/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import ru.metaculture.protection.ShaderCompileResult;
import ru.metaculture.protection.NodePort;
import ru.metaculture.protection.NuuUuvvuVV;
import ru.metaculture.protection.NodeInstance;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.ShaderUniformParam;
import ru.metaculture.protection.NodeConnection;
import ru.metaculture.protection.UniformType;
import ru.metaculture.protection.NodeGraph;
import ru.metaculture.protection.NodeDefinitionRegistry;
import ru.metaculture.protection.NodeDefinition;

public final class NodeGraphCompiler {
    private static volatile Function<SurfaceTarget, String> primaryVal;
    private final NodeDefinitionRegistry secondaryVal;

    public NodeGraphCompiler(NodeDefinitionRegistry nodeI) {
        this.secondaryVal = nodeI;
    }

    public static void primaryVal(Function<SurfaceTarget, String> function) {
        primaryVal = function;
    }

    private static String secondaryVal(SurfaceTarget vnuVUNUv) {
        Function<SurfaceTarget, String> function = primaryVal;
        if (function == null) {
            return "";
        }
        String string = function.apply(vnuVUNUv);
        return string == null ? "" : string;
    }

    public ShaderCompileResult primaryVal(NodeGraph nuVVnvn2) {
        return this.primaryVal(nuVVnvn2, null, null, null, SurfaceTarget.primaryVal(nuVVnvn2 == null ? null : nuVVnvn2.secondaryVal()).marginVal());
    }

    public ShaderCompileResult primaryVal(NodeGraph nuVVnvn2, String string, String string2, UniformType baseF) {
        return this.primaryVal(nuVVnvn2, string, string2, baseF, SurfaceTarget.PREVIEW_ONLY);
    }

    private ShaderCompileResult primaryVal(NodeGraph nuVVnvn2, String string, String string2, UniformType baseF, SurfaceTarget vnuVUNUv) {
        SurfaceTarget vnuVUNUv2 = vnuVUNUv == null ? SurfaceTarget.PREVIEW_ONLY : vnuVUNUv.marginVal();
        try {
            List<NodeInstance> list = this.secondaryVal(nuVVnvn2);
            HashMap<String, String> hashMap = new HashMap<String, String>();
            HashMap<String, String> hashMap2 = new HashMap<String, String>();
            List<ShaderUniformParam> list2 = this.primaryVal(list, hashMap2);
            NuuUuvvuVV nuuUuvvuVV = new NuuUuvvuVV(nuVVnvn2, this.secondaryVal, hashMap, hashMap2, vnuVUNUv2);
            StringBuilder stringBuilder = new StringBuilder(4096);
            String string3 = "vec4(0.02, 0.022, 0.028, 1.0)";
            for (NodeInstance queueVal : list) {
                NodeDefinition spanJ = this.secondaryVal.primaryVal(queueVal.secondaryVal());
                if (spanJ == null) {
                    return new ShaderCompileResult(this.primaryVal(vnuVUNUv2), "invalid", "Unknown node: " + queueVal.secondaryVal());
                }
                if ("output_color".equals(spanJ.primaryVal())) {
                    if (string != null && !string.equals(queueVal.primaryVal())) continue;
                    string3 = spanJ.extraVal().emit(nuuUuvvuVV, queueVal, "color");
                    continue;
                }
                for (NodePort cellA : spanJ.paramVal()) {
                    String string4 = nuuUuvvuVV.secondaryVal(queueVal, cellA.id());
                    String string5 = spanJ.extraVal().emit(nuuUuvvuVV, queueVal, cellA.id());
                    stringBuilder.append("    ").append(cellA.type().primaryVal()).append(" ").append(string4).append(" = ").append(string5).append(";\n");
                    hashMap.put(queueVal.primaryVal() + "." + cellA.id(), string4);
                    if (string == null || !string.equals(queueVal.primaryVal()) || !cellA.id().equals(string2)) continue;
                    string3 = NodeGraphCompiler.primaryVal(string4, baseF == null ? cellA.type() : baseF, string2);
                }
            }
            String string6 = this.primaryVal(nuVVnvn2, vnuVUNUv2, NodeGraphCompiler.primaryVal(list), NodeGraphCompiler.secondaryVal(list2), stringBuilder.toString(), string3);
            return new ShaderCompileResult(string6, NodeGraphCompiler.secondaryVal(string6), null, list2);
        }
        catch (RuntimeException runtimeException) {
            String string7 = this.primaryVal(vnuVUNUv2);
            return new ShaderCompileResult(string7, NodeGraphCompiler.secondaryVal(string7), runtimeException.getMessage());
        }
    }

