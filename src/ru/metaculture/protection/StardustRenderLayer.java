/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.platform.DestFactor
 *  com.mojang.blaze3d.platform.SourceFactor
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_10799
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.class_10799;
import net.minecraft.class_1921;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import ru.metaculture.protection.CoreDiagnosticsManager;

public final class StardustRenderLayer {
    private static final int primaryVal = 0x100000;
    private static final class_2960 secondaryVal = class_2960.method_60655((String)"minecraft", (String)"core/stardust");
    private static final BlendFunction tertiaryVal = new BlendFunction(SourceFactor.SRC_ALPHA, DestFactor.ONE);
    private static final RenderPipeline marginVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_60125, class_10799.field_60126}).withLocation(class_2960.method_60655((String)"wild", (String)"pipeline/stardust")).withVertexShader(secondaryVal).withFragmentShader(secondaryVal).withVertexFormat(class_290.field_1577, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(tertiaryVal).build());
    private static final class_1921 weightVal = class_1921.method_24049((String)"wild/stardust", (int)0x100000, (boolean)false, (boolean)true, (RenderPipeline)marginVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));

    private StardustRenderLayer() {
    }

    public static void primaryVal() {
        if (marginVal == null || weightVal == null) {
            CoreDiagnosticsManager.primaryVal().secondaryVal("StardustShaderRegistry.init", new IllegalStateException("Stardust shader registry failed"));
        }
    }

    public static class_1921 secondaryVal() {
        return weightVal;
    }
}

