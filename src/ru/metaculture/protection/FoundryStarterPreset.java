/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.function.Function;
import ru.metaculture.protection.NodeInstance;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.NodeGraph;
import ru.metaculture.protection.NodeDefinitionRegistry;

public final class FoundryStarterPreset {
    public static final List<cursorVal> primaryVal;

    private FoundryStarterPreset() {
    }

    public static NodeGraph primaryVal(cursorVal panelVal, NodeDefinitionRegistry nodeI) {
        return panelVal == null ? FoundryStarterPreset.primaryVal(nodeI) : panelVal.builder.apply(nodeI);
    }

    public static NodeGraph primaryVal(NodeDefinitionRegistry nodeI) {
        return FoundryStarterPreset.primaryVal(nodeI, SurfaceTarget.HUD, "Ferro HUD Starter", "clean HUD plate shader", 0.72f, 0.07f, 0.34f, 0.6f);
    }

    private static NodeGraph primaryVal(NodeDefinitionRegistry nodeI, SurfaceTarget vnuVUNUv, String string, String string2, float f, float f2, float f3, float f4) {
        NodeGraph nuVVnvn2 = new NodeGraph();
        FoundryStarterPreset.primaryVal(nuVVnvn2, string, string2, vnuVUNUv, "Starter");
        WildClient modeVal = new WildClient(-780.0f, -180.0f, 224.0f, 108.0f);
        NodeInstance queueVal = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "input_element_uv", modeVal, 0, 0);
        NodeInstance wickA = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "element_mask", modeVal, 0, 1);
        NodeInstance wickB = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "theme_panel", modeVal, 0, 3);
        NodeInstance wickC = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "theme_top", modeVal, 0, 4);
        NodeInstance wickD = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "theme_bottom", modeVal, 0, 5);
        NodeInstance wickE = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "exposed_float", modeVal, 1, 0);
        NodeInstance wickF = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "exposed_float", modeVal, 1, 1);
        NodeInstance wickG = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "exposed_float", modeVal, 1, 2);
        NodeInstance wickH = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "exposed_float", modeVal, 1, 3);
        NodeInstance wickI = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "exposed_float", modeVal, 1, 4);
        NodeInstance wickJ = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "exposed_float", modeVal, 1, 5);
        NodeInstance raftA = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "glass_surface", modeVal, 2, 0);
        NodeInstance raftB = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "rim_light", modeVal, 2, 2);
        NodeInstance raftC = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "hover_glow", modeVal, 2, 4);
        NodeInstance raftD = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "alpha_blend", modeVal, 3, 1);
        NodeInstance raftE = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "alpha_blend", modeVal, 4, 1);
        NodeInstance raftF = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "output_color", modeVal, 5, 1);
        FoundryStarterPreset.primaryVal(wickE, "Opacity", f, 0.05f, 1.0f, 0.01f);
        FoundryStarterPreset.primaryVal(wickF, "Grain", f2, 0.0f, 0.18f, 0.002f);
        FoundryStarterPreset.primaryVal(wickG, "Rim Width", 1.15f, 0.35f, 4.0f, 0.05f);
        FoundryStarterPreset.primaryVal(wickH, "Rim Power", f3, 0.0f, 1.0f, 0.01f);
        FoundryStarterPreset.primaryVal(wickI, "Hover Radius", 0.44f, 0.05f, 1.2f, 0.01f);
        FoundryStarterPreset.primaryVal(wickJ, "Hover Power", f4, 0.0f, 1.8f, 0.01f);
        nuVVnvn2.primaryVal(wickA.primaryVal(), "mask", raftA.primaryVal(), "mask", nodeI);
        nuVVnvn2.primaryVal(wickB.primaryVal(), "color", raftA.primaryVal(), "tint", nodeI);
        nuVVnvn2.primaryVal(wickE.primaryVal(), "value", raftA.primaryVal(), "opacity", nodeI);
        nuVVnvn2.primaryVal(wickF.primaryVal(), "value", raftA.primaryVal(), "grain", nodeI);
        nuVVnvn2.primaryVal(wickA.primaryVal(), "mask", raftB.primaryVal(), "mask", nodeI);
        nuVVnvn2.primaryVal(wickC.primaryVal(), "color", raftB.primaryVal(), "color", nodeI);
        nuVVnvn2.primaryVal(wickG.primaryVal(), "value", raftB.primaryVal(), "thickness", nodeI);
        nuVVnvn2.primaryVal(wickH.primaryVal(), "value", raftB.primaryVal(), "intensity", nodeI);
        nuVVnvn2.primaryVal(queueVal.primaryVal(), "uv", raftC.primaryVal(), "uv", nodeI);
        nuVVnvn2.primaryVal(wickD.primaryVal(), "color", raftC.primaryVal(), "color", nodeI);
        nuVVnvn2.primaryVal(wickI.primaryVal(), "value", raftC.primaryVal(), "radius", nodeI);
        nuVVnvn2.primaryVal(wickJ.primaryVal(), "value", raftC.primaryVal(), "intensity", nodeI);
        nuVVnvn2.primaryVal(raftA.primaryVal(), "color", raftD.primaryVal(), "base", nodeI);
        nuVVnvn2.primaryVal(raftB.primaryVal(), "color", raftD.primaryVal(), "layer", nodeI);
        nuVVnvn2.primaryVal(raftD.primaryVal(), "color", raftE.primaryVal(), "base", nodeI);
        nuVVnvn2.primaryVal(raftC.primaryVal(), "color", raftE.primaryVal(), "layer", nodeI);
        nuVVnvn2.primaryVal(raftE.primaryVal(), "color", raftF.primaryVal(), "color", nodeI);
        return nuVVnvn2;
    }

    private static NodeGraph secondaryVal(NodeDefinitionRegistry nodeI) {
        NodeGraph nuVVnvn2 = new NodeGraph();
        FoundryStarterPreset.primaryVal(nuVVnvn2, "Clean Health Fill", "stable health bar shader starter", SurfaceTarget.HEALTH_BAR, "Starter");
        WildClient modeVal = new WildClient(-720.0f, -150.0f, 216.0f, 104.0f);
        NodeInstance queueVal = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "input_element_uv", modeVal, 0, 0);
        NodeInstance wickA = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "vec2_split", modeVal, 1, 0);
        NodeInstance wickB = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "element_mask", modeVal, 0, 2);
        NodeInstance wickC = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "theme_bottom", modeVal, 1, 2);
        NodeInstance wickD = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "theme_top", modeVal, 1, 3);
        NodeInstance wickE = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "exposed_float", modeVal, 2, 0);
        NodeInstance wickF = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "color_ramp", modeVal, 2, 2);
        NodeInstance wickG = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "sdf_fill", modeVal, 3, 2);
        NodeInstance wickH = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "output_color", modeVal, 4, 2);
        FoundryStarterPreset.primaryVal(wickE, "Fill Alpha", 0.92f, 0.0f, 1.0f, 0.01f);
        nuVVnvn2.primaryVal(queueVal.primaryVal(), "uv", wickA.primaryVal(), "v", nodeI);
        nuVVnvn2.primaryVal(wickA.primaryVal(), "x", wickF.primaryVal(), "t", nodeI);
        nuVVnvn2.primaryVal(wickC.primaryVal(), "color", wickF.primaryVal(), "a", nodeI);
        nuVVnvn2.primaryVal(wickD.primaryVal(), "color", wickF.primaryVal(), "b", nodeI);
        nuVVnvn2.primaryVal(wickB.primaryVal(), "mask", wickG.primaryVal(), "mask", nodeI);
        nuVVnvn2.primaryVal(wickF.primaryVal(), "color", wickG.primaryVal(), "color", nodeI);
        nuVVnvn2.primaryVal(wickE.primaryVal(), "value", wickG.primaryVal(), "alpha", nodeI);
        nuVVnvn2.primaryVal(wickG.primaryVal(), "color", wickH.primaryVal(), "color", nodeI);
        return nuVVnvn2;
    }

    private static NodeGraph primaryVal(NodeDefinitionRegistry nodeI, SurfaceTarget vnuVUNUv, String string, String string2) {
        NodeGraph nuVVnvn2 = new NodeGraph();
        FoundryStarterPreset.primaryVal(nuVVnvn2, string, string2, vnuVUNUv, "Starter");
        WildClient modeVal = new WildClient(-700.0f, -130.0f, 216.0f, 104.0f);
        NodeInstance queueVal = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "input_global_uv", modeVal, 0, 0);
        NodeInstance wickA = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "vec2_split", modeVal, 1, 0);
        NodeInstance wickB = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "theme_bottom", modeVal, 1, 2);
        NodeInstance wickC = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "theme_panel", modeVal, 1, 3);
        NodeInstance wickD = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "theme_top", modeVal, 1, 4);
        NodeInstance wickE = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "color_gradient_map", modeVal, 2, 1);
        NodeInstance wickF = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "output_color", modeVal, 3, 1);
        nuVVnvn2.primaryVal(queueVal.primaryVal(), "uv", wickA.primaryVal(), "v", nodeI);
        nuVVnvn2.primaryVal(wickA.primaryVal(), "y", wickE.primaryVal(), "t", nodeI);
        nuVVnvn2.primaryVal(wickB.primaryVal(), "color", wickE.primaryVal(), "a", nodeI);
        nuVVnvn2.primaryVal(wickC.primaryVal(), "color", wickE.primaryVal(), "b", nodeI);
        nuVVnvn2.primaryVal(wickD.primaryVal(), "color", wickE.primaryVal(), "c", nodeI);
        nuVVnvn2.primaryVal(wickE.primaryVal(), "color", wickF.primaryVal(), "color", nodeI);
        return nuVVnvn2;
    }

    private static NodeGraph tertiaryVal(NodeDefinitionRegistry nodeI) {
        NodeGraph nuVVnvn2 = new NodeGraph();
        FoundryStarterPreset.primaryVal(nuVVnvn2, "Clean ESP Silhouette", "stable entity silhouette shader starter", SurfaceTarget.ESP, "Starter");
        WildClient modeVal = new WildClient(-720.0f, -160.0f, 216.0f, 106.0f);
        NodeInstance queueVal = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "element_mask", modeVal, 0, 0);
        NodeInstance wickA = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "theme_bottom", modeVal, 0, 2);
        NodeInstance wickB = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "theme_top", modeVal, 0, 3);
        NodeInstance wickC = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "exposed_float", modeVal, 1, 0);
        NodeInstance wickD = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "exposed_float", modeVal, 1, 1);
        NodeInstance wickE = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "sdf_fill", modeVal, 2, 0);
        NodeInstance wickF = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "rim_light", modeVal, 2, 2);
        NodeInstance wickG = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "alpha_blend", modeVal, 3, 1);
        NodeInstance wickH = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "output_color", modeVal, 4, 1);
        FoundryStarterPreset.primaryVal(wickC, "Aura Alpha", 0.78f, 0.0f, 1.0f, 0.01f);
        FoundryStarterPreset.primaryVal(wickD, "Rim Power", 0.46f, 0.0f, 1.2f, 0.01f);
        nuVVnvn2.primaryVal(queueVal.primaryVal(), "mask", wickE.primaryVal(), "mask", nodeI);
        nuVVnvn2.primaryVal(wickA.primaryVal(), "color", wickE.primaryVal(), "color", nodeI);
        nuVVnvn2.primaryVal(wickC.primaryVal(), "value", wickE.primaryVal(), "alpha", nodeI);
        nuVVnvn2.primaryVal(queueVal.primaryVal(), "mask", wickF.primaryVal(), "mask", nodeI);
        nuVVnvn2.primaryVal(wickB.primaryVal(), "color", wickF.primaryVal(), "color", nodeI);
        nuVVnvn2.primaryVal(wickD.primaryVal(), "value", wickF.primaryVal(), "intensity", nodeI);
        nuVVnvn2.primaryVal(wickE.primaryVal(), "color", wickG.primaryVal(), "base", nodeI);
        nuVVnvn2.primaryVal(wickF.primaryVal(), "color", wickG.primaryVal(), "layer", nodeI);
        nuVVnvn2.primaryVal(wickG.primaryVal(), "color", wickH.primaryVal(), "color", nodeI);
        return nuVVnvn2;
    }

    private static NodeGraph marginVal(NodeDefinitionRegistry nodeI) {
        NodeGraph nuVVnvn2 = new NodeGraph();
        FoundryStarterPreset.primaryVal(nuVVnvn2, "Clean Chams Film", "stable chams material starter", SurfaceTarget.CHAMS, "Starter");
        WildClient modeVal = new WildClient(-740.0f, -150.0f, 216.0f, 106.0f);
        NodeInstance queueVal = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "input_uv", modeVal, 0, 0);
        NodeInstance wickA = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "base_texture", modeVal, 0, 2);
        NodeInstance wickB = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "color_alpha", modeVal, 1, 2);
        NodeInstance wickC = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "fresnel", modeVal, 1, 0);
        NodeInstance wickD = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "theme_top", modeVal, 1, 4);
        NodeInstance wickE = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "theme_bottom", modeVal, 1, 5);
        NodeInstance wickF = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "color_ramp", modeVal, 2, 0);
        NodeInstance wickG = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "color_multiply_scalar", modeVal, 3, 0);
        NodeInstance wickH = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "blend_screen", modeVal, 4, 1);
        NodeInstance wickI = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "output_color", modeVal, 5, 1);
        nuVVnvn2.primaryVal(queueVal.primaryVal(), "uv", wickC.primaryVal(), "uv", nodeI);
        nuVVnvn2.primaryVal(wickC.primaryVal(), "value", wickF.primaryVal(), "t", nodeI);
        nuVVnvn2.primaryVal(wickE.primaryVal(), "color", wickF.primaryVal(), "a", nodeI);
        nuVVnvn2.primaryVal(wickD.primaryVal(), "color", wickF.primaryVal(), "b", nodeI);
        nuVVnvn2.primaryVal(wickA.primaryVal(), "color", wickB.primaryVal(), "color", nodeI);
        nuVVnvn2.primaryVal(wickF.primaryVal(), "color", wickG.primaryVal(), "color", nodeI);
        nuVVnvn2.primaryVal(wickB.primaryVal(), "alpha", wickG.primaryVal(), "factor", nodeI);
        nuVVnvn2.primaryVal(wickA.primaryVal(), "color", wickH.primaryVal(), "base", nodeI);
        nuVVnvn2.primaryVal(wickG.primaryVal(), "color", wickH.primaryVal(), "layer", nodeI);
        nuVVnvn2.primaryVal(wickB.primaryVal(), "alpha", wickH.primaryVal(), "opacity", nodeI);
        nuVVnvn2.primaryVal(wickH.primaryVal(), "color", wickI.primaryVal(), "color", nodeI);
        nuVVnvn2.primaryVal(wickB.primaryVal(), "alpha", wickI.primaryVal(), "alpha", nodeI);
        return nuVVnvn2;
    }

    private static NodeGraph weightVal(NodeDefinitionRegistry nodeI) {
        NodeGraph nuVVnvn2 = new NodeGraph();
        FoundryStarterPreset.primaryVal(nuVVnvn2, "Clean Trail Ribbon", "stable trail ribbon shader starter", SurfaceTarget.TRAILS, "Starter");
        WildClient modeVal = new WildClient(-720.0f, -145.0f, 216.0f, 104.0f);
        NodeInstance queueVal = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "input_uv", modeVal, 0, 0);
        NodeInstance wickA = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "fresnel", modeVal, 1, 0);
        NodeInstance wickB = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "theme_top", modeVal, 1, 2);
        NodeInstance wickC = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "theme_bottom", modeVal, 1, 3);
        NodeInstance wickD = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "exposed_float", modeVal, 2, 0);
        NodeInstance wickE = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "color_ramp", modeVal, 2, 2);
        NodeInstance wickF = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "bloom_lift", modeVal, 3, 2);
        NodeInstance wickG = FoundryStarterPreset.primaryVal(nuVVnvn2, nodeI, "output_color", modeVal, 4, 2);
        FoundryStarterPreset.primaryVal(wickD, "Ribbon Alpha", 0.86f, 0.0f, 1.0f, 0.01f);
        nuVVnvn2.primaryVal(queueVal.primaryVal(), "uv", wickA.primaryVal(), "uv", nodeI);
        nuVVnvn2.primaryVal(wickA.primaryVal(), "value", wickE.primaryVal(), "t", nodeI);
        nuVVnvn2.primaryVal(wickC.primaryVal(), "color", wickE.primaryVal(), "a", nodeI);
        nuVVnvn2.primaryVal(wickB.primaryVal(), "color", wickE.primaryVal(), "b", nodeI);
        nuVVnvn2.primaryVal(wickE.primaryVal(), "color", wickF.primaryVal(), "color", nodeI);
        nuVVnvn2.primaryVal(wickF.primaryVal(), "color", wickG.primaryVal(), "color", nodeI);
        nuVVnvn2.primaryVal(wickD.primaryVal(), "value", wickG.primaryVal(), "alpha", nodeI);
        return nuVVnvn2;
    }

    private static void primaryVal(NodeGraph nuVVnvn2, String string, String string2, SurfaceTarget vnuVUNUv, String string3) {
        nuVVnvn2.primaryVal().primaryVal(string);
        nuVVnvn2.primaryVal().tertiaryVal(string2);
        nuVVnvn2.primaryVal().marginVal(string3);
        nuVVnvn2.primaryVal().weightVal("preset");
        if (vnuVUNUv != null) {
            nuVVnvn2.primaryVal(vnuVUNUv.primaryVal());
        }
    }

    private static NodeInstance primaryVal(NodeGraph nuVVnvn2, NodeDefinitionRegistry nodeI, String string, WildClient modeVal, int n, int n2) {
        return nuVVnvn2.primaryVal(string, modeVal.x(n), modeVal.y(n2), nodeI);
    }

    private static void primaryVal(NodeInstance queueVal, String string, float f, float f2, float f3, float f4) {
        queueVal.secondaryVal("name", string);
        queueVal.secondaryVal("value", f);
        queueVal.secondaryVal("min", f2);
        queueVal.secondaryVal("max", f3);
        queueVal.secondaryVal("step", f4);
    }

    static {
        cursorVal[] nvnNNunvvArray = new cursorVal[11];
        nvnNNunvvArray[0] = new cursorVal("Ferro HUD Starter", "matte host plate with rim, grain and hover light", SurfaceTarget.HUD, "Starter", List.of("Element Mask", "Mica Glass", "Rim Light", "Hover Glow"), nodeI -> FoundryStarterPreset.primaryVal(nodeI, SurfaceTarget.HUD, "Ferro HUD Starter", "clean HUD plate shader", 0.72f, 0.07f, 0.34f, 0.6f));
        nvnNNunvvArray[1] = new cursorVal("Ferro Module Card", "module row glass without pulse or layout noise", SurfaceTarget.MODULE_CARD, "Starter", List.of("Element Mask", "Mica Glass", "Rim Light"), nodeI -> FoundryStarterPreset.primaryVal(nodeI, SurfaceTarget.MODULE_CARD, "Ferro Module Card", "module card material starter", 0.62f, 0.045f, 0.22f, 0.42f));
        nvnNNunvvArray[2] = new cursorVal("Ferro Panel Surface", "dock panel surface with stable mica depth", SurfaceTarget.PANEL_BACKGROUND, "Starter", List.of("Element Mask", "Mica Glass", "Rim Light"), nodeI -> FoundryStarterPreset.primaryVal(nodeI, SurfaceTarget.PANEL_BACKGROUND, "Ferro Panel Surface", "panel background material starter", 0.68f, 0.055f, 0.26f, 0.48f));
        nvnNNunvvArray[3] = new cursorVal("Ferro Button Surface", "button body with compact magnetic response", SurfaceTarget.BUTTON, "Starter", List.of("Element Mask", "Mica Glass", "Hover Glow"), nodeI -> FoundryStarterPreset.primaryVal(nodeI, SurfaceTarget.BUTTON, "Ferro Button Surface", "interactive button material starter", 0.66f, 0.038f, 0.3f, 0.82f));
        nvnNNunvvArray[4] = new cursorVal("Clean Health Fill", "stable gradient fill for bars and shield surfaces", SurfaceTarget.HEALTH_BAR, "Starter", List.of("Element UV", "Gradient Map", "SDF Fill"), FoundryStarterPreset::secondaryVal);
        nvnNNunvvArray[5] = new cursorVal("Clean Menu Background", "quiet full-screen gradient background", SurfaceTarget.BACKGROUND, "Starter", List.of("Global UV", "Gradient Map"), nodeI -> FoundryStarterPreset.primaryVal(nodeI, SurfaceTarget.BACKGROUND, "Clean Menu Background", "full-screen interface background starter"));
        nvnNNunvvArray[6] = new cursorVal("Clean Sky Atmosphere", "soft atmospheric wash for sky target", SurfaceTarget.SKY, "Starter", List.of("Global UV", "Gradient Map"), nodeI -> FoundryStarterPreset.primaryVal(nodeI, SurfaceTarget.SKY, "Clean Sky Atmosphere", "world atmosphere starter"));
        nvnNNunvvArray[7] = new cursorVal("Clean ESP Silhouette", "entity-target rounded silhouette with rim", SurfaceTarget.ESP, "Starter", List.of("Element Mask", "SDF Fill", "Rim Light"), FoundryStarterPreset::tertiaryVal);
        nvnNNunvvArray[8] = new cursorVal("Clean Chams Film", "texture-preserving entity film with stable fresnel", SurfaceTarget.CHAMS, "Starter", List.of("Base Texture", "Fresnel", "Screen Blend"), FoundryStarterPreset::marginVal);
        nvnNNunvvArray[9] = new cursorVal("Clean Nametag Plate", "billboard nametag mica plate", SurfaceTarget.NAMETAG, "Starter", List.of("Element Mask", "Mica Glass", "Rim Light"), nodeI -> FoundryStarterPreset.primaryVal(nodeI, SurfaceTarget.NAMETAG, "Clean Nametag Plate", "nametag plate material starter", 0.64f, 0.042f, 0.28f, 0.34f));
        nvnNNunvvArray[10] = new cursorVal("Clean Trail Ribbon", "additive ribbon starter with stable edge energy", SurfaceTarget.TRAILS, "Starter", List.of("Fresnel", "Gradient Map", "Bloom Lift"), FoundryStarterPreset::weightVal);
        primaryVal = List.of(nvnNNunvvArray);
    }

    public static final class cursorVal
     {
        private final String title;
        private final String description;
        private final SurfaceTarget target;
        private final String complexity;
        private final List<String> nodes;
        final Function<NodeDefinitionRegistry, NodeGraph> builder;

        public cursorVal(String string, String string2, SurfaceTarget vnuVUNUv, String string3, List<String> list, Function<NodeDefinitionRegistry, NodeGraph> function) {
            this.title = string;
            this.description = string2;
            this.target = vnuVUNUv;
            this.complexity = string3;
            this.nodes = list;
            this.builder = function;
        }

        @Override
        public final String toString() {
            return "nvnNNunvv[" + "title=" + this.title + ", " + "description=" + this.description + ", " + "target=" + this.target + ", " + "complexity=" + this.complexity + ", " + "nodes=" + this.nodes + ", " + "builder=" + this.builder + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.title, this.description, this.target, this.complexity, this.nodes, this.builder);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            cursorVal that = (cursorVal)object;
            return java.util.Objects.equals(this.title, that.title) && java.util.Objects.equals(this.description, that.description) && java.util.Objects.equals(this.target, that.target) && java.util.Objects.equals(this.complexity, that.complexity) && java.util.Objects.equals(this.nodes, that.nodes) && java.util.Objects.equals(this.builder, that.builder);}

        public String title() {
            return this.title;
        }

        public String description() {
            return this.description;
        }

        public SurfaceTarget target() {
            return this.target;
        }

        public String complexity() {
            return this.complexity;
        }

        public List<String> nodes() {
            return this.nodes;
        }

        public Function<NodeDefinitionRegistry, NodeGraph> builder() {
            return this.builder;
        }
    }

    record WildClient(float originX, float originY, float column, float row) {
        float x(int n) {
            return this.originX + this.column * (float)n;
        }

        float y(int n) {
            return this.originY + this.row * (float)n;
        }
    }
}

