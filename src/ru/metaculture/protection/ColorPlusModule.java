/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ColorGradePreset;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="ColorPlus", tertiaryVal=ModuleCategory.Visuals, secondaryVal="World color grading — presets and fine tuning")
public class ColorPlusModule
extends Module {
    public final ModeSetting countVal = new ModeSetting("Preset", "Cinematic", ColorGradePreset.primaryVal());
    public final FloatSetting depthVal = new FloatSetting("Effect strength", 1.0f, 0.0f, 1.0f, 0.01f, true);
    public final BoolSetting descRef = new BoolSetting("Sharpness (CAS)", true);
    public final FloatSetting activeVal = new FloatSetting("Exposure", 0.0f, -0.5f, 0.5f, 0.01f, false);
    public final FloatSetting radiusVal = new FloatSetting("Contrast", 0.0f, -0.5f, 0.5f, 0.01f, false);
    public final FloatSetting factorVal = new FloatSetting("Saturation", 0.0f, -0.5f, 0.5f, 0.01f, false);
    public final FloatSetting sourceVal = new FloatSetting("Vibrance", 0.0f, -0.5f, 0.5f, 0.01f, false);
    public final FloatSetting extraRef = new FloatSetting("Gamma", 0.0f, -0.5f, 0.5f, 0.01f, false);
    public final FloatSetting phaseVal = new FloatSetting("Temperature", 0.0f, -0.5f, 0.5f, 0.01f, false);
    public final FloatSetting limitRef = new FloatSetting("Tint (green/magenta)", 0.0f, -0.5f, 0.5f, 0.01f, false);
    public final FloatSetting paramRef = new FloatSetting("Bloom intensity", 0.0f, -0.3f, 0.3f, 0.01f, false);
    public final FloatSetting groupVal = new FloatSetting("Sharpness strength", 0.0f, -0.3f, 0.3f, 0.01f, false);
    public final FloatSetting layerVal = new FloatSetting("Vignette", 0.0f, -0.3f, 0.3f, 0.01f, false);

    public ColorPlusModule() {
        Setting[] nvUuvVvuuNArray = new Setting[13];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        nvUuvVvuuNArray[5] = this.factorVal;
        nvUuvVvuuNArray[6] = this.sourceVal;
        nvUuvVvuuNArray[7] = this.extraRef;
        nvUuvVvuuNArray[8] = this.phaseVal;
        nvUuvVvuuNArray[9] = this.limitRef;
        nvUuvVvuuNArray[10] = this.paramRef;
        nvUuvVvuuNArray[11] = this.groupVal;
        nvUuvVvuuNArray[12] = this.layerVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    public ColorGradePreset blockRef() {
        return ColorGradePreset.primaryVal(this.countVal.tertiaryVal());
    }
}

