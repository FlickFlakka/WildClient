/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1542
 *  net.minecraft.class_1657
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_4184
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Vector3f
 *  org.joml.Vector4f
 *  org.lwjgl.glfw.GLFW
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1542;
import net.minecraft.class_1657;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_4184;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.glfw.GLFW;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.GlowEspRenderer;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NnuVnuNVV;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.RenderHudEvent;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.NeumorphicThemeRenderer;
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.EntityFramebufferCapture;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="GlowESP", secondaryVal="Shader gradient outline for players", tertiaryVal=ModuleCategory.Visuals)
public final class GlowESPModule
extends Module {
    private static final String themeVal = "glow_esp";
    private static final String stageVal = "glow_esp_friends";
    private static final GlowEspRenderer.WildClient widthRef = new GlowEspRenderer.WildClient(0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE);
    public final SettingGroup countVal;
    public final BoolSetting depthVal;
    public final FloatSetting descRef;
    public final ModeSetting activeVal;
    public final FloatSetting radiusVal;
    public final FloatSetting factorVal;
    public final FloatSetting sourceVal;
    public final FloatSetting extraRef;
    public final ModeSetting phaseVal;
    public final ModeSetting limitRef;
    public final ColorSetting paramRef;
    public final ColorSetting groupVal;
    public final BoolSetting layerVal;
    public final ColorSetting slotVal;
    private final Predicate<class_1297> trackVal;
    private final Predicate<class_1297> modeRef;
    private GlowEspRenderer angleVal;
    private static final int heightRef = 0;
    private static final int levelVal = 1;
    private static final int UuNnnVnuNNV = 2;
    private final Matrix4f depthRef;
    private final Matrix4f speedRef;
    private final Vector4f countRef;
    private final Vector3f entryVal;
    private final int[] guardVal;
    private final float[] VUuuVUnun;
    private final float[] vVVuuVVv;
    private final float[] VuunNUUUvu;
    private final float[] NNUUNUuVNNVn;
    private final float[] VvVvnNUnvuvV;
    private boolean tokenVal;
    private GlowEspRenderer.WildClient NUVvUUVuVNVv;

    public GlowESPModule() {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[4];
        vvNnnUNnVvnArray[0] = new BoolSetting("Players", true);
        vvNnnUNnVvnArray[1] = new BoolSetting("Mobs", false);
        vvNnnUNnVvnArray[2] = new BoolSetting("Items", false);
        vvNnnUNnVvnArray[3] = new BoolSetting("Self", false);
        this.countVal = new SettingGroup("Targets", vvNnnUNnVvnArray);
        this.depthVal = new BoolSetting("Invisible", true);
        this.descRef = new FloatSetting("Distance", 96.0f, 8.0f, 256.0f, 1.0f, false);
        this.activeVal = new ModeSetting("Effect", "Glow + Outline", "Glow + Outline", "Glow", "Outline");
        this.radiusVal = new FloatSetting("Glow size", 10.0f, 2.0f, 32.0f, 1.0f, false).primaryVal(this::anchorVal);
        this.factorVal = new FloatSetting("Glow brightness", 2.0f, 0.25f, 5.0f, 0.05f, false).primaryVal(this::anchorVal);
        this.sourceVal = new FloatSetting("Outline Thickness", 2.0f, 0.5f, 6.0f, 0.5f, false).primaryVal(this::timerVal);
        this.extraRef = new FloatSetting("Transparency", 0.92f, 0.05f, 1.0f, 0.01f, true);
        String[] stringArray = new String[2];
        stringArray[0] = "Gradient";
        stringArray[1] = "Static";
        this.phaseVal = new ModeSetting("Color mode", "Gradient", stringArray);
        this.limitRef = new ModeSetting("Color source", "Theme", "Theme", "Custom");
        this.paramRef = new ColorSetting("Primary color", 55.0f, 0.72f, 1.0f).secondaryVal(() -> this.limitRef.secondaryVal("Theme"));
        this.groupVal = new ColorSetting("Secondary color", 76.0f, 0.78f, 1.0f).secondaryVal(() -> {
            boolean bl;
            if (!this.limitRef.secondaryVal("Theme")) {
                if (!this.phaseVal.secondaryVal("Static")) {
                    bl = false;
                    return bl;
                }
            }
            bl = true;
            return bl;
        });
        this.layerVal = new BoolSetting("Highlight friends", true);
        this.slotVal = new ColorSetting("Friends color", 40.0f, 0.8f, 1.0f).secondaryVal(() -> !this.layerVal.tertiaryVal());
        this.trackVal = this::primaryVal;
        this.modeRef = class_12972 -> {
            if (!this.primaryVal((class_1297)class_12972)) return false;
            if (!this.secondaryVal((class_1297)class_12972)) return false;
            return true;
        };
        this.depthRef = new Matrix4f();
        this.speedRef = new Matrix4f();
        this.countRef = new Vector4f();
        this.entryVal = new Vector3f();
        int[] nArray = new int[4];
        nArray[0] = 0;
        nArray[1] = 0;
        nArray[2] = 0;
        nArray[3] = 0;
        this.guardVal = nArray;
        this.VUuuVUnun = new float[4];
        this.vVVuuVVv = new float[3];
        this.VuunNUUUvu = new float[3];
        this.NNUUNUuVNNVn = new float[3];
        this.VvVvnNUnvuvV = new float[4];
        Setting[] nvUuvVvuuNArray = new Setting[14];
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
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.holderVal();
    }

    @Override
    public void onDisable() {
        EntityFramebufferCapture coreI = EntityFramebufferCapture.primaryVal();
        coreI.secondaryVal(stageVal);
        coreI.primaryVal(themeVal);
        this.weightRef();
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        this.holderVal();
    }

    @Subscribe(priority=0)
    public void primaryVal(RenderHudEvent partD) {
        block6: {
            block5: {
                this.holderVal();
                if (NnuVnuNVV.primaryVal()) {
                    return;
                }
                if (partD == null || partD.tertiaryVal() == null || GlowESPModule.mc.field_1687 == null) break block5;
                if (GlowESPModule.mc.field_1724 != null && mc.method_22683() != null && !mc.method_22683().method_65966()) break block6;
            }
            return;
        }
        int n = partD.paramVal();
        int n2 = partD.extraVal();
        if (n <= 0 || n2 <= 0) {
            return;
        }
        this.primaryVal(n, n2, partD.marginVal());
    }

    public void blockRef() {
        if (!this.enabled || !NnuVnuNVV.primaryVal() || GlowESPModule.mc.field_1687 == null || GlowESPModule.mc.field_1724 == null || mc.method_22683() == null || mc.method_22683().method_65966()) {
            return;
        }
        int n = mc.method_22683().method_4489();
        int n2 = mc.method_22683().method_4506();
        if (n <= 0 || n2 <= 0) {
            return;
        }
        this.primaryVal(n, n2, null);
    }

    private void primaryVal(int n, int n2, Renderer2D heightVal) {
        GlowEspRenderer.WildClient modeVal;
        EntityFramebufferCapture coreI = EntityFramebufferCapture.primaryVal();
        int n3 = coreI.marginVal();
        int n4 = coreI.weightVal();
        if (n3 <= 0) {
            return;
        }
        int n5 = 0;
        int n6 = 0;
        if (this.layerVal.tertiaryVal() && n4 > 0) {
            n5 = coreI.extraVal();
            n6 = coreI.limitVal();
        }
        boolean bl = n5 > 0 && n6 > 0;
        float f = this.radiusVal.tertiaryVal() * 2.0f;
        float f2 = this.sourceVal.tertiaryVal();
        GlowEspRenderer.WildClient nodeC = this.primaryVal(n, n2, this.anchorVal() ? 0.0f : f, this.timerVal() ? 0.0f : f2);
        if (nodeC == null) {
            return;
        }
        GlowEspRenderer.WildClient partE = modeVal = nodeC == widthRef ? null : nodeC;
        if (this.angleVal == null) {
            this.angleVal = new GlowEspRenderer();
        }
        if (heightVal != null) {
            heightVal.tertiaryVal();
        }
        this.secondaryVal(this.vVVuuVVv, this.VuunNUUUvu);
        this.angleVal.primaryVal(n3, n4, n, n2, this.primaryVal(this.vVVuuVVv, this.VuunNUUUvu), modeVal, n5, n6, bl ? 1 : 0);
        if (bl) {
            GlowESPModule.primaryVal(this.slotVal.tertiaryVal().getRGB(), this.NNUUNUuVNNVn);
            this.angleVal.primaryVal(n3, n4, n, n2, this.primaryVal(this.NNUUNUuVNNVn, this.NNUUNUuVNNVn), this.NUVvUUVuVNVv, n5, n6, 2);
        }
        if (heightVal != null) {
            heightVal.tertiaryVal();
        }
    }

    private GlowEspRenderer.cursorVal primaryVal(float[] fArray, float[] fArray2) {
        return new GlowEspRenderer.cursorVal(this.radiusVal.tertiaryVal() * 2.0f, this.sourceVal.tertiaryVal(), this.anchorVal() ? 0.0f : this.factorVal.tertiaryVal() * 2.0f, this.timerVal() ? 0.0f : 1.35f, this.extraRef.tertiaryVal(), 0, this.phaseVal.secondaryVal("Static") ? 1 : 0, 0, fArray[0], fArray[1], fArray[2], fArray2[0], fArray2[1], fArray2[2]);
    }

    private boolean primaryVal(class_1297 class_12972) {
        block10: {
            block9: {
                if (!this.enabled) break block9;
                if (GlowESPModule.mc.field_1724 != null && class_12972 != null && class_12972.method_5805() && !class_12972.method_31481()) break block10;
            }
            return false;
        }
        if (class_12972.method_5767()) {
            if (!this.depthVal.tertiaryVal()) {
                return false;
            }
        }
        float f = Math.max(1.0f, this.descRef.tertiaryVal());
        if (GlowESPModule.mc.field_1724.method_5858(class_12972) > (double)(f * f)) {
            return false;
        }
        if (class_12972 == GlowESPModule.mc.field_1724) {
            return this.countVal.secondaryVal("Self");
        }
        if (class_12972 instanceof class_1657) {
            return this.countVal.secondaryVal("Players");
        }
        if (class_12972 instanceof class_1542) {
            return this.countVal.secondaryVal("Items");
        }
        return class_12972 instanceof class_1309 && this.countVal.secondaryVal("Mobs");
    }

    private GlowEspRenderer.WildClient primaryVal(int n, int n2, float f, float f2) {
        int n3;
        float f3;
        float f4;
        float f5;
        float f6;
        block11: {
            block10: {
                this.NUVvUUVuVNVv = null;
                this.tokenVal = false;
                if (GlowESPModule.mc.field_1687 == null || GlowESPModule.mc.field_1773 == null || n <= 0 || n2 <= 0) {
                    return widthRef;
                }
                class_4184 class_41842 = GlowESPModule.mc.field_1773.method_19418();
                if (class_41842 == null) {
                    return widthRef;
                }
                class_243 class_2432 = class_41842.method_19326();
                this.depthRef.set((Matrix4fc)VnNnNnvuvn.tertiaryVal);
                this.speedRef.set((Matrix4fc)VnNnNnvuvn.primaryVal).mul((Matrix4fc)VnNnNnvuvn.secondaryVal);
                this.guardVal[0] = 0;
                this.guardVal[1] = 0;
                this.guardVal[2] = n;
                this.guardVal[3] = n2;
                float f7 = mc.method_61966().method_60637(true);
                boolean bl = this.layerVal.tertiaryVal();
                f6 = Float.POSITIVE_INFINITY;
                f5 = Float.POSITIVE_INFINITY;
                f4 = Float.NEGATIVE_INFINITY;
                f3 = Float.NEGATIVE_INFINITY;
                boolean bl2 = false;
                for (class_1297 class_12972 : GlowESPModule.mc.field_1687.method_18112()) {
                    if (!this.primaryVal(class_12972)) continue;
                    n3 = this.primaryVal(class_12972, f7, n, n2, class_2432);
                    if (n3 == 2) {
                        return widthRef;
                    }
                    if (n3 == 1) {
                        continue;
                    }
                    f6 = Math.min(f6, this.VUuuVUnun[0]);
                    f5 = Math.min(f5, this.VUuuVUnun[1]);
                    f4 = Math.max(f4, this.VUuuVUnun[2]);
                    f3 = Math.max(f3, this.VUuuVUnun[3]);
                    bl2 = true;
                    if (!bl || !this.secondaryVal(class_12972)) continue;
                    if (this.tokenVal) {
                        this.VvVvnNUnvuvV[0] = Math.min(this.VvVvnNUnvuvV[0], this.VUuuVUnun[0]);
                        this.VvVvnNUnvuvV[1] = Math.min(this.VvVvnNUnvuvV[1], this.VUuuVUnun[1]);
                        this.VvVvnNUnvuvV[2] = Math.max(this.VvVvnNUnvuvV[2], this.VUuuVUnun[2]);
                        this.VvVvnNUnvuvV[3] = Math.max(this.VvVvnNUnvuvV[3], this.VUuuVUnun[3]);
                        continue;
                    }
                    this.VvVvnNUnvuvV[0] = this.VUuuVUnun[0];
                    this.VvVvnNUnvuvV[1] = this.VUuuVUnun[1];
                    this.VvVvnNUnvuvV[2] = this.VUuuVUnun[2];
                    this.VvVvnNUnvuvV[3] = this.VUuuVUnun[3];
                    this.tokenVal = true;
                }
                if (this.tokenVal) {
                    this.NUVvUUVuVNVv = this.primaryVal(this.VvVvnNUnvuvV, n, n2, f, f2);
                }
                if (!bl2 || !Float.isFinite(f6)) break block10;
                if (Float.isFinite(f5) && Float.isFinite(f4) && Float.isFinite(f3)) break block11;
            }
            return null;
        }
        int n4 = (int)Math.ceil(Math.max(8.0f, f + f2 * 4.0f + 18.0f));
        int n5 = Math.max(0, (int)Math.floor(f6) - n4);
        n3 = Math.max(0, (int)Math.floor(f5) - n4);
        int n6 = Math.min(n, (int)Math.ceil(f4) + n4);
        int n7 = Math.min(n2, (int)Math.ceil(f3) + n4);
        int n8 = n6 - n5;
        int n9 = n7 - n3;
        return n8 > 2 && n9 > 2 ? new GlowEspRenderer.WildClient(n5, n3, n8, n9) : widthRef;
    }

    private int primaryVal(class_1297 class_12972, float f, int n, int n2, class_243 class_2432) {
        int n3;
        int n4;
        class_243 class_2433 = class_12972.method_30950(f);
        class_243 class_2434 = class_12972.method_19538();
        double d = class_2433.field_1352 - class_2434.field_1352;
        double d2 = class_2433.field_1351 - class_2434.field_1351;
        double d3 = class_2433.field_1350 - class_2434.field_1350;
        double d4 = class_12972 instanceof class_1542 ? 0.45 : 0.18;
        double d5 = Math.max(0.1, d4 * 0.65);
        class_238 class_2383 = class_12972.method_5829();
        double d6 = class_2383.field_1323 + d - d4;
        double d7 = class_2383.field_1320 + d + d4;
        double d8 = class_2383.field_1322 + d2 - d5;
        double d9 = class_2383.field_1325 + d2 + d5;
        double d10 = class_2383.field_1321 + d3 - d4;
        double d11 = class_2383.field_1324 + d3 + d4;
        float f2 = Float.POSITIVE_INFINITY;
        float f3 = Float.POSITIVE_INFINITY;
        float f4 = Float.NEGATIVE_INFINITY;
        float f5 = Float.NEGATIVE_INFINITY;
        for (n4 = 0; n4 < 2; ++n4) {
            double d12 = n4 == 0 ? d6 : d7;
            for (n3 = 0; n3 < 2; ++n3) {
                double d13 = n3 == 0 ? d8 : d9;
                for (int i = 0; i < 2; ++i) {
                    double d14;
                    double d15 = d14 = i == 0 ? d10 : d11;
                    if (!this.primaryVal(d12, d13, d14, class_2432)) {
                        return 2;
                    }
                    float f6 = this.entryVal.z;
                    if (f6 <= 0.001f || f6 > 1.0f) {
                        return 2;
                    }
                    float f7 = this.entryVal.x;
                    float f8 = (float)n2 - this.entryVal.y;
                    f2 = Math.min(f2, f7);
                    f3 = Math.min(f3, f8);
                    f4 = Math.max(f4, f7);
                    f5 = Math.max(f5, f8);
                }
            }
        }
        if (!(Float.isFinite(f2) && Float.isFinite(f3) && Float.isFinite(f4) && Float.isFinite(f5))) {
            return 1;
        }
        if (f4 < 0.0f || f5 < 0.0f || f2 > (float)n || f3 > (float)n2) {
            return 1;
        }
        n4 = Math.max(0, (int)Math.floor(f2));
        int n5 = Math.max(0, (int)Math.floor(f3));
        int n6 = Math.min(n, (int)Math.ceil(f4));
        n3 = Math.min(n2, (int)Math.ceil(f5));
        if (n6 - n4 <= 0 || n3 - n5 <= 0) {
            return 1;
        }
        this.VUuuVUnun[0] = n4;
        this.VUuuVUnun[1] = n5;
        this.VUuuVUnun[2] = n6;
        this.VUuuVUnun[3] = n3;
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(double d, double d2, double d3, class_243 class_2432) {
        this.countRef.set((float)(d - class_2432.field_1352), (float)(d2 - class_2432.field_1351), (float)(d3 - class_2432.field_1350), 1.0f).mul((Matrix4fc)this.depthRef);
        this.speedRef.project(this.countRef.x(), this.countRef.y(), this.countRef.z(), this.guardVal, this.entryVal);
        if (!Float.isFinite(this.entryVal.x)) return false;
        if (!Float.isFinite(this.entryVal.y)) return false;
        if (!Float.isFinite(this.entryVal.z)) return false;
        return true;
    }

    private void holderVal() {
        EntityFramebufferCapture coreI = EntityFramebufferCapture.primaryVal();
        coreI.primaryVal(themeVal, this.enabled, this.trackVal);
        boolean bl = this.enabled && this.layerVal.tertiaryVal() && !FriendCommand.marginVal().isEmpty();
        coreI.secondaryVal(stageVal, bl, this.modeRef);
    }

    private boolean timerVal() {
        return this.activeVal.secondaryVal("Glow");
    }

    private boolean anchorVal() {
        return this.activeVal.secondaryVal("Outline");
    }

    private boolean secondaryVal(class_1297 class_12972) {
        class_1657 class_16572;
        block3: {
            block2: {
                if (!(class_12972 instanceof class_1657)) break block2;
                class_16572 = (class_1657)class_12972;
                if (class_12972 != GlowESPModule.mc.field_1724) break block3;
            }
            return false;
        }
        String string = class_16572.method_7334() != null ? class_16572.method_7334().getName() : class_16572.method_5477().getString();
        return FriendCommand.primaryVal(string);
    }

    private GlowEspRenderer.WildClient primaryVal(float[] fArray, int n, int n2, float f, float f2) {
        int n3 = (int)Math.ceil(Math.max(8.0f, f + f2 * 4.0f + 18.0f));
        int n4 = Math.max(0, (int)Math.floor(fArray[0]) - n3);
        int n5 = Math.max(0, (int)Math.floor(fArray[1]) - n3);
        int n6 = Math.min(n, (int)Math.ceil(fArray[2]) + n3);
        int n7 = Math.min(n2, (int)Math.ceil(fArray[3]) + n3);
        int n8 = n6 - n4;
        int n9 = n7 - n5;
        return n8 > 2 && n9 > 2 ? new GlowEspRenderer.WildClient(n4, n5, n8, n9) : null;
    }

    private void secondaryVal(float[] fArray, float[] fArray2) {
        if (this.limitRef.secondaryVal("Custom")) {
            GlowESPModule.primaryVal(this.paramRef.tertiaryVal().getRGB(), fArray);
            GlowESPModule.primaryVal(this.groupVal.tertiaryVal().getRGB(), fArray2);
            return;
        }
        NvVNvUvunNNu nvVNvUvunNNu = WildClient.primaryVal != null && WildClient.primaryVal.chunkVal != null ? WildClient.primaryVal.chunkVal.secondaryVal() : NvVNvUvunNNu.WILD;
        ThemePalette configVal = ThemePalette.primaryVal(nvVNvUvunNNu, NeumorphicThemeRenderer.marginVal());
        GlowESPModule.primaryVal(configVal.depthVal(), fArray);
        GlowESPModule.primaryVal(configVal.descRef(), fArray2);
    }

    private static void primaryVal(int n, float[] fArray) {
        fArray[0] = (float)(n >> 16 & 0xFF) / 255.0f;
        fArray[1] = (float)(n >> 8 & 0xFF) / 255.0f;
        fArray[2] = (float)(n & 0xFF) / 255.0f;
    }

    private void weightRef() {
        GlowEspRenderer duneA = this.angleVal;
        this.angleVal = null;
        if (duneA == null) {
            return;
        }
        if (RenderSystem.isOnRenderThread()) {
            if (GLFW.glfwGetCurrentContext() != 0L) {
                duneA.close();
                return;
            }
        }
        if (mc != null) {
            mc.execute(duneA::close);
        }
    }
}