    private static boolean primaryVal(List<NodeInstance> list) {
        for (NodeInstance queueVal : list) {
            if (queueVal == null || !"base_texture".equals(queueVal.secondaryVal())) continue;
            return true;
        }
        return false;
    }

    private static String primaryVal(String string, UniformType baseF, String string2) {
        String string3;
        if (baseF == null) {
            return "vec4(0.02, 0.022, 0.028, 1.0)";
        }
        if ("mask".equals(string2)) {
            return "vec4(vec3(wild_sdf_alpha(" + string + ")), 1.0)";
        }
        switch (baseF) {
            default: {
                throw new MatchException(null, null);
            }
            case FLOAT: {
                string3 = "vec4(vec3(clamp(" + string + ", 0.0, 1.0)), 1.0)";
                break;
            }
            case VEC2: {
                string3 = "vec4(clamp(" + string + ", vec2(0.0), vec2(1.0)), 0.0, 1.0)";
                break;
            }
            case VEC3: {
                string3 = "vec4(clamp(" + string + ", vec3(0.0), vec3(1.0)), 1.0)";
                break;
            }
            case VEC4: {
                string3 = "vec4(clamp((" + string + ").rgb, vec3(0.0), vec3(1.0)), clamp((" + string + ").a, 0.0, 1.0))";
                break;
            }
            case INT: {
                string3 = "vec4(vec3(clamp(float(" + string + ") / 8.0, 0.0, 1.0)), 1.0)";
            }
        }
        return string3;
    }

    private List<ShaderUniformParam> primaryVal(List<NodeInstance> list, Map<String, String> map) {
        ArrayList<ShaderUniformParam> arrayList = new ArrayList<ShaderUniformParam>();
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
        for (NodeInstance queueVal : list) {
            float f;
            float f2;
            float f3;
            float f4;
            if (!"exposed_float".equals(queueVal.secondaryVal())) {
                if (!"exposed_color".equals(queueVal.secondaryVal())) continue;
            }
            String string = NodeGraphCompiler.primaryVal(queueVal);
            String string2 = NodeGraphCompiler.primaryVal(string);
            int n = linkedHashMap.getOrDefault(string2, 0);
            linkedHashMap.put(string2, n + 1);
            String string3 = "u_" + string2 + (String)(n == 0 ? "" : "_" + (n + 1));
            map.put(queueVal.primaryVal(), string3);
            if ("exposed_float".equals(queueVal.secondaryVal())) {
                f4 = queueVal.primaryVal("value", 0.5f);
                f3 = queueVal.primaryVal("min", 0.0f);
                f2 = queueVal.primaryVal("max", 1.0f);
                f = queueVal.primaryVal("step", 0.01f);
                arrayList.add(new ShaderUniformParam(string, string3, ShaderUniformParam.WildClient.FLOAT, new float[]{f4, 0.0f, 0.0f, 1.0f}, f3, f2, f));
                continue;
            }
            f4 = queueVal.primaryVal("r", 1.0f);
            f3 = queueVal.primaryVal("g", 1.0f);
            f2 = queueVal.primaryVal("b", 1.0f);
            f = queueVal.primaryVal("a", 1.0f);
            float[] fArray = new float[4];
            fArray[0] = f4;
            fArray[1] = f3;
            fArray[2] = f2;
            fArray[3] = f;
            arrayList.add(new ShaderUniformParam(string, string3, ShaderUniformParam.WildClient.COLOR, fArray, 0.0f, 1.0f, 0.01f));
        }
        return arrayList;
    }

    private static String secondaryVal(List<ShaderUniformParam> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(list.size() * 28);
        for (ShaderUniformParam ccCoCoOCocoo2 : list) {
            stringBuilder.append("uniform ").append(ccCoCoOCocoo2.kind() == ShaderUniformParam.WildClient.FLOAT ? "float " : "vec4 ").append(ccCoCoOCocoo2.uniformName()).append(";\n");
        }
        return stringBuilder.toString();
    }

    private static String primaryVal(NodeInstance queueVal) {
        String string = "exposed_color".equals(queueVal.secondaryVal()) ? "Color" : "Value";
        String string2 = queueVal.primaryVal("name", string);
        return string2 == null || string2.isBlank() ? string : string2.trim();
    }

