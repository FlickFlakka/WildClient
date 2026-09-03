/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_1268
 *  net.minecraft.class_1657
 *  net.minecraft.class_2596
 *  net.minecraft.class_2678
 *  net.minecraft.class_2724
 *  net.minecraft.class_2799
 *  net.minecraft.class_2799$class_2800
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 */
package ru.metaculture.protection;

import java.lang.runtime.SwitchBootstraps;
import java.util.Objects;
import lombok.Generated;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_2596;
import net.minecraft.class_2678;
import net.minecraft.class_2724;
import net.minecraft.class_2799;
import net.minecraft.class_2846;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.RotationFeature;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;

public class InteractAckGate
extends RotationFeature
implements MinecraftAccessor {
    public static final InteractAckGate primaryVal = new InteractAckGate();
    public boolean secondaryVal;
    public boolean tertiaryVal = true;

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        class_2596<?> class_25962 = uvUUuvnunU2.marginVal();
        Objects.requireNonNull(class_25962);
        if (class_25962 instanceof class_2846 && ((class_2846)class_25962).method_12363().equals((Object)class_2846.class_2847.field_12974)) {
            this.tertiaryVal = true;
        } else if (class_25962 instanceof class_2799 && ((class_2799)class_25962).method_12119().equals((Object)class_2799.class_2800.field_12774)) {
            this.tertiaryVal = true;
        } else if (class_25962 instanceof class_2724) {
            this.tertiaryVal = true;
        } else if (class_25962 instanceof class_2678) {
            this.tertiaryVal = true;
        }
    }

    public void primaryVal(class_1268 class_12682) {
        if (this.tertiaryVal) {
            InteractAckGate.a_.field_1761.method_2919((class_1657)InteractAckGate.a_.field_1724, class_12682);
            this.tertiaryVal = false;
        }
        this.secondaryVal = true;
    }

    @Generated
    public void primaryVal(boolean bl) {
        this.secondaryVal = bl;
    }

    @Generated
    public void secondaryVal(boolean bl) {
        this.tertiaryVal = bl;
    }

    @Generated
    public boolean primaryVal() {
        return this.secondaryVal;
    }

    @Generated
    public boolean secondaryVal() {
        return this.tertiaryVal;
    }
}

