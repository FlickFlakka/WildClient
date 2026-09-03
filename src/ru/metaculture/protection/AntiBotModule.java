/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_1304
 *  net.minecraft.class_1657
 *  net.minecraft.class_1799
 *  net.minecraft.class_2596
 *  net.minecraft.class_2703
 *  net.minecraft.class_2703$class_2705
 *  net.minecraft.class_2703$class_5893
 *  net.minecraft.class_640
 *  net.minecraft.class_7828
 */
package ru.metaculture.protection;

import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_1304;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_2596;
import net.minecraft.class_2703;
import net.minecraft.class_640;
import net.minecraft.class_7828;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ModuleBadge;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.Subscribe;

@ModuleRegister(primaryVal="AntiBot", tertiaryVal=ModuleCategory.Combat, secondaryVal="Removes the bot behind you", marginVal={ModuleBadge.MATRIX, ModuleBadge.GRIM})
public class AntiBotModule
extends Module {
    public final ModeSetting countVal = new ModeSetting("Mode: ", "ALL", "ReallyWorld", "Matrix", "ALL");
    public static final Set<UUID> depthVal = ConcurrentHashMap.newKeySet();
    private static final Set<UUID> activeVal = ConcurrentHashMap.newKeySet();
    private final Set<UUID> radiusVal = ConcurrentHashMap.newKeySet();
    private final Map<UUID, List<class_1799>> factorVal = new ConcurrentHashMap<UUID, List<class_1799>>();
    public static boolean descRef = false;

    public AntiBotModule() {
        this.addSettings(this.countVal);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        descRef = true;
    }

    @Override
    public void onDisable() {
        descRef = false;
        depthVal.clear();
        activeVal.clear();
        this.radiusVal.clear();
        this.factorVal.clear();
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        block7: {
            block6: {
                if (AntiBotModule.mc.field_1687 == null) break block6;
                if (AntiBotModule.mc.field_1724 != null) break block7;
            }
            return;
        }
        this.timerVal();
        String string = this.countVal.tertiaryVal();
        if (!string.equals("ReallyWorld") && !this.radiusVal.isEmpty()) {
            AntiBotModule.mc.field_1687.method_18456().stream().filter(class_7422 -> this.radiusVal.contains(class_7422.method_5667())).forEach(this::tertiaryVal);
        }
        if (string.equals("Matrix") || string.equals("ALL")) {
            this.blockRef();
        }
        if (string.equals("ReallyWorld") || string.equals("ALL")) {
            this.holderVal();
        }
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        class_2596<?> class_25962 = uvUUuvnunU2.marginVal();
        if (class_25962 instanceof class_2703) {
            class_2703 class_27032 = (class_2703)class_25962;
            this.primaryVal(class_27032);
        } else {
            class_25962 = uvUUuvnunU2.marginVal();
            if (class_25962 instanceof class_7828) {
                class_7828 class_78282 = (class_7828)class_25962;
                this.primaryVal(class_78282);
            }
        }
    }

    private void primaryVal(class_2703 class_27032) {
        if (!class_27032.method_46327().contains(class_2703.class_5893.field_29136)) {
            return;
        }
        class_27032.method_46329().forEach(class_27052 -> {
            GameProfile gameProfile = class_27052.comp_1107();
            if (gameProfile == null) {
                return;
            }
            if (this.primaryVal((class_2703.class_2705)class_27052, gameProfile)) {
                this.primaryVal(gameProfile.getId());
                return;
            }
            UUID uUID = gameProfile.getId();
            if (this.primaryVal(gameProfile)) {
                depthVal.add(uUID);
            } else {
                this.radiusVal.add(uUID);
            }
        });
    }

    private void primaryVal(class_7828 class_78282) {
        Iterator iterator = class_78282.comp_1105().iterator();
        while (iterator.hasNext()) {
            UUID uUID = (UUID)iterator.next();
            this.radiusVal.remove(uUID);
            depthVal.remove(uUID);
            activeVal.remove(uUID);
            this.factorVal.remove(uUID);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(class_2703.class_2705 class_27052, GameProfile gameProfile) {
        if (AntiBotModule.mc.field_1724 == null) {
            return false;
        }
        if (gameProfile.getId().equals(AntiBotModule.mc.field_1724.method_5667())) return true;
        if (class_27052.comp_1109() <= 0) return false;
        return true;
    }

    private boolean primaryVal(GameProfile gameProfile) {
        if (AntiBotModule.mc.field_1687 == null) {
            return false;
        }
        return AntiBotModule.mc.field_1687.method_18456().stream().anyMatch(class_7422 -> class_7422.method_7334().getName().equals(gameProfile.getName()) && !class_7422.method_5667().equals(gameProfile.getId()));
    }

    private List<class_1799> secondaryVal(class_1657 class_16572) {
        ArrayList<class_1799> arrayList = new ArrayList<class_1799>(4);
        arrayList.add(class_16572.method_6118(class_1304.field_6169));
        arrayList.add(class_16572.method_6118(class_1304.field_6174));
        arrayList.add(class_16572.method_6118(class_1304.field_6172));
        arrayList.add(class_16572.method_6118(class_1304.field_6166));
        return arrayList;
    }

    private void tertiaryVal(class_1657 class_16572) {
        if (AntiBotModule.marginVal(class_16572)) {
            this.radiusVal.remove(class_16572.method_5667());
            this.factorVal.remove(class_16572.method_5667());
            return;
        }
        List<class_1799> list = this.secondaryVal(class_16572);
        List<class_1799> list2 = this.factorVal.get(class_16572.method_5667());
        if (this.primaryVal(list) || this.primaryVal(list, list2)) {
            depthVal.add(class_16572.method_5667());
            this.radiusVal.remove(class_16572.method_5667());
        } else {
            this.factorVal.put(class_16572.method_5667(), list);
        }
    }

    private void blockRef() {
        if (AntiBotModule.mc.field_1687 == null || AntiBotModule.mc.field_1724 == null) {
            return;
        }
        Iterator<UUID> iterator = this.radiusVal.iterator();
        while (iterator.hasNext()) {
            block8: {
                UUID uUID2;
                block9: {
                    boolean bl;
                    uUID2 = iterator.next();
                    class_1657 class_16572 = AntiBotModule.mc.field_1687.method_18470(uUID2);
                    if (class_16572 == null) break block8;
                    if (AntiBotModule.marginVal(class_16572)) {
                        continue;
                    }
                    String string = class_16572.method_5477().getString();
                    boolean bl2 = string.startsWith("CIT-") && !string.contains("NPC") && !string.contains("[ZNPC]");
                    int n = 0;
                    for (class_1799 class_17992 : this.secondaryVal(class_16572)) {
                        if (class_17992 == null) continue;
                        if (class_17992.method_7960()) continue;
                        ++n;
                    }
                    boolean bl3 = n == 4;
                    boolean bl4 = bl = !class_16572.method_5667().equals(UUID.nameUUIDFromBytes(("OfflinePlayer:" + string).getBytes()));
                    if (bl3 || bl2) break block9;
                    if (!bl) break block8;
                }
                depthVal.add(uUID2);
            }
            iterator.remove();
        }
        if (AntiBotModule.mc.field_1724.field_6012 % 100 == 0) {
            depthVal.removeIf(uUID -> AntiBotModule.mc.field_1687.method_18470(uUID) == null);
        }
    }

    private void holderVal() {
        if (AntiBotModule.mc.field_1687 == null || AntiBotModule.mc.field_1724 == null) {
            return;
        }
        for (class_1657 class_16572 : AntiBotModule.mc.field_1687.method_18456()) {
            boolean bl;
            if (class_16572 == AntiBotModule.mc.field_1724 || AntiBotModule.marginVal(class_16572)) continue;
            String string = class_16572.method_5477().getString();
            boolean bl2 = !class_16572.method_5667().equals(UUID.nameUUIDFromBytes(("OfflinePlayer:" + string).getBytes()));
            boolean bl3 = bl = string.contains("NPC") || string.startsWith("[ZNPC]");
            if (!bl2 || bl) continue;
            depthVal.add(class_16572.method_5667());
        }
    }

    private boolean primaryVal(List<class_1799> list) {
        for (class_1799 class_17992 : list) {
            if (class_17992 != null) {
                if (!class_17992.method_7960() && !class_17992.method_7942()) continue;
            }
            return false;
        }
        return true;
    }

    private boolean primaryVal(List<class_1799> list, List<class_1799> list2) {
        if (list2 == null) {
            return false;
        }
        for (int i = 0; i < 4; ++i) {
            class_1799 class_17992 = list.get(i);
            class_1799 class_17993 = list2.get(i);
            if (!(class_17992 != null && class_17993 != null ? class_17992.method_7909() != class_17993.method_7909() : class_17992 != class_17993)) continue;
            return true;
        }
        return false;
    }

    private void timerVal() {
        if (mc.method_1562() == null) {
            return;
        }
        for (class_640 class_6402 : mc.method_1562().method_2880()) {
            if (class_6402 == null || class_6402.method_2966() == null || !this.primaryVal(class_6402.method_2966().getId(), class_6402.method_2959())) continue;
            this.primaryVal(class_6402.method_2966().getId());
        }
        activeVal.removeIf(uUID -> {
            if (mc.method_1562().method_2871(uUID) != null) return false;
            if (AntiBotModule.mc.field_1687 == null) return true;
            if (AntiBotModule.mc.field_1687.method_18470(uUID) != null) return false;
            return true;
        });
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(UUID uUID, int n) {
        if (AntiBotModule.mc.field_1724 != null) {
            if (uUID.equals(AntiBotModule.mc.field_1724.method_5667())) return true;
        }
        if (n <= 0) return false;
        return true;
    }

    private void primaryVal(UUID uUID) {
        AntiBotModule.secondaryVal(uUID);
        this.radiusVal.remove(uUID);
        this.factorVal.remove(uUID);
    }

    private static void secondaryVal(UUID uUID) {
        if (uUID == null) {
            return;
        }
        activeVal.add(uUID);
        depthVal.remove(uUID);
    }

    private static boolean marginVal(class_1657 class_16572) {
        if (class_16572 == null) {
            return false;
        }
        UUID uUID = class_16572.method_5667();
        if (activeVal.contains(uUID)) {
            return true;
        }
        if (AntiBotModule.mc.field_1724 != null && uUID.equals(AntiBotModule.mc.field_1724.method_5667())) {
            AntiBotModule.secondaryVal(uUID);
            return true;
        }
        if (mc.method_1562() == null) {
            return false;
        }
        class_640 class_6402 = mc.method_1562().method_2871(uUID);
        if (class_6402 != null && class_6402.method_2959() > 0) {
            AntiBotModule.secondaryVal(uUID);
            return true;
        }
        return false;
    }

    public static boolean primaryVal(class_1657 class_16572) {
        if (!descRef) {
            return false;
        }
        if (AntiBotModule.marginVal(class_16572)) {
            return false;
        }
        if (depthVal.contains(class_16572.method_5667())) {
            return true;
        }
        String string = class_16572.method_5477().getString();
        if (string.startsWith("CIT-") && !string.contains("NPC")) {
            if (!string.startsWith("[ZNPC]")) {
                return true;
            }
        }
        if (class_16572.method_5767() && !string.contains("NPC") && !string.startsWith("[ZNPC]")) {
            return !class_16572.method_5667().equals(UUID.nameUUIDFromBytes(("OfflinePlayer:" + string).getBytes()));
        }
        return false;
    }
}

