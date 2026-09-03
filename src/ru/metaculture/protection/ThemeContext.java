/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.ThemeSwatchCatalog;
import ru.metaculture.protection.GuiMetrics;

public final class ThemeContext {
    private final NvVNvUvunNNu primaryVal;
    private final GuiMetrics secondaryVal;
    private final ThemePalette tertiaryVal;
    private final ThemeSwatchCatalog marginVal;

    public boolean primaryVal() {
        if (this.tertiaryVal != null) {
            return this.tertiaryVal.activeVal();
        }
        if (this.marginVal == null) {
            return false;
        }
        return this.marginVal.tertiaryVal(this.primaryVal);
    }

    public boolean secondaryVal() {
        return this.primaryVal();
    }

    @Generated
    ThemeContext(NvVNvUvunNNu nvVNvUvunNNu, GuiMetrics cacheVal, ThemePalette configVal, ThemeSwatchCatalog baseA) {
        this.primaryVal = nvVNvUvunNNu;
        this.secondaryVal = cacheVal;
        this.tertiaryVal = configVal;
        this.marginVal = baseA;
    }

    @Generated
    public static Builder tertiaryVal() {
        return new Builder();
    }

    @Generated
    public NvVNvUvunNNu marginVal() {
        return this.primaryVal;
    }

    @Generated
    public GuiMetrics weightVal() {
        return this.secondaryVal;
    }

    @Generated
    public ThemePalette paramVal() {
        return this.tertiaryVal;
    }

    @Generated
    public ThemeSwatchCatalog extraVal() {
        return this.marginVal;
    }

    @Generated
    public boolean equals(Object object) {
        ThemeContext nodeE;
        block8: {
            block9: {
                ThemePalette configVal;
                ThemePalette linkE;
                block7: {
                    if (object == this) {
                        return true;
                    }
                    if (!(object instanceof ThemeContext)) {
                        return false;
                    }
                    nodeE = (ThemeContext)object;
                    NvVNvUvunNNu nvVNvUvunNNu = this.marginVal();
                    NvVNvUvunNNu nvVNvUvunNNu2 = nodeE.marginVal();
                    if (nvVNvUvunNNu == null ? nvVNvUvunNNu2 != null : !((Object)((Object)nvVNvUvunNNu)).equals((Object)nvVNvUvunNNu2)) {
                        return false;
                    }
                    GuiMetrics cacheVal = this.weightVal();
                    GuiMetrics duneE = nodeE.weightVal();
                    if (cacheVal == null ? duneE != null : !((Object)cacheVal).equals(duneE)) {
                        return false;
                    }
                    linkE = this.paramVal();
                    configVal = nodeE.paramVal();
                    if (linkE != null) break block7;
                    if (configVal == null) break block8;
                    break block9;
                }
                if (((Object)linkE).equals(configVal)) break block8;
            }
            return false;
        }
        ThemeSwatchCatalog baseA = this.extraVal();
        ThemeSwatchCatalog vaseB = nodeE.extraVal();
        return !(baseA == null ? vaseB != null : !((Object)baseA).equals(vaseB));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        NvVNvUvunNNu nvVNvUvunNNu = this.marginVal();
        n2 = n2 * 59 + (nvVNvUvunNNu == null ? 43 : ((Object)((Object)nvVNvUvunNNu)).hashCode());
        GuiMetrics cacheVal = this.weightVal();
        n2 = n2 * 59 + (cacheVal == null ? 43 : ((Object)cacheVal).hashCode());
        ThemePalette configVal = this.paramVal();
        n2 = n2 * 59 + (configVal == null ? 43 : ((Object)configVal).hashCode());
        ThemeSwatchCatalog baseA = this.extraVal();
        n2 = n2 * 59 + (baseA == null ? 43 : ((Object)baseA).hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "ThemeContext(theme=" + String.valueOf((Object)this.marginVal()) + ", metrics=" + String.valueOf(this.weightVal()) + ", colors=" + String.valueOf(this.paramVal()) + ", palette=" + String.valueOf(this.extraVal()) + ")";
    }

    @Generated
    public static class Builder {
        @Generated
        private NvVNvUvunNNu primaryVal;
        @Generated
        private GuiMetrics secondaryVal;
        @Generated
        private ThemePalette tertiaryVal;
        @Generated
        private ThemeSwatchCatalog marginVal;

        @Generated
        Builder() {
        }

        @Generated
        public Builder primaryVal(NvVNvUvunNNu nvVNvUvunNNu) {
            this.primaryVal = nvVNvUvunNNu;
            return this;
        }

        @Generated
        public Builder primaryVal(GuiMetrics cacheVal) {
            this.secondaryVal = cacheVal;
            return this;
        }

        @Generated
        public Builder primaryVal(ThemePalette configVal) {
            this.tertiaryVal = configVal;
            return this;
        }

        @Generated
        public Builder primaryVal(ThemeSwatchCatalog baseA) {
            this.marginVal = baseA;
            return this;
        }

        @Generated
        public ThemeContext primaryVal() {
            return new ThemeContext(this.primaryVal, this.secondaryVal, this.tertiaryVal, this.marginVal);
        }

        @Generated
        public String toString() {
            return "ThemeContext.ThemeContextBuilder(theme=" + String.valueOf((Object)this.primaryVal) + ", metrics=" + String.valueOf(this.secondaryVal) + ", colors=" + String.valueOf(this.tertiaryVal) + ", palette=" + String.valueOf(this.marginVal) + ")";
        }
    }
}

