/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10185
 *  net.minecraft.class_2596
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_2828$class_2830
 *  net.minecraft.class_2828$class_2831
 *  net.minecraft.class_2828$class_5911
 *  net.minecraft.class_299
 *  net.minecraft.class_310
 *  net.minecraft.class_3469
 *  net.minecraft.class_3532
 *  net.minecraft.class_634
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  net.minecraft.class_8791
 */
package ru.metaculture.protection;

import net.minecraft.class_10185;
import net.minecraft.class_2596;
import net.minecraft.class_2828;
import net.minecraft.class_299;
import net.minecraft.class_310;
import net.minecraft.class_3469;
import net.minecraft.class_3532;
import net.minecraft.class_634;
import net.minecraft.class_638;
import net.minecraft.class_746;
import net.minecraft.class_8791;
import ru.metaculture.protection.MovementPacketEvent;
import ru.metaculture.protection.CrossWorldEventDispatcher;
import ru.metaculture.protection.VnUvNVNVNUUn;
import ru.metaculture.protection.Event;
import ru.metaculture.protection.HeadlessBotHostManager;
import ru.metaculture.protection.HeadlessBotSession;

public final class HeadlessBotNetworkHandler
extends class_746 {
    private final HeadlessBotSession primaryVal;
    private double secondaryVal;
    private double tertiaryVal;
    private double marginVal;
    private float weightVal;
    private float paramVal;
    private boolean extraVal;
    private boolean limitVal;
    private int speedVal;

    public HeadlessBotNetworkHandler(HeadlessBotSession vUNVNUnuv2, class_310 class_3102, VnUvNVNVNUUn vnUvNVNVNUUn, class_634 class_6342, class_3469 class_34692, class_299 class_2992) {
        this(vUNVNUnuv2, class_3102, vnUvNVNVNUUn, class_6342, class_34692, class_2992, class_10185.field_54098, false);
    }

    public HeadlessBotNetworkHandler(HeadlessBotSession vUNVNUnuv2, class_310 class_3102, VnUvNVNVNUUn vnUvNVNVNUUn, class_634 class_6342, class_3469 class_34692, class_299 class_2992, class_10185 class_101852, boolean bl) {
        super(class_3102, (class_638)vnUvNVNVNUUn, class_6342, class_34692, class_2992, class_101852, bl);
        this.primaryVal = vUNVNUnuv2;
        class_8791 class_87912 = class_3102.field_1690.method_53842();
        this.method_5841().method_12778(field_7518, (byte)class_87912.comp_1955());
        this.method_7283(class_87912.comp_1956());
        this.secondaryVal();
    }

    public HeadlessBotSession primaryVal() {
        return this.primaryVal;
    }

    public void method_5773() {
        super.method_5773();
        if (HeadlessBotHostManager.primaryVal() != this.primaryVal) {
            MovementPacketEvent nUNnuuNUvuVU = new MovementPacketEvent(this.method_23317(), this.method_23318(), this.method_23321(), this.method_36454(), this.method_36455(), this.method_24828());
            CrossWorldEventDispatcher.primaryVal(this.primaryVal, (Event)nUNnuuNUvuVU);
            if (!nUNnuuNUvuVU.primaryVal()) {
                this.primaryVal(nUNnuuNUvuVU);
            }
        }
    }

    public void secondaryVal() {
        this.secondaryVal = this.method_23317();
        this.tertiaryVal = this.method_23318();
        this.marginVal = this.method_23321();
        this.weightVal = this.method_36454();
        this.paramVal = this.method_36455();
        this.extraVal = this.method_24828();
        this.limitVal = this.field_5976;
        this.speedVal = 0;
    }

    private void primaryVal(MovementPacketEvent nUNnuuNUvuVU) {
        boolean bl;
        double d = nUNnuuNUvuVU.tertiaryVal();
        double d2 = nUNnuuNUvuVU.marginVal();
        double d3 = nUNnuuNUvuVU.weightVal();
        float f = (float)nUNnuuNUvuVU.paramVal();
        float f2 = (float)nUNnuuNUvuVU.extraVal();
        boolean bl2 = nUNnuuNUvuVU.limitVal();
        double d4 = d - this.secondaryVal;
        double d5 = d2 - this.tertiaryVal;
        double d6 = d3 - this.marginVal;
        double d7 = f - this.weightVal;
        double d8 = f2 - this.paramVal;
        ++this.speedVal;
        boolean bl3 = class_3532.method_41190((double)d4, (double)d5, (double)d6) > class_3532.method_33723((double)2.0E-4) || this.speedVal >= 20;
        boolean bl4 = bl = d7 != 0.0 || d8 != 0.0;
        if (bl3 && bl) {
            this.field_3944.method_52787((class_2596)new class_2828.class_2830(d, d2, d3, f, f2, bl2, this.field_5976));
        } else if (bl3) {
            this.field_3944.method_52787((class_2596)new class_2828.class_2829(d, d2, d3, bl2, this.field_5976));
        } else if (bl) {
            this.field_3944.method_52787((class_2596)new class_2828.class_2831(f, f2, bl2, this.field_5976));
        } else if (this.extraVal != bl2 || this.limitVal != this.field_5976) {
            this.field_3944.method_52787((class_2596)new class_2828.class_5911(bl2, this.field_5976));
        }
        if (bl3) {
            this.secondaryVal = d;
            this.tertiaryVal = d2;
            this.marginVal = d3;
            this.speedVal = 0;
        }
        if (bl) {
            this.weightVal = f;
            this.paramVal = f2;
        }
        this.extraVal = bl2;
        this.limitVal = this.field_5976;
    }
}

