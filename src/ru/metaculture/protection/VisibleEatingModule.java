/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_1839
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 */
package ru.metaculture.protection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1839;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.NuNvVUuUUnun;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.RenderHudEvent;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.NeumorphicThemeRenderer;
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.Easing;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.ThemeSettings;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.AnimatedValue;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="VisibleEating", secondaryVal="Shows food and potions that players are using", tertiaryVal=ModuleCategory.Visuals)
public class VisibleEatingModule
extends Module {
    public static final FloatSetting countVal = new FloatSetting("Size", 24.0f, 16.0f, 42.0f, 1.0f, false);
    public static final FloatSetting depthVal = new FloatSetting("Distance", 64.0f, 8.0f, 160.0f, 2.0f, false);
    public static final FloatSetting descRef = new FloatSetting("Y offset", -28.0f, -120.0f, 120.0f, 1.0f, false);
    public static final BoolSetting activeVal = new BoolSetting("Visible only", false);
    public static final BoolSetting radiusVal = new BoolSetting("Show self", false);
    public static final BoolSetting factorVal = new BoolSetting("Background", true);
    private static final float sourceVal = 0.42f;
    private static final float extraRef = 6.0f;
    private static final float phaseVal = 0.52f;
    private final ThemeSettings limitRef = new ThemeSettings(){};
    private final Map<UUID, WildClient> paramRef = new HashMap<UUID, WildClient>();

    public VisibleEatingModule() {
        Setting[] nvUuvVvuuNArray = new Setting[6];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        nvUuvVvuuNArray[2] = descRef;
        nvUuvVvuuNArray[3] = activeVal;
        nvUuvVvuuNArray[4] = radiusVal;
        nvUuvVvuuNArray[5] = factorVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(RenderHudEvent partD) {
        if (VisibleEatingModule.mc.field_1687 == null || VisibleEatingModule.mc.field_1724 == null) {
            return;
        }
        Renderer2D heightVal = partD.marginVal();
        float f = mc.method_61966().method_60637(true);
        int n = partD.paramVal();
        int n2 = partD.extraVal();
        HashSet<UUID> hashSet = new HashSet<UUID>();
        for (class_1657 class_16572 : VisibleEatingModule.mc.field_1687.method_18456()) {
            boolean bl;
            if (class_16572 == null) continue;
            hashSet.add(class_16572.method_5667());
            boolean bl2 = bl = this.primaryVal(class_16572) && class_16572.method_6115();
            class_1799 class_17992 = bl ? class_16572.method_6030() : class_1799.field_8037;
            boolean bl3 = bl && !class_17992.method_7960() && (class_17992.method_7976() == class_1839.field_8950 || class_17992.method_7976() == class_1839.field_8946);
            WildClient modeVal = this.paramRef.computeIfAbsent(class_16572.method_5667(), uUID -> new WildClient());
            modeVal.weightVal = bl3;
            if (bl3) {
                modeVal.tertiaryVal = class_17992.method_7972();
                modeVal.marginVal = this.primaryVal(class_16572, class_17992);
                continue;
            }
            modeVal.marginVal = 0.0f;
        }
        this.paramRef.entrySet().removeIf(entry -> {
            WildClient modeVal = (WildClient)entry.getValue();
            if (!hashSet.contains(entry.getKey())) {
                modeVal.weightVal = false;
                modeVal.tertiaryVal = null;
            }
            return modeVal.primaryVal.chunkVal() <= (double)0.005f && !modeVal.weightVal;
        });
        this.primaryVal(heightVal, f, n, n2);
    }

    private void primaryVal(Renderer2D heightVal, float f, int n, int n2) {
        if (this.paramRef.isEmpty()) {
            return;
        }
        ThemePalette configVal = ThemePalette.primaryVal(this.blockRef(), NeumorphicThemeRenderer.marginVal());
        int n3 = configVal.depthVal();
        int n4 = ColorUtil.tertiaryVal(255, 255, 255, 42);
        float f2 = countVal.tertiaryVal();
        float f3 = f2 * 0.52f;
        float f4 = NuNvVUuUUnun.tertiaryVal(f3 / 16.0f);
        float f5 = f2 * 0.52f;
        float f6 = Math.max(2.0f, f2 * 0.11f);
        for (Map.Entry<UUID, WildClient> entry : this.paramRef.entrySet()) {
            class_1657 class_16572;
            WildClient modeVal = entry.getValue();
            modeVal.primaryVal.primaryVal();
            modeVal.primaryVal.primaryVal(modeVal.weightVal ? 1.0 : 0.0, 0.25, Easing.descRef);
            if (modeVal.primaryVal.chunkVal() <= (double)0.005f || modeVal.tertiaryVal == null || modeVal.tertiaryVal.method_7960() || (class_16572 = VisibleEatingModule.mc.field_1687.method_18470(entry.getKey())) == null) continue;
            class_243 class_2432 = class_16572.method_30950(f).method_1031(0.0, (double)(class_16572.method_17682() + 0.42f), 0.0);
            class_243 class_2433 = VnNnNnvuvn.primaryVal(class_2432);
            if (class_2433.field_1350 <= (double)0.001f || class_2433.field_1350 > 1.0) continue;
            float f7 = (float)class_2433.field_1352;
            float f8 = (float)class_2433.field_1351 + descRef.tertiaryVal();
            if (f7 < -6.0f || f7 > (float)n + 6.0f || f8 < -6.0f) continue;
            if (f8 > (float)n2 + 6.0f) continue;
            float f9 = (float)modeVal.primaryVal.chunkVal();
            modeVal.secondaryVal.primaryVal();
            modeVal.secondaryVal.primaryVal((double)modeVal.marginVal, (double)0.35f, Easing.descRef);
            float f10 = Math.max(0.01f, (float)modeVal.secondaryVal.chunkVal());
            if (factorVal.tertiaryVal()) {
                float f11 = f6 + 5.0f;
                float f12 = (f5 + f11) * 2.0f;
                float f13 = f7 - f12 * 0.5f;
                float f14 = f8 - f12 * 0.5f;
                this.limitRef.primaryVal(heightVal, f13, f14, f12, f12, f12 * 0.32f, f9);
            }
            heightVal.primaryVal(f7, f8, f5, 0.0f, 1.0f, f6, n4);
            heightVal.primaryVal(f7, f8, f5, 90.0f, f10, f6, ThemePalette.primaryVal(n3, (int)(235.0f * f9)));
            NuNvVUuUUnun.primaryVal(heightVal, modeVal.tertiaryVal, f7 - f3 * 0.5f, f8 - f3 * 0.5f, f4, 0, false, 0);
        }
    }

    private boolean primaryVal(class_1657 class_16572) {
        if (class_16572 == null || !class_16572.method_5805() || class_16572.method_7325()) {
            return false;
        }
        if (class_16572 == VisibleEatingModule.mc.field_1724 && !radiusVal.tertiaryVal()) {
            return false;
        }
        if (class_16572.method_5858((class_1297)VisibleEatingModule.mc.field_1724) > (double)(depthVal.tertiaryVal() * depthVal.tertiaryVal())) {
            return false;
        }
        return !activeVal.tertiaryVal() || VisibleEatingModule.mc.field_1724.method_6057((class_1297)class_16572);
    }

    private float primaryVal(class_1657 class_16572, class_1799 class_17992) {
        if (class_17992 == null || class_17992.method_7960()) {
            return 0.0f;
        }
        int n = class_17992.method_7935((class_1309)class_16572);
        if (n <= 0) {
            return 0.0f;
        }
        return class_3532.method_15363((float)((float)class_16572.method_6048() / (float)n), (float)0.0f, (float)1.0f);
    }

    private NvVNvUvunNNu blockRef() {
        if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal() != null) {
            return ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal();
        }
        return NvVNvUvunNNu.WILD;
    }

    @Override
    public void onDisable() {
        this.paramRef.clear();
        super.onDisable();
    }

    static class WildClient {
        final AnimatedValue primaryVal = new AnimatedValue();
        final AnimatedValue secondaryVal = new AnimatedValue();
        class_1799 tertiaryVal;
        float marginVal;
        boolean weightVal;

        WildClient() {
        }
    }
}

