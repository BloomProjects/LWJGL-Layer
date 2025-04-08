/*
 * Copyright (c) 2002-2008 LWJGL Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'LWJGL' nor the names of
 *   its contributors may be used to endorse or promote products derived
 *   from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.lwjgl.opengl;

public class Sync {
    /**
     * number of nanoseconds in a second
     */
    private static final long NANOS_IN_SECOND = 1000L * 1000L * 1000L;
    /**
     * for calculating the averages the previous sleep/yield times are stored
     */
    private static final RunningAvg sleepDurations = new RunningAvg(10);
    private static final RunningAvg yieldDurations = new RunningAvg(10);
    /**
     * The time to sleep/yield until the next frame
     */
    private static long nextFrame = 0;
    /**
     * whether the initialisation code has run
     */
    private static boolean initialised = false;

    /**
     * An accurate sync method that will attempt to run at a constant frame rate.
     * It should be called once every frame.
     *
     * @param fps - the desired frame rate, in frames per second
     */
    public static void sync(int fps) {
        if (fps <= 0) return;
        if (!initialised) initialise();

        try {
            // sleep until the average sleep time is greater than the time remaining till nextFrame
            for (long t0 = getTime(), t1; (nextFrame - t0) > sleepDurations.avg(); t0 = t1) {
                Thread.sleep(1);
                sleepDurations.add((t1 = getTime()) - t0); // update average sleep time
            }

            // slowly dampen sleep average if too high to avoid yielding too much
            sleepDurations.dampenForLowResTicker();

            // yield until the average yield time is greater than the time remaining till nextFrame
            for (long t0 = getTime(), t1; (nextFrame - t0) > yieldDurations.avg(); t0 = t1) {
                Thread.yield();
                yieldDurations.add((t1 = getTime()) - t0); // update average yield time
            }
        } catch (InterruptedException ignored) {
        }

        // schedule next frame, drop frame(s) if already too late for next frame
        nextFrame = Math.max(nextFrame + NANOS_IN_SECOND / fps, getTime());
    }

    /**
     * This method will initialise the sync method by setting initial
     * values for sleepDurations/yieldDurations and nextFrame.
     * If running on windows it will start the sleep timer fix.
     */
    private static void initialise() {
        initialised = true;

        sleepDurations.init(1000 * 1000);
        yieldDurations.init((int) (-(getTime() - getTime()) * 1.333));

        nextFrame = getTime();

        String osName = System.getProperty("os.name");

        if (osName.startsWith("Win")) {
            // On windows the sleep functions can be highly inaccurate by
            // over 10ms making in unusable. However, it can be forced to
            // be a bit more accurate by running a separate sleeping daemon
            // thread.
            Thread timerAccuracyThread = new Thread(() -> {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (Exception ignored) {
                }
            });

            timerAccuracyThread.setName("LWJGL Timer");
            timerAccuracyThread.setDaemon(true);
            timerAccuracyThread.start();
        }
    }

    /**
     * Get the system time in nanoseconds
     *
     * @return will return the current time in nano's
     */
    private static long getTime() {
        return System.nanoTime();
    }

    private static class RunningAvg {
        private static final long DAMPEN_THRESHOLD = 10 * 1000L * 1000L; // 10ms
        private static final float DAMPEN_FACTOR = 0.9f; // don't change: 0.9f is exactly right!
        private final long[] slots;
        private int offset;

        public RunningAvg(int slotCount) {
            this.slots = new long[slotCount];
            this.offset = 0;
        }

        public void init(long value) {
            while (this.offset < this.slots.length) {
                this.slots[this.offset++] = value;
            }
        }

        public void add(long value) {
            this.slots[this.offset++ % this.slots.length] = value;
            this.offset %= this.slots.length;
        }

        public long avg() {
            long sum = 0;
            for (long slot : this.slots) {
                sum += slot;
            }
            return sum / this.slots.length;
        }

        public void dampenForLowResTicker() {
            if (this.avg() > DAMPEN_THRESHOLD) {
                for (int i = 0; i < this.slots.length; i++) {
                    this.slots[i] *= (long) DAMPEN_FACTOR;
                }
            }
        }
    }

}