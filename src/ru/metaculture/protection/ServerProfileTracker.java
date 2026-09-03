/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_2561
 *  net.minecraft.class_266
 *  net.minecraft.class_268
 *  net.minecraft.class_269
 *  net.minecraft.class_270
 *  net.minecraft.class_310
 *  net.minecraft.class_345
 *  net.minecraft.class_8646
 *  net.minecraft.class_9011
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.class_2561;
import net.minecraft.class_266;
import net.minecraft.class_268;
import net.minecraft.class_269;
import net.minecraft.class_270;
import net.minecraft.class_310;
import net.minecraft.class_345;
import net.minecraft.class_8646;
import net.minecraft.class_9011;
import org.wild.mixin.acceser.BossBarHudAccessor;
import ru.metaculture.protection.MinecraftAccessor;

public class ServerProfileTracker {
    public static final ServerProfileTracker primaryVal = new ServerProfileTracker();
    private static final Pattern tertiaryVal = Pattern.compile("(?iu)(?:\u0430\u043d\u0430\u0440\u0445(?:\u0438\u044f|\u0438\u0438)?|anarchy|an)\\s*[-:#\u2116]?\\s*(\\d{1,5})");
    private static final Pattern marginVal = Pattern.compile("([a-zA-Z0-9_]{3,16})");
    private static final Pattern weightVal = Pattern.compile("Coins:\\s*(.+)");
    private static final Pattern paramVal = Pattern.compile("Tokens:\\s*(\\d+)");
    private static final Pattern extraVal = Pattern.compile("Rank:\\s*(.+)");
    private static final Pattern limitVal = Pattern.compile("Kills:\\s*(\\d+)");
    private static final Pattern speedVal = Pattern.compile("Deaths:\\s*(\\d+)");
    private static final Pattern widthVal = Pattern.compile("Playtime:\\s*(.+)");
    public static String secondaryVal = "N/A";
    private String chunkVal = "N/A";
    private String blockRef = "N/A";
    private String holderVal = "N/A";
    private String timerVal = "0";
    private String anchorVal = "0";
    private String weightRef = "0";
    private String bufferVal = "0";
    private String countVal = "0";
    private long depthVal;

    public void primaryVal(long l) {
        long l2 = System.currentTimeMillis();
        if (l2 - this.depthVal < l) {
            return;
        }
        this.depthVal = l2;
        this.primaryVal();
    }

    public void primaryVal() {
        class_310 class_3102 = class_310.method_1551();
        this.chunkVal = "N/A";
        this.timerVal = "0";
        this.anchorVal = "0";
        this.weightRef = "0";
        this.bufferVal = "0";
        this.countVal = "0";
        if (class_3102.field_1687 == null || class_3102.field_1724 == null) {
            return;
        }
        class_269 class_2694 = class_3102.field_1687.method_8428();
        class_266 class_2662 = class_2694.method_1189(class_8646.field_45157);
        if (class_2662 == null) {
            return;
        }
        String string = class_2662.method_1114().getString();
        Matcher matcher = tertiaryVal.matcher(this.primaryVal(string));
        if (matcher.find()) {
            this.chunkVal = matcher.group(1);
        }
        List<String> list = this.primaryVal(class_2694, class_2662);
        for (int i = 0; i < list.size(); ++i) {
            Matcher matcher2;
            Matcher matcher3;
            Matcher matcher4;
            Object object;
            Matcher matcher5;
            Matcher matcher6;
            String string2 = list.get(i);
            String string3 = this.primaryVal(string2);
            if ("N/A".equals(this.chunkVal)) {
                matcher6 = tertiaryVal.matcher(string3);
                if (matcher6.find()) {
                    this.chunkVal = matcher6.group(1);
                }
            }
            if (i < 5) {
                if (!string3.contains(":") && !string3.contains("=") && !string3.trim().isEmpty() && (matcher6 = marginVal.matcher(string3)).find()) {
                    this.blockRef = matcher6.group(1);
                    secondaryVal = this.blockRef;
                }
            }
            if ((matcher6 = extraVal.matcher(string3)).find()) {
                this.holderVal = matcher6.group(1).trim();
            }
            if ((matcher5 = weightVal.matcher(string3)).find()) {
                object = matcher5.group(1);
                this.timerVal = ((String)object).replaceAll("[^0-9]", "");
            }
            if (((Matcher)(object = paramVal.matcher(string3))).find()) {
                this.anchorVal = ((Matcher)object).group(1);
            }
            if ((matcher4 = limitVal.matcher(string3)).find()) {
                this.weightRef = matcher4.group(1);
            }
            if ((matcher3 = speedVal.matcher(string3)).find()) {
                this.bufferVal = matcher3.group(1);
            }
            if (!(matcher2 = widthVal.matcher(string3)).find()) continue;
            this.countVal = matcher2.group(1);
        }
    }

    private List<String> primaryVal(class_269 class_2694, class_266 class_2662) {
        ArrayList<String> arrayList = new ArrayList<String>();
        Collection collection = class_2694.method_1184(class_2662);
        ArrayList<class_9011> arrayList2 = new ArrayList<class_9011>(collection);
        arrayList2.sort(Comparator.comparingInt(class_9011::comp_2128).reversed());
        int n = Math.min(arrayList2.size(), 15);
        for (int i = 0; i < n; ++i) {
            class_9011 class_90112 = (class_9011)arrayList2.get(i);
            class_268 class_2682 = class_2694.method_1164(class_90112.comp_2127());
            arrayList.add(class_268.method_1142((class_270)class_2682, (class_2561)class_2561.method_43470((String)class_90112.comp_2127())).getString());
        }
        return arrayList;
    }

    private String primaryVal(String string) {
        if (string == null) {
            return "";
        }
        return string.replaceAll("(?i)\u00a7[0-9a-fk-or]", "").trim();
    }

    public static boolean secondaryVal() {
        if (MinecraftAccessor.a_.field_1705 == null || MinecraftAccessor.a_.field_1705.method_1740() == null) {
            return false;
        }
        Map<UUID, class_345> map = ((BossBarHudAccessor)MinecraftAccessor.a_.field_1705.method_1740()).getBossBars();
        for (class_345 class_3452 : map.values()) {
            String string = class_3452.method_5414().getString().toLowerCase();
            if (!string.contains("pvp-mode")) {
                if (!string.contains("pvp")) continue;
            }
            return true;
        }
        return false;
    }

    @Generated
    public String tertiaryVal() {
        return this.chunkVal;
    }

    @Generated
    public String marginVal() {
        return this.blockRef;
    }

    @Generated
    public String weightVal() {
        return this.holderVal;
    }

    @Generated
    public String paramVal() {
        return this.timerVal;
    }

    @Generated
    public String extraVal() {
        return this.anchorVal;
    }

    @Generated
    public String limitVal() {
        return this.weightRef;
    }

    @Generated
    public String speedVal() {
        return this.bufferVal;
    }

    @Generated
    public String widthVal() {
        return this.countVal;
    }

    @Generated
    public long chunkVal() {
        return this.depthVal;
    }
}

