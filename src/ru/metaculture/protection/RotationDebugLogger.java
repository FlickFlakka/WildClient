/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2828
 */
package ru.metaculture.protection;

import java.util.Locale;
import net.minecraft.class_2828;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.SnapAimEngine;
import ru.metaculture.protection.RotationFeature;
import ru.metaculture.protection.FovScaleUtil;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;

public class RotationDebugLogger
extends RotationFeature {
    public static boolean primaryVal = false;
    public static boolean secondaryVal = false;
    private static float tertiaryVal;
    private static float marginVal;
    private static boolean weightVal;

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        class_2828 class_28282;
        if (!primaryVal || !uvUUuvnunU2.tertiaryVal() || uvUUuvnunU2.primaryVal()) {
            return;
        }
        Object object = uvUUuvnunU2.marginVal();
        if (!(object instanceof class_2828) || !(class_28282 = (class_2828)object).method_36172()) {
            return;
        }
        object = SnapAimEngine.tertiaryVal();
        if (secondaryVal && "IDLE".equals(object)) {
            return;
        }
        float f = class_28282.method_12271(tertiaryVal);
        float f2 = class_28282.method_12270(marginVal);
        float f3 = weightVal ? f - tertiaryVal : 0.0f;
        float f4 = weightVal ? f2 - marginVal : 0.0f;
        float f5 = FovScaleUtil.primaryVal();
        Object[] objectArray = new Object[11];
        objectArray[0] = object;
        objectArray[1] = Float.valueOf(f);
        objectArray[2] = Float.valueOf(f2);
        objectArray[3] = Float.valueOf(f3);
        objectArray[4] = Float.valueOf(f4);
        objectArray[5] = Math.round(f3 / f5);
        objectArray[6] = Math.round(f4 / f5);
        objectArray[7] = Float.valueOf(f5);
        objectArray[8] = class_28282.method_12273();
        objectArray[9] = Float.valueOf(MouseLookOverride.tertiaryVal);
        objectArray[10] = Float.valueOf(MouseLookOverride.marginVal);
        System.out.printf(Locale.ROOT, "[WildRot] %-6s yaw=%9.4f pitch=%8.4f dYaw=%+9.4f dPitch=%+8.4f steps=%+d/%+d gcd=%.6f onGround=%b camera=%.4f/%.4f%n", objectArray);
        tertiaryVal = f;
        marginVal = f2;
        weightVal = true;
    }
}

