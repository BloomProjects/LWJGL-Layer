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
package org.lwjgl.input;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.fusion.LWJGLImplementationUtils;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.InputImplementation;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/**
 * A raw Keyboard interface. This can be used to poll the current state of the
 * keys, or read all the keyboard presses / releases since the last read.
 *
 * @author cix_foo <cix_foo@users.sourceforge.net>
 * @author elias_naur <elias_naur@users.sourceforge.net>
 * @author Brian Matzon <brian@matzon.dk>
 */
public class Keyboard {
    /**
     * Internal use - event size in bytes
     */
    public static final int EVENT_SIZE = 4 + 1 + 4 + 8 + 1;
    public static final int KEYBOARD_SIZE = GLFW.GLFW_KEY_LAST + 1;
    public static final int CHAR_NONE = '\0';
    /**
     * Buffer size in events
     */
    private static final int BUFFER_SIZE = 50;
    /**
     * The keys' status from the last poll
     */
    private static final ByteBuffer keyDownBuffer = BufferUtils.createByteBuffer(KEYBOARD_SIZE);
    /**
     * current event
     */
    private static final KeyEvent current_event = new KeyEvent();
    /**
     * scratch event
     */
    private static final KeyEvent tmp_event = new KeyEvent();
    public static final String[] keyNames = new String[KEYBOARD_SIZE];
    private static final Map<String, Integer> keyMap = new HashMap<>(253);

    /**
     * Key defines
     */
    public static final int KEY_NONE = 0x00;
    public static final int KEY_SPACE = 57;
    public static final int KEY_APOSTROPHE = 40;
    public static final int KEY_COMMA = 51;
    public static final int KEY_MINUS = 12;
    public static final int KEY_PERIOD = 52;
    public static final int KEY_SLASH = 53;
    public static final int KEY_0 = 11;
    public static final int KEY_1 = 2;
    public static final int KEY_2 = 3;
    public static final int KEY_3 = 4;
    public static final int KEY_4 = 5;
    public static final int KEY_5 = 6;
    public static final int KEY_6 = 7;
    public static final int KEY_7 = 8;
    public static final int KEY_8 = 9;
    public static final int KEY_9 = 10;
    public static final int KEY_SEMICOLON = 39;
    public static final int KEY_EQUALS = 13;
    public static final int KEY_A = 30;
    public static final int KEY_B = 48;
    public static final int KEY_C = 46;
    public static final int KEY_D = 32;
    public static final int KEY_E = 18;
    public static final int KEY_F = 33;
    public static final int KEY_G = 34;
    public static final int KEY_H = 35;
    public static final int KEY_I = 23;
    public static final int KEY_J = 36;
    public static final int KEY_K = 37;
    public static final int KEY_L = 38;
    public static final int KEY_M = 50;
    public static final int KEY_N = 49;
    public static final int KEY_O = 24;
    public static final int KEY_P = 25;
    public static final int KEY_Q = 16;
    public static final int KEY_R = 19;
    public static final int KEY_S = 31;
    public static final int KEY_T = 20;
    public static final int KEY_U = 22;
    public static final int KEY_V = 47;
    public static final int KEY_W = 17;
    public static final int KEY_X = 45;
    public static final int KEY_Y = 21;
    public static final int KEY_Z = 44;
    public static final int KEY_LBRACKET = 26;
    public static final int KEY_BACKSLASH = 43;
    public static final int KEY_RBRACKET = 27;
    public static final int KEY_GRAVE = 41;
    public static final int KEY_WORLD_1 = 161;
    public static final int KEY_WORLD_2 = 162;
    public static final int KEY_ESCAPE = 1;
    public static final int KEY_RETURN = 28;
    public static final int KEY_TAB = 15;
    public static final int KEY_BACK = 14;
    public static final int KEY_INSERT = 210;
    public static final int KEY_DELETE = 211;
    public static final int KEY_RIGHT = 205;
    public static final int KEY_LEFT = 203;
    public static final int KEY_DOWN = 208;
    public static final int KEY_UP = 200;
    public static final int KEY_PRIOR = 201;
    public static final int KEY_NEXT = 209;
    public static final int KEY_HOME = 199;
    public static final int KEY_END = 207;
    public static final int KEY_CAPITAL = 58;
    public static final int KEY_SCROLL = 70;
    public static final int KEY_NUMLOCK = 69;
    public static final int KEY_PRINT_SCREEN = 28;
    public static final int KEY_PAUSE = 197;
    public static final int KEY_F1 = 59;
    public static final int KEY_F2 = 60;
    public static final int KEY_F3 = 61;
    public static final int KEY_F4 = 62;
    public static final int KEY_F5 = 63;
    public static final int KEY_F6 = 64;
    public static final int KEY_F7 = 65;
    public static final int KEY_F8 = 66;
    public static final int KEY_F9 = 67;
    public static final int KEY_F10 = 68;
    public static final int KEY_F11 = 87;
    public static final int KEY_F12 = 88;
    public static final int KEY_F13 = 100;
    public static final int KEY_F14 = 101;
    public static final int KEY_F15 = 102;
    public static final int KEY_F16 = 103;
    public static final int KEY_F17 = 104;
    public static final int KEY_F18 = 105;
    public static final int KEY_F19 = 113;
    public static final int KEY_F20 = 309;
    public static final int KEY_F21 = 310;
    public static final int KEY_F22 = 311;
    public static final int KEY_F23 = 312;
    public static final int KEY_F24 = 313;
    public static final int KEY_F25 = 314;
    public static final int KEY_NUMPAD0 = 82;
    public static final int KEY_NUMPAD1 = 79;
    public static final int KEY_NUMPAD2 = 80;
    public static final int KEY_NUMPAD3 = 81;
    public static final int KEY_NUMPAD4 = 75;
    public static final int KEY_NUMPAD5 = 76;
    public static final int KEY_NUMPAD6 = 77;
    public static final int KEY_NUMPAD7 = 71;
    public static final int KEY_NUMPAD8 = 72;
    public static final int KEY_NUMPAD9 = 73;
    public static final int KEY_DECIMAL = 83;
    public static final int KEY_DIVIDE = 181;
    public static final int KEY_MULTIPLY = 55;
    public static final int KEY_SUBTRACT = 74;
    public static final int KEY_ADD = 78;
    public static final int KEY_NUMPADENTER = 156;
    public static final int KEY_NUMPADEQUALS = 141;
    public static final int KEY_LSHIFT = 42;
    public static final int KEY_LCONTROL = 29;
    public static final int KEY_LMENU = 56;
    public static final int KEY_LMETA = 219;
    public static final int KEY_RSHIFT = 54;
    public static final int KEY_RCONTROL = 157;
    public static final int KEY_RMENU = 184;
    public static final int KEY_RMETA = 220;
    public static final int KEY_MENU = 348;

