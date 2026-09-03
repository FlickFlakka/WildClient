/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL13
 *  org.lwjgl.opengl.GL14
 *  org.lwjgl.opengl.GL20
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;
import ru.metaculture.protection.ShaderCompileResult;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.UvnUNnnVnu;
import ru.metaculture.protection.ShaderPresetMeta;
import ru.metaculture.protection.VnnVNVNVUnnn;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.ShaderUniformParam;
import ru.metaculture.protection.FoundryStorage;
import ru.metaculture.protection.FullscreenQuad;
import ru.metaculture.protection.NodeGraph;
import ru.metaculture.protection.NodeDefinitionRegistry;
import ru.metaculture.protection.NodeGraphCompiler;
import ru.metaculture.protection.ThemeShaderProgramCache;
import ru.metaculture.protection.CoreDiagnosticsManager;
import ru.metaculture.protection.ShaderProgram;

public final class NuVunNnUvvN {
    private static final NuVunNnUvvN primaryVal = new NuVunNnUvvN();
    private final Map<String, WildClient> secondaryVal = new HashMap<String, WildClient>();
    private NodeGraphCompiler tertiaryVal;
    private NodeDefinitionRegistry marginVal;

    private NuVunNnUvvN() {
    }

    public static NuVunNnUvvN primaryVal() {
        return primaryVal;
    }

    public synchronized void primaryVal(NodeGraphCompiler coreE, NodeDefinitionRegistry nodeI) {
        this.tertiaryVal = coreE;
        this.marginVal = nodeI;
    }

    public synchronized boolean primaryVal(String string, float f, float f2, float f3, float f4, int n, int n2, float f5, float f6, ThemePalette configVal, float f7) {
        return this.primaryVal(string, null, f, f2, f3, f4, f, f2, f3, f4, 0.0f, n, n2, f5, f6, configVal, f7);
    }

    public synchronized boolean primaryVal(String string, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n, int n2, float f10, float f11, ThemePalette configVal, float f12) {
        return this.primaryVal(string, SurfaceTarget.HUD, f, f2, f3, f4, f5, f6, f7, f8, f9, n, n2, f10, f11, configVal, f12);
    }

