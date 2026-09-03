/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10039
 */
package ru.metaculture.protection;

import net.minecraft.class_10039;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ItemPhysicAccessor;
import ru.metaculture.protection.ModuleCategory;

@ModuleRegister(primaryVal="ItemPhysic", tertiaryVal=ModuleCategory.Visuals, secondaryVal="Renders items lying on the surface")
public class ItemPhysicModule
extends Module {
    private static final float countVal = 90.0f;
    private static final float depthVal = 0.0f;
    private static final float descRef = 22.0f;
    private static boolean activeVal;

    @Override
    public void onEnable() {
        super.onEnable();
        activeVal = true;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        activeVal = false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(class_10039 class_100392) {
        if (!activeVal) return false;
        if (!(class_100392 instanceof ItemPhysicAccessor)) return false;
        ItemPhysicAccessor panelVal = (ItemPhysicAccessor)class_100392;
        if (!panelVal.wild$isItemPhysicOnGround()) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean secondaryVal(class_10039 class_100392) {
        if (!activeVal) return false;
        if (!(class_100392 instanceof ItemPhysicAccessor)) return false;
        ItemPhysicAccessor panelVal = (ItemPhysicAccessor)class_100392;
        if (panelVal.wild$isItemPhysicOnGround()) return false;
        return true;
    }

    public static float blockRef() {
        return 0.0f;
    }

    public static float holderVal() {
        return 90.0f;
    }

    public static float primaryVal(float f) {
        return f * 22.0f;
    }
}

