/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package ru.metaculture.protection;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.metaculture.protection.NodeGraphMetadata;
import ru.metaculture.protection.NodeInstance;
import ru.metaculture.protection.NodeConnection;
import ru.metaculture.protection.NodeGraph;
import ru.metaculture.protection.NodeDefinitionRegistry;

public final class VnnVNVNVUnnn {
    public static final String primaryVal = "WildTheme::";

    private VnnVNVNVUnnn() {
    }

    public static String primaryVal(NodeGraph nuVVnvn2) {
        String string = VnnVNVNVUnnn.secondaryVal(nuVVnvn2).toString();
        byte[] byArray = VnnVNVNVUnnn.primaryVal(string.getBytes(StandardCharsets.UTF_8));
        String string2 = Base64.getUrlEncoder().withoutPadding().encodeToString(byArray);
        return primaryVal + VnnVNVNVUnnn.primaryVal(string) + "::" + string2;
    }

    public static NodeGraph primaryVal(String string, NodeDefinitionRegistry nodeI) {
        if (string == null || !string.startsWith(primaryVal)) {
            throw new IllegalArgumentException("Invalid WildTheme payload");
        }
        String string2 = string.substring(primaryVal.length());
        int n = string2.indexOf("::");
        String string3 = n >= 0 ? string2.substring(n + 2) : string2;
        byte[] byArray = Base64.getUrlDecoder().decode(string3);
        String string4 = new String(VnnVNVNVUnnn.secondaryVal(byArray), StandardCharsets.UTF_8);
        return VnnVNVNVUnnn.primaryVal(new JSONObject(string4), nodeI);
    }

