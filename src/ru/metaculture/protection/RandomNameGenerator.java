/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomNameGenerator {
    private static final String[] primaryVal;
    private static final String[] secondaryVal;

    private RandomNameGenerator() {
    }

    public static String primaryVal() {
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        return primaryVal[threadLocalRandom.nextInt(primaryVal.length)] + " " + secondaryVal[threadLocalRandom.nextInt(secondaryVal.length)];
    }

    static {
        String[] stringArray = new String[16];
        stringArray[0] = "Velvet";
        stringArray[1] = "Aurora";
        stringArray[2] = "Magnetic";
        stringArray[3] = "Prismatic";
        stringArray[4] = "Silent";
        stringArray[5] = "Crystal";
        stringArray[6] = "Solar";
        stringArray[7] = "Lunar";
        stringArray[8] = "Holographic";
        stringArray[9] = "Obsidian";
        stringArray[10] = "Radiant";
        stringArray[11] = "Neon";
        stringArray[12] = "Frosted";
        stringArray[13] = "Kinetic";
        stringArray[14] = "Vivid";
        stringArray[15] = "Phantom";
        primaryVal = stringArray;
        String[] stringArray2 = new String[16];
        stringArray2[0] = "Glass";
        stringArray2[1] = "Halo";
        stringArray2[2] = "Mica";
        stringArray2[3] = "Pulse";
        stringArray2[4] = "Mist";
        stringArray2[5] = "Bloom";
        stringArray2[6] = "Signal";
        stringArray2[7] = "Ribbon";
        stringArray2[8] = "Veil";
        stringArray2[9] = "Plate";
        stringArray2[10] = "Glow";
        stringArray2[11] = "Drift";
        stringArray2[12] = "Shell";
        stringArray2[13] = "Field";
        stringArray2[14] = "Aura";
        stringArray2[15] = "Prism";
        secondaryVal = stringArray2;
    }
}

