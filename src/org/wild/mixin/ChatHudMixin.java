/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_124
 *  net.minecraft.class_2558
 *  net.minecraft.class_2558$class_10609
 *  net.minecraft.class_2561
 *  net.minecraft.class_2568
 *  net.minecraft.class_2568$class_10613
 *  net.minecraft.class_2583
 *  net.minecraft.class_303
 *  net.minecraft.class_303$class_7590
 *  net.minecraft.class_338
 *  net.minecraft.class_5250
 *  net.minecraft.class_7469
 *  net.minecraft.class_7591
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 */
package org.wild.mixin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_124;
import net.minecraft.class_2558;
import net.minecraft.class_2561;
import net.minecraft.class_2568;
import net.minecraft.class_2583;
import net.minecraft.class_303;
import net.minecraft.class_338;
import net.minecraft.class_5250;
import net.minecraft.class_7469;
import net.minecraft.class_7591;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.wild.mixin.acceser.ChatHudAccessor;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ProtectInfoModule;
import ru.metaculture.protection.ChatHelperModule;
import ru.metaculture.protection.UnHookModule;

@Mixin(value={class_338.class})
public class ChatHudMixin extends class_338 {
    private static boolean litka$updating;
    private static String litka$lastMessageKey;
    private static int litka$lastMessageCount;
    String currentPrefix = WildClient.primaryVal.paramRef();
    private static final Pattern GENERAL_COORD_PATTERN;

    protected ChatHudMixin(net.minecraft.class_310 var1) {
        super(var1);
    }

    @ModifyVariable(method={"addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;Lnet/minecraft/client/gui/hud/MessageIndicator;)V"}, at=@At(value="HEAD"), argsOnly=true)
    private class_2561 litka$nameProtectAndExpand(class_2561 class_25612) {
        Object object;
        Object object2;
        Object object3;
        if (!WildClient.limitVal()) {
            return class_25612;
        }
        class_2561 class_25613 = ProtectInfoModule.primaryVal(class_25612);
        class_5250 class_52502 = class_25613.method_27661();
        String string = class_52502.getString();
        Matcher matcher = GENERAL_COORD_PATTERN.matcher(string);
        if (matcher.find()) {
            object3 = matcher.group(1);
            object2 = matcher.group(3);
            object = class_52502.method_10866().method_10958((class_2558)new class_2558.class_10609(this.currentPrefix + "gps " + (String)object3 + " " + (String)object2)).method_10949((class_2568)new class_2568.class_10613((class_2561)class_2561.method_43470((String)("§a[GPS] Click to place a marker at " + (String)object3 + ", " + (String)object2))));
            class_52502.method_10862((class_2583)object);
        }
        if (WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null && (object3 = WildClient.primaryVal.secondaryVal.primaryVal(ChatHelperModule.class)) != null && ((ChatHelperModule)object3).enabled && ChatHelperModule.activeVal.tertiaryVal() && string.contains("[More]")) {
            List<class_2561> list = new ArrayList<class_2561>();
            this.litka$extractHoverText(class_25613, list);
            for (class_2561 class_25614 : list) {
                String string2 = class_25614.getString();
                if (!string2.contains("Reason:") && !string2.contains("End:") && !string2.contains("[BAN]")) continue;
                class_52502.method_10852((class_2561)class_2561.method_43470((String)"\n").method_27692(class_124.field_1070));
                class_52502.method_10852(class_25614);
            }
        }
        return class_52502;
    }

    @Inject(method={"getMessageHistory"}, at={@At(value="RETURN")})
    private void litka$cleanHistoryOnUnhook(CallbackInfoReturnable<Object> callbackInfoReturnable) {
        Object object2;
        if (!WildClient.limitVal()) {
            return;
        }
        if (UnHookModule.depthVal && (object2 = callbackInfoReturnable.getReturnValue()) instanceof Collection) {
            Collection collection = (Collection)object2;
            String string = WildClient.primaryVal.paramRef();
            collection.removeIf(object -> {
                if (!(object instanceof String)) {
                    return false;
                }
                String string2 = (String)object;
                return string2.startsWith(string) || string2.startsWith("#");
            });
        }
    }

