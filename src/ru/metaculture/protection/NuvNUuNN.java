/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;
import ru.metaculture.protection.Easings;
import ru.metaculture.protection.EasingFn;

public enum NuvNUuNN {
    LINEAR(Easings.paramVal),
    QUAD_OUT(Easings.limitVal),
    CUBIC_OUT(Easings.chunkVal),
    QUART_OUT(Easings.timerVal),
    QUINT_OUT(Easings.bufferVal),
    SINE_OUT(Easings.descRef),
    CIRC_OUT(Easings.factorVal),
    ELASTIC_OUT(Easings.phaseVal),
    EXPO_OUT(Easings.groupVal),
    BACK_OUT(Easings.themeVal),
    BOUNCE_OUT(Easings.widthRef);
    private final EasingFn primaryVal;
    public String toString() {
        String string = this.name().toLowerCase();
        String[] stringArray = string.split("_");
        StringBuilder stringBuilder = new StringBuilder();
        String[] stringArray2 = stringArray;
        int n = stringArray2.length;
        for (int i = 0; i < n; ++i) {
            String string2 = stringArray2[i];
            stringBuilder.append(Character.toUpperCase(string2.charAt(0))).append(string2.substring(1)).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    @Generated
    public EasingFn primaryVal() {
        return this.primaryVal;
    }

    @Generated
    private NuvNUuNN(EasingFn nVunNUvNVN2) {
        this.primaryVal = nVunNUvNVN2;
    }}

