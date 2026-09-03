/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public enum UvnnvunNNuVV {
    MODELS("models", "Models"),
    ITEMS("items", "Items"),
    PETS("pets", "Pets");
    private final String primaryVal;
    private final String secondaryVal;
    private UvnnvunNNuVV(String string2, String string3) {
        this.primaryVal = string2;
        this.secondaryVal = string3;
    }

    public String primaryVal() {
        return this.primaryVal;
    }

    public String secondaryVal() {
        return this.secondaryVal;
    }

    public static UvnnvunNNuVV primaryVal(String string) {
        if (string != null) {
            UvnnvunNNuVV[] uvnnvunNNuVVArray = UvnnvunNNuVV.values();
            int n = uvnnvunNNuVVArray.length;
            for (int i = 0; i < n; ++i) {
                UvnnvunNNuVV uvnnvunNNuVV = uvnnvunNNuVVArray[i];
                if (!uvnnvunNNuVV.primaryVal.equalsIgnoreCase(string)) continue;
                return uvnnvunNNuVV;
            }
        }
        return MODELS;
    }}

