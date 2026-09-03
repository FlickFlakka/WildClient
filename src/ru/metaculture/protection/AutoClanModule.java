/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_7439
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_640;
import net.minecraft.class_7439;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WorldVariantDetector;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.MouseButtonEvent;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="AutoClan", tertiaryVal=ModuleCategory.Misc, secondaryVal="Automatically creates a clan and also invites your friends to it (if any)")
public class AutoClanModule
extends Module {
    public final KeybindSetting countVal = new KeybindSetting("Keybind", -1);
    private WildClient depthVal = WildClient.IDLE;
    private int descRef = 0;
    private int activeVal = 0;
    private int radiusVal = 0;
    private List<String> factorVal = new ArrayList<String>();
    private static final String sourceVal = "abcdefghijklmnopqrstuvwxyz0123456789";

    public AutoClanModule() {
        this.addSettings(this.countVal);
    }

    @Subscribe
    public void primaryVal(MouseButtonEvent spanD) {
        if (WorldVariantDetector.primaryVal()) {
            return;
        }
        if (spanD.marginVal() == this.countVal.tertiaryVal()) {
            // empty if block
        }
    }

    private void blockRef() {
        if (AutoClanModule.mc.field_1724 == null) {
            return;
        }
        this.holderVal();
    }

    private void holderVal() {
        String string = this.timerVal();
        ChatLogger.primaryVal("§7Creating clan named: §f" + string);
        AutoClanModule.mc.field_1724.field_3944.method_45729("/clan create " + string);
        this.depthVal = WildClient.WAITING_CREATE_RESPONSE;
        this.descRef = 0;
    }

    private String timerVal() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int n = threadLocalRandom.nextInt(3, 6);
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 0; i < n; ++i) {
            stringBuilder.append(sourceVal.charAt(threadLocalRandom.nextInt(sourceVal.length())));
        }
        return stringBuilder.toString();
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        if (AutoClanModule.mc.field_1724 == null || this.depthVal == WildClient.IDLE) {
            return;
        }
        Object object = uvUUuvnunU2.marginVal();
        if (object instanceof class_7439) {
            class_7439 class_74392 = (class_7439)object;
            object = class_74392.comp_763().getString();
            this.primaryVal((String)object);
        }
    }

    private void primaryVal(String string) {
        if (this.depthVal == WildClient.WAITING_CREATE_RESPONSE) {
            if (string.contains("Error, a clan with this name already exists")) {
                ChatLogger.primaryVal("§cName taken, trying another...");
                this.descRef = 0;
                this.depthVal = WildClient.CREATING_CLAN;
                return;
            }
            if (string.contains("Great! You successfully created a clan")) {
                ChatLogger.primaryVal("§aClan successfully created!");
                this.anchorVal();
                return;
            }
            if (string.contains("Error: You are already in a clan")) {
                ChatLogger.primaryVal("§eYou are already in a clan, starting to invite friends...");
                this.anchorVal();
                return;
            }
        }
        if (this.depthVal == WildClient.INVITING_FRIENDS) {
            // empty if block
        }
    }

    private void anchorVal() {
        this.factorVal = this.weightRef();
        if (this.factorVal.isEmpty()) {
            ChatLogger.primaryVal("§cNo friends online on this server!");
            this.bufferVal();
            return;
        }
        ChatLogger.primaryVal("§aFound §l" + this.factorVal.size() + "§a friends online. Starting invites...");
        this.activeVal = 0;
        this.radiusVal = 0;
        this.depthVal = WildClient.INVITING_FRIENDS;
    }

    private List<String> weightRef() {
        ArrayList<String> arrayList = new ArrayList<String>();
        if (AutoClanModule.mc.field_1724 == null || mc.method_1562() == null) {
            return arrayList;
        }
        List<String> list = FriendCommand.marginVal();
        Collection<class_640> collection = mc.method_1562().method_2880();
        HashSet<String> hashSet = new HashSet<String>();
        for (class_640 object : collection) {
            if (object.method_2966() == null || object.method_2966().getName() == null) continue;
            hashSet.add(object.method_2966().getName());
        }
        String string = AutoClanModule.mc.field_1724.method_5477().getString();
        for (String string2 : list) {
            if (!hashSet.contains(string2) || string2.equalsIgnoreCase(string)) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        block10: {
            block9: {
                if (AutoClanModule.mc.field_1724 == null) break block9;
                if (this.depthVal != WildClient.IDLE) break block10;
            }
            return;
        }
        ++this.descRef;
        switch (this.depthVal.ordinal()) {
            case 1: {
                if (this.descRef <= 20) break;
                this.holderVal();
                break;
            }
            case 2: {
                if (this.descRef <= 100) break;
                ChatLogger.primaryVal("§cTimeout waiting for server response.");
                this.bufferVal();
                break;
            }
            case 3: {
                ++this.radiusVal;
                if (this.radiusVal < 25) break;
                this.radiusVal = 0;
                if (this.activeVal < this.factorVal.size()) {
                    String string = this.factorVal.get(this.activeVal);
                    AutoClanModule.mc.field_1724.field_3944.method_45730("clan invite " + string);
                    ChatLogger.primaryVal("§7Invite: §f" + string + " \u00a77(" + (this.activeVal + 1) + "/" + this.factorVal.size() + ")");
                    ++this.activeVal;
                    break;
                }
                ChatLogger.primaryVal("§aAll friends invited! (" + this.factorVal.size() + " pcs.)");
                this.bufferVal();
            }
        }
    }

    private void bufferVal() {
        this.depthVal = WildClient.IDLE;
        this.descRef = 0;
        this.activeVal = 0;
        this.radiusVal = 0;
        this.factorVal.clear();
    }

    @Override
    public void onDisable() {
        this.bufferVal();
        super.onDisable();
    }

    public enum WildClient {
    IDLE,
    CREATING_CLAN,
    WAITING_CREATE_RESPONSE,
    INVITING_FRIENDS;
}
}

