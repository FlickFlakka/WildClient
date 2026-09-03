/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import org.wild.module.api.Module;
import ru.metaculture.protection.Setting;

@FunctionalInterface
public interface SettingEditorOpener {
    public void openForSetting(Module var1, Setting var2, double var3, double var5, Object var7);
}

