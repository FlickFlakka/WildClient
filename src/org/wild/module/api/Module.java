/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  lombok.Generated
 *  net.minecraft.class_310
 */
package org.wild.module.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import lombok.Generated;
import net.minecraft.class_310;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ClientUtilModule;
import ru.metaculture.protection.SettingList;
import ru.metaculture.protection.EventManager;
import ru.metaculture.protection.StringSlotSetting;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.MenuModule;
import ru.metaculture.protection.DynamicActionButton;
import ru.metaculture.protection.AnimatedFloat;
import ru.metaculture.protection.UnUnNvvu;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.EaseInOutQuadAnim;
import ru.metaculture.protection.AnimatedDouble;
import ru.metaculture.protection.VnnUVUVvV;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.Easing;
import ru.metaculture.protection.ShaderPresetSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.NotificationsHud;
import ru.metaculture.protection.StringListSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.RequiresRole;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.AnimatedValue;
import ru.metaculture.protection.ButtonSetting;
import ru.metaculture.protection.SoundUtil;
import ru.metaculture.protection.BoolSetting;

public class Module
extends SettingList {
    private static final String RESET_SETTINGS_LABEL = "Reset settings";
    private static final String FACTORY_DEFAULTS_LABEL = "To factory defaults";
    public ModuleRegister moduleRegister = this.getClass().getAnnotation(ModuleRegister.class);
    public RequiresRole requiresRole = this.getClass().getAnnotation(RequiresRole.class);
    public static class_310 mc = class_310.method_1551();
    public String name;
    public int keyIndex = -1;
    public boolean enabled = false;
    public boolean holdActive = false;
    public ModuleCategory category;
    public String displayName;
    public String description;
    public boolean expanded;
    public boolean wasToggled = true;
    public UnUnNvvu position = new UnUnNvvu(0.0f, 0.0f);
    protected final Set<ModuleBadge> badges = new HashSet<ModuleBadge>();
    protected boolean badgeWarned;
    protected final DynamicActionButton resetButton = new DynamicActionButton("Reset settings", 0, () -> "To factory defaults").secondaryVal(this::resetToDefaults);
    public AnimatedDouble scaleAnim = new AnimatedDouble();
    public AnimatedFloat slideAnim = new EaseInOutQuadAnim(300, 1.0);
    public AnimatedFloat fadeAnim = new EaseInOutQuadAnim(300, 1.0);
    public final AnimatedValue enableAnim = new AnimatedValue();

    public Module() {
        this.name = this.moduleRegister.primaryVal();
        this.category = this.moduleRegister.tertiaryVal();
        this.description = this.moduleRegister.secondaryVal();
        this.displayName = this.name;
        Collections.addAll(this.badges, this.moduleRegister.marginVal());
    }

    public void onEnable() {
        try {
            EventManager.register(this);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this.enabled = false;
            return;
        }
        if (Module.mc.field_1724 != null && !(this instanceof MenuModule)) {
            NotificationsHud.primaryVal(this.name, true);
            if (WildClient.primaryVal.secondaryVal.primaryVal(ClientUtilModule.class).enabled) {
                if (ClientUtilModule.depthVal.tertiaryVal() && ClientUtilModule.descRef.secondaryVal("Modules")) {
                    SoundUtil.primaryVal("Function_ON", ClientUtilModule.activeVal.tertiaryVal() / 250.0f);
                }
            }
        }
        this.enableAnim.primaryVal(1.0, (double)0.24f, Easing.timerVal);
    }

    public void onDisable() {
        EventManager.unregister(this);
        if (Module.mc.field_1724 != null && !WildClient.layerVal() && !(this instanceof MenuModule)) {
            NotificationsHud.primaryVal(this.name, false);
            if (WildClient.primaryVal.secondaryVal.primaryVal(ClientUtilModule.class).enabled) {
                if (ClientUtilModule.depthVal.tertiaryVal() && ClientUtilModule.descRef.secondaryVal("Modules")) {
                    SoundUtil.primaryVal("Function_OFF", ClientUtilModule.activeVal.tertiaryVal() / 250.0f);
                }
            }
        }
        this.enableAnim.primaryVal(0.0, (double)0.24f, Easing.timerVal);
    }

    public void toggle() {
        this.setEnabledInternal(!this.enabled, true);
    }

    public JsonObject saveConfig() {
        JsonObject jsonObject = new JsonObject();
        if (this.enabled) {
            jsonObject.addProperty("enable", Boolean.valueOf(this.enabled));
        }
        if (this.keyIndex != -1) {
            jsonObject.addProperty("keyIndex", (Number)this.keyIndex);
        }
        JsonObject jsonObject2 = new JsonObject();
        for (Setting nodeA : this.getAllSettings()) {
            if (nodeA == null || nodeA.tertiaryVal) continue;
            String string = nodeA.primaryVal();
            if (nodeA instanceof BoolSetting) {
                BoolSetting vvNnnUNnVvn2 = (BoolSetting)nodeA;
                jsonObject2.addProperty(string, Boolean.valueOf(vvNnnUNnVvn2.marginVal()));
                if (vvNnnUNnVvn2.paramVal != -1) {
                    JsonObject twigG = new JsonObject();
                    twigG.addProperty("key", vvNnnUNnVvn2.paramVal);
                    twigG.addProperty("hold", vvNnnUNnVvn2.extraVal);
                    jsonObject2.add(string + "$bind", (JsonElement)twigG);
                }
            } else if (nodeA instanceof ModeSetting) {
                ModeSetting twigG = (ModeSetting)nodeA;
                jsonObject2.addProperty(string, twigG.weightVal);
            } else if (nodeA instanceof ShaderPresetSetting) {
                ShaderPresetSetting ili11Iii1Ii2 = (ShaderPresetSetting)nodeA;
                jsonObject2.addProperty(string, ili11Iii1Ii2.extraVal());
            } else if (nodeA instanceof StringListSetting) {
                StringListSetting nuunVnvU2 = (StringListSetting)nodeA;
                jsonObject2.addProperty(string, String.join((CharSequence)", ", nuunVnvU2.extraVal));
            } else if (nodeA instanceof FloatSetting) {
                FloatSetting itemA = (FloatSetting)nodeA;
                jsonObject2.addProperty(string, (Number)Float.valueOf(itemA.marginVal));
            } else if (nodeA instanceof KeybindSetting) {
                KeybindSetting uVNuNUVvn2 = (KeybindSetting)nodeA;
                jsonObject2.addProperty(string, (Number)uVNuNUVvn2.marginVal);
            } else if (nodeA instanceof StringFilterSetting) {
                StringFilterSetting linkH = (StringFilterSetting)nodeA;
                jsonObject2.addProperty(string, linkH.weightVal);
            } else if (nodeA instanceof StringSlotSetting) {
                StringSlotSetting nVnVVNVNnv = (StringSlotSetting)nodeA;
                jsonObject2.add(string, (JsonElement)nVnVVNVNnv.extraVal());
            } else if (nodeA instanceof ColorSetting) {
                ColorSetting nodeG = (ColorSetting)nodeA;
                JsonObject vUVnvvnNN = new JsonObject();
                vUVnvvnNN.addProperty("current", Float.valueOf(nodeG.weightVal));
                vUVnvvnNN.addProperty("saturation", Float.valueOf(nodeG.holderVal));
                vUVnvvnNN.addProperty("brightness", Float.valueOf(nodeG.timerVal));
                jsonObject2.add(string, (JsonElement)vUVnvvnNN);
            } else if (nodeA instanceof SettingGroup) {
                SettingGroup vUVnvvnNN = (SettingGroup)nodeA;
                JsonObject jsonObject3 = new JsonObject();
                JsonObject jsonObject4 = new JsonObject();
                for (BoolSetting vvNnnUNnVvn3 : vUVnvvnNN.marginVal) {
                    jsonObject3.addProperty(vvNnnUNnVvn3.primaryVal, Boolean.valueOf(vvNnnUNnVvn3.marginVal()));
                    if (vvNnnUNnVvn3.paramVal == -1) continue;
                    JsonObject jsonObject5 = new JsonObject();
                    jsonObject5.addProperty("key", (Number)vvNnnUNnVvn3.paramVal);
                    jsonObject5.addProperty("hold", Boolean.valueOf(vvNnnUNnVvn3.extraVal));
                    jsonObject4.add(vvNnnUNnVvn3.primaryVal, (JsonElement)jsonObject5);
                }
                jsonObject2.add(string, (JsonElement)jsonObject3);
                if (jsonObject4.size() > 0) {
                    jsonObject2.add(string + "$binds", (JsonElement)jsonObject4);
                }
            }
        }
        jsonObject.add("Settings", (JsonElement)jsonObject2);
        return jsonObject;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void loadConfig(JsonObject jsonObject) {
        if (jsonObject == null) {
            return;
        }
        try {
            if (jsonObject.has("enable")) {
                this.setEnabled(jsonObject.get("enable").getAsBoolean());
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        try {
            if (jsonObject.has("keyIndex")) {
                this.keyIndex = jsonObject.get("keyIndex").getAsInt();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        JsonObject jsonObject2 = null;
        try {
            jsonObject2 = jsonObject.getAsJsonObject("Settings");
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (jsonObject2 == null) {
            return;
        }
        Iterator<Setting> iterator = this.getAllSettings().iterator();
        while (iterator.hasNext()) {
            String string;
            Setting nodeA = iterator.next();
            if (nodeA == null || nodeA.tertiaryVal || !jsonObject2.has(string = nodeA.primaryVal())) continue;
            try {
                if (nodeA instanceof BoolSetting) {
                    BoolSetting vvNnnUNnVvn2 = (BoolSetting)nodeA;
                    vvNnnUNnVvn2.secondaryVal(jsonObject2.get(string).getAsBoolean());
                    JsonElement twigG = jsonObject2.get(string + "$bind");
                    if (twigG != null && twigG.isJsonObject()) {
                        JsonObject object = twigG.getAsJsonObject();
                        if (object.has("key")) {
                            vvNnnUNnVvn2.paramVal = object.get("key").getAsInt();
                        }
                        if (object.has("hold")) {
                            vvNnnUNnVvn2.extraVal = object.get("hold").getAsBoolean();
                        }
                    }
                } else if (nodeA instanceof ModeSetting) {
                    ModeSetting twigG = (ModeSetting)nodeA;
                    String object = jsonObject2.get(string).getAsString();
                    if (twigG.marginVal != null && twigG.marginVal.contains(object)) {
                        twigG.weightVal = object;
                        twigG.limitVal = twigG.marginVal.indexOf(object);
                    }
                } else if (nodeA instanceof FloatSetting) {
                    FloatSetting itemA = (FloatSetting)nodeA;
                    float f = jsonObject2.get(string).getAsFloat();
                    if (!Float.isNaN(f) && !Float.isInfinite(f)) {
                        itemA.marginVal = Math.max(itemA.weightVal, Math.min(itemA.paramVal, f));
                    }
                } else if (nodeA instanceof ShaderPresetSetting) {
                    ShaderPresetSetting ili11Iii1Ii2 = (ShaderPresetSetting)nodeA;
                    ili11Iii1Ii2.tertiaryVal(jsonObject2.get(string).getAsString());
                } else if (nodeA instanceof KeybindSetting) {
                    KeybindSetting uVNuNUVvn2 = (KeybindSetting)nodeA;
                    uVNuNUVvn2.marginVal = jsonObject2.get(string).getAsInt();
                } else if (nodeA instanceof StringFilterSetting) {
                    StringFilterSetting linkH = (StringFilterSetting)nodeA;
                    linkH.secondaryVal(jsonObject2.get(string).getAsString());
                } else if (nodeA instanceof StringSlotSetting) {
                    StringSlotSetting nVnVVNVNnv = (StringSlotSetting)nodeA;
                    nVnVVNVNnv.primaryVal(jsonObject2.get(string));
                } else if (nodeA instanceof ColorSetting) {
                    ColorSetting nodeG = (ColorSetting)nodeA;
                    JsonElement vUVnvvnNN = jsonObject2.get(string);
                    if (vUVnvvnNN != null && vUVnvvnNN.isJsonObject()) {
                        JsonObject nuunVnvU2 = vUVnvvnNN.getAsJsonObject();
                        float f;
                        if (nuunVnvU2.has("current") && !Float.isNaN(f = nuunVnvU2.get("current").getAsFloat()) && !Float.isInfinite(f)) {
                            nodeG.weightVal = Math.max(nodeG.paramVal, Math.min(nodeG.extraVal, f));
                        }
                        if (nuunVnvU2.has("saturation")) {
                            f = nuunVnvU2.get("saturation").getAsFloat();
                            if (!Float.isNaN(f) && !Float.isInfinite(f)) {
                                nodeG.holderVal = Math.max(0.0f, Math.min(1.0f, f));
                            }
                        }
                        if (nuunVnvU2.has("brightness") && !Float.isNaN(f = nuunVnvU2.get("brightness").getAsFloat()) && !Float.isInfinite(f)) {
                            nodeG.timerVal = Math.max(0.0f, Math.min(1.0f, f));
                        }
                    } else if (vUVnvvnNN != null) {
                        float f = vUVnvvnNN.getAsFloat();
                        if (!Float.isNaN(f) && !Float.isInfinite(f)) {
                            nodeG.weightVal = Math.max(nodeG.paramVal, Math.min(nodeG.extraVal, f));
                        }
                    }
                } else if (nodeA instanceof SettingGroup) {
                    SettingGroup vUVnvvnNN = (SettingGroup)nodeA;
                    JsonElement currentEl = jsonObject2.get(string);
                    if (currentEl != null && currentEl.isJsonObject()) {
                        JsonObject jsonObject4 = currentEl.getAsJsonObject();
                        for (BoolSetting vvNnnUNnVvn3 : vUVnvvnNN.marginVal) {
                            if (!jsonObject4.has(vvNnnUNnVvn3.primaryVal)) continue;
                            try {
                                vvNnnUNnVvn3.secondaryVal(jsonObject4.get(vvNnnUNnVvn3.primaryVal).getAsBoolean());
                            }
                            catch (Throwable throwable) {}
                        }
                    }
                    JsonElement jsonElement = jsonObject2.get(string + "$binds");
                    if (jsonElement != null && jsonElement.isJsonObject()) {
                        JsonObject bindsObj = jsonElement.getAsJsonObject();
                        for (BoolSetting vvNnnUNnVvn3 : vUVnvvnNN.marginVal) {
                            if (!bindsObj.has(vvNnnUNnVvn3.primaryVal)) continue;
                            try {
                                JsonObject jsonObject3 = bindsObj.getAsJsonObject(vvNnnUNnVvn3.primaryVal);
                                if (jsonObject3.has("key")) {
                                    vvNnnUNnVvn3.paramVal = jsonObject3.get("key").getAsInt();
                                }
                                if (jsonObject3.has("hold")) {
                                    vvNnnUNnVvn3.extraVal = jsonObject3.get("hold").getAsBoolean();
                                }
                            }
                            catch (Throwable throwable) {}
                        }
                    }
                } else if (nodeA instanceof StringListSetting) {
                    StringListSetting nuunVnvU2 = (StringListSetting)nodeA;
                    nuunVnvU2.tertiaryVal();
                    JsonElement jsonElement = jsonObject2.get(string);
                    if (jsonElement != null) {
                        String[] parts = jsonElement.getAsString().split(",");
                        ArrayList<String> arrayList = new ArrayList<String>();
                        for (int i = 0; i < parts.length; ++i) {
                            String string2 = parts[i];
                            if (string2 == null) continue;
                            string2 = string2.trim();
                            if (string2.isEmpty() || nuunVnvU2.marginVal == null) continue;
                            if (!nuunVnvU2.marginVal.contains(string2)) continue;
                            arrayList.add(string2);
                        }
                        nuunVnvU2.extraVal = arrayList;
                    }
                }
            }
            catch (Throwable throwable) {
            }
        }
        return;
    }

    public void setEnabled(boolean bl) {
        this.setEnabledInternal(bl, false);
    }

    public void applyEnabled(boolean bl) {
        this.setEnabled(bl);
    }

    public void resetModule() {
        if (this.enabled) {
            this.setEnabled(false);
        }
        this.keyIndex = -1;
        this.holdActive = false;
        this.expanded = false;
        Iterator<Setting> iterator = this.getAllSettings().iterator();
        while (iterator.hasNext()) {
            Setting nodeA = iterator.next();
            if (nodeA == null) continue;
            if (nodeA.tertiaryVal) continue;
            nodeA.secondaryVal();
        }
    }

    @Override
    public List<Setting> getSettings() {
        List<Setting> list = super.getSettings();
        if (this.hasResettableSettings()) {
            list.add(this.resetButton);
        }
        return list;
    }

    private void resetToDefaults() {
        for (Setting nodeA : this.getAllSettings()) {
            if (!this.isResettable(nodeA)) continue;
            nodeA.secondaryVal();
        }
        if (WildClient.primaryVal != null && WildClient.primaryVal.holderVal != null) {
            WildClient.primaryVal.holderVal.tertiaryVal();
        }
    }

    private boolean hasResettableSettings() {
        for (Setting nodeA : this.getAllSettings()) {
            if (!this.isResettable(nodeA)) continue;
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean isResettable(Setting nodeA) {
        if (nodeA == null) return false;
        if (nodeA == this.resetButton) return false;
        if (nodeA.tertiaryVal) return false;
        if (nodeA instanceof ButtonSetting) return false;
        if (nodeA instanceof VnnUVUVvV) return false;
        return true;
    }

    public Module addBadge(ModuleBadge linkG) {
        if (linkG != null) {
            this.badges.add(linkG);
        }
        return this;
    }

    public Module addBadges(ModuleBadge ... uVUNNUnNvUArray) {
        if (uVUNNUnNvUArray != null) {
            Collections.addAll(this.badges, uVUNNUnNvUArray);
            this.badges.remove(null);
        }
        return this;
    }

    public boolean hasBadge(ModuleBadge linkG) {
        return linkG != null && this.badges.contains((Object)linkG);
    }

    public Set<ModuleBadge> getBadges() {
        return Collections.unmodifiableSet(this.badges);
    }

    private void setEnabledInternal(boolean bl, boolean bl2) {
        if (bl && WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null && !WildClient.primaryVal.secondaryVal.primaryVal(this)) {
            this.enabled = false;
            return;
        }
        if (this.enabled == bl) {
            return;
        }
        this.enabled = bl;
        if (bl) {
            this.onEnable();
        } else {
            this.onDisable();
        }
        if (bl2 && WildClient.primaryVal != null && WildClient.primaryVal.holderVal != null) {
            WildClient.primaryVal.holderVal.tertiaryVal();
        }
    }

    private void warnBadgeUsage() {
        if (this.badgeWarned || Module.mc.field_1724 == null || !this.hasBadge(ModuleBadge.RISKY) && !this.hasBadge(ModuleBadge.PATCHED)) {
            return;
        }
        this.badgeWarned = true;
        String string = this.hasBadge(ModuleBadge.RISKY) && this.hasBadge(ModuleBadge.PATCHED) ? "Risky/Patched" : (this.hasBadge(ModuleBadge.RISKY) ? "Risky" : "Patched");
        NotificationsHud.primaryVal("warn", "Warning: " + this.name + " is currently flagged as " + string + ".", 3500L);
    }

    @Generated
    public RequiresRole getRequiresRole() {
        return this.requiresRole;
    }

    @Generated
    public int getKeyIndex() {
        return this.keyIndex;
    }

    @Generated
    public String getDisplayName() {
        return this.displayName;
    }
}