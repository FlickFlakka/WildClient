/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.opengl.GlStateManager
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.platform.DestFactor
 *  com.mojang.blaze3d.platform.SourceFactor
 *  com.mojang.blaze3d.textures.GpuTexture
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_1044
 *  net.minecraft.class_1060
 *  net.minecraft.class_10799
 *  net.minecraft.class_10868
 *  net.minecraft.class_1297
 *  net.minecraft.class_1657
 *  net.minecraft.class_1671
 *  net.minecraft.class_1676
 *  net.minecraft.class_1682
 *  net.minecraft.class_1753
 *  net.minecraft.class_1764
 *  net.minecraft.class_1771
 *  net.minecraft.class_1776
 *  net.minecraft.class_1779
 *  net.minecraft.class_1792
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1823
 *  net.minecraft.class_1835
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_1935
 *  net.minecraft.class_2338
 *  net.minecraft.class_2350
 *  net.minecraft.class_2350$class_2351
 *  net.minecraft.class_238
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_4184
 *  net.minecraft.class_4537
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_640
 *  net.minecraft.class_7923
 *  org.joml.Matrix4f
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.platform.DestFactor;
import com.mojang.blaze3d.platform.SourceFactor;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_10799;
import net.minecraft.class_10868;
import net.minecraft.class_1297;
import net.minecraft.class_1657;
import net.minecraft.class_1671;
import net.minecraft.class_1676;
import net.minecraft.class_1682;
import net.minecraft.class_1753;
import net.minecraft.class_1764;
import net.minecraft.class_1771;
import net.minecraft.class_1776;
import net.minecraft.class_1779;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1823;
import net.minecraft.class_1835;
import net.minecraft.class_1921;
import net.minecraft.class_1935;
import net.minecraft.class_2338;
import net.minecraft.class_2350;
import net.minecraft.class_238;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_4184;
import net.minecraft.class_4537;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_640;
import net.minecraft.class_7923;
import org.joml.Matrix4f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.RenderHudEvent;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ClickPearlModule;
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.VertexBufferPool;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.ThemeSettings;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="Predictions", secondaryVal="Show flight trajectory prediction", tertiaryVal=ModuleCategory.Visuals)
public class PredictionsModule
extends Module {
    private static final int countVal = 240;
    private static final int depthVal = 96;
    private static final int descRef = 0x200000;
    private static final int activeVal = 72;
    private static final int radiusVal = 10;
    private static final int factorVal = 6;
    private static final int sourceVal = 8;
    private static final int extraRef = 6;
    private static final long phaseVal;
    private static final float limitRef = 1.5f;
    private static final float paramRef = 0.5f;
    private static final float groupVal = 0.7f;
    private static final float layerVal = -20.0f;
    private static final double slotVal = 0.99;
    private static final double themeVal = 0.8;
    private static final float stageVal = 0.1f;
    private static final float widthRef = 0.1f;
    private static final float trackVal = 0.1f;
    private static final double modeRef = 64.0;
    private static final double angleVal = 16.0;
    private static final double[] heightRef;
    private static final double[] levelVal;
    private static final float[] UuNnnVnuNNV;
    private static final double[] depthRef;
    private static final double[] speedRef;
    private static final float[] countRef;
    private static final float[] entryVal;
    private static final class_2960 guardVal;
    private static final BlendFunction VUuuVUnun;
    private static final RenderPipeline vVVuuVVv;
    private static final RenderPipeline VuunNUUUvu;
    private static final RenderPipeline NNUUNUuVNNVn;
    private static final RenderPipeline VvVvnNUnvuvV;
    private static final class_1921 tokenVal;
    private static final class_1921 NUVvUUVuVNVv;
    private static final class_1921 nodeB;
    private static final class_1921 UNvvunVVn;
    private final BoolSetting UnvuVuVnNuvu = new BoolSetting("ThroughWalls", true);
    private final BoolSetting UvNNVUVNVuvV = new BoolSetting("AimPreview", true);
    private final BoolSetting NnunUUnU = new BoolSetting("ShowOwner", false);
    private final ThemeSettings nvuVvuNnNUnv = new ThemeSettings(){};
    private final List<cursorVal> nodeF = new ArrayList<cursorVal>();
    private final Map<String, cursorVal> nodeH = new HashMap<String, cursorVal>();
    private class_1799 OCOocoOoOO;
    private final List<cursorVal> o0Ooc0COOoc = new ArrayList<cursorVal>();
    private long twigB = Long.MIN_VALUE;
    private final double[] UnUUVuVunvVu = new double[11];
    private final double[] twigC = new double[11];

    public PredictionsModule() {
        Setting[] nvUuvVvuuNArray = new Setting[3];
        nvUuvVvuuNArray[0] = this.UnvuVuVnNuvu;
        nvUuvVvuuNArray[1] = this.UvNNVUVNVuvV;
        nvUuvVvuuNArray[2] = this.NnunUUnU;
        this.addSettings(nvUuvVvuuNArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        int n;
        boolean bl;
        boolean bl2;
        boolean bl3;
        class_4588 class_45882;
        block19: {
            block18: {
                if (PredictionsModule.mc.field_1687 == null || PredictionsModule.mc.field_1724 == null) {
                    this.blockRef();
                    return;
                }
                if (PredictionsModule.mc.field_1690 == null) break block18;
                if (PredictionsModule.mc.field_1690.method_31044() != null && PredictionsModule.mc.field_1690.method_31044().method_31034()) break block19;
            }
            this.blockRef();
            return;
        }
        this.primaryVal(vvuuvuVVvvn.marginVal());
        if (this.nodeF.isEmpty()) {
            return;
        }
        class_4587 class_45872 = vvuuvuVVvvn.tertiaryVal();
        Matrix4f matrix4f = class_45872.method_23760().method_23761();
        class_243 class_2432 = PredictionsModule.mc.field_1773.method_19418().method_19326();
        class_1921 class_19212 = this.UnvuVuVnNuvu.tertiaryVal() ? NUVvUUVuVNVv : tokenVal;
        class_1921 class_19213 = this.UnvuVuVnNuvu.tertiaryVal() ? UNvvunVVn : nodeB;
        int n2 = ColorUtil.weightVal(ColorUtil.primaryVal(), 235);
        class_4597.class_4598 class_45982 = VertexBufferPool.primaryVal();
        try {
            class_45882 = class_45982.getBuffer(class_19212);
            for (cursorVal panelVal : this.nodeF) {
                bl3 = panelVal.hitEntity() != null;
                bl2 = panelVal.blockHit() != null && panelVal.blockHit().method_17783() != class_239.class_240.field_1333;
                bl = bl3 || bl2;
                n = bl3 ? -51112 : n2;
                this.primaryVal(class_45882, matrix4f, class_2432, panelVal.path(), n, bl);
            }
        }
        finally {
            VertexBufferPool.secondaryVal();
        }
        class_45982 = VertexBufferPool.primaryVal();
        try {
            class_45882 = class_45982.getBuffer(class_19213);
            for (cursorVal panelVal : this.nodeF) {
                class_238 class_2382;
                bl3 = panelVal.hitEntity() != null;
                bl2 = panelVal.blockHit() != null && panelVal.blockHit().method_17783() != class_239.class_240.field_1333;
                bl = bl3 || bl2;
                n = bl3 ? -51112 : n2;
                int n3 = n >> 16 & 0xFF;
                int n4 = n >> 8 & 0xFF;
                int n5 = n & 0xFF;
                this.secondaryVal(class_45882, matrix4f, class_2432, panelVal.path(), n, bl);
                if (bl3) {
                    class_2382 = panelVal.targetBox() != null ? panelVal.targetBox() : panelVal.hitEntity().method_5829();
                    this.primaryVal(class_45882, matrix4f, class_2382.field_1323 - class_2432.field_1352, class_2382.field_1322 - class_2432.field_1351, class_2382.field_1321 - class_2432.field_1350, class_2382.field_1320 - class_2432.field_1352, class_2382.field_1325 - class_2432.field_1351, class_2382.field_1324 - class_2432.field_1350, n3, n4, n5, 230);
                    this.primaryVal(class_45882, matrix4f, class_2432, class_2382, n3, n4, n5);
                    continue;
                }
                if (!bl2) continue;
                class_243 blockRenderPos = panelVal.blockRenderPos();
                if (blockRenderPos != null) {
                    this.primaryVal(class_45882, matrix4f, blockRenderPos.field_1352 - class_2432.field_1352, blockRenderPos.field_1351 - class_2432.field_1351, blockRenderPos.field_1350 - class_2432.field_1350, blockRenderPos.field_1352 + 1.0 - class_2432.field_1352, blockRenderPos.field_1351 + 1.0 - class_2432.field_1351, blockRenderPos.field_1350 + 1.0 - class_2432.field_1350, n3, n4, n5);
                }
                this.primaryVal(class_45882, matrix4f, class_2432, panelVal.blockHit(), panelVal.landingPos(), n);
            }
        }
        finally {
            VertexBufferPool.secondaryVal();
        }
    }

    @Subscribe
    public void primaryVal(RenderHudEvent partD) {
        if (PredictionsModule.mc.field_1687 == null || PredictionsModule.mc.field_1724 == null) {
            return;
        }
        if (PredictionsModule.mc.field_1690 == null || PredictionsModule.mc.field_1690.method_31044() == null || !PredictionsModule.mc.field_1690.method_31044().method_31034()) {
            return;
        }
        if (this.nodeF.isEmpty()) {
            return;
        }
        Renderer2D heightVal = partD.marginVal();
        heightVal.primaryVal(23.0f);
        for (cursorVal panelVal : this.nodeF) {
            class_243 class_2432;
            if (panelVal.isPreAim() || (class_2432 = VnNnNnvuvn.primaryVal(panelVal.landingPos())) == null || class_2432.field_1350 < 0.0) continue;
            if (class_2432.field_1350 > 1.0) continue;
            float f = (float)class_2432.field_1352;
            float f2 = (float)class_2432.field_1351;
            float f3 = 1.0f;
            this.primaryVal(heightVal, f, f2, f3, panelVal);
            if (!this.NnunUUnU.tertiaryVal() || !this.secondaryVal(panelVal)) continue;
            this.secondaryVal(heightVal, f, f2 - 31.0f * f3, f3, panelVal);
        }
    }

    private void primaryVal(float f) {
        long l;
        cursorVal panelVal;
        boolean bl;
        class_1799 class_17992;
        ArrayList<cursorVal> arrayList;
        block13: {
            block12: {
                this.nodeF.clear();
                if (PredictionsModule.mc.field_1687 == null || PredictionsModule.mc.field_1724 == null) {
                    this.nodeH.clear();
                    this.o0Ooc0COOoc.clear();
                    this.twigB = Long.MIN_VALUE;
                    return;
                }
                arrayList = new ArrayList<cursorVal>();
                class_17992 = PredictionsModule.mc.field_1724.method_6047();
                bl = false;
                if (class_17992.method_7960()) break block12;
                if (this.primaryVal(class_17992.method_7909())) break block13;
            }
            class_17992 = PredictionsModule.mc.field_1724.method_6079();
            bl = true;
        }
        if (this.UvNNVUVNVuvV.tertiaryVal()) {
            if (!class_17992.method_7960()) {
                if (this.primaryVal(class_17992.method_7909()) && (panelVal = this.primaryVal((class_1657)PredictionsModule.mc.field_1724, class_17992, bl, f)) != null) {
                    arrayList.add(panelVal);
                }
            }
        }
        if (ClickPearlModule.depthVal && (class_17992.method_7960() || !(class_17992.method_7909() instanceof class_1776))) {
            if (this.OCOocoOoOO == null) {
                this.OCOocoOoOO = new class_1799((class_1935)class_1802.field_8634);
            }
            if ((panelVal = this.primaryVal((class_1657)PredictionsModule.mc.field_1724, this.OCOocoOoOO, false, f)) != null) {
                arrayList.add(panelVal);
            }
        }
        if ((l = PredictionsModule.mc.field_1687.method_8510()) != this.twigB) {
            this.twigB = l;
            this.o0Ooc0COOoc.clear();
            for (class_1676 class_16763 : PredictionsModule.mc.field_1687.method_8390(class_1676.class, PredictionsModule.mc.field_1724.method_5829().method_1014(256.0), class_16762 -> !(class_16762 instanceof class_1671))) {
                cursorVal nvnNNunvv3 = this.primaryVal(class_16763, f);
                if (nvnNNunvv3 == null) continue;
                this.o0Ooc0COOoc.add(nvnNNunvv3);
            }
        }
        arrayList.addAll(this.o0Ooc0COOoc);
        this.secondaryVal(arrayList);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean primaryVal(class_1792 class_17922) {
        if (class_17922 instanceof class_1776) return true;
        if (class_17922 instanceof class_1823) return true;
        if (class_17922 instanceof class_1771) return true;
        if (class_17922 instanceof class_1753) return true;
        if (class_17922 instanceof class_1764) return true;
        if (class_17922 instanceof class_1835) return true;
        if (class_17922 instanceof class_4537) return true;
        if (!(class_17922 instanceof class_1779)) return false;
        return true;
    }

    private cursorVal primaryVal(class_1657 class_16572, class_1799 class_17992, boolean bl, float f) {
        class_1792 class_17922 = class_17992.method_7909();
        WildClient modeVal = this.primaryVal(class_16572, class_17922);
        class_2960 class_29602 = this.secondaryVal(class_17922);
        class_4184 class_41842 = PredictionsModule.mc.field_1773.method_19418();
        float f2 = class_41842.method_19330();
        float f3 = class_41842.method_19329();
        class_243 class_2432 = this.primaryVal(class_16572, f2, f3, modeVal.speed(), modeVal.pitchOffset());
        class_243 class_2433 = class_41842.method_19326().method_1023(0.0, 0.1, 0.0);
        class_243 class_2434 = class_243.method_1030((float)f3, (float)f2);
        class_243 class_2435 = class_243.method_1030((float)0.0f, (float)(f2 + 90.0f));
        float f4 = bl ? -0.3f : 0.3f;
        class_243 class_2436 = class_2433.method_1019(class_2434.method_1021(0.4)).method_1019(class_2435.method_1021((double)f4)).method_1023(0.0, 0.2, 0.0);
        class_243 class_2437 = class_2436.method_1020(class_2433);
        String string = (bl ? "self:off:" : "self:main:") + String.valueOf(class_7923.field_41178.method_10221(class_17922));
        return this.primaryVal((class_1297)class_16572, class_2433, class_2437, class_2432, modeVal.gravity(), 0.99, modeVal.applyPhysicsBeforeMove(), f, string, "You", class_29602, true);
    }

    private WildClient primaryVal(class_1657 class_16572, class_1792 class_17922) {
        double d = 1.5;
        double d2 = 0.03;
        float f = 0.0f;
        boolean bl = class_17922 instanceof class_1776 || class_17922 instanceof class_1823 || class_17922 instanceof class_1771;
        if (class_17922 instanceof class_1753) {
            int n = class_16572.method_6048();
            float f2 = n == 0 ? 1.0f : class_1753.method_7722((int)n);
            d = (double)f2 * 3.0;
            d2 = 0.05;
            bl = false;
        } else if (class_17922 instanceof class_1764) {
            d = 3.15;
            d2 = 0.05;
            bl = false;
        } else if (class_17922 instanceof class_1835) {
            d = 2.5;
            d2 = 0.05;
            bl = false;
        } else if (class_17922 instanceof class_1779) {
            d = 0.7f;
            d2 = 0.07;
            f = -20.0f;
            bl = true;
        } else if (class_17922 instanceof class_4537) {
            d = 0.5;
            d2 = 0.05;
            f = -20.0f;
            bl = true;
        }
        return new WildClient(d, d2, f, bl);
    }

    private class_243 primaryVal(class_1657 class_16572, float f, float f2, double d, float f3) {
        float f4 = f * ((float)Math.PI / 180);
        float f5 = f2 * ((float)Math.PI / 180);
        float f6 = (f2 + f3) * ((float)Math.PI / 180);
        double d2 = -class_3532.method_15374((float)f4) * class_3532.method_15362((float)f5);
        double d3 = -class_3532.method_15374((float)f6);
        double d4 = class_3532.method_15362((float)f4) * class_3532.method_15362((float)f5);
        class_243 class_2432 = new class_243(d2, d3, d4).method_1029().method_1021(d);
        class_243 class_2433 = class_16572.method_60478();
        return class_2432.method_1031(class_2433.field_1352, class_16572.method_24828() ? 0.0 : class_2433.field_1351, class_2433.field_1350);
    }

    private cursorVal primaryVal(class_1676 class_16762, float f) {
        block3: {
            block2: {
                if (class_16762.method_31481()) break block2;
                if (!(class_16762.method_18798().method_1027() < 0.001)) break block3;
            }
            return null;
        }
        class_243 class_2432 = class_16762.method_30950(f);
        double d = class_16762.method_56989();
        class_2960 class_29602 = this.primaryVal(class_16762);
        boolean bl = class_16762 instanceof class_1682;
        double d2 = bl && class_16762.method_5799() ? 0.8 : 0.99;
        return this.primaryVal((class_1297)class_16762, class_2432, class_243.field_1353, class_16762.method_18798(), d, d2, bl, f, "entity:" + class_16762.method_5628(), cursorVal.resolveOwnerName(class_16762), class_29602, false);
    }

    private cursorVal primaryVal(class_1297 class_12973, class_243 class_2432, class_243 class_2433, class_243 class_2434, double d, double d2, boolean bl, float f, String string, String string2, class_2960 class_29602, boolean bl2) {
        if (PredictionsModule.mc.field_1687 == null) {
            return null;
        }
        class_243 class_2435 = class_2434;
        class_243 class_2436 = class_2432;
        ArrayList<class_243> arrayList = new ArrayList<class_243>();
        arrayList.add(class_2432.method_1019(class_2433));
        int n = 0;
        class_3965 class_39652 = null;
        class_1297 class_12974 = null;
        int n2 = 7;
        for (int i = 0; i < 240; ++i) {
            class_243 class_2437 = bl ? this.primaryVal(class_2435, d, d2) : class_2435;
            class_243 class_2438 = class_2436.method_1019(class_2437);
            class_39652 = PredictionsModule.mc.field_1687.method_17742(new class_3959(class_2436, class_2438, class_3959.class_3960.field_17558, class_3959.class_242.field_1348, class_12973));
            class_243 class_2439 = class_39652.method_17783() != class_239.class_240.field_1333 ? class_39652.method_17784() : class_2438;
            class_238 class_2382 = new class_238(class_2436, class_2439).method_1014(1.0);
            double d3 = Double.MAX_VALUE;
            class_243 class_24310 = null;
            class_1297 class_12975 = null;
            for (class_1297 class_12976 : PredictionsModule.mc.field_1687.method_8333(class_12973, class_2382, class_12972 -> !class_12972.method_7325() && class_12972.method_5805())) {
                class_238 class_2383 = class_12976.method_5829().method_1014(0.3);
                Optional optional = class_2383.method_992(class_2436, class_2439);
                if (!optional.isPresent()) continue;
                double d4 = class_2436.method_1025((class_243)optional.get());
                if (!(d4 < d3)) continue;
                d3 = d4;
                class_24310 = (class_243)optional.get();
                class_12975 = class_12976;
            }
            double d5 = Math.max(0.0, 1.0 - (double)(i + 1) / (double)n2);
            if (class_12975 != null) {
                arrayList.add(class_24310.method_1019(class_2433.method_1021(d5)));
                class_12974 = class_12975;
                class_2436 = class_24310;
                n = i + 1;
                break;
            }
            if (class_39652.method_17783() != class_239.class_240.field_1333) {
                arrayList.add(class_39652.method_17784().method_1019(class_2433.method_1021(d5)));
                class_2436 = class_39652.method_17784();
                n = i + 1;
                break;
            }
            arrayList.add(class_2438.method_1019(class_2433.method_1021(d5)));
            class_2436 = class_2438;
            class_2435 = bl ? class_2437 : this.secondaryVal(class_2435, d, d2);
            n = i + 1;
        }
        if (arrayList.size() < 2) {
            return null;
        }
        class_238 class_2384 = class_12974 != null ? this.primaryVal(class_12974, f) : null;
        return new cursorVal(string, this.primaryVal((List<class_243>)arrayList), class_2436, this.primaryVal(class_39652), class_2384, n, class_12974, class_39652, string2, class_29602, bl2);
    }

    private List<class_243> primaryVal(List<class_243> list) {
        int n = list.size();
        if (n <= 96) {
            return list;
        }
        int n2 = Math.max(2, (int)Math.ceil((double)n / 96.0));
        ArrayList<class_243> arrayList = new ArrayList<class_243>(n / n2 + 2);
        for (int i = 0; i < n; i += n2) {
            arrayList.add(list.get(i));
        }
        class_243 class_2432 = list.get(n - 1);
        if (arrayList.isEmpty() || arrayList.get(arrayList.size() - 1) != class_2432) {
            arrayList.add(class_2432);
        }
        return arrayList;
    }

    private void secondaryVal(List<cursorVal> list) {
        if (list.isEmpty()) {
            this.nodeH.clear();
            return;
        }
        HashMap<String, cursorVal> hashMap = new HashMap<String, cursorVal>();
        Iterator<cursorVal> iterator = list.iterator();
        while (iterator.hasNext()) {
            cursorVal panelVal = iterator.next();
            cursorVal nvnNNunvv3 = this.primaryVal(panelVal);
            this.nodeF.add(nvnNNunvv3);
            hashMap.put(nvnNNunvv3.key(), nvnNNunvv3);
        }
        this.nodeH.clear();
        this.nodeH.putAll(hashMap);
    }

    private cursorVal primaryVal(cursorVal panelVal) {
        cursorVal nvnNNunvv3 = this.nodeH.get(panelVal.key());
        if (nvnNNunvv3 == null || nvnNNunvv3.path().size() < 2 || panelVal.path().size() < 2) {
            return panelVal;
        }
        if (nvnNNunvv3.path().get(0).method_1025(panelVal.path().get(0)) > 256.0) {
            return panelVal;
        }
        List<class_243> list = this.primaryVal(nvnNNunvv3.path(), panelVal.path(), 0.1f);
        float f = panelVal.isPreAim() ? 0.1f : 0.1f;
        class_243 class_2432 = this.primaryVal(nvnNNunvv3.landingPos(), panelVal.landingPos(), f, 64.0);
        class_243 class_2433 = this.secondaryVal(nvnNNunvv3.blockRenderPos(), panelVal.blockRenderPos(), f, 64.0);
        class_238 class_2382 = this.primaryVal(nvnNNunvv3, panelVal, panelVal.isPreAim() ? 0.1f : 0.1f);
        return panelVal.withRenderState(list, class_2432, class_2433, class_2382);
    }

    private List<class_243> primaryVal(List<class_243> list, List<class_243> list2, float f) {
        ArrayList<class_243> arrayList = new ArrayList<class_243>(list2.size());
        for (int i = 0; i < list2.size(); ++i) {
            class_243 class_2432 = i < list.size() ? this.primaryVal(list.get(i), list2.get(i), f) : list2.get(i);
            arrayList.add(class_2432);
        }
        return arrayList;
    }

    private class_243 primaryVal(class_243 class_2432, class_243 class_2433, float f) {
        return new class_243(class_3532.method_16436((double)f, (double)class_2432.field_1352, (double)class_2433.field_1352), class_3532.method_16436((double)f, (double)class_2432.field_1351, (double)class_2433.field_1351), class_3532.method_16436((double)f, (double)class_2432.field_1350, (double)class_2433.field_1350));
    }

    private class_243 primaryVal(class_243 class_2432, class_243 class_2433, float f, double d) {
        if (class_2432.method_1025(class_2433) > d) {
            return class_2433;
        }
        return this.primaryVal(class_2432, class_2433, f);
    }

    private class_243 secondaryVal(class_243 class_2432, class_243 class_2433, float f, double d) {
        if (class_2432 == null) {
            return class_2433;
        }
        if (class_2433 == null) {
            return null;
        }
        if (class_2432.method_1025(class_2433) > d) {
            return class_2433;
        }
        return this.primaryVal(class_2432, class_2433, f);
    }

    private class_238 primaryVal(cursorVal panelVal, cursorVal nvnNNunvv3, float f) {
        block7: {
            block6: {
                if (nvnNNunvv3.targetBox() == null) {
                    return null;
                }
                if (panelVal.targetBox() == null || panelVal.hitEntity() == null) break block6;
                if (nvnNNunvv3.hitEntity() != null) break block7;
            }
            return nvnNNunvv3.targetBox();
        }
        if (panelVal.hitEntity().method_5628() != nvnNNunvv3.hitEntity().method_5628()) {
            return nvnNNunvv3.targetBox();
        }
        if (this.primaryVal(panelVal.targetBox(), nvnNNunvv3.targetBox()) > 16.0) {
            return nvnNNunvv3.targetBox();
        }
        return this.primaryVal(panelVal.targetBox(), nvnNNunvv3.targetBox(), f);
    }

    private class_238 primaryVal(class_238 class_2382, class_238 class_2383, float f) {
        return new class_238(class_3532.method_16436((double)f, (double)class_2382.field_1323, (double)class_2383.field_1323), class_3532.method_16436((double)f, (double)class_2382.field_1322, (double)class_2383.field_1322), class_3532.method_16436((double)f, (double)class_2382.field_1321, (double)class_2383.field_1321), class_3532.method_16436((double)f, (double)class_2382.field_1320, (double)class_2383.field_1320), class_3532.method_16436((double)f, (double)class_2382.field_1325, (double)class_2383.field_1325), class_3532.method_16436((double)f, (double)class_2382.field_1324, (double)class_2383.field_1324));
    }

    private double primaryVal(class_238 class_2382, class_238 class_2383) {
        double d = (class_2382.field_1323 + class_2382.field_1320 - class_2383.field_1323 - class_2383.field_1320) * 0.5;
        double d2 = (class_2382.field_1322 + class_2382.field_1325 - class_2383.field_1322 - class_2383.field_1325) * 0.5;
        double d3 = (class_2382.field_1321 + class_2382.field_1324 - class_2383.field_1321 - class_2383.field_1324) * 0.5;
        return d * d + d2 * d2 + d3 * d3;
    }

    private class_238 primaryVal(class_1297 class_12972, float f) {
        class_243 class_2432 = class_12972.method_30950(f);
        class_243 class_2433 = class_12972.method_19538();
        return class_12972.method_5829().method_989(class_2432.field_1352 - class_2433.field_1352, class_2432.field_1351 - class_2433.field_1351, class_2432.field_1350 - class_2433.field_1350);
    }

    private class_243 primaryVal(class_3965 class_39652) {
        if (class_39652 == null || class_39652.method_17783() == class_239.class_240.field_1333) {
            return null;
        }
        class_2338 class_23382 = class_39652.method_17777();
        return new class_243((double)class_23382.method_10263(), (double)class_23382.method_10264(), (double)class_23382.method_10260());
    }

    private void blockRef() {
        this.nodeF.clear();
        this.nodeH.clear();
        this.o0Ooc0COOoc.clear();
        this.twigB = Long.MIN_VALUE;
    }

    private class_243 primaryVal(class_243 class_2432, double d, double d2) {
        return class_2432.method_1023(0.0, d, 0.0).method_1021(d2);
    }

    private class_243 secondaryVal(class_243 class_2432, double d, double d2) {
        return class_2432.method_1021(d2).method_1023(0.0, d, 0.0);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, class_243 class_2432, List<class_243> list, int n, boolean bl) {
        if (list.size() < 2) {
            return;
        }
        float f = this.holderVal() * 0.3125f;
        this.primaryVal(class_45882, matrix4f, class_2432, list, n, bl, 0.072f, 0.024f, 0.56f, f + 0.23f, 0.64f, 1.0f);
        this.primaryVal(class_45882, matrix4f, class_2432, list, n, bl, 0.042f, 0.014f, 0.94f, f + 0.37f, 1.0f, 1.0f);
    }

    private void secondaryVal(class_4588 class_45882, Matrix4f matrix4f, class_243 class_2432, List<class_243> list, int n, boolean bl) {
        if (list.size() < 2) {
            return;
        }
        float f = this.holderVal() * 0.3125f;
        this.primaryVal(class_45882, matrix4f, class_2432, list, n, bl, 0.235f, 0.066f, 0.16f, f, 0.25f, 0.0f);
        this.primaryVal(class_45882, matrix4f, class_2432, list, n, bl, 0.126f, 0.036f, 0.34f, f + 0.19f, 0.58f, 0.0f);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, class_243 class_2432, List<class_243> list, int n, boolean bl, float f, float f2, float f3, float f4, float f5, float f6) {
        int n2;
        int n3 = list.size();
        int n4 = n3 - 1;
        int n5 = n >> 16 & 0xFF;
        int n6 = n >> 8 & 0xFF;
        int n7 = n & 0xFF;
        int n8 = Math.max(120, n >>> 24 & 0xFF);
        double d = class_2432.field_1352;
        double d2 = class_2432.field_1351;
        double d3 = class_2432.field_1350;
        for (n2 = 0; n2 <= 10; ++n2) {
            double d4 = (double)(entryVal[n2] + f4 * 0.07f) * Math.PI * 2.0;
            this.UnUUVuVunvVu[n2] = Math.cos(d4);
            this.twigC[n2] = Math.sin(d4);
        }
        for (n2 = 0; n2 < n4; ++n2) {
            class_243 class_2433 = list.get(n2);
            class_243 class_2434 = list.get(n2 + 1);
            double d5 = class_2433.field_1352 - d;
            double d6 = class_2433.field_1351 - d2;
            double d7 = class_2433.field_1350 - d3;
            double d8 = class_2434.field_1352 - d;
            double d9 = class_2434.field_1351 - d2;
            double d10 = class_2434.field_1350 - d3;
            double d11 = d8 - d5;
            double d12 = d9 - d6;
            double d13 = d10 - d7;
            double d14 = Math.sqrt(d11 * d11 + d12 * d12 + d13 * d13);
            if (d14 <= 1.0E-5) continue;
            double d15 = d11 / d14;
            double d16 = d12 / d14;
            double d17 = d13 / d14;
            double d18 = Math.abs(d16) < 0.92 ? 0.0 : 1.0;
            double d19 = Math.abs(d16) < 0.92 ? 1.0 : 0.0;
            double d20 = 0.0;
            double d21 = d19 * d17 - d20 * d16;
            double d22 = d20 * d15 - d18 * d17;
            double d23 = d18 * d16 - d19 * d15;
            double d24 = Math.sqrt(d21 * d21 + d22 * d22 + d23 * d23);
            if (d24 <= 1.0E-5) {
                d21 = 1.0;
                d22 = 0.0;
                d23 = 0.0;
            } else {
                d21 /= d24;
                d22 /= d24;
                d23 /= d24;
            }
            double d25 = d16 * d23 - d17 * d22;
            double d26 = d17 * d21 - d15 * d23;
            double d27 = d15 * d22 - d16 * d21;
            float f7 = (float)n2 / (float)n4;
            float f8 = (float)(n2 + 1) / (float)n4;
            float f9 = this.primaryVal(f7, f, f2, bl);
            float f10 = this.primaryVal(f8, f, f2, bl);
            f9 *= 1.0f + 0.085f * (float)Math.sin((double)(f7 * 2.7f - f4 * 3.8f + f5 * 0.31f) * Math.PI * 2.0);
            f10 *= 1.0f + 0.085f * (float)Math.sin((double)(f8 * 2.7f - f4 * 3.8f + f5 * 0.31f) * Math.PI * 2.0);
            for (int i = 0; i < 10; ++i) {
                float f11 = entryVal[i];
                float f12 = entryVal[i + 1];
                double d28 = this.UnUUVuVunvVu[i];
                double d29 = this.twigC[i];
                double d30 = this.UnUUVuVunvVu[i + 1];
                double d31 = this.twigC[i + 1];
                double d32 = d21 * d28 + d25 * d29;
                double d33 = d22 * d28 + d26 * d29;
                double d34 = d23 * d28 + d27 * d29;
                double d35 = d21 * d30 + d25 * d31;
                double d36 = d22 * d30 + d26 * d31;
                double d37 = d23 * d30 + d27 * d31;
                this.primaryVal(class_45882, matrix4f, d5 + d32 * (double)f9, d6 + d33 * (double)f9, d7 + d34 * (double)f9, n5, n6, n7, n8, f7, f6 + f11, f4, f3, f5, d32, d33, d34);
                this.primaryVal(class_45882, matrix4f, d5 + d35 * (double)f9, d6 + d36 * (double)f9, d7 + d37 * (double)f9, n5, n6, n7, n8, f7, f6 + f12, f4, f3, f5, d35, d36, d37);
                this.primaryVal(class_45882, matrix4f, d8 + d35 * (double)f10, d9 + d36 * (double)f10, d10 + d37 * (double)f10, n5, n6, n7, n8, f8, f6 + f12, f4, f3, f5, d35, d36, d37);
                this.primaryVal(class_45882, matrix4f, d8 + d32 * (double)f10, d9 + d33 * (double)f10, d10 + d34 * (double)f10, n5, n6, n7, n8, f8, f6 + f11, f4, f3, f5, d32, d33, d34);
            }
        }
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, int n, int n2, int n3, int n4, float f, float f2, float f3, float f4, float f5, double d4, double d5, double d6) {
        float f6 = this.secondaryVal(f);
        int n5 = this.primaryVal(n, 255, f5 * 0.18f);
        int n6 = this.primaryVal(n2, 255, f5 * 0.14f);
        int n7 = this.primaryVal(n3, 255, f5 * 0.12f);
        int n8 = class_3532.method_15340((int)Math.round((float)n4 * f4 * f6), (int)0, (int)255);
        class_45882.method_22918(matrix4f, (float)d, (float)d2, (float)d3).method_22913(f + f3 * 0.28f, f2).method_1336(n5, n6, n7, n8).method_22914((float)d4, (float)d5, (float)d6);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, class_243 class_2432, class_3965 class_39652, class_243 class_2433, int n) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5;
        double d6;
        if (class_39652 == null || class_39652.method_17783() == class_239.class_240.field_1333) {
            return;
        }
        class_2350 class_23502 = class_39652.method_17780();
        class_243 class_2434 = class_2433 != null ? class_2433 : class_39652.method_17784();
        double d7 = class_23502.method_10148();
        double d8 = class_23502.method_10164();
        double d9 = class_23502.method_10165();
        double d10 = class_2434.field_1352 - class_2432.field_1352 + d7 * 0.01;
        double d11 = class_2434.field_1351 - class_2432.field_1351 + d8 * 0.01;
        double d12 = class_2434.field_1350 - class_2432.field_1350 + d9 * 0.01;
        if (class_23502.method_10166() == class_2350.class_2351.field_11052) {
            d6 = 1.0;
            d5 = 0.0;
            d4 = 0.0;
            d3 = 0.0;
            d2 = 0.0;
            d = class_23502 == class_2350.field_11033 ? -1.0 : 1.0;
        } else if (class_23502.method_10166() == class_2350.class_2351.field_11048) {
            d6 = 0.0;
            d5 = 0.0;
            d4 = class_23502 == class_2350.field_11039 ? -1.0 : 1.0;
            d3 = 0.0;
            d2 = 1.0;
            d = 0.0;
        } else {
            d6 = class_23502 == class_2350.field_11043 ? -1.0 : 1.0;
            d5 = 0.0;
            d4 = 0.0;
            d3 = 0.0;
            d2 = 1.0;
            d = 0.0;
        }
        float f = this.holderVal() * 0.454545f;
        int n2 = n >> 16 & 0xFF;
        int n3 = n >> 8 & 0xFF;
        int n4 = n & 0xFF;
        float f2 = 0.92f + 0.08f * (float)Math.sin((double)f * Math.PI * 2.0);
        this.primaryVal(class_45882, matrix4f, d10, d11, d12, d7, d8, d9, d6, d5, d4, d3, d2, d, 1.2f * f2, n2, n3, n4, 56, f, 4.0f);
        this.primaryVal(class_45882, matrix4f, d10, d11, d12, d7, d8, d9, d6, d5, d4, d3, d2, d, 0.74f * f2, this.primaryVal(n2, 255, 0.18f), this.primaryVal(n3, 255, 0.14f), this.primaryVal(n4, 255, 0.16f), 100, f + 0.27f, 4.0f);
        this.primaryVal(class_45882, matrix4f, d10, d11, d12, d7, d8, d9, d6, d5, d4, d3, d2, d, 0.54f * f2, 0.3f * f2, this.primaryVal(n2, 255, 0.32f), this.primaryVal(n3, 255, 0.26f), this.primaryVal(n4, 255, 0.28f), 130, f, 4.0f);
        this.primaryVal(class_45882, matrix4f, d10, d11, d12, d6, d5, d4, d3, d2, d, 0.62f * f2, 0.09f, n2, n3, n4, 110, f + 0.21f, 0.78f, 2.0f);
        this.primaryVal(class_45882, matrix4f, d10, d11, d12, d6, d5, d4, d3, d2, d, 0.33f * f2, 0.038f, this.primaryVal(n2, 255, 0.36f), this.primaryVal(n3, 255, 0.3f), this.primaryVal(n4, 255, 0.32f), 200, f + 0.46f, 0.95f, 2.0f);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, class_243 class_2432, class_238 class_2382, int n, int n2, int n3) {
        double d = (class_2382.field_1323 + class_2382.field_1320) * 0.5 - class_2432.field_1352;
        double d2 = class_2382.field_1322 - class_2432.field_1351 + 0.035;
        double d3 = (class_2382.field_1321 + class_2382.field_1324) * 0.5 - class_2432.field_1350;
        double d4 = class_2382.field_1325 - class_2382.field_1322;
        double d5 = Math.max(class_2382.field_1320 - class_2382.field_1323, class_2382.field_1324 - class_2382.field_1321) * 0.66 + 0.22;
        long l = System.currentTimeMillis();
        float f = (float)(l % 1800L) / 1800.0f;
        this.primaryVal(class_45882, matrix4f, d, d2, d3, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, (float)d5, 0.058f, n, n2, n3, 215, f, 1.0f, 2.0f);
        this.primaryVal(class_45882, matrix4f, d, d2 + d4 * 0.56, d3, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, (float)(d5 * 0.86), 0.04f, n, n2, n3, 120, f + 0.33f, 0.62f, 2.0f);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, float f, int n, int n2, int n3, int n4, float f2, float f3) {
        for (int i = 0; i < 8; ++i) {
            float f4 = (float)i / 8.0f;
            float f5 = (float)(i + 1) / 8.0f;
            float f6 = f4;
            float f7 = i == 7 ? 0.999f : f5;
            double d13 = f * f4;
            double d14 = f * f5;
            int n5 = class_3532.method_15340((int)Math.round((float)n4 * (1.0f - f4) * (1.0f - f4)), (int)0, (int)255);
            int n6 = class_3532.method_15340((int)Math.round((float)n4 * (1.0f - f5) * (1.0f - f5)), (int)0, (int)255);
            for (int j = 0; j < 72; ++j) {
                float f8 = UuNnnVnuNNV[j];
                float f9 = UuNnnVnuNNV[j + 1];
                double d15 = heightRef[j];
                double d16 = levelVal[j];
                double d17 = heightRef[j + 1];
                double d18 = levelVal[j + 1];
                this.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d15, d16, d14, n, n2, n3, n6, f8 + f2 * 0.18f, f3 + f7);
                this.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d15, d16, d13, n, n2, n3, n5, f8 + f2 * 0.18f, f3 + f6);
                this.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d17, d18, d13, n, n2, n3, n5, f9 + f2 * 0.18f, f3 + f6);
                this.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d17, d18, d14, n, n2, n3, n6, f9 + f2 * 0.18f, f3 + f7);
            }
        }
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, int n, int n2, int n3, int n4, float f, float f2) {
        double d16 = d + (d7 * d13 + d10 * d14) * d15;
        double d17 = d2 + (d8 * d13 + d11 * d14) * d15;
        double d18 = d3 + (d9 * d13 + d12 * d14) * d15;
        class_45882.method_22918(matrix4f, (float)d16, (float)d17, (float)d18).method_22913(f, f2).method_1336(n, n2, n3, n4).method_22914((float)d4, (float)d5, (float)d6);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, float f, float f2, int n, int n2, int n3, int n4, float f3, float f4) {
        for (int i = 0; i < 6; ++i) {
            float f5 = (float)i / 6.0f;
            float f6 = (float)(i + 1) / 6.0f;
            float f7 = f5;
            float f8 = i == 5 ? 0.999f : f6;
            double d13 = f * f5;
            double d14 = f * f6;
            double d15 = (double)f2 * (1.0 - (double)(f5 * f5));
            double d16 = (double)f2 * (1.0 - (double)(f6 * f6));
            int n5 = class_3532.method_15340((int)Math.round((float)n4 * (1.0f - f5 * 0.62f)), (int)0, (int)255);
            int n6 = class_3532.method_15340((int)Math.round((float)n4 * (1.0f - f6 * 0.62f)), (int)0, (int)255);
            for (int j = 0; j < 72; ++j) {
                float f9 = UuNnnVnuNNV[j];
                float f10 = UuNnnVnuNNV[j + 1];
                double d17 = heightRef[j];
                double d18 = levelVal[j];
                double d19 = heightRef[j + 1];
                double d20 = levelVal[j + 1];
                this.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d17, d18, d14, d16, f6, n, n2, n3, n6, f9 + f3 * 0.26f, f4 + f8);
                this.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d17, d18, d13, d15, f5, n, n2, n3, n5, f9 + f3 * 0.26f, f4 + f7);
                this.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d19, d20, d13, d15, f5, n, n2, n3, n5, f10 + f3 * 0.26f, f4 + f7);
                this.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d19, d20, d14, d16, f6, n, n2, n3, n6, f10 + f3 * 0.26f, f4 + f8);
            }
        }
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, float f, int n, int n2, int n3, int n4, float f2, float f3) {
        double d17 = d7 * d13 + d10 * d14;
        double d18 = d8 * d13 + d11 * d14;
        double d19 = d9 * d13 + d12 * d14;
        double d20 = d + d17 * d15 + d4 * d16;
        double d21 = d2 + d18 * d15 + d5 * d16;
        double d22 = d3 + d19 * d15 + d6 * d16;
        double d23 = d4 * (1.0 - (double)(f * 0.32f)) + d17 * (double)f * (double)0.68f;
        double d24 = d5 * (1.0 - (double)(f * 0.32f)) + d18 * (double)f * (double)0.68f;
        double d25 = d6 * (1.0 - (double)(f * 0.32f)) + d19 * (double)f * (double)0.68f;
        double d26 = Math.sqrt(d23 * d23 + d24 * d24 + d25 * d25);
        if (d26 <= 1.0E-5) {
            d23 = d4;
            d24 = d5;
            d25 = d6;
        } else {
            d23 /= d26;
            d24 /= d26;
            d25 /= d26;
        }
        class_45882.method_22918(matrix4f, (float)d20, (float)d21, (float)d22).method_22913(f2, f3).method_1336(n, n2, n3, n4).method_22914((float)d23, (float)d24, (float)d25);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, int n, int n2, int n3) {
        double d7 = 0.004;
        double d8 = d - d7;
        double d9 = d2 - d7;
        double d10 = d3 - d7;
        double d11 = d4 + d7;
        double d12 = d5 + d7;
        double d13 = d6 + d7;
        int n4 = this.primaryVal(n, 255, 0.3f);
        int n5 = this.primaryVal(n2, 255, 0.26f);
        int n6 = this.primaryVal(n3, 255, 0.26f);
        this.primaryVal(class_45882, matrix4f, d8, d9, d10, d11, d12, d13, 0.046f, n, n2, n3, 26);
        this.primaryVal(class_45882, matrix4f, d8, d9, d10, d11, d12, d13, 0.02f, n, n2, n3, 60);
        this.primaryVal(class_45882, matrix4f, d8, d9, d10, d11, d12, d13, 0.008f, n4, n5, n6, 180);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, float f, int n, int n2, int n3, int n4) {
        this.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d2, d3, f, n, n2, n3, n4, 3.0f);
        this.primaryVal(class_45882, matrix4f, d4, d2, d3, d4, d2, d6, f, n, n2, n3, n4, 3.0f);
        this.primaryVal(class_45882, matrix4f, d4, d2, d6, d, d2, d6, f, n, n2, n3, n4, 3.0f);
        this.primaryVal(class_45882, matrix4f, d, d2, d6, d, d2, d3, f, n, n2, n3, n4, 3.0f);
        this.primaryVal(class_45882, matrix4f, d, d5, d3, d4, d5, d3, f, n, n2, n3, n4, 3.0f);
        this.primaryVal(class_45882, matrix4f, d4, d5, d3, d4, d5, d6, f, n, n2, n3, n4, 3.0f);
        this.primaryVal(class_45882, matrix4f, d4, d5, d6, d, d5, d6, f, n, n2, n3, n4, 3.0f);
        this.primaryVal(class_45882, matrix4f, d, d5, d6, d, d5, d3, f, n, n2, n3, n4, 3.0f);
        this.primaryVal(class_45882, matrix4f, d, d2, d3, d, d5, d3, f, n, n2, n3, n4, 3.0f);
        this.primaryVal(class_45882, matrix4f, d4, d2, d3, d4, d5, d3, f, n, n2, n3, n4, 3.0f);
        this.primaryVal(class_45882, matrix4f, d4, d2, d6, d4, d5, d6, f, n, n2, n3, n4, 3.0f);
        this.primaryVal(class_45882, matrix4f, d, d2, d6, d, d5, d6, f, n, n2, n3, n4, 3.0f);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, int n, int n2, int n3, int n4) {
        double d7 = d4 - d;
        double d8 = d5 - d2;
        double d9 = d6 - d3;
        double d10 = Math.min(Math.min(d7, d8), d9) * 0.42;
        if (d10 < 0.18) {
            d10 = 0.18;
        }
        if (d10 > 0.38) {
            d10 = 0.38;
        }
        float f = 0.028f;
        this.primaryVal(class_45882, matrix4f, d, d2, d3, 1.0, 1.0, 1.0, d10, f, n, n2, n3, n4);
        this.primaryVal(class_45882, matrix4f, d4, d2, d3, -1.0, 1.0, 1.0, d10, f, n, n2, n3, n4);
        this.primaryVal(class_45882, matrix4f, d4, d2, d6, -1.0, 1.0, -1.0, d10, f, n, n2, n3, n4);
        this.primaryVal(class_45882, matrix4f, d, d2, d6, 1.0, 1.0, -1.0, d10, f, n, n2, n3, n4);
        this.primaryVal(class_45882, matrix4f, d, d5, d3, 1.0, -1.0, 1.0, d10, f, n, n2, n3, n4);
        this.primaryVal(class_45882, matrix4f, d4, d5, d3, -1.0, -1.0, 1.0, d10, f, n, n2, n3, n4);
        this.primaryVal(class_45882, matrix4f, d4, d5, d6, -1.0, -1.0, -1.0, d10, f, n, n2, n3, n4);
        this.primaryVal(class_45882, matrix4f, d, d5, d6, 1.0, -1.0, -1.0, d10, f, n, n2, n3, n4);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, double d7, float f, int n, int n2, int n3, int n4) {
        this.primaryVal(class_45882, matrix4f, d, d2, d3, d + d4 * d7, d2, d3, f, n, n2, n3, n4, 3.0f);
        this.primaryVal(class_45882, matrix4f, d, d2, d3, d, d2 + d5 * d7, d3, f, n, n2, n3, n4, 3.0f);
        this.primaryVal(class_45882, matrix4f, d, d2, d3, d, d2, d3 + d6 * d7, f, n, n2, n3, n4, 3.0f);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, float f, float f2, int n, int n2, int n3, int n4, float f3, float f4, float f5) {
        double d10 = Math.max(0.01, (double)(f - f2 * 0.5f));
        double d11 = f + f2 * 0.5f;
        double d12 = d5 * d9 - d6 * d8;
        double d13 = d6 * d7 - d4 * d9;
        double d14 = d4 * d8 - d5 * d7;
        for (int i = 0; i < 72; ++i) {
            float f6 = UuNnnVnuNNV[i];
            float f7 = UuNnnVnuNNV[i + 1];
            double d15 = heightRef[i];
            double d16 = levelVal[i];
            double d17 = heightRef[i + 1];
            double d18 = levelVal[i + 1];
            int n5 = this.primaryVal(n4, f6, f3, f4);
            int n6 = this.primaryVal(n4, f7, f3, f4);
            this.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d5, d6, d7, d8, d9, d15, d16, d11, n, n2, n3, n5, f6 + f3 * 0.2f, f5 + 0.92f, d12, d13, d14);
            this.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d5, d6, d7, d8, d9, d15, d16, d10, n, n2, n3, n5, f6 + f3 * 0.2f, f5 + 0.08f, d12, d13, d14);
            this.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d5, d6, d7, d8, d9, d17, d18, d10, n, n2, n3, n6, f7 + f3 * 0.2f, f5 + 0.08f, d12, d13, d14);
            this.primaryVal(class_45882, matrix4f, d, d2, d3, d4, d5, d6, d7, d8, d9, d17, d18, d11, n, n2, n3, n6, f7 + f3 * 0.2f, f5 + 0.92f, d12, d13, d14);
        }
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, int n, int n2, int n3, int n4, float f, float f2, double d13, double d14, double d15) {
        double d16 = d + (d4 * d10 + d7 * d11) * d12;
        double d17 = d2 + (d5 * d10 + d8 * d11) * d12;
        double d18 = d3 + (d6 * d10 + d9 * d11) * d12;
        class_45882.method_22918(matrix4f, (float)d16, (float)d17, (float)d18).method_22913(f, f2).method_1336(n, n2, n3, n4).method_22914((float)d13, (float)d14, (float)d15);
    }

    private int primaryVal(int n, float f, float f2, float f3) {
        float f4 = 0.5f + 0.5f * (float)Math.sin((double)(f * 3.0f - f2 * 2.0f) * Math.PI * 2.0);
        return class_3532.method_15340((int)Math.round((float)n * f3 * (0.48f + f4 * 0.52f)), (int)0, (int)255);
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, double d, double d2, double d3, double d4, double d5, double d6, float f, int n, int n2, int n3, int n4, float f2) {
        double d7 = d4 - d;
        double d8 = d5 - d2;
        double d9 = d6 - d3;
        double d10 = Math.sqrt(d7 * d7 + d8 * d8 + d9 * d9);
        if (d10 <= 1.0E-5) {
            return;
        }
        double d11 = d7 / d10;
        double d12 = d8 / d10;
        double d13 = d9 / d10;
        double d14 = Math.abs(d12) < 0.92 ? 0.0 : 1.0;
        double d15 = Math.abs(d12) < 0.92 ? 1.0 : 0.0;
        double d16 = 0.0;
        double d17 = d15 * d13 - d16 * d12;
        double d18 = d16 * d11 - d14 * d13;
        double d19 = d14 * d12 - d15 * d11;
        double d20 = Math.sqrt(d17 * d17 + d18 * d18 + d19 * d19);
        if (d20 <= 1.0E-5) {
            d17 = 1.0;
            d18 = 0.0;
            d19 = 0.0;
        } else {
            d17 /= d20;
            d18 /= d20;
            d19 /= d20;
        }
        double d21 = d12 * d19 - d13 * d18;
        double d22 = d13 * d17 - d11 * d19;
        double d23 = d11 * d18 - d12 * d17;
        double d24 = (double)f * 0.5;
        for (int i = 0; i < 6; ++i) {
            float f3 = countRef[i];
            float f4 = countRef[i + 1];
            double d25 = depthRef[i];
            double d26 = speedRef[i];
            double d27 = depthRef[i + 1];
            double d28 = speedRef[i + 1];
            double d29 = d17 * d25 + d21 * d26;
            double d30 = d18 * d25 + d22 * d26;
            double d31 = d19 * d25 + d23 * d26;
            double d32 = d17 * d27 + d21 * d28;
            double d33 = d18 * d27 + d22 * d28;
            double d34 = d19 * d27 + d23 * d28;
            class_45882.method_22918(matrix4f, (float)(d + d29 * d24), (float)(d2 + d30 * d24), (float)(d3 + d31 * d24)).method_22913(0.0f, f2 + f3).method_1336(n, n2, n3, n4).method_22914((float)d29, (float)d30, (float)d31);
            class_45882.method_22918(matrix4f, (float)(d + d32 * d24), (float)(d2 + d33 * d24), (float)(d3 + d34 * d24)).method_22913(0.0f, f2 + f4).method_1336(n, n2, n3, n4).method_22914((float)d32, (float)d33, (float)d34);
            class_45882.method_22918(matrix4f, (float)(d4 + d32 * d24), (float)(d5 + d33 * d24), (float)(d6 + d34 * d24)).method_22913(1.0f, f2 + f4).method_1336(n, n2, n3, n4).method_22914((float)d32, (float)d33, (float)d34);
            class_45882.method_22918(matrix4f, (float)(d4 + d29 * d24), (float)(d5 + d30 * d24), (float)(d6 + d31 * d24)).method_22913(1.0f, f2 + f3).method_1336(n, n2, n3, n4).method_22914((float)d29, (float)d30, (float)d31);
        }
    }

    private float primaryVal(float f, float f2, float f3, boolean bl) {
        float f4 = (float)Math.pow(this.tertiaryVal(f), 0.72f);
        float f5 = f2 + (f3 - f2) * f4;
        return bl ? f5 : f5 * (1.0f - f4 * 0.36f);
    }

    private float secondaryVal(float f) {
        return this.primaryVal(0.0f, 0.055f, f) * (1.0f - this.primaryVal(0.885f, 1.0f, f));
    }

    private float primaryVal(float f, float f2, float f3) {
        float f4 = this.tertiaryVal((f3 - f) / Math.max(1.0E-5f, f2 - f));
        return f4 * f4 * (3.0f - 2.0f * f4);
    }

    private float tertiaryVal(float f) {
        return Math.max(0.0f, Math.min(1.0f, f));
    }

    private int primaryVal(int n, int n2, float f) {
        float f2 = this.tertiaryVal(f);
        return class_3532.method_15340((int)Math.round((float)n + (float)(n2 - n) * f2), (int)0, (int)255);
    }

    private float holderVal() {
        return (float)(System.nanoTime() - phaseVal) * 1.0E-9f;
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, cursorVal panelVal) {
        float f4;
        String string = this.marginVal((float)panelVal.ticks() / 20.0f);
        float f5 = 25.0f;
        float f6 = 3.0f;
        float f7 = 3.0f;
        float f8 = 22.0f;
        float f9 = 3.0f;
        float f10 = 6.0f;
        float f11 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)f5).primaryVal;
        int n = this.primaryVal(panelVal.icon());
        boolean bl = n > 0;
        float f12 = bl ? f8 + f9 : 0.0f;
        float f13 = f6 * 2.0f + f12 + f11 + f10;
        float f14 = f7 + Math.max(bl ? f8 : 0.0f, f5);
        float f15 = f14 / 2.0f;
        heightVal.primaryVal(f, f2);
        heightVal.secondaryVal(f3, f3);
        float f16 = -f13 / 2.0f;
        float f17 = -f14;
        this.primaryVal(heightVal, f16, f17, f13, f14, f15, 111.0f);
        float f18 = f16 + f6 + (bl ? 0.0f : f10 / 2.0f);
        if (bl) {
            f4 = f16 + f6;
            float f19 = f17 + (f14 - f8) / 2.0f;
            heightVal.primaryVal(f4, f19 + f8);
            heightVal.secondaryVal(1.0f, -1.0f);
            heightVal.primaryVal(n, 0.0f, 0.0f, f8, f8);
            heightVal.speedVal();
            heightVal.limitVal();
            f18 = f4 + f8 + f9;
        }
        f4 = f17 + f7 + f5 - 10.0f;
        int n2 = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.extraVal(1, 1), 230);
        heightVal.primaryVal(FontRegistry.primaryVal, f18 + 1.0f, f4 + 1.0f, f5, string, n2);
        heightVal.speedVal();
        heightVal.limitVal();
    }

    private boolean secondaryVal(cursorVal panelVal) {
        class_2960 class_29602 = panelVal.icon();
        return class_29602 != null && class_29602.method_12832().contains("ender_pearl");
    }

    private void secondaryVal(Renderer2D heightVal, float f, float f2, float f3, cursorVal panelVal) {
        String string;
        block3: {
            block2: {
                string = panelVal.ownerName();
                if (string == null || string.isEmpty()) break block2;
                if (string.equals("Unknown")) break block2;
                if (!string.equals("You")) break block3;
            }
            return;
        }
        float f4 = 22.0f;
        float f5 = 4.0f;
        float f6 = 3.0f;
        float f7 = 18.0f;
        float f8 = 4.0f;
        float f9 = Renderer2D.primaryVal((FontObject)FontRegistry.primaryVal, (String)string, (float)f4).primaryVal;
        float f10 = f5 * 2.0f + f7 + f8 + f9;
        float f11 = f6 + Math.max(f7, f4);
        float f12 = f11 / 2.0f;
        heightVal.primaryVal(f, f2);
        heightVal.secondaryVal(f3, f3);
        float f13 = -f10 / 2.0f;
        float f14 = -f11;
        this.primaryVal(heightVal, f13, f14, f10, f11, f12, 111.0f);
        float f15 = f13 + f5;
        float f16 = f14 + (f11 - f7) / 2.0f;
        this.primaryVal(heightVal, string, f15, f16, f7, 1.0f);
        float f17 = f15 + f7 + f8;
        float f18 = f14 + f6 + f4 - 10.0f;
        int n = Renderer2D.VvunVVUvUNnv.chunkVal(Renderer2D.VvunVVUvUNnv.extraVal(1, 1), 230);
        heightVal.primaryVal(FontRegistry.primaryVal, f17 + 1.0f, f18 + 1.0f, f4, string, n);
        heightVal.speedVal();
        heightVal.limitVal();
    }

    private void primaryVal(Renderer2D heightVal, String string, float f, float f2, float f3, float f4) {
        if (mc.method_1562() == null) {
            return;
        }
        class_640 class_6402 = null;
        for (class_640 class_6403 : mc.method_1562().method_2880()) {
            if (!class_6403.method_2966().getName().equalsIgnoreCase(string)) continue;
            class_6402 = class_6403;
            break;
        }
        if (class_6402 == null) {
            return;
        }
        try {
            class_1044 class_6403;
            class_2960 class_29602 = class_6402.method_52810().comp_1626();
            class_6403 = mc.method_1531().method_4619(class_29602);
            if (class_6403 != null) {
                class_10868 class_108682;
                GpuTexture gpuTexture = class_6403.method_68004();
                if (gpuTexture instanceof class_10868 && (class_108682 = (class_10868)gpuTexture).method_68427() > 0) {
                    int n = class_108682.method_68427();
                    GlStateManager._bindTexture((int)n);
                    heightVal.weightVal(f4);
                    heightVal.primaryVal(n, f, f2, f3, f3, 0.125f, 0.125f, 0.25f, 0.25f, 3.0f);
                    heightVal.primaryVal(n, f, f2, f3, f3, 0.625f, 0.125f, 0.75f, 0.25f, 3.0f);
                    heightVal.widthVal();
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f6 / 155.0f;
        int n = this.nvuVvuNnNUnv.primaryVal(255.0f);
        int n2 = this.nvuVvuNnNUnv.marginVal(f7);
        heightVal.primaryVal(f, f2, f3, f4, 12.0f, n);
    }

    private String marginVal(float f) {
        String string = String.format(Locale.US, "%.1f", Float.valueOf(f)).replace('.', ',');
        return string + " sec";
    }

    private int primaryVal(class_2960 class_29602) {
        if (class_29602 == null) {
            return -1;
        }
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

    private class_2960 secondaryVal(class_1792 class_17922) {
        if (class_17922 instanceof class_1835) {
            return class_2960.method_60655((String)"minecraft", (String)"textures/item/trident.png");
        }
        if (class_17922 instanceof class_1753 || class_17922 instanceof class_1764) {
            return class_2960.method_60655((String)"minecraft", (String)"textures/item/arrow.png");
        }
        if (class_17922 instanceof class_4537) {
            return class_2960.method_60655((String)"minecraft", (String)"textures/item/potion.png");
        }
        if (class_17922 instanceof class_1823) {
            return class_2960.method_60655((String)"minecraft", (String)"textures/item/snowball.png");
        }
        if (class_17922 instanceof class_1771) {
            return class_2960.method_60655((String)"minecraft", (String)"textures/item/egg.png");
        }
        if (class_17922 instanceof class_1779) {
            return class_2960.method_60655((String)"minecraft", (String)"textures/item/experience_bottle.png");
        }
        if (class_17922 instanceof class_1776) {
            return class_2960.method_60655((String)"minecraft", (String)"textures/item/ender_pearl.png");
        }
        return null;
    }

    private class_2960 primaryVal(class_1676 class_16762) {
        String string = class_7923.field_41177.method_10221(class_16762.method_5864()).method_12832();
        if (string.contains("trident")) {
            return class_2960.method_60655((String)"minecraft", (String)"textures/item/trident.png");
        }
        if (string.contains("snowball")) {
            return class_2960.method_60655((String)"minecraft", (String)"textures/item/snowball.png");
        }
        if (string.contains("arrow")) {
            return class_2960.method_60655((String)"minecraft", (String)"textures/item/arrow.png");
        }
        if (string.contains("potion")) {
            return class_2960.method_60655((String)"minecraft", (String)"textures/item/potion.png");
        }
        if (string.contains("pearl")) {
            return class_2960.method_60655((String)"minecraft", (String)"textures/item/ender_pearl.png");
        }
        if (string.contains("egg")) {
            return class_2960.method_60655((String)"minecraft", (String)"textures/item/egg.png");
        }
        if (string.contains("experience_bottle")) {
            return class_2960.method_60655((String)"minecraft", (String)"textures/item/experience_bottle.png");
        }
        return null;
    }

    static {
        double d;
        float f;
        int n;
        phaseVal = System.nanoTime();
        heightRef = new double[73];
        levelVal = new double[73];
        UuNnnVnuNNV = new float[73];
        depthRef = new double[7];
        speedRef = new double[7];
        countRef = new float[7];
        entryVal = new float[11];
        for (n = 0; n <= 72; ++n) {
            PredictionsModule.UuNnnVnuNNV[n] = f = (float)n / 72.0f;
            d = (double)f * Math.PI * 2.0;
            PredictionsModule.heightRef[n] = Math.cos(d);
            PredictionsModule.levelVal[n] = Math.sin(d);
        }
        for (n = 0; n <= 6; ++n) {
            PredictionsModule.countRef[n] = f = n < 6 ? (float)n / 6.0f : 0.999f;
            d = (double)f * Math.PI * 2.0;
            PredictionsModule.depthRef[n] = Math.cos(d);
            PredictionsModule.speedRef[n] = Math.sin(d);
        }
        for (n = 0; n <= 10; ++n) {
            PredictionsModule.entryVal[n] = n < 10 ? (float)n / 10.0f : 0.999f;
        }
        guardVal = class_2960.method_60655((String)"wild", (String)"core/prediction_vfx");
        VUuuVUnun = new BlendFunction(SourceFactor.SRC_ALPHA, DestFactor.ONE);
        RenderPipeline.Snippet[] snippetArray = new RenderPipeline.Snippet[2];
        snippetArray[0] = class_10799.field_60125;
        snippetArray[1] = class_10799.field_60126;
        vVVuuVVv = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])snippetArray).withLocation(class_2960.method_60655((String)"wild", (String)"prediction_glass")).withVertexShader(guardVal).withFragmentShader(guardVal).withVertexFormat(class_290.field_1577, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).build());
        RenderPipeline.Snippet[] snippetArray2 = new RenderPipeline.Snippet[2];
        snippetArray2[0] = class_10799.field_60125;
        snippetArray2[1] = class_10799.field_60126;
        VuunNUUUvu = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])snippetArray2).withLocation(class_2960.method_60655((String)"wild", (String)"prediction_glass_no_depth")).withVertexShader(guardVal).withFragmentShader(guardVal).withVertexFormat(class_290.field_1577, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).build());
        RenderPipeline.Snippet[] snippetArray3 = new RenderPipeline.Snippet[2];
        snippetArray3[0] = class_10799.field_60125;
        snippetArray3[1] = class_10799.field_60126;
        NNUUNUuVNNVn = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])snippetArray3).withLocation(class_2960.method_60655((String)"wild", (String)"prediction_emission")).withVertexShader(guardVal).withFragmentShader(guardVal).withVertexFormat(class_290.field_1577, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(VUuuVUnun).build());
        VvVvnNUnvuvV = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_60125, class_10799.field_60126}).withLocation(class_2960.method_60655((String)"wild", (String)"prediction_emission_no_depth")).withVertexShader(guardVal).withFragmentShader(guardVal).withVertexFormat(class_290.field_1577, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(VUuuVUnun).build());
        tokenVal = class_1921.method_24049((String)"wild_prediction_glass", (int)0x200000, (boolean)false, (boolean)true, (RenderPipeline)vVVuuVVv, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        NUVvUUVuVNVv = class_1921.method_24049((String)"wild_prediction_glass_no_depth", (int)0x200000, (boolean)false, (boolean)true, (RenderPipeline)VuunNUUUvu, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        nodeB = class_1921.method_24049((String)"wild_prediction_emission", (int)0x200000, (boolean)false, (boolean)true, (RenderPipeline)NNUUNUuVNNVn, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        UNvvunVVn = class_1921.method_24049((String)"wild_prediction_emission_no_depth", (int)0x200000, (boolean)false, (boolean)true, (RenderPipeline)VvVvnNUnvuvV, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
    }

    record cursorVal(String key, List<class_243> path, class_243 landingPos, class_243 blockRenderPos, class_238 targetBox, int ticks, class_1297 hitEntity, class_3965 blockHit, String ownerName, class_2960 icon, boolean isPreAim) {
        cursorVal withRenderState(List<class_243> list, class_243 class_2432, class_243 class_2433, class_238 class_2382) {
            return new cursorVal(this.key, list, class_2432, class_2433, class_2382, this.ticks, this.hitEntity, this.blockHit, this.ownerName, this.icon, this.isPreAim);
        }

        static String resolveOwnerName(class_1676 class_16762) {
            class_1297 class_12972 = class_16762.method_24921();
            if (class_12972 instanceof class_1657) {
                class_1657 class_16572 = (class_1657)class_12972;
                return class_16572.method_5477().getString();
            }
            return "Unknown";
        }
    }

    record WildClient(double speed, double gravity, float pitchOffset, boolean applyPhysicsBeforeMove) {
    }
}

