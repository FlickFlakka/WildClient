/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import lombok.Generated;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public abstract class ChatCommand
implements MinecraftAccessor {
    private final String primaryVal;
    private final String secondaryVal;
    private final String tertiaryVal;
    private final Map<String, Supplier<List<String>>> marginVal = new HashMap<String, Supplier<List<String>>>();

    public ChatCommand(String string, String string2, String string3) {
        this.primaryVal = string;
        this.secondaryVal = string2;
        this.tertiaryVal = string3;
    }

    @Compile
    protected void primaryVal(String string, Supplier<List<String>> supplier) {
        this.marginVal.put(string.toLowerCase(), supplier);
    }

    public List<String> primaryVal(String[] stringArray) {
        String string2;
        if (stringArray.length == 2) {
            return this.marginVal.keySet().stream().filter(string -> string.startsWith(stringArray[1].toLowerCase())).toList();
        }
        if (stringArray.length == 3 && this.marginVal.containsKey(string2 = stringArray[1].toLowerCase())) {
            return this.marginVal.get(string2).get().stream().filter(string -> string.toLowerCase().startsWith(stringArray[2].toLowerCase())).toList();
        }
        return new ArrayList<String>();
    }

    public abstract void secondaryVal(String[] var1);

    @Generated
    public String primaryVal() {
        return this.primaryVal;
    }

    @Generated
    public String secondaryVal() {
        return this.secondaryVal;
    }

    @Generated
    public String tertiaryVal() {
        return this.tertiaryVal;
    }

    static {
        Loader.initialize();
    }
}

