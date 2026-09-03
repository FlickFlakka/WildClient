/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_239
 *  net.minecraft.class_243
 *  net.minecraft.class_3966
 *  net.minecraft.class_4184
 *  org.joml.Matrix4f
 */
package ru.metaculture.protection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.class_1297;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3966;
import net.minecraft.class_4184;
import org.joml.Matrix4f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.HitRefractionRenderer;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.NvvNNvNnnNnN;
import ru.metaculture.protection.TracerEffect;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.TracerLine;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.BlockBreakEvent;
import ru.metaculture.protection.RenderWorldLastEvent;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AttackEffect", secondaryVal="Nice effects at the impact point", tertiaryVal=ModuleCategory.Visuals)
public class AttackEffectModule
extends Module {
    private static final String paramRef = "Torus";
    private static final String groupVal = "Plasma";
    private static final int layerVal = 6061311;
    private static final int slotVal = 6748116;
    private static final long themeVal = 30L;
    private static final double stageVal = 9.0;
    public final ModeSetting countVal = new ModeSetting("Mode", "Torus", "Torus", "Plasma");
    public final FloatSetting depthVal = new FloatSetting("Wave radius", 1.8f, 0.1f, 3.5f, 0.05f, false).primaryVal(() -> !this.countVal.secondaryVal(paramRef));
    public final FloatSetting descRef = new FloatSetting("Refraction strength", 0.06f, 0.01f, 0.16f, 0.001f, false).primaryVal(() -> !this.countVal.secondaryVal(paramRef));
    public final FloatSetting activeVal = new FloatSetting("Duration", 420.0f, 200.0f, 1600.0f, 10.0f, false).primaryVal(() -> !this.countVal.secondaryVal(paramRef));
    public final BoolSetting radiusVal = new BoolSetting("Spectral dispersion", true).primaryVal(() -> !this.countVal.secondaryVal(paramRef));
    public final BoolSetting factorVal = new BoolSetting("Not through player", true).primaryVal(() -> !this.countVal.secondaryVal(paramRef));
    public final FloatSetting sourceVal = new FloatSetting("Plasma radius", 1.4f, 1.0f, 3.0f, 0.05f, false).primaryVal(() -> !this.countVal.secondaryVal(groupVal));
    public final FloatSetting extraRef = new FloatSetting("Plasma temperature", 1.0f, 0.5f, 2.0f, 0.05f, false).primaryVal(() -> !this.countVal.secondaryVal(groupVal));
    public final FloatSetting phaseVal = new FloatSetting("Plasma brightness", 0.8f, 0.3f, 1.6f, 0.02f, false).primaryVal(() -> !this.countVal.secondaryVal(groupVal));
    public final FloatSetting limitRef = new FloatSetting("Plasma duration", 480.0f, 220.0f, 900.0f, 10.0f, false).primaryVal(() -> !this.countVal.secondaryVal(groupVal));
    private final List<TracerEffect> widthRef = new CopyOnWriteArrayList<TracerEffect>();
    private final List<TracerLine> trackVal = new CopyOnWriteArrayList<TracerLine>();
    private long modeRef;
    private int angleVal = Integer.MIN_VALUE;
    private int heightRef;

    public AttackEffectModule() {
        Setting[] nvUuvVvuuNArray = new Setting[10];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        nvUuvVvuuNArray[5] = this.factorVal;
        nvUuvVvuuNArray[6] = this.sourceVal;
        nvUuvVvuuNArray[7] = this.extraRef;
        nvUuvVvuuNArray[8] = this.phaseVal;
        nvUuvVvuuNArray[9] = this.limitRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(BlockBreakEvent coreG) {
        if (coreG == null) {
            return;
        }
        this.primaryVal(coreG.tertiaryVal());
    }

    public void primaryVal(class_1297 class_12972) {
        if (!this.enabled || class_12972 == null || AttackEffectModule.mc.field_1724 == null || AttackEffectModule.mc.field_1687 == null) {
            return;
        }
        if (class_12972 == AttackEffectModule.mc.field_1724) {
            return;
        }
        long l = System.currentTimeMillis();
        if (class_12972.method_5628() == this.angleVal) {
            if (l - this.modeRef < 30L) {
                return;
            }
        }
        this.angleVal = class_12972.method_5628();
        this.modeRef = l;
        class_243 class_2432 = AttackEffectModule.mc.field_1724.method_5828(1.0f).method_1029();
        if (this.countVal.secondaryVal(groupVal)) {
            this.secondaryVal(class_12972, class_2432, l);
        } else {
            this.primaryVal(class_12972, class_2432, l);
        }
    }

    private void primaryVal(class_1297 class_12972, class_243 class_2432, long l) {
        class_243 class_2433 = class_12972.method_5829().method_1005();
        TracerEffect raftJ = new TracerEffect(class_2433, class_2432, l, (long)this.activeVal.marginVal, this.depthVal.marginVal, this.descRef.marginVal, this.holderVal());
        this.widthRef.add(raftJ);
        while (this.widthRef.size() > 10) {
            this.widthRef.remove(0);
        }
    }

    private void secondaryVal(class_1297 class_12972, class_243 class_2432, long l) {
        class_243 class_2433 = this.primaryVal(class_12972, class_2432);
        this.heightRef = this.heightRef + 1 & 0x3FF;
        float f = (float)this.heightRef * 7.31f % 41.0f;
        TracerLine sackA = new TracerLine(class_2433, class_2432, l, (long)this.limitRef.marginVal, this.sourceVal.marginVal, this.extraRef.marginVal, this.phaseVal.marginVal, f, this.blockRef());
        this.trackVal.add(sackA);
        while (this.trackVal.size() > 12) {
            this.trackVal.remove(0);
        }
    }

    private class_243 primaryVal(class_1297 class_12972, class_243 class_2432) {
        class_3966 class_39662;
        class_239 class_2392 = AttackEffectModule.mc.field_1765;
        if (class_2392 instanceof class_3966 && (class_39662 = (class_3966)class_2392).method_17782() == class_12972) {
            return class_39662.method_17784();
        }
        class_238 class_2382 = class_12972.method_5829();
        class_243 class_2433 = AttackEffectModule.mc.field_1724.method_33571();
        class_243 class_2434 = class_2433.method_1019(class_2432.method_1021(9.0));
        return class_2382.method_992(class_2433, class_2434).orElse(class_2382.method_1005());
    }

    @Subscribe
    public void primaryVal(RenderWorldLastEvent partI) {
        if (!this.enabled || partI == null) {
            return;
        }
        long l = System.currentTimeMillis();
        this.widthRef.removeIf(raftJ -> raftJ.secondaryVal(l));
        this.trackVal.removeIf(sackA -> sackA.secondaryVal(l));
        if (this.widthRef.isEmpty() && this.trackVal.isEmpty()) {
            return;
        }
        class_4184 class_41842 = partI.weightVal().primaryVal();
        if (class_41842 == null) {
            return;
        }
        class_243 class_2432 = class_41842.method_19326();
        Matrix4f matrix4f = partI.extraVal();
        Matrix4f matrix4f2 = partI.limitVal();
        float f = (float)(l % 100000L) / 1000.0f;
        if (!this.widthRef.isEmpty()) {
            HitRefractionRenderer.primaryVal().primaryVal(mc, this.widthRef, matrix4f, matrix4f2, class_2432, this.radiusVal.tertiaryVal(), this.factorVal.tertiaryVal(), f);
        }
        if (!this.trackVal.isEmpty()) {
            NvvNNvNnnNnN.primaryVal().primaryVal(mc, this.trackVal, matrix4f, matrix4f2, class_2432, f);
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.widthRef.clear();
        this.trackVal.clear();
    }

    private int blockRef() {
        return this.primaryVal(6748116);
    }

    private int holderVal() {
        return this.primaryVal(6061311);
    }

    private int primaryVal(int n) {
        try {
            if (WildClient.primaryVal != null && WildClient.primaryVal.chunkVal != null) {
                NvVNvUvunNNu nvVNvUvunNNu = WildClient.primaryVal.chunkVal.secondaryVal();
                if (nvVNvUvunNNu == NvVNvUvunNNu.CUSTOM) {
                    return WildClient.primaryVal.chunkVal.secondaryVal.limitVal() & 0xFFFFFF;
                }
                if (nvVNvUvunNNu != null) {
                    if (nvVNvUvunNNu.primaryVal() != null) {
                        return nvVNvUvunNNu.primaryVal().getRGB() & 0xFFFFFF;
                    }
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return n;
    }

    private boolean primaryVal(int n, int n2) {
        int n3 = Math.abs((n >> 16 & 0xFF) - (n2 >> 16 & 0xFF));
        int n4 = Math.abs((n >> 8 & 0xFF) - (n2 >> 8 & 0xFF));
        int n5 = Math.abs((n & 0xFF) - (n2 & 0xFF));
        return n3 <= 3 && n4 <= 3 && n5 <= 3;
    }
}

