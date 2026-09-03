/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  com.mojang.blaze3d.textures.GpuTexture
 *  net.minecraft.class_1044
 *  net.minecraft.class_10868
 *  net.minecraft.class_2561
 *  net.minecraft.class_2583
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_408
 *  net.minecraft.class_640
 */
package ru.metaculture.protection;

import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.textures.GpuTexture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import net.minecraft.class_1044;
import net.minecraft.class_10868;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_408;
import net.minecraft.class_640;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuUuVnVvnvn;
import ru.metaculture.protection.UuuNvUuUnu;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.AnimatedDouble;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.Easings;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.HudLayoutManager;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.HudSettingsPersistence;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.TextMeasureCache;
import ru.metaculture.protection.SettingHolder;
import ru.metaculture.protection.HudElementInfo;
import ru.metaculture.protection.BoolSetting;

@HudElementInfo(primaryVal="PartyListHUD", secondaryVal="w")
public final class PartyListHud
extends SettingHolder {
    private static final PartyListHud primaryVal = new PartyListHud();
    private static final class_310 secondaryVal = class_310.method_1551();
    private static final AnimatedDouble tertiaryVal = new AnimatedDouble();
    private static final AnimatedDouble marginVal = new AnimatedDouble();
    private static final AnimatedDouble weightVal = new AnimatedDouble();
    private static final AnimatedDouble paramVal = new AnimatedDouble();
    private static final Map<String, AnimatedDouble> extraVal = new HashMap<String, AnimatedDouble>();
    private static final Map<String, class_2960> limitVal = new HashMap<String, class_2960>();
    private static final Map<String, List<WildClient>> speedVal = new HashMap<String, List<WildClient>>();
    private static final List<String> widthVal = new ArrayList<String>(16);
    private static boolean chunkVal;
    private static long blockRef;
    private final BoolSetting holderVal = new BoolSetting("Show top", true);
    private final FloatSetting timerVal = new FloatSetting("Transparency", 1.0f, 0.1f, 1.0f, 0.05f, true);
    private final FloatSetting anchorVal = new FloatSetting("Transparency of dark elements", 1.0f, 0.0f, 1.0f, 0.05f, true);
    private final ModeSetting weightRef = new ModeSetting("Style", "Dark", "Dark", "Light", "Blur", "Ferrofluid");
    private final SettingGroup bufferVal;
    private final BoolSetting countVal;

    private PartyListHud() {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[2];
        vvNnnUNnVvnArray[0] = new BoolSetting("Shadow", true);
        vvNnnUNnVvnArray[1] = new BoolSetting("Outline", true);
        this.bufferVal = new SettingGroup("Visual", vvNnnUNnVvnArray);
        this.countVal = new BoolSetting("Show health", true);
        this.primaryVal((Setting)this.holderVal);
        this.primaryVal((Setting)this.timerVal);
        this.primaryVal((Setting)this.anchorVal);
        this.primaryVal((Setting)this.weightRef);
        this.primaryVal((Setting)this.bufferVal);
        this.primaryVal((Setting)this.countVal);
        HudSettingsPersistence.primaryVal(this);
    }

    public static void primaryVal(Renderer2D heightVal) {
        primaryVal.secondaryVal(heightVal);
    }

    private void secondaryVal(Renderer2D heightVal) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        if (PartyListHud.secondaryVal.field_1724 == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - blockRef > 1000L) {
            blockRef = l;
            speedVal.clear();
        }
        widthVal.clear();
        Iterator<String> namesIter = UuuNvUuUnu.weightVal().iterator();
        while (namesIter.hasNext()) {
            String string3 = namesIter.next();
            widthVal.add(string3.toLowerCase());
        }
        String selfName = PartyListHud.secondaryVal.field_1724.method_5477().getString().toLowerCase();
        if (!widthVal.contains(selfName)) {
            widthVal.add(0, selfName);
        }
        for (String object4 : widthVal) {
            extraVal.computeIfAbsent(object4, string -> new AnimatedDouble()).primaryVal(1.0, 0.2f, Easings.timerVal, false);
        }
        for (Map.Entry<String, AnimatedDouble> entry : extraVal.entrySet()) {
            entry.getValue().primaryVal();
            if (widthVal.contains(entry.getKey().toLowerCase())) continue;
            entry.getValue().primaryVal(0.0, 0.2f, Easings.timerVal, false);
        }
        boolean bl = widthVal.isEmpty() && !(PartyListHud.secondaryVal.field_1755 instanceof class_408);
        boolean bl2 = !bl;
        tertiaryVal.primaryVal();
        marginVal.primaryVal();
        tertiaryVal.primaryVal(bl ? 0.0 : 1.0, 0.18f, Easings.timerVal, false);
        if (bl2) {
            if (!chunkVal) {
                marginVal.paramVal(-10.0);
            }
            marginVal.primaryVal(0.0, 0.2f, Easings.timerVal, false);
        } else {
            if (chunkVal) {
                marginVal.paramVal(0.0);
            }
            marginVal.primaryVal(10.0, 0.2f, Easings.timerVal, false);
        }
        chunkVal = bl2;
        float f6 = tertiaryVal.weightVal();
        if (f6 <= 0.01f) {
            return;
        }
        float f7 = 24.0f;
        boolean bl3 = this.holderVal.tertiaryVal();
        float f8 = bl3 ? 7.0f : 0.0f;
        float f9 = bl3 ? 32.0f : 0.0f;
        float f10 = 22.0f;
        float f11 = 28.0f;
        float f12 = 10.0f;
        String string2 = "Party";
        float f13 = TextMeasureCache.primaryVal((FontObject)FontRegistry.marginVal, (String)string2, (float)26.0f).primaryVal;
        float f14 = f12 * 2.0f + 30.0f;
        if (bl3) {
            f14 = Math.max(f14, f13 + f10 + f12 * 2.0f + 24.0f);
        }
        Iterator<Map.Entry<String, AnimatedDouble>> iterator = extraVal.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, AnimatedDouble> entry2 = iterator.next();
            if (!(entry2.getValue().weightVal() > 0.01f)) continue;
            List<WildClient> names = this.primaryVal(entry2.getKey(), ColorUtil.tertiaryVal(245, 245, 245, 255));
            f5 = 0.0f;
            Iterator<WildClient> iterator2 = names.iterator();
            while (iterator2.hasNext()) {
                WildClient modeVal = iterator2.next();
                f5 += TextMeasureCache.primaryVal((FontObject)FontRegistry.primaryVal, (String)modeVal.primaryVal, (float)f7).primaryVal;
            }
            f4 = f5 + f12 * 2.0f + 26.0f;
            if (this.countVal.tertiaryVal()) {
                f4 += 40.0f;
            }
            f14 = Math.max(f14, f4);
        }
        float f15 = 0.0f;
        Iterator<AnimatedDouble> valuesIter = extraVal.values().iterator();
        while (valuesIter.hasNext()) {
            AnimatedDouble animatedDouble = valuesIter.next();
            f15 += f11 * Math.max(0.0f, Math.min(1.0f, animatedDouble.weightVal()));
        }
        if (f15 > 0.01f) {
            f15 += bl3 ? 5.0f : 7.0f;
        }
        float f16 = (bl3 ? f8 + f9 + 5.0f : 7.0f) + f15;
        weightVal.primaryVal();
        paramVal.primaryVal();
        weightVal.primaryVal(f14, 0.18f, Easings.timerVal, false);
        paramVal.primaryVal(f16, 0.18f, Easings.timerVal, false);
        float f17 = weightVal.weightVal();
        f5 = paramVal.weightVal();
        f4 = secondaryVal.method_22683().method_4489();
        float f18 = 10.0f;
        float f19 = 100.0f;
        HudLayoutManager.cursorVal panelVal = HudLayoutManager.primaryVal().primaryVal("HUD_PartyList", f18, f19, f17, f5);
        float f20 = panelVal.secondaryVal + marginVal.weightVal();
        float f21 = panelVal.tertiaryVal;
        float f22 = panelVal.marginVal;
        float f23 = panelVal.weightVal;
        float f24 = f22 / Math.max(1.0f, f17);
        float f25 = f23 / Math.max(1.0f, f5);
        float f26 = Math.min(f24, f25);
        float f27 = f8 * f24;
        float f28 = bl3 ? f8 * f25 : 0.0f;
        float f29 = bl3 ? f9 * f25 : 0.0f;
        float f30 = f11 * f25;
        float f31 = f12 * f24;
        float f32 = f7 * f26;
        int n = (int)(255.0f * f6 * this.timerVal.tertiaryVal());
        float f33 = f6 * this.timerVal.tertiaryVal() * this.anchorVal.tertiaryVal();
        int n2 = (int)(255.0f * f33);
        int n3 = ColorUtil.tertiaryVal(24, 24, 24, n);
        int n4 = ColorUtil.tertiaryVal(40, 37, 40, n2);
        int n5 = ColorUtil.tertiaryVal(45, 45, 45, n);
        int n6 = ColorUtil.tertiaryVal(255, 255, 255, n);
        int n7 = ColorUtil.tertiaryVal(255, 255, 255, n);
        int n8 = ColorUtil.tertiaryVal(22, 22, 22, n2);
        if (this.weightRef.tertiaryVal().equals("Light")) {
            n3 = ColorUtil.tertiaryVal(240, 240, 245, n);
            n4 = ColorUtil.tertiaryVal(220, 220, 225, n2);
            n5 = ColorUtil.tertiaryVal(200, 200, 200, n);
            n6 = ColorUtil.tertiaryVal(20, 20, 20, n);
            int n9 = Renderer2D.VvunVVUvUNnv.paramVal(255, 255);
            n7 = ColorUtil.weightVal(n9, (int)(255.0f * f6 * this.timerVal.tertiaryVal()));
            n8 = ColorUtil.tertiaryVal(200, 200, 200, n2);
        } else if (this.weightRef.tertiaryVal().equals("Blur")) {
            n3 = ColorUtil.tertiaryVal(10, 10, 10, (int)(40.0f * f6 * this.timerVal.tertiaryVal()));
            n4 = ColorUtil.tertiaryVal(25, 25, 25, (int)(120.0f * f33));
            n5 = ColorUtil.tertiaryVal(255, 255, 255, (int)(35.0f * f6 * this.timerVal.tertiaryVal()));
            n8 = ColorUtil.tertiaryVal(255, 255, 255, (int)(40.0f * f33));
        }
        float f34 = 10.0f;
        float f35 = 6.0f;
        if (this.bufferVal.secondaryVal("Shadow")) {
            heightVal.primaryVal(f20, f21, f22, f23, f34, 4.0f, 1.0f, ColorUtil.tertiaryVal(0, 0, 0, (int)(80.0f * f6 * this.timerVal.tertiaryVal())));
        }
        if (this.weightRef.tertiaryVal().equals("Blur")) {
            heightVal.primaryVal(23.0f);
            heightVal.primaryVal(f20, f21, f22, f23, f34, f6 * this.timerVal.tertiaryVal());
        }
        heightVal.primaryVal(f20, f21, f22, f23, f34, n3);
        if (this.bufferVal.secondaryVal("Outline")) {
            heightVal.primaryVal(f20, f21, f22, f23, f34, n5, this.weightRef.tertiaryVal().equals("Blur") ? 1.0f : 1.5f);
        }
        if (bl3) {
            f3 = f22 - f27 * 2.0f;
            if (this.weightRef.tertiaryVal().equals("Blur")) {
                heightVal.primaryVal(23.0f);
                heightVal.primaryVal(f20 + f27, f21 + f28, f3, f29, f35, f33);
            }
            heightVal.primaryVal(f20 + f27, f21 + f28, f3, f29, f35, n4);
            heightVal.primaryVal(FontRegistry.marginVal, f20 + f27 + 10.0f * f24, f21 + f28 + f29 / 2.0f + 6.0f * f25, 26.0f * f26, string2, n6);
            float f36 = f10 * f25;
            float f37 = f20 + f27 + f3 - 6.0f * f24 - f36;
            f2 = f21 + f28 + (f29 - f36) / 2.0f;
            heightVal.primaryVal(f37, f2, f36, f36, 6.0f, n8);
            f = (f7 + 4.0f) * f26;
            float f38 = TextMeasureCache.primaryVal((FontObject)FontRegistry.weightVal, (String)"p", (float)f).primaryVal;
            heightVal.primaryVal(FontRegistry.weightVal, f37 + (f36 - f38) / 2.0f, f2 + f36 / 2.0f + 7.0f * f25, f, "p", n7);
        }
        heightVal.primaryVal(f20, f21, f22, f23, f34, f34, f34, f34);
        f3 = f21 + (bl3 ? f28 + f29 + 5.0f * f25 : 7.0f * f25);
        for (Map.Entry<String, AnimatedDouble> entry : extraVal.entrySet()) {
            f2 = Math.max(0.0f, Math.min(1.0f, entry.getValue().weightVal()));
            if (f2 <= 0.01f) continue;
            f = f2 * f2;
            int n10 = (int)(255.0f * f6 * f * this.timerVal.tertiaryVal());
            if (n10 <= 5) {
                f3 += f30 * f2;
                continue;
            }
            String string3 = entry.getKey();
            float f39 = (1.0f - f2) * 8.0f * f24;
            float f40 = f20 + f31 - f39;
            float f41 = 18.0f * f26;
            PartyListHud.primaryVal(heightVal, string3, f40, f3 + (f30 - f41) / 2.0f, f41, f6 * f * this.timerVal.tertiaryVal());
            float f42 = f40 + f41 + 6.0f * f24;
            List<WildClient> list = this.primaryVal(string3, ColorUtil.tertiaryVal(245, 245, 245, n10));
            for (WildClient modeVal : list) {
                int n11 = ColorUtil.weightVal(modeVal.secondaryVal, n10);
                heightVal.primaryVal(FontRegistry.primaryVal, f42, f3 + f30 / 2.0f + 3.0f * f25, f32, modeVal.primaryVal, n11);
                f42 += TextMeasureCache.primaryVal((FontObject)FontRegistry.primaryVal, (String)modeVal.primaryVal, (float)f32).primaryVal;
            }
            if (this.countVal.tertiaryVal()) {
                String string4 = "20.0 HP";
                float f43 = TextMeasureCache.primaryVal((FontObject)FontRegistry.primaryVal, (String)string4, (float)f32).primaryVal;
                heightVal.primaryVal(FontRegistry.primaryVal, f20 + f22 - f31 - f43 + f39, f3 + f30 / 2.0f + 3.0f * f25, f32, string4, ColorUtil.tertiaryVal(100, 255, 100, n10));
            }
            f3 += f30 * f2;
        }
        heightVal.paramVal();
        HudLayoutManager.primaryVal().primaryVal(panelVal);
        UuUuVnVvnvn.primaryVal(heightVal, (SettingHolder)this, panelVal, HudLayoutManager.primaryVal(), (float)secondaryVal.method_22683().method_4486(), (float)secondaryVal.method_22683().method_4502());
    }

    private List<WildClient> primaryVal(String string2, int n) {
        ArrayList<WildClient> arrayList = new ArrayList<WildClient>();
        if (secondaryVal.method_1562() != null) {
            Iterator iterator = secondaryVal.method_1562().method_2880().iterator();
            while (iterator.hasNext()) {
                class_640 class_6402 = (class_640)iterator.next();
                if (!class_6402.method_2966().getName().equalsIgnoreCase(string2)) continue;
                class_2561 class_25612 = class_6402.method_2971() != null ? class_6402.method_2971() : class_2561.method_43470((String)class_6402.method_2966().getName());
                class_25612.method_27658((class_25832, string) -> {
                    String cleanName = string.replaceAll("(?i)\u00a7.", "").replaceAll("[^A-Za-z\u0410-\u042f\u0430-\u044f\u0401\u04510-9\\s\\[\\]()_\\-.,!<>:|]", "");
                    if (!cleanName.isEmpty()) {
                        int n2 = n;
                        if (class_25832.method_10973() != null) {
                            n2 = class_25832.method_10973().method_27716() | 0xFF000000;
                        }
                        arrayList.add(new WildClient(cleanName, n2));
                    }
                    return Optional.empty();
                }, class_2583.field_24360);
                if (arrayList.isEmpty()) continue;
                return arrayList;
            }
        }
        arrayList.add(new WildClient(string2, n));
        return arrayList;
    }

    private static void primaryVal(Renderer2D heightVal, String string, float f, float f2, float f3, float f4) {
        try {
            String string3 = string.toLowerCase(Locale.ROOT);
            class_2960 class_29602 = limitVal.computeIfAbsent(string3, string2 -> {
                GameProfile gameProfile = new GameProfile(UUID.nameUUIDFromBytes(("OfflinePlayer:" + string).getBytes()), string);
                return secondaryVal.method_1582().method_52862(gameProfile).comp_1626();
            });
            class_1044 class_10443 = secondaryVal.method_1531().method_4619(class_29602);
            GpuTexture gpuTexture = class_10443.method_68004();
            if (!(gpuTexture instanceof class_10868)) {
                return;
            }
            class_10868 class_108682 = (class_10868)gpuTexture;
            int n = class_108682.method_68427();
            if (n <= 0) {
                return;
            }
            GlStateManager._bindTexture((int)n);
            heightVal.weightVal(f4);
            heightVal.primaryVal(n, f, f2, f3, f3, 0.125f, 0.125f, 0.25f, 0.25f, 4.0f);
            heightVal.primaryVal(n, f, f2, f3, f3, 0.625f, 0.125f, 0.75f, 0.25f, 4.0f);
            heightVal.widthVal();
        }
        catch (Throwable throwable) {
            heightVal.primaryVal(f, f2, f3, f3, 4.0f, ColorUtil.marginVal(255, (int)(40.0f * f4)));
        }
    }

    static class WildClient {
        String primaryVal;
        int secondaryVal;

        WildClient(String string, int n) {
            this.primaryVal = string;
            this.secondaryVal = n;
        }
    }
}

