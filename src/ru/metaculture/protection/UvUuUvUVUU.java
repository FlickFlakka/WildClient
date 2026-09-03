/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_332
 */
package ru.metaculture.protection;

import java.util.List;
import net.minecraft.class_332;
import org.wild.module.api.Module;
import ru.metaculture.protection.ModuleLayoutResult;
import ru.metaculture.protection.SpringConfig;
import ru.metaculture.protection.HitTestRegion;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.VvvVunn;
import ru.metaculture.protection.ThemeContext;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.ClickGuiState;

public interface UvUuUvUVUU {
    public boolean primaryVal(Module var1);

    default public boolean primaryVal(Module module, ClickGuiState chunkRef) {
        return false;
    }

    default public void primaryVal(ClickGuiState chunkRef) {
    }

    default public void secondaryVal(ClickGuiState chunkRef) {
    }

    default public void tertiaryVal(ClickGuiState chunkRef) {
    }

    public float primaryVal(Module var1, GuiMetrics var2, ClickGuiState var3);

    public void primaryVal(Module var1, ClickGuiState var2, SpringConfig var3, SpringConfig var4);

    public void primaryVal(Renderer2D var1, class_332 var2, ClickGuiState var3, VvvVunn var4, ThemeContext var5);

    public void primaryVal(List<HitTestRegion> var1, ClickGuiState var2, VvvVunn var3, GuiMetrics var4);

    default public boolean primaryVal(ClickGuiState chunkRef, ModuleLayoutResult linkF, GuiMetrics cacheVal, float f, float f2, double d) {
        return false;
    }

    default public boolean primaryVal(ClickGuiState chunkRef, float f, float f2) {
        return false;
    }

    default public boolean marginVal(ClickGuiState chunkRef) {
        return false;
    }

    default public boolean primaryVal(ClickGuiState chunkRef, int n) {
        return false;
    }

    default public boolean primaryVal(ClickGuiState chunkRef, char c) {
        return false;
    }
}

