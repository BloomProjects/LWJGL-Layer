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

import org.lwjgl.LWJGLException;
import org.lwjgl.LWJGLUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL30.GL_NUM_EXTENSIONS;
import static org.lwjgl.opengl.GL30.glGetStringi;
import static org.lwjgl.opengl.GL32.GL_CONTEXT_PROFILE_MASK;

/**
 * Created by gudenau on 5/30/2017.
 * <p>
 * LWJGL3
 */
public class ContextCapabilities {
    static final boolean DEBUG = false;
    //TODO?
    //final StateTracker tracker = new StateTracker();

    public boolean GL_AMD_blend_minmax_factor = false;
    public boolean GL_AMD_conservative_depth = false;
    public boolean GL_AMD_debug_output = false;
    public boolean GL_AMD_depth_clamp_separate = false;
    public boolean GL_AMD_draw_buffers_blend = false;
    public boolean GL_AMD_interleaved_elements = false;
    public boolean GL_AMD_multi_draw_indirect = false;
    public boolean GL_AMD_name_gen_delete = false;
    public boolean GL_AMD_performance_monitor = false;
    public boolean GL_AMD_pinned_memory = false;
    public boolean GL_AMD_query_buffer_object = false;
    public boolean GL_AMD_sample_positions = false;
    public boolean GL_AMD_seamless_cubemap_per_texture = false;
    public boolean GL_AMD_shader_atomic_counter_ops = false;
    public boolean GL_AMD_shader_stencil_export = false;
    public boolean GL_AMD_shader_trinary_minmax = false;
    public boolean GL_AMD_sparse_texture = false;
    public boolean GL_AMD_stencil_operation_extended = false;
    public boolean GL_AMD_texture_texture4 = false;
    public boolean GL_AMD_transform_feedback3_lines_triangles = false;
    public boolean GL_AMD_vertex_shader_layer = false;
    public boolean GL_AMD_vertex_shader_tessellator = false;
    public boolean GL_AMD_vertex_shader_viewport_index = false;
    public boolean GL_APPLE_aux_depth_stencil = false;
    public boolean GL_APPLE_client_storage = false;
    public boolean GL_APPLE_element_array = false;
    public boolean GL_APPLE_fence = false;
    public boolean GL_APPLE_float_pixels = false;
    public boolean GL_APPLE_flush_buffer_range = false;
    public boolean GL_APPLE_object_purgeable = false;
    public boolean GL_APPLE_packed_pixels = false;
    public boolean GL_APPLE_rgb_422 = false;
    public boolean GL_APPLE_row_bytes = false;
    public boolean GL_APPLE_texture_range = false;
    public boolean GL_APPLE_vertex_array_object = false;
    public boolean GL_APPLE_vertex_array_range = false;
    public boolean GL_APPLE_vertex_program_evaluators = false;
    public boolean GL_APPLE_ycbcr_422 = false;
    public boolean GL_ARB_ES2_compatibility = false;
    public boolean GL_ARB_ES3_1_compatibility = false;
    public boolean GL_ARB_ES3_compatibility = false;
    public boolean GL_ARB_arrays_of_arrays = false;
    public boolean GL_ARB_base_instance = false;
    public boolean GL_ARB_bindless_texture = false;
    public boolean GL_ARB_blend_func_extended = false;
    public boolean GL_ARB_buffer_storage = false;
    public boolean GL_ARB_cl_event = false;
    public boolean GL_ARB_clear_buffer_object = false;
    public boolean GL_ARB_clear_texture = false;
    public boolean GL_ARB_clip_control = false;
    public boolean GL_ARB_color_buffer_float = false;
    public boolean GL_ARB_compatibility = false;
    public boolean GL_ARB_compressed_texture_pixel_storage = false;
    public boolean GL_ARB_compute_shader = false;
    public boolean GL_ARB_compute_variable_group_size = false;
    public boolean GL_ARB_conditional_render_inverted = false;
    public boolean GL_ARB_conservative_depth = false;
    public boolean GL_ARB_copy_buffer = false;
    public boolean GL_ARB_copy_image = false;
    public boolean GL_ARB_cull_distance = false;
    public boolean GL_ARB_debug_output = false;
    public boolean GL_ARB_depth_buffer_float = false;
    public boolean GL_ARB_depth_clamp = false;
    public boolean GL_ARB_depth_texture = false;
    public boolean GL_ARB_derivative_control = false;
    public boolean GL_ARB_direct_state_access = false;
    public boolean GL_ARB_draw_buffers = false;
    public boolean GL_ARB_draw_buffers_blend = false;
    public boolean GL_ARB_draw_elements_base_vertex = false;
    public boolean GL_ARB_draw_indirect = false;
    public boolean GL_ARB_draw_instanced = false;
    public boolean GL_ARB_enhanced_layouts = false;
    public boolean GL_ARB_explicit_attrib_location = false;
    public boolean GL_ARB_explicit_uniform_location = false;
    public boolean GL_ARB_fragment_coord_conventions = false;
    public boolean GL_ARB_fragment_layer_viewport = false;
    public boolean GL_ARB_fragment_program = false;
    public boolean GL_ARB_fragment_program_shadow = false;
    public boolean GL_ARB_fragment_shader = false;
    public boolean GL_ARB_framebuffer_no_attachments = false;
    public boolean GL_ARB_framebuffer_object = false;
    public boolean GL_ARB_framebuffer_sRGB = false;
    public boolean GL_ARB_geometry_shader4 = false;
    public boolean GL_ARB_get_program_binary = false;
    public boolean GL_ARB_get_texture_sub_image = false;
    public boolean GL_ARB_gpu_shader5 = false;
    public boolean GL_ARB_gpu_shader_fp64 = false;
    public boolean GL_ARB_half_float_pixel = false;
    public boolean GL_ARB_half_float_vertex = false;
    public boolean GL_ARB_imaging = false;
    public boolean GL_ARB_indirect_parameters = false;
    public boolean GL_ARB_instanced_arrays = false;
    public boolean GL_ARB_internalformat_query = false;
    public boolean GL_ARB_internalformat_query2 = false;
    public boolean GL_ARB_invalidate_subdata = false;
    public boolean GL_ARB_map_buffer_alignment = false;
    public boolean GL_ARB_map_buffer_range = false;
    public boolean GL_ARB_matrix_palette = false;
    public boolean GL_ARB_multi_bind = false;
    public boolean GL_ARB_multi_draw_indirect = false;
    public boolean GL_ARB_multisample = false;
    public boolean GL_ARB_multitexture = false;
    public boolean GL_ARB_occlusion_query = false;
    public boolean GL_ARB_occlusion_query2 = false;
    public boolean GL_ARB_pipeline_statistics_query = false;
    public boolean GL_ARB_pixel_buffer_object = false;
    public boolean GL_ARB_point_parameters = false;
    public boolean GL_ARB_point_sprite = false;
    public boolean GL_ARB_program_interface_query = false;
    public boolean GL_ARB_provoking_vertex = false;
    public boolean GL_ARB_query_buffer_object = false;
    public boolean GL_ARB_robust_buffer_access_behavior = false;
    public boolean GL_ARB_robustness = false;
    public boolean GL_ARB_robustness_isolation = false;
    public boolean GL_ARB_sample_shading = false;
    public boolean GL_ARB_sampler_objects = false;
    public boolean GL_ARB_seamless_cube_map = false;
    public boolean GL_ARB_seamless_cubemap_per_texture = false;
    public boolean GL_ARB_separate_shader_objects = false;
    public boolean GL_ARB_shader_atomic_counters = false;
    public boolean GL_ARB_shader_bit_encoding = false;
    public boolean GL_ARB_shader_draw_parameters = false;
    public boolean GL_ARB_shader_group_vote = false;
    public boolean GL_ARB_shader_image_load_store = false;
    public boolean GL_ARB_shader_image_size = false;
    public boolean GL_ARB_shader_objects = false;
    public boolean GL_ARB_shader_precision = false;
    public boolean GL_ARB_shader_stencil_export = false;
    public boolean GL_ARB_shader_storage_buffer_object = false;
    public boolean GL_ARB_shader_subroutine = false;
    public boolean GL_ARB_shader_texture_image_samples = false;
    public boolean GL_ARB_shader_texture_lod = false;
    public boolean GL_ARB_shading_language_100 = false;
    public boolean GL_ARB_shading_language_420pack = false;
    public boolean GL_ARB_shading_language_include = false;
    public boolean GL_ARB_shading_language_packing = false;
    public boolean GL_ARB_shadow = false;
    public boolean GL_ARB_shadow_ambient = false;
    public boolean GL_ARB_sparse_buffer = false;
    public boolean GL_ARB_sparse_texture = false;
    public boolean GL_ARB_stencil_texturing = false;
    public boolean GL_ARB_sync = false;
    public boolean GL_ARB_tessellation_shader = false;
    public boolean GL_ARB_texture_barrier = false;
    public boolean GL_ARB_texture_border_clamp = false;
    public boolean GL_ARB_texture_buffer_object = false;
    public boolean GL_ARB_texture_buffer_object_rgb32 = false;
    public boolean GL_ARB_texture_buffer_range = false;
    public boolean GL_ARB_texture_compression = false;
    public boolean GL_ARB_texture_compression_bptc = false;
    public boolean GL_ARB_texture_compression_rgtc = false;
    public boolean GL_ARB_texture_cube_map = false;
    public boolean GL_ARB_texture_cube_map_array = false;
    public boolean GL_ARB_texture_env_add = false;
    public boolean GL_ARB_texture_env_combine = false;
    public boolean GL_ARB_texture_env_crossbar = false;
    public boolean GL_ARB_texture_env_dot3 = false;
    public boolean GL_ARB_texture_float = false;
    public boolean GL_ARB_texture_gather = false;
    public boolean GL_ARB_texture_mirror_clamp_to_edge = false;
    public boolean GL_ARB_texture_mirrored_repeat = false;
    public boolean GL_ARB_texture_multisample = false;
    public boolean GL_ARB_texture_non_power_of_two = false;
    public boolean GL_ARB_texture_query_levels = false;
    public boolean GL_ARB_texture_query_lod = false;
    public boolean GL_ARB_texture_rectangle = false;
    public boolean GL_ARB_texture_rg = false;
    public boolean GL_ARB_texture_rgb10_a2ui = false;
    public boolean GL_ARB_texture_stencil8 = false;
    public boolean GL_ARB_texture_storage = false;
    public boolean GL_ARB_texture_storage_multisample = false;
    public boolean GL_ARB_texture_swizzle = false;
    public boolean GL_ARB_texture_view = false;
    public boolean GL_ARB_timer_query = false;
    public boolean GL_ARB_transform_feedback2 = false;
    public boolean GL_ARB_transform_feedback3 = false;
    public boolean GL_ARB_transform_feedback_instanced = false;
    public boolean GL_ARB_transform_feedback_overflow_query = false;
    public boolean GL_ARB_transpose_matrix = false;
    public boolean GL_ARB_uniform_buffer_object = false;
    public boolean GL_ARB_vertex_array_bgra = false;
    public boolean GL_ARB_vertex_array_object = false;
    public boolean GL_ARB_vertex_attrib_64bit = false;
    public boolean GL_ARB_vertex_attrib_binding = false;
    public boolean GL_ARB_vertex_blend = false;
    public boolean GL_ARB_vertex_buffer_object = false;
    public boolean GL_ARB_vertex_program = false;
    public boolean GL_ARB_vertex_shader = false;
    public boolean GL_ARB_vertex_type_10f_11f_11f_rev = false;
    public boolean GL_ARB_vertex_type_2_10_10_10_rev = false;
    public boolean GL_ARB_viewport_array = false;
    public boolean GL_ARB_window_pos = false;
    public boolean GL_ATI_draw_buffers = false;
    public boolean GL_ATI_element_array = false;
    public boolean GL_ATI_envmap_bumpmap = false;
    public boolean GL_ATI_fragment_shader = false;
    public boolean GL_ATI_map_object_buffer = false;
    public boolean GL_ATI_meminfo = false;
    public boolean GL_ATI_pn_triangles = false;
    public boolean GL_ATI_separate_stencil = false;
    public boolean GL_ATI_shader_texture_lod = false;
    public boolean GL_ATI_text_fragment_shader = false;
    public boolean GL_ATI_texture_compression_3dc = false;
    public boolean GL_ATI_texture_env_combine3 = false;
    public boolean GL_ATI_texture_float = false;
    public boolean GL_ATI_texture_mirror_once = false;
    public boolean GL_ATI_vertex_array_object = false;
    public boolean GL_ATI_vertex_attrib_array_object = false;
    public boolean GL_ATI_vertex_streams = false;
    public boolean GL_EXT_Cg_shader = false;
    public boolean GL_EXT_abgr = false;
    public boolean GL_EXT_bgra = false;
    public boolean GL_EXT_bindable_uniform = false;
    public boolean GL_EXT_blend_color = false;
    public boolean GL_EXT_blend_equation_separate = false;
    public boolean GL_EXT_blend_func_separate = false;
    public boolean GL_EXT_blend_minmax = false;
    public boolean GL_EXT_blend_subtract = false;
    public boolean GL_EXT_compiled_vertex_array = false;
    public boolean GL_EXT_depth_bounds_test = false;
    public boolean GL_EXT_direct_state_access = false;
    public boolean GL_EXT_draw_buffers2 = false;
    public boolean GL_EXT_draw_instanced = false;
    public boolean GL_EXT_draw_range_elements = false;
    public boolean GL_EXT_fog_coord = false;
    public boolean GL_EXT_framebuffer_blit = false;
    public boolean GL_EXT_framebuffer_multisample = false;
    public boolean GL_EXT_framebuffer_multisample_blit_scaled = false;
    public boolean GL_EXT_framebuffer_object = false;
    public boolean GL_EXT_framebuffer_sRGB = false;
    public boolean GL_EXT_geometry_shader4 = false;
    public boolean GL_EXT_gpu_program_parameters = false;
    public boolean GL_EXT_gpu_shader4 = false;
    public boolean GL_EXT_multi_draw_arrays = false;
    public boolean GL_EXT_packed_depth_stencil = false;
    public boolean GL_EXT_packed_float = false;
    public boolean GL_EXT_packed_pixels = false;
    public boolean GL_EXT_paletted_texture = false;
    public boolean GL_EXT_pixel_buffer_object = false;
    public boolean GL_EXT_point_parameters = false;
    public boolean GL_EXT_provoking_vertex = false;
    public boolean GL_EXT_rescale_normal = false;
    public boolean GL_EXT_secondary_color = false;
    public boolean GL_EXT_separate_shader_objects = false;
    public boolean GL_EXT_separate_specular_color = false;
    public boolean GL_EXT_shader_image_load_store = false;
    public boolean GL_EXT_shadow_funcs = false;
    public boolean GL_EXT_shared_texture_palette = false;
    public boolean GL_EXT_stencil_clear_tag = false;
    public boolean GL_EXT_stencil_two_side = false;
    public boolean GL_EXT_stencil_wrap = false;
    public boolean GL_EXT_texture_3d = false;
    public boolean GL_EXT_texture_array = false;
    public boolean GL_EXT_texture_buffer_object = false;
    public boolean GL_EXT_texture_compression_latc = false;
    public boolean GL_EXT_texture_compression_rgtc = false;
    public boolean GL_EXT_texture_compression_s3tc = false;
    public boolean GL_EXT_texture_env_combine = false;
    public boolean GL_EXT_texture_env_dot3 = false;
    public boolean GL_EXT_texture_filter_anisotropic = false;
    public boolean GL_EXT_texture_integer = false;
    public boolean GL_EXT_texture_lod_bias = false;
    public boolean GL_EXT_texture_mirror_clamp = false;
    public boolean GL_EXT_texture_rectangle = false;
    public boolean GL_EXT_texture_sRGB = false;
    public boolean GL_EXT_texture_sRGB_decode = false;
    public boolean GL_EXT_texture_shared_exponent = false;
    public boolean GL_EXT_texture_snorm = false;
    public boolean GL_EXT_texture_swizzle = false;
    public boolean GL_EXT_timer_query = false;
    public boolean GL_EXT_transform_feedback = false;
    public boolean GL_EXT_vertex_array_bgra = false;
    public boolean GL_EXT_vertex_attrib_64bit = false;
    public boolean GL_EXT_vertex_shader = false;
    public boolean GL_EXT_vertex_weighting = false;
    public boolean OpenGL11 = false;
    public boolean OpenGL12 = false;
    public boolean OpenGL13 = false;
    public boolean OpenGL14 = false;
    public boolean OpenGL15 = false;
    public boolean OpenGL20 = false;
    public boolean OpenGL21 = false;
    public boolean OpenGL30 = false;
    public boolean OpenGL31 = false;
    public boolean OpenGL32 = false;
    public boolean OpenGL33 = false;
    public boolean OpenGL40 = false;
    public boolean OpenGL41 = false;
    public boolean OpenGL42 = false;
    public boolean OpenGL43 = false;
    public boolean OpenGL44 = false;
    public boolean OpenGL45 = false;
    public boolean GL_GREMEDY_frame_terminator = false;
    public boolean GL_GREMEDY_string_marker = false;
    public boolean GL_HP_occlusion_test = false;
    public boolean GL_IBM_rasterpos_clip = false;
    public boolean GL_INTEL_map_texture = false;
    public boolean GL_KHR_context_flush_control = false;
    public boolean GL_KHR_debug = false;
    public boolean GL_KHR_robust_buffer_access_behavior = false;
    public boolean GL_KHR_robustness = false;
    public boolean GL_KHR_texture_compression_astc_ldr = false;
    public boolean GL_NVX_gpu_memory_info = false;
    public boolean GL_NV_bindless_multi_draw_indirect = false;
    public boolean GL_NV_bindless_texture = false;
    public boolean GL_NV_blend_equation_advanced = false;
    public boolean GL_NV_blend_square = false;
    public boolean GL_NV_compute_program5 = false;
    public boolean GL_NV_conditional_render = false;
    public boolean GL_NV_copy_depth_to_color = false;
    public boolean GL_NV_copy_image = false;
    public boolean GL_NV_deep_texture3D = false;
    public boolean GL_NV_depth_buffer_float = false;
    public boolean GL_NV_depth_clamp = false;
    public boolean GL_NV_draw_texture = false;
    public boolean GL_NV_evaluators = false;
    public boolean GL_NV_explicit_multisample = false;
    public boolean GL_NV_fence = false;
    public boolean GL_NV_float_buffer = false;
    public boolean GL_NV_fog_distance = false;
    public boolean GL_NV_fragment_program = false;
    public boolean GL_NV_fragment_program2 = false;
    public boolean GL_NV_fragment_program4 = false;
    public boolean GL_NV_fragment_program_option = false;
    public boolean GL_NV_framebuffer_multisample_coverage = false;
    public boolean GL_NV_geometry_program4 = false;
    public boolean GL_NV_geometry_shader4 = false;
    public boolean GL_NV_gpu_program4 = false;
    public boolean GL_NV_gpu_program5 = false;
    public boolean GL_NV_gpu_program5_mem_extended = false;
    public boolean GL_NV_gpu_shader5 = false;
    public boolean GL_NV_half_float = false;
    public boolean GL_NV_light_max_exponent = false;
    public boolean GL_NV_multisample_coverage = false;
    public boolean GL_NV_multisample_filter_hint = false;
    public boolean GL_NV_occlusion_query = false;
    public boolean GL_NV_packed_depth_stencil = false;
    public boolean GL_NV_parameter_buffer_object = false;
    public boolean GL_NV_parameter_buffer_object2 = false;
    public boolean GL_NV_path_rendering = false;
    public boolean GL_NV_pixel_data_range = false;
    public boolean GL_NV_point_sprite = false;
    public boolean GL_NV_present_video = false;
    public boolean GL_NV_primitive_restart = false;
    public boolean GL_NV_register_combiners = false;
    public boolean GL_NV_register_combiners2 = false;
    public boolean GL_NV_shader_atomic_counters = false;
    public boolean GL_NV_shader_atomic_float = false;
    public boolean GL_NV_shader_buffer_load = false;
    public boolean GL_NV_shader_buffer_store = false;
    public boolean GL_NV_shader_storage_buffer_object = false;
    public boolean GL_NV_tessellation_program5 = false;
    public boolean GL_NV_texgen_reflection = false;
    public boolean GL_NV_texture_barrier = false;
    public boolean GL_NV_texture_compression_vtc = false;
    public boolean GL_NV_texture_env_combine4 = false;
    public boolean GL_NV_texture_expand_normal = false;
    public boolean GL_NV_texture_multisample = false;
    public boolean GL_NV_texture_rectangle = false;
    public boolean GL_NV_texture_shader = false;
    public boolean GL_NV_texture_shader2 = false;
    public boolean GL_NV_texture_shader3 = false;
    public boolean GL_NV_transform_feedback = false;
    public boolean GL_NV_transform_feedback2 = false;
    public boolean GL_NV_vertex_array_range = false;
    public boolean GL_NV_vertex_array_range2 = false;
    public boolean GL_NV_vertex_attrib_integer_64bit = false;
    public boolean GL_NV_vertex_buffer_unified_memory = false;
    public boolean GL_NV_vertex_program = false;
    public boolean GL_NV_vertex_program1_1 = false;
    public boolean GL_NV_vertex_program2 = false;
    public boolean GL_NV_vertex_program2_option = false;
    public boolean GL_NV_vertex_program3 = false;
    public boolean GL_NV_vertex_program4 = false;
    public boolean GL_NV_video_capture = false;
    public boolean GL_SGIS_generate_mipmap = false;
    public boolean GL_SGIS_texture_lod = false;
    public boolean GL_SUN_slice_accum = false;

