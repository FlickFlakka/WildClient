/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  it.unimi.dsi.fastutil.objects.Reference2ByteOpenHashMap
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2591
 *  net.minecraft.class_2680
 */
package ru.metaculture.protection;

import it.unimi.dsi.fastutil.objects.Reference2ByteOpenHashMap;
import java.util.function.Predicate;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2591;
import net.minecraft.class_2680;

public final class RegistryIdUtil {
    public static final int primaryVal = 0;
    public static final int secondaryVal = 1;
    public static final int tertiaryVal = 2;
    public static final int marginVal = 3;
    public static final int weightVal = 4;
    public static final int paramVal = 5;
    public static final int extraVal = 6;
    public static final int limitVal = 7;
    public static final int speedVal = 8;
    public static final int widthVal = 9;
    public static final int chunkVal = 10;
    public static final int blockRef = 11;
    public static final int holderVal = 12;
    public static final int timerVal = 13;
    public static final int anchorVal = 14;
    public static final int weightRef = 15;
    public static final int bufferVal = 16;
    public static final int countVal = 17;
    public static final int depthVal = 18;
    public static final int descRef = 19;
    public static final int activeVal = 20;
    public static final int radiusVal = 21;
    public static final int factorVal = 22;
    public static final int sourceVal = 12;
    public static final int extraRef = 0x3FF000;
    public static final int phaseVal = 4095;
    private static final byte limitRef = -1;
    private static final Reference2ByteOpenHashMap<class_2248> paramRef = new Reference2ByteOpenHashMap();
    private static final Reference2ByteOpenHashMap<class_2591<?>> groupVal = new Reference2ByteOpenHashMap();
    private static final class_2591<?>[] layerVal = new class_2591[12];
    private static final int[] slotVal = new int[22];
    private static final Predicate<class_2680> themeVal = class_26802 -> paramRef.getByte((Object)class_26802.method_26204()) != -1;

    private RegistryIdUtil() {
    }

    private static void primaryVal(class_2248 class_22482, int n) {
        paramRef.put(class_22482, (byte)n);
    }

    private static void primaryVal(class_2591<?> class_25912, int n) {
        groupVal.put(class_25912, (byte)n);
        RegistryIdUtil.layerVal[n] = class_25912;
    }

    public static class_2591<?> primaryVal(int n) {
        return n >= 0 && n < layerVal.length ? layerVal[n] : null;
    }

    public static Predicate<class_2680> primaryVal() {
        return themeVal;
    }

    public static int primaryVal(class_2680 class_26802) {
        return paramRef.getByte((Object)class_26802.method_26204());
    }

    public static int primaryVal(class_2591<?> class_25912) {
        return groupVal.getByte(class_25912);
    }

    public static int secondaryVal(int n) {
        return slotVal[n];
    }

    static {
        paramRef.defaultReturnValue((byte)-1);
        groupVal.defaultReturnValue((byte)-1);
        RegistryIdUtil.primaryVal(class_2246.field_10418, 12);
        RegistryIdUtil.primaryVal(class_2246.field_29219, 12);
        RegistryIdUtil.primaryVal(class_2246.field_10212, 13);
        RegistryIdUtil.primaryVal(class_2246.field_29027, 13);
        RegistryIdUtil.primaryVal(class_2246.field_10571, 14);
        RegistryIdUtil.primaryVal(class_2246.field_29026, 14);
        RegistryIdUtil.primaryVal(class_2246.field_23077, 14);
        RegistryIdUtil.primaryVal(class_2246.field_27120, 15);
        RegistryIdUtil.primaryVal(class_2246.field_29221, 15);
        RegistryIdUtil.primaryVal(class_2246.field_10090, 16);
        RegistryIdUtil.primaryVal(class_2246.field_29028, 16);
        RegistryIdUtil.primaryVal(class_2246.field_10080, 17);
        RegistryIdUtil.primaryVal(class_2246.field_29030, 17);
        RegistryIdUtil.primaryVal(class_2246.field_10442, 18);
        RegistryIdUtil.primaryVal(class_2246.field_29029, 18);
        RegistryIdUtil.primaryVal(class_2246.field_10013, 19);
        RegistryIdUtil.primaryVal(class_2246.field_29220, 19);
        RegistryIdUtil.primaryVal(class_2246.field_10213, 20);
        RegistryIdUtil.primaryVal(class_2246.field_22109, 21);
        RegistryIdUtil.primaryVal(class_2591.field_11914, 0);
        RegistryIdUtil.primaryVal(class_2591.field_11891, 1);
        RegistryIdUtil.primaryVal(class_2591.field_11901, 2);
        RegistryIdUtil.primaryVal(class_2591.field_11889, 3);
        RegistryIdUtil.primaryVal(class_2591.field_16411, 4);
        RegistryIdUtil.primaryVal(class_2591.field_11888, 5);
        RegistryIdUtil.primaryVal(class_2591.field_11887, 6);
        RegistryIdUtil.primaryVal(class_2591.field_11899, 7);
        RegistryIdUtil.primaryVal(class_2591.field_11903, 8);
        RegistryIdUtil.primaryVal(class_2591.field_11896, 9);
        RegistryIdUtil.primaryVal(class_2591.field_42781, 10);
        RegistryIdUtil.primaryVal(class_2591.field_42780, 11);
        RegistryIdUtil.slotVal[12] = 0x242424;
        RegistryIdUtil.slotVal[13] = 14200728;
        RegistryIdUtil.slotVal[14] = 16766720;
        RegistryIdUtil.slotVal[15] = 13137226;
        RegistryIdUtil.slotVal[16] = 2647255;
        RegistryIdUtil.slotVal[17] = 14818075;
        RegistryIdUtil.slotVal[18] = 5629672;
        RegistryIdUtil.slotVal[19] = 0x26D66D;
        RegistryIdUtil.slotVal[20] = 15787216;
        RegistryIdUtil.slotVal[21] = 9128501;
    }
}

