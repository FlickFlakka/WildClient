/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10260
 *  net.minecraft.class_1657
 *  net.minecraft.class_1703
 *  net.minecraft.class_1707
 *  net.minecraft.class_1713
 *  net.minecraft.class_1733
 *  net.minecraft.class_1735
 *  net.minecraft.class_2561
 *  net.minecraft.class_332
 *  net.minecraft.class_364
 *  net.minecraft.class_4185
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_476
 *  net.minecraft.class_490
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.At$Shift
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import net.minecraft.class_10260;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1733;
import net.minecraft.class_1735;
import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_364;
import net.minecraft.class_4185;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_476;
import net.minecraft.class_490;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.wild.mixin.acceser.HandledScreenAccessor;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.LockSlotsModule;
import ru.metaculture.protection.AnimationsModule;
import ru.metaculture.protection.DiscountSliderWidget;
import ru.metaculture.protection.UnHookModule;
import ru.metaculture.protection.AutoBuyModule;
import ru.metaculture.protection.AhHelperModule;

@Mixin(value={class_465.class})
public abstract class HandledScreenMixin<T extends class_1703>
extends class_465<T> {
    @Shadow
    protected int field_2776;
    @Shadow
    protected int field_2800;
    @Shadow
    protected int field_2792;
    @Shadow
    protected int field_2779;
    @Unique
    private static final int WILD_AUTOPARSE_CONTROL_WIDTH = 110;
    @Unique
    private static final int WILD_AUTOPARSE_CONTROL_HEIGHT = 20;
    @Unique
    private static final int WILD_AUTOPARSE_CONTROL_GAP = 4;
    @Unique
    private class_4185 wild$autoParseButton;
    @Unique
    private DiscountSliderWidget wild$parseDiscountSlider;
    @Unique
    private static final int WILD_QUICK_BUTTON_HEIGHT = 20;
    @Unique
    private static final int WILD_QUICK_BUTTON_GAP = 4;
    @Unique
    private class_4185 wild$dropInventoryButton;
    @Unique
    private class_4185 wild$takeAllButton;
    @Unique
    private class_4185 wild$depositAllButton;
    @Unique
    private class_4185 wild$dropContainerButton;

    protected HandledScreenMixin(T class_17032, class_1661 class_16612, class_2561 class_25612) {
        super(class_17032, class_16612, class_25612);
    }

    @Unique
    private boolean litka$shouldAnimate(AnimationsModule twigI) {
        return twigI != null && twigI.primaryVal(this);
    }

    @Unique
    private boolean litka$isRecipeBookScreen() {
        return ((Object)this) instanceof class_10260;
    }

    @Unique
    private void litka$applyScale(class_332 class_3322, AnimationsModule twigI) {
        float f = twigI.secondaryVal(this);
        class_3322.method_51448().pushMatrix();
        float f2 = (float)class_3322.method_51421() / 2.0f;
        float f3 = (float)class_3322.method_51443() / 2.0f;
        class_3322.method_51448().translate(f2, f3);
        class_3322.method_51448().scale(f, f);
        class_3322.method_51448().translate(-f2, -f3);
    }

    @Inject(method={"renderBackground"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/ingame/HandledScreen;drawBackground(Lnet/minecraft/client/gui/DrawContext;FII)V")})
    private void litka$preDrawBackground(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        AnimationsModule twigI = WildClient.primaryVal.secondaryVal.primaryVal(AnimationsModule.class);
        if (this.litka$shouldAnimate(twigI)) {
            this.litka$applyScale(class_3322, twigI);
        }
    }

    @Inject(method={"renderBackground"}, at={@At(value="TAIL")})
    private void litka$postDrawBackground(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        AnimationsModule twigI = WildClient.primaryVal.secondaryVal.primaryVal(AnimationsModule.class);
        if (this.litka$shouldAnimate(twigI)) {
            class_3322.method_51448().popMatrix();
        }
    }

    @Inject(method={"renderMain"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/Screen;render(Lnet/minecraft/client/gui/DrawContext;IIF)V", shift=At.Shift.AFTER)})
    private void litka$preRenderForeground(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        AnimationsModule twigI = WildClient.primaryVal.secondaryVal.primaryVal(AnimationsModule.class);
        if (!this.litka$isRecipeBookScreen() && this.litka$shouldAnimate(twigI)) {
            this.litka$applyScale(class_3322, twigI);
        }
    }

    @Inject(method={"renderMain"}, at={@At(value="TAIL")})
    private void litka$postRenderForeground(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        AnimationsModule twigI = WildClient.primaryVal.secondaryVal.primaryVal(AnimationsModule.class);
        if (!this.litka$isRecipeBookScreen() && this.litka$shouldAnimate(twigI)) {
            class_3322.method_51448().popMatrix();
        }
    }

    @Inject(method={"close"}, at={@At(value="HEAD")}, cancellable=true)
    private void litka$animateClose(CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        AnimationsModule twigI = WildClient.primaryVal.secondaryVal.primaryVal(AnimationsModule.class);
        if (this.litka$shouldAnimate(twigI) && !twigI.factorVal()) {
            twigI.tertiaryVal(this);
            callbackInfo.cancel();
        }
    }

    @Inject(method={"removed"}, at={@At(value="HEAD")})
    private void litka$onClose(CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        AnimationsModule twigI = WildClient.primaryVal.secondaryVal.primaryVal(AnimationsModule.class);
        if (twigI != null) {
            twigI.sourceVal();
        }
        AhHelperModule.activeVal.clear();
    }

    @Inject(method={"drawSlot"}, at={@At(value="HEAD")}, cancellable=true)
    private void litka$onDrawSlot(class_332 class_3322, class_1735 class_17352, CallbackInfo callbackInfo) {
        if (AhHelperModule.primaryVal((class_465)this, class_17352)) {
            callbackInfo.cancel();
            return;
        }
        if (AhHelperModule.depthVal.tertiaryVal() && AhHelperModule.activeVal.contains(class_17352.field_7874)) {
            int n = class_17352.field_7873;
            int n2 = class_17352.field_7872;
            class_3322.method_25294(n, n2, n + 16, n2 + 16, 0x6000FF00);
        }
    }

    @Inject(method={"onMouseClick(Lnet/minecraft/screen/slot/Slot;IILnet/minecraft/screen/slot/SlotActionType;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$blockFilteredAuctionSlotClick(class_1735 class_17352, int n, int n2, class_1713 class_17132, CallbackInfo callbackInfo) {
        if (AhHelperModule.primaryVal((class_465)this, class_17352)) {
            callbackInfo.cancel();
            return;
        }
        if (this.wild$isLockedHotbarThrow(class_17352, class_17132)) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"onMouseClick(Lnet/minecraft/screen/slot/Slot;Lnet/minecraft/screen/slot/SlotActionType;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$blockFilteredAuctionQuickMove(class_1735 class_17352, class_1713 class_17132, CallbackInfo callbackInfo) {
        if (AhHelperModule.primaryVal((class_465)this, class_17352)) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"getSlotAt"}, at={@At(value="RETURN")}, cancellable=true)
    private void wild$excludeFilteredAuctionSlot(double d, double d2, CallbackInfoReturnable<class_1735> callbackInfoReturnable) {
        class_1735 class_17352 = (class_1735)callbackInfoReturnable.getReturnValue();
        if (AhHelperModule.primaryVal((class_465)this, class_17352)) {
            callbackInfoReturnable.setReturnValue(null);
        }
    }

    @Inject(method={"drawMouseoverTooltip"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$hideFilteredAuctionTooltip(class_332 class_3322, int n, int n2, CallbackInfo callbackInfo) {
        if (this.wild$isFilteredFocusedSlot()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"drawSlotHighlightBack"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$hideFilteredAuctionBackHighlight(class_332 class_3322, CallbackInfo callbackInfo) {
        if (this.wild$isFilteredFocusedSlot()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method={"drawSlotHighlightFront"}, at={@At(value="HEAD")}, cancellable=true)
    private void wild$hideFilteredAuctionFrontHighlight(class_332 class_3322, CallbackInfo callbackInfo) {
        if (this.wild$isFilteredFocusedSlot()) {
            callbackInfo.cancel();
        }
    }

    @Unique
    private boolean wild$isFilteredFocusedSlot() {
        class_1735 class_17352 = ((HandledScreenAccessor)((Object)this)).litka$getFocusedSlot();
        return AhHelperModule.primaryVal((class_465)this, class_17352);
    }

    @Inject(method={"init"}, at={@At(value="TAIL")})
    private void wild$initAutoParseControls(CallbackInfo callbackInfo) {
        if (UnHookModule.depthVal) {
            return;
        }
        AutoBuyModule uuVUVN2 = this.wild$getAutoBuy();
        if (uuVUVN2 == null || !this.wild$isAuctionContainer()) {
            return;
        }
        int n = this.field_2776 + this.field_2792 + 4;
        int n2 = this.field_2800;
        int n3 = n2 + 20 + 4;
        this.wild$autoParseButton = class_4185.method_46430((class_2561)this.wild$autoParseText(uuVUVN2), class_41852 -> {
            uuVUVN2.extraRef();
            class_41852.method_25355(this.wild$autoParseText(uuVUVN2));
            if (this.wild$parseDiscountSlider != null) {
                this.wild$parseDiscountSlider.primaryVal();
            }
        }).method_46434(n, n2, 110, 20).method_46431();
        this.method_37063(this.wild$autoParseButton);
        this.wild$parseDiscountSlider = new DiscountSliderWidget(uuVUVN2, n, n3, 110, 20);
        this.method_37063(this.wild$parseDiscountSlider);
    }

    @Inject(method={"init"}, at={@At(value="TAIL")})
    private void wild$initQuickContainerControls(CallbackInfo callbackInfo) {
        if (UnHookModule.depthVal) {
            return;
        }
        if (((Object)this) instanceof class_490) {
            int n = 124;
            int n2 = this.field_2776 + this.field_2792 / 2 - n / 2;
            int n3 = this.wild$controlsY();
            this.wild$dropInventoryButton = class_4185.method_46430((class_2561)class_2561.method_43470((String)"Drop all"), class_41852 -> this.wild$dropInventoryItems()).method_46434(n2, n3, n, 20).method_46431();
            this.method_37063(this.wild$dropInventoryButton);
            return;
        }
        if (!this.wild$isQuickContainer() || this.wild$isAuctionContainer()) {
            return;
        }
        int n = 82;
        int n4 = this.field_2776 + this.field_2792 + 4;
        int n5 = this.field_2800;
        this.wild$takeAllButton = class_4185.method_46430((class_2561)class_2561.method_43470((String)"Take all"), class_41852 -> this.wild$takeAllFromContainer()).method_46434(n4, n5, n, 20).method_46431();
        this.wild$depositAllButton = class_4185.method_46430((class_2561)class_2561.method_43470((String)"Stack"), class_41852 -> this.wild$depositAllToContainer()).method_46434(n4, n5 + 20 + 4, n, 20).method_46431();
        this.wild$dropContainerButton = class_4185.method_46430((class_2561)class_2561.method_43470((String)"Drop all"), class_41852 -> this.wild$dropAllFromContainer()).method_46434(n4, n5 + 48, n, 20).method_46431();
        this.method_37063(this.wild$takeAllButton);
        this.method_37063(this.wild$depositAllButton);
        this.method_37063(this.wild$dropContainerButton);
    }

    @Inject(method={"tick"}, at={@At(value="TAIL")})
    private void wild$tickAutoParseControls(CallbackInfo callbackInfo) {
        boolean bl;
        boolean bl2;
        AutoBuyModule uuVUVN2 = this.wild$getAutoBuy();
        boolean bl3 = bl2 = !UnHookModule.depthVal && uuVUVN2 != null && this.wild$isAuctionContainer();
        if (this.wild$autoParseButton != null) {
            this.wild$autoParseButton.field_22764 = bl2;
            this.wild$autoParseButton.field_22763 = bl2;
            if (bl2) {
                this.wild$autoParseButton.method_25355(this.wild$autoParseText(uuVUVN2));
            }
        }
        if (this.wild$parseDiscountSlider != null) {
            this.wild$parseDiscountSlider.field_22764 = bl2;
            this.wild$parseDiscountSlider.field_22763 = bl2;
            if (bl2) {
                this.wild$parseDiscountSlider.primaryVal();
            }
        }
        boolean bl4 = bl = !UnHookModule.depthVal;
        if (this.wild$dropInventoryButton != null) {
            this.wild$dropInventoryButton.field_22764 = bl;
            this.wild$dropInventoryButton.field_22763 = bl;
        }
        if (this.wild$takeAllButton != null) {
            this.wild$takeAllButton.field_22764 = bl;
            this.wild$takeAllButton.field_22763 = bl;
        }
        if (this.wild$depositAllButton != null) {
            this.wild$depositAllButton.field_22764 = bl;
            this.wild$depositAllButton.field_22763 = bl;
        }
        if (this.wild$dropContainerButton != null) {
            this.wild$dropContainerButton.field_22764 = bl;
            this.wild$dropContainerButton.field_22763 = bl;
        }
    }

    @Unique
    private AutoBuyModule wild$getAutoBuy() {
        if (!WildClient.limitVal()) {
            return null;
        }
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return null;
        }
        return WildClient.primaryVal.secondaryVal.primaryVal(AutoBuyModule.class);
    }

    @Unique
    private boolean wild$isAuctionContainer() {
        Object object = this;
        if (!(object instanceof class_476)) {
            return false;
        }
        class_476 class_4762 = (class_476)object;
        object = this.wild$getAutoBuy();
        if (object != null && ((AutoBuyModule)object).radiusVal.secondaryVal("HolyWorld")) {
            return ((AutoBuyModule)object).primaryVal(class_4762);
        }
        return AhHelperModule.primaryVal(class_4762);
    }

    @Unique
    private class_2561 wild$autoParseText(AutoBuyModule uuVUVN2) {
        return class_2561.method_43470((String)("AutoParse: " + (uuVUVN2.factorVal.tertiaryVal() ? "ON" : "OFF")));
    }

    @Unique
    private int wild$controlsY() {
        int n = this.field_2800 - 20 - 4;
        if (n >= 4) {
            return n;
        }
        return this.field_2800 + this.field_2779 + 4;
    }

    @Unique
    private int wild$centeredControlsX(int n) {
        int n2 = this.field_2776 + this.field_2792 / 2 - n / 2;
        int n3 = this.field_22789 - n - 4;
        return Math.max(4, Math.min(n2, n3));
    }

    @Unique
    private void wild$dropInventoryItems() {
        class_1703 class_17032 = this.wild$screenHandler();
        if (!this.wild$canInteract(class_17032)) {
            return;
        }
        for (class_1735 class_17352 : class_17032.field_7761) {
            if (!this.wild$isPlayerInventorySlot(class_17352) || !class_17352.method_7681() || !class_17352.method_7674((class_1657)this.field_22787.field_1724)) continue;
            this.field_22787.field_1761.method_2906(class_17032.field_7763, class_17352.field_7874, 1, class_1713.field_7795, (class_1657)this.field_22787.field_1724);
        }
    }

    @Unique
    private void wild$takeAllFromContainer() {
        class_1703 class_17032 = this.wild$screenHandler();
        if (!this.wild$canInteract(class_17032) || !this.wild$isQuickContainer(class_17032)) {
            return;
        }
        int n = this.wild$containerSlotCount(class_17032);
        for (int i = 0; i < n; ++i) {
            class_1735 class_17352 = class_17032.method_7611(i);
            if (!class_17352.method_7681() || !class_17352.method_7674((class_1657)this.field_22787.field_1724)) continue;
            this.field_22787.field_1761.method_2906(class_17032.field_7763, i, 0, class_1713.field_7794, (class_1657)this.field_22787.field_1724);
        }
    }

    @Unique
    private void wild$depositAllToContainer() {
        class_1703 class_17032 = this.wild$screenHandler();
        if (!this.wild$canInteract(class_17032)) {
            return;
        }
        for (class_1735 class_17352 : class_17032.field_7761) {
            if (!this.wild$isPlayerInventorySlot(class_17352) || !class_17352.method_7681()) continue;
            this.field_22787.field_1761.method_2906(class_17032.field_7763, class_17352.field_7874, 0, class_1713.field_7794, (class_1657)this.field_22787.field_1724);
        }
    }

    @Unique
    private void wild$dropAllFromContainer() {
        class_1703 class_17032 = this.wild$screenHandler();
        if (!this.wild$canInteract(class_17032) || !this.wild$isQuickContainer(class_17032)) {
            return;
        }
        int n = this.wild$containerSlotCount(class_17032);
        for (int i = 0; i < n; ++i) {
            class_1735 class_17352 = class_17032.method_7611(i);
            if (!class_17352.method_7681() || !class_17352.method_7674((class_1657)this.field_22787.field_1724)) continue;
            this.field_22787.field_1761.method_2906(class_17032.field_7763, i, 1, class_1713.field_7795, (class_1657)this.field_22787.field_1724);
        }
    }

    @Unique
    private boolean wild$canInteract(class_1703 class_17032) {
        return this.field_22787 != null && this.field_22787.field_1724 != null && this.field_22787.field_1761 != null && class_17032 != null;
    }

    @Unique
    private boolean wild$isLockedHotbarThrow(class_1735 class_17352, class_1713 class_17132) {
        if (!WildClient.limitVal()) {
            return false;
        }
        if (class_17132 != class_1713.field_7795 || !this.wild$isPlayerInventorySlot(class_17352)) {
            return false;
        }
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return false;
        }
        LockSlotsModule reedC = WildClient.primaryVal.secondaryVal.primaryVal(LockSlotsModule.class);
        return reedC != null && reedC.enabled && reedC.primaryVal(class_17352.method_34266());
    }

    @Unique
    private boolean wild$isPlayerInventorySlot(class_1735 class_17352) {
        return class_17352 != null && this.field_22787 != null && this.field_22787.field_1724 != null && class_17352.field_7871 == this.field_22787.field_1724.method_31548();
    }

    @Unique
    private class_1703 wild$screenHandler() {
        return ((class_465)this).method_17577();
    }

    @Unique
    private boolean wild$isQuickContainer() {
        return this.wild$isQuickContainer(this.wild$screenHandler());
    }

    @Unique
    private boolean wild$isQuickContainer(class_1703 class_17032) {
        return class_17032 instanceof class_1707 || class_17032 instanceof class_1733;
    }

    @Unique
    private int wild$containerSlotCount(class_1703 class_17032) {
        int n;
        if (class_17032 instanceof class_1707) {
            class_1707 class_17072 = (class_1707)class_17032;
            n = class_17072.method_17388();
        } else if (class_17032 instanceof class_1733) {
            n = 3;
        } else {
            return 0;
        }
        int n2 = class_17032.field_7761.size();
        return Math.max(0, Math.min(n * 9, n2));
    }
}

