/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1792
 *  net.minecraft.class_1802
 */
package ru.metaculture.protection;

import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AutoDrop", tertiaryVal=ModuleCategory.Misc, secondaryVal="Automatically drops junk")
public class AutoDropModule
extends Module {
    public static boolean countVal = false;
    private final BoolSetting depthVal = new BoolSetting("Stone", false);
    private final BoolSetting descRef = new BoolSetting("Cobblestone", false);
    private final BoolSetting activeVal = new BoolSetting("Granite", false);
    private final BoolSetting radiusVal = new BoolSetting("Sticks", false);
    private final BoolSetting factorVal = new BoolSetting("Tuff", false);
    private final BoolSetting sourceVal = new BoolSetting("Andesite", false);
    private final BoolSetting extraRef = new BoolSetting("Netherrack", false);
    private final BoolSetting phaseVal = new BoolSetting("Basalt", false);
    private final BoolSetting limitRef = new BoolSetting("Blackstone", false);
    private final BoolSetting paramRef = new BoolSetting("Soul Blocks", false);
    private final BoolSetting groupVal = new BoolSetting("Nether Ores", false);
    private final BoolSetting layerVal = new BoolSetting("Gravel", false);
    private int slotVal = 9;
    private final VuNvNNvVV themeVal = new VuNvNNvVV();

    public AutoDropModule() {
        Setting[] nvUuvVvuuNArray = new Setting[12];
        nvUuvVvuuNArray[0] = this.depthVal;
        nvUuvVvuuNArray[1] = this.descRef;
        nvUuvVvuuNArray[2] = this.activeVal;
        nvUuvVvuuNArray[3] = this.radiusVal;
        nvUuvVvuuNArray[4] = this.factorVal;
        nvUuvVvuuNArray[5] = this.sourceVal;
        nvUuvVvuuNArray[6] = this.extraRef;
        nvUuvVvuuNArray[7] = this.phaseVal;
        nvUuvVvuuNArray[8] = this.limitRef;
        nvUuvVvuuNArray[9] = this.paramRef;
        nvUuvVvuuNArray[10] = this.groupVal;
        nvUuvVvuuNArray[11] = this.layerVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        countVal = false;
        this.blockRef();
    }

    private void blockRef() {
        if (this.slotVal > 44) {
            this.slotVal = 9;
            return;
        }
        class_1735 class_17352 = AutoDropModule.mc.field_1724.field_7498.method_7611(this.slotVal);
        if (!class_17352.method_7681()) {
            ++this.slotVal;
            return;
        }
        class_1792 class_17922 = class_17352.method_7677().method_7909();
        if (this.primaryVal(class_17922)) {
            countVal = true;
            int n = AutoDropModule.mc.field_1724.field_7498.field_7763;
            AutoDropModule.mc.field_1761.method_2906(n, this.slotVal, 1, class_1713.field_7795, (class_1657)AutoDropModule.mc.field_1724);
            ++this.slotVal;
        } else {
            ++this.slotVal;
        }
    }

    private boolean primaryVal(class_1792 class_17922) {
        if (class_17922 == class_1802.field_20391) {
            if (this.depthVal.tertiaryVal()) {
                return true;
            }
        }
        if (class_17922 == class_1802.field_20412 && this.descRef.tertiaryVal()) {
            return true;
        }
        if (class_17922 == class_1802.field_20394 && this.activeVal.tertiaryVal()) {
            return true;
        }
        if (class_17922 == class_1802.field_8600 && this.radiusVal.tertiaryVal()) {
            return true;
        }
        if (class_17922 == class_1802.field_20407 && this.sourceVal.tertiaryVal()) {
            return true;
        }
        if ((class_17922 == class_1802.field_28866 || class_17922 == class_1802.field_29025) && this.factorVal.tertiaryVal()) {
            return true;
        }
        if (class_17922 == class_1802.field_8328 && this.extraRef.tertiaryVal()) {
            return true;
        }
        if ((class_17922 == class_1802.field_22000 || class_17922 == class_1802.field_29024 || class_17922 == class_1802.field_23069) && this.phaseVal.tertiaryVal()) {
            return true;
        }
        if ((class_17922 == class_1802.field_23843 || class_17922 == class_1802.field_23847) && this.limitRef.tertiaryVal()) {
            return true;
        }
        if ((class_17922 == class_1802.field_8067 || class_17922 == class_1802.field_21999) && this.paramRef.tertiaryVal()) {
            return true;
        }
        if ((class_17922 == class_1802.field_8702 || class_17922 == class_1802.field_23140 || class_17922 == class_1802.field_8155 || class_17922 == class_1802.field_8397) && this.groupVal.tertiaryVal()) {
            return true;
        }
        return class_17922 == class_1802.field_8110 && this.layerVal.tertiaryVal();
    }
}