    /**
     * Has the keyboard been created?
     */
    private static boolean created;
    /**
     * Are repeat events enabled?
     */
    private static boolean repeat_enabled;
    /**
     * The key events from the last read: a sequence of pairs of key number,
     * followed by state. The state is followed by
     * a 4 byte code point representing the translated character.
     */
    private static ByteBuffer readBuffer;
    /**
     * One time initialization
     */
    private static boolean initialized;
    private static InputImplementation implementation;
    /**
     * Keyboard cannot be constructed.
     */
    private Keyboard() {
    }

    /**
     * Static initialization
     */
    private static void initialize() {
        if (initialized)
            return;
        Sys.initialize();
        initialized = true;
    }

    /**
     * "Create" the keyboard with the given implementation. This is used
     * reflectively from AWTInputAdapter.
     */
    private static void create(InputImplementation impl) throws LWJGLException {
        if (created)
            return;
        if (!initialized)
            initialize();
        implementation = impl;
        implementation.createKeyboard();
        created = true;
        readBuffer = ByteBuffer.allocate(EVENT_SIZE * BUFFER_SIZE);
        reset();
    }

    /**
     * "Create" the keyboard. The display must first have been created. The
     * reason for this is so the keyboard has a window to "focus" in.
     *
     * @throws LWJGLException if the keyboard could not be created for any reason
     */
    public static void create() throws LWJGLException {
        if (!Display.isCreated()) throw new IllegalStateException("Display must be created.");

        create(LWJGLImplementationUtils.getOrCreateInputImplementation());
    }

