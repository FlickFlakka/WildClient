/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1792
 *  net.minecraft.class_1796
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_2656
 *  net.minecraft.class_2724
 *  net.minecraft.class_2960
 *  net.minecraft.class_332
 *  net.minecraft.class_408
 *  net.minecraft.class_7923
 */
package ru.metaculture.protection;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_1792;
import net.minecraft.class_1796;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_2596;
import net.minecraft.class_2656;
import net.minecraft.class_2724;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_408;
import net.minecraft.class_7923;
import org.wild.mixin.acceser.ItemCooldownManagerAccessor;
import org.wild.mixin.acceser.ItemCooldownManagerEntryAccessor;
import ru.metaculture.protection.NuNvVUuUUnun;
import ru.metaculture.protection.MinecraftAccessor;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuUuVnVvnvn;
import ru.metaculture.protection.ClickPearlModule;
import ru.metaculture.protection.AnimatedDouble;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.VnuuvvUv;
import ru.metaculture.protection.Easings;
import ru.metaculture.protection.HudLayoutManager;
import ru.metaculture.protection.ThemeSettings;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.HudModule;
import ru.metaculture.protection.HudSettingsPersistence;
import ru.metaculture.protection.HudElementRegistry;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.TextMeasureCache;
import ru.metaculture.protection.SettingHolder;
import ru.metaculture.protection.HudElementInfo;
import ru.metaculture.protection.BoolSetting;

