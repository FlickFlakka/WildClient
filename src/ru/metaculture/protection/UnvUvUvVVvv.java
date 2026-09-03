/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.metaculture.protection.StudioModelData;

public final class UnvUvUvVVvv {
    private static final String[] primaryVal = new String[]{"north", "east", "south", "west", "up", "down"};

    private UnvUvUvVVvv() {
    }

    public static StudioModelData primaryVal(String string) {
        Object object;
        Object object2;
        JSONArray jSONArray;
        JSONObject jSONObject = new JSONObject(string);
        int n = 16;
        int n2 = 16;
        JSONObject jSONObject2 = jSONObject.optJSONObject("resolution");
        if (jSONObject2 != null) {
            n = jSONObject2.optInt("width", 16);
            n2 = jSONObject2.optInt("height", 16);
        }
        List<StudioModelData.FingerprintCrypto> list = UnvUvUvVVvv.primaryVal(jSONObject.optJSONArray("textures"), n, n2);
        HashMap<String, StudioModelData.cursorVal> hashMap = new HashMap<String, StudioModelData.cursorVal>();
        HashMap<String, StudioModelData.DelayedFuse> hashMap2 = new HashMap<String, StudioModelData.DelayedFuse>();
        JSONArray jSONArray2 = jSONObject.optJSONArray("elements");
        if (jSONArray2 != null) {
            for (int i = 0; i < jSONArray2.length(); ++i) {
                JSONObject jSONObject3 = jSONArray2.optJSONObject(i);
                if (jSONObject3 == null) {
                    continue;
                }
                object2 = jSONObject3.optString("type", "cube");
                String string2 = jSONObject3.optString("uuid", "el" + i);
                if ("mesh".equals(object2)) {
                    object = UnvUvUvVVvv.primaryVal(jSONObject3);
                    if (object == null) continue;
                    hashMap2.put(string2, (StudioModelData.DelayedFuse)object);
                    continue;
                }
                if (!"cube".equals(object2)) continue;
                object = UnvUvUvVVvv.secondaryVal(jSONObject3);
                if (object == null) continue;
                hashMap.put(string2, (StudioModelData.cursorVal)object);
            }
        }
        ArrayList<StudioModelData.WildClient> arrayList = new ArrayList<StudioModelData.WildClient>();
        jSONArray = jSONObject.optJSONArray("outliner");
        if (jSONArray != null) {
            object2 = null;
            for (int i = 0; i < jSONArray.length(); ++i) {
                Object object3;
                object = jSONArray.get(i);
                if (object instanceof JSONObject) {
                    JSONObject jSONObject3 = (JSONObject)object;
                    object3 = UnvUvUvVVvv.primaryVal(jSONObject3, hashMap, hashMap2);
                    if (object3 == null) continue;
                    arrayList.add((StudioModelData.WildClient)object3);
                    continue;
                }
                if (!(object instanceof String)) continue;
                String string3 = (String)object;
                object3 = (StudioModelData.cursorVal)hashMap.get(string3);
                StudioModelData.DelayedFuse uunvUUVnuNn2 = (StudioModelData.DelayedFuse)hashMap2.get(string3);
                if (object3 == null) {
                    if (uunvUUVnuNn2 == null) continue;
                }
                if (object2 == null) {
                    object2 = new StudioModelData.WildClient("root", 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
                    arrayList.add((StudioModelData.WildClient)object2);
                }
                if (object3 != null) {
                    ((StudioModelData.WildClient)object2).widthVal().add((StudioModelData.cursorVal)object3);
                }
                if (uunvUUVnuNn2 == null) continue;
                ((StudioModelData.WildClient)object2).chunkVal().add(uunvUUVnuNn2);
            }
        }
        return new StudioModelData(n, n2, list, arrayList);
    }

    private static List<StudioModelData.FingerprintCrypto> primaryVal(JSONArray jSONArray, int n, int n2) {
        ArrayList<StudioModelData.FingerprintCrypto> arrayList = new ArrayList<StudioModelData.FingerprintCrypto>();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); ++i) {
            JSONObject jSONObject = jSONArray.optJSONObject(i);
            if (jSONObject == null) continue;
            String string = jSONObject.optString("name", "texture_" + i);
            int n3 = jSONObject.optInt("uv_width", jSONObject.optInt("width", n));
            int n4 = jSONObject.optInt("uv_height", jSONObject.optInt("height", n2));
            byte[] byArray = UnvUvUvVVvv.secondaryVal(jSONObject.optString("source", ""));
            arrayList.add(new StudioModelData.FingerprintCrypto(string, byArray, n3, n4));
        }
        return arrayList;
    }

    private static byte[] secondaryVal(String string) {
        if (string == null || string.isEmpty()) {
            return new byte[0];
        }
        int n = string.indexOf(44);
        String string2 = string.startsWith("data:") && n >= 0 ? string.substring(n + 1) : string;
        try {
            return Base64.getDecoder().decode(string2.replaceAll("\\s", ""));
        }
        catch (RuntimeException runtimeException) {
            return new byte[0];
        }
    }

    private static StudioModelData.WildClient primaryVal(JSONObject jSONObject, Map<String, StudioModelData.cursorVal> map, Map<String, StudioModelData.DelayedFuse> map2) {
        String string = jSONObject.optString("name", "");
        float[] fArray = UnvUvUvVVvv.primaryVal(jSONObject.optJSONArray("origin"), 0.0f);
        float[] fArray2 = UnvUvUvVVvv.primaryVal(jSONObject.optJSONArray("rotation"), 0.0f);
        StudioModelData.WildClient modeVal = new StudioModelData.WildClient(string, fArray[0], fArray[1], fArray[2], fArray2[0], fArray2[1], fArray2[2]);
        JSONArray jSONArray = jSONObject.optJSONArray("children");
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); ++i) {
                StudioModelData.DelayedFuse uunvUUVnuNn2;
                Object object;
                Object object2 = jSONArray.get(i);
                if (object2 instanceof JSONObject) {
                    JSONObject jSONObject2 = (JSONObject)object2;
                    object = UnvUvUvVVvv.primaryVal(jSONObject2, map, map2);
                    if (object == null) continue;
                    modeVal.speedVal().add((StudioModelData.WildClient)object);
                    continue;
                }
                if (!(object2 instanceof String)) continue;
                String string2 = (String)object2;
                object = map.get(string2);
                if (object != null) {
                    modeVal.widthVal().add((StudioModelData.cursorVal)object);
                }
                if ((uunvUUVnuNn2 = map2.get(string2)) == null) continue;
                modeVal.chunkVal().add(uunvUUVnuNn2);
            }
        }
        return modeVal;
    }

    private static StudioModelData.DelayedFuse primaryVal(JSONObject jSONObject) {
        JSONObject jSONObject2;
        float[] fArray;
        float[] fArray2;
        block10: {
            block9: {
                fArray2 = UnvUvUvVVvv.primaryVal(jSONObject.optJSONArray("origin"), 0.0f);
                fArray = UnvUvUvVVvv.primaryVal(jSONObject.optJSONArray("rotation"), 0.0f);
                jSONObject2 = jSONObject.optJSONObject("vertices");
                if (jSONObject2 == null) break block9;
                if (!jSONObject2.isEmpty()) break block10;
            }
            return null;
        }
        HashMap<Object, Integer> hashMap = new HashMap<Object, Integer>();
        float[] fArray3 = new float[jSONObject2.length() * 3];
        int n = 0;
        for (Object vertexKey : jSONObject2.keySet()) {
            JSONArray object = jSONObject2.optJSONArray((String)vertexKey);
            if (object == null || object.length() < 3) continue;
            hashMap.put(vertexKey, n);
            fArray3[n * 3] = (float)object.optDouble(0, 0.0);
            fArray3[n * 3 + 1] = (float)object.optDouble(1, 0.0);
            fArray3[n * 3 + 2] = (float)object.optDouble(2, 0.0);
            ++n;
        }
        JSONObject jSONObject3 = jSONObject.optJSONObject("faces");
        if (jSONObject3 == null) {
            return null;
        }
        ArrayList<StudioModelData.AccessGuardException> object22 = new ArrayList<StudioModelData.AccessGuardException>();
        Iterator object = jSONObject3.keySet().iterator();
        while (object.hasNext()) {
            String string = (String)object.next();
            JSONObject jSONObject4 = jSONObject3.optJSONObject(string);
            if (jSONObject4 == null) continue;
            JSONArray jSONArray = jSONObject4.optJSONArray("vertices");
            JSONObject jSONObject5 = jSONObject4.optJSONObject("uv");
            if (jSONArray == null) continue;
            if (jSONArray.length() < 3) continue;
            int n2 = Math.min(4, jSONArray.length());
            int[] nArray = new int[4];
            float[] fArray4 = new float[4];
            float[] fArray5 = new float[4];
            boolean bl = true;
            for (int i = 0; i < n2; ++i) {
                String string2 = jSONArray.optString(i, "");
                Integer n3 = (Integer)hashMap.get(string2);
                if (n3 == null) {
                    bl = false;
                    break;
                }
                nArray[i] = n3;
                JSONArray jSONArray2 = jSONObject5 == null ? null : jSONObject5.optJSONArray(string2);
                fArray4[i] = jSONArray2 == null ? 0.0f : (float)jSONArray2.optDouble(0, 0.0);
                fArray5[i] = jSONArray2 == null ? 0.0f : (float)jSONArray2.optDouble(1, 0.0);
            }
            if (!bl) continue;
            object22.add(new StudioModelData.AccessGuardException(n2, nArray, fArray4, fArray5, jSONObject4.optInt("texture", 0)));
        }
        if (object22.isEmpty()) {
            return null;
        }
        return new StudioModelData.DelayedFuse(fArray2[0], fArray2[1], fArray2[2], fArray[0], fArray[1], fArray[2], fArray3, object22.toArray(new StudioModelData.AccessGuardException[0]));
    }

    private static StudioModelData.cursorVal secondaryVal(JSONObject jSONObject) {
        float[] fArray = UnvUvUvVVvv.primaryVal(jSONObject.optJSONArray("from"), 0.0f);
        float[] fArray2 = UnvUvUvVVvv.primaryVal(jSONObject.optJSONArray("to"), 0.0f);
        float[] fArray3 = UnvUvUvVVvv.primaryVal(jSONObject.optJSONArray("origin"), 0.0f);
        float[] fArray4 = UnvUvUvVVvv.primaryVal(jSONObject.optJSONArray("rotation"), 0.0f);
        float f = (float)jSONObject.optDouble("inflate", 0.0);
        JSONObject jSONObject2 = jSONObject.optJSONObject("faces");
        StudioModelData.VvunVVUvUNnv[] vvunVVUvUNnvArray = new StudioModelData.VvunVVUvUNnv[primaryVal.length];
        boolean bl = false;
        if (jSONObject2 != null) {
            for (int i = 0; i < primaryVal.length; ++i) {
                JSONObject jSONObject3 = jSONObject2.optJSONObject(primaryVal[i]);
                if (jSONObject3 == null || jSONObject3.isNull("texture")) continue;
                JSONArray jSONArray = jSONObject3.optJSONArray("uv");
                if (jSONArray == null || jSONArray.length() < 4) continue;
                int n = jSONObject3.optInt("texture", 0);
                vvunVVUvUNnvArray[i] = new StudioModelData.VvunVVUvUNnv(n, (float)jSONArray.optDouble(0, 0.0), (float)jSONArray.optDouble(1, 0.0), (float)jSONArray.optDouble(2, 0.0), (float)jSONArray.optDouble(3, 0.0));
                bl = true;
            }
        }
        if (!bl) {
            return null;
        }
        return new StudioModelData.cursorVal(fArray[0], fArray[1], fArray[2], fArray2[0], fArray2[1], fArray2[2], fArray3[0], fArray3[1], fArray3[2], fArray4[0], fArray4[1], fArray4[2], f, vvunVVUvUNnvArray);
    }

    private static float[] primaryVal(JSONArray jSONArray, float f) {
        float[] fArray = new float[]{f, f, f};
        if (jSONArray == null) {
            return fArray;
        }
        for (int i = 0; i < 3 && i < jSONArray.length(); ++i) {
            fArray[i] = (float)jSONArray.optDouble(i, (double)f);
        }
        return fArray;
    }
}

