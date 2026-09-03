/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_1657
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_465
 *  org.lwjgl.glfw.GLFW
 */
package ru.metaculture.protection;

import lombok.Generated;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_465;
import org.lwjgl.glfw.GLFW;
import org.wild.mixin.acceser.HandledScreenAccessor;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.PostClientTickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="ItemScroller", secondaryVal="Speeds up item transferring", tertiaryVal=ModuleCategory.Misc)
public class ItemScrollerModule
extends Module {
    public final FloatSetting countVal = new FloatSetting("Delay", 10.0f, 0.0f, 100.0f, 1.0f, false);
    private static ItemScrollerModule depthVal;
    private final VuNvNNvVV descRef = new VuNvNNvVV();

    public ItemScrollerModule() {
        this.addSettings(this.countVal);
        depthVal = this;
    }

    @Subscribe
    public void primaryVal(PostClientTickEvent coreH) {
        boolean bl;
        if (ItemScrollerModule.mc.field_1724 == null || ItemScrollerModule.mc.field_1755 == null) {
            return;
        }
        if (!(ItemScrollerModule.mc.field_1755 instanceof class_465)) {
            return;
        }
        class_465 class_4652 = (class_465)ItemScrollerModule.mc.field_1755;
        if (mc.method_22683() == null) {
            return;
        }
        long l = mc.method_22683().method_4490();
        boolean bl2 = bl = GLFW.glfwGetKey((long)l, (int)340) == 1 || GLFW.glfwGetKey((long)l, (int)344) == 1;
        boolean bl3 = GLFW.glfwGetMouseButton((long)l, (int)0) == 1;
        if (!bl || !bl3) {
            return;
        }
        long l2 = (long)this.countVal.tertiaryVal();
        if (!this.descRef.weightVal(l2)) {
            return;
        }
        double d = ItemScrollerModule.mc.field_1729.method_1603() * (double)mc.method_22683().method_4486() / (double)mc.method_22683().method_4480();
        double d2 = ItemScrollerModule.mc.field_1729.method_1604() * (double)mc.method_22683().method_4502() / (double)mc.method_22683().method_4507();
        class_1735 class_17352 = ((HandledScreenAccessor)class_4652).getSlotAtPosition(d, d2);
        if (class_17352 != null && class_17352.method_7681()) {
            ItemScrollerModule.mc.field_1761.method_2906(class_4652.method_17577().field_7763, class_17352.field_7874, 0, class_1713.field_7794, (class_1657)ItemScrollerModule.mc.field_1724);
            this.descRef.primaryVal();
        }
    }

    @Generated
    public static ItemScrollerModule blockRef() {
        return depthVal;
    }
}

