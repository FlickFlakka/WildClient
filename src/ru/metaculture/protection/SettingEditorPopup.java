/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonPrimitive
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.SequencedCollection;
import net.minecraft.class_310;
import org.wild.module.api.Module;
import ru.metaculture.protection.KeybindPopupRenderer;
import ru.metaculture.protection.HsbaColor;
import ru.metaculture.protection.MenuModule;
import ru.metaculture.protection.NvvUnVuUvU;
import ru.metaculture.protection.FloatFieldWidget;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.HudElementRenderer;
import ru.metaculture.protection.PopupPlacement;
import ru.metaculture.protection.VnVvnNNuVuUu;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.SetFieldWidget;
import ru.metaculture.protection.StringListSetting;
import ru.metaculture.protection.BoolFieldWidget;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.SpringPhysicsParams;
import ru.metaculture.protection.SpringAnimatedFloat;
import ru.metaculture.protection.KeybindTargetModel;
import ru.metaculture.protection.EasingPresets;
import ru.metaculture.protection.MouseUpdateEvent;
import ru.metaculture.protection.BoolSetting;
import ru.metaculture.protection.FrameTaskScheduler;
import ru.metaculture.protection.KeybindMode;

public final class SettingEditorPopup {
    static final SpringPhysicsParams primaryVal = SpringPhysicsParams.primaryVal(2.2f, 0.72f);
    private static final SpringPhysicsParams secondaryVal = SpringPhysicsParams.primaryVal(1.9f, 0.68f);
    private static final float tertiaryVal = 16.0f;
    private static final float marginVal = 8.0f;
    private static final float weightVal = 8.0f;
    private static final float paramVal = 0.001f;
    private static final long extraVal = 1200000000L;
    private final SpringAnimatedFloat limitVal;
    private final SpringAnimatedFloat speedVal;
    private final SpringAnimatedFloat widthVal;
    private final SpringAnimatedFloat chunkVal;
    private final SpringAnimatedFloat blockRef;
    private final SpringAnimatedFloat holderVal;
    private final SpringAnimatedFloat timerVal;
    private final PopupPlacement anchorVal;
    private KeybindTargetModel weightRef;
    private KeybindPopupRenderer.WildClient bufferVal;
    private KeybindPopupRenderer.cursorVal countVal = new KeybindPopupRenderer.cursorVal(0.0f, 0.0f, 0.0f, 0.0f);
    private HudElementRenderer depthVal;
    private float descRef;
    private float activeVal;
    private float radiusVal = Float.NaN;
    private float factorVal = Float.NaN;
    private float sourceVal = 1.0f;
    private boolean extraRef;
    private boolean phaseVal;
    private boolean limitRef;
    private long paramRef;
    private double groupVal = -1.0;
    private double layerVal = -1.0;

