/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package ru.metaculture.protection;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.UvnnvunNNuVV;
import ru.metaculture.protection.VuNVnnuuUun;

public final class StudioAssetLibrary {
    private static final String primaryVal = "assets/wild/studio/presets/";
    private static StudioAssetLibrary secondaryVal;
    private final File tertiaryVal;
    private final List<VuNVnnuuUun> marginVal = new ArrayList<VuNVnnuuUun>();
    private final Map<String, UvnnvunNNuVV> weightVal = new HashMap<String, UvnnvunNNuVV>();
    private final Map<String, String> paramVal = new HashMap<String, String>();
    private final Map<String, String> extraVal = new HashMap<String, String>();
    private final Map<String, UvnnvunNNuVV> limitVal = new LinkedHashMap<String, UvnnvunNNuVV>();
    private String speedVal = "";
    private boolean widthVal;
    private boolean chunkVal;

    private StudioAssetLibrary() {
        this.tertiaryVal = new File(WildClient.secondaryVal(), "avatars");
    }

    public static StudioAssetLibrary primaryVal() {
        if (secondaryVal == null) {
            secondaryVal = new StudioAssetLibrary();
        }
        return secondaryVal;
    }

    public File secondaryVal() {
        return this.tertiaryVal;
    }

    public synchronized void tertiaryVal() {
        if (this.chunkVal) {
            return;
        }
        this.chunkVal = true;
        try {
            if (!this.tertiaryVal.exists()) {
                this.tertiaryVal.mkdirs();
            }
            this.chunkVal();
            this.widthVal();
            this.limitVal();
        }
        catch (Throwable throwable) {
            System.out.println("[Studio] library init failed: " + throwable.getClass().getSimpleName() + ": " + throwable.getMessage());
        }
    }

    public synchronized void marginVal() {
        this.chunkVal();
        this.limitVal();
    }

    public synchronized List<VuNVnnuuUun> weightVal() {
        return new ArrayList<VuNVnnuuUun>(this.marginVal);
    }

    public synchronized List<VuNVnnuuUun> primaryVal(UvnnvunNNuVV uvnnvunNNuVV) {
        ArrayList<VuNVnnuuUun> arrayList = new ArrayList<VuNVnnuuUun>();
        for (VuNVnnuuUun vuNVnnuuUun : this.marginVal) {
            if (vuNVnnuuUun.limitVal() != uvnnvunNNuVV) continue;
            arrayList.add(vuNVnnuuUun);
        }
        return arrayList;
    }

    public synchronized VuNVnnuuUun paramVal() {
        for (VuNVnnuuUun vuNVnnuuUun : this.marginVal) {
            if (!vuNVnnuuUun.primaryVal().equals(this.speedVal)) continue;
            return vuNVnnuuUun;
        }
        return null;
    }

    public synchronized void primaryVal(VuNVnnuuUun vuNVnnuuUun) {
        this.speedVal = vuNVnnuuUun == null ? "" : vuNVnnuuUun.primaryVal();
        this.widthVal = vuNVnnuuUun != null;
        this.blockRef();
    }

    public synchronized boolean extraVal() {
        return this.widthVal && !this.speedVal.isEmpty();
    }

    public synchronized void primaryVal(boolean bl) {
        this.widthVal = bl && !this.speedVal.isEmpty();
        this.blockRef();
    }

    public synchronized void primaryVal(VuNVnnuuUun vuNVnnuuUun, UvnnvunNNuVV uvnnvunNNuVV) {
        if (vuNVnnuuUun == null || uvnnvunNNuVV == null) {
            return;
        }
        vuNVnnuuUun.primaryVal(uvnnvunNNuVV);
        this.weightVal.put(vuNVnnuuUun.primaryVal(), uvnnvunNNuVV);
        this.blockRef();
    }