    private static void reset() {
        readBuffer.limit(0);
        for (int i = 0; i < keyDownBuffer.remaining(); i++)
            keyDownBuffer.put(i, (byte) 0);
        current_event.reset();
    }

    /**
     * @return true if the keyboard has been created
     */
    public static boolean isCreated() {
//        synchronized (OpenGLPackageAccess.global_lock) {
        return created;
//        }
    }

    /**
     * "Destroy" the keyboard
     */
    public static void destroy() {
//        synchronized (OpenGLPackageAccess.global_lock) {
        if (!created)
            return;
        created = false;
        implementation.destroyKeyboard();
        reset();
//        }
    }

    /**
     * Polls the keyboard for its current state. Access the polled values using the
     * <code>isKeyDown</code> method.
     * By using this method, it is possible to "miss" keyboard keys if you don't
     * poll fast enough.
     * To use buffered values, you have to call <code>next</code> for each event you
     * want to read. You can query which key caused the event by using
     * <code>getEventKey</code>. To get the state of that key, for that event, use
     * <code>getEventKeyState</code> - finally use <code>getEventCharacter</code> to get the
     * character for that event.
     * NOTE: This method does not query the operating system for new events. To do that,
     * Display.processMessages() (or Display.update()) must be called first.
     *
     * @see org.lwjgl.input.Keyboard#isKeyDown(int key)
     * @see org.lwjgl.input.Keyboard#next()
     * @see org.lwjgl.input.Keyboard#getEventKey()
     * @see org.lwjgl.input.Keyboard#getEventKeyState()
     * @see org.lwjgl.input.Keyboard#getEventCharacter()
     */
    public static void poll() {
//        synchronized (OpenGLPackageAccess.global_lock) {
        if (!created)
            throw new IllegalStateException("Keyboard must be created before you can poll the device");
        implementation.pollKeyboard(keyDownBuffer);
        read();
//        }
    }

    private static void read() {
        readBuffer.compact();
        implementation.readKeyboard(readBuffer);
        readBuffer.flip();
    }

    /**
     * Checks to see if a key is down.
     *
     * @param key Keycode to check
     * @return true if the key is down according to the last poll()
     */
    public static boolean isKeyDown(int key) {
        if (!created)
            throw new IllegalStateException("Keyboard must be created before you can query key state");
        return keyDownBuffer.get(key) != 0;
    }

    /**
     * Gets a key's name
     *
     * @param key The key
     * @return a String with the key's human-readable name in it or null if the key is unnamed
     */
    public static synchronized String getKeyName(int key) {
        return keyNames[key];
    }

    /**
     * Gets a key's index. If the key is unrecognised then KEY_NONE is returned.
     *
     * @param keyName The key name
     */
    public static synchronized int getKeyIndex(String keyName) {
        return keyMap.getOrDefault(keyName, KEY_NONE);
    }

    /**
     * Gets the number of keyboard events waiting after doing a buffer enabled poll().
     *
     * @return the number of keyboard events
     */
    public static int getNumKeyboardEvents() {
        if (!created)
            throw new IllegalStateException("Keyboard must be created before you can read events");
        int old_position = readBuffer.position();
        int num_events = 0;
        while (readNext(tmp_event) && (!tmp_event.repeat || repeat_enabled))
            num_events++;
        readBuffer.position(old_position);
        return num_events;
    }

    /**
     * Gets the next keyboard event. You can query which key caused the event by using
     * <code>getEventKey</code>. To get the state of that key, for that event, use
     * <code>getEventKeyState</code> - finally use <code>getEventCharacter</code> to get the
     * character for that event.
     *
     * @return true if a keyboard event was read, false otherwise
     * @see org.lwjgl.input.Keyboard#getEventKey()
     * @see org.lwjgl.input.Keyboard#getEventKeyState()
     * @see org.lwjgl.input.Keyboard#getEventCharacter()
     */
    public static boolean next() {
        if (!created)
            throw new IllegalStateException("Keyboard must be created before you can read events");

        boolean result;
        while ((result = readNext(current_event)) && current_event.repeat && !repeat_enabled)
            ;
        return result;
    }

