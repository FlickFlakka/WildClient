/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2596
 *  net.minecraft.class_7472
 */
package ru.metaculture.protection;

import net.minecraft.class_2596;
import net.minecraft.class_7472;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.ServerProfileTracker;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="ChatHelper", secondaryVal="Updates chat settings", tertiaryVal=ModuleCategory.Misc)
public class ChatHelperModule
extends Module {
    public static final BoolSetting countVal = new BoolSetting("Anti-spam chat", true);
    public static final BoolSetting depthVal = new BoolSetting("Save chat", true);
    public static final BoolSetting descRef = new BoolSetting("Improved commands", true);
    public static final BoolSetting activeVal = new BoolSetting("Extended chat view ", true);

    public ChatHelperModule() {
        this.addSettings(countVal, depthVal, descRef, activeVal);
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        Object object;
        if (ChatHelperModule.mc.field_1724 == null) {
            return;
        }
        Object object3 = uvUUuvnunU2.marginVal();
        if (!(object3 instanceof class_7472)) {
            return;
        }
        class_7472 class_74722 = (class_7472)object3;
        String object2 = null;
        String string = class_74722.comp_808();
        String string2 = string.toLowerCase();
        int n = string2.indexOf("ah");
        int n2 = string2.indexOf(" me", n);
        if (n2 != -1 && n != -1) {
            object = ChatHelperModule.mc.field_1724.method_5477().getString();
            object2 = string.substring(0, n2) + " " + (String)object + string.substring(n2 + 3);
        }
        if (string2.startsWith("clan")) {
            object = new ServerProfileTracker();
            ((ServerProfileTracker)object).primaryVal();
            String string3 = ((ServerProfileTracker)object).paramVal();
            if (string2.endsWith(" all") || string2.contains(" all")) {
                object2 = string.replaceAll("(?i)\\ball\\b", string3);
            }
        }
        if (object2 != null) {
            uvUUuvnunU2.secondaryVal();
            ChatHelperModule.mc.field_1724.field_3944.method_52787((class_2596)new class_7472(object2));
        }
    }
}