    // AMD_debug_output
    long glDebugMessageEnableAMD;
    long glDebugMessageInsertAMD;
    long glDebugMessageCallbackAMD;
    long glGetDebugMessageLogAMD;
    // AMD_draw_buffers_blend
    long glBlendFuncIndexedAMD;
    long glBlendFuncSeparateIndexedAMD;
    long glBlendEquationIndexedAMD;
    long glBlendEquationSeparateIndexedAMD;
    // AMD_interleaved_elements
    long glVertexAttribParameteriAMD;
    // AMD_multi_draw_indirect
    long glMultiDrawArraysIndirectAMD;
    long glMultiDrawElementsIndirectAMD;
    // AMD_name_gen_delete
    long glGenNamesAMD;
    long glDeleteNamesAMD;
    long glIsNameAMD;
    // AMD_performance_monitor
    long glGetPerfMonitorGroupsAMD;
    long glGetPerfMonitorCountersAMD;
    long glGetPerfMonitorGroupStringAMD;
    long glGetPerfMonitorCounterStringAMD;
    long glGetPerfMonitorCounterInfoAMD;
    long glGenPerfMonitorsAMD;
    long glDeletePerfMonitorsAMD;
    long glSelectPerfMonitorCountersAMD;
    long glBeginPerfMonitorAMD;
    long glEndPerfMonitorAMD;
    long glGetPerfMonitorCounterDataAMD;
    // AMD_sample_positions
    long glSetMultisamplefvAMD;
    // AMD_sparse_texture
    long glTexStorageSparseAMD;
    long glTextureStorageSparseAMD;
    // AMD_stencil_operation_extended
    long glStencilOpValueAMD;
    // AMD_vertex_shader_tessellator
    long glTessellationFactorAMD;
    long glTessellationModeAMD;
    // APPLE_element_array
    long glElementPointerAPPLE;
    long glDrawElementArrayAPPLE;
    long glDrawRangeElementArrayAPPLE;
    long glMultiDrawElementArrayAPPLE;
    long glMultiDrawRangeElementArrayAPPLE;
    // APPLE_fence
    long glGenFencesAPPLE;
    long glDeleteFencesAPPLE;
    long glSetFenceAPPLE;
    long glIsFenceAPPLE;
    long glTestFenceAPPLE;
    long glFinishFenceAPPLE;
    long glTestObjectAPPLE;
    long glFinishObjectAPPLE;
    // APPLE_flush_buffer_range
    long glBufferParameteriAPPLE;
    long glFlushMappedBufferRangeAPPLE;
    // APPLE_object_purgeable
    long glObjectPurgeableAPPLE;
    long glObjectUnpurgeableAPPLE;
    long glGetObjectParameterivAPPLE;
    // APPLE_texture_range
    long glTextureRangeAPPLE;
    long glGetTexParameterPointervAPPLE;
    // APPLE_vertex_array_object
    long glBindVertexArrayAPPLE;
    long glDeleteVertexArraysAPPLE;
    long glGenVertexArraysAPPLE;
    long glIsVertexArrayAPPLE;
    // APPLE_vertex_array_range
    long glVertexArrayRangeAPPLE;
    long glFlushVertexArrayRangeAPPLE;
    long glVertexArrayParameteriAPPLE;
    // APPLE_vertex_program_evaluators
    long glEnableVertexAttribAPPLE;
    long glDisableVertexAttribAPPLE;
    long glIsVertexAttribEnabledAPPLE;
    long glMapVertexAttrib1dAPPLE;
    long glMapVertexAttrib1fAPPLE;
    long glMapVertexAttrib2dAPPLE;
    long glMapVertexAttrib2fAPPLE;
    // ARB_bindless_texture
    long glGetTextureHandleARB;
    long glGetTextureSamplerHandleARB;
    long glMakeTextureHandleResidentARB;
    long glMakeTextureHandleNonResidentARB;
    long glGetImageHandleARB;
    long glMakeImageHandleResidentARB;
    long glMakeImageHandleNonResidentARB;
    long glUniformHandleui64ARB;
    long glUniformHandleui64vARB;
    long glProgramUniformHandleui64ARB;
    long glProgramUniformHandleui64vARB;
    long glIsTextureHandleResidentARB;
    long glIsImageHandleResidentARB;
    long glVertexAttribL1ui64ARB;
    long glVertexAttribL1ui64vARB;
    long glGetVertexAttribLui64vARB;
    // ARB_buffer_object
    long glBindBufferARB;
    long glDeleteBuffersARB;
    long glGenBuffersARB;
    long glIsBufferARB;
    long glBufferDataARB;
    long glBufferSubDataARB;
    long glGetBufferSubDataARB;
    long glMapBufferARB;
    long glUnmapBufferARB;
    long glGetBufferParameterivARB;
    long glGetBufferPointervARB;
    // ARB_buffer_storage
    long glNamedBufferStorageEXT;
    // ARB_cl_event
    long glCreateSyncFromCLeventARB;
    // ARB_clear_buffer_object
    long glClearNamedBufferDataEXT;
    long glClearNamedBufferSubDataEXT;
    // ARB_color_buffer_float
    long glClampColorARB;
    // ARB_compute_variable_group_size
    long glDispatchComputeGroupSizeARB;
    // ARB_debug_output
    long glDebugMessageControlARB;
    long glDebugMessageInsertARB;
    long glDebugMessageCallbackARB;
    long glGetDebugMessageLogARB;
    // ARB_draw_buffers
    long glDrawBuffersARB;
    // ARB_draw_buffers_blend
    long glBlendEquationiARB;
    long glBlendEquationSeparateiARB;
    long glBlendFunciARB;
    long glBlendFuncSeparateiARB;
    // ARB_draw_instanced
    long glDrawArraysInstancedARB;
    long glDrawElementsInstancedARB;
    // ARB_framebuffer_no_attachments
    long glNamedFramebufferParameteriEXT;
    long glGetNamedFramebufferParameterivEXT;
    // ARB_geometry_shader4
    long glProgramParameteriARB;
    long glFramebufferTextureARB;
    long glFramebufferTextureLayerARB;
    long glFramebufferTextureFaceARB;
    // ARB_gpu_shader_fp64
    long glProgramUniform1dEXT;
    long glProgramUniform2dEXT;
    long glProgramUniform3dEXT;
    long glProgramUniform4dEXT;
    long glProgramUniform1dvEXT;
    long glProgramUniform2dvEXT;
    long glProgramUniform3dvEXT;
    long glProgramUniform4dvEXT;
    long glProgramUniformMatrix2dvEXT;
    long glProgramUniformMatrix3dvEXT;
    long glProgramUniformMatrix4dvEXT;
    long glProgramUniformMatrix2x3dvEXT;
    long glProgramUniformMatrix2x4dvEXT;
    long glProgramUniformMatrix3x2dvEXT;
    long glProgramUniformMatrix3x4dvEXT;
    long glProgramUniformMatrix4x2dvEXT;
    long glProgramUniformMatrix4x3dvEXT;
    // ARB_imaging
    long glColorTable;
    long glColorSubTable;
    long glColorTableParameteriv;
    long glColorTableParameterfv;
    long glCopyColorSubTable;
    long glCopyColorTable;
    long glGetColorTable;
    long glGetColorTableParameteriv;
    long glGetColorTableParameterfv;
    long glHistogram;
    long glResetHistogram;
    long glGetHistogram;
    long glGetHistogramParameterfv;
    long glGetHistogramParameteriv;
    long glMinmax;
    long glResetMinmax;
    long glGetMinmax;
    long glGetMinmaxParameterfv;
    long glGetMinmaxParameteriv;
    long glConvolutionFilter1D;
    long glConvolutionFilter2D;
    long glConvolutionParameterf;
    long glConvolutionParameterfv;
    long glConvolutionParameteri;
    long glConvolutionParameteriv;
    long glCopyConvolutionFilter1D;
    long glCopyConvolutionFilter2D;
    long glGetConvolutionFilter;
    long glGetConvolutionParameterfv;
    long glGetConvolutionParameteriv;
    long glSeparableFilter2D;
    long glGetSeparableFilter;
    // ARB_indirect_parameters
    long glMultiDrawArraysIndirectCountARB;
    long glMultiDrawElementsIndirectCountARB;
    // ARB_instanced_arrays
    long glVertexAttribDivisorARB;
    // ARB_matrix_palette
    long glCurrentPaletteMatrixARB;
    long glMatrixIndexPointerARB;
    long glMatrixIndexubvARB;
    long glMatrixIndexusvARB;
    long glMatrixIndexuivARB;
    // ARB_multisample
    long glSampleCoverageARB;
    // ARB_multitexture
    long glClientActiveTextureARB;
    long glActiveTextureARB;
    long glMultiTexCoord1fARB;
    long glMultiTexCoord1dARB;
    long glMultiTexCoord1iARB;
    long glMultiTexCoord1sARB;
    long glMultiTexCoord2fARB;
    long glMultiTexCoord2dARB;
    long glMultiTexCoord2iARB;
    long glMultiTexCoord2sARB;
    long glMultiTexCoord3fARB;
    long glMultiTexCoord3dARB;
    long glMultiTexCoord3iARB;
    long glMultiTexCoord3sARB;
    long glMultiTexCoord4fARB;
    long glMultiTexCoord4dARB;
    long glMultiTexCoord4iARB;
    long glMultiTexCoord4sARB;
    // ARB_occlusion_query
    long glGenQueriesARB;
    long glDeleteQueriesARB;
    long glIsQueryARB;
    long glBeginQueryARB;
    long glEndQueryARB;
    long glGetQueryivARB;
    long glGetQueryObjectivARB;
    long glGetQueryObjectuivARB;
    // ARB_point_parameters
    long glPointParameterfARB;
    long glPointParameterfvARB;
    // ARB_program
    long glProgramStringARB;
    long glBindProgramARB;
    long glDeleteProgramsARB;
    long glGenProgramsARB;
    long glProgramEnvParameter4fARB;
    long glProgramEnvParameter4dARB;
    long glProgramEnvParameter4fvARB;
    long glProgramEnvParameter4dvARB;
    long glProgramLocalParameter4fARB;
    long glProgramLocalParameter4dARB;
    long glProgramLocalParameter4fvARB;
    long glProgramLocalParameter4dvARB;
    long glGetProgramEnvParameterfvARB;
    long glGetProgramEnvParameterdvARB;
    long glGetProgramLocalParameterfvARB;
    long glGetProgramLocalParameterdvARB;
    long glGetProgramivARB;
    long glGetProgramStringARB;
    long glIsProgramARB;
    // ARB_robustness
    long glGetGraphicsResetStatusARB;
    long glGetnMapdvARB;
    long glGetnMapfvARB;
    long glGetnMapivARB;
    long glGetnPixelMapfvARB;
    long glGetnPixelMapuivARB;
    long glGetnPixelMapusvARB;
    long glGetnPolygonStippleARB;
    long glGetnTexImageARB;
    long glReadnPixelsARB;
    long glGetnColorTableARB;
    long glGetnConvolutionFilterARB;
    long glGetnSeparableFilterARB;
    long glGetnHistogramARB;
    long glGetnMinmaxARB;
    long glGetnCompressedTexImageARB;
    long glGetnUniformfvARB;
    long glGetnUniformivARB;
    long glGetnUniformuivARB;
    long glGetnUniformdvARB;
    // ARB_sample_shading
    long glMinSampleShadingARB;
    // ARB_shader_objects
    long glDeleteObjectARB;
    long glGetHandleARB;
    long glDetachObjectARB;
    long glCreateShaderObjectARB;
    long glShaderSourceARB;
    long glCompileShaderARB;
    long glCreateProgramObjectARB;
    long glAttachObjectARB;
    long glLinkProgramARB;
    long glUseProgramObjectARB;
    long glValidateProgramARB;
    long glUniform1fARB;
    long glUniform2fARB;
    long glUniform3fARB;
    long glUniform4fARB;
    long glUniform1iARB;
    long glUniform2iARB;
    long glUniform3iARB;
    long glUniform4iARB;
    long glUniform1fvARB;
    long glUniform2fvARB;
    long glUniform3fvARB;
    long glUniform4fvARB;
    long glUniform1ivARB;
    long glUniform2ivARB;
    long glUniform3ivARB;
    long glUniform4ivARB;
    long glUniformMatrix2fvARB;
    long glUniformMatrix3fvARB;
    long glUniformMatrix4fvARB;
    long glGetObjectParameterfvARB;
    long glGetObjectParameterivARB;
    long glGetInfoLogARB;
    long glGetAttachedObjectsARB;
    long glGetUniformLocationARB;
    long glGetActiveUniformARB;
    long glGetUniformfvARB;
    long glGetUniformivARB;
    long glGetShaderSourceARB;
    // ARB_shading_language_include
    long glNamedStringARB;
    long glDeleteNamedStringARB;
    long glCompileShaderIncludeARB;
    long glIsNamedStringARB;
    long glGetNamedStringARB;
    long glGetNamedStringivARB;
    // ARB_sparse_buffer
    long glBufferPageCommitmentARB;
    // ARB_sparse_texture
    long glTexPageCommitmentARB;
    long glTexturePageCommitmentEXT;
    // ARB_texture_buffer_object
    long glTexBufferARB;
    // ARB_texture_buffer_range
    long glTextureBufferRangeEXT;
    // ARB_texture_compression
    long glCompressedTexImage1DARB;
    long glCompressedTexImage2DARB;
    long glCompressedTexImage3DARB;
    long glCompressedTexSubImage1DARB;
    long glCompressedTexSubImage2DARB;
    long glCompressedTexSubImage3DARB;
    long glGetCompressedTexImageARB;
    // ARB_texture_storage
    long glTextureStorage1DEXT;
    long glTextureStorage2DEXT;
    long glTextureStorage3DEXT;
    // ARB_texture_storage_multisample
    long glTextureStorage2DMultisampleEXT;
    long glTextureStorage3DMultisampleEXT;
    // ARB_transpose_matrix
    long glLoadTransposeMatrixfARB;
    long glMultTransposeMatrixfARB;
    // ARB_vertex_attrib_64bit
    long glVertexArrayVertexAttribLOffsetEXT;
    // ARB_vertex_blend
    long glWeightbvARB;
    long glWeightsvARB;
    long glWeightivARB;
    long glWeightfvARB;
    long glWeightdvARB;
    long glWeightubvARB;
    long glWeightusvARB;
    long glWeightuivARB;
    long glWeightPointerARB;
    long glVertexBlendARB;
    // ARB_vertex_shader
    long glVertexAttrib1sARB;
    long glVertexAttrib1fARB;
    long glVertexAttrib1dARB;
    long glVertexAttrib2sARB;
    long glVertexAttrib2fARB;
    long glVertexAttrib2dARB;
    long glVertexAttrib3sARB;
    long glVertexAttrib3fARB;
    long glVertexAttrib3dARB;
    long glVertexAttrib4sARB;
    long glVertexAttrib4fARB;
    long glVertexAttrib4dARB;
    long glVertexAttrib4NubARB;
    long glVertexAttribPointerARB;
    long glEnableVertexAttribArrayARB;
    long glDisableVertexAttribArrayARB;
    long glBindAttribLocationARB;
    long glGetActiveAttribARB;
    long glGetAttribLocationARB;
    long glGetVertexAttribfvARB;
    long glGetVertexAttribdvARB;
    long glGetVertexAttribivARB;
    long glGetVertexAttribPointervARB;
    // ARB_window_pos
    long glWindowPos2fARB;
    long glWindowPos2dARB;
    long glWindowPos2iARB;
    long glWindowPos2sARB;
    long glWindowPos3fARB;
    long glWindowPos3dARB;
    long glWindowPos3iARB;
    long glWindowPos3sARB;
    // ATI_draw_buffers
    long glDrawBuffersATI;
    // ATI_element_array
    long glElementPointerATI;
    long glDrawElementArrayATI;
    long glDrawRangeElementArrayATI;
    // ATI_envmap_bumpmap
    long glTexBumpParameterfvATI;
    long glTexBumpParameterivATI;
    long glGetTexBumpParameterfvATI;
    long glGetTexBumpParameterivATI;
    // ATI_fragment_shader
    long glGenFragmentShadersATI;
    long glBindFragmentShaderATI;
    long glDeleteFragmentShaderATI;
    long glBeginFragmentShaderATI;
    long glEndFragmentShaderATI;
    long glPassTexCoordATI;
    long glSampleMapATI;
    long glColorFragmentOp1ATI;
    long glColorFragmentOp2ATI;
    long glColorFragmentOp3ATI;
    long glAlphaFragmentOp1ATI;
    long glAlphaFragmentOp2ATI;
    long glAlphaFragmentOp3ATI;
    long glSetFragmentShaderConstantATI;
    // ATI_map_object_buffer
    long glMapObjectBufferATI;
    long glUnmapObjectBufferATI;
    // ATI_pn_triangles
    long glPNTrianglesfATI;
    long glPNTrianglesiATI;
    // ATI_separate_stencil
    long glStencilOpSeparateATI;
    long glStencilFuncSeparateATI;
    // ATI_vertex_array_object
    long glNewObjectBufferATI;
    long glIsObjectBufferATI;
    long glUpdateObjectBufferATI;
    long glGetObjectBufferfvATI;
    long glGetObjectBufferivATI;
    long glFreeObjectBufferATI;
    long glArrayObjectATI;
    long glGetArrayObjectfvATI;
    long glGetArrayObjectivATI;
    long glVariantArrayObjectATI;
    long glGetVariantArrayObjectfvATI;
    long glGetVariantArrayObjectivATI;
    // ATI_vertex_attrib_array_object
    long glVertexAttribArrayObjectATI;
    long glGetVertexAttribArrayObjectfvATI;
    long glGetVertexAttribArrayObjectivATI;
    // ATI_vertex_streams
    long glVertexStream2fATI;
    long glVertexStream2dATI;
    long glVertexStream2iATI;
    long glVertexStream2sATI;
    long glVertexStream3fATI;
    long glVertexStream3dATI;
    long glVertexStream3iATI;
    long glVertexStream3sATI;
    long glVertexStream4fATI;
    long glVertexStream4dATI;
    long glVertexStream4iATI;
    long glVertexStream4sATI;
    long glNormalStream3bATI;
    long glNormalStream3fATI;
    long glNormalStream3dATI;
    long glNormalStream3iATI;
    long glNormalStream3sATI;
    long glClientActiveVertexStreamATI;
    long glVertexBlendEnvfATI;
    long glVertexBlendEnviATI;
    // EXT_bindable_uniform
    long glUniformBufferEXT;
    long glGetUniformBufferSizeEXT;
    long glGetUniformOffsetEXT;
    // EXT_blend_color
    long glBlendColorEXT;
    // EXT_blend_equation_separate
    long glBlendEquationSeparateEXT;
    // EXT_blend_func_separate
    long glBlendFuncSeparateEXT;
    // EXT_blend_minmax
    long glBlendEquationEXT;
    // EXT_compiled_vertex_array
    long glLockArraysEXT;
    long glUnlockArraysEXT;
    // EXT_depth_bounds_test
    long glDepthBoundsEXT;
    // EXT_direct_state_access
    long glClientAttribDefaultEXT;
    long glPushClientAttribDefaultEXT;
    long glMatrixLoadfEXT;
    long glMatrixLoaddEXT;
    long glMatrixMultfEXT;
    long glMatrixMultdEXT;
    long glMatrixLoadIdentityEXT;
    long glMatrixRotatefEXT;
    long glMatrixRotatedEXT;
    long glMatrixScalefEXT;
    long glMatrixScaledEXT;
    long glMatrixTranslatefEXT;
    long glMatrixTranslatedEXT;
    long glMatrixOrthoEXT;
    long glMatrixFrustumEXT;
    long glMatrixPushEXT;
    long glMatrixPopEXT;
    long glTextureParameteriEXT;
    long glTextureParameterivEXT;
    long glTextureParameterfEXT;
    long glTextureParameterfvEXT;
    long glTextureImage1DEXT;
    long glTextureImage2DEXT;
    long glTextureSubImage1DEXT;
    long glTextureSubImage2DEXT;
    long glCopyTextureImage1DEXT;
    long glCopyTextureImage2DEXT;
    long glCopyTextureSubImage1DEXT;
    long glCopyTextureSubImage2DEXT;
    long glGetTextureImageEXT;
    long glGetTextureParameterfvEXT;
    long glGetTextureParameterivEXT;
    long glGetTextureLevelParameterfvEXT;
    long glGetTextureLevelParameterivEXT;
    long glTextureImage3DEXT;
    long glTextureSubImage3DEXT;
    long glCopyTextureSubImage3DEXT;
    long glBindMultiTextureEXT;
    long glMultiTexCoordPointerEXT;
    long glMultiTexEnvfEXT;
    long glMultiTexEnvfvEXT;
    long glMultiTexEnviEXT;
    long glMultiTexEnvivEXT;
    long glMultiTexGendEXT;
    long glMultiTexGendvEXT;
    long glMultiTexGenfEXT;
    long glMultiTexGenfvEXT;
    long glMultiTexGeniEXT;
    long glMultiTexGenivEXT;
    long glGetMultiTexEnvfvEXT;
    long glGetMultiTexEnvivEXT;
    long glGetMultiTexGendvEXT;
    long glGetMultiTexGenfvEXT;
    long glGetMultiTexGenivEXT;
    long glMultiTexParameteriEXT;
    long glMultiTexParameterivEXT;
    long glMultiTexParameterfEXT;
    long glMultiTexParameterfvEXT;
    long glMultiTexImage1DEXT;
    long glMultiTexImage2DEXT;
    long glMultiTexSubImage1DEXT;
    long glMultiTexSubImage2DEXT;
    long glCopyMultiTexImage1DEXT;
    long glCopyMultiTexImage2DEXT;
    long glCopyMultiTexSubImage1DEXT;
    long glCopyMultiTexSubImage2DEXT;
    long glGetMultiTexImageEXT;
    long glGetMultiTexParameterfvEXT;
    long glGetMultiTexParameterivEXT;
    long glGetMultiTexLevelParameterfvEXT;
    long glGetMultiTexLevelParameterivEXT;
    long glMultiTexImage3DEXT;
    long glMultiTexSubImage3DEXT;
    long glCopyMultiTexSubImage3DEXT;
    long glEnableClientStateIndexedEXT;
    long glDisableClientStateIndexedEXT;
    long glEnableClientStateiEXT;
    long glDisableClientStateiEXT;
    long glGetFloatIndexedvEXT;
    long glGetDoubleIndexedvEXT;
    long glGetPointerIndexedvEXT;
    long glGetFloati_vEXT;
    long glGetDoublei_vEXT;
    long glGetPointeri_vEXT;
    long glNamedProgramStringEXT;
    long glNamedProgramLocalParameter4dEXT;
    long glNamedProgramLocalParameter4dvEXT;
    long glNamedProgramLocalParameter4fEXT;
    long glNamedProgramLocalParameter4fvEXT;
    long glGetNamedProgramLocalParameterdvEXT;
    long glGetNamedProgramLocalParameterfvEXT;
    long glGetNamedProgramivEXT;
    long glGetNamedProgramStringEXT;
    long glCompressedTextureImage3DEXT;
    long glCompressedTextureImage2DEXT;
    long glCompressedTextureImage1DEXT;
    long glCompressedTextureSubImage3DEXT;
    long glCompressedTextureSubImage2DEXT;
    long glCompressedTextureSubImage1DEXT;
    long glGetCompressedTextureImageEXT;
    long glCompressedMultiTexImage3DEXT;
    long glCompressedMultiTexImage2DEXT;
    long glCompressedMultiTexImage1DEXT;
    long glCompressedMultiTexSubImage3DEXT;
    long glCompressedMultiTexSubImage2DEXT;
    long glCompressedMultiTexSubImage1DEXT;
    long glGetCompressedMultiTexImageEXT;
    long glMatrixLoadTransposefEXT;
    long glMatrixLoadTransposedEXT;
    long glMatrixMultTransposefEXT;
    long glMatrixMultTransposedEXT;
    long glNamedBufferDataEXT;
    long glNamedBufferSubDataEXT;
    long glMapNamedBufferEXT;
    long glUnmapNamedBufferEXT;
    long glGetNamedBufferParameterivEXT;
    long glGetNamedBufferPointervEXT;
    long glGetNamedBufferSubDataEXT;
    long glProgramUniform1fEXT;
    long glProgramUniform2fEXT;
    long glProgramUniform3fEXT;
    long glProgramUniform4fEXT;
    long glProgramUniform1iEXT;
    long glProgramUniform2iEXT;
    long glProgramUniform3iEXT;
    long glProgramUniform4iEXT;
    long glProgramUniform1fvEXT;
    long glProgramUniform2fvEXT;
    long glProgramUniform3fvEXT;
    long glProgramUniform4fvEXT;
    long glProgramUniform1ivEXT;
    long glProgramUniform2ivEXT;
    long glProgramUniform3ivEXT;
    long glProgramUniform4ivEXT;
    long glProgramUniformMatrix2fvEXT;
    long glProgramUniformMatrix3fvEXT;
    long glProgramUniformMatrix4fvEXT;
    long glProgramUniformMatrix2x3fvEXT;
    long glProgramUniformMatrix3x2fvEXT;
    long glProgramUniformMatrix2x4fvEXT;
    long glProgramUniformMatrix4x2fvEXT;
    long glProgramUniformMatrix3x4fvEXT;
    long glProgramUniformMatrix4x3fvEXT;
    long glTextureBufferEXT;
    long glMultiTexBufferEXT;
    long glTextureParameterIivEXT;
    long glTextureParameterIuivEXT;
    long glGetTextureParameterIivEXT;
    long glGetTextureParameterIuivEXT;
    long glMultiTexParameterIivEXT;
    long glMultiTexParameterIuivEXT;
    long glGetMultiTexParameterIivEXT;
    long glGetMultiTexParameterIuivEXT;
    long glProgramUniform1uiEXT;
    long glProgramUniform2uiEXT;
    long glProgramUniform3uiEXT;
    long glProgramUniform4uiEXT;
    long glProgramUniform1uivEXT;
    long glProgramUniform2uivEXT;
    long glProgramUniform3uivEXT;
    long glProgramUniform4uivEXT;
    long glNamedProgramLocalParameters4fvEXT;
    long glNamedProgramLocalParameterI4iEXT;
    long glNamedProgramLocalParameterI4ivEXT;
    long glNamedProgramLocalParametersI4ivEXT;
    long glNamedProgramLocalParameterI4uiEXT;
    long glNamedProgramLocalParameterI4uivEXT;
    long glNamedProgramLocalParametersI4uivEXT;
    long glGetNamedProgramLocalParameterIivEXT;
    long glGetNamedProgramLocalParameterIuivEXT;
    long glNamedRenderbufferStorageEXT;
    long glGetNamedRenderbufferParameterivEXT;
    long glNamedRenderbufferStorageMultisampleEXT;
    long glNamedRenderbufferStorageMultisampleCoverageEXT;
    long glCheckNamedFramebufferStatusEXT;
    long glNamedFramebufferTexture1DEXT;
    long glNamedFramebufferTexture2DEXT;
    long glNamedFramebufferTexture3DEXT;
    long glNamedFramebufferRenderbufferEXT;
    long glGetNamedFramebufferAttachmentParameterivEXT;
    long glGenerateTextureMipmapEXT;
    long glGenerateMultiTexMipmapEXT;
    long glFramebufferDrawBufferEXT;
    long glFramebufferDrawBuffersEXT;
    long glFramebufferReadBufferEXT;
    long glGetFramebufferParameterivEXT;
    long glNamedCopyBufferSubDataEXT;
    long glNamedFramebufferTextureEXT;
    long glNamedFramebufferTextureLayerEXT;
    long glNamedFramebufferTextureFaceEXT;
    long glTextureRenderbufferEXT;
    long glMultiTexRenderbufferEXT;
    long glVertexArrayVertexOffsetEXT;
    long glVertexArrayColorOffsetEXT;
    long glVertexArrayEdgeFlagOffsetEXT;
    long glVertexArrayIndexOffsetEXT;
    long glVertexArrayNormalOffsetEXT;
    long glVertexArrayTexCoordOffsetEXT;
    long glVertexArrayMultiTexCoordOffsetEXT;
    long glVertexArrayFogCoordOffsetEXT;
    long glVertexArraySecondaryColorOffsetEXT;
    long glVertexArrayVertexAttribOffsetEXT;
    long glVertexArrayVertexAttribIOffsetEXT;
    long glEnableVertexArrayEXT;
    long glDisableVertexArrayEXT;
    long glEnableVertexArrayAttribEXT;
    long glDisableVertexArrayAttribEXT;
    long glGetVertexArrayIntegervEXT;
    long glGetVertexArrayPointervEXT;
    long glGetVertexArrayIntegeri_vEXT;
    long glGetVertexArrayPointeri_vEXT;
    long glMapNamedBufferRangeEXT;
    long glFlushMappedNamedBufferRangeEXT;
    // EXT_draw_buffers2
    long glColorMaskIndexedEXT;
    long glGetBooleanIndexedvEXT;
    long glGetIntegerIndexedvEXT;
    long glEnableIndexedEXT;
    long glDisableIndexedEXT;
    long glIsEnabledIndexedEXT;
    // EXT_draw_instanced
    long glDrawArraysInstancedEXT;
    long glDrawElementsInstancedEXT;
    // EXT_draw_range_elements
    long glDrawRangeElementsEXT;
    // EXT_fog_coord
    long glFogCoordfEXT;
    long glFogCoorddEXT;
    long glFogCoordPointerEXT;
    // EXT_framebuffer_blit
    long glBlitFramebufferEXT;
    // EXT_framebuffer_multisample
    long glRenderbufferStorageMultisampleEXT;
    // EXT_framebuffer_object
    long glIsRenderbufferEXT;
    long glBindRenderbufferEXT;
    long glDeleteRenderbuffersEXT;
    long glGenRenderbuffersEXT;
    long glRenderbufferStorageEXT;
    long glGetRenderbufferParameterivEXT;
    long glIsFramebufferEXT;
    long glBindFramebufferEXT;
    long glDeleteFramebuffersEXT;
    long glGenFramebuffersEXT;
    long glCheckFramebufferStatusEXT;
    long glFramebufferTexture1DEXT;
    long glFramebufferTexture2DEXT;
    long glFramebufferTexture3DEXT;
    long glFramebufferRenderbufferEXT;
    long glGetFramebufferAttachmentParameterivEXT;
    long glGenerateMipmapEXT;
    // EXT_geometry_shader4
    long glProgramParameteriEXT;
    long glFramebufferTextureEXT;
    long glFramebufferTextureLayerEXT;
    long glFramebufferTextureFaceEXT;
    // EXT_gpu_program_parameters
    long glProgramEnvParameters4fvEXT;
    long glProgramLocalParameters4fvEXT;
    // EXT_gpu_shader4
    long glVertexAttribI1iEXT;
    long glVertexAttribI2iEXT;
    long glVertexAttribI3iEXT;
    long glVertexAttribI4iEXT;
    long glVertexAttribI1uiEXT;
    long glVertexAttribI2uiEXT;
    long glVertexAttribI3uiEXT;
    long glVertexAttribI4uiEXT;
    long glVertexAttribI1ivEXT;
    long glVertexAttribI2ivEXT;
    long glVertexAttribI3ivEXT;
    long glVertexAttribI4ivEXT;
    long glVertexAttribI1uivEXT;
    long glVertexAttribI2uivEXT;
    long glVertexAttribI3uivEXT;
    long glVertexAttribI4uivEXT;
    long glVertexAttribI4bvEXT;
    long glVertexAttribI4svEXT;
    long glVertexAttribI4ubvEXT;
    long glVertexAttribI4usvEXT;
    long glVertexAttribIPointerEXT;
    long glGetVertexAttribIivEXT;
    long glGetVertexAttribIuivEXT;
    long glUniform1uiEXT;
    long glUniform2uiEXT;
    long glUniform3uiEXT;
    long glUniform4uiEXT;
    long glUniform1uivEXT;
    long glUniform2uivEXT;
    long glUniform3uivEXT;
    long glUniform4uivEXT;
    long glGetUniformuivEXT;
    long glBindFragDataLocationEXT;
    long glGetFragDataLocationEXT;
    // EXT_multi_draw_arrays
    long glMultiDrawArraysEXT;
    // EXT_paletted_texture
    long glColorTableEXT;
    long glColorSubTableEXT;
    long glGetColorTableEXT;
    long glGetColorTableParameterivEXT;
    long glGetColorTableParameterfvEXT;
    // EXT_point_parameters
    long glPointParameterfEXT;
    long glPointParameterfvEXT;
    // EXT_provoking_vertex
    long glProvokingVertexEXT;
    // EXT_secondary_color
    long glSecondaryColor3bEXT;
    long glSecondaryColor3fEXT;
    long glSecondaryColor3dEXT;
    long glSecondaryColor3ubEXT;
    long glSecondaryColorPointerEXT;
    // EXT_separate_shader_objects
    long glUseShaderProgramEXT;
    long glActiveProgramEXT;
    long glCreateShaderProgramEXT;
    // EXT_shader_image_load_store
    long glBindImageTextureEXT;
    long glMemoryBarrierEXT;
    // EXT_stencil_clear_tag
    long glStencilClearTagEXT;
    // EXT_stencil_two_side
    long glActiveStencilFaceEXT;
    // EXT_texture_buffer_object
    long glTexBufferEXT;
    // EXT_texture_integer
    long glClearColorIiEXT;
    long glClearColorIuiEXT;
    long glTexParameterIivEXT;
    long glTexParameterIuivEXT;
    long glGetTexParameterIivEXT;
    long glGetTexParameterIuivEXT;
    // EXT_timer_query
    long glGetQueryObjecti64vEXT;
    long glGetQueryObjectui64vEXT;
    // EXT_transform_feedback
    long glBindBufferRangeEXT;
    long glBindBufferOffsetEXT;
    long glBindBufferBaseEXT;
    long glBeginTransformFeedbackEXT;
    long glEndTransformFeedbackEXT;
    long glTransformFeedbackVaryingsEXT;
    long glGetTransformFeedbackVaryingEXT;
    // EXT_vertex_attrib_64bit
    long glVertexAttribL1dEXT;
    long glVertexAttribL2dEXT;
    long glVertexAttribL3dEXT;
    long glVertexAttribL4dEXT;
    long glVertexAttribL1dvEXT;
    long glVertexAttribL2dvEXT;
    long glVertexAttribL3dvEXT;
    long glVertexAttribL4dvEXT;
    long glVertexAttribLPointerEXT;
    long glGetVertexAttribLdvEXT;
    // EXT_vertex_shader
    long glBeginVertexShaderEXT;
    long glEndVertexShaderEXT;
    long glBindVertexShaderEXT;
    long glGenVertexShadersEXT;
    long glDeleteVertexShaderEXT;
    long glShaderOp1EXT;
    long glShaderOp2EXT;
    long glShaderOp3EXT;
    long glSwizzleEXT;
    long glWriteMaskEXT;
    long glInsertComponentEXT;
    long glExtractComponentEXT;
    long glGenSymbolsEXT;
    long glSetInvariantEXT;
    long glSetLocalConstantEXT;
    long glVariantbvEXT;
    long glVariantsvEXT;
    long glVariantivEXT;
    long glVariantfvEXT;
    long glVariantdvEXT;
    long glVariantubvEXT;
    long glVariantusvEXT;
    long glVariantuivEXT;
    long glVariantPointerEXT;
    long glEnableVariantClientStateEXT;
    long glDisableVariantClientStateEXT;
    long glBindLightParameterEXT;
    long glBindMaterialParameterEXT;
    long glBindTexGenParameterEXT;
    long glBindTextureUnitParameterEXT;
    long glBindParameterEXT;
    long glIsVariantEnabledEXT;
    long glGetVariantBooleanvEXT;
    long glGetVariantIntegervEXT;
    long glGetVariantFloatvEXT;
    long glGetVariantPointervEXT;
    long glGetInvariantBooleanvEXT;
    long glGetInvariantIntegervEXT;
    long glGetInvariantFloatvEXT;
    long glGetLocalConstantBooleanvEXT;
    long glGetLocalConstantIntegervEXT;
    long glGetLocalConstantFloatvEXT;
    // EXT_vertex_weighting
    long glVertexWeightfEXT;
    long glVertexWeightPointerEXT;
    // GL11
    long glAccum;
    long glAlphaFunc;
    long glClearColor;
    long glClearAccum;
    long glClear;
    long glCallLists;
    long glCallList;
    long glBlendFunc;
    long glBitmap;
    long glBindTexture;
    long glPrioritizeTextures;
    long glAreTexturesResident;
    long glBegin;
    long glEnd;
    long glArrayElement;
    long glClearDepth;
    long glDeleteLists;
    long glDeleteTextures;
    long glCullFace;
    long glCopyTexSubImage2D;
    long glCopyTexSubImage1D;
    long glCopyTexImage2D;
    long glCopyTexImage1D;
    long glCopyPixels;
    long glColorPointer;
    long glColorMaterial;
    long glColorMask;
    long glColor3b;
    long glColor3f;
    long glColor3d;
    long glColor3ub;
    long glColor4b;
    long glColor4f;
    long glColor4d;
    long glColor4ub;
    long glClipPlane;
    long glClearStencil;
    long glEvalPoint1;
    long glEvalPoint2;
    long glEvalMesh1;
    long glEvalMesh2;
    long glEvalCoord1f;
    long glEvalCoord1d;
    long glEvalCoord2f;
    long glEvalCoord2d;
    long glEnableClientState;
    long glDisableClientState;
    long glEnable;
    long glDisable;
    long glEdgeFlagPointer;
    long glEdgeFlag;
    long glDrawPixels;
    long glDrawElements;
    long glDrawBuffer;
    long glDrawArrays;
    long glDepthRange;
    long glDepthMask;
    long glDepthFunc;
    long glFeedbackBuffer;
    long glGetPixelMapfv;
    long glGetPixelMapuiv;
    long glGetPixelMapusv;
    long glGetMaterialfv;
    long glGetMaterialiv;
    long glGetMapfv;
    long glGetMapdv;
    long glGetMapiv;
    long glGetLightfv;
    long glGetLightiv;
    long glGetError;
    long glGetClipPlane;
    long glGetBooleanv;
    long glGetDoublev;
    long glGetFloatv;
    long glGetIntegerv;
    long glGenTextures;
    long glGenLists;
    long glFrustum;
    long glFrontFace;
    long glFogf;
    long glFogi;
    long glFogfv;
    long glFogiv;
    long glFlush;
    long glFinish;
    long glGetPointerv;
    long glIsEnabled;
    long glInterleavedArrays;
    long glInitNames;
    long glHint;
    long glGetTexParameterfv;
    long glGetTexParameteriv;
    long glGetTexLevelParameterfv;
    long glGetTexLevelParameteriv;
    long glGetTexImage;
    long glGetTexGeniv;
    long glGetTexGenfv;
    long glGetTexGendv;
    long glGetTexEnviv;
    long glGetTexEnvfv;
    long glGetString;
    long glGetPolygonStipple;
    long glIsList;
    long glMaterialf;
    long glMateriali;
    long glMaterialfv;
    long glMaterialiv;
    long glMapGrid1f;
    long glMapGrid1d;
    long glMapGrid2f;
    long glMapGrid2d;
    long glMap2f;
    long glMap2d;
    long glMap1f;
    long glMap1d;
    long glLogicOp;
    long glLoadName;
    long glLoadMatrixf;
    long glLoadMatrixd;
    long glLoadIdentity;
    long glListBase;
    long glLineWidth;
    long glLineStipple;
    long glLightModelf;
    long glLightModeli;
    long glLightModelfv;
    long glLightModeliv;
    long glLightf;
    long glLighti;
    long glLightfv;
    long glLightiv;
    long glIsTexture;
    long glMatrixMode;
    long glPolygonStipple;
    long glPolygonOffset;
    long glPolygonMode;
    long glPointSize;
    long glPixelZoom;
    long glPixelTransferf;
    long glPixelTransferi;
    long glPixelStoref;
    long glPixelStorei;
    long glPixelMapfv;
    long glPixelMapuiv;
    long glPixelMapusv;
    long glPassThrough;
    long glOrtho;
    long glNormalPointer;
    long glNormal3b;
    long glNormal3f;
    long glNormal3d;
    long glNormal3i;
    long glNewList;
    long glEndList;
    long glMultMatrixf;
    long glMultMatrixd;
    long glShadeModel;
    long glSelectBuffer;
    long glScissor;
    long glScalef;
    long glScaled;
    long glRotatef;
    long glRotated;
    long glRenderMode;
    long glRectf;
    long glRectd;
    long glRecti;
    long glReadPixels;
    long glReadBuffer;
    long glRasterPos2f;
    long glRasterPos2d;
    long glRasterPos2i;
    long glRasterPos3f;
    long glRasterPos3d;
    long glRasterPos3i;
    long glRasterPos4f;
    long glRasterPos4d;
    long glRasterPos4i;
    long glPushName;
    long glPopName;
    long glPushMatrix;
    long glPopMatrix;
    long glPushClientAttrib;
    long glPopClientAttrib;
    long glPushAttrib;
    long glPopAttrib;
    long glStencilFunc;
    long glVertexPointer;
    long glVertex2f;
    long glVertex2d;
    long glVertex2i;
    long glVertex3f;
    long glVertex3d;
    long glVertex3i;
    long glVertex4f;
    long glVertex4d;
    long glVertex4i;
    long glTranslatef;
    long glTranslated;
    long glTexImage1D;
    long glTexImage2D;
    long glTexSubImage1D;
    long glTexSubImage2D;
    long glTexParameterf;
    long glTexParameteri;
    long glTexParameterfv;
    long glTexParameteriv;
    long glTexGenf;
    long glTexGend;
    long glTexGenfv;
    long glTexGendv;
    long glTexGeni;
    long glTexGeniv;
    long glTexEnvf;
    long glTexEnvi;
    long glTexEnvfv;
    long glTexEnviv;
    long glTexCoordPointer;
    long glTexCoord1f;
    long glTexCoord1d;
    long glTexCoord2f;
    long glTexCoord2d;
    long glTexCoord3f;
    long glTexCoord3d;
    long glTexCoord4f;
    long glTexCoord4d;
    long glStencilOp;
    long glStencilMask;
    long glViewport;
    // GL12
    long glDrawRangeElements;
    long glTexImage3D;
    long glTexSubImage3D;
    long glCopyTexSubImage3D;
    // GL13
    long glActiveTexture;
    long glClientActiveTexture;
    long glCompressedTexImage1D;
    long glCompressedTexImage2D;
    long glCompressedTexImage3D;
    long glCompressedTexSubImage1D;
    long glCompressedTexSubImage2D;
    long glCompressedTexSubImage3D;
    long glGetCompressedTexImage;
    long glMultiTexCoord1f;
    long glMultiTexCoord1d;
    long glMultiTexCoord2f;
    long glMultiTexCoord2d;
    long glMultiTexCoord3f;
    long glMultiTexCoord3d;
    long glMultiTexCoord4f;
    long glMultiTexCoord4d;
    long glLoadTransposeMatrixf;
    long glLoadTransposeMatrixd;
    long glMultTransposeMatrixf;
    long glMultTransposeMatrixd;
    long glSampleCoverage;
    // GL14
    long glBlendEquation;
    long glBlendColor;
    long glFogCoordf;
    long glFogCoordd;
    long glFogCoordPointer;
    long glMultiDrawArrays;
    long glPointParameteri;
    long glPointParameterf;
    long glPointParameteriv;
    long glPointParameterfv;
    long glSecondaryColor3b;
    long glSecondaryColor3f;
    long glSecondaryColor3d;
    long glSecondaryColor3ub;
    long glSecondaryColorPointer;
    long glBlendFuncSeparate;
    long glWindowPos2f;
    long glWindowPos2d;
    long glWindowPos2i;
    long glWindowPos3f;
    long glWindowPos3d;
    long glWindowPos3i;
    // GL15
    long glBindBuffer;
    long glDeleteBuffers;
    long glGenBuffers;
    long glIsBuffer;
    long glBufferData;
    long glBufferSubData;
    long glGetBufferSubData;
    long glMapBuffer;
    long glUnmapBuffer;
    long glGetBufferParameteriv;
    long glGetBufferPointerv;
    long glGenQueries;
    long glDeleteQueries;
    long glIsQuery;
    long glBeginQuery;
    long glEndQuery;
    long glGetQueryiv;
    long glGetQueryObjectiv;
    long glGetQueryObjectuiv;
    // GL20
    long glShaderSource;
    long glCreateShader;
    long glIsShader;
    long glCompileShader;
    long glDeleteShader;
    long glCreateProgram;
    long glIsProgram;
    long glAttachShader;
    long glDetachShader;
    long glLinkProgram;
    long glUseProgram;
    long glValidateProgram;
    long glDeleteProgram;
    long glUniform1f;
    long glUniform2f;
    long glUniform3f;
    long glUniform4f;
    long glUniform1i;
    long glUniform2i;
    long glUniform3i;
    long glUniform4i;
    long glUniform1fv;
    long glUniform2fv;
    long glUniform3fv;
    long glUniform4fv;
    long glUniform1iv;
    long glUniform2iv;
    long glUniform3iv;
    long glUniform4iv;
    long glUniformMatrix2fv;
    long glUniformMatrix3fv;
    long glUniformMatrix4fv;
    long glGetShaderiv;
    long glGetProgramiv;
    long glGetShaderInfoLog;
    long glGetProgramInfoLog;
    long glGetAttachedShaders;
    long glGetUniformLocation;
    long glGetActiveUniform;
    long glGetUniformfv;
    long glGetUniformiv;
    long glGetShaderSource;
    long glVertexAttrib1s;
    long glVertexAttrib1f;
    long glVertexAttrib1d;
    long glVertexAttrib2s;
    long glVertexAttrib2f;
    long glVertexAttrib2d;
    long glVertexAttrib3s;
    long glVertexAttrib3f;
    long glVertexAttrib3d;
    long glVertexAttrib4s;
    long glVertexAttrib4f;
    long glVertexAttrib4d;
    long glVertexAttrib4Nub;
    long glVertexAttribPointer;
    long glEnableVertexAttribArray;
    long glDisableVertexAttribArray;
    long glGetVertexAttribfv;
    long glGetVertexAttribdv;
    long glGetVertexAttribiv;
    long glGetVertexAttribPointerv;
    long glBindAttribLocation;
    long glGetActiveAttrib;
    long glGetAttribLocation;
    long glDrawBuffers;
    long glStencilOpSeparate;
    long glStencilFuncSeparate;
    long glStencilMaskSeparate;
    long glBlendEquationSeparate;
    // GL21
    long glUniformMatrix2x3fv;
    long glUniformMatrix3x2fv;
    long glUniformMatrix2x4fv;
    long glUniformMatrix4x2fv;
    long glUniformMatrix3x4fv;
    long glUniformMatrix4x3fv;
    // GL30
    long glGetStringi;
    long glClearBufferfv;
    long glClearBufferiv;
    long glClearBufferuiv;
    long glClearBufferfi;
    long glVertexAttribI1i;
    long glVertexAttribI2i;
    long glVertexAttribI3i;
    long glVertexAttribI4i;
    long glVertexAttribI1ui;
    long glVertexAttribI2ui;
    long glVertexAttribI3ui;
    long glVertexAttribI4ui;
    long glVertexAttribI1iv;
    long glVertexAttribI2iv;
    long glVertexAttribI3iv;
    long glVertexAttribI4iv;
    long glVertexAttribI1uiv;
    long glVertexAttribI2uiv;
    long glVertexAttribI3uiv;
    long glVertexAttribI4uiv;
    long glVertexAttribI4bv;
    long glVertexAttribI4sv;
    long glVertexAttribI4ubv;
    long glVertexAttribI4usv;
    long glVertexAttribIPointer;
    long glGetVertexAttribIiv;
    long glGetVertexAttribIuiv;
    long glUniform1ui;
    long glUniform2ui;
    long glUniform3ui;
    long glUniform4ui;
    long glUniform1uiv;
    long glUniform2uiv;
    long glUniform3uiv;
    long glUniform4uiv;
    long glGetUniformuiv;
    long glBindFragDataLocation;
    long glGetFragDataLocation;
    long glBeginConditionalRender;
    long glEndConditionalRender;
    long glMapBufferRange;
    long glFlushMappedBufferRange;
    long glClampColor;
    long glIsRenderbuffer;
    long glBindRenderbuffer;
    long glDeleteRenderbuffers;
    long glGenRenderbuffers;
    long glRenderbufferStorage;
    long glGetRenderbufferParameteriv;
    long glIsFramebuffer;
    long glBindFramebuffer;
    long glDeleteFramebuffers;
    long glGenFramebuffers;
    long glCheckFramebufferStatus;
    long glFramebufferTexture1D;
    long glFramebufferTexture2D;
    long glFramebufferTexture3D;
    long glFramebufferRenderbuffer;
    long glGetFramebufferAttachmentParameteriv;
    long glGenerateMipmap;
    long glRenderbufferStorageMultisample;
    long glBlitFramebuffer;
    long glTexParameterIiv;
    long glTexParameterIuiv;
    long glGetTexParameterIiv;
    long glGetTexParameterIuiv;
    long glFramebufferTextureLayer;
    long glColorMaski;
    long glGetBooleani_v;
    long glGetIntegeri_v;
    long glEnablei;
    long glDisablei;
    long glIsEnabledi;
    long glBindBufferRange;
    long glBindBufferBase;
    long glBeginTransformFeedback;
    long glEndTransformFeedback;
    long glTransformFeedbackVaryings;
    long glGetTransformFeedbackVarying;
    long glBindVertexArray;
    long glDeleteVertexArrays;
    long glGenVertexArrays;
    long glIsVertexArray;
    // GL31
    long glDrawArraysInstanced;
    long glDrawElementsInstanced;
    long glCopyBufferSubData;
    long glPrimitiveRestartIndex;
    long glTexBuffer;
    long glGetUniformIndices;
    long glGetActiveUniformsiv;
    long glGetActiveUniformName;
    long glGetUniformBlockIndex;
    long glGetActiveUniformBlockiv;
    long glGetActiveUniformBlockName;
    long glUniformBlockBinding;
    // GL32
    long glGetBufferParameteri64v;
    long glDrawElementsBaseVertex;
    long glDrawRangeElementsBaseVertex;
    long glDrawElementsInstancedBaseVertex;
    long glProvokingVertex;
    long glTexImage2DMultisample;
    long glTexImage3DMultisample;
    long glGetMultisamplefv;
    long glSampleMaski;
    long glFramebufferTexture;
    long glFenceSync;
    long glIsSync;
    long glDeleteSync;
    long glClientWaitSync;
    long glWaitSync;
    long glGetInteger64v;
    long glGetInteger64i_v;
    long glGetSynciv;
    // GL33
    long glBindFragDataLocationIndexed;
    long glGetFragDataIndex;
    long glGenSamplers;
    long glDeleteSamplers;
    long glIsSampler;
    long glBindSampler;
    long glSamplerParameteri;
    long glSamplerParameterf;
    long glSamplerParameteriv;
    long glSamplerParameterfv;
    long glSamplerParameterIiv;
    long glSamplerParameterIuiv;
    long glGetSamplerParameteriv;
    long glGetSamplerParameterfv;
    long glGetSamplerParameterIiv;
    long glGetSamplerParameterIuiv;
    long glQueryCounter;
    long glGetQueryObjecti64v;
    long glGetQueryObjectui64v;
    long glVertexAttribDivisor;
    long glVertexP2ui;
    long glVertexP3ui;
    long glVertexP4ui;
    long glVertexP2uiv;
    long glVertexP3uiv;
    long glVertexP4uiv;
    long glTexCoordP1ui;
    long glTexCoordP2ui;
    long glTexCoordP3ui;
    long glTexCoordP4ui;
    long glTexCoordP1uiv;
    long glTexCoordP2uiv;
    long glTexCoordP3uiv;
    long glTexCoordP4uiv;
    long glMultiTexCoordP1ui;
    long glMultiTexCoordP2ui;
    long glMultiTexCoordP3ui;
    long glMultiTexCoordP4ui;
    long glMultiTexCoordP1uiv;
    long glMultiTexCoordP2uiv;
    long glMultiTexCoordP3uiv;
    long glMultiTexCoordP4uiv;
    long glNormalP3ui;
    long glNormalP3uiv;
    long glColorP3ui;
    long glColorP4ui;
    long glColorP3uiv;
    long glColorP4uiv;
    long glSecondaryColorP3ui;
    long glSecondaryColorP3uiv;
    long glVertexAttribP1ui;
    long glVertexAttribP2ui;
    long glVertexAttribP3ui;
    long glVertexAttribP4ui;
    long glVertexAttribP1uiv;
    long glVertexAttribP2uiv;
    long glVertexAttribP3uiv;
    long glVertexAttribP4uiv;
    // GL40
    long glBlendEquationi;
    long glBlendEquationSeparatei;
    long glBlendFunci;
    long glBlendFuncSeparatei;
    long glDrawArraysIndirect;
    long glDrawElementsIndirect;
    long glUniform1d;
    long glUniform2d;
    long glUniform3d;
    long glUniform4d;
    long glUniform1dv;
    long glUniform2dv;
    long glUniform3dv;
    long glUniform4dv;
    long glUniformMatrix2dv;
    long glUniformMatrix3dv;
    long glUniformMatrix4dv;
    long glUniformMatrix2x3dv;
    long glUniformMatrix2x4dv;
    long glUniformMatrix3x2dv;
    long glUniformMatrix3x4dv;
    long glUniformMatrix4x2dv;
    long glUniformMatrix4x3dv;
    long glGetUniformdv;
    long glMinSampleShading;
    long glGetSubroutineUniformLocation;
    long glGetSubroutineIndex;
    long glGetActiveSubroutineUniformiv;
    long glGetActiveSubroutineUniformName;
    long glGetActiveSubroutineName;
    long glUniformSubroutinesuiv;
    long glGetUniformSubroutineuiv;
    long glGetProgramStageiv;
    long glPatchParameteri;
    long glPatchParameterfv;
    long glBindTransformFeedback;
    long glDeleteTransformFeedbacks;
    long glGenTransformFeedbacks;
    long glIsTransformFeedback;
    long glPauseTransformFeedback;
    long glResumeTransformFeedback;
    long glDrawTransformFeedback;
    long glDrawTransformFeedbackStream;
    long glBeginQueryIndexed;
    long glEndQueryIndexed;
    long glGetQueryIndexediv;
    // GL41
    long glReleaseShaderCompiler;
    long glShaderBinary;
    long glGetShaderPrecisionFormat;
    long glDepthRangef;
    long glClearDepthf;
    long glGetProgramBinary;
    long glProgramBinary;
    long glProgramParameteri;
    long glUseProgramStages;
    long glActiveShaderProgram;
    long glCreateShaderProgramv;
    long glBindProgramPipeline;
    long glDeleteProgramPipelines;
    long glGenProgramPipelines;
    long glIsProgramPipeline;
    long glGetProgramPipelineiv;
    long glProgramUniform1i;
    long glProgramUniform2i;
    long glProgramUniform3i;
    long glProgramUniform4i;
    long glProgramUniform1f;
    long glProgramUniform2f;
    long glProgramUniform3f;
    long glProgramUniform4f;
    long glProgramUniform1d;
    long glProgramUniform2d;
    long glProgramUniform3d;
    long glProgramUniform4d;
    long glProgramUniform1iv;
    long glProgramUniform2iv;
    long glProgramUniform3iv;
    long glProgramUniform4iv;
    long glProgramUniform1fv;
    long glProgramUniform2fv;
    long glProgramUniform3fv;
    long glProgramUniform4fv;
    long glProgramUniform1dv;
    long glProgramUniform2dv;
    long glProgramUniform3dv;
    long glProgramUniform4dv;
    long glProgramUniform1ui;
    long glProgramUniform2ui;
    long glProgramUniform3ui;
    long glProgramUniform4ui;
    long glProgramUniform1uiv;
    long glProgramUniform2uiv;
    long glProgramUniform3uiv;
    long glProgramUniform4uiv;
    long glProgramUniformMatrix2fv;
    long glProgramUniformMatrix3fv;
    long glProgramUniformMatrix4fv;
    long glProgramUniformMatrix2dv;
    long glProgramUniformMatrix3dv;
    long glProgramUniformMatrix4dv;
    long glProgramUniformMatrix2x3fv;
    long glProgramUniformMatrix3x2fv;
    long glProgramUniformMatrix2x4fv;
    long glProgramUniformMatrix4x2fv;
    long glProgramUniformMatrix3x4fv;
    long glProgramUniformMatrix4x3fv;
    long glProgramUniformMatrix2x3dv;
    long glProgramUniformMatrix3x2dv;
    long glProgramUniformMatrix2x4dv;
    long glProgramUniformMatrix4x2dv;
    long glProgramUniformMatrix3x4dv;
    long glProgramUniformMatrix4x3dv;
    long glValidateProgramPipeline;
    long glGetProgramPipelineInfoLog;
    long glVertexAttribL1d;
    long glVertexAttribL2d;
    long glVertexAttribL3d;
    long glVertexAttribL4d;
    long glVertexAttribL1dv;
    long glVertexAttribL2dv;
    long glVertexAttribL3dv;
    long glVertexAttribL4dv;
    long glVertexAttribLPointer;
    long glGetVertexAttribLdv;
    long glViewportArrayv;
    long glViewportIndexedf;
    long glViewportIndexedfv;
    long glScissorArrayv;
    long glScissorIndexed;
    long glScissorIndexedv;
    long glDepthRangeArrayv;
    long glDepthRangeIndexed;
    long glGetFloati_v;
    long glGetDoublei_v;
    // GL42
    long glGetActiveAtomicCounterBufferiv;
    long glTexStorage1D;
    long glTexStorage2D;
    long glTexStorage3D;
    long glDrawTransformFeedbackInstanced;
    long glDrawTransformFeedbackStreamInstanced;
    long glDrawArraysInstancedBaseInstance;
    long glDrawElementsInstancedBaseInstance;
    long glDrawElementsInstancedBaseVertexBaseInstance;
    long glBindImageTexture;
    long glMemoryBarrier;
    long glGetInternalformativ;
    // GL43
    long glClearBufferData;
    long glClearBufferSubData;
    long glDispatchCompute;
    long glDispatchComputeIndirect;
    long glCopyImageSubData;
    long glDebugMessageControl;
    long glDebugMessageInsert;
    long glDebugMessageCallback;
    long glGetDebugMessageLog;
    long glPushDebugGroup;
    long glPopDebugGroup;
    long glObjectLabel;
    long glGetObjectLabel;
    long glObjectPtrLabel;
    long glGetObjectPtrLabel;
    long glFramebufferParameteri;
    long glGetFramebufferParameteriv;
    long glGetInternalformati64v;
    long glInvalidateTexSubImage;
    long glInvalidateTexImage;
    long glInvalidateBufferSubData;
    long glInvalidateBufferData;
    long glInvalidateFramebuffer;
    long glInvalidateSubFramebuffer;
    long glMultiDrawArraysIndirect;
    long glMultiDrawElementsIndirect;
    long glGetProgramInterfaceiv;
    long glGetProgramResourceIndex;
    long glGetProgramResourceName;
    long glGetProgramResourceiv;
    long glGetProgramResourceLocation;
    long glGetProgramResourceLocationIndex;
    long glShaderStorageBlockBinding;
    long glTexBufferRange;
    long glTexStorage2DMultisample;
    long glTexStorage3DMultisample;
    long glTextureView;
    long glBindVertexBuffer;
    long glVertexAttribFormat;
    long glVertexAttribIFormat;
    long glVertexAttribLFormat;
    long glVertexAttribBinding;
    long glVertexBindingDivisor;
    // GL44
    long glBufferStorage;
    long glClearTexImage;
    long glClearTexSubImage;
    long glBindBuffersBase;
    long glBindBuffersRange;
    long glBindTextures;
    long glBindSamplers;
    long glBindImageTextures;
    long glBindVertexBuffers;
    // GL45
    long glClipControl;
    long glCreateTransformFeedbacks;
    long glTransformFeedbackBufferBase;
    long glTransformFeedbackBufferRange;
    long glGetTransformFeedbackiv;
    long glGetTransformFeedbacki_v;
    long glGetTransformFeedbacki64_v;
    long glCreateBuffers;
    long glNamedBufferStorage;
    long glNamedBufferData;
    long glNamedBufferSubData;
    long glCopyNamedBufferSubData;
    long glClearNamedBufferData;
    long glClearNamedBufferSubData;
    long glMapNamedBuffer;
    long glMapNamedBufferRange;
    long glUnmapNamedBuffer;
    long glFlushMappedNamedBufferRange;
    long glGetNamedBufferParameteriv;
    long glGetNamedBufferParameteri64v;
    long glGetNamedBufferPointerv;
    long glGetNamedBufferSubData;
    long glCreateFramebuffers;
    long glNamedFramebufferRenderbuffer;
    long glNamedFramebufferParameteri;
    long glNamedFramebufferTexture;
    long glNamedFramebufferTextureLayer;
    long glNamedFramebufferDrawBuffer;
    long glNamedFramebufferDrawBuffers;
    long glNamedFramebufferReadBuffer;
    long glInvalidateNamedFramebufferData;
    long glInvalidateNamedFramebufferSubData;
    long glClearNamedFramebufferiv;
    long glClearNamedFramebufferuiv;
    long glClearNamedFramebufferfv;
    long glClearNamedFramebufferfi;
    long glBlitNamedFramebuffer;
    long glCheckNamedFramebufferStatus;
    long glGetNamedFramebufferParameteriv;
    long glGetNamedFramebufferAttachmentParameteriv;
    long glCreateRenderbuffers;
    long glNamedRenderbufferStorage;
    long glNamedRenderbufferStorageMultisample;
    long glGetNamedRenderbufferParameteriv;
    long glCreateTextures;
    long glTextureBuffer;
    long glTextureBufferRange;
    long glTextureStorage1D;
    long glTextureStorage2D;
    long glTextureStorage3D;
    long glTextureStorage2DMultisample;
    long glTextureStorage3DMultisample;
    long glTextureSubImage1D;
    long glTextureSubImage2D;
    long glTextureSubImage3D;
    long glCompressedTextureSubImage1D;
    long glCompressedTextureSubImage2D;
    long glCompressedTextureSubImage3D;
    long glCopyTextureSubImage1D;
    long glCopyTextureSubImage2D;
    long glCopyTextureSubImage3D;
    long glTextureParameterf;
    long glTextureParameterfv;
    long glTextureParameteri;
    long glTextureParameterIiv;
    long glTextureParameterIuiv;
    long glTextureParameteriv;
    long glGenerateTextureMipmap;
    long glBindTextureUnit;
    long glGetTextureImage;
    long glGetCompressedTextureImage;
    long glGetTextureLevelParameterfv;
    long glGetTextureLevelParameteriv;
    long glGetTextureParameterfv;
    long glGetTextureParameterIiv;
    long glGetTextureParameterIuiv;
    long glGetTextureParameteriv;
    long glCreateVertexArrays;
    long glDisableVertexArrayAttrib;
    long glEnableVertexArrayAttrib;
    long glVertexArrayElementBuffer;
    long glVertexArrayVertexBuffer;
    long glVertexArrayVertexBuffers;
    long glVertexArrayAttribFormat;
    long glVertexArrayAttribIFormat;
    long glVertexArrayAttribLFormat;
    long glVertexArrayAttribBinding;
    long glVertexArrayBindingDivisor;
    long glGetVertexArrayiv;
    long glGetVertexArrayIndexediv;
    long glGetVertexArrayIndexed64iv;
    long glCreateSamplers;
    long glCreateProgramPipelines;
    long glCreateQueries;
    long glMemoryBarrierByRegion;
    long glGetTextureSubImage;
    long glGetCompressedTextureSubImage;
    long glTextureBarrier;
    long glGetGraphicsResetStatus;
    long glReadnPixels;
    long glGetnUniformfv;
    long glGetnUniformiv;
    long glGetnUniformuiv;
    // GREMEDY_frame_terminator
    long glFrameTerminatorGREMEDY;
    // GREMEDY_string_marker
    long glStringMarkerGREMEDY;
    // INTEL_map_texture
    long glMapTexture2DINTEL;
    long glUnmapTexture2DINTEL;
    long glSyncTextureINTEL;
    // NV_bindless_multi_draw_indirect
    long glMultiDrawArraysIndirectBindlessNV;
    long glMultiDrawElementsIndirectBindlessNV;
    // NV_bindless_texture
    long glGetTextureHandleNV;
    long glGetTextureSamplerHandleNV;
    long glMakeTextureHandleResidentNV;
    long glMakeTextureHandleNonResidentNV;
    long glGetImageHandleNV;
    long glMakeImageHandleResidentNV;
    long glMakeImageHandleNonResidentNV;
    long glUniformHandleui64NV;
    long glUniformHandleui64vNV;
    long glProgramUniformHandleui64NV;
    long glProgramUniformHandleui64vNV;
    long glIsTextureHandleResidentNV;
    long glIsImageHandleResidentNV;
    // NV_blend_equation_advanced
    long glBlendParameteriNV;
    long glBlendBarrierNV;
    // NV_conditional_render
    long glBeginConditionalRenderNV;
    long glEndConditionalRenderNV;
    // NV_copy_image
    long glCopyImageSubDataNV;
    // NV_depth_buffer_float
    long glDepthRangedNV;
    long glClearDepthdNV;
    long glDepthBoundsdNV;
    // NV_draw_texture
    long glDrawTextureNV;
    // NV_evaluators
    long glGetMapControlPointsNV;
    long glMapControlPointsNV;
    long glMapParameterfvNV;
    long glMapParameterivNV;
    long glGetMapParameterfvNV;
    long glGetMapParameterivNV;
    long glGetMapAttribParameterfvNV;
    long glGetMapAttribParameterivNV;
    long glEvalMapsNV;
    // NV_explicit_multisample
    long glGetMultisamplefvNV;
    long glSampleMaskIndexedNV;
    long glTexRenderbufferNV;
    // NV_fence
    long glGenFencesNV;
    long glDeleteFencesNV;
    long glSetFenceNV;
    long glTestFenceNV;
    long glFinishFenceNV;
    long glIsFenceNV;
    long glGetFenceivNV;
    // NV_fragment_program
    long glProgramNamedParameter4fNV;
    long glProgramNamedParameter4dNV;
    long glGetProgramNamedParameterfvNV;
    long glGetProgramNamedParameterdvNV;
    // NV_framebuffer_multisample_coverage
    long glRenderbufferStorageMultisampleCoverageNV;
    // NV_geometry_program4
    long glProgramVertexLimitNV;
    // NV_gpu_program4
    long glProgramLocalParameterI4iNV;
    long glProgramLocalParameterI4ivNV;
    long glProgramLocalParametersI4ivNV;
    long glProgramLocalParameterI4uiNV;
    long glProgramLocalParameterI4uivNV;
    long glProgramLocalParametersI4uivNV;
    long glProgramEnvParameterI4iNV;
    long glProgramEnvParameterI4ivNV;
    long glProgramEnvParametersI4ivNV;
    long glProgramEnvParameterI4uiNV;
    long glProgramEnvParameterI4uivNV;
    long glProgramEnvParametersI4uivNV;
    long glGetProgramLocalParameterIivNV;
    long glGetProgramLocalParameterIuivNV;
    long glGetProgramEnvParameterIivNV;
    long glGetProgramEnvParameterIuivNV;
    // NV_gpu_shader5
    long glUniform1i64NV;
    long glUniform2i64NV;
    long glUniform3i64NV;
    long glUniform4i64NV;
    long glUniform1i64vNV;
    long glUniform2i64vNV;
    long glUniform3i64vNV;
    long glUniform4i64vNV;
    long glUniform1ui64NV;
    long glUniform2ui64NV;
    long glUniform3ui64NV;
    long glUniform4ui64NV;
    long glUniform1ui64vNV;
    long glUniform2ui64vNV;
    long glUniform3ui64vNV;
    long glUniform4ui64vNV;
    long glGetUniformi64vNV;
    long glGetUniformui64vNV;
    long glProgramUniform1i64NV;
    long glProgramUniform2i64NV;
    long glProgramUniform3i64NV;
    long glProgramUniform4i64NV;
    long glProgramUniform1i64vNV;
    long glProgramUniform2i64vNV;
    long glProgramUniform3i64vNV;
    long glProgramUniform4i64vNV;
    long glProgramUniform1ui64NV;
    long glProgramUniform2ui64NV;
    long glProgramUniform3ui64NV;
    long glProgramUniform4ui64NV;
    long glProgramUniform1ui64vNV;
    long glProgramUniform2ui64vNV;
    long glProgramUniform3ui64vNV;
    long glProgramUniform4ui64vNV;
    // NV_half_float
    long glVertex2hNV;
    long glVertex3hNV;
    long glVertex4hNV;
    long glNormal3hNV;
    long glColor3hNV;
    long glColor4hNV;
    long glTexCoord1hNV;
    long glTexCoord2hNV;
    long glTexCoord3hNV;
    long glTexCoord4hNV;
    long glMultiTexCoord1hNV;
    long glMultiTexCoord2hNV;
    long glMultiTexCoord3hNV;
    long glMultiTexCoord4hNV;
    long glFogCoordhNV;
    long glSecondaryColor3hNV;
    long glVertexWeighthNV;
    long glVertexAttrib1hNV;
    long glVertexAttrib2hNV;
    long glVertexAttrib3hNV;
    long glVertexAttrib4hNV;
    long glVertexAttribs1hvNV;
    long glVertexAttribs2hvNV;
    long glVertexAttribs3hvNV;
    long glVertexAttribs4hvNV;
    // NV_occlusion_query
    long glGenOcclusionQueriesNV;
    long glDeleteOcclusionQueriesNV;
    long glIsOcclusionQueryNV;
    long glBeginOcclusionQueryNV;
    long glEndOcclusionQueryNV;
    long glGetOcclusionQueryuivNV;
    long glGetOcclusionQueryivNV;
    // NV_parameter_buffer_object
    long glProgramBufferParametersfvNV;
    long glProgramBufferParametersIivNV;
    long glProgramBufferParametersIuivNV;
    // NV_path_rendering
    long glPathCommandsNV;
    long glPathCoordsNV;
    long glPathSubCommandsNV;
    long glPathSubCoordsNV;
    long glPathStringNV;
    long glPathGlyphsNV;
    long glPathGlyphRangeNV;
    long glWeightPathsNV;
    long glCopyPathNV;
    long glInterpolatePathsNV;
    long glTransformPathNV;
    long glPathParameterivNV;
    long glPathParameteriNV;
    long glPathParameterfvNV;
    long glPathParameterfNV;
    long glPathDashArrayNV;
    long glGenPathsNV;
    long glDeletePathsNV;
    long glIsPathNV;
    long glPathStencilFuncNV;
    long glPathStencilDepthOffsetNV;
    long glStencilFillPathNV;
    long glStencilStrokePathNV;
    long glStencilFillPathInstancedNV;
    long glStencilStrokePathInstancedNV;
    long glPathCoverDepthFuncNV;
    long glPathColorGenNV;
    long glPathTexGenNV;
    long glPathFogGenNV;
    long glCoverFillPathNV;
    long glCoverStrokePathNV;
    long glCoverFillPathInstancedNV;
    long glCoverStrokePathInstancedNV;
    long glGetPathParameterivNV;
    long glGetPathParameterfvNV;
    long glGetPathCommandsNV;
    long glGetPathCoordsNV;
    long glGetPathDashArrayNV;
    long glGetPathMetricsNV;
    long glGetPathMetricRangeNV;
    long glGetPathSpacingNV;
    long glGetPathColorGenivNV;
    long glGetPathColorGenfvNV;
    long glGetPathTexGenivNV;
    long glGetPathTexGenfvNV;
    long glIsPointInFillPathNV;
    long glIsPointInStrokePathNV;
    long glGetPathLengthNV;
    long glPointAlongPathNV;
    // NV_pixel_data_range
    long glPixelDataRangeNV;
    long glFlushPixelDataRangeNV;
    // NV_point_sprite
    long glPointParameteriNV;
    long glPointParameterivNV;
    // NV_present_video
    long glPresentFrameKeyedNV;
    long glPresentFrameDualFillNV;
    long glGetVideoivNV;
    long glGetVideouivNV;
    long glGetVideoi64vNV;
    long glGetVideoui64vNV;
    // NV_primitive_restart
    long glPrimitiveRestartNV;
    long glPrimitiveRestartIndexNV;
    // NV_program
    long glLoadProgramNV;
    long glBindProgramNV;
    long glDeleteProgramsNV;
    long glGenProgramsNV;
    long glGetProgramivNV;
    long glGetProgramStringNV;
    long glIsProgramNV;
    long glAreProgramsResidentNV;
    long glRequestResidentProgramsNV;
    // NV_register_combiners
    long glCombinerParameterfNV;
    long glCombinerParameterfvNV;
    long glCombinerParameteriNV;
    long glCombinerParameterivNV;
    long glCombinerInputNV;
    long glCombinerOutputNV;
    long glFinalCombinerInputNV;
    long glGetCombinerInputParameterfvNV;
    long glGetCombinerInputParameterivNV;
    long glGetCombinerOutputParameterfvNV;
    long glGetCombinerOutputParameterivNV;
    long glGetFinalCombinerInputParameterfvNV;
    long glGetFinalCombinerInputParameterivNV;
    // NV_register_combiners2
    long glCombinerStageParameterfvNV;
    long glGetCombinerStageParameterfvNV;
    // NV_shader_buffer_load
    long glMakeBufferResidentNV;
    long glMakeBufferNonResidentNV;
    long glIsBufferResidentNV;
    long glMakeNamedBufferResidentNV;
    long glMakeNamedBufferNonResidentNV;
    long glIsNamedBufferResidentNV;
    long glGetBufferParameterui64vNV;
    long glGetNamedBufferParameterui64vNV;
    long glGetIntegerui64vNV;
    long glUniformui64NV;
    long glUniformui64vNV;
    long glProgramUniformui64NV;
    long glProgramUniformui64vNV;
    // NV_texture_barrier
    long glTextureBarrierNV;
    // NV_texture_multisample
    long glTexImage2DMultisampleCoverageNV;
    long glTexImage3DMultisampleCoverageNV;
    long glTextureImage2DMultisampleNV;
    long glTextureImage3DMultisampleNV;
    long glTextureImage2DMultisampleCoverageNV;
    long glTextureImage3DMultisampleCoverageNV;
    // NV_transform_feedback
    long glBindBufferRangeNV;
    long glBindBufferOffsetNV;
    long glBindBufferBaseNV;
    long glTransformFeedbackAttribsNV;
    long glTransformFeedbackVaryingsNV;
    long glBeginTransformFeedbackNV;
    long glEndTransformFeedbackNV;
    long glGetVaryingLocationNV;
    long glGetActiveVaryingNV;
    long glActiveVaryingNV;
    long glGetTransformFeedbackVaryingNV;
    // NV_transform_feedback2
    long glBindTransformFeedbackNV;
    long glDeleteTransformFeedbacksNV;
    long glGenTransformFeedbacksNV;
    long glIsTransformFeedbackNV;
    long glPauseTransformFeedbackNV;
    long glResumeTransformFeedbackNV;
    long glDrawTransformFeedbackNV;
    // NV_vertex_array_range
    long glVertexArrayRangeNV;
    long glFlushVertexArrayRangeNV;
    long glAllocateMemoryNV;
    long glFreeMemoryNV;
    // NV_vertex_attrib_integer_64bit
    long glVertexAttribL1i64NV;
    long glVertexAttribL2i64NV;
    long glVertexAttribL3i64NV;
    long glVertexAttribL4i64NV;
    long glVertexAttribL1i64vNV;
    long glVertexAttribL2i64vNV;
    long glVertexAttribL3i64vNV;
    long glVertexAttribL4i64vNV;
    long glVertexAttribL1ui64NV;
    long glVertexAttribL2ui64NV;
    long glVertexAttribL3ui64NV;
    long glVertexAttribL4ui64NV;
    long glVertexAttribL1ui64vNV;
    long glVertexAttribL2ui64vNV;
    long glVertexAttribL3ui64vNV;
    long glVertexAttribL4ui64vNV;
    long glGetVertexAttribLi64vNV;
    long glGetVertexAttribLui64vNV;
    long glVertexAttribLFormatNV;
    // NV_vertex_buffer_unified_memory
    long glBufferAddressRangeNV;
    long glVertexFormatNV;
    long glNormalFormatNV;
    long glColorFormatNV;
    long glIndexFormatNV;
    long glTexCoordFormatNV;
    long glEdgeFlagFormatNV;
    long glSecondaryColorFormatNV;
    long glFogCoordFormatNV;
    long glVertexAttribFormatNV;
    long glVertexAttribIFormatNV;
    long glGetIntegerui64i_vNV;
    // NV_vertex_program
    long glExecuteProgramNV;
    long glGetProgramParameterfvNV;
    long glGetProgramParameterdvNV;
    long glGetTrackMatrixivNV;
    long glGetVertexAttribfvNV;
    long glGetVertexAttribdvNV;
    long glGetVertexAttribivNV;
    long glGetVertexAttribPointervNV;
    long glProgramParameter4fNV;
    long glProgramParameter4dNV;
    long glProgramParameters4fvNV;
    long glProgramParameters4dvNV;
    long glTrackMatrixNV;
    long glVertexAttribPointerNV;
    long glVertexAttrib1sNV;
    long glVertexAttrib1fNV;
    long glVertexAttrib1dNV;
    long glVertexAttrib2sNV;
    long glVertexAttrib2fNV;
    long glVertexAttrib2dNV;
    long glVertexAttrib3sNV;
    long glVertexAttrib3fNV;
    long glVertexAttrib3dNV;
    long glVertexAttrib4sNV;
    long glVertexAttrib4fNV;
    long glVertexAttrib4dNV;
    long glVertexAttrib4ubNV;
    long glVertexAttribs1svNV;
    long glVertexAttribs1fvNV;
    long glVertexAttribs1dvNV;
    long glVertexAttribs2svNV;
    long glVertexAttribs2fvNV;
    long glVertexAttribs2dvNV;
    long glVertexAttribs3svNV;
    long glVertexAttribs3fvNV;
    long glVertexAttribs3dvNV;
    long glVertexAttribs4svNV;
    long glVertexAttribs4fvNV;
    long glVertexAttribs4dvNV;
    // NV_video_capture
    long glBeginVideoCaptureNV;
    long glBindVideoCaptureStreamBufferNV;
    long glBindVideoCaptureStreamTextureNV;
    long glEndVideoCaptureNV;
    long glGetVideoCaptureivNV;
    long glGetVideoCaptureStreamivNV;
    long glGetVideoCaptureStreamfvNV;
    long glGetVideoCaptureStreamdvNV;
    long glVideoCaptureNV;
    long glVideoCaptureStreamParameterivNV;
    long glVideoCaptureStreamParameterfvNV;
    long glVideoCaptureStreamParameterdvNV;