    public synchronized void primaryVal(VuNVnnuuUun vuNVnnuuUun3, String string) {
        String string2;
        if (vuNVnnuuUun3 == null) {
            return;
        }
        String string3 = string2 = string == null ? "" : string.trim();
        if (string2.isEmpty()) {
            this.paramVal.remove(vuNVnnuuUun3.primaryVal());
            vuNVnnuuUun3.primaryVal((String)null);
        } else {
            this.paramVal.put(vuNVnnuuUun3.primaryVal(), string2);
            vuNVnnuuUun3.primaryVal(string2);
        }
        this.marginVal.sort((vuNVnnuuUun, vuNVnnuuUun2) -> vuNVnnuuUun.marginVal().compareToIgnoreCase(vuNVnnuuUun2.marginVal()));
        this.blockRef();
    }

    public synchronized void secondaryVal(VuNVnnuuUun vuNVnnuuUun, String string) {
        if (vuNVnnuuUun == null) {
            return;
        }
        String string2 = string == null ? "" : string.trim();
        vuNVnnuuUun.secondaryVal(string2);
        if (string2.isEmpty()) {
            this.extraVal.remove(vuNVnnuuUun.primaryVal());
        } else {
            this.extraVal.put(vuNVnnuuUun.primaryVal(), string2);
        }
        this.blockRef();
    }

    public synchronized boolean secondaryVal(VuNVnnuuUun vuNVnnuuUun) {
        if (vuNVnnuuUun == null) {
            return false;
        }
        boolean bl = StudioAssetLibrary.primaryVal(vuNVnnuuUun.secondaryVal());
        this.marginVal.remove(vuNVnnuuUun);
        this.paramVal.remove(vuNVnnuuUun.primaryVal());
        this.extraVal.remove(vuNVnnuuUun.primaryVal());
        this.weightVal.remove(vuNVnnuuUun.primaryVal());
        if (vuNVnnuuUun.primaryVal().equals(this.speedVal)) {
            this.speedVal = "";
            this.widthVal = false;
        }
        this.blockRef();
        return bl;
    }

    private static boolean primaryVal(File file) {
        if (file == null) {
            return false;
        }
        File[] fileArray = file.listFiles();
        if (fileArray != null) {
            File[] fileArray2 = fileArray;
            int n = fileArray2.length;
            for (int i = 0; i < n; ++i) {
                File file2 = fileArray2[i];
                StudioAssetLibrary.primaryVal(file2);
            }
        }
        return file.delete();
    }

    public synchronized String primaryVal(File file, UvnnvunNNuVV uvnnvunNNuVV) {
        if (file == null || !file.exists()) {
            return "File not found";
        }
        try {
            Object object;
            File file2;
            block17: {
                block20: {
                    block19: {
                        block18: {
                            String string = StudioAssetLibrary.marginVal(StudioAssetLibrary.tertiaryVal(file.getName()));
                            if (string.isEmpty()) {
                                string = "import";
                            }
                            file2 = this.secondaryVal(string);
                            if (!file.isDirectory()) break block18;
                            this.primaryVal(file.toPath(), file2.toPath());
                            break block17;
                        }
                        object = StudioAssetLibrary.marginVal(file);
                        if ("rar".equals(object)) break block19;
                        if (!"7z".equals(object)) break block20;
                    }
                    return "This is " + ((String)object).toUpperCase(Locale.ROOT) + ", not a .zip — unpack it manually";
                }
                if (!"zip".equals(object)) {
                    return "A .zip or folder is needed";
                }
                try (InputStream inputStream = Files.newInputStream(file.toPath(), new OpenOption[0]);){
                    this.primaryVal(inputStream, file2);
                }
            }
            object = this.tertiaryVal(file2) + "/";
            int n = this.marginVal.size();
            this.limitVal();
            int n2 = 0;
            for (VuNVnnuuUun vuNVnnuuUun : this.marginVal) {
                if (!vuNVnnuuUun.primaryVal().startsWith((String)object)) continue;
                if (this.weightVal.get(vuNVnnuuUun.primaryVal()) == null) {
                    vuNVnnuuUun.primaryVal(uvnnvunNNuVV);
                    this.weightVal.put(vuNVnnuuUun.primaryVal(), uvnnvunNNuVV);
                }
                ++n2;
            }
            this.blockRef();
            if (n2 == 0) {
                return "No avatars found (no avatar.json)";
            }
            return "Imported: " + n2 + (this.marginVal.size() > n ? "" : "");
        }
        catch (Throwable throwable) {
            return "Error: " + throwable.getClass().getSimpleName();
        }
    }

