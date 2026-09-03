/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import ru.metaculture.protection.WorldMarker;

public final class NuuvVnVNN {
    private static final List<WorldMarker> primaryVal = new ArrayList<WorldMarker>();

    private NuuvVnVNN() {
    }

    public static void primaryVal(WorldMarker raftG) {
        NuuvVnVNN.primaryVal(raftG.primaryVal());
        primaryVal.add(raftG);
    }

    public static boolean primaryVal(String string) {
        boolean bl = false;
        for (int i = 0; i < primaryVal.size(); ++i) {
            WorldMarker raftG = primaryVal.get(i);
            if (!raftG.weightVal()) continue;
            if (!raftG.primaryVal().equalsIgnoreCase(string)) continue;
            raftG.paramVal();
            bl = true;
        }
        return bl;
    }

    public static int primaryVal() {
        int n = 0;
        for (int i = 0; i < primaryVal.size(); ++i) {
            WorldMarker raftG = primaryVal.get(i);
            if (!raftG.weightVal()) continue;
            raftG.paramVal();
            ++n;
        }
        return n;
    }

    public static void secondaryVal() {
        for (int i = primaryVal.size() - 1; i >= 0; --i) {
            if (!primaryVal.get(i).extraVal()) continue;
            primaryVal.remove(i);
        }
    }

    public static boolean tertiaryVal() {
        return primaryVal.isEmpty();
    }

    public static int marginVal() {
        return primaryVal.size();
    }

    public static WorldMarker primaryVal(int n) {
        return primaryVal.get(n);
    }

    public static WorldMarker secondaryVal(String string) {
        for (int i = 0; i < primaryVal.size(); ++i) {
            WorldMarker raftG = primaryVal.get(i);
            if (!raftG.weightVal()) continue;
            if (!raftG.primaryVal().equalsIgnoreCase(string)) continue;
            return raftG;
        }
        return null;
    }

    public static int weightVal() {
        int n = 0;
        for (int i = 0; i < primaryVal.size(); ++i) {
            if (!primaryVal.get(i).weightVal()) continue;
            ++n;
        }
        return n;
    }

    public static List<String> paramVal() {
        ArrayList<String> arrayList = new ArrayList<String>(primaryVal.size());
        for (int i = 0; i < primaryVal.size(); ++i) {
            WorldMarker raftG = primaryVal.get(i);
            if (!raftG.weightVal()) continue;
            arrayList.add(raftG.primaryVal());
        }
        return arrayList;
    }

    public static String tertiaryVal(String string) {
        for (int i = 1; i < 1000; ++i) {
            String string2 = string + " " + i;
            if (NuuvVnVNN.marginVal(string2)) continue;
            return string2;
        }
        return string;
    }

    private static boolean marginVal(String string) {
        for (int i = 0; i < primaryVal.size(); ++i) {
            WorldMarker raftG = primaryVal.get(i);
            if (!raftG.weightVal() || !raftG.primaryVal().toLowerCase(Locale.ROOT).equals(string.toLowerCase(Locale.ROOT))) continue;
            return true;
        }
        return false;
    }
}

