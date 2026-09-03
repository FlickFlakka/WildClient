/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  org.lwjgl.glfw.GLFW
 */
package ru.metaculture.protection;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.Objects;
import net.minecraft.class_310;
import org.lwjgl.glfw.GLFW;
import org.wild.module.api.Module;
import ru.metaculture.protection.AccentColor;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.VvUNvVNnuUNU;
import ru.metaculture.protection.VvnNUnUu;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.SettingValueAccessor;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.SpringPhysicsParams;
import ru.metaculture.protection.SpringAnimatedFloat;
import ru.metaculture.protection.EasingPresets;
import ru.metaculture.protection.SettingEditorOpener;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.FrameTaskScheduler;

public final class FloatSettingPopup
implements VvnNUnUu {
    private static final float primaryVal = 80.0f;
    private static final float secondaryVal = 18.0f;
    private static final float tertiaryVal = 18.0f;
    private static final float marginVal = 17.0f;
    private static final float weightVal = 18.0f;
    private static final float paramVal = 20.0f;
    private static final float extraVal = 298.0f;
    private static final float limitVal = 6.0f;
    private static final float speedVal = 15.0f;
    private static final float widthVal = 3.0f;
    private static final float chunkVal = 18.0f;
    private static final float blockRef = 12.0f;
    private static final float holderVal = 1.35f;
    private static final int timerVal = -14606047;
    private static final int anchorVal = -2500135;
    private static final int weightRef = -7829368;
    private static final int bufferVal = -1;
    private static final SpringPhysicsParams countVal = SpringPhysicsParams.primaryVal(2.1f, 0.55f);
    private static final SpringPhysicsParams depthVal = SpringPhysicsParams.primaryVal(1.4f, 0.7f);
    private static final SpringPhysicsParams descRef = SpringPhysicsParams.primaryVal(8.0f, 0.8f);
    private static final SpringPhysicsParams activeVal = SpringPhysicsParams.primaryVal(1.8f, 0.65f);
    private static final float radiusVal = 5.0E-4f;
    private static final float factorVal = 5.0E-4f;
    private static final float sourceVal = 1.0E-4f;
    private static final double extraRef = 1.0E-4;
    private static final float phaseVal = 0.001f;
    private final Module limitRef;
    private final FloatSetting paramRef;
    private final SettingEditorOpener groupVal;
    private final SettingValueAccessor<Double> layerVal;
    private final String slotVal;
    private final SpringAnimatedFloat themeVal;
    private final SpringAnimatedFloat stageVal;
    private final SpringAnimatedFloat widthRef;
    private final SpringAnimatedFloat trackVal;
    private WildClient modeRef = WildClient.EMPTY;
    private WildClient angleVal = WildClient.EMPTY;
    private WildClient heightRef = WildClient.EMPTY;
    private boolean levelVal = false;
    private double UuNnnVnuNNV;
    private int depthRef;
    private boolean speedRef = false;

    public FloatSettingPopup(Module module, SettingEditorOpener baseD, FloatSetting itemA, SettingValueAccessor<Double> nNVnuNVvvv2) {
        this(module, baseD, itemA, nNVnuNVvvv2, null);
    }

    public FloatSettingPopup(Module module, SettingEditorOpener baseD, FloatSetting itemA, SettingValueAccessor<Double> nNVnuNVvvv2, String string) {
        double d;
        this.limitRef = Objects.requireNonNull(module, "module");
        this.groupVal = Objects.requireNonNull(baseD, "popupContext");
        this.paramRef = Objects.requireNonNull(itemA, "setting");
        this.layerVal = Objects.requireNonNull(nNVnuNVvvv2, "valueAccessor");
        this.slotVal = FloatSettingPopup.primaryVal(string);
        this.themeVal = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), countVal, 0.0f, 0.0f, 1.0f, 5.0E-4f, 5.0E-4f);
        this.themeVal.primaryVal(EasingPresets.tertiaryVal);
        this.stageVal = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), depthVal, 0.0f, 0.0f, 1.0f, 5.0E-4f, 5.0E-4f);
        this.stageVal.primaryVal(EasingPresets.tertiaryVal);
        Double d2 = nNVnuNVvvv2.primaryVal();
        this.UuNnnVnuNNV = d = d2 != null ? d2 : (double)itemA.marginVal;
        this.depthRef = FloatSettingPopup.marginVal(itemA.extraVal);
        float f = this.tertiaryVal(this.UuNnnVnuNNV);
        this.widthRef = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), descRef, f, 0.0f, 1.0f, 5.0E-4f, 5.0E-4f);
        this.trackVal = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), activeVal, 1.0f, 0.0f, 1.0f, 5.0E-4f, 5.0E-4f);
        this.trackVal.primaryVal(EasingPresets.tertiaryVal);
    }

    @Override
    public void primaryVal() {
        double d;
        Double d2 = this.layerVal.primaryVal();
        this.UuNnnVnuNNV = d = d2 != null ? d2 : (double)this.paramRef.marginVal;
        this.themeVal.tertiaryVal(this.levelVal ? 1.0f : 0.0f);
        this.widthRef.tertiaryVal(this.speedVal());
        this.blockRef();
    }

    @Override
    public void primaryVal(boolean bl) {
        float f = bl ? 1.0f : 0.0f;
        this.trackVal.tertiaryVal(f);
        if (!bl) {
            this.levelVal = false;
            this.speedRef = false;
            this.themeVal.tertiaryVal(0.0f);
            this.blockRef();
        }
    }

    @Override
    public void primaryVal(float f, float f2, float f3) {
        float f4 = Math.max(0.0f, this.extraVal());
        this.modeRef = new WildClient(f, f2, f3, 80.0f);
        this.angleVal = new WildClient(f, f2, f3, f4);
        float f5 = f + 18.0f;
        float f6 = f2 + 17.0f + 18.0f + 15.0f;
        this.heightRef = new WildClient(f5, f6, 298.0f, 6.0f);
    }

    @Override
    public float secondaryVal() {
        return 80.0f;
    }

    @Override
    public float extraVal() {
        return 80.0f * FloatSettingPopup.primaryVal(this.trackVal.primaryVal());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void primaryVal(Renderer2D heightVal, float f, float f2, float f3) {
        float f4 = FloatSettingPopup.primaryVal(this.trackVal.primaryVal());
        if (f4 <= 0.001f) {
            return;
        }
        float f5 = f * FloatSettingPopup.primaryVal(f2) * f4;
        if (f5 <= 1.0E-4f) {
            return;
        }
        heightVal.tertiaryVal(1.0f, f4, this.modeRef.x, this.modeRef.y);
        try {
            float f6;
            this.limitVal();
            float f7 = FloatSettingPopup.primaryVal(this.stageVal.primaryVal());
            int n = VvUNvVNnuUNU.primaryVal(-7829368, -1, f7);
            int n2 = FloatSettingPopup.primaryVal(n, f5);
            float f8 = this.modeRef.x + 18.0f;
            float f9 = this.modeRef.y + 17.0f + 18.0f;
            heightVal.primaryVal(FontRegistry.marginVal, f8, f9, 18.0f, this.widthVal(), n2, "l");
            float f10 = this.modeRef.y + 20.0f + 18.0f;
            float f11 = this.modeRef.x + this.modeRef.width - 18.0f;
            heightVal.primaryVal(FontRegistry.marginVal, f11, f10, 18.0f, this.chunkVal(), n2, "r");
            int n3 = FloatSettingPopup.primaryVal(-14606047, f5);
            heightVal.primaryVal(this.heightRef.x, this.heightRef.y, this.heightRef.width, this.heightRef.height, 3.0f, n3);
            float f12 = FloatSettingPopup.primaryVal(this.widthRef.primaryVal());
            float f13 = this.heightRef.width * f12;
            if (f13 > 0.0f) {
                int n4 = FloatSettingPopup.primaryVal(AccentColor.primaryVal(), f5);
                f6 = f13 >= this.heightRef.width - 0.01f ? 3.0f : 0.0f;
                heightVal.primaryVal(this.heightRef.x, this.heightRef.y, f13, this.heightRef.height, 3.0f, f6, f6, 3.0f, n4);
            }
            float f14 = this.heightRef.x + f13;
            f6 = this.heightRef.y + this.heightRef.height * 0.5f;
            float f15 = 1.0f + FloatSettingPopup.primaryVal(this.themeVal.primaryVal()) * 0.35000002f;
            float f16 = 12.0f * f15;
            float f17 = f16 * 0.5f;
            int n5 = FloatSettingPopup.primaryVal(-2500135, f5);
            heightVal.secondaryVal(f14, f6, f17, 0.0f, 1.0f, n5);
        }
        finally {
            heightVal.speedVal();
        }
    }

    @Override
    public boolean primaryVal(double d, double d2, int n) {
        block6: {
            block5: {
                if (!this.holderVal()) break block5;
                if (this.angleVal.contains(d, d2)) break block6;
            }
            return false;
        }
        if (n == 2) {
            Double d3 = this.layerVal.primaryVal();
            Double d4 = d3 != null ? d3 : (double)this.paramRef.marginVal;
            this.groupVal.openForSetting(this.limitRef, this.paramRef, d, d2, d4);
            return true;
        }
        if (n != 0) {
            return false;
        }
        this.levelVal = true;
        this.themeVal.tertiaryVal(1.0f);
        this.blockRef();
        return true;
    }

    @Override
    public Setting tertiaryVal() {
        return this.paramRef;
    }

    @Override
    public boolean marginVal() {
        return true;
    }

    @Override
    public boolean secondaryVal(double d, double d2, double d3, double d4) {
        class_310 class_3102;
        block8: {
            block7: {
                if (!this.holderVal() || !this.angleVal.contains(d, d2)) {
                    return false;
                }
                if (Math.abs(d4) <= 1.0E-4) {
                    return false;
                }
                class_3102 = class_310.method_1551();
                if (class_3102 == null) break block7;
                if (class_3102.method_22683() != null) break block8;
            }
            return false;
        }
        long l = class_3102.method_22683().method_4490();
        if (GLFW.glfwGetKey((long)l, (int)341) != 1) {
            return false;
        }
        if (!this.secondaryVal(d4)) {
            return false;
        }
        this.themeVal.tertiaryVal(1.0f);
        this.blockRef();
        return true;
    }

    @Override
    public void primaryVal(double d, double d2) {
        if (!this.holderVal()) {
            this.speedRef = false;
            this.blockRef();
            return;
        }
        this.speedRef = this.angleVal.contains(d, d2);
        this.blockRef();
    }

    private void limitVal() {
        if (!this.levelVal) {
            return;
        }
        if (!this.holderVal()) {
            this.levelVal = false;
            this.themeVal.tertiaryVal(0.0f);
            this.blockRef();
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.method_22683() == null) {
            this.levelVal = false;
            this.themeVal.tertiaryVal(0.0f);
            this.blockRef();
            return;
        }
        long l = class_3102.method_22683().method_4490();
        if (GLFW.glfwGetMouseButton((long)l, (int)0) != 1) {
            this.levelVal = false;
            this.themeVal.tertiaryVal(0.0f);
            this.blockRef();
            return;
        }
        double[] dArray = new double[1];
        double[] dArray2 = new double[1];
        GLFW.glfwGetCursorPos((long)l, (double[])dArray, (double[])dArray2);
        this.primaryVal(FloatSettingPopup.primaryVal(dArray[0], class_3102));
    }

    private void primaryVal(double d) {
        block6: {
            block5: {
                if (this.heightRef.width <= 0.0f) break block5;
                if (this.holderVal()) break block6;
            }
            return;
        }
        double d2 = Math.min(Math.max(d, (double)this.heightRef.x), (double)(this.heightRef.x + this.heightRef.width));
        double d3 = (d2 - (double)this.heightRef.x) / (double)this.heightRef.width;
        double d4 = this.paramRef.paramVal;
        double d5 = this.paramRef.weightVal;
        if (d4 <= d5) {
            return;
        }
        double d6 = d5 + (d4 - d5) * d3;
        if (Math.abs(d6 - this.UuNnnVnuNNV) <= (double)1.0E-4f) {
            return;
        }
        this.layerVal.primaryVal(d6);
        Double d7 = this.layerVal.primaryVal();
        this.UuNnnVnuNNV = d7 != null ? d7 : (double)this.paramRef.marginVal;
        this.widthRef.tertiaryVal(this.speedVal());
    }

    private boolean secondaryVal(double d) {
        double d2;
        double d3;
        double d4;
        double d5 = this.paramRef.extraVal;
        if (d5 <= 0.0) {
            return false;
        }
        double d6 = this.paramRef.weightVal;
        double d7 = this.paramRef.paramVal;
        double d8 = Math.signum(d);
        if (d8 == 0.0) {
            return false;
        }
        double d9 = Math.ceil(Math.abs(d));
        if (d9 <= 0.0) {
            d9 = 1.0;
        }
        if (Math.abs((d4 = Math.min(Math.max(d3 = this.UuNnnVnuNNV + d5 * d9 * d8, d6), d7)) - this.UuNnnVnuNNV) <= (double)1.0E-4f) {
            return false;
        }
        this.layerVal.primaryVal(d4);
        Double d10 = this.layerVal.primaryVal();
        this.UuNnnVnuNNV = d2 = d10 instanceof Number ? d10 : (double)this.paramRef.marginVal;
        this.blockRef();
        this.widthRef.tertiaryVal(this.speedVal());
        return true;
    }

    private float speedVal() {
        return this.tertiaryVal(this.UuNnnVnuNNV);
    }

    private float tertiaryVal(double d) {
        double d2 = this.paramRef.weightVal;
        double d3 = this.paramRef.paramVal;
        if (d3 <= d2) {
            return 0.0f;
        }
        double d4 = Math.min(Math.max(d, d2), d3);
        return (float)((d4 - d2) / (d3 - d2));
    }

    private String widthVal() {
        return this.slotVal != null ? this.slotVal : this.paramRef.primaryVal;
    }

    private static String primaryVal(String string) {
        if (string == null) {
            return null;
        }
        String string2 = string.trim();
        return string2.isEmpty() ? null : string2;
    }

    private String chunkVal() {
        if (this.depthRef <= 0) {
            return String.format(Locale.US, "%.0f", this.UuNnnVnuNNV);
        }
        Object[] objectArray = new Object[1];
        objectArray[0] = this.UuNnnVnuNNV;
        return String.format(Locale.US, "%1$." + this.depthRef + "f", objectArray);
    }

    private static int marginVal(double d) {
        BigDecimal bigDecimal = BigDecimal.valueOf(d);
        int n = bigDecimal.scale();
        if (n <= 0) {
            return 0;
        }
        BigDecimal bigDecimal2 = bigDecimal.stripTrailingZeros();
        return Math.max(0, bigDecimal2.scale());
    }

    private void blockRef() {
        float f = this.levelVal ? 1.0f : (this.speedRef && this.holderVal() ? 0.5f : 0.0f);
        this.stageVal.tertiaryVal(f);
    }

    private boolean holderVal() {
        return FloatSettingPopup.primaryVal(this.trackVal.primaryVal()) > 0.001f;
    }

    private static float primaryVal(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        return f;
    }

    private static int primaryVal(int n, float f) {
        int n2 = n >>> 24 & 0xFF;
        int n3 = Math.round((float)n2 * f);
        int n4 = n & 0xFFFFFF;
        return n3 << 24 | n4;
    }

    private static double primaryVal(double d, int n, float f) {
        block5: {
            block4: {
                if (n <= 0) {
                    return d;
                }
                if (!Float.isFinite(f)) break block4;
                if (!(Math.abs(f - 1.0f) <= 0.001f)) break block5;
            }
            return d;
        }
        double d2 = (double)n * 0.5;
        return d2 + (d - d2) / (double)f;
    }

    private static double primaryVal(double d, class_310 class_3102) {
        float f;
        int n;
        block6: {
            block5: {
                if (class_3102 == null || class_3102.method_22683() == null) {
                    return d;
                }
                n = class_3102.method_22683().method_4489();
                if (n <= 0) {
                    return d;
                }
                f = 1.0f;
                if (!Float.isFinite(f)) break block5;
                if (!(Math.abs(f) <= 1.0E-4f)) break block6;
            }
            return d;
        }
        return FloatSettingPopup.primaryVal(d, n, f);
    }

    static final class WildClient
     {
        final float x;
        final float y;
        final float width;
        final float height;
        static final WildClient EMPTY = new WildClient(0.0f, 0.0f, 0.0f, 0.0f);

        WildClient(float f, float f2, float f3, float f4) {
            this.x = f;
            this.y = f2;
            this.width = f3;
            this.height = f4;
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        boolean contains(double d, double d2) {
            if (!(d >= (double)this.x)) return false;
            if (!(d <= (double)(this.x + this.width))) return false;
            if (!(d2 >= (double)this.y)) return false;
            if (!(d2 <= (double)(this.y + this.height))) return false;
            return true;
        }

        @Override
        public final String toString() {
            return "WildClient[" + "x=" + this.x + ", " + "y=" + this.y + ", " + "width=" + this.width + ", " + "height=" + this.height + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.x, this.y, this.width, this.height);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            WildClient that = (WildClient)object;
            return java.util.Objects.equals(this.x, that.x) && java.util.Objects.equals(this.y, that.y) && java.util.Objects.equals(this.width, that.width) && java.util.Objects.equals(this.height, that.height);}

        public float x() {
            return this.x;
        }

        public float y() {
            return this.y;
        }

        public float width() {
            return this.width;
        }

        public float height() {
            return this.height;
        }
    }
}