    ContextCapabilities(boolean forwardCompatible) throws LWJGLException {
        try {
            GLCapabilities capabilities = GL.getCapabilities();
            Field[] theirFields = GLCapabilities.class.getDeclaredFields();
            Field[] ourFields = ContextCapabilities.class.getDeclaredFields();
            for (Field ourField : ourFields) {
                int mods = ourField.getModifiers();
                if (ourField.getType() == Boolean.TYPE && !Modifier.isStatic(mods) &&
                        Modifier.isPublic(mods) && !Modifier.isFinal(mods)) {

                    String name = ourField.getName();
                    Field theirField = Arrays.stream(theirFields).filter(it -> it.getName().equals(name)).findFirst().orElse(null);
                    if (theirField != null) {
                        ourField.setBoolean(this, theirField.getBoolean(capabilities));
                    }
                }
            }
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    static long getPlatformSpecificFunctionAddress(String function_prefix, String[] os_prefixes, String[] os_function_prefixes, String function) {
        String os_name = System.getProperty("os.name");
        for (int i = 0; i < os_prefixes.length; i++)
            if (os_name.startsWith(os_prefixes[i])) {
                String platform_function_name = function.replaceFirst(function_prefix, os_function_prefixes[i]);
                long address = GL.getFunctionProvider().getFunctionAddress(platform_function_name);
                return address;
            }
        return 0;
    }

    static int getSupportedExtensions(final Set<String> supported_extensions) {
        // Detect OpenGL version first

        final String version = glGetString(GL_VERSION);
        if (version == null)
            throw new IllegalStateException("glGetString(GL_VERSION) returned null - possibly caused by missing current context.");

        final StringTokenizer version_tokenizer = new StringTokenizer(version, ". ");
        final String major_string = version_tokenizer.nextToken();
        final String minor_string = version_tokenizer.nextToken();

        int majorVersion = 0;
        int minorVersion = 0;
        try {
            majorVersion = Integer.parseInt(major_string);
            minorVersion = Integer.parseInt(minor_string);
        } catch (NumberFormatException e) {
            LWJGLUtil.log("The major and/or minor OpenGL version is malformed: " + e.getMessage());
        }

        final int[][] GL_VERSIONS = {
                {1, 2, 3, 4, 5},      // OpenGL 1
                {0, 1},               // OpenGL 2
                {0, 1, 2, 3},         // OpenGL 3
                {0, 1, 2, 3, 4, 5},   // OpenGL 4
        };

        for (int major = 1; major <= GL_VERSIONS.length; major++) {
            int[] minors = GL_VERSIONS[major - 1];
            for (int minor : minors) {
                if (major < majorVersion || (major == majorVersion && minor <= minorVersion))
                    supported_extensions.add("OpenGL" + Integer.toString(major) + Integer.toString(minor));
            }
        }

        int profileMask = 0;

        if (majorVersion < 3) {
            // Parse EXTENSIONS string
            final String extensions_string = glGetString(GL_EXTENSIONS);
            if (extensions_string == null)
                throw new IllegalStateException("glGetString(GL_EXTENSIONS) returned null - is there a context current?");

            final StringTokenizer tokenizer = new StringTokenizer(extensions_string);
            while (tokenizer.hasMoreTokens())
                supported_extensions.add(tokenizer.nextToken());
        } else {
            // Use forward compatible indexed EXTENSIONS
            final int extensionCount = glGetInteger(GL_NUM_EXTENSIONS);

            for (int i = 0; i < extensionCount; i++)
                supported_extensions.add(glGetStringi(GL_EXTENSIONS, i));

            // Get the context profile mask for versions >= 3.2
            if (3 < majorVersion || 2 <= minorVersion) {
                Util.checkGLError(); // Make sure we have no errors up to this point

                try {
                    profileMask = glGetInteger(GL_CONTEXT_PROFILE_MASK);
                    // Retrieving GL_CONTEXT_PROFILE_MASK may generate an INVALID_OPERATION error on certain implementations, ignore.
                    // Happens on pre10.1 ATI drivers, when ContextAttribs.withProfileCompatibility is not used
                    Util.checkGLError();
                } catch (OpenGLException e) {
                    LWJGLUtil.log("Failed to retrieve CONTEXT_PROFILE_MASK");
                }
            }
        }

        return profileMask;
    }

    static void unloadAllStubs() {
    }
}