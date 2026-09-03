/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.buffers.Std140SizeCalculator
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Builder
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.platform.DestFactor
 *  com.mojang.blaze3d.platform.SourceFactor
 *  com.mojang.blaze3d.vertex.VertexFormat
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  com.mojang.blaze3d.vertex.VertexFormatElement
 *  net.minecraft.class_10789
 *  net.minecraft.class_10799
 *  net.minecraft.class_2960
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.buffers.Std140SizeCalculator;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexFormatElement;
import net.minecraft.class_10789;
import net.minecraft.class_10799;
import net.minecraft.class_2960;

public final class UvNVnUVVnNN {
    public static final String primaryVal = "BlockEsp";
    public static final int secondaryVal = new Std140SizeCalculator().putMat4f().putVec4().putVec4().putVec4().putVec4().putVec4().putVec4().putVec4().get();
    public static final VertexFormat tertiaryVal = VertexFormat.builder().add("Position", VertexFormatElement.POSITION).add("UV0", VertexFormatElement.UV0).add("Color", VertexFormatElement.COLOR).add("UV2", VertexFormatElement.UV2).add("Normal", VertexFormatElement.NORMAL).padding(1).build();
    private static final BlendFunction marginVal = new BlendFunction(SourceFactor.ONE, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ONE_MINUS_SRC_ALPHA);
    private static final class_2960 weightVal = class_2960.method_60655((String)"wild", (String)"core/block_esp");
    private static final RenderPipeline paramVal = class_10799.method_67887((RenderPipeline)UvNVnUVVnNN.primaryVal("pipeline/block_esp_visible").withDepthTestFunction(DepthTestFunction.LESS_DEPTH_TEST).build());
    private static final RenderPipeline extraVal = class_10799.method_67887((RenderPipeline)UvNVnUVVnNN.primaryVal("pipeline/block_esp_occluded").withDepthTestFunction(DepthTestFunction.GREATER_DEPTH_TEST).build());

    private static RenderPipeline.Builder primaryVal(String string) {
        return RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[0]).withLocation(class_2960.method_60655((String)"wild", (String)string)).withVertexShader(weightVal).withFragmentShader(weightVal).withUniform("Projection", class_10789.field_60031).withUniform(primaryVal, class_10789.field_60031).withVertexFormat(tertiaryVal, VertexFormat.class_5596.field_27382).withCull(true).withDepthWrite(false).withDepthBias(-1.0f, -10.0f).withBlend(marginVal);
    }

    private UvNVnUVVnNN() {
    }

    public static void primaryVal() {
        block3: {
            block2: {
                if (paramVal == null) break block2;
                if (extraVal != null) break block3;
            }
            throw new IllegalStateException("BlockESP shader registry failed");
        }
    }

    public static RenderPipeline secondaryVal() {
        return paramVal;
    }

    public static RenderPipeline tertiaryVal() {
        return extraVal;
    }
}

