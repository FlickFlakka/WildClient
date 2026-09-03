/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import ru.metaculture.protection.ShaderCompileResult;
import ru.metaculture.protection.VnnVNVNVUnnn;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.ShaderUniformParam;
import ru.metaculture.protection.NodeGraph;
import ru.metaculture.protection.NodeGraphCompiler;
import ru.metaculture.protection.ThemeShaderProgramCache;

public final class ThemeShaderManager {
    private static final ThemeShaderManager primaryVal = new ThemeShaderManager();
    private final Map<SurfaceTarget, NodeGraph> secondaryVal = new EnumMap<SurfaceTarget, NodeGraph>(SurfaceTarget.class);
    private final Map<SurfaceTarget, ShaderCompileResult> tertiaryVal = new EnumMap<SurfaceTarget, ShaderCompileResult>(SurfaceTarget.class);
    private final Map<SurfaceTarget, String> marginVal = new EnumMap<SurfaceTarget, String>(SurfaceTarget.class);
    private final Map<String, NodeGraph> weightVal = new LinkedHashMap<String, NodeGraph>();
    private final Map<String, ShaderCompileResult> paramVal = new LinkedHashMap<String, ShaderCompileResult>();
    private final Map<String, String> extraVal = new LinkedHashMap<String, String>();
    private final Map<String, cursorVal> limitVal = new LinkedHashMap<String, cursorVal>();
    private final Map<String, WildClient> speedVal = new LinkedHashMap<String, WildClient>();
    private final Map<SurfaceTarget, WildClient> widthVal = new EnumMap<SurfaceTarget, WildClient>(SurfaceTarget.class);
    private final Map<SurfaceTarget, Map<String, float[]>> chunkVal = new EnumMap<SurfaceTarget, Map<String, float[]>>(SurfaceTarget.class);
    private final Map<String, Map<String, float[]>> blockRef = new LinkedHashMap<String, Map<String, float[]>>();
    private final List<Consumer<SurfaceTarget>> holderVal = new CopyOnWriteArrayList<Consumer<SurfaceTarget>>();
    private final List<Consumer<String>> timerVal = new CopyOnWriteArrayList<Consumer<String>>();
    private NodeGraphCompiler anchorVal;

    private ThemeShaderManager() {
    }

    public static ThemeShaderManager primaryVal() {
        return primaryVal;
    }

    public synchronized void primaryVal(NodeGraphCompiler coreE) {
        this.anchorVal = coreE;
    }

