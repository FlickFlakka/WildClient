/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.RotationLabStorage;
import ru.metaculture.protection.RotationLabSession;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.ChatLogger;

public final class NuUvVVvUVVUV
implements MinecraftAccessor {
    private static final int primaryVal = 18;
    private static final long secondaryVal = 700L;
    private static final float tertiaryVal = 34.0f;
    private static final float marginVal = 22.0f;
    private static final RotationLabStorage weightVal = new RotationLabStorage();
    private static RotationLabSession.Dataset paramVal;
    private static final cursorVal extraVal;
    private static int limitVal;
    private static int speedVal;
    private static int widthVal;
    private static String holderVal;
    private static long timerVal;
    private static boolean anchorVal;

    private NuUvVVvUVVUV() {
    }

    public static void primaryVal(class_1309 class_13092, boolean bl, boolean bl2) {
        NuUvVVvUVVUV.primaryVal(class_13092, bl, bl2, false);
    }

    public static void primaryVal(class_1309 class_13092, boolean bl, boolean bl2, boolean bl3) {
        if (NuUvVVvUVVUV.a_.field_1724 == null || NuUvVVvUVVUV.a_.field_1687 == null || class_13092 == null) {
            NuUvVVvUVVUV.primaryVal(AttackAuraModule.trackVal.tertiaryVal());
            holderVal = "Neuro idle";
            NuUvVVvUVVUV.primaryVal(bl3, "idle target=" + String.valueOf(class_13092 == null ? "null" : Integer.valueOf(class_13092.method_5628())));
            return;
        }
        ++widthVal;
        NuUvVVvUVVUV.primaryVal(class_13092);
        Rotation uuUuvNuNVNVU2 = NuUvVVvUVVUV.primaryVal(class_13092, extraVal);
        Rotation uuUuvNuNVNVU3 = new Rotation((class_1297)NuUvVVvUVVUV.a_.field_1724);
        float f = class_3532.method_15393((float)(uuUuvNuNVNVU2.primaryVal - uuUuvNuNVNVU3.primaryVal));
        float f2 = uuUuvNuNVNVU2.secondaryVal - uuUuvNuNVNVU3.secondaryVal;
        float f3 = (float)Math.hypot(f, f2);
        boolean bl4 = bl && !bl2;
        NuUvVVvUVVUV.primaryVal(f3, f, f2, bl4, bl2);
        if (NuUvVVvUVVUV.primaryVal(class_13092, f3, bl4)) {
            NuUvVVvUVVUV.primaryVal(class_13092, f, f2, bl4);
        }
        RotationLabSession.RotationSample panelVal = NuUvVVvUVVUV.marginVal();
        float f4 = NuUvVVvUVVUV.secondaryVal(f3, bl4, bl2, panelVal != null);
        float f5 = NuUvVVvUVVUV.primaryVal(panelVal, f3, bl4, bl2);
        WildClient modeVal = NuUvVVvUVVUV.primaryVal(panelVal, f, f2, f3, f4, bl4);
        VvunVVUvUNnv vvunVVUvUNnv = NuUvVVvUVVUV.primaryVal(f, f2, modeVal, f3, f5, bl4, bl2);
        float f6 = vvunVVUvUNnv.targetYawVelocity;
        float f7 = vvunVVUvUNnv.targetPitchVelocity;
        float f8 = vvunVVUvUNnv.yaw;
        float f9 = vvunVVUvUNnv.pitch;
        float f10 = uuUuvNuNVNVU3.primaryVal + f8;
        float f11 = class_3532.method_15363((float)(uuUuvNuNVNVU3.secondaryVal + f9), (float)-90.0f, (float)90.0f);
        float f12 = Math.max(0.18f, Math.abs(f8));
        float f13 = Math.max(0.14f, Math.abs(f9));
        anchorVal = RotationController.paramVal <= 18;
        RotationController.primaryVal(new Rotation(f10, f11), f12, f13, 30.0f, 30.0f, 1, 18, false);
        if (panelVal != null) {
            ++speedVal;
        }
        NuUvVVvUVVUV.extraVal.countVal = f;
        NuUvVVvUVVUV.extraVal.depthVal = f2;
        NuUvVVvUVVUV.extraVal.weightVal = true;
        holderVal = "Neuro humanize " + weightVal.primaryVal() + "p";
        NuUvVVvUVVUV.primaryVal(bl3, "aim target=" + class_13092.method_5628() + " type=" + NuUvVVvUVVUV.weightVal() + " sample=" + speedVal + "/" + NuUvVVvUVVUV.paramVal() + " yawErr=" + NuUvVVvUVVUV.secondaryVal(f) + " pitchErr=" + NuUvVVvUVVUV.secondaryVal(f2) + " yawBase=" + NuUvVVvUVVUV.secondaryVal(f6) + " pitchBase=" + NuUvVVvUVVUV.secondaryVal(f7) + " humanYaw=" + NuUvVVvUVVUV.secondaryVal(modeVal.yaw) + " humanPitch=" + NuUvVVvUVVUV.secondaryVal(modeVal.pitch) + " yawStep=" + NuUvVVvUVVUV.secondaryVal(f8) + " pitchStep=" + NuUvVVvUVVUV.secondaryVal(f9) + " speed=" + NuUvVVvUVVUV.secondaryVal(f5) + " focus=" + NuUvVVvUVVUV.secondaryVal(NuUvVVvUVVUV.extraVal.extraVal) + "/" + NuUvVVvUVVUV.secondaryVal(NuUvVVvUVVUV.extraVal.speedVal) + "/" + NuUvVVvUVVUV.secondaryVal(NuUvVVvUVVUV.extraVal.limitVal) + " cfg=" + NuUvVVvUVVUV.secondaryVal(NuUvVVvUVVUV.extraVal()) + "/" + NuUvVVvUVVUV.secondaryVal(NuUvVVvUVVUV.widthVal()) + " hold=" + NuUvVVvUVVUV.extraVal.marginVal + " attack=" + bl4 + " blocked=" + bl2);
    }

    public static void primaryVal() {
        paramVal = null;
        limitVal = -1;
        speedVal = 0;
        extraVal.primaryVal();
        anchorVal = false;
        holderVal = "Neuro reset";
    }

    public static void primaryVal(boolean bl) {
        if (!anchorVal) {
            NuUvVVvUVVUV.primaryVal();
            return;
        }
        if (NuUvVVvUVVUV.a_.field_1724 != null) {
            MouseLookOverride.tertiaryVal = NuUvVVvUVVUV.a_.field_1724.method_36454();
            MouseLookOverride.marginVal = NuUvVVvUVVUV.a_.field_1724.method_36455();
            if (bl) {
                NuUvVVvUVVUV.a_.field_1724.method_36456(NuUvVVvUVVUV.a_.field_1724.method_36454());
                NuUvVVvUVVUV.a_.field_1724.method_36457(NuUvVVvUVVUV.a_.field_1724.method_36455());
                NuUvVVvUVVUV.a_.field_1724.field_6241 = NuUvVVvUVVUV.a_.field_1724.method_36454();
            }
        }
        RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
        RotationController.paramVal = 0;
        RotationController.widthVal = false;
        RotationController.speedVal = null;
        RotationController.limitVal = 0;
        MouseLookOverride.primaryVal = bl ? false : MouseLookOverride.secondaryVal;
        NuUvVVvUVVUV.primaryVal();
    }

    public static void secondaryVal() {
        NuUvVVvUVVUV.primaryVal();
    }

    public static String tertiaryVal() {
        return holderVal + " / " + weightVal.secondaryVal();
    }

    private static boolean primaryVal(class_1309 class_13092, float f, boolean bl) {
        block10: {
            block9: {
                if (weightVal.primaryVal() == 0) {
                    paramVal = null;
                    limitVal = -1;
                    speedVal = 0;
                    return false;
                }
                if (paramVal == null || class_13092.method_5628() != limitVal) {
                    return true;
                }
                if (NuUvVVvUVVUV.paramVal.blockRef == null) break block9;
                if (speedVal < NuUvVVvUVVUV.paramVal.blockRef.size()) break block10;
            }
            return true;
        }
        if (bl) {
            if (!"Attack".equalsIgnoreCase(NuUvVVvUVVUV.paramVal.primaryVal) && speedVal > 2) {
                return true;
            }
        }
        if (f < 5.0f) {
            if ("Flick".equalsIgnoreCase(NuUvVVvUVVUV.paramVal.primaryVal) && speedVal > 2) {
                return true;
            }
        }
        return false;
    }

    private static void primaryVal(class_1309 class_13092, float f, float f2, boolean bl) {
        paramVal = weightVal.primaryVal(class_3532.method_15363((float)f, (float)-45.0f, (float)45.0f), class_3532.method_15363((float)f2, (float)-30.0f, (float)30.0f), bl);
        limitVal = class_13092.method_5628();
        speedVal = 0;
    }

    private static RotationLabSession.RotationSample marginVal() {
        block3: {
            block2: {
                if (paramVal == null || NuUvVVvUVVUV.paramVal.blockRef == null) break block2;
                if (!NuUvVVvUVVUV.paramVal.blockRef.isEmpty()) break block3;
            }
            return null;
        }
        return NuUvVVvUVVUV.paramVal.blockRef.get(Math.min(speedVal, NuUvVVvUVVUV.paramVal.blockRef.size() - 1));
    }

    private static float primaryVal(float f, boolean bl, boolean bl2, boolean bl3) {
        float f2;
        float f3 = Math.abs(f);
        if (f3 < 0.001f) {
            return 0.0f;
        }
        float f4 = bl ? 0.62f : 0.42f;
        float f5 = bl ? 34.0f : 22.0f;
        float f6 = f2 = bl ? 0.31f : 0.25f;
        if (bl2) {
            f5 *= 1.12f;
            f2 *= 1.08f;
        }
        if (bl3) {
            f5 *= 0.82f;
            f2 *= 0.88f;
        }
        if (f3 > 95.0f) {
            f2 += bl ? 0.08f : 0.05f;
        }
        float f7 = f3 * f2 + f4;
        if (f3 < 3.0f) {
            f7 = Math.max(f4 * 0.45f, f3 * 0.68f);
        }
        f7 = class_3532.method_15363((float)f7, (float)(f4 * 0.45f), (float)f5);
        f7 = Math.min(f7, f3);
        return Math.signum(f) * f7;
    }

    private static VvunVVUvUNnv primaryVal(float f, float f2, WildClient modeVal, float f3, float f4, boolean bl, boolean bl2) {
        float f5 = NuUvVVvUVVUV.extraVal.descRef + modeVal.yaw * 0.72f;
        float f6 = NuUvVVvUVVUV.extraVal.activeVal + modeVal.pitch * 0.68f;
        float f7 = NuUvVVvUVVUV.primaryVal(f5, true, f3, f4, bl, bl2);
        float f8 = NuUvVVvUVVUV.primaryVal(f6, false, f3, f4, bl, bl2);
        float f9 = NuUvVVvUVVUV.secondaryVal(3.4f, 2.75f, 3.15f) * (bl ? 1.12f : 1.0f);
        float f10 = NuUvVVvUVVUV.secondaryVal(2.4f, 1.95f, 2.25f) * (bl ? 1.1f : 1.0f);
        if (bl2) {
            f9 *= 0.78f;
            f10 *= 0.78f;
        }
        NuUvVVvUVVUV.extraVal.radiusVal = NuUvVVvUVVUV.primaryVal(NuUvVVvUVVUV.extraVal.radiusVal, f7, f9);
        NuUvVVvUVVUV.extraVal.factorVal = NuUvVVvUVVUV.primaryVal(NuUvVVvUVVUV.extraVal.factorVal, f8, f10);
        float f11 = NuUvVVvUVVUV.primaryVal(NuUvVVvUVVUV.extraVal.radiusVal, f, true, f3);
        float f12 = NuUvVVvUVVUV.primaryVal(NuUvVVvUVVUV.extraVal.factorVal, f2, false, f3);
        NuUvVVvUVVUV.extraVal.radiusVal = f11 * 0.86f + NuUvVVvUVVUV.extraVal.radiusVal * 0.14f;
        NuUvVVvUVVUV.extraVal.factorVal = f12 * 0.86f + NuUvVVvUVVUV.extraVal.factorVal * 0.14f;
        return new VvunVVUvUNnv(f11, f12, f7, f8);
    }

    private static float primaryVal(float f, boolean bl, float f2, float f3, boolean bl2, boolean bl3) {
        float f4 = Math.abs(f);
        if (f4 < 0.001f) {
            return 0.0f;
        }
        float f5 = (bl ? 34.0f : 22.0f) * NuUvVVvUVVUV.secondaryVal(0.72f, 0.64f, 0.72f);
        float f6 = (float)Math.sqrt(f4) * (bl ? 2.15f : 1.55f);
        float f7 = f4 * (bl ? 0.052f : 0.04f);
        float f8 = f6 + f7;
        if (f4 < 7.0f) {
            f8 = f4 * NuUvVVvUVVUV.secondaryVal(0.54f, 0.43f, 0.48f) + (bl ? 0.12f : 0.08f);
        }
        if (NuUvVVvUVVUV.extraVal.marginVal > 0 && f2 < 30.0f) {
            f8 *= bl2 ? 0.62f : 0.42f;
        }
        if (bl3) {
            f8 *= 0.76f;
        }
        f8 *= f3;
        f8 = class_3532.method_15363((float)f8, (float)0.0f, (float)f5);
        return Math.signum(f) * Math.min(f8, f4 + (f2 < 7.0f ? (bl ? 0.8f : 0.45f) : 0.0f));
    }

    private static float primaryVal(float f, float f2, float f3) {
        float f4 = f2 - f;
        float f5 = f3 + Math.abs(f) * 0.16f;
        return f + class_3532.method_15363((float)f4, (float)(-f5), (float)f5);
    }

    private static float primaryVal(RotationLabSession.RotationSample panelVal, float f, boolean bl, boolean bl2) {
        float f2;
        float f3;
        float f4 = f3 = f > 80.0f ? 1.08f : 0.96f;
        if (panelVal != null) {
            f2 = Math.abs(panelVal.marginVal) + Math.abs(panelVal.weightVal) + Math.abs(panelVal.paramVal) * 0.035f + Math.abs(panelVal.extraVal) * 0.03f;
            f3 = 0.78f + class_3532.method_15363((float)(f2 / 7.0f), (float)0.0f, (float)1.0f) * 0.48f;
            if (panelVal.limitVal > 0.72f) {
                f3 -= 0.04f;
            }
        } else {
            f3 += (float)Math.sin((float)widthVal * 0.31f) * 0.04f;
        }
        f2 = NuUvVVvUVVUV.extraVal();
        f3 += (float)Math.sin((float)NuUvVVvUVVUV.extraVal.secondaryVal * 0.23f + NuUvVVvUVVUV.extraVal.holderVal) * 0.065f * f2;
        f3 += (float)Math.sin((float)NuUvVVvUVVUV.extraVal.secondaryVal * 0.071f + NuUvVVvUVVUV.extraVal.holderVal * 0.43f) * 0.035f * f2;
        if (NuUvVVvUVVUV.extraVal.marginVal > 0 && f < 28.0f) {
            f3 *= bl ? 0.74f : 0.58f;
        }
        if (bl) {
            f3 += 0.08f;
        }
        if (bl2) {
            f3 -= 0.12f;
        }
        return class_3532.method_15363((float)f3, (float)0.72f, (float)1.28f);
    }

    private static float secondaryVal(float f, boolean bl, boolean bl2, boolean bl3) {
        float f2 = f > 90.0f ? 0.52f : (f > 35.0f ? 0.74f : (f > 8.0f ? 1.0f : 0.86f));
        if (bl) {
            f2 *= 1.08f;
        }
        if (bl2) {
            f2 *= 0.55f;
        }
        if (!bl3) {
            f2 *= 0.45f;
        }
        return class_3532.method_15363((float)(f2 * NuUvVVvUVVUV.extraVal()), (float)0.0f, (float)2.25f);
    }

    private static WildClient primaryVal(RotationLabSession.RotationSample panelVal, float f, float f2, float f3, float f4, boolean bl) {
        float f5;
        float f6;
        float f7;
        float f8 = NuUvVVvUVVUV.primaryVal(f);
        float f9 = NuUvVVvUVVUV.primaryVal(f2);
        float f10 = 0.0f;
        float f11 = 0.0f;
        if (panelVal != null) {
            f7 = NuUvVVvUVVUV.speedVal();
            f6 = Math.abs(panelVal.marginVal) * f8 * 0.14f + panelVal.marginVal * 0.045f + Math.signum(panelVal.marginVal) * Math.min(Math.abs(panelVal.paramVal) * 0.012f, 0.42f);
            f5 = Math.abs(panelVal.weightVal) * f9 * 0.115f + panelVal.weightVal * 0.036f + Math.signum(panelVal.weightVal) * Math.min(Math.abs(panelVal.extraVal) * 0.01f, 0.34f);
            f10 += class_3532.method_15363((float)(f6 * f7), (float)-4.2f, (float)4.2f);
            f11 += class_3532.method_15363((float)(f5 * f7), (float)-2.75f, (float)2.75f);
            if (paramVal != null) {
                if (panelVal.limitVal > 0.82f && f3 < 10.0f) {
                    f10 += f8 * class_3532.method_15363((float)(Math.abs(NuUvVVvUVVUV.paramVal.extraVal) * 0.28f * f7), (float)0.0f, (float)(bl ? 1.65f : 0.95f));
                    f11 += f9 * class_3532.method_15363((float)(Math.abs(NuUvVVvUVVUV.paramVal.limitVal) * 0.22f * f7), (float)0.0f, (float)(bl ? 1.05f : 0.65f));
                }
            }
        }
        f7 = NuUvVVvUVVUV.limitVal();
        f6 = ((float)Math.sin((float)NuUvVVvUVVUV.extraVal.secondaryVal * 0.81f + NuUvVVvUVVUV.extraVal.timerVal) * 0.26f + (float)Math.sin((float)NuUvVVvUVVUV.extraVal.secondaryVal * 1.37f + NuUvVVvUVVUV.extraVal.timerVal * 0.7f) * 0.11f) * f8 * f7;
        f5 = ((float)Math.sin((float)NuUvVVvUVVUV.extraVal.secondaryVal * 0.67f + NuUvVVvUVVUV.extraVal.timerVal * 1.3f) * 0.18f + (float)Math.sin((float)NuUvVVvUVVUV.extraVal.secondaryVal * 1.11f + NuUvVVvUVVUV.extraVal.timerVal * 0.4f) * 0.075f) * f9 * f7;
        float f12 = (float)Math.sin((float)NuUvVVvUVVUV.extraVal.secondaryVal * 0.097f + NuUvVVvUVVUV.extraVal.anchorVal) * 0.34f;
        float f13 = (float)Math.sin((float)NuUvVVvUVVUV.extraVal.secondaryVal * 0.083f + NuUvVVvUVVUV.extraVal.anchorVal * 0.62f) * 0.22f;
        float f14 = class_3532.method_15363((float)(Math.abs(f2) * 0.008f), (float)0.0f, (float)0.32f) * f8;
        float f15 = class_3532.method_15363((float)(Math.abs(f) * 0.005f), (float)0.0f, (float)0.22f) * f9;
        float f16 = f3 < 7.0f ? 1.28f : (f3 < 18.0f ? 1.12f : (f3 > 65.0f ? 0.72f : 1.0f));
        f10 += f6 + f12 + f14 + NuUvVVvUVVUV.extraVal.weightRef;
        f11 += f5 + f13 + f15 + NuUvVVvUVVUV.extraVal.bufferVal;
        return new WildClient(f10 * f4 * f16, f11 * f4 * f16);
    }

    private static float primaryVal(float f, float f2, boolean bl, float f3) {
        float f4;
        float f5 = Math.abs(f2);
        if (f5 < 0.001f) {
            return 0.0f;
        }
        float f6 = f4 = bl ? 39.44f : 24.64f;
        if (f5 > 2.8f && Math.signum(f) != Math.signum(f2)) {
            f = Math.signum(f2) * Math.min(f5, bl ? 0.34f : 0.24f);
        }
        float f7 = f3 < 7.0f ? (bl ? 0.95f : 0.55f) : 0.0f;
        float f8 = Math.min(f4, f5 + f7);
        f = class_3532.method_15363((float)f, (float)(-f8), (float)f8);
        if (f3 > 5.0f && Math.abs(f) > f5) {
            f = f2;
        }
        return f;
    }

    private static float primaryVal(float f) {
        return f < 0.0f ? -1.0f : 1.0f;
    }

    private static String weightVal() {
        return paramVal == null ? "synthetic" : NuUvVVvUVVUV.paramVal.primaryVal;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int paramVal() {
        if (paramVal == null) return 0;
        if (NuUvVVvUVVUV.paramVal.blockRef == null) {
            return 0;
        }
        int n = NuUvVVvUVVUV.paramVal.blockRef.size();
        return n;
    }

    private static void primaryVal(class_1309 class_13092) {
        if (NuUvVVvUVVUV.extraVal.primaryVal == class_13092.method_5628()) {
            return;
        }
        extraVal.primaryVal();
        NuUvVVvUVVUV.extraVal.primaryVal = class_13092.method_5628();
        float f = NuUvVVvUVVUV.widthVal();
        float f2 = NuUvVVvUVVUV.blockRef();
        NuUvVVvUVVUV.extraVal.extraVal = NuUvVVvUVVUV.primaryVal(-0.16f * f, 0.16f * f);
        NuUvVVvUVVUV.extraVal.limitVal = NuUvVVvUVVUV.primaryVal(-0.1f * f, 0.12f * f);
        NuUvVVvUVVUV.extraVal.speedVal = NuUvVVvUVVUV.primaryVal(0.58f - 0.06f * f2, 0.58f + 0.1f * f2);
        NuUvVVvUVVUV.extraVal.widthVal = NuUvVVvUVVUV.primaryVal(-0.24f * f, 0.24f * f);
        NuUvVVvUVVUV.extraVal.chunkVal = NuUvVVvUVVUV.primaryVal(-0.16f * f, 0.18f * f);
        NuUvVVvUVVUV.extraVal.blockRef = NuUvVVvUVVUV.primaryVal(0.58f - 0.1f * f2, 0.58f + 0.16f * f2);
        NuUvVVvUVVUV.extraVal.tertiaryVal = NuUvVVvUVVUV.secondaryVal(false);
        NuUvVVvUVVUV.extraVal.holderVal = NuUvVVvUVVUV.primaryVal(0.0f, (float)Math.PI * 2);
        NuUvVVvUVVUV.extraVal.timerVal = NuUvVVvUVVUV.primaryVal(0.0f, (float)Math.PI * 2);
        NuUvVVvUVVUV.extraVal.anchorVal = NuUvVVvUVVUV.primaryVal(0.0f, (float)Math.PI * 2);
    }

    private static void primaryVal(float f, float f2, float f3, boolean bl, boolean bl2) {
        float f4;
        float f5;
        ++NuUvVVvUVVUV.extraVal.secondaryVal;
        if (!NuUvVVvUVVUV.extraVal.paramVal) {
            NuUvVVvUVVUV.extraVal.descRef = f2;
            NuUvVVvUVVUV.extraVal.activeVal = f3;
            NuUvVVvUVVUV.extraVal.paramVal = true;
        } else {
            f5 = NuUvVVvUVVUV.secondaryVal(0.66f, 0.48f, 0.55f);
            if (bl) {
                f5 += 0.08f;
            }
            if (bl2) {
                f5 *= 0.72f;
            }
            NuUvVVvUVVUV.extraVal.descRef += class_3532.method_15393((float)(f2 - NuUvVVvUVVUV.extraVal.descRef)) * class_3532.method_15363((float)f5, (float)0.18f, (float)0.86f);
            NuUvVVvUVVUV.extraVal.activeVal += (f3 - NuUvVVvUVVUV.extraVal.activeVal) * class_3532.method_15363((float)f5, (float)0.18f, (float)0.86f);
        }
        if (NuUvVVvUVVUV.extraVal.tertiaryVal-- <= 0) {
            f5 = NuUvVVvUVVUV.widthVal();
            f4 = NuUvVVvUVVUV.blockRef();
            NuUvVVvUVVUV.extraVal.widthVal = NuUvVVvUVVUV.primaryVal(-0.3f * f5, 0.3f * f5);
            NuUvVVvUVVUV.extraVal.chunkVal = NuUvVVvUVVUV.primaryVal(-0.2f * f5, 0.22f * f5);
            NuUvVVvUVVUV.extraVal.blockRef = NuUvVVvUVVUV.primaryVal(0.58f - 0.12f * f4, bl ? 0.58f + 0.22f * f4 : 0.58f + 0.16f * f4);
            NuUvVVvUVVUV.extraVal.tertiaryVal = NuUvVVvUVVUV.secondaryVal(bl);
        }
        f5 = (bl ? 0.16f : 0.095f) * NuUvVVvUVVUV.chunkVal();
        NuUvVVvUVVUV.extraVal.extraVal += (NuUvVVvUVVUV.extraVal.widthVal - NuUvVVvUVVUV.extraVal.extraVal) * f5;
        NuUvVVvUVVUV.extraVal.limitVal += (NuUvVVvUVVUV.extraVal.chunkVal - NuUvVVvUVVUV.extraVal.limitVal) * f5;
        NuUvVVvUVVUV.extraVal.speedVal += (NuUvVVvUVVUV.extraVal.blockRef - NuUvVVvUVVUV.extraVal.speedVal) * f5;
        if (NuUvVVvUVVUV.extraVal.marginVal > 0) {
            --NuUvVVvUVVUV.extraVal.marginVal;
        } else if (!bl2 && f > 2.2f && f < 24.0f) {
            float f6 = f4 = bl ? 0.012f : 0.034f;
            if (ThreadLocalRandom.current().nextFloat() < f4) {
                NuUvVVvUVVUV.extraVal.marginVal = ThreadLocalRandom.current().nextInt(1, bl ? 3 : 4);
            }
        }
        if (NuUvVVvUVVUV.extraVal.weightVal && f < 32.0f) {
            f4 = Math.abs(f2) - Math.abs(NuUvVVvUVVUV.extraVal.countVal);
            float f7 = Math.abs(f3) - Math.abs(NuUvVVvUVVUV.extraVal.depthVal);
            if (f4 > 0.8f) {
                NuUvVVvUVVUV.extraVal.weightRef -= Math.signum(f2) * class_3532.method_15363((float)(f4 * 0.075f), (float)0.0f, (float)0.52f);
            }
            if (f7 > 0.65f) {
                NuUvVVvUVVUV.extraVal.bufferVal -= Math.signum(f3) * class_3532.method_15363((float)(f7 * 0.055f), (float)0.0f, (float)0.34f);
            }
        }
        NuUvVVvUVVUV.extraVal.weightRef = NuUvVVvUVVUV.extraVal.weightRef * (bl ? 0.76f : 0.68f);
        NuUvVVvUVVUV.extraVal.bufferVal = NuUvVVvUVVUV.extraVal.bufferVal * (bl ? 0.74f : 0.66f);
    }

    private static void primaryVal(boolean bl, String string) {
        if (!bl) {
            return;
        }
        long l = System.currentTimeMillis();
        String string2 = "[Neuro] " + string;
        try {
            Path path = RotationLabStorage.marginVal().resolve("neuro_debug.log");
            Files.createDirectories(path.getParent(), new FileAttribute[0]);
            Files.writeString(path, (CharSequence)(l + " " + string2 + System.lineSeparator()), StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
        catch (Throwable throwable) {
        }
        if (l - timerVal < 700L) {
            return;
        }
        timerVal = l;
        ChatLogger.primaryVal(string2);
    }

    private static String secondaryVal(float f) {
        Object[] objectArray = new Object[1];
        objectArray[0] = Float.valueOf(f);
        return String.format(Locale.ROOT, "%.2f", objectArray);
    }

    private static Rotation primaryVal(class_1309 class_13092, cursorVal panelVal) {
        class_243 class_2432 = NuUvVVvUVVUV.a_.field_1724.method_33571();
        class_238 class_2383 = class_13092.method_5829();
        class_243 class_2433 = class_13092.method_19538();
        class_243 class_2434 = NuUvVVvUVVUV.a_.field_1724.method_19538().method_1020(class_2433);
        double d = Math.hypot(class_2434.field_1352, class_2434.field_1350);
        double d2 = d > 1.0E-4 ? class_2434.field_1352 / d : 0.0;
        double d3 = d > 1.0E-4 ? class_2434.field_1350 / d : 1.0;
        double d4 = d > 1.0E-4 ? class_2434.field_1350 / d : 1.0;
        double d5 = d > 1.0E-4 ? -class_2434.field_1352 / d : 0.0;
        double d6 = (double)panelVal.extraVal * Math.max(0.25, (double)class_13092.method_17681());
        double d7 = (double)panelVal.limitVal * Math.max(0.25, (double)class_13092.method_17681());
        double d8 = class_2383.field_1322 + (double)class_13092.method_17682() * 0.22;
        double d9 = class_2383.field_1322 + (double)class_13092.method_17682() * 0.84;
        class_243 class_2435 = new class_243(class_3532.method_15350((double)(class_2433.field_1352 + d4 * d6 + d2 * d7), (double)class_2383.field_1323, (double)class_2383.field_1320), class_3532.method_15350((double)(class_2383.field_1322 + (double)(class_13092.method_17682() * panelVal.speedVal)), (double)d8, (double)d9), class_3532.method_15350((double)(class_2433.field_1350 + d5 * d6 + d3 * d7), (double)class_2383.field_1321, (double)class_2383.field_1324));
        class_243 class_2436 = class_2435.method_1020(class_2432);
        float f = (float)Math.toDegrees(Math.atan2(-class_2436.field_1352, class_2436.field_1350));
        float f2 = (float)class_3532.method_15350((double)(-Math.toDegrees(Math.atan2(class_2436.field_1351, Math.hypot(class_2436.field_1352, class_2436.field_1350)))), (double)-90.0, (double)90.0);
        return new Rotation(f, f2);
    }

    private static float primaryVal(float f, float f2) {
        return f + ThreadLocalRandom.current().nextFloat() * (f2 - f);
    }

    private static int secondaryVal(boolean bl) {
        float f = NuUvVVvUVVUV.chunkVal();
        int n = Math.max(2, Math.round((bl ? 5.0f : 7.0f) / f));
        int n2 = Math.max(n + 1, Math.round((bl ? 14.0f : 22.0f) / f));
        return ThreadLocalRandom.current().nextInt(n, n2 + 1);
    }

    private static float extraVal() {
        return NuUvVVvUVVUV.secondaryVal(1.05f, 1.45f, 1.75f);
    }

    private static float limitVal() {
        return NuUvVVvUVVUV.secondaryVal(0.78f, 1.18f, 1.42f);
    }

    private static float speedVal() {
        return NuUvVVvUVVUV.secondaryVal(1.0f, 1.35f, 1.65f);
    }

    private static float widthVal() {
        return NuUvVVvUVVUV.secondaryVal(0.9f, 1.32f, 1.58f);
    }

    private static float chunkVal() {
        return NuUvVVvUVVUV.secondaryVal(0.82f, 1.08f, 1.32f);
    }

    private static float blockRef() {
        return NuUvVVvUVVUV.secondaryVal(0.78f, 1.08f, 1.32f);
    }

    private static float secondaryVal(float f, float f2, float f3) {
        float f4 = switch (AttackAuraModule.stageVal.tertiaryVal()) {
            case "Stable" -> f;
            case "Dynamic" -> f3;
            default -> f2;
        };
        return class_3532.method_15363((float)(f4 * AttackAuraModule.widthRef.tertiaryVal()), (float)0.0f, (float)3.0f);
    }

    static {
        extraVal = new cursorVal();
        limitVal = -1;
        holderVal = "Neuro idle";
    }

    static final class cursorVal {
        int primaryVal = -1;
        int secondaryVal;
        int tertiaryVal;
        int marginVal;
        boolean weightVal;
        boolean paramVal;
        float extraVal;
        float limitVal;
        float speedVal = 0.58f;
        float widthVal;
        float chunkVal;
        float blockRef = 0.58f;
        float holderVal;
        float timerVal;
        float anchorVal;
        float weightRef;
        float bufferVal;
        float countVal;
        float depthVal;
        float descRef;
        float activeVal;
        float radiusVal;
        float factorVal;

        cursorVal() {
        }

        void primaryVal() {
            this.primaryVal = -1;
            this.secondaryVal = 0;
            this.tertiaryVal = 0;
            this.marginVal = 0;
            this.weightVal = false;
            this.paramVal = false;
            this.extraVal = 0.0f;
            this.limitVal = 0.0f;
            this.speedVal = 0.58f;
            this.widthVal = 0.0f;
            this.chunkVal = 0.0f;
            this.blockRef = 0.58f;
            this.holderVal = 0.0f;
            this.timerVal = 0.0f;
            this.anchorVal = 0.0f;
            this.weightRef = 0.0f;
            this.bufferVal = 0.0f;
            this.countVal = 0.0f;
            this.depthVal = 0.0f;
            this.descRef = 0.0f;
            this.activeVal = 0.0f;
            this.radiusVal = 0.0f;
            this.factorVal = 0.0f;
        }
    }

    static final class WildClient
     {
        final float yaw;
        final float pitch;

        WildClient(float f, float f2) {
            this.yaw = f;
            this.pitch = f2;
        }

        @Override
        public final String toString() {
            return "WildClient[" + "yaw=" + this.yaw + ", " + "pitch=" + this.pitch + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.yaw, this.pitch);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            WildClient that = (WildClient)object;
            return java.util.Objects.equals(this.yaw, that.yaw) && java.util.Objects.equals(this.pitch, that.pitch);}

        public float yaw() {
            return this.yaw;
        }

        public float pitch() {
            return this.pitch;
        }
    }

    static final class VvunVVUvUNnv
     {
        final float yaw;
        final float pitch;
        final float targetYawVelocity;
        final float targetPitchVelocity;

        VvunVVUvUNnv(float f, float f2, float f3, float f4) {
            this.yaw = f;
            this.pitch = f2;
            this.targetYawVelocity = f3;
            this.targetPitchVelocity = f4;
        }

        @Override
        public final String toString() {
            return "VvunVVUvUNnv[" + "yaw=" + this.yaw + ", " + "pitch=" + this.pitch + ", " + "targetYawVelocity=" + this.targetYawVelocity + ", " + "targetPitchVelocity=" + this.targetPitchVelocity + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.yaw, this.pitch, this.targetYawVelocity, this.targetPitchVelocity);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            VvunVVUvUNnv that = (VvunVVUvUNnv)object;
            return java.util.Objects.equals(this.yaw, that.yaw) && java.util.Objects.equals(this.pitch, that.pitch) && java.util.Objects.equals(this.targetYawVelocity, that.targetYawVelocity) && java.util.Objects.equals(this.targetPitchVelocity, that.targetPitchVelocity);}

        public float yaw() {
            return this.yaw;
        }

        public float pitch() {
            return this.pitch;
        }

        public float targetYawVelocity() {
            return this.targetYawVelocity;
        }

        public float targetPitchVelocity() {
            return this.targetPitchVelocity;
        }
    }
}

