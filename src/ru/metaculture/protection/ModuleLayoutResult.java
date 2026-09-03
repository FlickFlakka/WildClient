/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import java.util.List;
import lombok.Generated;
import ru.metaculture.protection.VvvVunn;

public final class ModuleLayoutResult {
    private final List<VvvVunn> primaryVal;
    private final float secondaryVal;

    public static ModuleLayoutResult primaryVal() {
        return new ModuleLayoutResult(List.of(), 0.0f);
    }

    @Generated
    public ModuleLayoutResult(List<VvvVunn> list, float f) {
        this.primaryVal = list;
        this.secondaryVal = f;
    }

    @Generated
    public List<VvvVunn> secondaryVal() {
        return this.primaryVal;
    }

    @Generated
    public float tertiaryVal() {
        return this.secondaryVal;
    }

    @Generated
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ModuleLayoutResult)) {
            return false;
        }
        ModuleLayoutResult linkF = (ModuleLayoutResult)object;
        if (Float.compare(this.tertiaryVal(), linkF.tertiaryVal()) != 0) {
            return false;
        }
        List<VvvVunn> list = this.secondaryVal();
        List<VvvVunn> list2 = linkF.secondaryVal();
        return !(list == null ? list2 != null : !((Object)list).equals(list2));
    }

    @Generated
    public int hashCode() {
        int n = 59;
        int n2 = 1;
        n2 = n2 * 59 + Float.floatToIntBits(this.tertiaryVal());
        List<VvvVunn> list = this.secondaryVal();
        n2 = n2 * 59 + (list == null ? 43 : ((Object)list).hashCode());
        return n2;
    }

    @Generated
    public String toString() {
        return "ModuleLayoutResult(placements=" + String.valueOf(this.secondaryVal()) + ", maxScroll=" + this.tertiaryVal() + ")";
    }
}

