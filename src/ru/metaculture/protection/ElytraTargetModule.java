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
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_243
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_4668$class_4677
 *  net.minecraft.class_746
 *  org.joml.Matrix4f
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.OptionalDouble;
import net.minecraft.class_10799;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1921;
import net.minecraft.class_243;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4668;
import net.minecraft.class_746;
import org.joml.Matrix4f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.WorldLineRenderer;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.GameContextUtils;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.VertexBufferPool;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.RequiresRole;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@RequiresRole(tertiaryVal={"lichoday"})
@ModuleRegister(primaryVal="ElytraTarget", secondaryVal="Chases the target on elytra", tertiaryVal=ModuleCategory.Combat, marginVal={ModuleBadge.RISKY})
public class ElytraTargetModule
extends Module {
    public final BoolSetting countVal = new BoolSetting("Overtake", true);
    public final ModeSetting depthVal = new ModeSetting("Prediction mode", "ReallyWorld", "ReallyWorld", "ReallyWorld - 2", "Default");
    public final FloatSetting descRef = new FloatSetting("Prediction strength", 2.7f, 1.0f, 5.0f, 0.1f, false);
    public static final FloatSetting activeVal = new FloatSetting("Elytra detection radius", 20.0f, 5.0f, 60.0f, 1.0f, false).primaryVal(() -> !ElytraTargetModule.blockRef());
    public final FloatSetting radiusVal = new FloatSetting("Chase distance", 30.0f, 10.0f, 100.0f, 5.0f, false);
    public final BoolSetting factorVal = new BoolSetting("180 turn", false);
    public final BoolSetting sourceVal = new BoolSetting("Draw prediction", true);
    public final FloatSetting extraRef = new FloatSetting("Transparency", 40.0f, 0.0f, 255.0f, 1.0f, false).primaryVal(() -> !this.sourceVal.tertiaryVal());
    public final BoolSetting phaseVal = new BoolSetting("From theme", true).primaryVal(() -> !this.sourceVal.tertiaryVal());
    public final ModeSetting limitRef;
    private static final double paramRef = 0.35;
    private static final float groupVal = 2.5f;
    private class_243 layerVal;
    private boolean slotVal;
    private class_1309 themeVal;
    private static final int stageVal = 2048;
    private static final RenderPipeline widthRef = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)"minecraft", (String)"rendertype_lequal_depth_test")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
    private static final RenderPipeline trackVal;
    private static final class_1921 modeRef;
    private static final class_1921 angleVal;

    public ElytraTargetModule() {
        String[] stringArray = new String[3];
        stringArray[0] = "Normal";
        stringArray[1] = "Dashed";
        stringArray[2] = "Diagonals";
        this.limitRef = new ModeSetting("Square appearance", "Normal", stringArray).primaryVal(() -> !this.sourceVal.tertiaryVal());
        this.layerVal = null;
        this.slotVal = false;
        this.themeVal = null;
        Setting[] nvUuvVvuuNArray = new Setting[10];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        nvUuvVvuuNArray[5] = this.factorVal;
        nvUuvVvuuNArray[6] = this.sourceVal;
        nvUuvVvuuNArray[7] = this.extraRef;
        nvUuvVvuuNArray[8] = this.phaseVal;
        nvUuvVvuuNArray[9] = this.limitRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    public static boolean blockRef() {
        block3: {
            block2: {
                if (WildClient.primaryVal == null) break block2;
                if (WildClient.primaryVal.secondaryVal != null) break block3;
            }
            return false;
        }
        ElytraTargetModule nnNnuunNNv = WildClient.primaryVal.secondaryVal.primaryVal(ElytraTargetModule.class);
        return nnNnuunNNv != null && nnNnuunNNv.enabled;
    }

    @Override
    public void onDisable() {
        this.layerVal = null;
        this.slotVal = false;
        this.themeVal = null;
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        class_243 class_2432;
        block8: {
            block7: {
                this.layerVal = null;
                if (GameContextUtils.primaryVal()) break block7;
                if (ElytraTargetModule.mc.field_1724 != null && ElytraTargetModule.mc.field_1687 != null) break block8;
            }
            return;
        }
        if (!this.countVal.tertiaryVal() || !ElytraTargetModule.mc.field_1724.method_6128()) {
            this.slotVal = false;
            this.themeVal = null;
            return;
        }
        class_1309 class_13092 = this.holderVal();
        if (class_13092 == null) {
            this.slotVal = false;
            return;
        }
        float f = ElytraTargetModule.mc.field_1724.method_5739((class_1297)class_13092);
        this.layerVal = class_2432 = this.secondaryVal(class_13092);
        class_243 class_2433 = class_2432.method_1020(ElytraTargetModule.mc.field_1724.method_33571());
        if (class_2433.method_1027() < 1.0E-7) {
            return;
        }
        float f2 = (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350));
        float f3 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350)))), (double)-90.0, (double)90.0);
        if (this.primaryVal(f)) {
            f2 = class_3532.method_15393((float)(f2 + 180.0f));
        }
        RotationController.primaryVal(new Rotation(f2, f3), 32.0f, 32.0f, 360.0f, 360.0f, 0, 12, true);
    }

    private class_1309 holderVal() {
        float f = activeVal.tertiaryVal();
        float f2 = Math.max(this.radiusVal.tertiaryVal(), f);
        if (this.primaryVal(this.themeVal) && ElytraTargetModule.mc.field_1724.method_5739((class_1297)this.themeVal) <= f2) {
            return this.themeVal;
        }
        this.themeVal = null;
        class_1309 class_13092 = AttackAuraModule.tokenVal;
        if (this.primaryVal(class_13092)) {
            if (ElytraTargetModule.mc.field_1724.method_5739((class_1297)class_13092) <= f2) {
                this.themeVal = class_13092;
                return this.themeVal;
            }
        }
        class_1309 class_13093 = null;
        double d = f * f;
        for (class_1297 class_12972 : ElytraTargetModule.mc.field_1687.method_18112()) {
            double d2;
            class_1309 class_13094;
            if (!(class_12972 instanceof class_1309) || !this.primaryVal(class_13094 = (class_1309)class_12972) || !((d2 = ElytraTargetModule.mc.field_1724.method_5858((class_1297)class_13094)) <= d)) continue;
            d = d2;
            class_13093 = class_13094;
        }
        this.themeVal = class_13093;
        return class_13093;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(class_1309 class_13092) {
        if (class_13092 == null) return false;
        if (!class_13092.method_5805()) return false;
        if (class_13092 == ElytraTargetModule.mc.field_1724) return false;
        if (class_13092 instanceof class_746) return false;
        if (!class_13092.method_6128()) return false;
        return true;
    }

    private class_243 secondaryVal(class_1309 class_13092) {
        class_243 class_2432 = class_13092.method_19538().method_1031(0.0, (double)class_13092.method_17682() * 0.5, 0.0);
        class_243 class_2433 = class_13092.method_18798();
        double d = this.descRef.tertiaryVal();
        if (this.depthVal.secondaryVal("Default")) {
            return class_2432;
        }
        if (this.depthVal.secondaryVal("ReallyWorld - 2")) {
            class_243 class_2434 = class_13092.method_5720().method_1029().method_1021(2.0);
            return class_2432.method_1019(class_2434).method_1019(class_2433.method_1021(d));
        }
        return class_2432.method_1019(class_2433.method_1021(d));
    }

    private boolean primaryVal(float f) {
        if (!this.factorVal.tertiaryVal()) {
            this.slotVal = false;
            return false;
        }
        float f2 = Math.max(2.5f, this.descRef.tertiaryVal());
        float f3 = f2 + 3.0f;
        if (!this.slotVal && f <= 2.5f) {
            this.slotVal = true;
        }
        if (this.slotVal && f >= f3) {
            this.slotVal = false;
        }
        return this.slotVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        block11: {
            block10: {
                if (!this.sourceVal.tertiaryVal() || this.layerVal == null) break block10;
                if (ElytraTargetModule.mc.field_1687 != null) break block11;
            }
            return;
        }
        class_243 class_2432 = ElytraTargetModule.mc.field_1773.method_19418().method_19326();
        double d = this.layerVal.field_1352 - 0.35 - class_2432.field_1352;
        double d2 = this.layerVal.field_1351 - 0.35 - class_2432.field_1351;
        double d3 = this.layerVal.field_1350 - 0.35 - class_2432.field_1350;
        double d4 = this.layerVal.field_1352 + 0.35 - class_2432.field_1352;
        double d5 = this.layerVal.field_1351 + 0.35 - class_2432.field_1351;
        double d6 = this.layerVal.field_1350 + 0.35 - class_2432.field_1350;
        int n = this.phaseVal.tertiaryVal() ? ColorUtil.primaryVal() : ColorUtil.tertiaryVal(255, 255, 255, 255);
        int[] nArray = new int[4];
        nArray[0] = n;
        nArray[1] = n;
        nArray[2] = n;
        nArray[3] = n;
        int[] nArray2 = nArray;
        int n2 = (int)this.extraRef.tertiaryVal();
        boolean bl = this.limitRef.secondaryVal("Diagonals");
        double d7 = this.limitRef.secondaryVal("Dashed") ? 0.12 : 0.5;
        double d8 = this.limitRef.secondaryVal("Dashed") ? 0.1 : 0.0;
        class_4597.class_4598 class_45982 = VertexBufferPool.primaryVal();
        try {
            class_4588 class_45882;
            class_4587 class_45872 = vvuuvuVVvvn.tertiaryVal();
            Matrix4f matrix4f = class_45872.method_23760().method_23761();
            if (n2 > 0) {
                class_45882 = class_45982.getBuffer(modeRef);
                WorldLineRenderer.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d5, d6, nArray2, n2);
            }
            class_45882 = class_45982.getBuffer(angleVal);
            WorldLineRenderer.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d5, d6, nArray2, 255, d7, d8);
            if (bl) {
                this.primaryVal(class_45882, matrix4f, n, d, d2, d3, d4, d5, d6);
            }
        }
        finally {
            VertexBufferPool.secondaryVal();
        }
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, int n, double d, double d2, double d3, double d4, double d5, double d6) {
        double[][] dArrayArray;
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        int n5 = 255;
        double[][] dArrayArray2 = new double[4][];
        double[] dArray = new double[6];
        dArray[0] = d;
        dArray[1] = d2;
        dArray[2] = d3;
        dArray[3] = d4;
        dArray[4] = d5;
        dArray[5] = d6;
        dArrayArray2[0] = dArray;
        dArrayArray2[1] = new double[]{d4, d2, d3, d, d5, d6};
        double[] dArray2 = new double[6];
        dArray2[0] = d;
        dArray2[1] = d2;
        dArray2[2] = d6;
        dArray2[3] = d4;
        dArray2[4] = d5;
        dArray2[5] = d3;
        dArrayArray2[2] = dArray2;
        double[] dArray3 = new double[6];
        dArray3[0] = d4;
        dArray3[1] = d2;
        dArray3[2] = d6;
        dArray3[3] = d;
        dArray3[4] = d5;
        dArray3[5] = d3;
        dArrayArray2[3] = dArray3;
        for (double[] dArray4 : dArrayArray = dArrayArray2) {
            class_45882.method_22918(matrix4f, (float)dArray4[0], (float)dArray4[1], (float)dArray4[2]).method_1336(n2, n3, n4, n5);
            class_45882.method_22918(matrix4f, (float)dArray4[3], (float)dArray4[4], (float)dArray4[5]).method_1336(n2, n3, n4, n5);
        }
    }

    static {
        RenderPipeline.Snippet[] snippetArray = new RenderPipeline.Snippet[1];
        snippetArray[0] = class_10799.field_56860;
        trackVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])snippetArray).withLocation(class_2960.method_60655((String)"minecraft", (String)"rendertype_lines")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_29344).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        modeRef = class_1921.method_24049((String)"elytra_target_fill", (int)2048, (boolean)false, (boolean)true, (RenderPipeline)widthRef, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        angleVal = class_1921.method_24049((String)"elytra_target_line", (int)2048, (boolean)false, (boolean)true, (RenderPipeline)trackVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23609(new class_4668.class_4677(OptionalDouble.of(2.0))).method_23617(false));
    }
}

