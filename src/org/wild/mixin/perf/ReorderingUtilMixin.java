/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2583
 *  net.minecraft.class_5348
 *  net.minecraft.class_5481
 *  net.minecraft.class_5491
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin.perf;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_2583;
import net.minecraft.class_5348;
import net.minecraft.class_5481;
import net.minecraft.class_5491;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value={class_5491.class})
public class ReorderingUtilMixin {
    private static final Map<class_5348, class_5481> WILD$CACHE = new ConcurrentHashMap<class_5348, class_5481>(2048);
    private static final int WILD$CACHE_LIMIT = 8192;

    @Inject(method={"reorder"}, at={@At(value="HEAD")}, cancellable=true)
    private static void wild$skipBidi(class_5348 class_53482, boolean bl, CallbackInfoReturnable<class_5481> callbackInfoReturnable) {
        if (class_53482 == null) {
            callbackInfoReturnable.setReturnValue(class_5481.field_26385);
            return;
        }
        class_5481 class_54812 = WILD$CACHE.get(class_53482);
        if (class_54812 != null) {
            callbackInfoReturnable.setReturnValue(class_54812);
            return;
        }
        class_5481 class_54813 = ReorderingUtilMixin.wild$buildLtr(class_53482);
        if (WILD$CACHE.size() >= 8192) {
            WILD$CACHE.clear();
        }
        WILD$CACHE.put(class_53482, class_54813);
        callbackInfoReturnable.setReturnValue(class_54813);
    }

    private static class_5481 wild$buildLtr(class_5348 class_53482) {
        ArrayList arrayList = new ArrayList(4);
        class_53482.method_27658((class_25832, string) -> {
            if (!string.isEmpty()) {
                arrayList.add(class_5481.method_30747((String)string, (class_2583)class_25832));
            }
            return Optional.empty();
        }, class_2583.field_24360);
        if (arrayList.isEmpty()) {
            return class_5481.field_26385;
        }
        if (arrayList.size() == 1) {
            return (class_5481)arrayList.get(0);
        }
        return class_5481.method_30749(arrayList);
    }
}

