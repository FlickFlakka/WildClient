/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTexture
 *  net.fabricmc.api.EnvType
 *  net.fabricmc.api.Environment
 *  net.minecraft.class_10868
 *  net.minecraft.class_11223
 *  net.minecraft.class_1297
 *  net.minecraft.class_2561
 *  net.minecraft.class_266
 *  net.minecraft.class_276
 *  net.minecraft.class_2960
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_327
 *  net.minecraft.class_329
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 *  net.minecraft.class_9779
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL30
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import com.mojang.blaze3d.textures.GpuTexture;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.class_10868;
import net.minecraft.class_11223;
import net.minecraft.class_1297;
import net.minecraft.class_2561;
import net.minecraft.class_266;
import net.minecraft.class_276;
import net.minecraft.class_2960;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_327;
import net.minecraft.class_329;
import net.minecraft.class_332;
import net.minecraft.class_437;
import net.minecraft.class_9779;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.KillAuraSettings;
import ru.metaculture.protection.NnUuNVvUvvNn;
import ru.metaculture.protection.RenderHudEvent;
import ru.metaculture.protection.AimLabScreen;
import ru.metaculture.protection.ColorPlusModule;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ProtectInfoModule;
import ru.metaculture.protection.MotionBlurModule;
import ru.metaculture.protection.AudioDeviceReset;
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.VuVNuuUUv;
import ru.metaculture.protection.VvNUnuUUuN;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.HudLayoutManager;
import ru.metaculture.protection.AnimationsModule;
import ru.metaculture.protection.ModernClickGuiScreen;
import ru.metaculture.protection.HudModule;
import ru.metaculture.protection.AutoBuyScreen;
import ru.metaculture.protection.RemovalsModule;
import ru.metaculture.protection.ColorGradePreset;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.AutoSwapModule;
import ru.metaculture.protection.MotionBlurRenderer;
import ru.metaculture.protection.RotationBuilderScreen;

@Environment(value=EnvType.CLIENT)
@Mixin(value={class_329.class})
public class InGameHudMixin {
    @Unique
    private static final RenderHudEvent wild$cachedEventScreen = new RenderHudEvent();
    @Unique
    private long wild$lastCorruptionFrameMs;
    @Unique
    private float wild$heldTearY;
    @Unique
    private float wild$heldTearH;
    @Unique
    private float wild$heldTearShift;
    @Unique
    private float wild$panicWhite;
    @Unique
    private float wild$panicBlack;

