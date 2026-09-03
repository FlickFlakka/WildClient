/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_7833
 *  org.joml.Matrix4f
 *  org.joml.Quaternionfc
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_243;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_7833;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.CurveAnimatedValue;
import ru.metaculture.protection.Easing;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.VertexBufferPool;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.JumpEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.JumpCircleRenderer;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="JumpCircle", secondaryVal="Nice circle after jumping", tertiaryVal=ModuleCategory.Visuals)
public class JumpCircleModule
extends Module {
    private static final long radiusVal = 250L;
    private static final long factorVal = 1500L;
    private static final long sourceVal = 850L;
    private static final float extraRef = 1.95f;
    private static final float phaseVal = 0.04f;
    public final BoolSetting countVal = new BoolSetting("Shimmer", false);
    public final FloatSetting depthVal = new FloatSetting("Shimmer speed", 1.0f, 0.1f, 3.0f, 0.05f, false);
    public final FloatSetting descRef = new FloatSetting("Brightness", 1.0f, 0.25f, 2.0f, 0.05f, false);
    public final FloatSetting activeVal = new FloatSetting("Transparency", 1.0f, 0.1f, 1.0f, 0.05f, true);
    private final List<WildClient> limitRef = new ArrayList<WildClient>();
    private long paramRef;

    public JumpCircleModule() {
        this.addSettings(this.countVal, this.depthVal, this.descRef, this.activeVal);
        JumpCircleRenderer.primaryVal();
    }

    @Subscribe
    public void primaryVal(JumpEvent kelpD) {
        if (JumpCircleModule.mc.field_1724 == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.paramRef < 250L) {
            return;
        }
        this.paramRef = l;
        this.limitRef.add(new WildClient(JumpCircleModule.mc.field_1724.method_19538().method_1031(0.0, (double)0.04f, 0.0), l));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        if (this.limitRef.isEmpty()) {
            return;
        }
        long l = System.currentTimeMillis();
        this.limitRef.removeIf(modeVal -> l - modeVal.secondaryVal > 1500L);
        if (this.limitRef.isEmpty()) {
            return;
        }
        NvVNvUvunNNu nvVNvUvunNNu = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null ? ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal() : NvVNvUvunNNu.WILD;
        int n = nvVNvUvunNNu == NvVNvUvunNNu.WILD ? 0x7BB7FF : nvVNvUvunNNu.primaryVal().getRGB() & 0xFFFFFF;
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        boolean bl = this.countVal.tertiaryVal();
        JumpCircleRenderer.primaryVal(this.depthVal.tertiaryVal(), this.descRef.tertiaryVal(), this.activeVal.tertiaryVal());
        class_4597.class_4598 class_45982 = VertexBufferPool.primaryVal();
        try {
            class_4588 class_45882 = class_45982.getBuffer(bl ? JumpCircleRenderer.tertiaryVal() : JumpCircleRenderer.secondaryVal());
            class_4587 class_45872 = vvuuvuVVvvn.tertiaryVal();
            class_243 class_2432 = JumpCircleModule.mc.field_1773.method_19418().method_19326();
            for (WildClient nodeC : this.limitRef) {
                long l2 = l - nodeC.secondaryVal;
                if (l2 >= 850L && !nodeC.paramVal) {
                    nodeC.weightVal.primaryVal(0.0, 0.65, Easing.chunkVal);
                    nodeC.marginVal.primaryVal(1.35, 0.65, Easing.chunkVal);
                    nodeC.paramVal = true;
                }
                nodeC.tertiaryVal.primaryVal();
                nodeC.marginVal.primaryVal();
                nodeC.weightVal.primaryVal();
                float f = Math.max(0.0f, Math.min(1.0f, (float)nodeC.tertiaryVal.speedVal()));
                float f2 = (float)nodeC.marginVal.speedVal();
                float f3 = Math.max(0.0f, Math.min(1.0f, (float)nodeC.weightVal.speedVal()));
                if (f3 <= 0.002f || f2 <= 0.001f) continue;
                int n5 = (int)(f3 * f * 255.0f);
                float f4 = 1.95f * f2 * f;
                class_45872.method_22903();
                class_45872.method_22904(nodeC.primaryVal.field_1352 - class_2432.field_1352, nodeC.primaryVal.field_1351 - class_2432.field_1351, nodeC.primaryVal.field_1350 - class_2432.field_1350);
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(90.0f));
                this.primaryVal(class_45882, class_45872.method_23760().method_23761(), f4, n2, n3, n4, n5);
                class_45872.method_22909();
            }
        }
        finally {
            VertexBufferPool.secondaryVal();
            JumpCircleRenderer.weightVal();
        }
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, int n, int n2, int n3, int n4) {
        float f2 = f * 0.5f;
        class_45882.method_22918(matrix4f, -f2, -f2, 0.0f).method_22913(0.0f, 0.0f).method_1336(n, n2, n3, n4).method_22914(0.0f, 0.0f, 1.0f);
        class_45882.method_22918(matrix4f, f2, -f2, 0.0f).method_22913(1.0f, 0.0f).method_1336(n, n2, n3, n4).method_22914(0.0f, 0.0f, 1.0f);
        class_45882.method_22918(matrix4f, f2, f2, 0.0f).method_22913(1.0f, 1.0f).method_1336(n, n2, n3, n4).method_22914(0.0f, 0.0f, 1.0f);
        class_45882.method_22918(matrix4f, -f2, f2, 0.0f).method_22913(0.0f, 1.0f).method_1336(n, n2, n3, n4).method_22914(0.0f, 0.0f, 1.0f);
    }

    static final class WildClient {
        final class_243 primaryVal;
        final long secondaryVal;
        final CurveAnimatedValue tertiaryVal = new CurveAnimatedValue();
        final CurveAnimatedValue marginVal = new CurveAnimatedValue();
        final CurveAnimatedValue weightVal = new CurveAnimatedValue();
        boolean paramVal;

        WildClient(class_243 class_2432, long l) {
            this.primaryVal = class_2432;
            this.secondaryVal = l;
            this.tertiaryVal.primaryVal(1.0, 0.28, Easing.chunkVal);
            this.marginVal.primaryVal(1.0, 0.4, Easing.timerVal);
            this.weightVal.primaryVal(1.0, 0.18, Easing.timerVal);
        }
    }
}

