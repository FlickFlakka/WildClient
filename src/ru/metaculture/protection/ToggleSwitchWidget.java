/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Objects;
import org.wild.module.api.Module;
import ru.metaculture.protection.AccentColor;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.VvUNvVNnuUNU;
import ru.metaculture.protection.VvnNUnUu;
import ru.metaculture.protection.SettingValueAccessor;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.SpringPhysicsParams;
import ru.metaculture.protection.SpringAnimatedFloat;
import ru.metaculture.protection.EasingPresets;
import ru.metaculture.protection.SettingEditorOpener;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.BoolSetting;
import ru.metaculture.protection.FrameTaskScheduler;

public final class ToggleSwitchWidget
implements VvnNUnUu {
    private static final float primaryVal = 62.0f;
    private static final float secondaryVal = 18.0f;
    private static final float tertiaryVal = 18.0f;
    private static final float marginVal = 5.0f;
    private static final float weightVal = 22.0f;
    private static final float paramVal = 4.0f;
    private static final float extraVal = 18.0f;
    private static final float limitVal = 16.0f;
    private static final float speedVal = 5.0f;
    private static final SpringPhysicsParams widthVal = SpringPhysicsParams.primaryVal(2.1f, 0.55f);
    private static final float chunkVal = 0.001f;
    private static final SpringPhysicsParams blockRef = SpringPhysicsParams.primaryVal(1.4f, 0.7f);
    private final Module holderVal;
    private final BoolSetting timerVal;
    private final SettingEditorOpener anchorVal;
    private final SettingValueAccessor<Boolean> weightRef;
    private final String bufferVal;
    private final SpringAnimatedFloat countVal;
    private final SpringAnimatedFloat depthVal;
    private Bounds descRef = Bounds.EMPTY;
    private Bounds activeVal = Bounds.EMPTY;
    private float radiusVal = 0.0f;
    private float factorVal = 0.0f;
    private boolean sourceVal = false;

    public ToggleSwitchWidget(Module module, SettingEditorOpener baseD, BoolSetting vvNnnUNnVvn2, SettingValueAccessor<?> nNVnuNVvvv2) {
        this(module, baseD, vvNnnUNnVvn2, nNVnuNVvvv2, null);
    }

    public ToggleSwitchWidget(Module module, SettingEditorOpener baseD, BoolSetting vvNnnUNnVvn2, SettingValueAccessor<?> nNVnuNVvvv2, String string) {
        this.holderVal = Objects.requireNonNull(module, "module");
        this.anchorVal = Objects.requireNonNull(baseD, "popupContext");
        this.timerVal = Objects.requireNonNull(vvNnnUNnVvn2, "setting");
        this.weightRef = (SettingValueAccessor<Boolean>)Objects.requireNonNull(nNVnuNVvvv2, "valueAccessor");
        this.bufferVal = ToggleSwitchWidget.primaryVal(string);
        Object obj = nNVnuNVvvv2.primaryVal();
        boolean bl = obj instanceof Boolean ? (Boolean)obj : false;
        float f = bl ? 1.0f : 0.0f;
        this.countVal = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), widthVal, f, 0.0f, 1.0f, 5.0E-4f, 5.0E-4f);
        this.countVal.primaryVal(EasingPresets.primaryVal);
        this.depthVal = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), blockRef, f, 0.0f, 1.0f, 5.0E-4f, 5.0E-4f);
        this.depthVal.primaryVal(EasingPresets.tertiaryVal);
    }

    @Override
    public void primaryVal() {
        Boolean bl = this.weightRef.primaryVal();
        boolean bl2 = bl instanceof Boolean ? bl : false;
        this.countVal.tertiaryVal(bl2 ? 1.0f : 0.0f);
        this.limitVal();
    }

    @Override
    public void primaryVal(float f, float f2, float f3) {
        this.descRef = new Bounds(f, f2, f3, 62.0f);
        float f4 = f + f3 - 18.0f - 22.0f;
        float f5 = f2 + 20.0f;
        this.activeVal = new Bounds(f4, f5, 22.0f, 22.0f);
        this.radiusVal = f + 18.0f;
        this.factorVal = f2 + 31.0f + 5.0f;
    }

    @Override
    public float secondaryVal() {
        return 62.0f;
    }

    @Override
    public void primaryVal(Renderer2D heightVal, float f, float f2, float f3) {
        float f4 = f * (float)ToggleSwitchWidget.primaryVal(f2);
        if (f4 <= 0.0f) {
            return;
        }
        float f5 = this.countVal.primaryVal();
        double d = ToggleSwitchWidget.primaryVal(f4 * f5);
        if (d > (double)0.001f) {
            heightVal.primaryVal(this.activeVal.x + 1.0f, this.activeVal.y + 1.0f, this.activeVal.width - 2.0f, this.activeVal.height - 2.0f, 4.0f, VvUNvVNnuUNU.primaryVal(AccentColor.primaryVal(), d));
        }
        double d2 = ToggleSwitchWidget.primaryVal(f4);
        heightVal.primaryVal(this.activeVal.x, this.activeVal.y, this.activeVal.width, this.activeVal.height, 4.0f, VvUNvVNnuUNU.primaryVal(0x4F4F4E, d2), 1.0f);
        double d3 = ToggleSwitchWidget.primaryVal(f5 * f4);
        if (d3 > (double)0.001f) {
            heightVal.primaryVal(FontRegistry.tertiaryVal, this.activeVal.centerX(), this.activeVal.centerY() + 5.0f + 3.0f, 16.0f, "\ue5ca", VvUNvVNnuUNU.primaryVal(0xFFFFFF, d3), "c");
        }
        double d4 = ToggleSwitchWidget.primaryVal(f4);
        float f6 = this.depthVal.primaryVal();
        int n = VvUNvVNnuUNU.primaryVal(0x888888, d4);
        int n2 = VvUNvVNnuUNU.primaryVal(0xFFFFFF, d4);
        int n3 = VvUNvVNnuUNU.primaryVal(n, n2, f6);
        heightVal.primaryVal(FontRegistry.marginVal, this.radiusVal, this.factorVal, 18.0f, this.speedVal(), n3, "l");
    }

    @Override
    public boolean primaryVal(double d, double d2, int n) {
        boolean bl;
        if (!this.descRef.contains(d, d2)) {
            return false;
        }
        if (n == 2) {
            Boolean bl2 = this.weightRef.primaryVal();
            Boolean bl3 = bl2 instanceof Boolean ? bl2 : false;
            this.anchorVal.openForSetting(this.holderVal, this.timerVal, d, d2, bl3);
            return true;
        }
        if (n != 0) {
            return false;
        }
        Boolean bl4 = this.weightRef.primaryVal();
        boolean bl5 = bl = bl4 instanceof Boolean ? bl4 : false;
        boolean bl6 = !bl;
        this.weightRef.primaryVal(bl6);
        this.countVal.tertiaryVal(bl6 ? 1.0f : 0.0f);
        return true;
    }

    @Override
    public Setting tertiaryVal() {
        return this.timerVal;
    }

    @Override
    public boolean marginVal() {
        return true;
    }

    @Override
    public void primaryVal(double d, double d2) {
        this.sourceVal = this.descRef.contains(d, d2);
        this.limitVal();
    }

    private void limitVal() {
        boolean bl;
        Boolean bl2 = this.weightRef.primaryVal();
        boolean bl3 = bl = bl2 instanceof Boolean ? bl2 : false;
        float f = bl ? 1.0f : (this.sourceVal ? 0.5f : 0.0f);
        this.depthVal.tertiaryVal(f);
    }

    private String speedVal() {
        return this.bufferVal != null ? this.bufferVal : this.timerVal.primaryVal;
    }

    private static String primaryVal(String string) {
        if (string == null) {
            return null;
        }
        String string2 = string.trim();
        return string2.isEmpty() ? null : string2;
    }

    private static double primaryVal(double d) {
        if (d <= 0.0) {
            return 0.0;
        }
        if (d >= 1.0) {
            return 1.0;
        }
        return d;
    }

    static final class Bounds
     {
        final float x;
        final float y;
        final float width;
        final float height;
        static final Bounds EMPTY = new Bounds(0.0f, 0.0f, 0.0f, 0.0f);

        Bounds(float f, float f2, float f3, float f4) {
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

        float centerX() {
            return this.x + this.width * 0.5f;
        }

        float centerY() {
            return this.y + this.height * 0.5f;
        }

        @Override
        public final String toString() {
            return "Bounds[" + "x=" + this.x + ", " + "y=" + this.y + ", " + "width=" + this.width + ", " + "height=" + this.height + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.x, this.y, this.width, this.height);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            Bounds that = (Bounds)object;
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

