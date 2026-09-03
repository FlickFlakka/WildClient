/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package ru.metaculture.protection;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.minecraft.class_310;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NodeGraphMetadata;
import ru.metaculture.protection.ShaderPresetMeta;
import ru.metaculture.protection.VnnVNVNVUnnn;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.RandomNameGenerator;
import ru.metaculture.protection.NodeGraph;
import ru.metaculture.protection.NodeDefinitionRegistry;
import ru.metaculture.protection.ThemeShaderManager;

public final class FoundryStorage {
    private static final FoundryStorage primaryVal = new FoundryStorage();
    private static final String secondaryVal = "active.json";
    private static final String tertiaryVal = ".theme.json";
    private static final String marginVal = ".wifd";
    private static final String weightVal = ".json";
    private static final DateTimeFormatter paramVal = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
    private final File extraVal;
    private final Map<SurfaceTarget, String> limitVal = new EnumMap<SurfaceTarget, String>(SurfaceTarget.class);
    private final Map<String, ShaderPresetMeta> speedVal = new HashMap<String, ShaderPresetMeta>();
    private boolean widthVal;

    private FoundryStorage() {
        File file;
        this.extraVal = file = WildClient.primaryVal != null && WildClient.primaryVal.paramVal != null ? new File(WildClient.primaryVal.paramVal, "foundry") : new File(WildClient.secondaryVal(), "foundry");
        if (!file.exists() && !file.mkdirs()) {
            System.out.println("[FoundryStorage] cannot create directory " + file.getAbsolutePath());
        }
    }

    public static FoundryStorage primaryVal() {
        return primaryVal;
    }

    public synchronized void primaryVal(NodeDefinitionRegistry nodeI) {
        if (this.widthVal) {
            return;
        }
        this.widthVal = true;
        this.speedVal.clear();
        if (!this.extraVal.isDirectory()) {
            return;
        }
        this.limitVal();
        File[] fileArray = this.extraVal.listFiles((file, string) -> string.endsWith(tertiaryVal));
        ArrayList<File> arrayList = new ArrayList<File>();
        if (fileArray != null) {
            for (File file2 : fileArray) {
                if (!FoundryStorage.tertiaryVal(file2.getName())) {
                    arrayList.add(file2);
                    continue;
                }
                try {
                    ShaderPresetMeta vUvUNNUvvNVN = this.primaryVal(file2, new JSONObject(FoundryStorage.primaryVal(file2)));
                    this.speedVal.put(vUvUNNUvvNVN.primaryVal(), vUvUNNUvvNVN);
                }
                catch (Throwable throwable) {
                    System.out.println("[FoundryStorage] skip " + file2.getName() + ": " + throwable.getMessage());
                }
            }
        }
        boolean bl = false;
        for (File file3 : arrayList) {
            bl |= this.secondaryVal(file3, nodeI);
        }
        if (bl) {
            this.speedVal();
        }
    }

    public synchronized List<ShaderPresetMeta> secondaryVal() {
        ArrayList<ShaderPresetMeta> arrayList = new ArrayList<ShaderPresetMeta>(this.speedVal.values());
        arrayList.sort((vUvUNNUvvNVN, vUvUNNUvvNVN2) -> Long.compare(vUvUNNUvvNVN2.chunkVal(), vUvUNNUvvNVN.chunkVal()));
        return arrayList;
    }

    public synchronized List<ShaderPresetMeta> primaryVal(SurfaceTarget vnuVUNUv) {
        if (vnuVUNUv == null) {
            return Collections.emptyList();
        }
        ArrayList<ShaderPresetMeta> arrayList = new ArrayList<ShaderPresetMeta>();
        for (ShaderPresetMeta vUvUNNUvvNVN3 : this.speedVal.values()) {
            if (!vnuVUNUv.primaryVal().equals(vUvUNNUvvNVN3.tertiaryVal())) continue;
            arrayList.add(vUvUNNUvvNVN3);
        }
        arrayList.sort((vUvUNNUvvNVN, vUvUNNUvvNVN2) -> Long.compare(vUvUNNUvvNVN2.chunkVal(), vUvUNNUvvNVN.chunkVal()));
        return arrayList;
    }

    public synchronized ShaderPresetMeta primaryVal(String string) {
        return string == null ? null : this.speedVal.get(string);
    }

