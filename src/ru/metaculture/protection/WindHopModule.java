/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1802
 *  net.minecraft.class_2596
 *  net.minecraft.class_2886
 */
package ru.metaculture.protection;

import net.minecraft.class_1802;
import net.minecraft.class_2596;
import net.minecraft.class_2886;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.PostWorldJoinEvent;
import ru.metaculture.protection.WorldJoinEvent;
import ru.metaculture.protection.PostClientTickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.MovementInputEvent;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="WindHop", secondaryVal="Picks up wind charge momentum with a jump", tertiaryVal=ModuleCategory.Player)
public class WindHopModule
extends Module {
    private static final int countVal = 2;
    private final BoolSetting depthVal = new BoolSetting("Momentum pickup", true);
    private int descRef = -1;
    private boolean activeVal;

    public WindHopModule() {
        Setting[] nvUuvVvuuNArray = new Setting[1];
        nvUuvVvuuNArray[0] = this.depthVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        class_2886 class_28862;
        if (!uvUUuvnunU2.tertiaryVal() || !this.depthVal.tertiaryVal() || WindHopModule.mc.field_1724 == null) {
            return;
        }
        class_2596<?> class_25962 = uvUUuvnunU2.marginVal();
        if (class_25962 instanceof class_2886 && WindHopModule.mc.field_1724.method_5998((class_28862 = (class_2886)class_25962).method_12551()).method_31574(class_1802.field_49098)) {
            this.descRef = 2;
            this.activeVal = false;
        }
    }

    @Subscribe
    public void primaryVal(PostClientTickEvent coreH) {
        if (!this.depthVal.tertiaryVal()) {
            this.blockRef();
            return;
        }
        if (this.descRef > 0) {
            --this.descRef;
            return;
        }
        if (this.descRef == 0) {
            this.descRef = -1;
            this.activeVal = true;
        }
    }

    @Subscribe
    public void primaryVal(MovementInputEvent uNVVnVUNun2) {
        if (!this.activeVal || !this.depthVal.tertiaryVal()) {
            return;
        }
        uNVVnVUNun2.primaryVal(true);
        this.blockRef();
    }

    @Subscribe
    public void primaryVal(PostWorldJoinEvent vaseE) {
        this.blockRef();
    }

    @Subscribe
    public void primaryVal(WorldJoinEvent coOCCcooOcOO2) {
        this.blockRef();
    }

    @Override
    public void onDisable() {
        this.blockRef();
        super.onDisable();
    }

    private void blockRef() {
        this.descRef = -1;
        this.activeVal = false;
    }
}

