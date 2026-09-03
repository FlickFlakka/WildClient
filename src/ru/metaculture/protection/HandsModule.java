/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1268
 *  net.minecraft.class_1306
 *  org.lwjgl.glfw.GLFW
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_1268;
import net.minecraft.class_1306;
import org.lwjgl.glfw.GLFW;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.GlowEspRenderer;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NnuVnuNVV;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.RenderHudEvent;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.NeumorphicThemeRenderer;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.HandFramebufferCapture;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="Hands", secondaryVal="Glow and customization of held items", tertiaryVal=ModuleCategory.Visuals)
public final class HandsModule
extends Module {
    public final SettingGroup countVal = new SettingGroup("Hands", new BoolSetting("Right", true), new BoolSetting("Left", true));
    public final ModeSetting depthVal = new ModeSetting("Effect", "Glow + Outline", "Glow + Outline", "Glow", "Outline");
    public final FloatSetting descRef = new FloatSetting("Radius", 8.0f, 2.0f, 24.0f, 1.0f, false).primaryVal(this::timerVal);
    public final FloatSetting activeVal = new FloatSetting("Glow Strength", 1.8f, 0.25f, 5.0f, 0.05f, false).primaryVal(this::timerVal);
    public final FloatSetting radiusVal = new FloatSetting("Outline Thickness", 1.5f, 0.5f, 6.0f, 0.5f, false).primaryVal(this::holderVal);
    public final FloatSetting factorVal = new FloatSetting("Transparency", 0.9f, 0.05f, 1.0f, 0.01f, true);
    public final ModeSetting sourceVal;
    public final ModeSetting extraRef;
    public final ColorSetting phaseVal;
    public final ColorSetting limitRef;
    private GlowEspRenderer paramRef;
    private static final class_1268[] groupVal = class_1268.values();
    private final float[] layerVal;
    private final float[] slotVal;

    public HandsModule() {
        String[] stringArray = new String[3];
        stringArray[0] = "Item";
        stringArray[1] = "Theme";
        stringArray[2] = "Custom";
        this.sourceVal = new ModeSetting("Color source", "Item", stringArray);
        this.extraRef = new ModeSetting("Color display", "Gradient", "Gradient", "Static");
        this.phaseVal = new ColorSetting("Primary color", 55.0f, 0.72f, 1.0f).secondaryVal(() -> !this.sourceVal.secondaryVal("Custom"));
        this.limitRef = new ColorSetting("Secondary color", 76.0f, 0.78f, 1.0f).secondaryVal(() -> {
            boolean bl;
            if (this.sourceVal.secondaryVal("Custom")) {
                if (!this.extraRef.secondaryVal("Static")) {
                    bl = false;
                    return bl;
                }
            }
            bl = true;
            return bl;
        });
        this.layerVal = new float[3];
        this.slotVal = new float[3];
        Setting[] nvUuvVvuuNArray = new Setting[10];
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
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onDisable() {
        this.bufferVal();
        super.onDisable();
    }

    public boolean primaryVal(class_1268 class_12682) {
        block3: {
            block2: {
                if (!this.enabled || class_12682 == null || HandsModule.mc.field_1724 == null || this.weightRef()) break block2;
                if (this.anchorVal()) break block3;
            }
            return false;
        }
        class_1306 class_13062 = class_12682 == class_1268.field_5808 ? HandsModule.mc.field_1724.method_6068() : HandsModule.primaryVal(HandsModule.mc.field_1724.method_6068());
        return this.countVal.secondaryVal(class_13062 == class_1306.field_6183 ? "Right" : "Left");
    }

    @Subscribe(priority=0)
    public void primaryVal(RenderHudEvent partD) {
        if (NnuVnuNVV.primaryVal() || partD == null || partD.marginVal() == null) {
            return;
        }
        partD.marginVal().tertiaryVal();
        this.primaryVal(partD.paramVal(), partD.extraVal());
        partD.marginVal().tertiaryVal();
    }

    public void blockRef() {
        if (!NnuVnuNVV.primaryVal() || mc.method_22683() == null) {
            return;
        }
        this.primaryVal(mc.method_22683().method_4489(), mc.method_22683().method_4506());
    }

    private void primaryVal(int n, int n2) {
        block9: {
            block8: {
                if (!this.enabled || HandsModule.mc.field_1687 == null || HandsModule.mc.field_1724 == null || n <= 0 || n2 <= 0 || mc.method_22683() == null) break block8;
                if (!mc.method_22683().method_65966()) break block9;
            }
            return;
        }
        HandFramebufferCapture sackB = HandFramebufferCapture.primaryVal();
        if (this.weightRef()) {
            sackB.primaryVal(false, false, n, n2);
            return;
        }
        if (!this.anchorVal()) {
            sackB.primaryVal(false, false, n, n2);
            return;
        }
        boolean bl = false;
        for (class_1268 class_12682 : groupVal) {
            int n3;
            if (!this.primaryVal(class_12682) || !sackB.secondaryVal(class_12682) || (n3 = sackB.tertiaryVal(class_12682)) <= 0) continue;
            if (this.paramRef == null) {
                this.paramRef = new GlowEspRenderer();
            }
            if (!bl) {
                this.primaryVal(this.layerVal, this.slotVal);
                bl = true;
            }
            int n4 = sackB.weightVal(class_12682);
            this.paramRef.primaryVal(n3, sackB.marginVal(class_12682), n4 > 0 ? n4 : n3, n, n2, new GlowEspRenderer.cursorVal(this.descRef.tertiaryVal() * 2.0f, this.radiusVal.tertiaryVal(), this.timerVal() ? 0.0f : this.activeVal.tertiaryVal() * 2.0f, this.holderVal() ? 0.0f : 1.35f, this.factorVal.tertiaryVal(), 0, this.extraRef.secondaryVal("Static") ? 1 : 0, this.sourceVal.secondaryVal("Item") ? 1 : 0, this.layerVal[0], this.layerVal[1], this.layerVal[2], this.slotVal[0], this.slotVal[1], this.slotVal[2]));
        }
    }

    private void primaryVal(float[] fArray, float[] fArray2) {
        if (this.sourceVal.secondaryVal("Custom")) {
            HandsModule.primaryVal(this.phaseVal.tertiaryVal().getRGB(), fArray);
            HandsModule.primaryVal(this.limitRef.tertiaryVal().getRGB(), fArray2);
            return;
        }
        NvVNvUvunNNu nvVNvUvunNNu = WildClient.primaryVal != null && WildClient.primaryVal.chunkVal != null ? WildClient.primaryVal.chunkVal.secondaryVal() : NvVNvUvunNNu.WILD;
        ThemePalette configVal = ThemePalette.primaryVal(nvVNvUvunNNu, NeumorphicThemeRenderer.marginVal());
        HandsModule.primaryVal(configVal.depthVal(), fArray);
        HandsModule.primaryVal(configVal.descRef(), fArray2);
    }

    private boolean holderVal() {
        return this.depthVal.secondaryVal("Glow");
    }

    private boolean timerVal() {
        return this.depthVal.secondaryVal("Outline");
    }

    private boolean anchorVal() {
        return HandsModule.mc.field_1690 != null && HandsModule.mc.field_1690.method_31044() != null && HandsModule.mc.field_1690.method_31044().method_31034();
    }

    private boolean weightRef() {
        return HandsModule.mc.field_1690 != null && HandsModule.mc.field_1690.field_1842;
    }

    private void bufferVal() {
        Runnable runnable = () -> {
            HandFramebufferCapture.primaryVal().secondaryVal();
            GlowEspRenderer duneA = this.paramRef;
            this.paramRef = null;
            if (duneA != null) {
                duneA.close();
            }
        };
        if (RenderSystem.isOnRenderThread() && GLFW.glfwGetCurrentContext() != 0L) {
            runnable.run();
        } else if (mc != null) {
            mc.execute(runnable);
        }
    }

    private static class_1306 primaryVal(class_1306 class_13062) {
        return class_13062 == class_1306.field_6183 ? class_1306.field_6182 : class_1306.field_6183;
    }

    private static void primaryVal(int n, float[] fArray) {
        fArray[0] = (float)(n >> 16 & 0xFF) / 255.0f;
        fArray[1] = (float)(n >> 8 & 0xFF) / 255.0f;
        fArray[2] = (float)(n & 0xFF) / 255.0f;
    }
}

