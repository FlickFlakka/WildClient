/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1703
 *  net.minecraft.class_1707
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_266
 *  net.minecraft.class_268
 *  net.minecraft.class_269
 *  net.minecraft.class_270
 *  net.minecraft.class_2868
 *  net.minecraft.class_437
 *  net.minecraft.class_476
 *  net.minecraft.class_7439
 *  net.minecraft.class_8646
 *  net.minecraft.class_9011
 *  net.minecraft.class_9290
 *  net.minecraft.class_9334
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1703;
import net.minecraft.class_1707;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_266;
import net.minecraft.class_268;
import net.minecraft.class_269;
import net.minecraft.class_270;
import net.minecraft.class_2868;
import net.minecraft.class_437;
import net.minecraft.class_476;
import net.minecraft.class_7439;
import net.minecraft.class_8646;
import net.minecraft.class_9011;
import net.minecraft.class_9290;
import net.minecraft.class_9334;
import ru.metaculture.protection.ChatCommand;
import ru.metaculture.protection.PostClientTickEvent;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.ServerProfileTracker;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public final class RejoinAnarchyCommand
extends ChatCommand {
    private static final int primaryVal = 1;
    private static final int secondaryVal = 66;
    private static final long tertiaryVal = 180L;
    private static final long marginVal = 650L;
    private static final long weightVal = 20000L;
    private static final long paramVal = 1000L;
    private static final long extraVal = 300000L;
    private static final long limitVal = 600000L;
    private static RejoinAnarchyCommand speedVal;
    private static final Pattern widthVal;
    private static final Pattern holderVal;
    private static final Pattern timerVal;
    private int anchorVal = -1;
    private boolean weightRef;
    private boolean bufferVal;
    private boolean countVal;
    private boolean depthVal;
    private long descRef;
    private long activeVal;
    private long radiusVal;
    private long factorVal;
    private long sourceVal;
    private boolean extraRef;
    private long phaseVal;

    public RejoinAnarchyCommand() {
        super("rct", "Rejoin the selected Lite anarchy", ".rct [1-66]");
        speedVal = this;
    }

    public static RejoinAnarchyCommand marginVal() {
        return speedVal;
    }

    public void primaryVal(boolean bl) {
        if (this.extraRef == bl) {
            return;
        }
        this.extraRef = bl;
        this.phaseVal = bl ? this.weightVal() : 0L;
    }

    private long weightVal() {
        return System.currentTimeMillis() + ThreadLocalRandom.current().nextLong(300000L, 600001L);
    }

    private void paramVal() {
        if (!this.extraRef) {
            return;
        }
        if (this.phaseVal == 0L) {
            this.phaseVal = this.weightVal();
            return;
        }
        if (System.currentTimeMillis() < this.phaseVal) {
            return;
        }
        int n = this.primaryVal(this.limitVal());
        this.phaseVal = this.weightVal();
        this.secondaryVal(new String[]{String.valueOf(n)});
    }

    private int primaryVal(int n) {
        int n2;
        int n3 = 66;
        if (n3 <= 1) {
            return 1;
        }
        while ((n2 = 1 + ThreadLocalRandom.current().nextInt(n3)) == n) {
        }
        return n2;
    }

    @Override
    @Compile
    public void secondaryVal(String[] stringArray) {
        int n;
        if (RejoinAnarchyCommand.a_.field_1724 == null || RejoinAnarchyCommand.a_.field_1724.field_3944 == null) {
            ChatLogger.primaryVal("§c[RCT] Player is not connected to the server.");
            return;
        }
        if (stringArray.length > 1) {
            this.holderVal();
            return;
        }
        if (stringArray.length == 0) {
            n = this.speedVal();
            if (n < 1 || n > 66) {
                ChatLogger.primaryVal("§c[RCT] Parse error");
                return;
            }
        } else {
            n = this.secondaryVal(stringArray[0]);
            if (n < 1 || n > 66) {
                ChatLogger.primaryVal("§c[RCT] Anarchy number must be between 1 and 66.");
                return;
            }
        }
        this.anchorVal = n;
        this.weightRef = true;
        this.countVal = false;
        this.depthVal = false;
        this.activeVal = this.descRef = System.currentTimeMillis();
        this.radiusVal = 0L;
        this.factorVal = 0L;
        this.sourceVal = 0L;
        this.bufferVal = this.widthVal();
        if (RejoinAnarchyCommand.a_.field_1755 != null) {
            RejoinAnarchyCommand.a_.field_1724.method_3137();
        }
        if (this.bufferVal) {
            RejoinAnarchyCommand.a_.field_1724.field_3944.method_45730("hub");
            RejoinAnarchyCommand.a_.field_1724.field_3944.method_45730("an" + this.anchorVal);
            this.sourceVal = this.descRef + 1000L;
            ChatLogger.primaryVal("§7[RCT] FunTime switching to anarchy §f#" + this.anchorVal + "\u00a77...");
        } else {
            RejoinAnarchyCommand.a_.field_1724.field_3944.method_45730("hub");
            ChatLogger.primaryVal("§7[RCT] Switching to Lite anarchy §f#" + this.anchorVal + "\u00a77...");
        }
    }

    @Subscribe
    public void primaryVal(PostClientTickEvent coreH) {
        if (RejoinAnarchyCommand.a_.field_1724 == null || RejoinAnarchyCommand.a_.field_1687 == null || RejoinAnarchyCommand.a_.field_1761 == null) {
            return;
        }
        if (!this.weightRef) {
            this.paramVal();
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.descRef > 20000L) {
            this.weightVal("Timed out waiting for menu or connection.");
            return;
        }
        if (this.bufferVal) {
            this.primaryVal(l);
            return;
        }
        if (this.depthVal) {
            if (this.limitVal() == this.anchorVal) {
                this.chunkVal();
                return;
            }
        }
        if (this.depthVal && l - this.radiusVal > 8000L) {
            this.weightVal("Server did not confirm connection to anarchy #" + this.anchorVal + ".");
            return;
        }
        class_437 class_4372 = RejoinAnarchyCommand.a_.field_1755;
        if (class_4372 instanceof class_476) {
            class_476 class_4762 = (class_476)class_4372;
            this.primaryVal(class_4762, l);
            return;
        }
        if (l - this.activeVal >= 650L) {
            this.extraVal();
            this.activeVal = l;
        }
    }

    private void primaryVal(class_476 class_4762, long l) {
        block18: {
            block20: {
                class_1735 class_17353;
                block19: {
                    String string;
                    block17: {
                        class_1735 class_17354;
                        block16: {
                            if (l - this.activeVal < 180L) {
                                return;
                            }
                            string = this.marginVal(class_4762.method_25440().getString());
                            if (string.contains("select mode")) break block16;
                            if (!string.contains("select mode")) break block17;
                        }
                        if (this.factorVal == 0L) {
                            this.factorVal = l;
                        }
                        if ((class_17354 = this.primaryVal(class_4762)) != null) {
                            this.primaryVal(class_4762, class_17354, class_1713.field_7790);
                            this.countVal = false;
                            this.factorVal = 0L;
                            this.activeVal = l;
                        } else if (l - this.factorVal >= 3000L) {
                            this.weightVal("Lite mode is missing from the selection menu.");
                        }
                        return;
                    }
                    if (!string.contains("lite anarchy selection") && !string.contains("lite anarchy")) {
                        return;
                    }
                    class_17353 = this.secondaryVal(class_4762);
                    if (class_17353 == null) break block18;
                    if (!this.depthVal) break block19;
                    if (l - this.activeVal < 1200L) break block20;
                }
                this.primaryVal(class_4762, class_17353);
                this.depthVal = true;
                this.radiusVal = l;
                this.activeVal = l;
            }
            return;
        }
        if (this.countVal) {
            if (l - this.activeVal >= 1200L) {
                this.countVal = false;
            }
        }
        if (!this.countVal) {
            List<class_1735> list = this.tertiaryVal(class_4762).stream().filter(class_17352 -> class_17352.method_7677().method_31574(class_1802.field_8694)).sorted(Comparator.comparingInt(class_17352 -> class_17352.field_7874)).toList();
            int n = this.tertiaryVal(this.anchorVal);
            if (n >= 0 && n < list.size()) {
                this.primaryVal(class_4762, list.get(n));
                this.countVal = true;
                this.activeVal = l;
            }
        }
    }

    private class_1735 primaryVal(class_476 class_4762) {
        class_1735 class_17352 = null;
        for (class_1735 class_17353 : this.tertiaryVal(class_4762)) {
            class_1799 class_17992 = class_17353.method_7677();
            if (!class_17992.method_31574(class_1802.field_8575)) continue;
            String string = this.marginVal(class_17992.method_7964().getString());
            if (string.equals("lite") || string.equals("lite")) {
                return class_17353;
            }
            String string2 = this.primaryVal(class_17992);
            if (!string2.contains("anarchy lite")) {
                if (!string2.contains("lite anarchy")) continue;
            }
            if (!string2.matches("(?s).*\u0430\u043d\u0430\u0440\u0445\u0438\u044f\\s*1\\D+16.*") && !string2.matches("(?s).*anarchy\\s*1\\D+16.*")) continue;
            class_17352 = class_17353;
        }
        return class_17352;
    }

    private class_1735 secondaryVal(class_476 class_4762) {
        Pattern pattern = Pattern.compile("(?iu)#\\s*0*" + this.anchorVal + "(?!\\d)");
        for (class_1735 class_17352 : this.tertiaryVal(class_4762)) {
            class_1799 class_17992 = class_17352.method_7677();
            if (class_17992.method_7960()) continue;
            if (class_17992.method_31574(class_1802.field_8694) || !pattern.matcher(this.primaryVal(class_17992)).find()) continue;
            return class_17352;
        }
        return null;
    }

    private List<class_1735> tertiaryVal(class_476 class_4762) {
        ArrayList<class_1735> arrayList = new ArrayList<class_1735>();
        class_1703 class_17032 = class_4762.method_17577();
        for (class_1735 class_17352 : class_17032.field_7761) {
            if (RejoinAnarchyCommand.a_.field_1724 != null && class_17352.field_7871 == RejoinAnarchyCommand.a_.field_1724.method_31548()) continue;
            arrayList.add(class_17352);
        }
        return arrayList;
    }

    private String primaryVal(class_1799 class_17992) {
        StringBuilder stringBuilder = new StringBuilder(class_17992.method_7964().getString());
        class_9290 class_92902 = (class_9290)class_17992.method_58694(class_9334.field_49632);
        if (class_92902 != null) {
            for (class_2561 class_25612 : class_92902.comp_2400()) {
                stringBuilder.append(' ').append(class_25612.getString());
            }
        }
        return this.marginVal(stringBuilder.toString());
    }

    private void primaryVal(class_476 class_4762, class_1735 class_17352) {
        this.primaryVal(class_4762, class_17352, class_1713.field_7794);
    }

    private void primaryVal(class_476 class_4762, class_1735 class_17352, class_1713 class_17132) {
        RejoinAnarchyCommand.a_.field_1761.method_2906(((class_1707)class_4762.method_17577()).field_7763, class_17352.field_7874, 0, class_17132, (class_1657)RejoinAnarchyCommand.a_.field_1724);
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        class_7439 class_74392;
        Object object;
        block11: {
            block12: {
                block10: {
                    block9: {
                        if (!this.weightRef) break block9;
                        if (uvUUuvnunU2.weightVal() == PacketEvent.PacketDirection.RECEIVE) break block10;
                    }
                    return;
                }
                object = uvUUuvnunU2.marginVal();
                if (!(object instanceof class_7439)) {
                    return;
                }
                class_74392 = (class_7439)object;
                object = this.marginVal(class_74392.comp_763().getString());
                if (((String)object).isEmpty()) {
                    return;
                }
                if (!this.depthVal) break block11;
                if (((String)object).contains("you are already connected to this server")) break block12;
                if (!((String)object).contains("already connected to this server")) break block11;
            }
            this.chunkVal();
            return;
        }
        if (this.tertiaryVal((String)object)) {
            this.weightVal("Connection failed: " + class_74392.comp_763().getString());
        }
    }

    private void extraVal() {
        class_1661 class_16612 = RejoinAnarchyCommand.a_.field_1724.method_31548();
        for (int i = 0; i < 9; ++i) {
            if (!class_16612.method_5438(i).method_31574(class_1802.field_8251)) continue;
            if (class_16612.method_67532() != i) {
                class_16612.method_61496(i);
                RejoinAnarchyCommand.a_.field_1724.field_3944.method_52787((class_2596)new class_2868(i));
            }
            RejoinAnarchyCommand.a_.field_1761.method_2919((class_1657)RejoinAnarchyCommand.a_.field_1724, class_1268.field_5808);
            return;
        }
    }

    private void primaryVal(long l) {
        if (this.limitVal() == this.anchorVal) {
            this.chunkVal();
            return;
        }
        if (this.sourceVal != 0L) {
            if (l >= this.sourceVal) {
                RejoinAnarchyCommand.a_.field_1724.field_3944.method_45730("an" + this.anchorVal);
                this.sourceVal = 0L;
                this.activeVal = l;
                return;
            }
        }
        if (this.sourceVal == 0L && l - this.activeVal >= 4000L) {
            this.weightVal("FunTime did not confirm connection to anarchy #" + this.anchorVal + ".");
        }
    }

    private int limitVal() {
        int n = this.speedVal();
        if (this.secondaryVal(n)) {
            return n;
        }
        ServerProfileTracker.primaryVal.primaryVal();
        return this.secondaryVal(ServerProfileTracker.primaryVal.tertiaryVal());
    }

    private int speedVal() {
        int n;
        if (RejoinAnarchyCommand.a_.field_1687 == null) {
            return -1;
        }
        class_269 class_2694 = RejoinAnarchyCommand.a_.field_1687.method_8428();
        ArrayList<String> arrayList = new ArrayList<String>();
        this.primaryVal(class_2694.method_1189(class_8646.field_45157), class_2694, arrayList);
        for (class_266 object : class_2694.method_1151()) {
            this.primaryVal(object, class_2694, arrayList);
        }
        for (String string : arrayList) {
            n = this.primaryVal(timerVal, string);
            if (!this.secondaryVal(n)) continue;
            return n;
        }
        for (String string : arrayList) {
            n = this.primaryVal(widthVal, string);
            if (!this.secondaryVal(n)) continue;
            return n;
        }
        for (String string : arrayList) {
            n = this.primaryVal(holderVal, string);
            if (!this.secondaryVal(n)) continue;
            return n;
        }
        return -1;
    }

    private void primaryVal(class_266 class_2662, class_269 class_2694, List<String> list) {
        if (class_2662 == null) {
            return;
        }
        list.add(class_2662.method_1114().getString());
        Collection<class_9011> collection = class_2694.method_1184(class_2662);
        for (class_9011 class_90112 : collection) {
            class_268 class_2682 = class_2694.method_1164(class_90112.comp_2127());
            list.add(class_268.method_1142((class_270)class_2682, (class_2561)class_2561.method_43470((String)class_90112.comp_2127())).getString());
        }
    }

    private boolean widthVal() {
        if (RejoinAnarchyCommand.a_.field_1687 == null) {
            return false;
        }
        class_269 class_2694 = RejoinAnarchyCommand.a_.field_1687.method_8428();
        class_266 class_2662 = class_2694.method_1189(class_8646.field_45157);
        if (class_2662 != null) {
            if (this.primaryVal(class_2662.method_1114().getString())) {
                return true;
            }
        }
        Iterator iterator = class_2694.method_1151().iterator();
        while (iterator.hasNext()) {
            class_266 class_2665 = (class_266)iterator.next();
            if (!this.primaryVal(class_2665.method_1114().getString())) continue;
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(String string) {
        String string2 = this.marginVal(string);
        if (string2.contains("anarchy-")) return true;
        if (string2.contains("anarchy #")) return true;
        if (!string2.contains("anarchy-")) return false;
        return true;
    }

    private int primaryVal(Pattern pattern, String string) {
        Matcher matcher = pattern.matcher(this.marginVal(string));
        if (!matcher.find()) {
            return -1;
        }
        return this.secondaryVal(matcher.group(1));
    }

    private boolean secondaryVal(int n) {
        return n >= 1 && n <= 66;
    }

    private int secondaryVal(String string) {
        if (string == null) {
            return -1;
        }
        String string2 = string.replaceAll("\\D+", "");
        if (string2.isEmpty()) {
            return -1;
        }
        try {
            return Integer.parseInt(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }

    private int tertiaryVal(int n) {
        if (n <= 15) {
            return 0;
        }
        if (n <= 31) {
            return 1;
        }
        if (n <= 47) {
            return 2;
        }
        return 3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean tertiaryVal(String string) {
        if (string.contains("server is full")) return true;
        if (string.contains("were kicked while connecting")) return true;
        if (string.contains("failed to connect")) return true;
        if (string.contains("connection error")) return true;
        if (string.contains("server unavailable")) return true;
        if (string.contains("no free slots")) return true;
        if (string.contains("failed to connect")) return true;
        if (string.contains("could not connect")) return true;
        if (string.contains("server is full")) return true;
        if (!string.contains("server unavailable")) return false;
        return true;
    }

    private String marginVal(String string) {
        return string == null ? "" : string.replaceAll("(?i)\u00a7.", "").replace('\u00a0', ' ').replaceAll("\\s+", " ").trim().toLowerCase(Locale.ROOT);
    }

    private void chunkVal() {
        this.blockRef();
    }

    private void weightVal(String string) {
        ChatLogger.primaryVal("\u00a7c[RCT] " + string);
        this.blockRef();
    }

    private void blockRef() {
        this.weightRef = false;
        this.bufferVal = false;
        this.countVal = false;
        this.depthVal = false;
        this.anchorVal = -1;
        this.descRef = 0L;
        this.activeVal = 0L;
        this.radiusVal = 0L;
        this.factorVal = 0L;
        this.sourceVal = 0L;
    }

    private void holderVal() {
        ChatLogger.primaryVal("§cUsage: " + this.tertiaryVal());
        ChatLogger.primaryVal("§7Without a number, the command uses the current anarchy from the scoreboard.");
    }

    static {
        Loader.initialize();
        widthVal = Pattern.compile("(?iu)(?:\u043a\u043b\u0430\u043d\\s*\u043b\u0430\u0439\u0442|\u043a\u043b\u0430\u043d\u043b\u0430\u0439\u0442|clan\\s*lite|clanlite|\u043b\u0430\u0439\u0442|lite|\u0430\u043d\u0430\u0440\u0445(?:\u0438\u044f|\u0438\u0438)?|anarchy)[^\\d#\u2116]{0,24}[#\u2116]?\\s*(\\d{1,2})(?!\\d)");
        holderVal = Pattern.compile("(?u)[#\u2116]\\s*(\\d{1,2})(?!\\d)");
        timerVal = Pattern.compile("(?iu)\u0430\u043d\u0430\u0440\u0445(?:\u0438\u044f)?\\s*[-#\u2116]?\\s*(\\d{1,2})(?!\\d)");
    }
}

