/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10055
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1921
 *  net.minecraft.class_1937
 *  net.minecraft.class_2394
 *  net.minecraft.class_2398
 *  net.minecraft.class_243
 *  net.minecraft.class_2663
 *  net.minecraft.class_2960
 *  net.minecraft.class_3532
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_4608
 *  net.minecraft.class_5498
 *  net.minecraft.class_5599
 *  net.minecraft.class_5600
 *  net.minecraft.class_5602
 *  net.minecraft.class_591
 *  net.minecraft.class_630
 *  net.minecraft.class_742
 *  net.minecraft.class_7833
 *  net.minecraft.class_8685$class_7920
 *  net.minecraft.class_9848
 *  org.joml.Matrix4f
 *  org.joml.Quaternionfc
 */
package ru.metaculture.protection;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_10055;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1921;
import net.minecraft.class_1937;
import net.minecraft.class_2394;
import net.minecraft.class_2398;
import net.minecraft.class_2596;
import net.minecraft.class_243;
import net.minecraft.class_2663;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_5498;
import net.minecraft.class_5599;
import net.minecraft.class_5600;
import net.minecraft.class_5602;
import net.minecraft.class_591;
import net.minecraft.class_630;
import net.minecraft.class_742;
import net.minecraft.class_7833;
import net.minecraft.class_8685;
import net.minecraft.class_9848;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WildRenderLayers;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.WorldJoinEvent;
import ru.metaculture.protection.VertexBufferPool;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="DeadEffect", secondaryVal="Smooth soul exit from the player model on totem loss or death.", tertiaryVal=ModuleCategory.Visuals)
public final class DeadEffectModule
extends Module {
    private static final String countVal = "Totem";
    private static final String depthVal = "Death";
    private static final String descRef = "Self";
    private static final String activeVal = "Players";
    private static final long radiusVal = 180000000L;
    private static final long factorVal = 700000000L;
    private static final long sourceVal = 5000000000L;
    private static final float extraRef = (float)Math.PI * 2;
    private static final int phaseVal = 96;
    private static final int limitRef = 36;
    private final SettingGroup paramRef = new SettingGroup("Events", new BoolSetting("Totem", true), new BoolSetting("Death", true));
    private final SettingGroup groupVal = new SettingGroup("Targets", new BoolSetting("Self", true), new BoolSetting("Players", true));
    private final FloatSetting layerVal = new FloatSetting("Duration", 1.65f, 0.55f, 4.0f, 0.05f, false);
    private final FloatSetting slotVal = new FloatSetting("Rise", 1.85f, 0.6f, 4.0f, 0.05f, false);
    private final FloatSetting themeVal = new FloatSetting("Transparency", 0.74f, 0.15f, 1.0f, 0.01f, true);
    private final FloatSetting stageVal = new FloatSetting("Glow", 1.15f, 0.0f, 2.4f, 0.05f, false);
    private final FloatSetting widthRef = new FloatSetting("Particles", 34.0f, 0.0f, 90.0f, 1.0f, false);
    private final ColorSetting trackVal = new ColorSetting("Totem color", 31.0f, 0.82f, 1.0f);
    private final ColorSetting modeRef = new ColorSetting("Death color", 74.0f, 0.68f, 1.0f);
    private final Map<Integer, AccessGuardException> angleVal = new ConcurrentHashMap<Integer, AccessGuardException>();
    private final Map<Integer, VvunVVUvUNnv> heightRef = new ConcurrentHashMap<Integer, VvunVVUvUNnv>();
    private final Set<Integer> levelVal = ConcurrentHashMap.newKeySet();
    private class_5599 UuNnnVnuNNV;
    private class_591 depthRef;
    private class_591 speedRef;
    private VvunVVUvUNnv countRef;
    private VvunVVUvUNnv entryVal;

    public DeadEffectModule() {
        Setting[] nvUuvVvuuNArray = new Setting[9];
        nvUuvVvuuNArray[0] = this.paramRef;
        nvUuvVvuuNArray[1] = this.groupVal;
        nvUuvVvuuNArray[2] = this.layerVal;
        nvUuvVvuuNArray[3] = this.slotVal;
        nvUuvVvuuNArray[4] = this.themeVal;
        nvUuvVvuuNArray[5] = this.stageVal;
        nvUuvVvuuNArray[6] = this.widthRef;
        nvUuvVvuuNArray[7] = this.trackVal;
        nvUuvVvuuNArray[8] = this.modeRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        this.angleVal.clear();
        this.heightRef.clear();
        this.levelVal.clear();
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.angleVal.clear();
        this.heightRef.clear();
        this.levelVal.clear();
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(WorldJoinEvent coOCCcooOcOO2) {
        this.angleVal.clear();
        this.heightRef.clear();
        this.levelVal.clear();
    }

    /*
     * Enabled aggressive block sorting
     */
    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        if (DeadEffectModule.mc.field_1687 == null) return;
        if (uvUUuvnunU2 == null) return;
        if (uvUUuvnunU2.tertiaryVal()) {
            return;
        }
        class_2596<?> class_25962 = uvUUuvnunU2.marginVal();
        if (!(class_25962 instanceof class_2663)) return;
        class_2663 class_26632 = (class_2663)class_25962;
        class_1297 class_12972 = class_26632.method_11469((class_1937)DeadEffectModule.mc.field_1687);
        if (!(class_12972 instanceof class_1657)) return;
        class_1657 class_16572 = (class_1657)class_12972;
        if (!this.primaryVal(class_16572)) {
            return;
        }
        byte by = class_26632.method_11470();
        if (by == 35) {
            if (this.paramRef.secondaryVal(countVal)) {
                this.primaryVal(class_16572, WildClient.TOTEM);
                return;
            }
        }
        if (by != 3) return;
        if (!this.paramRef.secondaryVal(depthVal)) return;
        if (!DeadEffectModule.secondaryVal(class_16572)) return;
        this.primaryVal(class_16572, WildClient.DEATH);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (DeadEffectModule.mc.field_1687 == null || DeadEffectModule.mc.field_1724 == null) {
            this.angleVal.clear();
            this.levelVal.clear();
            return;
        }
        long l = System.nanoTime();
        this.primaryVal(l);
        for (class_1657 class_16572 : DeadEffectModule.mc.field_1687.method_18456()) {
            if (!this.primaryVal(class_16572)) continue;
            int n = class_16572.method_5628();
            if (DeadEffectModule.secondaryVal(class_16572)) {
                if (!this.levelVal.add(n) || !this.paramRef.secondaryVal(depthVal)) continue;
                this.primaryVal(class_16572, WildClient.DEATH);
                continue;
            }
            this.levelVal.remove(n);
        }
    }

    public static void primaryVal(class_10055 class_100552, class_591 class_5912, class_4587 class_45872, class_4597 class_45972, int n, int n2) {
        DeadEffectModule reedF = DeadEffectModule.blockRef();
        if (reedF != null) {
            reedF.primaryVal(class_100552, class_5912);
        }
    }

    private void primaryVal(class_10055 class_100552, class_591 class_5912) {
        block9: {
            block8: {
                if (!this.enabled) break block8;
                if (class_100552 != null && class_5912 != null && class_100552.field_53520 != null) break block9;
            }
            return;
        }
        if (class_100552.field_53542 || class_100552.field_53333 || class_100552.field_53461) {
            return;
        }
        VvunVVUvUNnv vvunVVUvUNnv = VvunVVUvUNnv.capture(class_5912, System.nanoTime());
        this.heightRef.put(class_100552.field_53528, vvunVVUvUNnv);
        AccessGuardException itemD = this.angleVal.get(class_100552.field_53528);
        if (itemD == null) {
            return;
        }
        if (itemD.marginVal == null) {
            itemD.marginVal = vvunVVUvUNnv;
        }
        if (itemD.weightVal == null) {
            itemD.weightVal = DelayedFuse.fromState(class_100552);
        }
        if (itemD.paramVal == null) {
            itemD.paramVal = class_100552.field_53520.comp_1626();
        }
        itemD.extraVal = DeadEffectModule.primaryVal(class_100552);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        if (!this.enabled || DeadEffectModule.mc.field_1687 == null || DeadEffectModule.mc.field_1724 == null || vvuuvuVVvvn == null || this.angleVal.isEmpty()) {
            return;
        }
        long l = System.nanoTime();
        this.primaryVal(l);
        if (this.angleVal.isEmpty()) {
            return;
        }
        class_4597.class_4598 class_45982 = VertexBufferPool.primaryVal();
        try {
            for (Map.Entry<Integer, AccessGuardException> entry : this.angleVal.entrySet()) {
                AccessGuardException itemD;
                int n = entry.getKey();
                if (n == DeadEffectModule.mc.field_1724.method_5628() && DeadEffectModule.mc.field_1690 != null) {
                    if (DeadEffectModule.mc.field_1690.method_31044() == class_5498.field_26664) {
                        continue;
                    }
                }
                if (this.primaryVal(itemD = entry.getValue(), vvuuvuVVvvn.tertiaryVal(), (class_4597)class_45982, l)) continue;
                this.angleVal.remove(n, itemD);
            }
        }
        finally {
            VertexBufferPool.secondaryVal();
        }
    }

    private boolean primaryVal(AccessGuardException itemD, class_4587 class_45872, class_4597 class_45972, long l) {
        VvunVVUvUNnv vvunVVUvUNnv;
        if (itemD == null || class_45872 == null || class_45972 == null || itemD.weightVal == null) {
            return false;
        }
        float f = (float)(l - itemD.secondaryVal) / 1.0E9f;
        float f2 = this.secondaryVal(itemD.primaryVal);
        float f3 = this.primaryVal(itemD.primaryVal);
        if (f >= f3) {
            return false;
        }
        float f4 = DeadEffectModule.secondaryVal(f / f3);
        float f5 = DeadEffectModule.secondaryVal(f / f2);
        float f6 = DeadEffectModule.primaryVal(f2 * 0.58f, f3, f);
        float f7 = DeadEffectModule.primaryVal(0.0f, 0.11f, f4);
        float f8 = 1.0f - f6;
        float f9 = DeadEffectModule.secondaryVal(f7 * f8 * this.themeVal.tertiaryVal());
        if (f9 <= 0.002f) {
            return true;
        }
        float f10 = DeadEffectModule.primaryVal(f5);
        float f11 = this.slotVal.tertiaryVal() * itemD.primaryVal.tertiaryVal * (f10 + f6 * 0.075f);
        float f12 = itemD.tertiaryVal + f * 2.15f;
        float f13 = (float)Math.sin(f12 * 1.7f) * (0.025f + f6 * 0.045f) * f10;
        float f14 = (float)Math.cos(f12 * 1.3f) * (0.025f + f6 * 0.045f) * f10;
        float f15 = 1.0f + (float)Math.sin((double)f4 * Math.PI * 3.0) * 0.022f * (1.0f - f4);
        float f16 = (f15 + itemD.primaryVal.marginVal * f10) * (1.0f + f6 * 0.055f);
        int n = this.tertiaryVal(itemD.primaryVal);
        this.primaryVal(class_45872, class_45972, itemD, f4, f9, f11, f12, f6);
        class_2960 class_29602 = itemD.paramVal;
        if (class_29602 == null) {
            return true;
        }
        class_591 class_5912 = this.tertiaryVal(itemD.extraVal);
        if (class_5912 == null) {
            return true;
        }
        class_1921 class_19212 = class_1921.method_42600((class_2960)class_29602);
        int n2 = DeadEffectModule.primaryVal(DeadEffectModule.primaryVal(0xFFFFFF, n, itemD.primaryVal.speedVal), f9 * itemD.primaryVal.limitVal * (1.0f - f6 * 0.22f));
        VvunVVUvUNnv vvunVVUvUNnv2 = vvunVVUvUNnv = itemD.marginVal != null ? itemD.marginVal : this.marginVal(itemD.extraVal);
        if (vvunVVUvUNnv != null) {
            vvunVVUvUNnv.apply(class_5912);
        }
        this.primaryVal(class_5912, class_45872, class_45972, class_19212, itemD.weightVal, 0xF000F0, class_4608.field_21444, f13, f11, f14, f16, n2);
        return true;
    }

    private void primaryVal(class_591 class_5912, class_4587 class_45872, class_4597 class_45972, class_1921 class_19212, DelayedFuse uunvUUVnuNn2, int n, int n2, float f, float f2, float f3, float f4, int n3) {
        if ((n3 >>> 24 & 0xFF) == 0) {
            return;
        }
        class_45872.method_22903();
        this.primaryVal(class_45872, uunvUUVnuNn2, f, f2, f3, f4);
        class_4588 class_45882 = class_45972.getBuffer(class_19212);
        class_5912.method_62100(class_45872, class_45882, n, n2, n3);
        class_45872.method_22909();
        if (class_45972 instanceof class_4597.class_4598) {
            class_4597.class_4598 class_45982 = (class_4597.class_4598)class_45972;
            class_45982.method_22994(class_19212);
        }
    }

    private void primaryVal(class_4587 class_45872, DelayedFuse uunvUUVnuNn2, float f, float f2, float f3, float f4) {
        class_4184 class_41842 = DeadEffectModule.mc.field_1773.method_19418();
        class_243 class_2432 = class_41842 == null ? class_243.field_1353 : class_41842.method_19326();
        class_45872.method_22904(uunvUUVnuNn2.x - class_2432.field_1352 + (double)f, uunvUUVnuNn2.y - class_2432.field_1351 + (double)f2, uunvUUVnuNn2.z - class_2432.field_1350 + (double)f3);
        class_45872.method_22905(uunvUUVnuNn2.baseScale, uunvUUVnuNn2.baseScale, uunvUUVnuNn2.baseScale);
        class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(180.0f - uunvUUVnuNn2.bodyYaw));
        class_45872.method_22905(-f4, -f4, f4);
        class_45872.method_46416(0.0f, -1.501f, 0.0f);
    }

    private class_591 tertiaryVal(boolean bl) {
        if (this.UuNnnVnuNNV == null) {
            this.UuNnnVnuNNV = new class_5599(class_5600.method_32073());
        }
        if (bl) {
            if (this.speedRef == null) {
                this.speedRef = new class_591(this.UuNnnVnuNNV.method_32072(class_5602.field_27581), true);
                this.entryVal = VvunVVUvUNnv.capture(this.speedRef, 0L);
            }
            return this.speedRef;
        }
        if (this.depthRef == null) {
            this.depthRef = new class_591(this.UuNnnVnuNNV.method_32072(class_5602.field_27577), false);
            this.countRef = VvunVVUvUNnv.capture(this.depthRef, 0L);
        }
        return this.depthRef;
    }

    private VvunVVUvUNnv marginVal(boolean bl) {
        this.tertiaryVal(bl);
        return bl ? this.entryVal : this.countRef;
    }

    private void primaryVal(class_1657 class_16572, WildClient modeVal) {
        block7: {
            block6: {
                if (class_16572 == null) break block6;
                if (this.primaryVal(class_16572)) break block7;
            }
            return;
        }
        int n = class_16572.method_5628();
        long l = System.nanoTime();
        AccessGuardException itemD = this.angleVal.get(n);
        if (itemD != null && itemD.primaryVal == modeVal && l - itemD.secondaryVal < 180000000L) {
            return;
        }
        VvunVVUvUNnv vvunVVUvUNnv = this.heightRef.get(n);
        if (vvunVVUvUNnv != null && l - vvunVVUvUNnv.capturedNanos > 700000000L) {
            vvunVVUvUNnv = null;
        }
        this.angleVal.put(n, new AccessGuardException(modeVal, l, (float)(ThreadLocalRandom.current().nextDouble() * Math.PI * 2.0), vvunVVUvUNnv, DelayedFuse.fromPlayer(class_16572), DeadEffectModule.tertiaryVal(class_16572), DeadEffectModule.marginVal(class_16572)));
        if (this.widthRef.tertiaryVal() > 0.5f) {
            double d = class_16572.method_23317();
            double d2 = class_16572.method_23318();
            double d3 = class_16572.method_23321();
            double d4 = Math.max(1.0, (double)class_16572.method_17682());
            mc.execute(() -> this.primaryVal(d, d2, d3, d4, modeVal));
        }
    }

    private void primaryVal(double d, double d2, double d3, double d4, WildClient modeVal) {
        if (DeadEffectModule.mc.field_1713 == null) {
            return;
        }
        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();
        int n = Math.max(0, Math.round(this.widthRef.tertiaryVal()));
        for (int i = 0; i < n; ++i) {
            double d5 = threadLocalRandom.nextDouble(Math.PI * 2);
            double d6 = threadLocalRandom.nextDouble(0.08, 0.56);
            double d7 = d + Math.cos(d5) * d6;
            double d8 = d2 + threadLocalRandom.nextDouble(0.08, d4 + 0.42);
            double d9 = d3 + Math.sin(d5) * d6;
            double d10 = threadLocalRandom.nextDouble(0.018, 0.07);
            double d11 = Math.cos(d5) * d10;
            double d12 = threadLocalRandom.nextDouble(0.045, 0.145) * (double)modeVal.holderVal;
            double d13 = Math.sin(d5) * d10;
            DeadEffectModule.mc.field_1713.method_3056(modeVal.primaryVal(i), d7, d8, d9, d11, d12, d13);
        }
    }

    private void primaryVal(long l) {
        Iterator<Map.Entry<Integer, AccessGuardException>> iterator = this.angleVal.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, AccessGuardException> entry2 = iterator.next();
            AccessGuardException itemD = entry2.getValue();
            float f = this.primaryVal(itemD.primaryVal) + 0.25f;
            if (!((float)(l - itemD.secondaryVal) > f * 1.0E9f)) continue;
            iterator.remove();
        }
        this.heightRef.entrySet().removeIf(entry -> l - ((VvunVVUvUNnv)entry.getValue()).capturedNanos > 5000000000L);
    }

    private void primaryVal(class_4587 class_45872, class_4597 class_45972, AccessGuardException itemD, float f, float f2, float f3, float f4, float f5) {
        if (class_45872 == null || itemD.weightVal == null || f2 <= 0.01f || DeadEffectModule.mc.field_1773 == null) {
            return;
        }
        class_4184 class_41842 = DeadEffectModule.mc.field_1773.method_19418();
        if (class_41842 == null) {
            return;
        }
        class_1921 class_19212 = WildRenderLayers.tertiaryVal();
        class_4588 class_45882 = class_45972.getBuffer(class_19212);
        Matrix4f matrix4f = class_45872.method_23760().method_23761();
        class_243 class_2432 = class_41842.method_19326();
        DelayedFuse uunvUUVnuNn2 = itemD.weightVal;
        float f6 = (float)(uunvUUVnuNn2.x - class_2432.field_1352);
        float f7 = (float)(uunvUUVnuNn2.y - class_2432.field_1351);
        float f8 = (float)(uunvUUVnuNn2.z - class_2432.field_1350);
        this.primaryVal(class_45882, matrix4f, itemD, f6, f7, f8, f, f2, f3);
        this.primaryVal(class_45882, matrix4f, itemD, f6, f7, f8, f, f2, f3, f4);
        this.secondaryVal(class_45882, matrix4f, itemD, f6, f7, f8, f, f2, f3);
        this.primaryVal(class_45882, matrix4f, itemD, f6, f7, f8, f, f2, f3, f4, f5);
        if (class_45972 instanceof class_4597.class_4598) {
            class_4597.class_4598 class_45982 = (class_4597.class_4598)class_45972;
            class_45982.method_22994(class_19212);
        }
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, AccessGuardException itemD, float f, float f2, float f3, float f4, float f5, float f6) {
        for (int i = 0; i < 3; ++i) {
            float f7 = DeadEffectModule.tertiaryVal(f4 * (1.22f + itemD.primaryVal.blockRef) + (float)i * 0.31f);
            float f8 = (1.0f - f7) * DeadEffectModule.primaryVal(0.0f, 0.18f, f7);
            float f9 = itemD.primaryVal.widthVal + f7 * itemD.primaryVal.chunkVal;
            float f10 = 0.02f + (1.0f - f7) * 0.045f;
            float f11 = f2 + 0.08f + f6 * (0.1f + (float)i * 0.075f) + (float)i * 0.16f;
            int n = DeadEffectModule.primaryVal(DeadEffectModule.primaryVal(this.tertiaryVal(itemD.primaryVal), itemD.primaryVal.timerVal, 0.35f + (float)i * 0.18f), f5 * f8 * 0.74f);
            this.primaryVal(class_45882, matrix4f, f, f11, f3, f9, f10, n);
        }
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, AccessGuardException itemD, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = 1.38f + f6 * 0.72f;
        for (int i = 0; i < 2; ++i) {
            float f9 = i == 0 ? 1.0f : -1.0f;
            int n = i == 0 ? itemD.primaryVal.weightRef : itemD.primaryVal.bufferVal;
            for (int j = 0; j < 36; ++j) {
                float f10 = (float)j / 36.0f;
                float f11 = (float)(j + 1) / 36.0f;
                float f12 = f7 + f9 * (f10 * ((float)Math.PI * 2) * 1.72f + f4 * ((float)Math.PI * 2) * 1.15f);
                float f13 = f7 + f9 * (f11 * ((float)Math.PI * 2) * 1.72f + f4 * ((float)Math.PI * 2) * 1.15f);
                float f14 = 0.34f + 0.13f * (float)Math.sin((double)f10 * Math.PI + (double)(f4 * 3.0f));
                float f15 = 0.34f + 0.13f * (float)Math.sin((double)f11 * Math.PI + (double)(f4 * 3.0f));
                float f16 = 0.032f + 0.018f * (1.0f - f4);
                float f17 = f2 + 0.12f + f10 * f8;
                float f18 = f2 + 0.12f + f11 * f8;
                float f19 = (float)Math.sin((double)f10 * Math.PI) * (1.0f - DeadEffectModule.primaryVal(0.86f, 1.0f, f4));
                int n2 = DeadEffectModule.primaryVal(DeadEffectModule.primaryVal(n, itemD.primaryVal.anchorVal, f10), f5 * f19 * 0.54f);
                int n3 = DeadEffectModule.primaryVal(DeadEffectModule.primaryVal(n, itemD.primaryVal.anchorVal, f11), f5 * f19 * 0.54f);
                this.primaryVal(class_45882, matrix4f, f, f3, f17, f18, f12, f13, f14, f15, f16, n2, n3);
            }
        }
    }

    private void secondaryVal(class_4588 class_45882, Matrix4f matrix4f, AccessGuardException itemD, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f2 + 0.08f + f6 * 0.08f;
        float f8 = f2 + 1.7f + f6 * 0.92f;
        float f9 = 0.1f + 0.055f * (1.0f - f4);
        int n = DeadEffectModule.primaryVal(itemD.primaryVal.timerVal, f5 * 0.04f);
        int n2 = DeadEffectModule.primaryVal(DeadEffectModule.primaryVal(this.tertiaryVal(itemD.primaryVal), 0xFFFFFF, 0.38f), f5 * 0.3f * (1.0f - f4 * 0.34f));
        this.primaryVal(class_45882, matrix4f, f - f9, f7, f3, f + f9, f7, f3, f + f9 * 0.32f, f8, f3, f - f9 * 0.32f, f8, f3, n, n, n2, n2);
        this.primaryVal(class_45882, matrix4f, f, f7, f3 - f9, f, f7, f3 + f9, f, f8, f3 + f9 * 0.32f, f, f8, f3 - f9 * 0.32f, n, n, n2, n2);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, AccessGuardException itemD, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        if (f8 <= 0.02f) {
            return;
        }
        int n = 18;
        for (int i = 0; i < n; ++i) {
            float f9 = DeadEffectModule.tertiaryVal(itemD.tertiaryVal * 0.137f + (float)i * 0.6180339f);
            float f10 = DeadEffectModule.tertiaryVal(f4 * (0.78f + f9 * 0.22f) + f9);
            float f11 = f7 * 0.78f + (float)i * 2.399963f + f10 * ((float)Math.PI * 2) * 0.62f;
            float f12 = 0.18f + f10 * (0.38f + f9 * 0.34f);
            float f13 = f + (float)Math.cos(f11) * f12;
            float f14 = f3 + (float)Math.sin(f11) * f12;
            float f15 = f2 + 0.52f + f6 * (0.45f + f9 * 0.28f) + f10 * (0.92f + f9 * 0.42f);
            float f16 = (0.025f + f9 * 0.035f) * (1.0f - f10 * 0.42f);
            float f17 = f5 * f8 * (1.0f - f10) * (0.3f + f9 * 0.28f) * this.stageVal.tertiaryVal();
            int n2 = DeadEffectModule.primaryVal(DeadEffectModule.primaryVal(itemD.primaryVal.timerVal, itemD.primaryVal.anchorVal, f9), f17);
            this.primaryVal(class_45882, matrix4f, f13, f15 + f16, f14, f13 + f16, f15, f14, f13, f15 - f16, f14, f13 - f16, f15, f14, n2, n2, n2, n2);
        }
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, int n) {
        if ((n >>> 24 & 0xFF) == 0) {
            return;
        }
        float f6 = Math.max(0.02f, f4 - f5);
        float f7 = f4 + f5;
        for (int i = 0; i < 96; ++i) {
            float f8 = (float)Math.PI * 2 * (float)i / 96.0f;
            float f9 = (float)Math.PI * 2 * (float)(i + 1) / 96.0f;
            float f10 = (float)Math.cos(f8);
            float f11 = (float)Math.sin(f8);
            float f12 = (float)Math.cos(f9);
            float f13 = (float)Math.sin(f9);
            this.primaryVal(class_45882, matrix4f, f + f10 * f6, f2, f3 + f11 * f6, f + f12 * f6, f2, f3 + f13 * f6, f + f12 * f7, f2, f3 + f13 * f7, f + f10 * f7, f2, f3 + f11 * f7, n, n, n, n);
        }
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n, int n2) {
        if ((n >>> 24 & 0xFF | n2 >>> 24 & 0xFF) == 0) {
            return;
        }
        float f10 = (float)Math.cos(f5);
        float f11 = (float)Math.sin(f5);
        float f12 = (float)Math.cos(f6);
        float f13 = (float)Math.sin(f6);
        this.primaryVal(class_45882, matrix4f, f + f10 * (f7 - f9), f3, f2 + f11 * (f7 - f9), f + f10 * (f7 + f9), f3, f2 + f11 * (f7 + f9), f + f12 * (f8 + f9), f4, f2 + f13 * (f8 + f9), f + f12 * (f8 - f9), f4, f2 + f13 * (f8 - f9), n, n, n2, n2);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, int n, int n2, int n3, int n4) {
        this.primaryVal(class_45882, matrix4f, f, f2, f3, n);
        this.primaryVal(class_45882, matrix4f, f4, f5, f6, n2);
        this.primaryVal(class_45882, matrix4f, f7, f8, f9, n3);
        this.primaryVal(class_45882, matrix4f, f10, f11, f12, n4);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, float f2, float f3, int n) {
        class_45882.method_22918(matrix4f, f, f2, f3).method_1336(DeadEffectModule.primaryVal(n), DeadEffectModule.secondaryVal(n), DeadEffectModule.tertiaryVal(n), n >>> 24 & 0xFF);
    }

    private boolean primaryVal(class_1657 class_16572) {
        if (class_16572 == null) {
            return false;
        }
        if (DeadEffectModule.mc.field_1724 != null && class_16572.method_5628() == DeadEffectModule.mc.field_1724.method_5628()) {
            return this.groupVal.secondaryVal(descRef);
        }
        return this.groupVal.secondaryVal(activeVal);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean secondaryVal(class_1657 class_16572) {
        if (class_16572 == null) return true;
        if (class_16572.method_31481()) return true;
        if (!class_16572.method_5805()) return true;
        if (class_16572.method_6032() <= 0.0f) return true;
        if (class_16572.field_6213 <= 0) return false;
        return true;
    }

    private float primaryVal(WildClient modeVal) {
        return this.secondaryVal(modeVal) + modeVal.secondaryVal;
    }

    private float secondaryVal(WildClient modeVal) {
        return Math.max(0.15f, this.layerVal.tertiaryVal() * modeVal.primaryVal);
    }

    private int tertiaryVal(WildClient modeVal) {
        return modeVal == WildClient.TOTEM ? this.trackVal.limitVal() : this.modeRef.limitVal();
    }

    private static DeadEffectModule blockRef() {
        block3: {
            block2: {
                if (ru.metaculture.protection.WildClient.primaryVal == null) break block2;
                if (ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null) break block3;
            }
            return null;
        }
        DeadEffectModule reedF = ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(DeadEffectModule.class);
        return reedF != null && reedF.enabled ? reedF : null;
    }

    private static class_2960 tertiaryVal(class_1657 class_16572) {
        if (class_16572 instanceof class_742) {
            class_742 class_7422 = (class_742)class_16572;
            return class_7422.method_52814().comp_1626();
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean marginVal(class_1657 class_16572) {
        if (!(class_16572 instanceof class_742)) return false;
        class_742 class_7422 = (class_742)class_16572;
        if (class_7422.method_52814().comp_1629() != class_8685.class_7920.field_41122) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean primaryVal(class_10055 class_100552) {
        if (class_100552 == null) return false;
        if (class_100552.field_53520 == null) return false;
        if (class_100552.field_53520.comp_1629() != class_8685.class_7920.field_41122) return false;
        return true;
    }

    private static int primaryVal(int n, float f) {
        return class_9848.method_61324((int)DeadEffectModule.marginVal(Math.round(DeadEffectModule.secondaryVal(f) * 255.0f)), (int)DeadEffectModule.primaryVal(n), (int)DeadEffectModule.secondaryVal(n), (int)DeadEffectModule.tertiaryVal(n));
    }

    private static int primaryVal(int n, int n2, float f) {
        float f2 = DeadEffectModule.secondaryVal(f);
        int n3 = Math.round((float)DeadEffectModule.primaryVal(n) + (float)(DeadEffectModule.primaryVal(n2) - DeadEffectModule.primaryVal(n)) * f2);
        int n4 = Math.round((float)DeadEffectModule.secondaryVal(n) + (float)(DeadEffectModule.secondaryVal(n2) - DeadEffectModule.secondaryVal(n)) * f2);
        int n5 = Math.round((float)DeadEffectModule.tertiaryVal(n) + (float)(DeadEffectModule.tertiaryVal(n2) - DeadEffectModule.tertiaryVal(n)) * f2);
        return n3 << 16 | n4 << 8 | n5;
    }

    private static int primaryVal(int n) {
        return n >> 16 & 0xFF;
    }

    private static int secondaryVal(int n) {
        return n >> 8 & 0xFF;
    }

    private static int tertiaryVal(int n) {
        return n & 0xFF;
    }

    private static int marginVal(int n) {
        return Math.max(0, Math.min(255, n));
    }

    private static float primaryVal(float f) {
        float f2 = 1.0f - DeadEffectModule.secondaryVal(f);
        return 1.0f - f2 * f2 * f2;
    }

    private static float primaryVal(float f, float f2, float f3) {
        float f4 = class_3532.method_15363((float)((f3 - f) / Math.max(1.0E-4f, f2 - f)), (float)0.0f, (float)1.0f);
        return f4 * f4 * (3.0f - 2.0f * f4);
    }

    private static float secondaryVal(float f) {
        if (!Float.isFinite(f)) {
            return 0.0f;
        }
        return class_3532.method_15363((float)f, (float)0.0f, (float)1.0f);
    }

    private static float tertiaryVal(float f) {
        return f - (float)Math.floor(f);
    }

    public enum WildClient {
    TOTEM(0.9f, 0.58f, 0.92f, 0.035f, 0.82f, 0.44f, 0.42f, 0.66f, 0.2f, 0.58f, 1.18f, 0.22f, 1.1f, 6815716, 0xFFFFFF, 16773226, 3669974, 0),
    DEATH(1.22f, 0.78f, 1.26f, 0.085f, 0.72f, 0.6f, 0.52f, 0.58f, 0.34f, 0.44f, 1.55f, 0.1f, 0.82f, 8693759, 0xF2F5FF, 16739278, 6484991, 1);
        final float primaryVal;
        final float secondaryVal;
        final float tertiaryVal;
        final float marginVal;
        final float weightVal;
        final float paramVal;
        final float extraVal;
        final float limitVal;
        final float speedVal;
        final float widthVal;
        final float chunkVal;
        final float blockRef;
        final float holderVal;
        final int timerVal;
        final int anchorVal;
        final int weightRef;
        final int bufferVal;
        final int countVal;
    private WildClient(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, int n2, int n3, int n4, int n5, int n6) {
            this.primaryVal = f;
            this.secondaryVal = f2;
            this.tertiaryVal = f3;
            this.marginVal = f4;
            this.weightVal = f5;
            this.paramVal = f6;
            this.extraVal = f7;
            this.limitVal = f8;
            this.speedVal = f9;
            this.widthVal = f10;
            this.chunkVal = f11;
            this.blockRef = f12;
            this.holderVal = f13;
            this.timerVal = n2;
            this.anchorVal = n3;
            this.weightRef = n4;
            this.bufferVal = n5;
            this.countVal = n6;
        }

        class_2394 primaryVal(int n) {
            int n2 = (n + this.countVal) % 5;
            if (this == TOTEM) {
                return switch (n2) {
                    case 0 -> class_2398.field_11220;
                    case 1 -> class_2398.field_11207;
                    case 2 -> class_2398.field_28479;
                    case 3 -> class_2398.field_29644;
                    default -> class_2398.field_11249;
                };
            }
            return switch (n2) {
                case 0 -> class_2398.field_23114;
                case 1 -> class_2398.field_22246;
                case 2 -> class_2398.field_23190;
                case 3 -> class_2398.field_23956;
                default -> class_2398.field_38002;
            };
        }}

    static final class VvunVVUvUNnv
     {
        final long capturedNanos;
        private final cursorVal head;
        private final cursorVal hat;
        private final cursorVal body;
        private final cursorVal rightArm;
        private final cursorVal leftArm;
        private final cursorVal rightLeg;
        private final cursorVal leftLeg;
        private final cursorVal leftSleeve;
        private final cursorVal rightSleeve;
        private final cursorVal leftPants;
        private final cursorVal rightPants;
        private final cursorVal jacket;

        private VvunVVUvUNnv(long l, cursorVal panelVal, cursorVal nvnNNunvv3, cursorVal nvnNNunvv4, cursorVal nvnNNunvv5, cursorVal nvnNNunvv6, cursorVal nvnNNunvv7, cursorVal nvnNNunvv8, cursorVal nvnNNunvv9, cursorVal nvnNNunvv10, cursorVal nvnNNunvv11, cursorVal nvnNNunvv12, cursorVal nvnNNunvv13) {
            this.capturedNanos = l;
            this.head = panelVal;
            this.hat = nvnNNunvv3;
            this.body = nvnNNunvv4;
            this.rightArm = nvnNNunvv5;
            this.leftArm = nvnNNunvv6;
            this.rightLeg = nvnNNunvv7;
            this.leftLeg = nvnNNunvv8;
            this.leftSleeve = nvnNNunvv9;
            this.rightSleeve = nvnNNunvv10;
            this.leftPants = nvnNNunvv11;
            this.rightPants = nvnNNunvv12;
            this.jacket = nvnNNunvv13;
        }

        static VvunVVUvUNnv capture(class_591 class_5912, long l) {
            return new VvunVVUvUNnv(l, cursorVal.capture(class_5912.field_3398), cursorVal.capture(class_5912.field_3394), cursorVal.capture(class_5912.field_3391), cursorVal.capture(class_5912.field_3401), cursorVal.capture(class_5912.field_27433), cursorVal.capture(class_5912.field_3392), cursorVal.capture(class_5912.field_3397), cursorVal.capture(class_5912.field_3484), cursorVal.capture(class_5912.field_3486), cursorVal.capture(class_5912.field_3482), cursorVal.capture(class_5912.field_3479), cursorVal.capture(class_5912.field_3483));
        }

        void apply(class_591 class_5912) {
            this.head.apply(class_5912.field_3398);
            this.hat.apply(class_5912.field_3394);
            this.body.apply(class_5912.field_3391);
            this.rightArm.apply(class_5912.field_3401);
            this.leftArm.apply(class_5912.field_27433);
            this.rightLeg.apply(class_5912.field_3392);
            this.leftLeg.apply(class_5912.field_3397);
            this.leftSleeve.apply(class_5912.field_3484);
            this.rightSleeve.apply(class_5912.field_3486);
            this.leftPants.apply(class_5912.field_3482);
            this.rightPants.apply(class_5912.field_3479);
            this.jacket.apply(class_5912.field_3483);
        }

        @Override
        public final String toString() {
            return "VvunVVUvUNnv[" + "capturedNanos=" + this.capturedNanos + ", " + "head=" + this.head + ", " + "hat=" + this.hat + ", " + "body=" + this.body + ", " + "rightArm=" + this.rightArm + ", " + "leftArm=" + this.leftArm + ", " + "rightLeg=" + this.rightLeg + ", " + "leftLeg=" + this.leftLeg + ", " + "leftSleeve=" + this.leftSleeve + ", " + "rightSleeve=" + this.rightSleeve + ", " + "leftPants=" + this.leftPants + ", " + "rightPants=" + this.rightPants + ", " + "jacket=" + this.jacket + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.capturedNanos, this.head, this.hat, this.body, this.rightArm, this.leftArm, this.rightLeg, this.leftLeg, this.leftSleeve, this.rightSleeve, this.leftPants, this.rightPants, this.jacket);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            VvunVVUvUNnv that = (VvunVVUvUNnv)object;
            return java.util.Objects.equals(this.capturedNanos, that.capturedNanos) && java.util.Objects.equals(this.head, that.head) && java.util.Objects.equals(this.hat, that.hat) && java.util.Objects.equals(this.body, that.body) && java.util.Objects.equals(this.rightArm, that.rightArm) && java.util.Objects.equals(this.leftArm, that.leftArm) && java.util.Objects.equals(this.rightLeg, that.rightLeg) && java.util.Objects.equals(this.leftLeg, that.leftLeg) && java.util.Objects.equals(this.leftSleeve, that.leftSleeve) && java.util.Objects.equals(this.rightSleeve, that.rightSleeve) && java.util.Objects.equals(this.leftPants, that.leftPants) && java.util.Objects.equals(this.rightPants, that.rightPants) && java.util.Objects.equals(this.jacket, that.jacket);}

        public long capturedNanos() {
            return this.capturedNanos;
        }

        public cursorVal head() {
            return this.head;
        }

        public cursorVal hat() {
            return this.hat;
        }

        public cursorVal body() {
            return this.body;
        }

        public cursorVal rightArm() {
            return this.rightArm;
        }

        public cursorVal leftArm() {
            return this.leftArm;
        }

        public cursorVal rightLeg() {
            return this.rightLeg;
        }

        public cursorVal leftLeg() {
            return this.leftLeg;
        }

        public cursorVal leftSleeve() {
            return this.leftSleeve;
        }

        public cursorVal rightSleeve() {
            return this.rightSleeve;
        }

        public cursorVal leftPants() {
            return this.leftPants;
        }

        public cursorVal rightPants() {
            return this.rightPants;
        }

        public cursorVal jacket() {
            return this.jacket;
        }
    }

    static final class AccessGuardException {
        final WildClient primaryVal;
        final long secondaryVal;
        final float tertiaryVal;
        VvunVVUvUNnv marginVal;
        DelayedFuse weightVal;
        class_2960 paramVal;
        boolean extraVal;

        AccessGuardException(WildClient modeVal, long l, float f, VvunVVUvUNnv vvunVVUvUNnv, DelayedFuse uunvUUVnuNn2, class_2960 class_29602, boolean bl) {
            this.primaryVal = modeVal;
            this.secondaryVal = l;
            this.tertiaryVal = f;
            this.marginVal = vvunVVUvUNnv;
            this.weightVal = uunvUUVnuNn2;
            this.paramVal = class_29602;
            this.extraVal = bl;
        }
    }

    static final class DelayedFuse
     {
        final double x;
        final double y;
        final double z;
        final float bodyYaw;
        final float baseScale;

        private DelayedFuse(double d, double d2, double d3, float f, float f2) {
            this.x = d;
            this.y = d2;
            this.z = d3;
            this.bodyYaw = f;
            this.baseScale = f2;
        }

        static DelayedFuse fromPlayer(class_1657 class_16572) {
            float f = Module.mc.method_61966().method_60637(true);
            double d = class_3532.method_16436((double)f, (double)class_16572.field_6014, (double)class_16572.method_23317());
            double d2 = class_3532.method_16436((double)f, (double)class_16572.field_6036, (double)class_16572.method_23318());
            double d3 = class_3532.method_16436((double)f, (double)class_16572.field_5969, (double)class_16572.method_23321());
            float f2 = class_3532.method_17821((float)f, (float)class_16572.field_6220, (float)class_16572.field_6283);
            return new DelayedFuse(d, d2, d3, f2, Math.max(0.01f, class_16572.method_55693()));
        }

        static DelayedFuse fromState(class_10055 class_100552) {
            return new DelayedFuse(class_100552.field_53325, class_100552.field_53326, class_100552.field_53327, class_100552.field_53446, Math.max(0.01f, class_100552.field_53453));
        }

        @Override
        public final String toString() {
            return "DelayedFuse[" + "x=" + this.x + ", " + "y=" + this.y + ", " + "z=" + this.z + ", " + "bodyYaw=" + this.bodyYaw + ", " + "baseScale=" + this.baseScale + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.x, this.y, this.z, this.bodyYaw, this.baseScale);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            DelayedFuse that = (DelayedFuse)object;
            return java.util.Objects.equals(this.x, that.x) && java.util.Objects.equals(this.y, that.y) && java.util.Objects.equals(this.z, that.z) && java.util.Objects.equals(this.bodyYaw, that.bodyYaw) && java.util.Objects.equals(this.baseScale, that.baseScale);}

        public double x() {
            return this.x;
        }

        public double y() {
            return this.y;
        }

        public double z() {
            return this.z;
        }

        public float bodyYaw() {
            return this.bodyYaw;
        }

        public float baseScale() {
            return this.baseScale;
        }
    }

    record cursorVal(float originX, float originY, float originZ, float pitch, float yaw, float roll, float xScale, float yScale, float zScale, boolean visible, boolean hidden) {
        static cursorVal capture(class_630 class_6302) {
            return new cursorVal(class_6302.field_3657, class_6302.field_3656, class_6302.field_3655, class_6302.field_3654, class_6302.field_3675, class_6302.field_3674, class_6302.field_37938, class_6302.field_37939, class_6302.field_37940, class_6302.field_3665, class_6302.field_38456);
        }

        void apply(class_630 class_6302) {
            class_6302.field_3657 = this.originX;
            class_6302.field_3656 = this.originY;
            class_6302.field_3655 = this.originZ;
            class_6302.field_3654 = this.pitch;
            class_6302.field_3675 = this.yaw;
            class_6302.field_3674 = this.roll;
            class_6302.field_37938 = this.xScale;
            class_6302.field_37939 = this.yScale;
            class_6302.field_37940 = this.zScale;
            class_6302.field_3665 = this.visible;
            class_6302.field_38456 = this.hidden;
        }
    }
}

