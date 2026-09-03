/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.CameraRotationEvent;
import ru.metaculture.protection.UuvVnuU;
import ru.metaculture.protection.MouseMoveEvent;
import ru.metaculture.protection.RotationFeature;
import ru.metaculture.protection.Subscribe;

public class MouseLookOverride
extends RotationFeature {
    public static boolean primaryVal;
    public static boolean secondaryVal;
    public static float tertiaryVal;
    public static float marginVal;

    @Subscribe
    public void primaryVal(MouseMoveEvent nUUuNuvNUVV2) {
        if (primaryVal) {
            this.primaryVal(nUUuNuvNUVV2.tertiaryVal(), nUUuNuvNUVV2.marginVal());
            nUUuNuvNUVV2.secondaryVal();
        }
    }

    @Subscribe
    public void primaryVal(CameraRotationEvent reedH) {
        if (primaryVal) {
            reedH.primaryVal(tertiaryVal);
            reedH.secondaryVal(marginVal);
        } else {
            tertiaryVal = reedH.tertiaryVal();
            marginVal = reedH.marginVal();
        }
    }

    private void primaryVal(double d, double d2) {
        marginVal = UuvVnuU.widthVal((float)((double)marginVal + d2 * 0.15), -90.0f, 90.0f);
        tertiaryVal = (float)((double)tertiaryVal + d * 0.15);
    }
}

