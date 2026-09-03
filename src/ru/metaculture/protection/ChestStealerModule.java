/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1703
 *  net.minecraft.class_1707
 *  net.minecraft.class_1713
 *  net.minecraft.class_1716
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_238
 *  net.minecraft.class_437
 *  net.minecraft.class_476
 *  net.minecraft.class_480
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1703;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1716;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_238;
import net.minecraft.class_437;
import net.minecraft.class_476;
import net.minecraft.class_480;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.GameContextUtils;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="ChestStealer", secondaryVal="Loots items from chests", tertiaryVal=ModuleCategory.Player)
public class ChestStealerModule
extends Module {
    public static BoolSetting countVal = new BoolSetting("Remove players", false);
    public final ModeSetting depthVal;
    private static final int descRef = 9;
    private static final double activeVal = 0.5;
    private static final double radiusVal = 1.0;
    private final Random factorVal;

    public ChestStealerModule() {
        String[] stringArray = new String[2];
        stringArray[0] = "Normal";
        stringArray[1] = "FunTime Event";
        this.depthVal = new ModeSetting("Operating mode", "Normal", stringArray);
        this.factorVal = new Random();
        this.addSettings(countVal, this.depthVal);
    }

    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        if (GameContextUtils.primaryVal()) {
            return;
        }
        if (countVal.tertiaryVal()) {
            this.primaryVal(0.5);
            for (class_1297 class_12972 : ChestStealerModule.mc.field_1687.method_18112()) {
                class_1657 class_16572;
                if (!(class_12972 instanceof class_1657) || (class_16572 = (class_1657)class_12972) == ChestStealerModule.mc.field_1724) continue;
                double d = class_12972.method_23317();
                double d2 = class_12972.method_23318();
                double d3 = class_12972.method_23321();
                class_12972.method_5857(new class_238(d - 1.0E-5, d2, d3 - 1.0E-5, d + 1.0E-5, d2 + (double)class_12972.method_17682(), d3 + 1.0E-5));
            }
        } else {
            this.primaryVal(1.0);
        }
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        class_437 class_4372 = ChestStealerModule.mc.field_1755;
        if (class_4372 instanceof class_476) {
            class_476 class_4762 = (class_476)class_4372;
            class_1707 class_4373 = class_4762.method_17577();
            this.primaryVal(class_4762.method_25440().getString(), class_4373, class_4373.method_17388() * 9);
        } else {
            class_437 class_4372b = ChestStealerModule.mc.field_1755;
            if (class_4372b instanceof class_480) {
                class_480 class_4802 = (class_480)class_4372b;
                class_1716 class_4374 = class_4802.method_17577();
                this.primaryVal(class_4802.method_25440().getString(), class_4374, 9);
            }
        }
    }

    private void primaryVal(String string, class_1703 class_17032, int n) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        switch (this.depthVal.tertiaryVal()) {
            case "Normal": {
                for (int i = 0; i < n; ++i) {
                    if (class_17032.method_7611(i).method_7677().method_7960()) continue;
                    arrayList.add(i);
                }
                break;
            }
            case "FunTime Event": {
                for (int i = 0; i < n; ++i) {
                    class_1799 class_17992 = class_17032.method_7611(i).method_7677();
                    if (class_17992.method_7960()) continue;
                    class_1792 class_17922 = class_17992.method_7909();
                    if (class_17922 != class_1802.field_8864 && class_17922 != class_1802.field_8054 && class_17922 != class_1802.field_8446) {
                        if (class_17922 != class_1802.field_8851) continue;
                    }
                    arrayList.add(i);
                }
                break;
            }
            case "FunTime AIRDrop": {
                int n2;
                if (!this.primaryVal(string)) break;
                boolean bl = false;
                for (n2 = 0; n2 < n; ++n2) {
                    class_1799 class_17993 = class_17032.method_7611(n2).method_7677();
                    if (class_17993.method_7909() != class_1802.field_8183 || !class_17993.method_7964().getString().contains("[★] Item is not yet on cooldown reset")) continue;
                    bl = true;
                    break;
                }
                if (bl) break;
                for (n2 = 0; n2 < n; ++n2) {
                    if (class_17032.method_7611(n2).method_7677().method_7960()) continue;
                    arrayList.add(n2);
                }
                break;
            }
        }
        if (!arrayList.isEmpty()) {
            int n3 = (Integer)arrayList.get(this.factorVal.nextInt(arrayList.size()));
            ChestStealerModule.mc.field_1761.method_2906(class_17032.field_7763, n3, 0, class_1713.field_7794, (class_1657)ChestStealerModule.mc.field_1724);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(String string) {
        String string2 = string.toLowerCase().replaceAll("\u00a7.", "").trim();
        if (string2.equals("barrel")) return true;
        if (string2.equals("dispenser")) return true;
        if (string2.equals("dispenser")) return true;
        if (string2.equals("barrel")) return true;
        if (string2.equals("air drop")) return true;
        if (string2.equals("air drop")) return true;
        if (string2.equals("air-drop")) return true;
        if (string2.equals("air drop")) return true;
        if (!string2.equals("airdrop")) return false;
        return true;
    }

    private void primaryVal(double d) {
        double d2 = (Double)ChestStealerModule.mc.field_1690.method_42517().method_41753();
        if (Math.abs(d2 - d) > 0.001) {
            ChestStealerModule.mc.field_1690.method_42517().method_41748(d);
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.primaryVal(1.0);
    }
}