@HudElementInfo(primaryVal="CoolDownsHUD", secondaryVal="i")
public final class CoolDownsHud
extends ThemeSettings {
    private static final CoolDownsHud primaryVal = new CoolDownsHud();
    private static final Map<class_1792, CooldownEntry> limitRef = new ConcurrentHashMap<class_1792, CooldownEntry>();
    private static final List<CooldownEntry> paramRef = new ArrayList<CooldownEntry>(16);
    private static final List<PearlRenderRequest> groupVal = new ArrayList<PearlRenderRequest>(16);
    private static final AnimatedDouble layerVal = new AnimatedDouble();
    private static final AnimatedDouble slotVal = new AnimatedDouble();
    private static final AnimatedDouble themeVal = new AnimatedDouble();
    private final BoolSetting stageVal = new BoolSetting("Show top", true);
    private final BoolSetting widthRef = new BoolSetting("Show icons", true);

    private CoolDownsHud() {
        this.primaryVal((Setting)this.stageVal);
        this.primaryVal((Setting)this.widthRef);
        HudSettingsPersistence.primaryVal(this);
    }

    public static CoolDownsHud secondaryVal() {
        return primaryVal;
    }

    public static long primaryVal(class_1792 class_17922) {
        if (class_17922 == null) {
            return 0L;
        }
        return CoolDownsHud.primaryVal(new class_1799((class_1935)class_17922));
    }

    public static void primaryVal(PacketEvent uvUUuvnunU2) {
        if (uvUUuvnunU2 == null || uvUUuvnunU2.tertiaryVal() || MinecraftAccessor.a_.field_1724 == null) {
            return;
        }
        class_2596<?> class_25962 = uvUUuvnunU2.marginVal();
        class_1792 class_17922;
        if (class_25962 instanceof class_2656) {
            class_2656 class_26562 = (class_2656)class_25962;
            if ((class_17922 = (class_1792)class_7923.field_41178.method_63535(class_26562.comp_3082())) == null || class_17922 == class_1802.field_8162) {
                return;
            }
            int n = class_26562.comp_2199();
            if (n <= 0) {
                limitRef.remove(class_17922);
            } else {
                CooldownEntry modeVal = limitRef.computeIfAbsent(class_17922, CooldownEntry::new);
                modeVal.primaryVal(CoolDownsHud.secondaryVal(class_17922));
            }
        } else if (uvUUuvnunU2.marginVal() instanceof class_2724) {
            CoolDownsHud.bufferVal();
        }
    }

    public static void primaryVal(Renderer2D heightVal, class_332 class_3322) {
        primaryVal.secondaryVal(heightVal, class_3322);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void secondaryVal(Renderer2D heightVal, class_332 class_3322) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        boolean bl;
        if (MinecraftAccessor.a_.field_1724 == null || MinecraftAccessor.a_.field_1687 == null) {
            CoolDownsHud.bufferVal();
            layerVal.paramVal(0.0);
            paramRef.clear();
            groupVal.clear();
            return;
        }
        CoolDownsHud.weightRef();
        paramRef.clear();
        groupVal.clear();
        Iterator<Map.Entry<class_1792, CooldownEntry>> iterator = limitRef.entrySet().iterator();
        while (iterator.hasNext()) {
            block29: {
                CooldownEntry nodeC;
                block28: {
                    nodeC = iterator.next().getValue();
                    bl = nodeC.paramVal > 0L;
                    nodeC.marginVal.primaryVal();
                    nodeC.marginVal.primaryVal(bl ? 1.0 : 0.0, 0.15f, Easings.timerVal, false);
                    if (bl) break block28;
                    if (!(nodeC.marginVal.weightVal() > 0.01f)) break block29;
                }
                paramRef.add(nodeC);
                continue;
            }
            iterator.remove();
        }
        paramRef.sort(Comparator.<CooldownEntry>comparingLong(modeVal -> -modeVal.paramVal).thenComparing(modeVal -> modeVal.tertiaryVal));
        boolean bl2 = !paramRef.isEmpty() || MinecraftAccessor.a_.field_1755 instanceof class_408;
        layerVal.primaryVal();
        layerVal.primaryVal(bl2 ? 1.0 : 0.0, 0.22f, Easings.timerVal, false);
        float f12 = layerVal.weightVal();
        if (f12 <= 0.01f) {
            return;
        }
        bl = this.stageVal.tertiaryVal();
        boolean bl3 = this.widthRef.tertiaryVal();
        boolean bl4 = HudModule.holderVal();
        HudElementRegistry.WildClient partE = bl4 ? HudElementRegistry.primaryVal("HUD_CoolDowns") : null;
        float f13 = 24.0f;
        float f14 = f11 = bl4 ? partE.limitVal : 7.0f;
        float f15 = bl ? (bl4 ? partE.widthVal : 32.0f) : 0.0f;
        float f16 = bl4 ? partE.chunkVal : 22.0f;
        float f17 = bl4 ? partE.speedVal : 5.0f;
        float f18 = bl4 ? partE.blockRef : 28.0f;
        String string = "Cooldowns";
        float f19 = TextMeasureCache.secondaryVal(FontRegistry.marginVal, string, f18);
        float f20 = bl ? f19 + 46.0f : 0.0f;
        float f21 = 0.0f;
        float f22 = 0.0f;
        float f23 = 0.0f;
        for (CooldownEntry reedB : paramRef) {
            f10 = reedB.marginVal.weightVal();
            if (f10 <= 0.01f) continue;
            String string2 = CoolDownsHud.blockRef((float)reedB.paramVal / 1000.0f);
            f21 = Math.max(f21, TextMeasureCache.secondaryVal(FontRegistry.primaryVal, reedB.tertiaryVal, f13));
            f22 = Math.max(f22, TextMeasureCache.secondaryVal(FontRegistry.primaryVal, string2, f13));
            f23 += f16 * f10;
        }
        float f24 = bl3 ? 22.0f : 0.0f;
        float f25 = f21 + f24 + 24.0f;
        f10 = f22 + 20.0f + (bl4 ? partE.timerVal : 0.0f);
        float f26 = paramRef.isEmpty() ? 0.0f : f25 + f17 + f10;
        float f27 = Math.max(f20, f26) + f11 * 2.0f;
        f27 = Math.max(f27, bl ? 104.0f : 74.0f);
        if (f26 > 0.0f) {
            f9 = f27 - f11 * 2.0f;
            f25 = Math.max(40.0f, f9 - f17 - f10);
        }
        f9 = f11 + f15 + (bl && f23 > 0.01f ? f17 : 0.0f) + f23 + f11;
        slotVal.primaryVal();
        themeVal.primaryVal();
        slotVal.primaryVal(f27, 0.18f, Easings.timerVal, false);
        themeVal.primaryVal(f9, 0.18f, Easings.timerVal, false);
        float f28 = slotVal.weightVal();
        float f29 = themeVal.weightVal();
        float f30 = MinecraftAccessor.a_.method_22683().method_4489();
        HudLayoutManager.cursorVal panelVal = HudLayoutManager.primaryVal().primaryVal("HUD_CoolDowns", Math.max(10.0f, f30 - f28 - 10.0f), 140.0f, f28, f29);
        float f31 = panelVal.secondaryVal;
        float f32 = panelVal.tertiaryVal;
        float f33 = panelVal.marginVal;
        float f34 = panelVal.weightVal;
        this.primaryVal(f31, f32, f33, f34);
        float f35 = f33 / Math.max(1.0f, f28);
        float f36 = f34 / Math.max(1.0f, f29);
        float f37 = Math.min(f35, f36);
        float f38 = f11 * f35;
        float f39 = f11 * f36;
        float f40 = f15 * f36;
        float f41 = f16 * f36;
        float f42 = f17 * f35;
        float f43 = f17 * f36;
        float f44 = f13 * f37;
        float f45 = f25 * f35;
        float f46 = f10 * f35;
        float f47 = f33 - f38 * 2.0f;
        float f48 = f12 * this.depthVal.tertiaryVal();
        int n = this.primaryVal(f48);
        int n2 = this.secondaryVal(f48);
        int n3 = this.tertiaryVal(f48);
        int n4 = this.marginVal(f48);
        int n5 = this.weightVal(f48);
        int n6 = this.limitVal(f48);
        float f49 = bl4 ? partE.primaryVal : 14.0f;
        float f50 = bl4 ? partE.secondaryVal : 11.0f;
        float f51 = bl4 ? partE.marginVal : 7.0f;
        float f52 = bl4 ? partE.weightVal : 7.0f;
        float f53 = bl4 ? partE.anchorVal : 1.9f;
        this.primaryVal(heightVal, f31, f32, f33, f34, f49, f48);
        if (bl) {
            if (this.chunkVal()) {
                this.primaryVal(heightVal, f31 + f38, f32 + f39, f47, f40, f50, f48);
            } else if (bl4) {
                heightVal.primaryVal(f31 + f38, f32 + f39, f47, f40, f50, n2);
            } else {
                heightVal.primaryVal(f31 + f38, f32 + f39, f47, f40, 11.0f, 11.0f, 4.0f, 4.0f, n2);
            }
            f8 = bl4 ? f31 + partE.weightRef.primaryVal * f35 : f31 + f38 + 10.0f * f35;
            f7 = bl4 ? f32 + partE.weightRef.secondaryVal * f36 : f32 + f39 + f40 * 0.5f + 6.0f * f36;
            heightVal.primaryVal(FontRegistry.marginVal, f8, f7, f18 * f37, string, n5);
            f6 = 22.0f * f36;
            f5 = f31 + f38 + f47 - 10.0f * f35 - f6;
            f4 = f32 + f39 + (f40 - f6) * 0.5f;
            f3 = (bl4 ? partE.holderVal : f13) * f37;
            f2 = TextMeasureCache.secondaryVal(FontRegistry.weightVal, "g", f3);
            f = bl4 ? (partE.bufferVal.tertiaryVal ? f31 + f33 : f31) + partE.bufferVal.primaryVal * f35 : f5 + (f6 - f2) * 0.8f;
            float f54 = bl4 ? f32 + partE.bufferVal.secondaryVal * f36 : f4 + f6 * 0.55f + 5.5f * f36;
            heightVal.primaryVal(FontRegistry.weightVal, f, f54, f3, "g", n6);
        }
        f8 = f32 + f39 + f40 + (bl && f23 > 0.01f ? f43 : 0.0f);
        f7 = f31 + f38 + (bl4 ? partE.countVal.primaryVal * f35 : 0.0f);
        f6 = f8 + (bl4 ? partE.countVal.secondaryVal * f36 : 0.0f);
        f5 = f31 + f38 + f45 + f42 + (bl4 ? partE.depthVal.primaryVal * f35 : 0.0f);
        f4 = f8 + (bl4 ? partE.depthVal.secondaryVal * f36 : 0.0f);
        f3 = f23 * f36;
        if (f3 > 0.01f && this.limitVal()) {
            if (this.chunkVal()) {
                this.secondaryVal(heightVal, f7, f6, f45, f3, f51, f48);
                this.secondaryVal(heightVal, f5, f4, f46, f3, f52, f48);
            } else if (bl4) {
                heightVal.primaryVal(f7, f6, f45, f3, f51, n3);
                heightVal.primaryVal(f5, f4, f46, f3, f52, n3);
            } else {
                heightVal.primaryVal(f7, f6, f45, f3, bl ? 4.0f : 11.0f, bl ? 4.0f : 11.0f, 4.0f, 11.0f, n3);
                heightVal.primaryVal(f5, f4, f46, f3, 4.0f, bl ? 4.0f : 11.0f, 11.0f, 4.0f, n3);
            }
        }
        heightVal.tertiaryVal();
        heightVal.primaryVal(f31, f32, f33, f34, f49, f49, f49, f49);
        try {
            f2 = f6;
            f = f4;
            for (int i = 0; i < paramRef.size(); ++i) {
                float f54;
                float f55;
                CooldownEntry object = paramRef.get(i);
                float f56 = object.marginVal.weightVal();
                if (f56 <= 0.01f) continue;
                String string2 = CoolDownsHud.blockRef((float)object.paramVal / 1000.0f);
                int n7 = (int)(255.0f * f48 * f56);
                int n8 = ColorUtil.primaryVal(this.weightVal(1.0f), n7);
                int n9 = ColorUtil.primaryVal(this.limitVal(1.0f), n7);
                float f57 = (1.0f - f56) * 8.0f * f35;
                float f58 = f7 + 10.0f * f35 - f57;
                if (f53 > 0.05f) {
                    heightVal.primaryVal(f58, f2 + (f41 - 8.0f * f36) * 0.5f, f53 * f35, 8.0f * f36, Math.max(0.7f, f53 * 0.5f) * f35, n9);
                }
                f58 += 8.0f * f35;
                if (bl3) {
                    f55 = 0.9f * f37;
                    f54 = 16.0f * f55;
                    float f59 = f2 + (f41 - f54) * 0.5f;
                    groupVal.add(new PearlRenderRequest(object.secondaryVal, f58, f59, f55, i));
                    f58 += 20.0f * f35;
                }
                heightVal.primaryVal(FontRegistry.primaryVal, f58, f2 + f41 * 0.5f + 4.0f * f36, f44, object.tertiaryVal, n8);
                object.weightVal.primaryVal(string2, object.paramVal);
                f55 = f5 + f46 * 0.5f + f57;
                f54 = f + f41 * 0.5f + 4.0f * f36;
                object.weightVal.primaryVal(heightVal, FontRegistry.primaryVal, f5, f, f46, f41, Math.min(f52, f41 * 0.5f), f55, f54, f44, n9);
                f2 += f41 * f56;
                f += f41 * f56;
            }
            if (!groupVal.isEmpty()) {
                heightVal.tertiaryVal();
                for (PearlRenderRequest nvnNNunvv3 : groupVal) {
                    NuNvVUuUUnun.primaryVal(heightVal, nvnNNunvv3.stack, NuNvVUuUUnun.primaryVal(nvnNNunvv3.x), NuNvVUuUUnun.primaryVal(nvnNNunvv3.y), NuNvVUuUUnun.tertiaryVal(nvnNNunvv3.scale), nvnNNunvv3.seed, false, nvnNNunvv3.seed);
                }
            }
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
        HudLayoutManager.primaryVal().primaryVal(panelVal);
        UuUuVnVvnvn.primaryVal(heightVal, (SettingHolder)this, panelVal, HudLayoutManager.primaryVal(), (float)MinecraftAccessor.a_.method_22683().method_4486(), (float)MinecraftAccessor.a_.method_22683().method_4502());
    }

    private static String blockRef(float f) {
        int n = Math.max(0, Math.round(f * 10.0f));
        return n / 10 + "." + n % 10 + "s";
    }

    private static void weightRef() {
        Object object;
        if (MinecraftAccessor.a_.field_1724 == null) {
            CoolDownsHud.bufferVal();
            return;
        }
        Iterator<CooldownEntry> iterator = limitRef.values().iterator();
        while (iterator.hasNext()) {
            object = iterator.next();
            ((CooldownEntry)object).paramVal = 0L;
        }
        class_1796 class_17962 = MinecraftAccessor.a_.field_1724.method_7357();
        ItemCooldownManagerAccessor accessor = (ItemCooldownManagerAccessor)class_17962;
        int n = accessor.wild$getTick();
        for (Map.Entry<class_2960, ?> entry : accessor.wild$getEntries().entrySet()) {
            class_1792 class_17922;
            long l = CoolDownsHud.primaryVal(entry.getValue(), n);
            if (l <= 0L || (class_17922 = (class_1792)class_7923.field_41178.method_63535(entry.getKey())) == null || class_17922 == class_1802.field_8162) continue;
            CooldownEntry modeVal = limitRef.computeIfAbsent(class_17922, CooldownEntry::new);
            modeVal.primaryVal(CoolDownsHud.secondaryVal(class_17922));
            modeVal.paramVal = Math.max(modeVal.paramVal, l);
        }
    }

    private static long primaryVal(class_1799 class_17992) {
        if (MinecraftAccessor.a_.field_1724 == null || class_17992 == null || class_17992.method_7960()) {
            return 0L;
        }
        class_1796 class_17962 = MinecraftAccessor.a_.field_1724.method_7357();
        ItemCooldownManagerAccessor itemCooldownManagerAccessor = (ItemCooldownManagerAccessor)class_17962;
        Object obj = itemCooldownManagerAccessor.wild$getEntries().get(class_17962.method_62836(class_17992));
        if (obj == null) {
            return 0L;
        }
        return CoolDownsHud.primaryVal(obj, itemCooldownManagerAccessor.wild$getTick());
    }

    private static long primaryVal(Object object, int n) {
        int n2 = ((ItemCooldownManagerEntryAccessor)object).wild$getEndTick() - n;
        return n2 > 0 ? (long)n2 * 50L : 0L;
    }

    private static void bufferVal() {
        if (!limitRef.isEmpty()) {
            limitRef.clear();
        }
    }

    static class_1799 secondaryVal(class_1792 class_17922) {
        class_1799 class_17992;
        if (MinecraftAccessor.a_.field_1724 != null) {
            for (int i = 0; i < 36; ++i) {
                class_1799 class_17993 = MinecraftAccessor.a_.field_1724.method_31548().method_5438(i);
                if (class_17993.method_7960() || !class_17993.method_31574(class_17922)) continue;
                return class_17993.method_7972();
            }
            class_17992 = MinecraftAccessor.a_.field_1724.method_6079();
            if (!class_17992.method_7960() && class_17992.method_31574(class_17922)) {
                return class_17992.method_7972();
            }
        }
        if (class_17922 == class_1802.field_8634 && !(class_17992 = ClickPearlModule.blockRef()).method_7960()) {
            return class_17992;
        }
        return new class_1799((class_1935)class_17922);
    }

    static String primaryVal(class_1799 class_17992, class_1792 class_17922) {
        String string = class_17992.method_7964().getString();
        if (string != null && !string.isBlank()) {
            return string;
        }
        class_2960 class_29602 = class_7923.field_41178.method_10221(class_17922);
        String string2 = class_29602.method_12832().replace('_', ' ');
        StringBuilder stringBuilder = new StringBuilder();
        for (String string3 : string2.split(" ")) {
            if (string3.isEmpty()) continue;
            stringBuilder.append(Character.toUpperCase(string3.charAt(0))).append(string3.substring(1)).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    static class CooldownEntry {
        final class_1792 primaryVal;
        class_1799 secondaryVal;
        String tertiaryVal;
        final AnimatedDouble marginVal = new AnimatedDouble();
        final VnuuvvUv weightVal = new VnuuvvUv();
        long paramVal;

        CooldownEntry(class_1792 class_17922) {
            this.primaryVal = class_17922;
            this.primaryVal(CoolDownsHud.secondaryVal(class_17922));
            this.marginVal.paramVal(0.0);
        }

        void primaryVal(class_1799 class_17992) {
            this.secondaryVal = class_17992;
            this.tertiaryVal = CoolDownsHud.primaryVal(class_17992, this.primaryVal);
        }
    }

    static final class PearlRenderRequest
     {
        final class_1799 stack;
        final float x;
        final float y;
        final float scale;
        final int seed;

        PearlRenderRequest(class_1799 class_17992, float f, float f2, float f3, int n) {
            this.stack = class_17992;
            this.x = f;
            this.y = f2;
            this.scale = f3;
            this.seed = n;
        }

        @Override
        public final String toString() {
            return "PearlRenderRequest[" + "stack=" + this.stack + ", " + "x=" + this.x + ", " + "y=" + this.y + ", " + "scale=" + this.scale + ", " + "seed=" + this.seed + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.stack, this.x, this.y, this.scale, this.seed);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            PearlRenderRequest that = (PearlRenderRequest)object;
            return java.util.Objects.equals(this.stack, that.stack) && java.util.Objects.equals(this.x, that.x) && java.util.Objects.equals(this.y, that.y) && java.util.Objects.equals(this.scale, that.scale) && java.util.Objects.equals(this.seed, that.seed);}

        public class_1799 stack() {
            return this.stack;
        }

        public float x() {
            return this.x;
        }

        public float y() {
            return this.y;
        }

        public float scale() {
            return this.scale;
        }

        public int seed() {
            return this.seed;
        }
    }
}