    public synchronized ShaderPresetMeta primaryVal(SurfaceTarget vnuVUNUv, NodeGraph nuVVnvn2, String string, String string2) {
        ShaderPresetMeta vUvUNNUvvNVN;
        String string3;
        if (vnuVUNUv == null || nuVVnvn2 == null) {
            return null;
        }
        long l = System.currentTimeMillis();
        String string4 = string3 = string == null || string.isBlank() ? nuVVnvn2.primaryVal().secondaryVal() : string.trim();
        if (string3 == null || string3.isBlank()) {
            string3 = RandomNameGenerator.primaryVal();
        }
        NodeGraphMetadata itemH = nuVVnvn2.primaryVal();
        itemH.primaryVal(string3, FoundryStorage.extraVal());
        itemH.primaryVal(string3);
        itemH.secondaryVal(l);
        itemH.weightVal("local");
        String string5 = VnnVNVNVUnnn.primaryVal(nuVVnvn2);
        ShaderPresetMeta vUvUNNUvvNVN2 = vUvUNNUvvNVN = string2 == null ? null : this.speedVal.get(string2);
        if (vUvUNNUvvNVN == null) {
            vUvUNNUvvNVN = new ShaderPresetMeta(this.widthVal(), string3, vnuVUNUv.primaryVal(), string5, itemH.tertiaryVal(), itemH.marginVal(), itemH.weightVal(), "user", "saved", itemH.speedVal(), l, itemH.chunkVal());
            this.speedVal.put(vUvUNNUvvNVN.primaryVal(), vUvUNNUvvNVN);
        } else {
            vUvUNNUvvNVN.primaryVal(string3);
            vUvUNNUvvNVN.secondaryVal(vnuVUNUv.primaryVal());
            vUvUNNUvvNVN.tertiaryVal(string5);
            vUvUNNUvvNVN.marginVal(itemH.tertiaryVal());
            vUvUNNUvvNVN.weightVal(itemH.marginVal());
            vUvUNNUvvNVN.paramVal(itemH.weightVal());
            vUvUNNUvvNVN.extraVal("user");
            vUvUNNUvvNVN.limitVal("saved");
            vUvUNNUvvNVN.primaryVal(itemH.speedVal());
            vUvUNNUvvNVN.secondaryVal(l);
            vUvUNNUvvNVN.primaryVal(itemH.chunkVal());
        }
        try {
            this.primaryVal(vUvUNNUvvNVN, itemH);
        }
        catch (IOException iOException) {
            System.out.println("[FoundryStorage] save failed: " + iOException.getMessage());
        }
        return vUvUNNUvvNVN;
    }

    public synchronized ShaderPresetMeta primaryVal(SurfaceTarget vnuVUNUv, NodeGraph nuVVnvn2, String string) {
        if (vnuVUNUv == null || nuVVnvn2 == null) {
            return null;
        }
        ShaderPresetMeta vUvUNNUvvNVN = string == null ? null : this.speedVal.get(string);
        String string2 = vUvUNNUvvNVN == null ? nuVVnvn2.primaryVal().secondaryVal() : vUvUNNUvvNVN.secondaryVal();
        return this.primaryVal(vnuVUNUv, nuVVnvn2, string2, string);
    }

