/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Locale;
import ru.metaculture.protection.NodeDefinition;

public final class NodeSearchScorer {
    private NodeSearchScorer() {
    }

    public static SearchMatch primaryVal(NodeDefinition spanJ, String string) {
        int[] nArray;
        int n;
        block13: {
            String string2 = spanJ.secondaryVal().toLowerCase(Locale.ROOT);
            n = 0;
            nArray = NodeSearchScorer.primaryVal(string2, string);
            if (nArray == null) break block13;
            n += 30;
            if (string2.startsWith(string)) {
                n += 90;
            } else if (string2.contains(string)) {
                n += 48;
            }
            int prev = -2;
            for (int pos : nArray) {
                block15: {
                    block14: {
                        if (pos == prev + 1) {
                            n += 10;
                        } else if (pos > prev + 1 && prev >= 0) {
                            n -= Math.min(pos - prev - 1, 6);
                        }
                        if (pos == 0) break block14;
                        if (!NodeSearchScorer.primaryVal(string2.charAt(pos - 1))) break block15;
                    }
                    n += 14;
                }
                prev = pos;
            }
        }
        String string3 = spanJ.primaryVal().toLowerCase(Locale.ROOT);
        String string4 = spanJ.tertiaryVal().toLowerCase(Locale.ROOT);
        if (string3.contains(string)) {
            n += 22;
        }
        if (string4.contains(string)) {
            n += 10;
        }
        if (n <= 0) {
            return null;
        }
        return new SearchMatch(spanJ, n, nArray == null ? new int[]{} : nArray);
    }

    public static int[] primaryVal(String string, String string2) {
        int[] nArray = new int[string2.length()];
        int n = 0;
        for (int i = 0; i < string2.length(); ++i) {
            int n2 = string.indexOf(string2.charAt(i), n);
            if (n2 < 0) {
                return null;
            }
            nArray[i] = n2;
            n = n2 + 1;
        }
        return nArray;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(char c) {
        if (c == ' ') return true;
        if (c == '_') return true;
        if (c == '.') return true;
        if (c == '-') return true;
        if (c == '(') return true;
        if (c != '/') return false;
        return true;
    }

    public record SearchMatch(NodeDefinition def, int score, int[] titlePositions) {
    }
}

