/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1291
 *  net.minecraft.class_1293
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1703
 *  net.minecraft.class_1706
 *  net.minecraft.class_1713
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1844
 *  net.minecraft.class_2246
 *  net.minecraft.class_2248
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2382
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_2596
 *  net.minecraft.class_2855
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_471
 *  net.minecraft.class_6880
 *  net.minecraft.class_9334
 */
package ru.metaculture.protection;

import java.util.Random;
import java.util.function.Predicate;
import net.minecraft.class_1268;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1703;
import net.minecraft.class_1706;
import net.minecraft.class_1713;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1844;
import net.minecraft.class_2246;
import net.minecraft.class_2248;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2382;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2855;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_471;
import net.minecraft.class_6880;
import net.minecraft.class_9334;
import org.wild.mixin.acceser.ClientPlayerInteractionManagerAccessor;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.RotationController;
import ru.metaculture.protection.MouseLookOverride;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Rotation;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="PotionCombiner", tertiaryVal=ModuleCategory.Misc, secondaryVal="Automatically combines potions in an anvil")
public class PotionCombinerModule
extends Module {
    private static final String activeVal = "Strength";
    private static final String radiusVal = "Speed";
    private static final String factorVal = "Speed 3 + Strength 3";
    private static final String sourceVal = "Strength 3 + Speed 3";
    private static final float extraRef = 0.92f;
    private static final float phaseVal = 0.005f;
    private static final float limitRef = 0.02f;
    private static final int paramRef = 6;
    private static final double groupVal = 4.6;
    public final ModeSetting countVal = new ModeSetting("Potion", "Strength", "Strength", "Speed", "Speed 3 + Strength 3", "Strength 3 + Speed 3");
    public final FloatSetting depthVal = new FloatSetting("Level", 5.0f, 1.0f, 30.0f, 1.0f, false);
    public final BoolSetting descRef = new BoolSetting("Experience savings", true);
    private final VuNvNNvVV layerVal = new VuNvNNvVV();
    private final VuNvNNvVV slotVal = new VuNvNNvVV();
    private final VuNvNNvVV themeVal = new VuNvNNvVV();
    private final VuNvNNvVV stageVal = new VuNvNNvVV();
    private final Random widthRef = new Random();
    private boolean trackVal;
    private int modeRef = 8;
    private int angleVal = 300;
    private int heightRef = 220;
    private int levelVal = -1;
    private int UuNnnVnuNNV = -1;
    private float depthRef;
    private String speedRef = "";
    private int countRef;

    public PotionCombinerModule() {
        Setting[] nvUuvVvuuNArray = new Setting[3];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.speedRef = "";
        this.stageVal.secondaryVal(-10000L);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        class_1703 class_17032;
        block10: {
            block9: {
                if (PotionCombinerModule.mc.field_1724 == null || PotionCombinerModule.mc.field_1687 == null) break block9;
                if (PotionCombinerModule.mc.field_1761 != null) break block10;
            }
            this.marginVal(false);
            return;
        }
        if (this.trackVal) {
            this.weightRef();
            return;
        }
        if (PotionCombinerModule.mc.field_1724.field_7520 < this.descRef()) {
            if (this.countVal() != -1) {
                this.anchorVal();
            } else {
                this.tertiaryVal("§cNo experience bottles. Need to reach level " + this.descRef() + ".");
            }
            return;
        }
        if (PotionCombinerModule.mc.field_1755 instanceof class_471 && (class_17032 = PotionCombinerModule.mc.field_1724.field_7512) instanceof class_1706) {
            class_1706 class_17062 = (class_1706)class_17032;
            this.primaryVal(class_17062);
            return;
        }
        if (PotionCombinerModule.mc.field_1755 == null) {
            this.blockRef();
        }
    }

    private void blockRef() {
        class_2338 class_23382;
        block7: {
            block6: {
                class_23382 = this.tertiaryVal(6);
                if (class_23382 == null) {
                    this.secondaryVal("§cNo anvil found within 6 blocks.");
                    return;
                }
                class_243 class_2432 = new class_243((double)class_23382.method_10263() + 0.5, (double)class_23382.method_10264() + 0.9, (double)class_23382.method_10260() + 0.5);
                class_243 class_2433 = this.primaryVal(class_2432, 0.02f);
                Rotation uuUuvNuNVNVU2 = this.primaryVal(class_2433);
                float f = 55.0f + this.primaryVal(-2.0f, 2.0f);
                RotationController.primaryVal(uuUuvNuNVNVU2, f * 0.92f, f * 0.92f, 25.0f, 25.0f, 2, 30, false);
                if (!this.themeVal.primaryVal((long)this.modeRef)) {
                    return;
                }
                Rotation uuUuvNuNVNVU3 = new Rotation((class_1297)PotionCombinerModule.mc.field_1724);
                if (uuUuvNuNVNVU3.primaryVal(uuUuvNuNVNVU2) > 4.0f) {
                    return;
                }
                if (!this.primaryVal(class_2433, 4.6)) break block6;
                if (this.primaryVal(class_23382, class_2433)) break block7;
            }
            return;
        }
        class_3965 class_39652 = new class_3965(this.primaryVal(class_243.method_24953((class_2382)class_23382), 0.08f), class_2350.field_11036, class_23382, false);
        PotionCombinerModule.mc.field_1724.method_6104(class_1268.field_5808);
        PotionCombinerModule.mc.field_1761.method_2896(PotionCombinerModule.mc.field_1724, class_1268.field_5808, class_39652);
        this.themeVal.primaryVal();
        this.modeRef = this.primaryVal(0, 1);
    }

    private void primaryVal(class_1706 class_17062) {
        if (this.paramVal(class_17062)) {
            return;
        }
        if (this.slotVal.primaryVal((long)this.heightRef) && this.weightVal(class_17062)) {
            return;
        }
        this.secondaryVal(class_17062);
        if (PotionCombinerModule.mc.field_1724.field_7520 < this.descRef()) {
            this.anchorVal();
            return;
        }
        if (this.marginVal(class_17062) && class_17062.method_7611(2).method_7681()) {
            if (this.slotVal.primaryVal((long)this.heightRef)) {
                if (this.descRef.tertiaryVal()) {
                    this.extraVal(class_17062);
                }
                PotionCombinerModule.mc.field_1761.method_2906(class_17062.field_7763, 2, 0, class_1713.field_7794, (class_1657)PotionCombinerModule.mc.field_1724);
                this.slotVal.primaryVal();
                this.heightRef = this.primaryVal(85, 120);
            }
        }
    }

    private void secondaryVal(class_1706 class_17062) {
        int n;
        if (!this.slotVal.primaryVal((long)this.heightRef)) {
            return;
        }
        if (this.activeVal()) {
            this.tertiaryVal(class_17062);
            return;
        }
        for (n = 0; n < 2; ++n) {
            class_1799 class_17992 = this.secondaryVal(class_17062, n);
            if (class_17992.method_7960() || this.primaryVal(class_17992)) continue;
            this.primaryVal(class_17062, n);
            this.depthVal();
            return;
        }
        for (n = 0; n < 2; ++n) {
            if (!this.secondaryVal(class_17062, n).method_7960()) continue;
            int n2 = this.secondaryVal(class_17062, this::primaryVal);
            if (n2 != -1) {
                this.primaryVal(class_17062, n2, n);
                this.depthVal();
            }
            return;
        }
    }

    private void tertiaryVal(class_1706 class_17062) {
        int n;
        for (n = 0; n < 2; ++n) {
            class_1799 class_17992 = this.secondaryVal(class_17062, n);
            if (class_17992.method_7960() || this.primaryVal(class_17992, n)) continue;
            this.primaryVal(class_17062, n);
            this.depthVal();
            return;
        }
        for (n = 0; n < 2; ++n) {
            if (!this.secondaryVal(class_17062, n).method_7960()) continue;
            int n2 = this.secondaryVal(class_17062, this.primaryVal(n));
            if (n2 != -1) {
                this.primaryVal(class_17062, n2, n);
                this.depthVal();
            }
            return;
        }
    }

    private boolean marginVal(class_1706 class_17062) {
        class_1799 class_17992 = this.secondaryVal(class_17062, 0);
        class_1799 class_17993 = this.secondaryVal(class_17062, 1);
        if (this.activeVal()) {
            return this.primaryVal(class_17992, 0) && this.primaryVal(class_17993, 1);
        }
        return this.primaryVal(class_17992) && this.primaryVal(class_17993);
    }

    private boolean weightVal(class_1706 class_17062) {
        if (this.activeVal()) {
            if (this.primaryVal(class_17062, this::secondaryVal) <= 0) {
                this.tertiaryVal("§cMissing ingredient: Speed III.");
                return true;
            }
            if (this.primaryVal(class_17062, this::tertiaryVal) <= 0) {
                this.tertiaryVal("§cMissing ingredient: Strength III.");
                return true;
            }
            return false;
        }
        int n = this.primaryVal(class_17062, this::primaryVal);
        if (n < 2) {
            this.tertiaryVal("§cMissing ingredient: " + this.holderVal() + " x" + (2 - n) + ".");
            return true;
        }
        return false;
    }

    private boolean paramVal(class_1706 class_17062) {
        for (int i = 0; i < 2; ++i) {
            class_1799 class_17992 = this.secondaryVal(class_17062, i);
            if (class_17992.method_7960()) continue;
            if (class_17992.method_7947() <= 1) continue;
            if (this.slotVal.primaryVal((long)this.heightRef)) {
                this.primaryVal(class_17062, i);
                this.depthVal();
            }
            return true;
        }
        return false;
    }

    private int primaryVal(class_1706 class_17062, Predicate<class_1799> predicate) {
        int n = 0;
        for (int i = 0; i < class_17062.field_7761.size(); ++i) {
            if (i == 2) continue;
            class_1799 class_17992 = class_17062.method_7611(i).method_7677();
            if (!predicate.test(class_17992)) continue;
            n += Math.max(1, class_17992.method_7947());
        }
        return n;
    }

    private String holderVal() {
        if (this.countVal.secondaryVal(activeVal)) {
            return "Strength II";
        }
        if (this.countVal.secondaryVal(radiusVal)) {
            return "Speed II";
        }
        return "potion";
    }

    private boolean primaryVal(class_1799 class_17992) {
        if (this.countVal.secondaryVal(activeVal)) {
            return this.primaryVal(class_17992, (class_6880<class_1291>)class_1294.field_5910, 2);
        }
        if (this.countVal.secondaryVal(radiusVal)) {
            return this.primaryVal(class_17992, (class_6880<class_1291>)class_1294.field_5904, 2);
        }
        return this.secondaryVal(class_17992) || this.tertiaryVal(class_17992);
    }

    private boolean primaryVal(class_1799 class_17992, int n) {
        return this.secondaryVal(n) ? this.secondaryVal(class_17992) : this.tertiaryVal(class_17992);
    }

    private Predicate<class_1799> primaryVal(int n) {
        return this.secondaryVal(n) ? this::secondaryVal : this::tertiaryVal;
    }

    private boolean secondaryVal(int n) {
        boolean bl = this.countVal.secondaryVal(factorVal);
        return n == 0 ? bl : !bl;
    }

    private boolean primaryVal(class_1799 class_17992, class_6880<class_1291> class_68802, int n) {
        if (!this.marginVal(class_17992)) {
            return false;
        }
        class_1844 class_18442 = (class_1844)class_17992.method_58694(class_9334.field_49651);
        if (class_18442 == null) {
            return false;
        }
        for (class_1293 class_12932 : class_18442.method_57397()) {
            if (!class_12932.method_5579().equals(class_68802)) continue;
            if (class_12932.method_5578() != n - 1) continue;
            return true;
        }
        return false;
    }

    private boolean secondaryVal(class_1799 class_17992) {
        return this.primaryVal(class_17992, (class_6880<class_1291>)class_1294.field_5904, 3) && !this.primaryVal(class_17992, (class_6880<class_1291>)class_1294.field_5910, 3);
    }

    private boolean tertiaryVal(class_1799 class_17992) {
        return this.primaryVal(class_17992, (class_6880<class_1291>)class_1294.field_5910, 3) && !this.primaryVal(class_17992, (class_6880<class_1291>)class_1294.field_5904, 3);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean marginVal(class_1799 class_17992) {
        if (class_17992 == null) return false;
        if (class_17992.method_7960()) return false;
        if (class_17992.method_31574(class_1802.field_8574)) return true;
        if (class_17992.method_31574(class_1802.field_8436)) return true;
        if (!class_17992.method_31574(class_1802.field_8150)) return false;
        return true;
    }

    private int secondaryVal(class_1706 class_17062, Predicate<class_1799> predicate) {
        for (int i = 3; i < class_17062.field_7761.size(); ++i) {
            class_1799 class_17992 = class_17062.method_7611(i).method_7677();
            if (!predicate.test(class_17992)) continue;
            return i;
        }
        return -1;
    }

    private void primaryVal(class_1706 class_17062, int n, int n2) {
        PotionCombinerModule.mc.field_1761.method_2906(class_17062.field_7763, n, 0, class_1713.field_7790, (class_1657)PotionCombinerModule.mc.field_1724);
        PotionCombinerModule.mc.field_1761.method_2906(class_17062.field_7763, n2, 1, class_1713.field_7790, (class_1657)PotionCombinerModule.mc.field_1724);
        PotionCombinerModule.mc.field_1761.method_2906(class_17062.field_7763, n, 0, class_1713.field_7790, (class_1657)PotionCombinerModule.mc.field_1724);
    }

    private void primaryVal(class_1706 class_17062, int n) {
        PotionCombinerModule.mc.field_1761.method_2906(class_17062.field_7763, n, 0, class_1713.field_7794, (class_1657)PotionCombinerModule.mc.field_1724);
    }

    private void extraVal(class_1706 class_17062) {
        if (PotionCombinerModule.mc.field_1724 == null || PotionCombinerModule.mc.field_1724.field_3944 == null) {
            return;
        }
        String string = this.limitVal(class_17062);
        for (int i = 0; i < 10; ++i) {
            String string2 = i % 2 == 0 ? string + this.timerVal() : string;
            class_17062.method_7625(string2);
            PotionCombinerModule.mc.field_1724.field_3944.method_52787((class_2596)new class_2855(string2));
        }
    }

    private String limitVal(class_1706 class_17062) {
        class_1799 class_17992 = this.secondaryVal(class_17062, 0);
        if (!class_17992.method_7960()) {
            return this.primaryVal(class_17992.method_7964().getString());
        }
        class_1799 class_17993 = this.secondaryVal(class_17062, 2);
        if (!class_17993.method_7960()) {
            return this.primaryVal(class_17993.method_7964().getString());
        }
        return "Potion";
    }

    private String timerVal() {
        ++this.countRef;
        return "_" + Integer.toString(this.countRef, 36) + Integer.toString(this.widthRef.nextInt(1296), 36);
    }

    private String primaryVal(String string) {
        if (string == null || string.isBlank()) {
            return "Potion";
        }
        return string.length() > 32 ? string.substring(0, 32) : string;
    }

    private class_1799 secondaryVal(class_1706 class_17062, int n) {
        block3: {
            block2: {
                if (class_17062 == null || n < 0) break block2;
                if (n < class_17062.field_7761.size()) break block3;
            }
            return class_1799.field_8037;
        }
        return class_17062.method_7611(n).method_7677();
    }

    private void anchorVal() {
        this.trackVal = true;
        this.levelVal = PotionCombinerModule.mc.field_1724.method_31548().method_67532();
        this.depthRef = PotionCombinerModule.mc.field_1724.method_36455();
        this.layerVal.primaryVal();
    }

    private void weightRef() {
        if (PotionCombinerModule.mc.field_1724.field_7520 >= this.descRef()) {
            this.tertiaryVal(true);
            return;
        }
        if (PotionCombinerModule.mc.field_1755 != null) {
            PotionCombinerModule.mc.field_1724.method_7346();
            return;
        }
        float f = 87.0f + this.primaryVal(-0.7f, 0.7f);
        PotionCombinerModule.mc.field_1724.method_36457(PotionCombinerModule.secondaryVal(f));
        if (!this.bufferVal()) {
            this.tertiaryVal(true);
            this.tertiaryVal("§cNo experience bottles. Need to reach level " + this.descRef() + ".");
            return;
        }
        if (!this.layerVal.primaryVal((long)this.angleVal)) {
            return;
        }
        PotionCombinerModule.mc.field_1761.method_2919((class_1657)PotionCombinerModule.mc.field_1724, class_1268.field_5808);
        PotionCombinerModule.mc.field_1724.method_6104(class_1268.field_5808);
        this.layerVal.primaryVal();
        this.angleVal = this.primaryVal(50, 70);
    }

    private boolean bufferVal() {
        if (PotionCombinerModule.mc.field_1724.method_6047().method_31574(class_1802.field_8287)) {
            return true;
        }
        int n = this.countVal();
        if (n == -1) {
            return false;
        }
        if (n >= 36 && n <= 44) {
            PotionCombinerModule.mc.field_1724.method_31548().method_61496(n - 36);
            ((ClientPlayerInteractionManagerAccessor)PotionCombinerModule.mc.field_1761).invokeSyncSelectedSlot();
            return true;
        }
        if (this.levelVal < 0) {
            this.levelVal = PotionCombinerModule.mc.field_1724.method_31548().method_67532();
        }
        this.UuNnnVnuNNV = n;
        PotionCombinerModule.mc.field_1761.method_2906(PotionCombinerModule.mc.field_1724.field_7498.field_7763, n, this.levelVal, class_1713.field_7791, (class_1657)PotionCombinerModule.mc.field_1724);
        ((ClientPlayerInteractionManagerAccessor)PotionCombinerModule.mc.field_1761).invokeSyncSelectedSlot();
        return true;
    }

    private int countVal() {
        if (PotionCombinerModule.mc.field_1724 == null) {
            return -1;
        }
        for (int i = 9; i <= 44; ++i) {
            if (!PotionCombinerModule.mc.field_1724.field_7498.method_7611(i).method_7677().method_31574(class_1802.field_8287)) continue;
            return i;
        }
        return -1;
    }

    private void tertiaryVal(boolean bl) {
        if (bl && PotionCombinerModule.mc.field_1724 != null && PotionCombinerModule.mc.field_1761 != null) {
            if (this.UuNnnVnuNNV != -1 && this.levelVal >= 0) {
                PotionCombinerModule.mc.field_1761.method_2906(PotionCombinerModule.mc.field_1724.field_7498.field_7763, this.UuNnnVnuNNV, this.levelVal, class_1713.field_7791, (class_1657)PotionCombinerModule.mc.field_1724);
            }
            if (this.levelVal >= 0) {
                PotionCombinerModule.mc.field_1724.method_31548().method_61496(this.levelVal);
                ((ClientPlayerInteractionManagerAccessor)PotionCombinerModule.mc.field_1761).invokeSyncSelectedSlot();
            }
            PotionCombinerModule.mc.field_1724.method_36457(this.depthRef);
        }
        this.trackVal = false;
        this.UuNnnVnuNNV = -1;
        this.levelVal = -1;
    }

    private class_2338 tertiaryVal(int n) {
        class_2338 class_23382 = PotionCombinerModule.mc.field_1724.method_24515();
        class_243 class_2432 = PotionCombinerModule.mc.field_1724.method_33571();
        class_2338 class_23383 = null;
        double d = Double.MAX_VALUE;
        for (int i = -n; i <= n; ++i) {
            for (int j = -2; j <= 2; ++j) {
                for (int k = -n; k <= n; ++k) {
                    class_2338 class_23384 = class_23382.method_10069(i, j, k);
                    class_2248 class_22482 = PotionCombinerModule.mc.field_1687.method_8320(class_23384).method_26204();
                    if (!this.primaryVal(class_22482)) continue;
                    class_243 class_2433 = new class_243((double)class_23384.method_10263() + 0.5, (double)class_23384.method_10264() + 0.9, (double)class_23384.method_10260() + 0.5);
                    double d2 = class_2432.method_1025(class_2433);
                    if (!(d2 < d)) continue;
                    d = d2;
                    class_23383 = class_23384.method_10062();
                }
            }
        }
        return class_23383;
    }

    private boolean primaryVal(class_2248 class_22482) {
        return class_22482 == class_2246.field_10535 || class_22482 == class_2246.field_10105 || class_22482 == class_2246.field_10414;
    }

    private boolean primaryVal(class_2338 class_23382, class_243 class_2432) {
        class_243 class_2433 = PotionCombinerModule.mc.field_1724.method_33571();
        class_3965 class_39652 = PotionCombinerModule.mc.field_1687.method_17742(new class_3959(class_2433, class_2432, class_3959.class_3960.field_17559, class_3959.class_242.field_1348, (class_1297)PotionCombinerModule.mc.field_1724));
        return class_39652.method_17783() == class_239.class_240.field_1332 && class_39652.method_17777().equals((Object)class_23382);
    }

    private boolean primaryVal(class_243 class_2432, double d) {
        return PotionCombinerModule.mc.field_1724.method_33571().method_1025(class_2432) <= d * d;
    }

    private Rotation primaryVal(class_243 class_2432) {
        class_243 class_2433 = PotionCombinerModule.mc.field_1724.method_33571();
        double d = class_2432.field_1352 - class_2433.field_1352;
        double d2 = class_2432.field_1351 - class_2433.field_1351;
        double d3 = class_2432.field_1350 - class_2433.field_1350;
        double d4 = Math.hypot(d, d3);
        float f = (float)Math.toDegrees(Math.atan2(d3, d)) - 90.0f;
        float f2 = (float)(-Math.toDegrees(Math.atan2(d2, d4)));
        f += this.primaryVal(-0.03f, 0.03f);
        f2 += this.primaryVal(-0.03f, 0.03f);
        return new Rotation(PotionCombinerModule.primaryVal(f), PotionCombinerModule.secondaryVal(f2));
    }

    private class_243 primaryVal(class_243 class_2432, float f) {
        return new class_243(class_2432.field_1352 + (double)this.primaryVal(-f, f), class_2432.field_1351 + (double)this.primaryVal(-f * 0.5f, f * 0.5f), class_2432.field_1350 + (double)this.primaryVal(-f, f));
    }

    private void depthVal() {
        this.slotVal.primaryVal();
        this.heightRef = this.primaryVal(85, 120);
    }

    private void secondaryVal(String string) {
        block5: {
            block4: {
                if (string == null || string.isBlank()) {
                    return;
                }
                if (!string.equals(this.speedRef)) break block4;
                if (!this.stageVal.primaryVal(2500L)) break block5;
            }
            ChatLogger.primaryVal("\u00a78[\u00a7dPotionCombiner\u00a78] \u00a7f" + string);
            this.speedRef = string;
            this.stageVal.primaryVal();
        }
    }

    private void tertiaryVal(String string) {
        this.secondaryVal(string);
        if (this.enabled) {
            this.toggle();
        }
    }

    private int descRef() {
        return Math.max(1, Math.round(this.depthVal.tertiaryVal()));
    }

    private boolean activeVal() {
        return this.countVal.secondaryVal(factorVal) || this.countVal.secondaryVal(sourceVal);
    }

    private float primaryVal(float f, float f2) {
        return f + (f2 - f) * this.widthRef.nextFloat();
    }

    private int primaryVal(int n, int n2) {
        return n + this.widthRef.nextInt(Math.max(1, n2 - n + 1));
    }

    private static float primaryVal(float f) {
        if ((f %= 360.0f) >= 180.0f) {
            f -= 360.0f;
        }
        if (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    private static float secondaryVal(float f) {
        return Math.max(-90.0f, Math.min(90.0f, f));
    }

    private void marginVal(boolean bl) {
        this.tertiaryVal(bl);
        RotationController.primaryVal = RotationController.VvunVVUvUNnv.IDLE;
        RotationController.paramVal = 0;
        RotationController.speedVal = null;
        MouseLookOverride.primaryVal = false;
    }

    @Override
    public void onDisable() {
        this.marginVal(true);
        super.onDisable();
    }
}

