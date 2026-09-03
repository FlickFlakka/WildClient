/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 */
package ru.metaculture.protection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.wild.module.api.Module;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NnunnNUUUNVn;
import ru.metaculture.protection.AnimatedFloat;
import ru.metaculture.protection.EaseInOutQuadAnim;
import ru.metaculture.protection.HudLayoutManager;
import ru.metaculture.protection.HudSettingsPersistence;
import ru.metaculture.protection.UnHookModule;
import ru.metaculture.protection.JsonSerializable;

public final class ConfigFile
implements JsonSerializable {
    private final String paramVal;
    private final File extraVal;
    public AnimatedFloat primaryVal = new EaseInOutQuadAnim(500, 1.0);
    public AnimatedFloat secondaryVal = new EaseInOutQuadAnim(300, 1.0);
    public AnimatedFloat tertiaryVal = new EaseInOutQuadAnim(300, 1.0);
    public AnimatedFloat marginVal = new EaseInOutQuadAnim(300, 1.0);
    public AnimatedFloat weightVal = new EaseInOutQuadAnim(500, 1.0);

    public ConfigFile(String string) {
        this.paramVal = string;
        this.extraVal = new File(NnunnNUUUNVn.primaryVal, string + ".json");
        if (!this.extraVal.exists()) {
            try {
                File file = this.extraVal.getParentFile();
                if (file != null && !file.exists() && !file.mkdirs()) {
                    System.out.println("[Config] Warning: failed to create parent dir for " + string);
                }
                if (!this.extraVal.createNewFile()) {
                    System.out.println("[Config] Warning: failed to create file " + this.extraVal.getAbsolutePath());
                }
            }
            catch (Exception exception) {
                System.out.println("[Config] Cannot create config '" + string + "': " + exception.getMessage());
            }
        }
    }

    public File primaryVal() {
        return this.extraVal;
    }

    public String secondaryVal() {
        return this.paramVal;
    }

    @Override
    public JsonObject tertiaryVal() {
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        for (Module object2 : WildClient.primaryVal.secondaryVal.primaryVal) {
            JsonObject jsonObject3 = object2.saveConfig();
            this.primaryVal(object2, jsonObject3);
            jsonObject2.add(object2.name, (JsonElement)jsonObject3);
        }
        jsonObject.add("Features", (JsonElement)jsonObject2);
        JsonObject jsonObject3 = new JsonObject();
        for (Map.Entry<String, HudLayoutManager.FingerprintCrypto> entry : HudLayoutManager.primaryVal().weightVal().entrySet()) {
            JsonObject jsonObject4 = new JsonObject();
            jsonObject4.addProperty("x", (Number)Float.valueOf(entry.getValue().nx()));
            jsonObject4.addProperty("y", (Number)Float.valueOf(entry.getValue().ny()));
            jsonObject4.addProperty("scaleX", (Number)Float.valueOf(entry.getValue().scaleX()));
            jsonObject4.addProperty("scaleY", (Number)Float.valueOf(entry.getValue().scaleY()));
            jsonObject4.addProperty("resized", Boolean.valueOf(entry.getValue().userResized()));
            jsonObject3.add(entry.getKey(), (JsonElement)jsonObject4);
        }
        jsonObject.add("DraggablePositions", (JsonElement)jsonObject3);
        JsonObject jsonObject5 = new JsonObject();
        for (Map.Entry<String, Float> entry : HudLayoutManager.primaryVal().paramVal().entrySet()) {
            jsonObject5.addProperty(entry.getKey(), (Number)entry.getValue());
        }
        jsonObject.add("PendingDraggableScales", (JsonElement)jsonObject5);
        jsonObject.add("HUDSettings", (JsonElement)HudSettingsPersistence.weightVal());
        return jsonObject;
    }

    @Override
    public void primaryVal(JsonObject jsonObject) {
        JsonObject jsonObject3;
        System.out.println("[Config] Loading config: " + this.paramVal);
        if (jsonObject == null) {
            return;
        }
        boolean bl = false;
        if (jsonObject.has("Features")) {
            JsonObject featuresObj;
            try {
                featuresObj = jsonObject.getAsJsonObject("Features");
            }
            catch (Throwable throwable) {
                System.out.println("[Config] 'Features' object malformed, skipping");
                featuresObj = null;
            }
            if (featuresObj != null) {
                this.secondaryVal(featuresObj);
                int n = 0;
                for (Module object2 : WildClient.primaryVal.secondaryVal.primaryVal) {
                    try {
                        if (object2.enabled) {
                            object2.setEnabled(false);
                        }
                        if (!WildClient.primaryVal.secondaryVal.primaryVal(object2) || !featuresObj.has(object2.name)) continue;
                        jsonObject3 = null;
                        try {
                            jsonObject3 = featuresObj.getAsJsonObject(object2.name);
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                        if (jsonObject3 != null) {
                            bl |= this.primaryVal(object2, jsonObject3);
                            object2.loadConfig(jsonObject3);
                        }
                        if (!object2.enabled) continue;
                        ++n;
                    }
                    catch (Throwable throwable) {
                        System.out.println("[Config] Failed to load module '" + object2.name + "': " + throwable.getMessage());
                    }
                }
            }
        }
        if (jsonObject.has("HUDSettings")) {
            try {
                HudSettingsPersistence.primaryVal(jsonObject.getAsJsonObject("HUDSettings"));
            }
            catch (Throwable throwable) {
                System.out.println("[Config] Failed to load HUD settings: " + throwable.getMessage());
            }
        }
        if (jsonObject.has("DraggablePositions")) {
            JsonObject positionsObj = jsonObject.getAsJsonObject("DraggablePositions");
            Map<String, HudLayoutManager.FingerprintCrypto> positions = new HashMap<String, HudLayoutManager.FingerprintCrypto>();
            for (String string : positionsObj.keySet()) {
                float f;
                jsonObject3 = positionsObj.getAsJsonObject(string);
                if (!jsonObject3.has("x") || !jsonObject3.has("y")) continue;
                float f2 = jsonObject3.get("x").getAsFloat();
                float f3 = jsonObject3.get("y").getAsFloat();
                float f4 = jsonObject3.has("scaleX") ? jsonObject3.get("scaleX").getAsFloat() : 1.0f;
                float f5 = f = jsonObject3.has("scaleY") ? jsonObject3.get("scaleY").getAsFloat() : 1.0f;
                if (f4 > 10.0f || f4 <= 0.0f) {
                    f4 = 1.0f;
                }
                if (f > 10.0f || f <= 0.0f) {
                    f = 1.0f;
                }
                boolean bl2 = jsonObject3.has("resized") && jsonObject3.get("resized").getAsBoolean();
                try {
                    positions.put(string, new HudLayoutManager.FingerprintCrypto(f2, f3, f4, f, bl2));
                }
                catch (Exception exception) {
                    System.out.println("[Config] Failed to load position for: " + string);
                }
            }
            HudLayoutManager.primaryVal().primaryVal(positions);
            System.out.println("[Config] Loaded " + positions.size() + " draggable positions");
        }
        Map<String, Float> scales = new HashMap<String, Float>();
        if (jsonObject.has("PendingDraggableScales")) {
            try {
                JsonObject scalesObj = jsonObject.getAsJsonObject("PendingDraggableScales");
                Iterator<String> iterator = scalesObj.keySet().iterator();
                while (iterator.hasNext()) {
                    String string = iterator.next();
                    float f = scalesObj.get(string).getAsFloat();
                    if (!Float.isFinite(f) || !(f > 0.0f) || !(f <= 10.0f)) continue;
                    scales.put(string, Float.valueOf(f));
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        HudLayoutManager.primaryVal().secondaryVal(scales);
        if (bl && WildClient.primaryVal != null && WildClient.primaryVal.holderVal != null) {
            WildClient.primaryVal.holderVal.secondaryVal(this.paramVal);
        }
    }

    private void secondaryVal(JsonObject jsonObject) {
        if (jsonObject == null || !jsonObject.has("NoRender")) {
            return;
        }
        JsonObject jsonObject2 = null;
        try {
            jsonObject2 = jsonObject.getAsJsonObject("NoRender");
        }
        catch (Throwable throwable) {
        }
        if (jsonObject2 == null || !jsonObject2.has("Settings")) {
            return;
        }
        JsonObject jsonObject3 = null;
        try {
            jsonObject3 = jsonObject2.getAsJsonObject("Settings");
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (jsonObject3 == null) {
            return;
        }
        boolean bl = false;
        try {
            bl = jsonObject2.has("enable") && jsonObject2.get("enable").getAsBoolean();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (!bl) {
            return;
        }
        JsonObject jsonObject4 = null;
        try {
            jsonObject4 = jsonObject.has("Removals") ? jsonObject.getAsJsonObject("Removals") : new JsonObject();
        }
        catch (Throwable throwable) {
        }
        if (jsonObject4 == null) {
            jsonObject4 = new JsonObject();
        }
        JsonObject jsonObject5 = null;
        try {
            jsonObject5 = jsonObject4.has("Settings") ? jsonObject4.getAsJsonObject("Settings") : new JsonObject();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (jsonObject5 == null) {
            jsonObject5 = new JsonObject();
        }
        boolean bl2 = false;
        try {
            bl2 = jsonObject4.has("enable") && jsonObject4.get("enable").getAsBoolean();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (jsonObject2.has("enable") && !jsonObject4.has("enable")) {
            try {
                jsonObject4.add("enable", jsonObject2.get("enable").deepCopy());
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (!bl2) {
            jsonObject5.addProperty("Remove grass", Boolean.valueOf(false));
            jsonObject5.addProperty("Remove plants", Boolean.valueOf(false));
            jsonObject5.addProperty("Remove armor stands", Boolean.valueOf(false));
            jsonObject5.addProperty("Remove item frames", Boolean.valueOf(false));
            jsonObject5.addProperty("Remove paintings", Boolean.valueOf(false));
            jsonObject5.addProperty("Remove item drops", Boolean.valueOf(false));
            jsonObject5.addProperty("Remove XP orbs", Boolean.valueOf(false));
            jsonObject5.addProperty("Disable narrator", Boolean.valueOf(false));
        }
        for (String string : jsonObject3.keySet()) {
            if (jsonObject5.has(string)) continue;
            try {
                jsonObject5.add(string, jsonObject3.get(string).deepCopy());
            }
            catch (Throwable throwable) {}
        }
        if (jsonObject3.has("Don't Render") && !jsonObject5.has("Don't Render")) {
            try {
                jsonObject5.add("Don't Render", jsonObject3.get("Don't Render").deepCopy());
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        jsonObject4.add("Settings", (JsonElement)jsonObject5);
        jsonObject.add("Removals", (JsonElement)jsonObject4);
    }

    private boolean primaryVal(Module module, JsonObject jsonObject) {
        if (module == null || jsonObject == null) {
            return false;
        }
        if (module instanceof UnHookModule) {
            return jsonObject.remove("enable") != null;
        }
        return false;
    }
}