    public synchronized void primaryVal(SurfaceTarget vnuVUNUv2, NodeGraph nuVVnvn2, ShaderCompileResult twigE) {
        if (vnuVUNUv2 == null || nuVVnvn2 == null || twigE == null) {
            return;
        }
        this.secondaryVal.put(vnuVUNUv2, nuVVnvn2);
        this.tertiaryVal.put(vnuVUNUv2, twigE);
        this.widthVal.put(vnuVUNUv2, twigE.ok() ? WildClient.SAVED : WildClient.FAILED);
        ThemeShaderManager.primaryVal(this.chunkVal.computeIfAbsent(vnuVUNUv2, vnuVUNUv -> new LinkedHashMap()), twigE);
        try {
            this.marginVal.put(vnuVUNUv2, VnnVNVNVUnnn.primaryVal(nuVVnvn2));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        this.chunkVal(vnuVUNUv2);
    }

    public synchronized void primaryVal(String string, NodeGraph nuVVnvn2, ShaderCompileResult twigE) {
        this.primaryVal(string, nuVVnvn2, twigE, ThemeShaderManager.primaryVal(nuVVnvn2));
    }

    public synchronized void primaryVal(String string2, NodeGraph nuVVnvn2, ShaderCompileResult twigE, cursorVal panelVal) {
        String string3 = ThemeShaderManager.widthVal(string2);
        if (string3.isBlank() || nuVVnvn2 == null || twigE == null) {
            return;
        }
        this.weightVal.put(string3, nuVVnvn2);
        this.paramVal.put(string3, twigE);
        this.limitVal.put(string3, panelVal == null ? cursorVal.USER : panelVal);
        this.speedVal.put(string3, twigE.ok() ? WildClient.SAVED : WildClient.FAILED);
        ThemeShaderManager.primaryVal(this.blockRef.computeIfAbsent(string3, string -> new LinkedHashMap()), twigE);
        try {
            this.extraVal.put(string3, VnnVNVNVUnnn.primaryVal(nuVVnvn2));
        }
        catch (Throwable throwable) {
        }
        this.chunkVal(string3);
    }

    public void primaryVal(Consumer<SurfaceTarget> consumer) {
        if (consumer != null) {
            this.holderVal.add(consumer);
        }
    }

    public void secondaryVal(Consumer<String> consumer) {
        if (consumer != null) {
            this.timerVal.add(consumer);
        }
    }

    private void chunkVal(SurfaceTarget vnuVUNUv) {
        Iterator<Consumer<SurfaceTarget>> iterator = this.holderVal.iterator();
        while (iterator.hasNext()) {
            Consumer<SurfaceTarget> consumer = iterator.next();
            try {
                consumer.accept(vnuVUNUv);
            }
            catch (Throwable throwable) {}
        }
    }

    private void chunkVal(String string) {
        Iterator<Consumer<String>> iterator = this.timerVal.iterator();
        while (iterator.hasNext()) {
            Consumer<String> consumer = iterator.next();
            try {
                consumer.accept(string);
            }
            catch (Throwable throwable) {}
        }
    }

    public synchronized void primaryVal(SurfaceTarget vnuVUNUv) {
        this.secondaryVal.remove((Object)vnuVUNUv);
        this.tertiaryVal.remove((Object)vnuVUNUv);
        this.marginVal.remove((Object)vnuVUNUv);
        this.chunkVal.remove((Object)vnuVUNUv);
        this.widthVal.remove((Object)vnuVUNUv);
        this.chunkVal(vnuVUNUv);
    }

    public synchronized void primaryVal(String string) {
        String string2 = ThemeShaderManager.widthVal(string);
        this.weightVal.remove(string2);
        this.paramVal.remove(string2);
        this.extraVal.remove(string2);
        this.limitVal.remove(string2);
        this.speedVal.remove(string2);
        this.blockRef.remove(string2);
        ThemeShaderProgramCache.primaryVal().tertiaryVal(string2);
        this.chunkVal(string2);
    }

    public synchronized ShaderCompileResult secondaryVal(SurfaceTarget vnuVUNUv) {
        return this.tertiaryVal.get((Object)vnuVUNUv);
    }

    public synchronized ShaderCompileResult secondaryVal(String string) {
        return this.paramVal.get(ThemeShaderManager.widthVal(string));
    }

    public synchronized NodeGraph tertiaryVal(SurfaceTarget vnuVUNUv) {
        return this.secondaryVal.get((Object)vnuVUNUv);
    }

    public synchronized NodeGraph tertiaryVal(String string) {
        return this.weightVal.get(ThemeShaderManager.widthVal(string));
    }

    public synchronized String marginVal(SurfaceTarget vnuVUNUv) {
        return this.marginVal.get((Object)vnuVUNUv);
    }

    public synchronized String marginVal(String string) {
        return this.extraVal.get(ThemeShaderManager.widthVal(string));
    }

    public synchronized boolean weightVal(SurfaceTarget vnuVUNUv) {
        return vnuVUNUv != null && this.tertiaryVal.containsKey((Object)vnuVUNUv);
    }

    public synchronized boolean weightVal(String string) {
        return this.paramVal.containsKey(ThemeShaderManager.widthVal(string));
    }

    public synchronized cursorVal paramVal(String string) {
        return this.limitVal.getOrDefault(ThemeShaderManager.widthVal(string), cursorVal.USER);
    }

    public synchronized WildClient extraVal(String string) {
        return this.speedVal.getOrDefault(ThemeShaderManager.widthVal(string), WildClient.FAILED);
    }

    public synchronized WildClient paramVal(SurfaceTarget vnuVUNUv) {
        return this.widthVal.getOrDefault((Object)vnuVUNUv, WildClient.FAILED);
    }

    public synchronized List<ShaderUniformParam> extraVal(SurfaceTarget vnuVUNUv) {
        ShaderCompileResult twigE = vnuVUNUv == null ? null : this.tertiaryVal.get((Object)vnuVUNUv);
        return twigE == null ? List.of() : twigE.exposedUniforms();
    }

    public synchronized List<ShaderUniformParam> limitVal(String string) {
        ShaderCompileResult twigE = this.paramVal.get(ThemeShaderManager.widthVal(string));
        return twigE == null ? List.of() : twigE.exposedUniforms();
    }

    public synchronized Map<String, float[]> limitVal(SurfaceTarget vnuVUNUv) {
        return ThemeShaderManager.primaryVal(this.chunkVal.get((Object)vnuVUNUv));
    }

    public synchronized Map<String, float[]> speedVal(String string) {
        return ThemeShaderManager.primaryVal(this.blockRef.get(ThemeShaderManager.widthVal(string)));
    }

    public synchronized void primaryVal(SurfaceTarget vnuVUNUv2, String string, float f) {
        if (vnuVUNUv2 == null || !Float.isFinite(f)) {
            return;
        }
        ShaderUniformParam ccCoCoOCocoo2 = ThemeShaderManager.primaryVal(this.extraVal(vnuVUNUv2), string, ShaderUniformParam.WildClient.FLOAT);
        if (ccCoCoOCocoo2 != null) {
            float[] fArray = new float[4];
            fArray[0] = f;
            fArray[1] = 0.0f;
            fArray[2] = 0.0f;
            fArray[3] = 1.0f;
            this.chunkVal.computeIfAbsent(vnuVUNUv2, vnuVUNUv -> new LinkedHashMap()).put(ccCoCoOCocoo2.uniformName(), fArray);
        }
    }

    public synchronized void primaryVal(String string2, String string3, float f) {
        String string4 = ThemeShaderManager.widthVal(string2);
        if (string4.isBlank() || !Float.isFinite(f)) {
            return;
        }
        ShaderUniformParam ccCoCoOCocoo2 = ThemeShaderManager.primaryVal(this.limitVal(string4), string3, ShaderUniformParam.WildClient.FLOAT);
        if (ccCoCoOCocoo2 != null) {
            float[] fArray = new float[4];
            fArray[0] = f;
            fArray[1] = 0.0f;
            fArray[2] = 0.0f;
            fArray[3] = 1.0f;
            this.blockRef.computeIfAbsent(string4, string -> new LinkedHashMap()).put(ccCoCoOCocoo2.uniformName(), fArray);
        }
    }

    public synchronized void primaryVal(SurfaceTarget vnuVUNUv2, String string, int n) {
        if (vnuVUNUv2 == null) {
            return;
        }
        ShaderUniformParam ccCoCoOCocoo2 = ThemeShaderManager.primaryVal(this.extraVal(vnuVUNUv2), string, ShaderUniformParam.WildClient.COLOR);
        if (ccCoCoOCocoo2 != null) {
            this.chunkVal.computeIfAbsent(vnuVUNUv2, vnuVUNUv -> new LinkedHashMap()).put(ccCoCoOCocoo2.uniformName(), ThemeShaderManager.primaryVal(n));
        }
    }

    public synchronized void primaryVal(String string2, String string3, int n) {
        String string4 = ThemeShaderManager.widthVal(string2);
        if (string4.isBlank()) {
            return;
        }
        ShaderUniformParam ccCoCoOCocoo2 = ThemeShaderManager.primaryVal(this.limitVal(string4), string3, ShaderUniformParam.WildClient.COLOR);
        if (ccCoCoOCocoo2 != null) {
            this.blockRef.computeIfAbsent(string4, string -> new LinkedHashMap()).put(ccCoCoOCocoo2.uniformName(), ThemeShaderManager.primaryVal(n));
        }
    }

    public synchronized List<String> secondaryVal() {
        ArrayList<String> arrayList = new ArrayList<String>();
        Iterator<String> iterator = this.paramVal.keySet().iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            if (ThemeShaderManager.blockRef(string)) continue;
            arrayList.add(string);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public synchronized List<String> speedVal(SurfaceTarget vnuVUNUv) {
        SurfaceTarget vnuVUNUv2 = vnuVUNUv == null ? SurfaceTarget.PREVIEW_ONLY : vnuVUNUv;
        ArrayList<String> arrayList = new ArrayList<String>();
        for (String string : this.paramVal.keySet()) {
            NodeGraph nuVVnvn2;
            SurfaceTarget vnuVUNUv3;
            if (ThemeShaderManager.blockRef(string) || (vnuVUNUv3 = SurfaceTarget.primaryVal((nuVVnvn2 = this.weightVal.get(string)) == null ? null : nuVVnvn2.secondaryVal())) != vnuVUNUv2) continue;
            arrayList.add(string);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public synchronized List<String> tertiaryVal() {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("None");
        arrayList.addAll(this.secondaryVal());
        return arrayList;
    }

    public synchronized List<String> widthVal(SurfaceTarget vnuVUNUv) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("None");
        arrayList.addAll(this.speedVal(vnuVUNUv));
        return arrayList;
    }

    private static void primaryVal(Map<String, float[]> map, ShaderCompileResult twigE) {
        if (map == null || twigE == null) {
            return;
        }
        Iterator<ShaderUniformParam> iterator = twigE.exposedUniforms().iterator();
        while (iterator.hasNext()) {
            ShaderUniformParam ccCoCoOCocoo2 = iterator.next();
            map.putIfAbsent(ccCoCoOCocoo2.uniformName(), Arrays.copyOf(ccCoCoOCocoo2.defaults(), ccCoCoOCocoo2.defaults().length));
        }
    }

    private static Map<String, float[]> primaryVal(Map<String, float[]> map) {
        if (map == null || map.isEmpty()) {
            return Map.of();
        }
        HashMap<String, float[]> hashMap = new HashMap<String, float[]>();
        for (Map.Entry<String, float[]> entry : map.entrySet()) {
            float[] fArray;
            if (entry.getValue() == null) {
                float[] fArray2 = new float[4];
                fArray2[0] = 0.0f;
                fArray2[1] = 0.0f;
                fArray2[2] = 0.0f;
                fArray = fArray2;
                fArray2[3] = 1.0f;
            } else {
                fArray = Arrays.copyOf(entry.getValue(), entry.getValue().length);
            }
            hashMap.put(entry.getKey(), fArray);
        }
        return hashMap;
    }

    private static ShaderUniformParam primaryVal(List<ShaderUniformParam> list, String string, ShaderUniformParam.WildClient modeVal) {
        if (list == null || list.isEmpty() || string == null || string.isBlank()) {
            return null;
        }
        String string2 = ThemeShaderManager.widthVal(string);
        for (ShaderUniformParam ccCoCoOCocoo2 : list) {
            if (ccCoCoOCocoo2.kind() != modeVal || !ThemeShaderManager.widthVal(ccCoCoOCocoo2.name()).equals(string2) && !ThemeShaderManager.widthVal(ccCoCoOCocoo2.uniformName()).equals(string2)) continue;
            return ccCoCoOCocoo2;
        }
        return null;
    }

    private static float[] primaryVal(int n) {
        float[] fArray = new float[4];
        fArray[0] = (float)(n >> 16 & 0xFF) / 255.0f;
        fArray[1] = (float)(n >> 8 & 0xFF) / 255.0f;
        fArray[2] = (float)(n & 0xFF) / 255.0f;
        fArray[3] = (float)(n >>> 24 & 0xFF) / 255.0f;
        return fArray;
    }

    public static String widthVal(String string) {
        if (string == null) {
            return "";
        }
        String string2 = string.trim().replaceAll("\\s+", " ");
        return string2.length() > 48 ? string2.substring(0, 48) : string2;
    }

    private static boolean blockRef(String string) {
        return string != null && string.startsWith("__");
    }

    private static cursorVal primaryVal(NodeGraph nuVVnvn2) {
        block7: {
            block6: {
                if (nuVVnvn2 == null) break block6;
                if (nuVVnvn2.primaryVal() != null) break block7;
            }
            return cursorVal.USER;
        }
        String string = nuVVnvn2.primaryVal().paramVal();
        if ("preset".equalsIgnoreCase(string)) {
            return cursorVal.PRESET;
        }
        if ("imported".equalsIgnoreCase(string) || "shared".equalsIgnoreCase(string)) {
            return cursorVal.IMPORTED;
        }
        if ("runtime".equalsIgnoreCase(string)) {
            return cursorVal.RUNTIME;
        }
        return cursorVal.USER;
    }

    public enum WildClient {
    SAVED,
    DIRTY,
    FAILED,
    COMPILING;
}

    public enum cursorVal {
    PRESET,
    USER,
    IMPORTED,
    RUNTIME;
}
}

