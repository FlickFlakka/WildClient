/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_10182
 *  net.minecraft.class_1297
 *  net.minecraft.class_1661
 *  net.minecraft.class_1934
 *  net.minecraft.class_2535
 *  net.minecraft.class_2596
 *  net.minecraft.class_2649
 *  net.minecraft.class_2651
 *  net.minecraft.class_2653
 *  net.minecraft.class_2656
 *  net.minecraft.class_2664
 *  net.minecraft.class_2668
 *  net.minecraft.class_2668$class_5402
 *  net.minecraft.class_2696
 *  net.minecraft.class_2708
 *  net.minecraft.class_2735
 *  net.minecraft.class_2748
 *  net.minecraft.class_2749
 *  net.minecraft.class_2793
 *  net.minecraft.class_2799
 *  net.minecraft.class_2799$class_2800
 *  net.minecraft.class_2828$class_2829
 *  net.minecraft.class_2828$class_2830
 *  net.minecraft.class_2828$class_2831
 *  net.minecraft.class_2828$class_5911
 *  net.minecraft.class_310
 *  net.minecraft.class_3532
 *  net.minecraft.class_434
 *  net.minecraft.class_634
 *  net.minecraft.class_636
 *  net.minecraft.class_638
 *  net.minecraft.class_743
 *  net.minecraft.class_744
 *  net.minecraft.class_746
 *  net.minecraft.class_9834
 *  net.minecraft.class_9835
 *  net.minecraft.class_9836
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import net.minecraft.class_10182;
import net.minecraft.class_1297;
import net.minecraft.class_1661;
import net.minecraft.class_1934;
import net.minecraft.class_2535;
import net.minecraft.class_2596;
import net.minecraft.class_2649;
import net.minecraft.class_2651;
import net.minecraft.class_2653;
import net.minecraft.class_2656;
import net.minecraft.class_2664;
import net.minecraft.class_243;
import net.minecraft.class_2668;
import net.minecraft.class_2696;
import net.minecraft.class_2708;
import net.minecraft.class_2735;
import net.minecraft.class_2748;
import net.minecraft.class_2749;
import net.minecraft.class_2793;
import net.minecraft.class_2799;
import net.minecraft.class_2828;
import net.minecraft.class_310;
import net.minecraft.class_3532;
import net.minecraft.class_434;
import net.minecraft.class_634;
import net.minecraft.class_636;
import net.minecraft.class_638;
import net.minecraft.class_743;
import net.minecraft.class_744;
import net.minecraft.class_746;
import net.minecraft.class_9834;
import net.minecraft.class_9835;
import net.minecraft.class_9836;
import org.wild.mixin.acceser.MinecraftClientAccessor;
import ru.metaculture.protection.BotConnector;
import ru.metaculture.protection.HeadlessBotNetworkHandler;
import ru.metaculture.protection.WorldContextSwapper;
import ru.metaculture.protection.VnUvNVNVNUUn;
import ru.metaculture.protection.VvNvUNnUuUv;
import ru.metaculture.protection.HeadlessBotPlayNetworkHandler;
import ru.metaculture.protection.HeadlessBotSession;

public final class HeadlessBotHostManager {
    public static final List<HeadlessBotSession> primaryVal = new CopyOnWriteArrayList<HeadlessBotSession>();
    public static final List<HeadlessBotSession> secondaryVal = new CopyOnWriteArrayList<HeadlessBotSession>();
    private static final Set<String> tertiaryVal = ConcurrentHashMap.newKeySet();
    private static final Object marginVal = new Object();
    private static final Map<String, VvunVVUvUNnv> weightVal = new LinkedHashMap<String, VvunVVUvUNnv>();
    private static final AtomicLong paramVal = new AtomicLong();
    private static volatile HeadlessBotSession extraVal;
    private static class_638 limitVal;
    private static class_746 speedVal;
    private static class_636 widthVal;
    private static boolean chunkVal;
    private static boolean blockRef;
    private static HeadlessBotSession holderVal;
    private static HeadlessBotSession timerVal;
    private static double anchorVal;
    private static double weightRef;
    private static double bufferVal;
    private static float countVal;
    private static float depthVal;
    private static boolean descRef;
    private static boolean activeVal;
    private static int radiusVal;

    private HeadlessBotHostManager() {
    }

