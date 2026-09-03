/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Iterator;
import java.util.Set;
import ru.metaculture.protection.ShaderCompileResult;
import ru.metaculture.protection.NuVunNnUvvN;
import ru.metaculture.protection.ShaderPresetMeta;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.FoundryStorage;
import ru.metaculture.protection.FoundryStarterPreset;
import ru.metaculture.protection.NodeGraph;
import ru.metaculture.protection.NodeDefinitionRegistry;
import ru.metaculture.protection.NodeGraphCompiler;
import ru.metaculture.protection.ThemeShaderManager;

public final class ShaderFoundryBootstrap {
    private static boolean primaryVal;
    private static final Set<String> secondaryVal;

    private ShaderFoundryBootstrap() {
    }

    public static synchronized void primaryVal(NodeDefinitionRegistry nodeI, NodeGraphCompiler coreE) {
        NodeGraph throwable;
        if (primaryVal || nodeI == null || coreE == null) {
            return;
        }
        primaryVal = true;
        FoundryStorage duneF = FoundryStorage.primaryVal();
        duneF.primaryVal(nodeI);
        ThemeShaderManager.primaryVal().primaryVal(coreE);
        NuVunNnUvvN.primaryVal().primaryVal(coreE, nodeI);
        for (FoundryStarterPreset.cursorVal object : FoundryStarterPreset.primaryVal) {
            try {
                throwable = FoundryStarterPreset.primaryVal(object, nodeI);
                if (throwable == null) {
                    continue;
                }
                throwable.primaryVal(object.target().primaryVal());
                ShaderCompileResult twigE = coreE.primaryVal(throwable);
                if (!twigE.ok()) {
                    System.out.println("[FoundryBootstrap] skipped failed preset " + object.title() + ": " + twigE.error());
                    continue;
                }
                ThemeShaderManager.primaryVal().primaryVal(object.title(), throwable, twigE, ThemeShaderManager.cursorVal.PRESET);
            }
            catch (Throwable throwable2) {
                System.out.println("[FoundryBootstrap] failed to publish preset " + object.title() + ": " + throwable2.getMessage());
            }
        }
        for (ShaderPresetMeta vUvUNNUvvNVN : duneF.secondaryVal()) {
            try {
                if (ShaderFoundryBootstrap.primaryVal(vUvUNNUvvNVN) || (throwable = duneF.primaryVal(vUvUNNUvvNVN.primaryVal(), nodeI)) == null) continue;
                ShaderCompileResult twigE = coreE.primaryVal(throwable);
                if (!twigE.ok()) {
                    System.out.println("[FoundryBootstrap] skipped failed slot " + vUvUNNUvvNVN.secondaryVal() + ": " + twigE.error());
                    continue;
                }
                ThemeShaderManager.primaryVal().primaryVal(vUvUNNUvvNVN.secondaryVal(), throwable, twigE, ShaderFoundryBootstrap.secondaryVal(vUvUNNUvvNVN));
            }
            catch (Throwable throwable3) {
                System.out.println("[FoundryBootstrap] failed to publish " + vUvUNNUvvNVN.secondaryVal() + ": " + throwable3.getMessage());
            }
        }
        for (SurfaceTarget surfaceTarget : SurfaceTarget.values()) {
            ShaderPresetMeta vUvUNNUvvNVN = duneF.tertiaryVal(surfaceTarget);
            if (vUvUNNUvvNVN == null) continue;
            try {
                NodeGraph nuVVnvn2 = duneF.primaryVal(vUvUNNUvvNVN.primaryVal(), nodeI);
                if (nuVVnvn2 == null) continue;
                nuVVnvn2.primaryVal(surfaceTarget.primaryVal());
                ShaderCompileResult twigE = coreE.primaryVal(nuVVnvn2);
                if (!twigE.ok()) {
                    System.out.println("[FoundryBootstrap] skipped failed bound target " + surfaceTarget.primaryVal() + ": " + twigE.error());
                    continue;
                }
                ThemeShaderManager.primaryVal().primaryVal(surfaceTarget, nuVVnvn2, twigE);
            }
            catch (Throwable throwable4) {
                System.out.println("[FoundryBootstrap] failed to publish " + surfaceTarget.primaryVal() + ": " + throwable4.getMessage());
            }
        }
    }

    public static Set<String> primaryVal() {
        return secondaryVal;
    }

    private static boolean primaryVal(ShaderPresetMeta vUvUNNUvvNVN) {
        if (vUvUNNUvvNVN == null) {
            return false;
        }
        String string = ThemeShaderManager.widthVal(vUvUNNUvvNVN.secondaryVal());
        return secondaryVal.contains(string);
    }

    private static ThemeShaderManager.cursorVal secondaryVal(ShaderPresetMeta vUvUNNUvvNVN) {
        if (vUvUNNUvvNVN == null) {
            return ThemeShaderManager.cursorVal.USER;
        }
        String string = vUvUNNUvvNVN.limitVal();
        if ("preset".equalsIgnoreCase(string)) {
            return ThemeShaderManager.cursorVal.PRESET;
        }
        if ("imported".equalsIgnoreCase(string) || "shared".equalsIgnoreCase(string)) {
            return ThemeShaderManager.cursorVal.IMPORTED;
        }
        return ThemeShaderManager.cursorVal.USER;
    }

    static {
        String[] stringArray = new String[13];
        stringArray[0] = "Adaptive Mica Plate";
        stringArray[1] = "Velvet Module Card";
        stringArray[2] = "Nebula Panel Bloom";
        stringArray[3] = "Aurora Button Pulse";
        stringArray[4] = "Entity Aura Mask";
        stringArray[5] = "Holographic Nametag";
        stringArray[6] = "Trail Energy Ribbon";
        stringArray[7] = "Magnetic Rim Glow";
        stringArray[8] = "Pulse Health Ribbon";
        stringArray[9] = "Phase Chams Film";
        stringArray[10] = "Prism Sky Wash";
        stringArray[11] = "Menu Mica Backdrop";
        stringArray[12] = "Vivid Veil";
        secondaryVal = Set.of(stringArray);
    }
}

