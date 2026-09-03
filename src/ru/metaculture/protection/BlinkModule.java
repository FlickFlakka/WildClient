/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2824
 *  net.minecraft.class_5498
 *  net.minecraft.class_746
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2824;
import net.minecraft.class_5498;
import net.minecraft.class_746;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.PostWorldJoinEvent;
import ru.metaculture.protection.WorldJoinEvent;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.PostClientTickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.BlockBreakEvent;
import ru.metaculture.protection.RenderWorldLastEvent;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="Blink", secondaryVal="Delays packets to simulate ping", tertiaryVal=ModuleCategory.Player, marginVal={ModuleBadge.RISKY, ModuleBadge.GRIM})
public class BlinkModule
extends Module {
    private static final int countVal = -1258291201;
    private final List<class_2596<?>> depthVal = new ArrayList();
    private final BoolSetting descRef = new BoolSetting("Pulse", false);
    private final FloatSetting activeVal = new FloatSetting("Delay", 12.0f, 1.0f, 40.0f, 1.0f, false).primaryVal(() -> !this.descRef.tertiaryVal());
    private final BoolSetting radiusVal = new BoolSetting("Reset on hit", false);
    private final BoolSetting factorVal = new BoolSetting("Display model", true);
    private final BoolSetting sourceVal = new BoolSetting("Hide in first person", true).primaryVal(() -> !this.factorVal.tertiaryVal());
    private class_243 extraRef;
    private boolean phaseVal;
    private boolean limitRef;
    private boolean paramRef;
    private long groupVal;

    public BlinkModule() {
        Setting[] nvUuvVvuuNArray = new Setting[5];
        nvUuvVvuuNArray[0] = this.descRef;
        nvUuvVvuuNArray[1] = this.activeVal;
        nvUuvVvuuNArray[2] = this.radiusVal;
        nvUuvVvuuNArray[3] = this.factorVal;
        nvUuvVvuuNArray[4] = this.sourceVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        if (!this.holderVal()) {
            this.setEnabled(false);
            return;
        }
        this.depthVal.clear();
        this.extraRef = BlinkModule.mc.field_1724.method_19538();
        this.phaseVal = false;
        this.paramRef = false;
        this.groupVal = System.currentTimeMillis();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        if (!this.limitRef) {
            this.blockRef();
        }
        this.depthVal.clear();
        this.extraRef = null;
        this.phaseVal = false;
        this.paramRef = false;
        this.limitRef = false;
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        if (!uvUUuvnunU2.tertiaryVal() || this.phaseVal || !this.holderVal()) {
            return;
        }
        if (this.paramRef) {
            this.paramRef = false;
            if (uvUUuvnunU2.marginVal() instanceof class_2824) {
                return;
            }
        }
        this.depthVal.add(uvUUuvnunU2.marginVal());
        uvUUuvnunU2.secondaryVal();
    }

    @Subscribe
    public void primaryVal(BlockBreakEvent coreG) {
        block3: {
            block2: {
                class_1297 class_12972;
                if (!this.radiusVal.tertiaryVal() || !this.holderVal() || !((class_12972 = coreG.tertiaryVal()) instanceof class_1657)) break block2;
                class_1657 class_16572 = (class_1657)class_12972;
                if (class_16572 != BlinkModule.mc.field_1724 && !(class_16572 instanceof class_746)) break block3;
            }
            return;
        }
        this.blockRef();
        this.depthVal.clear();
        this.extraRef = BlinkModule.mc.field_1724.method_19538();
        this.paramRef = true;
        this.groupVal = System.currentTimeMillis();
    }

    @Subscribe
    public void primaryVal(PostClientTickEvent coreH) {
        if (!this.descRef.tertiaryVal() || this.depthVal.isEmpty()) {
            return;
        }
        if (System.currentTimeMillis() - this.groupVal >= this.timerVal()) {
            this.blockRef();
            this.depthVal.clear();
            this.extraRef = BlinkModule.mc.field_1724 != null ? BlinkModule.mc.field_1724.method_19538() : null;
            this.groupVal = System.currentTimeMillis();
        }
    }

    @Subscribe
    public void primaryVal(RenderWorldLastEvent partI) {
        block6: {
            block5: {
                if (!this.factorVal.tertiaryVal()) break block5;
                if (this.extraRef == null) break block5;
                if (BlinkModule.mc.field_1724 != null && BlinkModule.mc.field_1687 != null) break block6;
            }
            return;
        }
        if (BlinkModule.mc.field_1690.method_31044() == class_5498.field_26664) {
            if (this.sourceVal.tertiaryVal()) {
                return;
            }
        }
        class_238 class_2383 = BlinkModule.mc.field_1724.method_5829().method_997(this.extraRef.method_1020(BlinkModule.mc.field_1724.method_19538()));
        this.primaryVal(partI, class_2383, -1258291201);
    }

    @Subscribe
    public void primaryVal(PostWorldJoinEvent vaseE) {
        this.limitRef = true;
        this.setEnabled(false);
    }

    @Subscribe
    public void primaryVal(WorldJoinEvent coOCCcooOcOO2) {
        this.limitRef = true;
        this.setEnabled(false);
    }

    private void blockRef() {
        if (this.depthVal.isEmpty() || mc.method_1562() == null) {
            return;
        }
        this.phaseVal = true;
        try {
            for (class_2596<?> class_25962 : this.depthVal) {
                mc.method_1562().method_52787(class_25962);
            }
        }
        finally {
            this.phaseVal = false;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean holderVal() {
        if (BlinkModule.mc.field_1724 == null) return false;
        if (BlinkModule.mc.field_1687 == null) return false;
        if (mc.method_1562() == null) return false;
        return true;
    }

    private long timerVal() {
        return Math.round(this.activeVal.tertiaryVal() * 50.0f);
    }

    private void primaryVal(RenderWorldLastEvent partI, class_238 class_2383, int n) {
        class_243 class_2432 = new class_243(class_2383.field_1323, class_2383.field_1322, class_2383.field_1321);
        class_243 class_2433 = new class_243(class_2383.field_1320, class_2383.field_1325, class_2383.field_1324);
        class_243 class_2434 = new class_243(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
        class_243 class_2435 = new class_243(class_2432.field_1352, class_2432.field_1351, class_2433.field_1350);
        class_243 class_2436 = new class_243(class_2432.field_1352, class_2433.field_1351, class_2432.field_1350);
        class_243 class_2437 = new class_243(class_2432.field_1352, class_2433.field_1351, class_2433.field_1350);
        class_243 class_2438 = new class_243(class_2433.field_1352, class_2432.field_1351, class_2432.field_1350);
        class_243 class_2439 = new class_243(class_2433.field_1352, class_2432.field_1351, class_2433.field_1350);
        class_243 class_24310 = new class_243(class_2433.field_1352, class_2433.field_1351, class_2432.field_1350);
        class_243 class_24311 = new class_243(class_2433.field_1352, class_2433.field_1351, class_2433.field_1350);
        partI.weightVal().primaryVal(class_2434, class_2438, 1.0, n, false);
        partI.weightVal().primaryVal(class_2438, class_2439, 1.0, n, false);
        partI.weightVal().primaryVal(class_2439, class_2435, 1.0, n, false);
        partI.weightVal().primaryVal(class_2435, class_2434, 1.0, n, false);
        partI.weightVal().primaryVal(class_2436, class_24310, 1.0, n, false);
        partI.weightVal().primaryVal(class_24310, class_24311, 1.0, n, false);
        partI.weightVal().primaryVal(class_24311, class_2437, 1.0, n, false);
        partI.weightVal().primaryVal(class_2437, class_2436, 1.0, n, false);
        partI.weightVal().primaryVal(class_2434, class_2436, 1.0, n, false);
        partI.weightVal().primaryVal(class_2438, class_24310, 1.0, n, false);
        partI.weightVal().primaryVal(class_2439, class_24311, 1.0, n, false);
        partI.weightVal().primaryVal(class_2435, class_2437, 1.0, n, false);
    }
}

