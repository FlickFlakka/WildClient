/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import ru.metaculture.protection.SidebarNavShaderRenderer;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuUuVnVvnvn;
import ru.metaculture.protection.AnimatedDouble;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.Easings;
import ru.metaculture.protection.HudLayoutManager;
import ru.metaculture.protection.ThemeSettings;
import ru.metaculture.protection.HudSettingsPersistence;
import ru.metaculture.protection.AutoBuyModule;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.TextMeasureCache;
import ru.metaculture.protection.SettingHolder;
import ru.metaculture.protection.HudElementInfo;

@HudElementInfo(primaryVal="AutoBuyInfoHUD", secondaryVal="")
public final class AutoBuyInfoHudElement
extends ThemeSettings
implements MinecraftAccessor {
    private static final AutoBuyInfoHudElement primaryVal = new AutoBuyInfoHudElement();
    private static final AnimatedDouble limitRef = new AnimatedDouble();
    private static final AnimatedDouble paramRef = new AnimatedDouble();
    private static final AnimatedDouble groupVal = new AnimatedDouble();
    private static final List<StatRow> layerVal = new ArrayList<StatRow>(8);
    private static final SimpleDateFormat slotVal = new SimpleDateFormat("HH:mm:ss");

    private AutoBuyInfoHudElement() {
        HudSettingsPersistence.primaryVal(this);
    }

    public static void primaryVal(Renderer2D heightVal) {
        primaryVal.secondaryVal(heightVal);
    }

    public void secondaryVal(Renderer2D heightVal) {
        if (AutoBuyInfoHudElement.a_.field_1724 == null || AutoBuyModule.countVal == null) {
            return;
        }
        AutoBuyModule uuVUVN2 = AutoBuyModule.countVal;
        layerVal.clear();
        layerVal.add(new StatRow("Status", uuVUVN2.enabled ? "ON" : "OFF", uuVUVN2.enabled ? ColorUtil.tertiaryVal(100, 255, 140, 255) : ColorUtil.tertiaryVal(255, 90, 90, 255)));
        layerVal.add(new StatRow("Mode", uuVUVN2.radiusVal.tertiaryVal(), ColorUtil.tertiaryVal(120, 190, 255, 255)));
        layerVal.add(new StatRow("Time", AutoBuyInfoHudElement.secondaryVal(AutoBuyInfoHudElement.secondaryVal()), ColorUtil.tertiaryVal(255, 255, 255, 255)));
        layerVal.add(new StatRow("Deals", String.valueOf(AutoBuyModule.anchorVal()), ColorUtil.tertiaryVal(255, 190, 80, 255)));
        layerVal.add(new StatRow("Items", String.valueOf(AutoBuyModule.weightRef()), ColorUtil.tertiaryVal(255, 190, 80, 255)));
        layerVal.add(new StatRow("Spent", AutoBuyInfoHudElement.primaryVal(AutoBuyModule.bufferVal()), ColorUtil.tertiaryVal(255, 120, 120, 255)));
        layerVal.add(new StatRow("Balance", AutoBuyInfoHudElement.weightRef(), ColorUtil.tertiaryVal(160, 220, 255, 255)));
        layerVal.add(new StatRow("Payback", AutoBuyInfoHudElement.bufferVal(), AutoBuyModule.tokenVal > 0L ? ColorUtil.tertiaryVal(100, 255, 140, 255) : ColorUtil.tertiaryVal(180, 180, 180, 255)));
        limitRef.primaryVal();
        limitRef.primaryVal(1.0, 0.2f, Easings.timerVal, false);
        float f = limitRef.weightVal();
        if (f <= 0.01f) {
            return;
        }
        float f2 = 22.0f;
        float f3 = 7.0f;
        float f4 = 32.0f;
        float f5 = 22.0f;
        float f6 = 5.0f;
        float f7 = 28.0f;
        String string = "AutoBuy";
        float f8 = 0.0f;
        float f9 = 0.0f;
        Iterator<StatRow> iterator = layerVal.iterator();
        while (iterator.hasNext()) {
            StatRow modeVal = iterator.next();
            f8 = Math.max(f8, TextMeasureCache.secondaryVal(FontRegistry.primaryVal, modeVal.label(), f2));
            f9 = Math.max(f9, TextMeasureCache.secondaryVal(FontRegistry.primaryVal, modeVal.value(), f2));
        }
        float f10 = f8 + f9 + 20.0f + 22.0f;
        float f11 = TextMeasureCache.secondaryVal(FontRegistry.marginVal, string, f7) + 42.0f;
        float f12 = Math.max(f10, f11) + f3 * 2.0f;
        float f13 = (float)layerVal.size() * f5 + 10.0f;
        float f14 = f3 + f4 + f6 + f13 + f3;
        paramRef.primaryVal();
        groupVal.primaryVal();
        paramRef.primaryVal(f12, 0.18f, Easings.timerVal, false);
        groupVal.primaryVal(f14, 0.18f, Easings.timerVal, false);
        float f15 = paramRef.weightVal();
        float f16 = groupVal.weightVal();
        float f17 = 10.0f;
        float f18 = 155.0f;
        HudLayoutManager.cursorVal panelVal = HudLayoutManager.primaryVal().primaryVal("HUD_AutoBuyInfo", f17, f18, f15, f16);
        float f19 = panelVal.secondaryVal;
        float f20 = panelVal.tertiaryVal;
        float f21 = panelVal.marginVal;
        float f22 = panelVal.weightVal;
        this.primaryVal(f19, f20, f21, f22);
        float f23 = f21 / Math.max(1.0f, f15);
        float f24 = f22 / Math.max(1.0f, f16);
        float f25 = Math.min(f23, f24);
        float f26 = f3 * f23;
        float f27 = f3 * f24;
        float f28 = f4 * f24;
        float f29 = f5 * f24;
        float f30 = f2 * f25;
        float f31 = f * this.depthVal.tertiaryVal();
        int n = (int)(255.0f * f31);
        int n2 = this.primaryVal(f31);
        int n3 = this.secondaryVal(f31);
        int n4 = this.tertiaryVal(f31);
        int n5 = this.marginVal(f31);
        int n6 = ColorUtil.primaryVal(this.weightVal(1.0f), n);
        int n7 = ColorUtil.primaryVal(this.paramVal(1.0f), n);
        boolean bl = this.chunkVal();
        float f32 = 14.0f;
        float f33 = f21 - f26 * 2.0f;
        this.primaryVal(heightVal, f19, f20, f21, f22, f32, f31);
        if (bl) {
            this.primaryVal(heightVal, f19 + f26, f20 + f27, f33, f28, 11.0f, f31);
        } else {
            heightVal.primaryVal(f19 + f26, f20 + f27, f33, f28, 11.0f, 11.0f, 4.0f, 4.0f, n3);
        }
        heightVal.primaryVal(FontRegistry.marginVal, f19 + f26 + 10.0f * f23, f20 + f27 + f28 * 0.5f + 6.0f * f24, f7 * f25, string, n6);
        heightVal.tertiaryVal();
        float f34 = Math.min(f28, 32.0f * f25);
        SidebarNavShaderRenderer.primaryVal(f19 + f26 + f33 - 18.0f * f23 - f34 * 0.5f, f20 + f27 + f28 * 0.5f - f34 * 0.5f, f34, this.limitVal(1.0f), this.speedVal(1.0f), f31, this.timerVal());
        float f35 = f20 + f27 + f28 + f6 * f24;
        if (this.limitVal() || bl) {
            if (bl) {
                this.secondaryVal(heightVal, f19 + f26, f35, f33, f13 * f24, 8.0f, f31);
            } else {
                heightVal.primaryVal(f19 + f26, f35, f33, f13 * f24, 4.0f, 4.0f, 11.0f, 11.0f, n4);
            }
        }
        heightVal.primaryVal(f19, f20, f21, f22, f32, f32, f32, f32);
        float f36 = f35 + 5.0f * f24;
        for (StatRow modeVal : layerVal) {
            heightVal.primaryVal(FontRegistry.primaryVal, f19 + f26 + 10.0f * f23, f36 + f29 * 0.5f + 4.0f * f24, f30, modeVal.label(), n7);
            int n8 = ColorUtil.primaryVal(modeVal.color(), n);
            float f37 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, modeVal.value(), f30);
            heightVal.primaryVal(FontRegistry.primaryVal, f19 + f21 - f26 - 10.0f * f23 - f37, f36 + f29 * 0.5f + 4.0f * f24, f30, modeVal.value(), n8);
            f36 += f29;
        }
        heightVal.paramVal();
        HudLayoutManager.primaryVal().primaryVal(panelVal);
        UuUuVnVvnvn.primaryVal(heightVal, (SettingHolder)this, panelVal, HudLayoutManager.primaryVal(), (float)a_.method_22683().method_4486(), (float)a_.method_22683().method_4502());
    }

    private static long secondaryVal() {
        if (AutoBuyModule.VuunNUUUvu <= 0L) {
            return 0L;
        }
        return Math.max(0L, System.currentTimeMillis() - AutoBuyModule.VuunNUUUvu);
    }

    private static String weightRef() {
        block4: {
            block3: {
                if (AutoBuyModule.NNUUNUuVNNVn <= 0L) break block3;
                if (AutoBuyModule.VvVvnNUnvuvV > 0L) break block4;
            }
            return "N/A";
        }
        long l = AutoBuyModule.countVal();
        return AutoBuyInfoHudElement.primaryVal(AutoBuyModule.VvVvnNUnvuvV) + " (" + (l >= 0L ? "+" : "") + AutoBuyInfoHudElement.primaryVal(l) + ")";
    }

    private static String bufferVal() {
        if (AutoBuyModule.tokenVal > 0L) {
            if (AutoBuyModule.VuunNUUUvu > 0L) {
                return slotVal.format(new Date(AutoBuyModule.tokenVal)) + " (" + AutoBuyInfoHudElement.secondaryVal(AutoBuyModule.tokenVal - AutoBuyModule.VuunNUUUvu) + ")";
            }
        }
        if (AutoBuyModule.bufferVal() <= 0L) {
            return "-";
        }
        return "waiting";
    }

    private static String primaryVal(long l) {
        long l2 = Math.abs(l);
        String string = String.format(Locale.ROOT, "%,d", l2).replace(',', ' ') + "\u00a4";
        return l < 0L ? "-" + string : string;
    }

    private static String secondaryVal(long l) {
        long l2 = Math.max(0L, l / 1000L);
        long l3 = l2 / 3600L;
        long l4 = l2 % 3600L / 60L;
        long l5 = l2 % 60L;
        if (l3 > 0L) {
            Object[] objectArray = new Object[3];
            objectArray[0] = l3;
            objectArray[1] = l4;
            objectArray[2] = l5;
            return String.format(Locale.ROOT, "%d:%02d:%02d", objectArray);
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = l4;
        objectArray[1] = l5;
        return String.format(Locale.ROOT, "%02d:%02d", objectArray);
    }

    record StatRow(String label, String value, int color) {
    }
}