    /**
     * Controls whether repeat events are reported or not. If repeat events
     * are enabled, key down events are reported when a key is pressed and held for
     * an OS dependent amount of time. To distinguish a repeat event from a normal event,
     * use isRepeatEvent().
     *
     * @see org.lwjgl.input.Keyboard#getEventKey()
     */
    public static void enableRepeatEvents(boolean enable) {
//        synchronized (OpenGLPackageAccess.global_lock) {
        repeat_enabled = enable;
//        }
    }

    /**
     * Check whether repeat events are currently reported or not.
     *
     * @return true is repeat events are reported, false if not.
     * @see org.lwjgl.input.Keyboard#getEventKey()
     */
    public static boolean areRepeatEventsEnabled() {
//        synchronized (OpenGLPackageAccess.global_lock) {
        return repeat_enabled;
//        }
    }

    private static boolean readNext(KeyEvent event) {
        if (readBuffer.hasRemaining()) {
            event.key = readBuffer.getInt()/* & 0xFF */;
            event.state = readBuffer.get() != 0;
            event.character = readBuffer.getInt();
            event.nanos = readBuffer.getLong();
            event.repeat = readBuffer.get() == 1;
            return true;
        } else
            return false;
    }

    /**
     * @return Number of keys on this keyboard
     */
    public static int getKeyCount() {
        return keyMap.size();
    }

    /**
     * @return The character from the current event
     */
    public static char getEventCharacter() {
//        synchronized (OpenGLPackageAccess.global_lock) {
        return (char) current_event.character;
//        }
    }

    /**
     * Please note that the key code returned is NOT valid against the
     * current keyboard layout. To get the actual character pressed call
     * getEventCharacter
     *
     * @return The key from the current event
     */
    public static int getEventKey() {
//        synchronized (OpenGLPackageAccess.global_lock) {
        return current_event.key;
//        }
    }

    /**
     * Gets the state of the key that generated the
     * current event
     *
     * @return True if key was down, or false if released
     */
    public static boolean getEventKeyState() {
//        synchronized (OpenGLPackageAccess.global_lock) {
        return current_event.state;
//        }
    }

    /**
     * Gets the time in nanoseconds of the current event.
     * Only useful for relative comparisons with other
     * Keyboard events, as the absolute time has no defined
     * origin.
     *
     * @return The time in nanoseconds of the current event
     */
    public static long getEventNanoseconds() {
//        synchronized (OpenGLPackageAccess.global_lock) {
        return current_event.nanos;
//        }
    }

    /**
     * @return true if the current event is a repeat event, false if
     * the current event is not a repeat even or if repeat events are disabled.
     * @see org.lwjgl.input.Keyboard#enableRepeatEvents(boolean)
     */
    public static boolean isRepeatEvent() {
//        synchronized (OpenGLPackageAccess.global_lock) {
        return current_event.repeat;
//        }
    }

    private static void register(String name, int lwjglCode) {
        keyNames[lwjglCode] = name;
        keyMap.put(name, lwjglCode);
    }

    private static final class KeyEvent {
        /**
         * The current keyboard character being examined
         */
        private int character;

        /**
         * The current keyboard event key being examined
         */
        private int key;

        /**
         * The current state of the key being examined in the event queue
         */
        private boolean state;

        /**
         * The current event time
         */
        private long nanos;

        /**
         * Is the current event a repeated event?
         */
        private boolean repeat;

        private void reset() {
            character = 0;
            key = 0;
            state = false;
            repeat = false;
        }
    }

