/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.VuVNuVvVn;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;

@ModuleRegister(primaryVal="AspectRation", secondaryVal="Changes screen resolution", tertiaryVal=ModuleCategory.Visuals)
public class AspectRationModule
extends Module {
    public static final ModeSetting countVal;
    public static final FloatSetting depthVal;

    public AspectRationModule() {
        Setting[] nvUuvVvuuNArray = new Setting[2];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    public static float blockRef() {
        VuVNuVvVn peakA = new VuVNuVvVn(mc);
        if (!WildClient.primaryVal.secondaryVal.secondaryVal(AspectRationModule.class).enabled) {
            return 0.0f;
        }
        float f = (float)peakA.tertiaryVal() / (float)peakA.marginVal();
        float f2 = switch (countVal.tertiaryVal()) {
            case "16:9" -> 1.7777778f;
            case "4:3" -> 1.3333334f;
            case "1:1" -> 1.0f;
            case "16:10" -> 1.6f;
            case "21:9" -> 2.3333333f;
            case "32:9" -> 3.5555556f;
            case "5:4" -> 1.25f;
            case "2:1" -> 2.0f;
            default -> depthVal.tertiaryVal();
        };
        return f2 - f;
    }

    static {
        String[] stringArray = new String[9];
        stringArray[0] = "16:9";
        stringArray[1] = "4:3";
        stringArray[2] = "1:1";
        stringArray[3] = "16:10";
        stringArray[4] = "21:9";
        stringArray[5] = "32:9";
        stringArray[6] = "5:4";
        stringArray[7] = "2:1";
        stringArray[8] = "Custom";
        countVal = new ModeSetting("Screen aspect ratio", "16:9", stringArray);
        depthVal = new FloatSetting("Custom value", 2.0f, 1.0f, 3.0f, 0.1f, false).primaryVal(() -> !countVal.secondaryVal("Custom"));
    }
}