    private static String primaryVal(String string) {
        String string2;
        String string3 = string2 = string == null ? "Value" : string.trim();
        if (string2.isBlank()) {
            string2 = "Value";
        }
        StringBuilder stringBuilder = new StringBuilder(string2.length());
        boolean bl = true;
        for (int i = 0; i < string2.length(); ++i) {
            char c = string2.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stringBuilder.append(bl ? Character.toUpperCase(c) : c);
                bl = false;
                continue;
            }
            bl = true;
        }
        if (stringBuilder.isEmpty()) {
            stringBuilder.append("Value");
        }
        if (Character.isDigit(stringBuilder.charAt(0))) {
            stringBuilder.insert(0, 'N');
        }
        return stringBuilder.toString();
    }

    private List<NodeInstance> secondaryVal(NodeGraph nuVVnvn2) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        HashMap<String, List<String>> hashMap2 = new HashMap<String, List<String>>();
        for (NodeInstance object32 : nuVVnvn2.tertiaryVal()) {
            hashMap.put(object32.primaryVal(), 0);
            hashMap2.put(object32.primaryVal(), new ArrayList<String>());
        }
        for (NodeConnection unitJ : nuVVnvn2.marginVal()) {
            if (!hashMap.containsKey(unitJ.primaryVal()) || !hashMap.containsKey(unitJ.tertiaryVal())) continue;
            hashMap2.get(unitJ.primaryVal()).add(unitJ.tertiaryVal());
            hashMap.put(unitJ.tertiaryVal(), hashMap.get(unitJ.tertiaryVal()) + 1);
        }
        ArrayDeque<String> arrayDeque = new ArrayDeque<String>();
        Iterator<Map.Entry<String, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            if (entry.getValue() != 0) continue;
            arrayDeque.add(entry.getKey());
        }
        ArrayList<NodeInstance> arrayList = new ArrayList<NodeInstance>();
        while (!arrayDeque.isEmpty()) {
            String object = arrayDeque.removeFirst();
            NodeInstance queueVal = nuVVnvn2.tertiaryVal(object);
            if (queueVal != null) {
                arrayList.add(queueVal);
            }
            for (String string : hashMap2.getOrDefault(object, List.of())) {
                int n = hashMap.get(string) - 1;
                hashMap.put(string, n);
                if (n != 0) continue;
                arrayDeque.add(string);
            }
        }
        if (arrayList.size() != hashMap.size()) {
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>(hashMap.keySet());
            for (NodeInstance object2 : arrayList) {
                linkedHashSet.remove(object2.primaryVal());
            }
            throw new IllegalStateException("Circular dependency in graph: " + String.join(", ", linkedHashSet));
        }
        return arrayList;
    }

    private String primaryVal(NodeGraph nuVVnvn2, SurfaceTarget vnuVUNUv, boolean bl, String string, String string2, String string3) {
        SurfaceTarget vnuVUNUv2;
        vnuVUNUv2 = vnuVUNUv == null ? SurfaceTarget.PREVIEW_ONLY : vnuVUNUv.marginVal();
        String string4 = vnuVUNUv2 == SurfaceTarget.HUD ? NodeGraphCompiler.tertiaryVal(nuVVnvn2) : (vnuVUNUv2.limitVal() && !bl ? "    float diffuseAlpha = texture(u_DiffuseMap, wild_diffuse_uv()).a;\n    fragColor = vec4(finalColor, finalAlpha * diffuseAlpha * clamp(u_Alpha, 0.0, 1.0));" : "    fragColor = vec4(finalColor, finalAlpha * clamp(u_Alpha, 0.0, 1.0));");
        Object[] objectArray = new Object[6];
        objectArray[0] = NodeGraphCompiler.secondaryVal(vnuVUNUv2) + (string == null ? "" : string);
        objectArray[1] = NodeGraphCompiler.marginVal(nuVVnvn2);
        objectArray[2] = vnuVUNUv2 == SurfaceTarget.HUD ? "centerPos" : "((localPos - 0.5 * u_ElementRect.zw) / max(u_ElementRect.w, 1.0))";
        objectArray[3] = string2;
        objectArray[4] = string3;
        objectArray[5] = string4;
        return "#version 330 core\nlayout(location = 0) out vec4 fragColor;\nin vec2 vUv;\nin vec2 vLocal;\nin vec2 vScreen;\nuniform vec2 uViewport;\nuniform vec4 uRect;\nuniform float u_Time;\nuniform vec2 u_Resolution;\nuniform vec2 u_Mouse;\nuniform vec4 u_ElementRect;\nuniform float u_ElementRadius;\nuniform vec2 u_GlobalUV;\nuniform vec3 u_AccentTop;\nuniform vec3 u_AccentBottom;\nuniform vec4 u_ThemeColors[4];\nuniform float u_Alpha;\nuniform sampler2D u_DiffuseMap;\n%s\n\nfloat wild_sat(float v) {\n    return clamp(v, 0.0, 1.0);\n}\n\nvec2 wild_screen_px() {\n    return vec2(gl_FragCoord.x, u_Resolution.y - gl_FragCoord.y);\n}\n\nvec2 wild_global_uv() {\n    return wild_screen_px() / max(u_Resolution, vec2(1.0));\n}\n\nfloat wild_sdf_alpha(float d) {\n    float aa = max(fwidth(d), 1.0);\n    return 1.0 - smoothstep(0.0, aa, d);\n}\n\nfloat wild_shadow_alpha(float d, vec2 size) {\n    float outside = max(d, 0.0);\n    float soft = clamp(min(size.x, size.y) * 0.32, 10.0, 54.0);\n    float gaussian = exp(-(outside * outside) / max(2.0 * soft * soft, 1.0));\n    float falloff = 1.0 - smoothstep(0.0, soft * 2.4, outside);\n    return gaussian * falloff * 0.28 * step(0.0, d);\n}\n\nvec2 wild_diffuse_uv() {\n    return vec2(vScreen.x / max(uViewport.x, 1.0), 1.0 - vScreen.y / max(uViewport.y, 1.0));\n}\n\nvec4 wild_blend_screen(vec4 base, vec4 layer, float opacity) {\n    vec3 v = 1.0 - (1.0 - base.rgb) * (1.0 - layer.rgb);\n    return vec4(mix(base.rgb, v, wild_sat(opacity)), max(base.a, layer.a));\n}\n\nvec4 wild_blend_overlay(vec4 base, vec4 layer, float opacity) {\n    vec3 lo = 2.0 * base.rgb * layer.rgb;\n    vec3 hi = 1.0 - 2.0 * (1.0 - base.rgb) * (1.0 - layer.rgb);\n    vec3 v = mix(lo, hi, step(vec3(0.5), base.rgb));\n    return vec4(mix(base.rgb, v, wild_sat(opacity)), max(base.a, layer.a));\n}\n\nfloat wild_hash12(vec2 p) {\n    vec3 p3 = fract(vec3(p.xyx) * 0.1031);\n    p3 += dot(p3, p3.yzx + 33.33);\n    return fract((p3.x + p3.y) * p3.z);\n}\n\nfloat wild_hash13(vec3 p3) {\n    p3 = fract(p3 * 0.1031);\n    p3 += dot(p3, p3.zyx + 31.32);\n    return fract((p3.x + p3.y) * p3.z);\n}\n\nfloat wild_noise3(vec3 p) {\n    vec3 i = floor(p);\n    vec3 f = fract(p);\n    vec3 u = f * f * (3.0 - 2.0 * f);\n    float n000 = wild_hash13(i + vec3(0.0, 0.0, 0.0));\n    float n100 = wild_hash13(i + vec3(1.0, 0.0, 0.0));\n    float n010 = wild_hash13(i + vec3(0.0, 1.0, 0.0));\n    float n110 = wild_hash13(i + vec3(1.0, 1.0, 0.0));\n    float n001 = wild_hash13(i + vec3(0.0, 0.0, 1.0));\n    float n101 = wild_hash13(i + vec3(1.0, 0.0, 1.0));\n    float n011 = wild_hash13(i + vec3(0.0, 1.0, 1.0));\n    float n111 = wild_hash13(i + vec3(1.0, 1.0, 1.0));\n    float nx00 = mix(n000, n100, u.x);\n    float nx10 = mix(n010, n110, u.x);\n    float nx01 = mix(n001, n101, u.x);\n    float nx11 = mix(n011, n111, u.x);\n    float nxy0 = mix(nx00, nx10, u.y);\n    float nxy1 = mix(nx01, nx11, u.y);\n    return mix(nxy0, nxy1, u.z);\n}\n\nfloat wild_simplex3(vec3 p) {\n    float v = 0.0;\n    float a = 0.5;\n    float f = 1.0;\n    for (int i = 0; i < 5; i++) {\n        v += (wild_noise3(p * f) * 2.0 - 1.0) * a;\n        f *= 2.03;\n        a *= 0.52;\n    }\n    return clamp(v, -1.0, 1.0);\n}\n\nfloat wild_voronoi(vec2 x, float time) {\n    vec2 n = floor(x);\n    vec2 f = fract(x);\n    float md = 8.0;\n    for (int j = -1; j <= 1; j++) {\n        for (int i = -1; i <= 1; i++) {\n            vec2 g = vec2(float(i), float(j));\n            vec2 o = vec2(wild_hash12(n + g), wild_hash12(n + g + 17.31));\n            o = 0.5 + 0.5 * sin(time * 0.45 + 6.2831 * o);\n            vec2 r = g + o - f;\n            md = min(md, dot(r, r));\n        }\n    }\n    return clamp(sqrt(md), 0.0, 1.0);\n}\n\nfloat wild_sdf_circle(vec2 uv, vec2 center, float radius, float softness) {\n    return length(uv - center) - max(radius, 0.0);\n}\n\nfloat wild_sdf_round_box(vec2 uv, vec2 center, vec2 size, float radius, float softness) {\n    vec2 p = uv - center;\n    vec2 safeSize = max(size, vec2(0.0001));\n    float safeRadius = clamp(radius, 0.0, min(safeSize.x, safeSize.y));\n    vec2 q = abs(p) - safeSize + safeRadius;\n    float d = length(max(q, 0.0)) - safeRadius + min(max(q.x, q.y), 0.0);\n    return d;\n}\n\nvec2 wild_local_pos() {\n    return wild_screen_px() - u_ElementRect.xy;\n}\n\nvec2 wild_center_pos() {\n    return wild_local_pos() - u_ElementRect.zw * 0.5;\n}\n\n%s\n\nvec4 wild_alpha_over(vec4 base, vec4 layer) {\n    float outA = layer.a + base.a * (1.0 - layer.a);\n    vec3 outRgb = outA <= 0.0001 ? vec3(0.0) : (layer.rgb * layer.a + base.rgb * base.a * (1.0 - layer.a)) / outA;\n    return vec4(outRgb, outA);\n}\n\nvec4 wild_glass_surface(float d, vec4 tint, float opacity, float grain) {\n    float mask = wild_sdf_alpha(d);\n    vec2 uvn = wild_local_pos() / max(u_ElementRect.zw, vec2(1.0));\n    float noise = wild_noise3(vec3(uvn * max(u_ElementRect.zw, vec2(1.0)) * 0.035, u_Time * 0.18));\n    float vertical = smoothstep(1.0, 0.0, uvn.y);\n    vec3 base = mix(vec3(0.018, 0.020, 0.028), tint.rgb, 0.18 + vertical * 0.10);\n    base += (noise - 0.5) * clamp(grain, 0.0, 0.18);\n    base += vec3(0.035) * smoothstep(0.85, 0.02, abs(uvn.y - 0.08));\n    return vec4(clamp(base, 0.0, 1.0), mask * clamp(opacity, 0.0, 1.0) * tint.a);\n}\n\nvec4 wild_rim_light(float d, vec4 color, float thickness, float intensity) {\n    float width = max(thickness, max(fwidth(d), 0.75));\n    float edge = exp(-(d * d) / max(width * width * 2.0, 0.0001));\n    float inside = wild_sdf_alpha(d);\n    float a = edge * inside * clamp(intensity, 0.0, 1.0) * color.a;\n    return vec4(color.rgb * a, a);\n}\n\nvec4 wild_hover_glow(vec2 uv, vec4 color, float radius, float intensity) {\n    vec2 mouse = clamp(u_Mouse / max(u_ElementRect.zw, vec2(1.0)), vec2(0.0), vec2(1.0));\n    float r = max(radius, 0.001);\n    float d = distance(uv, mouse);\n    float glow = exp(-(d * d) / max(r * r, 0.0001)) * clamp(intensity, 0.0, 2.0);\n    float mask = wild_sdf_alpha(wild_element_distance());\n    float a = glow * mask * color.a;\n    return vec4(color.rgb * glow, a);\n}\n\nfloat wild_inner_shadow(float d, float strength, float width) {\n    float w = max(width, max(fwidth(d), 1.0));\n    float edge = 1.0 - smoothstep(0.0, w, -d);\n    return edge * wild_sdf_alpha(d) * clamp(strength, 0.0, 1.0);\n}\n\nvec4 wild_exposure_lift(vec4 color, float amount, float decay) {\n    float pulse = exp(-fract(u_Time * max(decay, 0.001)) * 4.0);\n    vec3 lifted = color.rgb + color.rgb * pulse * max(amount, 0.0);\n    return vec4(clamp(lifted, 0.0, 1.0), color.a);\n}\n\nvec4 wild_chromatic(vec4 color, vec2 uv, float amount, float phase) {\n    vec2 c = uv - 0.5;\n    float r = color.r + sin(dot(c, vec2(21.7, 17.1)) + phase) * amount;\n    float b = color.b + cos(dot(c, vec2(15.1, 24.2)) - phase * 0.8) * amount;\n    return vec4(clamp(vec3(r, color.g, b), 0.0, 1.0), color.a);\n}\n\nfloat wild_sdf_triangle(vec2 uv, vec2 center, float radius, float softness) {\n    vec2 p = uv - center;\n    const float k = 1.7320508;\n    p.x = abs(p.x) - radius;\n    p.y = p.y + radius / k;\n    if (p.x + k * p.y > 0.0) {\n        p = vec2(p.x - k * p.y, -k * p.x - p.y) / 2.0;\n    }\n    p.x -= clamp(p.x, -2.0 * radius, 0.0);\n    float d = -length(p) * sign(p.y);\n    return d;\n}\n\nfloat wild_sdf_hex(vec2 uv, vec2 center, float radius, float softness) {\n    vec2 p = abs(uv - center);\n    const vec2 k = vec2(0.8660254, 0.5);\n    p -= 2.0 * min(dot(k, p), 0.0) * k;\n    p -= vec2(clamp(p.x, -k.y * radius, k.y * radius), radius);\n    float d = length(p) * sign(p.y);\n    return d;\n}\n\nfloat wild_fbm(vec3 p, int octaves) {\n    float v = 0.0;\n    float a = 0.5;\n    float f = 1.0;\n    for (int i = 0; i < 8; i++) {\n        if (i >= octaves) break;\n        v += (wild_noise3(p * f) * 2.0 - 1.0) * a;\n        f *= 2.07;\n        a *= 0.52;\n    }\n    return clamp(v * 0.5 + 0.5, 0.0, 1.0);\n}\n\nvec2 wild_polar(vec2 uv, vec2 center) {\n    vec2 p = uv - center;\n    float r = length(p);\n    float a = atan(p.y, p.x);\n    return vec2(a / 6.2831 + 0.5, clamp(r * 2.0, 0.0, 1.0));\n}\n\nvec2 wild_rotate_uv(vec2 uv, vec2 center, float angle) {\n    vec2 p = uv - center;\n    float s = sin(angle);\n    float c = cos(angle);\n    return center + vec2(p.x * c - p.y * s, p.x * s + p.y * c);\n}\n\nvec2 wild_twist_uv(vec2 uv, vec2 center, float strength) {\n    vec2 p = uv - center;\n    float r = length(p);\n    float a = atan(p.y, p.x) + r * strength;\n    return center + vec2(cos(a), sin(a)) * r;\n}\n\nfloat wild_vignette(vec2 uv, float intensity, float falloff) {\n    float d = length(uv - 0.5) * 1.4142;\n    return clamp(pow(1.0 - d * clamp(intensity, 0.0, 4.0), max(falloff, 0.0001) * 4.0), 0.0, 1.0);\n}\n\nvec4 wild_bloom_lift(vec4 color, float threshold, float amount) {\n    float lum = dot(color.rgb, vec3(0.2126, 0.7152, 0.0722));\n    float boost = smoothstep(threshold, threshold + 0.05, lum) * max(amount, 0.0);\n    return vec4(color.rgb + color.rgb * boost, color.a);\n}\n\nvec4 wild_channel_split(vec4 color, float amount, float t) {\n    float a = clamp(amount, 0.0, 0.5);\n    float r = color.r + sin(t * 1.3) * a;\n    float g = color.g + sin(t * 1.7 + 1.0) * a * 0.6;\n    float b = color.b + sin(t * 2.1 + 2.0) * a;\n    return vec4(clamp(vec3(r, g, b), 0.0, 1.0), color.a);\n}\n\nvec4 wild_iridescence(float t, float speed) {\n    float phase = t + u_Time * speed * 0.4;\n    vec3 col = 0.5 + 0.5 * cos(6.2831 * (phase + vec3(0.0, 0.33, 0.67)));\n    return vec4(col, 1.0);\n}\n\nfloat wild_smin(float a, float b, float k) {\n    float kk = max(k, 0.0001);\n    float h = clamp(0.5 + 0.5 * (b - a) / kk, 0.0, 1.0);\n    return mix(b, a, h) - kk * h * (1.0 - h);\n}\n\nfloat wild_smax(float a, float b, float k) {\n    float kk = max(k, 0.0001);\n    float h = clamp(0.5 - 0.5 * (b - a) / kk, 0.0, 1.0);\n    return mix(b, a, h) + kk * h * (1.0 - h);\n}\n\nfloat wild_sdf_union(float a, float b, float smoothness) {\n    return wild_smin(a, b, smoothness);\n}\n\nfloat wild_sdf_subtract(float a, float b, float smoothness) {\n    return wild_smax(a, -b, smoothness);\n}\n\nfloat wild_sdf_intersect(float a, float b, float smoothness) {\n    return wild_smax(a, b, smoothness);\n}\n\nfloat wild_remap(float v, float inMin, float inMax, float outMin, float outMax) {\n    float dn = inMax - inMin;\n    if (abs(dn) < 1e-5) return outMin;\n    float t = clamp((v - inMin) / dn, 0.0, 1.0);\n    return mix(outMin, outMax, t);\n}\n\nvec3 wild_gradient3(float t, vec3 a, vec3 b, vec3 c) {\n    float ct = clamp(t, 0.0, 1.0);\n    if (ct < 0.5) {\n        return mix(a, b, ct * 2.0);\n    }\n    return mix(b, c, (ct - 0.5) * 2.0);\n}\n\nvec4 wild_gradient_map(float t, vec4 a, vec4 b, vec4 c) {\n    float ct = clamp(t, 0.0, 1.0);\n    if (ct < 0.5) {\n        return mix(a, b, ct * 2.0);\n    }\n    return mix(b, c, (ct - 0.5) * 2.0);\n}\n\nvec3 wild_desaturate(vec3 col, float amount) {\n    float lum = dot(col, vec3(0.299, 0.587, 0.114));\n    return mix(col, vec3(lum), clamp(amount, 0.0, 1.0));\n}\n\nvec3 wild_invert(vec3 col, float amount) {\n    return mix(col, vec3(1.0) - col, clamp(amount, 0.0, 1.0));\n}\n\nvec3 wild_hsv2rgb(vec3 c) {\n    vec3 p = abs(fract(c.xxx + vec3(0.0, 2.0 / 3.0, 1.0 / 3.0)) * 6.0 - 3.0);\n    return c.z * mix(vec3(1.0), clamp(p - 1.0, 0.0, 1.0), c.y);\n}\n\nfloat wild_bpm(float bpm, float strength) {\n    float beats = u_Time * (max(bpm, 1.0) / 60.0);\n    float pulse = 0.5 + 0.5 * sin(beats * 6.2831);\n    return pow(pulse, max(strength, 0.0001));\n}\n\nvec2 wild_view_dir(vec2 uv) {\n    return normalize(uv - 0.5 + 1e-5);\n}\n\nvec3 wild_normal_from_uv(vec2 uv, float strength) {\n    vec3 nx = vec3(1.0, 0.0, dFdx(length(uv - 0.5)) * strength * 40.0);\n    vec3 ny = vec3(0.0, 1.0, dFdy(length(uv - 0.5)) * strength * 40.0);\n    return normalize(cross(nx, ny));\n}\n\nfloat wild_pulse(float t, float duty) {\n    float f = fract(t);\n    return step(f, clamp(duty, 0.0, 1.0));\n}\n\nvec4 wild_box_blur(vec2 uv, vec4 base, float radius, int samples) {\n    return base;\n}\n\nfloat wild_sdf_star(vec2 uv, vec2 center, float radius, float points, float softness) {\n    vec2 p = uv - center;\n    float a = atan(p.y, p.x);\n    float r = length(p);\n    float pts = max(points, 3.0);\n    float angle = 6.2831 / pts;\n    float c = cos(floor(0.5 + a / angle) * angle - a);\n    float d = r * c - radius;\n    return d;\n}\n\nvec3 wild_rgb2hsv(vec3 c) {\n    vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);\n    vec4 p = mix(vec4(c.bg, K.wz), vec4(c.gb, K.xy), step(c.b, c.g));\n    vec4 q = mix(vec4(p.xyw, c.r), vec4(c.r, p.yzx), step(p.x, c.r));\n    float d = q.x - min(q.w, q.y);\n    float e = 1.0e-10;\n    return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);\n}\n\nvec2 wild_radial_shear(vec2 uv, vec2 center, float strength) {\n    vec2 d = uv - center;\n    float r = dot(d, d);\n    return uv + vec2(d.y, -d.x) * r * strength;\n}\n\nvec2 wild_spherize(vec2 uv, vec2 center, float strength) {\n    vec2 d = uv - center;\n    float r = length(d);\n    vec2 dir = r > 1e-5 ? d / r : vec2(0.0);\n    float rr = mix(r, sin(r * 1.5708), clamp(strength, 0.0, 1.0));\n    return center + dir * rr;\n}\n\nfloat wild_checker(vec2 uv, vec2 freq) {\n    vec2 c = floor(uv * freq);\n    return mod(c.x + c.y, 2.0);\n}\n\nfloat wild_gnoise2(vec2 p) {\n    return wild_noise3(vec3(p, 0.0));\n}\n\nvoid main() {\n    vec2 screenPos = wild_screen_px();\n    vec2 globalUv = wild_global_uv();\n    vec2 localPos = screenPos - u_ElementRect.xy;\n    vec2 centerPos = localPos - (u_ElementRect.zw * 0.5);\n    vec2 normalizedUv = localPos / max(u_ElementRect.zw, vec2(1.0));\n    vec2 uv = %s;\n%s\n    vec4 color = %s;\n    float vignette = smoothstep(0.92, 0.18, length(normalizedUv - 0.5));\n    color.rgb *= 0.74 + vignette * 0.42;\n    color.rgb += pow(max(color.rgb, vec3(0.0)), vec3(2.2)) * 0.18;\n    vec3 finalColor = clamp(color.rgb, 0.0, 1.0);\n    float finalAlpha = clamp(color.a, 0.0, 1.0);\n%s\n}\n".formatted(objectArray);
    }

    public String primaryVal() {
        return this.primaryVal(SurfaceTarget.PREVIEW_ONLY);
    }

    private static String tertiaryVal(NodeGraph nuVVnvn2) {
        if ("Full Quad".equals(NodeGraphCompiler.weightVal(nuVVnvn2))) {
            return "    fragColor = vec4(finalColor, finalAlpha * clamp(u_Alpha, 0.0, 1.0));";
        }
        return "    float hudDistance = wild_element_distance();\n    float hudInside = wild_sdf_alpha(hudDistance);\n    vec2 hudAabbMask = step(u_ElementRect.xy, screenPos) * step(screenPos, u_ElementRect.xy + u_ElementRect.zw);\n    float hudAabbInside = hudAabbMask.x * hudAabbMask.y;\n    float hudShadow = wild_shadow_alpha(hudDistance, u_ElementRect.zw) * (1.0 - hudAabbInside);\n    float hudAlpha = finalAlpha * clamp(u_Alpha, 0.0, 1.0) * hudInside;\n    float outAlpha = clamp(hudAlpha + hudShadow * (1.0 - hudAlpha), 0.0, 1.0);\n    vec3 outColor = outAlpha <= 0.0001 ? vec3(0.0) : (finalColor * hudAlpha) / outAlpha;\n    fragColor = vec4(outColor, outAlpha);";
    }

    private static String marginVal(NodeGraph nuVVnvn2) {
        String string = NodeGraphCompiler.weightVal(nuVVnvn2);
        String string2 = "float wild_host_element_distance(float inset) {\n    float px = max(inset, 0.0);\n    vec2 size = max(vec2(1.0), u_ElementRect.zw * 0.5 - vec2(px));\n    float radius = max(0.0, u_ElementRadius - px);\n    return wild_sdf_round_box(wild_center_pos(), vec2(0.0), size, radius, 0.0);\n}\n";
        if ("Full Quad".equals(string)) {
            return string2 + "float wild_element_distance() {\n    return -1.0;\n}\n\nfloat wild_element_distance_inset(float inset) {\n    return wild_host_element_distance(inset);\n}\n";
        }
        if ("Inset Shape".equals(string)) {
            return string2 + "float wild_element_distance() {\n    float inset = max(1.0, min(u_ElementRect.z, u_ElementRect.w) * 0.075);\n    return wild_host_element_distance(inset);\n}\n\nfloat wild_element_distance_inset(float inset) {\n    float baseInset = max(1.0, min(u_ElementRect.z, u_ElementRect.w) * 0.075);\n    return wild_host_element_distance(baseInset + max(inset, 0.0));\n}\n";
        }
        return string2 + "float wild_element_distance() {\n    return wild_host_element_distance(0.0);\n}\n\nfloat wild_element_distance_inset(float inset) {\n    return wild_host_element_distance(inset);\n}\n";
    }

    private static String weightVal(NodeGraph nuVVnvn2) {
        if (nuVVnvn2 == null || nuVVnvn2.primaryVal() == null) {
            return "Host Rectangle";
        }
        String string = nuVVnvn2.primaryVal().extraVal();
        return "Inset Shape".equals(string) || "Full Quad".equals(string) ? string : "Host Rectangle";
    }

    public String primaryVal(SurfaceTarget vnuVUNUv) {
        return this.primaryVal(null, vnuVUNUv, false, "", "", "vec4(mix(vec3(0.018, 0.020, 0.027), u_AccentTop, 0.18 + 0.12 * sin(u_Time + vUv.x * 6.2831)), 1.0)");
    }

    private static String secondaryVal(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder(16);
            for (int i = 0; i < 8; ++i) {
                stringBuilder.append(String.format("%02x", byArray[i] & 0xFF));
            }
            return stringBuilder.toString();
        }
        catch (Exception exception) {
            return "0000000000000000";
        }
    }
}

