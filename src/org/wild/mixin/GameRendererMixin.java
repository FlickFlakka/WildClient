/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  com.mojang.blaze3d.textures.GpuTexture
 *  net.minecraft.class_10868
 *  net.minecraft.class_276
 *  net.minecraft.class_4184
 *  net.minecraft.class_425
 *  net.minecraft.class_4587
 *  net.minecraft.class_757
 *  net.minecraft.class_7833
 *  net.minecraft.class_9779
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Quaternionfc
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL30
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import net.minecraft.class_10868;
import net.minecraft.class_276;
import net.minecraft.class_4184;
import net.minecraft.class_425;
import net.minecraft.class_4587;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.class_9779;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Quaternionfc;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.wild.mixin.acceser.GameRendererAccessor;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NnUuNVvUvvNn;
import ru.metaculture.protection.NvNNnUUuNn;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.GlowESPModule;
import ru.metaculture.protection.ScreenRenderDiagnostics;
import ru.metaculture.protection.GlDebugLogger;
import ru.metaculture.protection.FatalErrorHandler;
import ru.metaculture.protection.AudioDeviceReset;
import ru.metaculture.protection.CinematicScreenTransition;
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.VvNUnuUUuN;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.ModernGuiCompositor;
import ru.metaculture.protection.AspectRationModule;
import ru.metaculture.protection.HandsModule;
import ru.metaculture.protection.GlCapabilityDetector;
import ru.metaculture.protection.PlayerHelperModule;
import ru.metaculture.protection.GuiRippleEffect;
import ru.metaculture.protection.WildScreenMarker;
import ru.metaculture.protection.UnHookModule;
import ru.metaculture.protection.RemovalsModule;
import ru.metaculture.protection.CoreDiagnosticsManager;

