/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1713
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2596
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 *  net.minecraft.class_3675
 *  net.minecraft.class_490
 *  org.lwjgl.glfw.GLFW
 */
package ru.metaculture.protection;

import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2596;
import net.minecraft.class_2848;
import net.minecraft.class_3675;
import net.minecraft.class_490;
import org.lwjgl.glfw.GLFW;
import org.wild.mixin.acceser.ClientPlayerInteractionManagerAccessor;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.SprintModule;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AutoExp", secondaryVal="Automatically uses experience bottles", tertiaryVal=ModuleCategory.Player)
public class AutoExpModule
extends Module {
    private final KeybindSetting countVal = new KeybindSetting("Experience key", -1, true);
    private final FloatSetting depthVal = new FloatSetting("Delay", 80.0f, 20.0f, 300.0f, 10.0f, false);
    private final BoolSetting descRef = new BoolSetting("Only worn items", false);
    private final FloatSetting activeVal = new FloatSetting("Durability up to", 95.0f, 5.0f, 100.0f, 5.0f, false).primaryVal(() -> !this.descRef.tertiaryVal());
    private final VuNvNNvVV radiusVal = new VuNvNNvVV();
    private int factorVal = 0;
    private int sourceVal = 0;
    private int extraRef = -1;
    private int phaseVal = -1;
    private class_1268 limitRef = class_1268.field_5808;

    public AutoExpModule() {
        this.addSettings(this.countVal, this.depthVal, this.descRef, this.activeVal);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        block8: {
            block7: {
                if (AutoExpModule.mc.field_1724 == null || AutoExpModule.mc.field_1761 == null) break block7;
                if (this.countVal.tertiaryVal() != -1) break block8;
            }
            this.bufferVal();
            return;
        }
        if (this.factorVal > 0) {
            if (this.sourceVal > 0) {
                this.countVal();
                --this.sourceVal;
                return;
            }
            this.holderVal();
            return;
        }
        if (!this.descRef() || !this.radiusVal.weightVal((long)this.depthVal.tertiaryVal())) {
            return;
        }
        if (this.descRef.tertiaryVal() && !this.radiusVal()) {
            return;
        }
        this.blockRef();
    }

    private void blockRef() {
        this.phaseVal = AutoExpModule.mc.field_1724.method_31548().method_67532();
        if (AutoExpModule.mc.field_1724.method_6079().method_31574(class_1802.field_8287)) {
            this.limitRef = class_1268.field_5810;
            this.factorVal = AutoExpModule.mc.field_1755 instanceof class_490 ? 1 : 2;
            return;
        }
        int n = this.activeVal();
        if (n == -1) {
            return;
        }
        this.extraRef = n;
        this.limitRef = class_1268.field_5808;
        this.factorVal = AutoExpModule.mc.field_1755 instanceof class_490 ? 1 : (n < 9 ? 2 : 4);
    }

    private void holderVal() {
        if (AutoExpModule.mc.field_1724 == null || AutoExpModule.mc.field_1761 == null) {
            this.bufferVal();
            return;
        }
        switch (this.factorVal) {
            case 1: {
                AutoExpModule.mc.field_1724.method_7346();
                this.factorVal = this.extraRef >= 9 ? 4 : 2;
                this.sourceVal = 2;
                break;
            }
            case 2: {
                this.countVal();
                this.timerVal();
                this.factorVal = 3;
                this.sourceVal = 1;
                break;
            }
            case 3: {
                this.anchorVal();
                break;
            }
            case 4: {
                this.countVal();
                this.depthVal();
                AutoExpModule.mc.field_1761.method_2906(AutoExpModule.mc.field_1724.field_7498.field_7763, this.extraRef, this.phaseVal, class_1713.field_7791, (class_1657)AutoExpModule.mc.field_1724);
                AutoExpModule.mc.field_1724.method_7346();
                this.factorVal = 5;
                this.sourceVal = 2;
                break;
            }
            case 5: {
                this.countVal();
                this.timerVal();
                this.factorVal = 6;
                this.sourceVal = 2;
                break;
            }
            case 6: {
                this.countVal();
                this.depthVal();
                AutoExpModule.mc.field_1761.method_2906(AutoExpModule.mc.field_1724.field_7498.field_7763, this.extraRef, this.phaseVal, class_1713.field_7791, (class_1657)AutoExpModule.mc.field_1724);
                AutoExpModule.mc.field_1724.method_7346();
                this.weightRef();
                break;
            }
            default: {
                this.bufferVal();
            }
        }
    }

    private void timerVal() {
        if (this.limitRef == class_1268.field_5808 && this.extraRef >= 0 && this.extraRef < 9) {
            AutoExpModule.mc.field_1724.method_31548().method_61496(this.extraRef);
        }
        AutoExpModule.mc.field_1761.method_2919((class_1657)AutoExpModule.mc.field_1724, this.limitRef);
        AutoExpModule.mc.field_1724.method_6104(this.limitRef);
    }

    private void anchorVal() {
        if (this.limitRef == class_1268.field_5808 && this.extraRef >= 0 && this.extraRef < 9 && this.phaseVal != this.extraRef) {
            AutoExpModule.mc.field_1724.method_31548().method_61496(this.phaseVal);
            ((ClientPlayerInteractionManagerAccessor)AutoExpModule.mc.field_1761).invokeSyncSelectedSlot();
        }
        this.weightRef();
    }

    private void weightRef() {
        this.radiusVal.primaryVal();
        this.bufferVal();
    }

    private void bufferVal() {
        this.factorVal = 0;
        this.sourceVal = 0;
        this.extraRef = -1;
        this.phaseVal = -1;
        this.limitRef = class_1268.field_5808;
    }

    private void countVal() {
        SprintModule.radiusVal = 2;
        AutoExpModule.mc.field_1690.field_1867.method_23481(false);
        if (AutoExpModule.mc.field_1724.method_5624()) {
            AutoExpModule.mc.field_1724.method_5728(false);
            if (mc.method_1562() != null) {
                mc.method_1562().method_52787((class_2596)new class_2848((class_1297)AutoExpModule.mc.field_1724, class_2848.class_2849.field_12985));
            }
        }
    }

    private void depthVal() {
        if (mc.method_1562() != null) {
            mc.method_1562().method_52787((class_2596)new class_2848((class_1297)AutoExpModule.mc.field_1724, class_2848.class_2849.field_12988));
        }
    }

    private boolean descRef() {
        if (AutoExpModule.mc.field_1755 == null) {
            return KeybindSetting.secondaryVal(this.countVal.tertiaryVal());
        }
        if (!(AutoExpModule.mc.field_1755 instanceof class_490) || mc.method_22683() == null) {
            return false;
        }
        long l = mc.method_22683().method_4490();
        int n = this.countVal.tertiaryVal();
        if (n >= 0) {
            return class_3675.method_15987((long)l, (int)n);
        }
        if (n <= -100) {
            return GLFW.glfwGetMouseButton((long)l, (int)(-n - 100)) == 1;
        }
        return false;
    }

    private int activeVal() {
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = AutoExpModule.mc.field_1724.method_31548().method_5438(i);
            if (class_17992.method_7960() || !class_17992.method_31574(class_1802.field_8287)) continue;
            return i;
        }
        return -1;
    }

    private boolean radiusVal() {
        for (int i = 0; i < AutoExpModule.mc.field_1724.method_31548().method_5439(); ++i) {
            if (!this.primaryVal(AutoExpModule.mc.field_1724.method_31548().method_5438(i))) continue;
            return true;
        }
        return this.primaryVal(AutoExpModule.mc.field_1724.method_6079());
    }

    private boolean primaryVal(class_1799 class_17992) {
        block5: {
            block4: {
                if (class_17992.method_7960()) break block4;
                if (class_17992.method_7963()) break block5;
            }
            return false;
        }
        int n = class_17992.method_7936();
        if (n <= 0) {
            return false;
        }
        int n2 = n - class_17992.method_7919();
        float f = (float)n2 * 100.0f / (float)n;
        return f <= this.activeVal.tertiaryVal();
    }

    @Override
    public void onDisable() {
        this.bufferVal();
        super.onDisable();
    }
}

