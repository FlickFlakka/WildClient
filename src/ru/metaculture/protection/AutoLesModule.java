/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1747
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2596
 *  net.minecraft.class_2626
 *  net.minecraft.class_2680
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 *  net.minecraft.class_2885
 *  net.minecraft.class_3481
 */
package ru.metaculture.protection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_1747;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2596;
import net.minecraft.class_2626;
import net.minecraft.class_2680;
import net.minecraft.class_2846;
import net.minecraft.class_2885;
import net.minecraft.class_3481;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.RequiresRole;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@RequiresRole(tertiaryVal={"lichoday"})
@ModuleRegister(primaryVal="AutoLes", tertiaryVal=ModuleCategory.Player, secondaryVal="Automatically farms wood for you and earns on ReallyWorld")
public class AutoLesModule
extends Module {
    public final FloatSetting countVal = new FloatSetting("Radius", 4.0f, 1.0f, 6.0f, 0.5f, false);
    public final BoolSetting depthVal = new BoolSetting("Wave hand", true);
    public final BoolSetting descRef = new BoolSetting("Auto-change", true);
    public final BoolSetting activeVal = new BoolSetting("AutoPay", false);
    public final StringFilterSetting radiusVal = new StringFilterSetting("Nickname for money transfer", "");
    public final FloatSetting factorVal = new FloatSetting("Coin amount", 1000.0f, 500.0f, 25000.0f, 1000.0f, false).primaryVal(() -> !this.activeVal.tertiaryVal());
    public final FloatSetting sourceVal = new FloatSetting("Schedule/s", 20.0f, 1.0f, 60.0f, 1.0f, false);
    private final Map<class_2338, class_2680> extraRef = new ConcurrentHashMap<class_2338, class_2680>();
    private final Map<class_2338, Long> phaseVal = new ConcurrentHashMap<class_2338, Long>();
    private final Set<class_2338> limitRef = ConcurrentHashMap.newKeySet();
    private long paramRef = 0L;
    private long groupVal = 0L;
    private long layerVal = 0L;
    private class_2338 slotVal = null;

    public AutoLesModule() {
        Setting[] nvUuvVvuuNArray = new Setting[7];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        nvUuvVvuuNArray[5] = this.factorVal;
        nvUuvVvuuNArray[6] = this.sourceVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.timerVal();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.holderVal();
        this.timerVal();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (AutoLesModule.mc.field_1724 == null || AutoLesModule.mc.field_1687 == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (this.descRef.tertiaryVal()) {
            if ((float)(l - this.paramRef) > this.sourceVal.tertiaryVal() * 500.0f) {
                mc.method_1562().method_45730("sellwood");
                this.paramRef = l;
            }
        }
        if (this.activeVal.tertiaryVal() && (float)(l - this.groupVal) > this.sourceVal.tertiaryVal() * 500.0f + 200.0f) {
            mc.method_1562().method_45730("pay " + this.radiusVal.tertiaryVal() + " " + (int)this.factorVal.tertiaryVal());
            this.groupVal = l;
        }
        this.primaryVal(l);
        this.secondaryVal(l);
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        block9: {
            class_2596<?> class_25962;
            block7: {
                class_2846 class_28462;
                block8: {
                    if (AutoLesModule.mc.field_1724 == null || AutoLesModule.mc.field_1687 == null) {
                        return;
                    }
                    class_25962 = uvUUuvnunU2.marginVal();
                    if (!(class_25962 instanceof class_2846)) break block7;
                    class_28462 = (class_2846)class_25962;
                    if (class_28462.method_12363() == class_2846.class_2847.field_12973) break block8;
                    if (class_28462.method_12363() != class_2846.class_2847.field_12968) break block9;
                }
                this.tertiaryVal(class_28462.method_12362());
                break block9;
            }
            class_25962 = uvUUuvnunU2.marginVal();
            if (class_25962 instanceof class_2885) {
                class_2885 class_28852 = (class_2885)class_25962;
                if (AutoLesModule.mc.field_1724.method_5998(class_28852.method_12546()).method_7909() instanceof class_1747) {
                    class_2338 class_23382 = class_28852.method_12543().method_17777().method_10093(class_28852.method_12543().method_17780());
                    this.limitRef.add(class_23382);
                    this.extraRef.remove(class_23382);
                    this.phaseVal.remove(class_23382);
                }
            } else {
                class_25962 = uvUUuvnunU2.marginVal();
                if (class_25962 instanceof class_2626) {
                    class_2626 class_26262 = (class_2626)class_25962;
                    this.primaryVal(uvUUuvnunU2, class_26262);
                }
            }
        }
    }

    private void primaryVal(long l) {
        if (this.slotVal != null) {
            if (!this.primaryVal(this.slotVal) || !this.secondaryVal(this.slotVal)) {
                this.slotVal = null;
            }
        }
        if (this.slotVal == null) {
            this.blockRef();
        }
        if (this.slotVal != null && l - this.layerVal > 0L) {
            mc.method_1562().method_52787((class_2596)new class_2846(class_2846.class_2847.field_12968, this.slotVal, class_2350.field_11036));
            mc.method_1562().method_52787((class_2596)new class_2846(class_2846.class_2847.field_12973, this.slotVal, class_2350.field_11033));
            this.layerVal = l;
        }
    }

    private void blockRef() {
        int n = (int)this.countVal.tertiaryVal();
        class_2338 class_23382 = AutoLesModule.mc.field_1724.method_24515();
        double d = Double.MAX_VALUE;
        class_2338 class_23383 = null;
        Iterator iterator = class_2338.method_10097((class_2338)class_23382.method_10069(-n, -n, -n), (class_2338)class_23382.method_10069(n, n, n)).iterator();
        while (iterator.hasNext()) {
            class_2338 class_23384 = (class_2338)iterator.next();
            if (!this.primaryVal(class_23384)) continue;
            double d2 = AutoLesModule.mc.field_1724.method_5707(class_23384.method_46558());
            if (!(d2 <= (double)(n * n))) continue;
            if (!(d2 < d)) continue;
            d = d2;
            class_23383 = class_23384.method_10062();
        }
        this.slotVal = class_23383;
    }

    private boolean primaryVal(class_2338 class_23382) {
        return AutoLesModule.mc.field_1687.method_8320(class_23382).method_26164(class_3481.field_15475);
    }

    private boolean secondaryVal(class_2338 class_23382) {
        float f = this.countVal.tertiaryVal();
        return AutoLesModule.mc.field_1724.method_5707(class_23382.method_46558()) <= (double)(f * f);
    }

    private void tertiaryVal(class_2338 class_23382) {
        class_2680 class_26802 = AutoLesModule.mc.field_1687.method_8320(class_23382);
        if (!class_26802.method_26215()) {
            this.extraRef.put(class_23382, class_26802);
            this.phaseVal.put(class_23382, System.currentTimeMillis());
            this.primaryVal(class_23382, class_26802);
        }
    }

    private void primaryVal(PacketEvent uvUUuvnunU2, class_2626 class_26262) {
        block5: {
            class_2680 class_26802;
            class_2338 class_23382;
            block3: {
                class_2680 class_26803;
                block4: {
                    class_23382 = class_26262.method_11309();
                    class_26802 = class_26262.method_11308();
                    if (!this.extraRef.containsKey(class_23382)) break block3;
                    class_26803 = this.extraRef.get(class_23382);
                    if (class_26802.method_26215()) break block4;
                    if (class_26802.equals((Object)class_26803)) break block5;
                }
                uvUUuvnunU2.secondaryVal();
                this.primaryVal(class_23382, class_26803);
                break block5;
            }
            if (this.limitRef.contains(class_23382) && class_26802.method_26215()) {
                uvUUuvnunU2.secondaryVal();
                mc.execute(() -> {
                    if (AutoLesModule.mc.field_1687 != null) {
                        AutoLesModule.mc.field_1687.method_8652(class_23382, AutoLesModule.mc.field_1687.method_8320(class_23382), 0);
                    }
                });
            }
        }
    }

    private void secondaryVal(long l) {
        this.extraRef.forEach((class_23382, class_26802) -> {
            class_2680 class_26803 = AutoLesModule.mc.field_1687.method_8320(class_23382);
            if (!class_26803.equals(class_26802)) {
                AutoLesModule.mc.field_1687.method_8652(class_23382, class_26802, 0);
                if (!class_26803.method_26215()) {
                    this.phaseVal.put((class_2338)class_23382, l);
                }
            }
            class_2350[] class_2350Array = class_2350.values();
            int n = class_2350Array.length;
            for (int i = 0; i < n; ++i) {
                class_2350 class_23502 = class_2350Array[i];
                class_2338 class_23383 = class_23382.method_10093(class_23502);
                if (!this.extraRef.containsKey(class_23383)) continue;
                class_2680 class_26804 = this.extraRef.get(class_23383);
                if (AutoLesModule.mc.field_1687.method_8320(class_23383).equals((Object)class_26804)) continue;
                AutoLesModule.mc.field_1687.method_8652(class_23383, class_26804, 0);
            }
        });
        this.phaseVal.entrySet().removeIf(entry -> {
            if (l - (Long)entry.getValue() > 300000L) {
                this.extraRef.remove(entry.getKey());
                return true;
            }
            return false;
        });
    }

    private void primaryVal(class_2338 class_23382, class_2680 class_26802) {
        mc.execute(() -> {
            if (AutoLesModule.mc.field_1687 != null) {
                AutoLesModule.mc.field_1687.method_8652(class_23382, class_26802, 0);
            }
        });
    }

    private void holderVal() {
        if (AutoLesModule.mc.field_1687 == null) {
            return;
        }
        mc.execute(() -> {
            for (class_2338 class_23382 : this.extraRef.keySet()) {
                AutoLesModule.mc.field_1687.method_8652(class_23382, class_2246.field_10124.method_9564(), 0);
            }
        });
    }

    private void timerVal() {
        this.slotVal = null;
        this.paramRef = 0L;
        this.groupVal = 0L;
        this.layerVal = 0L;
        this.extraRef.clear();
        this.limitRef.clear();
        this.phaseVal.clear();
    }
}

