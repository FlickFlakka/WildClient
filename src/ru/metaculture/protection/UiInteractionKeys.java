/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import lombok.Generated;
import org.wild.module.api.Module;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;

public final class UiInteractionKeys {
    public static String primaryVal() {
        return "search:focus";
    }

    public static String secondaryVal() {
        return "avatar:hover";
    }

    public static String tertiaryVal() {
        return "logo:debug:reveal";
    }

    public static String marginVal() {
        return "logo:debug:hover";
    }

    public static String weightVal() {
        return "autobuy:tab:hover";
    }

    public static String paramVal() {
        return "autobuy:tab:active";
    }

    public static String extraVal() {
        return "bots:tab:hover";
    }

    public static String limitVal() {
        return "bots:tab:active";
    }

    public static String speedVal() {
        return "audit:panel:open";
    }

    public static String widthVal() {
        return "audit:log-viewer:open";
    }

    public static String chunkVal() {
        return "themes:tab:hover";
    }

    public static String blockRef() {
        return "themes:tab:active";
    }

    public static String primaryVal(ModuleCategory linkC) {
        return "category:hover:" + linkC.name();
    }

    public static String secondaryVal(ModuleCategory linkC) {
        return "category:active:" + linkC.name();
    }

    public static String primaryVal(int n) {
        return "theme:hover:" + n;
    }

    public static String secondaryVal(int n) {
        return "theme:active:" + n;
    }

    public static String primaryVal(Module module) {
        return "module:expand:" + System.identityHashCode(module);
    }

    public static String secondaryVal(Module module) {
        return "module:hover:" + System.identityHashCode(module);
    }

    public static String tertiaryVal(Module module) {
        return "module:enabled:" + System.identityHashCode(module);
    }

    public static String marginVal(Module module) {
        return "module:gear:" + System.identityHashCode(module);
    }

    public static String weightVal(Module module) {
        return "module:gear:hover:" + System.identityHashCode(module);
    }

    public static String primaryVal(Setting nodeA) {
        return "setting:value:" + System.identityHashCode(nodeA);
    }

    public static String secondaryVal(Setting nodeA) {
        return "setting:hover:" + System.identityHashCode(nodeA);
    }

    public static String tertiaryVal(Setting nodeA) {
        return "setting:control:hover:" + System.identityHashCode(nodeA);
    }

    public static String marginVal(Setting nodeA) {
        return "setting:vis:" + System.identityHashCode(nodeA);
    }

    public static String primaryVal(Setting nodeA, int n) {
        return "mb:chip:" + System.identityHashCode(nodeA) + ":" + n;
    }

    public static String secondaryVal(Setting nodeA, int n) {
        return "mb:chip:hover:" + System.identityHashCode(nodeA) + ":" + n;
    }

    public static String tertiaryVal(Setting nodeA, int n) {
        return "mode:option:hover:" + System.identityHashCode(nodeA) + ":" + n;
    }

    public static String paramVal(Module module) {
        return "module:svis:" + System.identityHashCode(module);
    }

    public static String extraVal(Module module) {
        return "module:card:entry:" + System.identityHashCode(module);
    }

    public static String limitVal(Module module) {
        return "module:card:transition:" + System.identityHashCode(module);
    }

    public static String holderVal() {
        return "search:text";
    }

    public static String weightVal(Setting nodeA) {
        return "mode:exp:" + System.identityHashCode(nodeA);
    }

    public static String timerVal() {
        return "theme:panel:open";
    }

    public static String anchorVal() {
        return "theme:search:focus";
    }

    public static String weightRef() {
        return "theme:search:text";
    }

    public static String paramVal(Setting nodeA) {
        return "slider:elastic:" + System.identityHashCode(nodeA);
    }

    public static String extraVal(Setting nodeA) {
        return "slider:drag:" + System.identityHashCode(nodeA);
    }

    public static String limitVal(Setting nodeA) {
        return "cp:expand:" + System.identityHashCode(nodeA);
    }

    public static String speedVal(Setting nodeA) {
        return "cp:cx:" + System.identityHashCode(nodeA);
    }

    public static String widthVal(Setting nodeA) {
        return "cp:cy:" + System.identityHashCode(nodeA);
    }

    public static String chunkVal(Setting nodeA) {
        return "cp:hue:" + System.identityHashCode(nodeA);
    }

    public static String blockRef(Setting nodeA) {
        return "cp:alpha:" + System.identityHashCode(nodeA);
    }

    public static String bufferVal() {
        return "profile:expand";
    }

    public static String countVal() {
        return "tooltip:alpha";
    }

    public static String primaryVal(String string) {
        return "ab:catalog:entry:" + string;
    }

    public static String depthVal() {
        return "ab:panel";
    }

    public static String secondaryVal(String string) {
        return "ab:rule:entry:" + string;
    }

    public static String tertiaryVal(String string) {
        return "ab:slot:hover:" + string;
    }

    public static String marginVal(String string) {
        return "ab:rule:hover:" + string;
    }

    public static String weightVal(String string) {
        return "ab:delete:hover:" + string;
    }

    public static String paramVal(String string) {
        return "ab:status:hover:" + string;
    }

    public static String extraVal(String string) {
        return "ab:price:focus:" + string;
    }

    public static String descRef() {
        return "resize:handle:hover";
    }

    public static String activeVal() {
        return "resize:handle:active";
    }

    public static String radiusVal() {
        return "theme:resize:handle:hover";
    }

    public static String factorVal() {
        return "theme:resize:handle:active";
    }

    public static String sourceVal() {
        return "theme:foundry:open";
    }

    public static String extraRef() {
        return "theme:foundry:button:hover";
    }

    public static String phaseVal() {
        return "studio:open";
    }

    public static String limitRef() {
        return "studio:button:hover";
    }

    public static String paramRef() {
        return "account:button:hover";
    }

    @Generated
    private UiInteractionKeys() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}

