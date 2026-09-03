/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Supplier;
import ru.metaculture.protection.ShaderPresetMeta;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.FoundryStorage;
import ru.metaculture.protection.StringListSetting;
import ru.metaculture.protection.ThemeShaderManager;

public class ShaderPresetSetting
extends StringListSetting {
    public static final String speedVal = "None";
    private static final List<ShaderPresetSetting> chunkVal = new CopyOnWriteArrayList<ShaderPresetSetting>();
    public final SurfaceTarget widthVal;
    private final Supplier<List<String>> blockRef;

    public ShaderPresetSetting(String string, SurfaceTarget vnuVUNUv) {
        this(string, vnuVUNUv, () -> ThemeShaderManager.primaryVal().widthVal(vnuVUNUv));
    }

    public ShaderPresetSetting(String string, SurfaceTarget vnuVUNUv, Supplier<List<String>> supplier) {
        super(string, speedVal);
        this.widthVal = vnuVUNUv;
        this.blockRef = supplier;
        this.extraVal = new ArrayList();
        this.extraVal.add(speedVal);
        this.tertiaryVal();
        this.marginVal();
        chunkVal.add(this);
    }

    public static void primaryVal(SurfaceTarget vnuVUNUv, String string) {
        if (vnuVUNUv == null || string == null || string.isBlank()) {
            return;
        }
        Iterator<ShaderPresetSetting> iterator = chunkVal.iterator();
        while (iterator.hasNext()) {
            ShaderPresetSetting ili11Iii1Ii2 = iterator.next();
            if (ili11Iii1Ii2.widthVal != vnuVUNUv) continue;
            ili11Iii1Ii2.tertiaryVal(string);
        }
    }

    public static void primaryVal(SurfaceTarget vnuVUNUv) {
        if (vnuVUNUv == null) {
            return;
        }
        for (ShaderPresetSetting ili11Iii1Ii2 : chunkVal) {
            if (ili11Iii1Ii2.widthVal != vnuVUNUv) continue;
            ili11Iii1Ii2.tertiaryVal(speedVal);
        }
    }

    public ShaderPresetSetting tertiaryVal(Supplier<Boolean> supplier) {
        this.secondaryVal = supplier;
        return this;
    }

    @Override
    public List<String> tertiaryVal() {
        List<String> list;
        try {
            list = this.blockRef == null ? Collections.emptyList() : this.blockRef.get();
        }
        catch (Throwable throwable) {
            list = Collections.emptyList();
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(speedVal);
        if (list != null) {
            for (String string3 : list) {
                if (string3 == null || string3.isBlank()) continue;
                if (ShaderPresetSetting.primaryVal(arrayList, string3)) continue;
                arrayList.add(string3.trim());
            }
        }
        if (arrayList.size() > 2) {
            arrayList.subList(1, arrayList.size()).sort((string, string2) -> {
                int n = ShaderPresetSetting.paramVal(string);
                int n2 = ShaderPresetSetting.paramVal(string2);
                if (n != n2) {
                    return Integer.compare(n, n2);
                }
                return string.compareToIgnoreCase((String)string2);
            });
        }
        this.marginVal = arrayList;
        if (this.extraVal == null) {
            this.extraVal = new ArrayList();
        }
        if (this.extraVal.isEmpty()) {
            this.extraVal.add(speedVal);
        } else {
            String string4 = (String)this.extraVal.get(this.extraVal.size() - 1);
            this.extraVal.clear();
            this.extraVal.add(ShaderPresetSetting.marginVal(string4));
        }
        return this.marginVal;
    }

    public String extraVal() {
        this.tertiaryVal();
        return this.extraVal.isEmpty() ? speedVal : (String)this.extraVal.get(this.extraVal.size() - 1);
    }

    public String limitVal() {
        String string = this.extraVal();
        return ShaderPresetSetting.weightVal(string) ? speedVal : string;
    }

    public void tertiaryVal(String string) {
        if (this.extraVal == null) {
            this.extraVal = new ArrayList();
        }
        this.extraVal.clear();
        this.extraVal.add(ShaderPresetSetting.marginVal(string));
        this.tertiaryVal();
    }

    public void primaryVal(int n) {
        this.tertiaryVal();
        if (n >= 0 && n < this.marginVal.size()) {
            this.tertiaryVal((String)this.marginVal.get(n));
        }
    }

    public int speedVal() {
        String string = this.extraVal();
        for (int i = 0; i < this.marginVal.size(); ++i) {
            if (!((String)this.marginVal.get(i)).equalsIgnoreCase(string)) continue;
            return i;
        }
        return -1;
    }

    public boolean widthVal() {
        String string = this.extraVal();
        return !ShaderPresetSetting.weightVal(string) && !ShaderPresetSetting.primaryVal(this.marginVal, string);
    }

    public String blockRef() {
        return this.timerVal();
    }

    public boolean holderVal() {
        return ShaderPresetSetting.weightVal(this.extraVal());
    }

    public String timerVal() {
        String string = this.extraVal();
        if (ShaderPresetSetting.weightVal(string)) {
            return "";
        }
        return ThemeShaderManager.primaryVal().weightVal(string) ? string : "";
    }

    public String anchorVal() {
        if (this.widthVal == null || this.widthVal == SurfaceTarget.PREVIEW_ONLY) {
            return "";
        }
        try {
            ShaderPresetMeta vUvUNNUvvNVN = FoundryStorage.primaryVal().tertiaryVal(this.widthVal);
            if (vUvUNNUvvNVN != null && ThemeShaderManager.primaryVal().weightVal(vUvUNNUvvNVN.secondaryVal())) {
                return vUvUNNUvvNVN.secondaryVal();
            }
        }
        catch (Throwable throwable) {
        }
        return "";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean secondaryVal(String string) {
        if (string == null) return false;
        if (!string.equalsIgnoreCase(this.extraVal())) return false;
        return true;
    }

    private static String marginVal(String string) {
        block3: {
            block2: {
                if (string == null) break block2;
                if (string.isBlank()) break block2;
                if (!ShaderPresetSetting.weightVal(string)) break block3;
            }
            return speedVal;
        }
        return string.trim();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean weightVal(String string) {
        if (string == null) return true;
        if (string.isBlank()) return true;
        if (!speedVal.equalsIgnoreCase(string.trim())) return false;
        return true;
    }

    private static int paramVal(String string) {
        ThemeShaderManager.cursorVal panelVal = ThemeShaderManager.primaryVal().paramVal(string);
        return switch (panelVal) {
            default -> throw new MatchException(null, null);
            case ThemeShaderManager.cursorVal.PRESET -> 0;
            case ThemeShaderManager.cursorVal.USER -> 1;
            case ThemeShaderManager.cursorVal.IMPORTED -> 2;
            case ThemeShaderManager.cursorVal.RUNTIME -> 3;
        };
    }

    private static boolean primaryVal(List<String> list, String string) {
        if (list == null || string == null) {
            return false;
        }
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String string2 = iterator.next();
            if (string2 == null || !string2.equalsIgnoreCase(string.trim())) continue;
            return true;
        }
        return false;
    }

    public /* synthetic */ StringListSetting primaryVal(Supplier supplier) {
        return this.tertiaryVal(supplier);
    }
}

