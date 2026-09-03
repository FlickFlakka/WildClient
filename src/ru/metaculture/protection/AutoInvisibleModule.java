/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1657
 *  net.minecraft.class_1713
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1844
 *  net.minecraft.class_636
 *  net.minecraft.class_9334
 */
package ru.metaculture.protection;

import java.util.function.Predicate;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_636;
import net.minecraft.class_9334;
import org.wild.mixin.acceser.ClientPlayerInteractionManagerAccessor;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="AutoInvisible", tertiaryVal=ModuleCategory.Player, secondaryVal="Automatically drinks invisibility potion and restores the previous slot")
public class AutoInvisibleModule
extends Module {
    public final FloatSetting countVal = new FloatSetting("Threshold before potion (sec)", 5.0f, 1.0f, 60.0f, 1.0f, false);
    private static final long depthVal = 1850L;
    private final VuNvNNvVV descRef = new VuNvNNvVV();
    private boolean activeVal;
    private int radiusVal = -1;

    public AutoInvisibleModule() {
        this.addSettings(this.countVal);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (AutoInvisibleModule.mc.field_1724 == null || AutoInvisibleModule.mc.field_1687 == null || AutoInvisibleModule.mc.field_1761 == null) {
            return;
        }
        if (AutoInvisibleModule.mc.field_1755 != null) {
            if (this.activeVal) {
                this.blockRef();
            }
            return;
        }
        if (this.activeVal) {
            if (AutoInvisibleModule.mc.field_1724.method_6115() && !this.descRef.weightVal(1850L)) {
                AutoInvisibleModule.mc.field_1690.field_1904.method_23481(true);
                return;
            }
            this.blockRef();
            return;
        }
        if (!this.holderVal()) {
            return;
        }
        int n = this.primaryVal(this::primaryVal);
        if (n == -1) {
            return;
        }
        int n2 = this.primaryVal(n);
        if (n2 == -1) {
            return;
        }
        this.radiusVal = AutoInvisibleModule.mc.field_1724.method_31548().method_67532();
        this.secondaryVal(n2);
        AutoInvisibleModule.mc.field_1690.field_1904.method_23481(true);
        this.activeVal = true;
        this.descRef.primaryVal();
    }

    private void blockRef() {
        AutoInvisibleModule.mc.field_1690.field_1904.method_23481(false);
        if (this.radiusVal >= 0 && this.radiusVal < 9) {
            this.secondaryVal(this.radiusVal);
        }
        this.activeVal = false;
        this.radiusVal = -1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean holderVal() {
        class_1293 class_12932 = AutoInvisibleModule.mc.field_1724.method_6112(class_1294.field_5905);
        if (class_12932 == null) return true;
        if (class_12932.method_5584() > (int)this.countVal.tertiaryVal() * 20) return false;
        return true;
    }

    private int primaryVal(Predicate<class_1799> predicate) {
        for (int i = 0; i < 36; ++i) {
            class_1799 class_17992 = AutoInvisibleModule.mc.field_1724.method_31548().method_5438(i);
            if (class_17992.method_7960()) continue;
            if (!predicate.test(class_17992)) continue;
            return i;
        }
        return -1;
    }

    private int primaryVal(int n) {
        int n2;
        if (n >= 0 && n < 9) {
            return n;
        }
        int n3 = AutoInvisibleModule.mc.field_1724.method_31548().method_67532();
        for (n2 = 0; n2 < 9; ++n2) {
            if (!AutoInvisibleModule.mc.field_1724.method_31548().method_5438(n2).method_7960()) continue;
            n3 = n2;
            break;
        }
        n2 = n < 9 ? n + 36 : n;
        AutoInvisibleModule.mc.field_1761.method_2906(AutoInvisibleModule.mc.field_1724.field_7498.field_7763, n2, n3, class_1713.field_7791, (class_1657)AutoInvisibleModule.mc.field_1724);
        return n3;
    }

    private boolean primaryVal(class_1799 class_17992) {
        if (class_17992 == null || class_17992.method_7960() || !class_17992.method_31574(class_1802.field_8574)) {
            return false;
        }
        class_1844 class_18442 = (class_1844)class_17992.method_58694(class_9334.field_49651);
        if (class_18442 == null) {
            return false;
        }
        for (class_1293 class_12932 : class_18442.method_57397()) {
            if (!class_12932.method_5579().equals((Object)class_1294.field_5905)) continue;
            return true;
        }
        return false;
    }

    private void secondaryVal(int n) {
        AutoInvisibleModule.mc.field_1724.method_31548().method_61496(n);
        class_636 class_6362 = AutoInvisibleModule.mc.field_1761;
        if (class_6362 instanceof ClientPlayerInteractionManagerAccessor) {
            ClientPlayerInteractionManagerAccessor clientPlayerInteractionManagerAccessor = (ClientPlayerInteractionManagerAccessor)class_6362;
            clientPlayerInteractionManagerAccessor.invokeSyncSelectedSlot();
        }
    }

    @Override
    public void onDisable() {
        if (this.activeVal || AutoInvisibleModule.mc.field_1690 != null && AutoInvisibleModule.mc.field_1690.field_1904.method_1434()) {
            AutoInvisibleModule.mc.field_1690.field_1904.method_23481(false);
            if (this.radiusVal >= 0 && this.radiusVal < 9 && AutoInvisibleModule.mc.field_1724 != null) {
                this.secondaryVal(this.radiusVal);
            }
        }
        this.activeVal = false;
        this.radiusVal = -1;
        super.onDisable();
    }
}