    private void limitVal() {
        this.marginVal.clear();
        if (!this.tertiaryVal.isDirectory()) {
            return;
        }
        this.speedVal();
        ArrayList<File> arrayList = new ArrayList<File>();
        this.primaryVal(this.tertiaryVal, arrayList, 0);
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String string;
            File file;
            String string2;
            UvnnvunNNuVV uvnnvunNNuVV = this.weightVal.get(string2 = this.tertiaryVal(file = (File)iterator.next()));
            VuNVnnuuUun vuNVnnuuUun3 = VuNVnnuuUun.primaryVal(string2, file, uvnnvunNNuVV != null ? uvnnvunNNuVV : this.primaryVal(string2));
            if (vuNVnnuuUun3 == null) continue;
            if (uvnnvunNNuVV == null) {
                try {
                    vuNVnnuuUun3.primaryVal(vuNVnnuuUun3.chunkVal());
                }
                catch (Throwable throwable) {
                }
            }
            String string3 = this.paramVal.get(string2);
            if (string3 != null && !string3.isEmpty()) {
                vuNVnnuuUun3.primaryVal(string3);
            }
            if ((string = this.extraVal.get(string2)) != null && !string.isEmpty()) {
                vuNVnnuuUun3.secondaryVal(string);
            }
            this.marginVal.add(vuNVnnuuUun3);
        }
        this.marginVal.sort((vuNVnnuuUun, vuNVnnuuUun2) -> vuNVnnuuUun.marginVal().compareToIgnoreCase(vuNVnnuuUun2.marginVal()));
    }

    private void primaryVal(File file, List<File> list, int n) {
        if (file == null || !file.isDirectory() || n > 8) {
            return;
        }
        if (this.secondaryVal(file)) {
            list.add(file);
            return;
        }
        File[] fileArray = file.listFiles();
        if (fileArray == null) {
            return;
        }
        for (File file2 : fileArray) {
            if (!file2.isDirectory()) continue;
            this.primaryVal(file2, list, n + 1);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void speedVal() {
        File[] fileArray = this.tertiaryVal.listFiles();
        if (fileArray == null) {
            return;
        }
        File[] fileArray2 = fileArray;
        int n = fileArray2.length;
        int n2 = 0;
        while (n2 < n) {
            File file = fileArray2[n2];
            if (file.isFile() && file.getName().toLowerCase(Locale.ROOT).endsWith(".zip")) {
                if (!"zip".equals(StudioAssetLibrary.marginVal(file))) {
                    System.out.println("[Studio] skipping non-zip archive (RAR/7z?): " + file.getName());
                } else {
                    try {
                        block12: {
                            String string = StudioAssetLibrary.marginVal(StudioAssetLibrary.tertiaryVal(file.getName()));
                            if (string.isEmpty()) {
                                string = "import";
                            }
                            File file2 = this.secondaryVal(string);
                            try (InputStream inputStream = Files.newInputStream(file.toPath(), new OpenOption[0]);){
                                this.primaryVal(inputStream, file2);
                                if (inputStream == null) break block12;
                            }
                        }
                        file.delete();
                    }
                    catch (Throwable throwable) {
                        System.out.println("[Studio] loose import failed " + file.getName() + ": " + throwable.getMessage());
                    }
                }
            }
            ++n2;
        }
    }

    private boolean secondaryVal(File file) {
        File[] fileArray = file.listFiles();
        if (fileArray == null) {
            return false;
        }
        File[] fileArray2 = fileArray;
        int n = fileArray2.length;
        for (int i = 0; i < n; ++i) {
            File file2 = fileArray2[i];
            if (!file2.isFile() || !file2.getName().toLowerCase(Locale.ROOT).endsWith(".bbmodel")) continue;
            return true;
        }
        return false;
    }

    private UvnnvunNNuVV primaryVal(String string) {
        for (Map.Entry<String, UvnnvunNNuVV> entry : this.limitVal.entrySet()) {
            if (!string.startsWith(entry.getKey() + "/")) {
                if (!string.equals(entry.getKey())) continue;
            }
            return entry.getValue();
        }
        return UvnnvunNNuVV.MODELS;
    }

    private String tertiaryVal(File file) {
        String string = this.tertiaryVal.getAbsolutePath();
        String string2 = file.getAbsolutePath();
        String string3 = string2.length() > string.length() ? string2.substring(string.length()) : string2;
        string3 = string3.replace('\\', '/');
        while (string3.startsWith("/")) {
            string3 = string3.substring(1);
        }
        return string3;
    }

    private void widthVal() {
        String string = this.weightVal("assets/wild/studio/presets/index.json");
        if (string == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(string);
        JSONArray jSONArray = jSONObject.optJSONArray("presets");
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); ++i) {
            byte[] byArray;
            JSONObject jSONObject2 = jSONArray.optJSONObject(i);
            if (jSONObject2 == null) continue;
            String string2 = jSONObject2.optString("file", "");
            UvnnvunNNuVV uvnnvunNNuVV = UvnnvunNNuVV.primaryVal(jSONObject2.optString("category", "models"));
            if (string2.isEmpty()) continue;
            String string3 = StudioAssetLibrary.marginVal(StudioAssetLibrary.tertiaryVal(string2));
            this.limitVal.put(string3, uvnnvunNNuVV);
            File file = new File(this.tertiaryVal, string3);
            if (file.isDirectory() || (byArray = this.paramVal(primaryVal + string2)) == null) continue;
            try {
                this.primaryVal(new ByteArrayInputStream(byArray), file);
                continue;
            }
            catch (IOException iOException) {
                System.out.println("[Studio] preset seed failed " + string2 + ": " + iOException.getMessage());
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String marginVal(File file) {
        try {
            InputStream inputStream;
            block10: {
                byte[] byArray;
                block9: {
                    block8: {
                        String string;
                        inputStream = Files.newInputStream(file.toPath(), new OpenOption[0]);
                        try {
                            byArray = inputStream.readNBytes(4);
                            if (byArray.length < 2) break block8;
                            if (byArray[0] != 80 || byArray[1] != 75) break block8;
                            string = "zip";
                            if (inputStream == null) return string;
                        }
                        catch (Throwable throwable) {
                            if (inputStream == null) throw throwable;
                            try {
                                inputStream.close();
                                throw throwable;
                            }
                            catch (Throwable throwable2) {
                                throwable.addSuppressed(throwable2);
                            }
                            throw throwable;
                        }
                        inputStream.close();
                        return string;
                    }
                    if (byArray.length < 4) break block9;
                    if ((byArray[0] & 0xFF) != 82) break block9;
                    if ((byArray[1] & 0xFF) != 97 || (byArray[2] & 0xFF) != 114 || (byArray[3] & 0xFF) != 33) break block9;
                    String string = "rar";
                    if (inputStream == null) return string;
                    inputStream.close();
                    return string;
                }
                if (byArray.length < 4 || (byArray[0] & 0xFF) != 55 || (byArray[1] & 0xFF) != 122 || (byArray[2] & 0xFF) != 188 || (byArray[3] & 0xFF) != 175) break block10;
                String string = "7z";
                if (inputStream == null) return string;
                inputStream.close();
                return string;
            }
            if (inputStream == null) return "unknown";
            inputStream.close();
            return "unknown";
        }
        catch (IOException iOException) {
            // empty catch block
        }
        return "unknown";
    }

    private void primaryVal(InputStream inputStream, File file) throws IOException {
        if (!file.exists()) {
            file.mkdirs();
        }
        Path path = file.toPath().normalize();
        try (ZipInputStream zipInputStream = new ZipInputStream(inputStream);){
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                Path path2 = path.resolve(zipEntry.getName()).normalize();
                if (!path2.startsWith(path)) continue;
                if (zipEntry.isDirectory()) {
                    Files.createDirectories(path2, new FileAttribute[0]);
                } else {
                    Files.createDirectories(path2.getParent(), new FileAttribute[0]);
                    Files.copy(zipInputStream, path2, StandardCopyOption.REPLACE_EXISTING);
                }
                zipInputStream.closeEntry();
            }
        }
    }

    private void primaryVal(Path path, Path path2) throws IOException {
        Files.walk(path, new FileVisitOption[0]).forEach(path3 -> {
            try {
                Path path4 = path2.resolve(path.relativize((Path)path3).toString());
                if (Files.isDirectory(path3, new LinkOption[0])) {
                    Files.createDirectories(path4, new FileAttribute[0]);
                } else {
                    Files.createDirectories(path4.getParent(), new FileAttribute[0]);
                    Files.copy(path3, path4, StandardCopyOption.REPLACE_EXISTING);
                }
            }
            catch (IOException iOException) {
                throw new RuntimeException(iOException);
            }
        });
    }

    private File secondaryVal(String string) {
        File file = new File(this.tertiaryVal, string);
        int n = 2;
        while (file.exists()) {
            file = new File(this.tertiaryVal, string + "-" + n);
            ++n;
        }
        return file;
    }

    private static String tertiaryVal(String string) {
        int n = string.lastIndexOf(46);
        return n > 0 ? string.substring(0, n) : string;
    }

    private static String marginVal(String string) {
        return string.trim().replaceAll("[^a-zA-Z0-9._ -]", "_");
    }

    private void chunkVal() {
        this.weightVal.clear();
        this.paramVal.clear();
        this.extraVal.clear();
        this.speedVal = "";
        this.widthVal = false;
        File file = new File(this.tertiaryVal, "index.json");
        if (!file.isFile()) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8));
            this.speedVal = jSONObject2.optString("selected", "");
            this.widthVal = jSONObject2.optBoolean("equipped", !this.speedVal.isEmpty()) && !this.speedVal.isEmpty();
            JSONObject jSONObject3 = jSONObject2.optJSONObject("tabs");
            if (jSONObject3 != null) {
                Iterator<String> tabsIter = jSONObject3.keySet().iterator();
                while (tabsIter.hasNext()) {
                    String key = tabsIter.next();
                    this.weightVal.put(key, UvnnvunNNuVV.primaryVal(jSONObject3.optString(key, "models")));
                }
            }
            JSONObject namesObj = jSONObject2.optJSONObject("names");
            if (namesObj != null) {
                Iterator<String> namesIter = namesObj.keySet().iterator();
                while (namesIter.hasNext()) {
                    String string = namesIter.next();
                    this.paramVal.put(string, namesObj.optString(string, ""));
                }
            }
            JSONObject prefixesObj = jSONObject2.optJSONObject("prefixes");
            if (prefixesObj != null) {
                for (String string : prefixesObj.keySet()) {
                    this.extraVal.put(string, prefixesObj.optString(string, ""));
                }
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private void blockRef() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("selected", (Object)this.speedVal);
            jSONObject.put("equipped", this.widthVal);
            JSONObject jSONObject2 = new JSONObject();
            Iterator<Map.Entry<String, UvnnvunNNuVV>> tabsIter = this.weightVal.entrySet().iterator();
            while (tabsIter.hasNext()) {
                Map.Entry<String, UvnnvunNNuVV> entry2 = tabsIter.next();
                jSONObject2.put(entry2.getKey(), (Object)entry2.getValue().primaryVal());
            }
            jSONObject.put("tabs", (Object)jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> object3 : this.paramVal.entrySet()) {
                jSONObject3.put(object3.getKey(), object3.getValue());
            }
            jSONObject.put("names", (Object)jSONObject3);
            JSONObject object2 = new JSONObject();
            for (Map.Entry<String, String> entry : this.extraVal.entrySet()) {
                object2.put(entry.getKey(), (Object)entry.getValue());
            }
            jSONObject.put("prefixes", object2);
            File file = new File(this.tertiaryVal, "index.json");
            Files.write(file.toPath(), jSONObject.toString(2).getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private String weightVal(String string) {
        byte[] byArray = this.paramVal(string);
        return byArray == null ? null : new String(byArray, StandardCharsets.UTF_8);
    }

    /*
     * Enabled aggressive exception aggregation
     */
    private byte[] paramVal(String string) {
        ClassLoader classLoader = StudioAssetLibrary.class.getClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(string)) {
            if (inputStream == null) {
                return null;
            }
            return inputStream.readAllBytes();
        }
        catch (IOException iOException) {
            return null;
        }
    }
}

