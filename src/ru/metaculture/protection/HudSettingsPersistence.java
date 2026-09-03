/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 */
package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.ShaderPresetSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.RequiresRole;
import ru.metaculture.protection.ModuleManager;
import ru.metaculture.protection.SettingHolder;
import ru.metaculture.protection.HudElementInfo;
import ru.metaculture.protection.BoolSetting;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class HudSettingsPersistence {
    private static final List<SettingHolder> primaryVal;
    private static final Gson secondaryVal;
    private static JsonObject tertiaryVal;
    private static boolean marginVal;

    private static File paramVal() {
        return new File(WildClient.primaryVal.paramVal, "hudP.cfg");
    }

    @Compile
    public static void primaryVal() {
        if (marginVal) {
            HudSettingsPersistence.extraVal();
            HudSettingsPersistence.limitVal();
            return;
        }
        File file = HudSettingsPersistence.paramVal();
        if (!file.exists()) {
            return;
        }
        try (FileReader fileReader = new FileReader(file);){
            JsonObject jsonObject = (JsonObject)secondaryVal.fromJson((Reader)fileReader, JsonObject.class);
            Field field = HudSettingsPersistence.class.getDeclaredField("tertiaryVal");
            field.setAccessible(true);
            field.set(null, jsonObject);
            if (tertiaryVal != null) {
                HudSettingsPersistence.extraVal();
            }
            if (WildClient.primaryVal != null && WildClient.primaryVal.holderVal != null) {
                WildClient.primaryVal.holderVal.tertiaryVal();
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Compile
    public static void primaryVal(SettingHolder vVvnUVnUvv2) {
        if (vVvnUVnUvv2 == null || !HudSettingsPersistence.primaryVal(vVvnUVnUvv2.getClass()) || primaryVal.contains(vVvnUVnUvv2)) {
            return;
        }
        primaryVal.add(vVvnUVnUvv2);
        HudSettingsPersistence.primaryVal(vVvnUVnUvv2);
    }

    public static List<SettingHolder> secondaryVal() {
        return primaryVal.stream().filter(vVvnUVnUvv2 -> {
            if (vVvnUVnUvv2 == null) return false;
            if (!HudSettingsPersistence.primaryVal(vVvnUVnUvv2.getClass())) return false;
            return true;
        }).toList();
    }

    public static void tertiaryVal() {
        tertiaryVal = new JsonObject();
        for (SettingHolder vVvnUVnUvv2 : HudSettingsPersistence.secondaryVal()) {
            Iterator<Setting> iterator = vVvnUVnUvv2.primaryVal().iterator();
            while (iterator.hasNext()) {
                Setting nodeA = iterator.next();
                if (nodeA == null || nodeA.tertiaryVal) continue;
                nodeA.secondaryVal();
            }
        }
        HudSettingsPersistence.marginVal();
    }

    public static boolean primaryVal(Class<?> clazz) {
        return clazz != null && ModuleManager.primaryVal(clazz.getAnnotation(RequiresRole.class));
    }

    @Compile
    private static void secondaryVal(SettingHolder vVvnUVnUvv2) {
        if (vVvnUVnUvv2 == null) {
            return;
        }
        Class<?> clazz = vVvnUVnUvv2.getClass();
        if (clazz == null) {
            return;
        }
        HudElementInfo reedD = clazz.getAnnotation(HudElementInfo.class);
        if (reedD == null) {
            return;
        }
        JsonObject jsonObject = tertiaryVal;
        String string = reedD.primaryVal();
        if (jsonObject == null || !jsonObject.has(string)) {
            return;
        }
        JsonObject jsonObject2 = tertiaryVal;
        String string2 = reedD.primaryVal();
        JsonObject jsonObject3 = jsonObject2 == null ? null : jsonObject2.getAsJsonObject(string2);
        List<Setting> list = vVvnUVnUvv2.primaryVal();
        if (list == null) {
            return;
        }
        Iterator<Setting> iterator = list.iterator();
        if (iterator == null) {
            return;
        }
        while (iterator.hasNext()) {
            List<String> list2;
            List<BoolSetting> list3;
            JsonElement jsonElement;
            Setting nodeA = iterator.next();
            if (nodeA == null || nodeA.tertiaryVal) continue;
            if (nodeA instanceof BoolSetting) {
                BoolSetting vvNnnUNnVvn2 = (BoolSetting)nodeA;
                if (jsonObject3 == null || !jsonObject3.has(vvNnnUNnVvn2.primaryVal)) continue;
                jsonElement = jsonObject3.get(vvNnnUNnVvn2.primaryVal);
                vvNnnUNnVvn2.secondaryVal(jsonElement != null && jsonElement.getAsBoolean());
                continue;
            }
            if (nodeA instanceof FloatSetting) {
                FloatSetting itemA = (FloatSetting)nodeA;
                if (jsonObject3 == null || !jsonObject3.has(itemA.primaryVal)) continue;
                jsonElement = jsonObject3.get(itemA.primaryVal);
                itemA.primaryVal(jsonElement == null ? 0.0f : jsonElement.getAsFloat());
                continue;
            }
            if (nodeA instanceof ModeSetting) {
                ModeSetting twigG = (ModeSetting)nodeA;
                if (jsonObject3 == null || !jsonObject3.has(twigG.primaryVal)) continue;
                jsonElement = jsonObject3.get(twigG.primaryVal);
                String string3 = jsonElement == null ? null : jsonElement.getAsString();
                list2 = twigG.marginVal;
                int n = list2 == null ? -1 : list2.indexOf(string3);
                if (n < 0) continue;
                twigG.limitVal = n;
                twigG.weightVal = list2 == null ? null : (String)list2.get(n);
                continue;
            }
            if (nodeA instanceof ShaderPresetSetting) {
                ShaderPresetSetting ili11Iii1Ii2 = (ShaderPresetSetting)nodeA;
                if (jsonObject3 == null || !jsonObject3.has(ili11Iii1Ii2.primaryVal)) continue;
                jsonElement = jsonObject3.get(ili11Iii1Ii2.primaryVal);
                ili11Iii1Ii2.tertiaryVal(jsonElement == null ? null : jsonElement.getAsString());
                continue;
            }
            if (!(nodeA instanceof SettingGroup)) continue;
            SettingGroup vUVnvvnNN = (SettingGroup)nodeA;
            if (jsonObject3 == null || !jsonObject3.has(vUVnvvnNN.primaryVal)) continue;
            JsonObject jsonObject4 = jsonObject3.getAsJsonObject(vUVnvvnNN.primaryVal);
            list3 = vUVnvvnNN.marginVal;
            Iterator<BoolSetting> iterator2;
            if (list3 == null || (iterator2 = list3.iterator()) == null) continue;
            while (iterator2.hasNext()) {
                BoolSetting vvNnnUNnVvn3 = iterator2.next();
                if (jsonObject4 == null || !jsonObject4.has(vvNnnUNnVvn3.primaryVal)) continue;
                JsonElement jsonElement2 = jsonObject4.get(vvNnnUNnVvn3.primaryVal);
                vvNnnUNnVvn3.secondaryVal(jsonElement2 != null && jsonElement2.getAsBoolean());
            }
        }
    }

    public static void marginVal() {
        tertiaryVal = HudSettingsPersistence.weightVal();
        HudSettingsPersistence.limitVal();
        if (WildClient.primaryVal != null) {
            if (WildClient.primaryVal.holderVal != null) {
                WildClient.primaryVal.holderVal.tertiaryVal();
            }
        }
    }

    public static JsonObject weightVal() {
        JsonObject jsonObject = new JsonObject();
        Iterator<SettingHolder> iterator = HudSettingsPersistence.secondaryVal().iterator();
        while (iterator.hasNext()) {
            SettingHolder vVvnUVnUvv2 = iterator.next();
            HudElementInfo reedD = vVvnUVnUvv2.getClass().getAnnotation(HudElementInfo.class);
            if (reedD == null) continue;
            JsonObject jsonObject2 = new JsonObject();
            for (Setting nodeA : vVvnUVnUvv2.primaryVal()) {
                if (nodeA == null || nodeA.tertiaryVal) continue;
                if (nodeA instanceof BoolSetting) {
                    BoolSetting vvNnnUNnVvn2 = (BoolSetting)nodeA;
                    jsonObject2.addProperty(vvNnnUNnVvn2.primaryVal, Boolean.valueOf(vvNnnUNnVvn2.tertiaryVal()));
                    continue;
                }
                if (nodeA instanceof FloatSetting) {
                    FloatSetting itemA = (FloatSetting)nodeA;
                    jsonObject2.addProperty(itemA.primaryVal, (Number)Float.valueOf(itemA.tertiaryVal()));
                    continue;
                }
                if (nodeA instanceof ModeSetting) {
                    ModeSetting twigG = (ModeSetting)nodeA;
                    jsonObject2.addProperty(twigG.primaryVal, twigG.tertiaryVal());
                    continue;
                }
                if (nodeA instanceof ShaderPresetSetting) {
                    ShaderPresetSetting ili11Iii1Ii2 = (ShaderPresetSetting)nodeA;
                    jsonObject2.addProperty(ili11Iii1Ii2.primaryVal, ili11Iii1Ii2.extraVal());
                    continue;
                }
                if (!(nodeA instanceof SettingGroup)) continue;
                SettingGroup vUVnvvnNN = (SettingGroup)nodeA;
                JsonObject jsonObject3 = new JsonObject();
                Iterator<BoolSetting> iterator2 = vUVnvvnNN.marginVal.iterator();
                while (iterator2.hasNext()) {
                    BoolSetting vvNnnUNnVvn3 = iterator2.next();
                    jsonObject3.addProperty(vvNnnUNnVvn3.primaryVal, Boolean.valueOf(vvNnnUNnVvn3.tertiaryVal()));
                }
                jsonObject2.add(vUVnvvnNN.primaryVal, (JsonElement)jsonObject3);
            }
            jsonObject.add(reedD.primaryVal(), (JsonElement)jsonObject2);
        }
        return jsonObject;
    }

    public static void primaryVal(JsonObject jsonObject) {
        if (jsonObject == null) {
            return;
        }
        tertiaryVal = jsonObject.deepCopy();
        marginVal = true;
        HudSettingsPersistence.extraVal();
        HudSettingsPersistence.limitVal();
    }

    private static void extraVal() {
        Iterator<SettingHolder> iterator = primaryVal.iterator();
        while (iterator.hasNext()) {
            SettingHolder vVvnUVnUvv2 = iterator.next();
            HudSettingsPersistence.secondaryVal(vVvnUVnUvv2);
        }
    }

    private static void limitVal() {
        try {
            File file = HudSettingsPersistence.paramVal();
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            try (FileWriter fileWriter = new FileWriter(file);){
                secondaryVal.toJson((JsonElement)tertiaryVal, (Appendable)fileWriter);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    static {
        Loader.initialize();
        primaryVal = new ArrayList<SettingHolder>();
        secondaryVal = new GsonBuilder().setPrettyPrinting().create();
        tertiaryVal = new JsonObject();
    }
}

