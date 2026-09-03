/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_437
 *  net.minecraft.class_5498
 */
package ru.metaculture.protection;

import net.minecraft.class_437;
import net.minecraft.class_5498;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.WorldVariantDetector;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.MouseButtonEvent;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="FreeLock", tertiaryVal=ModuleCategory.Misc, secondaryVal="Third-person view")
public class FreeLockModule
extends Module {
    private final ModeSetting countVal;
    private final KeybindSetting depthVal;
    private class_5498 descRef;

    public FreeLockModule() {
        String[] stringArray = new String[2];
        stringArray[0] = "By holding";
        stringArray[1] = "By keybind";
        this.countVal = new ModeSetting("Mode", "By holding", stringArray);
        this.depthVal = new KeybindSetting("Keybind", -1, true);
        Setting[] nvUuvVvuuNArray = new Setting[2];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    public boolean blockRef() {
        return this.descRef != null;
    }

    @Subscribe
    public void primaryVal(MouseButtonEvent spanD) {
        if (WorldVariantDetector.primaryVal()) {
            return;
        }
        if (this.primaryVal(FreeLockModule.mc.field_1755)) {
            this.timerVal();
            return;
        }
        if (spanD.marginVal() != this.depthVal.tertiaryVal()) {
            return;
        }
        boolean bl = KeybindSetting.secondaryVal(this.depthVal.tertiaryVal());
        if (this.countVal.secondaryVal("By holding")) {
            if (bl && this.descRef == null) {
                this.holderVal();
            } else if (!bl && this.descRef != null) {
                this.timerVal();
            }
        } else if (this.countVal.secondaryVal("By keybind") && bl) {
            if (this.descRef != null) {
                this.timerVal();
            } else {
                this.holderVal();
            }
        }
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (this.primaryVal(FreeLockModule.mc.field_1755)) {
            this.timerVal();
        }
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.timerVal();
    }

    private void holderVal() {
        if (WorldVariantDetector.primaryVal() || this.primaryVal(FreeLockModule.mc.field_1755)) {
            return;
        }
        AttackAuraModule coreB = WildClient.primaryVal.secondaryVal.primaryVal(AttackAuraModule.class);
        if (coreB != null && coreB.enabled) {
            ChatLogger.primaryVal("Disable the aura to use free look");
            return;
        }
        if (FreeLockModule.mc.field_1690 == null) {
            return;
        }
        this.descRef = FreeLockModule.mc.field_1690.method_31044();
        FreeLockModule.mc.field_1690.method_31043(class_5498.field_26665);
        MouseLookOverride.tertiaryVal = FreeLockModule.mc.field_1773.method_19418().method_19330();
        MouseLookOverride.marginVal = FreeLockModule.mc.field_1773.method_19418().method_19329();
        MouseLookOverride.secondaryVal = true;
        MouseLookOverride.primaryVal = true;
    }

    private void timerVal() {
        if (this.descRef == null) {
            return;
        }
        if (FreeLockModule.mc.field_1690 != null) {
            FreeLockModule.mc.field_1690.method_31043(this.descRef);
        }
        this.descRef = null;
        MouseLookOverride.secondaryVal = false;
        MouseLookOverride.primaryVal = false;
    }

    private boolean primaryVal(class_437 class_4372) {
        return class_4372 != null;
    }
}

