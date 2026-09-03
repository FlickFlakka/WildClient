/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import java.util.Locale;
import net.minecraft.class_3532;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuUuVnVvnvn;
import ru.metaculture.protection.AnimatedDouble;
import ru.metaculture.protection.AiRecorderStatus;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.VuUvvnuUu;
import ru.metaculture.protection.Easings;
import ru.metaculture.protection.HudLayoutManager;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.ThemeSettings;
import ru.metaculture.protection.HudSettingsPersistence;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.TextMeasureCache;
import ru.metaculture.protection.SettingHolder;
import ru.metaculture.protection.HudElementInfo;

@HudElementInfo(primaryVal="Neuro Monitor", secondaryVal="i")
public final class NeuroMonitorHudElement
extends ThemeSettings
implements MinecraftAccessor {
    private static final NeuroMonitorHudElement primaryVal = new NeuroMonitorHudElement();
    private static final AnimatedDouble limitRef = new AnimatedDouble();

    private NeuroMonitorHudElement() {
        HudSettingsPersistence.primaryVal(this);
    }

    public static void primaryVal(Renderer2D heightVal) {
        primaryVal.secondaryVal(heightVal);
    }

    private void secondaryVal(Renderer2D heightVal) {
        if (NeuroMonitorHudElement.a_.field_1724 == null || NeuroMonitorHudElement.a_.field_1687 == null) {
            return;
        }
        AiRecorderStatus vnUNuvv = VuUvvnuUu.limitRef();
        long l = System.currentTimeMillis();
        boolean bl = AttackAuraModule.descRef.secondaryVal("AI") || VuUvvnuUu.extraRef() || vnUNuvv.training() || l - vnUNuvv.updatedAtMs() < 4000L;
        limitRef.primaryVal();
        limitRef.primaryVal(bl ? 1.0 : 0.0, 0.2f, Easings.timerVal, false);
        float f = limitRef.weightVal();
        if (f <= 0.01f) {
            return;
        }
        float f2 = 306.0f;
        float f3 = 170.0f;
        float f4 = 12.0f;
        float f5 = 120.0f;
        HudLayoutManager.cursorVal panelVal = HudLayoutManager.primaryVal().primaryVal("HUD_NeuroMonitor", f4, f5, f2, f3);
        float f6 = f * this.depthVal.tertiaryVal();
        float f7 = panelVal.secondaryVal;
        float f8 = panelVal.tertiaryVal;
        float f9 = panelVal.marginVal;
        float f10 = panelVal.weightVal;
        this.primaryVal(f7, f8, f9, f10);
        int n = this.weightVal(f6);
        int n2 = this.paramVal(f6);
        int n3 = this.limitVal(f6);
        int n4 = ColorUtil.tertiaryVal(255, 156, 86, (int)(255.0f * f6));
        int n5 = this.primaryVal(vnUNuvv, f6);
        this.primaryVal(heightVal, f7, f8, f9, f10, 12.0f, f6);
        float f11 = 12.0f;
        heightVal.secondaryVal(f7 + f11 + 4.0f, f8 + 15.0f, 4.0f, 0.0f, 360.0f, n5);
        heightVal.primaryVal(FontRegistry.marginVal, f7 + f11 + 14.0f, f8 + 18.0f, 21.0f, "Neuro Monitor", n);
        String string = vnUNuvv.text();
        float f12 = TextMeasureCache.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)15.0f).primaryVal;
        heightVal.primaryVal(FontRegistry.primaryVal, f7 + f9 - f11 - f12, f8 + 17.0f, 15.0f, string, n2);
        String string2 = VuUvvnuUu.timerVal() < 0.0f ? "\u2014" : String.format(Locale.ROOT, "%.4f", Float.valueOf(VuUvvnuUu.timerVal()));
        Object[] objectArray = new Object[1];
        objectArray[0] = Float.valueOf(AttackAuraModule.radiusVal.tertiaryVal());
        String string3 = "Profile " + VuUvvnuUu.themeVal() + "   Pairs " + VuUvvnuUu.anchorVal() + "   Loss " + string2 + "   Jitter " + String.format(Locale.ROOT, "%.2f", objectArray);
        heightVal.primaryVal(FontRegistry.primaryVal, f7 + f11, f8 + 35.0f, 13.0f, string3, ColorUtil.primaryVal(n2, (int)(215.0f * f6)));
        float f13 = f7 + f11;
        float f14 = f9 - f11 * 2.0f;
        float f15 = 44.0f;
        float f16 = f8 + 50.0f;
        heightVal.primaryVal(FontRegistry.primaryVal, f13, f16, 13.0f, "Your style (dataset)", n2);
        this.primaryVal(heightVal, f13 + f14, f16, n3, n4, f6);
        this.primaryVal(heightVal, f13, f16 + 5.0f, f14, f15, VuUvvnuUu.blockRef(), VuUvvnuUu.holderVal(), -1, f6, n3, n4, "No recording — .ai train -> .ai learn");
        float f17 = f16 + 5.0f + f15 + 12.0f;
        String string4 = VuUvvnuUu.extraRef() ? "Your aim — recording (live)" : (VuUvvnuUu.depthVal() ? "Neural network — combat (live)" : "Live");
        heightVal.primaryVal(FontRegistry.primaryVal, f13, f17, 13.0f, string4, n2);
        this.primaryVal(heightVal, f13, f17 + 5.0f, f14, f15, VuUvvnuUu.limitVal(), VuUvvnuUu.speedVal(), VuUvvnuUu.widthVal(), f6, n3, n4, "Waiting...");
        HudLayoutManager.primaryVal().primaryVal(panelVal);
        UuUuVnVvnvn.primaryVal(heightVal, (SettingHolder)this, panelVal, HudLayoutManager.primaryVal(), (float)a_.method_22683().method_4486(), (float)a_.method_22683().method_4502());
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, int n, int n2, float f3) {
        float f4 = 12.0f;
        String string = "Pitch";
        String string2 = "Yaw";
        float f5 = TextMeasureCache.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)f4).primaryVal;
        float f6 = TextMeasureCache.primaryVal((FontObject)FontRegistry.primaryVal, (String)string2, (float)f4).primaryVal;
        float f7 = f - f5;
        heightVal.primaryVal(FontRegistry.primaryVal, f7, f2, f4, string, ColorUtil.primaryVal(n2, (int)(255.0f * f3)));
        float f8 = f7 - 10.0f - f6;
        heightVal.primaryVal(FontRegistry.primaryVal, f8, f2, f4, string2, ColorUtil.primaryVal(n, (int)(255.0f * f3)));
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float[] fArray, float[] fArray2, int n, float f5, int n2, int n3, String string) {
        float f6;
        float f7;
        heightVal.primaryVal(f, f2, f3, f4, 6.0f, ColorUtil.tertiaryVal(8, 10, 16, (int)(150.0f * f5)));
        if (this.weightVal()) {
            heightVal.primaryVal(f, f2, f3, f4, 6.0f, this.marginVal(f5), 1.0f);
        }
        float f8 = f2 + f4 * 0.5f;
        heightVal.primaryVal(f + 3.0f, f8 - 0.5f, f3 - 6.0f, 1.0f, ColorUtil.primaryVal(n2, (int)(40.0f * f5)));
        if (fArray == null || fArray2 == null || fArray.length == 0) {
            float f9 = TextMeasureCache.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)12.0f).primaryVal;
            heightVal.primaryVal(FontRegistry.primaryVal, f + (f3 - f9) * 0.5f, f8 + 4.0f, 12.0f, string, ColorUtil.tertiaryVal(150, 156, 170, (int)(185.0f * f5)));
            return;
        }
        int n4 = Math.min(fArray.length, fArray2.length);
        float f10 = 6.0f;
        for (int i = 0; i < n4; ++i) {
            f7 = Math.abs(fArray[i]);
            if (f7 > f10) {
                f10 = f7;
            }
            if (!((f6 = Math.abs(fArray2[i])) > f10)) continue;
            f10 = f6;
        }
        if (f10 > 35.0f) {
            f10 = 35.0f;
        }
        float f11 = f4 * 0.5f - 3.0f;
        f7 = f11 / f10;
        f6 = f3 / (float)n4;
        float f12 = Math.max(1.0f, f6 * 0.9f);
        int n5 = ColorUtil.primaryVal(n2, (int)(225.0f * f5));
        int n6 = ColorUtil.primaryVal(n3, (int)(150.0f * f5));
        for (int i = 0; i < n4; ++i) {
            int n7 = n < 0 ? i : (n + i) % n4;
            float f13 = f + (float)i * f6;
            float f14 = class_3532.method_15363((float)(fArray2[n7] * f7), (float)(-f11), (float)f11);
            if (f14 >= 0.0f) {
                heightVal.primaryVal(f13, f8 - f14, f12, f14, n6);
            } else {
                heightVal.primaryVal(f13, f8, f12, -f14, n6);
            }
            float f15 = class_3532.method_15363((float)(fArray[n7] * f7), (float)(-f11), (float)f11);
            if (f15 >= 0.0f) {
                heightVal.primaryVal(f13, f8 - f15, f12, f15, n5);
                continue;
            }
            heightVal.primaryVal(f13, f8, f12, -f15, n5);
        }
    }

    private int primaryVal(AiRecorderStatus vnUNuvv, float f) {
        block11: {
            block10: {
                String string;
                block9: {
                    block8: {
                        string = vnUNuvv.text().toLowerCase(Locale.ROOT);
                        if (string.contains("failed") || string.contains("error") || string.contains("missing") || string.contains("outdated")) {
                            return ColorUtil.tertiaryVal(255, 96, 112, (int)(255.0f * f));
                        }
                        if (vnUNuvv.training()) {
                            return ColorUtil.tertiaryVal(255, 198, 92, (int)(255.0f * f));
                        }
                        if (string.contains("recording")) break block8;
                        if (!string.contains("recording")) break block9;
                    }
                    return ColorUtil.tertiaryVal(92, 235, 182, (int)(255.0f * f));
                }
                if (string.contains("brain") || string.contains("ready")) break block10;
                if (!string.contains("replay")) break block11;
            }
            return ColorUtil.tertiaryVal(128, 226, 255, (int)(255.0f * f));
        }
        return this.limitVal(f);
    }
}