    @Inject(method={"addToMessageHistory"}, at={@At(value="HEAD")}, cancellable=true)
    private void litka$blockHistoryWhenUnhooked(String string, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (UnHookModule.depthVal && string != null && (string.startsWith(WildClient.primaryVal.paramRef()) || string.startsWith("#"))) {
            callbackInfo.cancel();
        }
    }

    private void litka$extractHoverText(class_2561 class_25612, List<class_2561> list) {
        boolean bl;
        class_2568.class_10613 class_256142;
        class_2561 class_25615;
        class_2568 class_25682;
        class_2583 class_25832 = class_25612.method_10866();
        if (class_25832 != null && class_25832.method_10969() != null && (class_25682 = class_25832.method_10969()) instanceof class_2568.class_10613 && (class_25615 = (class_256142 = (class_2568.class_10613)class_25682).comp_3510()) != null && !(bl = list.stream().anyMatch(class_25613 -> class_25613.getString().equals(class_25615.getString())))) {
            list.add(class_25615);
        }
        for (class_2561 sibling : class_25612.method_10855()) {
            this.litka$extractHoverText(sibling, list);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Inject(method={"addMessage(Lnet/minecraft/text/Text;Lnet/minecraft/network/message/MessageSignatureData;Lnet/minecraft/client/gui/hud/MessageIndicator;)V"}, at={@At(value="HEAD")}, cancellable=true)
    private void litka$mergeSpam(class_2561 class_25612, class_7469 class_74692, class_7591 class_75912, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (litka$updating) {
            return;
        }
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        ChatHelperModule wWWWwVWvWWVw = WildClient.primaryVal.secondaryVal.primaryVal(ChatHelperModule.class);
        if (wWWWwVWvWWVw == null || !wWWWwVWvWWVw.enabled || !ChatHelperModule.countVal.tertiaryVal()) {
            return;
        }
        String string = class_25612.getString();
        if (string == null || string.isBlank()) {
            return;
        }
        if (string.equals(litka$lastMessageKey)) {
            class_5250 class_52502 = class_25612.method_27661().method_10852((class_2561)class_2561.method_43470((String)(" [x" + ++litka$lastMessageCount + "]")).method_27692(class_124.field_1080));
            litka$updating = true;
            try {
                this.removeLastEntry();
                ((class_338)this).method_44811((class_2561)class_52502, class_74692, class_75912);
            }
            finally {
                litka$updating = false;
            }
            callbackInfo.cancel();
        } else {
            litka$lastMessageKey = string;
            litka$lastMessageCount = 1;
        }
    }

    @Inject(method={"clear"}, at={@At(value="HEAD")}, cancellable=true)
    private void litka$preserveChat(boolean bl, CallbackInfo callbackInfo) {
        if (!WildClient.limitVal()) {
            return;
        }
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return;
        }
        ChatHelperModule wWWWwVWvWWVw = WildClient.primaryVal.secondaryVal.primaryVal(ChatHelperModule.class);
        if (wWWWwVWvWWVw != null && wWWWwVWvWWVw.enabled && ChatHelperModule.depthVal.tertiaryVal()) {
            callbackInfo.cancel();
            return;
        }
        litka$lastMessageKey = null;
        litka$lastMessageCount = 0;
    }

    private void removeLastEntry() {
        List<class_303.class_7590> list;
        ChatHudAccessor chatHudAccessor = (ChatHudAccessor)((Object)this);
        List<class_303> list2 = chatHudAccessor.litka$getMessages();
        if (!list2.isEmpty()) {
            list2.remove(0);
        }
        if (!(list = chatHudAccessor.litka$getVisibleMessages()).isEmpty()) {
            class_303.class_7590 class_75902;
            do {
                class_75902 = list.remove(0);
            } while (!list.isEmpty() && !class_75902.comp_898());
        }
    }

    static {
        GENERAL_COORD_PATTERN = Pattern.compile("(-?\\d+)[\\s,]+(-?\\d+)[\\s,]+(-?\\d+)");
    }
}

