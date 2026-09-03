/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 */
package ru.metaculture.protection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import org.wild.module.api.Module;
import ru.metaculture.protection.HsbaColor;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.StringListSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.BoolSetting;
import ru.metaculture.protection.KeybindMode;

public final class KeybindTargetModel {
    private static final double primaryVal = 1.0E-6;
    private final WildClient secondaryVal;
    private final Module tertiaryVal;
    private final Setting marginVal;
    private final String weightVal;
    private final String paramVal;
    private final Object extraVal;
    private final String limitVal;
    private Object speedVal;
    private Object widthVal;
    private int chunkVal;
    private KeybindMode blockRef;
    private int holderVal;
    private KeybindMode timerVal;
    private boolean anchorVal;
    private boolean weightRef;

    private KeybindTargetModel(WildClient modeVal, Module module, Setting nodeA, String string, String string2, Object object, String string3, Object object2, Object object3, int n, KeybindMode vvVUVuVvnnVN2) {
        this.secondaryVal = Objects.requireNonNull(modeVal, "targetType");
        this.tertiaryVal = module;
        this.marginVal = nodeA;
        this.weightVal = string == null ? "" : string;
        this.paramVal = string2 == null ? "" : string2;
        this.extraVal = object;
        this.limitVal = string3 == null ? "" : string3;
        this.speedVal = object2;
        this.widthVal = object3;
        this.chunkVal = n;
        this.blockRef = Objects.requireNonNull(vvVUVuVvnnVN2, "mode");
        this.holderVal = n;
        this.timerVal = vvVUVuVvnnVN2;
        this.weightRef = this.anchorVal = n == -1;
    }

    public static KeybindTargetModel primaryVal(Module module) {
        Objects.requireNonNull(module, "module");
        int n = module.keyIndex > 0 ? module.keyIndex : -1;
        return new KeybindTargetModel(WildClient.MODULE, module, null, module.name, module.description, module.enabled, "Modules toggle state is controlled by the mode.", null, null, n, KeybindMode.TOGGLE);
    }

    public static KeybindTargetModel primaryVal(Module module, Setting nodeA, Object object, Object object2, int n, KeybindMode vvVUVuVvnnVN2) {
        Objects.requireNonNull(module, "module");
        Objects.requireNonNull(nodeA, "setting");
        Object object3 = object;
        Object object4 = object2;
        return new KeybindTargetModel(WildClient.SETTING, module, nodeA, nodeA.primaryVal, module.name, object3, "", object4, object4, n, vvVUVuVvnnVN2);
    }

    public WildClient primaryVal() {
        return this.secondaryVal;
    }

    public Module secondaryVal() {
        return this.tertiaryVal;
    }

    public Setting tertiaryVal() {
        return this.marginVal;
    }

    public String marginVal() {
        return this.weightVal;
    }

    public String weightVal() {
        return this.paramVal;
    }

    public Object paramVal() {
        return this.extraVal;
    }

    public String extraVal() {
        return this.limitVal;
    }

    public Object limitVal() {
        if (!this.blockRef()) {
            return null;
        }
        return this.speedVal;
    }

    public void primaryVal(Object object) {
        this.phaseVal();
        this.speedVal = this.tertiaryVal(object);
        this.anchorVal = false;
    }

    public int speedVal() {
        return this.chunkVal;
    }

    public void primaryVal(int n) {
        if (n != -1 && (n < 32 || n > 348)) {
            throw new IllegalArgumentException("keyCode must be GLFW.GLFW_KEY_UNKNOWN or a valid GLFW key constant");
        }
        this.chunkVal = n;
        if (n != -1) {
            this.anchorVal = false;
        }
    }

    public KeybindMode widthVal() {
        return this.blockRef;
    }

    public void primaryVal(KeybindMode vvVUVuVvnnVN2) {
        this.blockRef = Objects.requireNonNull(vvVUVuVvnnVN2, "mode");
    }

    public boolean chunkVal() {
        return this.secondaryVal == WildClient.MODULE;
    }

