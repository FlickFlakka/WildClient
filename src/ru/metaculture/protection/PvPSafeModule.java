/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_345
 *  net.minecraft.class_642
 */
package ru.metaculture.protection;

import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.minecraft.class_310;
import net.minecraft.class_345;
import net.minecraft.class_642;
import org.wild.mixin.acceser.BossBarHudAccessor;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.AutoLeaveModule;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.ServerJoinerModule;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="PvPSafe", tertiaryVal=ModuleCategory.Misc, secondaryVal="Protects you from leaving while on cooldown")
public class PvPSafeModule
extends Module {
    private static final Set<String> countVal;
    private final SettingGroup depthVal;
    private final BoolSetting descRef;
    private long activeVal;

    public PvPSafeModule() {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[4];
        vvNnnUNnVvnArray[0] = new BoolSetting("FunTime", true);
        vvNnnUNnVvnArray[1] = new BoolSetting("HolyWorld", true);
        vvNnnUNnVvnArray[2] = new BoolSetting("SpookyTime", true);
        vvNnnUNnVvnArray[3] = new BoolSetting("Any other", true);
        this.depthVal = new SettingGroup("Server", vvNnnUNnVvnArray);
        this.descRef = new BoolSetting("Notifications", true);
        this.addSettings(this.depthVal, this.descRef);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (!this.timerVal()) {
            return;
        }
        this.primaryVal(AutoLeaveModule.class);
        this.primaryVal(ServerJoinerModule.class);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean blockRef() {
        PvPSafeModule uvuuunvnNNUU = PvPSafeModule.bufferVal();
        if (uvuuunvnNNUU == null) return false;
        if (!uvuuunvnNNUU.timerVal()) return false;
        return true;
    }

    public static boolean holderVal() {
        return PvPSafeModule.primaryVal(class_310.method_1551());
    }

    public static boolean primaryVal(String string) {
        if (string == null) {
            return false;
        }
        String string2 = string.trim();
        if (!string2.startsWith("/")) {
            return false;
        }
        return PvPSafeModule.secondaryVal(string2.substring(1));
    }

    public static boolean secondaryVal(String string) {
        boolean bl;
        if (string == null) {
            return false;
        }
        String string2 = PvPSafeModule.paramVal(string);
        if (string2.isEmpty()) {
            return false;
        }
        String string3 = string2.split("\\s+", 2)[0];
        boolean bl2 = bl = countVal.contains(string3) || string3.matches("an\\d{1,5}");
        if (!bl) {
            return false;
        }
        return PvPSafeModule.marginVal("command /" + string2);
    }

    public static boolean tertiaryVal(boolean bl) {
        return PvPSafeModule.marginVal(bl ? "server transfer" : "disconnect");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean timerVal() {
        if (!this.enabled) return false;
        if (PvPSafeModule.mc.field_1724 == null) return false;
        if (PvPSafeModule.mc.field_1687 == null) {
            return false;
        }
        if (!this.anchorVal()) return false;
        if (!PvPSafeModule.primaryVal(mc)) return false;
        return true;
    }

    private boolean anchorVal() {
        block10: {
            block9: {
                String string;
                block8: {
                    block7: {
                        string = this.weightRef();
                        if (string.contains("funtime") || string.contains("fun-time")) {
                            return this.depthVal.secondaryVal("FunTime");
                        }
                        if (string.contains("holyworld") || string.contains("holy-world")) break block7;
                        if (!string.contains("holy")) break block8;
                    }
                    return this.depthVal.secondaryVal("HolyWorld");
                }
                if (string.contains("spookytime") || string.contains("spooky-time")) break block9;
                if (!string.contains("spooky")) break block10;
            }
            return this.depthVal.secondaryVal("SpookyTime");
        }
        return this.depthVal.secondaryVal("Any other");
    }

    private String weightRef() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null) {
            return "";
        }
        class_642 class_6422 = class_3102.method_1558();
        return class_6422 == null || class_6422.field_3761 == null ? "" : class_6422.field_3761.toLowerCase(Locale.ROOT);
    }

    private static boolean primaryVal(class_310 class_3102) {
        if (class_3102 == null || class_3102.field_1705 == null || class_3102.field_1705.method_1740() == null) {
            return false;
        }
        Map<UUID, class_345> map = ((BossBarHudAccessor)class_3102.field_1705.method_1740()).getBossBars();
        for (class_345 class_3452 : map.values()) {
            String string = PvPSafeModule.extraVal(class_3452.method_5414().getString());
            if (!PvPSafeModule.tertiaryVal(string)) continue;
            return true;
        }
        return false;
    }

    private static boolean tertiaryVal(String string) {
        return string.contains("pvp") || string.contains("pvp") || string.contains("combat") || string.contains("fight") || string.contains("battle") || string.contains("combat mode") || string.contains("in combat") || string.contains("until exit") || string.contains("cannot leave") || string.contains("don't leave");
    }

    private static boolean marginVal(String string) {
        PvPSafeModule uvuuunvnNNUU = PvPSafeModule.bufferVal();
        if (uvuuunvnNNUU == null || !uvuuunvnNNUU.timerVal()) {
            return false;
        }
        uvuuunvnNNUU.weightVal(string);
        return true;
    }

    private void weightVal(String string) {
        if (!this.descRef.tertiaryVal()) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.activeVal < 1200L) {
            return;
        }
        this.activeVal = l;
        ChatLogger.primaryVal("[PvPSafe] blocked " + string);
    }

    private static String paramVal(String string) {
        String string2 = string.trim().toLowerCase(Locale.ROOT);
        while (string2.startsWith("/")) {
            string2 = string2.substring(1).trim();
        }
        return string2.replaceAll("\\s+", " ");
    }

    private static String extraVal(String string) {
        return string == null ? "" : string.replaceAll("(?i)\u00a7[0-9a-fk-or]", "").toLowerCase(Locale.ROOT).trim();
    }

    private static PvPSafeModule bufferVal() {
        if (!WildClient.groupVal() || WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return null;
        }
        return WildClient.primaryVal.secondaryVal.primaryVal(PvPSafeModule.class);
    }

    private <T extends Module> void primaryVal(Class<T> clazz) {
        T t = WildClient.primaryVal.secondaryVal.primaryVal(clazz);
        if (t != null && ((Module)t).enabled) {
            ((Module)t).setEnabled(false);
        }
    }

    static {
        String[] stringArray = new String[18];
        stringArray[0] = "hub";
        stringArray[1] = "lobby";
        stringArray[2] = "spawn";
        stringArray[3] = "leave";
        stringArray[4] = "quit";
        stringArray[5] = "disconnect";
        stringArray[6] = "server";
        stringArray[7] = "servers";
        stringArray[8] = "an";
        stringArray[9] = "anarchy";
        stringArray[10] = "realm";
        stringArray[11] = "menu";
        stringArray[12] = "logout";
        stringArray[13] = "reconnect";
        stringArray[14] = "play";
        stringArray[15] = "warp";
        stringArray[16] = "duel";
        stringArray[17] = "l";
        countVal = Set.of(stringArray);
    }
}

