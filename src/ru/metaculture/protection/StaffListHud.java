/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_408
 *  net.minecraft.class_640
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.class_310;
import net.minecraft.class_408;
import net.minecraft.class_640;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuUuVnVvnvn;
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

@HudElementInfo(primaryVal="StaffListHUD", secondaryVal="w")
public final class StaffListHud
extends SettingHolder {
    private static final StaffListHud primaryVal = new StaffListHud();
    private static final class_310 secondaryVal = class_310.method_1551();
    private static final AnimatedDouble tertiaryVal = new AnimatedDouble();
    private static final AnimatedDouble marginVal = new AnimatedDouble();
    private static final AnimatedDouble weightVal = new AnimatedDouble();
    private static final AnimatedDouble paramVal = new AnimatedDouble();
    private static final Map<String, AnimatedDouble> extraVal = new HashMap<String, AnimatedDouble>();
    private static final List<WildClient> limitVal = new ArrayList<WildClient>(32);
    private static boolean speedVal;
    private static long widthVal;
    private static final List<String> chunkVal;
    private final BoolSetting blockRef = new BoolSetting("Show top", true);
    private final FloatSetting holderVal = new FloatSetting("Transparency", 1.0f, 0.1f, 1.0f, 0.05f, true);
    private final FloatSetting timerVal = new FloatSetting("Transparency of dark elements", 1.0f, 0.0f, 1.0f, 0.05f, true);
    private final ModeSetting anchorVal;
    private final SettingGroup weightRef;
    private final BoolSetting bufferVal;
    private static final Map<Character, Integer> countVal;

    private StaffListHud() {
        String[] stringArray = new String[4];
        stringArray[0] = "Dark";
        stringArray[1] = "Light";
        stringArray[2] = "Blur";
        stringArray[3] = "Ferrofluid";
        this.anchorVal = new ModeSetting("Style", "Dark", stringArray);
        this.weightRef = new SettingGroup("Visual", new BoolSetting("Shadow", true), new BoolSetting("Outline", true));
        this.bufferVal = new BoolSetting("Show heads", true);
        this.primaryVal((Setting)this.blockRef);
        this.primaryVal((Setting)this.holderVal);
        this.primaryVal((Setting)this.timerVal);
        this.primaryVal((Setting)this.anchorVal);
        this.primaryVal((Setting)this.weightRef);
        this.primaryVal((Setting)this.bufferVal);
        HudSettingsPersistence.primaryVal(this);
    }

    public static void primaryVal(Renderer2D heightVal) {
        primaryVal.secondaryVal(heightVal);
    }

    private void secondaryVal(Renderer2D heightVal) {
        float f;
        float f2;
        float f3;
        if (StaffListHud.secondaryVal.field_1724 == null || secondaryVal.method_1562() == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - widthVal > 500L) {
            widthVal = l;
            StaffListHud.secondaryVal();
        }
        for (WildClient object : limitVal) {
            extraVal.computeIfAbsent(object.primaryVal, string -> new AnimatedDouble()).primaryVal(1.0, 0.2f, Easings.timerVal, false);
        }
        for (Map.Entry entry : extraVal.entrySet()) {
            ((AnimatedDouble)entry.getValue()).primaryVal();
            boolean bl = false;
            for (WildClient modeVal : limitVal) {
                if (!modeVal.primaryVal.equals(entry.getKey())) continue;
                bl = true;
                break;
            }
            if (bl) continue;
            ((AnimatedDouble)entry.getValue()).primaryVal(0.0, 0.2f, Easings.timerVal, false);
        }
        boolean bl = limitVal.isEmpty() && !(StaffListHud.secondaryVal.field_1755 instanceof class_408);
        boolean bl2 = !bl;
        tertiaryVal.primaryVal();
        marginVal.primaryVal();
        tertiaryVal.primaryVal(bl ? 0.0 : 1.0, 0.18f, Easings.timerVal, false);
        if (bl2) {
            if (!speedVal) {
                marginVal.paramVal(-10.0);
            }
            marginVal.primaryVal(0.0, 0.2f, Easings.timerVal, false);
        } else {
            if (speedVal) {
                marginVal.paramVal(0.0);
            }
            marginVal.primaryVal(10.0, 0.2f, Easings.timerVal, false);
        }
        speedVal = bl2;
        float f4 = tertiaryVal.weightVal();
        if (f4 <= 0.01f) {
            return;
        }
        float f5 = 24.0f;
        boolean bl3 = this.blockRef.tertiaryVal();
        float f6 = bl3 ? 7.0f : 0.0f;
        float f7 = bl3 ? 29.48f : 0.0f;
        float f8 = 22.0f;
        float f9 = 19.37f;
        float f10 = 10.0f;
        String string2 = "Staff";
        float f11 = TextMeasureCache.primaryVal((FontObject)FontRegistry.marginVal, (String)string2, (float)30.0f).primaryVal;
        float f12 = f10 * 2.0f + 30.0f;
        if (bl3) {
            f12 = Math.max(f12, f11 + f8 + f10 * 2.0f + 24.0f);
        }
        f12 = Math.max(f12, 228.379f);
        for (Map.Entry<String, AnimatedDouble> entry : extraVal.entrySet()) {
            if (!(entry.getValue().weightVal() > 0.01f)) continue;
            float duneH = TextMeasureCache.primaryVal((FontObject)FontRegistry.primaryVal, (String)((String)entry.getKey()), (float)f5).primaryVal + f10 * 2.0f + 20.0f;
            if (this.bufferVal.tertiaryVal()) {
                duneH += 22.0f;
            }
            f12 = Math.max(f12, duneH);
        }
        float f13 = 0.0f;
        for (AnimatedDouble duneH : extraVal.values()) {
            f13 += f9 * Math.max(0.0f, Math.min(1.0f, duneH.weightVal()));
        }
        if (f13 > 0.01f) {
            f13 += bl3 ? 5.0f : 7.0f;
        }
        float f14 = (bl3 ? f6 + f7 + f6 : 12.0f) + f13;
        weightVal.primaryVal();
        paramVal.primaryVal();
        weightVal.primaryVal(f12, 0.18f, Easings.timerVal, false);
        paramVal.primaryVal(f14, 0.18f, Easings.timerVal, false);
        float f15 = weightVal.weightVal();
        float f16 = paramVal.weightVal();
        float f17 = secondaryVal.method_22683().method_4489();
        float f18 = Math.max(10.0f, f17 - f15 - 10.0f);
        float f19 = 100.0f;
        HudLayoutManager.cursorVal panelVal = HudLayoutManager.primaryVal().primaryVal("HUD_StaffList", f18, f19, f15, f16);
        float f20 = panelVal.secondaryVal + marginVal.weightVal();
        float f21 = panelVal.tertiaryVal;
        float f22 = panelVal.marginVal;
        float f23 = panelVal.weightVal;
        float f24 = f22 / Math.max(1.0f, f15);
        float f25 = f23 / Math.max(1.0f, f16);
        float f26 = Math.min(f24, f25);
        float f27 = f6 * f24;
        float f28 = bl3 ? f6 * f25 : 0.0f;
        float f29 = bl3 ? f7 * f25 : 0.0f;
        float f30 = f9 * f25;
        float f31 = f10 * f24;
        float f32 = f5 * f26;
        int n = (int)(255.0f * f4 * this.holderVal.tertiaryVal());
        float f33 = f4 * this.holderVal.tertiaryVal() * this.timerVal.tertiaryVal();
        int n2 = (int)(255.0f * f33);
        int n3 = ColorUtil.tertiaryVal(24, 24, 24, n);
        int n4 = ColorUtil.tertiaryVal(40, 37, 40, n2);
        int n5 = ColorUtil.tertiaryVal(45, 45, 45, n);
        int n6 = ColorUtil.tertiaryVal(255, 255, 255, n);
        int n7 = ColorUtil.tertiaryVal(255, 255, 255, n);
        int n8 = ColorUtil.tertiaryVal(22, 22, 22, n2);
        if (this.anchorVal.tertiaryVal().equals("Light")) {
            n3 = ColorUtil.tertiaryVal(240, 240, 245, n);
            n4 = ColorUtil.tertiaryVal(220, 220, 225, n2);
            n5 = ColorUtil.tertiaryVal(200, 200, 200, n);
            n6 = ColorUtil.tertiaryVal(20, 20, 20, n);
            int n9 = Renderer2D.VvunVVUvUNnv.paramVal(255, 255);
            n7 = ColorUtil.weightVal(n9, (int)(255.0f * f4 * this.holderVal.tertiaryVal()));
            n8 = ColorUtil.tertiaryVal(200, 200, 200, n2);
        } else if (this.anchorVal.tertiaryVal().equals("Blur")) {
            n3 = ColorUtil.tertiaryVal(21, 22, 26, (int)(122.0f * f4 * this.holderVal.tertiaryVal()));
            n4 = ColorUtil.tertiaryVal(21, 22, 26, (int)(184.0f * f33));
            n5 = ColorUtil.tertiaryVal(255, 255, 255, (int)(10.0f * f4 * this.holderVal.tertiaryVal()));
            n8 = ColorUtil.tertiaryVal(255, 255, 255, (int)(10.0f * f33));
        }
        float f34 = 14.0f;
        float f35 = 10.0f;
        if (this.weightRef.secondaryVal("Shadow")) {
            heightVal.primaryVal(f20, f21, f22, f23, f34, 4.0f, 1.0f, ColorUtil.tertiaryVal(0, 0, 0, (int)(80.0f * f4 * this.holderVal.tertiaryVal())));
        }
        if (this.anchorVal.tertiaryVal().equals("Blur")) {
            heightVal.primaryVal(23.0f);
            heightVal.primaryVal(f20, f21, f22, f23, f34, f4 * this.holderVal.tertiaryVal());
        }
        heightVal.primaryVal(f20, f21, f22, f23, f34, n3);
        if (this.weightRef.secondaryVal("Outline")) {
            heightVal.primaryVal(f20, f21, f22, f23, f34, n5, this.anchorVal.tertiaryVal().equals("Blur") ? 1.0f : 1.5f);
        }
        if (bl3) {
            f3 = f22 - f27 * 2.0f;
            if (this.anchorVal.tertiaryVal().equals("Blur")) {
                heightVal.primaryVal(23.0f);
                heightVal.primaryVal(f20 + f27, f21 + f28, f3, f29, f35, f33);
            }
            heightVal.primaryVal(f20 + f27, f21 + f28, f3, f29, 10.0f * f26, 10.0f * f26, 4.0f * f26, 4.0f * f26, n4);
            heightVal.primaryVal(FontRegistry.marginVal, f20 + f27 + 12.4f * f24, f21 + f28 + f29 / 2.0f + 6.0f * f25, 30.0f * f26, string2, n6);
            float f36 = f8 * f25;
            float f37 = f20 + f27 + f3 - 6.0f * f24 - f36;
            f2 = f21 + f28 + (f29 - f36) / 2.0f;
            heightVal.primaryVal(f37, f2, f36, f36, 6.0f, n8);
            float f38 = (f5 + 4.0f) * f26;
            f = TextMeasureCache.primaryVal((FontObject)FontRegistry.weightVal, (String)"f", (float)f38).primaryVal;
            heightVal.primaryVal(FontRegistry.weightVal, f37 + (f36 - f) / 2.0f, f2 + f36 / 2.0f + 7.0f * f25, f38, "f", n7);
        }
        heightVal.primaryVal(f20, f21, f22, f23, f34, f34, f34, f34);
        f3 = f21 + (bl3 ? f28 + f29 + 5.0f * f25 : 7.0f * f25);
        for (Map.Entry<String, AnimatedDouble> entry : extraVal.entrySet()) {
            float f39;
            f2 = Math.max(0.0f, Math.min(1.0f, entry.getValue().weightVal()));
            if (f2 <= 0.01f) {
                continue;
            }
            WildClient modeVal = null;
            for (WildClient nodeC : limitVal) {
                if (!nodeC.primaryVal.equals(entry.getKey())) continue;
                modeVal = nodeC;
                break;
            }
            f = (1.0f - f2) * 8.0f * f24;
            float f40 = f20 + f31 - f;
            if (this.bufferVal.tertiaryVal() && modeVal != null) {
                f39 = 16.0f * f26;
                heightVal.primaryVal(f40, f3 + (f30 - f39) / 2.0f, f39, f39, 4.0f, ColorUtil.tertiaryVal(150, 150, 150, (int)(255.0f * f4 * this.holderVal.tertiaryVal())));
                f40 += f39 + 6.0f * f24;
            }
            if (modeVal != null) {
                f39 = f40;
                Iterator<cursorVal> iterator = modeVal.secondaryVal.iterator();
                while (iterator.hasNext()) {
                    cursorVal nvnNNunvv3 = iterator.next();
                    int n10 = (int)(255.0f * f4 * f2 * this.holderVal.tertiaryVal());
                    int n11 = ColorUtil.weightVal(nvnNNunvv3.secondaryVal, n10);
                    heightVal.primaryVal(FontRegistry.primaryVal, f39, f3 + f30 / 2.0f + 3.0f * f25, f32, nvnNNunvv3.primaryVal, n11);
                    f39 += TextMeasureCache.primaryVal((FontObject)FontRegistry.primaryVal, (String)nvnNNunvv3.primaryVal, (float)f32).primaryVal;
                }
            } else {
                heightVal.primaryVal(FontRegistry.primaryVal, f40, f3 + f30 / 2.0f + 3.0f * f25, f32, entry.getKey(), ColorUtil.tertiaryVal(200, 200, 200, (int)(255.0f * f4 * this.holderVal.tertiaryVal())));
            }
            f3 += f30 * f2;
        }
        heightVal.paramVal();
        HudLayoutManager.primaryVal().primaryVal(panelVal);
        UuUuVnVvnvn.primaryVal(heightVal, (SettingHolder)this, panelVal, HudLayoutManager.primaryVal(), (float)secondaryVal.method_22683().method_4486(), (float)secondaryVal.method_22683().method_4502());
    }

    private static void secondaryVal() {
        limitVal.clear();
        if (secondaryVal.method_1562() == null) {
            return;
        }
        for (class_640 class_6402 : secondaryVal.method_1562().method_2880()) {
            String string = class_6402.method_2966().getName();
            String string2 = class_6402.method_2971() != null ? class_6402.method_2971().getString() : string;
            String string3 = string2.toLowerCase(Locale.ROOT);
            boolean bl = false;
            for (String string4 : chunkVal) {
                if (!string3.contains(string4)) continue;
                bl = true;
                break;
            }
            if (!bl) continue;
            limitVal.add(StaffListHud.secondaryVal(string2));
        }
    }

    private static String primaryVal(String string) {
        return string.replaceAll("(?i)\u00a7[0-9A-FK-OR]", "");
    }

    private static WildClient secondaryVal(String string) {
        ArrayList<cursorVal> arrayList = new ArrayList<cursorVal>();
        StringBuilder stringBuilder = new StringBuilder();
        int n = -1;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (c == '\u00a7' && i + 1 < string.length()) {
                char c2 = Character.toLowerCase(string.charAt(i + 1));
                if (countVal.containsKey(Character.valueOf(c2))) {
                    if (!stringBuilder.isEmpty()) {
                        arrayList.add(new cursorVal(stringBuilder.toString(), n));
                        stringBuilder.setLength(0);
                    }
                    n = countVal.get(Character.valueOf(c2));
                }
                ++i;
                continue;
            }
            stringBuilder.append(c);
        }
        if (!stringBuilder.isEmpty()) {
            arrayList.add(new cursorVal(stringBuilder.toString(), n));
        }
        return new WildClient(StaffListHud.primaryVal(string), arrayList);
    }

    static {
        String[] stringArray = new String[14];
        stringArray[0] = "helper";
        stringArray[1] = "moder";
        stringArray[2] = "staff";
        stringArray[3] = "admin";
        stringArray[4] = "curator";
        stringArray[5] = "stager";
        stringArray[6] = "sotrudnik";
        stringArray[7] = "pomoshnik";
        stringArray[8] = "seniority";
        stringArray[9] = "staff";
        stringArray[10] = "moder";
        stringArray[11] = "admin";
        stringArray[12] = "curator";
        stringArray[13] = "helper";
        chunkVal = List.of(stringArray);
        countVal = new HashMap<Character, Integer>();
        countVal.put(Character.valueOf('0'), -16777216);
        countVal.put(Character.valueOf('1'), -16777046);
        countVal.put(Character.valueOf('2'), -16733696);
        countVal.put(Character.valueOf('3'), -16733526);
        countVal.put(Character.valueOf('4'), -5636096);
        countVal.put(Character.valueOf('5'), -5635926);
        countVal.put(Character.valueOf('6'), -22016);
        countVal.put(Character.valueOf('7'), -5592406);
        countVal.put(Character.valueOf('8'), -11184811);
        countVal.put(Character.valueOf('9'), -11184641);
        countVal.put(Character.valueOf('a'), -11141291);
        countVal.put(Character.valueOf('b'), -11141121);
        countVal.put(Character.valueOf('c'), -43691);
        countVal.put(Character.valueOf('d'), -43521);
        countVal.put(Character.valueOf('e'), -171);
        countVal.put(Character.valueOf('f'), -1);
    }

    static class WildClient {
        final String primaryVal;
        final List<cursorVal> secondaryVal;

        WildClient(String string, List<cursorVal> list) {
            this.primaryVal = string;
            this.secondaryVal = list;
        }
    }

    static class cursorVal {
        final String primaryVal;
        final int secondaryVal;

        cursorVal(String string, int n) {
            this.primaryVal = string;
            this.secondaryVal = n;
        }
    }
}

