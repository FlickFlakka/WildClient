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
import java.util.Map;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;
import ru.metaculture.protection.ShaderCompileResult;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.GlDiagnostics;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.ShaderUniformParam;
import ru.metaculture.protection.FullscreenQuad;
import ru.metaculture.protection.ThemeShaderManager;
import ru.metaculture.protection.ThemeShaderProgramCache;
import ru.metaculture.protection.CoreDiagnosticsManager;
import ru.metaculture.protection.ShaderProgram;

public final class ThemeShaderRenderer {
    private ThemeShaderRenderer() {
    }

    public static boolean primaryVal(SurfaceTarget vnuVUNUv, float f, float f2, float f3, float f4, int n, int n2, float f5, float f6, ThemePalette configVal, float f7) {
        if (vnuVUNUv == null || f3 <= 1.0f || f4 <= 1.0f || n <= 0 || n2 <= 0 || f7 <= 0.001f) {
            return false;
        }
        ShaderCompileResult twigE = ThemeShaderManager.primaryVal().secondaryVal(vnuVUNUv);
        if (twigE == null) {
            return false;
        }
        ShaderProgram vVvUNNUVVnNn2 = ThemeShaderProgramCache.primaryVal().primaryVal(vnuVUNUv, twigE);
        return ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, twigE, ThemeShaderManager.primaryVal().limitVal(vnuVUNUv), f, f2, f3, f4, f, f2, f3, f4, 0.0f, n, n2, f5, f6, configVal, f7, ThemeShaderProgramCache.primaryVal().weightVal());
    }

    public static boolean primaryVal(String string, float f, float f2, float f3, float f4, int n, int n2, float f5, float f6, ThemePalette configVal, float f7) {
        block5: {
            block4: {
                if (string == null || f3 <= 1.0f || f4 <= 1.0f) break block4;
                if (n > 0 && n2 > 0 && !(f7 <= 0.001f)) break block5;
            }
            return false;
        }
        ShaderCompileResult twigE = ThemeShaderManager.primaryVal().secondaryVal(string);
        if (twigE == null) {
            return false;
        }
        ShaderProgram vVvUNNUVVnNn2 = ThemeShaderProgramCache.primaryVal().primaryVal(string, twigE);
        return ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, twigE, ThemeShaderManager.primaryVal().speedVal(string), f, f2, f3, f4, f, f2, f3, f4, 0.0f, n, n2, f5, f6, configVal, f7, ThemeShaderProgramCache.primaryVal().weightVal());
    }

    public static boolean primaryVal(String string, int n, float f, float f2, float f3, float f4, int n2, int n3, float f5, float f6, ThemePalette configVal, float f7) {
        block5: {
            block4: {
                if (string == null || f3 <= 1.0f || f4 <= 1.0f) break block4;
                if (n2 > 0 && n3 > 0 && !(f7 <= 0.001f)) break block5;
            }
            return false;
        }
        ShaderCompileResult twigE = ThemeShaderManager.primaryVal().secondaryVal(string);
        if (twigE == null) {
            return false;
        }
        ShaderProgram vVvUNNUVVnNn2 = ThemeShaderProgramCache.primaryVal().primaryVal(string, twigE);
        int n4 = n > 0 ? n : ThemeShaderProgramCache.primaryVal().weightVal();
        return ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, twigE, ThemeShaderManager.primaryVal().speedVal(string), f, f2, f3, f4, f, f2, f3, f4, 0.0f, n2, n3, f5, f6, configVal, f7, n4);
    }

    public static boolean primaryVal(SurfaceTarget vnuVUNUv, int n, float f, float f2, float f3, float f4, int n2, int n3, float f5, float f6, ThemePalette configVal, float f7) {
        block5: {
            block4: {
                if (vnuVUNUv == null || f3 <= 1.0f) break block4;
                if (f4 <= 1.0f || n2 <= 0 || n3 <= 0) break block4;
                if (!(f7 <= 0.001f)) break block5;
            }
            return false;
        }
        ShaderCompileResult twigE = ThemeShaderManager.primaryVal().secondaryVal(vnuVUNUv);
        if (twigE == null) {
            return false;
        }
        ShaderProgram vVvUNNUVVnNn2 = ThemeShaderProgramCache.primaryVal().primaryVal(vnuVUNUv, twigE);
        int n4 = n > 0 ? n : ThemeShaderProgramCache.primaryVal().weightVal();
        return ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, twigE, ThemeShaderManager.primaryVal().limitVal(vnuVUNUv), f, f2, f3, f4, f, f2, f3, f4, 0.0f, n2, n3, f5, f6, configVal, f7, n4);
    }

    public static boolean primaryVal(String string, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n, int n2, float f10, float f11, ThemePalette configVal, float f12) {
        block5: {
            block4: {
                if (string == null || f3 <= 1.0f || f4 <= 1.0f) break block4;
                if (!(f7 <= 1.0f) && !(f8 <= 1.0f) && n > 0 && n2 > 0 && !(f12 <= 0.001f)) break block5;
            }
            return false;
        }
        ShaderCompileResult twigE = ThemeShaderManager.primaryVal().secondaryVal(string);
        if (twigE == null) {
            return false;
        }
        ShaderProgram vVvUNNUVVnNn2 = ThemeShaderProgramCache.primaryVal().primaryVal(string, twigE);
        return ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, twigE, ThemeShaderManager.primaryVal().speedVal(string), f, f2, f3, f4, f5, f6, f7, f8, f9, n, n2, f10, f11, configVal, f12, ThemeShaderProgramCache.primaryVal().weightVal());
    }

    public static boolean primaryVal(SurfaceTarget vnuVUNUv, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n, int n2, float f10, float f11, ThemePalette configVal, float f12) {
        block5: {
            block4: {
                if (vnuVUNUv == null) break block4;
                if (!(f3 <= 1.0f || f4 <= 1.0f || f7 <= 1.0f || f8 <= 1.0f || n <= 0 || n2 <= 0) && !(f12 <= 0.001f)) break block5;
            }
            return false;
        }
        ShaderCompileResult twigE = ThemeShaderManager.primaryVal().secondaryVal(vnuVUNUv);
        if (twigE == null) {
            return false;
        }
        ShaderProgram vVvUNNUVVnNn2 = ThemeShaderProgramCache.primaryVal().primaryVal(vnuVUNUv, twigE);
        return ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, twigE, ThemeShaderManager.primaryVal().limitVal(vnuVUNUv), f, f2, f3, f4, f5, f6, f7, f8, f9, n, n2, f10, f11, configVal, f12, ThemeShaderProgramCache.primaryVal().weightVal());
    }

    public static boolean primaryVal(String string, ShaderCompileResult twigE, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n, int n2, float f10, float f11, ThemePalette configVal, float f12) {
        block3: {
            block2: {
                if (string == null) break block2;
                if (string.isBlank()) break block2;
                if (!(twigE == null || f3 <= 1.0f || f4 <= 1.0f || f7 <= 1.0f || f8 <= 1.0f || n <= 0 || n2 <= 0) && !(f12 <= 0.001f)) break block3;
            }
            return false;
        }
        ShaderProgram vVvUNNUVVnNn2 = ThemeShaderProgramCache.primaryVal().primaryVal(string, twigE);
        return ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, twigE, Map.of(), f, f2, f3, f4, f5, f6, f7, f8, f9, n, n2, f10, f11, configVal, f12, ThemeShaderProgramCache.primaryVal().weightVal());
    }

    public static boolean primaryVal(String string, ShaderCompileResult twigE, float f, float f2, float f3, float f4, int n, int n2, float f5, float f6, ThemePalette configVal, float f7) {
        block3: {
            block2: {
                if (string == null || string.isBlank() || twigE == null) break block2;
                if (!(f3 <= 1.0f) && !(f4 <= 1.0f) && n > 0 && n2 > 0 && !(f7 <= 0.001f)) break block3;
            }
            return false;
        }
        ShaderProgram vVvUNNUVVnNn2 = ThemeShaderProgramCache.primaryVal().primaryVal(string, twigE);
        return ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, twigE, Map.of(), f, f2, f3, f4, f, f2, f3, f4, 0.0f, n, n2, f5, f6, configVal, f7, ThemeShaderProgramCache.primaryVal().weightVal());
    }

    public static boolean primaryVal(String string, ShaderCompileResult twigE, int n, float f, float f2, float f3, float f4, int n2, int n3, float f5, float f6, ThemePalette configVal, float f7) {
        block3: {
            block2: {
                if (string == null || string.isBlank() || twigE == null) break block2;
                if (!(f3 <= 1.0f) && !(f4 <= 1.0f) && n2 > 0 && n3 > 0 && !(f7 <= 0.001f)) break block3;
            }
            return false;
        }
        ShaderProgram vVvUNNUVVnNn2 = ThemeShaderProgramCache.primaryVal().primaryVal(string, twigE);
        int n4 = n > 0 ? n : ThemeShaderProgramCache.primaryVal().weightVal();
        return ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, twigE, Map.of(), f, f2, f3, f4, f, f2, f3, f4, 0.0f, n2, n3, f5, f6, configVal, f7, n4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean primaryVal(ShaderProgram vVvUNNUVVnNn2, ShaderCompileResult twigE, Map<String, float[]> map, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n, int n2, float f10, float f11, ThemePalette configVal, float f12, int n3) {
        if (vVvUNNUVVnNn2 == null) {
            return false;
        }
        FullscreenQuad duneD = ThemeShaderProgramCache.primaryVal().secondaryVal();
        if (duneD == null) {
            return false;
        }
        int n4 = GlDiagnostics.primaryVal();
        int n5 = GlDiagnostics.secondaryVal();
        int n6 = GlDiagnostics.tertiaryVal();
        CoreDiagnosticsManager.primaryVal().speedVal();
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            GL11.glViewport((int)0, (int)0, (int)n, (int)n2);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glDepthMask((boolean)false);
            GlStateManager._enableBlend();
            GL11.glEnable((int)3042);
            GL14.glBlendFuncSeparate((int)770, (int)771, (int)1, (int)771);
            GL11.glDisable((int)36281);
            vVvUNNUVVnNn2.primaryVal();
            GL13.glActiveTexture((int)33984);
            GL11.glBindTexture((int)3553, (int)n3);
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "u_DiffuseMap", 0);
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "uViewport", n, n2);
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "uRect", f, f2, f3, f4);
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "u_ElementRect", f5, f6, f7, f8);
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "u_ElementRadius", Math.max(0.0f, f9));
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "u_Time", ThemeShaderProgramCache.primaryVal().tertiaryVal());
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "u_Resolution", Math.max(1.0f, (float)n), Math.max(1.0f, (float)n2));
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "u_GlobalUV", f5 / Math.max(1.0f, (float)n), f6 / Math.max(1.0f, (float)n2));
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "u_Mouse", f10 - f5, f11 - f6);
            int n7 = configVal == null ? -1 : configVal.depthVal();
            int n8 = configVal == null ? -16777216 : configVal.descRef();
            int n9 = configVal == null ? -15724520 : configVal.paramVal();
            int n10 = configVal == null ? -14671832 : configVal.extraVal();
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "u_AccentTop", ThemeShaderRenderer.primaryVal(n7), ThemeShaderRenderer.secondaryVal(n7), ThemeShaderRenderer.tertiaryVal(n7));
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "u_AccentBottom", ThemeShaderRenderer.primaryVal(n8), ThemeShaderRenderer.secondaryVal(n8), ThemeShaderRenderer.tertiaryVal(n8));
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "u_ThemeColors[0]", ThemeShaderRenderer.primaryVal(n9), ThemeShaderRenderer.secondaryVal(n9), ThemeShaderRenderer.tertiaryVal(n9), ThemeShaderRenderer.marginVal(n9));
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "u_ThemeColors[1]", ThemeShaderRenderer.primaryVal(n10), ThemeShaderRenderer.secondaryVal(n10), ThemeShaderRenderer.tertiaryVal(n10), ThemeShaderRenderer.marginVal(n10));
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "u_ThemeColors[2]", ThemeShaderRenderer.primaryVal(n7), ThemeShaderRenderer.secondaryVal(n7), ThemeShaderRenderer.tertiaryVal(n7), f12);
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "u_ThemeColors[3]", ThemeShaderRenderer.primaryVal(n8), ThemeShaderRenderer.secondaryVal(n8), ThemeShaderRenderer.tertiaryVal(n8), f12);
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, "u_Alpha", f12);
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, twigE, map);
            duneD.primaryVal();
            boolean bl = true;
            return bl;
        }
        catch (Throwable throwable) {
            CoreDiagnosticsManager.primaryVal().secondaryVal("ThemeShaderDispatcher.drawProgram", throwable);
            throw new IllegalStateException("unreachable shader failure", throwable);
        }
        finally {
            try {
                GL13.glActiveTexture((int)33984);
                GL11.glBindTexture((int)3553, (int)0);
                GL20.glUseProgram((int)0);
                GLStateSnapshot.tertiaryVal(modeVal);
                CoreDiagnosticsManager.primaryVal().primaryVal(n4, n5, n6);
            }
            catch (Throwable throwable) {
                CoreDiagnosticsManager.primaryVal().primaryVal(n4, n5, n6);
                throw throwable;
            }
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

    private static void primaryVal(ShaderProgram vVvUNNUVVnNn2, ShaderCompileResult twigE, Map<String, float[]> map) {
        if (vVvUNNUVVnNn2 == null || twigE == null || twigE.exposedUniforms().isEmpty()) {
            return;
        }
        for (ShaderUniformParam ccCoCoOCocoo2 : twigE.exposedUniforms()) {
            float f;
            float[] fArray;
            block7: {
                block6: {
                    float[] fArray2 = fArray = map == null ? null : map.get(ccCoCoOCocoo2.uniformName());
                    if (fArray == null) break block6;
                    if (fArray.length != 0) break block7;
                }
                fArray = ccCoCoOCocoo2.defaults();
            }
            if (ccCoCoOCocoo2.kind() == ShaderUniformParam.WildClient.FLOAT) {
                ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, ccCoCoOCocoo2.uniformName(), fArray[0]);
                continue;
            }
            float f2 = f = fArray.length > 0 ? fArray[0] : 0.0f;
            float f3 = fArray.length > 1 ? fArray[1] : 0.0f;
            float f4 = fArray.length > 2 ? fArray[2] : 0.0f;
            float f5 = fArray.length > 3 ? fArray[3] : 1.0f;
            ThemeShaderRenderer.primaryVal(vVvUNNUVVnNn2, ccCoCoOCocoo2.uniformName(), f, f3, f4, f5);
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
}

