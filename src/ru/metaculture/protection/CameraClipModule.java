/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.CameraClipEvent;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="CameraClip", secondaryVal="Camera passes through blocks", tertiaryVal=ModuleCategory.Player)
public class CameraClipModule
extends Module {
    @Subscribe
    public void primaryVal(CameraClipEvent duneJ) {
        duneJ.secondaryVal();
    }
}

