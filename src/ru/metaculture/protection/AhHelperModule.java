/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_437;
import net.minecraft.class_465;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.TradeListingParser;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.Deadline;
import ru.metaculture.protection.MouseButtonEvent;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="AhHelper", secondaryVal="Auction House Helper", tertiaryVal=ModuleCategory.Misc)
public class AhHelperModule
extends Module {
    public static KeybindSetting countVal = new KeybindSetting("Search item in hand", -1);
    public static BoolSetting depthVal = new BoolSetting("Show cheapest items", true);
    public static BoolSetting descRef = new BoolSetting("Show by price", true);
    public static final List<Integer> activeVal = new ArrayList<Integer>();
    private static AhHelperModule radiusVal;
    private static String factorVal;
    private static long sourceVal;
    private static boolean extraRef;
    private static boolean phaseVal;
    private static boolean limitRef;
    private static long paramRef;
    private final Deadline groupVal = new Deadline();

    public AhHelperModule() {
        radiusVal = this;
        Setting[] nvUuvVvuuNArray = new Setting[3];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        nvUuvVvuuNArray[2] = descRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        block8: {
            block7: {
                AhHelperModule.bufferVal();
                if (AhHelperModule.mc.field_1724 == null) break block7;
                if (depthVal.tertiaryVal()) break block8;
            }
            activeVal.clear();
            return;
        }
        class_437 class_4372 = AhHelperModule.mc.field_1755;
        if (class_4372 instanceof class_465) {
            class_465 class_4652 = (class_465)class_4372;
            if (AhHelperModule.primaryVal(class_4652)) {
                this.tertiaryVal(class_4652);
            } else {
                activeVal.clear();
            }
        } else {
            activeVal.clear();
        }
    }

    public static boolean primaryVal(class_465<?> class_4652) {
        if (class_4652 == null) {
            return false;
        }
        String string = AhHelperModule.tertiaryVal(class_4652.method_25440().getString());
        return AhHelperModule.secondaryVal(string);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean secondaryVal(class_465<?> class_4652) {
        if (class_4652 == null) {
            return false;
        }
        String string = AhHelperModule.tertiaryVal(class_4652.method_25440().getString());
        if (string.contains("search:")) return true;
        if (string.contains("search:")) return true;
        if (string.contains("p:")) return true;
        if (string.contains("\u6f22:")) return true;
        if (string.contains("\ud83d\udd0e")) return true;
        if (!string.contains("\ud83d\udd0d")) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean secondaryVal(String string) {
        if (string.contains("auction")) return true;
        if (string.contains("auction")) return true;
        if (string.contains("search:")) return true;
        if (string.contains("search:")) return true;
        if (string.contains("p:")) return true;
        if (string.contains("\u6f22:")) return true;
        if (string.contains("\ud83d\udd0e:")) return true;
        if (!string.contains("\ud83d\udd0d:")) return false;
        return true;
    }

    private static String tertiaryVal(String string) {
        if (string == null) {
            return "";
        }
        return string.replaceAll("(?i)\u00a7.", "").replace('\u00a0', ' ').replace('\uff1a', ':').replaceAll("\\s*:\\s*", ":").trim().toLowerCase(Locale.ROOT);
    }

    private void tertiaryVal(class_465<?> class_4652) {
        activeVal.clear();
        int[] nArray = new int[4];
        nArray[0] = Integer.MAX_VALUE;
        nArray[1] = Integer.MAX_VALUE;
        nArray[2] = Integer.MAX_VALUE;
        nArray[3] = Integer.MAX_VALUE;
        int[] nArray2 = nArray;
        int[] nArray3 = new int[4];
        nArray3[0] = -1;
        nArray3[1] = -1;
        nArray3[2] = -1;
        nArray3[3] = -1;
        int[] nArray4 = nArray3;
        block0: for (class_1735 class_17352 : class_4652.method_17577().field_7761) {
            int n;
            if (AhHelperModule.primaryVal(class_4652, class_17352) || (n = TradeListingParser.secondaryVal(class_17352)) <= 0) continue;
            for (int i = 0; i < 4; ++i) {
                if (n >= nArray2[i]) continue;
                for (int j = 3; j > i; --j) {
                    nArray2[j] = nArray2[j - 1];
                    nArray4[j] = nArray4[j - 1];
                }
                nArray2[i] = n;
                nArray4[i] = class_17352.field_7874;
                continue block0;
            }
        }
        for (int i = 0; i < 4; ++i) {
            if (nArray4[i] == -1) continue;
            activeVal.add(nArray4[i]);
        }
    }

    @Subscribe
    public void primaryVal(MouseButtonEvent spanD) {
        if (this.groupVal.marginVal(300L) && spanD.marginVal() == countVal.tertiaryVal()) {
            this.weightRef();
            this.groupVal.primaryVal();
        }
    }

    private void weightRef() {
        if (AhHelperModule.mc.field_1724 == null) {
            return;
        }
        class_1799 class_17992 = AhHelperModule.mc.field_1724.method_6047();
        if (class_17992.method_7960()) {
            return;
        }
        String string = this.marginVal(class_17992.method_7964().getString());
        String string2 = this.primaryVal(string);
        if (!string2.equals(string)) {
            AhHelperModule.mc.field_1724.field_3944.method_45730("ah search " + string2);
            return;
        }
        if (string.isEmpty()) {
            string = class_17992.method_7909().method_63680().getString();
        }
        if (!string.isEmpty()) {
            AhHelperModule.mc.field_1724.field_3944.method_45730("ah search " + string);
        }
    }

    private String marginVal(String string) {
        if (string == null) {
            return "";
        }
        return string.replaceAll("(?i)\u00a7.", "").replaceAll("123", "").replaceAll("(?i)&.", "").replaceAll("\\[[^\\]]*]", " ").replaceAll("[\u2605\u2726\u2727\u272a\u272b\u272c\u272d\u272e\u272f\u2730\u2744\u2603\u2692\u2620\u2764\u2763\u2655\u265b\u265c\u265e\u265f]", " ").replace("xxx", " ").replaceAll("\\s+", " ").trim();
    }

    public String primaryVal(String string) {
        if (string == null) {
            return "";
        }
        if (string.contains("Monster Spawner")) {
            return "Spawner";
        }
        if (string.contains("TIER WHITE")) {
            return "white";
        }
        if (string.contains("TIER BLACK")) {
            return "black";
        }
        if (string.contains("Chunk Loader [1x1]")) {
            return "Chunk Loader";
        }
        return string;
    }

    public static void primaryVal(String string, long l) {
        factorVal = AhHelperModule.weightVal(string);
        sourceVal = l;
        extraRef = !factorVal.isEmpty() && l > 0L;
        phaseVal = true;
        limitRef = false;
        paramRef = System.currentTimeMillis();
    }

    public static void primaryVal(long l) {
        factorVal = "";
        sourceVal = l;
        extraRef = l > 0L;
        phaseVal = false;
        limitRef = false;
        paramRef = System.currentTimeMillis();
    }

    public static void blockRef() {
        factorVal = "";
        sourceVal = 0L;
        extraRef = false;
        phaseVal = false;
        limitRef = false;
        paramRef = 0L;
        activeVal.clear();
    }

    public static boolean holderVal() {
        return extraRef;
    }

    public static String timerVal() {
        return factorVal;
    }

    public static long anchorVal() {
        return sourceVal;
    }

    public static boolean primaryVal(class_465<?> class_4652, class_1735 class_17352) {
        if (!(radiusVal != null && AhHelperModule.radiusVal.enabled && descRef.tertiaryVal() && extraRef)) {
            return false;
        }
        if (class_4652 == null || class_17352 == null || !class_17352.method_7681() || !AhHelperModule.marginVal(class_4652)) {
            return false;
        }
        if (AhHelperModule.mc.field_1724 != null && class_17352.field_7871 == AhHelperModule.mc.field_1724.method_31548()) {
            return false;
        }
        int n = TradeListingParser.secondaryVal(class_17352);
        if (n <= 0) {
            return false;
        }
        return (long)n > sourceVal;
    }

    private static void bufferVal() {
        block8: {
            block7: {
                if (!extraRef) {
                    return;
                }
                class_437 class_4372 = AhHelperModule.mc.field_1755;
                if (class_4372 instanceof class_465) {
                    class_465 class_4652 = (class_465)class_4372;
                    if (AhHelperModule.marginVal(class_4652)) {
                        limitRef = true;
                        return;
                    }
                    if (limitRef || System.currentTimeMillis() - paramRef > 5000L) {
                        AhHelperModule.blockRef();
                    }
                    return;
                }
                if (limitRef) break block7;
                if (System.currentTimeMillis() - paramRef <= 5000L) break block8;
            }
            AhHelperModule.blockRef();
        }
    }

    private static boolean marginVal(class_465<?> class_4652) {
        return phaseVal ? AhHelperModule.secondaryVal(class_4652) : AhHelperModule.primaryVal(class_4652);
    }

    private static String weightVal(String string) {
        if (string == null) {
            return "";
        }
        return string.replaceAll("(?i)\u00a7.", "").replaceAll("(?i)&.", "").replace('\u00a0', ' ').replace('_', ' ').replace('-', ' ').replaceAll("(?i)\\bminecraft:", "").replaceAll("[^\\p{L}\\p{N}: ]", " ").replaceAll("\\s+", " ").trim().toLowerCase(Locale.ROOT);
    }

    static {
        factorVal = "";
    }
}

