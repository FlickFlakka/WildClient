/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1944
 *  net.minecraft.class_2338
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1944;
import net.minecraft.class_2338;
import net.minecraft.class_3532;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.PostClientTickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="FullBright", secondaryVal="ENLIGHTENED", tertiaryVal=ModuleCategory.Visuals)
public class FullBrightModule
extends Module {
    private static final String limitRef = "Gamma";
    private static final String paramRef = "Effect";
    private static final String groupVal = "Dynamic";
    private static final String layerVal = "Adaptive";
    private static final String slotVal = "Torch";
    public ModeSetting countVal = new ModeSetting("Type", "Gamma", "Gamma", "Effect", "Dynamic", "Adaptive", "Torch");
    public FloatSetting depthVal = new FloatSetting("Threshold", 0.53f, 0.5f, 0.6f, 0.01f, true).primaryVal(() -> !this.timerVal());
    public FloatSetting descRef = new FloatSetting("Curve", 1.4f, 0.5f, 3.0f, 0.1f, false).primaryVal(() -> !this.timerVal());
    public FloatSetting activeVal = new FloatSetting("Radius", 10.0f, 5.0f, 20.0f, 1.0f, false).primaryVal(() -> !this.anchorVal());
    public static volatile boolean radiusVal = false;
    public static volatile float factorVal = 10.0f;
    public static volatile double sourceVal = 0.0;
    public static volatile double extraRef = 0.0;
    public static volatile double phaseVal = 0.0;
    private int themeVal = Integer.MIN_VALUE;
    private int stageVal = Integer.MIN_VALUE;
    private int widthRef = Integer.MIN_VALUE;
    private boolean trackVal = false;
    private int modeRef;
    private int angleVal;
    private int heightRef;
    private int levelVal;
    private int UuNnnVnuNNV;
    private int depthRef;

    public FullBrightModule() {
        Setting[] nvUuvVvuuNArray = new Setting[4];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.themeVal = Integer.MIN_VALUE;
        this.stageVal = Integer.MIN_VALUE;
        this.widthRef = Integer.MIN_VALUE;
        if (FullBrightModule.mc.field_1769 != null && this.radiusVal()) {
            FullBrightModule.mc.field_1769.method_3279();
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.descRef();
        if (FullBrightModule.mc.field_1769 != null && this.radiusVal()) {
            FullBrightModule.mc.field_1769.method_3279();
        }
        if (FullBrightModule.mc.field_1724 != null) {
            FullBrightModule.mc.field_1724.method_6016(class_1294.field_5925);
        }
    }

    @Subscribe
    public void primaryVal(PostClientTickEvent coreH) {
        if (FullBrightModule.mc.field_1724 == null) {
            return;
        }
        if (this.activeVal()) {
            FullBrightModule.mc.field_1724.method_6016(class_1294.field_5925);
        }
        if (this.countVal.secondaryVal(paramRef)) {
            FullBrightModule.mc.field_1724.method_6092(new class_1293(class_1294.field_5925, 300, 0, false, false));
        }
        this.depthVal();
    }

    private void depthVal() {
        block6: {
            block5: {
                if (!this.anchorVal()) break block5;
                if (FullBrightModule.mc.field_1687 != null && FullBrightModule.mc.field_1769 != null) break block6;
            }
            this.descRef();
            return;
        }
        factorVal = this.activeVal.tertiaryVal();
        sourceVal = FullBrightModule.mc.field_1724.method_23317();
        extraRef = FullBrightModule.mc.field_1724.method_23320();
        phaseVal = FullBrightModule.mc.field_1724.method_23321();
        radiusVal = true;
        int n = class_3532.method_15357((double)sourceVal);
        int n2 = class_3532.method_15357((double)FullBrightModule.mc.field_1724.method_23318());
        int n3 = class_3532.method_15357((double)phaseVal);
        if (n == this.themeVal && n2 == this.stageVal && n3 == this.widthRef) {
            return;
        }
        if (this.trackVal) {
            FullBrightModule.mc.field_1769.method_18146(this.modeRef, this.angleVal, this.heightRef, this.levelVal, this.UuNnnVnuNNV, this.depthRef);
        }
        int n4 = class_3532.method_15386((float)this.activeVal.tertiaryVal()) + 1;
        this.modeRef = n - n4;
        this.angleVal = n2 - n4;
        this.heightRef = n3 - n4;
        this.levelVal = n + n4;
        this.UuNnnVnuNNV = n2 + n4;
        this.depthRef = n3 + n4;
        this.trackVal = true;
        FullBrightModule.mc.field_1769.method_18146(this.modeRef, this.angleVal, this.heightRef, this.levelVal, this.UuNnnVnuNNV, this.depthRef);
        this.themeVal = n;
        this.stageVal = n2;
        this.widthRef = n3;
    }

    private void descRef() {
        if (!radiusVal && !this.trackVal) {
            return;
        }
        radiusVal = false;
        if (this.trackVal && FullBrightModule.mc.field_1769 != null) {
            FullBrightModule.mc.field_1769.method_18146(this.modeRef, this.angleVal, this.heightRef, this.levelVal, this.UuNnnVnuNNV, this.depthRef);
        }
        this.trackVal = false;
        this.themeVal = Integer.MIN_VALUE;
        this.stageVal = Integer.MIN_VALUE;
        this.widthRef = Integer.MIN_VALUE;
    }

    public static int primaryVal(int n, int n2, int n3) {
        return FullBrightModule.primaryVal((double)n + 0.5, (double)n2 + 0.5, (double)n3 + 0.5);
    }

    public static int primaryVal(double d, double d2, double d3) {
        if (!radiusVal) {
            return 0;
        }
        float f = factorVal;
        if (f <= 0.0f) {
            return 0;
        }
        double d4 = d - sourceVal;
        double d5 = d2 - extraRef;
        double d6 = d3 - phaseVal;
        double d7 = Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6);
        if (d7 >= (double)f) {
            return 0;
        }
        int n = Math.round(15.0f * (float)(1.0 - d7 / (double)f));
        if (n < 1) {
            return 0;
        }
        return Math.min(n, 15);
    }

    public boolean blockRef() {
        return this.countVal.secondaryVal(limitRef);
    }

    public boolean holderVal() {
        return this.countVal.secondaryVal(groupVal);
    }

    public boolean timerVal() {
        return this.countVal.secondaryVal(layerVal);
    }

    public boolean anchorVal() {
        return this.countVal.secondaryVal(slotVal);
    }

    public float weightRef() {
        return FullBrightModule.primaryVal(this.depthVal.tertiaryVal(), 0.0f, 1.0f);
    }

    public float bufferVal() {
        return FullBrightModule.primaryVal(this.descRef.tertiaryVal(), 0.5f, 3.0f);
    }

    public float countVal() {
        if (FullBrightModule.mc.field_1724 == null || FullBrightModule.mc.field_1687 == null) {
            return 80.0f;
        }
        class_2338 class_23382 = FullBrightModule.mc.field_1724.method_24515();
        float f = (float)FullBrightModule.mc.field_1687.method_8314(class_1944.field_9282, class_23382) / 15.0f;
        float f2 = (float)FullBrightModule.mc.field_1687.method_8314(class_1944.field_9284, class_23382) / 15.0f;
        float f3 = FullBrightModule.primaryVal(FullBrightModule.mc.field_1687.method_8532() % 24000L);
        float f4 = Math.max(f, f2 * (1.0f - f3 * 0.7f));
        float f5 = FullBrightModule.primaryVal(Math.max(1.0f - f4, f3 * 0.65f), 0.0f, 1.0f);
        float f6 = (float)Math.sin((double)System.currentTimeMillis() * 0.0018) * 0.035f;
        return 2.0f + FullBrightModule.primaryVal(f5 + f6, 0.0f, 1.0f) * 198.0f;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean activeVal() {
        if (this.countVal.secondaryVal(limitRef)) return true;
        if (this.countVal.secondaryVal(groupVal)) return true;
        if (!this.countVal.secondaryVal(layerVal)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean radiusVal() {
        if (this.countVal.secondaryVal(limitRef)) return true;
        if (!this.countVal.secondaryVal(groupVal)) return false;
        return true;
    }

    private static float primaryVal(long l) {
        if (l < 12000L) {
            return 0.0f;
        }
        if (l < 14000L) {
            return (float)(l - 12000L) / 2000.0f;
        }
        if (l < 22000L) {
            return 1.0f;
        }
        return 1.0f - (float)(l - 22000L) / 2000.0f;
    }

    private static float primaryVal(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }
}

