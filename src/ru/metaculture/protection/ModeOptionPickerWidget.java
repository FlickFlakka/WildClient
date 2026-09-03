/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.wild.module.api.Module;
import ru.metaculture.protection.AccentColor;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.VvUNvVNnuUNU;
import ru.metaculture.protection.VvnNUnUu;
import ru.metaculture.protection.SettingValueAccessor;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.SpringPhysicsParams;
import ru.metaculture.protection.SpringAnimatedFloat;
import ru.metaculture.protection.EasingPresets;
import ru.metaculture.protection.SettingEditorOpener;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.FrameTaskScheduler;

public final class ModeOptionPickerWidget
implements VvnNUnUu {
    private static final float primaryVal = 100.0f;
    private static final float secondaryVal = 18.0f;
    private static final float tertiaryVal = 18.0f;
    private static final float marginVal = 17.0f;
    private static final float weightVal = 8.0f;
    private static final float paramVal = 298.0f;
    private static final float extraVal = 38.0f;
    private static final float limitVal = 6.0f;
    private static final float speedVal = 18.0f;
    private static final int widthVal = -14408668;
    private static final float chunkVal = 16.0f;
    private static final float blockRef = 16.0f;
    private static final float holderVal = 6.0f;
    private static final int timerVal = -7829368;
    private static final int anchorVal = -1;
    private static final float weightRef = 40.0f;
    private static final float bufferVal = 24.0f;
    private static final int countVal = 58131;
    private static final SpringPhysicsParams depthVal = SpringPhysicsParams.primaryVal(1.4f, 0.7f);
    private static final SpringPhysicsParams descRef = SpringPhysicsParams.primaryVal(2.1f, 0.55f);
    private static final float activeVal = 38.0f;
    private static final int radiusVal = -14408668;
    private static final int factorVal = -13750738;
    private static final float sourceVal = 18.0f;
    private static final float extraRef = 6.0f;
    private static final int phaseVal = -1;
    private static final float limitRef = 1.0E-4f;
    private static final float paramRef = 0.001f;
    private final Module groupVal;
    private final ModeSetting layerVal;
    private final SettingEditorOpener slotVal;
    private final SettingValueAccessor<String> themeVal;
    private final String stageVal;
    private final List<String> widthRef;
    private final SpringAnimatedFloat trackVal;
    private final SpringAnimatedFloat modeRef;
    private final List<SpringAnimatedFloat> angleVal;
    private static float heightRef = Float.NaN;
    private OptionRect levelVal = OptionRect.EMPTY;
    private OptionRect UuNnnVnuNNV = OptionRect.EMPTY;
    private OptionRect depthRef = OptionRect.EMPTY;
    private OptionRect speedRef = OptionRect.EMPTY;
    private final List<OptionRect> countRef = new ArrayList<OptionRect>();
    private float entryVal = 0.0f;
    private float guardVal = 0.0f;
    private boolean VUuuVUnun = false;
    private boolean vVVuuVVv = false;
    private int VuunNUUUvu = -1;

    public ModeOptionPickerWidget(Module module, SettingEditorOpener baseD, ModeSetting twigG, SettingValueAccessor<String> nNVnuNVvvv2) {
        this(module, baseD, twigG, nNVnuNVvvv2, null);
    }

    public ModeOptionPickerWidget(Module module, SettingEditorOpener baseD, ModeSetting twigG, SettingValueAccessor<String> nNVnuNVvvv2, String string) {
        this.groupVal = Objects.requireNonNull(module, "module");
        this.slotVal = Objects.requireNonNull(baseD, "popupContext");
        this.layerVal = Objects.requireNonNull(twigG, "setting");
        this.themeVal = Objects.requireNonNull(nNVnuNVvvv2, "valueAccessor");
        this.stageVal = ModeOptionPickerWidget.primaryVal(string);
        this.widthRef = new ArrayList<String>(twigG.marginVal != null ? twigG.marginVal : List.of());
        this.trackVal = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), depthVal, 0.0f, 0.0f, 1.0f, 5.0E-4f, 5.0E-4f);
        this.trackVal.primaryVal(EasingPresets.tertiaryVal);
        this.modeRef = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), descRef, 0.0f, 0.0f, 1.0f, 5.0E-4f, 5.0E-4f);
        this.modeRef.primaryVal(EasingPresets.tertiaryVal);
        this.angleVal = new ArrayList<SpringAnimatedFloat>();
        this.holderVal();
    }

    @Override
    public void primaryVal() {
        List list;
        List<Object> list2 = list = this.layerVal.marginVal != null ? this.layerVal.marginVal : List.of();
        if (list.size() != this.widthRef.size() || !this.widthRef.equals(list)) {
            this.widthRef.clear();
            this.widthRef.addAll(list);
            this.holderVal();
            this.chunkVal();
        }
        this.trackVal.tertiaryVal(this.vVVuuVVv ? 1.0f : (this.vVVuuVVv ? 0.0f : (this.VUuuVUnun ? 0.5f : 0.0f)));
        this.modeRef.tertiaryVal(this.vVVuuVVv ? 1.0f : 0.0f);
        for (int i = 0; i < this.angleVal.size(); ++i) {
            float f = this.vVVuuVVv && i == this.VuunNUUUvu ? 1.0f : 0.0f;
            this.angleVal.get(i).tertiaryVal(f);
        }
        if (!this.vVVuuVVv) {
            this.VuunNUUUvu = -1;
        }
    }

    @Override
    public void primaryVal(float f, float f2, float f3) {
        this.levelVal = new OptionRect(f, f2, f3, 100.0f);
        this.entryVal = f + 18.0f;
        this.guardVal = f2 + 17.0f + 18.0f;
        float f4 = f + 18.0f;
        float f5 = this.guardVal + 8.0f;
        this.UuNnnVnuNNV = new OptionRect(f4, f5, 298.0f, 38.0f);
        this.depthRef = new OptionRect(f4 + 298.0f - 40.0f, f5, 40.0f, 38.0f);
        this.chunkVal();
    }

    @Override
    public float secondaryVal() {
        return 100.0f;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void primaryVal(Renderer2D heightVal, float f, float f2, float f3) {
        float f4 = ModeOptionPickerWidget.primaryVal(f2);
        float f5 = f * f4;
        if (f5 <= 1.0E-4f) {
            return;
        }
        float f6 = ModeOptionPickerWidget.primaryVal(this.trackVal.primaryVal());
        int n = ModeOptionPickerWidget.primaryVal(-7829368, f5);
        int n2 = ModeOptionPickerWidget.primaryVal(-1, f5);
        int n3 = VvUNvVNnuUNU.primaryVal(n, n2, f6);
        heightVal.primaryVal(FontRegistry.marginVal, this.entryVal, this.guardVal - 4.0f, 18.0f, this.blockRef(), n3, "l");
        int n4 = ModeOptionPickerWidget.primaryVal(-14408668, f5);
        heightVal.primaryVal(this.UuNnnVnuNNV.x, this.UuNnnVnuNNV.y, this.UuNnnVnuNNV.width, this.UuNnnVnuNNV.height, 6.0f, n4);
        int n5 = ModeOptionPickerWidget.primaryVal(AccentColor.primaryVal(), f5);
        heightVal.primaryVal(this.depthRef.x, this.depthRef.y, this.depthRef.width, this.depthRef.height, 0.0f, 6.0f, 6.0f, 0.0f, n5);
        float f7 = this.UuNnnVnuNNV.centerY() + 6.0f;
        float f8 = this.UuNnnVnuNNV.x + 16.0f;
        String string = this.themeVal.primaryVal();
        if (string == null) {
            string = "";
        }
        int n6 = ModeOptionPickerWidget.primaryVal(-7829368, f5);
        int n7 = ModeOptionPickerWidget.primaryVal(-1, f5);
        int n8 = VvUNvVNnuUNU.primaryVal(n6, n7, f6);
        heightVal.primaryVal(FontRegistry.marginVal, f8, f7, 16.0f, string, n8, "l");
        float f9 = ModeOptionPickerWidget.primaryVal(this.modeRef.primaryVal()) * 180.0f;
        float f10 = this.depthRef.centerX();
        float f11 = this.depthRef.centerY();
        float f12 = ModeOptionPickerWidget.timerVal();
        float f13 = f11 + f12;
        heightVal.primaryVal(f10, f13);
        heightVal.primaryVal(0.0f, -f12);
        heightVal.secondaryVal(f9);
        heightVal.primaryVal(0.0f, f12);
        heightVal.primaryVal(-f10, -f13);
        try {
            heightVal.primaryVal(FontRegistry.tertiaryVal, f10, f13, 24.0f, "\ue313", ModeOptionPickerWidget.primaryVal(-1, f5), "c");
        }
        finally {
            heightVal.limitVal();
            heightVal.limitVal();
            heightVal.extraVal();
            heightVal.limitVal();
            heightVal.limitVal();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void primaryVal(Renderer2D heightVal, float f, float f2) {
        float f3;
        block13: {
            block12: {
                f3 = ModeOptionPickerWidget.primaryVal(this.modeRef.primaryVal());
                if (f3 <= 0.001f) {
                    return;
                }
                if (this.widthRef.isEmpty()) break block12;
                if (!(this.speedRef.width <= 0.0f) && !(this.speedRef.height <= 0.0f)) break block13;
            }
            return;
        }
        float f4 = ModeOptionPickerWidget.primaryVal(f2);
        float f5 = f * f4 * f3;
        if (f5 <= 1.0E-4f) {
            return;
        }
        int n = -14408668;
        heightVal.tertiaryVal(1.0f, f3, this.speedRef.x, this.speedRef.y);
        try {
            heightVal.primaryVal(this.speedRef.x, this.speedRef.y, this.speedRef.width, this.speedRef.height, 6.0f, 6.0f, 6.0f, 6.0f, n);
            String string = this.themeVal.primaryVal();
            if (string == null) {
                string = "";
            }
            for (int i = 0; i < this.countRef.size(); ++i) {
                float f6;
                float f7;
                float f8;
                OptionRect modeVal = this.countRef.get(i);
                String string2 = this.widthRef.get(i);
                boolean bl = Objects.equals(string2, string);
                f8 = i < this.angleVal.size() ? ModeOptionPickerWidget.primaryVal(this.angleVal.get(i).primaryVal()) : 0.0f;
                if (f8 > 0.001f) {
                    int n2 = ModeOptionPickerWidget.primaryVal(-13750738, f8 * f5);
                    f7 = i == 0 ? 6.0f : 0.0f;
                    float f10 = i == 0 ? 6.0f : 0.0f;
                    float f11 = i == this.countRef.size() - 1 ? 6.0f : 0.0f;
                    f6 = i == this.countRef.size() - 1 ? 6.0f : 0.0f;
                    heightVal.primaryVal(modeVal.x, modeVal.y, modeVal.width, modeVal.height, f7, f10, f11, f6, n2);
                }
                float f12 = modeVal.x + 16.0f;
                f7 = modeVal.centerY() + 6.0f;
                int n3 = ModeOptionPickerWidget.primaryVal(-7829368, f5);
                int n4 = ModeOptionPickerWidget.primaryVal(-1, f5);
                f6 = bl ? 1.0f : f8 * 0.7f;
                int n5 = VvUNvVNnuUNU.primaryVal(n3, n4, f6);
                heightVal.primaryVal(FontRegistry.marginVal, f12, f7, 16.0f, string2, n5, "l");
                if (!Objects.equals(string2, string)) continue;
                float f13 = modeVal.x + modeVal.width - 16.0f + 2.0f;
                float f14 = modeVal.centerY() + 6.0f + 3.0f;
                heightVal.primaryVal(FontRegistry.tertiaryVal, f13, f14, 18.0f, "\ue5ca", ModeOptionPickerWidget.primaryVal(-1, f5), "r");
            }
        }
        finally {
            heightVal.speedVal();
        }
    }

    @Override
    public boolean weightVal() {
        return (this.vVVuuVVv || this.modeRef.primaryVal() > 0.001f) && this.speedRef.width > 0.0f && this.speedRef.height > 0.0f;
    }

    @Override
    public boolean secondaryVal(double d, double d2, int n) {
        if (!this.weightVal()) {
            return false;
        }
        if (!this.vVVuuVVv) {
            return false;
        }
        if (n != 0) {
            this.speedVal();
            return true;
        }
        if (this.speedRef.contains(d, d2)) {
            int n2 = this.primaryVal(d2);
            if (n2 >= 0 && n2 < this.widthRef.size()) {
                this.primaryVal(n2);
            }
            this.speedVal();
            return true;
        }
        if (this.UuNnnVnuNNV.contains(d, d2) || this.depthRef.contains(d, d2)) {
            this.speedVal();
            return true;
        }
        this.speedVal();
        return true;
    }

    @Override
    public boolean primaryVal(double d, double d2, int n) {
        boolean bl;
        boolean bl2 = bl = this.UuNnnVnuNNV.contains(d, d2) || this.depthRef.contains(d, d2);
        if (n == 2) {
            if (!bl) {
                return false;
            }
            this.speedVal();
            String string = this.themeVal.primaryVal();
            String string2 = string != null ? string.toString() : "";
            this.slotVal.openForSetting(this.groupVal, this.layerVal, d, d2, string2);
            return true;
        }
        if (n != 0) {
            return false;
        }
        if (this.vVVuuVVv) {
            return this.secondaryVal(d, d2, n);
        }
        if (bl) {
            this.limitVal();
            return true;
        }
        return false;
    }

    @Override
    public boolean primaryVal(double d, double d2, double d3, double d4) {
        return this.weightVal();
    }

    @Override
    public void primaryVal(double d, double d2) {
        boolean bl = this.UuNnnVnuNNV.contains(d, d2) || this.depthRef.contains(d, d2);
        boolean bl2 = this.vVVuuVVv && this.speedRef.contains(d, d2);
        this.VUuuVUnun = this.vVVuuVVv ? false : bl;
        if (this.vVVuuVVv) {
            this.VuunNUUUvu = bl2 ? this.primaryVal(d2) : -1;
        }
    }

    @Override
    public void paramVal() {
        this.widthVal();
    }

    @Override
    public Setting tertiaryVal() {
        return this.layerVal;
    }

    @Override
    public boolean marginVal() {
        return true;
    }

    private void limitVal() {
        this.vVVuuVVv = true;
        this.modeRef.tertiaryVal(1.0f);
        this.trackVal.tertiaryVal(1.0f);
    }

    private void speedVal() {
        this.vVVuuVVv = false;
        this.modeRef.tertiaryVal(0.0f);
        this.VuunNUUUvu = -1;
    }

    private void widthVal() {
        this.vVVuuVVv = false;
        this.modeRef.secondaryVal(0.0f);
        this.VuunNUUUvu = -1;
    }

    private void primaryVal(int n) {
        if (n < 0 || n >= this.widthRef.size()) {
            return;
        }
        String string = this.widthRef.get(n);
        String string2 = this.themeVal.primaryVal();
        if (!Objects.equals(string, string2)) {
            this.themeVal.primaryVal(string);
        }
    }

    private void chunkVal() {
        this.countRef.clear();
        if (this.widthRef.isEmpty()) {
            this.speedRef = OptionRect.EMPTY;
            return;
        }
        float f = this.UuNnnVnuNNV.x;
        float f2 = this.UuNnnVnuNNV.y + this.UuNnnVnuNNV.height + 6.0f;
        float f3 = this.UuNnnVnuNNV.width;
        float f4 = 38.0f * (float)this.widthRef.size();
        this.speedRef = new OptionRect(f, f2, f3, f4);
        float f5 = f2;
        for (int i = 0; i < this.widthRef.size(); ++i) {
            this.countRef.add(new OptionRect(f, f5, f3, 38.0f));
            f5 += 38.0f;
        }
    }

    private int primaryVal(double d) {
        int n;
        block6: {
            block5: {
                if (d < (double)this.speedRef.y || d > (double)(this.speedRef.y + this.speedRef.height)) {
                    return -1;
                }
                double d2 = d - (double)this.speedRef.y;
                if (d2 < 0.0) {
                    return -1;
                }
                n = (int)(d2 / 38.0);
                if (n < 0) break block5;
                if (n < this.widthRef.size()) break block6;
            }
            return -1;
        }
        return n;
    }

    private String blockRef() {
        return this.stageVal != null ? this.stageVal : this.layerVal.primaryVal;
    }

    private static String primaryVal(String string) {
        if (string == null) {
            return null;
        }
        String string2 = string.trim();
        return string2.isEmpty() ? null : string2;
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

    private void holderVal() {
        this.angleVal.clear();
        for (int i = 0; i < this.widthRef.size(); ++i) {
            SpringAnimatedFloat raftI = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), depthVal, 0.0f, 0.0f, 1.0f, 5.0E-4f, 5.0E-4f);
            raftI.primaryVal(EasingPresets.tertiaryVal);
            this.angleVal.add(raftI);
        }
    }

    private static float timerVal() {
        if (Float.isNaN(heightRef)) {
            float f;
            heightRef = f = FontRegistry.primaryVal(FontRegistry.tertiaryVal, 58131, 24.0f);
        }
        return heightRef;
    }

    private static int primaryVal(int n, float f) {
        int n2 = n >>> 24 & 0xFF;
        int n3 = Math.round((float)n2 * f);
        int n4 = n & 0xFFFFFF;
        return n3 << 24 | n4;
    }

    static final class OptionRect
     {
        final float x;
        final float y;
        final float width;
        final float height;
        static final OptionRect EMPTY = new OptionRect(0.0f, 0.0f, 0.0f, 0.0f);

        OptionRect(float f, float f2, float f3, float f4) {
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
            return "OptionRect[" + "x=" + this.x + ", " + "y=" + this.y + ", " + "width=" + this.width + ", " + "height=" + this.height + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.x, this.y, this.width, this.height);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            OptionRect that = (OptionRect)object;
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

