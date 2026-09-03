/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.class_310;
import org.wild.module.api.Module;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.AnimatedFloat;
import ru.metaculture.protection.EaseInOutQuadAnim;
import ru.metaculture.protection.AnimationEasing;
import ru.metaculture.protection.CurveAnimatedValue;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.VwVVvwWW;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.AnimatedValue;
import ru.metaculture.protection.SmoothedValue;
import ru.metaculture.protection.BoolSetting;

public class BlurEffectState {
    public static class_310 primaryVal = class_310.method_1551();
    public static AnimatedFloat secondaryVal = new EaseInOutQuadAnim(200, 1.0);
    public static AnimatedFloat tertiaryVal = new EaseInOutQuadAnim(500, 1.0);
    public static AnimatedFloat marginVal = new EaseInOutQuadAnim(500, 1.0);
    public static AnimatedFloat weightVal = new EaseInOutQuadAnim(500, 1.0);
    public static AnimatedFloat paramVal = new EaseInOutQuadAnim(1000, 1.0);
    public static BoolSetting extraVal = new BoolSetting("Need blur?", true);
    public static SmoothedValue limitVal = new SmoothedValue(AnimationEasing.EASE_OUT_SINE, 1500L);
    public static CurveAnimatedValue speedVal = new CurveAnimatedValue();
    public static AnimatedValue widthVal = new AnimatedValue();
    public static AnimatedValue chunkVal = new AnimatedValue();
    public static AnimatedValue blockRef = new AnimatedValue();
    public static AnimatedValue holderVal = new AnimatedValue();
    public static AnimatedValue timerVal = new AnimatedValue();
    public static ColorSetting anchorVal = null;
    public static float weightRef = 0.0f;
    public static float bufferVal = 0.0f;
    public static boolean countVal = false;
    public static boolean depthVal = false;
    public static boolean descRef = false;
    public static KeybindSetting activeVal = null;
    public static StringFilterSetting radiusVal = null;
    public static FloatSetting factorVal = null;
    public static Module sourceVal = null;
    public static float extraRef = 0.0f;
    public static float phaseVal = 0.0f;
    public static float limitRef = 0.0f;
    public static String paramRef = "";
    public static boolean groupVal = false;
    public static long layerVal = 0L;
    public static boolean slotVal = false;
    public static long themeVal = 0L;
    public static final int stageVal = -200;
    public static final int widthRef = -201;
    public static boolean trackVal = false;
    public static float modeRef;
    public static float angleVal;
    public static float heightRef;
    public static float levelVal;
    public static int UuNnnVnuNNV;
    public static int depthRef;
    public static ModuleCategory[] speedRef;
    public static NvVNvUvunNNu countRef;
    public static NvVNvUvunNNu entryVal;
    public static NvVNvUvunNNu[] guardVal;
    public static ModuleCategory VUuuVUnun;
    public static List<Module> vVVuuVVv;
    private static VwVVvwWW nodeB;
    public static Set<Module> VuunNUUUvu;
    public static Map<Module, AnimatedValue> NNUUNUuVNNVn;
    public static Map<Module, AnimatedValue> VvVvnNUnvuvV;
    public static Map<Module, AnimatedValue> tokenVal;
    public static Map<FloatSetting, AnimatedValue> NUVvUUVuVNVv;

    public static VwVVvwWW primaryVal() {
        if (nodeB == null) {
            nodeB = new VwVVvwWW();
        }
        return nodeB;
    }

    public static AnimatedValue primaryVal(Module module2) {
        return NNUUNUuVNNVn.computeIfAbsent(module2, module -> new AnimatedValue());
    }

    public static AnimatedValue secondaryVal(Module module2) {
        return VvVvnNUnvuvV.computeIfAbsent(module2, module -> new AnimatedValue());
    }

    public static AnimatedValue tertiaryVal(Module module2) {
        AnimatedValue cellJ = tokenVal.computeIfAbsent(module2, module -> new AnimatedValue());
        if (module2.keyIndex != -1) {
            if (cellJ.limitVal() == 0.0 && cellJ.chunkVal() == 0.0) {
                cellJ.marginVal(1.0);
            }
        }
        return cellJ;
    }

    public static AnimatedValue primaryVal(FloatSetting itemA) {
        AnimatedValue cellJ = NUVvUUVuVNVv.computeIfAbsent(itemA, kelpE -> {
            AnimatedValue entry = new AnimatedValue();
            float f = (itemA.marginVal - itemA.weightVal) / (itemA.paramVal - itemA.weightVal);
            entry.marginVal(f);
            return entry;
        });
        return cellJ;
    }

    static {
        UuNnnVnuNNV = 0;
        depthRef = 0;
        VuunNUUUvu = new HashSet<Module>();
        NNUUNUuVNNVn = new HashMap<Module, AnimatedValue>();
        VvVvnNUnvuvV = new HashMap<Module, AnimatedValue>();
        tokenVal = new HashMap<Module, AnimatedValue>();
        NUVvUUVuVNVv = new HashMap<FloatSetting, AnimatedValue>();
    }
}

