/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;
import ru.metaculture.protection.EasingFn;

public final class Easings {
    public static final double primaryVal = 1.70158;
    public static final double secondaryVal = 2.5949095;
    public static final double tertiaryVal = 2.70158;
    public static final double marginVal = 2.0943951023931953;
    public static final double weightVal = 1.3962634015954636;
    public static final EasingFn paramVal = d -> d;
    public static final EasingFn extraVal = Easings.primaryVal(2);
    public static final EasingFn limitVal = Easings.secondaryVal(2);
    public static final EasingFn speedVal = Easings.tertiaryVal(2.0);
    public static final EasingFn widthVal = Easings.primaryVal(3);
    public static final EasingFn chunkVal = Easings.secondaryVal(3);
    public static final EasingFn blockRef = Easings.tertiaryVal(3.0);
    public static final EasingFn holderVal = Easings.primaryVal(4);
    public static final EasingFn timerVal = Easings.secondaryVal(4);
    public static final EasingFn anchorVal = Easings.tertiaryVal(4.0);
    public static final EasingFn weightRef = Easings.primaryVal(5);
    public static final EasingFn bufferVal = Easings.secondaryVal(5);
    public static final EasingFn countVal = Easings.tertiaryVal(5.0);
    public static final EasingFn depthVal = d -> 1.0 - Math.cos(d * Math.PI / 2.0);
    public static final EasingFn descRef = d -> Math.sin(d * Math.PI / 2.0);
    public static final EasingFn activeVal = d -> -(Math.cos(Math.PI * d) - 1.0) / 2.0;
    public static final EasingFn radiusVal = d -> 1.0 - Math.sqrt(1.0 - Math.pow(d, 2.0));
    public static final EasingFn factorVal = d -> Math.sqrt(1.0 - Math.pow(d - 1.0, 2.0));
    public static final EasingFn sourceVal = d -> d < 0.5 ? (1.0 - Math.sqrt(1.0 - Math.pow(2.0 * d, 2.0))) / 2.0 : (Math.sqrt(1.0 - Math.pow(-2.0 * d + 2.0, 2.0)) + 1.0) / 2.0;
    public static final EasingFn extraRef = d -> d != 0.0 && d != 1.0 ? Math.pow(-2.0, 10.0 * d - 10.0) * Math.sin((d * 10.0 - 10.75) * 2.0943951023931953) : d;
    public static final EasingFn phaseVal = d -> d != 0.0 && d != 1.0 ? Math.pow(2.0, -10.0 * d) * Math.sin((d * 10.0 - 0.75) * 2.0943951023931953) + 1.0 : d;
    public static final EasingFn limitRef = d -> {
        if (d != 0.0 && d != 1.0) {
            return d < 0.5 ? -(Math.pow(2.0, 20.0 * d - 10.0) * Math.sin((20.0 * d - 11.125) * 1.3962634015954636)) / 2.0 : Math.pow(2.0, -20.0 * d + 10.0) * Math.sin((20.0 * d - 11.125) * 1.3962634015954636) / 2.0 + 1.0;
        }
        return d;
    };
    public static final EasingFn paramRef = d -> d != 0.0 ? Math.pow(2.0, 10.0 * d - 10.0) : d;
    public static final EasingFn groupVal = d -> d != 1.0 ? 1.0 - Math.pow(2.0, -10.0 * d) : d;
    public static final EasingFn layerVal = d -> {
        if (d != 0.0 && d != 1.0) {
            return d < 0.5 ? Math.pow(2.0, 20.0 * d - 10.0) / 2.0 : (2.0 - Math.pow(2.0, -20.0 * d + 10.0)) / 2.0;
        }
        return d;
    };
    public static final EasingFn slotVal = d -> 2.70158 * Math.pow(d, 3.0) - 1.70158 * Math.pow(d, 2.0);
    public static final EasingFn themeVal = d -> 1.0 + 2.70158 * Math.pow(d - 1.0, 3.0) + 1.70158 * Math.pow(d - 1.0, 2.0);
    public static final EasingFn stageVal = d -> d < 0.5 ? Math.pow(2.0 * d, 2.0) * (7.189819 * d - 2.5949095) / 2.0 : (Math.pow(2.0 * d - 2.0, 2.0) * (3.5949095 * (d * 2.0 - 2.0) + 2.5949095) + 2.0) / 2.0;
    public static final EasingFn widthRef = d -> {
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
    public static final EasingFn trackVal = d -> 1.0 - widthRef.ease(1.0 - d);
    public static final EasingFn modeRef = d -> d < 0.5 ? (1.0 - widthRef.ease(1.0 - 2.0 * d)) / 2.0 : (1.0 + widthRef.ease(2.0 * d - 1.0)) / 2.0;

    public static EasingFn primaryVal(double d) {
        return d2 -> Math.pow(d2, d);
    }

    public static EasingFn primaryVal(int n) {
        return Easings.primaryVal((double)n);
    }

    public static EasingFn secondaryVal(double d) {
        return d2 -> 1.0 - Math.pow(1.0 - d2, d);
    }

    public static EasingFn secondaryVal(int n) {
        return Easings.secondaryVal((double)n);
    }

    public static EasingFn tertiaryVal(double d) {
        return d2 -> d2 < 0.5 ? Math.pow(2.0, d - 1.0) * Math.pow(d2, d) : 1.0 - Math.pow(-2.0 * d2 + 2.0, d) / 2.0;
    }

    @Generated
    private Easings() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

