/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_1657
 *  net.minecraft.class_1713
 *  net.minecraft.class_1802
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2680
 *  net.minecraft.class_2815
 *  net.minecraft.class_3532
 *  net.minecraft.class_3965
 *  net.minecraft.class_9892
 */
package ru.metaculture.protection;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1802;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2680;
import net.minecraft.class_2815;
import net.minecraft.class_3532;
import net.minecraft.class_3965;
import net.minecraft.class_9892;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.WorldVariantDetector;
import ru.metaculture.protection.InventoryUtil;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AutoExplosion", tertiaryVal=ModuleCategory.Combat, secondaryVal="Automatically places and detonates crystals on new obsidian", marginVal={ModuleBadge.RISKY})
public class AutoExplosionModule
extends Module {
    private static final float countVal = 6.0f;
    private final FloatSetting depthVal = new FloatSetting("Number of crystals", 1.0f, 1.0f, 10.0f, 1.0f, false);
    private final BoolSetting descRef = new BoolSetting("Don't blow up yourself", false);
    private final BoolSetting activeVal = new BoolSetting("Don't blow up friends", false);
    private final Set<class_2338> radiusVal = new HashSet<class_2338>();
    private final Set<class_2338> factorVal = new HashSet<class_2338>();
    private final Queue<class_2338> sourceVal = new ArrayDeque<class_2338>();
    private class_2338 extraRef;
    private int phaseVal;
    private int limitRef = -1;
    private int paramRef = -1;
    private int groupVal;
    private class_2338 layerVal;

    public AutoExplosionModule() {
        Setting[] nvUuvVvuuNArray = new Setting[3];
        nvUuvVvuuNArray[0] = this.depthVal;
        nvUuvVvuuNArray[1] = this.descRef;
        nvUuvVvuuNArray[2] = this.activeVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        block25: {
            class_2338 class_23382;
            block27: {
                block26: {
                    block24: {
                        block23: {
                            if (WorldVariantDetector.primaryVal()) break block23;
                            if (AutoExplosionModule.mc.field_1761 != null && mc.method_1562() != null) break block24;
                        }
                        return;
                    }
                    this.blockRef();
                    if (this.groupVal > 0) {
                        --this.groupVal;
                        if (this.groupVal == 0) {
                            this.timerVal();
                        }
                        return;
                    }
                    if (this.layerVal == null) break block25;
                    class_23382 = this.layerVal;
                    this.layerVal = null;
                    if (!class_23382.equals((Object)this.extraRef)) break block26;
                    if (this.phaseVal > 0) break block27;
                }
                this.anchorVal();
                return;
            }
            class_1511 class_15112 = this.secondaryVal(class_23382);
            if (class_15112 != null) {
                if (!this.extraVal(class_23382)) {
                    this.anchorVal();
                    return;
                }
                this.primaryVal(class_15112);
                --this.phaseVal;
                if (this.phaseVal <= 0) {
                    this.extraRef = null;
                }
                return;
            }
            if (this.paramVal(class_23382) && this.weightVal(class_23382)) {
                this.tertiaryVal(class_23382);
            } else {
                this.anchorVal();
            }
            return;
        }
        if (this.extraRef == null) {
            this.holderVal();
        }
        if (this.extraRef == null) {
            return;
        }
        if (!this.primaryVal(this.extraRef, 3.0)) {
            this.anchorVal();
            return;
        }
        if (!this.marginVal(this.extraRef)) {
            this.anchorVal();
            return;
        }
        class_1511 class_15113 = this.secondaryVal(this.extraRef);
        if (class_15113 != null) {
            if (!this.extraVal(this.extraRef)) {
                this.anchorVal();
                return;
            }
            this.primaryVal(class_15113);
            --this.phaseVal;
            if (this.phaseVal <= 0) {
                this.extraRef = null;
            }
            return;
        }
        if (this.phaseVal > 0 && !this.paramVal(this.extraRef)) {
            this.anchorVal();
            return;
        }
        if (this.phaseVal > 0 && this.weightVal(this.extraRef)) {
            int n = InventoryUtil.primaryVal(class_1802.field_8301);
            if (n == -1) {
                this.anchorVal();
                return;
            }
            this.primaryVal(this.extraRef, n);
        }
    }

    private void blockRef() {
        class_2338 class_23382 = AutoExplosionModule.mc.field_1724.method_24515();
        int n = 3;
        HashSet<class_2338> hashSet = new HashSet<class_2338>();
        for (int i = -n; i <= n; ++i) {
            for (int j = -n; j <= n; ++j) {
                for (int k = -n; k <= n; ++k) {
                    class_2338 class_23383 = class_23382.method_10069(i, j, k).method_10062();
                    if (!this.primaryVal(class_23383, (double)n)) continue;
                    hashSet.add(class_23383);
                    boolean bl = AutoExplosionModule.mc.field_1687.method_8320(class_23383).method_27852(class_2246.field_10540);
                    if (!this.radiusVal.contains(class_23383)) {
                        if (bl) {
                            this.factorVal.add(class_23383);
                            continue;
                        }
                        this.factorVal.remove(class_23383);
                        continue;
                    }
                    boolean bl2 = this.factorVal.contains(class_23383);
                    if (!bl2 && bl) {
                        this.factorVal.add(class_23383);
                        this.primaryVal(class_23383);
                        continue;
                    }
                    if (!bl2 || bl) continue;
                    this.factorVal.remove(class_23383);
                }
            }
        }
        this.radiusVal.clear();
        this.radiusVal.addAll(hashSet);
    }

    private void primaryVal(class_2338 class_23382) {
        if (!this.primaryVal(class_23382, 3.0)) {
            return;
        }
        if (class_23382.equals((Object)this.extraRef)) {
            return;
        }
        if (this.sourceVal.contains(class_23382)) {
            return;
        }
        this.sourceVal.offer(class_23382);
    }

    private void holderVal() {
        while (!this.sourceVal.isEmpty()) {
            class_2338 class_23382 = this.sourceVal.poll();
            if (!this.primaryVal(class_23382, 3.0) || !this.marginVal(class_23382)) continue;
            this.extraRef = class_23382;
            this.phaseVal = Math.max(1, Math.round(this.depthVal.tertiaryVal()));
            return;
        }
    }

    private class_1511 secondaryVal(class_2338 class_23382) {
        class_238 class_2383 = new class_238((double)class_23382.method_10263() - 0.5, (double)class_23382.method_10264() + 0.5, (double)class_23382.method_10260() - 0.5, (double)class_23382.method_10263() + 1.5, (double)class_23382.method_10264() + 3.0, (double)class_23382.method_10260() + 1.5);
        for (class_1297 class_12972 : AutoExplosionModule.mc.field_1687.method_8335(null, class_2383)) {
            if (!(class_12972 instanceof class_1511)) continue;
            class_1511 class_15112 = (class_1511)class_12972;
            return class_15112;
        }
        return null;
    }

    private void primaryVal(class_1511 class_15112) {
        this.primaryVal(class_15112.method_19538());
        AutoExplosionModule.mc.field_1761.method_2918((class_1657)AutoExplosionModule.mc.field_1724, (class_1297)class_15112);
        AutoExplosionModule.mc.field_1724.method_6104(class_1268.field_5808);
        this.groupVal = 2;
    }

    private void primaryVal(class_2338 class_23382, int n) {
        this.primaryVal(n);
        this.layerVal = class_23382;
    }

    private void tertiaryVal(class_2338 class_23382) {
        class_243 class_2432 = class_23382.method_46558().method_1031(0.0, 0.5, 0.0);
        this.primaryVal(class_2432);
        AutoExplosionModule.mc.field_1761.method_2896(AutoExplosionModule.mc.field_1724, class_1268.field_5808, new class_3965(class_2432, class_2350.field_11036, class_23382, false));
        AutoExplosionModule.mc.field_1724.method_6104(class_1268.field_5808);
        this.groupVal = 2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean marginVal(class_2338 class_23382) {
        class_2680 class_26802 = AutoExplosionModule.mc.field_1687.method_8320(class_23382);
        if (class_26802.method_27852(class_2246.field_10540)) return true;
        if (!class_26802.method_27852(class_2246.field_9987)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean weightVal(class_2338 class_23382) {
        if (!this.marginVal(class_23382)) {
            return false;
        }
        class_2338 class_23383 = class_23382.method_10084();
        class_2338 class_23384 = class_23383.method_10084();
        if (!AutoExplosionModule.mc.field_1687.method_8320(class_23383).method_26215()) return false;
        if (!AutoExplosionModule.mc.field_1687.method_8320(class_23384).method_26215()) return false;
        if (!AutoExplosionModule.mc.field_1687.method_8335(null, new class_238(class_23383)).isEmpty()) return false;
        if (!AutoExplosionModule.mc.field_1687.method_8335(null, new class_238(class_23384)).isEmpty()) return false;
        return true;
    }

    private boolean primaryVal(class_2338 class_23382, double d) {
        return AutoExplosionModule.mc.field_1724.method_5707(class_23382.method_46558()) <= d * d;
    }

    private boolean paramVal(class_2338 class_23382) {
        if (this.descRef.tertiaryVal()) {
            if (this.limitVal(class_23382)) {
                return false;
            }
        }
        return this.extraVal(class_23382);
    }

    private boolean extraVal(class_2338 class_23382) {
        if (this.descRef.tertiaryVal() && this.limitVal(class_23382)) {
            return false;
        }
        if (!this.activeVal.tertiaryVal()) {
            return true;
        }
        for (class_1657 class_16572 : AutoExplosionModule.mc.field_1687.method_18456()) {
            if (class_16572 == AutoExplosionModule.mc.field_1724 || !FriendCommand.primaryVal(class_16572.method_5477().getString()) || !this.primaryVal(class_16572, class_23382.method_46558().method_1031(0.0, 1.0, 0.0))) continue;
            return false;
        }
        return true;
    }

    private boolean limitVal(class_2338 class_23382) {
        return AutoExplosionModule.mc.field_1724.method_31478() == class_23382.method_10264() + 1;
    }

    private boolean primaryVal(class_1657 class_16572, class_243 class_2432) {
        double d = 12.0;
        if (class_16572.method_5707(class_2432) > d * d) {
            return false;
        }
        return class_9892.method_61731((class_243)class_2432, (class_1297)class_16572) > 0.0f;
    }

    private void primaryVal(int n) {
        if (this.limitRef < 0) {
            this.limitRef = AutoExplosionModule.mc.field_1724.method_31548().method_67532();
        }
        if (this.secondaryVal(n)) {
            AutoExplosionModule.mc.field_1724.method_31548().method_61496(this.tertiaryVal(n));
            return;
        }
        this.paramRef = n;
        AutoExplosionModule.mc.field_1761.method_2906(AutoExplosionModule.mc.field_1724.field_7498.field_7763, this.paramRef, this.limitRef, class_1713.field_7791, (class_1657)AutoExplosionModule.mc.field_1724);
    }

    private void timerVal() {
        if (this.limitRef < 0) {
            return;
        }
        if (this.paramRef >= 0) {
            AutoExplosionModule.mc.field_1761.method_2906(AutoExplosionModule.mc.field_1724.field_7498.field_7763, this.paramRef, this.limitRef, class_1713.field_7791, (class_1657)AutoExplosionModule.mc.field_1724);
            if (mc.method_1562() != null) {
                mc.method_1562().method_52787((class_2596)new class_2815(AutoExplosionModule.mc.field_1724.field_7498.field_7763));
            }
            this.paramRef = -1;
        }
        AutoExplosionModule.mc.field_1724.method_31548().method_61496(this.limitRef);
        this.limitRef = -1;
    }

    private boolean secondaryVal(int n) {
        return n >= 0 && n <= 8 || n >= 36 && n <= 44;
    }

    private int tertiaryVal(int n) {
        return n >= 36 ? n - 36 : n;
    }

    private void anchorVal() {
        this.extraRef = null;
        this.phaseVal = 0;
        this.layerVal = null;
        this.timerVal();
    }

    private void primaryVal(class_243 class_2432) {
        class_243 class_2433 = class_2432.method_1020(AutoExplosionModule.mc.field_1724.method_33571());
        float f = (float)Math.toDegrees(Math.atan2(-class_2433.field_1352, class_2433.field_1350));
        float f2 = (float)(-Math.toDegrees(Math.atan2(class_2433.field_1351, Math.hypot(class_2433.field_1352, class_2433.field_1350))));
        RotationController.primaryVal(new Rotation(f, class_3532.method_15363((float)f2, (float)-90.0f, (float)90.0f)), 360.0f, 360.0f, 360.0f, 360.0f, 2, 30, false);
    }

    @Override
    public void onDisable() {
        if (this.limitRef >= 0) {
            if (AutoExplosionModule.mc.field_1724 != null) {
                this.timerVal();
            }
        }
        this.extraRef = null;
        this.phaseVal = 0;
        this.limitRef = -1;
        this.paramRef = -1;
        this.groupVal = 0;
        this.layerVal = null;
        this.sourceVal.clear();
        this.radiusVal.clear();
        this.factorVal.clear();
        RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
        RotationController.paramVal = 0;
        RotationController.speedVal = null;
        MouseLookOverride.primaryVal = false;
        super.onDisable();
    }
}

