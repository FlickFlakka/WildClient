/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 */
package ru.metaculture.protection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.Arrays;
import java.util.function.Supplier;
import ru.metaculture.protection.Setting;

public class StringSlotSetting
extends Setting {
    private static final int marginVal = 9;
    private final String[] weightVal = new String[9];
    private final String[] paramVal = new String[9];

    public StringSlotSetting(String string) {
        this.primaryVal = string;
        Arrays.fill(this.weightVal, "");
        Arrays.fill(this.paramVal, "");
    }

    public String primaryVal(int n) {
        if (n < 0 || n >= 9) {
            return "";
        }
        return this.weightVal[n] == null ? "" : this.weightVal[n];
    }

    public void primaryVal(int n, String string) {
        if (n < 0 || n >= 9) {
            return;
        }
        this.weightVal[n] = string == null ? "" : string.trim();
    }

    public void secondaryVal(int n) {
        this.primaryVal(n, "");
    }

    public void tertiaryVal() {
        Arrays.fill(this.weightVal, "");
    }

    public boolean marginVal() {
        String[] stringArray = this.weightVal;
        for (String string : stringArray) {
            if (string == null || string.isBlank()) continue;
            return false;
        }
        return true;
    }

    public String[] weightVal() {
        return Arrays.copyOf(this.weightVal, this.weightVal.length);
    }

    public JsonArray extraVal() {
        JsonArray jsonArray = new JsonArray();
        String[] stringArray = this.weightVal;
        int n = stringArray.length;
        for (int i = 0; i < n; ++i) {
            String string = stringArray[i];
            jsonArray.add(string == null ? "" : string);
        }
        return jsonArray;
    }

    public void primaryVal(JsonElement jsonElement) {
        block6: {
            block5: {
                Arrays.fill(this.weightVal, "");
                if (jsonElement == null) break block5;
                if (jsonElement.isJsonArray()) break block6;
            }
            return;
        }
        JsonArray jsonArray = jsonElement.getAsJsonArray();
        for (int i = 0; i < Math.min(9, jsonArray.size()); ++i) {
            try {
                this.weightVal[i] = jsonArray.get(i).getAsString();
                continue;
            }
            catch (Throwable throwable) {
                this.weightVal[i] = "";
            }
        }
    }

    public StringSlotSetting primaryVal(Supplier<Boolean> supplier) {
        this.secondaryVal = supplier;
        return this;
    }

    @Override
    public void secondaryVal() {
        System.arraycopy(this.paramVal, 0, this.weightVal, 0, 9);
    }
}

