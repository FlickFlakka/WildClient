/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_239$class_240
 *  org.lwjgl.glfw.GLFW
 */
package ru.metaculture.protection;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_239;
import org.lwjgl.glfw.GLFW;
import org.wild.mixin.acceser.MinecraftClientAccessor;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.Cooldown;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="TapeMouse", secondaryVal="Who even uses this ?-?", tertiaryVal=ModuleCategory.Misc)
public class TapeMouseModule
extends Module {
    private final ModeSetting countVal = new ModeSetting("Button", "LMB", "LMB", "RMB", "Both");
    private final ModeSetting depthVal = new ModeSetting("Hit mode", "By cooldown", "By cooldown", "By delay", "CPS");
    private final FloatSetting descRef = new FloatSetting("Delay", 1000.0f, 100.0f, 5000.0f, 100.0f, false).primaryVal(() -> !this.depthVal.secondaryVal("By delay"));
    private final FloatSetting activeVal = new FloatSetting("CPS minimum", 8.0f, 1.0f, 20.0f, 1.0f, false).primaryVal(() -> !this.depthVal.secondaryVal("CPS"));
    private final FloatSetting radiusVal = new FloatSetting("CPS maximum", 12.0f, 1.0f, 20.0f, 1.0f, false).primaryVal(() -> !this.depthVal.secondaryVal("CPS"));
    private final BoolSetting factorVal = new BoolSetting("Entity check", false);
    private final BoolSetting sourceVal = new BoolSetting("Only while held", false);
    private final Cooldown extraRef = new Cooldown();
    private final Cooldown phaseVal = new Cooldown();
    private long limitRef;
    private long paramRef;

    public TapeMouseModule() {
        Setting[] nvUuvVvuuNArray = new Setting[7];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        nvUuvVvuuNArray[5] = this.factorVal;
        nvUuvVvuuNArray[6] = this.sourceVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.timerVal();
    }

    @Override
    public void toggle() {
        super.toggle();
        this.timerVal();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        block6: {
            block5: {
                if (TapeMouseModule.mc.field_1724 == null || TapeMouseModule.mc.field_1761 == null || TapeMouseModule.mc.field_1755 != null) {
                    return;
                }
                if (this.countVal.secondaryVal("LMB")) break block5;
                if (!this.countVal.secondaryVal("Both")) break block6;
            }
            this.tertiaryVal(true);
        }
        if (this.countVal.secondaryVal("RMB") || this.countVal.secondaryVal("Both")) {
            this.tertiaryVal(false);
        }
    }

    private void tertiaryVal(boolean bl) {
        if (bl && this.factorVal.tertiaryVal()) {
            if (!this.blockRef()) {
                return;
            }
        }
        if (this.sourceVal.tertiaryVal() && !this.primaryVal(bl ? 0 : 1)) {
            return;
        }
        Cooldown duneI = bl ? this.extraRef : this.phaseVal;
        if (this.depthVal.secondaryVal("By cooldown")) {
            if (this.marginVal(bl)) {
                this.weightVal(bl);
            }
        } else if (this.depthVal.secondaryVal("By delay")) {
            if (duneI.primaryVal(this.descRef.tertiaryVal())) {
                this.weightVal(bl);
                duneI.primaryVal();
            }
        } else {
            long l;
            l = bl ? this.limitRef : this.paramRef;
            if (duneI.primaryVal((double)l)) {
                this.weightVal(bl);
                duneI.primaryVal();
                long l3 = this.holderVal();
                if (bl) {
                    this.limitRef = l3;
                } else {
                    this.paramRef = l3;
                }
            }
        }
    }

    private boolean marginVal(boolean bl) {
        if (bl) {
            return TapeMouseModule.mc.field_1724.method_7261(0.0f) >= 1.0f;
        }
        return ((MinecraftClientAccessor)mc).getItemUseCooldown() <= 0;
    }

    private void weightVal(boolean bl) {
        MinecraftClientAccessor minecraftClientAccessor = (MinecraftClientAccessor)mc;
        if (bl) {
            minecraftClientAccessor.invokeDoAttack();
        } else {
            minecraftClientAccessor.invokeDoItemUse();
            if (this.depthVal.secondaryVal("By cooldown")) {
                minecraftClientAccessor.setItemUseCooldown(4);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean blockRef() {
        if (TapeMouseModule.mc.field_1765 == null) return false;
        if (TapeMouseModule.mc.field_1765.method_17783() != class_239.class_240.field_1331) return false;
        return true;
    }

    private boolean primaryVal(int n) {
        if (mc.method_22683() == null) {
            return false;
        }
        return GLFW.glfwGetMouseButton((long)mc.method_22683().method_4490(), (int)n) == 1;
    }

    private long holderVal() {
        float f = Math.min(this.activeVal.tertiaryVal(), this.radiusVal.tertiaryVal());
        float f2 = Math.max(this.activeVal.tertiaryVal(), this.radiusVal.tertiaryVal());
        double d = f >= f2 ? (double)f : (double)f + ThreadLocalRandom.current().nextDouble() * (double)(f2 - f);
        if (d < 0.1) {
            d = 0.1;
        }
        return (long)(1000.0 / d);
    }

    private void timerVal() {
        this.extraRef.primaryVal();
        this.phaseVal.primaryVal();
        this.limitRef = this.holderVal();
        this.paramRef = this.holderVal();
    }
}

