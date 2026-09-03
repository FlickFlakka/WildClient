/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.GpuBufferSlice
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_5636
 *  net.minecraft.class_638
 *  net.minecraft.class_757
 *  net.minecraft.class_761
 *  net.minecraft.class_9779
 *  net.minecraft.class_9909
 *  net.minecraft.class_9916
 *  net.minecraft.class_9922
 *  net.minecraft.class_9960
 *  org.jetbrains.annotations.Nullable
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Vector4f
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import com.mojang.blaze3d.buffers.GpuBufferSlice;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_5636;
import net.minecraft.class_638;
import net.minecraft.class_757;
import net.minecraft.class_761;
import net.minecraft.class_9779;
import net.minecraft.class_9909;
import net.minecraft.class_9916;
import net.minecraft.class_9922;
import net.minecraft.class_9960;
import org.jetbrains.annotations.Nullable;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.BlockEspRenderer;
import ru.metaculture.protection.StardustModule;
import ru.metaculture.protection.WorldRenderContext;
import ru.metaculture.protection.GLStateSnapshot;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.VertexBufferPool;
import ru.metaculture.protection.EntityFramebufferCapture;
import ru.metaculture.protection.RenderWorldLastEvent;
import ru.metaculture.protection.RemovalsModule;
import ru.metaculture.protection.WorldTweaksModule;
import ru.metaculture.protection.ChinaHatModule;
import ru.metaculture.protection.StardustSkyRenderer;

@Mixin(value={class_761.class})
public class WorldRendererMixin extends class_761 {
    @Shadow
    @Final
    private class_9960 field_53081;
    @Shadow
    @Nullable
    private class_638 field_4085;

    protected WorldRendererMixin(class_310 var1, net.minecraft.class_898 var2, net.minecraft.class_824 var3, net.minecraft.class_4599 var4) {
        super(var1, var2, var3, var4);
    }

    @Inject(method={"renderSky"}, at={@At(value="HEAD")}, cancellable=true)
    private void renderStardustSky(class_9909 class_99092, class_4184 class_41842, float f, GpuBufferSlice gpuBufferSlice, CallbackInfo callbackInfo) {
        if (!StardustModule.blockRef()) {
            return;
        }
        callbackInfo.cancel();
        if (this.field_4085 == null || class_41842 == null) {
            return;
        }
        class_5636 class_56362 = class_41842.method_19334();
        if (class_56362 == class_5636.field_27887 || class_56362 == class_5636.field_27885 || this.wild$hasBlindnessOrDarkness(class_41842)) {
            return;
        }
        class_9916 class_99162 = class_99092.method_61911("wild_stardust_sky");
        this.field_53081.field_53091 = class_99162.method_61933(this.field_53081.field_53091);
        class_99162.method_61929(() -> {
            RenderSystem.setShaderFog((GpuBufferSlice)gpuBufferSlice);
            StardustSkyRenderer.primaryVal(class_41842, f, StardustModule.timerVal());
        });
    }

    @Unique
    private boolean wild$hasBlindnessOrDarkness(class_4184 class_41842) {
        class_1297 class_12972 = class_41842.method_19331();
        if (!(class_12972 instanceof class_1309)) {
            return false;
        }
        class_1309 class_13092 = (class_1309)class_12972;
        return class_13092.method_6059(class_1294.field_5919) || class_13092.method_6059(class_1294.field_38092);
    }

    @Inject(method={"renderWeather"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$suppressWeather(class_9909 class_99092, class_243 class_2432, float f, GpuBufferSlice gpuBufferSlice, CallbackInfo callbackInfo) {
        if (WorldTweaksModule.blockRef() || RemovalsModule.secondaryVal("Weather (Rain/Snow)")) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"addWeatherParticlesAndSound"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$suppressWeatherFx(class_4184 class_41842, CallbackInfo callbackInfo) {
        if (RemovalsModule.secondaryVal("Weather (Rain/Snow)")) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void beginEntityCapture(class_9922 class_99222, class_9779 class_97792, boolean bl, class_4184 class_41842, Matrix4f matrix4f, Matrix4f matrix4f2, GpuBufferSlice gpuBufferSlice, Vector4f vector4f, boolean bl2, CallbackInfo callbackInfo) {
        ChinaHatModule.blockRef();
        BlockEspRenderer.primaryVal(matrix4f2);
        StardustSkyRenderer.primaryVal(matrix4f, matrix4f2);
        EntityFramebufferCapture.primaryVal().primaryVal((class_761)this, class_97792, class_41842);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Inject(method={"render"}, at={@At(value="RETURN")})
    private void publishWorldRenderEvent(class_9922 class_99222, class_9779 class_97792, boolean bl, class_4184 class_41842, Matrix4f matrix4f, Matrix4f matrix4f2, GpuBufferSlice gpuBufferSlice, Vector4f vector4f, boolean bl2, CallbackInfo callbackInfo) {
        class_310 class_3102 = class_310.method_1551();
        if (!VertexBufferPool.primaryVal(class_3102)) {
            EntityFramebufferCapture.primaryVal().chunkVal();
            return;
        }
        class_4587 class_45872 = new class_4587();
        class_45872.method_34425((Matrix4fc)new Matrix4f((Matrix4fc)matrix4f));
        EventManager.post(new RenderWorldEvent(class_45872, class_97792.method_60637(true)));
        EntityFramebufferCapture.primaryVal().chunkVal();
        class_757 class_7572 = class_3102.field_1773;
        if (class_7572 == null || class_41842 == null) {
            return;
        }
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        WorldRenderContext vUVnuvunnvuV = null;
        try {
            vUVnuvunnvuV = WorldRenderContext.primaryVal(class_3102, class_97792, class_41842, matrix4f, matrix4f2);
            float f = vUVnuvunnvuV.paramVal();
            try {
                EventManager.post(new RenderWorldLastEvent(class_3102, class_7572, vUVnuvunnvuV, f));
            }
            finally {
                if (vUVnuvunnvuV != null) {
                    try {
                        vUVnuvunnvuV.limitVal();
                    }
                    finally {
                        vUVnuvunnvuV.close();
                    }
                }
            }
        }
        finally {
            GLStateSnapshot.tertiaryVal(modeVal);
            if (ChinaHatModule.holderVal()) {
                GLStateSnapshot.marginVal(modeVal);
            }
        }
    }
}

