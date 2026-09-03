/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.function.Function;

public enum AnimationEasing {
    LINEAR(d -> d),
    SIGMOID(d -> 1.0 / (1.0 + Math.exp(-d.doubleValue()))),
    EASE_IN_QUAD(d -> d * d),
    EASE_OUT_QUAD(d -> d * (2.0 - d)),
    EASE_IN_OUT_QUAD(d -> d < 0.5 ? 2.0 * d * d : -1.0 + (4.0 - 2.0 * d) * d),
    EASE_IN_CUBIC(d -> d * d * d),
    EASE_OUT_CUBIC(d -> { d = d - 1.0; return d * d * d + 1.0; }),
    EASE_IN_OUT_CUBIC(d -> d < 0.5 ? 4.0 * d * d * d : (d - 1.0) * (2.0 * d - 2.0) * (2.0 * d - 2.0) + 1.0),
    EASE_IN_QUART(d -> d * d * d * d),
    EASE_OUT_QUART(d -> { d = d - 1.0; return 1.0 - d * d * d * d; }),
    EASE_IN_OUT_QUART(d -> { double d2; if (d < 0.5) { d2 = 8.0 * d * d * d * d; } else { d = d - 1.0; d2 = 1.0 - 8.0 * d * d * d * d; } return d2; }),
    EASE_IN_QUINT(d -> d * d * d * d * d),
    EASE_OUT_QUINT(d -> { d = d - 1.0; return 1.0 + d * d * d * d * d; }),
    EASE_IN_OUT_QUINT(d -> { double d2; if (d < 0.5) { d2 = 16.0 * d * d * d * d * d; } else { d = d - 1.0; d2 = 1.0 + 16.0 * d * d * d * d * d; } return d2; }),
    EASE_IN_SINE(d -> 1.0 - Math.cos(d * Math.PI / 2.0)),
    EASE_OUT_SINE(d -> Math.sin(d * Math.PI / 2.0)),
    EASE_IN_OUT_SINE(d -> 1.0 - Math.cos(Math.PI * d / 2.0)),
    EASE_IN_EXPO(d -> d == 0.0 ? 0.0 : Math.pow(2.0, 10.0 * d - 10.0)),
    EASE_OUT_EXPO(d -> d == 1.0 ? 1.0 : 1.0 - Math.pow(2.0, -10.0 * d)),
    EASE_IN_OUT_EXPO(d -> d == 0.0 ? 0.0 : (d == 1.0 ? 1.0 : (d < 0.5 ? Math.pow(2.0, 20.0 * d - 10.0) / 2.0 : (2.0 - Math.pow(2.0, -20.0 * d + 10.0)) / 2.0))),
    EASE_IN_CIRC(d -> 1.0 - Math.sqrt(1.0 - d * d)),
    EASE_OUT_CIRC(d -> { d = d - 1.0; return Math.sqrt(1.0 - d * d); }),
    EASE_IN_OUT_CIRC(d -> d < 0.5 ? (1.0 - Math.sqrt(1.0 - 4.0 * d * d)) / 2.0 : (Math.sqrt(1.0 - 4.0 * (d - 1.0) * d) + 1.0) / 2.0),
    EASE_IN_BACK(d -> 2.70158 * d * d * d - 1.70158 * d * d),
    EASE_OUT_BACK(d -> 1.0 + 2.70158 * Math.pow(d - 1.0, 3.0) + 1.70158 * Math.pow(d - 1.0, 2.0)),
    EASE_IN_OUT_BACK(d -> d < 0.5 ? Math.pow(2.0 * d, 2.0) * (7.189819 * d - 2.5949095) / 2.0 : (Math.pow(2.0 * d - 2.0, 2.0) * (3.5949095 * (d * 2.0 - 2.0) + 2.5949095) + 2.0) / 2.0),
    EASE_IN_ELASTIC(d -> d == 0.0 ? 0.0 : (d == 1.0 ? 1.0 : -Math.pow(2.0, 10.0 * d - 10.0) * Math.sin((d * 10.0 - 10.75) * 2.0943951023931953))),
    EASE_OUT_ELASTIC(d -> d == 0.0 ? 0.0 : (d == 1.0 ? 1.0 : Math.pow(2.0, -10.0 * d) * Math.sin((d * 10.0 - 0.75) * 2.0943951023931953) * 0.5 + 1.0)),
    EASE_IN_OUT_ELASTIC(d -> d == 0.0 ? 0.0 : (d == 1.0 ? 1.0 : (d < 0.5 ? -(Math.pow(2.0, 20.0 * d - 10.0) * Math.sin((20.0 * d - 11.125) * 1.3962634015954636)) / 2.0 : Math.pow(2.0, -20.0 * d + 10.0) * Math.sin((20.0 * d - 11.125) * 1.3962634015954636) / 2.0 + 1.0))),
    SHRINK_EASING(d -> { float f = 1.3f; float f2 = f + 1.0f; return Math.max(0.0, 1.0 + (double)f2 * Math.pow(d - 1.0, 3.0) + (double)f * Math.pow(d - 1.0, 2.0)); });
    private final Function<Double, Double> primaryVal;
    private AnimationEasing(Function<Double, Double> function) {
        this.primaryVal = function;
    }

    public Function<Double, Double> primaryVal() {
        return this.primaryVal;
    }

    public double primaryVal(double d) {
        return this.primaryVal().apply(d);
    }

    public float primaryVal(float f) {
        return this.primaryVal().apply(Double.valueOf(f)).floatValue();
    }

    public static String primaryVal(String string) {
        int n;
        if (string != null && (n = string.length()) != 0) {
            char c = string.charAt(0);
            char c2 = Character.toTitleCase(c);
            if (c == c2) {
                return string;
            }
            char[] cArray = new char[n];
            cArray[0] = c2;
            string.getChars(1, n, cArray, 1);
            return String.valueOf(cArray);
        }
        return string;
    }

    public String toString() {
        return AnimationEasing.primaryVal(super.toString().toLowerCase().replace("_", " "));
    }}

