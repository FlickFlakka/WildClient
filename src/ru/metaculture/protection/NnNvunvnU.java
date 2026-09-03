/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTexture
 *  net.minecraft.class_1044
 *  net.minecraft.class_1060
 *  net.minecraft.class_10868
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1937
 *  net.minecraft.class_243
 *  net.minecraft.class_2663
 *  net.minecraft.class_2960
 *  net.minecraft.class_3532
 *  net.minecraft.class_4184
 *  org.json.JSONObject
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.textures.GpuTexture;
import java.awt.Color;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_10868;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1937;
import net.minecraft.class_243;
import net.minecraft.class_2596;
import net.minecraft.class_2663;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import org.json.JSONObject;
import org.wild.module.api.Module;
import ru.metaculture.protection.WorldVariantDetector;
import ru.metaculture.protection.RenderHudEvent;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.FriendCommand;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.IrcWebSocketClient;
import ru.metaculture.protection.MouseButtonEvent;
import ru.metaculture.protection.ServerProfileTracker;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

public class NnNvunvnU
extends Module {
    private static final class_2960 groupVal = class_2960.method_60655((String)"wild", (String)"textures/png/skull_state_0.png");
    private static final class_2960 layerVal = class_2960.method_60655((String)"wild", (String)"textures/png/skull_state_1.png");
    private static final class_2960 slotVal = class_2960.method_60655((String)"wild", (String)"textures/png/skull_state_2.png");
    public final ModeSetting countVal;
    public final SettingGroup depthVal;
    public final BoolSetting descRef;
    public final KeybindSetting activeVal;
    public final BoolSetting radiusVal;
    public final BoolSetting factorVal;
    public static String sourceVal = "";
    private String themeVal;
    private long stageVal;
    public static double extraRef;
    public static double phaseVal;
    public static double limitRef;
    private long widthRef;

    public NnNvunvnU() {
        String[] stringArray = new String[2];
        stringArray[0] = "All";
        stringArray[1] = "Friends only";
        this.countVal = new ModeSetting("Display: ", "Friends only", stringArray);
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[3];
        vvNnnUNnVvnArray[0] = new BoolSetting("Show in tab list", true);
        vvNnnUNnVvnArray[1] = new BoolSetting("Show in nametags", false);
        vvNnnUNnVvnArray[2] = new BoolSetting("Show logo", false);
        this.depthVal = new SettingGroup("Information", vvNnnUNnVvnArray);
        this.descRef = new BoolSetting("Marker placement", true);
        this.activeVal = new KeybindSetting("Placement button", -1).primaryVal(this.descRef::tertiaryVal);
        this.radiusVal = new BoolSetting("Target focus", true);
        this.factorVal = new BoolSetting("Counter for enemy totems popped", true);
        this.themeVal = "";
        this.stageVal = 0L;
        this.widthRef = 0L;
        Setting[] nvUuvVvuuNArray = new Setting[6];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        nvUuvVvuuNArray[5] = this.factorVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Subscribe
    public void primaryVal(MouseButtonEvent spanD) {
        if (WorldVariantDetector.primaryVal()) {
            return;
        }
        if (spanD.marginVal() == this.activeVal.tertiaryVal()) {
            // empty if block
        }
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        Object object;
        Object object2;
        if (WorldVariantDetector.primaryVal()) {
            return;
        }
        if (IrcWebSocketClient.primaryVal != null) {
            IrcWebSocketClient.primaryVal.tertiaryVal();
        }
        if (System.currentTimeMillis() - this.stageVal > 200L) {
            this.stageVal = System.currentTimeMillis();
            if (NnNvunvnU.mc.field_1724 != null) {
                if (NnNvunvnU.mc.field_1687 != null) {
                    ServerProfileTracker.primaryVal.primaryVal();
                    object2 = NnNvunvnU.mc.field_1687.method_27983().method_29177().method_12832();
                    float f = NnNvunvnU.mc.field_1724.method_6032() + NnNvunvnU.mc.field_1724.method_6067();
                    boolean bl = ServerProfileTracker.secondaryVal();
                    IrcWebSocketClient vUUvvNUVNvNU2 = IrcWebSocketClient.primaryVal;
                    if (vUUvvNUVNvNU2 != null) {
                        vUUvvNUVNvNU2.primaryVal(NnNvunvnU.mc.field_1724.method_23317(), NnNvunvnU.mc.field_1724.method_23318(), NnNvunvnU.mc.field_1724.method_23321(), (String)object2, f, ServerProfileTracker.primaryVal.tertiaryVal(), bl);
                    }
                }
            }
        }
        if ((object = AttackAuraModule.tokenVal) instanceof class_1657) {
            class_1657 targetPlayer = (class_1657)object;
            String string = sourceVal = targetPlayer.method_5805() && targetPlayer.method_6032() > 0.0f ? targetPlayer.method_5477().getString() : "";
        }
        if (!sourceVal.isEmpty() && FriendCommand.primaryVal(sourceVal)) {
            sourceVal = "";
        }
        if (NnNvunvnU.mc.field_1687 != null) {
            class_1657 nearestFriend = null;
            for (class_1657 class_16572 : NnNvunvnU.mc.field_1687.method_18456()) {
                if (!class_16572.method_5805() || class_16572.method_6032() <= 0.0f) {
                    IrcWebSocketClient.weightVal.remove(class_16572.method_5477().getString());
                    if (!class_16572.method_5477().getString().equalsIgnoreCase(sourceVal)) continue;
                    sourceVal = "";
                    continue;
                }
                if (!class_16572.method_5477().getString().equalsIgnoreCase(sourceVal)) continue;
                nearestFriend = class_16572;
            }
            if (this.radiusVal.tertiaryVal() && IrcWebSocketClient.primaryVal != null) {
                if (IrcWebSocketClient.primaryVal.isOpen()) {
                    long l = System.currentTimeMillis();
                    if (nearestFriend != null) {
                        extraRef = nearestFriend.method_23317();
                        phaseVal = nearestFriend.method_23318();
                        limitRef = nearestFriend.method_23321();
                        if (l - this.widthRef > 200L) {
                            this.widthRef = l;
                            this.primaryVal(sourceVal, extraRef, phaseVal, limitRef);
                        }
                    } else if (sourceVal.isEmpty() && !this.themeVal.isEmpty()) {
                        this.widthRef = l;
                        this.primaryVal("", 0.0, 0.0, 0.0);
                    }
                }
            }
        }
    }

    private void primaryVal(String string, double d, double d2, double d3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", (Object)"target_sync");
            jSONObject.put("user", (Object)mc.method_1548().method_1676());
            jSONObject.put("target", (Object)string);
            jSONObject.put("server", (Object)IrcWebSocketClient.primaryVal());
            if (!string.isEmpty()) {
                jSONObject.put("x", d);
                jSONObject.put("y", d2);
                jSONObject.put("z", d3);
            }
            IrcWebSocketClient.primaryVal.send(jSONObject.toString());
            this.themeVal = string;
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        class_2663 class_26632;
        if (WorldVariantDetector.primaryVal() || !this.factorVal.tertiaryVal()) {
            return;
        }
        class_2596<?> class_25962 = uvUUuvnunU2.marginVal();
        class_1297 class_12972;
        if (class_25962 instanceof class_2663 && (class_26632 = (class_2663)class_25962).method_11470() == 35 && (class_12972 = class_26632.method_11469((class_1937)NnNvunvnU.mc.field_1687)) instanceof class_1657) {
            class_1657 class_16572 = (class_1657)class_12972;
            String string = class_16572.method_5477().getString();
            int n = IrcWebSocketClient.weightVal.getOrDefault(string, 0) + 1;
            IrcWebSocketClient.weightVal.put(string, n);
            IrcWebSocketClient.paramVal.put(string, System.currentTimeMillis());
            if (AttackAuraModule.tokenVal != null && AttackAuraModule.tokenVal.method_5628() == class_12972.method_5628() && IrcWebSocketClient.primaryVal != null && IrcWebSocketClient.primaryVal.isOpen()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", (Object)"totem_pop");
                    jSONObject.put("attacker", (Object)mc.method_1548().method_1676());
                    jSONObject.put("victim", (Object)string);
                    jSONObject.put("count", n);
                    jSONObject.put("server", (Object)IrcWebSocketClient.primaryVal());
                    IrcWebSocketClient.primaryVal.send(jSONObject.toString());
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
        }
    }

    @Subscribe
    public void primaryVal(RenderHudEvent partD) {
        IrcWebSocketClient.cursorVal panelVal;
        if (WorldVariantDetector.primaryVal() || !this.radiusVal.tertiaryVal()) {
            return;
        }
        HashSet<String> hashSet = new HashSet<String>();
        if (!sourceVal.isEmpty()) {
            hashSet.add(sourceVal);
        }
        String string = IrcWebSocketClient.primaryVal();
        if (IrcWebSocketClient.primaryVal != null && IrcWebSocketClient.primaryVal.isOpen()) {
            boolean bl = "Friends only".equals(this.countVal.tertiaryVal());
            String string2 = mc.method_1548() != null ? mc.method_1548().method_1676() : "";
            Iterator<Map.Entry<String, IrcWebSocketClient.cursorVal>> iterator = IrcWebSocketClient.marginVal.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, IrcWebSocketClient.cursorVal> entry = iterator.next();
                String string3 = (String)entry.getKey();
                panelVal = (IrcWebSocketClient.cursorVal)entry.getValue();
                if (bl && !string3.equals(string2) && !FriendCommand.primaryVal(string3) || !panelVal.secondaryVal.equals(string)) continue;
                hashSet.add(panelVal.primaryVal);
            }
        }
        if (hashSet.isEmpty()) {
            return;
        }
        float f = mc.method_61966().method_60637(true);
        long l = System.currentTimeMillis();
        assert (NnNvunvnU.mc.field_1687 != null);
        for (String string3 : hashSet) {
            class_1657 matchedFriend = null;
            Iterator iterator = NnNvunvnU.mc.field_1687.method_18456().iterator();
            while (iterator.hasNext()) {
                class_1657 class_16572 = (class_1657)iterator.next();
                if (!class_16572.method_5477().getString().equalsIgnoreCase(string3) || class_16572 == NnNvunvnU.mc.field_1724) continue;
                matchedFriend = class_16572;
                break;
            }
            if (matchedFriend != null) {
                this.primaryVal(partD.marginVal(), matchedFriend, f);
                continue;
            }
            double d = 0.0;
            double d2 = 0.0;
            double d3 = 0.0;
            boolean bl = false;
            long l2 = 0L;
            Iterator<IrcWebSocketClient.cursorVal> iterator2 = IrcWebSocketClient.marginVal.values().iterator();
            while (iterator2.hasNext()) {
                IrcWebSocketClient.cursorVal nvnNNunvv3 = iterator2.next();
                if (!nvnNNunvv3.primaryVal.equalsIgnoreCase(string3) || !nvnNNunvv3.secondaryVal.equals(string)) continue;
                l2 = l - nvnNNunvv3.speedVal;
                if (l2 >= 4000L) continue;
                double d4 = class_3532.method_15350((double)((double)l2 / 200.0), (double)0.0, (double)1.0);
                d = class_3532.method_16436((double)d4, (double)nvnNNunvv3.paramVal, (double)nvnNNunvv3.tertiaryVal);
                d2 = class_3532.method_16436((double)d4, (double)nvnNNunvv3.extraVal, (double)nvnNNunvv3.marginVal);
                d3 = class_3532.method_16436((double)d4, (double)nvnNNunvv3.limitVal, (double)nvnNNunvv3.weightVal);
                bl = true;
                break;
            }
            if (!bl && string3.equalsIgnoreCase(sourceVal)) {
                d = extraRef;
                d2 = phaseVal;
                d3 = limitRef;
                bl = true;
            }
            if (!bl) continue;
            float f2 = 1.0f;
            if (l2 > 3000L) {
                f2 = 1.0f - (float)(l2 - 3000L) / 1000.0f;
                f2 = class_3532.method_15363((float)f2, (float)0.0f, (float)1.0f);
            }
            float f3 = 20.0f;
            this.primaryVal(partD.marginVal(), string3, d, d2 + 2.0, d3, f3, 20.0f, f2);
        }
    }

    private void primaryVal(Renderer2D heightVal, class_1657 class_16572, float f) {
        double d = class_3532.method_16436((double)f, (double)class_16572.field_6014, (double)class_16572.method_23317());
        double d2 = class_3532.method_16436((double)f, (double)class_16572.field_6036, (double)class_16572.method_23318());
        double d3 = class_3532.method_16436((double)f, (double)class_16572.field_5969, (double)class_16572.method_23321());
        float f2 = class_16572.method_6032() + class_16572.method_6067();
        float f3 = class_16572.method_6063();
        this.primaryVal(heightVal, class_16572.method_5477().getString(), d, d2 + (double)class_16572.method_17682(), d3, f2, f3, 1.0f);
    }

    private void primaryVal(Renderer2D heightVal, String string, double d, double d2, double d3, float f, float f2, float f3) {
        int n;
        float f4;
        float f5;
        boolean bl;
        class_243 class_2432;
        block7: {
            block6: {
                class_243 class_2433 = new class_243(d, d2, d3);
                class_4184 class_41842 = NnNvunvnU.mc.field_1773.method_19418();
                class_243 class_2434 = class_41842.method_19326();
                if (class_2433.method_1025(class_2434) < 1.0E-6) {
                    return;
                }
                class_2432 = VnNnNnvuvn.primaryVal(class_2433);
                if (class_2432 == null || class_2432.field_1350 <= (double)0.001f) break block6;
                if (!(class_2432.field_1350 > 1.0)) break block7;
            }
            return;
        }
        float f6 = (float)class_2432.field_1352;
        float f7 = (float)class_2432.field_1351;
        long l = IrcWebSocketClient.paramVal.getOrDefault(string, 0L);
        boolean bl2 = bl = System.currentTimeMillis() - l < 2500L;
        class_2960 class_29602 = bl ? slotVal : (f <= f2 / 2.0f ? layerVal : groupVal);
        int n2 = this.primaryVal(class_29602);
        if (n2 > 0 && f3 > 0.05f) {
            float f8 = 28.0f;
            float f9 = 15.0f;
            f5 = f6 - f8 / 2.0f;
            f4 = f7 - f8 - f9;
            heightVal.primaryVal(f5, f4);
            heightVal.primaryVal(f8 / 2.0f, f8 / 2.0f);
            heightVal.secondaryVal(1.0f, -1.0f);
            heightVal.primaryVal(-f8 / 2.0f, -f8 / 2.0f);
            heightVal.primaryVal(n2, 0.0f, 0.0f, f8, f8);
            heightVal.limitVal();
            heightVal.speedVal();
            heightVal.limitVal();
            heightVal.limitVal();
        }
        if (this.factorVal.tertiaryVal() && (n = IrcWebSocketClient.weightVal.getOrDefault(string, 0).intValue()) > 0) {
            String string2 = n + " totems";
            f5 = 22.0f;
            f4 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string2, (float)f5).primaryVal;
            heightVal.primaryVal(FontRegistry.primaryVal, f6 - f4 / 2.0f, f7 - 5.0f, f5, string2, this.primaryVal(Color.WHITE.getRGB(), f3));
        }
    }

    private int primaryVal(int n, float f) {
        int n2 = n >> 24 & 0xFF;
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        n2 = (int)((float)n2 * f);
        return Renderer2D.VvunVVUvUNnv.tertiaryVal(n3, n4, n5, n2);
    }

    private int primaryVal(class_2960 class_29602) {
        class_1060 class_10602 = mc.method_1531();
        if (class_10602 == null) {
            return -1;
        }
        class_1044 class_10442 = class_10602.method_4619(class_29602);
        if (class_10442 == null) {
            return -1;
        }
        GpuTexture gpuTexture = class_10442.method_68004();
        if (!(gpuTexture instanceof class_10868)) {
            return -1;
        }
        class_10868 class_108682 = (class_10868)gpuTexture;
        int n = class_108682.method_68427();
        return n > 0 ? n : -1;
    }
}