    public synchronized File tertiaryVal() {
        File file = new File(this.extraVal, "shaders");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public synchronized File marginVal() {
        if (!this.extraVal.exists()) {
            this.extraVal.mkdirs();
        }
        return this.extraVal;
    }

    public synchronized File secondaryVal(SurfaceTarget vnuVUNUv, NodeGraph nuVVnvn2, String string) {
        String string2;
        if (nuVVnvn2 == null) {
            return null;
        }
        SurfaceTarget vnuVUNUv2 = vnuVUNUv == null ? SurfaceTarget.primaryVal(nuVVnvn2.secondaryVal()) : vnuVUNUv;
        String string3 = string2 = string == null || string.isBlank() ? nuVVnvn2.primaryVal().secondaryVal() : string.trim();
        if (string2 == null || string2.isBlank()) {
            string2 = RandomNameGenerator.primaryVal();
        }
        NodeGraphMetadata itemH = nuVVnvn2.primaryVal();
        itemH.primaryVal(string2, FoundryStorage.extraVal());
        itemH.primaryVal(string2);
        itemH.secondaryVal(System.currentTimeMillis());
        itemH.weightVal("shared");
        String string4 = FoundryStorage.marginVal(string2);
        String string5 = LocalDateTime.now().format(paramVal);
        File file = new File(this.tertiaryVal(), string4 + "_" + string5 + marginVal);
        try {
            nuVVnvn2.primaryVal(vnuVUNUv2.primaryVal());
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", 4);
            jSONObject.put("type", (Object)"wild_foundry");
            jSONObject.put("target", (Object)vnuVUNUv2.primaryVal());
            jSONObject.put("metadata", (Object)VnnVNVNVUnnn.primaryVal(itemH));
            jSONObject.put("graph", (Object)VnnVNVNVUnnn.secondaryVal(nuVVnvn2));
            Files.write(file.toPath(), jSONObject.toString(2).getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
            return file;
        }
        catch (Throwable throwable) {
            System.out.println("[FoundryStorage] shared export failed: " + throwable.getMessage());
            return null;
        }
    }

    public synchronized List<File> weightVal() {
        File file3 = this.tertiaryVal();
        File[] fileArray = file3.listFiles((file, string) -> {
            if (string == null) {
                return false;
            }
            String string2 = string.toLowerCase(Locale.ROOT);
            return string2.endsWith(marginVal) || string2.endsWith(weightVal);
        });
        if (fileArray == null || fileArray.length == 0) {
            return List.of();
        }
        ArrayList<File> arrayList = new ArrayList<File>(List.of(fileArray));
        arrayList.sort((file, file2) -> Long.compare(file2.lastModified(), file.lastModified()));
        return arrayList;
    }

    public synchronized NodeGraph primaryVal(File file, NodeDefinitionRegistry nodeI) {
        block11: {
            block10: {
                if (file == null || nodeI == null) break block10;
                if (file.isFile()) break block11;
            }
            return null;
        }
        try {
            String string = FoundryStorage.primaryVal(file);
            JSONObject jSONObject = new JSONObject(string);
            JSONObject jSONObject2 = jSONObject.optJSONObject("graph");
            if (jSONObject2 != null) {
                NodeGraph nuVVnvn2 = VnnVNVNVUnnn.primaryVal(jSONObject2, nodeI);
                String string2 = jSONObject.optString("target", "");
                if (!string2.isBlank()) {
                    nuVVnvn2.primaryVal(string2);
                }
                NodeGraphMetadata itemH = VnnVNVNVUnnn.primaryVal(jSONObject.optJSONObject("metadata"), jSONObject);
                itemH.weightVal("imported");
                itemH.primaryVal(jSONObject.optString("displayName", RandomNameGenerator.primaryVal()), jSONObject.optString("author", FoundryStorage.extraVal()));
                nuVVnvn2.primaryVal(itemH);
                return nuVVnvn2;
            }
            String string3 = jSONObject.optString("wildTheme", "");
            if (!string3.isBlank()) {
                NodeGraph nuVVnvn3 = VnnVNVNVUnnn.primaryVal(string3, nodeI);
                NodeGraphMetadata itemH = VnnVNVNVUnnn.primaryVal(jSONObject.optJSONObject("metadata"), jSONObject);
                itemH.weightVal("imported");
                itemH.primaryVal(jSONObject.optString("displayName", RandomNameGenerator.primaryVal()), jSONObject.optString("author", FoundryStorage.extraVal()));
                nuVVnvn3.primaryVal(itemH);
                return nuVVnvn3;
            }
            if (jSONObject.has("nodes") && jSONObject.has("connections")) {
                NodeGraph nuVVnvn4 = VnnVNVNVUnnn.primaryVal(jSONObject, nodeI);
                nuVVnvn4.primaryVal().weightVal("imported");
                nuVVnvn4.primaryVal().primaryVal(jSONObject.optString("displayName", RandomNameGenerator.primaryVal()), jSONObject.optString("author", FoundryStorage.extraVal()));
                return nuVVnvn4;
            }
        }
        catch (Throwable throwable) {
            System.out.println("[FoundryStorage] shared import failed: " + throwable.getMessage());
        }
        return null;
    }

    public synchronized boolean secondaryVal(String string) {
        if (string == null) {
            return false;
        }
        ShaderPresetMeta vUvUNNUvvNVN = this.speedVal.remove(string);
        if (vUvUNNUvvNVN == null) {
            return false;
        }
        for (Map.Entry<SurfaceTarget, String> entry : new ArrayList<Map.Entry<SurfaceTarget, String>>(this.limitVal.entrySet())) {
            if (!string.equals(entry.getValue())) continue;
            this.limitVal.remove((Object)entry.getKey());
        }
        try {
            Files.deleteIfExists(new File(this.extraVal, string).toPath());
        }
        catch (IOException iOException) {
            // empty catch block
        }
        this.speedVal();
        return true;
    }

    public synchronized NodeGraph primaryVal(String string, NodeDefinitionRegistry nodeI) {
        ShaderPresetMeta vUvUNNUvvNVN = this.speedVal.get(string);
        if (vUvUNNUvvNVN == null) {
            return null;
        }
        try {
            NodeGraph nuVVnvn2 = VnnVNVNVUnnn.primaryVal(vUvUNNUvvNVN.marginVal(), nodeI);
            nuVVnvn2.primaryVal().primaryVal(vUvUNNUvvNVN.secondaryVal(), vUvUNNUvvNVN.weightVal().isBlank() ? FoundryStorage.extraVal() : vUvUNNUvvNVN.weightVal());
            nuVVnvn2.primaryVal().primaryVal(vUvUNNUvvNVN.secondaryVal());
            if (!vUvUNNUvvNVN.weightVal().isBlank()) {
                nuVVnvn2.primaryVal().secondaryVal(vUvUNNUvvNVN.weightVal());
            }
            nuVVnvn2.primaryVal().tertiaryVal(vUvUNNUvvNVN.paramVal());
            nuVVnvn2.primaryVal().marginVal(vUvUNNUvvNVN.extraVal());
            nuVVnvn2.primaryVal().primaryVal(vUvUNNUvvNVN.widthVal());
            nuVVnvn2.primaryVal().secondaryVal(vUvUNNUvvNVN.chunkVal());
            nuVVnvn2.primaryVal().primaryVal(vUvUNNUvvNVN.blockRef());
            return nuVVnvn2;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public synchronized void primaryVal(SurfaceTarget vnuVUNUv, String string) {
        if (vnuVUNUv == null) {
            return;
        }
        if (string == null || string.isBlank()) {
            this.limitVal.remove((Object)vnuVUNUv);
        } else if (this.speedVal.containsKey(string)) {
            this.limitVal.put(vnuVUNUv, string);
        }
        this.speedVal();
    }

    public synchronized String secondaryVal(SurfaceTarget vnuVUNUv) {
        return this.limitVal.get((Object)vnuVUNUv);
    }

    public synchronized ShaderPresetMeta tertiaryVal(SurfaceTarget vnuVUNUv) {
        String string = this.limitVal.get((Object)vnuVUNUv);
        return string == null ? null : this.speedVal.get(string);
    }

    public synchronized JSONArray paramVal() {
        JSONArray jSONArray = new JSONArray();
        for (ShaderPresetMeta vUvUNNUvvNVN : this.secondaryVal()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fileName", (Object)vUvUNNUvvNVN.primaryVal());
            jSONObject.put("displayName", (Object)vUvUNNUvvNVN.secondaryVal());
            jSONObject.put("target", (Object)vUvUNNUvvNVN.tertiaryVal());
            jSONObject.put("author", (Object)vUvUNNUvvNVN.weightVal());
            jSONObject.put("description", (Object)vUvUNNUvvNVN.paramVal());
            jSONObject.put("complexity", (Object)vUvUNNUvvNVN.extraVal());
            jSONObject.put("source", (Object)vUvUNNUvvNVN.limitVal());
            jSONObject.put("compileStatus", (Object)vUvUNNUvvNVN.speedVal());
            jSONObject.put("createdAt", vUvUNNUvvNVN.widthVal());
            jSONObject.put("updatedAt", vUvUNNUvvNVN.chunkVal());
            jSONObject.put("favorite", vUvUNNUvvNVN.blockRef());
            jSONArray.put((Object)jSONObject);
        }
        return jSONArray;
    }

    private void limitVal() {
        File file = new File(this.extraVal, secondaryVal);
        if (!file.exists()) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(FoundryStorage.primaryVal(file));
            for (SurfaceTarget vnuVUNUv : SurfaceTarget.values()) {
                String string = jSONObject.optString(vnuVUNUv.primaryVal(), null);
                if (string == null || string.isBlank()) continue;
                this.limitVal.put(vnuVUNUv, string);
            }
        }
        catch (Throwable throwable) {
            System.out.println("[FoundryStorage] cannot read active bindings: " + throwable.getMessage());
        }
    }

    private void speedVal() {
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<SurfaceTarget, String> entry : this.limitVal.entrySet()) {
                jSONObject.put(entry.getKey().primaryVal(), (Object)entry.getValue());
            }
            Files.write(new File(this.extraVal, secondaryVal).toPath(), jSONObject.toString(2).getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
        }
        catch (IOException iOException) {
            System.out.println("[FoundryStorage] cannot persist active bindings: " + iOException.getMessage());
        }
    }

    private ShaderPresetMeta primaryVal(File file, JSONObject jSONObject) {
        String string = jSONObject.optString("wildTheme", "");
        NodeGraphMetadata itemH = VnnVNVNVUnnn.primaryVal(jSONObject.optJSONObject("metadata"), jSONObject);
        if (itemH.secondaryVal().isBlank()) {
            itemH.primaryVal(FoundryStorage.tertiaryVal(file.getName()) ? RandomNameGenerator.primaryVal() : file.getName().replace(tertiaryVal, ""));
        }
        itemH.primaryVal(itemH.secondaryVal(), FoundryStorage.extraVal());
        long l = itemH.widthVal() > 0L ? itemH.widthVal() : jSONObject.optLong("updatedAt", file.lastModified());
        String string2 = jSONObject.optString("target", "preview");
        String string3 = jSONObject.optString("source", itemH.paramVal().isBlank() ? "user" : itemH.paramVal());
        String string4 = jSONObject.optString("compileStatus", "saved");
        return new ShaderPresetMeta(file.getName(), itemH.secondaryVal(), string2, string, itemH.tertiaryVal(), itemH.marginVal(), itemH.weightVal(), string3, string4, itemH.speedVal(), l, itemH.chunkVal());
    }

    private boolean secondaryVal(File file, NodeDefinitionRegistry nodeI) {
        String string = file.getName();
        boolean bl = false;
        try {
            Object object;
            String string2;
            Object object2;
            Object object3;
            JSONObject jSONObject = new JSONObject(FoundryStorage.primaryVal(file));
            ShaderPresetMeta vUvUNNUvvNVN = this.primaryVal(file, jSONObject);
            if (!this.secondaryVal(vUvUNNUvvNVN.marginVal(), nodeI) && (object3 = jSONObject.optJSONObject("graph")) != null) {
                object2 = VnnVNVNVUnnn.primaryVal((JSONObject)object3, nodeI);
                if (object2 != null) {
                    vUvUNNUvvNVN.tertiaryVal(VnnVNVNVUnnn.primaryVal((NodeGraph)object2));
                }
            }
            if (!this.secondaryVal(vUvUNNUvvNVN.marginVal(), nodeI)) {
                System.out.println("[FoundryStorage] keeping legacy file without loadable payload: " + string);
                return false;
            }
            object3 = this.primaryVal(vUvUNNUvvNVN);
            if (object3 != null) {
                string2 = ((ShaderPresetMeta)object3).primaryVal();
            } else {
                string2 = this.widthVal();
                object2 = VnnVNVNVUnnn.primaryVal(jSONObject.optJSONObject("metadata"), jSONObject);
                ((NodeGraphMetadata)object2).primaryVal(vUvUNNUvvNVN.secondaryVal(), FoundryStorage.extraVal());
                ((NodeGraphMetadata)object2).primaryVal(vUvUNNUvvNVN.secondaryVal());
                ((NodeGraphMetadata)object2).primaryVal(vUvUNNUvvNVN.widthVal());
                ((NodeGraphMetadata)object2).secondaryVal(vUvUNNUvvNVN.chunkVal());
                ((NodeGraphMetadata)object2).primaryVal(vUvUNNUvvNVN.blockRef());
                object = new ShaderPresetMeta(string2, vUvUNNUvvNVN.secondaryVal(), vUvUNNUvvNVN.tertiaryVal(), vUvUNNUvvNVN.marginVal(), vUvUNNUvvNVN.weightVal(), vUvUNNUvvNVN.paramVal(), vUvUNNUvvNVN.extraVal(), vUvUNNUvvNVN.limitVal(), vUvUNNUvvNVN.speedVal(), vUvUNNUvvNVN.widthVal(), vUvUNNUvvNVN.chunkVal(), vUvUNNUvvNVN.blockRef());
                this.primaryVal((ShaderPresetMeta)object, (NodeGraphMetadata)object2);
                this.speedVal.put(string2, (ShaderPresetMeta)object);
            }
            Iterator<Map.Entry<SurfaceTarget, String>> iterator = new ArrayList<Map.Entry<SurfaceTarget, String>>(this.limitVal.entrySet()).iterator();
            while (iterator.hasNext()) {
                Map.Entry<SurfaceTarget, String> entry = iterator.next();
                if (!string.equals(entry.getValue())) continue;
                this.limitVal.put(entry.getKey(), string2);
                bl = true;
            }
            if (bl) {
                this.speedVal();
            }
            Files.deleteIfExists(file.toPath());
        }
        catch (Throwable throwable) {
            System.out.println("[FoundryStorage] legacy migration failed for " + string + ": " + throwable.getMessage());
            return bl;
        }
        return bl;
    }

    private boolean secondaryVal(String string, NodeDefinitionRegistry nodeI) {
        if (string == null || string.isBlank()) {
            return false;
        }
        try {
            return VnnVNVNVUnnn.primaryVal(string, nodeI) != null;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    private ShaderPresetMeta primaryVal(ShaderPresetMeta vUvUNNUvvNVN) {
        Iterator<ShaderPresetMeta> iterator = this.speedVal.values().iterator();
        while (iterator.hasNext()) {
            ShaderPresetMeta vUvUNNUvvNVN2 = iterator.next();
            if (!vUvUNNUvvNVN2.secondaryVal().equals(vUvUNNUvvNVN.secondaryVal())) continue;
            if (!vUvUNNUvvNVN2.tertiaryVal().equals(vUvUNNUvvNVN.tertiaryVal()) || !vUvUNNUvvNVN2.marginVal().equals(vUvUNNUvvNVN.marginVal())) continue;
            return vUvUNNUvvNVN2;
        }
        return null;
    }

    private void primaryVal(ShaderPresetMeta vUvUNNUvvNVN, NodeGraphMetadata itemH) throws IOException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", 4);
        jSONObject.put("target", (Object)vUvUNNUvvNVN.tertiaryVal());
        jSONObject.put("source", (Object)vUvUNNUvvNVN.limitVal());
        jSONObject.put("compileStatus", (Object)vUvUNNUvvNVN.speedVal());
        jSONObject.put("wildTheme", (Object)vUvUNNUvvNVN.marginVal());
        jSONObject.put("metadata", (Object)VnnVNVNVUnnn.primaryVal(itemH));
        Files.write(new File(this.extraVal, vUvUNNUvvNVN.primaryVal()).toPath(), jSONObject.toString(2).getBytes(StandardCharsets.UTF_8), new OpenOption[0]);
    }

    private String widthVal() {
        String string;
        while (this.speedVal.containsKey(string = String.valueOf(UUID.randomUUID()) + tertiaryVal) || new File(this.extraVal, string).exists()) {
        }
        return string;
    }

    private static boolean tertiaryVal(String string) {
        if (string == null || !string.endsWith(tertiaryVal)) {
            return false;
        }
        String string2 = string.substring(0, string.length() - tertiaryVal.length());
        if (string2.length() != 36) {
            return false;
        }
        try {
            UUID.fromString(string2);
            return true;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            return false;
        }
    }

    private static String primaryVal(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
    }

    public static String extraVal() {
        if (WildClient.widthVal != null && !WildClient.widthVal.isBlank()) {
            return WildClient.widthVal.trim();
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 != null && class_3102.method_1548() != null && class_3102.method_1548().method_1676() != null && !class_3102.method_1548().method_1676().isBlank()) {
            return class_3102.method_1548().method_1676().trim();
        }
        return "Unknown";
    }

    public synchronized int primaryVal(Set<String> set) {
        block4: {
            block3: {
                if (set == null) break block3;
                if (!set.isEmpty()) break block4;
            }
            return 0;
        }
        int n = 0;
        Iterator<ShaderPresetMeta> iterator = new ArrayList<ShaderPresetMeta>(this.speedVal.values()).iterator();
        while (iterator.hasNext()) {
            ShaderPresetMeta vUvUNNUvvNVN = iterator.next();
            if (!set.contains(ThemeShaderManager.widthVal(vUvUNNUvvNVN.secondaryVal()))) continue;
            if (!this.secondaryVal(vUvUNNUvvNVN.primaryVal())) continue;
            ++n;
        }
        return n;
    }

    private static String marginVal(String string) {
        String string2;
        String string3 = string2 = string == null ? "theme" : string.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9]+", "_").replaceAll("^_+|_+$", "");
        return string2.isBlank() ? "theme" : string2;
    }
}

