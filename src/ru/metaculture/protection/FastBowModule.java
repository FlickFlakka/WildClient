/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1753
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2596
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 *  net.minecraft.class_2886
 */
package ru.metaculture.protection;

import net.minecraft.class_1268;
import net.minecraft.class_1753;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_2596;
import net.minecraft.class_2846;
import net.minecraft.class_2886;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="FastBow", tertiaryVal=ModuleCategory.Combat, secondaryVal="Automatic arrow spam")
public class FastBowModule
extends Module {
    private final FloatSetting countVal = new FloatSetting("Delay", 10.0f, 1.0f, 10.0f, 1.0f, false);

    public FastBowModule() {
        this.addSettings(this.countVal);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (this.blockRef()) {
            return;
        }
        if (this.holderVal()) {
            this.timerVal();
            FastBowModule.mc.field_1724.method_6075();
        }
    }

    private boolean blockRef() {
        return FastBowModule.mc.field_1724 == null || FastBowModule.mc.field_1687 == null || mc.method_1562() == null;
    }

    private boolean holderVal() {
        boolean bl = FastBowModule.mc.field_1724.method_6047().method_7909() instanceof class_1753;
        boolean bl2 = FastBowModule.mc.field_1724.method_6115();
        if (!bl || !bl2) {
            return false;
        }
        return (float)FastBowModule.mc.field_1724.method_6048() >= this.countVal.tertiaryVal();
    }

    private void timerVal() {
        class_2846 class_28462 = new class_2846(class_2846.class_2847.field_12974, class_2338.field_10980, class_2350.field_11033);
        class_2886 class_28862 = new class_2886(class_1268.field_5808, 0, FastBowModule.mc.field_1724.method_36454(), FastBowModule.mc.field_1724.method_36455());
        mc.method_1562().method_52787((class_2596)class_28462);
        mc.method_1562().method_52787((class_2596)class_28862);
    }
}

