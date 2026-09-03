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
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.metaculture.protection.UnvUvUvVVvv;
import ru.metaculture.protection.UvnnvunNNuVV;
import ru.metaculture.protection.StudioModelData;

public final class VuNVnnuuUun {
    private final String primaryVal;
    private final File secondaryVal;
    private final File tertiaryVal;
    private final File marginVal;
    private final String weightVal;
    private String paramVal;
    private final String extraVal;
    private final String limitVal;
    private UvnnvunNNuVV speedVal;
    private String widthVal = "";
    private StudioModelData chunkVal;
    private boolean blockRef;
    private String holderVal;

    public VuNVnnuuUun(String string, File file, File file2, File file3, String string2, String string3, String string4, UvnnvunNNuVV uvnnvunNNuVV) {
        this.primaryVal = string;
        this.secondaryVal = file;
        this.tertiaryVal = file2;
        this.marginVal = file3;
        this.weightVal = string2;
        this.paramVal = string2;
        this.extraVal = string3;
        this.limitVal = string4;
        this.speedVal = uvnnvunNNuVV == null ? UvnnvunNNuVV.MODELS : uvnnvunNNuVV;
    }

    public static VuNVnnuuUun primaryVal(String string, File file, UvnnvunNNuVV uvnnvunNNuVV) {
        if (file == null || !file.isDirectory()) {
            return null;
        }
        File file2 = VuNVnnuuUun.primaryVal(file);
        if (file2 == null) {
            return null;
        }
        File file3 = new File(file, "avatar.png");
        if (!file3.isFile()) {
            file3 = null;
        }
        String string2 = VuNVnnuuUun.tertiaryVal(file.getName());
        String string3 = "";
        String string4 = "";
        File file4 = new File(file, "avatar.json");
        if (file4.isFile()) {
            try {
                JSONObject jSONObject = new JSONObject(new String(Files.readAllBytes(file4.toPath()), StandardCharsets.UTF_8));
                string2 = VuNVnnuuUun.tertiaryVal(jSONObject.optString("name", string2));
                string4 = jSONObject.optString("color", "");
                JSONArray jSONArray = jSONObject.optJSONArray("authors");
                if (jSONArray != null && jSONArray.length() > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < jSONArray.length(); ++i) {
                        if (i > 0) {
                            stringBuilder.append(", ");
                        }
                        stringBuilder.append(VuNVnnuuUun.tertiaryVal(jSONArray.optString(i, "")));
                    }
                    string3 = stringBuilder.toString();
                } else {
                    string3 = VuNVnnuuUun.tertiaryVal(jSONObject.optString("author", ""));
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
        return new VuNVnnuuUun(string, file, file2, file3, string2.isEmpty() ? file.getName() : string2, string3, string4, uvnnvunNNuVV);
    }

    private static File primaryVal(File file) {
        File[] fileArray = file.listFiles();
        if (fileArray == null) {
            return null;
        }
        File file2 = null;
        File file3 = null;
        long l = -1L;
        File[] fileArray2 = fileArray;
        for (File file4 : fileArray2) {
            String string;
            if (!file4.isFile() || !(string = file4.getName().toLowerCase()).endsWith(".bbmodel") || string.contains("hud")) continue;
            if (string.equals("model.bbmodel")) {
                file2 = file4;
            }
            if (file4.length() <= l) continue;
            l = file4.length();
            file3 = file4;
        }
        if (file2 != null) {
            return file2;
        }
        if (file3 != null) {
            return file3;
        }
        return VuNVnnuuUun.primaryVal(file, ".bbmodel");
    }

    private static String tertiaryVal(String string) {
        if (string == null) {
            return "";
        }
        return string.replaceAll("\u00a7.", "").replaceAll("&[0-9A-Fa-fK-Ok-or]", "").trim();
    }

    private static File primaryVal(File file, String string) {
        File[] fileArray = file.listFiles();
        if (fileArray == null) {
            return null;
        }
        File[] fileArray2 = fileArray;
        int n = fileArray2.length;
        for (int i = 0; i < n; ++i) {
            File file2 = fileArray2[i];
            if (!file2.isFile() || !file2.getName().toLowerCase().endsWith(string)) continue;
            return file2;
        }
        return null;
    }

    public String primaryVal() {
        return this.primaryVal;
    }

    public File secondaryVal() {
        return this.secondaryVal;
    }

    public File tertiaryVal() {
        return this.marginVal;
    }

    public String marginVal() {
        return this.paramVal;
    }

    public String weightVal() {
        return this.weightVal;
    }

    void primaryVal(String string) {
        this.paramVal = string == null || string.trim().isEmpty() ? this.weightVal : string.trim();
    }

    public String paramVal() {
        return this.extraVal;
    }

    public String extraVal() {
        return this.limitVal;
    }

    public UvnnvunNNuVV limitVal() {
        return this.speedVal;
    }

    void primaryVal(UvnnvunNNuVV uvnnvunNNuVV) {
        this.speedVal = uvnnvunNNuVV == null ? UvnnvunNNuVV.MODELS : uvnnvunNNuVV;
    }

    public String speedVal() {
        return this.widthVal;
    }

    void secondaryVal(String string) {
        this.widthVal = string == null ? "" : string.trim();
    }

    public boolean widthVal() {
        return this.holderVal() != null;
    }

    public UvnnvunNNuVV chunkVal() {
        StudioModelData linkD = this.holderVal();
        if (linkD == null) {
            return UvnnvunNNuVV.MODELS;
        }
        HashSet<String> hashSet = new HashSet<String>();
        for (StudioModelData.WildClient modeVal : linkD.marginVal()) {
            VuNVnnuuUun.primaryVal(modeVal, hashSet);
        }
        boolean bl = hashSet.contains("body") || hashSet.contains("torso");
        boolean bl2 = hashSet.contains("leftleg") || hashSet.contains("rightleg") || hashSet.contains("left_leg") || hashSet.contains("right_leg");
        boolean bl3 = hashSet.contains("leftarm") || hashSet.contains("rightarm") || hashSet.contains("left_arm") || hashSet.contains("right_arm");
        boolean bl4 = hashSet.contains("head");
        if (bl) {
            if (bl2 || bl3) {
                return UvnnvunNNuVV.MODELS;
            }
        }
        if (bl4 && !bl && !bl2) {
            return UvnnvunNNuVV.ITEMS;
        }
        if (!(bl || bl2 || bl3 || bl4)) {
            return UvnnvunNNuVV.PETS;
        }
        return UvnnvunNNuVV.MODELS;
    }

    private static void primaryVal(StudioModelData.WildClient modeVal, Set<String> set) {
        if (modeVal.primaryVal() != null) {
            set.add(modeVal.primaryVal().toLowerCase());
        }
        for (StudioModelData.WildClient nodeC : modeVal.speedVal()) {
            VuNVnnuuUun.primaryVal(nodeC, set);
        }
    }

    public String blockRef() {
        this.holderVal();
        return this.holderVal;
    }

    public StudioModelData holderVal() {
        if (this.blockRef) {
            return this.chunkVal;
        }
        this.blockRef = true;
        try {
            String string = new String(Files.readAllBytes(this.tertiaryVal.toPath()), StandardCharsets.UTF_8);
            this.chunkVal = UnvUvUvVVvv.primaryVal(string);
            if (this.chunkVal.marginVal().isEmpty()) {
                this.holderVal = "Empty model";
            }
        }
        catch (Throwable throwable) {
            this.holderVal = throwable.getClass().getSimpleName() + ": " + throwable.getMessage();
            this.chunkVal = null;
        }
        return this.chunkVal;
    }
}

