/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.Objects;
import org.wild.module.api.Module;
import ru.metaculture.protection.KeybindPopupRenderer;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.HudElementRenderer;
import ru.metaculture.protection.VvnNUnUu;
import ru.metaculture.protection.SettingValueAccessor;
import ru.metaculture.protection.KeybindTargetModel;
import ru.metaculture.protection.SettingEditorOpener;

abstract class BoundFieldWidget<T>
implements HudElementRenderer {
    private static final SettingEditorOpener secondaryVal = (module, nodeA, d, d2, object) -> {};
    protected static final String primaryVal = "New Value";
    private final KeybindTargetModel tertiaryVal;
    private final VvnNUnUu marginVal;
    private KeybindPopupRenderer.cursorVal weightVal = new KeybindPopupRenderer.cursorVal(0.0f, 0.0f, 0.0f, 0.0f);

    BoundFieldWidget(KeybindTargetModel unNVnvNVNvVV2, VvnNUnUu vvnNUnUu) {
        this.tertiaryVal = Objects.requireNonNull(unNVnvNVNvVV2, "model");
        this.marginVal = Objects.requireNonNull(vvnNUnUu, "widget");
    }

    protected final KeybindTargetModel primaryVal() {
        return this.tertiaryVal;
    }

    protected final VvnNUnUu secondaryVal() {
        return this.marginVal;
    }

    protected final SettingEditorOpener tertiaryVal() {
        return secondaryVal;
    }

    protected static SettingEditorOpener marginVal() {
        return secondaryVal;
    }

    protected static Module primaryVal(KeybindTargetModel unNVnvNVNvVV2) {
        Module module = unNVnvNVNvVV2.secondaryVal();
        if (module == null) {
            throw new IllegalStateException("Bind popup model is missing module context");
        }
        return module;
    }

    @Override
    public void primaryVal(KeybindPopupRenderer.cursorVal panelVal) {
        Objects.requireNonNull(panelVal, "area");
        this.weightVal = panelVal;
        this.marginVal.primaryVal(panelVal.primaryVal(), panelVal.secondaryVal(), panelVal.tertiaryVal());
    }

    @Override
    public float weightVal() {
        return this.marginVal.secondaryVal();
    }

    @Override
    public void paramVal() {
        this.marginVal.primaryVal();
    }

    @Override
    public void primaryVal(double d, double d2) {
        this.marginVal.primaryVal(d, d2);
    }

    @Override
    public boolean primaryVal(double d, double d2, int n) {
        if (this.marginVal.weightVal()) {
            if (this.marginVal.secondaryVal(d, d2, n)) {
                return true;
            }
            return true;
        }
        if (!this.weightVal.primaryVal(d, d2)) {
            return false;
        }
        return this.marginVal.primaryVal(d, d2, n);
    }

    @Override
    public boolean primaryVal(double d, double d2, double d3, double d4) {
        if (this.marginVal.weightVal()) {
            if (this.marginVal.primaryVal(d, d2, d3, d4)) {
                return true;
            }
            return true;
        }
        if (!this.weightVal.primaryVal(d, d2)) {
            return false;
        }
        return this.marginVal.secondaryVal(d, d2, d3, d4);
    }

    @Override
    public void primaryVal(Renderer2D heightVal, float f, float f2) {
        this.marginVal.primaryVal(heightVal, f, f2, 0.0f);
    }

    @Override
    public void secondaryVal(Renderer2D heightVal, float f, float f2) {
        this.marginVal.primaryVal(heightVal, f, f2);
    }

    @Override
    public boolean extraVal() {
        return this.marginVal.weightVal();
    }

    protected static <V> SettingValueAccessor<V> primaryVal(final KeybindTargetModel unNVnvNVNvVV2, final V v, final FieldAccessor<V> modeVal) {
        Objects.requireNonNull(unNVnvNVNvVV2, "model");
        Objects.requireNonNull(modeVal, "adapter");
        return new SettingValueAccessor<V>(){

            @Override
            public V primaryVal() {
                return modeVal.primaryVal(unNVnvNVNvVV2);
            }

            @Override
            public void primaryVal(V v2) {
                modeVal.primaryVal(unNVnvNVNvVV2, v2);
            }

            @Override
            public V secondaryVal() {
                return v;
            }

            @Override
            public void tertiaryVal() {
            }
        };
    }

    @FunctionalInterface
    protected static interface FieldAccessor<V> {
        public V primaryVal(KeybindTargetModel var1);

        default public void primaryVal(KeybindTargetModel unNVnvNVNvVV2, V v) {
            unNVnvNVNvVV2.secondaryVal(v);
        }
    }
}

