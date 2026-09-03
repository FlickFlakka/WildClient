/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1802
 */
package ru.metaculture.protection;

import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1802;
import org.wild.mixin.acceser.ClientPlayerInteractionManagerAccessor;
import org.wild.mixin.acceser.MinecraftClientAccessor;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="NoDelay", secondaryVal="Removes delay", tertiaryVal=ModuleCategory.Player)
public class NoDelayModule
extends Module {
    public static BoolSetting countVal = new BoolSetting("Jumps", true);
    public static BoolSetting depthVal = new BoolSetting("Randomization", false).primaryVal(() -> !countVal.tertiaryVal());
    public static BoolSetting descRef = new BoolSetting("Block breaking", false);
    public static BoolSetting activeVal = new BoolSetting("LMB", false);
    public static BoolSetting radiusVal = new BoolSetting("RMB", false);
    public static BoolSetting factorVal = new BoolSetting("XP bottles", true);
    public static FloatSetting sourceVal = new FloatSetting("Jump speed", 0.0f, 0.0f, 10.0f, 1.0f, false).primaryVal(() -> !countVal.tertiaryVal());
    public static FloatSetting extraRef = new FloatSetting("Block breaking speed", 0.0f, 0.0f, 5.0f, 1.0f, false).primaryVal(() -> !descRef.tertiaryVal());
    public static FloatSetting phaseVal = new FloatSetting("LMB delay", 0.0f, 0.0f, 10.0f, 1.0f, false).primaryVal(() -> !activeVal.tertiaryVal());
    public static FloatSetting limitRef = new FloatSetting("RMB delay", 0.0f, 0.0f, 4.0f, 1.0f, false).primaryVal(() -> !radiusVal.tertiaryVal());

    public NoDelayModule() {
        Setting[] nvUuvVvuuNArray = new Setting[10];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        nvUuvVvuuNArray[2] = sourceVal;
        nvUuvVvuuNArray[3] = descRef;
        nvUuvVvuuNArray[4] = extraRef;
        nvUuvVvuuNArray[5] = activeVal;
        nvUuvVvuuNArray[6] = phaseVal;
        nvUuvVvuuNArray[7] = radiusVal;
        nvUuvVvuuNArray[8] = limitRef;
        nvUuvVvuuNArray[9] = factorVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    public static int blockRef() {
        int n = (int)sourceVal.tertiaryVal();
        if (depthVal.tertiaryVal() && n > 0) {
            return ThreadLocalRandom.current().nextInt(0, n + 1);
        }
        return n;
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        ClientPlayerInteractionManagerAccessor clientPlayerInteractionManagerAccessor;
        if (NoDelayModule.mc.field_1724 == null) {
            return;
        }
        if (descRef.tertiaryVal() && NoDelayModule.mc.field_1761 != null && (float)(clientPlayerInteractionManagerAccessor = (ClientPlayerInteractionManagerAccessor)NoDelayModule.mc.field_1761).getBlockBreakingCooldown() > extraRef.tertiaryVal()) {
            clientPlayerInteractionManagerAccessor.setBlockBreakingCooldown((int)extraRef.tertiaryVal());
        }
        if (factorVal.tertiaryVal()) {
            boolean bl;
            boolean bl2 = bl = NoDelayModule.mc.field_1724.method_6047().method_7909() == class_1802.field_8287 || NoDelayModule.mc.field_1724.method_6079().method_7909() == class_1802.field_8287;
            if (bl) {
                ((MinecraftClientAccessor)mc).setItemUseCooldown(0);
            }
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        if (NoDelayModule.mc.field_1761 != null) {
            ((ClientPlayerInteractionManagerAccessor)NoDelayModule.mc.field_1761).setBlockBreakingCooldown(5);
        }
    }
}

