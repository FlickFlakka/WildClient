/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_437
 *  net.minecraft.class_476
 */
package ru.metaculture.protection;

import net.minecraft.class_310;
import net.minecraft.class_437;
import net.minecraft.class_476;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.AutoBuyModule;
import ru.metaculture.protection.AhHelperModule;

final class AuctionHouseAutomationState {
    private static final int primaryVal = 5;
    private static final long secondaryVal = 900L;
    private static final VuNvNNvVV tertiaryVal = new VuNvNNvVV();
    private static WildClient marginVal = WildClient.NONE;
    private static boolean weightVal = false;
    private static boolean paramVal = false;
    private static boolean extraVal = false;
    private static int limitVal = 0;

    private AuctionHouseAutomationState() {
    }

    static void primaryVal() {
        marginVal = WildClient.NONE;
        weightVal = false;
        paramVal = false;
        extraVal = false;
        limitVal = 0;
        AuctionHouseAutomationState.weightRef();
    }

    static void secondaryVal() {
        if (!extraVal) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 == null) {
            return;
        }
        if (AuctionHouseAutomationState.tertiaryVal(class_3102)) {
            extraVal = false;
            limitVal = 0;
            return;
        }
        if (!AuctionHouseAutomationState.anchorVal()) {
            extraVal = false;
            limitVal = 0;
            return;
        }
        if (limitVal >= 5) {
            if (tertiaryVal.weightVal(900L)) {
                extraVal = false;
            }
            return;
        }
        if (tertiaryVal.weightVal(900L)) {
            AuctionHouseAutomationState.secondaryVal(class_3102);
        }
    }

    static boolean tertiaryVal() {
        return weightVal;
    }

    static boolean marginVal() {
        return paramVal;
    }

    static boolean weightVal() {
        return marginVal == WildClient.SELL || AutoBuyModule.depthVal;
    }

    static boolean paramVal() {
        return marginVal == WildClient.RESELL || AutoBuyModule.descRef;
    }

    static boolean extraVal() {
        return !weightVal && !AuctionHouseAutomationState.paramVal();
    }

    static boolean limitVal() {
        if (!AuctionHouseAutomationState.extraVal()) {
            return false;
        }
        marginVal = WildClient.SELL;
        AuctionHouseAutomationState.weightRef();
        return true;
    }

    static void primaryVal(boolean bl) {
        if (marginVal == WildClient.SELL) {
            marginVal = WildClient.NONE;
        }
        AutoBuyModule.depthVal = false;
        AuctionHouseAutomationState.weightRef();
        AuctionHouseAutomationState.marginVal(bl);
    }

    static boolean speedVal() {
        block3: {
            block2: {
                if (!paramVal) break block2;
                if (!AuctionHouseAutomationState.weightVal()) break block3;
            }
            return false;
        }
        marginVal = WildClient.RESELL;
        AuctionHouseAutomationState.weightRef();
        return true;
    }

    static void secondaryVal(boolean bl) {
        if (marginVal == WildClient.RESELL) {
            marginVal = WildClient.NONE;
        }
        AutoBuyModule.descRef = false;
        AuctionHouseAutomationState.weightRef();
        AuctionHouseAutomationState.marginVal(bl);
    }

    static void tertiaryVal(boolean bl) {
        if (bl && !weightVal) {
            AuctionHouseAutomationState.limitVal();
            return;
        }
        AuctionHouseAutomationState.weightRef();
        AuctionHouseAutomationState.marginVal(true);
    }

    static void widthVal() {
        weightVal = false;
        paramVal = true;
        AuctionHouseAutomationState.weightRef();
    }

    static void chunkVal() {
        weightVal = true;
        paramVal = true;
        if (marginVal == WildClient.SELL) {
            marginVal = WildClient.NONE;
        }
        AuctionHouseAutomationState.weightRef();
    }

    static void blockRef() {
        weightVal = false;
        paramVal = true;
        AuctionHouseAutomationState.weightRef();
    }

    static void holderVal() {
        paramVal = true;
        AuctionHouseAutomationState.weightRef();
    }

    static void timerVal() {
        weightVal = false;
        paramVal = false;
        if (marginVal == WildClient.RESELL) {
            marginVal = WildClient.NONE;
        }
        AuctionHouseAutomationState.weightRef();
    }

    static void marginVal(boolean bl) {
        if (!bl) {
            return;
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102.field_1724 == null) {
            return;
        }
        if (AutoBuyModule.countVal == null || !AutoBuyModule.countVal.enabled) {
            return;
        }
        AuctionHouseAutomationState.primaryVal(class_3102);
    }

    private static void primaryVal(class_310 class_3102) {
        if (AuctionHouseAutomationState.tertiaryVal(class_3102)) {
            extraVal = false;
            limitVal = 0;
            return;
        }
        if (AuctionHouseAutomationState.anchorVal()) {
            extraVal = false;
            limitVal = 0;
            AutoBuyModule.countVal.sourceVal();
            return;
        }
        class_3102.field_1724.field_3944.method_45730("ah");
    }

    private static void secondaryVal(class_310 class_3102) {
        class_3102.field_1724.field_3944.method_45730("ah");
        ++limitVal;
        tertiaryVal.primaryVal();
    }

    private static boolean tertiaryVal(class_310 class_3102) {
        class_476 class_4762;
        class_437 class_4372 = class_3102.field_1755;
        return class_4372 instanceof class_476 && AhHelperModule.primaryVal(class_4762 = (class_476)class_4372);
    }

    private static boolean anchorVal() {
        return AutoBuyModule.countVal != null && AutoBuyModule.countVal.radiusVal.secondaryVal("FunTime");
    }

    private static void weightRef() {
        AutoBuyModule.depthVal = marginVal == WildClient.SELL;
        AutoBuyModule.descRef = marginVal == WildClient.RESELL;
        AutoBuyModule.activeVal = weightVal;
    }

    public enum WildClient {
    NONE,
    SELL,
    RESELL;
}
}

