/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_3532
 *  net.minecraft.class_437
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_437;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.RenderHudEvent;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.AimStatsSnapshot;
import ru.metaculture.protection.AnimatedDouble;
import ru.metaculture.protection.VuUvvnuUu;
import ru.metaculture.protection.Easings;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.TextMeasureCache;
import ru.metaculture.protection.Subscribe;

public final class AimLabScreen
extends class_437 {
    private static volatile boolean primaryVal;
    private static final String[] secondaryVal;
    private static final float tertiaryVal = 52.0f;
    private static final float marginVal = 28.0f;
    private static final float weightVal = 30.0f;
    private static final float paramVal = 28.0f;
    private static final float extraVal = 28.0f;
    private static final float limitVal = 24.0f;
    private static final float speedVal = 22.0f;
    private static final float widthVal = 28.0f;
    private final AnimatedDouble chunkVal = new AnimatedDouble();
    private final List<cursorVal> blockRef = new ArrayList<cursorVal>();
    private final List<AccessGuardException> holderVal = new ArrayList<AccessGuardException>();
    private float timerVal;
    private float anchorVal;
    private float weightRef = 1.0f;
    private float bufferVal;
    private float countVal;
    private boolean depthVal;
    private int descRef;
    private AccessGuardException activeVal;
    private AimStatsSnapshot radiusVal;
    private long factorVal;
    private WildClient sourceVal = new WildClient(0.0f, 0.0f, 0.0f, 0.0f);
    private WildClient extraRef = new WildClient(0.0f, 0.0f, 0.0f, 0.0f);
    private final WildClient[] phaseVal;

    public AimLabScreen() {
        super((class_2561)class_2561.method_43470((String)"AI Lab"));
        WildClient[] mossA = new WildClient[3];
        mossA[0] = new WildClient(0.0f, 0.0f, 0.0f, 0.0f);
        mossA[1] = new WildClient(0.0f, 0.0f, 0.0f, 0.0f);
        mossA[2] = new WildClient(0.0f, 0.0f, 0.0f, 0.0f);
        this.phaseVal = mossA;
        AimLabScreen.tertiaryVal();
        this.primaryVal();
    }

    private void primaryVal() {
        this.radiusVal = VuUvvnuUu.paramVal();
        this.factorVal = System.currentTimeMillis();
    }

    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        this.primaryVal(this.primaryVal((double)n), this.secondaryVal((double)n2));
        super.method_25394(class_3322, n, n2, f);
    }

    public void method_25420(class_332 class_3322, int n, int n2, float f) {
    }

    public void method_52752(class_332 class_3322) {
    }

    public void primaryVal(Renderer2D heightVal, int n, int n2) {
        float f;
        block10: {
            block9: {
                if (heightVal == null) break block9;
                if (n > 0 && n2 > 0) break block10;
            }
            return;
        }
        this.marginVal();
        long l = System.currentTimeMillis();
        if (!VuUvvnuUu.extraRef() && l - this.factorVal > 2000L) {
            this.primaryVal();
        }
        this.chunkVal.primaryVal();
        this.chunkVal.primaryVal(this.depthVal ? 0.0 : 1.0, this.depthVal ? (double)0.18f : (double)0.22f, this.depthVal ? Easings.holderVal : Easings.themeVal, false);
        float f2 = AimLabScreen.primaryVal(this.chunkVal.weightVal(), 0.0f, 1.0f);
        heightVal.primaryVal(0.0f, 0.0f, (float)n, (float)n2, 0.0f, AimLabScreen.primaryVal(0, 0, 0, Math.round(170.0f * f2)));
        heightVal.weightVal(f2);
        this.weightRef = f = (0.97f + 0.03f * f2) * 0.9f;
        this.bufferVal = (float)n * 0.5f;
        this.countVal = (float)n2 * 0.5f;
        heightVal.tertiaryVal(f, f, (float)n * 0.5f, (float)n2 * 0.5f);
        float f3 = AimLabScreen.primaryVal((float)n - 80.0f, 900.0f, 1120.0f);
        float f4 = AimLabScreen.primaryVal((float)n2 - 70.0f, 600.0f, 780.0f);
        float f5 = ((float)n - f3) * 0.5f;
        float f6 = ((float)n2 - f4) * 0.5f;
        this.sourceVal = new WildClient(f5, f6, f3, f4);
        heightVal.primaryVal(20.0f);
        heightVal.primaryVal(f5, f6, f3, f4, 18.0f, 1.0f);
        heightVal.primaryVal(f5, f6, f3, f4, 18.0f, AimLabScreen.primaryVal(13, 15, 21, 186));
        heightVal.primaryVal(f5, f6, f3, f4, 18.0f, AimLabScreen.primaryVal(255, 255, 255, 26), 2.0f);
        this.blockRef.clear();
        this.holderVal.clear();
        this.primaryVal(heightVal);
        this.secondaryVal(heightVal);
        float f7 = f5 + 24.0f;
        float f8 = f6 + 170.0f;
        float f9 = f3 - 48.0f;
        float f10 = f4 - 170.0f - 24.0f;
        switch (this.descRef) {
            case 1: {
                this.secondaryVal(heightVal, f7, f8, f9, f10);
                break;
            }
            case 2: {
                this.tertiaryVal(heightVal, f7, f8, f9, f10);
                break;
            }
            default: {
                this.primaryVal(heightVal, f7, f8, f9, f10);
            }
        }
        heightVal.speedVal();
        heightVal.widthVal();
        if (this.depthVal && f2 <= 0.015f) {
            class_310.method_1551().execute(() -> {
                if (class_310.method_1551().field_1755 == this) {
                    class_310.method_1551().method_1507(null);
                }
            });
        }
    }

    private void primaryVal(Renderer2D heightVal) {
        float f = this.sourceVal.primaryVal + 24.0f;
        heightVal.primaryVal(FontRegistry.marginVal, f, this.sourceVal.secondaryVal + 54.0f, 52.0f, "AI Lab", AimLabScreen.primaryVal(245, 248, 255, 246));
        String string = "Profile " + VuUvvnuUu.themeVal() + "  \u2022  " + VuUvvnuUu.paramRef();
        heightVal.primaryVal(FontRegistry.primaryVal, f, this.sourceVal.secondaryVal + 88.0f, 28.0f, string, AimLabScreen.primaryVal(150, 160, 178, 220));
        float f2 = 44.0f;
        this.extraRef = new WildClient(this.sourceVal.primaryVal + this.sourceVal.tertiaryVal - f2 - 18.0f, this.sourceVal.secondaryVal + 18.0f, f2, f2);
        boolean bl = this.extraRef.primaryVal(this.timerVal, this.anchorVal);
        heightVal.primaryVal(this.extraRef.primaryVal, this.extraRef.secondaryVal, f2, f2, 10.0f, AimLabScreen.primaryVal(bl ? 235 : 40, bl ? 80 : 44, bl ? 92 : 52, bl ? 235 : 150));
        this.primaryVal(heightVal, "X", this.extraRef, 30.0f, AimLabScreen.primaryVal(245, 245, 250, 240));
    }

    private void secondaryVal(Renderer2D heightVal) {
        float f = this.sourceVal.primaryVal + 24.0f;
        float f2 = this.sourceVal.secondaryVal + 108.0f;
        float f3 = 200.0f;
        float f4 = 46.0f;
        for (int i = 0; i < secondaryVal.length; ++i) {
            WildClient modeVal = new WildClient(f + (float)i * (f3 + 10.0f), f2, f3, f4);
            this.phaseVal[i] = modeVal;
            boolean bl = this.descRef == i;
            boolean bl2 = modeVal.primaryVal(this.timerVal, this.anchorVal);
            int n = bl ? AimLabScreen.primaryVal(96, 150, 240, 210) : AimLabScreen.primaryVal(255, 255, 255, bl2 ? 26 : 14);
            heightVal.primaryVal(modeVal.primaryVal, modeVal.secondaryVal, modeVal.tertiaryVal, modeVal.marginVal, 10.0f, n);
            this.primaryVal(heightVal, secondaryVal[i], modeVal, 30.0f, bl ? AimLabScreen.primaryVal(255, 255, 255, 246) : AimLabScreen.primaryVal(180, 188, 204, 220));
        }
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4) {
        AimStatsSnapshot vNVuNNvvuNnu;
        block3: {
            block2: {
                vNVuNNvvuNnu = this.radiusVal;
                if (vNVuNNvvuNnu == null) break block2;
                if (vNVuNNvvuNnu.primaryVal) break block3;
            }
            this.secondaryVal(heightVal, f, f2, f3, f4, "No recording. Go to Training -> Record tab, then come back.");
            return;
        }
        Object[] objectArray = new Object[1];
        objectArray[0] = Float.valueOf(vNVuNNvvuNnu.limitVal);
        heightVal.primaryVal(FontRegistry.primaryVal, f, f2 + 22.0f, 28.0f, "Frames " + vNVuNNvvuNnu.tertiaryVal + "   Hits " + vNVuNNvvuNnu.marginVal + "   Misses " + Math.round(vNVuNNvvuNnu.extraVal * 100.0f) + "%   Sensitivity " + String.format(Locale.ROOT, "%.2f", objectArray) + "   Dist " + AimLabScreen.tertiaryVal(vNVuNNvvuNnu.speedVal) + "-" + AimLabScreen.tertiaryVal(vNVuNNvvuNnu.widthVal) + "m", AimLabScreen.primaryVal(200, 208, 222, 230));
        float f5 = (f3 - 18.0f) * 0.5f;
        float f6 = f2 + 44.0f;
        float f7 = (f4 - 44.0f - 18.0f) * 0.5f - 9.0f;
        this.primaryVal(heightVal, f, f6, f5, f7, vNVuNNvvuNnu);
        this.secondaryVal(heightVal, f + f5 + 18.0f, f6, f5, f7, vNVuNNvvuNnu);
        float f8 = f6 + f7 + 18.0f;
        this.primaryVal(heightVal, f, f8, f5, f7, "Yaw deltas", vNVuNNvvuNnu.countVal, vNVuNNvvuNnu.descRef, AimLabScreen.primaryVal(110, 200, 255, 255));
        this.primaryVal(heightVal, f + f5 + 18.0f, f8, f5, f7, "Pitch deltas", vNVuNNvvuNnu.depthVal, vNVuNNvvuNnu.activeVal, AimLabScreen.primaryVal(255, 156, 86, 255));
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, AimStatsSnapshot vNVuNNvvuNnu) {
        this.primaryVal(heightVal, f, f2, f3, f4, "Distance: distribution");
        float f5 = f + 16.0f;
        float f6 = f2 + 44.0f;
        float f7 = f3 - 32.0f;
        float f8 = f4 - 58.0f;
        int n = Math.max(1, vNVuNNvvuNnu.holderVal[0] + vNVuNNvvuNnu.holderVal[1] + vNVuNNvvuNnu.holderVal[2]);
        String[] stringArray = new String[3];
        stringArray[0] = "Close <" + AimLabScreen.tertiaryVal(vNVuNNvvuNnu.chunkVal);
        stringArray[1] = "Medium";
        stringArray[2] = "Far >" + AimLabScreen.tertiaryVal(vNVuNNvvuNnu.blockRef);
        String[] stringArray2 = stringArray;
        int[] nArray = new int[3];
        nArray[0] = AimLabScreen.primaryVal(92, 235, 182, 255);
        nArray[1] = AimLabScreen.primaryVal(110, 200, 255, 255);
        nArray[2] = AimLabScreen.primaryVal(255, 156, 86, 255);
        int[] nArray2 = nArray;
        float f9 = f7 / 3.0f - 14.0f;
        for (int i = 0; i < 3; ++i) {
            float f10 = (float)vNVuNNvvuNnu.holderVal[i] / (float)n;
            float f11 = f5 + (float)i * (f7 / 3.0f) + 7.0f;
            float f12 = Math.max(3.0f, f10 * (f8 - 28.0f));
            heightVal.primaryVal(f11, f6 + f8 - 26.0f - f12, f9, f12, 5.0f, nArray2[i]);
            String string = Math.round(f10 * 100.0f) + "%";
            heightVal.primaryVal(FontRegistry.primaryVal, f11, f6 + f8 - 2.0f, 22.0f, stringArray2[i], AimLabScreen.primaryVal(170, 178, 194, 220));
            heightVal.primaryVal(FontRegistry.marginVal, f11, f6 + f8 - 30.0f - f12, 24.0f, string, AimLabScreen.primaryVal(235, 240, 250, 235));
        }
    }

    private void secondaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, AimStatsSnapshot vNVuNNvvuNnu) {
        this.primaryVal(heightVal, f, f2, f3, f4, "Aim speed <-> distance");
        float f5 = f + 16.0f;
        float f6 = f2 + 44.0f;
        float f7 = f3 - 32.0f;
        float f8 = f4 - 64.0f;
        float f9 = Math.max(1.0f, vNVuNNvvuNnu.weightRef);
        int n = vNVuNNvvuNnu.anchorVal == null ? 0 : vNVuNNvvuNnu.anchorVal.length;
        float f10 = n > 0 ? f7 / (float)n : f7;
        for (int i = 0; i < n; ++i) {
            float f11 = vNVuNNvvuNnu.anchorVal[i] / f9;
            float f12 = Math.max(1.0f, f11 * (f8 - 4.0f));
            heightVal.primaryVal(f5 + (float)i * f10, f6 + f8 - f12, Math.max(1.0f, f10 * 0.85f), f12, 0.0f, AimLabScreen.primaryVal(120, 170, 255, 230));
        }
        heightVal.primaryVal(FontRegistry.primaryVal, f5, f6 + f8 + 18.0f, 22.0f, AimLabScreen.tertiaryVal(vNVuNNvvuNnu.speedVal) + "m", AimLabScreen.primaryVal(150, 158, 174, 200));
        String string = AimLabScreen.tertiaryVal(vNVuNNvvuNnu.widthVal) + "m";
        heightVal.primaryVal(FontRegistry.primaryVal, f5 + f7 - TextMeasureCache.secondaryVal(FontRegistry.primaryVal, string, 22.0f), f6 + f8 + 18.0f, 22.0f, string, AimLabScreen.primaryVal(150, 158, 174, 200));
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, String string, int[] nArray, int n, int n2) {
        this.primaryVal(heightVal, f, f2, f3, f4, string);
        if (nArray == null) {
            return;
        }
        float f5 = f + 16.0f;
        float f6 = f2 + 44.0f;
        float f7 = f3 - 32.0f;
        float f8 = f4 - 58.0f;
        float f9 = f7 / (float)nArray.length;
        float f10 = Math.max(1.0f, (float)n);
        for (int i = 0; i < nArray.length; ++i) {
            float f11 = Math.max(1.0f, (float)nArray[i] / f10 * (f8 - 2.0f));
            heightVal.primaryVal(f5 + (float)i * f9, f6 + f8 - f11, Math.max(1.0f, f9 * 0.8f), f11, 0.0f, n2);
        }
        heightVal.primaryVal(f5 + f7 * 0.5f - 0.5f, f6, 1.0f, f8, AimLabScreen.primaryVal(255, 255, 255, 40));
    }

    private void secondaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4) {
        String string;
        String string2;
        List<String> list = VuUvvnuUu.stageVal();
        String string3 = VuUvvnuUu.themeVal();
        this.primaryVal(heightVal, f, f2, f3, 86.0f, "Profile");
        WildClient modeVal = new WildClient(f + 16.0f, f2 + 40.0f, 38.0f, 34.0f);
        WildClient nodeC = new WildClient(f + 16.0f + 44.0f, f2 + 40.0f, 220.0f, 34.0f);
        WildClient partE = new WildClient(nodeC.primaryVal + nodeC.tertiaryVal + 8.0f, f2 + 40.0f, 38.0f, 34.0f);
        this.primaryVal(heightVal, modeVal, "<", false, false, () -> this.primaryVal(list, -1));
        heightVal.primaryVal(nodeC.primaryVal, nodeC.secondaryVal, nodeC.tertiaryVal, nodeC.marginVal, 7.0f, AimLabScreen.primaryVal(255, 255, 255, 16));
        this.primaryVal(heightVal, string3, nodeC, 28.0f, AimLabScreen.primaryVal(235, 240, 250, 235));
        this.primaryVal(heightVal, partE, ">", false, false, () -> this.primaryVal(list, 1));
        float f5 = f2 + 104.0f;
        float f6 = (f3 - 24.0f) / 4.0f - 8.0f;
        boolean bl = VuUvvnuUu.extraRef();
        boolean bl2 = VuUvvnuUu.phaseVal();
        boolean bl3 = VuUvvnuUu.slotVal();
        this.primaryVal(heightVal, new WildClient(f, f5, f6, 42.0f), bl ? "Recording..." : "Recording", false, bl, VuUvvnuUu::primaryVal);
        this.primaryVal(heightVal, new WildClient(f + (f6 + 10.0f), f5, f6, 42.0f), "Stop", true, false, () -> {
            VuUvvnuUu.secondaryVal();
            this.primaryVal();
        });
        this.primaryVal(heightVal, new WildClient(f + (f6 + 10.0f) * 2.0f, f5, f6, 42.0f), bl3 ? "Training..." : "Train", false, bl3, VuUvvnuUu::marginVal);
        this.primaryVal(heightVal, new WildClient(f + (f6 + 10.0f) * 3.0f, f5, f6, 42.0f), bl2 ? "In progress" : "Start", false, bl2, this::secondaryVal);
        float f7 = f5 + 58.0f;
        this.primaryVal(heightVal, f, f7, f3, 120.0f, "Parameters");
        this.primaryVal(heightVal, new WildClient(f + 16.0f, f7 + 46.0f, f3 - 32.0f, 30.0f), "AI Jitter (your shake strength)", 0.0f, 2.0f, false, AttackAuraModule.radiusVal::tertiaryVal, AttackAuraModule.radiusVal::primaryVal);
        WildClient reedB = new WildClient(f + 16.0f, f7 + 84.0f, 230.0f, 28.0f);
        boolean bl4 = AttackAuraModule.factorVal.tertiaryVal();
        this.primaryVal(heightVal, reedB, bl4 ? "Logs: ON" : "Logs: OFF", false, bl4, () -> AttackAuraModule.factorVal.secondaryVal(!AttackAuraModule.factorVal.tertiaryVal()));
        WildClient mossJ = new WildClient(reedB.primaryVal + reedB.tertiaryVal + 12.0f, f7 + 84.0f, 260.0f, 28.0f);
        boolean bl5 = AttackAuraModule.sourceVal.tertiaryVal();
        this.primaryVal(heightVal, mossJ, bl5 ? "Misses: ON" : "Misses: OFF", false, bl5, () -> AttackAuraModule.sourceVal.secondaryVal(!AttackAuraModule.sourceVal.tertiaryVal()));
        AimStatsSnapshot vNVuNNvvuNnu = this.radiusVal;
        float f8 = f7 + 132.0f;
        String string4 = vNVuNNvvuNnu != null && vNVuNNvvuNnu.primaryVal ? String.valueOf(vNVuNNvvuNnu.tertiaryVal) : "-";
        String string5 = string2 = VuUvvnuUu.timerVal() < 0.0f ? "-" : String.format(Locale.ROOT, "%.4f", Float.valueOf(VuUvvnuUu.timerVal()));
        string = vNVuNNvvuNnu != null && vNVuNNvvuNnu.primaryVal ? "[" + vNVuNNvvuNnu.holderVal[0] + "," + vNVuNNvvuNnu.holderVal[1] + "," + vNVuNNvvuNnu.holderVal[2] + "]" : "-";
        String string6 = vNVuNNvvuNnu != null && vNVuNNvvuNnu.primaryVal ? Math.round(vNVuNNvvuNnu.extraVal * 100.0f) + "%" : "-";
        heightVal.primaryVal(FontRegistry.primaryVal, f, f8 + 12.0f, 28.0f, "Frames " + string4 + "   Loss " + string2 + "   Buckets " + string + "   Misses " + string6, AimLabScreen.primaryVal(195, 204, 220, 230));
        heightVal.primaryVal(FontRegistry.primaryVal, f, f8 + 44.0f, 24.0f, "Tip: record at DIFFERENT distances and track the target smoothly, not just flicks.", AimLabScreen.primaryVal(150, 158, 176, 205));
    }

    private void tertiaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4) {
        AimStatsSnapshot vNVuNNvvuNnu;
        block7: {
            block6: {
                vNVuNNvvuNnu = this.radiusVal;
                if (vNVuNNvvuNnu == null) break block6;
                if (vNVuNNvvuNnu.primaryVal) break block7;
            }
            this.secondaryVal(heightVal, f, f2, f3, f4, "No data. Record and train first.");
            return;
        }
        float f5 = (f4 - 18.0f) * 0.5f - 6.0f;
        this.primaryVal(heightVal, f, f2, f3, f5, "Yaw: you vs neural network", vNVuNNvvuNnu.sourceVal, vNVuNNvvuNnu.paramRef ? vNVuNNvvuNnu.phaseVal : null);
        this.primaryVal(heightVal, f, f2 + f5 + 18.0f, f3, f5, "Pitch: you vs neural network", vNVuNNvvuNnu.extraRef, vNVuNNvvuNnu.paramRef ? vNVuNNvvuNnu.limitRef : null);
        if (!vNVuNNvvuNnu.paramRef) {
            heightVal.primaryVal(FontRegistry.primaryVal, f + 16.0f, f2 + 34.0f, 24.0f, "Model not trained — no orange line. Click Train.", AimLabScreen.primaryVal(255, 180, 110, 230));
        } else {
            String string = vNVuNNvvuNnu.groupVal < 0.0f ? "-" : String.format(Locale.ROOT, "%.4f", Float.valueOf(vNVuNNvvuNnu.groupVal));
            String string2 = "Loss " + string;
            heightVal.primaryVal(FontRegistry.primaryVal, f + f3 - TextMeasureCache.secondaryVal(FontRegistry.primaryVal, string2, 24.0f) - 16.0f, f2 + 34.0f, 24.0f, string2, AimLabScreen.primaryVal(150, 200, 255, 230));
        }
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, String string, float[] fArray, float[] fArray2) {
        float f5;
        int n;
        int n2;
        float[] fArray3;
        this.primaryVal(heightVal, f, f2, f3, f4, string);
        float f6 = f + 14.0f;
        float f7 = f2 + 42.0f;
        float f8 = f3 - 28.0f;
        float f9 = f4 - 64.0f;
        float f10 = f7 + f9 * 0.5f;
        heightVal.primaryVal(f6, f10 - 0.5f, f8, 1.0f, AimLabScreen.primaryVal(255, 255, 255, 36));
        float f11 = 6.0f;
        if (fArray != null) {
            fArray3 = fArray;
            n2 = fArray3.length;
            for (n = 0; n < n2; ++n) {
                f5 = fArray3[n];
                f11 = Math.max(f11, Math.abs(f5));
            }
        }
        if (fArray2 != null) {
            fArray3 = fArray2;
            n2 = fArray3.length;
            for (n = 0; n < n2; ++n) {
                f5 = fArray3[n];
                f11 = Math.max(f11, Math.abs(f5));
            }
        }
        f11 = Math.min(f11, 35.0f);
        this.primaryVal(heightVal, f6, f10, f8, f9 * 0.5f - 2.0f, fArray, f11, AimLabScreen.primaryVal(120, 210, 255, 235));
        this.primaryVal(heightVal, f6, f10, f8, f9 * 0.5f - 2.0f, fArray2, f11, AimLabScreen.primaryVal(255, 150, 90, 235));
        heightVal.primaryVal(FontRegistry.primaryVal, f6, f7 + f9 + 18.0f, 22.0f, "you", AimLabScreen.primaryVal(120, 210, 255, 220));
        heightVal.primaryVal(FontRegistry.primaryVal, f6 + 48.0f, f7 + f9 + 18.0f, 22.0f, "neural network", AimLabScreen.primaryVal(255, 150, 90, 220));
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float[] fArray, float f5, int n) {
        if (fArray == null || fArray.length == 0) {
            return;
        }
        float f6 = f3 / (float)fArray.length;
        float f7 = f4 / f5;
        for (int i = 0; i < fArray.length; ++i) {
            float f8 = class_3532.method_15363((float)(fArray[i] * f7), (float)(-f4), (float)f4);
            if (f8 >= 0.0f) {
                heightVal.primaryVal(f + (float)i * f6, f2 - f8, Math.max(1.0f, f6 * 0.8f), f8, n);
                continue;
            }
            heightVal.primaryVal(f + (float)i * f6, f2, Math.max(1.0f, f6 * 0.8f), -f8, n);
        }
    }

    private void secondaryVal() {
        VuUvvnuUu.tertiaryVal();
        if (ru.metaculture.protection.WildClient.primaryVal == null || ru.metaculture.protection.WildClient.primaryVal.secondaryVal == null || !AttackAuraModule.descRef.marginVal.contains("AI")) {
            return;
        }
        AttackAuraModule.descRef.weightVal = "AI";
        AttackAuraModule.descRef.limitVal = AttackAuraModule.descRef.marginVal.indexOf("AI");
        AttackAuraModule coreB = ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(AttackAuraModule.class);
        if (coreB != null && !coreB.enabled) {
            coreB.setEnabled(true);
        }
    }

    private void primaryVal(List<String> list, int n) {
        if (list == null || list.isEmpty()) {
            return;
        }
        int n2 = list.indexOf(VuUvvnuUu.themeVal());
        n2 = Math.floorMod((n2 < 0 ? 0 : n2) + n, list.size());
        VuUvvnuUu.secondaryVal(list.get(n2));
        this.primaryVal();
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, String string) {
        heightVal.primaryVal(f, f2, f3, f4, 12.0f, AimLabScreen.primaryVal(255, 255, 255, 12));
        heightVal.primaryVal(f, f2, f3, f4, 12.0f, AimLabScreen.primaryVal(255, 255, 255, 22), 1.0f);
        heightVal.primaryVal(FontRegistry.marginVal, f + 16.0f, f2 + 26.0f, 28.0f, string, AimLabScreen.primaryVal(210, 218, 232, 235));
    }

    private void secondaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, String string) {
        float f5 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, string, 28.0f);
        heightVal.primaryVal(FontRegistry.primaryVal, f + (f3 - f5) * 0.5f, f2 + f4 * 0.5f, 28.0f, string, AimLabScreen.primaryVal(170, 178, 196, 220));
    }

    private void primaryVal(Renderer2D heightVal, WildClient modeVal, String string, boolean bl, boolean bl2, Runnable runnable) {
        boolean bl3 = modeVal.primaryVal(this.timerVal, this.anchorVal);
        int n = bl2 ? AimLabScreen.primaryVal(96, 150, 240, 220) : (bl ? AimLabScreen.primaryVal(bl3 ? 230 : 150, bl3 ? 78 : 52, bl3 ? 90 : 60, bl3 ? 230 : 170) : AimLabScreen.primaryVal(255, 255, 255, bl3 ? 34 : 18));
        heightVal.primaryVal(modeVal.primaryVal, modeVal.secondaryVal, modeVal.tertiaryVal, modeVal.marginVal, 8.0f, n);
        this.primaryVal(heightVal, string, modeVal, 28.0f, AimLabScreen.primaryVal(238, 242, 250, 240));
        this.blockRef.add(new cursorVal(modeVal, runnable));
    }

    private void primaryVal(Renderer2D heightVal, WildClient modeVal, String string, float f, float f2, boolean bl, VvunVVUvUNnv vvunVVUvUNnv, DelayedFuse uunvUUVnuNn2) {
        Object[] objectArray = new Object[1];
        objectArray[0] = Float.valueOf(vvunVVUvUNnv.get());
        heightVal.primaryVal(FontRegistry.primaryVal, modeVal.primaryVal, modeVal.secondaryVal - 6.0f, 24.0f, string + "  " + String.format(Locale.ROOT, "%.2f", objectArray), AimLabScreen.primaryVal(190, 198, 214, 225));
        float f3 = modeVal.secondaryVal + 16.0f;
        heightVal.primaryVal(modeVal.primaryVal, f3, modeVal.tertiaryVal, 6.0f, 3.0f, AimLabScreen.primaryVal(255, 255, 255, 30));
        float f4 = AimLabScreen.primaryVal((vvunVVUvUNnv.get() - f) / (f2 - f), 0.0f, 1.0f);
        heightVal.primaryVal(modeVal.primaryVal, f3, modeVal.tertiaryVal * f4, 6.0f, 3.0f, AimLabScreen.primaryVal(110, 170, 255, 235));
        heightVal.secondaryVal(modeVal.primaryVal + modeVal.tertiaryVal * f4, f3 + 3.0f, 8.0f, 0.0f, 360.0f, AimLabScreen.primaryVal(235, 242, 255, 245));
        this.holderVal.add(new AccessGuardException(this, string, f, f2, bl, vvunVVUvUNnv, uunvUUVnuNn2, new WildClient(modeVal.primaryVal, f3 - 12.0f, modeVal.tertiaryVal, 30.0f)));
    }

    private void primaryVal(Renderer2D heightVal, String string, WildClient modeVal, float f, int n) {
        float f2 = TextMeasureCache.secondaryVal(FontRegistry.primaryVal, string, f);
        heightVal.primaryVal(FontRegistry.primaryVal, modeVal.primaryVal + (modeVal.tertiaryVal - f2) * 0.5f, modeVal.secondaryVal + modeVal.marginVal * 0.5f + f * 0.2f, f, string, n);
    }

    public boolean method_25402(double d, double d2, int n) {
        float f = this.primaryVal(this.primaryVal(d));
        float f2 = this.secondaryVal(this.secondaryVal(d2));
        if (this.extraRef.primaryVal(f, f2)) {
            this.method_25419();
            return true;
        }
        for (int i = 0; i < this.phaseVal.length; ++i) {
            if (!this.phaseVal[i].primaryVal(f, f2)) continue;
            this.descRef = i;
            return true;
        }
        for (AccessGuardException object : this.holderVal) {
            if (!object.extraVal.primaryVal(f, f2)) continue;
            this.activeVal = object;
            object.primaryVal(f);
            return true;
        }
        for (cursorVal panelVal : this.blockRef) {
            if (!panelVal.bounds().primaryVal(f, f2)) continue;
            panelVal.action().run();
            return true;
        }
        return super.method_25402(d, d2, n);
    }

    public boolean method_25406(double d, double d2, int n) {
        this.activeVal = null;
        return super.method_25406(d, d2, n);
    }

    public boolean method_25403(double d, double d2, int n, double d3, double d4) {
        if (this.activeVal != null) {
            this.activeVal.primaryVal(this.primaryVal(this.primaryVal(d)));
            return true;
        }
        return super.method_25403(d, d2, n, d3, d4);
    }

    public boolean method_25404(int n, int n2, int n3) {
        if (n == 256) {
            this.method_25419();
            return true;
        }
        return super.method_25404(n, n2, n3);
    }

    public void method_25419() {
        this.depthVal = true;
    }

    public boolean method_25421() {
        return false;
    }

    private static void tertiaryVal() {
        if (primaryVal) {
            return;
        }
        primaryVal = true;
        EventManager.register(new Object(){

            @Subscribe
            public void primaryVal(RenderHudEvent partD) {
                class_437 class_4372;
                if (partD.tertiaryVal() != null && (class_4372 = partD.tertiaryVal().field_1755) instanceof AimLabScreen) {
                    AimLabScreen uNVnvUUUVv = (AimLabScreen)class_4372;
                    uNVnvUUUVv.primaryVal(partD.marginVal(), partD.paramVal(), partD.extraVal());
                    if (partD.marginVal() != null) {
                        partD.marginVal().tertiaryVal();
                    }
                }
            }
        });
    }

    private void primaryVal(float f, float f2) {
        this.timerVal = this.primaryVal(f);
        this.anchorVal = this.secondaryVal(f2);
    }

    private float primaryVal(float f) {
        return this.weightRef <= 0.0f ? f : (f - this.bufferVal) / this.weightRef + this.bufferVal;
    }

    private float secondaryVal(float f) {
        return this.weightRef <= 0.0f ? f : (f - this.countVal) / this.weightRef + this.countVal;
    }

    private void marginVal() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.method_22683() == null || class_3102.field_1729 == null) {
            return;
        }
        double d = class_3102.method_22683().method_4489();
        double d2 = class_3102.method_22683().method_4506();
        if (d <= 0.0 || d2 <= 0.0) {
            return;
        }
        double d3 = class_3102.field_1729.method_1603();
        double d4 = class_3102.field_1729.method_1604();
        if (d3 >= 0.0 && d4 >= 0.0 && d3 <= d + 2.0 && d4 <= d2 + 2.0) {
            this.primaryVal((float)d3, (float)d4);
        }
    }

    private float primaryVal(double d) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.method_22683() == null) {
            return (float)d;
        }
        int n = class_3102.method_22683().method_4489();
        int n2 = class_3102.method_22683().method_4486();
        if (n <= 0 || n2 <= 0) {
            return (float)d;
        }
        return (float)(d * (double)n / Math.max(1.0, (double)n2));
    }

    private float secondaryVal(double d) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.method_22683() == null) {
            return (float)d;
        }
        int n = class_3102.method_22683().method_4506();
        int n2 = class_3102.method_22683().method_4502();
        if (n <= 0 || n2 <= 0) {
            return (float)d;
        }
        return (float)(d * (double)n / Math.max(1.0, (double)n2));
    }

    private static String tertiaryVal(float f) {
        return String.format(Locale.ROOT, "%.1f", Float.valueOf(f));
    }

    static float primaryVal(float f, float f2, float f3) {
        if (!Float.isFinite(f)) {
            return f2;
        }
        return Math.max(f2, Math.min(f3, f));
    }

    private static int primaryVal(int n, int n2, int n3, int n4) {
        return Renderer2D.VvunVVUvUNnv.marginVal(n, n2, n3, Math.max(0, Math.min(255, n4)));
    }

    static {
        String[] stringArray = new String[3];
        stringArray[0] = "Analytics";
        stringArray[1] = "Training";
        stringArray[2] = "Comparison";
        secondaryVal = stringArray;
    }

    static final class WildClient {
        final float primaryVal;
        final float secondaryVal;
        final float tertiaryVal;
        final float marginVal;

        WildClient(float f, float f2, float f3, float f4) {
            this.primaryVal = f;
            this.secondaryVal = f2;
            this.tertiaryVal = f3;
            this.marginVal = f4;
        }

        boolean primaryVal(float f, float f2) {
            return f >= this.primaryVal && f <= this.primaryVal + this.tertiaryVal && f2 >= this.secondaryVal && f2 <= this.secondaryVal + this.marginVal;
        }
    }

    static interface VvunVVUvUNnv {
        public float get();
    }

    static interface DelayedFuse {
        public void set(float var1);
    }

    record cursorVal(WildClient bounds, Runnable action) {
    }

    final class AccessGuardException {
        final String primaryVal;
        final float secondaryVal;
        final float tertiaryVal;
        final boolean marginVal;
        final VvunVVUvUNnv weightVal;
        final DelayedFuse paramVal;
        final WildClient extraVal;

        AccessGuardException(AimLabScreen uNVnvUUUVv, String string, float f, float f2, boolean bl, VvunVVUvUNnv vvunVVUvUNnv, DelayedFuse uunvUUVnuNn2, WildClient modeVal) {
            this.primaryVal = string;
            this.secondaryVal = f;
            this.tertiaryVal = f2;
            this.marginVal = bl;
            this.weightVal = vvunVVUvUNnv;
            this.paramVal = uunvUUVnuNn2;
            this.extraVal = modeVal;
        }

        void primaryVal(float f) {
            float f2 = AimLabScreen.primaryVal((f - this.extraVal.primaryVal) / this.extraVal.tertiaryVal, 0.0f, 1.0f);
            float f3 = this.secondaryVal + f2 * (this.tertiaryVal - this.secondaryVal);
            f3 = this.marginVal ? (float)Math.round(f3) : (float)Math.round(f3 * 100.0f) / 100.0f;
            this.paramVal.set(AimLabScreen.primaryVal(f3, this.secondaryVal, this.tertiaryVal));
        }
    }
}

