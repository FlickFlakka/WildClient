/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1684
 *  net.minecraft.class_1713
 *  net.minecraft.class_1802
 *  net.minecraft.class_238
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2815
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 */
package ru.metaculture.protection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import net.minecraft.class_1268;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1684;
import net.minecraft.class_1713;
import net.minecraft.class_1802;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2815;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.InputFreezeManager;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.RequiresRole;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.SprintModule;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@RequiresRole(tertiaryVal={"lichoday"})
@ModuleRegister(primaryVal="TargetPearl", secondaryVal="Throws an ender pearl following the nearest player's pearl", tertiaryVal=ModuleCategory.Combat)
public class TargetPearlModule
extends Module {
    private static final double countVal = 0.03;
    private static final double depthVal = 0.99;
    private static final double descRef = 0.8;
    private static final double activeVal = 1.5;
    private static final int radiusVal = 240;
    private static final int factorVal = 160;
    private static final String sourceVal = "TargetPearl";
    private final FloatSetting extraRef = new FloatSetting("Reaction radius", 48.0f, 8.0f, 128.0f, 1.0f, false);
    private final BoolSetting phaseVal = new BoolSetting("Use rotation", true);
    private final FloatSetting limitRef = new FloatSetting("Turn speed", 40.0f, 5.0f, 180.0f, 1.0f, false).primaryVal(() -> !this.phaseVal.tertiaryVal());
    private final FloatSetting paramRef = new FloatSetting("Aim accuracy", 2.5f, 0.5f, 10.0f, 0.1f, false).primaryVal(() -> !this.phaseVal.tertiaryVal());
    private final FloatSetting groupVal = new FloatSetting("Max miss (blocks)", 2.5f, 0.5f, 8.0f, 0.1f, false);
    private final FloatSetting layerVal = new FloatSetting("Throw delay (ms)", 600.0f, 0.0f, 3000.0f, 50.0f, false);
    private final BoolSetting slotVal = new BoolSetting("Hotbar only", false);
    private final BoolSetting themeVal = new BoolSetting("Inventory only", false);
    private final BoolSetting stageVal = new BoolSetting("Ignore friends", true);
    private final BoolSetting widthRef = new BoolSetting("Require owner", false);
    private static final double trackVal = 3.0;
    private final Set<Integer> modeRef = new HashSet<Integer>();
    private final Set<Integer> angleVal = new HashSet<Integer>();
    private final Map<Integer, class_243> heightRef = new HashMap<Integer, class_243>();
    private final Map<Integer, class_243> levelVal = new HashMap<Integer, class_243>();
    private long UuNnnVnuNNV;
    private int depthRef = -1;
    private int speedRef;
    private int countRef;
    private int entryVal = -1;
    private int guardVal = -1;
    private float VUuuVUnun;
    private float vVVuuVVv;
    private float VuunNUUUvu;
    private float NNUUNUuVNNVn;

    public TargetPearlModule() {
        Setting[] nvUuvVvuuNArray = new Setting[10];
        nvUuvVvuuNArray[0] = this.extraRef;
        nvUuvVvuuNArray[1] = this.phaseVal;
        nvUuvVvuuNArray[2] = this.limitRef;
        nvUuvVvuuNArray[3] = this.paramRef;
        nvUuvVvuuNArray[4] = this.groupVal;
        nvUuvVvuuNArray[5] = this.layerVal;
        nvUuvVvuuNArray[6] = this.slotVal;
        nvUuvVvuuNArray[7] = this.themeVal;
        nvUuvVvuuNArray[8] = this.stageVal;
        nvUuvVvuuNArray[9] = this.widthRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        int n;
        float f;
        if (TargetPearlModule.mc.field_1724 == null || TargetPearlModule.mc.field_1687 == null || TargetPearlModule.mc.field_1761 == null) {
            return;
        }
        this.weightRef();
        if (this.speedRef > 0) {
            this.holderVal();
            return;
        }
        this.depthVal();
        class_1684 class_16842 = this.bufferVal();
        if (class_16842 == null) {
            return;
        }
        class_243 class_2432 = this.primaryVal(class_16842, this.primaryVal(class_16842));
        if (class_2432 == null) {
            return;
        }
        class_243 class_2433 = TargetPearlModule.mc.field_1724.method_33571().method_1023(0.0, 0.1, 0.0);
        WildClient modeVal = this.primaryVal(class_2433, class_2432);
        if (modeVal == null || modeVal.tertiaryVal > (double)this.groupVal.tertiaryVal()) {
            return;
        }
        if (this.phaseVal.tertiaryVal()) {
            f = this.limitRef.tertiaryVal();
            RotationController.primaryVal(new Rotation(modeVal.primaryVal, modeVal.secondaryVal), f, f, 6, 5);
        }
        if (this.modeRef.contains(class_16842.method_5628())) {
            return;
        }
        if (System.currentTimeMillis() - this.UuNnnVnuNNV < (long)this.layerVal.tertiaryVal()) {
            return;
        }
        if (this.phaseVal.tertiaryVal()) {
            f = new Rotation((class_1297)TargetPearlModule.mc.field_1724).primaryVal(new Rotation(modeVal.primaryVal, modeVal.secondaryVal));
            if (f > this.paramRef.tertiaryVal()) {
                return;
            }
        }
        if ((n = this.countVal()) == -1) {
            return;
        }
        this.primaryVal(n, modeVal, class_16842.method_5628());
        this.modeRef.add(class_16842.method_5628());
    }

    private void primaryVal(int n, WildClient modeVal, int n2) {
        this.entryVal = n;
        this.depthRef = n2;
        this.VUuuVUnun = modeVal.primaryVal;
        this.vVVuuVVv = modeVal.secondaryVal;
        this.guardVal = -1;
        this.countRef = 0;
        this.speedRef = 1;
        this.holderVal();
    }

    private void blockRef() {
        if (this.depthRef == -1 || TargetPearlModule.mc.field_1687 == null) {
            return;
        }
        class_1297 class_12972 = TargetPearlModule.mc.field_1687.method_8469(this.depthRef);
        if (!(class_12972 instanceof class_1684)) {
            return;
        }
        class_1684 class_16842 = (class_1684)class_12972;
        class_243 class_2433 = this.primaryVal(class_16842, this.primaryVal(class_16842));
        if (class_2433 == null) {
            return;
        }
        class_243 class_2432 = TargetPearlModule.mc.field_1724.method_33571().method_1023(0.0, 0.1, 0.0);
        WildClient modeVal = this.primaryVal(class_2432, class_2433);
        if (modeVal != null && modeVal.tertiaryVal <= (double)this.groupVal.tertiaryVal()) {
            this.VUuuVUnun = modeVal.primaryVal;
            this.vVVuuVVv = modeVal.secondaryVal;
        }
    }

    private void holderVal() {
        boolean bl = this.primaryVal(this.entryVal);
        if (!bl) {
            SprintModule.radiusVal = 2;
            TargetPearlModule.mc.field_1690.field_1867.method_23481(false);
            TargetPearlModule.mc.field_1724.method_5728(false);
            InputFreezeManager.primaryVal().primaryVal(sourceVal);
        }
        if (this.countRef > 0) {
            --this.countRef;
            return;
        }
        if (bl) {
            int n = this.secondaryVal(this.entryVal);
            switch (this.speedRef) {
                case 1: {
                    this.guardVal = TargetPearlModule.mc.field_1724.method_31548().method_67532();
                    if (this.guardVal != n) {
                        TargetPearlModule.mc.field_1724.method_31548().method_61496(n);
                    }
                    this.timerVal();
                    this.speedRef = 2;
                    this.countRef = 1;
                    break;
                }
                case 2: {
                    if (this.guardVal != n) {
                        TargetPearlModule.mc.field_1724.method_31548().method_61496(this.guardVal);
                    }
                    this.anchorVal();
                }
            }
            return;
        }
        switch (this.speedRef) {
            case 1: {
                this.speedRef = 2;
                this.countRef = 3;
                break;
            }
            case 2: {
                this.guardVal = TargetPearlModule.mc.field_1724.method_31548().method_67532();
                if (!TargetPearlModule.mc.field_1724.method_5624()) {
                    TargetPearlModule.mc.field_1761.method_2906(TargetPearlModule.mc.field_1724.field_7498.field_7763, this.entryVal, this.guardVal, class_1713.field_7791, (class_1657)TargetPearlModule.mc.field_1724);
                }
                this.speedRef = 3;
                this.countRef = 1;
                break;
            }
            case 3: {
                this.timerVal();
                this.speedRef = 4;
                this.countRef = 1;
                break;
            }
            case 4: {
                if (!TargetPearlModule.mc.field_1724.method_5624()) {
                    TargetPearlModule.mc.field_1761.method_2906(TargetPearlModule.mc.field_1724.field_7498.field_7763, this.entryVal, this.guardVal, class_1713.field_7791, (class_1657)TargetPearlModule.mc.field_1724);
                }
                if (mc.method_1562() != null) {
                    mc.method_1562().method_52787((class_2596)new class_2815(TargetPearlModule.mc.field_1724.field_7498.field_7763));
                }
                this.speedRef = 5;
                this.countRef = 1;
                break;
            }
            case 5: {
                InputFreezeManager.primaryVal().secondaryVal(sourceVal);
                this.anchorVal();
            }
        }
    }

    private void timerVal() {
        this.blockRef();
        this.VuunNUUUvu = TargetPearlModule.mc.field_1724.method_36454();
        this.NNUUNUuVNNVn = TargetPearlModule.mc.field_1724.method_36455();
        TargetPearlModule.mc.field_1724.method_36456(this.VUuuVUnun);
        TargetPearlModule.mc.field_1724.field_6241 = this.VUuuVUnun;
        TargetPearlModule.mc.field_1724.method_36457(this.vVVuuVVv);
        TargetPearlModule.mc.field_1761.method_2919((class_1657)TargetPearlModule.mc.field_1724, class_1268.field_5808);
        TargetPearlModule.mc.field_1724.method_6104(class_1268.field_5808);
        TargetPearlModule.mc.field_1724.method_36456(this.VuunNUUUvu);
        TargetPearlModule.mc.field_1724.field_6241 = this.VuunNUUUvu;
        TargetPearlModule.mc.field_1724.method_36457(this.NNUUNUuVNNVn);
    }

    private void anchorVal() {
        this.UuNnnVnuNNV = System.currentTimeMillis();
        this.speedRef = 0;
        this.countRef = 0;
        this.entryVal = -1;
        this.depthRef = -1;
        this.guardVal = -1;
    }

    private void weightRef() {
        this.levelVal.clear();
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (class_1297 class_12972 : TargetPearlModule.mc.field_1687.method_18112()) {
            if (!(class_12972 instanceof class_1684)) continue;
            class_1684 class_16842 = (class_1684)class_12972;
            int n = class_16842.method_5628();
            hashSet.add(n);
            class_243 class_2432 = class_16842.method_19538();
            class_243 class_2433 = this.heightRef.get(n);
            if (class_2433 == null) {
                if (TargetPearlModule.mc.field_1724.method_33571().method_1025(class_2432) < 9.0) {
                    this.angleVal.add(n);
                }
            }
            this.levelVal.put(n, class_2433 != null ? class_2432.method_1020(class_2433) : class_16842.method_18798());
            this.heightRef.put(n, class_2432);
        }
        this.heightRef.keySet().retainAll(hashSet);
        this.angleVal.retainAll(hashSet);
    }

    private class_243 primaryVal(class_1684 class_16842) {
        class_243 class_2432 = class_16842.method_18798();
        if (class_2432.method_1027() > 0.001) {
            return class_2432;
        }
        class_243 class_2433 = this.levelVal.get(class_16842.method_5628());
        return class_2433 != null ? class_2433 : class_2432;
    }

    private class_1684 bufferVal() {
        class_1684 class_16842 = null;
        double d = Double.MAX_VALUE;
        double d2 = this.extraRef.tertiaryVal() * this.extraRef.tertiaryVal();
        Iterator iterator = TargetPearlModule.mc.field_1687.method_18112().iterator();
        while (iterator.hasNext()) {
            class_1657 class_16572;
            class_1684 class_16843;
            class_1297 class_12972 = (class_1297)iterator.next();
            if (!(class_12972 instanceof class_1684) || this.primaryVal(class_16843 = (class_1684)class_12972).method_1027() < 0.001 || this.angleVal.contains(class_16843.method_5628())) continue;
            class_1297 class_12973 = class_16843.method_24921();
            class_1657 class_16573 = class_12973 instanceof class_1657 ? (class_16572 = (class_1657)class_12973) : null;
            if (class_16573 == TargetPearlModule.mc.field_1724) continue;
            if (class_16573 == null) {
                if (this.widthRef.tertiaryVal()) {
                    continue;
                }
            } else if (this.stageVal.tertiaryVal() && FriendCommand.primaryVal(class_16573.method_5477().getString())) continue;
            double d3 = TargetPearlModule.mc.field_1724.method_5858((class_1297)class_16843);
            if (d3 > d2 || !(d3 < d)) continue;
            d = d3;
            class_16842 = class_16843;
        }
        return class_16842;
    }

    private class_243 primaryVal(class_1684 class_16842, class_243 class_2432) {
        double d = class_16842.method_56989();
        if (d <= 0.0) {
            d = 0.03;
        }
        double d2 = class_16842.method_5799() ? 0.8 : 0.99;
        return this.primaryVal(class_16842.method_19538(), class_2432, d, d2, (class_1297)class_16842, 240);
    }

    private WildClient primaryVal(class_243 class_2432, class_243 class_2433) {
        WildClient modeVal;
        float f;
        float f2;
        double d = class_2433.field_1352 - class_2432.field_1352;
        double d2 = class_2433.field_1350 - class_2432.field_1350;
        float f3 = (float)Math.toDegrees(Math.atan2(-d, d2));
        WildClient nodeC = null;
        for (float f4 = -10.0f; f4 <= 10.0f; f4 += 2.0f) {
            f2 = f3 + f4;
            for (f = -90.0f; f <= 90.0f; f += 1.5f) {
                modeVal = this.primaryVal(class_2432, class_2433, f2, f);
                if (modeVal == null || nodeC != null && !(modeVal.tertiaryVal < nodeC.tertiaryVal)) continue;
                nodeC = modeVal;
            }
        }
        if (nodeC == null) {
            return null;
        }
        WildClient partE = nodeC;
        for (f2 = nodeC.primaryVal - 2.0f; f2 <= nodeC.primaryVal + 2.0f; f2 += 0.5f) {
            for (f = nodeC.secondaryVal - 2.0f; f <= nodeC.secondaryVal + 2.0f; f += 0.3f) {
                modeVal = this.primaryVal(class_2432, class_2433, f2, f);
                if (modeVal == null || !(modeVal.tertiaryVal < partE.tertiaryVal)) continue;
                partE = modeVal;
            }
        }
        return partE;
    }

    private WildClient primaryVal(class_243 class_2432, class_243 class_2433, float f, float f2) {
        class_243 class_2434 = this.primaryVal(f, f2);
        class_243 class_2435 = this.primaryVal(class_2432, class_2434, 0.03, 0.99, (class_1297)TargetPearlModule.mc.field_1724, 160);
        if (class_2435 == null) {
            return null;
        }
        double d = Math.sqrt(class_2435.method_1025(class_2433));
        return new WildClient(class_3532.method_15393((float)f), class_3532.method_15363((float)f2, (float)-90.0f, (float)90.0f), d);
    }

    private class_243 primaryVal(float f, float f2) {
        float f3 = f * ((float)Math.PI / 180);
        float f4 = f2 * ((float)Math.PI / 180);
        double d = -class_3532.method_15374((float)f3) * class_3532.method_15362((float)f4);
        double d2 = -class_3532.method_15374((float)f4);
        double d3 = class_3532.method_15362((float)f3) * class_3532.method_15362((float)f4);
        class_243 class_2432 = new class_243(d, d2, d3).method_1029().method_1021(1.5);
        class_243 class_2433 = TargetPearlModule.mc.field_1724.method_60478();
        return class_2432.method_1031(class_2433.field_1352, TargetPearlModule.mc.field_1724.method_24828() ? 0.0 : class_2433.field_1351, class_2433.field_1350);
    }

    private class_243 primaryVal(class_243 class_2432, class_243 class_2433, double d, double d2, class_1297 class_12973, int n) {
        if (TargetPearlModule.mc.field_1687 == null) {
            return null;
        }
        class_243 class_2434 = class_2432;
        class_243 class_2435 = class_2433;
        for (int i = 0; i < n; ++i) {
            class_2435 = class_2435.method_1023(0.0, d, 0.0).method_1021(d2);
            class_243 class_2436 = class_2434.method_1019(class_2435);
            class_3965 class_39652 = TargetPearlModule.mc.field_1687.method_17742(new class_3959(class_2434, class_2436, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, class_12973));
            if (class_39652.method_17783() != class_239.class_240.field_1333) {
                return class_39652.method_17784();
            }
            class_238 class_2383 = new class_238(class_2434, class_2436).method_1014(1.0);
            double d3 = Double.MAX_VALUE;
            class_243 class_2437 = null;
            for (class_1297 class_12974 : TargetPearlModule.mc.field_1687.method_8333(class_12973, class_2383, class_12972 -> class_12972.method_5805() && !class_12972.method_7325() && class_12972 instanceof class_1657)) {
                class_238 class_2384 = class_12974.method_5829().method_1014(0.3);
                Optional optional = class_2384.method_992(class_2434, class_2436);
                if (!optional.isPresent()) continue;
                double d4 = class_2434.method_1025((class_243)optional.get());
                if (!(d4 < d3)) continue;
                d3 = d4;
                class_2437 = (class_243)optional.get();
            }
            if (class_2437 != null) {
                return class_2437;
            }
            class_2434 = class_2436;
        }
        return class_2434;
    }

    private int countVal() {
        for (int i = 0; i < 36; ++i) {
            boolean bl;
            if (TargetPearlModule.mc.field_1724.method_31548().method_5438(i).method_7909() != class_1802.field_8634) continue;
            boolean bl2 = bl = i < 9;
            if (this.themeVal.tertiaryVal() && bl || this.slotVal.tertiaryVal() && !bl) continue;
            return bl ? i + 36 : i;
        }
        return -1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(int n) {
        if (n >= 0) {
            if (n <= 8) return true;
        }
        if (n < 36) return false;
        if (n > 44) return false;
        return true;
    }

    private int secondaryVal(int n) {
        if (n >= 0 && n <= 8) {
            return n;
        }
        if (n >= 36 && n <= 44) {
            return n - 36;
        }
        return -1;
    }

    private void depthVal() {
        if (this.modeRef.isEmpty()) {
            return;
        }
        this.modeRef.removeIf(n -> TargetPearlModule.mc.field_1687.method_8469(n.intValue()) == null);
    }

    @Override
    public void onDisable() {
        if (this.speedRef > 0 && !this.primaryVal(this.entryVal)) {
            InputFreezeManager.primaryVal().secondaryVal(sourceVal);
        }
        this.modeRef.clear();
        this.angleVal.clear();
        this.heightRef.clear();
        this.levelVal.clear();
        this.speedRef = 0;
        this.countRef = 0;
        this.entryVal = -1;
        this.depthRef = -1;
        MouseLookOverride.primaryVal = MouseLookOverride.secondaryVal;
        super.onDisable();
    }

    static final class WildClient {
        final float primaryVal;
        final float secondaryVal;
        final double tertiaryVal;

        WildClient(float f, float f2, double d) {
            this.primaryVal = f;
            this.secondaryVal = f2;
            this.tertiaryVal = d;
        }
    }
}

