/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1294
 *  net.minecraft.class_2561
 */
package ru.metaculture.protection;

import net.minecraft.class_1294;
import net.minecraft.class_2561;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WorldVariantDetector;
import ru.metaculture.protection.PostWorldJoinEvent;
import ru.metaculture.protection.PlayerAttackEvent;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.AdaptiveCombatUtil;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="Sprint", secondaryVal="Hard to tell what this module does", tertiaryVal=ModuleCategory.Movement)
public class SprintModule
extends Module {
    public static ModeSetting countVal;
    public static BoolSetting depthVal;
    public static FloatSetting descRef;
    public final BoolSetting activeVal = new BoolSetting("Ignore hunger", false);
    public static int radiusVal;

    public SprintModule() {
        Setting[] nvUuvVvuuNArray = new Setting[4];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        nvUuvVvuuNArray[2] = descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(PlayerAttackEvent nnVUvuvVUnv) {
        block5: {
            block4: {
                if (SprintModule.mc.field_1724 == null) break block4;
                if (!SprintModule.mc.field_1724.method_6059(class_1294.field_5919)) break block5;
            }
            return;
        }
        if (depthVal.tertiaryVal()) {
            SprintModule.mc.field_1724.method_18800(SprintModule.mc.field_1724.method_18798().field_1352 / (double)descRef.tertiaryVal(), SprintModule.mc.field_1724.method_18798().field_1351, SprintModule.mc.field_1724.method_18798().field_1350 / (double)descRef.tertiaryVal());
            SprintModule.mc.field_1724.method_5728(true);
        }
    }

    @Subscribe
    public void primaryVal(PostWorldJoinEvent vaseE) {
        if (countVal.secondaryVal("Constant")) {
            radiusVal += 4;
        }
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        boolean bl;
        if (SprintModule.mc.field_1724 == null || SprintModule.mc.field_1687 == null) {
            return;
        }
        if (SprintModule.mc.field_1724.method_6059(class_1294.field_5919)) {
            SprintModule.mc.field_1724.method_5728(false);
            SprintModule.mc.field_1690.field_1867.method_23481(false);
            return;
        }
        if (countVal.secondaryVal("Constant")) {
            this.blockRef();
            return;
        }
        bl = SprintModule.mc.field_1724.field_5976 && !SprintModule.mc.field_1724.field_34927;
        if (radiusVal != 0) {
            SprintModule.mc.field_1724.method_5728(false);
            SprintModule.mc.field_1690.field_1867.method_23481(false);
            --radiusVal;
            return;
        }
        if (AdaptiveCombatUtil.secondaryVal(AttackAuraModule.tokenVal, AttackAuraModule.secondaryVal(AttackAuraModule.tokenVal))) {
            SprintModule.mc.field_1724.method_5728(false);
            SprintModule.mc.field_1690.field_1867.method_23481(false);
        }
        if (!SprintModule.mc.field_1724.method_5715() && !bl && SprintModule.mc.field_1690.field_1894.method_1434()) {
            SprintModule.mc.field_1724.method_5728(true);
            SprintModule.mc.field_1690.field_1867.method_23481(true);
        }
    }

    private void blockRef() {
        boolean bl;
        if (!SprintModule.mc.field_1724.method_5805()) {
            radiusVal += 2;
        }
        if (radiusVal != 0) {
            SprintModule.mc.field_1724.method_5728(false);
            SprintModule.mc.field_1690.field_1867.method_23481(false);
            --radiusVal;
            return;
        }
        boolean bl2 = AdaptiveCombatUtil.secondaryVal(AttackAuraModule.tokenVal, AttackAuraModule.secondaryVal(AttackAuraModule.tokenVal));
        if (bl2 && AttackAuraModule.levelVal.secondaryVal("Test")) {
            SprintModule.mc.field_1690.field_1867.method_23481(false);
            return;
        }
        if (bl2) {
            if (AttackAuraModule.levelVal.secondaryVal("Updated")) {
                SprintModule.mc.field_1724.method_5728(false);
                SprintModule.mc.field_1690.field_1867.method_23481(false);
                return;
            }
        }
        boolean bl3 = bl = SprintModule.mc.field_1724.method_5715() && !SprintModule.mc.field_1724.method_5681();
        if (bl) {
            return;
        }
        SprintModule.mc.field_1690.field_1867.method_23481(true);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        if (SprintModule.mc.field_1724 != null) {
            SprintModule.mc.field_1724.method_5728(false);
        }
    }

    @Override
    public void onEnable() {
        super.onEnable();
        if (this.activeVal.tertiaryVal() && !WorldVariantDetector.tertiaryVal() && SprintModule.mc.field_1724 != null) {
            SprintModule.mc.field_1724.method_7353(class_2561.method_30163((String)"§cThis setting only works on FunTime!"), true);
        }
    }

    static {
        String[] stringArray = new String[2];
        stringArray[0] = "Normal";
        stringArray[1] = "Constant";
        countVal = new ModeSetting("Mode", "Normal", stringArray);
        depthVal = new BoolSetting("Preserve sprint", false);
        descRef = new FloatSetting("Preservation strength", 0.6f, 0.2f, 1.0f, 0.1f, false).primaryVal(() -> !depthVal.tertiaryVal());
        radiusVal = 0;
    }
}

