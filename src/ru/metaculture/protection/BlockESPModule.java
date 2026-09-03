/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.systems.RenderSystem
 *  net.minecraft.class_1923
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_243
 *  net.minecraft.class_2591
 *  net.minecraft.class_2596
 *  net.minecraft.class_2622
 *  net.minecraft.class_2626
 *  net.minecraft.class_2637
 *  net.minecraft.class_2666
 *  net.minecraft.class_2672
 *  net.minecraft.class_2680
 *  net.minecraft.class_2846
 *  net.minecraft.class_2846$class_2847
 *  net.minecraft.class_2885
 *  net.minecraft.class_3532
 *  net.minecraft.class_638
 *  net.minecraft.class_746
 *  org.joml.Matrix4f
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import net.minecraft.class_1923;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_243;
import net.minecraft.class_2591;
import net.minecraft.class_2596;
import net.minecraft.class_2622;
import net.minecraft.class_2626;
import net.minecraft.class_2637;
import net.minecraft.class_2666;
import net.minecraft.class_2672;
import net.minecraft.class_2680;
import net.minecraft.class_2846;
import net.minecraft.class_2885;
import net.minecraft.class_3532;
import net.minecraft.class_638;
import net.minecraft.class_746;
import org.joml.Matrix4f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.BlockEspRenderer;
import ru.metaculture.protection.NnUuunvvvUun;
import ru.metaculture.protection.AnimationClock;
import ru.metaculture.protection.UvNVnUVVnNN;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.BlockEspGeometryBuilder;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.WorldJoinEvent;
import ru.metaculture.protection.VertexBufferPool;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.PostClientTickEvent;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.PacketEvent;
import ru.metaculture.protection.RegistryIdUtil;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="BlockESP", tertiaryVal=ModuleCategory.Visuals, secondaryVal="Highlighting of specific blocks")
public class BlockESPModule
extends Module {
    public final ModeSetting countVal = new ModeSetting("Mode", "Normal", "Normal", "Performance");
    public final FloatSetting depthVal = new FloatSetting("Radius", 48.0f, 16.0f, 128.0f, 8.0f, false).primaryVal(() -> !this.countVal.secondaryVal("Performance"));
    public final BoolSetting descRef = new BoolSetting("Through walls", true);
    public final FloatSetting activeVal = new FloatSetting("Box limit", 512.0f, 128.0f, 2048.0f, 64.0f, false).primaryVal(() -> !this.countVal.secondaryVal("Performance"));
    public static SettingGroup radiusVal;
    public static final Map<class_2591<?>, Integer> factorVal;
    private static final int sourceVal = 16384;
    private static final double extraRef = 6.0;
    private static final int phaseVal = 2;
    private static final int limitRef = 14;
    private static final int paramRef = 90;
    private static final String[] groupVal;
    private final NnUuunvvvUun layerVal = new NnUuunvvvUun();
    private final BlockEspGeometryBuilder slotVal = new BlockEspGeometryBuilder();
    private final BlockEspRenderer themeVal = new BlockEspRenderer();
    private final int[] stageVal = new int[22];
    private final int[] widthRef = new int[22];
    private final long[] trackVal = new long[4096];
    private int modeRef;
    private final BiConsumer<class_2338, class_2680> angleVal = (class_23382, class_26802) -> {
        if (this.modeRef < this.trackVal.length) {
            this.trackVal[this.modeRef++] = class_2338.method_10064((int)class_23382.method_10263(), (int)class_23382.method_10264(), (int)class_23382.method_10260());
        }
    };
    private long[] heightRef;
    private byte[] levelVal;
    private int[] UuNnnVnuNNV;
    private double depthRef;
    private double speedRef;
    private double countRef;
    private int entryVal;
    private int guardVal;
    private int VUuuVUnun;
    private int vVVuuVVv;
    private int VuunNUUUvu = -1;
    private int NNUUNUuVNNVn = -1;
    private int VvVvnNUnvuvV = -1;
    private float tokenVal = Float.MAX_VALUE;
    private boolean NUVvUUVuVNVv;

    public BlockESPModule() {
        this.addSettings(this.countVal, this.depthVal, this.activeVal, this.descRef, radiusVal);
        factorVal.clear();
        factorVal.put(class_2591.field_11914, new Color(255, 194, 84).getRGB());
        factorVal.put(class_2591.field_11891, new Color(143, 109, 62).getRGB());
        factorVal.put(class_2591.field_11901, new Color(153, 49, 238).getRGB());
        factorVal.put(class_2591.field_11889, 0xFFFFFF);
        factorVal.put(class_2591.field_16411, new Color(250, 225, 62).getRGB());
        factorVal.put(class_2591.field_11888, new Color(62, 137, 250).getRGB());
        factorVal.put(class_2591.field_11887, new Color(27, 64, 250).getRGB());
        factorVal.put(class_2591.field_11899, new Color(0, 23, 255).getRGB());
        factorVal.put(class_2591.field_11903, new Color(115, 115, 115).getRGB());
        factorVal.put(class_2591.field_11896, new Color(246, 123, 123).getRGB());
        factorVal.put(class_2591.field_42781, new Color(185, 122, 87).getRGB());
        factorVal.put(class_2591.field_42780, new Color(227, 203, 153).getRGB());
        this.timerVal();
        UvNVnUVVnNN.primaryVal();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.layerVal.primaryVal();
        this.slotVal.primaryVal();
        this.VuunNUUUvu = -1;
        this.NNUUNUuVNNVn = -1;
        this.VvVvnNUnvuvV = -1;
        this.VUuuVUnun = 0;
        this.vVVuuVVv = 0;
        this.NUVvUUVuVNVv = true;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.slotVal.secondaryVal();
        this.layerVal.primaryVal();
        this.NUVvUUVuVNVv = false;
        this.bufferVal();
    }

    @Subscribe
    public void primaryVal(WorldJoinEvent coOCCcooOcOO2) {
        this.layerVal.primaryVal();
        this.slotVal.secondaryVal();
        BlockEspGeometryBuilder.primaryVal(this.slotVal.weightVal());
        this.themeVal.primaryVal();
        this.slotVal.primaryVal();
        this.VUuuVUnun = 0;
        this.vVVuuVVv = 0;
        this.NUVvUUVuVNVv = true;
    }

    @Subscribe
    public void primaryVal(PacketEvent uvUUuvnunU2) {
        class_2596<?> class_25962 = uvUUuvnunU2.marginVal();
        if (uvUUuvnunU2.tertiaryVal()) {
            if (class_25962 instanceof class_2846) {
                class_2846 class_28462 = (class_2846)class_25962;
                class_2846.class_2847 class_28472 = class_28462.method_12363();
                if (class_28472 == class_2846.class_2847.field_12968 || class_28472 == class_2846.class_2847.field_12973) {
                    class_2338 class_23382 = class_28462.method_12362();
                    this.layerVal.primaryVal(class_23382.method_10263(), class_23382.method_10264(), class_23382.method_10260());
                }
            } else if (class_25962 instanceof class_2885) {
                class_2885 class_28852 = (class_2885)class_25962;
                class_2338 class_23383 = class_28852.method_12543().method_17777();
                class_2350 class_23502 = class_28852.method_12543().method_17780();
                this.layerVal.primaryVal(class_23383.method_10263(), class_23383.method_10264(), class_23383.method_10260());
                this.layerVal.primaryVal(class_23383.method_10263() + class_23502.method_10148(), class_23383.method_10264() + class_23502.method_10164(), class_23383.method_10260() + class_23502.method_10165());
            }
            return;
        }
        if (class_25962 instanceof class_2626) {
            class_2626 class_26262 = (class_2626)class_25962;
            class_2338 class_23384 = class_26262.method_11309();
            this.layerVal.primaryVal(class_23384.method_10263(), class_23384.method_10264(), class_23384.method_10260());
        } else if (class_25962 instanceof class_2622) {
            class_2622 class_26222 = (class_2622)class_25962;
            class_2338 class_23385 = class_26222.method_11293();
            this.layerVal.primaryVal(class_23385.method_10263(), class_23385.method_10264(), class_23385.method_10260());
        } else if (class_25962 instanceof class_2637) {
            class_2637 class_26372 = (class_2637)class_25962;
            this.modeRef = 0;
            class_26372.method_30621(this.angleVal);
            this.layerVal.primaryVal(this.trackVal, this.modeRef);
        } else if (class_25962 instanceof class_2672) {
            class_2672 class_26722 = (class_2672)class_25962;
            this.layerVal.primaryVal(class_26722.method_11523(), class_26722.method_11524());
        } else if (class_25962 instanceof class_2666) {
            class_2666 class_26662 = (class_2666)class_25962;
            class_1923 class_19232 = class_26662.comp_1726();
            this.layerVal.secondaryVal(class_19232.field_9181, class_19232.field_9180);
        }
    }

    @Subscribe
    public void primaryVal(PostClientTickEvent coreH) {
        int n;
        class_746 class_7462;
        class_638 class_6382;
        block11: {
            int n2;
            int n3;
            int n4;
            block10: {
                class_6382 = BlockESPModule.mc.field_1687;
                class_7462 = BlockESPModule.mc.field_1724;
                if (class_6382 == null || class_7462 == null) {
                    return;
                }
                boolean bl = this.countVal.secondaryVal("Performance");
                n = BlockESPModule.mc.field_1690.method_38521();
                n4 = bl ? Math.min(n, 6) : n;
                n3 = bl ? class_3532.method_15340((int)((int)this.activeVal.tertiaryVal()), (int)1, (int)4096) : 16384;
                n2 = this.anchorVal();
                if (this.weightRef() || n2 != this.VuunNUUUvu) break block10;
                if (n3 == this.NNUUNUuVNNVn && n4 == this.VvVvnNUnvuvV) break block11;
            }
            this.VuunNUUUvu = n2;
            this.NNUUNUuVNNVn = n3;
            this.VvVvnNUnvuvV = n4;
            this.NUVvUUVuVNVv = true;
        }
        this.layerVal.primaryVal(n + 1);
        class_1923 class_19232 = class_7462.method_31476();
        this.layerVal.primaryVal(class_6382, class_19232.field_9181, class_19232.field_9180);
        ++this.guardVal;
        if (this.layerVal.tertiaryVal() || this.slotVal.marginVal()) {
            this.NUVvUUVuVNVv = true;
        }
        if (this.VUuuVUnun != 0 && this.guardVal - this.VUuuVUnun >= 0) {
            this.VUuuVUnun = 0;
            this.NUVvUUVuVNVv = true;
        }
        if (this.vVVuuVVv != 0 && this.guardVal - this.vVVuuVVv >= 0) {
            this.vVVuuVVv = 0;
            this.NUVvUUVuVNVv = true;
        }
        if (this.layerVal.marginVal() && this.primaryVal(class_7462) > 6.0) {
            this.NUVvUUVuVNVv = true;
        }
        if (this.NUVvUUVuVNVv && !this.slotVal.tertiaryVal()) {
            if (this.guardVal - this.entryVal >= 2) {
                this.secondaryVal(class_7462);
            }
        }
    }

    private double primaryVal(class_746 class_7462) {
        double d = class_7462.method_23317() - this.depthRef;
        double d2 = class_7462.method_23318() - this.speedRef;
        double d3 = class_7462.method_23321() - this.countRef;
        return Math.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        block5: {
            block4: {
                if (BlockESPModule.mc.field_1687 == null || BlockESPModule.mc.field_1724 == null) break block4;
                if (VertexBufferPool.primaryVal(mc)) break block5;
            }
            return;
        }
        this.themeVal.primaryVal(this.slotVal.weightVal());
        if (!this.themeVal.weightVal()) {
            return;
        }
        class_243 class_2432 = BlockESPModule.mc.field_1773.method_19418().method_19326();
        Matrix4f matrix4f = vvuuvuVVvvn.tertiaryVal().method_23760().method_23761();
        float f = Math.min(this.blockRef(), this.tokenVal);
        float f2 = f * 0.88f;
        this.themeVal.primaryVal(matrix4f, (float)(class_2432.field_1352 - (double)this.themeVal.secondaryVal()), (float)(class_2432.field_1351 - (double)this.themeVal.tertiaryVal()), (float)(class_2432.field_1350 - (double)this.themeVal.marginVal()), BlockESPModule.primaryVal(class_2432.field_1352), BlockESPModule.primaryVal(class_2432.field_1351), BlockESPModule.primaryVal(class_2432.field_1350), AnimationClock.secondaryVal(), AnimationClock.tertiaryVal(), f2, f, 1.0f, this.descRef.tertiaryVal());
    }

    private static float primaryVal(double d) {
        return (float)(d - Math.floor(d * 0.00390625) * 256.0);
    }

    private void secondaryVal(class_746 class_7462) {
        block7: {
            block6: {
                if (this.heightRef == null) break block6;
                if (this.heightRef.length >= this.NNUUNUuVNNVn) break block7;
            }
            this.heightRef = new long[this.NNUUNUuVNNVn];
            this.levelVal = new byte[this.NNUUNUuVNNVn];
            this.UuNnnVnuNNV = new int[this.NNUUNUuVNNVn];
        }
        this.depthRef = class_7462.method_23317();
        this.speedRef = class_7462.method_23320();
        this.countRef = class_7462.method_23321();
        this.entryVal = this.guardVal;
        int n = this.layerVal.primaryVal(this.heightRef, this.levelVal, this.UuNnnVnuNNV, this.NNUUNUuVNNVn, this.VuunNUUUvu, this.VvVvnNUnvuvV, this.depthRef, this.speedRef, this.countRef, this.holderVal());
        this.tokenVal = n >= this.NNUUNUuVNNVn ? (float)this.layerVal.paramVal() : Float.MAX_VALUE;
        class_2338 class_23382 = class_7462.method_24515();
        int n2 = class_23382.method_10263() & 0xFFFFFFF0;
        int n3 = class_23382.method_10264() & 0xFFFFFFF0;
        int n4 = class_23382.method_10260() & 0xFFFFFFF0;
        if (this.slotVal.primaryVal(this.heightRef, this.levelVal, this.UuNnnVnuNNV, n, (int[])this.stageVal.clone(), n2, n3, n4)) {
            this.NUVvUUVuVNVv = false;
            if (this.layerVal.extraVal() > 0) {
                this.VUuuVUnun = this.guardVal + 14;
            }
            if (this.layerVal.weightVal()) {
                this.vVVuuVVv = this.guardVal + 90;
            }
        }
    }

    private float blockRef() {
        if (this.countVal.secondaryVal("Performance")) {
            return this.depthVal.tertiaryVal();
        }
        return (float)BlockESPModule.mc.field_1690.method_38521() * 16.0f * 1.5f + 48.0f;
    }

    private double holderVal() {
        return (double)this.blockRef() + 8.0;
    }

    private void timerVal() {
        block0: for (int i = 0; i < 22; ++i) {
            this.widthRef[i] = -1;
            for (int j = 0; j < BlockESPModule.radiusVal.marginVal.size(); ++j) {
                if (!BlockESPModule.radiusVal.marginVal.get((int)j).primaryVal.equals(groupVal[i])) continue;
                this.widthRef[i] = j;
                continue block0;
            }
        }
    }

    private int anchorVal() {
        int n = 0;
        for (int i = 0; i < 22; ++i) {
            int n2 = this.widthRef[i];
            if (n2 < 0 || !radiusVal.primaryVal(n2)) continue;
            n |= 1 << i;
        }
        return n;
    }

    private boolean weightRef() {
        boolean bl = false;
        for (int i = 0; i < 22; ++i) {
            int n;
            class_2591<?> class_25912 = RegistryIdUtil.primaryVal(i);
            if (class_25912 != null) {
                Integer n2 = factorVal.get(class_25912);
                n = n2 == null ? 0xFFFFFF : n2 & 0xFFFFFF;
            } else {
                n = RegistryIdUtil.secondaryVal(i) & 0xFFFFFF;
            }
            if (this.stageVal[i] == n) continue;
            this.stageVal[i] = n;
            bl = true;
        }
        return bl;
    }

    private void bufferVal() {
        if (RenderSystem.isOnRenderThread()) {
            this.themeVal.paramVal();
        } else {
            mc.execute(this.themeVal::paramVal);
        }
    }

    static {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[22];
        vvNnnUNnVvnArray[0] = new BoolSetting("Chest", true);
        vvNnnUNnVvnArray[1] = new BoolSetting("Trap Chest", true);
        vvNnnUNnVvnArray[2] = new BoolSetting("Ender Chest", true);
        vvNnnUNnVvnArray[3] = new BoolSetting("Spawner", true);
        vvNnnUNnVvnArray[4] = new BoolSetting("Barrel", true);
        vvNnnUNnVvnArray[5] = new BoolSetting("Hopper", true);
        vvNnnUNnVvnArray[6] = new BoolSetting("Dispenser", true);
        vvNnnUNnVvnArray[7] = new BoolSetting("Dropper", true);
        vvNnnUNnVvnArray[8] = new BoolSetting("Furnace", true);
        vvNnnUNnVvnArray[9] = new BoolSetting("Shulker", true);
        vvNnnUNnVvnArray[10] = new BoolSetting("Vase", true);
        vvNnnUNnVvnArray[11] = new BoolSetting("Suspicious Sand", true);
        vvNnnUNnVvnArray[12] = new BoolSetting("Coal Ore", true);
        vvNnnUNnVvnArray[13] = new BoolSetting("Iron Ore", true);
        vvNnnUNnVvnArray[14] = new BoolSetting("Gold Ore", true);
        vvNnnUNnVvnArray[15] = new BoolSetting("Copper Ore", true);
        vvNnnUNnVvnArray[16] = new BoolSetting("Lapis Ore", true);
        vvNnnUNnVvnArray[17] = new BoolSetting("Redstone Ore", true);
        vvNnnUNnVvnArray[18] = new BoolSetting("Diamond Ore", true);
        vvNnnUNnVvnArray[19] = new BoolSetting("Emerald Ore", true);
        vvNnnUNnVvnArray[20] = new BoolSetting("Quartz Ore", true);
        vvNnnUNnVvnArray[21] = new BoolSetting("Ancient Debris", true);
        radiusVal = new SettingGroup("Blocks", vvNnnUNnVvnArray);
        factorVal = new HashMap();
        String[] stringArray = new String[22];
        stringArray[0] = "Chest";
        stringArray[1] = "Trap Chest";
        stringArray[2] = "Ender Chest";
        stringArray[3] = "Spawner";
        stringArray[4] = "Barrel";
        stringArray[5] = "Hopper";
        stringArray[6] = "Dispenser";
        stringArray[7] = "Dropper";
        stringArray[8] = "Furnace";
        stringArray[9] = "Shulker";
        stringArray[10] = "Vase";
        stringArray[11] = "Suspicious Sand";
        stringArray[12] = "Coal Ore";
        stringArray[13] = "Iron Ore";
        stringArray[14] = "Gold Ore";
        stringArray[15] = "Copper Ore";
        stringArray[16] = "Lapis Ore";
        stringArray[17] = "Redstone Ore";
        stringArray[18] = "Diamond Ore";
        stringArray[19] = "Emerald Ore";
        stringArray[20] = "Quartz Ore";
        stringArray[21] = "Ancient Debris";
        groupVal = stringArray;
    }
}