    public boolean blockRef() {
        return this.secondaryVal == WildClient.SETTING;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean holderVal() {
        if (this.secondaryVal != WildClient.SETTING) return false;
        if (this.marginVal == null) {
            return false;
        }
        if (this.marginVal instanceof FloatSetting) return true;
        if (this.marginVal instanceof ModeSetting) return true;
        if (!(this.marginVal instanceof StringListSetting)) return false;
        return true;
    }

    public boolean timerVal() {
        return !this.limitVal.isBlank();
    }

    public boolean anchorVal() {
        return this.chunkVal != this.holderVal || this.blockRef != this.timerVal || this.anchorVal != this.weightRef || this.weightRef();
    }

    public boolean weightRef() {
        block3: {
            block2: {
                if (!this.blockRef()) break block2;
                if (this.marginVal != null) break block3;
            }
            return false;
        }
        return !KeybindTargetModel.primaryVal(this.marginVal, this.speedVal, this.widthVal);
    }

    public void bufferVal() {
        this.phaseVal();
        this.anchorVal = this.weightRef;
    }

    public void countVal() {
        this.depthVal();
    }

    public void depthVal() {
        this.holderVal = this.chunkVal;
        this.timerVal = this.blockRef;
        this.weightRef = this.anchorVal;
        if (this.blockRef() && this.marginVal != null) {
            this.widthVal = KeybindTargetModel.secondaryVal(this.marginVal, this.speedVal);
        }
    }

    public void descRef() {
        this.chunkVal = this.holderVal;
        this.blockRef = this.timerVal;
        this.anchorVal = this.weightRef;
        if (this.blockRef()) {
        }
    }

    public void activeVal() {
        this.chunkVal = -1;
        this.anchorVal = true;
        if (this.blockRef()) {
        }
    }

    public boolean radiusVal() {
        return this.anchorVal;
    }

    public Object factorVal() {
        this.phaseVal();
        return KeybindTargetModel.secondaryVal(this.marginVal, this.speedVal);
    }

    public void secondaryVal(Object object) {
        this.phaseVal();
        this.speedVal = this.tertiaryVal(Objects.requireNonNull(object, "value"));
        this.anchorVal = false;
    }

    public String sourceVal() {
        if (this.tertiaryVal != null) {
            return this.tertiaryVal.name;
        }
        return "";
    }

    public String extraRef() {
        if (this.marginVal != null) {
            return this.marginVal.primaryVal;
        }
        return "";
    }

    private void phaseVal() {
        if (!this.blockRef()) {
            throw new IllegalStateException("Operation only supported for setting targets");
        }
        if (this.marginVal == null) {
            throw new IllegalStateException("Setting context is not available");
        }
    }

    private Object tertiaryVal(Object object) {
        Objects.requireNonNull(object, "value");
        if (this.marginVal instanceof BoolSetting) {
            if (object instanceof Boolean) {
                Boolean bl = (Boolean)object;
                return (boolean)bl;
            }
            if (object instanceof Number) {
                Number number = (Number)object;
                return number.doubleValue() != 0.0;
            }
            throw new IllegalArgumentException("Target value must be boolean-compatible");
        }
        if (this.marginVal instanceof FloatSetting) {
            return this.marginVal(object);
        }
        if (this.marginVal instanceof ModeSetting) {
            return this.weightVal(object);
        }
        if (this.marginVal instanceof StringListSetting) {
            return this.paramVal(object);
        }
        if (this.marginVal instanceof ColorSetting) {
            return this.extraVal(object);
        }
        if (object instanceof String) {
            return object;
        }
        return object.toString();
    }

    private Object marginVal(Object object) {
        Object object2 = this.marginVal;
        if (!(object2 instanceof FloatSetting)) {
            throw new IllegalStateException("Setting is not a SliderSetting");
        }
        FloatSetting itemA = (FloatSetting)object2;
        if (!(object instanceof Number)) {
            throw new IllegalArgumentException("Target value must be numeric");
        }
        object2 = (Number)object;
        double d = ((Number)object2).doubleValue();
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException("Target value must be a finite number");
        }
        double d2 = Math.min(Math.max(d, (double)itemA.weightVal), (double)itemA.paramVal);
        double d3 = Math.round((d2 - (double)itemA.weightVal) / (double)itemA.extraVal);
        double d4 = (double)itemA.weightVal + d3 * (double)itemA.extraVal;
        if (d4 < (double)itemA.weightVal) {
            d4 = itemA.weightVal;
        } else if (d4 > (double)itemA.paramVal) {
            d4 = itemA.paramVal;
        }
        return d4;
    }

