/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1713
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1844
 *  net.minecraft.class_2596
 *  net.minecraft.class_2815
 *  net.minecraft.class_6880
 *  net.minecraft.class_9334
 */
package ru.metaculture.protection;

import java.util.ArrayDeque;
import java.util.Queue;
import net.minecraft.class_1268;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_2596;
import net.minecraft.class_2815;
import net.minecraft.class_6880;
import net.minecraft.class_9334;
import org.wild.mixin.acceser.ClientPlayerInteractionManagerAccessor;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AutoPotion", tertiaryVal=ModuleCategory.Player, secondaryVal="Automatically throws explosive potions under you")
public class AutoPotionModule
extends Module {
    public static AutoPotionModule countVal;
    public static boolean depthVal;
    public final SettingGroup descRef = new SettingGroup("What to buff: ", new BoolSetting("Strength", false), new BoolSetting("Speed", false), new BoolSetting("Fire Resistance", false));
    public final BoolSetting activeVal = new BoolSetting("Throw while looking down", false);
    private final BoolSetting radiusVal = new BoolSetting("Only in PVP", false);
    private final Queue<Integer> factorVal = new ArrayDeque<Integer>();
    private int sourceVal = -1;
    private boolean extraRef = false;
    private int phaseVal = 0;

    public AutoPotionModule() {
        countVal = this;
        this.addSettings(this.descRef, this.activeVal, this.radiusVal);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        int n;
        if (AutoPotionModule.mc.field_1724 == null || AutoPotionModule.mc.field_1687 == null || AutoPotionModule.mc.field_1761 == null) {
            return;
        }
        if (this.factorVal.isEmpty()) {
            if (depthVal) {
                this.timerVal();
            }
            if (this.phaseVal > 0) {
                --this.phaseVal;
                return;
            }
            if (this.radiusVal.tertiaryVal() && !this.holderVal()) {
                return;
            }
            if (this.activeVal.tertiaryVal() && AutoPotionModule.mc.field_1724.method_36455() < 80.0f) {
                return;
            }
            this.blockRef();
            return;
        }
        if (!depthVal) {
            depthVal = true;
            if (!this.activeVal.tertiaryVal()) {
                MouseLookOverride.tertiaryVal = AutoPotionModule.mc.field_1724.method_36454();
                MouseLookOverride.marginVal = AutoPotionModule.mc.field_1724.method_36455();
                MouseLookOverride.primaryVal = true;
            }
            if (this.sourceVal == -1) {
                this.sourceVal = AutoPotionModule.mc.field_1724.method_31548().method_67532();
            }
        }
        AutoPotionModule.mc.field_1690.field_1867.method_23481(false);
        AutoPotionModule.mc.field_1724.method_5728(false);
        if (!this.activeVal.tertiaryVal()) {
            AutoPotionModule.mc.field_1724.method_36457(90.0f);
        }
        if ((n = this.factorVal.poll().intValue()) < 9) {
            AutoPotionModule.mc.field_1724.method_31548().method_61496(n);
            ((ClientPlayerInteractionManagerAccessor)AutoPotionModule.mc.field_1761).invokeSyncSelectedSlot();
        } else {
            this.extraRef = true;
            AutoPotionModule.mc.field_1761.method_2906(AutoPotionModule.mc.field_1724.field_7498.field_7763, n, this.sourceVal, class_1713.field_7791, (class_1657)AutoPotionModule.mc.field_1724);
        }
        AutoPotionModule.mc.field_1761.method_2919((class_1657)AutoPotionModule.mc.field_1724, class_1268.field_5808);
        AutoPotionModule.mc.field_1724.method_6104(class_1268.field_5808);
        if (n < 9) {
            AutoPotionModule.mc.field_1724.method_31548().method_61496(this.sourceVal);
            ((ClientPlayerInteractionManagerAccessor)AutoPotionModule.mc.field_1761).invokeSyncSelectedSlot();
        } else {
            AutoPotionModule.mc.field_1761.method_2906(AutoPotionModule.mc.field_1724.field_7498.field_7763, n, this.sourceVal, class_1713.field_7791, (class_1657)AutoPotionModule.mc.field_1724);
        }
        if (this.factorVal.isEmpty()) {
            if (this.extraRef) {
                AutoPotionModule.mc.field_1724.field_3944.method_52787((class_2596)new class_2815(AutoPotionModule.mc.field_1724.field_7498.field_7763));
                this.extraRef = false;
            }
            this.phaseVal = 1;
            this.timerVal();
        }
    }

    private void blockRef() {
        boolean bl;
        boolean bl2 = this.descRef.secondaryVal("Strength") && !AutoPotionModule.mc.field_1724.method_6059(class_1294.field_5910);
        boolean bl3 = this.descRef.secondaryVal("Speed") && !AutoPotionModule.mc.field_1724.method_6059(class_1294.field_5904);
        boolean bl4 = bl = this.descRef.secondaryVal("Fire Resistance") && !AutoPotionModule.mc.field_1724.method_6059(class_1294.field_5918);
        if (!bl2 && !bl3) {
            if (!bl) {
                return;
            }
        }
        block0: for (int i = 0; i < 36; ++i) {
            class_1844 class_18442;
            class_1799 class_17992 = AutoPotionModule.mc.field_1724.method_31548().method_5438(i);
            if (class_17992.method_7960() || class_17992.method_7909() != class_1802.field_8436 || (class_18442 = (class_1844)class_17992.method_58694(class_9334.field_49651)) == null) continue;
            for (class_1293 class_12932 : class_18442.method_57397()) {
                class_6880 class_68802 = class_12932.method_5579();
                if (bl2 && class_68802.equals((Object)class_1294.field_5910)) {
                    this.factorVal.add(i);
                    bl2 = false;
                    continue block0;
                }
                if (bl3 && class_68802.equals((Object)class_1294.field_5904)) {
                    this.factorVal.add(i);
                    bl3 = false;
                    continue block0;
                }
                if (!bl || !class_68802.equals((Object)class_1294.field_5918)) continue;
                this.factorVal.add(i);
                bl = false;
                continue block0;
            }
        }
    }

    private boolean holderVal() {
        for (class_1657 class_16572 : AutoPotionModule.mc.field_1687.method_18456()) {
            if (class_16572 == AutoPotionModule.mc.field_1724) continue;
            if (!(AutoPotionModule.mc.field_1724.method_5858((class_1297)class_16572) <= 225.0)) continue;
            return true;
        }
        return false;
    }

    private void timerVal() {
        depthVal = false;
        this.sourceVal = -1;
        if (!this.activeVal.tertiaryVal()) {
            if (AutoPotionModule.mc.field_1724 != null) {
                AutoPotionModule.mc.field_1724.method_36456(MouseLookOverride.tertiaryVal);
                AutoPotionModule.mc.field_1724.method_36457(MouseLookOverride.marginVal);
            }
            MouseLookOverride.primaryVal = false;
        }
    }

    @Override
    public void onDisable() {
        this.factorVal.clear();
        this.timerVal();
        super.onDisable();
    }

    static {
        depthVal = false;
    }
}

