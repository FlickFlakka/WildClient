/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_437
 */
package ru.metaculture.protection;

import java.nio.file.Files;
import java.nio.file.Path;
import net.minecraft.class_2561;
import net.minecraft.class_437;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.RotationLabStorage;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.RequiresRole;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.ButtonSetting;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.RotationLabScreen;
import ru.metaculture.protection.BoolSetting;

@RequiresRole(tertiaryVal={"lichoday"})
@ModuleRegister(primaryVal="RotationLab", tertiaryVal=ModuleCategory.Player, secondaryVal="Human rotation pattern trainer", marginVal={ModuleBadge.NEW})
public class RotationLabModule
extends Module {
    private final StringFilterSetting countVal = new StringFilterSetting("Asset", "rotation_lab").primaryVal(48);
    private final ButtonSetting depthVal = new ButtonSetting("Delete Asset", 0).secondaryVal("Delete").primaryVal(this::countVal);
    private final ModeSetting descRef;
    private final BoolSetting activeVal;
    private final FloatSetting radiusVal;
    private final FloatSetting factorVal;
    private final FloatSetting sourceVal;
    private RotationLabScreen extraRef;

    public RotationLabModule() {
        String[] stringArray = new String[8];
        stringArray[0] = "Mixed";
        stringArray[1] = "Flick";
        stringArray[2] = "Tracking";
        stringArray[3] = "Micro";
        stringArray[4] = "Vertical";
        stringArray[5] = "Diagonal";
        stringArray[6] = "Idle";
        stringArray[7] = "Attack";
        this.descRef = new ModeSetting("Mode", "Mixed", stringArray);
        this.activeVal = new BoolSetting("Auto Capture", true);
        this.radiusVal = new FloatSetting("Target Radius", 11.0f, 5.0f, 30.0f, 1.0f, false);
        this.factorVal = new FloatSetting("Spread", 78.0f, 25.0f, 95.0f, 1.0f, false);
        this.sourceVal = new FloatSetting("Targets", 80.0f, 5.0f, 500.0f, 1.0f, false);
        Setting[] nvUuvVvuuNArray = new Setting[7];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        nvUuvVvuuNArray[5] = this.factorVal;
        nvUuvVvuuNArray[6] = this.sourceVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        if (mc != null) {
            mc.execute(this::depthVal);
        }
    }

    @Override
    public void onDisable() {
        if (this.extraRef != null) {
            this.extraRef.primaryVal();
        }
        if (this.extraRef != null && RotationLabModule.mc.field_1755 == this.extraRef) {
            mc.method_1507(null);
        }
        this.extraRef = null;
        super.onDisable();
    }

    private void depthVal() {
        if (!this.enabled || mc.method_22683() == null) {
            return;
        }
        this.extraRef = new RotationLabScreen(this);
        mc.method_1507((class_437)this.extraRef);
        if (RotationLabModule.mc.field_1724 != null) {
            RotationLabModule.mc.field_1724.method_7353(class_2561.method_30163((String)"RotationLab opened"), true);
        }
    }

    public void primaryVal(RotationLabScreen vuuvVuVVVnuU2) {
        if (this.extraRef == vuuvVuVVVnuU2) {
            this.extraRef = null;
        }
        if (this.enabled) {
            this.setEnabled(false);
        }
    }

    public String blockRef() {
        return this.countVal.tertiaryVal();
    }

    public String holderVal() {
        return this.descRef.tertiaryVal();
    }

    public boolean timerVal() {
        return this.activeVal.tertiaryVal();
    }

    public int anchorVal() {
        return Math.max(5, Math.round(this.radiusVal.tertiaryVal()));
    }

    public float weightRef() {
        return Math.max(0.25f, Math.min(0.95f, this.factorVal.tertiaryVal() / 100.0f));
    }

    public int bufferVal() {
        return Math.max(1, Math.round(this.sourceVal.tertiaryVal()));
    }

    public void countVal() {
        Path path = RotationLabStorage.primaryVal(this.blockRef());
        try {
            if (this.extraRef != null) {
                this.extraRef.secondaryVal();
            }
            if (Files.deleteIfExists(path)) {
                ChatLogger.primaryVal("[RotationLab] Deleted " + String.valueOf(path.getFileName()));
            } else {
                ChatLogger.primaryVal("[RotationLab] Asset not found: " + String.valueOf(path.getFileName()));
            }
        }
        catch (Throwable throwable) {
            ChatLogger.primaryVal("[RotationLab] Delete failed: " + throwable.getClass().getSimpleName());
        }
    }
}

