/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1304
 *  net.minecraft.class_1802
 *  net.minecraft.class_2596
 *  net.minecraft.class_2661
 *  net.minecraft.class_2678
 *  net.minecraft.class_2708
 *  net.minecraft.class_2724
 *  net.minecraft.class_2828
 *  net.minecraft.class_2828$class_5911
 *  net.minecraft.class_2848
 *  net.minecraft.class_2848$class_2849
 */
package ru.metaculture.protection;

import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1802;
import net.minecraft.class_2596;
import net.minecraft.class_2661;
import net.minecraft.class_2678;
import net.minecraft.class_2708;
import net.minecraft.class_2724;
import net.minecraft.class_2828;
import net.minecraft.class_2848;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.TimerModule;
import ru.metaculture.protection.Cooldown;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.PostClientTickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.MovementInputEvent;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="NoFall", tertiaryVal=ModuleCategory.Movement, secondaryVal="Prevents fall damage", marginVal={ModuleBadge.RISKY, ModuleBadge.GRIM})
public class NoFallModule
extends Module {
    private final ModeSetting countVal = new ModeSetting("Mode", "Grim v72", "Grim v72", "Grim v73");
    private final Cooldown depthVal = new Cooldown();
    private final Cooldown descRef = new Cooldown();
    private boolean activeVal;
    private boolean radiusVal;
    private boolean factorVal;
    private int sourceVal;
    private int extraRef;

    public NoFallModule() {
        this.addSettings(this.countVal);
    }

    @Subscribe
    public void primaryVal(PostClientTickEvent coreH) {
        if (NoFallModule.mc.field_1724 == null || NoFallModule.mc.field_1687 == null) {
            this.timerVal();
            return;
        }
        boolean bl = this.activeVal = NoFallModule.mc.field_1724.field_6017 > 3.0;
        if (this.countVal.secondaryVal("Grim v72")) {
            if (this.sourceVal > 0) {
                --this.sourceVal;
            }
            if (this.activeVal && !NoFallModule.mc.field_1724.method_24828() && this.blockRef() && NoFallModule.mc.field_1724.method_6118(class_1304.field_6174).method_31574(class_1802.field_8833) && this.descRef.primaryVal(200.0)) {
                this.holderVal();
                this.holderVal();
                this.descRef.primaryVal();
                this.radiusVal = true;
                this.depthVal.primaryVal();
            }
            if (this.depthVal.primaryVal(300.0)) {
                this.radiusVal = false;
                this.sourceVal = 0;
            }
            return;
        }
        if (this.extraRef == 2) {
            TimerModule.countVal = 0.5f;
        } else if (this.extraRef <= 1) {
            TimerModule.countVal = 1.0f;
        }
        if (this.extraRef > 0) {
            --this.extraRef;
        }
        if (this.depthVal.primaryVal(300.0)) {
            this.radiusVal = false;
            this.extraRef = 0;
        }
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        if (!uvUUuvnunU2.tertiaryVal()) {
            if (uvUUuvnunU2.marginVal() instanceof class_2678 || uvUUuvnunU2.marginVal() instanceof class_2661 || uvUUuvnunU2.marginVal() instanceof class_2724) {
                this.timerVal();
                return;
            }
            if (uvUUuvnunU2.marginVal() instanceof class_2708 && this.radiusVal) {
                if (this.countVal.secondaryVal("Grim v72")) {
                    this.sourceVal = 2;
                } else {
                    this.extraRef = 2;
                }
                this.radiusVal = false;
            }
            return;
        }
        if (NoFallModule.mc.field_1724 == null || this.factorVal) {
            return;
        }
        if (this.countVal.secondaryVal("Grim v72") && NoFallModule.mc.field_1724.method_6118(class_1304.field_6174).method_31574(class_1802.field_8833)) {
            return;
        }
        if (uvUUuvnunU2.marginVal() instanceof class_2828 && this.activeVal && this.blockRef() && this.extraRef == 0) {
            if (this.descRef.primaryVal(100.0)) {
                this.factorVal = true;
                mc.method_1562().method_52787((class_2596)new class_2828.class_5911(true, false));
                this.factorVal = false;
                uvUUuvnunU2.secondaryVal();
                this.descRef.primaryVal();
                this.depthVal.primaryVal();
                this.radiusVal = true;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Subscribe
    public void primaryVal(MovementInputEvent uNVVnVUNun2) {
        block5: {
            block4: {
                if (this.radiusVal || this.sourceVal == 2) break block4;
                if (this.extraRef != 2) break block5;
            }
            uNVVnVUNun2.primaryVal(false);
            return;
        }
        if (this.sourceVal != 1) {
            if (this.extraRef != 1) return;
        }
        uNVVnVUNun2.primaryVal(true);
    }

    private boolean blockRef() {
        double d = Math.min(-0.05, NoFallModule.mc.field_1724.method_18798().field_1351);
        return NoFallModule.mc.field_1687.method_20812((class_1297)NoFallModule.mc.field_1724, NoFallModule.mc.field_1724.method_5829().method_989(0.0, d, 0.0)).iterator().hasNext();
    }

    private void holderVal() {
        mc.method_1562().method_52787((class_2596)new class_2848((class_1297)NoFallModule.mc.field_1724, class_2848.class_2849.field_12982));
    }

    private void timerVal() {
        this.activeVal = false;
        this.radiusVal = false;
        this.factorVal = false;
        this.sourceVal = 0;
        this.extraRef = 0;
        TimerModule.countVal = 1.0f;
    }

    @Override
    public void onDisable() {
        this.timerVal();
        super.onDisable();
    }
}

