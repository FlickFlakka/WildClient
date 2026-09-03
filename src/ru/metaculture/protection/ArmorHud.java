/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1304
 *  net.minecraft.class_1799
 *  net.minecraft.class_332
 *  net.minecraft.class_408
 */
package ru.metaculture.protection;

import net.minecraft.class_1304;
import net.minecraft.class_1799;
import net.minecraft.class_332;
import net.minecraft.class_408;
import ru.metaculture.protection.NuNvVUuUUnun;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuUuVnVvnvn;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.AnimatedDouble;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.VnuuvvUv;
import ru.metaculture.protection.Easings;
import ru.metaculture.protection.HudLayoutManager;
import ru.metaculture.protection.ThemeSettings;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.HudSettingsPersistence;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.SettingHolder;
import ru.metaculture.protection.HudElementInfo;
import ru.metaculture.protection.BoolSetting;

@HudElementInfo(primaryVal="ArmorHUD", secondaryVal="w")
public final class ArmorHud
extends ThemeSettings {
    private static final ArmorHud primaryVal = new ArmorHud();
    private static final AnimatedDouble limitRef = new AnimatedDouble();
    private static final AnimatedDouble paramRef = new AnimatedDouble();
    private static final AnimatedDouble groupVal = new AnimatedDouble();
    private static final class_1799[] layerVal = new class_1799[4];
    private static final VnuuvvUv[] slotVal = new VnuuvvUv[4];
    private final BoolSetting themeVal = new BoolSetting("Show as percentage", true);
    private final ModeSetting stageVal = new ModeSetting("Orientation", "Horizontal", "Horizontal", "Vertical");

    private ArmorHud() {
        this.primaryVal((Setting)this.themeVal);
        this.primaryVal((Setting)this.stageVal);
        HudSettingsPersistence.primaryVal(this);
    }

    public static ArmorHud secondaryVal() {
        return primaryVal;
    }

    public static void primaryVal(Renderer2D heightVal, class_332 class_3322) {
        primaryVal.secondaryVal(heightVal, class_3322);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void secondaryVal(Renderer2D heightVal, class_332 class_3322) {
        float f;
        int n;
        if (MinecraftAccessor.a_.field_1724 == null) {
            return;
        }
        ArmorHud.layerVal[0] = MinecraftAccessor.a_.field_1724.method_6118(class_1304.field_6169);
        ArmorHud.layerVal[1] = MinecraftAccessor.a_.field_1724.method_6118(class_1304.field_6174);
        ArmorHud.layerVal[2] = MinecraftAccessor.a_.field_1724.method_6118(class_1304.field_6172);
        ArmorHud.layerVal[3] = MinecraftAccessor.a_.field_1724.method_6118(class_1304.field_6166);
        int n2 = 0;
        for (n = 0; n < 4; ++n) {
            class_1799 class_17992 = layerVal[n];
            if (class_17992 == null) continue;
            if (class_17992.method_7960()) continue;
            ArmorHud.layerVal[n2++] = class_17992;
        }
        n = n2 > 0 ? 1 : 0;
        boolean bl = n != 0 || MinecraftAccessor.a_.field_1755 instanceof class_408;
        limitRef.primaryVal();
        limitRef.primaryVal(bl ? 1.0 : 0.0, 0.22f, Easings.timerVal, false);
        float f2 = limitRef.weightVal();
        if (f2 <= 0.01f) {
            return;
        }
        float f3 = MinecraftAccessor.a_.method_22683().method_4489();
        float f4 = MinecraftAccessor.a_.method_22683().method_4506();
        float f5 = 7.0f;
        boolean bl2 = this.stageVal.secondaryVal("Vertical");
        float f6 = bl2 ? 56.0f : 42.0f;
        float f7 = 54.0f;
        float f8 = 5.0f;
        int n3 = n != 0 ? n2 : 4;
        float f9 = f = bl2 ? f6 : (float)n3 * f6 + (float)(n3 - 1) * f8;
        float f10 = bl2 ? (float)n3 * f7 + (float)(n3 - 1) * f8 : f7;
        float f11 = f + f5 * 2.0f;
        float f12 = f10 + f5 * 2.0f;
        paramRef.primaryVal();
        groupVal.primaryVal();
        paramRef.primaryVal(f11, 0.18f, Easings.timerVal, false);
        groupVal.primaryVal(f12, 0.18f, Easings.timerVal, false);
        float f13 = paramRef.weightVal();
        float f14 = groupVal.weightVal();
        float f15 = f3 * 0.5f + 96.0f;
        float f16 = f4 - f14 - 12.0f;
        HudLayoutManager.cursorVal panelVal = HudLayoutManager.primaryVal().primaryVal("hud_armor", f15, f16, f13, f14);
        float f17 = panelVal.secondaryVal;
        float f18 = panelVal.tertiaryVal;
        float f19 = panelVal.marginVal;
        float f20 = panelVal.weightVal;
        this.primaryVal(f17, f18, f19, f20);
        float f21 = f19 / Math.max(1.0f, f13);
        float f22 = f20 / Math.max(1.0f, f14);
        float f23 = Math.min(f21, f22);
        float f24 = f6 * f21;
        float f25 = f7 * f22;
        float f26 = f8 * (bl2 ? f22 : f21);
        float f27 = f * f21;
        float f28 = f10 * f22;
        float f29 = f2 * this.depthVal.tertiaryVal();
        float f30 = this.widthVal(f29);
        int n4 = (int)(255.0f * f29);
        int n5 = this.primaryVal(f29);
        int n6 = this.marginVal(f29);
        int n7 = this.widthVal() ? ColorUtil.tertiaryVal(255, 255, 255, (int)(5.0f * f30)) : this.secondaryVal(f30);
        float f31 = 10.0f;
        this.primaryVal(heightVal, f17, f18, f19, f20, f31, f29);
        heightVal.tertiaryVal();
        heightVal.primaryVal(f17, f18, f19, f20, f31, f31, f31, f31);
        try {
            float f32;
            float f33;
            int n8;
            float f34 = f17 + (f19 - f27) * 0.5f;
            float f35 = f18 + (f20 - f28) * 0.5f;
            for (n8 = 0; n8 < n3; ++n8) {
                f33 = bl2 ? f34 : f34 + (float)n8 * (f24 + f26);
                float f36 = f32 = bl2 ? f35 + (float)n8 * (f25 + f26) : f35;
                if (this.chunkVal() || this.blockRef() || this.holderVal()) {
                    this.secondaryVal(heightVal, f33, f32, f24, f25, 6.0f * f23, f29);
                    continue;
                }
                heightVal.primaryVal(f33, f32, f24, f25, 6.0f * f23, n7);
            }
            if (n != 0) {
                heightVal.tertiaryVal();
            }
            for (n8 = 0; n8 < n3; ++n8) {
                float f37;
                if (n == 0) {
                    break;
                }
                f33 = bl2 ? f34 : f34 + (float)n8 * (f24 + f26);
                f32 = bl2 ? f35 + (float)n8 * (f25 + f26) : f35;
                class_1799 class_17993 = layerVal[n8];
                float f38 = 1.5f * f23;
                float f39 = 16.0f * f38;
                float f40 = f33 + (f24 - f39) * 0.5f;
                float f41 = f32 + 8.0f * f22;
                NuNvVUuUUnun.primaryVal(heightVal, class_17993, NuNvVUuUUnun.primaryVal(f40), NuNvVUuUUnun.primaryVal(f41), NuNvVUuUUnun.tertiaryVal(f38), n8, true, n8);
                if (!class_17993.method_7963()) continue;
                int n9 = class_17993.method_7936();
                int n10 = n9 - class_17993.method_7919();
                boolean bl3 = this.themeVal.tertiaryVal();
                f37 = n9 <= 0 ? 1.0f : (float)n10 / (float)n9;
                String string = bl3 ? (int)(f37 * 100.0f) + "%" : n10 + "/" + n9;
                int n11 = f37 <= 0.2f ? ColorUtil.tertiaryVal(255, 85, 85, n4) : this.limitVal(f29);
                float f43 = 16.0f * f23;
                slotVal[n8].primaryVal(string, n10);
                slotVal[n8].primaryVal(heightVal, FontRegistry.marginVal, f33, f32, f24, f25, 4.0f * f23, f33 + f24 * 0.5f, f32 + f25 - 6.0f * f22, f43, n11);
            }
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
        HudLayoutManager.primaryVal().primaryVal(panelVal);
        UuUuVnVvnvn.primaryVal(heightVal, (SettingHolder)this, panelVal, HudLayoutManager.primaryVal(), (float)MinecraftAccessor.a_.method_22683().method_4486(), (float)MinecraftAccessor.a_.method_22683().method_4502());
    }

    static {
        for (int i = 0; i < slotVal.length; ++i) {
            ArmorHud.slotVal[i] = new VnuuvvUv();
        }
    }
}

