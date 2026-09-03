/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_2535
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2797
 *  net.minecraft.class_3515$class_7426
 *  net.minecraft.class_636
 *  net.minecraft.class_7472
 *  net.minecraft.class_7635$class_7636
 */
package ru.metaculture.protection;

import com.mojang.authlib.GameProfile;
import java.time.Instant;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.class_2535;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2797;
import net.minecraft.class_3515;
import net.minecraft.class_636;
import net.minecraft.class_7472;
import net.minecraft.class_7635;
import ru.metaculture.protection.HeadlessBotNetworkHandler;
import ru.metaculture.protection.BotModuleRegistry;
import ru.metaculture.protection.VnUvNVNVNUUn;
import ru.metaculture.protection.HeadlessBotPlayNetworkHandler;

public final class HeadlessBotSession {
    private final String primaryVal;
    private final class_2535 secondaryVal;
    private volatile GameProfile tertiaryVal;
    private volatile HeadlessBotPlayNetworkHandler marginVal;
    private volatile VnUvNVNVNUUn weightVal;
    private volatile HeadlessBotNetworkHandler paramVal;
    private volatile class_636 extraVal;
    private volatile boolean limitVal;
    private volatile boolean speedVal;
    private volatile boolean widthVal;
    private final AtomicBoolean chunkVal = new AtomicBoolean();
    private final BotModuleRegistry blockRef = new BotModuleRegistry(this);

    public HeadlessBotSession(String string, class_2535 class_25352) {
        this.primaryVal = string;
        this.secondaryVal = class_25352;
    }

    public String primaryVal() {
        return this.primaryVal;
    }

    public GameProfile secondaryVal() {
        return this.tertiaryVal;
    }

    public void primaryVal(GameProfile gameProfile) {
        this.tertiaryVal = gameProfile;
    }

    public class_2535 tertiaryVal() {
        return this.secondaryVal;
    }

    public void primaryVal(class_2596<?> class_25962) {
        if (this.secondaryVal.method_10758()) {
            this.secondaryVal.method_10743(class_25962);
        }
    }

    public boolean primaryVal(String string) {
        if (!this.limitVal || string == null || string.isBlank() || string.length() > 256 || !this.secondaryVal.method_10758()) {
            return false;
        }
        if (string.startsWith("/")) {
            if (string.length() == 1) {
                return false;
            }
            this.primaryVal((class_2596<?>)new class_7472(string.substring(1)));
            return true;
        }
        this.primaryVal((class_2596<?>)new class_2797(string, Instant.now(), class_3515.class_7426.method_43531(), null, new class_7635.class_7636(0, new BitSet(), (byte)0)));
        return true;
    }

    public void marginVal() {
        if (this.secondaryVal.method_10758()) {
            this.secondaryVal.method_10747((class_2561)class_2561.method_43470((String)"Bot removed"));
        }
    }

    public boolean weightVal() {
        return this.secondaryVal.method_10758();
    }

    public HeadlessBotPlayNetworkHandler paramVal() {
        return this.marginVal;
    }

    public void primaryVal(HeadlessBotPlayNetworkHandler nNnnNNnNVvUv2) {
        this.marginVal = nNnnNNnNVvUv2;
    }

    public VnUvNVNVNUUn extraVal() {
        return this.weightVal;
    }

    public void primaryVal(VnUvNVNVNUUn vnUvNVNVNUUn) {
        this.weightVal = vnUvNVNVNUUn;
    }

    public HeadlessBotNetworkHandler limitVal() {
        return this.paramVal;
    }

    public void primaryVal(HeadlessBotNetworkHandler vNNVunUvvnn) {
        this.paramVal = vNNVunUvvnn;
    }

    public class_636 speedVal() {
        return this.extraVal;
    }

    public void primaryVal(class_636 class_6362) {
        this.extraVal = class_6362;
    }

    public boolean widthVal() {
        return this.limitVal;
    }

    public void primaryVal(boolean bl) {
        this.limitVal = bl;
    }

    public boolean chunkVal() {
        return this.speedVal;
    }

    public void secondaryVal(boolean bl) {
        this.speedVal = bl;
    }

    public BotModuleRegistry blockRef() {
        return this.blockRef;
    }

    public boolean holderVal() {
        return this.widthVal;
    }

    public void tertiaryVal(boolean bl) {
        this.widthVal = bl;
    }

    boolean timerVal() {
        return this.chunkVal.compareAndSet(false, true);
    }

    boolean anchorVal() {
        return this.chunkVal.get();
    }

    void weightRef() {
        this.limitVal = false;
        this.speedVal = false;
        this.widthVal = false;
        this.marginVal = null;
        this.weightVal = null;
        this.paramVal = null;
        this.extraVal = null;
    }
}

