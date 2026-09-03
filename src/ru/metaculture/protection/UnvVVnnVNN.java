/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.class_155
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_155;
import net.minecraft.class_310;

public final class UnvVVnnVNN {
    public static final String primaryVal = "viafabricplus";
    public static final String secondaryVal = "https://modrinth.com/mod/viafabricplus";
    private static final String tertiaryVal = "com.viaversion.viaversion.api.protocol.version.ProtocolVersion";
    private static final String[] marginVal = new String[]{"com.viaversion.viafabricplus.protocoltranslator.ProtocolTranslator", "de.florianmichael.viafabricplus.protocoltranslator.ProtocolTranslator"};
    private static final String[] weightVal = new String[]{"com.viaversion.vialoader.util.ProtocolVersionList", "net.raphimc.vialoader.util.ProtocolVersionList"};
    private static final String paramVal = "de.florianmichael.viafabricplus.protocolhack.ProtocolHack";
    private static final String[] extraVal;
    private static volatile boolean limitVal;
    private static boolean speedVal;
    private static boolean widthVal;
    private static Method chunkVal;
    private static Method blockRef;
    private static Method holderVal;
    private static Method timerVal;
    private static Method anchorVal;
    private static Method weightRef;
    private static Method bufferVal;
    private static Method countVal;
    private static Field depthVal;
    private static Field descRef;
    private static List<WildClient> activeVal;
    private static boolean radiusVal;
    private static long factorVal;

    private UnvVVnnVNN() {
    }

    public static boolean primaryVal() {
        UnvVVnnVNN.holderVal();
        return speedVal;
    }

    public static boolean secondaryVal() {
        UnvVVnnVNN.holderVal();
        return widthVal;
    }

