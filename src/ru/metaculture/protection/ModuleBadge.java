/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Locale;
import ru.metaculture.protection.ModuleCategory;

public enum ModuleBadge {
    NEW("New", -14494738, "E", 10),
    RISKY("Risky", -50340, "I", 20),
    PATCHED("Patched", -20448, "O", 30),
    GRIM("Grim", -15681151, "Q", 40),
    MATRIX("Matrix", -5083905, "W", 50),
    VIP("VIP", -6511697, "T", 60),
    COMBAT("Combat", -45709, "f", 200),
    MOVEMENT("Movement", -10034009, "b", 210),
    VISUALS("Visuals", -8861697, "n", 220),
    PLAYER("Player", -11930, "m", 230),
    MISC("Misc", -3889153, "v", 240);
    private final String primaryVal;
    private final int secondaryVal;
    private final String tertiaryVal;
    private final int marginVal;
    ModuleBadge(String string2, int n2, String string3, int n3) {
        this.primaryVal = string2;
        this.secondaryVal = n2;
        this.tertiaryVal = string3;
        this.marginVal = n3;
    }

    public String primaryVal() {
        return this.primaryVal;
    }

    public int secondaryVal() {
        return this.secondaryVal;
    }

    public String tertiaryVal() {
        return this.tertiaryVal;
    }

    public int marginVal() {
        return this.marginVal;
    }

    public static ModuleBadge primaryVal(String string) {
        if (string == null) {
            return null;
        }
        String string2 = ModuleBadge.secondaryVal(string);
        if (string2.isEmpty()) {
            return null;
        }
        ModuleBadge[] uVUNNUnNvUArray = ModuleBadge.values();
        int n = uVUNNUnNvUArray.length;
        for (int i = 0; i < n; ++i) {
            ModuleBadge linkG = uVUNNUnNvUArray[i];
            if (!ModuleBadge.secondaryVal(linkG.name()).equals(string2) && !ModuleBadge.secondaryVal(linkG.primaryVal).equals(string2)) continue;
            return linkG;
        }
        return null;
    }

    public static ModuleBadge primaryVal(ModuleCategory linkC) {
        if (linkC == null) {
            return null;
        }
        return switch (linkC) {
            default -> throw new MatchException(null, null);
            case ModuleCategory.Combat -> COMBAT;
            case ModuleCategory.Movement -> MOVEMENT;
            case ModuleCategory.Visuals -> VISUALS;
            case ModuleCategory.Player -> PLAYER;
            case ModuleCategory.Misc -> MISC;
        };
    }

    private static String secondaryVal(String string) {
        String string2;
        String string3 = string2 = string == null ? "" : string.trim().toLowerCase(Locale.ROOT);
        if (string2.startsWith("#")) {
            string2 = string2.substring(1);
        }
        return string2.replace("-", "").replace("_", "").replace(" ", "");
    }

}

