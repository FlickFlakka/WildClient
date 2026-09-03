/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1268
 *  net.minecraft.class_1657
 *  net.minecraft.class_1661
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1802
 *  net.minecraft.class_2596
 *  net.minecraft.class_2868
 *  net.minecraft.class_437
 *  net.minecraft.class_465
 *  net.minecraft.class_7439
 */
package ru.metaculture.protection;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_1268;
import net.minecraft.class_1657;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1802;
import net.minecraft.class_2596;
import net.minecraft.class_2868;
import net.minecraft.class_437;
import net.minecraft.class_465;
import net.minecraft.class_1703;
import net.minecraft.class_7439;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="ServerJoiner", tertiaryVal=ModuleCategory.Misc, secondaryVal="Auto-join servers (FunTime/SpookyTime)")
public class ServerJoinerModule
extends Module {
    public final ModeSetting countVal = new ModeSetting("Mode", "FunTime", "FunTime", "SpookyTime");
    private static final Pattern activeVal = Pattern.compile("anarchy\\s*(\\d+)");
    public final StringFilterSetting depthVal = new StringFilterSetting("Anarchy", "101").primaryVal(() -> !this.countVal.secondaryVal("FunTime"));
    public final BoolSetting descRef = new BoolSetting("Disable after joining", true);
    private final VuNvNNvVV radiusVal = new VuNvNNvVV();
    private int factorVal = -1;
    private boolean sourceVal;
    private boolean extraRef;

    public ServerJoinerModule() {
        Setting[] nvUuvVvuuNArray = new Setting[3];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.sourceVal = false;
        this.extraRef = false;
        this.radiusVal.primaryVal();
        if (this.countVal.secondaryVal("FunTime")) {
            this.factorVal = this.weightRef();
            if (this.factorVal <= 0) {
                ChatLogger.primaryVal("[ServerJoiner] Specify a valid anarchy in the settings.");
                this.toggle();
                return;
            }
            this.anchorVal();
        }
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (ServerJoinerModule.mc.field_1724 == null || ServerJoinerModule.mc.field_1687 == null || this.sourceVal) {
            return;
        }
        if (this.countVal.secondaryVal("FunTime")) {
            if (this.radiusVal.weightVal(50L)) {
                this.anchorVal();
                this.radiusVal.primaryVal();
            }
        } else if (this.countVal.secondaryVal("SpookyTime")) {
            if (this.extraRef && !this.timerVal()) {
                this.primaryVal("[ServerJoiner] Successfully joined SpookyTime duels.");
                return;
            }
            this.blockRef();
        }
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        if (!this.countVal.secondaryVal("FunTime") || !uvUUuvnunU2.weightVal().equals((Object)PacketEvent.PacketDirection.RECEIVE)) {
            return;
        }
        Object object = uvUUuvnunU2.marginVal();
        if (!(object instanceof class_7439)) {
            return;
        }
        class_7439 class_74392 = (class_7439)object;
        object = this.secondaryVal(class_74392.comp_763().getString());
        if (((String)object).isEmpty() || ((String)object).contains("server is full") || ((String)object).contains("were kicked while connecting")) {
            return;
        }
        if (this.tertiaryVal((String)object)) {
            this.primaryVal("[ServerJoiner] Already connected to this anarchy.");
            return;
        }
        Matcher matcher = activeVal.matcher((CharSequence)object);
        if (matcher.find()) {
            try {
                if (Integer.parseInt(matcher.group(1)) == this.factorVal) {
                    this.primaryVal("[ServerJoiner] Joined via /an" + this.factorVal + ".");
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
    }

    private void blockRef() {
        class_437 class_4372 = ServerJoinerModule.mc.field_1755;
        if (class_4372 instanceof class_465) {
            class_465 class_4652 = (class_465)class_4372;
            if (!this.primaryVal(class_4652)) {
                ChatLogger.primaryVal("[ServerJoiner] Wrong screen open for SpookyTime, module disabled.");
                this.setEnabled(false);
                return;
            }
            class_1703 class_17032 = class_4652.method_17577();
            for (int i = 0; i < class_17032.field_7761.size(); ++i) {
                class_1735 class_17352 = (class_1735)class_17032.field_7761.get(i);
                if (!class_17352.method_7677().method_31574(class_1802.field_23141)) continue;
                ServerJoinerModule.mc.field_1761.method_2906(class_17032.field_7763, i, 0, class_1713.field_7790, (class_1657)ServerJoinerModule.mc.field_1724);
                mc.method_1507(null);
                this.extraRef = true;
                this.radiusVal.primaryVal();
                return;
            }
        } else if (this.radiusVal.weightVal(500L)) {
            this.holderVal();
            this.radiusVal.primaryVal();
        }
    }

    private boolean primaryVal(class_465<?> class_4652) {
        return this.secondaryVal(class_4652.method_25440().getString()).equals("select mode: ");
    }

    private void holderVal() {
        class_1661 class_16612 = ServerJoinerModule.mc.field_1724.method_31548();
        for (int i = 0; i < 9; ++i) {
            if (!class_16612.method_5438(i).method_31574(class_1802.field_8251)) continue;
            if (class_16612.method_67532() != i) {
                class_16612.method_61496(i);
                mc.method_1562().method_52787((class_2596)new class_2868(i));
            }
            ServerJoinerModule.mc.field_1761.method_2919((class_1657)ServerJoinerModule.mc.field_1724, class_1268.field_5808);
            return;
        }
    }

    private boolean timerVal() {
        if (ServerJoinerModule.mc.field_1724 == null) {
            return false;
        }
        class_1661 class_16612 = ServerJoinerModule.mc.field_1724.method_31548();
        for (int i = 0; i < 9; ++i) {
            if (!class_16612.method_5438(i).method_31574(class_1802.field_8251)) continue;
            return true;
        }
        return false;
    }

    private void anchorVal() {
        if (ServerJoinerModule.mc.field_1724 != null) {
            if (ServerJoinerModule.mc.field_1724.field_3944 != null) {
                ServerJoinerModule.mc.field_1724.field_3944.method_45729("/an" + this.factorVal);
            }
        }
    }

    private void primaryVal(String string) {
        this.sourceVal = true;
        ChatLogger.primaryVal(string);
        if (this.descRef.tertiaryVal()) {
            this.toggle();
        }
    }

    private int weightRef() {
        String string = this.depthVal.tertiaryVal();
        if (string == null) {
            return -1;
        }
        String string2 = string.replaceAll("\\D+", "");
        return string2.isEmpty() ? -1 : Integer.parseInt(string2);
    }

    private String secondaryVal(String string) {
        return string == null ? "" : string.replaceAll("\u00a7.", "").toLowerCase(Locale.ROOT).trim();
    }

    private boolean tertiaryVal(String string) {
        return string.contains("you are already connected to this server") || string.contains("already connected to this server");
    }
}