    static {
        register("NONE", KEY_NONE);
        register("SPACE", KEY_SPACE);
        register("APOSTROPHE", KEY_APOSTROPHE);
        register("COMMA", KEY_COMMA);
        register("MINUS", KEY_MINUS);
        register("PERIOD", KEY_PERIOD);
        register("SLASH", KEY_SLASH);
        register("0", KEY_0);
        register("1", KEY_1);
        register("2", KEY_2);
        register("3", KEY_3);
        register("4", KEY_4);
        register("5", KEY_5);
        register("6", KEY_6);
        register("7", KEY_7);
        register("8", KEY_8);
        register("9", KEY_9);
        register("SEMICOLON", KEY_SEMICOLON);
        register("EQUALS", KEY_EQUALS);
        register("A", KEY_A);
        register("B", KEY_B);
        register("C", KEY_C);
        register("D", KEY_D);
        register("E", KEY_E);
        register("F", KEY_F);
        register("G", KEY_G);
        register("H", KEY_H);
        register("I", KEY_I);
        register("J", KEY_J);
        register("K", KEY_K);
        register("L", KEY_L);
        register("M", KEY_M);
        register("N", KEY_N);
        register("O", KEY_O);
        register("P", KEY_P);
        register("Q", KEY_Q);
        register("R", KEY_R);
        register("S", KEY_S);
        register("T", KEY_T);
        register("U", KEY_U);
        register("V", KEY_V);
        register("W", KEY_W);
        register("X", KEY_X);
        register("Y", KEY_Y);
        register("Z", KEY_Z);
        register("LBRACKET", KEY_LBRACKET);
        register("BACKSLASH", KEY_BACKSLASH);
        register("RBRACKET", KEY_RBRACKET);
        register("GRAVE", KEY_GRAVE);
        register("WORLD_1", KEY_WORLD_1);
        register("WORLD_2", KEY_WORLD_2);
        register("ESCAPE", KEY_ESCAPE);
        register("RETURN", KEY_RETURN);
        register("TAB", KEY_TAB);
        register("BACK", KEY_BACK);
        register("INSERT", KEY_INSERT);
        register("DELETE", KEY_DELETE);
        register("RIGHT", KEY_RIGHT);
        register("LEFT", KEY_LEFT);
        register("DOWN", KEY_DOWN);
        register("UP", KEY_UP);
        register("PRIOR", KEY_PRIOR);
        register("NEXT", KEY_NEXT);
        register("HOME", KEY_HOME);
        register("END", KEY_END);
        register("CAPITAL", KEY_CAPITAL);
        register("SCROLL", KEY_SCROLL);
        register("NUMLOCK", KEY_NUMLOCK);
        register("PRINT_SCREEN", KEY_PRINT_SCREEN);
        register("PAUSE", KEY_PAUSE);
        register("F1", KEY_F1);
        register("F2", KEY_F2);
        register("F3", KEY_F3);
        register("F4", KEY_F4);
        register("F5", KEY_F5);
        register("F6", KEY_F6);
        register("F7", KEY_F7);
        register("F8", KEY_F8);
        register("F9", KEY_F9);
        register("F10", KEY_F10);
        register("F11", KEY_F11);
        register("F12", KEY_F12);
        register("F13", KEY_F13);
        register("F14", KEY_F14);
        register("F15", KEY_F15);
        register("F16", KEY_F16);
        register("F17", KEY_F17);
        register("F18", KEY_F18);
        register("F19", KEY_F19);
        register("F20", KEY_F20);
        register("F21", KEY_F21);
        register("F22", KEY_F22);
        register("F23", KEY_F23);
        register("F24", KEY_F24);
        register("F25", KEY_F25);
        register("NUMPAD0", KEY_NUMPAD0);
        register("NUMPAD1", KEY_NUMPAD1);
        register("NUMPAD2", KEY_NUMPAD2);
        register("NUMPAD3", KEY_NUMPAD3);
        register("NUMPAD4", KEY_NUMPAD4);
        register("NUMPAD5", KEY_NUMPAD5);
        register("NUMPAD6", KEY_NUMPAD6);
        register("NUMPAD7", KEY_NUMPAD7);
        register("NUMPAD8", KEY_NUMPAD8);
        register("NUMPAD9", KEY_NUMPAD9);
        register("DECIMAL", KEY_DECIMAL);
        register("DIVIDE", KEY_DIVIDE);
        register("MULTIPLY", KEY_MULTIPLY);
        register("SUBTRACT", KEY_SUBTRACT);
        register("ADD", KEY_ADD);
        register("NUMPADENTER", KEY_NUMPADENTER);
        register("NUMPADEQUALS", KEY_NUMPADEQUALS);
        register("LSHIFT", KEY_LSHIFT);
        register("LCONTROL", KEY_LCONTROL);
        register("LMENU", KEY_LMENU);
        register("LMETA", KEY_LMETA);
        register("RSHIFT", KEY_RSHIFT);
        register("RCONTROL", KEY_RCONTROL);
        register("RMENU", KEY_RMENU);
        register("RMETA", KEY_RMETA);
        register("MENU", KEY_MENU);
    }

}