    public static JSONObject secondaryVal(NodeGraph nuVVnvn2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("version", 3);
        jSONObject2.put("target", (Object)nuVVnvn2.secondaryVal());
        jSONObject2.put("metadata", (Object)VnnVNVNVUnnn.primaryVal(nuVVnvn2.primaryVal()));
        JSONArray jSONArray = new JSONArray();
        for (NodeInstance object : nuVVnvn2.tertiaryVal()) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", (Object)object.primaryVal());
            jSONObject3.put("kind", (Object)object.secondaryVal());
            jSONObject3.put("x", object.tertiaryVal());
            jSONObject3.put("y", object.marginVal());
            jSONObject = new JSONObject();
            for (Map.Entry<String, Float> entry : object.paramVal().entrySet()) {
                jSONObject.put(entry.getKey(), (Object)entry.getValue());
            }
            jSONObject3.put("values", (Object)jSONObject);
            JSONObject jSONObject4 = new JSONObject();
            for (Map.Entry<String, String> entry : object.extraVal().entrySet()) {
                jSONObject4.put(entry.getKey(), (Object)entry.getValue());
            }
            jSONObject3.put("textValues", (Object)jSONObject4);
            jSONArray.put((Object)jSONObject3);
        }
        JSONArray jSONArray2 = new JSONArray();
        for (NodeConnection unitJ : nuVVnvn2.marginVal()) {
            jSONObject = new JSONObject();
            jSONObject.put("fromNode", (Object)unitJ.primaryVal());
            jSONObject.put("fromPin", (Object)unitJ.secondaryVal());
            jSONObject.put("toNode", (Object)unitJ.tertiaryVal());
            jSONObject.put("toPin", (Object)unitJ.marginVal());
            jSONArray2.put((Object)jSONObject);
        }
        jSONObject2.put("nodes", (Object)jSONArray);
        jSONObject2.put("connections", (Object)jSONArray2);
        return jSONObject2;
    }

    public static NodeGraph primaryVal(JSONObject jSONObject, NodeDefinitionRegistry nodeI) {
        JSONArray jSONArray;
        NodeGraph nuVVnvn2 = new NodeGraph();
        String string = jSONObject.optString("target", "");
        if (!string.isBlank()) {
            nuVVnvn2.primaryVal(string);
        }
        nuVVnvn2.primaryVal(VnnVNVNVUnnn.primaryVal(jSONObject.optJSONObject("metadata"), jSONObject));
        JSONArray jSONArray2 = jSONObject.optJSONArray("nodes");
        if (jSONArray2 != null) {
            for (int i = 0; i < jSONArray2.length(); ++i) {
                JSONObject jSONObject3 = jSONArray2.getJSONObject(i);
                NodeInstance nodeInstance = new NodeInstance(jSONObject3.getString("id"), jSONObject3.getString("kind"), (float)jSONObject3.optDouble("x", 0.0), (float)jSONObject3.optDouble("y", 0.0));
                JSONObject jSONObject4 = jSONObject3.optJSONObject("values");
                if (jSONObject4 != null) {
                    Iterator<String> valuesIter = jSONObject4.keySet().iterator();
                    while (valuesIter.hasNext()) {
                        String key = valuesIter.next();
                        nodeInstance.secondaryVal(key, (float)jSONObject4.optDouble(key, 0.0));
                    }
                }
                JSONObject jSONObject2 = jSONObject3.optJSONObject("textValues");
                if (jSONObject2 != null) {
                    Iterator<String> textValuesIter = jSONObject2.keySet().iterator();
                    while (textValuesIter.hasNext()) {
                        String string2 = textValuesIter.next();
                        nodeInstance.secondaryVal(string2, jSONObject2.optString(string2, ""));
                    }
                }
                nuVVnvn2.primaryVal(nodeInstance, nodeI);
            }
        }
        if ((jSONArray = jSONObject.optJSONArray("connections")) != null) {
            for (int i = 0; i < jSONArray.length(); ++i) {
                JSONObject object = jSONArray.getJSONObject(i);
                nuVVnvn2.primaryVal(object.getString("fromNode"), object.getString("fromPin"), object.getString("toNode"), object.getString("toPin"), nodeI);
            }
        }
        return nuVVnvn2;
    }

    public static JSONObject primaryVal(NodeGraphMetadata itemH) {
        NodeGraphMetadata edgeA = itemH == null ? new NodeGraphMetadata() : itemH;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", (Object)edgeA.secondaryVal());
        jSONObject.put("author", (Object)edgeA.tertiaryVal());
        jSONObject.put("description", (Object)edgeA.marginVal());
        jSONObject.put("complexity", (Object)edgeA.weightVal());
        jSONObject.put("source", (Object)edgeA.paramVal());
        jSONObject.put("shapeSource", (Object)edgeA.extraVal());
        jSONObject.put("createdAt", edgeA.speedVal());
        jSONObject.put("updatedAt", edgeA.widthVal());
        jSONObject.put("favorite", edgeA.chunkVal());
        jSONObject.put("previewThumbnail", (Object)edgeA.limitVal());
        return jSONObject;
    }

    public static NodeGraphMetadata primaryVal(JSONObject jSONObject, JSONObject jSONObject2) {
        NodeGraphMetadata itemH = new NodeGraphMetadata();
        JSONObject jSONObject3 = jSONObject == null ? new JSONObject() : jSONObject;
        JSONObject jSONObject4 = jSONObject2 == null ? new JSONObject() : jSONObject2;
        itemH.primaryVal(jSONObject3.optString("name", jSONObject4.optString("displayName", "")));
        itemH.secondaryVal(jSONObject3.optString("author", jSONObject4.optString("author", "")));
        itemH.tertiaryVal(jSONObject3.optString("description", jSONObject4.optString("description", "")));
        itemH.marginVal(jSONObject3.optString("complexity", jSONObject4.optString("complexity", "Custom")));
        itemH.weightVal(jSONObject3.optString("source", jSONObject4.optString("source", "local")));
        itemH.paramVal(jSONObject3.optString("shapeSource", jSONObject4.optString("shapeSource", "Host Rectangle")));
        itemH.primaryVal(jSONObject3.optLong("createdAt", jSONObject4.optLong("createdAt", 0L)));
        itemH.secondaryVal(jSONObject3.optLong("updatedAt", jSONObject4.optLong("updatedAt", 0L)));
        itemH.primaryVal(jSONObject3.optBoolean("favorite", jSONObject4.optBoolean("favorite", false)));
        itemH.extraVal(jSONObject3.optString("previewThumbnail", jSONObject4.optString("previewThumbnail", "")));
        return itemH;
    }

    private static byte[] primaryVal(byte[] byArray) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);){
                gZIPOutputStream.write(byArray);
            }
            return byteArrayOutputStream.toByteArray();
        }
        catch (Exception exception) {
            throw new IllegalStateException("GZIP export failed", exception);
        }
    }

    private static byte[] secondaryVal(byte[] byArray) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try (GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(byArray));){
                gZIPInputStream.transferTo(byteArrayOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        }
        catch (Exception exception) {
            throw new IllegalArgumentException("GZIP import failed", exception);
        }
    }

    private static String primaryVal(String string) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] byArray = messageDigest.digest(string.getBytes(StandardCharsets.UTF_8));
            StringBuilder stringBuilder = new StringBuilder(16);
            for (int i = 0; i < 8; ++i) {
                stringBuilder.append(String.format("%02x", byArray[i] & 0xFF));
            }
            return stringBuilder.toString();
        }
        catch (Exception exception) {
            return "0000000000000000";
        }
    }
}