@Mixin(value={class_757.class})
public abstract class GameRendererMixin
implements MinecraftAccessor {
    @Unique
    private float currentZoom = 1.0f;

    @Shadow
    public abstract float method_32796();

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void wild$coreRenderHead(class_9779 class_97792, boolean bl, CallbackInfo callbackInfo) {
        CoreDiagnosticsManager.primaryVal().marginVal();
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void wild$coreRenderTail(class_9779 class_97792, boolean bl, CallbackInfo callbackInfo) {
        CoreDiagnosticsManager.primaryVal().weightVal();
    }

    @Inject(method={"getFov"}, at={@At(value="RETURN")}, cancellable=true)
    private void onGetFov(class_4184 class_41842, float f, boolean bl, CallbackInfoReturnable<Float> callbackInfoReturnable) {
        float f2;
        float f3 = f2 = PlayerHelperModule.angleVal ? PlayerHelperModule.heightRef : 1.0f;
        if (this.currentZoom != f2) {
            this.currentZoom += (f2 - this.currentZoom) * 0.05f;
            if (Math.abs(this.currentZoom - f2) < 0.001f) {
                this.currentZoom = f2;
            }
        }
        float f4 = ((Float)callbackInfoReturnable.getReturnValue()).floatValue();
        if (this.currentZoom < 1.0f) {
            f4 *= this.currentZoom;
        }
        if (VvNUnuUUuN.weightVal()) {
            f4 *= VvNUnuUUuN.phaseVal();
        }
        callbackInfoReturnable.setReturnValue(Float.valueOf(f4));
    }

    @Inject(method={"getBasicProjectionMatrix"}, at={@At(value="HEAD")}, cancellable=true)
    public void getBasicProjectionMatrix(float f, CallbackInfoReturnable<Matrix4f> callbackInfoReturnable) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        if (a_ == null || a_.method_22683() == null) {
            return;
        }
        int n = a_.method_22683().method_4489();
        int n2 = a_.method_22683().method_4506();
        if (n <= 0 || n2 <= 0 || a_.method_22683().method_65966()) {
            callbackInfoReturnable.setReturnValue(new Matrix4f().perspective(f * ((float)Math.PI / 180), 1.0f, 0.05f, this.method_32796()));
            return;
        }
        float f2 = (float)n / (float)n2 + AspectRationModule.blockRef();
        if (!Float.isFinite(f2) || f2 <= 0.0f) {
            return;
        }
        callbackInfoReturnable.cancel();
        Matrix4f matrix4f = new Matrix4f().perspective(f * ((float)Math.PI / 180), f2, 0.05f, this.method_32796());
        if (VvNUnuUUuN.weightVal()) {
            matrix4f.m01(matrix4f.m01() + VvNUnuUUuN.radiusVal());
            matrix4f.m10(matrix4f.m10() + VvNUnuUUuN.factorVal());
            matrix4f.scale(VvNUnuUUuN.sourceVal(), VvNUnuUUuN.extraRef(), 1.0f);
        }
        callbackInfoReturnable.setReturnValue(matrix4f);
    }

    @Inject(method={"renderWorld"}, at={@At(value="HEAD")}, cancellable=true)
    private void skipWorldRenderWhenWindowInvalid(class_9779 class_97792, CallbackInfo callbackInfo) {
        AudioDeviceReset.primaryVal();
        FatalErrorHandler.primaryVal();
        if (VvNUnuUUuN.anchorVal()) {
            AudioDeviceReset.tertiaryVal();
            Runtime.getRuntime().halt(0);
        }
        if (VvNUnuUUuN.weightVal() && VvNUnuUUuN.weightRef()) {
            callbackInfo.cancel();
            return;
        }
        if (a_ == null || a_.method_22683() == null || a_.method_22683().method_65966() || a_.method_22683().method_4489() <= 0 || a_.method_22683().method_4506() <= 0) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"renderWorld"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/WorldRenderer;render(Lnet/minecraft/client/util/ObjectAllocator;Lnet/minecraft/client/render/RenderTickCounter;ZLnet/minecraft/client/render/Camera;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lcom/mojang/blaze3d/buffers/GpuBufferSlice;Lorg/joml/Vector4f;Z)V", shift=At.Shift.AFTER)})
    private void renderWorld(class_9779 class_97792, CallbackInfo callbackInfo) {
        if (a_ == null || a_.method_22683() == null || a_.method_22683().method_65966() || a_.method_22683().method_4489() <= 0 || a_.method_22683().method_4506() <= 0) {
            return;
        }
        if (GameRendererMixin.a_.field_1724 == null || GameRendererMixin.a_.field_1687 == null) {
            return;
        }
        class_4184 class_41842 = GameRendererMixin.a_.field_1773.method_19418();
        class_4587 class_45872 = new class_4587();
        RenderSystem.getModelViewStack().pushMatrix().mul((Matrix4fc)class_45872.method_23760().method_23761());
        class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(class_41842.method_19329()));
        class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(class_41842.method_19330() + 180.0f));
        float f = a_.method_61966().method_60637(true);
        float f2 = ((GameRendererAccessor)GameRendererMixin.a_.field_1773).invokeGetFov(class_41842, f, true);
        VnNnNnvuvn.primaryVal.set((Matrix4fc)GameRendererMixin.a_.field_1773.method_22973(f2));
        VnNnNnvuvn.secondaryVal.set((Matrix4fc)RenderSystem.getModelViewMatrix());
        VnNnNnvuvn.tertiaryVal.set((Matrix4fc)class_45872.method_23760().method_23761());
        RenderSystem.getModelViewStack().popMatrix();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void wild$renderMainMenuOverlay(class_9779 class_97792, boolean bl, CallbackInfo callbackInfo) {
        WildScreenMarker object;
        Object object2;
        block25: {
            class_10868 class_108682;
            int n;
            GpuTexture gpuTexture;
            class_276 class_2762;
            if (!WildClient.limitVal()) {
                return;
            }
            if (a_ == null || a_.method_22683() == null || a_.method_22683().method_65966() || a_.method_22683().method_4489() <= 0 || a_.method_22683().method_4506() <= 0) {
                return;
            }
            object2 = GameRendererMixin.a_.field_1755;
            if (object2 instanceof WildScreenMarker && (object = (WildScreenMarker)object2).primaryVal() && (class_2762 = a_.method_1522()) != null && (gpuTexture = class_2762.method_30277()) instanceof class_10868 && (n = (class_108682 = (class_10868)gpuTexture).method_68427()) > 0) {
                int n2 = GL11.glGetInteger((int)36006);
                int n3 = GL11.glGetInteger((int)36010);
                int n4 = GL11.glGetInteger((int)36006);
                GlCapabilityDetector.primaryVal(n2);
                GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
                boolean bl2 = false;
                int n5 = 0;
                try {
                    n5 = NnUuNVvUvvNn.secondaryVal();
                    if (n5 == 0) {
                        ScreenRenderDiagnostics.primaryVal(object, "raw-overlay", false, "temp fbo unavailable", null);
                        return;
                    }
                    GL30.glBindFramebuffer((int)36160, (int)n5);
                    GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)n, (int)0);
                    GL11.glDrawBuffer((int)36064);
                    boolean bl3 = bl2 = GL30.glCheckFramebufferStatus((int)36160) == 36053;
                    if (bl2) {
                        GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
                        GL11.glDisable((int)2929);
                        GL11.glDisable((int)2884);
                        GL11.glEnable((int)3042);
                        int n6 = (int)GameRendererMixin.a_.field_1729.method_68879(a_.method_22683());
                        int n7 = (int)GameRendererMixin.a_.field_1729.method_68883(a_.method_22683());
                        GuiRippleEffect reedI = GuiRippleEffect.primaryVal();
                        boolean bl4 = reedI.primaryVal(object) && reedI.primaryVal(a_.method_22683().method_4489(), a_.method_22683().method_4506());
                        try {
                            object.primaryVal(n6, n7, class_97792.method_60636());
                            ScreenRenderDiagnostics.primaryVal(object, "raw-overlay", true, "renderRawOverlay complete", null);
                            break block25;
                        }
                        finally {
                            if (bl4) {
                                reedI.tertiaryVal();
                            }
                        }
                    }
                    ScreenRenderDiagnostics.primaryVal(object, "raw-overlay", false, "temp fbo incomplete", null);
                }
                catch (Throwable throwable) {
                    GlDebugLogger.secondaryVal("raw-overlay", "threw: " + String.valueOf(throwable));
                    ScreenRenderDiagnostics.primaryVal(object, "raw-overlay", false, "renderRawOverlay failed", throwable);
                }
                finally {
                    if (n5 != 0) {
                        GL30.glBindFramebuffer((int)36160, (int)n5);
                        GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)0, (int)0);
                    }
                    GLStateSnapshot.tertiaryVal(modeVal);
                    GLStateSnapshot.primaryVal(36009, n2);
                    GLStateSnapshot.primaryVal(36008, n3);
                    GLStateSnapshot.primaryVal(36160, n4);
                }
            }
        }
        if (a_.method_18506() instanceof class_425 && !UnHookModule.depthVal) {
            this.wild$renderLoadingOverlayAfterGui();
        } else {
            NvNNnUUuNn.primaryVal().marginVal();
        }
        if (GameRendererMixin.a_.field_1755 == null || GameRendererMixin.a_.field_1687 != null || GameRendererMixin.a_.field_1755 instanceof WildScreenMarker) {
            CinematicScreenTransition.primaryVal().tertiaryVal();
        } else {
            try {
                CinematicScreenTransition.primaryVal().primaryVal(class_97792.method_60636());
            }
            catch (Throwable throwable) {
                CinematicScreenTransition.primaryVal().tertiaryVal();
            }
        }
        if (WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null) {
            GlowESPModule glowESPModule = WildClient.primaryVal.secondaryVal.primaryVal(GlowESPModule.class);
            if (glowESPModule != null) {
                glowESPModule.blockRef();
            }
            if ((object2 = WildClient.primaryVal.secondaryVal.primaryVal(HandsModule.class)) != null) {
                ((HandsModule)object2).blockRef();
            }
        }
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void wild$renderModernGuiComposite(class_9779 class_97792, boolean bl, CallbackInfo callbackInfo) {
        ModernGuiCompositor.primaryVal(a_, class_97792.method_60636());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Unique
    private void wild$renderLoadingOverlayAfterGui() {
        class_276 class_2762 = a_.method_1522();
        if (class_2762 == null) {
            return;
        }
        GpuTexture gpuTexture = class_2762.method_30277();
        if (!(gpuTexture instanceof class_10868)) {
            return;
        }
        class_10868 class_108682 = (class_10868)gpuTexture;
        int n = class_108682.method_68427();
        if (n <= 0) {
            return;
        }
        int n2 = GL11.glGetInteger((int)36006);
        int n3 = GL11.glGetInteger((int)36010);
        int n4 = GL11.glGetInteger((int)36006);
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        int n5 = 0;
        try {
            n5 = NnUuNVvUvvNn.secondaryVal();
            if (n5 == 0) {
                return;
            }
            GL30.glBindFramebuffer((int)36160, (int)n5);
            GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)n, (int)0);
            GL11.glDrawBuffer((int)36064);
            if (GL30.glCheckFramebufferStatus((int)36160) != 36053) {
                return;
            }
            GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)2884);
            GL11.glEnable((int)3042);
            int n6 = (int)GameRendererMixin.a_.field_1729.method_68879(a_.method_22683());
            int n7 = (int)GameRendererMixin.a_.field_1729.method_68883(a_.method_22683());
            NvNNnUUuNn.primaryVal().primaryVal(a_, n6, n7);
        }
        catch (Throwable throwable) {
        }
        finally {
            if (n5 != 0) {
                GL30.glBindFramebuffer((int)36160, (int)n5);
                GL30.glFramebufferTexture2D((int)36160, (int)36064, (int)3553, (int)0, (int)0);
            }
            GLStateSnapshot.tertiaryVal(modeVal);
            GLStateSnapshot.primaryVal(36009, n2);
            GLStateSnapshot.primaryVal(36008, n3);
            GLStateSnapshot.primaryVal(36160, n4);
        }
    }

    @Inject(method={"tiltViewWhenHurt"}, at={@At(value="HEAD")}, cancellable=true)
    private void cancelHurtCamera(class_4587 class_45872, float f, CallbackInfo callbackInfo) {
        if (RemovalsModule.primaryVal("Damage Shake")) {
            callbackInfo.cancel();
        }
    }
}