    @Inject(method={"renderCrosshair"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRenderCrosshair(class_332 class_3322, class_9779 class_97792, CallbackInfo callbackInfo) {
        class_310 class_3102 = class_310.method_1551();
        if (VvNUnuUUuN.weightVal()) {
            callbackInfo.cancel();
            return;
        }
        if (AutoSwapModule.blockRef() || class_3102.field_1755 instanceof AutoBuyScreen || class_3102.field_1755 instanceof ModernClickGuiScreen || class_3102.field_1755 instanceof KillAuraSettings || class_3102.field_1755 instanceof RotationBuilderScreen || class_3102.field_1755 instanceof AimLabScreen) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderStatusEffectOverlay"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRenderStatusEffects(class_332 class_3322, class_9779 class_97792, CallbackInfo callbackInfo) {
        if (VvNUnuUUuN.weightVal()) {
            callbackInfo.cancel();
            return;
        }
        if (HudModule.activeVal.secondaryVal("Potions") || InGameHudMixin.wild$noRenderPotions()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderHotbar"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRenderHotbar(class_332 class_3322, class_9779 class_97792, CallbackInfo callbackInfo) {
        if (VvNUnuUUuN.weightVal()) {
            callbackInfo.cancel();
            return;
        }
        if (InGameHudMixin.wild$customHotbarActive() || this.wild$foundryOverlayVisible() || class_310.method_1551().field_1755 instanceof KillAuraSettings) {
            callbackInfo.cancel();
        }
    }

    @Unique
    private boolean wild$foundryOverlayVisible() {
        class_437 class_4372;
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || !((class_4372 = class_3102.field_1755) instanceof ModernClickGuiScreen)) {
            return false;
        }
        ModernClickGuiScreen mossB = (ModernClickGuiScreen)class_4372;
        return mossB.primaryVal().primaryVal();
    }

    @Inject(method={"renderStatusBars"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void onRenderStatusBars(class_332 class_3322, CallbackInfo callbackInfo) {
        if (VvNUnuUUuN.weightVal() || InGameHudMixin.wild$customHotbarActive()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderHeldItemTooltip"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void wild$cancelHeldItemTooltip(class_332 class_3322, CallbackInfo callbackInfo) {
        if (VvNUnuUUuN.weightVal() || InGameHudMixin.wild$customHotbarActive()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/scoreboard/ScoreboardObjective;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRenderScoreboardSidebar(class_332 class_3322, class_266 class_2662, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (VvNUnuUUuN.weightVal()) {
            callbackInfo.cancel();
            return;
        }
        ProtectInfoModule unVVnUuvNvu = WildClient.primaryVal.secondaryVal.primaryVal(ProtectInfoModule.class);
        if (unVVnUuvNvu != null && unVVnUuvNvu.enabled && unVVnUuvNvu.phaseVal.tertiaryVal()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderMainHud"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void wild$cancelMainHudDuringCorruption(class_332 class_3322, class_9779 class_97792, CallbackInfo callbackInfo) {
        if (VvNUnuUUuN.weightVal()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderPlayerList"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void wild$cancelPlayerListDuringCorruption(class_332 class_3322, class_9779 class_97792, CallbackInfo callbackInfo) {
        if (VvNUnuUUuN.weightVal()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderOverlayMessage"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void wild$cancelOverlayMessageDuringCorruption(class_332 class_3322, class_9779 class_97792, CallbackInfo callbackInfo) {
        if (VvNUnuUUuN.weightVal()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderTitleAndSubtitle"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void wild$cancelTitleDuringCorruption(class_332 class_3322, class_9779 class_97792, CallbackInfo callbackInfo) {
        if (VvNUnuUUuN.weightVal()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderVignetteOverlay"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void wild$cancelVignette(class_332 class_3322, class_1297 class_12972, CallbackInfo callbackInfo) {
        if (RemovalsModule.primaryVal("Vignette")) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderSpyglassOverlay"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void wild$cancelSpyglass(class_332 class_3322, float f, CallbackInfo callbackInfo) {
        if (RemovalsModule.primaryVal("Spyglass")) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderPortalOverlay"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void wild$cancelPortalOverlay(class_332 class_3322, float f, CallbackInfo callbackInfo) {
        if (RemovalsModule.primaryVal("Portal")) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderNauseaOverlay"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void wild$cancelNauseaOverlay(class_332 class_3322, float f, CallbackInfo callbackInfo) {
        if (RemovalsModule.primaryVal("Nausea (Screen)")) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderOverlay"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void wild$cancelMiscOverlay(class_332 class_3322, class_2960 class_29602, float f, CallbackInfo callbackInfo) {
        if (class_29602 == null) {
            return;
        }
        String string = class_29602.method_12832();
        if (string.contains("pumpkin") && RemovalsModule.primaryVal("Pumpkin")) {
            callbackInfo.cancel();
            return;
        }
        if (string.contains("powder_snow") && RemovalsModule.primaryVal("Powder Snow")) {
            callbackInfo.cancel();
        }
    }

    @Redirect(method={"renderPlayerList"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/option/KeyBinding;isPressed()Z"), require=0)
    private boolean wild$keepTabListForClose(class_304 class_3042) {
        if (!WildClient.limitVal()) {
            return false;
        }
        if (VvNUnuUUuN.weightVal()) {
            return false;
        }
        boolean bl = class_3042.method_1434();
        if (!WildClient.groupVal() || WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return bl;
        }
        AnimationsModule twigI = WildClient.primaryVal.secondaryVal.primaryVal(AnimationsModule.class);
        if (twigI == null || !twigI.enabled || !twigI.countVal.secondaryVal("Tab")) {
            return bl;
        }
        return twigI.tertiaryVal(bl);
    }

    @Redirect(method={"renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/scoreboard/ScoreboardObjective;)V"}, at=@At(value="INVOKE", target="Lnet/minecraft/scoreboard/ScoreboardObjective;getDisplayName()Lnet/minecraft/text/Text;"))
    private class_2561 litka$maskScoreboardTitle(class_266 class_2662) {
        if (VvNUnuUUuN.weightVal()) {
            return class_2561.method_43473();
        }
        if (class_2662 == null) {
            return class_2561.method_43473();
        }
        class_2561 class_25612 = class_2662.method_1114();
        return class_25612 != null ? ProtectInfoModule.primaryVal(class_25612) : class_2561.method_43473();
    }

    @Redirect(method={"renderMainHud"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/hud/bar/Bar;drawExperienceLevel(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/font/TextRenderer;I)V"))
    private void redirectDrawExperienceLevel(class_332 class_3322, class_327 class_3272, int n) {
        if (!VvNUnuUUuN.weightVal() && !InGameHudMixin.wild$customHotbarActive()) {
            class_11223.method_70866((class_332)class_3322, (class_327)class_3272, (int)n);
        }
    }

    @Redirect(method={"renderMainHud"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/hud/bar/Bar;renderBar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V"), require=0)
    private void redirectRenderBar(class_11223 class_112232, class_332 class_3322, class_9779 class_97792) {
        if (VvNUnuUUuN.weightVal()) {
            return;
        }
        if (InGameHudMixin.wild$customHotbarActive()) {
            return;
        }
        class_112232.method_70865(class_3322, class_97792);
    }

    @Redirect(method={"renderMainHud"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/hud/bar/Bar;renderAddons(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/render/RenderTickCounter;)V"), require=0)
    private void redirectRenderAddons(class_11223 class_112232, class_332 class_3322, class_9779 class_97792) {
        if (VvNUnuUUuN.weightVal()) {
            return;
        }
        if (InGameHudMixin.wild$customHotbarActive()) {
            return;
        }
        class_112232.method_70868(class_3322, class_97792);
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void wild$applyColorPlus(class_332 class_3322, class_9779 class_97792, CallbackInfo callbackInfo) {
        boolean bl;
        MotionBlurModule vNNNVuNvvNvn;
        ColorPlusModule coreF;
        if (!WildClient.limitVal()) {
            return;
        }
        if (!WildClient.groupVal()) {
            return;
        }
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        try {
            coreF = (ColorPlusModule)WildClient.primaryVal.secondaryVal.secondaryVal(ColorPlusModule.class);
            vNNNVuNvvNvn = (MotionBlurModule)WildClient.primaryVal.secondaryVal.secondaryVal(MotionBlurModule.class);
        }
        catch (Throwable throwable) {
            return;
        }
        boolean bl2 = coreF != null && coreF.enabled;
        boolean bl3 = bl = vNNNVuNvvNvn != null && vNNNVuNvvNvn.enabled;
        if (!bl2 && !bl) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.field_1687 == null || class_3102.field_1724 == null) {
            return;
        }
        if (class_3102.method_22683() == null) {
            return;
        }
        int n = class_3102.method_22683().method_4489();
        int n2 = class_3102.method_22683().method_4506();
        if (n <= 1 || n2 <= 1) {
            return;
        }
        class_276 class_2762 = class_3102.method_1522();
        if (class_2762 == null) {
            return;
        }
        GpuTexture gpuTexture = class_2762.method_30277();
        if (!(gpuTexture instanceof class_10868)) {
            return;
        }
        class_10868 class_108682 = (class_10868)gpuTexture;
        int n3 = class_108682.method_68427();
        if (n3 <= 0) {
            return;
        }
        if (bl) {
            if (class_3102.field_1755 == null) {
                try {
                    MotionBlurRenderer.primaryVal().primaryVal(class_3102, class_3102.field_1773.method_19418(), new Matrix4f((Matrix4fc)VnNnNnvuvn.tertiaryVal), new Matrix4f((Matrix4fc)VnNnNnvuvn.primaryVal), vNNNVuNvvNvn.blockRef());
                }
                catch (Throwable throwable) {
                    System.err.println("[SilkFlow] apply failed: " + throwable.getMessage());
                }
            } else {
                MotionBlurRenderer.primaryVal().secondaryVal();
            }
        }
        if (!bl2) {
            return;
        }
        ColorGradePreset uuuUNnu2 = coreF.blockRef();
        VuVNuuUUv.WildClient modeVal = new VuVNuuUUv.WildClient();
        modeVal.primaryVal = coreF.depthVal.tertiaryVal();
        modeVal.secondaryVal = uuuUNnu2.secondaryVal + coreF.activeVal.tertiaryVal();
        modeVal.tertiaryVal = uuuUNnu2.tertiaryVal + coreF.radiusVal.tertiaryVal();
        modeVal.marginVal = uuuUNnu2.marginVal + coreF.factorVal.tertiaryVal();
        modeVal.weightVal = uuuUNnu2.weightVal + coreF.sourceVal.tertiaryVal();
        modeVal.paramVal = uuuUNnu2.paramVal + coreF.extraRef.tertiaryVal();
        modeVal.extraVal = uuuUNnu2.extraVal + coreF.phaseVal.tertiaryVal();
        modeVal.limitVal = uuuUNnu2.limitVal + coreF.limitRef.tertiaryVal();
        modeVal.speedVal = uuuUNnu2.speedVal[0];
        modeVal.widthVal = uuuUNnu2.speedVal[1];
        modeVal.chunkVal = uuuUNnu2.speedVal[2];
        modeVal.blockRef = uuuUNnu2.widthVal[0];
        modeVal.holderVal = uuuUNnu2.widthVal[1];
        modeVal.timerVal = uuuUNnu2.widthVal[2];
        modeVal.anchorVal = uuuUNnu2.chunkVal[0];
        modeVal.weightRef = uuuUNnu2.chunkVal[1];
        modeVal.bufferVal = uuuUNnu2.chunkVal[2];
        modeVal.countVal = 0.0f;
        modeVal.depthVal = uuuUNnu2.holderVal;
        modeVal.descRef = uuuUNnu2.timerVal;
        modeVal.activeVal = coreF.descRef.tertiaryVal() ? Math.max(0.0f, uuuUNnu2.anchorVal + coreF.groupVal.tertiaryVal()) : 0.0f;
        modeVal.radiusVal = Math.max(0.0f, uuuUNnu2.weightRef + coreF.layerVal.tertiaryVal());
        modeVal.factorVal = true;
        try {
            VuVNuuUUv.primaryVal().primaryVal(n3, n, n2, modeVal);
        }
        catch (Throwable throwable) {
            System.err.println("[ColorPlus] apply failed: " + throwable.getMessage());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Inject(method={"render"}, at={@At(value="RETURN")})
    private void onRenderHud(class_332 class_3322, class_9779 class_97792, CallbackInfo callbackInfo) {
        if (!WildClient.groupVal()) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.field_1724 == null || class_3102.field_1687 == null || class_3102.method_22683() == null) {
            return;
        }
        int n = class_3102.method_22683().method_4489();
        int n2 = class_3102.method_22683().method_4506();
        if (n <= 0 || n2 <= 0) {
            WildClient.primaryVal(n, n2);
            return;
        }
        try {
            WildClient.speedVal();
        }
        catch (Throwable throwable) {
            return;
        }
        if (WildClient.primaryVal() == null) {
            return;
        }
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        int n3 = 0;
        try {
            int n4;
            Object object;
            Object object2;
            try {
                FontRegistry.secondaryVal();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
            class_276 class_2762 = class_3102.method_1522();
            if (class_2762 != null) {
                object2 = class_2762.method_30277();
                if (object2 instanceof class_10868) {
                    class_10868 class_108682 = (class_10868)object2;
                    n4 = class_108682.method_68427();
                    n3 = NnUuNVvUvvNn.primaryVal();
                    if (n3 == 0) {
                        GLStateSnapshot.primaryVal(36009, modeVal.primaryVal);
                        GLStateSnapshot.primaryVal(36008, modeVal.secondaryVal);
                    } else {
                        GL30.glBindFramebuffer((int)36160, (int)n3);
                        GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)n4, (int)0);
                        GL11.glDrawBuffer((int)36064);
                        if (GL30.glCheckFramebufferStatus((int)36160) != 36053) {
                            GL30.glDeleteFramebuffers((int)n3);
                            NnUuNVvUvvNn.primaryVal(n3);
                            n3 = 0;
                            GLStateSnapshot.primaryVal(36009, modeVal.primaryVal);
                            GLStateSnapshot.primaryVal(36008, modeVal.secondaryVal);
                        }
                    }
                } else {
                    GLStateSnapshot.primaryVal(36009, modeVal.primaryVal);
                    GLStateSnapshot.primaryVal(36008, modeVal.secondaryVal);
                }
            } else {
                GLStateSnapshot.primaryVal(36009, modeVal.primaryVal);
                GLStateSnapshot.primaryVal(36008, modeVal.secondaryVal);
            }
            GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
            GL11.glDisable((int)2929);
            GL11.glEnable((int)3042);
            object2 = WildClient.primaryVal();
            if (object2 == null) {
                return;
            }
            object = HudLayoutManager.primaryVal();
            ((HudLayoutManager)object).primaryVal(class_3102, (Renderer2D)object2, n, n2);
            ((HudLayoutManager)object).tertiaryVal();
            n4 = VvNUnuUUuN.weightVal() ? 1 : 0;
            AudioDeviceReset.primaryVal();
            boolean bl = false;
            try {
                ((Renderer2D)object2).primaryVal(n, n2);
                bl = true;
                if (n4 != 0) {
                    this.wild$drawCorruption((Renderer2D)object2, n, n2);
                } else {
                    wild$cachedEventScreen.primaryVal(class_3102, (Renderer2D)object2, FontRegistry.primaryVal, n, n2, class_3322);
                    EventManager.post(wild$cachedEventScreen);
                }
            }
            finally {
                if (bl) {
                    ((Renderer2D)object2).secondaryVal();
                    ((HudLayoutManager)object).marginVal();
                }
            }
        }
        finally {
            if (n3 != 0) {
                GL30.glBindFramebuffer((int)36160, (int)n3);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)0, (int)0);
            }
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }

    @Unique
    private void wild$drawCorruption(Renderer2D heightVal, int n, int n2) {
        if (n <= 0 || n2 <= 0) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.wild$lastCorruptionFrameMs > 28L || VvNUnuUUuN.primaryVal(9182, 120L, 0.36f, 42L)) {
            this.wild$lastCorruptionFrameMs = l;
            this.wild$heldTearY = InGameHudMixin.wild$norm(VvNUnuUUuN.secondaryVal(901)) * (float)n2;
            this.wild$heldTearH = 8.0f + Math.abs(VvNUnuUUuN.secondaryVal(902)) * (float)n2 * 0.22f;
            this.wild$heldTearShift = VvNUnuUUuN.secondaryVal(903) * (float)n * 0.42f;
        }
        int n3 = VvNUnuUUuN.blockRef();
        float f = VvNUnuUUuN.holderVal();
        float f2 = VvNUnuUUuN.primaryVal(1250000000L, 2250000000L);
        this.wild$panicWhite = VvNUnuUUuN.depthVal() ? Math.min(1.0f, this.wild$panicWhite + 0.68f + VvNUnuUUuN.trackVal() * 0.24f) : (this.wild$panicWhite *= 0.58f);
        this.wild$panicBlack = VvNUnuUUuN.bufferVal() ? Math.min(1.0f, this.wild$panicBlack + 0.38f + VvNUnuUUuN.widthRef() * 0.32f) : (this.wild$panicBlack *= 0.72f);
        this.wild$drawNoHudVoid(heightVal, n, n2, n3, f, f2);
        this.wild$drawBacklightPulse(heightVal, n, n2, n3, f);
        this.wild$drawScanMatrix(heightVal, n, n2, n3, f);
        this.wild$drawHeldTear(heightVal, n, n2, n3, f);
        this.wild$drawTconFailure(heightVal, n, n2, n3, f);
        this.wild$drawVramFailure(heightVal, n, n2, n3, f);
        this.wild$drawDeadPixels(heightVal, n, n2, n3, f);
        this.wild$drawEdgePressure(heightVal, n, n2, n3, f, f2);
        this.wild$drawBlackout(heightVal, n, n2, n3, f, f2);
    }

    @Unique
    private void wild$drawNoHudVoid(Renderer2D heightVal, int n, int n2, int n3, float f, float f2) {
        int n4;
        int n5 = InGameHudMixin.wild$alpha(42 + (int)(95.0f * VvNUnuUUuN.layerVal()));
        heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, InGameHudMixin.wild$rgba(n5, 0, 0, 0));
        if (n3 <= 2) {
            n4 = InGameHudMixin.wild$alpha(18 + (int)(36.0f * f));
            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, InGameHudMixin.wild$rgba(n4, 2, 7, 13));
        }
        if (n3 >= 3) {
            n4 = InGameHudMixin.wild$alpha((int)(72.0f * f));
            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, InGameHudMixin.wild$rgba(n4, 7, 0, 0));
        }
        if (f2 > 0.0f) {
            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha((int)(120.0f * f2)), 0, 0, 0));
        }
    }

    @Unique
    private void wild$drawBacklightPulse(Renderer2D heightVal, int n, int n2, int n3, float f) {
        int n4;
        if (this.wild$panicWhite > 0.01f) {
            n4 = InGameHudMixin.wild$alpha((int)(220.0f * this.wild$panicWhite));
            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, InGameHudMixin.wild$rgba(n4, 255, 255, 255));
        }
        if (n3 >= 2 && VvNUnuUUuN.primaryVal(12001, 260L, 0.38f + VvNUnuUUuN.trackVal() * 0.28f, 28L)) {
            n4 = InGameHudMixin.wild$alpha(60 + (int)(130.0f * f));
            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, InGameHudMixin.wild$rgba(n4, 230, 245, 255));
        }
        if (n3 >= 3 && VvNUnuUUuN.primaryVal(12002, 720L, 0.26f + VvNUnuUUuN.widthRef() * 0.34f, 95L)) {
            n4 = InGameHudMixin.wild$alpha(130 + (int)(90.0f * f));
            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, InGameHudMixin.wild$rgba(n4, 0, 0, 0));
        }
    }

    @Unique
    private void wild$drawScanMatrix(Renderer2D heightVal, int n, int n2, int n3, float f) {
        float f2;
        int n4;
        int n5 = n3 >= 3 ? 2 : 3;
        float f3 = System.nanoTime() / 1400000L % (long)n5;
        int n6 = InGameHudMixin.wild$alpha(20 + (int)(54.0f * f));
        for (float f4 = -f3; f4 < (float)n2; f4 += (float)n5) {
            heightVal.primaryVal(0.0f, f4, (float)n, 1.0f, InGameHudMixin.wild$rgba(n6, 0, 0, 0));
        }
        int n7 = n3 >= 3 ? 7 : 3;
        for (n4 = 0; n4 < n7; ++n4) {
            float f5 = InGameHudMixin.wild$norm(VvNUnuUUuN.primaryVal(13000 + n4, 85L)) * (float)n;
            f2 = 1.0f + Math.abs(VvNUnuUUuN.primaryVal(13020 + n4, 130L)) * 5.0f * f;
            int n8 = InGameHudMixin.wild$alpha(12 + (int)(56.0f * f));
            heightVal.primaryVal(f5, 0.0f, f2, (float)n2, InGameHudMixin.wild$rgba(n8, 255, 255, 255));
        }
        n4 = n3 >= 3 ? 18 : (n3 >= 2 ? 9 : 4);
        for (int i = 0; i < n4; ++i) {
            f2 = InGameHudMixin.wild$norm(VvNUnuUUuN.primaryVal(13100 + i, 18L + (long)i)) * (float)n2;
            float f6 = 1.0f + Math.abs(VvNUnuUUuN.primaryVal(13140 + i, 44L)) * (n3 >= 3 ? 6.0f : 2.0f);
            int n9 = InGameHudMixin.wild$alpha(28 + (int)(120.0f * f * Math.abs(VvNUnuUUuN.primaryVal(13180 + i, 31L))));
            heightVal.primaryVal(0.0f, f2, (float)n, f6, InGameHudMixin.wild$rgba(n9, 210, 228, 255));
        }
    }

    @Unique
    private void wild$drawHeldTear(Renderer2D heightVal, int n, int n2, int n3, float f) {
        if (n3 < 2) {
            return;
        }
        int n4 = InGameHudMixin.wild$alpha(36 + (int)(105.0f * f));
        float f2 = Math.max(0.0f, Math.min((float)n2, this.wild$heldTearY));
        float f3 = Math.max(1.0f, Math.min((float)n2 * 0.45f, this.wild$heldTearH));
        float f4 = this.wild$heldTearShift * f;
        heightVal.primaryVal(f4, f2, (float)n + Math.abs(f4) * 2.0f, f3, InGameHudMixin.wild$rgba(n4, 220, 220, 220));
        if (n3 >= 3) {
            heightVal.primaryVal(f4 - 12.0f * f, f2, (float)n + Math.abs(f4) * 2.0f, Math.max(1.0f, f3 * 0.16f), InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha(n4 + 28), 255, 25, 38));
            heightVal.primaryVal(f4 + 8.0f * f, f2 + f3 * 0.34f, (float)n + Math.abs(f4) * 2.0f, Math.max(1.0f, f3 * 0.12f), InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha(n4 + 18), 25, 255, 70));
            heightVal.primaryVal(f4 + 18.0f * f, f2 + f3 * 0.66f, (float)n + Math.abs(f4) * 2.0f, Math.max(1.0f, f3 * 0.1f), InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha(n4 + 18), 40, 80, 255));
        }
    }

    @Unique
    private void wild$drawTconFailure(Renderer2D heightVal, int n, int n2, int n3, float f) {
        int n4;
        float f2;
        float f3;
        float f4;
        int n5;
        int n6 = VvNUnuUUuN.limitRef() + (n3 >= 3 ? 16 : 4);
        long l = n3 >= 3 ? 14L : 30L;
        for (n5 = 0; n5 < n6; ++n5) {
            float f5 = InGameHudMixin.wild$norm(VvNUnuUUuN.primaryVal(14000 + n5 * 7, l + (long)n5)) * (float)n2;
            f4 = 1.0f + Math.abs(VvNUnuUUuN.primaryVal(14001 + n5 * 7, l + 11L)) * (n3 >= 3 ? 26.0f : 9.0f) * f;
            f3 = VvNUnuUUuN.primaryVal(14002 + n5 * 7, l) * (float)n * (n3 >= 3 ? 0.44f : 0.18f) * f;
            f2 = (float)n + Math.abs(f3) * 2.0f;
            n4 = InGameHudMixin.wild$alpha(22 + (int)(118.0f * f * Math.abs(VvNUnuUUuN.primaryVal(14003 + n5 * 7, l))));
            int n7 = n5 % 11;
            if (n7 == 0) {
                heightVal.primaryVal(f3, f5, f2, f4, InGameHudMixin.wild$rgba(n4, 255, 25, 35));
                continue;
            }
            if (n7 == 1) {
                heightVal.primaryVal(f3, f5, f2, f4, InGameHudMixin.wild$rgba(n4, 28, 255, 70));
                continue;
            }
            if (n7 == 2) {
                heightVal.primaryVal(f3, f5, f2, f4, InGameHudMixin.wild$rgba(n4, 42, 86, 255));
                continue;
            }
            if (n7 == 3) {
                heightVal.primaryVal(f3, f5, f2, f4, InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha(n4 + 30), 255, 255, 255));
                continue;
            }
            heightVal.primaryVal(f3, f5, f2, f4, InGameHudMixin.wild$rgba(n4, 210, 210, 210));
        }
        if (n3 >= 3) {
            n5 = 3 + (int)(8.0f * VvNUnuUUuN.themeVal());
            for (int i = 0; i < n5; ++i) {
                f4 = InGameHudMixin.wild$norm(VvNUnuUUuN.primaryVal(14200 + i, 44L)) * (float)n2;
                f3 = 12.0f + Math.abs(VvNUnuUUuN.primaryVal(14250 + i, 58L)) * (float)n2 * 0.18f * f;
                f2 = VvNUnuUUuN.primaryVal(14300 + i, 32L) * (float)n * 0.58f * f;
                n4 = InGameHudMixin.wild$alpha(28 + (int)(112.0f * f));
                heightVal.primaryVal(f2, f4, (float)n + Math.abs(f2) * 2.0f, f3, InGameHudMixin.wild$rgba(n4, 230, 230, 230));
            }
        }
    }

    @Unique
    private void wild$drawVramFailure(Renderer2D heightVal, int n, int n2, int n3, float f) {
        if (n3 < 2) {
            return;
        }
        int n4 = VvNUnuUUuN.paramRef() + (n3 >= 3 ? 22 : 4);
        long l = n3 >= 3 ? 32L : 76L;
        for (int i = 0; i < n4; ++i) {
            float f2 = InGameHudMixin.wild$norm(VvNUnuUUuN.primaryVal(15000 + i * 6, l)) * (float)n;
            float f3 = InGameHudMixin.wild$norm(VvNUnuUUuN.primaryVal(15001 + i * 6, l + 7L)) * (float)n2;
            float f4 = 3.0f + Math.abs(VvNUnuUUuN.primaryVal(15002 + i * 6, l + 13L)) * (n3 >= 3 ? 210.0f : 76.0f) * f;
            float f5 = 2.0f + Math.abs(VvNUnuUUuN.primaryVal(15003 + i * 6, l + 19L)) * (n3 >= 3 ? 116.0f : 38.0f) * f;
            int n5 = InGameHudMixin.wild$alpha(26 + (int)(130.0f * f));
            int n6 = i % 17;
            int n7 = InGameHudMixin.wild$byte(VvNUnuUUuN.primaryVal(15004 + i * 6, l + 23L));
            if (n6 == 0) {
                heightVal.primaryVal(f2, f3, f4, f5, InGameHudMixin.wild$rgba(n5, 255, 0, 0));
                continue;
            }
            if (n6 == 1) {
                heightVal.primaryVal(f2, f3, f4, f5, InGameHudMixin.wild$rgba(n5, 0, 255, 70));
                continue;
            }
            if (n6 == 2) {
                heightVal.primaryVal(f2, f3, f4, f5, InGameHudMixin.wild$rgba(n5, 40, 80, 255));
                continue;
            }
            if (n6 == 3) {
                heightVal.primaryVal(f2, f3, f4, f5, InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha(n5 + 30), 255, 255, 255));
                continue;
            }
            if (n6 == 4 && n3 >= 3) {
                heightVal.primaryVal(f2, f3, f4, f5, InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha(n5 + 20), 0, 0, 0));
                continue;
            }
            heightVal.primaryVal(f2, f3, f4, f5, InGameHudMixin.wild$rgba(n5, n7, n7, n7));
        }
    }

    @Unique
    private void wild$drawDeadPixels(Renderer2D heightVal, int n, int n2, int n3, float f) {
        int n4 = VvNUnuUUuN.groupVal() + (n3 >= 3 ? 120 : 24);
        for (int i = 0; i < n4; ++i) {
            float f2 = InGameHudMixin.wild$norm(VvNUnuUUuN.tertiaryVal(16000 + i * 3)) * (float)n;
            float f3 = InGameHudMixin.wild$norm(VvNUnuUUuN.tertiaryVal(16001 + i * 3)) * (float)n2;
            if (n3 < 3 && VvNUnuUUuN.primaryVal(16002 + i * 3, 230L) < -0.42f) continue;
            float f4 = n3 >= 3 && i % 9 == 0 ? 2.0f : 1.0f;
            int n5 = InGameHudMixin.wild$alpha(36 + (int)(205.0f * f * Math.abs(VvNUnuUUuN.primaryVal(16100 + i, 110L))));
            int n6 = i % 19;
            if (n6 == 0) {
                heightVal.primaryVal(f2, f3, f4, f4, InGameHudMixin.wild$rgba(n5, 255, 0, 0));
                continue;
            }
            if (n6 == 1) {
                heightVal.primaryVal(f2, f3, f4, f4, InGameHudMixin.wild$rgba(n5, 0, 255, 50));
                continue;
            }
            if (n6 == 2) {
                heightVal.primaryVal(f2, f3, f4, f4, InGameHudMixin.wild$rgba(n5, 40, 90, 255));
                continue;
            }
            if (n6 == 3) {
                heightVal.primaryVal(f2, f3, f4, f4, InGameHudMixin.wild$rgba(n5, 0, 0, 0));
                continue;
            }
            heightVal.primaryVal(f2, f3, f4, f4, InGameHudMixin.wild$rgba(n5, 235, 235, 235));
        }
    }

    @Unique
    private void wild$drawEdgePressure(Renderer2D heightVal, int n, int n2, int n3, float f, float f2) {
        float f3 = (float)n2 * (0.04f + Math.abs(VvNUnuUUuN.primaryVal(17000, 70L)) * 0.12f * f);
        float f4 = (float)n2 * (0.04f + Math.abs(VvNUnuUUuN.primaryVal(17001, 80L)) * 0.14f * f);
        float f5 = (float)n * (0.012f + Math.abs(VvNUnuUUuN.primaryVal(17002, 95L)) * 0.055f * f);
        float f6 = (float)n * (0.012f + Math.abs(VvNUnuUUuN.primaryVal(17003, 105L)) * 0.055f * f);
        heightVal.primaryVal(0.0f, 0.0f, (float)n, f3, InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha(55 + (int)(145.0f * f)), 0, 0, 0));
        heightVal.primaryVal(0.0f, (float)n2 - f4, (float)n, f4, InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha(55 + (int)(155.0f * f)), 0, 0, 0));
        if (n3 >= 3) {
            heightVal.primaryVal(0.0f, 0.0f, f5, (float)n2, InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha(45 + (int)(130.0f * f)), 0, 0, 0));
            heightVal.primaryVal((float)n - f6, 0.0f, f6, (float)n2, InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha(45 + (int)(130.0f * f)), 0, 0, 0));
        }
        if (f2 > 0.0f) {
            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha((int)(150.0f * f2)), 0, 0, 0));
        }
    }

    @Unique
    private void wild$drawBlackout(Renderer2D heightVal, int n, int n2, int n3, float f, float f2) {
        if (this.wild$panicBlack > 0.01f) {
            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha((int)(235.0f * this.wild$panicBlack)), 0, 0, 0));
        }
        if (VvNUnuUUuN.countVal()) {
            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha(190 + (int)(62.0f * f)), 0, 0, 0));
        }
        if (n3 >= 4) {
            float f3 = System.nanoTime() / 2300000L % (long)Math.max(1, n2);
            heightVal.primaryVal(0.0f, f3, (float)n, 2.0f, InGameHudMixin.wild$rgba(235, 255, 255, 255));
            heightVal.primaryVal(0.0f, f3 + 3.0f, (float)n, 1.0f, InGameHudMixin.wild$rgba(130, 255, 30, 60));
            heightVal.primaryVal(0.0f, f3 + 5.0f, (float)n, 1.0f, InGameHudMixin.wild$rgba(130, 40, 90, 255));
            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, InGameHudMixin.wild$rgba(InGameHudMixin.wild$alpha((int)(120.0f + 125.0f * f2)), 0, 0, 0));
        }
        if (n3 >= 5) {
            heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, -16777216);
        }
    }

    @Unique
    private static float wild$norm(float f) {
        return (f + 1.0f) * 0.5f;
    }

    @Unique
    private static int wild$byte(float f) {
        int n = (int)(InGameHudMixin.wild$norm(f) * 255.0f);
        if (n < 0) {
            return 0;
        }
        if (n > 255) {
            return 255;
        }
        return n;
    }

    @Unique
    private static int wild$alpha(int n) {
        if (n < 0) {
            return 0;
        }
        if (n > 255) {
            return 255;
        }
        return n;
    }

    @Unique
    private static int wild$rgba(int n, int n2, int n3, int n4) {
        return (n & 0xFF) << 24 | (n2 & 0xFF) << 16 | (n3 & 0xFF) << 8 | n4 & 0xFF;
    }

    @Inject(method={"renderChat"}, at={@At(value="HEAD")}, cancellable=true, require=0)
    private void wild$cancelChatDuringCorruption(class_332 class_3322, class_9779 class_97792, CallbackInfo callbackInfo) {
        if (VvNUnuUUuN.weightVal()) {
            callbackInfo.cancel();
        }
    }

    @Unique
    private static boolean wild$customHotbarActive() {
        if (!WildClient.limitVal()) {
            return false;
        }
        if (!HudModule.activeVal.secondaryVal("HotBar") || !WildClient.groupVal() || WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return false;
        }
        HudModule vaseC = WildClient.primaryVal.secondaryVal.primaryVal(HudModule.class);
        return vaseC != null && vaseC.enabled;
    }

    @Unique
    private static boolean wild$noRenderPotions() {
        return RemovalsModule.primaryVal("Effect Icons");
    }
}

