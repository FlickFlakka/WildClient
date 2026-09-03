/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.List;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuUuVnVvnvn;
import ru.metaculture.protection.AutoPottBotModule;
import ru.metaculture.protection.AnimatedDouble;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.Easings;
import ru.metaculture.protection.HudLayoutManager;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.ThemeSettings;
import ru.metaculture.protection.HudSettingsPersistence;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.TextMeasureCache;
import ru.metaculture.protection.SettingHolder;
import ru.metaculture.protection.HudElementInfo;

@HudElementInfo(primaryVal="Brew Monitor", secondaryVal="i")
public final class BrewMonitorHud
extends ThemeSettings
implements MinecraftAccessor {
    private static final BrewMonitorHud primaryVal = new BrewMonitorHud();
    private static final AnimatedDouble limitRef = new AnimatedDouble();
    private static final int paramRef = 6;

    private BrewMonitorHud() {
        HudSettingsPersistence.primaryVal(this);
    }

    public static void primaryVal(Renderer2D heightVal) {
        primaryVal.secondaryVal(heightVal);
    }

    private void secondaryVal(Renderer2D heightVal) {
        if (BrewMonitorHud.a_.field_1724 == null || BrewMonitorHud.a_.field_1687 == null) {
            return;
        }
        limitRef.primaryVal();
        limitRef.primaryVal(AutoPottBotModule.countVal ? 1.0 : 0.0, 0.2f, Easings.timerVal, false);
        float f = limitRef.weightVal();
        if (f <= 0.01f) {
            return;
        }
        List<AutoPottBotModule.FingerprintCrypto> list = AutoPottBotModule.limitRef;
        List<String> list2 = AutoPottBotModule.paramRef;
        int[] nArray = AutoPottBotModule.phaseVal;
        int n = Math.min(list.size(), 6);
        float f2 = 252.0f;
        float f3 = 52.0f;
        float f4 = 32.0f;
        float f5 = 15.0f;
        float f6 = list2.isEmpty() ? 0.0f : 16.0f;
        float f7 = f3 + f4 + (float)n * f5 + f6 + 12.0f;
        HudLayoutManager.cursorVal panelVal = HudLayoutManager.primaryVal().primaryVal("HUD_BrewMonitor", 12.0f, 300.0f, f2, f7);
        float f8 = f * this.depthVal.tertiaryVal();
        float f9 = panelVal.secondaryVal;
        float f10 = panelVal.tertiaryVal;
        float f11 = panelVal.marginVal;
        float f12 = panelVal.weightVal;
        this.primaryVal(f9, f10, f11, f12);
        int n2 = this.weightVal(f8);
        int n3 = this.paramVal(f8);
        int n4 = AutoPottBotModule.countVal ? BrewMonitorHud.primaryVal(5954680, f8) : BrewMonitorHud.primaryVal(0x808088, f8);
        this.primaryVal(heightVal, f9, f10, f11, f12, 12.0f, f8);
        float f13 = 12.0f;
        heightVal.secondaryVal(f9 + f13 + 4.0f, f10 + 15.0f, 4.0f, 0.0f, 360.0f, n4);
        heightVal.primaryVal(FontRegistry.marginVal, f9 + f13 + 14.0f, f10 + 18.0f, 21.0f, "Brew Monitor", n2);
        String string = AutoPottBotModule.depthVal;
        float f14 = TextMeasureCache.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)14.0f).primaryVal;
        heightVal.primaryVal(FontRegistry.primaryVal, f9 + f11 - f13 - f14, f10 + 17.0f, 14.0f, string, n3);
        String string2 = "Brews " + AutoPottBotModule.descRef + "   brew " + AutoPottBotModule.activeVal + "   free " + AutoPottBotModule.radiusVal + "   ready " + AutoPottBotModule.factorVal + "   potions ≈ " + AutoPottBotModule.sourceVal;
        heightVal.primaryVal(FontRegistry.primaryVal, f9 + f13, f10 + 36.0f, 13.0f, string2, ColorUtil.primaryVal(n3, (int)(235.0f * f8)));
        float f15 = f10 + 54.0f;
        String string3 = "Water " + nArray[0] + "    Btl " + AutoPottBotModule.extraRef + "    Wart " + nArray[1] + "    Blaze " + nArray[2];
        String string4 = "Glow " + nArray[3] + "    Sugar " + nArray[4] + "    Magma " + nArray[5] + "    Redst " + nArray[6];
        heightVal.primaryVal(FontRegistry.primaryVal, f9 + f13, f15, 12.5f, string3, n3);
        heightVal.primaryVal(FontRegistry.primaryVal, f9 + f13, f15 += 14.0f, 12.5f, string4, n3);
        f15 += 18.0f;
        float f16 = 84.0f;
        float f17 = f9 + f11 - f13 - f16;
        for (int i = 0; i < n; ++i) {
            AutoPottBotModule.FingerprintCrypto unitC = list.get(i);
            heightVal.primaryVal(FontRegistry.primaryVal, f9 + f13, f15 + 1.0f, 12.5f, unitC.label(), n2);
            float f18 = f15 + 2.5f;
            float f19 = 4.0f;
            heightVal.primaryVal(f17, f18, f16, f19, f19 / 2.0f, BrewMonitorHud.primaryVal(0, f8 * 0.55f));
            float f20 = Math.max(0.0f, Math.min(1.0f, unitC.progress()));
            if (f20 > 0.001f) {
                heightVal.primaryVal(f17, f18, f16 * f20, f19, f19 / 2.0f, BrewMonitorHud.primaryVal(unitC.color(), f8));
            }
            f15 += f5;
        }
        if (!list2.isEmpty()) {
            String string5 = "Missing: " + String.join((CharSequence)", ", list2);
            heightVal.primaryVal(FontRegistry.primaryVal, f9 + f13, f15 + 2.0f, 12.5f, string5, BrewMonitorHud.primaryVal(16737392, f8));
        }
        HudLayoutManager.primaryVal().primaryVal(panelVal);
        UuUuVnVvnvn.primaryVal(heightVal, (SettingHolder)this, panelVal, HudLayoutManager.primaryVal(), (float)a_.method_22683().method_4486(), (float)a_.method_22683().method_4502());
    }

    private static int primaryVal(int n, float f) {
        int n2 = (int)(255.0f * Math.max(0.0f, Math.min(1.0f, f)));
        return ColorUtil.tertiaryVal(n >> 16 & 0xFF, n >> 8 & 0xFF, n & 0xFF, n2);
    }
}

