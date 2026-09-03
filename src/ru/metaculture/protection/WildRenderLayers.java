/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.systems.RenderPass
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_10799
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4687
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_4668$class_4677
 *  net.minecraft.class_4668$class_4683
 *  net.minecraft.class_4668$class_5939
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import net.minecraft.class_10799;
import net.minecraft.class_1921;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_4668;
import ru.metaculture.protection.RenderPhaseAccessor;

public final class WildRenderLayers {
    private static final int primaryVal = 1024;
    private static final int secondaryVal = 256;
    private static final String tertiaryVal = "wild";
    private static final double marginVal = 0.0625;
    private static final double weightVal = 64.0;
    private static final int paramVal = 128;
    private static final RenderPipeline extraVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)"wild", (String)"pipeline/world/position_color_quads")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(true).build());
    private static final RenderPipeline limitVal;
    private static final RenderPipeline speedVal;
    private static final RenderPipeline widthVal;
    private static final RenderPipeline chunkVal;
    private static final RenderPipeline blockRef;
    private static final RenderPipeline holderVal;
    private static final RenderPipeline timerVal;
    private static final RenderPipeline anchorVal;
    private static final RenderPipeline weightRef;
    private static final RenderPipeline bufferVal;
    private static final class_1921 countVal;
    private static final class_1921 depthVal;
    private static final class_1921 descRef;
    private static final class_1921 activeVal;
    private static final class_1921 radiusVal;
    private static final class_1921 factorVal;
    private static final class_1921 sourceVal;
    private static final class_1921 extraRef;
    private static final class_1921 phaseVal;
    private static final Map<Double, class_1921> limitRef;
    private static final Map<Double, class_1921> paramRef;

    private WildRenderLayers() {
    }

    public static class_1921 primaryVal() {
        return countVal;
    }

    public static class_1921 secondaryVal() {
        return depthVal;
    }

    public static class_1921 tertiaryVal() {
        return descRef;
    }

    public static class_1921 marginVal() {
        return activeVal;
    }

    public static class_1921 weightVal() {
        return radiusVal;
    }

    public static class_1921 paramVal() {
        return factorVal;
    }

    public static class_1921 primaryVal(class_2960 class_29602) {
        return class_1921.method_24049((String)class_29602.toString(), (int)1024, (boolean)false, (boolean)true, (RenderPipeline)bufferVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_34577((class_4668.class_5939)new class_4668.class_4683(class_29602, false)).method_23617(false));
    }

    public static class_1921 secondaryVal(class_2960 class_29602) {
        return class_1921.method_24049((String)class_29602.toString(), (int)1024, (boolean)false, (boolean)true, (RenderPipeline)timerVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_34577((class_4668.class_5939)new class_4668.class_4683(class_29602, false)).method_23617(false));
    }

    public static class_1921 tertiaryVal(class_2960 class_29602) {
        return class_1921.method_24049((String)class_29602.toString(), (int)1024, (boolean)false, (boolean)true, (RenderPipeline)anchorVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_34577((class_4668.class_5939)new class_4668.class_4683(class_29602, false)).method_23617(false));
    }

    public static class_1921 marginVal(class_2960 class_29602) {
        return class_1921.method_24049((String)class_29602.toString(), (int)1024, (boolean)false, (boolean)true, (RenderPipeline)weightRef, (class_1921.class_4688)class_1921.class_4688.method_23598().method_34577((class_4668.class_5939)new class_4668.class_4683(class_29602, false)).method_23617(false));
    }

    public static class_1921 primaryVal(double d2) {
        WildRenderLayers.primaryVal(limitRef);
        double d3 = WildRenderLayers.tertiaryVal(d2);
        return limitRef.computeIfAbsent(d3, d -> WildRenderLayers.primaryVal(d, "wild/world/lines", blockRef));
    }

    public static class_1921 secondaryVal(double d2) {
        WildRenderLayers.primaryVal(paramRef);
        double d3 = WildRenderLayers.tertiaryVal(d2);
        return paramRef.computeIfAbsent(d3, d -> WildRenderLayers.primaryVal(d, "wild/world/lines_no_depth", holderVal));
    }

    private static class_1921 primaryVal(double d, String string, RenderPipeline renderPipeline) {
        class_4668.class_4677 class_46772 = new class_4668.class_4677(d == 0.0 ? OptionalDouble.empty() : OptionalDouble.of(d));
        return class_1921.method_24049((String)(string + "/" + (d == 0.0 ? "default" : Double.toHexString(d))), (int)256, (boolean)false, (boolean)true, (RenderPipeline)renderPipeline, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23609(class_46772).method_23617(false));
    }

    public static class_1921.class_4687 primaryVal(class_1921 class_19212, Consumer<RenderPass> consumer) {
        Objects.requireNonNull(class_19212, "renderLayer");
        if (!(class_19212 instanceof class_1921.class_4687)) {
            throw new IllegalArgumentException("Render layer must be a MultiPhase instance.");
        }
        class_1921.class_4687 class_46872 = (class_1921.class_4687)class_19212;
        RenderPhaseAccessor.primaryVal(class_46872).withRenderPassSetup(consumer);
        return class_46872;
    }

    private static double tertiaryVal(double d) {
        if (!Double.isFinite(d)) {
            throw new IllegalArgumentException("Line width must be finite.");
        }
        if (d < 0.0) {
            throw new IllegalArgumentException("Line width cannot be negative.");
        }
        if (d == 0.0) {
            return 0.0;
        }
        double d2 = Math.min(d, 64.0);
        double d3 = (double)Math.round(d2 / 0.0625) * 0.0625;
        if (d3 <= 0.0) {
            d3 = 0.0625;
        }
        return d3;
    }

    private static void primaryVal(Map<Double, class_1921> map) {
        if (map.size() > 128) {
            map.clear();
        }
    }

    static {
        RenderPipeline.Snippet[] snippetArray = new RenderPipeline.Snippet[1];
        snippetArray[0] = class_10799.field_56860;
        limitVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])snippetArray).withLocation(class_2960.method_60655((String)tertiaryVal, (String)"pipeline/world/position_color_quads_no_depth")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).build());
        speedVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)tertiaryVal, (String)"pipeline/world/position_color_quads_no_depth_blend")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        RenderPipeline.Snippet[] snippetArray2 = new RenderPipeline.Snippet[1];
        snippetArray2[0] = class_10799.field_56860;
        widthVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])snippetArray2).withLocation(class_2960.method_60655((String)tertiaryVal, (String)"pipeline/world/position_color_quads_translucent")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).build());
        chunkVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)tertiaryVal, (String)"pipeline/world/position_color_quads_translucent_no_depth")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).build());
        RenderPipeline.Snippet[] snippetArray3 = new RenderPipeline.Snippet[1];
        snippetArray3[0] = class_10799.field_56859;
        blockRef = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])snippetArray3).withLocation(class_2960.method_60655((String)tertiaryVal, (String)"pipeline/world/lines")).withVertexFormat(class_290.field_29337, VertexFormat.class_5596.field_27377).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(true).build());
        holderVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56859}).withLocation(class_2960.method_60655((String)tertiaryVal, (String)"pipeline/world/lines_no_depth")).withVertexFormat(class_290.field_29337, VertexFormat.class_5596.field_27377).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).build());
        timerVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56864}).withLocation(class_2960.method_60655((String)tertiaryVal, (String)"pipeline/world/textured_quads")).withVertexFormat(class_290.field_1575, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).build());
        anchorVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56864}).withLocation(class_2960.method_60655((String)tertiaryVal, (String)"pipeline/world/textured_quads_additive")).withVertexFormat(class_290.field_1575, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.ADDITIVE).build());
        weightRef = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56864}).withLocation(class_2960.method_60655((String)tertiaryVal, (String)"pipeline/world/textured_quads_no_depth_additive")).withVertexFormat(class_290.field_1575, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.ADDITIVE).build());
        bufferVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56864}).withLocation(class_2960.method_60655((String)tertiaryVal, (String)"pipeline/world/textured_quads_no_depth")).withVertexFormat(class_290.field_1575, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).build());
        countVal = class_1921.method_24049((String)"wild/world/position_color_quads", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)extraVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        depthVal = class_1921.method_24049((String)"wild/world/position_color_quads_no_depth", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)limitVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        descRef = class_1921.method_24049((String)"wild/world/position_color_quads_no_depth_blend", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)speedVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        activeVal = class_1921.method_24049((String)"wild/world/position_color_quads_translucent", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)widthVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        radiusVal = class_1921.method_24049((String)"wild/world/position_color_quads_translucent_no_depth", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)chunkVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        factorVal = class_1921.method_24049((String)"wild/world/textured_quads", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)timerVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        sourceVal = class_1921.method_24049((String)"wild/world/textured_quads_additive", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)anchorVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        extraRef = class_1921.method_24049((String)"wild/world/textured_quads_no_depth_additive", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)weightRef, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        phaseVal = class_1921.method_24049((String)"wild/world/textured_quads_no_depth", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)bufferVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        limitRef = new ConcurrentHashMap<Double, class_1921>();
        paramRef = new ConcurrentHashMap<Double, class_1921>();
    }
}