    private Object weightVal(Object object) {
        Object object2;
        block5: {
            block4: {
                object2 = this.marginVal;
                if (!(object2 instanceof ModeSetting)) {
                    throw new IllegalStateException("Setting is not a ModeSetting");
                }
                ModeSetting twigG = (ModeSetting)object2;
                object2 = object.toString();
                if (twigG.marginVal == null) break block4;
                if (twigG.marginVal.contains(object2)) break block5;
            }
            throw new IllegalArgumentException("Unsupported option '" + (String)object2 + "'");
        }
        return object2;
    }

    private Object paramVal(Object object) {
        Object object2 = this.marginVal;
        if (!(object2 instanceof StringListSetting)) {
            throw new IllegalStateException("Setting is not a ListSetting");
        }
        StringListSetting nuunVnvU2 = (StringListSetting)object2;
        nuunVnvU2.tertiaryVal();
        if (!(object instanceof Collection)) {
            throw new IllegalArgumentException("Target value must be a collection");
        }
        Collection<?> collection = (Collection)object;
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object e = iterator.next();
            if (e == null) continue;
            String string = e.toString();
            if (nuunVnvU2.marginVal == null || !nuunVnvU2.marginVal.contains(string)) {
                throw new IllegalArgumentException("Unsupported option '" + string + "'");
            }
            linkedHashSet.add(string);
        }
        return linkedHashSet;
    }

    private Object extraVal(Object object) {
        Object object2 = this.marginVal;
        if (!(object2 instanceof ColorSetting)) {
            throw new IllegalStateException("Setting is not a HueSetting");
        }
        ColorSetting nodeG = (ColorSetting)object2;
        if (object instanceof HsbaColor) {
            object2 = (HsbaColor)object;
            return object2;
        }
        if (object instanceof Number) {
            object2 = (Number)object;
            return HsbaColor.primaryVal(((Number)object2).intValue());
        }
        if (object instanceof String) {
            object2 = (String)object;
            try {
                Object object3 = ((String)object2).startsWith("#") ? ((String)object2).substring(1) : object2;
                int n = (int)Long.parseUnsignedLong((String)object3, 16);
                int n2 = ((String)object3).length() > 6 ? n : 0xFF000000 | n;
                return HsbaColor.primaryVal(n2);
            }
            catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException("Invalid colour string: " + (String)object2, numberFormatException);
            }
        }
        return HsbaColor.primaryVal(nodeG.weightVal(), nodeG.holderVal, nodeG.timerVal, nodeG.anchorVal);
    }

    private static Object primaryVal(Setting nodeA, Object object) {
        if (nodeA instanceof BoolSetting) {
            return KeybindTargetModel.primaryVal((JsonElement)null, object, nodeA);
        }
        if (nodeA instanceof FloatSetting) {
            return KeybindTargetModel.primaryVal((JsonElement)null, nodeA, object);
        }
        if (nodeA instanceof ModeSetting) {
            return KeybindTargetModel.secondaryVal(null, nodeA, object);
        }
        if (nodeA instanceof StringListSetting) {
            return KeybindTargetModel.marginVal(null, nodeA, object);
        }
        if (nodeA instanceof ColorSetting) {
            return KeybindTargetModel.weightVal(null, nodeA, object);
        }
        return object;
    }

    private static Object primaryVal(JsonElement jsonElement, Object object, Setting nodeA) {
        boolean bl;
        if (object instanceof Boolean) {
            Boolean bl2 = (Boolean)object;
            bl = bl2;
        } else {
            bl = Boolean.FALSE;
        }
        boolean bl3 = bl;
        if (jsonElement != null && jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isBoolean()) {
            bl3 = jsonElement.getAsBoolean();
        }
        return bl3;
    }

    private static Object primaryVal(JsonElement jsonElement, Setting nodeA, Object object) {
        double d;
        if (!(nodeA instanceof FloatSetting)) {
            throw new IllegalStateException("Setting is not a SliderSetting");
        }
        FloatSetting itemA = (FloatSetting)nodeA;
        if (object instanceof Number) {
            Number number = (Number)object;
            d = number.doubleValue();
        } else {
            d = (double)itemA.marginVal;
        }
        if (jsonElement != null && jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
            d = jsonElement.getAsDouble();
        }
        double d2 = Math.min(Math.max(d, (double)itemA.weightVal), (double)itemA.paramVal);
        double d3 = Math.round((d2 - (double)itemA.weightVal) / (double)itemA.extraVal);
        double d4 = (double)itemA.weightVal + d3 * (double)itemA.extraVal;
        if (d4 < (double)itemA.weightVal) {
            d4 = itemA.weightVal;
        } else if (d4 > (double)itemA.paramVal) {
            d4 = itemA.paramVal;
        }
        return d4;
    }

    private static Object secondaryVal(JsonElement jsonElement, Setting nodeA, Object object) {
        String string;
        if (!(nodeA instanceof ModeSetting)) {
            throw new IllegalStateException("Setting is not a ModeSetting");
        }
        ModeSetting twigG = (ModeSetting)nodeA;
        string = object instanceof String ? (String)object : (twigG.weightVal != null ? twigG.weightVal : "");
        if (jsonElement != null && jsonElement.isJsonPrimitive()) {
            string = jsonElement.getAsString();
        }
        if (twigG.marginVal != null) {
            if (!twigG.marginVal.contains(string)) {
            }
        } else {
            string = twigG.weightVal != null ? twigG.weightVal : "";
        }
        return string;
    }

    private static Object tertiaryVal(JsonElement jsonElement, Setting nodeA, Object object) {
        String string;
        string = object instanceof String ? (String)object : "";
        if (jsonElement != null && jsonElement.isJsonPrimitive()) {
            string = jsonElement.getAsString();
        }
        return string;
    }

    private static Object marginVal(JsonElement jsonElement, Setting nodeA, Object object) {
        if (!(nodeA instanceof StringListSetting)) {
            throw new IllegalStateException("Setting is not a ListSetting");
        }
        StringListSetting nuunVnvU2 = (StringListSetting)nodeA;
        nuunVnvU2.tertiaryVal();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        if (jsonElement != null && jsonElement.isJsonArray()) {
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            Iterator iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JsonElement jsonElement2 = (JsonElement)iterator.next();
                if (!jsonElement2.isJsonPrimitive()) continue;
                String string = jsonElement2.getAsString();
                if (nuunVnvU2.marginVal == null || !nuunVnvU2.marginVal.contains(string)) continue;
                linkedHashSet.add(string);
            }
        }
        return linkedHashSet;
    }

    private static Object weightVal(JsonElement jsonElement, Setting nodeA, Object object) {
        HsbaColor nUvuNUvvUvvN;
        if (!(nodeA instanceof ColorSetting)) {
            throw new IllegalStateException("Setting is not a HueSetting");
        }
        ColorSetting nodeG = (ColorSetting)nodeA;
        if (object instanceof HsbaColor) {
            HsbaColor nUvuNUvvUvvN2;
            nUvuNUvvUvvN = nUvuNUvvUvvN2 = (HsbaColor)object;
        } else if (object instanceof Number) {
            Number number = (Number)object;
            nUvuNUvvUvvN = HsbaColor.primaryVal(number.intValue());
        } else if (object instanceof String) {
            String string = (String)object;
            try {
                String string2 = string.startsWith("#") ? string.substring(1) : string;
                int n = (int)Long.parseUnsignedLong(string2, 16);
                int n2 = string2.length() > 6 ? n : 0xFF000000 | n;
                nUvuNUvvUvvN = HsbaColor.primaryVal(n2);
            }
            catch (NumberFormatException numberFormatException) {
                nUvuNUvvUvvN = HsbaColor.primaryVal(nodeG.weightVal(), nodeG.holderVal, nodeG.timerVal, nodeG.anchorVal);
            }
        } else {
            nUvuNUvvUvvN = HsbaColor.primaryVal(nodeG.weightVal(), nodeG.holderVal, nodeG.timerVal, nodeG.anchorVal);
        }
        return nUvuNUvvUvvN;
    }

    private static Collection<?> limitVal(Object object) {
        if (object instanceof Collection) {
            Collection collection = (Collection)object;
            return collection;
        }
        return List.of();
    }

    private static Object secondaryVal(Setting nodeA, Object object) {
        if (nodeA == null || object == null) {
            return object;
        }
        if (nodeA instanceof BoolSetting) {
            return Boolean.TRUE.equals(object);
        }
        if (nodeA instanceof FloatSetting) {
            return ((Number)object).doubleValue();
        }
        if (nodeA instanceof ModeSetting || nodeA instanceof StringFilterSetting) {
            return object.toString();
        }
        if (nodeA instanceof StringListSetting) {
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
            if (object instanceof Collection) {
                Collection collection = (Collection)object;
                for (Object e : collection) {
                    if (e == null) continue;
                    linkedHashSet.add(e.toString());
                }
            }
            return linkedHashSet;
        }
        if (nodeA instanceof ColorSetting) {
            return KeybindTargetModel.speedVal(object);
        }
        return object;
    }

    private static boolean primaryVal(Setting nodeA, Object object, Object object2) {
        block15: {
            Collection collection;
            block17: {
                block16: {
                    if (object == object2) {
                        return true;
                    }
                    if (object == null || object2 == null) {
                        return false;
                    }
                    if (nodeA instanceof BoolSetting || nodeA instanceof ModeSetting || nodeA instanceof StringFilterSetting) {
                        return Objects.equals(object, object2);
                    }
                    if (nodeA instanceof FloatSetting) {
                        return Math.abs(((Number)object).doubleValue() - ((Number)object2).doubleValue()) <= 1.0E-6;
                    }
                    if (!(nodeA instanceof StringListSetting)) break block15;
                    if (!(object instanceof Collection)) break block16;
                    collection = (Collection)object;
                    if (object2 instanceof Collection) break block17;
                }
                return false;
            }
            Collection collection2 = (Collection)object2;
            if (collection.size() != collection2.size()) {
                return false;
            }
            return new LinkedHashSet<String>(KeybindTargetModel.primaryVal(collection)).equals(new LinkedHashSet<String>(KeybindTargetModel.primaryVal(collection2)));
        }
        if (nodeA instanceof ColorSetting) {
            Object object3;
            if (object instanceof HsbaColor) {
                object3 = (HsbaColor)object;
                if (object2 instanceof HsbaColor) {
                    HsbaColor nUvuNUvvUvvN = (HsbaColor)object2;
                    return ((HsbaColor)object3).equals(nUvuNUvvUvvN);
                }
            }
            if (object instanceof Number) {
                object3 = (Number)object;
                if (object2 instanceof Number) {
                    Number number = (Number)object2;
                    return ((Number)object3).intValue() == number.intValue();
                }
            }
            if (object instanceof String) {
                object3 = (String)object;
                if (object2 instanceof String) {
                    String string = (String)object2;
                    return ((String)object3).equalsIgnoreCase(string);
                }
            }
            return false;
        }
        return Objects.equals(object, object2);
    }

    private static List<String> primaryVal(Collection<?> collection) {
        ArrayList<String> arrayList = new ArrayList<String>(collection.size());
        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj == null) continue;
            arrayList.add(obj.toString());
        }
        return arrayList;
    }

    private static HsbaColor speedVal(Object object) {
        if (object instanceof HsbaColor) {
            HsbaColor nUvuNUvvUvvN = (HsbaColor)object;
            return HsbaColor.primaryVal(nUvuNUvvUvvN.primaryVal(), nUvuNUvvUvvN.secondaryVal(), nUvuNUvvUvvN.tertiaryVal(), nUvuNUvvUvvN.marginVal());
        }
        if (object instanceof Number) {
            Number number = (Number)object;
            return HsbaColor.primaryVal(number.intValue());
        }
        if (object instanceof String) {
            String string = (String)object;
            try {
                String string2 = string.startsWith("#") ? string.substring(1) : string;
                int n = (int)Long.parseUnsignedLong(string2, 16);
                int n2 = string2.length() > 6 ? n : 0xFF000000 | n;
                return HsbaColor.primaryVal(n2);
            }
            catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException("Invalid colour string: " + string, numberFormatException);
            }
        }
        throw new IllegalArgumentException("Unsupported colour value type: " + object.getClass().getName());
    }

    public enum WildClient {
    MODULE,
    SETTING;
}
}

