/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.brigadier.Message
 *  com.mojang.brigadier.suggestion.Suggestions
 *  com.mojang.brigadier.suggestion.SuggestionsBuilder
 *  net.minecraft.class_2561
 *  net.minecraft.class_342
 *  net.minecraft.class_4717
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import com.mojang.brigadier.Message;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import java.util.concurrent.CompletableFuture;
import net.minecraft.class_2561;
import net.minecraft.class_342;
import net.minecraft.class_4717;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.UnHookModule;

@Mixin(value={class_4717.class})
public abstract class ChatInputSuggestorMixin {
    @Shadow
    @Final
    class_342 field_21599;
    @Shadow
    private CompletableFuture<Suggestions> field_21611;

    @Shadow
    public abstract void method_23920(boolean var1);

    @Inject(method={"refresh"}, at={@At(value="HEAD")}, cancellable=true)
    private void onRefresh(CallbackInfo callbackInfo) {
        String string;
        if (!WildClient.limitVal()) {
            return;
        }
        if (UnHookModule.depthVal) {
            return;
        }
        String string2 = this.field_21599.method_1882();
        if (string2.startsWith(string = WildClient.primaryVal.paramRef())) {
            int n = this.field_21599.method_1881();
            String string3 = string2.substring(0, n);
            int n2 = string3.lastIndexOf(32) + 1;
            if (n2 < 0) {
                n2 = 0;
            }
            SuggestionsBuilder suggestionsBuilder = new SuggestionsBuilder(string3, n2);
            String string4 = string3.substring(string.length());
            String[] stringArray = string4.split(" ", -1);
            String string5 = stringArray[0];
            if (stringArray.length <= 1) {
                for (ChatCommand coreC : WildClient.primaryVal.phaseVal().primaryVal()) {
                    if (!coreC.primaryVal().toLowerCase().startsWith(string5.toLowerCase())) continue;
                    suggestionsBuilder.suggest(string + coreC.primaryVal(), (Message)class_2561.method_43470((String)coreC.secondaryVal()));
                }
            } else {
                for (ChatCommand coreC : WildClient.primaryVal.phaseVal().primaryVal()) {
                    if (!coreC.primaryVal().equalsIgnoreCase(string5)) continue;
                    for (String string6 : coreC.primaryVal(stringArray)) {
                        suggestionsBuilder.suggest(string6);
                    }
                }
            }
            this.field_21611 = suggestionsBuilder.buildFuture();
            this.method_23920(false);
            callbackInfo.cancel();
        }
    }

    @Shadow
    public abstract void method_23933(boolean var1);

    @Inject(method={"refresh"}, at={@At(value="HEAD")}, cancellable=true)
    private void litka$hideSuggestionsOnUnhook(CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (UnHookModule.depthVal) {
            String string = this.field_21599.method_1882();
            String string2 = WildClient.primaryVal.paramRef();
            if (string != null && (string.startsWith(string2) || string.startsWith("#"))) {
                this.method_23933(false);
                callbackInfo.cancel();
            }
        }
    }
}

