/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_10799
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_4668$class_4677
 *  org.joml.Matrix4f
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import net.minecraft.class_10799;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1921;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4668;
import org.joml.Matrix4f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WorldLineRenderer;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.VertexBufferPool;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="ESP", secondaryVal="Player highlighting", tertiaryVal=ModuleCategory.Visuals)
public class ESPModule
extends Module {
    private static final int radiusVal = 2048;
    private static final int factorVal = 96;
    private static final int sourceVal = ColorUtil.tertiaryVal(52, 255, 96, 255);
    public final SettingGroup countVal;
    public final FloatSetting depthVal;
    public final BoolSetting descRef;
    public final BoolSetting activeVal;
    private final List<class_1297> extraRef;
    private final int[] phaseVal;
    private static final RenderPipeline limitRef;
    private static final RenderPipeline paramRef;
    private static final class_1921 groupVal;
    private static final class_1921 layerVal;

    public ESPModule() {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[2];
        vvNnnUNnVvnArray[0] = new BoolSetting("Players", true);
        vvNnnUNnVvnArray[1] = new BoolSetting("Mobs", true);
        this.countVal = new SettingGroup("Targets", vvNnnUNnVvnArray);
        this.depthVal = new FloatSetting("Distance", 72.0f, 8.0f, 200.0f, 1.0f, false);
        this.descRef = new BoolSetting("Fill", true);
        this.activeVal = new BoolSetting("Outline", true);
        this.extraRef = new ArrayList<class_1297>(96);
        this.phaseVal = new int[4];
        Setting[] nvUuvVvuuNArray = new Setting[4];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        if (ESPModule.mc.field_1687 == null || ESPModule.mc.field_1724 == null) {
            return;
        }
        List<class_1297> list = this.blockRef();
        if (list.isEmpty()) {
            return;
        }
        class_4597.class_4598 class_45982 = VertexBufferPool.primaryVal();
        try {
            Iterator<class_1297> iterator = list.iterator();
            while (iterator.hasNext()) {
                class_1297 class_12972 = iterator.next();
                this.primaryVal(vvuuvuVVvvn.tertiaryVal(), class_45982, class_12972, vvuuvuVVvvn.marginVal());
            }
        }
        finally {
            VertexBufferPool.secondaryVal();
        }
    }

    private List<class_1297> blockRef() {
        this.extraRef.clear();
        float f = this.depthVal.tertiaryVal() * this.depthVal.tertiaryVal();
        boolean bl = this.countVal.secondaryVal("Players");
        boolean bl2 = this.countVal.secondaryVal("Mobs");
        for (class_1297 class_12972 : ESPModule.mc.field_1687.method_18112()) {
            if (this.extraRef.size() >= 96) break;
            if (!this.primaryVal(class_12972, bl, bl2) || ESPModule.mc.field_1724.method_5858(class_12972) > (double)f) continue;
            this.extraRef.add(class_12972);
        }
        return this.extraRef;
    }

    private boolean primaryVal(class_1297 class_12972, boolean bl, boolean bl2) {
        class_1309 class_13092;
        if (class_12972 == null || class_12972 == ESPModule.mc.field_1724) {
            return false;
        }
        if (!(class_12972 instanceof class_1309) || !(class_13092 = (class_1309)class_12972).method_5805()) {
            return false;
        }
        if (class_12972 instanceof class_1657) {
            return bl;
        }
        return bl2;
    }

    private void primaryVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_1297 class_12972, float f) {
        class_4588 class_45882;
        int n;
        class_243 class_2432 = ESPModule.mc.field_1773.method_19418().method_19326();
        class_243 class_2433 = this.primaryVal(class_12972, f);
        class_238 class_2383 = class_12972.method_5829().method_989(class_2433.field_1352 - class_12972.method_23317(), class_2433.field_1351 - class_12972.method_23318(), class_2433.field_1350 - class_12972.method_23321());
        float f2 = class_12972 instanceof class_1657 ? 0.09f : 0.06f;
        class_238 class_2384 = class_2383.method_1014((double)f2).method_989(-class_2432.field_1352, -class_2432.field_1351, -class_2432.field_1350);
        int n2 = this.secondaryVal(class_12972);
        float f3 = this.primaryVal(class_12972);
        int n3 = ColorUtil.paramVal(n2, 0.92f);
        int n4 = ColorUtil.weightVal(n2, 0.62f);
        int n5 = ColorUtil.weightVal(n2, 0.8f);
        int[] nArray = this.phaseVal;
        nArray[0] = ColorUtil.secondaryVal(n3, n5, 0, 10);
        nArray[1] = ColorUtil.secondaryVal(n5, n4, 90, 10);
        nArray[2] = ColorUtil.secondaryVal(n4, n5, 180, 10);
        nArray[3] = ColorUtil.secondaryVal(n5, n3, 270, 10);
        Matrix4f matrix4f = class_45872.method_23760().method_23761();
        if (this.descRef.tertiaryVal()) {
            n = (int)(class_3532.method_15363((float)f3, (float)0.1f, (float)1.0f) * 95.0f);
            class_45882 = class_45982.getBuffer(groupVal);
            WorldLineRenderer.primaryVal(class_45882, matrix4f, class_2384.field_1323, class_2384.field_1322, class_2384.field_1321, class_2384.field_1320, class_2384.field_1325, class_2384.field_1324, nArray, n);
        }
        if (this.activeVal.tertiaryVal()) {
            n = (int)(class_3532.method_15363((float)f3, (float)0.2f, (float)1.0f) * 255.0f);
            class_45882 = class_45982.getBuffer(layerVal);
            WorldLineRenderer.primaryVal(class_45882, matrix4f, class_2384.field_1323, class_2384.field_1322, class_2384.field_1321, class_2384.field_1320, class_2384.field_1325, class_2384.field_1324, nArray, n, 0.18, 0.06);
        }
    }

    private class_243 primaryVal(class_1297 class_12972, float f) {
        double d = class_3532.method_16436((double)f, (double)class_12972.field_6038, (double)class_12972.method_23317());
        double d2 = class_3532.method_16436((double)f, (double)class_12972.field_5971, (double)class_12972.method_23318());
        double d3 = class_3532.method_16436((double)f, (double)class_12972.field_5989, (double)class_12972.method_23321());
        return new class_243(d, d2, d3);
    }

    private float primaryVal(class_1297 class_12972) {
        float f = ESPModule.mc.field_1724.method_5739(class_12972);
        float f2 = Math.max(this.depthVal.tertiaryVal(), 1.0f);
        return 1.0f - class_3532.method_15363((float)(f / f2), (float)0.0f, (float)1.0f);
    }

    private int secondaryVal(class_1297 class_12972) {
        if (class_12972 instanceof class_1657) {
            String string;
            class_1657 class_16572 = (class_1657)class_12972;
            string = class_16572.method_7334() != null ? class_16572.method_7334().getName() : class_16572.method_5477().getString();
            if (FriendCommand.primaryVal(string)) {
                return sourceVal;
            }
            return ColorUtil.activeVal(class_16572.method_5628() * 17);
        }
        return ColorUtil.activeVal(class_12972.method_5628() * 11);
    }

    static {
        RenderPipeline.Snippet[] snippetArray = new RenderPipeline.Snippet[1];
        snippetArray[0] = class_10799.field_56860;
        limitRef = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])snippetArray).withLocation(class_2960.method_60655((String)"minecraft", (String)"rendertype_lequal_depth_test")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        paramRef = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)"minecraft", (String)"rendertype_lines")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_29344).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        groupVal = class_1921.method_24049((String)"litka_esp_fill", (int)2048, (boolean)false, (boolean)true, (RenderPipeline)limitRef, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        layerVal = class_1921.method_24049((String)"litka_esp_line", (int)2048, (boolean)false, (boolean)true, (RenderPipeline)paramRef, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23609(new class_4668.class_4677(OptionalDouble.of(2.2))).method_23617(false));
    }
}

