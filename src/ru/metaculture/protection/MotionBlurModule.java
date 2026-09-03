/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.MotionBlurRenderer;

@ModuleRegister(primaryVal="MotionBlur", tertiaryVal=ModuleCategory.Visuals, secondaryVal="Physically based MotionBlur, greatly improves image smoothness.", marginVal={ModuleBadge.NEW})
public final class MotionBlurModule
extends Module {
    public final FloatSetting countVal = new FloatSetting("Smoothness", 0.68f, 0.0f, 1.0f, 0.01f, true);

    public MotionBlurModule() {
        this.addSettings(this.countVal);
    }

    @Override
    public void onEnable() {
        MotionBlurRenderer.primaryVal().secondaryVal();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        MotionBlurRenderer.primaryVal().secondaryVal();
    }

    public MotionBlurRenderer.cursorVal blockRef() {
        float f = Math.max(0.0f, Math.min(1.0f, this.countVal.tertiaryVal()));
        float f2 = f * f * (3.0f - 2.0f * f);
        MotionBlurRenderer.cursorVal panelVal = new MotionBlurRenderer.cursorVal();
        panelVal.primaryVal = 0.38f + f2 * 0.92f;
        panelVal.secondaryVal = 1.1f + f2 * 2.25f;
        panelVal.tertiaryVal = 5 + Math.round(f2 * 7.0f);
        panelVal.marginVal = 24.0f + f2 * 82.0f;
        panelVal.weightVal = 0.3f + f2 * 0.42f;
        panelVal.paramVal = 0.22f + f2 * 1.12f;
        panelVal.extraVal = 0.68f;
        panelVal.limitVal = 2.85f - f2 * 1.35f;
        panelVal.speedVal = 0.035f + (1.0f - f2) * 0.075f;
        return panelVal;
    }
}

