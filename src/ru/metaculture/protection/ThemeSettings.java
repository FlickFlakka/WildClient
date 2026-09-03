/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import ru.metaculture.protection.SpringConfig;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.ThemeSwatchCatalog;
import ru.metaculture.protection.SmoothedFloat;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UnnUvUvn;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.NeumorphicThemeRenderer;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.PrismaticEdgeShaderRenderer;
import ru.metaculture.protection.SettingHolder;
import ru.metaculture.protection.BoolSetting;

public abstract class ThemeSettings
extends SettingHolder {
    public static final String secondaryVal = "Dark";
    public static final String tertiaryVal = "Light";
    public static final String marginVal = "Blur";
    public static final String weightVal = "Neumorphism";
    public static final String paramVal = "Ferrofluid";
    public static final String extraVal = "Prism";
    public static final String limitVal = "Prism Core";
    public static final String speedVal = "Neo distance";
    public static final String widthVal = "Neo blur";
    public static final String chunkVal = "Neo intensity";
    public static final String blockRef = "Neo shape";
    public static final String holderVal = "Flat";
    public static final String timerVal = "Convex";
    public static final String anchorVal = "Concave";
    protected static final float weightRef = 7.0f;
    protected static final float bufferVal = 5.0f;
    protected static final float countVal = 10.0f;
    public final FloatSetting depthVal = new FloatSetting("Transparency", 1.0f, 0.1f, 1.0f, 0.05f, true);
    public final FloatSetting descRef = new FloatSetting("Transparency of dark elements", 1.0f, 0.0f, 1.0f, 0.05f, true);
    public final ModeSetting activeVal;
    public final FloatSetting radiusVal;
    public final FloatSetting factorVal;
    public final FloatSetting sourceVal;
    public final ModeSetting extraRef;
    public final SettingGroup phaseVal;
    private NvVNvUvunNNu primaryVal;
    private boolean limitRef;
    private ThemePalette paramRef;
    private ThemeSwatchCatalog.VvunVVUvUNnv groupVal;
    private NvVNvUvunNNu layerVal;
    private long slotVal;
    private int themeVal;
    private float stageVal;
    private float widthRef;
    private int trackVal;
    private final SmoothedFloat modeRef;
    private static final ThemeSwatchCatalog angleVal = ThemeSwatchCatalog.primaryVal();

    public ThemeSettings() {
        String[] stringArray = new String[6];
        stringArray[0] = secondaryVal;
        stringArray[1] = tertiaryVal;
        stringArray[2] = marginVal;
        stringArray[3] = weightVal;
        stringArray[4] = paramVal;
        stringArray[5] = extraVal;
        this.activeVal = new ModeSetting("Style", secondaryVal, stringArray);
        this.radiusVal = new FloatSetting(speedVal, 5.5f, 2.0f, 18.0f, 0.5f, false).primaryVal(() -> !this.chunkVal());
        this.factorVal = new FloatSetting(widthVal, 18.0f, 6.0f, 48.0f, 1.0f, false).primaryVal(() -> !this.chunkVal());
        this.sourceVal = new FloatSetting(chunkVal, 0.72f, 0.1f, 1.0f, 0.05f, true).primaryVal(() -> !this.chunkVal());
        String[] stringArray2 = new String[3];
        stringArray2[0] = holderVal;
        stringArray2[1] = timerVal;
        stringArray2[2] = anchorVal;
        this.extraRef = new ModeSetting(blockRef, timerVal, stringArray2).primaryVal(() -> !this.chunkVal());
        this.phaseVal = new SettingGroup("Visual", new BoolSetting("Shadow", true), new BoolSetting("Outline", true), new BoolSetting("Dark zones", true), new BoolSetting("Top overlay", true), new BoolSetting("Bottom overlay", true), new BoolSetting("Dark rect overlay", true));
        this.slotVal = Long.MIN_VALUE;
        this.stageVal = 0.5f;
        this.widthRef = 0.5f;
        this.modeRef = new SmoothedFloat(0.0f);
        this.primaryVal((Setting)this.depthVal);
        this.primaryVal((Setting)this.descRef);
        this.primaryVal((Setting)this.activeVal);
        this.primaryVal((Setting)this.radiusVal);
        this.primaryVal((Setting)this.factorVal);
        this.primaryVal((Setting)this.sourceVal);
        this.primaryVal((Setting)this.extraRef);
        this.primaryVal((Setting)this.phaseVal);
    }

    public int primaryVal(float f) {
        if (this.chunkVal()) {
            return NeumorphicThemeRenderer.primaryVal(f);
        }
        if (this.blockRef()) {
            int n = (int)(232.0f * f);
            float f2 = this.anchorVal();
            int n2 = ColorUtil.tertiaryVal(ColorUtil.tertiaryVal(13, 15, 24, n), ColorUtil.primaryVal(this.bufferVal().descRef(), n), 0.12f);
            int n3 = ColorUtil.tertiaryVal(ColorUtil.tertiaryVal(250, 253, 255, (int)(152.0f * f)), ColorUtil.primaryVal(this.bufferVal().depthVal(), (int)(132.0f * f)), 0.055f);
            return ColorUtil.tertiaryVal(n2, n3, f2);
        }
        if (this.holderVal()) {
            int n = (int)(172.0f * f);
            return ColorUtil.tertiaryVal(ColorUtil.tertiaryVal(14, 18, 30, n), ColorUtil.primaryVal(this.bufferVal().descRef(), n), 0.1f);
        }
        int n = (int)(255.0f * f);
        if (this.timerVal()) {
            return ColorUtil.primaryVal(this.depthVal(), (int)((float)(this.secondaryVal() ? 152 : 176) * f));
        }
        return switch (this.activeVal.tertiaryVal()) {
            case tertiaryVal -> ColorUtil.tertiaryVal(240, 240, 245, n);
            case marginVal -> ColorUtil.tertiaryVal(21, 22, 26, this.speedVal() ? (int)(122.0f * f) : 0);
            default -> ColorUtil.tertiaryVal(20, 20, 20, n);
        };
    }

    public int secondaryVal(float f) {
        return this.primaryVal(f, this.extraVal());
    }

    public int tertiaryVal(float f) {
        return this.primaryVal(f, this.limitVal());
    }

    private int primaryVal(float f, boolean bl) {
        if (!bl) {
            return ColorUtil.tertiaryVal(0, 0, 0, 0);
        }
        if (this.chunkVal()) {
            return NeumorphicThemeRenderer.primaryVal(f);
        }
        float f2 = this.widthVal(f);
        if (this.blockRef()) {
            int n = (int)(202.0f * f2);
            float f3 = this.anchorVal();
            int n2 = ColorUtil.tertiaryVal(ColorUtil.tertiaryVal(15, 18, 30, n), ColorUtil.primaryVal(this.bufferVal().depthVal(), n), 0.1f);
            int n3 = ColorUtil.tertiaryVal(ColorUtil.tertiaryVal(255, 255, 255, (int)(132.0f * f2)), ColorUtil.primaryVal(this.bufferVal().descRef(), (int)(118.0f * f2)), 0.06f);
            return ColorUtil.tertiaryVal(n2, n3, f3);
        }
        if (this.holderVal()) {
            int n = (int)(150.0f * f2);
            return ColorUtil.tertiaryVal(ColorUtil.tertiaryVal(12, 16, 26, n), ColorUtil.primaryVal(this.bufferVal().depthVal(), n), 0.08f);
        }
        int n = (int)(255.0f * f2);
        if (this.timerVal()) {
            return ColorUtil.primaryVal(this.descRef(), (int)((float)(this.secondaryVal() ? 138 : 160) * f2));
        }
        return switch (this.activeVal.tertiaryVal()) {
            case tertiaryVal -> ColorUtil.tertiaryVal(200, 200, 205, n);
            case marginVal -> ColorUtil.tertiaryVal(21, 22, 26, (int)(184.0f * f2));
            default -> ColorUtil.tertiaryVal(25, 25, 25, n);
        };
    }

    public int marginVal(float f) {
        if (this.chunkVal()) {
            return ColorUtil.tertiaryVal(0, 0, 0, 0);
        }
        if (this.blockRef()) {
            float f2 = this.anchorVal();
            int n = ColorUtil.primaryVal(this.sourceVal(), (int)(92.0f * f));
            int n2 = ColorUtil.tertiaryVal(ColorUtil.tertiaryVal(20, 28, 42, (int)(56.0f * f)), ColorUtil.primaryVal(this.extraRef(), (int)(76.0f * f)), 0.35f);
            return ColorUtil.tertiaryVal(n, n2, f2);
        }
        if (this.holderVal()) {
            int n = ColorUtil.tertiaryVal(this.bufferVal().depthVal(), this.bufferVal().descRef(), 0.5f);
            return ColorUtil.primaryVal(n, (int)(70.0f * f));
        }
        int n = (int)(255.0f * f);
        if (this.weightRef() == NvVNvUvunNNu.VERNAL_SOLSTICE) {
            return ColorUtil.tertiaryVal(5, 17, 5, (int)(46.0f * f));
        }
        if (this.timerVal()) {
            return ColorUtil.primaryVal(this.activeVal(), (int)((float)(this.secondaryVal() ? 38 : 48) * f));
        }
        return switch (this.activeVal.tertiaryVal()) {
            case tertiaryVal -> ColorUtil.tertiaryVal(200, 200, 200, n);
            case marginVal -> ColorUtil.tertiaryVal(255, 255, 255, (int)(10.0f * f));
            default -> ColorUtil.tertiaryVal(45, 45, 45, n);
        };
    }

    public int weightVal(float f) {
        if (this.chunkVal()) {
            return NeumorphicThemeRenderer.secondaryVal(f);
        }
        if (this.blockRef()) {
            float f2 = this.anchorVal();
            int n = ColorUtil.tertiaryVal(242, 245, 255, (int)(255.0f * f));
            int n2 = ColorUtil.tertiaryVal(18, 25, 38, (int)(255.0f * f));
            return ColorUtil.tertiaryVal(n, n2, f2);
        }
        if (this.holderVal()) {
            return ColorUtil.tertiaryVal(244, 247, 255, (int)(255.0f * f));
        }
        int n = (int)(255.0f * f);
        if (this.weightRef() == NvVNvUvunNNu.VERNAL_SOLSTICE) {
            return ColorUtil.tertiaryVal(5, 17, 5, n);
        }
        if (this.timerVal()) {
            return ColorUtil.primaryVal(this.radiusVal(), n);
        }
        return this.activeVal.tertiaryVal().equals(tertiaryVal) ? ColorUtil.tertiaryVal(20, 20, 20, n) : ColorUtil.tertiaryVal(255, 255, 255, n);
    }

    public int paramVal(float f) {
        if (this.chunkVal()) {
            return NeumorphicThemeRenderer.tertiaryVal(f);
        }
        if (this.blockRef()) {
            float f2 = this.anchorVal();
            int n = ColorUtil.tertiaryVal(170, 177, 196, (int)(214.0f * f));
            int n2 = ColorUtil.tertiaryVal(72, 84, 108, (int)(224.0f * f));
            return ColorUtil.tertiaryVal(n, n2, f2);
        }
        if (this.holderVal()) {
            return ColorUtil.tertiaryVal(176, 184, 204, (int)(220.0f * f));
        }
        int n = (int)(255.0f * f);
        if (this.weightRef() == NvVNvUvunNNu.VERNAL_SOLSTICE) {
            return ColorUtil.tertiaryVal(5, 17, 5, (int)(184.0f * f));
        }
        if (this.timerVal()) {
            return ColorUtil.primaryVal(this.factorVal(), n);
        }
        return switch (this.activeVal.tertiaryVal()) {
            case tertiaryVal -> ColorUtil.tertiaryVal(80, 80, 80, n);
            case marginVal -> ColorUtil.tertiaryVal(255, 255, 255, (int)(122.0f * f));
            default -> ColorUtil.tertiaryVal(170, 170, 170, n);
        };
    }

    public int extraVal(float f) {
        if (this.blockRef()) {
            return ColorUtil.primaryVal(ThemePalette.primaryVal(this.sourceVal(), this.extraRef(), 0.55f), (int)(255.0f * f));
        }
        return ColorUtil.primaryVal(this.bufferVal().descRef(), (int)(255.0f * f));
    }

    public int limitVal(float f) {
        if (this.blockRef()) {
            return ColorUtil.primaryVal(this.sourceVal(), (int)(255.0f * f));
        }
        return ColorUtil.primaryVal(this.bufferVal().depthVal(), (int)(255.0f * f));
    }

    public int speedVal(float f) {
        if (this.blockRef()) {
            return ColorUtil.primaryVal(this.extraRef(), (int)(255.0f * f));
        }
        return ColorUtil.primaryVal(this.bufferVal().descRef(), (int)(255.0f * f));
    }

    public float widthVal(float f) {
        return f * this.descRef.tertiaryVal();
    }

    public float tertiaryVal() {
        return this.activeVal.tertiaryVal().equals(marginVal) ? 1.0f : 1.5f;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean marginVal() {
        if (this.chunkVal()) return false;
        if (!this.phaseVal.secondaryVal("Shadow")) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean weightVal() {
        if (this.chunkVal()) return false;
        if (!this.phaseVal.secondaryVal("Outline")) return false;
        return true;
    }

    public boolean paramVal() {
        return this.phaseVal.secondaryVal("Dark zones");
    }

    public boolean extraVal() {
        return this.paramVal() && this.phaseVal.secondaryVal("Top overlay");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean limitVal() {
        if (!this.paramVal()) return false;
        if (!this.phaseVal.secondaryVal("Bottom overlay")) return false;
        return true;
    }

    public boolean speedVal() {
        return this.phaseVal.secondaryVal("Dark rect overlay");
    }

    public boolean widthVal() {
        if (this.chunkVal() || this.blockRef() || this.holderVal()) {
            return false;
        }
        return this.activeVal.tertiaryVal().equals(marginVal);
    }

    public boolean chunkVal() {
        return weightVal.equals(this.activeVal.tertiaryVal());
    }

    public boolean blockRef() {
        return paramVal.equals(this.activeVal.tertiaryVal());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean holderVal() {
        if (extraVal.equals(this.activeVal.tertiaryVal())) return true;
        if (!limitVal.equals(this.activeVal.tertiaryVal())) return false;
        return true;
    }

    public static boolean primaryVal(String string) {
        return weightVal.equals(string);
    }

    public static boolean secondaryVal(String string) {
        return paramVal.equals(string);
    }

    public static boolean tertiaryVal(String string) {
        return extraVal.equals(string);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean primaryVal(float f, float f2, float f3, float f4, float f5, boolean bl, float f6) {
        if (!this.chunkVal()) return false;
        if (!NeumorphicThemeRenderer.primaryVal(null, f, f2, f3, f4, f5, bl, f6, NeumorphicThemeRenderer.primaryVal(this.radiusVal.tertiaryVal(), this.factorVal.tertiaryVal(), this.sourceVal.tertiaryVal(), this.extraRef.tertiaryVal()))) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean primaryVal(float f, float f2, float f3, float f4, float f5, boolean bl, float f6, int n) {
        if (!this.chunkVal()) return false;
        if (!NeumorphicThemeRenderer.primaryVal(null, f, f2, f3, f4, f5, this.radiusVal.tertiaryVal(), this.factorVal.tertiaryVal(), this.sourceVal.tertiaryVal(), n, bl, f6)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean primaryVal(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, boolean bl, float f9) {
        if (!this.chunkVal()) return false;
        if (!NeumorphicThemeRenderer.primaryVal(null, f, f2, f3, f4, f5, f6, f7, f8, n, bl, f9)) return false;
        return true;
    }

    public void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6) {
        this.primaryVal(f, f2, f3, f4);
        if (NeumorphicThemeRenderer.primaryVal(null, f, f2, f3, f4, f5, f6)) {
            return;
        }
        if (this.primaryVal(f, f2, f3, f4, f5, false, f6)) {
            return;
        }
        if (this.primaryVal(heightVal, f, f2, f3, f4, f5, false, f6)) {
            return;
        }
        if (this.secondaryVal(heightVal, f, f2, f3, f4, f5, false, f6)) {
            return;
        }
        if (this.marginVal()) {
            heightVal.primaryVal(f, f2, f3, f4, f5, this.timerVal() ? 6.0f : 4.0f, 1.0f, this.chunkVal(f6));
        }
        if (this.widthVal()) {
            heightVal.primaryVal(23.0f);
            heightVal.primaryVal(f, f2, f3, f4, f5, f6);
        }
        if (this.timerVal() && !this.widthVal()) {
            this.primaryVal(heightVal, f, f2, f3, f4, f5, this.primaryVal(f6), false, f6);
        } else {
            heightVal.primaryVal(f, f2, f3, f4, f5, this.primaryVal(f6));
        }
        if (this.weightVal()) {
            heightVal.primaryVal(f, f2, f3, f4, f5, this.marginVal(f6), this.tertiaryVal());
        }
    }

    public void secondaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6) {
        this.primaryVal(f, f2, f3, f4);
        if (this.primaryVal(heightVal, f, f2, f3, f4, f5, true, f6)) {
            return;
        }
        if (this.secondaryVal(heightVal, f, f2, f3, f4, f5, true, f6)) {
            return;
        }
        if (!this.limitVal()) {
            return;
        }
        if (this.primaryVal(f, f2, f3, f4, f5, true, f6)) {
            return;
        }
        if (this.timerVal() && !this.widthVal()) {
            this.primaryVal(heightVal, f, f2, f3, f4, f5, this.tertiaryVal(f6), true, f6);
        } else {
            heightVal.primaryVal(f, f2, f3, f4, f5, this.tertiaryVal(f6));
        }
        if (this.weightVal()) {
            heightVal.primaryVal(f, f2, f3, f4, f5, this.marginVal(f6), Math.max(1.0f, this.tertiaryVal() * 0.65f));
        }
    }

    protected boolean timerVal() {
        return tertiaryVal.equals(this.activeVal.tertiaryVal()) || NeumorphicThemeRenderer.marginVal();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean secondaryVal() {
        NvVNvUvunNNu nvVNvUvunNNu = this.weightRef();
        if (!this.timerVal()) return false;
        if (nvVNvUvunNNu == NvVNvUvunNNu.SAKURA_BREEZE) return true;
        if (nvVNvUvunNNu != NvVNvUvunNNu.SAKURA) return false;
        return true;
    }

    protected float anchorVal() {
        return this.modeRef.primaryVal(this.timerVal() ? 1.0f : 0.0f, SpringConfig.weightRef());
    }

    protected void primaryVal(float f, float f2, float f3, float f4) {
        int n;
        int n2;
        block8: {
            block7: {
                n2 = 0;
                n = 0;
                try {
                    class_310 class_3102 = class_310.method_1551();
                    if (class_3102 != null && class_3102.method_22683() != null) {
                        n2 = class_3102.method_22683().method_4489();
                        n = class_3102.method_22683().method_4506();
                    }
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                if (n2 <= 0 || n <= 0 || !Float.isFinite(f) || !Float.isFinite(f2) || !Float.isFinite(f3)) break block7;
                if (Float.isFinite(f4)) break block8;
            }
            this.stageVal = 0.5f;
            this.widthRef = 0.5f;
            this.trackVal = 0;
            return;
        }
        this.stageVal = this.blockRef((f + f3 * 0.5f) / (float)n2);
        this.widthRef = this.blockRef((f2 + f4 * 0.5f) / (float)n);
        int n3 = Math.round(this.stageVal * 2048.0f);
        int n4 = Math.round(this.widthRef * 2048.0f);
        int n5 = Math.round(Math.max(1.0f, f3) * 0.25f);
        int n6 = Math.round(Math.max(1.0f, f4) * 0.25f);
        this.trackVal = (n3 * 7349 ^ n4 * 9151) * 31 ^ n5 * 131 ^ n6;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, boolean bl, float f6) {
        if (!this.blockRef()) return false;
        if (!UnnUvUvn.primaryVal(heightVal, f, f2, f3, f4, f5, f6, bl, this.primaryVal(f6), this.marginVal(f6), this.limitVal(f6), this.speedVal(f6), this.marginVal(), true, this.anchorVal())) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean secondaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, boolean bl, float f6) {
        if (!this.holderVal()) return false;
        if (!PrismaticEdgeShaderRenderer.primaryVal(heightVal, f, f2, f3, f4, f5, f6, bl, this.primaryVal(f6), this.marginVal(f6), this.limitVal(f6), this.speedVal(f6), this.marginVal(), this.weightVal(), this.anchorVal())) return false;
        return true;
    }

    private NvVNvUvunNNu weightRef() {
        if (WildClient.primaryVal != null) {
            if (WildClient.primaryVal.chunkVal != null) {
                return WildClient.primaryVal.chunkVal.secondaryVal();
            }
        }
        return NvVNvUvunNNu.WILD;
    }

    private ThemePalette bufferVal() {
        block3: {
            long l;
            long l2;
            boolean bl;
            NvVNvUvunNNu nvVNvUvunNNu;
            block2: {
                nvVNvUvunNNu = this.weightRef();
                bl = this.timerVal();
                l2 = System.currentTimeMillis();
                l = l2 / 16L;
                if (this.paramRef == null || this.primaryVal != nvVNvUvunNNu || this.limitRef != bl) break block2;
                if (this.slotVal == l && this.themeVal == this.trackVal && nvVNvUvunNNu != NvVNvUvunNNu.CUSTOM) break block3;
            }
            ThemePalette configVal = ThemePalette.primaryVal(nvVNvUvunNNu, bl);
            this.paramRef = this.primaryVal(nvVNvUvunNNu, ThemePalette.primaryVal(nvVNvUvunNNu, configVal, l2), l2);
            this.primaryVal = nvVNvUvunNNu;
            this.limitRef = bl;
            this.slotVal = l;
            this.themeVal = this.trackVal;
        }
        return this.paramRef;
    }

    private ThemePalette primaryVal(NvVNvUvunNNu nvVNvUvunNNu, ThemePalette configVal, long l) {
        int n;
        float f;
        int[] nArray;
        block4: {
            block3: {
                ThemeSwatchCatalog.VvunVVUvUNnv vvunVVUvUNnv = this.countVal();
                int[] nArray2 = nArray = vvunVVUvUNnv == null ? null : vvunVVUvUNnv.extraVal();
                if (configVal == null) break block3;
                if (nArray != null && nArray.length >= 2) break block4;
            }
            return configVal;
        }
        float f2 = this.primaryVal(l);
        int n2 = this.primaryVal(nArray, f2);
        int n3 = this.primaryVal(nArray, f2 + 0.31f);
        int n4 = this.primaryVal(nArray, f2 + 0.67f);
        float f3 = nArray.length > 2 ? 1.0f : 0.52f;
        float f4 = 0.34f + 0.3f * f3;
        f = configVal.activeVal() ? 0.018f + 0.02f * f3 : 0.045f + 0.05f * f3;
        float f6 = configVal.activeVal() ? 0.06f + 0.035f * f3 : 0.16f + 0.1f * f3;
        int n5 = ColorUtil.tertiaryVal(configVal.depthVal(), ColorUtil.tertiaryVal(n2, -1, 0.1f), f4);
        int n6 = ColorUtil.tertiaryVal(configVal.descRef(), n3, f4);
        int n7 = ThemePalette.secondaryVal(configVal.paramVal(), n4, f);
        int n8 = ThemePalette.secondaryVal(configVal.extraVal(), n3, f * 1.08f);
        int n9 = ThemePalette.secondaryVal(configVal.timerVal(), n2, f6);
        int n10 = ThemePalette.secondaryVal(configVal.anchorVal(), n3, f6);
        int n11 = n = configVal.activeVal() ? configVal.weightRef() : ThemePalette.secondaryVal(configVal.weightRef(), n4, 0.1f + 0.08f * f3);
        int n12 = configVal.activeVal() ? configVal.bufferVal() : ThemePalette.secondaryVal(configVal.bufferVal(), n2, 0.08f + 0.06f * f3);
        int n13 = configVal.activeVal() ? configVal.countVal() : ColorUtil.tertiaryVal(configVal.countVal(), n2, 0.025f + 0.025f * f3);
        return ThemePalette.primaryVal(ThemePalette.weightVal().primaryVal(n7).secondaryVal(n8).tertiaryVal(configVal.limitVal()).marginVal(configVal.speedVal()).weightVal(configVal.widthVal()).paramVal(configVal.chunkVal()).extraVal(configVal.blockRef()).limitVal(configVal.holderVal()).speedVal(n9).widthVal(n10).chunkVal(n).blockRef(n12).holderVal(n13).timerVal(n5).anchorVal(n6).primaryVal(configVal.activeVal()).primaryVal());
    }

    private float primaryVal(long l) {
        float f = (float)(l % 14000L) / 14000.0f;
        float f2 = (float)Math.sin((this.stageVal * 1.72f - this.widthRef * 1.18f + f * 1.35f) * ((float)Math.PI * 2)) * 0.055f;
        return this.stageVal * 0.54f + this.widthRef * 0.36f + f * 0.58f + f2;
    }

    private int primaryVal(int[] nArray, float f) {
        if (nArray.length == 1) {
            return nArray[0];
        }
        float f2 = f - (float)Math.floor(f);
        float f3 = f2 * (float)(nArray.length - 1);
        int n = Math.min(nArray.length - 2, Math.max(0, (int)Math.floor(f3)));
        return ColorUtil.tertiaryVal(nArray[n], nArray[n + 1], f3 - (float)n);
    }

    private float blockRef(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    private ThemeSwatchCatalog.VvunVVUvUNnv countVal() {
        NvVNvUvunNNu nvVNvUvunNNu = this.weightRef();
        if (nvVNvUvunNNu == NvVNvUvunNNu.CUSTOM) {
            return null;
        }
        if (this.groupVal == null || this.layerVal != nvVNvUvunNNu) {
            this.groupVal = angleVal.secondaryVal(nvVNvUvunNNu);
            this.layerVal = nvVNvUvunNNu;
        }
        return this.groupVal;
    }

    private int depthVal() {
        ThemePalette configVal = this.bufferVal();
        if (this.secondaryVal()) {
            int n = ColorUtil.tertiaryVal(-1283, configVal.depthVal(), 0.05f);
            return ColorUtil.tertiaryVal(n, configVal.descRef(), 0.03f);
        }
        int n = ColorUtil.tertiaryVal(-196865, configVal.depthVal(), 0.026f);
        ThemeSwatchCatalog.VvunVVUvUNnv vvunVVUvUNnv = this.countVal();
        if (vvunVVUvUNnv != null && vvunVVUvUNnv.paramVal()) {
            n = ColorUtil.tertiaryVal(n, vvunVVUvUNnv.marginVal(), 0.022f);
        }
        return n;
    }

    private int descRef() {
        ThemePalette configVal = this.bufferVal();
        if (this.secondaryVal()) {
            int n = ColorUtil.tertiaryVal(-1, configVal.descRef(), 0.07f);
            return ColorUtil.tertiaryVal(n, configVal.depthVal(), 0.03f);
        }
        int n = ColorUtil.tertiaryVal(-1, configVal.descRef(), 0.022f);
        ThemeSwatchCatalog.VvunVVUvUNnv vvunVVUvUNnv = this.countVal();
        if (vvunVVUvUNnv != null && vvunVVUvUNnv.paramVal()) {
            n = ColorUtil.tertiaryVal(n, vvunVVUvUNnv.weightVal(), 0.018f);
        }
        return n;
    }

    private int activeVal() {
        ThemePalette configVal = this.bufferVal();
        int n = ColorUtil.tertiaryVal(configVal.depthVal(), configVal.descRef(), 0.44f);
        if (this.secondaryVal()) {
            return ColorUtil.tertiaryVal(-7582617, n, 0.48f);
        }
        return ColorUtil.tertiaryVal(-15261133, n, 0.34f);
    }

    private int radiusVal() {
        ThemePalette configVal = this.bufferVal();
        return ColorUtil.tertiaryVal(-15722718, configVal.depthVal(), 0.035f);
    }

    private int factorVal() {
        ThemePalette configVal = this.bufferVal();
        return ColorUtil.tertiaryVal(-12168086, configVal.descRef(), 0.055f);
    }

    public int chunkVal(float f) {
        if (this.timerVal()) {
            ThemePalette configVal = this.bufferVal();
            if (this.secondaryVal()) {
                int n = ColorUtil.tertiaryVal(-2779216, configVal.descRef(), 0.26f);
                return ColorUtil.primaryVal(n, (int)(34.0f * f));
            }
            int n = ColorUtil.tertiaryVal(-10787208, configVal.descRef(), 0.1f);
            return ColorUtil.primaryVal(n, (int)(46.0f * f));
        }
        return ColorUtil.tertiaryVal(0, 0, 0, (int)(80.0f * f));
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, int n, boolean bl, float f6) {
        int n2 = ColorUtil.primaryVal(n);
        ThemePalette configVal = this.bufferVal();
        float f7 = this.secondaryVal() ? 0.115f : 0.055f;
        float f8 = this.secondaryVal() ? 0.085f : 0.04f;
        int n3 = ColorUtil.primaryVal(ColorUtil.tertiaryVal(n, configVal.depthVal(), bl ? f7 * 0.76f : f7), n2);
        int n4 = ColorUtil.primaryVal(ColorUtil.tertiaryVal(n, configVal.descRef(), bl ? f8 * 0.7f : f8), n2);
        heightVal.secondaryVal(f, f2, f3, f4, f5, n3, n4);
        if (!bl && f4 > 10.0f) {
            float f9 = Math.max(4.0f, Math.min(f4 * 0.36f, 18.0f));
            int n5 = ColorUtil.tertiaryVal(255, 255, 255, (int)((float)(this.secondaryVal() ? 34 : 24) * f6));
            heightVal.secondaryVal(f + 1.0f, f2 + 1.0f, Math.max(1.0f, f3 - 2.0f), f9, Math.max(0.0f, f5 - 1.0f), n5, ColorUtil.tertiaryVal(255, 255, 255, 0));
        }
    }

    private int sourceVal() {
        return ThemePalette.secondaryVal(ColorUtil.primaryVal(this.bufferVal().depthVal(), 255), -1, 0.2f);
    }

    private int extraRef() {
        return ThemePalette.secondaryVal(ColorUtil.primaryVal(this.bufferVal().descRef(), 255), -1, 0.12f);
    }
}