    public static String tertiaryVal() {
        try {
            return FabricLoader.getInstance().getModContainer(primaryVal).map(modContainer -> modContainer.getMetadata().getVersion().getFriendlyString()).orElse(null);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    public static String marginVal() {
        try {
            return class_155.method_16673().comp_4025();
        }
        catch (Throwable throwable) {
            return "1.21.8";
        }
    }

    public static List<WildClient> weightVal() {
        long l;
        block5: {
            block6: {
                if (!UnvVVnnVNN.primaryVal()) {
                    return List.of();
                }
                l = System.nanoTime();
                if (activeVal.isEmpty()) break block5;
                if (radiusVal) break block6;
                if (l - factorVal >= 1000000000L) break block5;
            }
            return activeVal;
        }
        factorVal = l;
        List<WildClient> list = UnvVVnnVNN.chunkVal();
        if (!list.isEmpty()) {
            activeVal = list;
            radiusVal = UnvVVnnVNN.widthVal();
        }
        return activeVal;
    }

    public static List<WildClient> primaryVal(List<WildClient> list, WildClient modeVal, int n) {
        ArrayList<WildClient> arrayList = new ArrayList<WildClient>(n);
        Iterator<WildClient> object2 = list.iterator();
        while (object2.hasNext()) {
            WildClient object = object2.next();
            if (!object.autoDetect()) continue;
            arrayList.add(object);
            break;
        }
        WildClient object4 = UnvVVnnVNN.primaryVal(list, UnvVVnnVNN.marginVal());
        if (object4 != null && !arrayList.contains(object4)) {
            arrayList.add(object4);
        }
        if (modeVal != null) {
            if (!arrayList.contains(modeVal)) {
                arrayList.add(modeVal);
            }
        }
        String[] stringArray2 = extraVal;
        int n2 = stringArray2.length;
        for (int i = 0; i < n2; ++i) {
            String object3 = stringArray2[i];
            if (arrayList.size() >= n) break;
            WildClient nodeC = UnvVVnnVNN.primaryVal(list, object3);
            if (nodeC == null || arrayList.contains(nodeC)) continue;
            arrayList.add(nodeC);
        }
        for (WildClient partE : list) {
            if (arrayList.size() >= n) break;
            if (arrayList.contains(partE)) continue;
            if (!"RELEASE".equals(partE.group())) continue;
            arrayList.add(partE);
        }
        return List.copyOf(arrayList);
    }

    private static WildClient primaryVal(List<WildClient> list, String string) {
        for (WildClient modeVal : list) {
            if (!modeVal.label().equals(string)) continue;
            return modeVal;
        }
        return null;
    }

    public static WildClient paramVal() {
        if (!UnvVVnnVNN.primaryVal()) {
            return null;
        }
        Object object = UnvVVnnVNN.speedVal();
        if (object == null) {
            return null;
        }
        Iterator<WildClient> iterator = UnvVVnnVNN.weightVal().iterator();
        while (iterator.hasNext()) {
            WildClient modeVal = iterator.next();
            if (!Objects.equals(modeVal.handle(), object)) continue;
            return modeVal;
        }
        return UnvVVnnVNN.primaryVal(object);
    }

    public static String extraVal() {
        WildClient modeVal = UnvVVnnVNN.paramVal();
        return modeVal == null ? UnvVVnnVNN.marginVal() : modeVal.label();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean limitVal() {
        if (!UnvVVnnVNN.primaryVal()) {
            return false;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null) return false;
        if (class_3102.method_1562() != null) return false;
        if (class_3102.field_1687 != null) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(WildClient modeVal) {
        block4: {
            if (modeVal == null || modeVal.handle() == null || !UnvVVnnVNN.limitVal()) {
                return false;
            }
            try {
                if (holderVal == null) break block4;
                Object[] objectArray = new Object[2];
                objectArray[0] = modeVal.handle();
                objectArray[1] = Boolean.TRUE;
                holderVal.invoke(null, objectArray);
                return true;
            }
            catch (Throwable throwable) {
                return false;
            }
        }
        if (blockRef == null) return false;
        Object[] objectArray = new Object[1];
        objectArray[0] = modeVal.handle();
        try {
            blockRef.invoke(null, objectArray);
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    private static Object speedVal() {
        if (chunkVal != null) {
            try {
                Object object = chunkVal.invoke(null, new Object[0]);
                if (object != null) {
                    return object;
                }
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (depthVal != null) {
            try {
                return depthVal.get(null);
            }
            catch (Throwable throwable) {
            }
        }
        return null;
    }

    private static boolean widthVal() {
        if (descRef == null || timerVal == null) {
            return true;
        }
        try {
            Object object = descRef.get(null);
            for (Object e : (List)timerVal.invoke(null, new Object[0])) {
                if (e != object) continue;
                return true;
            }
            return false;
        }
        catch (Throwable throwable) {
            return true;
        }
    }

    private static List<WildClient> chunkVal() {
        List<Object> list = UnvVVnnVNN.blockRef();
        if (list.isEmpty()) {
            return List.of();
        }
        ArrayList<WildClient> arrayList = new ArrayList<WildClient>(list.size());
        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            WildClient modeVal = UnvVVnnVNN.primaryVal(object);
            if (modeVal == null) continue;
            arrayList.add(modeVal);
        }
        return List.copyOf(arrayList);
    }

    private static List<Object> blockRef() {
        if (timerVal != null) {
            try {
                ArrayList<Object> arrayList = new ArrayList<Object>((List)timerVal.invoke(null, new Object[0]));
                Collections.reverse(arrayList);
                return arrayList;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (anchorVal != null) {
            try {
                return new ArrayList<Object>((List)anchorVal.invoke(null, new Object[0]));
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        return List.of();
    }

    private static WildClient primaryVal(Object object) {
        String string;
        if (object == null || weightRef == null) {
            return null;
        }
        try {
            string = (String)weightRef.invoke(object, new Object[0]);
        }
        catch (Throwable throwable) {
            return null;
        }
        if (string == null || string.isEmpty()) {
            return null;
        }
        int n = Integer.MIN_VALUE;
        if (bufferVal != null) {
            try {
                n = (Integer)bufferVal.invoke(object, new Object[0]);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        String string2 = "OTHER";
        if (countVal != null) {
            try {
                String string3;
                Object object2 = countVal.invoke(object, new Object[0]);
                if (object2 instanceof Enum) {
                    Enum enum_ = (Enum)object2;
                    string3 = enum_.name();
                } else {
                    string3 = "OTHER";
                }
                string2 = string3;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        boolean bl = false;
        if (descRef != null) {
            try {
                bl = descRef.get(null) == object;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        return new WildClient(object, string, n, string2, bl);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void holderVal() {
        if (limitVal) {
            return;
        }
        Class<UnvVVnnVNN> clazz = UnvVVnnVNN.class;
        synchronized (UnvVVnnVNN.class) {
            block7: {
                if (!limitVal) break block7;
                // ** MonitorExit[var0] (shouldn't be in output)
                return;
            }
            try {
                UnvVVnnVNN.timerVal();
            }
            catch (Throwable throwable) {
                speedVal = false;
            }
            limitVal = true;
            // ** MonitorExit[var0] (shouldn't be in output)
            return;
        }
    }

    private static void timerVal() {
        Class<?> clazz;
        boolean bl = false;
        try {
            bl = FabricLoader.getInstance().isModLoaded(primaryVal);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        Class<?> clazz2 = UnvVVnnVNN.primaryVal(tertiaryVal);
        if (clazz2 == null) {
            widthVal = bl && UnvVVnnVNN.primaryVal(paramVal) != null;
            speedVal = false;
            return;
        }
        weightRef = UnvVVnnVNN.primaryVal(clazz2, "getName", new Class[0]);
        bufferVal = UnvVVnnVNN.primaryVal(clazz2, "getVersion", new Class[0]);
        countVal = UnvVVnnVNN.primaryVal(clazz2, "getVersionType", new Class[0]);
        timerVal = UnvVVnnVNN.primaryVal(clazz2, "getProtocols", new Class[0]);
        for (String string : weightVal) {
            clazz = UnvVVnnVNN.primaryVal(string);
            if (clazz == null) continue;
            anchorVal = UnvVVnnVNN.primaryVal(clazz, "getProtocolsNewToOld", new Class[0]);
            if (anchorVal == null) continue;
            break;
        }
        for (String string : marginVal) {
            clazz = UnvVVnnVNN.primaryVal(string);
            if (clazz == null) continue;
            chunkVal = UnvVVnnVNN.primaryVal(clazz, "getTargetVersion", new Class[0]);
            Class[] classArray = new Class[1];
            classArray[0] = clazz2;
            blockRef = UnvVVnnVNN.primaryVal(clazz, "setTargetVersion", classArray);
            holderVal = UnvVVnnVNN.primaryVal(clazz, "setTargetVersion", clazz2, Boolean.TYPE);
            depthVal = UnvVVnnVNN.primaryVal(clazz, "NATIVE_VERSION");
            descRef = UnvVVnnVNN.primaryVal(clazz, "AUTO_DETECT_PROTOCOL");
            if (chunkVal == null || blockRef == null) continue;
            if (weightRef == null) continue;
            speedVal = true;
            return;
        }
        widthVal = bl && UnvVVnnVNN.primaryVal(paramVal) != null;
        speedVal = false;
    }

    private static Class<?> primaryVal(String string) {
        try {
            return Class.forName(string, false, UnvVVnnVNN.class.getClassLoader());
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Method primaryVal(Class<?> clazz, String string, Class<?> ... classArray) {
        try {
            Method method = clazz.getMethod(string, classArray);
            method.setAccessible(true);
            return method;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Field primaryVal(Class<?> clazz, String string) {
        try {
            Field field = clazz.getField(string);
            field.setAccessible(true);
            return field;
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    static {
        String[] stringArray = new String[10];
        stringArray[0] = "1.21.5";
        stringArray[1] = "1.21.4";
        stringArray[2] = "1.21.2";
        stringArray[3] = "1.20.6";
        stringArray[4] = "1.20.1";
        stringArray[5] = "1.19.4";
        stringArray[6] = "1.18.2";
        stringArray[7] = "1.16.5";
        stringArray[8] = "1.12.2";
        stringArray[9] = "1.8.x";
        extraVal = stringArray;
        activeVal = List.of();
    }

    public record WildClient(Object handle, String label, int protocol, String group, boolean autoDetect) {
    }
}

