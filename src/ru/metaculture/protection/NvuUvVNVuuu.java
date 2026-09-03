/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Iterator;
import java.util.List;
import org.wild.module.api.Module;
import ru.metaculture.protection.ModuleLayoutResult;
import ru.metaculture.protection.SpringConfig;
import ru.metaculture.protection.HitTestRegion;
import ru.metaculture.protection.UvUuUvUVUU;
import ru.metaculture.protection.VvvVunn;
import ru.metaculture.protection.ConfigCatalogPanel;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.AutoCraftPanel;
import ru.metaculture.protection.ElementAnimState;
import ru.metaculture.protection.ClickGuiState;

public final class NvuUvVNVuuu {
    private static final List<UvUuUvUVUU> primaryVal = List.of(new ConfigCatalogPanel(), new AutoCraftPanel());

    private NvuUvVNVuuu() {
    }

    public static UvUuUvUVUU primaryVal(Module module) {
        Iterator<UvUuUvUVUU> iterator = primaryVal.iterator();
        while (iterator.hasNext()) {
            UvUuUvUVUU cellF = iterator.next();
            if (!cellF.primaryVal(module)) continue;
            return cellF;
        }
        return null;
    }

    public static boolean secondaryVal(Module module) {
        return NvuUvVNVuuu.primaryVal(module) != null;
    }

    public static VvvVunn primaryVal(Module module, ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        return new VvvVunn(module, uVUvuUUNVUv2.anchorVal(), uVUvuUUNVUv2.weightRef() - cacheVal.weightRef() - cacheVal.primaryVal(10.0f), uVUvuUUNVUv2.bufferVal(), cacheVal.weightRef() + uVUvuUUNVUv2.countVal(), uVUvuUUNVUv2.countVal() + cacheVal.primaryVal(20.0f));
    }

    public static void primaryVal(ClickGuiState chunkRef) {
        NvuUvVNVuuu.tertiaryVal(chunkRef);
        Iterator<UvUuUvUVUU> iterator = primaryVal.iterator();
        while (iterator.hasNext()) {
            UvUuUvUVUU cellF = iterator.next();
            cellF.primaryVal(chunkRef);
        }
    }

    public static void secondaryVal(ClickGuiState chunkRef) {
        NvuUvVNVuuu.tertiaryVal(chunkRef);
        Iterator<UvUuUvUVUU> iterator = primaryVal.iterator();
        while (iterator.hasNext()) {
            UvUuUvUVUU cellF = iterator.next();
            cellF.secondaryVal(chunkRef);
        }
    }

    public static void tertiaryVal(ClickGuiState chunkRef) {
        Iterator<UvUuUvUVUU> iterator = primaryVal.iterator();
        while (iterator.hasNext()) {
            UvUuUvUVUU cellF = iterator.next();
            cellF.tertiaryVal(chunkRef);
        }
    }

    public static void primaryVal(Module module, ClickGuiState chunkRef, SpringConfig unitH, SpringConfig coreJ) {
        UvUuUvUVUU cellF = NvuUvVNVuuu.primaryVal(module);
        if (cellF != null) {
            cellF.primaryVal(module, chunkRef, unitH, coreJ);
        }
    }

    public static void primaryVal(List<HitTestRegion> list, ClickGuiState chunkRef, VvvVunn vvvVunn, GuiMetrics cacheVal) {
        UvUuUvUVUU cellF = NvuUvVNVuuu.primaryVal(vvvVunn.primaryVal());
        if (cellF != null) {
            cellF.primaryVal(list, chunkRef, vvvVunn, cacheVal);
        }
    }

    public static boolean primaryVal(ClickGuiState chunkRef, ModuleLayoutResult linkF, GuiMetrics cacheVal, float f, float f2, double d) {
        for (UvUuUvUVUU cellF : primaryVal) {
            if (!cellF.primaryVal(chunkRef, linkF, cacheVal, f, f2, d)) continue;
            return true;
        }
        return false;
    }

    public static boolean primaryVal(ClickGuiState chunkRef, float f, float f2) {
        for (UvUuUvUVUU cellF : primaryVal) {
            if (!cellF.primaryVal(chunkRef, f, f2)) continue;
            return true;
        }
        return false;
    }

    public static boolean marginVal(ClickGuiState chunkRef) {
        boolean bl = false;
        Iterator<UvUuUvUVUU> iterator = primaryVal.iterator();
        while (iterator.hasNext()) {
            UvUuUvUVUU cellF = iterator.next();
            if (!cellF.marginVal(chunkRef)) continue;
            bl = true;
        }
        return bl;
    }

    public static boolean primaryVal(ClickGuiState chunkRef, int n) {
        Iterator<UvUuUvUVUU> iterator = primaryVal.iterator();
        while (iterator.hasNext()) {
            UvUuUvUVUU cellF = iterator.next();
            if (!cellF.primaryVal(chunkRef, n)) continue;
            return true;
        }
        return false;
    }

    public static boolean primaryVal(ClickGuiState chunkRef, char c) {
        Iterator<UvUuUvUVUU> iterator = primaryVal.iterator();
        while (iterator.hasNext()) {
            UvUuUvUVUU cellF = iterator.next();
            if (!cellF.primaryVal(chunkRef, c)) continue;
            return true;
        }
        return false;
    }
}

