/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 */
package ru.metaculture.protection;

import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import net.minecraft.class_310;
import net.minecraft.class_437;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.UnUvnuVNNN;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.ModernClickGuiScreen;
import ru.metaculture.protection.ModuleCategory;

public class GuiConfigManager {
    public static class_310 primaryVal = class_310.method_1551();
    private File tertiaryVal;
    private NvVNvUvunNNu marginVal = NvVNvUvunNNu.WILD;
    private ModuleCategory weightVal = ModuleCategory.Visuals;
    private boolean paramVal;
    private float extraVal;
    private float limitVal;
    private boolean speedVal;
    private boolean widthVal;
    public ColorSetting secondaryVal = new ColorSetting("Custom Theme Color", Color.WHITE.getRGB());

    public void primaryVal() {
        this.tertiaryVal = new File(new File(WildClient.primaryVal.paramVal, "configs"), "gui.cfg");
        try {
            if (!this.tertiaryVal.getParentFile().exists()) {
                this.tertiaryVal.getParentFile().mkdirs();
            }
            if (!this.tertiaryVal.exists()) {
                this.tertiaryVal.createNewFile();
                this.widthVal();
            } else {
                this.chunkVal();
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void primaryVal(NvVNvUvunNNu nvVNvUvunNNu) {
        this.marginVal = nvVNvUvunNNu;
        this.widthVal();
    }

    public void primaryVal(ModuleCategory linkC) {
        this.weightVal = linkC;
        this.widthVal();
    }

    public NvVNvUvunNNu secondaryVal() {
        return this.marginVal;
    }

    public ModuleCategory tertiaryVal() {
        return this.weightVal;
    }

    public boolean marginVal() {
        return this.paramVal;
    }

    public float weightVal() {
        return this.extraVal;
    }

    public float paramVal() {
        return this.limitVal;
    }

    public void primaryVal(float f, float f2) {
        if (!Float.isFinite(f) || !Float.isFinite(f2)) {
            return;
        }
        if (this.paramVal && Math.abs(this.extraVal - f) < 0.5f && Math.abs(this.limitVal - f2) < 0.5f) {
            return;
        }
        this.paramVal = true;
        this.extraVal = f;
        this.limitVal = f2;
        this.widthVal();
    }

    public boolean extraVal() {
        return this.speedVal;
    }

    public boolean limitVal() {
        return this.widthVal;
    }

    public void primaryVal(boolean bl) {
        if (this.speedVal && this.widthVal == bl) {
            return;
        }
        this.speedVal = true;
        this.widthVal = bl;
        this.widthVal();
    }

    public UnUvnuVNNN speedVal() {
        class_437 class_4372;
        if (primaryVal != null && (class_4372 = GuiConfigManager.primaryVal.field_1755) instanceof ModernClickGuiScreen) {
            ModernClickGuiScreen mossB = (ModernClickGuiScreen)class_4372;
            return mossB.primaryVal();
        }
        return null;
    }

    private void widthVal() {
        if (this.tertiaryVal == null) {
            return;
        }
        try (FileWriter fileWriter = new FileWriter(this.tertiaryVal);){
            Properties properties = new Properties();
            properties.setProperty("theme", this.marginVal.name());
            properties.setProperty("category", this.weightVal.name());
            properties.setProperty("customColor", String.valueOf(this.secondaryVal.limitVal()));
            properties.setProperty("customColorAlpha", String.valueOf(this.secondaryVal.anchorVal));
            properties.setProperty("customColorPresets", this.primaryVal(this.secondaryVal));
            if (this.paramVal) {
                properties.setProperty("themeScreenX", String.valueOf(this.extraVal));
                properties.setProperty("themeScreenY", String.valueOf(this.limitVal));
            }
            if (this.speedVal) {
                properties.setProperty("themePanelVisible", String.valueOf(this.widthVal));
            }
            properties.store(fileWriter, "GUI Settings");
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    private void chunkVal() {
        try (FileReader fileReader = new FileReader(this.tertiaryVal);){
            Properties properties = new Properties();
            properties.load(fileReader);
            this.marginVal = NvVNvUvunNNu.valueOf(properties.getProperty("theme", NvVNvUvunNNu.WILD.name()));
            this.weightVal = ModuleCategory.valueOf(properties.getProperty("category", ModuleCategory.Visuals.name()));
            if (properties.containsKey("customColor")) {
                int n = Integer.parseInt(properties.getProperty("customColor"));
                this.secondaryVal.primaryVal(n);
                if (properties.containsKey("customColorAlpha")) {
                    this.secondaryVal.secondaryVal(Float.parseFloat(properties.getProperty("customColorAlpha")));
                }
                this.primaryVal(this.secondaryVal, properties.getProperty("customColorPresets", ""));
            }
            if (properties.containsKey("themeScreenX") && properties.containsKey("themeScreenY")) {
                this.extraVal = Float.parseFloat(properties.getProperty("themeScreenX"));
                this.limitVal = Float.parseFloat(properties.getProperty("themeScreenY"));
                this.paramVal = Float.isFinite(this.extraVal) && Float.isFinite(this.limitVal);
            }
            if (properties.containsKey("themePanelVisible")) {
                this.widthVal = Boolean.parseBoolean(properties.getProperty("themePanelVisible"));
                this.speedVal = true;
            }
        }
        catch (IOException | IllegalArgumentException exception) {
            exception.printStackTrace();
        }
    }

    private String primaryVal(ColorSetting nodeG) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nodeG.weightRef.size(); ++i) {
            if (i > 0) {
                stringBuilder.append(',');
            }
            stringBuilder.append(nodeG.weightRef.get(i));
        }
        return stringBuilder.toString();
    }

    private void primaryVal(ColorSetting nodeG, String string) {
        String[] stringArray;
        block6: {
            block5: {
                nodeG.weightRef.clear();
                if (string == null) break block5;
                if (!string.isBlank()) break block6;
            }
            return;
        }
        String[] stringArray2 = stringArray = string.split(",");
        int n = stringArray2.length;
        for (int i = 0; i < n; ++i) {
            String string2 = stringArray2[i];
            if (nodeG.weightRef.size() >= 8) break;
            try {
                nodeG.weightRef.add(Integer.parseInt(string2.trim()));
                continue;
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
    }
}

