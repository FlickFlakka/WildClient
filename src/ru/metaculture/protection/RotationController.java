/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import net.minecraft.class_1297;
import net.minecraft.class_3532;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.AimDeadzoneSmoothing;
import ru.metaculture.protection.UuvVnuU;
import ru.metaculture.protection.PostClientTickEvent;
import ru.metaculture.protection.SnapAimEngine;
import ru.metaculture.protection.RotationFeature;
import ru.metaculture.protection.MovementInputEvent;
import ru.metaculture.protection.FovScaleUtil;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.Subscribe;

public class RotationController
extends RotationFeature {
    private static DelayedFuse holderVal;
    private static RotationStepProvider timerVal;
    public static VvunVVUvUNnv primaryVal;
    public static float secondaryVal;
    public static float tertiaryVal;
    public static float marginVal;
    public static float weightVal;
    public static int paramVal;
    public static int extraVal;
    public static int limitVal;
    public static Rotation speedVal;
    public static boolean widthVal;

    public static void primaryVal(DelayedFuse uunvUUVnuNn2, Runnable runnable) {
        holderVal = uunvUUVnuNn2;
        try {
            runnable.run();
            holderVal = null;
        }
        catch (Throwable throwable) {
            holderVal = null;
            throw throwable;
        }
    }

    public static boolean primaryVal() {
        return !primaryVal.equals((Object)VvunVVUvUNnv.IDLE);
    }

    private void tertiaryVal() {
        block4: {
            RotationStep panelVal;
            block6: {
                block5: {
                    if (timerVal == null) break block4;
                    panelVal = timerVal.nextStep();
                    if (panelVal == null) break block5;
                    if (!panelVal.marginVal && panelVal.primaryVal != null) break block6;
                }
                this.secondaryVal();
                return;
            }
            RotationController.primaryVal(panelVal.primaryVal, panelVal.secondaryVal, panelVal.tertiaryVal);
            return;
        }
        Rotation uuUuvNuNVNVU2 = new Rotation(MouseLookOverride.tertiaryVal, MouseLookOverride.marginVal);
        if (RotationController.primaryVal(uuUuvNuNVNVU2, marginVal, weightVal)) {
            this.secondaryVal();
        }
    }

    @Subscribe
    public void primaryVal(MovementInputEvent uNVVnVUNun2) {
        SnapAimEngine.primaryVal(uNVVnVUNun2);
    }

    @Subscribe
    public void primaryVal(PostClientTickEvent coreH) {
        if (primaryVal.equals((Object)VvunVVUvUNnv.AIM)) {
            if (limitVal > extraVal) {
                if (widthVal) {
                    this.secondaryVal();
                } else {
                    primaryVal = VvunVVUvUNnv.RESET;
                }
            }
        }
        if (primaryVal.equals((Object)VvunVVUvUNnv.RESET)) {
            this.tertiaryVal();
        }
        ++limitVal;
    }

    public static void primaryVal(Rotation uuUuvNuNVNVU2, float f, float f2, float f3, float f4, int n, int n2, boolean bl) {
        RotationController.secondaryVal(uuUuvNuNVNVU2, f, f2, f3, f4, n, n2, bl, null);
    }

    public static void primaryVal(Rotation uuUuvNuNVNVU2, float f, float f2, float f3, float f4, int n, int n2, boolean bl, RotationStepProvider modeVal) {
        RotationController.secondaryVal(uuUuvNuNVNVU2, f, f2, f3, f4, n, n2, bl, modeVal);
    }

    private static void secondaryVal(Rotation uuUuvNuNVNVU2, float f, float f2, float f3, float f4, int n, int n2, boolean bl, RotationStepProvider modeVal) {
        if (holderVal != null) {
            f = RotationController.holderVal.primaryVal;
            f2 = RotationController.holderVal.secondaryVal;
            f3 = RotationController.holderVal.tertiaryVal;
            f4 = RotationController.holderVal.marginVal;
            bl = RotationController.holderVal.weightVal;
        }
        if (paramVal > n2) {
            return;
        }
        if (AimDeadzoneSmoothing.primaryVal && uuUuvNuNVNVU2 != null) {
            AimDeadzoneSmoothing.primaryVal();
            float f5 = uuUuvNuNVNVU2.primaryVal + AimDeadzoneSmoothing.secondaryVal;
            float f6 = class_3532.method_15363((float)class_3532.method_15363((float)(uuUuvNuNVNVU2.secondaryVal + AimDeadzoneSmoothing.tertiaryVal), (float)AimDeadzoneSmoothing.marginVal, (float)AimDeadzoneSmoothing.weightVal), (float)-90.0f, (float)90.0f);
            uuUuvNuNVNVU2 = new Rotation(f5, f6);
        }
        if (bl) {
            MouseLookOverride.primaryVal = false;
            if (RotationController.a_.field_1724 != null) {
                MouseLookOverride.tertiaryVal = RotationController.a_.field_1724.method_36454();
                MouseLookOverride.marginVal = RotationController.a_.field_1724.method_36455();
            }
        } else if (primaryVal.equals((Object)VvunVVUvUNnv.IDLE)) {
            MouseLookOverride.primaryVal = true;
        }
        secondaryVal = f;
        tertiaryVal = f2;
        marginVal = f3;
        weightVal = f4;
        extraVal = n;
        paramVal = n2;
        primaryVal = VvunVVUvUNnv.AIM;
        widthVal = bl;
        timerVal = modeVal;
        speedVal = uuUuvNuNVNVU2;
        RotationController.primaryVal(uuUuvNuNVNVU2, f, f2);
    }

    public static void primaryVal(Rotation uuUuvNuNVNVU2, float f, float f2, float f3, float f4, int n, int n2) {
        RotationController.primaryVal(uuUuvNuNVNVU2, f, f2, f3, f4, n, n2, true);
    }

    public static void primaryVal(Rotation uuUuvNuNVNVU2, float f, float f2, int n, int n2) {
        RotationController.primaryVal(uuUuvNuNVNVU2, f, f, f2, f2, n, n2, false);
    }

    public static void primaryVal(RotationStepProvider modeVal) {
        if (modeVal == null || timerVal != modeVal || primaryVal.equals((Object)VvunVVUvUNnv.IDLE)) {
            return;
        }
        primaryVal = VvunVVUvUNnv.RESET;
        widthVal = false;
        limitVal = 0;
    }

    public static void secondaryVal(RotationStepProvider modeVal) {
        if (timerVal == modeVal) {
            timerVal = null;
        }
    }

    static boolean primaryVal(Rotation uuUuvNuNVNVU2, float f, float f2) {
        if (RotationController.a_.field_1724 == null) {
            return false;
        }
        Rotation uuUuvNuNVNVU3 = new Rotation((class_1297)RotationController.a_.field_1724);
        float f3 = UuvVnuU.extraVal(uuUuvNuNVNVU2.primaryVal - uuUuvNuNVNVU3.primaryVal);
        float f4 = uuUuvNuNVNVU2.secondaryVal - uuUuvNuNVNVU3.secondaryVal;
        float f5 = Math.min(Math.abs(f3), f);
        float f6 = Math.min(Math.abs(f4), f2);
        RotationController.a_.field_1724.method_36456(RotationController.a_.field_1724.field_6241 += FovScaleUtil.primaryVal(class_3532.method_15363((float)f3, (float)(-f5), (float)f5)));
        RotationController.a_.field_1724.method_36457(class_3532.method_15363((float)(RotationController.a_.field_1724.method_36455() + FovScaleUtil.primaryVal(class_3532.method_15363((float)f4, (float)(-f6), (float)f6))), (float)-90.0f, (float)90.0f));
        limitVal = 0;
        return new Rotation((class_1297)RotationController.a_.field_1724).primaryVal(uuUuvNuNVNVU2) < 1.0f;
    }

    public void secondaryVal() {
        primaryVal = VvunVVUvUNnv.IDLE;
        paramVal = 0;
        widthVal = false;
        timerVal = null;
        MouseLookOverride.primaryVal = MouseLookOverride.secondaryVal;
    }

    static {
        primaryVal = VvunVVUvUNnv.IDLE;
    }

    public static final class DelayedFuse {
        public final float primaryVal;
        public final float secondaryVal;
        public final float tertiaryVal;
        public final float marginVal;
        public final boolean weightVal;

        public DelayedFuse(float f, float f2, float f3, float f4, boolean bl) {
            this.primaryVal = f;
            this.secondaryVal = f2;
            this.tertiaryVal = f3;
            this.marginVal = f4;
            this.weightVal = bl;
        }
    }

    public enum VvunVVUvUNnv {
    AIM,
    RESET,
    IDLE;
}

    @FunctionalInterface
    public static interface RotationStepProvider {
        public RotationStep nextStep();
    }

    public static final class RotationStep {
        public final Rotation primaryVal;
        public final float secondaryVal;
        public final float tertiaryVal;
        public final boolean marginVal;

        public RotationStep(Rotation uuUuvNuNVNVU2, float f, float f2, boolean bl) {
            this.primaryVal = uuUuvNuNVNVU2;
            this.secondaryVal = f;
            this.tertiaryVal = f2;
            this.marginVal = bl;
        }

        public static RotationStep primaryVal() {
            return new RotationStep(null, 0.0f, 0.0f, true);
        }
    }
}

