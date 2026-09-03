/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ru.metaculture.protection.ShaderCompileResult;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.ShaderUniformParam;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ThemeShaderManager;
import ru.metaculture.protection.ThemeShaderRenderer;
import ru.metaculture.protection.ThemeShaderProgramCache;
import ru.metaculture.protection.ShaderProgram;

public final class ThemeShaderFacade {
    private ThemeShaderFacade() {
    }

    public static boolean primaryVal(String string) {
        return ThemeShaderManager.primaryVal().weightVal(string);
    }

    public static boolean primaryVal(SurfaceTarget vnuVUNUv) {
        return ThemeShaderManager.primaryVal().weightVal(vnuVUNUv);
    }

    public static boolean primaryVal(String string, float f, float f2, float f3, float f4, int n, int n2, float f5, float f6, ThemePalette configVal, float f7) {
        return ThemeShaderRenderer.primaryVal(string, f, f2, f3, f4, n, n2, f5, f6, configVal, f7);
    }

    public static boolean primaryVal(SurfaceTarget vnuVUNUv, float f, float f2, float f3, float f4, int n, int n2, float f5, float f6, ThemePalette configVal, float f7) {
        return ThemeShaderRenderer.primaryVal(vnuVUNUv, f, f2, f3, f4, n, n2, f5, f6, configVal, f7);
    }

    public static boolean primaryVal(String string, int n, float f, float f2, float f3, float f4, int n2, int n3, float f5, float f6, ThemePalette configVal, float f7) {
        return ThemeShaderRenderer.primaryVal(string, n, f, f2, f3, f4, n2, n3, f5, f6, configVal, f7);
    }

    public static String secondaryVal(String string) {
        return ThemeShaderProgramCache.primaryVal().primaryVal(string);
    }

    public static String secondaryVal(SurfaceTarget vnuVUNUv) {
        return ThemeShaderProgramCache.primaryVal().primaryVal(vnuVUNUv);
    }

    public static String tertiaryVal(String string) {
        ShaderCompileResult twigE = ThemeShaderManager.primaryVal().secondaryVal(string);
        if (twigE != null && twigE.hash() != null) {
            return twigE.hash();
        }
        return ThemeShaderProgramCache.primaryVal().secondaryVal(string);
    }

    public static String tertiaryVal(SurfaceTarget vnuVUNUv) {
        ShaderCompileResult twigE = ThemeShaderManager.primaryVal().secondaryVal(vnuVUNUv);
        if (twigE != null) {
            if (twigE.hash() != null) {
                return twigE.hash();
            }
        }
        return ThemeShaderProgramCache.primaryVal().secondaryVal(vnuVUNUv);
    }

    public static ShaderProgram marginVal(String string) {
        String string2 = ThemeShaderManager.widthVal(string);
        if (string2.isBlank()) {
            return null;
        }
        ShaderCompileResult twigE = ThemeShaderManager.primaryVal().secondaryVal(string2);
        if (twigE == null) {
            return null;
        }
        return ThemeShaderProgramCache.primaryVal().primaryVal(string2, twigE);
    }

    public static ShaderProgram marginVal(SurfaceTarget vnuVUNUv) {
        if (vnuVUNUv == null) {
            return null;
        }
        ShaderCompileResult twigE = ThemeShaderManager.primaryVal().secondaryVal(vnuVUNUv);
        if (twigE == null) {
            return null;
        }
        return ThemeShaderProgramCache.primaryVal().primaryVal(vnuVUNUv, twigE);
    }

    public static List<ShaderUniformParam> weightVal(String string) {
        return ThemeShaderManager.primaryVal().limitVal(string);
    }

    public static List<ShaderUniformParam> weightVal(SurfaceTarget vnuVUNUv) {
        return ThemeShaderManager.primaryVal().extraVal(vnuVUNUv);
    }

    public static List<Setting> paramVal(String string) {
        return ThemeShaderFacade.primaryVal(ThemeShaderManager.primaryVal().limitVal(string));
    }

    public static List<Setting> paramVal(SurfaceTarget vnuVUNUv) {
        return ThemeShaderFacade.primaryVal(ThemeShaderManager.primaryVal().extraVal(vnuVUNUv));
    }

    public static void primaryVal(String string, String string2, float f) {
        ThemeShaderManager.primaryVal().primaryVal(string, string2, f);
    }

    public static void primaryVal(SurfaceTarget vnuVUNUv, String string, float f) {
        ThemeShaderManager.primaryVal().primaryVal(vnuVUNUv, string, f);
    }

    public static void primaryVal(String string, String string2, int n) {
        ThemeShaderManager.primaryVal().primaryVal(string, string2, n);
    }

    public static void primaryVal(SurfaceTarget vnuVUNUv, String string, int n) {
        ThemeShaderManager.primaryVal().primaryVal(vnuVUNUv, string, n);
    }

    public static void primaryVal(String string, List<Setting> list) {
        if (list == null) {
            return;
        }
        for (Setting nodeA : list) {
            if (nodeA instanceof FloatSetting) {
                FloatSetting itemA = (FloatSetting)nodeA;
                ThemeShaderFacade.primaryVal(string, itemA.primaryVal, itemA.marginVal);
                continue;
            }
            if (!(nodeA instanceof ColorSetting)) continue;
            ColorSetting nodeG = (ColorSetting)nodeA;
            ThemeShaderFacade.primaryVal(string, nodeG.primaryVal, nodeG.speedVal());
        }
    }

    public static void primaryVal(SurfaceTarget vnuVUNUv, List<Setting> list) {
        if (list == null) {
            return;
        }
        for (Setting nodeA : list) {
            if (nodeA instanceof FloatSetting) {
                FloatSetting itemA = (FloatSetting)nodeA;
                ThemeShaderFacade.primaryVal(vnuVUNUv, itemA.primaryVal, itemA.marginVal);
                continue;
            }
            if (!(nodeA instanceof ColorSetting)) continue;
            ColorSetting nodeG = (ColorSetting)nodeA;
            ThemeShaderFacade.primaryVal(vnuVUNUv, nodeG.primaryVal, nodeG.speedVal());
        }
    }

    public static void extraVal(String string) {
        ThemeShaderManager.primaryVal().primaryVal(string);
        ThemeShaderProgramCache.primaryVal().tertiaryVal(string);
    }

    public static void extraVal(SurfaceTarget vnuVUNUv) {
        ThemeShaderManager.primaryVal().primaryVal(vnuVUNUv);
        ThemeShaderProgramCache.primaryVal().tertiaryVal(vnuVUNUv);
    }

    public static void primaryVal() {
        ThemeShaderProgramCache.primaryVal().marginVal();
    }

    private static List<Setting> primaryVal(List<ShaderUniformParam> list) {
        ArrayList<Setting> arrayList = new ArrayList<Setting>();
        if (list == null) {
            return arrayList;
        }
        Iterator<ShaderUniformParam> iterator = list.iterator();
        while (iterator.hasNext()) {
            ShaderUniformParam ccCoCoOCocoo2 = iterator.next();
            if (ccCoCoOCocoo2.kind() == ShaderUniformParam.WildClient.FLOAT) {
                arrayList.add(new FloatSetting(ccCoCoOCocoo2.name(), ccCoCoOCocoo2.defaultFloat(), ccCoCoOCocoo2.minimum(), ccCoCoOCocoo2.maximum(), ccCoCoOCocoo2.increment(), false));
                continue;
            }
            arrayList.add(new ColorSetting(ccCoCoOCocoo2.name(), ccCoCoOCocoo2.defaultRgba()));
        }
        return arrayList;
    }
}

