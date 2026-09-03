/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1657
 *  net.minecraft.class_1703
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_2596
 *  net.minecraft.class_2813
 *  net.minecraft.class_2815
 *  net.minecraft.class_304
 *  net.minecraft.class_310
 *  net.minecraft.class_3675
 *  net.minecraft.class_490
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.class_1657;
import net.minecraft.class_1703;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_2596;
import net.minecraft.class_2813;
import net.minecraft.class_2815;
import net.minecraft.class_304;
import net.minecraft.class_310;
import net.minecraft.class_3675;
import net.minecraft.class_490;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.InputFreezeManager;
import ru.metaculture.protection.MovementUtil;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.ClickGuiScreen;
import ru.metaculture.protection.PostClientTickEvent;
import ru.metaculture.protection.DisconnectPacketEvent;
import ru.metaculture.protection.ModernClickGuiScreen;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="InvMove", secondaryVal="Allows walking with the inventory and client menu open", tertiaryVal=ModuleCategory.Movement)
public class InvMoveModule
extends Module {
    public static ModeSetting countVal;
    public static FloatSetting depthVal;
    private final List<class_2596<?>> activeVal = new ArrayList();
    public boolean descRef = false;
    private boolean radiusVal = false;
    private boolean factorVal = false;
    private long sourceVal = 0L;
    private static long extraRef;

    public InvMoveModule() {
        Setting[] nvUuvVvuuNArray = new Setting[2];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(PostClientTickEvent coreH) {
        if (this.descRef) {
            InputFreezeManager.primaryVal().primaryVal("GuiMove");
        } else {
            InputFreezeManager.primaryVal().secondaryVal("GuiMove");
        }
        if (this.radiusVal && System.currentTimeMillis() >= this.sourceVal) {
            this.radiusVal = false;
            this.anchorVal();
            this.descRef = false;
        }
        if (InvMoveModule.mc.field_1724 == null) {
            return;
        }
        if (countVal.secondaryVal("Vanilla")) {
            this.descRef();
        } else if (countVal.secondaryVal("Grim")) {
            this.depthVal();
        } else if (countVal.secondaryVal("FunTime")) {
            if (!MovementUtil.primaryVal() && !this.activeVal.isEmpty()) {
                if (InvMoveModule.mc.field_1755 instanceof class_490) {
                    this.holderVal();
                }
            }
            this.activeVal();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        class_2813 class_28132;
        block10: {
            block11: {
                block8: {
                    block9: {
                        if (!uvUUuvnunU2.tertiaryVal()) return;
                        if (this.factorVal) return;
                        if (!(InvMoveModule.mc.field_1755 instanceof class_490)) {
                            return;
                        }
                        if (!(uvUUuvnunU2.marginVal() instanceof class_2815) || !countVal.secondaryVal("FunTime")) break block8;
                        if (!this.activeVal.isEmpty()) break block9;
                        if (!MovementUtil.primaryVal()) break block8;
                    }
                    uvUUuvnunU2.secondaryVal();
                    this.sourceVal = System.currentTimeMillis() + this.bufferVal();
                    this.radiusVal = true;
                    this.descRef = true;
                    return;
                }
                class_2596<?> class_25962 = uvUUuvnunU2.marginVal();
                if (!(class_25962 instanceof class_2813)) return;
                class_28132 = (class_2813)class_25962;
                InvMoveModule.countVal();
                if (!countVal.secondaryVal("Grim")) break block10;
                if (InvMoveModule.mc.field_1724.method_5624()) break block11;
                if (!InvMoveModule.mc.field_1724.method_70673()) break block10;
            }
            this.activeVal.add((class_2596<?>)class_28132);
            uvUUuvnunU2.secondaryVal();
            return;
        }
        if (!countVal.secondaryVal("FunTime")) return;
        if (!MovementUtil.primaryVal()) return;
        if (this.activeVal.isEmpty()) {
            if (!this.primaryVal(class_28132)) return;
        }
        this.activeVal.add((class_2596<?>)class_28132);
        uvUUuvnunU2.secondaryVal();
    }

    @Subscribe
    public void primaryVal(DisconnectPacketEvent nVVuNnVvvnnn2) {
        if (InvMoveModule.mc.field_1755 instanceof class_490) {
            if (countVal.secondaryVal("Grim")) {
                if (!InvMoveModule.mc.field_1724.method_5624()) {
                    this.weightRef();
                    return;
                }
                nVVuNnVvvnnn2.secondaryVal();
                this.descRef = false;
                this.sourceVal = System.currentTimeMillis() + this.bufferVal();
                this.radiusVal = true;
            } else if (countVal.secondaryVal("FunTime")) {
                if (!this.activeVal.isEmpty() || MovementUtil.primaryVal()) {
                    nVVuNnVvvnnn2.secondaryVal();
                    this.sourceVal = System.currentTimeMillis() + this.bufferVal();
                    this.radiusVal = true;
                    this.descRef = true;
                } else {
                    this.weightRef();
                    this.descRef = false;
                    this.radiusVal = false;
                }
            }
        }
    }

    private void holderVal() {
        if (this.activeVal.isEmpty()) {
            return;
        }
        InvMoveModule.countVal();
        this.factorVal = true;
        try {
            for (class_2596<?> class_25962 : this.activeVal) {
                if (mc.method_1562() == null) continue;
                mc.method_1562().method_52787(class_25962);
            }
        }
        finally {
            this.factorVal = false;
            this.activeVal.clear();
        }
    }

    private void timerVal() {
        if (InvMoveModule.mc.field_1724 != null) {
            InvMoveModule.mc.field_1724.method_3137();
        }
    }

    private void anchorVal() {
        this.holderVal();
        this.weightRef();
        this.timerVal();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void weightRef() {
        class_1703 class_17032;
        block10: {
            block9: {
                if (InvMoveModule.mc.field_1724 == null || InvMoveModule.mc.field_1761 == null) {
                    return;
                }
                class_17032 = InvMoveModule.mc.field_1724.field_7512;
                if (class_17032 == null) break block9;
                if (!class_17032.method_34255().method_7960()) break block10;
            }
            return;
        }
        int n = this.primaryVal(class_17032);
        if (n == -1) {
            return;
        }
        boolean bl = this.factorVal;
        this.factorVal = true;
        try {
            InvMoveModule.countVal();
            InvMoveModule.mc.field_1761.method_2906(class_17032.field_7763, n, 0, class_1713.field_7790, (class_1657)InvMoveModule.mc.field_1724);
        }
        finally {
            this.factorVal = bl;
        }
    }

    private int primaryVal(class_1703 class_17032) {
        class_1799 class_17992 = class_17032.method_34255();
        int n = -1;
        for (class_1735 class_17352 : class_17032.field_7761) {
            if (class_17352.field_7871 != InvMoveModule.mc.field_1724.method_31548()) continue;
            class_1799 class_17993 = class_17352.method_7677();
            if (class_17993.method_7960()) {
                if (n != -1) continue;
                n = class_17352.field_7874;
                continue;
            }
            if (!class_1799.method_31577((class_1799)class_17993, (class_1799)class_17992)) continue;
            if (class_17993.method_7947() + class_17992.method_7947() > class_17993.method_7914()) continue;
            return class_17352.field_7874;
        }
        return n;
    }

    private long bufferVal() {
        return (long)depthVal.tertiaryVal();
    }

    private boolean primaryVal(class_2813 class_28132) {
        return !class_28132.comp_3847().isEmpty();
    }

    private static void countVal() {
        extraRef = System.currentTimeMillis();
    }

    public static boolean blockRef() {
        return InvMoveModule.mc.field_1755 instanceof class_490 && System.currentTimeMillis() - extraRef < 350L;
    }

    private void depthVal() {
        class_304[] class_304Array = new class_304[6];
        class_304Array[0] = InvMoveModule.mc.field_1690.field_1894;
        class_304Array[1] = InvMoveModule.mc.field_1690.field_1881;
        class_304Array[2] = InvMoveModule.mc.field_1690.field_1913;
        class_304Array[3] = InvMoveModule.mc.field_1690.field_1849;
        class_304Array[4] = InvMoveModule.mc.field_1690.field_1903;
        class_304Array[5] = InvMoveModule.mc.field_1690.field_1867;
        class_304[] class_304Array2 = class_304Array;
        if (this.radiusVal()) {
            this.descRef = false;
            this.primaryVal(class_304Array2);
            return;
        }
        if (this.radiusVal) {
            this.descRef = true;
            return;
        }
        if (!(InvMoveModule.mc.field_1755 instanceof class_490)) {
            this.descRef = false;
        }
        if (InvMoveModule.mc.field_1755 instanceof class_490) {
            this.primaryVal(class_304Array2);
        }
    }

    private void descRef() {
        if (!(InvMoveModule.mc.field_1755 instanceof class_490)) {
            if (!this.radiusVal()) {
                this.descRef = false;
            }
        }
        class_304[] class_304Array = new class_304[6];
        class_304Array[0] = InvMoveModule.mc.field_1690.field_1894;
        class_304Array[1] = InvMoveModule.mc.field_1690.field_1881;
        class_304Array[2] = InvMoveModule.mc.field_1690.field_1913;
        class_304Array[3] = InvMoveModule.mc.field_1690.field_1849;
        class_304Array[4] = InvMoveModule.mc.field_1690.field_1903;
        class_304Array[5] = InvMoveModule.mc.field_1690.field_1867;
        class_304[] class_304Array2 = class_304Array;
        if (InvMoveModule.mc.field_1755 instanceof class_490 || this.radiusVal()) {
            this.descRef = false;
            this.primaryVal(class_304Array2);
        }
    }

    private void activeVal() {
        class_304[] class_304Array = new class_304[]{InvMoveModule.mc.field_1690.field_1894, InvMoveModule.mc.field_1690.field_1881, InvMoveModule.mc.field_1690.field_1913, InvMoveModule.mc.field_1690.field_1849, InvMoveModule.mc.field_1690.field_1903, InvMoveModule.mc.field_1690.field_1867};
        if (this.radiusVal()) {
            this.descRef = false;
            this.primaryVal(class_304Array);
            return;
        }
        if (this.radiusVal) {
            this.descRef = true;
            return;
        }
        if (!(InvMoveModule.mc.field_1755 instanceof class_490)) {
            this.descRef = false;
        }
        if (InvMoveModule.mc.field_1755 instanceof class_490) {
            this.primaryVal(class_304Array);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean radiusVal() {
        if (InvMoveModule.mc.field_1755 instanceof ClickGuiScreen) return true;
        if (!(InvMoveModule.mc.field_1755 instanceof ModernClickGuiScreen)) return false;
        return true;
    }

    private void primaryVal(class_304[] class_304Array) {
        ModernClickGuiScreen mossB;
        long l = class_310.method_1551().method_22683().method_4490();
        ModernClickGuiScreen kelpC = mossB = InvMoveModule.mc.field_1755 instanceof ModernClickGuiScreen ? (ModernClickGuiScreen)InvMoveModule.mc.field_1755 : null;
        boolean bl = mossB != null && mossB.primaryVal().weightVal();
        class_304[] class_304Array2 = class_304Array;
        for (class_304 class_3042 : class_304Array2) {
            if (bl) {
                class_3042.method_23481(false);
                continue;
            }
            int n = class_3042.method_1429().method_1444();
            boolean bl2 = class_3675.method_15987((long)l, (int)n);
            class_3042.method_23481(bl2);
        }
    }

    @Override
    public void onDisable() {
        this.descRef = false;
        this.radiusVal = false;
        this.factorVal = false;
        InputFreezeManager.primaryVal().secondaryVal("GuiMove");
        this.activeVal.clear();
        super.onDisable();
    }

    static {
        String[] stringArray = new String[3];
        stringArray[0] = "Grim";
        stringArray[1] = "Vanilla";
        stringArray[2] = "FunTime";
        countVal = new ModeSetting("Mode", "Grim", stringArray);
        depthVal = new FloatSetting("Close delay", 100.0f, 0.0f, 300.0f, 10.0f, false);
        extraRef = 0L;
    }
}

