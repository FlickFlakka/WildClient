/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  org.joml.Vector2f
 */
package ru.metaculture.protection;

import net.minecraft.class_1297;
import org.joml.Vector2f;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.UuvVnuU;

public class Rotation
implements MinecraftAccessor {
    public float primaryVal;
    public float secondaryVal;

    public Rotation(class_1297 class_12972) {
        this.primaryVal = class_12972.method_36454();
        this.secondaryVal = class_12972.method_36455();
    }

    public Rotation(float f, float f2) {
        this.primaryVal = f;
        this.secondaryVal = f2;
    }

    public float primaryVal(Rotation uuUuvNuNVNVU2) {
        float f = UuvVnuU.extraVal(uuUuvNuNVNVU2.primaryVal - this.primaryVal);
        float f2 = uuUuvNuNVNVU2.secondaryVal - this.secondaryVal;
        return (float)Math.hypot(Math.abs(f), Math.abs(f2));
    }

    public double secondaryVal(Rotation uuUuvNuNVNVU2) {
        double d = UuvVnuU.extraVal(uuUuvNuNVNVU2.primaryVal - this.primaryVal);
        double d2 = UuvVnuU.extraVal(uuUuvNuNVNVU2.secondaryVal - this.secondaryVal);
        return Math.hypot(d, d2);
    }

    public static Vector2f primaryVal() {
        return new Vector2f(Rotation.secondaryVal(), Rotation.tertiaryVal());
    }

    public static float secondaryVal() {
        return UuvVnuU.extraVal(Rotation.a_.field_1773.method_19418().method_19330() + (float)(Rotation.a_.field_1773.method_19418().method_19333() ? 180 : 0));
    }

    public static float tertiaryVal() {
        return (float)(Rotation.a_.field_1773.method_19418().method_19333() ? -1 : 1) * Rotation.a_.field_1773.method_19418().method_19329();
    }
}

