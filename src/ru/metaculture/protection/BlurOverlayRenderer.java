/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 */
package ru.metaculture.protection;

import java.util.Iterator;
import net.minecraft.class_310;
import net.minecraft.class_332;
import org.wild.module.api.Module;
import ru.metaculture.protection.CoCO0oOCO0c;
import ru.metaculture.protection.BlurEffectState;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ClickGuiController;

public class BlurOverlayRenderer
extends BlurEffectState {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal(Renderer2D heightVal, class_332 class_3322, int n, int n2, float f) {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null || class_3102.method_22683() == null) {
            return;
        }
        int n3 = class_3102.method_22683().method_4489();
        int n4 = class_3102.method_22683().method_4506();
        if (n3 <= 0 || n4 <= 0) {
            return;
        }
        int n5 = (int)((float)n / CoCO0oOCO0c.primaryVal);
        int n6 = (int)((float)n2 / CoCO0oOCO0c.primaryVal);
        BlurEffectState.UuNnnVnuNNV = n5;
        BlurEffectState.depthRef = n6;
        BlurEffectState.widthVal.primaryVal();
        BlurEffectState.chunkVal.primaryVal();
        BlurEffectState.blockRef.primaryVal();
        BlurEffectState.holderVal.primaryVal();
        if (BlurEffectState.vVVuuVVv != null) {
            Iterator<Module> iterator = BlurEffectState.vVVuuVVv.iterator();
            while (iterator.hasNext()) {
                Module module = iterator.next();
                BlurEffectState.primaryVal(module).primaryVal();
                BlurEffectState.secondaryVal(module).primaryVal();
                BlurEffectState.tertiaryVal(module).primaryVal();
            }
        }
        BlurEffectState.limitVal.primaryVal(1.0);
        float f2 = BlurEffectState.widthVal.weightVal();
        if (f2 <= 0.001f) {
            return;
        }
        float f3 = class_3102.method_22683().method_4486();
        float f4 = class_3102.method_22683().method_4502();
        BlurEffectState.modeRef = f3 / 2.0f - BlurEffectState.heightRef / 2.0f;
        BlurEffectState.angleVal = f4 / 2.0f - BlurEffectState.levelVal / 2.0f - (80.0f - 80.0f * f2);
        float f5 = (float)class_3102.method_22683().method_4489() / (float)class_3102.method_22683().method_4486();
        heightVal.tertiaryVal(f5);
        try {
            if (BlurEffectState.extraVal.tertiaryVal()) {
                heightVal.primaryVal(23.0f);
            }
            heightVal.primaryVal(0.0f, 0.0f, f3, f4, Renderer2D.VvunVVUvUNnv.marginVal(0, 0, 0, (int)(140.0f * f2)));
            ClickGuiController.primaryVal(heightVal, n5, n6, f2);
        }
        finally {
            heightVal.limitVal();
            heightVal.limitVal();
        }
    }
}

