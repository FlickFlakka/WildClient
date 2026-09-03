/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.wild.module.api.Module;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.KeyCodeNames;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.ClickGuiSettingLayout;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuvVnuU;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.VwVVvwWW;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.ClickGuiController;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.AnimatedValue;
import ru.metaculture.protection.FontRegistry;

final class ClickGuiCategoryPanel {
    private static final float primaryVal = 20.0f;
    private static final float secondaryVal = 8.0f;
    private static final float tertiaryVal = 4.0f;
    private static final float marginVal = 20.0f;
    private static final float weightVal = 4.0f;
    private static final float paramVal = 4.0f;
    private static final float extraVal = 4.0f;
    private final ModuleCategory limitVal;
    private final VwVVvwWW speedVal = new VwVVvwWW();
    private float widthVal;
    private float chunkVal;
    private float blockRef;
    private float holderVal;

    ClickGuiCategoryPanel(ModuleCategory linkC) {
        this.limitVal = linkC;
    }

    void primaryVal(float f, float f2, float f3, float f4) {
        this.widthVal = f;
        this.chunkVal = f2;
        this.blockRef = f3;
        this.holderVal = f4;
    }

    void primaryVal(Renderer2D heightVal, int n, int n2, float f) {
        float f2;
        float f3;
        Object object;
        int n3 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.weightVal(1, 1), (int)(30.0f * f));
        int n4 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(1, 1), (int)(160.0f * f));
        int n5 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.marginVal(1, 1), (int)(190.0f * f));
        int n6 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)(220.0f * f));
        int n7 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)(90.0f * f));
        int n8 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.extraVal(1, 1), (int)(220.0f * f));
        if (BlurEffectState.extraVal.tertiaryVal()) {
            heightVal.primaryVal(this.widthVal, this.chunkVal, this.blockRef, this.holderVal, 8.0f, f);
        }
        heightVal.primaryVal(this.widthVal, this.chunkVal, this.blockRef, this.holderVal, 8.0f, n3, 1.0f);
        heightVal.primaryVal(this.widthVal, this.chunkVal, this.blockRef, this.holderVal, 8.0f, n5);
        heightVal.primaryVal(this.widthVal, this.chunkVal, this.blockRef, 20.0f, 8.0f, 8.0f, 0.0f, 0.0f, Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.paramVal(1, 1), (int)(15.0f * f)));
        heightVal.primaryVal(FontRegistry.marginVal, this.widthVal + 4.0f + 5.0f, this.chunkVal + 6.0f + 6.5f, 16.0f, this.limitVal.secondaryVal(), n8);
        heightVal.primaryVal(FontRegistry.weightVal, this.widthVal + 4.0f + 100.0f, this.chunkVal + 6.0f + 6.5f, 16.0f, this.limitVal.primaryVal(), n8);
        float f4 = this.widthVal + 4.0f;
        float f5 = this.chunkVal + 20.0f + 4.0f;
        float f6 = this.blockRef - 8.0f;
        float f7 = this.holderVal - 20.0f - 8.0f;
        boolean bl = UuvVnuU.primaryVal(n, n2, f4, f5, f6, f7);
        this.speedVal.primaryVal(bl);
        this.speedVal.marginVal(6.0f);
        List<Module> list = this.primaryVal();
        float f8 = 0.0f;
        for (Module object22 : list) {
            object = ClickGuiController.primaryVal(object22);
            ((AnimatedValue)object).primaryVal();
            float cellJ = ClickGuiSettingLayout.primaryVal(heightVal, object22.getSettings(), f6 - 10.0f);
            f3 = cellJ > 0.0f ? cellJ + 4.0f : 0.0f;
            f2 = f3 * ((AnimatedValue)object).weightVal();
            f8 += 20.0f + f2 + 4.0f;
        }
        f8 = Math.max(0.0f, f8 - 4.0f);
        this.speedVal.primaryVal(f8, f7);
        this.speedVal.tertiaryVal();
        heightVal.primaryVal(f4, f5, f6, f7, 0.0f, 0.0f, 0.0f, 0.0f);
        float f10 = f5 + this.speedVal.limitVal();
        Iterator<Module> iterator = list.iterator();
        while (iterator.hasNext()) {
            float f9;
            float f11;
            object = iterator.next();
            AnimatedValue cellJ = ClickGuiController.primaryVal((Module)object);
            f3 = cellJ.weightVal();
            f2 = ClickGuiSettingLayout.primaryVal(heightVal, ((Module)object).getSettings(), f6 - 10.0f);
            float f12 = f2 > 0.0f ? f2 + 4.0f : 0.0f;
            float f13 = f12 * f3;
            float f14 = f4;
            float f15 = f10;
            float f16 = f6;
            float f17 = 20.0f + f13;
            if (f15 + f17 < f5 - 20.0f || f15 > f5 + f7 + 20.0f) {
                f10 += f17 + 4.0f;
                continue;
            }
            int n9 = ((Module)object).enabled ? ColorUtil.weightVal(n4, n6, 0.1f) : n4;
            heightVal.primaryVal(f14, f15, f16, f17, 4.0f, n9);
            float f18 = f15 + 5.0f + 6.5f;
            heightVal.primaryVal(FontRegistry.primaryVal, f14 + 6.0f, f18, 13.0f, ((Module)object).name, ((Module)object).enabled ? n8 : n7);
            if (((Module)object).expanded || ((Module)object).keyIndex != -1) {
                String f20 = ((Module)object).expanded ? "..." : KeyCodeNames.secondaryVal(((Module)object).keyIndex);
                f11 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)f20, (float)10.0f).primaryVal + 6.0f;
                f9 = f14 + f16 - f11 - 16.0f;
                heightVal.primaryVal(f9, f15 + 4.0f, f11, 10.0f, 3.0f, n4);
                heightVal.primaryVal(FontRegistry.marginVal, f9 + 3.0f, f15 + 4.0f + 6.8f, 10.0f, f20, n7);
            }
            if (!((Module)object).getSettings().isEmpty()) {
                float f21 = f14 + f16 - 12.0f;
                f11 = f18 + 1.0f;
                heightVal.primaryVal(FontRegistry.tertiaryVal, f21, f11, 13.0f, "X", ColorUtil.weightVal(n7, 0, f3));
            }
            if (f13 > 0.5f && f2 > 0.0f) {
                float f19 = f14 + 5.0f;
                f11 = f15 + 20.0f + 2.0f;
                f9 = f16 - 10.0f;
                float f20 = f2;
                heightVal.primaryVal(f14, f15 + 20.0f, f16, f13, 0.0f, 0.0f, 4.0f, 4.0f);
                float f21 = 0.0f;
                for (Setting nodeA : ((Module)object).getSettings()) {
                    if (nodeA.secondaryVal.get().booleanValue()) continue;
                    float f22 = ClickGuiSettingLayout.primaryVal(heightVal, nodeA, f19, f11 + f21, f9, n, n2, f * f3, n3, n6, n7, n8, n4);
                    f21 += f22 + ClickGuiSettingLayout.primaryVal();
                }
                heightVal.paramVal();
            }
            f10 += f17 + 4.0f;
        }
        heightVal.paramVal();
    }

    boolean primaryVal(Renderer2D heightVal, int n, int n2, int n3) {
        float f = this.widthVal + 4.0f;
        float f2 = this.chunkVal + 20.0f + 4.0f;
        float f3 = this.blockRef - 8.0f;
        float f4 = this.holderVal - 20.0f - 8.0f;
        if (!UuvVnuU.primaryVal(n, n2, f, f2, f3, f4)) {
            return false;
        }
        List<Module> list = this.primaryVal();
        float f5 = f2 + this.speedVal.limitVal();
        Iterator<Module> iterator = list.iterator();
        while (iterator.hasNext()) {
            float f6;
            Module module = iterator.next();
            AnimatedValue cellJ = ClickGuiController.primaryVal(module);
            float f7 = cellJ.weightVal();
            float f8 = ClickGuiSettingLayout.primaryVal(heightVal, module.getSettings(), f3 - 10.0f);
            float f9 = f8 > 0.0f ? f8 + 4.0f : 0.0f;
            float f10 = f9 * f7;
            float f11 = f;
            float f12 = f5;
            float f13 = f3;
            float f14 = 20.0f;
            if (UuvVnuU.primaryVal(n, n2, f11, f12, f13, f14)) {
                if (n3 == 1 && !module.getSettings().isEmpty()) {
                    ClickGuiController.secondaryVal(module);
                    return true;
                }
                if (n3 == 2) {
                    if (BlurEffectState.sourceVal != null && BlurEffectState.sourceVal != module) {
                        BlurEffectState.sourceVal.expanded = false;
                    }
                    module.expanded = !module.expanded;
                    BlurEffectState.sourceVal = module.expanded ? module : null;
                    return true;
                }
                if (n3 == 0) {
                    module.toggle();
                    return true;
                }
            }
            if (f10 > 0.5f) {
                f6 = f11 + 5.0f;
                float f15 = f12 + 20.0f + 2.0f;
                float f16 = f13 - 10.0f;
                float f17 = 0.0f;
                Iterator<Setting> iterator2 = module.getSettings().iterator();
                while (iterator2.hasNext()) {
                    Setting nodeA = iterator2.next();
                    if (nodeA.secondaryVal.get().booleanValue()) continue;
                    float f18 = ClickGuiSettingLayout.primaryVal(heightVal, nodeA, f16);
                    if (ClickGuiSettingLayout.primaryVal(heightVal, nodeA, f6, f15 + f17, f16, n, n2, n3)) {
                        return true;
                    }
                    f17 += f18 + ClickGuiSettingLayout.primaryVal();
                }
            }
            f6 = 20.0f + f10;
            f5 += f6 + 4.0f;
        }
        return false;
    }

    boolean primaryVal(float f, float f2, double d) {
        float f3 = this.widthVal + 4.0f;
        float f4 = this.chunkVal + 20.0f + 4.0f;
        float f5 = this.blockRef - 8.0f;
        float f6 = this.holderVal - 20.0f - 8.0f;
        if (UuvVnuU.primaryVal(f, f2, f3, f4, f5, f6)) {
            this.speedVal.primaryVal(d);
            return true;
        }
        return false;
    }

    private List<Module> primaryVal() {
        String string;
        if (WildClient.primaryVal.secondaryVal == null) {
            return Collections.emptyList();
        }
        ArrayList<Module> arrayList = WildClient.primaryVal.secondaryVal.primaryVal(this.limitVal);
        string = BlurEffectState.paramRef == null ? "" : BlurEffectState.paramRef.trim().toLowerCase();
        if (string.isEmpty()) {
            return arrayList;
        }
        return arrayList.stream().filter(module -> module.name != null && module.name.toLowerCase().contains(string)).toList();
    }
}

