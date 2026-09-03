/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1309
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import net.minecraft.class_1309;
import net.minecraft.class_3532;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.Rotation;

public final class NnuUuVVVvUu {
    private int primaryVal = -1;

    void primaryVal(Rotation uuUuvNuNVNVU2, class_1309 class_13092, float f, float f2) {
        if (class_13092.method_5628() != this.primaryVal) {
            this.primaryVal(class_13092.method_5628());
        }
        float f3 = uuUuvNuNVNVU2.primaryVal + f;
        float f4 = class_3532.method_15363((float)(uuUuvNuNVNVU2.secondaryVal + f2), (float)-90.0f, (float)90.0f);
        RotationController.primaryVal(new Rotation(f3, f4), Math.abs(f), Math.abs(f2), 20.0f, 20.0f, 1, 15, false);
    }

    public void primaryVal(Rotation uuUuvNuNVNVU2, float f, float f2, int n, int n2) {
        this.primaryVal(uuUuvNuNVNVU2, f, f2, 20.0f, 20.0f, n, n2);
    }

    public void primaryVal(Rotation uuUuvNuNVNVU2, float f, float f2, float f3, float f4, int n, int n2) {
        this.primaryVal(-1);
        RotationController.primaryVal(uuUuvNuNVNVU2, f, f2, f3, f4, n, n2, false);
    }

    public void primaryVal() {
        this.primaryVal(-1);
    }

    private void primaryVal(int n) {
        this.primaryVal = n;
    }
}

