/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1304
 *  net.minecraft.class_1309
 *  net.minecraft.class_1421
 *  net.minecraft.class_1429
 *  net.minecraft.class_1480
 *  net.minecraft.class_1531
 *  net.minecraft.class_1569
 *  net.minecraft.class_1621
 *  net.minecraft.class_1646
 *  net.minecraft.class_1657
 *  net.minecraft.class_1802
 *  net.minecraft.class_1819
 *  net.minecraft.class_3489
 *  net.minecraft.class_3988
 *  net.minecraft.class_746
 */
package ru.metaculture.protection;

import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1421;
import net.minecraft.class_1429;
import net.minecraft.class_1480;
import net.minecraft.class_1531;
import net.minecraft.class_1569;
import net.minecraft.class_1621;
import net.minecraft.class_1646;
import net.minecraft.class_1657;
import net.minecraft.class_1802;
import net.minecraft.class_1819;
import net.minecraft.class_3489;
import net.minecraft.class_3988;
import net.minecraft.class_746;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.AntiBotModule;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.VuUVUvnU;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.AdaptiveCombatUtil;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="TriggerBot", secondaryVal="Hits an entity when aimed at it", tertiaryVal=ModuleCategory.Combat, marginVal={ModuleBadge.RISKY, ModuleBadge.GRIM})
public class TriggerBotModule
extends Module {
    public static FloatSetting countVal = new FloatSetting("Distance", 4.5f, 3.0f, 8.0f, 0.1f, false);
    public static SettingGroup depthVal;
    public static SettingGroup descRef;
    public static SettingGroup activeVal;
    public static FloatSetting radiusVal;
    public static FloatSetting factorVal;
    public static class_1309 sourceVal;
    private static long extraRef;
    private static boolean phaseVal;
    private static float limitRef;

    public TriggerBotModule() {
        Setting[] nvUuvVvuuNArray = new Setting[6];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        nvUuvVvuuNArray[2] = descRef;
        nvUuvVvuuNArray[3] = activeVal;
        nvUuvVvuuNArray[4] = radiusVal;
        nvUuvVvuuNArray[5] = factorVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    public static class_1309 blockRef() {
        return sourceVal;
    }

    @Override
    public void onDisable() {
        sourceVal = null;
        phaseVal = false;
        limitRef = 0.0f;
        extraRef = 0L;
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (TriggerBotModule.mc.field_1724 == null || TriggerBotModule.mc.field_1687 == null) {
            sourceVal = null;
            return;
        }
        this.holderVal();
        if (AttackAuraModule.anchorVal()) {
            return;
        }
        class_1309 class_13092 = this.timerVal();
        if (class_13092 == null) {
            return;
        }
        if (this.anchorVal()) {
            return;
        }
        float f = TriggerBotModule.primaryVal(class_13092);
        float[] fArray = new float[3];
        fArray[0] = f;
        fArray[1] = 0.0f;
        fArray[2] = f;
        float[] fArray2 = fArray;
        AdaptiveCombatUtil.primaryVal(class_13092, true, true, false);
        boolean bl = !activeVal.secondaryVal("Smart Crits");
        if (!AdaptiveCombatUtil.primaryVal(class_13092, false, true, bl, 0L, fArray2)) {
            return;
        }
        Runnable[] runnableArray = AdaptiveCombatUtil.primaryVal(class_13092, descRef.secondaryVal("Break Shield"));
        Runnable[] runnableArray2 = AdaptiveCombatUtil.primaryVal(true);
        Runnable[] runnableArray3 = AdaptiveCombatUtil.secondaryVal(false);
        Runnable runnable = () -> {
            runnableArray3[0].run();
            runnableArray2[0].run();
            runnableArray[0].run();
        };
        Runnable runnable2 = () -> {
            runnableArray[1].run();
            runnableArray2[1].run();
            runnableArray3[1].run();
        };
        if (descRef.secondaryVal("Shield Disable") && TriggerBotModule.mc.field_1724.method_6030().method_7909().equals(class_1802.field_8255)) {
            if (TriggerBotModule.mc.field_1724.method_6115()) {
                TriggerBotModule.mc.field_1761.method_2897((class_1657)TriggerBotModule.mc.field_1724);
            }
        }
        if (AdaptiveCombatUtil.primaryVal(class_13092, runnable, runnable2, class_1268.field_5808, true)) {
            sourceVal = class_13092;
        }
    }

    private void holderVal() {
        block5: {
            block4: {
                if (sourceVal == null) {
                    return;
                }
                if (!sourceVal.method_5805() || sourceVal.method_31481()) break block4;
                if (TriggerBotModule.mc.field_1724 == null) break block4;
                if (!(TriggerBotModule.mc.field_1724.method_5739((class_1297)sourceVal) > TriggerBotModule.primaryVal(sourceVal) + 2.0f)) break block5;
            }
            sourceVal = null;
        }
    }

    private class_1309 timerVal() {
        class_1309 class_13092 = null;
        double d = Double.MAX_VALUE;
        float f = TriggerBotModule.mc.field_1724.method_36454();
        float f2 = TriggerBotModule.mc.field_1724.method_36455();
        boolean bl = descRef.secondaryVal("Hit through blocks");
        Iterator iterator = TriggerBotModule.mc.field_1687.method_18112().iterator();
        while (iterator.hasNext()) {
            double d2;
            class_1309 class_13093;
            class_1297 class_12972 = (class_1297)iterator.next();
            if (!(class_12972 instanceof class_1309) || !this.secondaryVal(class_13093 = (class_1309)class_12972) || !VuUVUvnU.tertiaryVal(f, f2, TriggerBotModule.primaryVal(class_13093), (class_1297)class_13093, bl) || !((d2 = TriggerBotModule.mc.field_1724.method_5858((class_1297)class_13093)) < d)) continue;
            d = d2;
            class_13092 = class_13093;
        }
        return class_13092;
    }

    public static float primaryVal(class_1309 class_13092) {
        if (class_13092 == null) {
            return countVal.tertiaryVal();
        }
        float f = countVal.tertiaryVal();
        if (activeVal.secondaryVal("Advanced attack settings")) {
            float f2 = f = class_13092 instanceof class_1657 ? factorVal.tertiaryVal() : radiusVal.tertiaryVal();
        }
        if (activeVal.secondaryVal("Increased hit distance")) {
            float f3 = class_13092.method_6032() + class_13092.method_6067();
            if (f3 >= 10.0f && f3 <= 12.0f) {
                long l = System.currentTimeMillis();
                if (l >= extraRef) {
                    if (ThreadLocalRandom.current().nextInt(100) < 25) {
                        phaseVal = true;
                        limitRef = 0.1f + ThreadLocalRandom.current().nextFloat() * 0.05f;
                        extraRef = l + ThreadLocalRandom.current().nextLong(400L, 700L);
                    } else {
                        phaseVal = false;
                        limitRef = 0.0f;
                        extraRef = l + ThreadLocalRandom.current().nextLong(1500L, 2500L);
                    }
                }
                if (phaseVal) {
                    return f + limitRef;
                }
            } else {
                phaseVal = false;
                limitRef = 0.0f;
            }
        }
        return f;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean anchorVal() {
        if (TriggerBotModule.mc.field_1724.method_6115() && descRef.secondaryVal("Don't hit while eating")) {
            if (!(TriggerBotModule.mc.field_1724.method_6030().method_7909() instanceof class_1819)) return true;
        }
        if (TriggerBotModule.mc.field_1755 != null) {
            if (descRef.secondaryVal("Don't hit in containers ")) return true;
        }
        if (TriggerBotModule.mc.field_1724.method_6047().method_31573(class_3489.field_42611)) return false;
        if (TriggerBotModule.mc.field_1724.method_6047().method_31573(class_3489.field_42612)) return false;
        if (!descRef.secondaryVal("Hit only with weapon")) return false;
        return true;
    }

    private boolean secondaryVal(class_1309 class_13092) {
        boolean bl;
        if (class_13092 instanceof class_746 || class_13092 == TriggerBotModule.mc.field_1724) {
            return false;
        }
        if (!class_13092.method_5805() || class_13092.method_5655() || class_13092 instanceof class_1531) {
            return false;
        }
        if (TriggerBotModule.mc.field_1724.method_5739((class_1297)class_13092) > TriggerBotModule.primaryVal(class_13092)) {
            return false;
        }
        if (!descRef.secondaryVal("Hit through blocks") && !TriggerBotModule.mc.field_1724.method_6057((class_1297)class_13092)) {
            return false;
        }
        if (!depthVal.secondaryVal("NPC") && this.tertiaryVal(class_13092)) {
            return false;
        }
        if (class_13092 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_13092;
            if (class_16572.method_68878() || class_16572.method_7325()) {
                return false;
            }
            boolean bl2 = FriendCommand.primaryVal(class_16572.method_5477().getString());
            if (bl2 && !depthVal.secondaryVal("Friends")) {
                return false;
            }
            if (!bl2 && !depthVal.secondaryVal("Players")) {
                return false;
            }
            if (AntiBotModule.primaryVal(class_16572)) {
                return false;
            }
            boolean bl3 = !this.primaryVal(class_16572);
            boolean bl4 = class_16572.method_5767();
            if (bl4) {
                if (bl3) {
                    return depthVal.secondaryVal("Naked Invisibles");
                }
                return depthVal.secondaryVal("Invisibles");
            }
            return !bl3 || depthVal.secondaryVal("Naked");
        }
        boolean bl5 = class_13092 instanceof class_1569 || class_13092 instanceof class_1621;
        boolean bl6 = class_13092 instanceof class_1646 || class_13092 instanceof class_3988;
        bl = class_13092 instanceof class_1429 || class_13092 instanceof class_1646 || class_13092 instanceof class_1480 || class_13092 instanceof class_1421;
        if (bl5 && depthVal.secondaryVal("Mobs")) {
            return true;
        }
        if (bl6 && depthVal.secondaryVal("Villagers")) {
            return true;
        }
        if (bl && depthVal.secondaryVal("Animals")) {
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(class_1657 class_16572) {
        if (!class_16572.method_6118(class_1304.field_6169).method_7960()) return true;
        if (!class_16572.method_6118(class_1304.field_6174).method_7960()) return true;
        if (!class_16572.method_6118(class_1304.field_6172).method_7960()) return true;
        if (class_16572.method_6118(class_1304.field_6166).method_7960()) return false;
        return true;
    }

    private boolean tertiaryVal(class_1309 class_13092) {
        String string;
        String string2;
        String string3;
        String string4;
        block6: {
            block5: {
                string4 = this.secondaryVal(class_13092.method_5477().getString());
                string3 = this.secondaryVal(class_13092.method_5476().getString());
                String string5 = class_13092.method_5797() == null ? "" : this.secondaryVal(class_13092.method_5797().getString());
                string2 = "";
                string = "";
                if (class_13092.method_5781() != null) {
                    string2 = this.secondaryVal(class_13092.method_5781().method_1144().getString());
                    string = this.secondaryVal(class_13092.method_5781().method_1136().getString());
                }
                if (this.primaryVal(string4) || this.primaryVal(string3) || this.primaryVal(string5)) break block5;
                if (!this.primaryVal(string2) && !this.primaryVal(string)) break block6;
            }
            return true;
        }
        if (class_13092 instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_13092;
            boolean bl = mc.method_1562() != null && mc.method_1562().method_2871(class_16572.method_5667()) == null;
            boolean bl2 = string4.matches("\\d{1,8}") || string4.startsWith("cit-");
            return bl || bl2 && (!string3.equals(string4) || !string2.isEmpty() || !string.isEmpty());
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(String string) {
        if (string.contains("npc")) return true;
        if (string.contains("znpc")) return true;
        if (string.contains("npc")) return true;
        if (!string.contains("mentor")) return false;
        return true;
    }

    private String secondaryVal(String string) {
        if (string == null) {
            return "";
        }
        return string.replaceAll("(?i)\u00a7.", "").replaceAll("(?i)&.", "").replaceAll("\\p{Cntrl}", "").trim().toLowerCase(Locale.ROOT);
    }

    static {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[9];
        vvNnnUNnVvnArray[0] = new BoolSetting("Players", true);
        vvNnnUNnVvnArray[1] = new BoolSetting("Naked", true);
        vvNnnUNnVvnArray[2] = new BoolSetting("Invisibles", true);
        vvNnnUNnVvnArray[3] = new BoolSetting("Naked Invisibles", false);
        vvNnnUNnVvnArray[4] = new BoolSetting("Friends", false);
        vvNnnUNnVvnArray[5] = new BoolSetting("NPC", true);
        vvNnnUNnVvnArray[6] = new BoolSetting("Mobs", false);
        vvNnnUNnVvnArray[7] = new BoolSetting("Animals", false);
        vvNnnUNnVvnArray[8] = new BoolSetting("Villagers", false);
        depthVal = new SettingGroup("Targets", vvNnnUNnVvnArray);
        BoolSetting[] vvNnnUNnVvnArray2 = new BoolSetting[6];
        vvNnnUNnVvnArray2[0] = new BoolSetting("Hit through blocks", false);
        vvNnnUNnVvnArray2[1] = new BoolSetting("Hit only with weapon", false);
        vvNnnUNnVvnArray2[2] = new BoolSetting("Don't hit while eating", true);
        vvNnnUNnVvnArray2[3] = new BoolSetting("Don't hit in containers ", false);
        vvNnnUNnVvnArray2[4] = new BoolSetting("Break Shield", false);
        vvNnnUNnVvnArray2[5] = new BoolSetting("Shield Disable", false);
        descRef = new SettingGroup("Checks before hit", vvNnnUNnVvnArray2);
        BoolSetting[] vvNnnUNnVvnArray3 = new BoolSetting[3];
        vvNnnUNnVvnArray3[0] = new BoolSetting("Advanced attack settings", false);
        vvNnnUNnVvnArray3[1] = new BoolSetting("Smart Crits", false);
        vvNnnUNnVvnArray3[2] = new BoolSetting("Increased hit distance", false);
        activeVal = new SettingGroup("Additional settings", vvNnnUNnVvnArray3);
        radiusVal = new FloatSetting("Attack radius for mobs", 4.5f, 3.0f, 8.0f, 0.1f, false).primaryVal(() -> !activeVal.secondaryVal("Advanced attack settings"));
        factorVal = new FloatSetting("Attack radius for players", 4.5f, 3.0f, 8.0f, 0.1f, false).primaryVal(() -> !activeVal.secondaryVal("Advanced attack settings"));
        extraRef = 0L;
        phaseVal = false;
        limitRef = 0.0f;
    }
}