    private static SpringAnimatedFloat limitVal() {
        SpringAnimatedFloat raftI = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), secondaryVal, 0.0f, 0.0f, 1.0f, 5.0E-4f, 5.0E-4f);
        raftI.primaryVal(EasingPresets.tertiaryVal);
        return raftI;
    }

    SettingEditorPopup(SpringAnimatedFloat raftI) {
        this.limitVal = Objects.requireNonNull(raftI, "visibilityAnimator");
        this.speedVal = SettingEditorPopup.limitVal();
        this.widthVal = SettingEditorPopup.limitVal();
        this.chunkVal = SettingEditorPopup.limitVal();
        this.blockRef = SettingEditorPopup.limitVal();
        this.holderVal = SettingEditorPopup.limitVal();
        this.timerVal = SettingEditorPopup.limitVal();
        this.anchorVal = new PopupPlacement(16.0f, 8.0f, 8.0f);
    }

    private void speedVal() {
        this.depthVal = null;
        if (this.weightRef == null || !this.weightRef.blockRef()) {
            return;
        }
        Setting nodeA = this.weightRef.tertiaryVal();
        if (nodeA instanceof BoolSetting) {
            BoolSetting vvNnnUNnVvn2 = (BoolSetting)nodeA;
            this.depthVal = new BoolFieldWidget(this.weightRef, vvNnnUNnVvn2);
        } else if (nodeA instanceof FloatSetting) {
            FloatSetting itemA = (FloatSetting)nodeA;
            this.depthVal = new FloatFieldWidget(this.weightRef, itemA);
        } else if (nodeA instanceof ModeSetting) {
            ModeSetting twigG = (ModeSetting)nodeA;
            this.depthVal = new NvvUnVuUvU(this.weightRef, twigG);
        } else if (nodeA instanceof StringListSetting) {
            StringListSetting nuunVnvU2 = (StringListSetting)nodeA;
            this.depthVal = new SetFieldWidget(this.weightRef, nuunVnvU2);
        }
    }

    private float widthVal() {
        if (this.depthVal == null) {
            return 0.0f;
        }
        return Math.max(0.0f, this.depthVal.weightVal());
    }

    private void chunkVal() {
        block5: {
            block4: {
                if (this.depthVal == null) break block4;
                if (this.bufferVal != null) break block5;
            }
            return;
        }
        KeybindPopupRenderer.cursorVal panelVal = this.bufferVal.valueContent();
        if (panelVal.marginVal() <= 0.0f) {
            return;
        }
        this.depthVal.primaryVal(panelVal);
    }

    private boolean secondaryVal(double d, double d2, int n) {
        if (this.depthVal == null) {
            return false;
        }
        if (this.depthVal.extraVal()) {
            if (this.depthVal.primaryVal(d, d2, n)) {
                return true;
            }
            return true;
        }
        if (this.bufferVal != null) {
            if (this.bufferVal.valueContent().primaryVal(d, d2)) {
                return this.depthVal.primaryVal(d, d2, n);
            }
        }
        return false;
    }

    private boolean secondaryVal(double d, double d2, double d3, double d4) {
        if (this.depthVal == null) {
            return false;
        }
        if (this.depthVal.extraVal()) {
            if (this.depthVal.primaryVal(d, d2, d3, d4)) {
                return true;
            }
            return true;
        }
        if (this.bufferVal != null) {
            if (this.bufferVal.valueContent().primaryVal(d, d2)) {
                return this.depthVal.primaryVal(d, d2, d3, d4);
            }
        }
        return false;
    }

    public static SettingEditorPopup primaryVal() {
        return WildClient.primaryVal;
    }

    public synchronized void primaryVal(Module module, double d, double d2, int n, int n2) {
        Objects.requireNonNull(module, "module");
        KeybindTargetModel unNVnvNVNvVV2 = KeybindTargetModel.primaryVal(module);
        this.primaryVal(unNVnvNVNvVV2, d, d2, n, n2);
    }

    public synchronized void primaryVal(Module module, Setting nodeA, double d, double d2, Object object) {
        class_310 class_3102 = class_310.method_1551();
        int n = 1;
        int n2 = 1;
        if (class_3102 != null && class_3102.method_22683() != null) {
            n = Math.max(1, class_3102.method_22683().method_4489());
            n2 = Math.max(1, class_3102.method_22683().method_4506());
        }
        this.primaryVal(module, nodeA, d, d2, n, n2, object);
    }

    public synchronized void primaryVal(Module module, Setting nodeA, double d, double d2, int n, int n2, Object object) {
        Objects.requireNonNull(module, "module");
        Objects.requireNonNull(nodeA, "setting");
        Object object2 = object != null ? object : SettingEditorPopup.primaryVal(nodeA);
        Object object3 = SettingEditorPopup.secondaryVal(nodeA);
        int n3 = -1;
        int n4 = Math.max(1, n);
        int n5 = Math.max(1, n2);
        KeybindTargetModel unNVnvNVNvVV2 = KeybindTargetModel.primaryVal(module, nodeA, object2, object3, n3, KeybindMode.TOGGLE);
        this.primaryVal(unNVnvNVNvVV2, d, d2, n4, n5);
    }

    private void primaryVal(KeybindTargetModel unNVnvNVNvVV2, double d, double d2, int n, int n2) {
        this.weightRef = Objects.requireNonNull(unNVnvNVNvVV2, "newModel");
        this.extraRef = false;
        this.limitRef = false;
        this.paramRef = 0L;
        this.phaseVal = false;
        VnVvnNNuVuUu.primaryVal().primaryVal(false);
        this.speedVal();
        KeybindPopupRenderer.WildClient modeVal = KeybindPopupRenderer.primaryVal(this.weightRef, 0.0f, 0.0f, this.widthVal());
        float f = modeVal.bounds().tertiaryVal();
        float f2 = modeVal.bounds().marginVal();
        this.radiusVal = SettingEditorPopup.primaryVal(d);
        this.factorVal = SettingEditorPopup.primaryVal(d2);
        this.sourceVal = this.depthVal();
        this.primaryVal(f, f2, n, n2);
        this.bufferVal = KeybindPopupRenderer.primaryVal(this.weightRef, this.descRef, this.activeVal, this.widthVal());
        this.countVal = this.bufferVal.field();
        this.chunkVal();
        this.timerVal();
        this.bufferVal();
        this.timerVal.tertiaryVal(1.0f);
        this.limitVal.tertiaryVal(1.0f);
    }

    private static Object primaryVal(Setting nodeA) {
        if (nodeA instanceof BoolSetting) {
            return ((BoolSetting)nodeA).tertiaryVal();
        }
        if (nodeA instanceof ModeSetting) {
            return ((ModeSetting)nodeA).weightVal;
        }
        if (nodeA instanceof FloatSetting) {
            return (double)((FloatSetting)nodeA).marginVal;
        }
        if (nodeA instanceof StringListSetting) {
            return new LinkedHashSet<String>(((StringListSetting)nodeA).extraVal);
        }
        if (nodeA instanceof ColorSetting) {
            ColorSetting nodeG = (ColorSetting)nodeA;
            return HsbaColor.primaryVal(nodeG.weightVal(), nodeG.holderVal, nodeG.timerVal, nodeG.anchorVal);
        }
        return null;
    }

    private static Object secondaryVal(Setting nodeA) {
        if (nodeA instanceof BoolSetting) {
            return Boolean.FALSE;
        }
        if (nodeA instanceof ModeSetting) {
            return ((ModeSetting)nodeA).weightVal != null ? ((ModeSetting)nodeA).weightVal : "";
        }
        if (nodeA instanceof FloatSetting) {
            return (double)((FloatSetting)nodeA).marginVal;
        }
        if (nodeA instanceof StringListSetting) {
            return new LinkedHashSet<String>(((StringListSetting)nodeA).extraVal);
        }
        if (nodeA instanceof ColorSetting) {
            ColorSetting nodeG = (ColorSetting)nodeA;
            return HsbaColor.primaryVal(nodeG.weightVal(), nodeG.holderVal, nodeG.timerVal, nodeG.anchorVal);
        }
        return null;
    }

    private static JsonElement primaryVal(Setting nodeA, Object object) {
        if (nodeA instanceof BoolSetting) {
            return new JsonPrimitive(Boolean.valueOf(SettingEditorPopup.secondaryVal(nodeA, object)));
        }
        if (nodeA instanceof FloatSetting) {
            return new JsonPrimitive((Number)SettingEditorPopup.primaryVal((FloatSetting)nodeA, object));
        }
        if (nodeA instanceof ModeSetting) {
            return new JsonPrimitive(SettingEditorPopup.primaryVal((ModeSetting)nodeA, object));
        }
        if (nodeA instanceof StringListSetting) {
            return SettingEditorPopup.primaryVal((StringListSetting)nodeA, object);
        }
        if (nodeA instanceof ColorSetting) {
            return SettingEditorPopup.tertiaryVal(nodeA, object);
        }
        return new JsonPrimitive(object != null ? object.toString() : "");
    }

    private static boolean secondaryVal(Setting nodeA, Object object) {
        if (object instanceof Boolean) {
            Boolean bl = (Boolean)object;
            return bl;
        }
        if (object instanceof Number) {
            Number number = (Number)object;
            return number.doubleValue() != 0.0;
        }
        if (nodeA instanceof BoolSetting) {
            return ((BoolSetting)nodeA).tertiaryVal();
        }
        return false;
    }

    private static JsonElement tertiaryVal(Setting nodeA, Object object) {
        HsbaColor nUvuNUvvUvvN;
        if (!(nodeA instanceof ColorSetting)) {
            throw new IllegalStateException("Expected HueSetting for colour type");
        }
        ColorSetting nodeG = (ColorSetting)nodeA;
        if (object instanceof HsbaColor) {
            HsbaColor nUvuNUvvUvvN2;
            nUvuNUvvUvvN = nUvuNUvvUvvN2 = (HsbaColor)object;
        } else if (object instanceof Number) {
            Number number = (Number)object;
            nUvuNUvvUvvN = HsbaColor.primaryVal(number.intValue());
        } else if (object instanceof String) {
            String string = (String)object;
            try {
                String string2 = string.startsWith("#") ? string.substring(1) : string;
                int n = (int)Long.parseUnsignedLong(string2, 16);
                int n2 = string2.length() > 6 ? n : 0xFF000000 | n;
                nUvuNUvvUvvN = HsbaColor.primaryVal(n2);
            }
            catch (NumberFormatException numberFormatException) {
                nUvuNUvvUvvN = HsbaColor.primaryVal(nodeG.weightVal(), nodeG.holderVal, nodeG.timerVal, nodeG.anchorVal);
            }
        } else {
            nUvuNUvvUvvN = HsbaColor.primaryVal(nodeG.weightVal(), nodeG.holderVal, nodeG.timerVal, nodeG.anchorVal);
        }
        return new JsonPrimitive((Number)nUvuNUvvUvvN.paramVal());
    }

    private static double primaryVal(FloatSetting itemA, Object object) {
        double d;
        double d2;
        double d3;
        double d4;
        block10: {
            block9: {
                if (object instanceof Number) {
                    Number number = (Number)object;
                    d4 = number.doubleValue();
                } else {
                    d4 = itemA.marginVal;
                }
                if (!Double.isFinite(d4)) {
                    d4 = itemA.marginVal;
                }
                d3 = itemA.weightVal;
                d2 = itemA.paramVal;
                d = itemA.extraVal;
                if (!Double.isFinite(d)) break block9;
                if (!(d <= 0.0)) break block10;
            }
            d = 1.0;
        }
        double d5 = Math.min(Math.max(d4, d3), d2);
        double d6 = Math.round((d5 - d3) / d);
        double d7 = d3 + d6 * d;
        if (d7 < d3) {
            d7 = d3;
        } else if (d7 > d2) {
            d7 = d2;
        }
        return d7;
    }

    private static String primaryVal(ModeSetting twigG, Object object) {
        String string;
        block3: {
            block2: {
                String string2 = string = object != null ? object.toString() : null;
                if (string == null || string.isBlank()) break block2;
                if (twigG.marginVal == null || twigG.marginVal.contains(string)) break block3;
            }
            string = twigG.weightVal != null ? twigG.weightVal : "";
        }
        return string;
    }

    private static String marginVal(Setting nodeA, Object object) {
        Object object2;
        Object object3 = object2 = object != null ? object : "";
        if (object2 == null) {
            return "";
        }
        return object2.toString();
    }

    private static JsonElement primaryVal(StringListSetting nuunVnvU2, Object object) {
        Collection<?> list;
        nuunVnvU2.tertiaryVal();
        if (object instanceof Collection) {
            list = (Collection<?>)object;
        } else {
            list = nuunVnvU2.extraVal != null ? nuunVnvU2.extraVal : List.of();
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        if (list != null) {
            for (Object iterator : list) {
                if (iterator == null) continue;
                String string = iterator.toString();
                if (nuunVnvU2.marginVal == null || !nuunVnvU2.marginVal.contains(string)) continue;
                linkedHashSet.add(string);
            }
        }
        if (linkedHashSet.isEmpty() && nuunVnvU2.extraVal != null) {
            linkedHashSet.addAll(nuunVnvU2.extraVal);
        }
        JsonArray jsonArray = new JsonArray();
        for (String string : linkedHashSet) {
            jsonArray.add(string);
        }
        return jsonArray;
    }

    private void primaryVal(float f, float f2, int n, int n2) {
        PopupPlacement.WildClient modeVal = this.anchorVal.primaryVal(this.radiusVal, this.factorVal, f, f2, n, n2, this.sourceVal);
        this.descRef = modeVal.x();
        this.activeVal = modeVal.y();
    }

    public synchronized boolean primaryVal(double d, double d2, int n) {
        if (!this.holderVal()) {
            return false;
        }
        if (this.bufferVal == null) {
            return false;
        }
        if (this.secondaryVal(d, d2, n)) {
            return true;
        }
        boolean bl = this.bufferVal.bounds().primaryVal(d, d2);
        if (!bl) {
            this.secondaryVal();
            return true;
        }
        if (n == 0) {
            if (this.countVal.primaryVal(d, d2)) {
                if (this.extraRef) {
                    this.weightRef();
                } else {
                    this.anchorVal();
                }
                return true;
            }
            if (this.bufferVal.toggleButton().primaryVal(d, d2)) {
                this.primaryVal(KeybindMode.TOGGLE);
                return true;
            }
            if (this.bufferVal.holdButton().primaryVal(d, d2)) {
                this.primaryVal(KeybindMode.HOLD);
                return true;
            }
            this.secondaryVal();
            return true;
        }
        if (n == 1) {
            this.secondaryVal();
            return true;
        }
        return bl;
    }

    public synchronized boolean primaryVal(double d, double d2, double d3, double d4) {
        if (!this.holderVal()) {
            return false;
        }
        if (this.secondaryVal(d, d2, d3, d4)) {
            return true;
        }
        return true;
    }

    public synchronized boolean primaryVal(MouseUpdateEvent vNuUUUVVunnV2) {
        Objects.requireNonNull(vNuUUUVVunnV2, "event");
        return this.marginVal();
    }

    public synchronized boolean primaryVal(int n, int n2, int n3, int n4) {
        if (!this.holderVal()) {
            return false;
        }
        if (!this.extraRef) {
            int n5 = SettingEditorPopup.blockRef();
            if (n5 != -1 && n == n5) {
                return false;
            }
            return this.weightRef != null;
        }
        if (n3 != 1) {
            return true;
        }
        if (n == 261 || n == 259 || n == 256) {
            this.weightRef.activeVal();
            this.limitRef = false;
            this.paramRef = 0L;
            this.weightRef();
            this.extraVal();
            return true;
        }
        if (n == -1) {
            return true;
        }
        if (this.primaryVal(n)) {
            this.limitRef = true;
            this.paramRef = System.nanoTime();
            return true;
        }
        this.weightRef.primaryVal(n);
        this.limitRef = false;
        this.paramRef = 0L;
        this.weightRef();
        this.extraVal();
        return true;
    }

    private static int blockRef() {
        MenuModule nnNvuuvuNu = MenuModule.anchorVal();
        if (nnNvuuvuNu == null) {
            return 344;
        }
        return nnNvuuvuNu.keyIndex > 0 ? nnNvuuvuNu.keyIndex : 344;
    }

    public synchronized void primaryVal(Renderer2D heightVal, FontObject twigJ, int n, int n2, float f) {
        boolean bl;
        Objects.requireNonNull(heightVal, "renderer");
        Objects.requireNonNull(twigJ, "defaultFont");
        if (this.weightRef == null) {
            if (this.phaseVal) {
                if (this.limitVal.primaryVal() <= 0.001f) {
                    this.countVal();
                }
            }
            return;
        }
        this.primaryVal(n, n2);
        float f2 = SettingEditorPopup.secondaryVal(this.limitVal.primaryVal());
        if (f2 <= 0.001f && this.limitVal.tertiaryVal() <= 0.0f) {
            if (this.phaseVal) {
                this.countVal();
            }
            return;
        }
        float f3 = this.widthVal();
        if (this.bufferVal == null || Math.abs(this.bufferVal.valueBlock().marginVal() - f3) > 0.001f) {
            this.bufferVal = KeybindPopupRenderer.primaryVal(this.weightRef, this.descRef, this.activeVal, f3);
            this.chunkVal();
        }
        if (this.depthVal != null) {
            this.depthVal.paramVal();
        }
        String string = this.extraRef ? "Press a key" : SettingEditorPopup.secondaryVal(this.weightRef.speedVal());
        this.countVal = KeybindPopupRenderer.primaryVal(this.bufferVal, heightVal, string);
        bl = this.countVal.primaryVal(this.groupVal, this.layerVal);
        boolean bl2 = this.bufferVal.toggleButton().primaryVal(this.groupVal, this.layerVal);
        boolean bl3 = this.bufferVal.holdButton().primaryVal(this.groupVal, this.layerVal);
        this.primaryVal(bl, bl2, bl3);
        float f4 = this.speedVal.primaryVal();
        float f5 = this.widthVal.primaryVal();
        float f6 = this.chunkVal.primaryVal();
        boolean bl4 = this.limitRef && System.nanoTime() - this.paramRef <= 1200000000L;
        String string2 = "";
        if (bl4) {
            string2 = "";
        }
        float f7 = this.blockRef.primaryVal();
        float f8 = this.holderVal.primaryVal();
        float f9 = this.timerVal.primaryVal() * f;
        KeybindPopupRenderer.VvunVVUvUNnv vvunVVUvUNnv = new KeybindPopupRenderer.VvunVVUvUNnv(f2, f9, this.extraRef, bl, bl2, bl3, f4, f5, f6, f7, f8, this.weightRef.widthVal(), string, string2, this.bufferVal.valueBlock().marginVal(), this.bufferVal.valueLabelBaseline(), this.countVal);
        KeybindPopupRenderer.primaryVal(heightVal, twigJ, this.weightRef, this.bufferVal, vvunVVUvUNnv);
        if (this.depthVal != null) {
            this.depthVal.primaryVal(heightVal, f2, 1.0f);
            this.depthVal.secondaryVal(heightVal, f2, 1.0f);
        }
        if (!bl4) {
            this.limitRef = false;
        }
    }

    public synchronized void primaryVal(double d, double d2) {
        this.groupVal = d;
        this.layerVal = d2;
        if (this.depthVal != null) {
            this.depthVal.primaryVal(d, d2);
        }
    }

    public synchronized void secondaryVal() {
        if (this.weightRef == null) {
            if (this.limitVal.primaryVal() <= 0.001f) {
                return;
            }
        }
        if (this.weightRef != null) {
            this.extraVal();
        }
        this.weightRef();
        this.primaryVal(false, false, false);
        this.timerVal.tertiaryVal(0.0f);
        this.limitVal.tertiaryVal(0.0f);
        this.phaseVal = true;
    }

    public synchronized void tertiaryVal() {
        if (this.weightRef == null && this.limitVal.primaryVal() <= 0.001f) {
            return;
        }
        if (this.weightRef != null) {
            this.extraVal();
        }
        this.weightRef();
        this.primaryVal(false, false, false);
        this.timerVal.secondaryVal(0.0f);
        this.limitVal.secondaryVal(0.0f);
        this.countVal();
    }

    public synchronized boolean marginVal() {
        if (this.weightRef != null) {
            return true;
        }
        return this.limitVal.primaryVal() > 0.001f;
    }

    public synchronized boolean weightVal() {
        return this.weightRef != null;
    }

    public synchronized KeybindPopupRenderer.WildClient paramVal() {
        return this.bufferVal;
    }

    public synchronized KeybindPopupRenderer.VvunVVUvUNnv primaryVal(float f) {
        int n;
        block5: {
            block4: {
                if (this.weightRef == null) break block4;
                if (this.bufferVal != null) break block5;
            }
            return null;
        }
        float f2 = SettingEditorPopup.secondaryVal(this.limitVal.primaryVal());
        boolean bl = this.countVal.primaryVal(this.groupVal, this.layerVal);
        boolean bl2 = this.bufferVal.toggleButton().primaryVal(this.groupVal, this.layerVal);
        boolean bl3 = this.bufferVal.holdButton().primaryVal(this.groupVal, this.layerVal);
        float f3 = this.speedVal.primaryVal();
        float f4 = this.widthVal.primaryVal();
        float f5 = this.chunkVal.primaryVal();
        String string = this.extraRef ? "Press a key" : ((n = this.weightRef.speedVal()) == -1 ? "None" : SettingEditorPopup.secondaryVal(n));
        n = this.limitRef && System.nanoTime() - this.paramRef <= 1200000000L ? 1 : 0;
        String string2 = "";
        if (n != 0) {
            string2 = "";
        }
        float f6 = this.blockRef.primaryVal();
        float f7 = this.holderVal.primaryVal();
        float f8 = this.timerVal.primaryVal() * f;
        return new KeybindPopupRenderer.VvunVVUvUNnv(f2, f8, this.extraRef, bl, bl2, bl3, f3, f4, f5, f6, f7, this.weightRef.widthVal(), string, string2, this.bufferVal.valueBlock().marginVal(), this.bufferVal.valueLabelBaseline(), this.countVal);
    }

    public synchronized void extraVal() {
        if (this.weightRef == null) {
            return;
        }
        if (!this.weightRef.anchorVal()) {
            return;
        }
        VnVvnNNuVuUu sackE = VnVvnNNuVuUu.primaryVal();
        if (this.weightRef.chunkVal()) {
            Module module = this.weightRef.secondaryVal();
            if (module != null) {
                sackE.primaryVal(module, this.weightRef.speedVal(), this.weightRef.widthVal());
            }
        } else if (this.weightRef.blockRef()) {
            Module module = this.weightRef.secondaryVal();
            Setting nodeA = this.weightRef.tertiaryVal();
            if (module != null) {
                if (nodeA != null) {
                    if (this.weightRef.radiusVal()) {
                        sackE.primaryVal(module.name, nodeA.primaryVal);
                    } else {
                        Object object = this.weightRef.limitVal();
                        if (object != null) {
                            SettingEditorPopup.weightVal(nodeA, object);
                            sackE.primaryVal(module, nodeA, this.weightRef.widthVal(), this.weightRef.speedVal(), object);
                        }
                    }
                }
            }
        }
        this.weightRef.depthVal();
    }

    private boolean holderVal() {
        if (this.weightRef != null) {
            return true;
        }
        return this.limitVal.primaryVal() > 0.001f && this.bufferVal != null;
    }

    private void primaryVal(int n, int n2) {
        if (this.weightRef == null || this.bufferVal == null) {
            return;
        }
        float f = this.descRef;
        float f2 = this.activeVal;
        this.sourceVal = this.depthVal();
        this.primaryVal(this.bufferVal.bounds().tertiaryVal(), this.bufferVal.bounds().marginVal(), n, n2);
        if (this.descRef != f || this.activeVal != f2) {
            this.bufferVal = KeybindPopupRenderer.primaryVal(this.weightRef, this.descRef, this.activeVal, this.widthVal());
            this.countVal = this.bufferVal.field();
            this.chunkVal();
        }
    }

    private void timerVal() {
        this.speedVal.tertiaryVal(0.0f);
        this.widthVal.tertiaryVal(0.0f);
        this.chunkVal.tertiaryVal(0.0f);
        this.timerVal.tertiaryVal(0.0f);
        this.speedVal.secondaryVal(0.0f);
        this.widthVal.secondaryVal(0.0f);
        this.chunkVal.secondaryVal(0.0f);
        this.timerVal.secondaryVal(0.0f);
    }

    private void primaryVal(boolean bl, boolean bl2, boolean bl3) {
        this.speedVal.tertiaryVal(bl ? 1.0f : 0.0f);
        this.widthVal.tertiaryVal(bl2 ? 1.0f : 0.0f);
        this.chunkVal.tertiaryVal(bl3 ? 1.0f : 0.0f);
    }

    private void anchorVal() {
        this.extraRef = true;
        this.limitRef = false;
        this.paramRef = 0L;
        VnVvnNNuVuUu.primaryVal().primaryVal(true);
    }

    private void weightRef() {
        if (!this.extraRef) {
            return;
        }
        this.extraRef = false;
        VnVvnNNuVuUu.primaryVal().primaryVal(false);
    }

    private void primaryVal(KeybindMode vvVUVuVvnnVN2) {
        if (this.weightRef == null || vvVUVuVvnnVN2 == null) {
            return;
        }
        this.weightRef.primaryVal(vvVUVuVvnnVN2);
        this.bufferVal();
        this.extraVal();
    }

    private void bufferVal() {
        if (this.weightRef == null) {
            return;
        }
        this.blockRef.tertiaryVal(this.weightRef.widthVal() == KeybindMode.TOGGLE ? 1.0f : 0.0f);
        this.holderVal.tertiaryVal(this.weightRef.widthVal() == KeybindMode.HOLD ? 1.0f : 0.0f);
    }

    private boolean primaryVal(int n) {
        return false;
    }

    private void countVal() {
        this.weightRef = null;
        this.bufferVal = null;
        this.countVal = new KeybindPopupRenderer.cursorVal(0.0f, 0.0f, 0.0f, 0.0f);
        this.depthVal = null;
        this.phaseVal = false;
        this.limitRef = false;
        this.paramRef = 0L;
        this.radiusVal = Float.NaN;
        this.factorVal = Float.NaN;
        this.sourceVal = 1.0f;
        this.timerVal();
    }

    private float depthVal() {
        float f = 1.0f;
        if (!Float.isFinite(f)) {
            return 1.0f;
        }
        if (f <= 0.001f) {
            return 1.0f;
        }
        return f;
    }

    private static float primaryVal(double d) {
        if (!Double.isFinite(d)) {
            return Float.NaN;
        }
        if (d > 3.4028234663852886E38) {
            return Float.MAX_VALUE;
        }
        if (d < -3.4028234663852886E38) {
            return -3.4028235E38f;
        }
        return (float)d;
    }

    private static float primaryVal(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        if (f > f3) {
            return f3;
        }
        return f;
    }

    private static float secondaryVal(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        return f;
    }

    private static String secondaryVal(int n) {
        if (n == -1) {
            return "None";
        }
        if (n >= 65) {
            if (n <= 90) {
                return String.valueOf((char)(65 + (n - 65)));
            }
        }
        if (n >= 48 && n <= 57) {
            return String.valueOf((char)(48 + (n - 48)));
        }
        return "Key " + n;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static void weightVal(Setting nodeA, Object object) {
        if (nodeA instanceof BoolSetting && object instanceof Boolean) {
            ((BoolSetting)nodeA).secondaryVal((Boolean)object);
            return;
        }
        if (nodeA instanceof ModeSetting) {
            if (object instanceof String) {
                ((ModeSetting)nodeA).weightVal = (String)object;
                if (((ModeSetting)nodeA).marginVal == null) return;
                if (!((ModeSetting)nodeA).marginVal.contains((String)object)) return;
                ((ModeSetting)nodeA).limitVal = ((ModeSetting)nodeA).marginVal.indexOf((String)object);
                return;
            }
        }
        if (nodeA instanceof FloatSetting && object instanceof Number) {
            double d = ((Number)object).doubleValue();
            ((FloatSetting)nodeA).marginVal = (float)Math.max((double)((FloatSetting)nodeA).weightVal, Math.min((double)((FloatSetting)nodeA).paramVal, d));
            return;
        }
        if (nodeA instanceof StringListSetting && object instanceof Collection) {
            ((StringListSetting)nodeA).extraVal = new ArrayList<String>((Collection)object);
            return;
        }
        if (!(nodeA instanceof ColorSetting)) return;
        if (!(object instanceof HsbaColor)) return;
        HsbaColor nUvuNUvvUvvN = (HsbaColor)object;
        ColorSetting nodeG = (ColorSetting)nodeA;
        nodeG.primaryVal(nUvuNUvvUvvN.primaryVal());
        nodeG.holderVal = nUvuNUvvUvvN.secondaryVal();
        nodeG.timerVal = nUvuNUvvUvvN.tertiaryVal();
        nodeG.anchorVal = nUvuNUvvUvvN.marginVal();
    }

    static final class WildClient {
        static final SettingEditorPopup primaryVal = new SettingEditorPopup(WildClient.primaryVal());

        private WildClient() {
        }

        private static SpringAnimatedFloat primaryVal() {
            SpringAnimatedFloat raftI = new SpringAnimatedFloat(FrameTaskScheduler.primaryVal(), SpringPhysicsParams.primaryVal(2.1f, 0.55f), 0.0f, 0.0f, 1.0f, 5.0E-4f, 5.0E-4f);
            raftI.primaryVal(EasingPresets.tertiaryVal);
            return raftI;
        }
    }
}

