/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.TelegramNotifier;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="ClientUtil", tertiaryVal=ModuleCategory.Misc, secondaryVal="Client settings")
public class ClientUtilModule
extends Module {
    public static final BoolSetting countVal = new BoolSetting("Telegram notifications", true);
    public static final BoolSetting depthVal = new BoolSetting("Client sounds", true);
    public static SettingGroup descRef;
    public static FloatSetting activeVal;

    public ClientUtilModule() {
        Setting[] nvUuvVvuuNArray = new Setting[4];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        nvUuvVvuuNArray[2] = descRef;
        nvUuvVvuuNArray[3] = activeVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (countVal.tertiaryVal() && !TelegramNotifier.primaryVal()) {
            ChatLogger.primaryVal("§cThe list is empty for sending messages. Configure the API via .tapi");
            countVal.secondaryVal(false);
        }
    }

    static {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[2];
        vvNnnUNnVvnArray[0] = new BoolSetting("Modules", true);
        vvNnnUNnVvnArray[1] = new BoolSetting("Notifications", true).primaryVal(() -> !depthVal.tertiaryVal());
        descRef = new SettingGroup("Sounds", vvNnnUNnVvnArray);
        activeVal = new FloatSetting("Volume", 100.0f, 10.0f, 100.0f, 1.0f, false).primaryVal(() -> !depthVal.tertiaryVal());
    }
}

