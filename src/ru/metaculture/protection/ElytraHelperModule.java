/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1713
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2596
 *  net.minecraft.class_2815
 */
package ru.metaculture.protection;

import net.minecraft.class_1268;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2596;
import net.minecraft.class_2815;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.InputFreezeManager;
import ru.metaculture.protection.InventoryUtil;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.MouseButtonEvent;
import ru.metaculture.protection.ServerProfileTracker;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="ElytraHelper", secondaryVal="Automatically uses fireworks/swaps to elytra", tertiaryVal=ModuleCategory.Player)
public class ElytraHelperModule
extends Module {
    public static ElytraHelperModule countVal;
    public static KeybindSetting depthVal;
    public static KeybindSetting descRef;
    public final BoolSetting activeVal = new BoolSetting("Swap on cooldown", false);
    private int radiusVal = 0;
    private int factorVal = 0;
    private int sourceVal = -1;
    private int extraRef = -1;
    private boolean phaseVal = false;

    public ElytraHelperModule() {
        this.addSettings(depthVal, descRef, this.activeVal);
        countVal = this;
    }

    @Subscribe
    private void primaryVal(MouseButtonEvent spanD) {
        int n;
        if (spanD.paramVal() != 1 || ElytraHelperModule.mc.field_1724 == null) {
            return;
        }
        if (!(spanD.marginVal() != depthVal.tertiaryVal() || this.radiusVal != 0 || ElytraHelperModule.mc.field_1724.method_6115() && ElytraHelperModule.mc.field_1724.method_6079().method_7909() != class_1802.field_8255)) {
            int n2;
            class_1799 class_17992 = ElytraHelperModule.mc.field_1724.method_6118(class_1304.field_6174);
            int n3 = n2 = class_17992.method_7909() == class_1802.field_8833 ? this.depthVal() : InventoryUtil.primaryVal(class_1802.field_8833);
            if (n2 >= 0) {
                this.sourceVal = n2;
                this.phaseVal = false;
                this.radiusVal = 1;
                this.anchorVal();
            }
        }
        if (spanD.marginVal() == descRef.tertiaryVal() && this.radiusVal == 0 && (n = InventoryUtil.primaryVal(class_1802.field_8639)) != -1) {
            this.sourceVal = n;
            this.phaseVal = true;
            this.radiusVal = 1;
            this.anchorVal();
        }
    }

    @Subscribe
    private void primaryVal(TickEvent nVunNNvuv2) {
        if (ElytraHelperModule.mc.field_1724 == null || ElytraHelperModule.mc.field_1755 != null) {
            this.countVal();
            return;
        }
        if (this.radiusVal > 0) {
            if (this.factorVal > 0) {
                --this.factorVal;
                return;
            }
            this.anchorVal();
            return;
        }
        if (this.activeVal.tertiaryVal()) {
            int n;
            boolean bl;
            boolean bl2 = bl = ElytraHelperModule.mc.field_1724.method_6118(class_1304.field_6174).method_7909() == class_1802.field_8833;
            if (bl && ServerProfileTracker.secondaryVal() && (n = this.depthVal()) != -1) {
                this.sourceVal = n;
                this.phaseVal = false;
                this.radiusVal = 1;
                this.anchorVal();
            }
        }
    }

    private void anchorVal() {
        if (this.phaseVal) {
            this.weightRef();
        } else {
            this.bufferVal();
        }
    }

    private void weightRef() {
        switch (this.radiusVal) {
            case 1: {
                InputFreezeManager.primaryVal().primaryVal("ElytraHelper_FW");
                if (ElytraHelperModule.mc.field_1724.method_5624()) {
                    ElytraHelperModule.mc.field_1724.method_5728(false);
                }
                this.radiusVal = 2;
                this.factorVal = 1;
                break;
            }
            case 2: {
                this.extraRef = ElytraHelperModule.mc.field_1724.method_31548().method_67532();
                if (this.sourceVal < 9) {
                    InventoryUtil.primaryVal(this.sourceVal);
                } else {
                    ElytraHelperModule.mc.field_1761.method_2906(ElytraHelperModule.mc.field_1724.field_7498.field_7763, this.sourceVal, this.extraRef, class_1713.field_7791, (class_1657)ElytraHelperModule.mc.field_1724);
                }
                this.radiusVal = 3;
                this.factorVal = 1;
                break;
            }
            case 3: {
                ElytraHelperModule.mc.field_1761.method_2919((class_1657)ElytraHelperModule.mc.field_1724, class_1268.field_5808);
                ElytraHelperModule.mc.field_1724.method_6104(class_1268.field_5808);
                this.radiusVal = 4;
                this.factorVal = 1;
                break;
            }
            case 4: {
                if (this.sourceVal < 9) {
                    InventoryUtil.primaryVal(this.extraRef);
                } else {
                    ElytraHelperModule.mc.field_1761.method_2906(ElytraHelperModule.mc.field_1724.field_7498.field_7763, this.sourceVal, this.extraRef, class_1713.field_7791, (class_1657)ElytraHelperModule.mc.field_1724);
                }
                InputFreezeManager.primaryVal().secondaryVal("ElytraHelper_FW");
                this.radiusVal = 0;
            }
        }
    }

    private void bufferVal() {
        switch (this.radiusVal) {
            case 1: {
                InputFreezeManager.primaryVal().primaryVal("ElytraHelper");
                if (ElytraHelperModule.mc.field_1724.method_5624()) {
                    ElytraHelperModule.mc.field_1724.method_5728(false);
                }
                this.radiusVal = 2;
                this.factorVal = 1;
                break;
            }
            case 2: {
                InventoryUtil.primaryVal(this.sourceVal, 6);
                if (mc.method_1562() != null) {
                    mc.method_1562().method_52787((class_2596)new class_2815(ElytraHelperModule.mc.field_1724.field_7498.field_7763));
                }
                this.radiusVal = 3;
                this.factorVal = 1;
                break;
            }
            case 3: {
                InputFreezeManager.primaryVal().secondaryVal("ElytraHelper");
                this.radiusVal = 0;
            }
        }
    }

    private void countVal() {
        if (this.radiusVal > 0) {
            InputFreezeManager.primaryVal().secondaryVal(this.phaseVal ? "ElytraHelper_FW" : "ElytraHelper");
        }
        this.radiusVal = 0;
        this.factorVal = 0;
        this.sourceVal = -1;
    }

    private int depthVal() {
        class_1792[] class_1792Array;
        class_1792[] class_1792Array2 = new class_1792[6];
        class_1792Array2[0] = class_1802.field_22028;
        class_1792Array2[1] = class_1802.field_8058;
        class_1792Array2[2] = class_1802.field_8873;
        class_1792Array2[3] = class_1802.field_8678;
        class_1792Array2[4] = class_1802.field_8523;
        class_1792Array2[5] = class_1802.field_8577;
        class_1792[] class_1792Array3 = class_1792Array = class_1792Array2;
        int n = class_1792Array3.length;
        for (int i = 0; i < n; ++i) {
            class_1792 class_17922 = class_1792Array3[i];
            int n2 = InventoryUtil.primaryVal(class_17922);
            if (n2 == -1) continue;
            return n2;
        }
        return -1;
    }

    public static boolean blockRef() {
        if (ElytraHelperModule.mc.field_1724 == null || ElytraHelperModule.mc.field_1761 == null) {
            return false;
        }
        if (ElytraHelperModule.mc.field_1724.method_6118(class_1304.field_6174).method_7909() == class_1802.field_8833) {
            return true;
        }
        int n = InventoryUtil.primaryVal(class_1802.field_8833);
        if (n == -1) {
            return false;
        }
        InventoryUtil.primaryVal(n, 6);
        if (mc.method_1562() != null) {
            mc.method_1562().method_52787((class_2596)new class_2815(ElytraHelperModule.mc.field_1724.field_7498.field_7763));
        }
        return true;
    }

    public static boolean holderVal() {
        class_1792[] class_1792Array;
        if (ElytraHelperModule.mc.field_1724 == null || ElytraHelperModule.mc.field_1761 == null) {
            return false;
        }
        class_1792[] class_1792Array2 = new class_1792[6];
        class_1792Array2[0] = class_1802.field_22028;
        class_1792Array2[1] = class_1802.field_8058;
        class_1792Array2[2] = class_1802.field_8523;
        class_1792Array2[3] = class_1802.field_8873;
        class_1792Array2[4] = class_1802.field_8678;
        class_1792Array2[5] = class_1802.field_8577;
        class_1792[] class_1792Array3 = class_1792Array = class_1792Array2;
        int n = class_1792Array3.length;
        for (int i = 0; i < n; ++i) {
            class_1792 class_17922 = class_1792Array3[i];
            int n2 = InventoryUtil.primaryVal(class_17922);
            if (n2 == -1) continue;
            InventoryUtil.primaryVal(n2, 6);
            if (mc.method_1562() != null) {
                mc.method_1562().method_52787((class_2596)new class_2815(ElytraHelperModule.mc.field_1724.field_7498.field_7763));
            }
            return true;
        }
        return false;
    }

    public static boolean timerVal() {
        return ElytraHelperModule.primaryVal(class_1802.field_8639);
    }

    private static boolean primaryVal(class_1792 class_17922) {
        boolean bl;
        block9: {
            block8: {
                if (ElytraHelperModule.mc.field_1724 == null) break block8;
                if (ElytraHelperModule.mc.field_1761 != null) break block9;
            }
            return false;
        }
        int n = InventoryUtil.primaryVal(class_17922);
        if (n == -1) {
            return false;
        }
        int n2 = ElytraHelperModule.mc.field_1724.method_31548().method_67532();
        boolean bl2 = bl = n >= 36 && n <= 44;
        if (bl) {
            InventoryUtil.primaryVal(n - 36);
        } else {
            ElytraHelperModule.mc.field_1761.method_2906(ElytraHelperModule.mc.field_1724.field_7498.field_7763, n, n2, class_1713.field_7791, (class_1657)ElytraHelperModule.mc.field_1724);
        }
        ElytraHelperModule.mc.field_1761.method_2919((class_1657)ElytraHelperModule.mc.field_1724, class_1268.field_5808);
        ElytraHelperModule.mc.field_1724.method_6104(class_1268.field_5808);
        if (bl) {
            InventoryUtil.primaryVal(n2);
        } else {
            ElytraHelperModule.mc.field_1761.method_2906(ElytraHelperModule.mc.field_1724.field_7498.field_7763, n, n2, class_1713.field_7791, (class_1657)ElytraHelperModule.mc.field_1724);
        }
        return true;
    }

    @Override
    public void onDisable() {
        this.countVal();
        super.onDisable();
    }

    static {
        depthVal = new KeybindSetting("Swap to chestplate", -1);
        descRef = new KeybindSetting("Firework", -1);
    }
}

