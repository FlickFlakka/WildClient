/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Locale;

public enum SkyThemePreset {
    AURORA("Aurora", "Aurora Borealis"),
    STARDUST("Stardust", "Star Dust", "Stardust Field"),
    TWILIGHT_RAYLEIGH("Twilight Rayleigh", "Solar Storm", "Zodiacal Dawn", "Noctilucent Clouds"),
    QUANTUM_NEBULA("Quantum Nebula", "Nebula"),
    CHRONOS_SINGULARITY("Chronos Singularity", "Galactic Veil", "Supercell on the Horizon");
    private final String primaryVal;
    private final String[] secondaryVal;
    private SkyThemePreset(String string2, String ... stringArray) {
        this.primaryVal = string2;
        this.secondaryVal = stringArray;
    }

    public String primaryVal() {
        return this.primaryVal;
    }

    public int secondaryVal() {
        return this.ordinal();
    }

    public static String[] tertiaryVal() {
        SkyThemePreset[] silkF = SkyThemePreset.values();
        String[] stringArray = new String[silkF.length];
        for (int i = 0; i < silkF.length; ++i) {
            stringArray[i] = silkF[i].primaryVal;
        }
        return stringArray;
    }

    public static SkyThemePreset primaryVal(String string) {
        block7: {
            block6: {
                if (string == null) break block6;
                if (!string.isBlank()) break block7;
            }
            return AURORA;
        }
        String string2 = SkyThemePreset.secondaryVal(string);
        for (SkyThemePreset baseJ : SkyThemePreset.values()) {
            if (SkyThemePreset.secondaryVal(baseJ.primaryVal).equals(string2) || SkyThemePreset.secondaryVal(baseJ.name()).equals(string2)) {
                return baseJ;
            }
            for (String string3 : baseJ.secondaryVal) {
                if (!SkyThemePreset.secondaryVal(string3).equals(string2)) continue;
                return baseJ;
            }
        }
        return AURORA;
    }

    private static String secondaryVal(String string) {
        return string.trim().replace('_', ' ').toLowerCase(Locale.ROOT);
    }}

