/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1921
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_238
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_265
 *  net.minecraft.class_2680
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 *  net.minecraft.class_4184
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597$class_4598
 *  org.joml.Matrix4f
 */
package ru.metaculture.protection;

import net.minecraft.class_1921;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_2680;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_4184;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import org.joml.Matrix4f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.WildRenderLayers;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.ShaderPresetSetting;
import ru.metaculture.protection.VertexBufferPool;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ThemeTargetProvider;
import ru.metaculture.protection.ThemeSettingSync;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="BlockOutline", tertiaryVal=ModuleCategory.Visuals, secondaryVal="Smooth glowing outline for the targeted block")
public final class BlockOutlineModule
extends Module
implements ThemeTargetProvider {
    private static final double stageVal = 0.0022;
    private static final int[] widthRef;
    private static final int[] trackVal;
    public final FloatSetting countVal = new FloatSetting("Smoothness", 0.55f, 0.0f, 1.0f, 0.01f, true);
    public final FloatSetting depthVal = new FloatSetting("Transparency", 1.0f, 0.05f, 1.0f, 0.01f, true);
    public final FloatSetting descRef = new FloatSetting("Thickness", 2.0f, 0.5f, 6.0f, 0.1f, false);
    public final FloatSetting activeVal = new FloatSetting("Expansion", 0.0f, 0.0f, 0.2f, 0.005f, false);
    public final BoolSetting radiusVal = new BoolSetting("Glow", true);
    public final FloatSetting factorVal = new FloatSetting("Glow Strength", 1.2f, 0.2f, 3.0f, 0.05f, false).primaryVal(() -> !this.radiusVal.tertiaryVal());
    public final BoolSetting sourceVal = new BoolSetting("Fill", false);
    public final FloatSetting extraRef = new FloatSetting("Fill transparency", 0.22f, 0.02f, 0.8f, 0.01f, true).primaryVal(() -> !this.sourceVal.tertiaryVal());
    public final BoolSetting phaseVal = new BoolSetting("Pulsation", false);
    public final FloatSetting limitRef = new FloatSetting("Pulsation speed", 2.0f, 0.2f, 6.0f, 0.1f, false).primaryVal(() -> !this.phaseVal.tertiaryVal());
    public final BoolSetting paramRef = new BoolSetting("Through walls", false);
    public final ModeSetting groupVal;
    public final ColorSetting layerVal;
    public final FloatSetting slotVal;
    public final ShaderPresetSetting themeVal;
    private final double[] modeRef;
    private final double[] angleVal;
    private final double[] heightRef;
    private boolean levelVal;
    private float UuNnnVnuNNV;
    private long depthRef;

    public BlockOutlineModule() {
        String[] stringArray = new String[3];
        stringArray[0] = "Theme";
        stringArray[1] = "Custom";
        stringArray[2] = "Rainbow";
        this.groupVal = new ModeSetting("Color", "Theme", stringArray);
        this.layerVal = new ColorSetting("Custom color", 50.0f, 0.82f, 1.0f).secondaryVal(() -> !this.groupVal.secondaryVal("Custom"));
        this.slotVal = new FloatSetting("Rainbow speed", 1.0f, 0.1f, 4.0f, 0.1f, false).primaryVal(() -> !this.groupVal.secondaryVal("Rainbow"));
        this.themeVal = new ShaderPresetSetting("Foundry Shader", SurfaceTarget.ESP);
        this.modeRef = new double[6];
        this.angleVal = new double[6];
        this.heightRef = new double[24];
        Setting[] nvUuvVvuuNArray = new Setting[15];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        nvUuvVvuuNArray[5] = this.factorVal;
        nvUuvVvuuNArray[6] = this.sourceVal;
        nvUuvVvuuNArray[7] = this.extraRef;
        nvUuvVvuuNArray[8] = this.phaseVal;
        nvUuvVvuuNArray[9] = this.limitRef;
        nvUuvVvuuNArray[10] = this.paramRef;
        nvUuvVvuuNArray[11] = this.groupVal;
        nvUuvVvuuNArray[12] = this.layerVal;
        nvUuvVvuuNArray[13] = this.slotVal;
        nvUuvVvuuNArray[14] = this.themeVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        ThemeSettingSync.primaryVal().primaryVal(this, (ThemeTargetProvider)this);
    }

    @Override
    public void onDisable() {
        ThemeSettingSync.primaryVal().primaryVal(this);
        this.weightRef();
        super.onDisable();
    }

    @Override
    public SurfaceTarget tertiaryVal() {
        return SurfaceTarget.ESP;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public String marginVal() {
        String string = this.themeVal == null ? "" : this.themeVal.blockRef();
        if (string == null) return null;
        if (string.isBlank()) {
            return null;
        }
        String string2 = string;
        return string2;
    }

    @Override
    public boolean weightVal() {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        ThemeSettingSync.primaryVal().secondaryVal(this, (ThemeTargetProvider)this);
        if (BlockOutlineModule.mc.field_1687 == null || BlockOutlineModule.mc.field_1724 == null || BlockOutlineModule.mc.field_1773 == null) {
            this.weightRef();
            return;
        }
        boolean bl = this.blockRef();
        float f = this.tertiaryVal(bl);
        if (!this.levelVal || f <= 0.003f) {
            return;
        }
        class_4184 class_41842 = BlockOutlineModule.mc.field_1773.method_19418();
        if (class_41842 == null) {
            return;
        }
        class_243 class_2432 = class_41842.method_19326();
        Matrix4f matrix4f = vvuuvuVVvvn.tertiaryVal().method_23760().method_23761();
        this.primaryVal(class_2432);
        float f2 = this.phaseVal.tertiaryVal() ? 0.78f + 0.22f * (float)Math.sin((double)(BlockOutlineModule.anchorVal() * this.limitRef.tertiaryVal()) * Math.PI) : 1.0f;
        float f3 = class_3532.method_15363((float)(f * this.depthVal.tertiaryVal() * f2), (float)0.0f, (float)1.0f);
        if (f3 <= 0.003f) {
            return;
        }
        int n = this.holderVal();
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        boolean bl2 = !this.paramRef.tertiaryVal();
        float f4 = this.descRef.tertiaryVal();
        class_4597.class_4598 class_45982 = VertexBufferPool.primaryVal();
        try {
            int n5;
            if (this.sourceVal.tertiaryVal() && (n5 = BlockOutlineModule.primaryVal(this.extraRef.tertiaryVal() * f3 * 255.0f)) > 0) {
                class_1921 class_19212 = bl2 ? WildRenderLayers.marginVal() : WildRenderLayers.weightVal();
                this.secondaryVal(class_45982.getBuffer(class_19212), matrix4f, n2, n3, n4, n5);
            }
            if (this.radiusVal.tertiaryVal()) {
                float f5 = f4 * (2.4f + this.factorVal.tertiaryVal());
                int n6 = BlockOutlineModule.primaryVal(0.16f * this.factorVal.tertiaryVal() * f3 * 255.0f);
                if (n6 > 0) {
                    this.primaryVal(class_45982.getBuffer(BlockOutlineModule.primaryVal((double)f5, bl2)), matrix4f, n2, n3, n4, n6);
                }
            }
            n5 = BlockOutlineModule.primaryVal(f3 * 255.0f);
            this.primaryVal(class_45982.getBuffer(BlockOutlineModule.primaryVal((double)f4, bl2)), matrix4f, n2, n3, n4, n5);
        }
        finally {
            VertexBufferPool.secondaryVal();
        }
    }

    private boolean blockRef() {
        class_3965 class_39652;
        block7: {
            block6: {
                class_239 class_2392 = BlockOutlineModule.mc.field_1765;
                if (!(class_2392 instanceof class_3965)) break block6;
                class_39652 = (class_3965)class_2392;
                if (class_2392.method_17783() == class_239.class_240.field_1332) break block7;
            }
            return false;
        }
        class_2338 class_23382 = class_39652.method_17777();
        if (class_23382 == null) {
            return false;
        }
        class_2680 class_26802 = BlockOutlineModule.mc.field_1687.method_8320(class_23382);
        if (class_26802 == null || class_26802.method_26215()) {
            return false;
        }
        class_265 class_2652 = class_26802.method_26218((class_1922)BlockOutlineModule.mc.field_1687, class_23382);
        if (class_2652 == null || class_2652.method_1110()) {
            return false;
        }
        class_238 class_2383 = class_2652.method_1107();
        double d = (double)this.activeVal.tertiaryVal() + 0.0022;
        this.angleVal[0] = (double)class_23382.method_10263() + class_2383.field_1323 - d;
        this.angleVal[1] = (double)class_23382.method_10264() + class_2383.field_1322 - d;
        this.angleVal[2] = (double)class_23382.method_10260() + class_2383.field_1321 - d;
        this.angleVal[3] = (double)class_23382.method_10263() + class_2383.field_1320 + d;
        this.angleVal[4] = (double)class_23382.method_10264() + class_2383.field_1325 + d;
        this.angleVal[5] = (double)class_23382.method_10260() + class_2383.field_1324 + d;
        return true;
    }

    private float tertiaryVal(boolean bl) {
        long l = System.nanoTime();
        float f = this.depthRef == 0L ? 0.0f : Math.min((float)(l - this.depthRef) / 1.0E9f, 0.1f);
        this.depthRef = l;
        this.UuNnnVnuNNV += ((bl ? 1.0f : 0.0f) - this.UuNnnVnuNNV) * BlockOutlineModule.primaryVal(16.0f, f);
        if (!bl && this.UuNnnVnuNNV < 0.01f) {
            this.UuNnnVnuNNV = 0.0f;
            this.levelVal = false;
            return 0.0f;
        }
        if (!bl) {
            return this.UuNnnVnuNNV;
        }
        if (!this.levelVal) {
            System.arraycopy(this.angleVal, 0, this.modeRef, 0, 6);
            this.levelVal = true;
        } else {
            float f2 = class_3532.method_16439((float)class_3532.method_15363((float)this.countVal.tertiaryVal(), (float)0.0f, (float)1.0f), (float)42.0f, (float)4.5f);
            float f3 = BlockOutlineModule.primaryVal(f2, f);
            for (int i = 0; i < 6; ++i) {
                int n = i;
                this.modeRef[n] = this.modeRef[n] + (this.angleVal[i] - this.modeRef[i]) * (double)f3;
            }
        }
        return this.UuNnnVnuNNV;
    }

    private void primaryVal(class_243 class_2432) {
        double d = this.modeRef[0] - class_2432.field_1352;
        double d2 = this.modeRef[1] - class_2432.field_1351;
        double d3 = this.modeRef[2] - class_2432.field_1350;
        double d4 = this.modeRef[3] - class_2432.field_1352;
        double d5 = this.modeRef[4] - class_2432.field_1351;
        double d6 = this.modeRef[5] - class_2432.field_1350;
        for (int i = 0; i < 8; ++i) {
            int n = i * 3;
            this.heightRef[n] = (i & 1) == 0 ? d : d4;
            this.heightRef[n + 1] = (i & 2) == 0 ? d2 : d5;
            this.heightRef[n + 2] = (i & 4) == 0 ? d3 : d6;
        }
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, int n, int n2, int n3, int n4) {
        for (int i = 0; i < widthRef.length; i += 2) {
            int n5 = widthRef[i] * 3;
            int n6 = widthRef[i + 1] * 3;
            double d = this.heightRef[n5];
            double d2 = this.heightRef[n5 + 1];
            double d3 = this.heightRef[n5 + 2];
            double d4 = this.heightRef[n6];
            double d5 = this.heightRef[n6 + 1];
            double d6 = this.heightRef[n6 + 2];
            double d7 = d4 - d;
            double d8 = d5 - d2;
            double d9 = d6 - d3;
            double d10 = Math.sqrt(d7 * d7 + d8 * d8 + d9 * d9);
            if (d10 < 1.0E-6) {
                continue;
            }
            float f = (float)(d7 / d10);
            float f2 = (float)(d8 / d10);
            float f3 = (float)(d9 / d10);
            class_45882.method_22918(matrix4f, (float)d, (float)d2, (float)d3).method_1336(n, n2, n3, n4).method_22914(f, f2, f3);
            class_45882.method_22918(matrix4f, (float)d4, (float)d5, (float)d6).method_1336(n, n2, n3, n4).method_22914(f, f2, f3);
        }
    }

    private void secondaryVal(class_4588 class_45882, Matrix4f matrix4f, int n, int n2, int n3, int n4) {
        for (int i = 0; i < trackVal.length; i += 4) {
            for (int j = 0; j < 4; ++j) {
                int n5 = trackVal[i + j] * 3;
                class_45882.method_22918(matrix4f, (float)this.heightRef[n5], (float)this.heightRef[n5 + 1], (float)this.heightRef[n5 + 2]).method_1336(n, n2, n3, n4);
            }
        }
    }

    private static class_1921 primaryVal(double d, boolean bl) {
        return bl ? WildRenderLayers.primaryVal(d) : WildRenderLayers.secondaryVal(d);
    }

    private int holderVal() {
        if (this.groupVal.secondaryVal("Rainbow")) {
            float f = BlockOutlineModule.anchorVal() * this.slotVal.tertiaryVal() * 0.12f % 1.0f;
            return BlockOutlineModule.primaryVal(f < 0.0f ? f + 1.0f : f, 0.85f, 1.0f);
        }
        if (this.groupVal.secondaryVal("Custom")) {
            return this.layerVal.limitVal() & 0xFFFFFF;
        }
        return BlockOutlineModule.timerVal();
    }

    private static int timerVal() {
        try {
            if (WildClient.primaryVal != null && WildClient.primaryVal.chunkVal != null) {
                NvVNvUvunNNu nvVNvUvunNNu = WildClient.primaryVal.chunkVal.secondaryVal();
                if (nvVNvUvunNNu == NvVNvUvunNNu.CUSTOM && WildClient.primaryVal.chunkVal.secondaryVal != null) {
                    return WildClient.primaryVal.chunkVal.secondaryVal.limitVal() & 0xFFFFFF;
                }
                if (nvVNvUvunNNu != null && nvVNvUvunNNu.primaryVal() != null) {
                    return nvVNvUvunNNu.primaryVal().getRGB() & 0xFFFFFF;
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return 6061311;
    }

    private static int primaryVal(float f, float f2, float f3) {
        float f4;
        float f5;
        float f6 = (float)Math.floor(f * 6.0f);
        float f7 = f * 6.0f - f6;
        float f8 = f3 * (1.0f - f2);
        float f9 = f3 * (1.0f - f7 * f2);
        float f10 = f3 * (1.0f - (1.0f - f7) * f2);
        float f11 = switch ((int)f6 % 6) {
            case 0 -> {
                f5 = f3;
                f4 = f10;
                yield f8;
            }
            case 1 -> {
                f5 = f9;
                f4 = f3;
                yield f8;
            }
            case 2 -> {
                f5 = f8;
                f4 = f3;
                yield f10;
            }
            case 3 -> {
                f5 = f8;
                f4 = f9;
                yield f3;
            }
            case 4 -> {
                f5 = f10;
                f4 = f8;
                yield f3;
            }
            default -> {
                f5 = f3;
                f4 = f8;
                yield f9;
            }
        };
        return Math.round(f5 * 255.0f) << 16 | Math.round(f4 * 255.0f) << 8 | Math.round(f11 * 255.0f);
    }

    private static int primaryVal(float f) {
        return class_3532.method_15340((int)Math.round(f), (int)0, (int)255);
    }

    private static float primaryVal(float f, float f2) {
        return 1.0f - (float)Math.exp(-f * f2);
    }

    private static float anchorVal() {
        return (float)(System.nanoTime() % 1000000000000L) / 1.0E9f;
    }

    private void weightRef() {
        this.levelVal = false;
        this.UuNnnVnuNNV = 0.0f;
        this.depthRef = 0L;
    }

    static {
        int[] nArray = new int[24];
        nArray[0] = 0;
        nArray[1] = 1;
        nArray[2] = 1;
        nArray[3] = 5;
        nArray[4] = 5;
        nArray[5] = 4;
        nArray[6] = 4;
        nArray[7] = 0;
        nArray[8] = 2;
        nArray[9] = 3;
        nArray[10] = 3;
        nArray[11] = 7;
        nArray[12] = 7;
        nArray[13] = 6;
        nArray[14] = 6;
        nArray[15] = 2;
        nArray[16] = 0;
        nArray[17] = 2;
        nArray[18] = 1;
        nArray[19] = 3;
        nArray[20] = 5;
        nArray[21] = 7;
        nArray[22] = 4;
        nArray[23] = 6;
        widthRef = nArray;
        int[] nArray2 = new int[24];
        nArray2[0] = 0;
        nArray2[1] = 1;
        nArray2[2] = 5;
        nArray2[3] = 4;
        nArray2[4] = 2;
        nArray2[5] = 6;
        nArray2[6] = 7;
        nArray2[7] = 3;
        nArray2[8] = 0;
        nArray2[9] = 4;
        nArray2[10] = 6;
        nArray2[11] = 2;
        nArray2[12] = 1;
        nArray2[13] = 3;
        nArray2[14] = 7;
        nArray2[15] = 5;
        nArray2[16] = 0;
        nArray2[17] = 2;
        nArray2[18] = 3;
        nArray2[19] = 1;
        nArray2[20] = 4;
        nArray2[21] = 5;
        nArray2[22] = 7;
        nArray2[23] = 6;
        trackVal = nArray2;
    }
}