    private boolean primaryVal(String string, SurfaceTarget vnuVUNUv, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n, int n2, float f10, float f11, ThemePalette configVal, float f12) {
        block12: {
            block11: {
                if (string == null || string.isBlank() || this.tertiaryVal == null || this.marginVal == null) {
                    return false;
                }
                if (f3 <= 1.0f || f4 <= 1.0f || f7 <= 1.0f || f8 <= 1.0f) break block11;
                if (!(f12 <= 0.001f)) break block12;
            }
            return false;
        }
        WildClient modeVal = this.primaryVal(string, vnuVUNUv);
        if (modeVal == null || modeVal.tertiaryVal == null) {
            return false;
        }
        FullscreenQuad duneD = ThemeShaderProgramCache.primaryVal().secondaryVal();
        if (duneD == null) {
            return false;
        }
        GLStateSnapshot.Snapshot nodeC = GLStateSnapshot.primaryVal();
        try {
            GL11.glViewport((int)0, (int)0, (int)n, (int)n2);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GlStateManager._enableBlend();
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GL11.glDisable((int)36281);
            modeVal.tertiaryVal.primaryVal();
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)ThemeShaderProgramCache.primaryVal().weightVal());
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "u_DiffuseMap", 0);
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "uViewport", n, n2);
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "uRect", f, f2, f3, f4);
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "u_ElementRect", f5, f6, f7, f8);
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "u_ElementRadius", Math.max(0.0f, f9));
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "u_Time", ThemeShaderProgramCache.primaryVal().tertiaryVal());
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "u_Resolution", Math.max(1.0f, (float)n), Math.max(1.0f, (float)n2));
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "u_GlobalUV", f5 / Math.max(1.0f, (float)n), f6 / Math.max(1.0f, (float)n2));
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "u_Mouse", f10 - f5, f11 - f6);
            int n3 = configVal == null ? -1 : configVal.depthVal();
            int n4 = configVal == null ? -16777216 : configVal.descRef();
            int n5 = configVal == null ? -15724520 : configVal.paramVal();
            int n6 = configVal == null ? -14671832 : configVal.extraVal();
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "u_AccentTop", NuVunNnUvvN.primaryVal(n3), NuVunNnUvvN.secondaryVal(n3), NuVunNnUvvN.tertiaryVal(n3));
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "u_AccentBottom", NuVunNnUvvN.primaryVal(n4), NuVunNnUvvN.secondaryVal(n4), NuVunNnUvvN.tertiaryVal(n4));
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "u_ThemeColors[0]", NuVunNnUvvN.primaryVal(n5), NuVunNnUvvN.secondaryVal(n5), NuVunNnUvvN.tertiaryVal(n5), NuVunNnUvvN.marginVal(n5));
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "u_ThemeColors[1]", NuVunNnUvvN.primaryVal(n6), NuVunNnUvvN.secondaryVal(n6), NuVunNnUvvN.tertiaryVal(n6), NuVunNnUvvN.marginVal(n6));
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "u_ThemeColors[2]", NuVunNnUvvN.primaryVal(n3), NuVunNnUvvN.secondaryVal(n3), NuVunNnUvvN.tertiaryVal(n3), f12);
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "u_ThemeColors[3]", NuVunNnUvvN.primaryVal(n4), NuVunNnUvvN.secondaryVal(n4), NuVunNnUvvN.tertiaryVal(n4), f12);
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, "u_Alpha", f12);
            NuVunNnUvvN.primaryVal(modeVal.tertiaryVal, modeVal.secondaryVal);
            duneD.primaryVal();
            boolean bl = true;
            return bl;
        }
        catch (Throwable throwable) {
            CoreDiagnosticsManager.primaryVal().secondaryVal("NamedThemeCache.draw:" + string, throwable);
            throw new IllegalStateException("unreachable shader failure", throwable);
        }
        finally {
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)0);
            GL20.glUseProgram((int)0);
            GLStateSnapshot.tertiaryVal(nodeC);
        }
    }

    public synchronized void primaryVal(String string) {
        if (string == null) {
            return;
        }
        String string2 = string.trim();
        this.secondaryVal.entrySet().removeIf(entry -> {
            String key = (String)entry.getKey();
            if (!key.equals(string2)) {
                if (!key.startsWith(string2 + "#")) return false;
            }
            boolean bl = true;
            boolean bl2 = bl;
            if (!bl2) return bl2;
            if (entry.getValue() == null) return bl2;
            if (((WildClient)entry.getValue()).tertiaryVal == null) return bl2;
            ((WildClient)entry.getValue()).tertiaryVal.secondaryVal();
            ((WildClient)entry.getValue()).tertiaryVal = null;
            return bl2;
        });
        ShaderPresetMeta vUvUNNUvvNVN2 = FoundryStorage.primaryVal().secondaryVal().stream().filter(vUvUNNUvvNVN -> {
            if (string2.equals(vUvUNNUvvNVN.secondaryVal())) return true;
            if (!string2.equals(vUvUNNUvvNVN.primaryVal())) return false;
            return true;
        }).findFirst().orElse(null);
        if (vUvUNNUvvNVN2 != null) {
            if (!vUvUNNUvvNVN2.primaryVal().equals(string2)) {
                String string3 = vUvUNNUvvNVN2.primaryVal();
                this.secondaryVal.entrySet().removeIf(entry -> {
                    String key = (String)entry.getKey();
                    if (!key.equals(string3)) {
                        if (!key.startsWith(string3 + "#")) return false;
                    }
                    boolean bl = true;
                    boolean bl2 = bl;
                    if (!bl2) return bl2;
                    if (entry.getValue() == null) return bl2;
                    if (((WildClient)entry.getValue()).tertiaryVal == null) return bl2;
                    ((WildClient)entry.getValue()).tertiaryVal.secondaryVal();
                    ((WildClient)entry.getValue()).tertiaryVal = null;
                    return bl2;
                });
            }
        }
    }

    public synchronized void secondaryVal() {
        for (WildClient modeVal : this.secondaryVal.values()) {
            if (modeVal.tertiaryVal == null) continue;
            modeVal.tertiaryVal.secondaryVal();
            modeVal.tertiaryVal = null;
        }
        this.secondaryVal.clear();
    }

    private WildClient primaryVal(String string, SurfaceTarget vnuVUNUv) {
        ShaderPresetMeta vUvUNNUvvNVN2 = FoundryStorage.primaryVal().secondaryVal().stream().filter(vUvUNNUvvNVN -> string.equals(vUvUNNUvvNVN.primaryVal()) || string.equals(vUvUNNUvvNVN.secondaryVal())).findFirst().orElse(null);
        if (vUvUNNUvvNVN2 == null) {
            return null;
        }
        String string2 = vnuVUNUv == null ? vUvUNNUvvNVN2.primaryVal() : vUvUNNUvvNVN2.primaryVal() + "#" + vnuVUNUv.primaryVal();
        WildClient modeVal = this.secondaryVal.get(string2);
        String string3 = vnuVUNUv == null ? vUvUNNUvvNVN2.marginVal() : vUvUNNUvvNVN2.marginVal() + "#" + vnuVUNUv.primaryVal();
        if (modeVal != null && modeVal.primaryVal != null && modeVal.primaryVal.equals(string3) && modeVal.tertiaryVal != null) {
            return modeVal;
        }
        try {
            NodeGraph nuVVnvn2 = VnnVNVNVUnnn.primaryVal(vUvUNNUvvNVN2.marginVal(), this.marginVal);
            if (vnuVUNUv != null) {
                nuVVnvn2.primaryVal(vnuVUNUv.primaryVal());
            }
            ShaderCompileResult twigE = this.tertiaryVal.primaryVal(nuVVnvn2);
            if (modeVal != null && modeVal.tertiaryVal != null) {
                modeVal.tertiaryVal.secondaryVal();
                modeVal.tertiaryVal = null;
            }
            if (modeVal == null) {
                modeVal = new WildClient();
                this.secondaryVal.put(string2, modeVal);
            }
            modeVal.primaryVal = string3;
            modeVal.secondaryVal = twigE;
            modeVal.tertiaryVal = new ShaderProgram(UvnUNnnVnu.primaryVal("assets/wild/shaders/mainmenu/menu_quad.vert"), twigE.fragmentSource());
            modeVal.marginVal = twigE.error();
            return modeVal;
        }
        catch (Throwable throwable) {
            if (modeVal == null) {
                modeVal = new WildClient();
                this.secondaryVal.put(vUvUNNUvvNVN2.primaryVal(), modeVal);
            }
            modeVal.marginVal = throwable.getMessage() == null ? throwable.getClass().getSimpleName() : throwable.getMessage();
            modeVal.tertiaryVal = null;
            modeVal.secondaryVal = null;
            CoreDiagnosticsManager.primaryVal().secondaryVal("NamedThemeCache.compile:" + vUvUNNUvvNVN2.primaryVal(), throwable);
            throw new IllegalStateException("unreachable shader failure", throwable);
        }
    }

    private static void primaryVal(ShaderProgram vVvUNNUVVnNn2, String string, float f) {
        int n = vVvUNNUVVnNn2.primaryVal(string);
        if (n >= 0) {
            GL20.glUniform1f((int)n, (float)f);
        }
    }

    private static void primaryVal(ShaderProgram vVvUNNUVVnNn2, String string, int n) {
        int n2 = vVvUNNUVVnNn2.primaryVal(string);
        if (n2 >= 0) {
            GL20.glUniform1i((int)n2, (int)n);
        }
    }

    private static void primaryVal(ShaderProgram vVvUNNUVVnNn2, String string, float f, float f2) {
        int n = vVvUNNUVVnNn2.primaryVal(string);
        if (n >= 0) {
            GL20.glUniform2f((int)n, (float)f, (float)f2);
        }
    }

    private static void primaryVal(ShaderProgram vVvUNNUVVnNn2, String string, float f, float f2, float f3) {
        int n = vVvUNNUVVnNn2.primaryVal(string);
        if (n >= 0) {
            GL20.glUniform3f((int)n, (float)f, (float)f2, (float)f3);
        }
    }

    private static void primaryVal(ShaderProgram vVvUNNUVVnNn2, String string, float f, float f2, float f3, float f4) {
        int n = vVvUNNUVVnNn2.primaryVal(string);
        if (n >= 0) {
            GL20.glUniform4f((int)n, (float)f, (float)f2, (float)f3, (float)f4);
        }
    }

    private static void primaryVal(ShaderProgram vVvUNNUVVnNn2, ShaderCompileResult twigE) {
        block6: {
            block5: {
                if (vVvUNNUVVnNn2 == null || twigE == null) break block5;
                if (!twigE.exposedUniforms().isEmpty()) break block6;
            }
            return;
        }
        for (ShaderUniformParam ccCoCoOCocoo2 : twigE.exposedUniforms()) {
            float[] fArray = ccCoCoOCocoo2.defaults();
            if (ccCoCoOCocoo2.kind() == ShaderUniformParam.WildClient.FLOAT) {
                NuVunNnUvvN.primaryVal(vVvUNNUVVnNn2, ccCoCoOCocoo2.uniformName(), fArray[0]);
                continue;
            }
            float f = fArray.length > 0 ? fArray[0] : 0.0f;
            float f2 = fArray.length > 1 ? fArray[1] : 0.0f;
            float f3 = fArray.length > 2 ? fArray[2] : 0.0f;
            float f4 = fArray.length > 3 ? fArray[3] : 1.0f;
            NuVunNnUvvN.primaryVal(vVvUNNUVVnNn2, ccCoCoOCocoo2.uniformName(), f, f2, f3, f4);
        }
    }

    private static float primaryVal(int n) {
        return (float)(n >> 16 & 0xFF) / 255.0f;
    }

    private static float secondaryVal(int n) {
        return (float)(n >> 8 & 0xFF) / 255.0f;
    }

    private static float tertiaryVal(int n) {
        return (float)(n & 0xFF) / 255.0f;
    }

    private static float marginVal(int n) {
        return (float)(n >>> 24 & 0xFF) / 255.0f;
    }

    static final class WildClient {
        String primaryVal = "";
        ShaderCompileResult secondaryVal;
        ShaderProgram tertiaryVal;
        String marginVal = "";

        WildClient() {
        }
    }
}

