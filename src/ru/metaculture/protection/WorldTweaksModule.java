/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.awt.Color;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.PresetColorSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.RequiresRole;
import ru.metaculture.protection.RenderWorldLastEvent;
import ru.metaculture.protection.WorldEffectsRenderer;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.Subscribe;

@RequiresRole(tertiaryVal={"lichoday"})
@ModuleRegister(primaryVal="WorldTweaks", tertiaryVal=ModuleCategory.Visuals, secondaryVal="Cinematic atmosphere: wind, fog, sky tinting", marginVal={ModuleBadge.NEW})
public final class WorldTweaksModule
extends Module {
    public final FloatSetting countVal = new FloatSetting("Wind Speed", 0.72f, 0.0f, 2.0f, 0.01f, false);
    public final FloatSetting depthVal = new FloatSetting("Wind Direction", 35.0f, 0.0f, 360.0f, 1.0f, false);
    public final FloatSetting descRef = new FloatSetting("Fog Density", 0.032f, 0.0f, 0.1f, 0.001f, false);
    public final FloatSetting activeVal = new FloatSetting("Horizon Dissolve", 0.82f, 0.0f, 1.0f, 0.01f, true);
    public final FloatSetting radiusVal = new FloatSetting("Sky Lift", 0.64f, 0.0f, 1.0f, 0.01f, true);
    public final FloatSetting factorVal = new FloatSetting("Edge Softness", 0.72f, 0.0f, 1.0f, 0.01f, true);
    public final PresetColorSetting sourceVal = new PresetColorSetting("Atmosphere Tint", 6978453);

    public WorldTweaksModule() {
        Setting[] nvUuvVvuuNArray = new Setting[7];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        nvUuvVvuuNArray[5] = this.factorVal;
        nvUuvVvuuNArray[6] = this.sourceVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean blockRef() {
        if (WildClient.primaryVal == null) return false;
        if (WildClient.primaryVal.secondaryVal == null) {
            return false;
        }
        WorldTweaksModule peakE = WildClient.primaryVal.secondaryVal.primaryVal(WorldTweaksModule.class);
        if (peakE == null) return false;
        if (!peakE.enabled) return false;
        return true;
    }

    @Subscribe(priority=0)
    public void primaryVal(RenderWorldLastEvent partI) {
        block3: {
            block2: {
                if (partI == null || partI.tertiaryVal() == null || partI.tertiaryVal().field_1687 == null) break block2;
                if (partI.tertiaryVal().field_1724 != null && partI.weightVal() != null) break block3;
            }
            return;
        }
        WorldEffectsRenderer.cursorVal panelVal = new WorldEffectsRenderer.cursorVal();
        Color color = this.sourceVal.tertiaryVal();
        float f = (float)Math.toRadians(this.depthVal.tertiaryVal());
        panelVal.primaryVal = this.countVal.tertiaryVal();
        panelVal.secondaryVal = (float)Math.cos(f);
        panelVal.tertiaryVal = 0.0f;
        panelVal.marginVal = (float)Math.sin(f);
        panelVal.weightVal = this.descRef.tertiaryVal();
        panelVal.paramVal = this.activeVal.tertiaryVal();
        panelVal.extraVal = this.radiusVal.tertiaryVal();
        panelVal.limitVal = this.factorVal.tertiaryVal();
        panelVal.speedVal = (float)color.getRed() / 255.0f;
        panelVal.widthVal = (float)color.getGreen() / 255.0f;
        panelVal.chunkVal = (float)color.getBlue() / 255.0f;
        panelVal.anchorVal = ((float)partI.tertiaryVal().field_1687.method_8510() + partI.speedVal()) * 0.05f;
        WorldEffectsRenderer.primaryVal().primaryVal(partI.tertiaryVal(), partI.weightVal().primaryVal(), partI.extraVal(), partI.limitVal(), panelVal);
    }
}

