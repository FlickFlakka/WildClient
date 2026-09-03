/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_156
 *  net.minecraft.class_2561
 *  net.minecraft.class_342
 *  net.minecraft.class_364
 *  net.minecraft.class_4185
 *  net.minecraft.class_4185$class_7840
 *  net.minecraft.class_437
 *  net.minecraft.class_5369$class_5371
 *  net.minecraft.class_5375
 *  net.minecraft.class_7919
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.gen.Invoker
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyVariable
 *  org.spongepowered.asm.mixin.injection.Redirect
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package org.wild.mixin;

import java.io.File;
import java.nio.file.Path;
import java.util.Locale;
import java.util.stream.Stream;
import net.minecraft.class_156;
import net.minecraft.class_2561;
import net.minecraft.class_342;
import net.minecraft.class_364;
import net.minecraft.class_4185;
import net.minecraft.class_437;
import net.minecraft.class_5369;
import net.minecraft.class_5375;
import net.minecraft.class_7919;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.wild.mixin.acceser.MessageAccessor;
import ru.metaculture.protection.UnHookModule;

@Mixin(value={class_5375.class})
public abstract class PackScreenMixin
extends class_437 {
    @Unique
    private static final Logger LOGGER = LoggerFactory.getLogger(PackScreenMixin.class);
    @Unique
    private static final class_2561 OPEN_FOLDER = class_2561.method_43471((String)"pack.openFolder");
    @Unique
    private static final class_2561 FOLDER_INFO = class_2561.method_43471((String)"pack.folderInfo");
    @Unique
    private static final class_2561 SEARCH_TITLE = class_2561.method_43470((String)"Search resource packs");
    @Unique
    private static final class_2561 SEARCH_PLACEHOLDER = class_2561.method_43470((String)"Search...");
    @Unique
    private class_342 wild$packSearchField;
    @Unique
    private String wild$packSearchQuery = "";
    @Shadow
    private Path field_25474;

    protected PackScreenMixin(class_2561 class_25612) {
        super(class_25612);
    }

    @Invoker(value="updatePackLists")
    public abstract void wild$updatePackLists();

    @Inject(method={"init"}, at={@At(value="RETURN")})
    private void wild$addPackSearch(CallbackInfo callbackInfo) {
        if (UnHookModule.depthVal) {
            return;
        }
        this.wild$packSearchField = new class_342(this.field_22793, 0, 0, 160, 20, SEARCH_TITLE);
        this.wild$packSearchField.method_1880(128);
        this.wild$packSearchField.method_47404(SEARCH_PLACEHOLDER);
        this.wild$packSearchField.method_1852(this.wild$packSearchQuery);
        this.wild$packSearchField.method_1863(string -> {
            this.wild$packSearchQuery = string == null ? "" : string;
            this.wild$updatePackLists();
        });
        this.wild$positionPackSearchField();
        this.method_37063(this.wild$packSearchField);
    }

    @Inject(method={"refreshWidgetPositions"}, at={@At(value="RETURN")})
    private void wild$refreshPackSearchPosition(CallbackInfo callbackInfo) {
        this.wild$positionPackSearchField();
    }

    @Inject(method={"tick"}, at={@At(value="TAIL")})
    private void wild$tickPackSearchVisibility(CallbackInfo callbackInfo) {
        this.wild$syncPackSearchVisibility();
    }

    @ModifyVariable(method={"updatePackList"}, at=@At(value="HEAD"), argsOnly=true, ordinal=0, require=0)
    private Stream<class_5369.class_5371> wild$filterPackList(Stream<class_5369.class_5371> stream) {
        String string;
        if (UnHookModule.depthVal) {
            return stream;
        }
        String string2 = string = this.wild$packSearchQuery == null ? "" : this.wild$packSearchQuery.trim().toLowerCase(Locale.ROOT);
        if (string.isEmpty()) {
            return stream;
        }
        return stream.filter(class_53712 -> this.wild$matchesPackSearch((class_5369.class_5371)class_53712, string));
    }

    @Unique
    private void wild$positionPackSearchField() {
        if (this.wild$packSearchField == null) {
            return;
        }
        int n = Math.min(180, Math.max(120, this.field_22789 / 5));
        this.wild$packSearchField.method_55445(n, 20);
        this.wild$packSearchField.method_46421(this.field_22789 - n - 8);
        this.wild$packSearchField.method_46419(8);
    }

    @Unique
    private void wild$syncPackSearchVisibility() {
        boolean bl;
        if (this.wild$packSearchField == null) {
            return;
        }
        this.wild$packSearchField.field_22764 = bl = !UnHookModule.depthVal;
        this.wild$packSearchField.field_22763 = bl;
        if (!bl) {
            this.wild$packSearchField.method_25365(false);
        }
    }

    @Unique
    private boolean wild$matchesPackSearch(class_5369.class_5371 class_53712, String string) {
        if (class_53712 == null) {
            return false;
        }
        return this.wild$contains(class_53712.method_48276(), string) || this.wild$contains(class_53712.method_29650(), string) || this.wild$contains(class_53712.method_29651(), string);
    }

    @Unique
    private boolean wild$contains(class_2561 class_25612, String string) {
        return class_25612 != null && this.wild$contains(class_25612.getString(), string);
    }

    @Unique
    private boolean wild$contains(String string, String string2) {
        return string != null && string.toLowerCase(Locale.ROOT).contains(string2);
    }

    @Redirect(method={"init"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/widget/ButtonWidget$Builder;build()Lnet/minecraft/client/gui/widget/ButtonWidget;"))
    private class_4185 redirectOpenFolderButton(class_4185.class_7840 class_78402) {
        class_2561 class_25612 = ((MessageAccessor)class_78402).getMessage();
        if (class_25612.equals((Object)OPEN_FOLDER)) {
            return class_4185.method_46430((class_2561)OPEN_FOLDER, class_41852 -> {
                File file = UnHookModule.depthVal && UnHookModule.descRef != null ? UnHookModule.descRef : this.field_25474.toFile();
                if (!file.exists()) {
                    file.mkdirs();
                }
                LOGGER.info("Opening folder: {}", (Object)file.getPath());
                class_156.method_668().method_672(file);
            }).method_46436(class_7919.method_47407((class_2561)FOLDER_INFO)).method_46431();
        }
        return class_78402.method_46431();
    }
}