    public static HeadlessBotSession primaryVal() {
        return extraVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static List<WildClient> secondaryVal() {
        Object object = marginVal;
        synchronized (object) {
            ArrayList<WildClient> arrayList = new ArrayList<WildClient>(weightVal.size());
            for (VvunVVUvUNnv vvunVVUvUNnv : weightVal.values()) {
                arrayList.add(vvunVVUvUNnv.primaryVal());
            }
            return List.copyOf(arrayList);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static WildClient primaryVal(String string) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = weightVal.get(HeadlessBotHostManager.widthVal(string));
            return vvunVVUvUNnv == null ? null : vvunVVUvUNnv.primaryVal();
        }
    }

    public static boolean secondaryVal(String string) {
        WildClient modeVal;
        block5: {
            block4: {
                modeVal = HeadlessBotHostManager.primaryVal(string);
                if (modeVal == null) break block4;
                if (!modeVal.address().isBlank()) break block5;
            }
            return false;
        }
        class_310 class_3102 = HeadlessBotHostManager.anchorVal();
        if (class_3102 != null && !class_3102.method_18854()) {
            class_3102.execute(() -> HeadlessBotHostManager.secondaryVal(string));
            return true;
        }
        HeadlessBotHostManager.tertiaryVal(string);
        return BotConnector.primaryVal(modeVal.name(), modeVal.address());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean tertiaryVal(String string) {
        HeadlessBotSession vUNVNUnuv2;
        Thread thread = null;
        boolean bl = false;
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = weightVal.get(HeadlessBotHostManager.widthVal(string));
            if (vvunVVUvUNnv == null) {
                return false;
            }
            vUNVNUnuv2 = vvunVVUvUNnv.extraVal;
            if (vUNVNUnuv2 == null) {
                if (!vvunVVUvUNnv.tertiaryVal.primaryVal()) {
                    return false;
                }
                thread = vvunVVUvUNnv.limitVal;
                vvunVVUvUNnv.limitVal = null;
                vvunVVUvUNnv.paramVal = paramVal.incrementAndGet();
                vvunVVUvUNnv.primaryVal(cursorVal.DISCONNECTED, "Connection cancelled");
                bl = true;
            } else {
                vvunVVUvUNnv.primaryVal(cursorVal.DISCONNECTED, "Disconnected by user");
            }
        }
        if (bl) {
            if (thread != null) {
                thread.interrupt();
            }
            HeadlessBotHostManager.paramVal(string);
            return true;
        }
        HeadlessBotHostManager.tertiaryVal(vUNVNUnuv2);
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static boolean marginVal(String string) {
        String string2 = HeadlessBotHostManager.widthVal(string);
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = weightVal.get(string2);
            if (vvunVVUvUNnv == null || vvunVVUvUNnv.extraVal != null || vvunVVUvUNnv.tertiaryVal.primaryVal()) {
                return false;
            }
            weightVal.remove(string2);
        }
        HeadlessBotHostManager.paramVal(string);
        VvNvUNnUuUv.secondaryVal();
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static boolean primaryVal(String string, String string2) {
        String string3;
        String string4;
        String string5;
        block8: {
            block7: {
                string5 = string == null ? "" : string.trim();
                string4 = string2 == null ? "" : string2.trim();
                string3 = HeadlessBotHostManager.widthVal(string5);
                if (string3.isEmpty()) break block7;
                if (!string4.isEmpty()) break block8;
            }
            return false;
        }
        Object object = marginVal;
        synchronized (object) {
            if (weightVal.containsKey(string3)) {
                return false;
            }
            weightVal.put(string3, VvunVVUvUNnv.primaryVal(string5, string4));
            return true;
        }
    }

    public static class_746 tertiaryVal() {
        return speedVal;
    }

    public static boolean primaryVal(class_634 class_6342) {
        if (extraVal == null) {
            return false;
        }
        if (class_6342 instanceof HeadlessBotPlayNetworkHandler) {
            return false;
        }
        class_310 class_3102 = HeadlessBotHostManager.anchorVal();
        return class_3102 != null && class_6342 != class_3102.method_1562();
    }

    public static void primaryVal(class_2708 class_27082, class_634 class_6342) {
        class_2535 class_25352 = class_6342.method_48296();
        class_746 class_7462 = speedVal;
        if (class_7462 != null && !class_7462.method_5765()) {
            class_10182 class_101822 = class_10182.method_63638((class_1297)class_7462);
            class_10182 class_101823 = class_10182.method_63639((class_10182)class_101822, (class_10182)class_27082.comp_3228(), (Set)class_27082.comp_3229());
            class_7462.method_33574(class_101823.comp_3148());
            class_7462.method_18799(class_101823.comp_3149());
            class_7462.method_36456(class_101823.comp_3150());
            class_7462.method_36457(class_101823.comp_3151());
        }
        class_25352.method_10743((class_2596)new class_2793(class_27082.comp_3133()));
        if (class_7462 != null) {
            class_25352.method_10743((class_2596)new class_2828.class_2830(class_7462.method_23317(), class_7462.method_23318(), class_7462.method_23321(), class_7462.method_36454(), class_7462.method_36455(), class_7462.method_24828(), class_7462.field_5976));
            HeadlessBotHostManager.primaryVal(class_7462);
        }
    }

    public static boolean primaryVal(HeadlessBotSession vUNVNUnuv2) {
        HeadlessBotSession vUNVNUnuv3;
        class_310 class_3102;
        block11: {
            block13: {
                block12: {
                    block10: {
                        block9: {
                            class_3102 = HeadlessBotHostManager.anchorVal();
                            if (vUNVNUnuv2 == null || class_3102 == null || !class_3102.method_18854() || blockRef || !primaryVal.contains(vUNVNUnuv2) || !vUNVNUnuv2.weightVal() || !vUNVNUnuv2.widthVal()) break block9;
                            if (vUNVNUnuv2.extraVal() != null && vUNVNUnuv2.limitVal() != null && vUNVNUnuv2.speedVal() != null) break block10;
                        }
                        return false;
                    }
                    vUNVNUnuv3 = extraVal;
                    if (extraVal != null) break block11;
                    if (class_3102.field_1687 == null) break block12;
                    if (class_3102.field_1724 != null && class_3102.field_1761 != null && class_3102.field_1724.field_3944 != null && class_3102.field_1724.field_3944.method_48296().method_10758()) break block13;
                }
                return false;
            }
            limitVal = class_3102.field_1687;
            speedVal = class_3102.field_1724;
            widthVal = class_3102.field_1761;
        }
        if (vUNVNUnuv3 != null) {
            if (vUNVNUnuv3 != vUNVNUnuv2 && vUNVNUnuv3.limitVal() != null) {
                vUNVNUnuv3.limitVal().field_3913 = new class_744();
            }
        }
        extraVal = vUNVNUnuv2;
        if (speedVal != null) {
            HeadlessBotHostManager.speedVal.field_3913 = new class_744();
            chunkVal = false;
            HeadlessBotHostManager.primaryVal(speedVal);
        }
        class_3102.field_1687 = vUNVNUnuv2.extraVal();
        ((MinecraftClientAccessor)class_3102).wild$setWorld(vUNVNUnuv2.extraVal());
        class_3102.field_1724 = vUNVNUnuv2.limitVal();
        class_3102.field_1761 = vUNVNUnuv2.speedVal();
        vUNVNUnuv2.limitVal().field_3913 = new class_743(class_3102.field_1690);
        class_3102.method_1504((class_1297)vUNVNUnuv2.limitVal());
        class_3102.field_1769.method_3279();
        return true;
    }

    public static void marginVal() {
        HeadlessBotHostManager.bufferVal();
        class_310 class_3102 = HeadlessBotHostManager.anchorVal();
        HeadlessBotSession vUNVNUnuv2 = extraVal;
        extraVal = null;
        if (vUNVNUnuv2 == null && limitVal == null && speedVal == null) {
            if (widthVal == null) {
                return;
            }
        }
        if (class_3102 == null) {
            limitVal = null;
            speedVal = null;
            widthVal = null;
            return;
        }
        if (vUNVNUnuv2 != null && vUNVNUnuv2.limitVal() != null) {
            vUNVNUnuv2.limitVal().field_3913 = new class_744();
        }
        if (limitVal != null) {
            class_3102.field_1687 = limitVal;
            ((MinecraftClientAccessor)class_3102).wild$setWorld(limitVal);
        }
        if (speedVal != null) {
            HeadlessBotHostManager.speedVal.field_3913 = new class_743(class_3102.field_1690);
            class_3102.field_1724 = speedVal;
            class_3102.method_1504((class_1297)speedVal);
        }
        if (widthVal != null) {
            class_3102.field_1761 = widthVal;
        }
        chunkVal = false;
        class_3102.field_1769.method_3279();
        limitVal = null;
        speedVal = null;
        widthVal = null;
    }

    public static synchronized boolean weightVal(String string) {
        String string2;
        block3: {
            block2: {
                string2 = HeadlessBotHostManager.widthVal(string);
                if (string2.isEmpty()) break block2;
                if (HeadlessBotHostManager.limitVal(string2) == null) break block3;
            }
            return false;
        }
        return tertiaryVal.add(string2);
    }

    public static void paramVal(String string) {
        tertiaryVal.remove(HeadlessBotHostManager.widthVal(string));
    }

    static void primaryVal(String string, long l) {
        if (HeadlessBotHostManager.tertiaryVal(string, l)) {
            HeadlessBotHostManager.paramVal(string);
        }
    }

    public static boolean secondaryVal(HeadlessBotSession vUNVNUnuv2) {
        if (!HeadlessBotHostManager.weightVal(vUNVNUnuv2)) {
            return false;
        }
        secondaryVal.remove(vUNVNUnuv2);
        if (!primaryVal.contains(vUNVNUnuv2)) {
            vUNVNUnuv2.blockRef().primaryVal();
            primaryVal.add(vUNVNUnuv2);
        }
        if (!HeadlessBotHostManager.weightVal(vUNVNUnuv2)) {
            primaryVal.remove(vUNVNUnuv2);
            return false;
        }
        return true;
    }

    public static void tertiaryVal(HeadlessBotSession vUNVNUnuv2) {
        if (vUNVNUnuv2 == null) {
            return;
        }
        class_310 class_3102 = HeadlessBotHostManager.anchorVal();
        if (class_3102 != null) {
            if (!class_3102.method_18854()) {
                class_3102.execute(() -> HeadlessBotHostManager.tertiaryVal(vUNVNUnuv2));
                return;
            }
        }
        boolean bl = vUNVNUnuv2.timerVal();
        if (extraVal == vUNVNUnuv2) {
            HeadlessBotHostManager.marginVal();
        }
        if (holderVal == vUNVNUnuv2) {
            holderVal = null;
            blockRef = false;
        }
        if (timerVal == vUNVNUnuv2) {
            timerVal = null;
        }
        secondaryVal.remove(vUNVNUnuv2);
        primaryVal.remove(vUNVNUnuv2);
        if (HeadlessBotHostManager.limitVal(vUNVNUnuv2)) {
            HeadlessBotHostManager.paramVal(vUNVNUnuv2.primaryVal());
        }
        if (bl) {
            try {
                vUNVNUnuv2.blockRef().marginVal();
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        try {
            vUNVNUnuv2.marginVal();
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        vUNVNUnuv2.weightRef();
    }

    public static HeadlessBotSession extraVal(String string) {
        return HeadlessBotHostManager.limitVal(HeadlessBotHostManager.widthVal(string));
    }

    public static List<HeadlessBotSession> weightVal() {
        ArrayList<HeadlessBotSession> arrayList = new ArrayList<HeadlessBotSession>(primaryVal.size() + secondaryVal.size());
        arrayList.addAll(primaryVal);
        for (HeadlessBotSession vUNVNUnuv2 : secondaryVal) {
            if (arrayList.contains(vUNVNUnuv2)) continue;
            arrayList.add(vUNVNUnuv2);
        }
        return List.copyOf(arrayList);
    }

    public static void paramVal() {
        HeadlessBotSession vUNVNUnuv2;
        Iterator<HeadlessBotSession> iterator = secondaryVal.iterator();
        while (iterator.hasNext()) {
            vUNVNUnuv2 = iterator.next();
            HeadlessBotHostManager.paramVal(vUNVNUnuv2);
        }
        iterator = primaryVal.iterator();
        while (iterator.hasNext()) {
            vUNVNUnuv2 = iterator.next();
            if (!HeadlessBotHostManager.paramVal(vUNVNUnuv2) || !primaryVal.contains(vUNVNUnuv2) || vUNVNUnuv2 == extraVal) continue;
            HeadlessBotHostManager.extraVal(vUNVNUnuv2);
        }
        if (extraVal != null) {
            HeadlessBotHostManager.weightRef();
        }
    }

    private static void weightRef() {
        class_746 class_7462 = speedVal;
        if (class_7462 == null) {
            return;
        }
        class_634 class_6342 = class_7462.field_3944;
        if (class_6342 == null) {
            return;
        }
        class_2535 class_25352 = class_6342.method_48296();
        if (class_25352 == null || !class_25352.method_10758()) {
            if (class_25352 != null) {
                class_25352.method_10768();
            }
            if (extraVal != null) {
                HeadlessBotHostManager.marginVal();
            }
            return;
        }
        if (class_25352.method_10744() != class_6342) {
            return;
        }
        try {
            class_25352.method_10754();
            if (extraVal == null || speedVal != class_7462) {
                return;
            }
            if (class_7462.method_6032() <= 0.0f) {
                if (!chunkVal) {
                    chunkVal = true;
                    class_6342.method_52787((class_2596)new class_2799(class_2799.class_2800.field_12774));
                }
            } else {
                chunkVal = false;
            }
            class_7462.method_5773();
            HeadlessBotHostManager.primaryVal(class_7462, class_6342);
            class_6342.method_52787((class_2596)class_9836.field_52333);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            HeadlessBotSession vUNVNUnuv2 = extraVal;
            if (vUNVNUnuv2 != null) {
                BotConnector.primaryVal(vUNVNUnuv2, "\u00a7cbackground host tick failed: " + throwable.getClass().getSimpleName());
            }
            HeadlessBotHostManager.marginVal();
        }
    }

    private static void primaryVal(class_746 class_7462) {
        anchorVal = class_7462.method_23317();
        weightRef = class_7462.method_23318();
        bufferVal = class_7462.method_23321();
        countVal = class_7462.method_36454();
        depthVal = class_7462.method_36455();
        descRef = class_7462.method_24828();
        activeVal = class_7462.field_5976;
        radiusVal = 0;
    }

    private static void primaryVal(class_746 class_7462, class_634 class_6342) {
        boolean bl;
        boolean bl2;
        block6: {
            block9: {
                block8: {
                    block7: {
                        block5: {
                            double d = class_7462.method_23317() - anchorVal;
                            double d2 = class_7462.method_23318() - weightRef;
                            double d3 = class_7462.method_23321() - bufferVal;
                            double d4 = class_7462.method_36454() - countVal;
                            double d5 = class_7462.method_36455() - depthVal;
                            bl2 = class_3532.method_41190((double)d, (double)d2, (double)d3) > class_3532.method_33723((double)2.0E-4) || ++radiusVal >= 20;
                            bl = d4 != 0.0 || d5 != 0.0;
                            if (!bl2 || !bl) break block5;
                            class_6342.method_52787((class_2596)new class_2828.class_2830(class_7462.method_23317(), class_7462.method_23318(), class_7462.method_23321(), class_7462.method_36454(), class_7462.method_36455(), class_7462.method_24828(), class_7462.field_5976));
                            break block6;
                        }
                        if (!bl2) break block7;
                        class_6342.method_52787((class_2596)new class_2828.class_2829(class_7462.method_23317(), class_7462.method_23318(), class_7462.method_23321(), class_7462.method_24828(), class_7462.field_5976));
                        break block6;
                    }
                    if (!bl) break block8;
                    class_6342.method_52787((class_2596)new class_2828.class_2831(class_7462.method_36454(), class_7462.method_36455(), class_7462.method_24828(), class_7462.field_5976));
                    break block6;
                }
                if (descRef != class_7462.method_24828()) break block9;
                if (activeVal == class_7462.field_5976) break block6;
            }
            class_6342.method_52787((class_2596)new class_2828.class_5911(class_7462.method_24828(), class_7462.field_5976));
        }
        if (bl2) {
            anchorVal = class_7462.method_23317();
            weightRef = class_7462.method_23318();
            bufferVal = class_7462.method_23321();
            radiusVal = 0;
        }
        if (bl) {
            countVal = class_7462.method_36454();
            depthVal = class_7462.method_36455();
        }
        descRef = class_7462.method_24828();
        activeVal = class_7462.field_5976;
    }

    public static void primaryVal(class_2749 class_27492) {
        class_746 class_7462 = speedVal;
        if (class_7462 != null) {
            class_7462.method_3138(class_27492.method_11833());
            class_7462.method_7344().method_7580(class_27492.method_11831());
            class_7462.method_7344().method_7581(class_27492.method_11834());
        }
    }

    public static void primaryVal(class_2664 class_26642) {
        class_746 class_7462 = speedVal;
        if (class_7462 != null) {
            Optional<class_243> optional = class_26642.comp_2884();
            class_746 class_7463 = class_7462;
            Objects.requireNonNull(class_7463);
            optional.ifPresent(arg_0 -> class_7463.method_45319(arg_0));
        }
    }

    public static void primaryVal(class_2649 class_26492) {
        class_746 class_7462 = speedVal;
        if (class_7462 == null) {
            return;
        }
        if (class_26492.comp_3837() == 0) {
            class_7462.field_7498.method_7610(class_26492.comp_3838(), class_26492.comp_3839(), class_26492.comp_3840());
        } else if (class_26492.comp_3837() == class_7462.field_7512.field_7763) {
            class_7462.field_7512.method_7610(class_26492.comp_3838(), class_26492.comp_3839(), class_26492.comp_3840());
        }
    }

    public static void primaryVal(class_2696 class_26962) {
        class_746 class_7462 = speedVal;
        if (class_7462 != null) {
            class_7462.method_31549().field_7479 = class_26962.method_11698();
            class_7462.method_31549().field_7477 = class_26962.method_11696();
            class_7462.method_31549().field_7480 = class_26962.method_11695();
            class_7462.method_31549().field_7478 = class_26962.method_11699();
            class_7462.method_31549().method_7248(class_26962.method_11690());
            class_7462.method_31549().method_7250(class_26962.method_11691());
        }
    }

    public static void primaryVal(class_2668 class_26682) {
        class_746 class_7462 = speedVal;
        class_638 class_6382 = limitVal;
        class_2668.class_5402 class_54022 = class_26682.method_11491();
        float f = class_26682.method_11492();
        if (class_54022 == class_2668.field_25648) {
            if (widthVal != null) {
                widthVal.method_2907(class_1934.method_8384((int)class_3532.method_15375((float)(f + 0.5f))));
            }
        } else if (class_6382 != null && class_54022 == class_2668.field_25646) {
            class_6382.method_28104().method_157(true);
            class_6382.method_8519(0.0f);
        } else if (class_6382 != null && class_54022 == class_2668.field_25647) {
            class_6382.method_28104().method_157(false);
            class_6382.method_8519(1.0f);
        } else if (class_6382 != null && class_54022 == class_2668.field_25652) {
            class_6382.method_8519(f);
        } else if (class_6382 != null && class_54022 == class_2668.field_25653) {
            class_6382.method_8496(f);
        } else if (class_7462 != null && class_54022 == class_2668.field_25656) {
            class_7462.method_22420(f == 0.0f);
        } else if (class_7462 != null && class_54022 == class_2668.field_46189) {
            class_7462.method_53848(f == 1.0f);
        }
    }

    public static void primaryVal(class_2735 class_27352) {
        class_746 class_7462 = speedVal;
        if (class_7462 != null && class_1661.method_7380((int)class_27352.comp_3325())) {
            class_7462.method_31548().method_61496(class_27352.comp_3325());
        }
    }

    public static void primaryVal(class_2748 class_27482) {
        class_746 class_7462 = speedVal;
        if (class_7462 != null) {
            class_7462.method_3145(class_27482.method_11830(), class_27482.method_11827(), class_27482.method_11828());
        }
    }

    public static void primaryVal(class_2653 class_26532) {
        class_746 class_7462 = speedVal;
        if (class_7462 == null) {
            return;
        }
        if (class_26532.method_11452() == 0) {
            class_7462.field_7498.method_7619(class_26532.method_11450(), class_26532.method_37439(), class_26532.method_11449());
        } else if (class_7462.field_7512.field_7763 == class_26532.method_11452()) {
            class_7462.field_7512.method_7619(class_26532.method_11450(), class_26532.method_37439(), class_26532.method_11449());
        }
    }

    public static void primaryVal(class_2651 class_26512) {
        class_746 class_7462 = speedVal;
        if (class_7462 != null && class_7462.field_7512.field_7763 == class_26512.method_11448()) {
            class_7462.field_7512.method_7606(class_26512.method_11445(), class_26512.method_11446());
        }
    }

    public static void primaryVal(class_9834 class_98342) {
        class_746 class_7462 = speedVal;
        if (class_7462 != null) {
            class_7462.field_7512.method_34254(class_98342.comp_2890());
        }
    }

    public static void primaryVal(class_9835 class_98352) {
        class_746 class_7462 = speedVal;
        if (class_7462 != null) {
            class_7462.method_31548().method_5447(class_98352.comp_2891(), class_98352.comp_2892());
        }
    }

    public static void extraVal() {
        class_746 class_7462 = speedVal;
        if (class_7462 != null) {
            class_7462.field_7512 = class_7462.field_7498;
        }
    }

    public static void primaryVal(class_2656 class_26562) {
        class_746 class_7462 = speedVal;
        if (class_7462 == null) {
            return;
        }
        if (class_26562.comp_2199() == 0) {
            class_7462.method_7357().method_7900(class_26562.comp_3082());
        } else {
            class_7462.method_7357().method_7906(class_26562.comp_3082(), class_26562.comp_2199());
        }
    }

    public static void limitVal() {
        HeadlessBotSession vUNVNUnuv2 = extraVal;
        if (vUNVNUnuv2 == null) {
            return;
        }
        HeadlessBotHostManager.marginVal();
        timerVal = vUNVNUnuv2;
    }

    public static void speedVal() {
        HeadlessBotSession vUNVNUnuv2 = timerVal;
        timerVal = null;
        chunkVal = false;
        if (extraVal == null && vUNVNUnuv2 != null && primaryVal.contains(vUNVNUnuv2) && vUNVNUnuv2.weightVal() && vUNVNUnuv2.widthVal()) {
            HeadlessBotHostManager.primaryVal(vUNVNUnuv2);
        }
    }

    public static boolean widthVal() {
        return blockRef;
    }

    public static void chunkVal() {
        HeadlessBotSession vUNVNUnuv2 = extraVal;
        if (vUNVNUnuv2 == null) {
            return;
        }
        HeadlessBotHostManager.marginVal();
        holderVal = vUNVNUnuv2;
        blockRef = true;
    }

    public static void blockRef() {
        HeadlessBotSession vUNVNUnuv2 = holderVal;
        blockRef = false;
        holderVal = null;
        if (!(extraVal == null && vUNVNUnuv2 != null && primaryVal.contains(vUNVNUnuv2) && vUNVNUnuv2.weightVal() && vUNVNUnuv2.widthVal())) {
            return;
        }
        class_310 class_3102 = HeadlessBotHostManager.anchorVal();
        if (class_3102 == null) {
            return;
        }
        if (class_3102.field_1755 instanceof class_434) {
            class_3102.method_1507(null);
        }
        HeadlessBotHostManager.primaryVal(vUNVNUnuv2);
    }

    public static void secondaryVal(class_634 class_6342) {
        if (class_6342 instanceof HeadlessBotPlayNetworkHandler) {
            return;
        }
        if (extraVal != null && speedVal != null && HeadlessBotHostManager.speedVal.field_3944 == class_6342) {
            HeadlessBotHostManager.marginVal();
        } else {
            HeadlessBotHostManager.bufferVal();
        }
    }

    public static void holderVal() {
        HeadlessBotHostManager.bufferVal();
    }

    private static boolean paramVal(HeadlessBotSession vUNVNUnuv2) {
        try {
            if (vUNVNUnuv2.tertiaryVal().method_10758()) {
                vUNVNUnuv2.tertiaryVal().method_10754();
                return true;
            }
            vUNVNUnuv2.tertiaryVal().method_10768();
            HeadlessBotHostManager.tertiaryVal(vUNVNUnuv2);
            return false;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            String string = "network tick failed: " + throwable.getClass().getSimpleName();
            HeadlessBotHostManager.primaryVal(vUNVNUnuv2, string);
            BotConnector.primaryVal(vUNVNUnuv2, "\u00a7c" + string);
            HeadlessBotHostManager.tertiaryVal(vUNVNUnuv2);
            return false;
        }
    }

    private static void extraVal(HeadlessBotSession vUNVNUnuv2) {
        class_636 class_6362;
        HeadlessBotNetworkHandler vNNVunUvvnn;
        VnUvNVNVNUUn vnUvNVNVNUUn;
        block5: {
            block4: {
                vnUvNVNVNUUn = vUNVNUnuv2.extraVal();
                vNNVunUvvnn = vUNVNUnuv2.limitVal();
                class_6362 = vUNVNUnuv2.speedVal();
                if (vnUvNVNVNUUn == null || vNNVunUvvnn == null) break block4;
                if (class_6362 != null && vUNVNUnuv2.widthVal()) break block5;
            }
            return;
        }
        try {
            WorldContextSwapper.primaryVal(vUNVNUnuv2, () -> {
                if (vNNVunUvvnn.method_6032() <= 0.0f) {
                    if (!vUNVNUnuv2.chunkVal()) {
                        vUNVNUnuv2.secondaryVal(true);
                        vUNVNUnuv2.primaryVal((class_2596<?>)new class_2799(class_2799.class_2800.field_12774));
                    }
                } else {
                    vUNVNUnuv2.secondaryVal(false);
                }
                class_6362.method_2927();
                vnUvNVNVNUUn.method_18116();
                vnUvNVNVNUUn.method_8441(() -> true);
                vUNVNUnuv2.primaryVal((class_2596<?>)class_9836.field_52333);
            });
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            String string = "world tick failed: " + throwable.getClass().getSimpleName();
            HeadlessBotHostManager.primaryVal(vUNVNUnuv2, string);
            BotConnector.primaryVal(vUNVNUnuv2, "\u00a7c" + string);
            HeadlessBotHostManager.tertiaryVal(vUNVNUnuv2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void timerVal() {
        ArrayList<Thread> arrayList = new ArrayList<Thread>();
        Object object = marginVal;
        synchronized (object) {
            for (VvunVVUvUNnv vvunVVUvUNnv : weightVal.values()) {
                if (vvunVVUvUNnv.extraVal != null || !vvunVVUvUNnv.tertiaryVal.primaryVal()) continue;
                if (vvunVVUvUNnv.limitVal != null) {
                    arrayList.add(vvunVVUvUNnv.limitVal);
                    vvunVVUvUNnv.limitVal = null;
                }
                vvunVVUvUNnv.paramVal = paramVal.incrementAndGet();
                vvunVVUvUNnv.primaryVal(cursorVal.DISCONNECTED, "Connection cancelled");
            }
        }
        for (Thread thread : arrayList) {
            thread.interrupt();
        }
        for (HeadlessBotSession vUNVNUnuv2 : primaryVal) {
            HeadlessBotHostManager.tertiaryVal(vUNVNUnuv2);
        }
        for (HeadlessBotSession vUNVNUnuv3 : secondaryVal) {
            HeadlessBotHostManager.tertiaryVal(vUNVNUnuv3);
        }
        primaryVal.clear();
        secondaryVal.clear();
        tertiaryVal.clear();
        HeadlessBotHostManager.bufferVal();
    }

    public static HeadlessBotSession primaryVal(class_1297 class_12972) {
        if (class_12972 == null) {
            return null;
        }
        for (HeadlessBotSession vUNVNUnuv2 : primaryVal) {
            if (vUNVNUnuv2.limitVal() != class_12972) continue;
            return vUNVNUnuv2;
        }
        return null;
    }

    public static boolean secondaryVal(class_1297 class_12972) {
        Iterator<HeadlessBotSession> iterator = primaryVal.iterator();
        while (iterator.hasNext()) {
            HeadlessBotSession vUNVNUnuv2 = iterator.next();
            if (vUNVNUnuv2.limitVal() != class_12972) continue;
            return true;
        }
        return false;
    }

    public static class_310 anchorVal() {
        return class_310.method_1551();
    }

    private static void bufferVal() {
        blockRef = false;
        holderVal = null;
        timerVal = null;
        for (HeadlessBotSession vUNVNUnuv2 : primaryVal) {
            vUNVNUnuv2.tertiaryVal(false);
        }
        for (HeadlessBotSession vUNVNUnuv2 : secondaryVal) {
            vUNVNUnuv2.tertiaryVal(false);
        }
    }

    private static HeadlessBotSession limitVal(String string) {
        if (string.isEmpty()) {
            return null;
        }
        Iterator<HeadlessBotSession> iterator = primaryVal.iterator();
        while (iterator.hasNext()) {
            HeadlessBotSession vUNVNUnuv2 = iterator.next();
            if (!HeadlessBotHostManager.widthVal(vUNVNUnuv2.primaryVal()).equals(string)) continue;
            return vUNVNUnuv2;
        }
        for (HeadlessBotSession vUNVNUnuv2 : secondaryVal) {
            if (!HeadlessBotHostManager.widthVal(vUNVNUnuv2.primaryVal()).equals(string)) continue;
            return vUNVNUnuv2;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static long secondaryVal(String string, String string2) {
        long l;
        String string3;
        block10: {
            block9: {
                string3 = HeadlessBotHostManager.widthVal(string);
                if (string3.isEmpty()) break block9;
                if (string2 == null) break block9;
                if (!string2.isBlank()) break block10;
            }
            return -1L;
        }
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = weightVal.get(string3);
            if (vvunVVUvUNnv != null && (vvunVVUvUNnv.extraVal != null || vvunVVUvUNnv.tertiaryVal.primaryVal())) {
                return -1L;
            }
            l = paramVal.incrementAndGet();
            if (vvunVVUvUNnv == null) {
                vvunVVUvUNnv = new VvunVVUvUNnv(string.trim(), string2.trim(), l);
                weightVal.put(string3, vvunVVUvUNnv);
            } else {
                vvunVVUvUNnv.primaryVal = string.trim();
                vvunVVUvUNnv.secondaryVal = string2.trim();
                vvunVVUvUNnv.paramVal = l;
                vvunVVUvUNnv.extraVal = null;
                vvunVVUvUNnv.limitVal = null;
                vvunVVUvUNnv.primaryVal(cursorVal.RESOLVING, "Resolving " + vvunVVUvUNnv.secondaryVal + " ...");
            }
        }
        VvNvUNnUuUv.secondaryVal();
        return l;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static boolean secondaryVal(String string, long l) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = weightVal.get(HeadlessBotHostManager.widthVal(string));
            if (vvunVVUvUNnv == null) return false;
            if (vvunVVUvUNnv.paramVal != l) return false;
            if (!vvunVVUvUNnv.tertiaryVal.primaryVal()) return false;
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static boolean tertiaryVal(String string, long l) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = weightVal.get(HeadlessBotHostManager.widthVal(string));
            if (vvunVVUvUNnv == null) return false;
            if (vvunVVUvUNnv.paramVal != l) return false;
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static boolean marginVal(HeadlessBotSession vUNVNUnuv2) {
        Object object = marginVal;
        synchronized (object) {
            // MONITOREXIT @DISABLED, blocks:[0, 1] lbl4 : MonitorExitStatement: MONITOREXIT : var1_1
            return HeadlessBotHostManager.speedVal(vUNVNUnuv2) != null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static boolean weightVal(HeadlessBotSession vUNVNUnuv2) {
        Object object = marginVal;
        synchronized (object) {
            return vUNVNUnuv2 != null && !vUNVNUnuv2.anchorVal() && vUNVNUnuv2.weightVal() && HeadlessBotHostManager.speedVal(vUNVNUnuv2) != null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static boolean primaryVal(String string, long l, Thread thread) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = weightVal.get(HeadlessBotHostManager.widthVal(string));
            block4: {
                if (vvunVVUvUNnv != null && vvunVVUvUNnv.paramVal == l && vvunVVUvUNnv.tertiaryVal.primaryVal()) break block4;
                return false;
            }
            vvunVVUvUNnv.limitVal = thread;
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void secondaryVal(String string, long l, Thread thread) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = weightVal.get(HeadlessBotHostManager.widthVal(string));
            if (vvunVVUvUNnv != null && vvunVVUvUNnv.paramVal == l && vvunVVUvUNnv.limitVal == thread) {
                vvunVVUvUNnv.limitVal = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static boolean primaryVal(String string, long l, HeadlessBotSession vUNVNUnuv2) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = weightVal.get(HeadlessBotHostManager.widthVal(string));
            block8: {
                block7: {
                    if (vvunVVUvUNnv == null || vvunVVUvUNnv.paramVal != l || !vvunVVUvUNnv.tertiaryVal.primaryVal() || vvunVVUvUNnv.extraVal != null || vUNVNUnuv2 == null || vUNVNUnuv2.anchorVal()) break block7;
                    if (HeadlessBotHostManager.limitVal(HeadlessBotHostManager.widthVal(string)) == null) break block8;
                }
                return false;
            }
            vvunVVUvUNnv.extraVal = vUNVNUnuv2;
            vvunVVUvUNnv.weightVal = System.currentTimeMillis();
            if (!secondaryVal.contains(vUNVNUnuv2)) {
                secondaryVal.add(vUNVNUnuv2);
            }
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void primaryVal(String string, long l, cursorVal panelVal, String string2) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv;
            block6: {
                block5: {
                    vvunVVUvUNnv = weightVal.get(HeadlessBotHostManager.widthVal(string));
                    if (vvunVVUvUNnv == null) break block5;
                    if (vvunVVUvUNnv.paramVal == l && vvunVVUvUNnv.tertiaryVal.primaryVal() && vvunVVUvUNnv.tertiaryVal != cursorVal.ERROR) break block6;
                }
                return;
            }
            vvunVVUvUNnv.primaryVal(panelVal, string2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void primaryVal(String string, long l, String string2) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = weightVal.get(HeadlessBotHostManager.widthVal(string));
            if (vvunVVUvUNnv == null || vvunVVUvUNnv.paramVal != l) {
                return;
            }
            if (vvunVVUvUNnv.tertiaryVal != cursorVal.ERROR) {
                vvunVVUvUNnv.primaryVal(cursorVal.ERROR, string2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void primaryVal(HeadlessBotSession vUNVNUnuv2, cursorVal panelVal, String string) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = HeadlessBotHostManager.speedVal(vUNVNUnuv2);
            if (vvunVVUvUNnv == null || vvunVVUvUNnv.tertiaryVal == cursorVal.ERROR && panelVal != cursorVal.ERROR) {
                return;
            }
            vvunVVUvUNnv.primaryVal(panelVal, string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void primaryVal(HeadlessBotSession vUNVNUnuv2, String string) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = HeadlessBotHostManager.speedVal(vUNVNUnuv2);
            if (vvunVVUvUNnv != null && vvunVVUvUNnv.tertiaryVal != cursorVal.ERROR) {
                vvunVVUvUNnv.primaryVal(cursorVal.ERROR, string);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void secondaryVal(HeadlessBotSession vUNVNUnuv2, String string) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = HeadlessBotHostManager.speedVal(vUNVNUnuv2);
            if (vvunVVUvUNnv != null && vvunVVUvUNnv.tertiaryVal != cursorVal.ERROR) {
                vvunVVUvUNnv.primaryVal(cursorVal.DISCONNECTED, string);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void tertiaryVal(String string, String string2) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = weightVal.get(HeadlessBotHostManager.widthVal(string));
            if (vvunVVUvUNnv != null && vvunVVUvUNnv.tertiaryVal != cursorVal.ERROR) {
                vvunVVUvUNnv.primaryVal(string2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void secondaryVal(String string, long l, String string2) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = weightVal.get(HeadlessBotHostManager.widthVal(string));
            if (vvunVVUvUNnv != null && vvunVVUvUNnv.paramVal == l && vvunVVUvUNnv.tertiaryVal != cursorVal.ERROR) {
                vvunVVUvUNnv.primaryVal(string2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void tertiaryVal(HeadlessBotSession vUNVNUnuv2, String string) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = HeadlessBotHostManager.speedVal(vUNVNUnuv2);
            if (vvunVVUvUNnv != null && vvunVVUvUNnv.tertiaryVal != cursorVal.ERROR) {
                vvunVVUvUNnv.primaryVal(string);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static boolean limitVal(HeadlessBotSession vUNVNUnuv2) {
        Object object = marginVal;
        synchronized (object) {
            VvunVVUvUNnv vvunVVUvUNnv = HeadlessBotHostManager.speedVal(vUNVNUnuv2);
            if (vvunVVUvUNnv == null) {
                return false;
            }
            vvunVVUvUNnv.paramVal = paramVal.incrementAndGet();
            vvunVVUvUNnv.extraVal = null;
            vvunVVUvUNnv.limitVal = null;
            if (vvunVVUvUNnv.tertiaryVal != cursorVal.ERROR && vvunVVUvUNnv.tertiaryVal != cursorVal.DISCONNECTED) {
                vvunVVUvUNnv.primaryVal(cursorVal.DISCONNECTED, "Disconnected");
            } else {
                vvunVVUvUNnv.weightVal = System.currentTimeMillis();
            }
            return true;
        }
    }

    private static VvunVVUvUNnv speedVal(HeadlessBotSession vUNVNUnuv2) {
        if (vUNVNUnuv2 == null) {
            return null;
        }
        VvunVVUvUNnv vvunVVUvUNnv = weightVal.get(HeadlessBotHostManager.widthVal(vUNVNUnuv2.primaryVal()));
        return vvunVVUvUNnv != null && vvunVVUvUNnv.extraVal == vUNVNUnuv2 ? vvunVVUvUNnv : null;
    }

    static String speedVal(String string) {
        if (string == null) {
            return "";
        }
        return string.replaceAll("(?i)\\u00A7[0-9A-FK-OR]", "").trim();
    }

    private static String widthVal(String string) {
        return string == null ? "" : string.trim().toLowerCase(Locale.ROOT);
    }

    static final class VvunVVUvUNnv {
        String primaryVal;
        String secondaryVal;
        cursorVal tertiaryVal;
        private String marginVal;
        long weightVal;
        long paramVal;
        HeadlessBotSession extraVal;
        Thread limitVal;

        VvunVVUvUNnv(String string, String string2, long l) {
            this.primaryVal = string;
            this.secondaryVal = string2;
            this.paramVal = l;
            this.tertiaryVal = cursorVal.RESOLVING;
            this.marginVal = "Resolving " + string2 + " ...";
            this.weightVal = System.currentTimeMillis();
        }

        static VvunVVUvUNnv primaryVal(String string, String string2) {
            VvunVVUvUNnv vvunVVUvUNnv = new VvunVVUvUNnv(string, string2, 0L);
            vvunVVUvUNnv.primaryVal(cursorVal.SAVED, "Saved profile");
            return vvunVVUvUNnv;
        }

        void primaryVal(cursorVal panelVal, String string) {
            this.tertiaryVal = panelVal;
            this.marginVal = HeadlessBotHostManager.speedVal(string);
            this.weightVal = System.currentTimeMillis();
        }

        void primaryVal(String string) {
            this.marginVal = HeadlessBotHostManager.speedVal(string);
            this.weightVal = System.currentTimeMillis();
        }

        WildClient primaryVal() {
            return new WildClient(this.primaryVal, this.secondaryVal, this.tertiaryVal, this.marginVal, this.weightVal, this.extraVal);
        }
    }

    public record WildClient(String name, String address, cursorVal state, String status, long updatedAt, HeadlessBotSession bot) {
        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean isOnline() {
            if (this.bot == null) return false;
            if (!this.bot.weightVal()) return false;
            if (!this.bot.widthVal()) return false;
            return true;
        }

        public boolean isConnecting() {
            return this.state.primaryVal();
        }
    }

    public enum cursorVal {
    SAVED,
    RESOLVING,
    CONNECTING,
    LOGIN,
    CONFIGURING,
    JOINED,
    RECONFIGURING,
    DISCONNECTED,
    ERROR;
/*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public boolean primaryVal() {
            if (this == RESOLVING) return true;
            if (this == CONNECTING) return true;
            if (this == LOGIN) return true;
            if (this == CONFIGURING) return true;
            if (this != RECONFIGURING) return false;
            return true;
        }}
}

