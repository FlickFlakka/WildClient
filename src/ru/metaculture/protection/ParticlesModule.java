/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  lombok.Generated
 *  net.minecraft.class_10799
 *  net.minecraft.class_1297
 *  net.minecraft.class_1667
 *  net.minecraft.class_1684
 *  net.minecraft.class_1685
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_1922
 *  net.minecraft.class_2338
 *  net.minecraft.class_2338$class_2339
 *  net.minecraft.class_2374
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_265
 *  net.minecraft.class_290
 *  net.minecraft.class_2902$class_2903
 *  net.minecraft.class_2960
 *  net.minecraft.class_3532
 *  net.minecraft.class_4587
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_4608
 *  net.minecraft.class_4668$class_4683
 *  net.minecraft.class_4668$class_5939
 *  net.minecraft.class_5819
 *  net.minecraft.class_9799
 *  org.joml.Matrix3f
 *  org.joml.Matrix4f
 *  org.joml.Quaternionfc
 *  org.joml.Vector3f
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Generated;
import net.minecraft.class_10799;
import net.minecraft.class_1297;
import net.minecraft.class_1667;
import net.minecraft.class_1684;
import net.minecraft.class_1685;
import net.minecraft.class_1921;
import net.minecraft.class_1922;
import net.minecraft.class_2338;
import net.minecraft.class_2374;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_265;
import net.minecraft.class_290;
import net.minecraft.class_2902;
import net.minecraft.class_2960;
import net.minecraft.class_3532;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_4668;
import net.minecraft.class_5819;
import net.minecraft.class_9799;
import org.joml.Matrix3f;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.PlayerMovementEvent;
import ru.metaculture.protection.Cooldown;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.AnimatedDouble;
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.ColorSetting;
import ru.metaculture.protection.Easings;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.WorldJoinEvent;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.BlockBreakEvent;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="Particles", secondaryVal="Improved particles on attacks and throws", tertiaryVal=ModuleCategory.Visuals)
public class ParticlesModule
extends Module {
    public static SettingGroup countVal = new SettingGroup("Spawn on", new BoolSetting("Attack", true), new BoolSetting("Throw", true), new BoolSetting("In world", false));
    public static ModeSetting depthVal;
    public static FloatSetting descRef;
    public static FloatSetting activeVal;
    public static FloatSetting radiusVal;
    public static FloatSetting factorVal;
    public static BoolSetting sourceVal;
    public static ModeSetting extraRef;
    public static ColorSetting phaseVal;
    private static final int limitRef = 1024;
    private long paramRef = System.nanoTime();
    private static final String groupVal = "wild";
    private static final RenderPipeline layerVal;
    private static final Map<cursorVal, class_1921> slotVal;
    private final List<WildClient> themeVal = new ArrayList<WildClient>();
    private final List<WildClient> stageVal = new ArrayList<WildClient>();
    private final List<WildClient> widthRef = new ArrayList<WildClient>();
    private static final Vector3f trackVal;

    public ParticlesModule() {
        Setting[] nvUuvVvuuNArray = new Setting[9];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        nvUuvVvuuNArray[2] = extraRef;
        nvUuvVvuuNArray[3] = phaseVal;
        nvUuvVvuuNArray[4] = descRef;
        nvUuvVvuuNArray[5] = activeVal;
        nvUuvVvuuNArray[6] = radiusVal;
        nvUuvVvuuNArray[7] = factorVal;
        nvUuvVvuuNArray[8] = sourceVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    private void blockRef() {
        this.themeVal.clear();
        this.widthRef.clear();
        this.stageVal.clear();
    }

    private void primaryVal(List<WildClient> list, class_243 class_2432, class_243 class_2433) {
        float f = 0.05f + descRef.tertiaryVal() * 0.2f;
        int n = extraRef.secondaryVal("Custom") ? phaseVal.tertiaryVal().getRGB() : ColorUtil.activeVal(list.size() * 100);
        cursorVal panelVal = switch (depthVal.tertiaryVal()) {
            case "Heart" -> cursorVal.HEART;
            case "Star" -> cursorVal.STAR;
            case "Snow" -> cursorVal.SNOW;
            case "Bloom" -> cursorVal.BLOOM;
            case "Dollar" -> cursorVal.DOLLAR;
            case "Triangle" -> cursorVal.TRIANGLE;
            case "Sakura" -> cursorVal.SAKURA;
            case "Genshin" -> cursorVal.GEMINI;
            case "Rhombus" -> cursorVal.SIMS;
            default -> cursorVal.BLOOM;
        };
        list.add(new WildClient(panelVal, class_2432.method_1031(0.0, (double)f, 0.0), class_2433, list.size(), (int)VnNnNnvuvn.weightVal(VnNnNnvuvn.marginVal(0.0f, 360.0f), 15.0), n, f, 0.2f));
    }

    @Subscribe
    public void primaryVal(BlockBreakEvent coreG) {
        class_1297 class_12972 = coreG.tertiaryVal();
        float f = 6.0f;
        if (countVal.secondaryVal("Attack")) {
            int n = (int)activeVal.tertiaryVal();
            for (int i = 0; i < n; ++i) {
                this.primaryVal(this.themeVal, new class_243(class_12972.method_23317(), class_12972.method_23318() + (double)VnNnNnvuvn.marginVal(0.0f, class_12972.method_17682()), class_12972.method_23321()), new class_243((double)VnNnNnvuvn.marginVal(-f, f), (double)VnNnNnvuvn.marginVal(-f, f), (double)VnNnNnvuvn.marginVal(-f, f)));
            }
        }
    }

    @Subscribe
    public void primaryVal(PlayerMovementEvent raftH) {
        class_243 class_2432;
        if (countVal.secondaryVal("Throw")) {
            if (ParticlesModule.mc.field_1687 == null) {
                return;
            }
            Iterator iterator = ParticlesModule.mc.field_1687.method_18112().iterator();
            while (iterator.hasNext()) {
                boolean bl;
                class_1685 class_16852;
                class_1297 class_12972 = (class_1297)iterator.next();
                if (!(class_12972 instanceof class_1684) && !(class_12972 instanceof class_1667) && !(class_12972 instanceof class_1685) || class_12972 instanceof class_1685 && (class_16852 = (class_1685)class_12972).method_24828()) continue;
                boolean bl2 = bl = class_12972.field_6014 != class_12972.method_23317() || class_12972.field_6036 != class_12972.method_23318() || class_12972.field_5969 != class_12972.method_23321();
                if (!bl) continue;
                class_2432 = class_12972.method_19538();
                int n = Math.max(1, (int)(activeVal.tertiaryVal() / 10.0f));
                for (int i = 0; i < n; ++i) {
                    this.primaryVal(this.widthRef, new class_243(class_2432.field_1352 + class_3532.method_15366((class_5819)class_5819.method_43047(), (double)-0.2, (double)0.2), class_2432.field_1351 + class_3532.method_15366((class_5819)class_5819.method_43047(), (double)-0.2, (double)0.2), class_2432.field_1350 + class_3532.method_15366((class_5819)class_5819.method_43047(), (double)-0.2, (double)0.2)), new class_243(class_3532.method_15366((class_5819)class_5819.method_43047(), (double)-1.0, (double)1.0), class_3532.method_15366((class_5819)class_5819.method_43047(), (double)-0.3, (double)0.3), class_3532.method_15366((class_5819)class_5819.method_43047(), (double)-1.0, (double)1.0)));
                }
            }
        }
        if (countVal.secondaryVal("In world")) {
            if (ParticlesModule.mc.field_1687 == null || ParticlesModule.mc.field_1724 == null) {
                return;
            }
            int n = (int)factorVal.tertiaryVal();
            int n2 = Math.max(1, (int)(activeVal.tertiaryVal() / 2.0f));
            for (int i = 0; i < n2; ++i) {
                class_2432 = ParticlesModule.mc.field_1724.method_19538().method_1031((double)VnNnNnvuvn.marginVal(-n, n), 0.0, (double)VnNnNnvuvn.marginVal(-n, n));
                class_2338 class_23382 = ParticlesModule.mc.field_1687.method_8598(class_2902.class_2903.field_13197, class_2338.method_49638((class_2374)class_2432));
                double d = (float)class_23382.method_10263() + VnNnNnvuvn.marginVal(0.0f, 1.0f);
                double d2 = (float)class_23382.method_10260() + VnNnNnvuvn.marginVal(0.0f, 1.0f);
                double d3 = ParticlesModule.mc.field_1724.method_23318() + (double)VnNnNnvuvn.marginVal(ParticlesModule.mc.field_1724.method_17682(), n);
                class_243 class_2433 = new class_243(d, d3, d2);
                while (!ParticlesModule.mc.field_1687.method_22347(class_2338.method_49638((class_2374)class_2433))) {
                    if (!(class_2433.field_1351 < (double)ParticlesModule.mc.field_1687.method_31600())) break;
                    class_2433 = class_2433.method_1031(0.0, 1.0, 0.0);
                }
                this.primaryVal(this.stageVal, class_2433, new class_243(ParticlesModule.mc.field_1724.method_18798().field_1352 + (double)VnNnNnvuvn.marginVal(-2.0f, 2.0f), VnNnNnvuvn.secondaryVal(-0.2, 0.2), ParticlesModule.mc.field_1724.method_18798().field_1350 + (double)VnNnNnvuvn.marginVal(-2.0f, 2.0f)));
            }
        }
        long l = this.holderVal();
        this.primaryVal(this.themeVal, l);
        this.primaryVal(this.widthRef, l);
        this.primaryVal(this.stageVal, l);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        class_4587 class_45872 = vvuuvuVVvvn.tertiaryVal();
        class_243 class_2432 = ParticlesModule.mc.field_1773.method_19418().method_19326();
        long l = System.nanoTime();
        double d = (double)(l - this.paramRef) / 1.0E9;
        this.paramRef = l;
        class_9799 class_97992 = new class_9799(262144);
        class_4597.class_4598 class_45982 = class_4597.method_22991((class_9799)class_97992);
        try {
            long l2 = this.holderVal();
            long l3 = Math.min(400L, Math.max(100L, l2 / 5L));
            long l4 = Math.max(l3 + 1L, (long)((float)l2 * 0.62f));
            this.primaryVal(class_45872, class_45982, class_2432, this.themeVal, l3, l4, d);
            this.primaryVal(class_45872, class_45982, class_2432, this.widthRef, l3, l4, d);
            this.primaryVal(class_45872, class_45982, class_2432, this.stageVal, l3, l4, d);
            class_45982.method_22993();
        }
        finally {
            class_97992.close();
        }
    }

    private long holderVal() {
        return Math.max(250L, (long)(radiusVal.tertiaryVal() * 1000.0f));
    }

    private void primaryVal(List<WildClient> list, long l) {
        list.removeIf(modeVal -> modeVal.widthVal().primaryVal((double)l));
    }

    private void primaryVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_243 class_2432, List<WildClient> list, long l, long l2, double d) {
        if (list.isEmpty()) {
            return;
        }
        class_45872.method_22903();
        for (WildClient modeVal : list) {
            float f;
            int n;
            modeVal.primaryVal(sourceVal.tertiaryVal(), d);
            boolean bl = !modeVal.widthVal().primaryVal((double)l);
            boolean bl2 = modeVal.widthVal().primaryVal((double)l2);
            if (bl) {
                modeVal.chunkVal().primaryVal(1.0, 0.4, Easings.limitVal, true);
            } else if (bl2) {
                modeVal.chunkVal().primaryVal(0.0, 0.4, Easings.limitVal, true);
            }
            if (modeVal.countVal.secondaryVal()) {
                modeVal.countVal.primaryVal();
            }
            if ((n = (int)((f = modeVal.countVal.weightVal()) * 255.0f)) <= 0) continue;
            int n2 = ColorUtil.weightVal(modeVal.extraVal(), n);
            class_243 class_2433 = modeVal.tertiaryVal();
            this.primaryVal(class_45872, class_45982, modeVal, (float)class_2433.field_1352, (float)class_2433.field_1351, (float)class_2433.field_1350, modeVal.limitVal, n2, n);
        }
        class_45872.method_22909();
    }

    private void primaryVal(class_4587 class_45872, class_4597.class_4598 class_45982, WildClient modeVal, float f, float f2, float f3, float f4, int n, int n2) {
        class_45872.method_22903();
        Renderer2D.primaryVal(class_45872, f, f2, f3);
        class_45872.method_22907((Quaternionfc)ParticlesModule.mc.field_1773.method_19418().method_23767());
        class_1921 class_19212 = slotVal.computeIfAbsent(modeVal.secondaryVal(), panelVal -> {
            class_2960 class_29602 = panelVal.primaryVal();
            return class_1921.method_24049((String)class_29602.toString(), (int)1024, (boolean)false, (boolean)true, (RenderPipeline)layerVal, (class_1921.class_4688)class_1921.class_4688.method_23598().method_34577((class_4668.class_5939)new class_4668.class_4683(class_29602, false)).method_23617(false));
        });
        class_4587.class_4665 class_46652 = class_45872.method_23760();
        Matrix4f matrix4f = class_46652.method_23761();
        Matrix3f matrix3f = class_46652.method_23762();
        class_4588 class_45882 = class_45982.getBuffer(class_19212);
        this.primaryVal(class_45882, matrix4f, matrix3f, -f4, -f4, f4 * 2.0f, f4 * 2.0f, n, n2);
        if (modeVal.secondaryVal == cursorVal.BLOOM) {
            this.primaryVal(class_45882, matrix4f, matrix3f, -f4 / 2.0f, -f4 / 2.0f, f4, f4, n, n2);
        }
        class_45872.method_22909();
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, Matrix3f matrix3f, float f, float f2, float f3, float f4, int n, int n2) {
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        trackVal.set(0.0f, 0.0f, 1.0f);
        matrix3f.transform(trackVal);
        trackVal.normalize();
        float f5 = f;
        float f6 = f2;
        float f7 = f + f3;
        float f8 = f2 + f4;
        class_45882.method_22918(matrix4f, f5, f6, 0.0f).method_1336(n3, n4, n5, n2).method_22913(0.0f, 1.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(ParticlesModule.trackVal.x, ParticlesModule.trackVal.y, ParticlesModule.trackVal.z);
        class_45882.method_22918(matrix4f, f7, f6, 0.0f).method_1336(n3, n4, n5, n2).method_22913(1.0f, 1.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(ParticlesModule.trackVal.x, ParticlesModule.trackVal.y, ParticlesModule.trackVal.z);
        class_45882.method_22918(matrix4f, f7, f8, 0.0f).method_1336(n3, n4, n5, n2).method_22913(1.0f, 0.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(ParticlesModule.trackVal.x, ParticlesModule.trackVal.y, ParticlesModule.trackVal.z);
        class_45882.method_22918(matrix4f, f5, f8, 0.0f).method_1336(n3, n4, n5, n2).method_22913(0.0f, 0.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(ParticlesModule.trackVal.x, ParticlesModule.trackVal.y, ParticlesModule.trackVal.z);
    }

    @Override
    public void toggle() {
        super.toggle();
        this.blockRef();
    }

    @Subscribe
    public void primaryVal(WorldJoinEvent coOCCcooOcOO2) {
        this.blockRef();
    }

    static {
        String[] stringArray = new String[9];
        stringArray[0] = "Bloom";
        stringArray[1] = "Star";
        stringArray[2] = "Snow";
        stringArray[3] = "Heart";
        stringArray[4] = "Dollar";
        stringArray[5] = "Triangle";
        stringArray[6] = "Sakura";
        stringArray[7] = "Genshin";
        stringArray[8] = "Rhombus";
        depthVal = new ModeSetting("Particle type", "Bloom", stringArray);
        descRef = new FloatSetting("Size", 0.5f, 0.0f, 1.0f, 0.1f, false);
        activeVal = new FloatSetting("Amount", 10.0f, 10.0f, 100.0f, 10.0f, false);
        radiusVal = new FloatSetting("Lifetime", 2.0f, 0.5f, 10.0f, 0.5f, false);
        factorVal = new FloatSetting("World radius", 12.0f, 2.0f, 50.0f, 1.0f, false);
        sourceVal = new BoolSetting("Physics", true);
        extraRef = new ModeSetting("Color mode", "Client-side", "Client-side", "Custom");
        phaseVal = new ColorSetting("Custom color", 15.0f, 1.0f, 1.0f).secondaryVal(() -> !extraRef.secondaryVal("Custom"));
        layerVal = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56864}).withLocation(class_2960.method_60655((String)groupVal, (String)"pipeline/world/textured_quads")).withVertexFormat(class_290.field_1575, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        slotVal = new ConcurrentHashMap<cursorVal, class_1921>();
        trackVal = new Vector3f(0.0f, 0.0f, 1.0f);
    }

    public enum cursorVal {
    HEART("heart", false),
    STAR("star", false),
    SNOW("snowflake", false),
    BLOOM("firefly", false),
    DOLLAR("dollar", false),
    TRIANGLE("triangle", false),
    SAKURA("sakura", false),
    GEMINI("genshin", false),
    SIMS("rhombus", false);
        private final class_2960 primaryVal;
        private final boolean secondaryVal;
    private cursorVal(String string2, boolean bl) {
            this.primaryVal = class_2960.method_60655((String)ParticlesModule.groupVal, (String)("textures/world/" + string2 + ".png"));
            this.secondaryVal = bl;
        }

        @Generated
        public class_2960 primaryVal() {
            return this.primaryVal;
        }

        @Generated
        public boolean secondaryVal() {
            return this.secondaryVal;
        }}

    public static class WildClient {
        private class_238 primaryVal;
        final cursorVal secondaryVal;
        private class_243 tertiaryVal;
        private class_243 marginVal;
        private final int weightVal;
        private final int paramVal;
        private final int extraVal;
        final float limitVal;
        private static final double speedVal = 0.05;
        private static final double widthVal = 0.0035;
        private static final double chunkVal = 0.985;
        private static final double blockRef = 0.55;
        private static final double holderVal = 0.72;
        private static final double timerVal = 0.003;
        private static final double anchorVal = 1.0E-6;
        private final double weightRef;
        private final Cooldown bufferVal = new Cooldown();
        final AnimatedDouble countVal = new AnimatedDouble();

        public WildClient(cursorVal panelVal, class_243 class_2432, class_243 class_2433, int n, int n2, int n3, float f, double d) {
            double d2 = (double)f / 2.0;
            this.primaryVal = new class_238(new class_243(class_2432.field_1352 - d2, class_2432.field_1351 - d2, class_2432.field_1350 - d2), new class_243(class_2432.field_1352 + d2, class_2432.field_1351 + d2, class_2432.field_1350 + d2));
            this.secondaryVal = panelVal;
            this.tertiaryVal = class_2432;
            this.marginVal = class_2433.method_1021(0.05);
            this.weightVal = n;
            this.paramVal = n2;
            this.extraVal = n3;
            this.limitVal = f;
            this.weightRef = d;
            this.bufferVal.primaryVal();
        }

        public void primaryVal(boolean bl, double d) {
            double d2 = d * 60.0 * this.weightRef;
            if (bl && Module.mc.field_1687 != null) {
                this.marginVal = this.marginVal.method_1021(Math.pow(0.985, d * 60.0)).method_1023(0.0, 0.0035 * d * 60.0, 0.0);
                this.primaryVal(this.marginVal.field_1352 * d2, 0);
                this.primaryVal(this.marginVal.field_1351 * d2, 1);
                this.primaryVal(this.marginVal.field_1350 * d2, 2);
                return;
            }
            this.tertiaryVal = this.tertiaryVal.method_1019(this.marginVal.method_1021(d2));
            this.blockRef();
        }

        private void primaryVal(double d, int n) {
            class_238 class_2383;
            if (Math.abs(d) <= 1.0E-6) {
                return;
            }
            switch (n) {
                case 0: {
                    class_2383 = this.primaryVal.method_989(d, 0.0, 0.0);
                    break;
                }
                case 1: {
                    class_2383 = this.primaryVal.method_989(0.0, d, 0.0);
                    break;
                }
                default: {
                    class_2383 = this.primaryVal.method_989(0.0, 0.0, d);
                }
            }
            if (this.primaryVal(class_2383)) {
                this.primaryVal(n);
                return;
            }
            this.primaryVal = class_2383;
            this.tertiaryVal = switch (n) {
                case 0 -> this.tertiaryVal.method_1031(d, 0.0, 0.0);
                case 1 -> this.tertiaryVal.method_1031(0.0, d, 0.0);
                default -> this.tertiaryVal.method_1031(0.0, 0.0, d);
            };
        }

        private void primaryVal(int n) {
            double d = this.marginVal.field_1352;
            double d2 = this.marginVal.field_1351;
            double d3 = this.marginVal.field_1350;
            switch (n) {
                case 0: {
                    d = -d * 0.55;
                    break;
                }
                case 1: {
                    if (d2 < 0.0) {
                        d *= 0.72;
                        d3 *= 0.72;
                    }
                    d2 = -d2 * 0.55;
                    break;
                }
                default: {
                    d3 = -d3 * 0.55;
                }
            }
            this.marginVal = new class_243(this.primaryVal(d), this.primaryVal(d2), this.primaryVal(d3));
        }

        private double primaryVal(double d) {
            return Math.abs(d) < 0.003 ? 0.0 : d;
        }

        private boolean primaryVal(class_238 class_2383) {
            int n = class_3532.method_15357((double)(class_2383.field_1323 + 1.0E-6));
            int n2 = class_3532.method_15357((double)(class_2383.field_1322 + 1.0E-6));
            int n3 = class_3532.method_15357((double)(class_2383.field_1321 + 1.0E-6));
            int n4 = class_3532.method_15357((double)(class_2383.field_1320 - 1.0E-6));
            int n5 = class_3532.method_15357((double)(class_2383.field_1325 - 1.0E-6));
            int n6 = class_3532.method_15357((double)(class_2383.field_1324 - 1.0E-6));
            class_2338.class_2339 class_23392 = new class_2338.class_2339();
            for (int i = n; i <= n4; ++i) {
                for (int j = n2; j <= n5; ++j) {
                    for (int k = n3; k <= n6; ++k) {
                        class_23392.method_10103(i, j, k);
                        class_265 class_2652 = Module.mc.field_1687.method_8320((class_2338)class_23392).method_26220((class_1922)Module.mc.field_1687, (class_2338)class_23392);
                        if (class_2652.method_1110()) continue;
                        for (class_238 class_2384 : class_2652.method_1090()) {
                            if (!class_2383.method_994(class_2384.method_989((double)i, (double)j, (double)k))) continue;
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private void blockRef() {
            double d = (double)this.limitVal / 2.0;
            this.primaryVal = new class_238(new class_243(this.tertiaryVal.field_1352 - d, this.tertiaryVal.field_1351 - d, this.tertiaryVal.field_1350 - d), new class_243(this.tertiaryVal.field_1352 + d, this.tertiaryVal.field_1351 + d, this.tertiaryVal.field_1350 + d));
        }

        @Generated
        public class_238 primaryVal() {
            return this.primaryVal;
        }

        @Generated
        public cursorVal secondaryVal() {
            return this.secondaryVal;
        }

        @Generated
        public class_243 tertiaryVal() {
            return this.tertiaryVal;
        }

        @Generated
        public class_243 marginVal() {
            return this.marginVal;
        }

        @Generated
        public int weightVal() {
            return this.weightVal;
        }

        @Generated
        public int paramVal() {
            return this.paramVal;
        }

        @Generated
        public int extraVal() {
            return this.extraVal;
        }

        @Generated
        public float limitVal() {
            return this.limitVal;
        }

        @Generated
        public double speedVal() {
            return this.weightRef;
        }

        @Generated
        public Cooldown widthVal() {
            return this.bufferVal;
        }

        @Generated
        public AnimatedDouble chunkVal() {
            return this.countVal;
        }
    }
}

