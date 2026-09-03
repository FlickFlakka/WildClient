/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_7439
 */
package ru.metaculture.protection;

import net.minecraft.class_7439;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WorldVariantDetector;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="AutoAuth", secondaryVal="Auto register/login on servers", tertiaryVal=ModuleCategory.Misc)
public class AutoAuthModule
extends Module {
    public final StringFilterSetting countVal = new StringFilterSetting("Type your password here", "");

    public AutoAuthModule() {
        Setting[] nvUuvVvuuNArray = new Setting[1];
        nvUuvVvuuNArray[0] = this.countVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        if (WorldVariantDetector.primaryVal() || AutoAuthModule.mc.field_1687 == null) {
            return;
        }
        Object object = uvUUuvnunU2.marginVal();
        if (object instanceof class_7439) {
            class_7439 class_74392 = (class_7439)object;
            object = class_74392.comp_763().getString();
            String string = this.countVal.tertiaryVal();
            if ((((String)object).contains("Log in") || ((String)object).contains("/login")) && AutoAuthModule.mc.field_1724.field_3944 != null) {
                AutoAuthModule.mc.field_1724.field_3944.method_45730("login " + string);
            }
            if ((((String)object).contains("Register") || ((String)object).contains("/reg")) && string != null && string.length() >= 4) {
                if (AutoAuthModule.mc.field_1724.field_3944 != null) {
                    AutoAuthModule.mc.field_1724.field_3944.method_45730("reg " + string + " " + string);
                }
            }
        }
    }
}

