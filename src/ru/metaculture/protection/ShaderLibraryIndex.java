/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package ru.metaculture.protection;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.metaculture.protection.FoundryStorage;

public final class ShaderLibraryIndex {
    private static final ShaderLibraryIndex primaryVal = new ShaderLibraryIndex();
    private static final int secondaryVal = 8;
    private final LinkedHashSet<String> tertiaryVal = new LinkedHashSet();
    private final ArrayList<String> marginVal = new ArrayList();
    private boolean weightVal;

    private ShaderLibraryIndex() {
    }

    public static ShaderLibraryIndex primaryVal() {
        return primaryVal;
    }

    public synchronized Set<String> secondaryVal() {
        this.weightVal();
        return new LinkedHashSet<String>(this.tertiaryVal);
    }

    public synchronized List<String> tertiaryVal() {
        this.weightVal();
        return new ArrayList<String>(this.marginVal);
    }

    public synchronized boolean primaryVal(String string) {
        this.weightVal();
        return string != null && this.tertiaryVal.contains(string);
    }

    public synchronized void secondaryVal(String string) {
        if (string == null || string.isBlank()) {
            return;
        }
        this.weightVal();
        if (!this.tertiaryVal.remove(string)) {
            this.tertiaryVal.add(string);
        }
        this.paramVal();
    }

    public synchronized void tertiaryVal(String string) {
        if (string == null || string.isBlank()) {
            return;
        }
        this.weightVal();
        this.marginVal.remove(string);
        this.marginVal.add(0, string);
        while (this.marginVal.size() > 8) {
            this.marginVal.remove(this.marginVal.size() - 1);
        }
        this.paramVal();
    }

    private File marginVal() {
        return new File(FoundryStorage.primaryVal().marginVal(), "library.json");
    }

    private void weightVal() {
        if (this.weightVal) {
            return;
        }
        this.weightVal = true;
        try {
            JSONArray jSONArray;
            File file = this.marginVal();
            if (!file.isFile()) {
                return;
            }
            JSONObject jSONObject = new JSONObject(new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8));
            JSONArray jSONArray2 = jSONObject.optJSONArray("favorites");
            if (jSONArray2 != null) {
                for (int i = 0; i < jSONArray2.length(); ++i) {
                    String string = jSONArray2.optString(i, "");
                    if (string.isBlank()) continue;
                    this.tertiaryVal.add(string);
                }
            }
            if ((jSONArray = jSONObject.optJSONArray("recents")) != null) {
                for (int i = 0; i < jSONArray.length() && this.marginVal.size() < 8; ++i) {
                    String string = jSONArray.optString(i, "");
                    if (string.isBlank() || this.marginVal.contains(string)) continue;
                    this.marginVal.add(string);
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private void paramVal() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("favorites", (Object)new JSONArray(this.tertiaryVal));
            jSONObject.put("recents", (Object)new JSONArray(this.marginVal));
            Files.write(this.marginVal().toPath(), jSONObject.toString(2).getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }
}

