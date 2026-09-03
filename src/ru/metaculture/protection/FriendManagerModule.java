/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_239
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_3966
 */
package ru.metaculture.protection;

import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_239;
import net.minecraft.class_3966;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.Deadline;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.MouseButtonEvent;
import ru.metaculture.protection.SoundUtil;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="FriendManager", tertiaryVal=ModuleCategory.Misc, secondaryVal="Friends management manager")
public class FriendManagerModule
extends Module {
    public static KeybindSetting countVal = new KeybindSetting("Friends keybind", -1);
    public static BoolSetting depthVal = new BoolSetting("Don't hit friends", true);
    public static BoolSetting descRef = new BoolSetting("Remove friend's hitbox", true);
    private final Deadline activeVal = new Deadline();

    public FriendManagerModule() {
        Setting[] nvUuvVvuuNArray = new Setting[3];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        nvUuvVvuuNArray[2] = descRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(MouseButtonEvent spanD) {
        block7: {
            class_239 class_2392;
            block9: {
                block8: {
                    if (spanD.marginVal() != countVal.tertiaryVal() || spanD.paramVal() != 1 || !this.activeVal.marginVal(200L)) break block7;
                    if (AttackAuraModule.tokenVal != null) {
                        return;
                    }
                    class_2392 = FriendManagerModule.mc.field_1765;
                    if (class_2392 == null) break block8;
                    if (class_2392.method_17783() == class_239.class_240.field_1331) break block9;
                }
                return;
            }
            class_1297 class_12972 = ((class_3966)class_2392).method_17782();
            if (!(class_12972 instanceof class_1657)) {
                return;
            }
            class_1657 class_16572 = (class_1657)class_12972;
            String string = class_16572.method_5477().getString();
            String string2 = WildClient.primaryVal.paramRef();
            if (!FriendCommand.primaryVal(string)) {
                WildClient.primaryVal.phaseVal().primaryVal(string2 + "friend add " + string);
                SoundUtil.primaryVal("add", 0.5f);
            } else {
                WildClient.primaryVal.phaseVal().primaryVal(string2 + "friend remove " + string);
                SoundUtil.primaryVal("remove", 0.5f);
            }
            this.activeVal.primaryVal();
        }
    }
}

