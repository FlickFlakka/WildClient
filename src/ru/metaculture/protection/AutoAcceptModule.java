/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2558$class_10609
 *  net.minecraft.class_2558$class_10610
 *  net.minecraft.class_2561
 *  net.minecraft.class_7439
 */
package ru.metaculture.protection;

import java.util.Arrays;
import java.util.List;
import net.minecraft.class_2558;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_7439;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WorldVariantDetector;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AutoAccept", tertiaryVal=ModuleCategory.Misc, secondaryVal="Automatically accepts teleport and clan requests")
public class AutoAcceptModule
extends Module {
    public final SettingGroup countVal = new SettingGroup("Accept", new BoolSetting("Teleport Request", true), new BoolSetting("Clan Request", true));
    public final ModeSetting depthVal = new ModeSetting("Accept TP from", "Friends", "Friends", "All").primaryVal(() -> !this.countVal.secondaryVal("Teleport Request"));
    public final BoolSetting descRef = new BoolSetting("Accept clan request only from friends", true).primaryVal(() -> !this.countVal.secondaryVal("Clan Request"));
    private boolean activeVal;
    private boolean radiusVal = false;
    private long factorVal = 0L;
    private final String[] sourceVal = new String[]{"has requested teleport", "asks to teleport", "wants to teleport to you", "asks to teleport to you"};
    private final String[] extraRef = new String[]{"invites you to clan", "invites you to clan", "invited you to clan"};

    public AutoAcceptModule() {
        Setting[] nvUuvVvuuNArray = new Setting[3];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        WorldVariantDetector.primaryVal();
        class_2596<?> class_25962 = uvUUuvnunU2.marginVal();
        if (class_25962 instanceof class_7439) {
            String string;
            class_7439 class_74392 = (class_7439)class_25962;
            class_2561 class_25612 = class_74392.comp_763();
            String string2 = class_25612.getString();
            if (this.radiusVal) {
                if (System.currentTimeMillis() - this.factorVal > 5000L) {
                    this.radiusVal = false;
                } else {
                    string = this.primaryVal(class_25612, "Join");
                    if (string != null) {
                        this.primaryVal(string);
                        this.radiusVal = false;
                        return;
                    }
                }
            }
            if (this.countVal.secondaryVal("Teleport Request") && this.tertiaryVal(string2)) {
                if (this.depthVal.secondaryVal("All")) {
                    this.activeVal = true;
                } else {
                    string = string2.toLowerCase();
                    for (String string3 : FriendCommand.marginVal()) {
                        if (!string.contains(string3.toLowerCase())) continue;
                        this.activeVal = true;
                        break;
                    }
                }
            }
            if (this.countVal.secondaryVal("Clan Request") && this.marginVal(string2)) {
                string = this.primaryVal(string2, "invites");
                if (string != null && !this.secondaryVal(string)) {
                    return;
                }
                String string4 = this.primaryVal(class_25612, "Join");
                if (string4 != null) {
                    this.primaryVal(string4);
                } else {
                    this.radiusVal = true;
                    this.factorVal = System.currentTimeMillis();
                }
            }
        }
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (this.activeVal && AutoAcceptModule.mc.field_1724 != null) {
            AutoAcceptModule.mc.field_1724.field_3944.method_45730("tpaccept");
            this.activeVal = false;
        }
    }

    private String primaryVal(class_2561 class_25612, String string) {
        List<class_2561> list;
        if (class_25612 == null) {
            return null;
        }
        if (class_25612.method_10866() != null && class_25612.method_10866().method_10970() != null) {
            class_2558 clickEvent = class_25612.method_10866().method_10970();
            if (class_25612.getString().contains(string)) {
                if (clickEvent instanceof class_2558.class_10609) {
                    class_2558.class_10609 class_106092 = (class_2558.class_10609)clickEvent;
                    return class_106092.comp_3506();
                }
                if (clickEvent instanceof class_2558.class_10610) {
                    class_2558.class_10610 class_106102 = (class_2558.class_10610)clickEvent;
                    return class_106102.comp_3507();
                }
            }
        }
        if ((list = class_25612.method_10855()) != null) {
            for (class_2561 class_25613 : list) {
                String string2 = this.primaryVal(class_25613, string);
                if (string2 == null) continue;
                return string2;
            }
        }
        return null;
    }

    private void primaryVal(String string) {
        block6: {
            block5: {
                if (AutoAcceptModule.mc.field_1724 == null) break block5;
                if (AutoAcceptModule.mc.field_1724.field_3944 != null) break block6;
            }
            return;
        }
        if (string.startsWith("/")) {
            AutoAcceptModule.mc.field_1724.field_3944.method_45730(string.substring(1));
        } else {
            AutoAcceptModule.mc.field_1724.field_3944.method_45730(string);
        }
    }

    private boolean secondaryVal(String string) {
        if (!this.descRef.tertiaryVal()) {
            return true;
        }
        return FriendCommand.primaryVal(string);
    }

    private String primaryVal(String string, String string2) {
        String string3 = string.replaceAll("\u00a7.", "");
        int n = string3.indexOf(string2);
        if (n <= 0) {
            return null;
        }
        String string4 = string3.substring(0, n).trim();
        int n2 = string4.lastIndexOf(32);
        if (n2 >= 0) {
            return string4.substring(n2 + 1).trim();
        }
        return string4.trim();
    }

    private boolean tertiaryVal(String string) {
        String string3 = string.toLowerCase();
        return Arrays.stream(this.sourceVal).anyMatch(string2 -> string3.contains(string2.toLowerCase()));
    }

    private boolean marginVal(String string) {
        String string3 = string.toLowerCase();
        return Arrays.stream(this.extraRef).anyMatch(string2 -> string3.contains(string2.toLowerCase()));
    }
}

