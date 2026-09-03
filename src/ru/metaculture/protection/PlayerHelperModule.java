/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  it.unimi.dsi.fastutil.objects.Object2IntMap$Entry
 *  net.minecraft.class_1268
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1713
 *  net.minecraft.class_1735
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2720
 *  net.minecraft.class_2815
 *  net.minecraft.class_2824
 *  net.minecraft.class_2846
 *  net.minecraft.class_2856
 *  net.minecraft.class_2856$class_2857
 *  net.minecraft.class_2885
 *  net.minecraft.class_2886
 *  net.minecraft.class_408
 *  net.minecraft.class_418
 *  net.minecraft.class_5537
 *  net.minecraft.class_7439
 *  net.minecraft.class_9276
 *  net.minecraft.class_9304
 *  net.minecraft.class_9334
 *  net.minecraft.class_9837
 */
package ru.metaculture.protection;

import com.google.gson.JsonObject;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_1268;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1735;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2720;
import net.minecraft.class_2815;
import net.minecraft.class_2824;
import net.minecraft.class_2846;
import net.minecraft.class_2856;
import net.minecraft.class_2885;
import net.minecraft.class_2886;
import net.minecraft.class_408;
import net.minecraft.class_418;
import net.minecraft.class_5537;
import net.minecraft.class_7439;
import net.minecraft.class_9276;
import net.minecraft.class_9304;
import net.minecraft.class_9334;
import net.minecraft.class_9837;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WorldVariantDetector;
import ru.metaculture.protection.InputFreezeManager;
import ru.metaculture.protection.InventoryUtil;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.VuNvNNvVV;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.MouseButtonEvent;
import ru.metaculture.protection.ServerProfileTracker;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="PlayerHelper", tertiaryVal=ModuleCategory.Player, secondaryVal="Useful tweaks for the player")
public class PlayerHelperModule
extends Module {
    private static final String levelVal = "PlayerHelper_AutoArmor";
    public final ModeSetting countVal;
    public final BoolSetting depthVal;
    public final BoolSetting descRef;
    public final BoolSetting activeVal;
    public final BoolSetting radiusVal;
    public final FloatSetting factorVal;
    public final BoolSetting sourceVal;
    public final ModeSetting extraRef;
    public final KeybindSetting phaseVal;
    public final BoolSetting limitRef;
    public final BoolSetting paramRef;
    public final FloatSetting groupVal;
    public final BoolSetting layerVal;
    public final FloatSetting slotVal;
    public final KeybindSetting themeVal;
    public final BoolSetting stageVal;
    public final BoolSetting widthRef;
    private int UuNnnVnuNNV;
    private boolean depthRef;
    public static boolean trackVal = false;
    public static boolean modeRef = false;
    private int speedRef;
    private float countRef;
    public static boolean angleVal = false;
    public static float heightRef = 0.25f;
    private final VuNvNNvVV entryVal;
    private final VuNvNNvVV guardVal;
    private WildClient VUuuVUnun;
    private int vVVuuVVv;
    private int VuunNUUUvu;
    private String NNUUNUuVNNVn;
    private String VvVvnNUnvuvV;
    private String tokenVal;
    private boolean NUVvUUVuVNVv;

    public PlayerHelperModule() {
        String[] stringArray = new String[3];
        stringArray[0] = "Load";
        stringArray[1] = "Skip";
        stringArray[2] = "Vanilla";
        this.countVal = new ModeSetting("Resource pack mode", "Load", stringArray);
        this.depthVal = new BoolSetting("Auto respawn", true);
        this.descRef = new BoolSetting("Skip resource packs", true);
        this.activeVal = new BoolSetting("Print death coordinates", false);
        this.radiusVal = new BoolSetting("Automatically eat", false);
        this.factorVal = new FloatSetting("Hunger threshold", 10.0f, 1.0f, 20.0f, 1.0f, false).primaryVal(() -> !this.radiusVal.tertiaryVal());
        this.sourceVal = new BoolSetting("Send coordinates", false);
        this.extraRef = new ModeSetting("Send to: ", "SOS.To Clan", "Friends", "Global chat", "SOS.To Clan").primaryVal(() -> !this.sourceVal.tertiaryVal());
        this.phaseVal = new KeybindSetting("Send keybind", -1).primaryVal(() -> !this.sourceVal.tertiaryVal());
        this.limitRef = new BoolSetting("Don't break item", false);
        this.paramRef = new BoolSetting("Automatically repair", false);
        this.groupVal = new FloatSetting("Durability threshold", 100.0f, 1.0f, 500.0f, 1.0f, false).primaryVal(() -> !this.paramRef.tertiaryVal());
        this.layerVal = new BoolSetting("AutoArmor", false);
        this.slotVal = new FloatSetting("Equip speed", 150.0f, 50.0f, 1000.0f, 50.0f, false).primaryVal(() -> !this.layerVal.tertiaryVal());
        this.themeVal = new KeybindSetting("Zoom keybind", -1, true);
        this.stageVal = new BoolSetting("Send /event delay when joining a new anarchy", true);
        this.widthRef = new BoolSetting("Rejoin when AFK", true);
        this.UuNnnVnuNNV = -1;
        this.depthRef = false;
        this.speedRef = -1;
        this.countRef = 0.0f;
        this.entryVal = new VuNvNNvVV();
        this.guardVal = new VuNvNNvVV();
        this.VUuuVUnun = null;
        this.vVVuuVVv = 0;
        this.VuunNUUUvu = 0;
        this.NNUUNUuVNNVn = "N/A";
        this.VvVvnNUnvuvV = "N/A";
        this.tokenVal = "N/A";
        this.NUVvUUVuVNVv = false;
        Setting[] nvUuvVvuuNArray = new Setting[16];
        nvUuvVvuuNArray[0] = this.depthVal;
        nvUuvVvuuNArray[1] = this.countVal;
        nvUuvVvuuNArray[2] = this.activeVal;
        nvUuvVvuuNArray[3] = this.radiusVal;
        nvUuvVvuuNArray[4] = this.factorVal;
        nvUuvVvuuNArray[5] = this.sourceVal;
        nvUuvVvuuNArray[6] = this.extraRef;
        nvUuvVvuuNArray[7] = this.phaseVal;
        nvUuvVvuuNArray[8] = this.limitRef;
        nvUuvVvuuNArray[9] = this.paramRef;
        nvUuvVvuuNArray[10] = this.groupVal;
        nvUuvVvuuNArray[11] = this.layerVal;
        nvUuvVvuuNArray[12] = this.slotVal;
        nvUuvVvuuNArray[13] = this.themeVal;
        nvUuvVvuuNArray[14] = this.stageVal;
        nvUuvVvuuNArray[15] = this.widthRef;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void loadConfig(JsonObject jsonObject) {
        JsonObject jsonObject2;
        block9: {
            block8: {
                super.loadConfig(jsonObject);
                if (jsonObject == null) {
                    return;
                }
                jsonObject2 = null;
                try {
                    jsonObject2 = jsonObject.getAsJsonObject("Settings");
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
                if (jsonObject2 == null) break block8;
                if (jsonObject2.has(this.countVal.primaryVal)) break block8;
                if (jsonObject2.has(this.descRef.primaryVal)) break block9;
            }
            return;
        }
        try {
            boolean bl = jsonObject2.get(this.descRef.primaryVal).getAsBoolean();
            this.countVal.weightVal = bl ? "Skip" : "Load";
            this.countVal.limitVal = this.countVal.marginVal.indexOf(this.countVal.weightVal);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean blockRef() {
        if (trackVal) return true;
        if (!modeRef) return false;
        return true;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.NNUUNUuVNNVn = "N/A";
        this.VvVvnNUnvuvV = "N/A";
        this.tokenVal = "N/A";
        this.NUVvUUVuVNVv = false;
        this.entryVal.primaryVal();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        if (WorldVariantDetector.primaryVal() || PlayerHelperModule.mc.field_1724 == null || PlayerHelperModule.mc.field_1687 == null) {
            return;
        }
        this.weightRef();
        this.holderVal();
        this.timerVal();
        if (PlayerHelperModule.mc.field_1724.method_6032() <= 0.0f || PlayerHelperModule.mc.field_1755 instanceof class_418) {
            if (this.activeVal.tertiaryVal() && PlayerHelperModule.mc.field_1724.field_6213 < 2) {
                Object[] objectArray = new Object[3];
                objectArray[0] = (int)PlayerHelperModule.mc.field_1724.method_23317();
                objectArray[1] = (int)PlayerHelperModule.mc.field_1724.method_23318();
                objectArray[2] = (int)PlayerHelperModule.mc.field_1724.method_23321();
                PlayerHelperModule.mc.field_1724.method_7353(class_2561.method_30163((String)String.format("\u00a7cDeathCoords: \u00a7fX: %d Y: %d Z: %d", objectArray)), false);
            }
            if (this.depthVal.tertiaryVal()) {
                PlayerHelperModule.mc.field_1724.method_7331();
                mc.method_1507(null);
            }
            this.layerVal();
            this.activeVal();
            this.sourceVal();
            return;
        }
        if (this.radiusVal.tertiaryVal()) {
            this.paramRef();
        }
        if (this.limitRef.tertiaryVal()) {
            this.bufferVal();
        }
        if (this.paramRef.tertiaryVal() && !trackVal) {
            this.countVal();
        }
        if (this.layerVal.tertiaryVal()) {
            this.radiusVal();
        }
    }

    @Subscribe
    public void primaryVal(MouseButtonEvent spanD) {
        block5: {
            block4: {
                if (PlayerHelperModule.mc.field_1755 != null || PlayerHelperModule.mc.field_1724 == null) break block4;
                if (spanD.paramVal() == 1) break block5;
            }
            return;
        }
        if (spanD.marginVal() == this.phaseVal.tertiaryVal() && this.phaseVal.tertiaryVal() != -1 && this.sourceVal.tertiaryVal()) {
            this.limitRef();
        }
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        block6: {
            block7: {
                class_2720 class_27202;
                Object object;
                if (PlayerHelperModule.mc.field_1724 == null) {
                    return;
                }
                if (this.countVal.secondaryVal("Skip") && (object = uvUUuvnunU2.marginVal()) instanceof class_2720) {
                    class_27202 = (class_2720)object;
                    mc.method_1562().method_52787((class_2596)new class_2856(class_27202.comp_2158(), class_2856.class_2857.field_13016));
                    mc.method_1562().method_52787((class_2596)new class_2856(class_27202.comp_2158(), class_2856.class_2857.field_13017));
                    uvUUuvnunU2.secondaryVal();
                }
                if (this.widthRef.tertiaryVal() && (object = uvUUuvnunU2.marginVal()) instanceof class_7439 && this.primaryVal(((class_7439)object).comp_763().getString())) {
                    this.anchorVal();
                }
                if (!this.limitRef.tertiaryVal()) break block6;
                class_1799 class_17992 = PlayerHelperModule.mc.field_1724.method_6047();
                if (!this.primaryVal(class_17992)) break block6;
                if (uvUUuvnunU2.marginVal() instanceof class_2846) break block7;
                if (!(uvUUuvnunU2.marginVal() instanceof class_2885) && !(uvUUuvnunU2.marginVal() instanceof class_2824) && !(uvUUuvnunU2.marginVal() instanceof class_2886)) break block6;
            }
            uvUUuvnunU2.secondaryVal();
        }
    }

    private void holderVal() {
        ServerProfileTracker.primaryVal.primaryVal(200L);
        String string = this.secondaryVal(ServerProfileTracker.primaryVal.tertiaryVal());
        if (!this.tertiaryVal(string)) {
            return;
        }
        boolean bl = !string.equals(this.NNUUNUuVNNVn);
        this.NNUUNUuVNNVn = string;
        if (this.stageVal.tertiaryVal() && !string.equals(this.VvVvnNUnvuvV) && PlayerHelperModule.mc.field_1724.field_3944 != null) {
            PlayerHelperModule.mc.field_1724.field_3944.method_45730("event delay");
            this.VvVvnNUnvuvV = string;
        }
    }

    private void timerVal() {
        if (!this.NUVvUUVuVNVv || PlayerHelperModule.mc.field_1724 == null || PlayerHelperModule.mc.field_1724.field_3944 == null || ServerProfileTracker.secondaryVal()) {
            return;
        }
        if (!this.entryVal.weightVal(1000L)) {
            return;
        }
        PlayerHelperModule.mc.field_1724.field_3944.method_45730("an" + this.tokenVal);
        this.NUVvUUVuVNVv = false;
        this.entryVal.primaryVal();
    }

    private void anchorVal() {
        block6: {
            block5: {
                if (this.NUVvUUVuVNVv) break block5;
                if (PlayerHelperModule.mc.field_1724 == null) break block5;
                if (PlayerHelperModule.mc.field_1724.field_3944 != null) break block6;
            }
            return;
        }
        ServerProfileTracker.primaryVal.primaryVal();
        String string = this.secondaryVal(ServerProfileTracker.primaryVal.tertiaryVal());
        String string2 = this.tokenVal = this.tertiaryVal(string) ? string : this.NNUUNUuVNNVn;
        if (!this.tertiaryVal(this.tokenVal)) {
            return;
        }
        if (PlayerHelperModule.mc.field_1755 != null) {
            PlayerHelperModule.mc.field_1724.method_3137();
        }
        PlayerHelperModule.mc.field_1724.field_3944.method_45730("hub");
        this.NUVvUUVuVNVv = true;
        this.entryVal.primaryVal();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(String string) {
        if (string == null) {
            return false;
        }
        String string2 = string.replaceAll("\u00a7.", "").toLowerCase(Locale.ROOT);
        if (string2.contains("unavailable in afk mode")) return true;
        if (!string2.contains("cannot click in afk mode")) return false;
        return true;
    }

    private String secondaryVal(String string) {
        if (string == null) {
            return "N/A";
        }
        String string2 = string.replaceAll("\\D+", "");
        return string2.isEmpty() ? "N/A" : string2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean tertiaryVal(String string) {
        if (string == null) return false;
        if ("N/A".equals(string)) return false;
        if (string.isBlank()) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(KeybindSetting uVNuNUVvn2) {
        if (uVNuNUVvn2 == null) return false;
        if (uVNuNUVvn2.tertiaryVal() == -1) return false;
        return true;
    }

    private void weightRef() {
        if (this.themeVal.tertiaryVal() != -1) {
            boolean bl = KeybindSetting.secondaryVal(this.themeVal.tertiaryVal());
            if (angleVal && !bl) {
                heightRef = 0.25f;
            }
            angleVal = bl;
        } else {
            angleVal = false;
            heightRef = 0.25f;
        }
    }

    private void bufferVal() {
        class_1799 class_17992 = PlayerHelperModule.mc.field_1724.method_6047();
        if (this.primaryVal(class_17992)) {
            PlayerHelperModule.mc.field_1690.field_1886.method_23481(false);
            PlayerHelperModule.mc.field_1690.field_1904.method_23481(false);
        }
    }

    private boolean primaryVal(class_1799 class_17992) {
        if (class_17992 == null || !class_17992.method_7963()) {
            return false;
        }
        int n = class_17992.method_7936();
        if (n <= 0) {
            return false;
        }
        int n2 = n - class_17992.method_7919();
        int n3 = n < 70 ? Math.max(1, (int)Math.ceil((double)n * 0.12)) : 70;
        return n2 <= n3;
    }

    private void countVal() {
        block12: {
            block14: {
                block13: {
                    class_1799 class_17992;
                    block11: {
                        if (PlayerHelperModule.mc.field_1755 != null) {
                            if (modeRef) {
                                this.activeVal();
                            }
                            return;
                        }
                        class_1799 class_17993 = PlayerHelperModule.mc.field_1724.method_6047();
                        class_17992 = PlayerHelperModule.mc.field_1724.method_6079();
                        if (modeRef) break block11;
                        if (PlayerHelperModule.mc.field_1724.method_6115()) {
                            return;
                        }
                        if (class_17993.method_7963() && (float)(class_17993.method_7936() - class_17993.method_7919()) <= this.groupVal.tertiaryVal()) {
                            if (this.descRef() == -1) {
                                return;
                            }
                            modeRef = true;
                            this.speedRef = PlayerHelperModule.mc.field_1724.method_31548().method_67532();
                            this.countRef = PlayerHelperModule.mc.field_1724.method_36455();
                            PlayerHelperModule.mc.field_1761.method_2906(PlayerHelperModule.mc.field_1724.field_7498.field_7763, 45, this.speedRef, class_1713.field_7791, (class_1657)PlayerHelperModule.mc.field_1724);
                            this.depthVal();
                        }
                        break block12;
                    }
                    PlayerHelperModule.mc.field_1724.method_36457(90.0f);
                    if (class_17992.method_7960() || class_17992.method_7919() == 0) break block13;
                    if (class_17992.method_7963()) break block14;
                }
                this.activeVal();
                return;
            }
            if (PlayerHelperModule.mc.field_1724.method_6047().method_7909() != class_1802.field_8287) {
                if (!this.depthVal()) {
                    this.activeVal();
                    return;
                }
            }
            PlayerHelperModule.mc.field_1690.field_1904.method_23481(true);
            PlayerHelperModule.mc.field_1761.method_2919((class_1657)PlayerHelperModule.mc.field_1724, class_1268.field_5808);
        }
    }

    private boolean depthVal() {
        int n = this.descRef();
        if (n == -1) {
            return false;
        }
        if (n >= 36 && n <= 44) {
            PlayerHelperModule.mc.field_1724.method_31548().method_61496(n - 36);
        } else {
            PlayerHelperModule.mc.field_1761.method_2906(PlayerHelperModule.mc.field_1724.field_7498.field_7763, n, PlayerHelperModule.mc.field_1724.method_31548().method_67532(), class_1713.field_7791, (class_1657)PlayerHelperModule.mc.field_1724);
        }
        return true;
    }

    private int descRef() {
        for (int i = 9; i <= 44; ++i) {
            if (((class_1735)PlayerHelperModule.mc.field_1724.field_7498.field_7761.get(i)).method_7677().method_7909() != class_1802.field_8287) continue;
            return i;
        }
        return -1;
    }

    private void activeVal() {
        if (modeRef) {
            modeRef = false;
            PlayerHelperModule.mc.field_1690.field_1904.method_23481(false);
            PlayerHelperModule.mc.field_1724.method_36457(this.countRef);
            if (this.speedRef != -1) {
                PlayerHelperModule.mc.field_1761.method_2906(PlayerHelperModule.mc.field_1724.field_7498.field_7763, 45, this.speedRef, class_1713.field_7791, (class_1657)PlayerHelperModule.mc.field_1724);
                PlayerHelperModule.mc.field_1724.method_31548().method_61496(this.speedRef);
                this.speedRef = -1;
            }
        }
    }

    private void radiusVal() {
        if (this.vVVuuVVv > 0) {
            this.factorVal();
            return;
        }
        if (PlayerHelperModule.mc.field_1761 == null || trackVal || modeRef || PlayerHelperModule.mc.field_1724.method_6115()) {
            return;
        }
        if (!this.guardVal.weightVal((long)this.slotVal.tertiaryVal())) {
            return;
        }
        WildClient modeVal = this.extraRef();
        if (modeVal == null) {
            return;
        }
        this.VUuuVUnun = modeVal;
        this.vVVuuVVv = 1;
        this.VuunNUUUvu = 0;
        this.factorVal();
    }

    private void factorVal() {
        if (PlayerHelperModule.mc.field_1724 == null || PlayerHelperModule.mc.field_1687 == null || PlayerHelperModule.mc.field_1761 == null || this.VUuuVUnun == null) {
            this.sourceVal();
            return;
        }
        switch (this.vVVuuVVv) {
            case 1: {
                InputFreezeManager.primaryVal().primaryVal(levelVal);
                PlayerHelperModule.mc.field_1690.field_1867.method_23481(false);
                PlayerHelperModule.mc.field_1724.method_5728(false);
                this.vVVuuVVv = 2;
                this.VuunNUUUvu = 1;
                break;
            }
            case 2: {
                if (this.VuunNUUUvu-- > 0) {
                    return;
                }
                if (this.VUuuVUnun.fromBundle()) {
                    if (!this.primaryVal(this.VUuuVUnun)) {
                        this.sourceVal();
                        return;
                    }
                    this.vVVuuVVv = 3;
                    this.VuunNUUUvu = 1;
                    return;
                }
                InventoryUtil.primaryVal(this.VUuuVUnun.sourceSlot(), this.VUuuVUnun.armorSlotId());
                PlayerHelperModule.mc.field_1724.field_3944.method_52787((class_2596)new class_2815(PlayerHelperModule.mc.field_1724.field_7498.field_7763));
                this.guardVal.primaryVal();
                this.vVVuuVVv = 3;
                this.VuunNUUUvu = 1;
                break;
            }
            case 3: {
                if (this.VuunNUUUvu-- > 0) {
                    return;
                }
                if (this.VUuuVUnun.fromBundle()) {
                    InventoryUtil.primaryVal(this.VUuuVUnun.sourceSlot(), this.VUuuVUnun.armorSlotId());
                    PlayerHelperModule.mc.field_1724.field_3944.method_52787((class_2596)new class_2815(PlayerHelperModule.mc.field_1724.field_7498.field_7763));
                    this.guardVal.primaryVal();
                }
                this.sourceVal();
                break;
            }
            default: {
                this.sourceVal();
            }
        }
    }

    private boolean primaryVal(WildClient modeVal) {
        block5: {
            block4: {
                if (PlayerHelperModule.mc.field_1724 == null) break block4;
                if (PlayerHelperModule.mc.field_1761 == null) break block4;
                if (PlayerHelperModule.mc.field_1724.field_7498.method_34255().method_7960()) break block5;
            }
            return false;
        }
        class_1799 class_17992 = PlayerHelperModule.mc.field_1724.method_31548().method_5438(modeVal.bundleSlot());
        class_9276 class_92762 = (class_9276)class_17992.method_58694(class_9334.field_49650);
        if (!(class_17992.method_7909() instanceof class_5537) || class_92762 == null || modeVal.bundleIndex() >= class_92762.method_57426()) {
            return false;
        }
        int n = modeVal.bundleSlot() < 9 ? modeVal.bundleSlot() + 36 : modeVal.bundleSlot();
        class_5537.method_61637((class_1799)class_17992, (int)modeVal.bundleIndex());
        PlayerHelperModule.mc.field_1724.field_3944.method_52787((class_2596)new class_9837(n, modeVal.bundleIndex()));
        PlayerHelperModule.mc.field_1761.method_2906(PlayerHelperModule.mc.field_1724.field_7498.field_7763, n, 1, class_1713.field_7790, (class_1657)PlayerHelperModule.mc.field_1724);
        PlayerHelperModule.mc.field_1761.method_2906(PlayerHelperModule.mc.field_1724.field_7498.field_7763, modeVal.sourceSlot(), 0, class_1713.field_7790, (class_1657)PlayerHelperModule.mc.field_1724);
        return true;
    }

    private void sourceVal() {
        if (this.vVVuuVVv > 0) {
            InputFreezeManager.primaryVal().secondaryVal(levelVal);
        }
        this.VUuuVUnun = null;
        this.vVVuuVVv = 0;
        this.VuunNUUUvu = 0;
    }

    private WildClient extraRef() {
        WildClient modeVal = null;
        modeVal = this.primaryVal(modeVal, this.primaryVal(class_1304.field_6169, 5));
        modeVal = this.primaryVal(modeVal, this.primaryVal(class_1304.field_6174, 6));
        modeVal = this.primaryVal(modeVal, this.primaryVal(class_1304.field_6172, 7));
        modeVal = this.primaryVal(modeVal, this.primaryVal(class_1304.field_6166, 8));
        return modeVal;
    }

    private WildClient primaryVal(WildClient modeVal, WildClient nodeC) {
        if (nodeC == null) {
            return modeVal;
        }
        if (modeVal == null) {
            return nodeC;
        }
        return nodeC.improvement() > modeVal.improvement() ? nodeC : modeVal;
    }

    private WildClient primaryVal(class_1304 class_13042, int n) {
        int n2;
        class_1799 class_17992 = PlayerHelperModule.mc.field_1724.method_6118(class_13042);
        int n3 = this.primaryVal(class_17992, class_13042);
        int n4 = -1;
        int n5 = n3;
        for (n2 = 0; n2 < 36; ++n2) {
            class_1799 class_17993 = PlayerHelperModule.mc.field_1724.method_31548().method_5438(n2);
            int n6 = this.primaryVal(class_17993, class_13042);
            if (n6 <= n5) continue;
            n5 = n6;
            n4 = n2 < 9 ? n2 + 36 : n2;
        }
        n2 = this.phaseVal();
        if (n2 != -1) {
            for (int i = 0; i < 36; ++i) {
                class_9276 class_92762;
                class_1799 class_17994 = PlayerHelperModule.mc.field_1724.method_31548().method_5438(i);
                if (!(class_17994.method_7909() instanceof class_5537) || (class_92762 = (class_9276)class_17994.method_58694(class_9334.field_49650)) == null) continue;
                for (int j = 0; j < class_92762.method_57426(); ++j) {
                    int n7 = this.primaryVal(class_92762.method_57422(j), class_13042);
                    if (n7 <= n5) continue;
                    n5 = n7;
                    n4 = n2 < 9 ? n2 + 36 : n2;
                    return new WildClient(n4, n, n5 - n3, i, j);
                }
            }
        }
        return n4 == -1 ? null : new WildClient(n4, n, n5 - n3);
    }

    private int phaseVal() {
        for (int i = 0; i < 36; ++i) {
            if (!PlayerHelperModule.mc.field_1724.method_31548().method_5438(i).method_7960()) continue;
            return i;
        }
        return -1;
    }

    private int primaryVal(class_1799 class_17992, class_1304 class_13042) {
        if (class_17992 == null || class_17992.method_7960() || this.primaryVal(class_17992.method_7909()) != class_13042) {
            return -1;
        }
        int n = this.secondaryVal(class_17992.method_7909()) * 10000;
        class_9304 class_93042 = (class_9304)class_17992.method_58694(class_9334.field_49633);
        if (class_93042 != null && !class_93042.method_57543()) {
            for (Object2IntMap.Entry entry : class_93042.method_57539()) {
                n += entry.getIntValue() * 100;
            }
        }
        if (class_17992.method_7963()) {
            n += Math.max(0, class_17992.method_7936() - class_17992.method_7919()) * 100 / Math.max(1, class_17992.method_7936());
        }
        return n;
    }

    private class_1304 primaryVal(class_1792 class_17922) {
        block11: {
            block10: {
                block9: {
                    block8: {
                        if (class_17922 == class_1802.field_22027 || class_17922 == class_1802.field_8805 || class_17922 == class_1802.field_8743 || class_17922 == class_1802.field_8283 || class_17922 == class_1802.field_8862 || class_17922 == class_1802.field_8267) break block8;
                        if (class_17922 != class_1802.field_8090) break block9;
                    }
                    return class_1304.field_6169;
                }
                if (class_17922 == class_1802.field_22028 || class_17922 == class_1802.field_8058) break block10;
                if (class_17922 != class_1802.field_8523 && class_17922 != class_1802.field_8873 && class_17922 != class_1802.field_8678 && class_17922 != class_1802.field_8577) break block11;
            }
            return class_1304.field_6174;
        }
        if (class_17922 == class_1802.field_22029 || class_17922 == class_1802.field_8348 || class_17922 == class_1802.field_8396 || class_17922 == class_1802.field_8218 || class_17922 == class_1802.field_8416 || class_17922 == class_1802.field_8570) {
            return class_1304.field_6172;
        }
        if (class_17922 == class_1802.field_22030 || class_17922 == class_1802.field_8285 || class_17922 == class_1802.field_8660 || class_17922 == class_1802.field_8313 || class_17922 == class_1802.field_8753 || class_17922 == class_1802.field_8370) {
            return class_1304.field_6166;
        }
        return null;
    }

    private int secondaryVal(class_1792 class_17922) {
        block10: {
            block9: {
                if (class_17922 == class_1802.field_22027 || class_17922 == class_1802.field_22028 || class_17922 == class_1802.field_22029) break block9;
                if (class_17922 != class_1802.field_22030) break block10;
            }
            return 6;
        }
        if (class_17922 == class_1802.field_8805 || class_17922 == class_1802.field_8058 || class_17922 == class_1802.field_8348 || class_17922 == class_1802.field_8285) {
            return 5;
        }
        if (class_17922 == class_1802.field_8743 || class_17922 == class_1802.field_8523 || class_17922 == class_1802.field_8396 || class_17922 == class_1802.field_8660) {
            return 4;
        }
        if (class_17922 == class_1802.field_8283 || class_17922 == class_1802.field_8873 || class_17922 == class_1802.field_8218 || class_17922 == class_1802.field_8313) {
            return 3;
        }
        if (class_17922 == class_1802.field_8862 || class_17922 == class_1802.field_8678 || class_17922 == class_1802.field_8416 || class_17922 == class_1802.field_8753) {
            return 2;
        }
        if (class_17922 == class_1802.field_8267 || class_17922 == class_1802.field_8577 || class_17922 == class_1802.field_8570 || class_17922 == class_1802.field_8370) {
            return 1;
        }
        if (class_17922 == class_1802.field_8090) {
            return 2;
        }
        return 0;
    }

    private void limitRef() {
        String string;
        int n = (int)PlayerHelperModule.mc.field_1724.method_23317();
        int n2 = (int)PlayerHelperModule.mc.field_1724.method_23318();
        int n3 = (int)PlayerHelperModule.mc.field_1724.method_23321();
        Object[] objectArray = new Object[3];
        objectArray[0] = n;
        objectArray[1] = n2;
        objectArray[2] = n3;
        String string2 = String.format(" %d %d %d", objectArray);
        switch (string = this.extraRef.tertiaryVal()) {
            case "Global chat": {
                mc.method_1562().method_45729("! My coordinates:" + string2);
                break;
            }
            case "Friends": {
                List<String> list = FriendCommand.marginVal();
                if (list.isEmpty()) {
                    PlayerHelperModule.mc.field_1724.method_7353(class_2561.method_30163((String)"§cFriends list is empty!"), true);
                    return;
                }
                for (String string3 : list) {
                    mc.method_1562().method_45729("/msg " + string3 + " My coordinates:" + string2);
                }
                PlayerHelperModule.mc.field_1724.method_7353(class_2561.method_30163((String)"§aCoordinates sent to friends."), true);
                break;
            }
            case "SOS.To Clan": {
                mc.method_1562().method_45729("/clan chat" + string2);
            }
        }
    }

    private void paramRef() {
        class_1268 class_12682;
        if (PlayerHelperModule.mc.field_1755 != null && !(PlayerHelperModule.mc.field_1755 instanceof class_408)) {
            if (trackVal) {
                this.layerVal();
            }
            return;
        }
        if (!(!((float)PlayerHelperModule.mc.field_1724.method_7344().method_7586() >= this.factorVal.tertiaryVal()) || trackVal && PlayerHelperModule.mc.field_1724.method_6115())) {
            if (trackVal) {
                this.layerVal();
            }
            return;
        }
        if (!trackVal) {
            if (PlayerHelperModule.mc.field_1724.method_6115()) {
                return;
            }
        }
        if ((class_12682 = this.groupVal()) == null) {
            if (trackVal && !PlayerHelperModule.mc.field_1724.method_6115()) {
                this.layerVal();
            }
            return;
        }
        if (!trackVal) {
            this.primaryVal(class_12682);
        } else {
            this.secondaryVal(class_12682);
        }
    }

    private class_1268 groupVal() {
        class_1799 class_17992 = PlayerHelperModule.mc.field_1724.method_6047();
        if (class_17992.method_57826(class_9334.field_50075)) {
            return class_1268.field_5808;
        }
        class_1799 class_17993 = PlayerHelperModule.mc.field_1724.method_6079();
        if (class_17993.method_57826(class_9334.field_50075)) {
            return class_1268.field_5810;
        }
        for (int i = 0; i < 9; ++i) {
            if (!PlayerHelperModule.mc.field_1724.method_31548().method_5438(i).method_57826(class_9334.field_50075)) continue;
            return class_1268.field_5808;
        }
        return null;
    }

    private void primaryVal(class_1268 class_12682) {
        if (class_12682 == class_1268.field_5808) {
            int n = this.slotVal();
            if (n == -1) {
                return;
            }
            this.UuNnnVnuNNV = PlayerHelperModule.mc.field_1724.method_31548().method_67532();
            PlayerHelperModule.mc.field_1724.method_31548().method_61496(n);
        }
        PlayerHelperModule.mc.field_1690.field_1904.method_23481(true);
        if (PlayerHelperModule.mc.field_1761 != null) {
            PlayerHelperModule.mc.field_1761.method_2919((class_1657)PlayerHelperModule.mc.field_1724, class_12682);
        }
        this.depthRef = true;
        trackVal = true;
    }

    private void secondaryVal(class_1268 class_12682) {
        if (PlayerHelperModule.mc.field_1724.method_6115()) {
            PlayerHelperModule.mc.field_1690.field_1904.method_23481(true);
            this.depthRef = true;
        } else if (this.depthRef) {
            this.depthRef = false;
            this.layerVal();
        } else {
            PlayerHelperModule.mc.field_1690.field_1904.method_23481(true);
            if (PlayerHelperModule.mc.field_1761 != null) {
                PlayerHelperModule.mc.field_1761.method_2919((class_1657)PlayerHelperModule.mc.field_1724, class_12682);
            }
        }
    }

    private void layerVal() {
        if (trackVal) {
            PlayerHelperModule.mc.field_1690.field_1904.method_23481(false);
            if (this.UuNnnVnuNNV != -1 && PlayerHelperModule.mc.field_1724 != null) {
                PlayerHelperModule.mc.field_1724.method_31548().method_61496(this.UuNnnVnuNNV);
                this.UuNnnVnuNNV = -1;
            }
            this.depthRef = false;
            trackVal = false;
        }
    }

    private int slotVal() {
        for (int i = 0; i < 9; ++i) {
            if (!PlayerHelperModule.mc.field_1724.method_31548().method_5438(i).method_57826(class_9334.field_50075)) continue;
            return i;
        }
        return -1;
    }

    @Override
    public void onDisable() {
        this.layerVal();
        this.activeVal();
        this.sourceVal();
        angleVal = false;
        heightRef = 0.25f;
        this.NUVvUUVuVNVv = false;
        super.onDisable();
    }

    record WildClient(int sourceSlot, int armorSlotId, int improvement, int bundleSlot, int bundleIndex) {
        WildClient(int n, int n2, int n3) {
            this(n, n2, n3, -1, -1);
        }

        boolean fromBundle() {
            return this.bundleSlot >= 0 && this.bundleIndex >= 0;
        }
    }
}

