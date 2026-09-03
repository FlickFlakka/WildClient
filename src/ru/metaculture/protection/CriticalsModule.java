/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1294
 *  net.minecraft.class_1297
 *  net.minecraft.class_1511
 *  net.minecraft.class_2246
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_238
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828$class_2830
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1511;
import net.minecraft.class_2246;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_3532;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.GameContextUtils;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.BlockBreakEvent;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="Criticals", secondaryVal="Critical hit while gently falling or in a cobweb", tertiaryVal=ModuleCategory.Combat, marginVal={ModuleBadge.RISKY, ModuleBadge.GRIM})
public class CriticalsModule
extends Module {
    public static boolean countVal;
    public final SettingGroup depthVal;

    public CriticalsModule() {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[2];
        vvNnnUNnVvnArray[0] = new BoolSetting("Cobweb", true);
        vvNnnUNnVvnArray[1] = new BoolSetting("Smooth Falling", true);
        this.depthVal = new SettingGroup("Conditions", vvNnnUNnVvnArray);
        this.addSettings(this.depthVal);
    }

    @Subscribe
    public void primaryVal(BlockBreakEvent coreG) {
        boolean bl;
        boolean bl2;
        if (countVal) {
            return;
        }
        if (GameContextUtils.primaryVal() || CriticalsModule.mc.field_1724 == null || CriticalsModule.mc.field_1687 == null) {
            return;
        }
        if (CriticalsModule.mc.field_1724.field_3944 == null) {
            return;
        }
        if (CriticalsModule.mc.field_1724.method_6128()) {
            return;
        }
        class_1297 class_12972 = coreG.tertiaryVal();
        if (class_12972 == null || class_12972 == CriticalsModule.mc.field_1724 || class_12972 instanceof class_1511) {
            return;
        }
        boolean bl3 = bl2 = this.depthVal.secondaryVal("Cobweb") && this.blockRef();
        bl = this.depthVal.secondaryVal("Smooth Falling") && CriticalsModule.mc.field_1724.method_6059(class_1294.field_5906);
        if (!bl2 && !bl) {
            return;
        }
        float f = class_3532.method_16439((float)ThreadLocalRandom.current().nextFloat(), (float)1.0E-7f, (float)1.0E-6f);
        CriticalsModule.mc.field_1724.field_6017 = f;
        CriticalsModule.mc.field_1724.field_3944.method_52787((class_2596)new class_2828.class_2830(CriticalsModule.mc.field_1724.method_23317(), CriticalsModule.mc.field_1724.method_23318() - (double)f, CriticalsModule.mc.field_1724.method_23321(), CriticalsModule.mc.field_1724.method_36454(), CriticalsModule.mc.field_1724.method_36455(), false, CriticalsModule.mc.field_1724.field_5976));
    }

    private boolean blockRef() {
        class_238 class_2383 = CriticalsModule.mc.field_1724.method_5829().method_1011(1.0E-7);
        int n = class_3532.method_15357((double)class_2383.field_1323);
        int n2 = class_3532.method_15357((double)class_2383.field_1320);
        int n3 = class_3532.method_15357((double)class_2383.field_1322);
        int n4 = class_3532.method_15357((double)class_2383.field_1325);
        int n5 = class_3532.method_15357((double)class_2383.field_1321);
        int n6 = class_3532.method_15357((double)class_2383.field_1324);
        class_2338.class_2339 class_23392 = new class_2338.class_2339();
        for (int i = n; i <= n2; ++i) {
            for (int j = n3; j <= n4; ++j) {
                for (int k = n5; k <= n6; ++k) {
                    class_23392.method_10103(i, j, k);
                    if (!CriticalsModule.mc.field_1687.method_8320((class_2338)class_23392).method_27852(class_2246.field_10343)) continue;
                    return true;
                }
            }
        }
        return false;
    }
}

