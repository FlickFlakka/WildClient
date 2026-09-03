/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import ru.metaculture.protection.Interpolator;

public final class Easing {
    public static final double primaryVal = 1.70158;
    public static final double secondaryVal = 2.5949095;
    public static final double tertiaryVal = 2.70158;
    public static final double marginVal = 2.0943951023931953;
    public static final double weightVal = 1.3962634015954636;
    public static final Interpolator paramVal = d -> d;
    public static final Interpolator extraVal = Easing.primaryVal(2);
    public static final Interpolator limitVal = Easing.secondaryVal(2);
    public static final Interpolator speedVal = Easing.tertiaryVal(2.0);
    public static final Interpolator widthVal = Easing.primaryVal(3);
    public static final Interpolator chunkVal = Easing.secondaryVal(3);
    public static final Interpolator blockRef = Easing.tertiaryVal(3.0);
    public static final Interpolator holderVal = Easing.primaryVal(4);
    public static final Interpolator timerVal = Easing.secondaryVal(4);
    public static final Interpolator anchorVal = Easing.tertiaryVal(4.0);
    public static final Interpolator weightRef = Easing.primaryVal(5);
    public static final Interpolator bufferVal = Easing.secondaryVal(5);
    public static final Interpolator countVal = Easing.tertiaryVal(5.0);
    public static final Interpolator depthVal = d -> 1.0 - Math.cos(d * Math.PI / 2.0);
    public static final Interpolator descRef = d -> Math.sin(d * Math.PI / 2.0);
    public static final Interpolator activeVal = d -> -(Math.cos(Math.PI * d) - 1.0) / 2.0;
    public static final Interpolator radiusVal = d -> 1.0 - Math.sqrt(1.0 - Math.pow(d, 2.0));
    public static final Interpolator factorVal = d -> Math.sqrt(1.0 - Math.pow(d - 1.0, 2.0));
    public static final Interpolator sourceVal = d -> d < 0.5 ? (1.0 - Math.sqrt(1.0 - Math.pow(2.0 * d, 2.0))) / 2.0 : (Math.sqrt(1.0 - Math.pow(-2.0 * d + 2.0, 2.0)) + 1.0) / 2.0;
    public static final Interpolator extraRef = d -> {
        double d2;
        if (d != 0.0) {
            if (d != 1.0) {
                d2 = Math.pow(-2.0, 10.0 * d - 10.0) * Math.sin((d * 10.0 - 10.75) * 2.0943951023931953);
                return d2;
            }
        }
        d2 = d;
        return d2;
    };
    public static final Interpolator phaseVal = d -> {
        double d2;
        if (d != 0.0) {
            if (d != 1.0) {
                d2 = Math.pow(2.0, -10.0 * d) * Math.sin((d * 10.0 - 0.75) * 2.0943951023931953) + 1.0;
                return d2;
            }
        }
        d2 = d;
        return d2;
    };
    public static final Interpolator limitRef = d -> {
        if (d != 0.0 && d != 1.0) {
            return d < 0.5 ? -(Math.pow(2.0, 20.0 * d - 10.0) * Math.sin((20.0 * d - 11.125) * 1.3962634015954636)) / 2.0 : Math.pow(2.0, -20.0 * d + 10.0) * Math.sin((20.0 * d - 11.125) * 1.3962634015954636) / 2.0 + 1.0;
        }
        return d;
    };
    public static final Interpolator paramRef = d -> d != 0.0 ? Math.pow(2.0, 10.0 * d - 10.0) : d;
    public static final Interpolator groupVal = d -> d != 1.0 ? 1.0 - Math.pow(2.0, -10.0 * d) : d;
    public static final Interpolator layerVal = d -> {
        if (d != 0.0) {
            if (d != 1.0) {
                return d < 0.5 ? Math.pow(2.0, 20.0 * d - 10.0) / 2.0 : (2.0 - Math.pow(2.0, -20.0 * d + 10.0)) / 2.0;
            }
        }
        return d;
    };
    public static final Interpolator slotVal = d -> 2.70158 * Math.pow(d, 3.0) - 1.70158 * Math.pow(d, 2.0);
    public static final Interpolator themeVal = d -> 1.0 + 2.70158 * Math.pow(d - 1.0, 3.0) + 1.70158 * Math.pow(d - 1.0, 2.0);
    public static final Interpolator stageVal = d -> d < 0.5 ? Math.pow(2.0 * d, 2.0) * (7.189819 * d - 2.5949095) / 2.0 : (Math.pow(2.0 * d - 2.0, 2.0) * (3.5949095 * (d * 2.0 - 2.0) + 2.5949095) + 2.0) / 2.0;
    public static final Interpolator widthRef = d -> {
        double d2 = 7.5625;
        double d3 = 2.75;
        if (d < 1.0 / d3) {
            return d2 * Math.pow(d, 2.0);
        }
        if (d < 2.0 / d3) {
            return d2 * Math.pow(d - 1.5 / d3, 2.0) + 0.75;
        }
        return d < 2.5 / d3 ? d2 * Math.pow(d - 2.25 / d3, 2.0) + 0.9375 : d2 * Math.pow(d - 2.625 / d3, 2.0) + 0.984375;
    };
    public static final Interpolator trackVal = d -> 1.0 - widthRef.ease(1.0 - d);
    public static final Interpolator modeRef = d -> d < 0.5 ? (1.0 - widthRef.ease(1.0 - 2.0 * d)) / 2.0 : (1.0 + widthRef.ease(2.0 * d - 1.0)) / 2.0;

    private Easing() {
    }

    public static Interpolator primaryVal(double d) {
        return d2 -> Math.pow(d2, d);
    }

    public static Interpolator primaryVal(int n) {
        return Easing.primaryVal((double)n);
    }

    public static Interpolator secondaryVal(double d) {
        return d2 -> 1.0 - Math.pow(1.0 - d2, d);
    }

    public static Interpolator secondaryVal(int n) {
        return Easing.secondaryVal((double)n);
    }

    public static Interpolator tertiaryVal(double d) {
        return d2 -> d2 < 0.5 ? Math.pow(2.0, d - 1.0) * Math.pow(d2, d) : 1.0 - Math.pow(-2.0 * d2 + 2.0, d) / 2.0;
    }
}

