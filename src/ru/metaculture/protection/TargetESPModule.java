/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.pipeline.BlendFunction
 *  com.mojang.blaze3d.pipeline.RenderPipeline
 *  com.mojang.blaze3d.pipeline.RenderPipeline$Snippet
 *  com.mojang.blaze3d.platform.DepthTestFunction
 *  com.mojang.blaze3d.vertex.VertexFormat$class_5596
 *  net.minecraft.class_10799
 *  net.minecraft.class_1297
 *  net.minecraft.class_1309
 *  net.minecraft.class_1921
 *  net.minecraft.class_1921$class_4688
 *  net.minecraft.class_238
 *  net.minecraft.class_243
 *  net.minecraft.class_290
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_4608
 *  net.minecraft.class_4668$class_4683
 *  net.minecraft.class_4668$class_5939
 *  net.minecraft.class_7833
 *  org.joml.Matrix4f
 *  org.joml.Quaternionfc
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.platform.DepthTestFunction;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;
import net.minecraft.class_10799;
import net.minecraft.class_1297;
import net.minecraft.class_1309;
import net.minecraft.class_1921;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_4608;
import net.minecraft.class_4668;
import net.minecraft.class_7833;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.NvVNvUvunNNu;
import ru.metaculture.protection.RenderHudEvent;
import ru.metaculture.protection.AnimatedFloat;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.UuvVnuU;
import ru.metaculture.protection.ModeSetting;
import ru.metaculture.protection.EaseInOutQuadAnim;
import ru.metaculture.protection.NeumorphicThemeRenderer;
import ru.metaculture.protection.VnNnNnvuvn;
import ru.metaculture.protection.ColorUtil;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.Easing;
import ru.metaculture.protection.RenderWorldEvent;
import ru.metaculture.protection.ShaderPresetSetting;
import ru.metaculture.protection.VertexBufferPool;
import ru.metaculture.protection.EntityFramebufferCapture;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.ShapeRendererUtil;
import ru.metaculture.protection.AnimatedValue;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.AnimDirection;
import ru.metaculture.protection.ThemeTargetProvider;
import ru.metaculture.protection.ThemeSettingSync;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.TriggerBotModule;

@ModuleRegister(primaryVal="TargetESP", secondaryVal="Jozky target ESP", tertiaryVal=ModuleCategory.Visuals)
public class TargetESPModule
extends Module
implements ThemeTargetProvider {
    private static final String extraRef = "target_esp";
    public static ModeSetting countVal = new ModeSetting("Texture", "Image", "Image", "Ghosts", "Ring", "Cubes", "Sphere");
    public static ModeSetting depthVal;
    public static ModeSetting descRef;
    public static ModeSetting activeVal;
    public static ShaderPresetSetting radiusVal;
    private static final class_2960 phaseVal;
    private static final class_2960 limitRef;
    private static final class_2960 paramRef;
    private static final class_2960 groupVal;
    private static final class_2960 layerVal;
    public static AnimatedValue factorVal;
    public static AnimatedValue sourceVal;
    private class_1309 slotVal = null;
    private final Predicate<class_1297> themeVal = class_12972 -> class_12972 == AttackAuraModule.tokenVal || class_12972 == this.slotVal;
    private static long stageVal;
    private float widthRef = 0.0f;
    private long trackVal = 0L;
    private final ArrayList<WildClient> modeRef = new ArrayList();
    private static long angleVal;
    static float heightRef;
    private static final long levelVal = 1000L;
    private static final int UuNnnVnuNNV = 1;
    private static final float depthRef = 0.02f;
    private static final int speedRef = 50;
    private float countRef = 0.0f;
    private static final int entryVal = 1024;
    private static final String guardVal = "wild";
    private static final RenderPipeline VUuuVUnun;
    private static final RenderPipeline vVVuuVVv;
    private static final class_1921 VuunNUUUvu;
    private static final class_1921 NNUUNUuVNNVn;
    private static final class_1921 VvVvnNUnvuvV;
    private static final class_1921 tokenVal;
    private static final class_1921 NUVvUUVuVNVv;
    private static final RenderPipeline nodeB;
    private static final RenderPipeline UNvvunVVn;
    private static final class_1921 UnvuVuVnNuvu;
    private static final class_1921 UvNNVUVNVuvV;
    private static final RenderPipeline NnunUUnU;
    private static final class_1921 nvuVvuNnNUnv;
    private static final RenderPipeline nodeF;
    private static final RenderPipeline nodeH;
    private static final class_1921 OCOocoOoOO;
    private static final RenderPipeline o0Ooc0COOoc;
    static final class_1921 twigB;
    private static final RenderPipeline UnUUVuVunvVu;
    static final class_1921 twigC;

    public TargetESPModule() {
        Setting[] nvUuvVvuuNArray = new Setting[5];
        nvUuvVvuuNArray[0] = countVal;
        nvUuvVvuuNArray[1] = depthVal;
        nvUuvVvuuNArray[2] = descRef;
        nvUuvVvuuNArray[3] = activeVal;
        nvUuvVvuuNArray[4] = radiusVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public SurfaceTarget tertiaryVal() {
        return SurfaceTarget.ESP;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public String marginVal() {
        String string = TargetESPModule.blockRef();
        if (string == null) return null;
        if (string.isBlank()) {
            return null;
        }
        String string2 = string;
        return string2;
    }

    public static String blockRef() {
        String string = radiusVal == null ? "" : radiusVal.blockRef();
        return string == null ? "" : string;
    }

    @Override
    public boolean weightVal() {
        return true;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        ThemeSettingSync.primaryVal().primaryVal(this, (ThemeTargetProvider)this);
        this.holderVal();
    }

    @Override
    public void onDisable() {
        EntityFramebufferCapture.primaryVal().primaryVal(extraRef);
        ThemeSettingSync.primaryVal().primaryVal(this);
        this.modeRef.clear();
        super.onDisable();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Subscribe
    public void primaryVal(RenderWorldEvent vvuuvuVVvvn) {
        block22: {
            block21: {
                block20: {
                    ThemeSettingSync.primaryVal().secondaryVal(this, (ThemeTargetProvider)this);
                    this.holderVal();
                    factorVal.primaryVal();
                    class_1309 class_13092 = AttackAuraModule.tokenVal != null ? AttackAuraModule.tokenVal : TriggerBotModule.blockRef();
                    if (TargetESPModule.mc.field_1687 == null || TargetESPModule.mc.field_1724 == null) {
                        return;
                    }
                    AttackAuraModule coreB = (AttackAuraModule)ru.metaculture.protection.WildClient.primaryVal.secondaryVal.secondaryVal(AttackAuraModule.class);
                    if (coreB == null) {
                        return;
                    }
                    factorVal.primaryVal(class_13092 == null ? 0.0 : 1.0, (double)0.35f, Easing.timerVal);
                    if (!(factorVal.chunkVal() > 0.0)) break block21;
                    if (class_13092 != null) {
                        if (this.slotVal != class_13092) {
                            stageVal = 0L;
                            this.trackVal = 0L;
                            this.widthRef = 0.0f;
                        }
                        this.slotVal = class_13092;
                    }
                    if (this.slotVal == null || countVal.secondaryVal("Don't display")) break block22;
                    class_4597.class_4598 class_45982 = VertexBufferPool.primaryVal();
                    try {
                        if (countVal.secondaryVal("Image") && descRef.secondaryVal("Diamond Shape")) {
                            this.primaryVal(vvuuvuVVvvn.tertiaryVal(), class_45982, this.slotVal, vvuuvuVVvvn.marginVal());
                        }
                        if (countVal.secondaryVal("Image") && descRef.secondaryVal("Client")) {
                            this.secondaryVal(vvuuvuVVvvn.tertiaryVal(), class_45982, this.slotVal, vvuuvuVVvvn.marginVal());
                        }
                        if (countVal.secondaryVal("Image") && descRef.secondaryVal("Diamond Shape 2")) {
                            this.tertiaryVal(vvuuvuVVvvn.tertiaryVal(), class_45982, this.slotVal, vvuuvuVVvvn.marginVal());
                        }
                        if (countVal.secondaryVal("Ghosts") && depthVal.secondaryVal("Normal")) {
                            this.chunkVal(vvuuvuVVvvn.tertiaryVal(), class_45982, this.slotVal, vvuuvuVVvvn.marginVal());
                        }
                        if (countVal.secondaryVal("Ghosts")) {
                            if (depthVal.secondaryVal("New")) {
                                this.weightVal(vvuuvuVVvvn.tertiaryVal(), class_45982, this.slotVal, vvuuvuVVvvn.marginVal());
                            }
                        }
                        if (countVal.secondaryVal("Ghosts") && depthVal.secondaryVal("Old")) {
                            this.paramVal(vvuuvuVVvvn.tertiaryVal(), class_45982, this.slotVal, vvuuvuVVvvn.marginVal());
                        }
                        if (countVal.secondaryVal("Ghosts") && depthVal.secondaryVal("Orbit")) {
                            this.extraVal(vvuuvuVVvvn.tertiaryVal(), class_45982, this.slotVal, vvuuvuVVvvn.marginVal());
                        }
                        if (countVal.secondaryVal("Ghosts")) {
                            if (depthVal.secondaryVal("Spiral")) {
                                this.limitVal(vvuuvuVVvvn.tertiaryVal(), class_45982, this.slotVal, vvuuvuVVvvn.marginVal());
                            }
                        }
                        if (countVal.secondaryVal("Ring")) {
                            this.marginVal(vvuuvuVVvvn.tertiaryVal(), class_45982, this.slotVal, vvuuvuVVvvn.marginVal());
                        }
                        if (countVal.secondaryVal("Cubes") && activeVal.secondaryVal("New")) {
                            this.blockRef(vvuuvuVVvvn.tertiaryVal(), class_45982, this.slotVal, vvuuvuVVvvn.marginVal());
                        }
                        if (countVal.secondaryVal("Cubes") && activeVal.secondaryVal("Old")) {
                            this.holderVal(vvuuvuVVvvn.tertiaryVal(), class_45982, this.slotVal, vvuuvuVVvvn.marginVal());
                        }
                        if (countVal.secondaryVal("Cubes") && activeVal.secondaryVal("Orbit")) {
                            this.speedVal(vvuuvuVVvvn.tertiaryVal(), class_45982, this.slotVal, vvuuvuVVvvn.marginVal());
                        }
                        if (!countVal.secondaryVal("Sphere")) break block20;
                        this.widthVal(vvuuvuVVvvn.tertiaryVal(), class_45982, this.slotVal, vvuuvuVVvvn.marginVal());
                    }
                    catch (Throwable throwable) {
                        VertexBufferPool.secondaryVal();
                        throw throwable;
                    }
                }
                VertexBufferPool.secondaryVal();
                break block22;
            }
            this.slotVal = null;
            stageVal = 0L;
            this.trackVal = 0L;
            this.widthRef = 0.0f;
            this.modeRef.clear();
        }
    }

    @Subscribe
    public void primaryVal(RenderHudEvent partD) {
        String string;
        block13: {
            block12: {
                block11: {
                    block10: {
                        if (TargetESPModule.mc.field_1687 == null) break block10;
                        if (TargetESPModule.mc.field_1724 != null && partD != null && partD.tertiaryVal() != null) break block11;
                    }
                    return;
                }
                string = TargetESPModule.blockRef();
                if (string.isBlank()) break block12;
                if (this.slotVal != null && !(factorVal.chunkVal() <= (double)0.001f)) break block13;
            }
            return;
        }
        float f = partD.tertiaryVal().method_61966().method_60636();
        cursorVal panelVal = this.primaryVal(this.slotVal, f, partD.paramVal(), partD.extraVal());
        if (panelVal == null) {
            return;
        }
        Renderer2D heightVal = partD.marginVal();
        if (heightVal != null) {
            heightVal.tertiaryVal();
        }
        float f2 = (float)Math.min(0.92, factorVal.chunkVal() * 0.78);
        float f3 = panelVal.x + panelVal.w * 0.5f;
        float f4 = panelVal.y + panelVal.h * 0.5f;
        int n = EntityFramebufferCapture.primaryVal().marginVal();
        boolean bl = NeumorphicThemeRenderer.primaryVal(string, n, panelVal.x, panelVal.y, panelVal.w, panelVal.h, partD.paramVal(), partD.extraVal(), f3, f4, TargetESPModule.timerVal(), f2);
        if (bl) {
            if (heightVal != null) {
                heightVal.tertiaryVal();
            }
        }
    }

    private void holderVal() {
        EntityFramebufferCapture.primaryVal().primaryVal(extraRef, this.enabled && !TargetESPModule.blockRef().isBlank(), this.themeVal);
    }

    private cursorVal primaryVal(class_1309 class_13092, float f, int n, int n2) {
        if (class_13092 == null || class_13092.method_31481() || n <= 1 || n2 <= 1 || TargetESPModule.mc.field_1773 == null || TargetESPModule.mc.field_1773.method_19418() == null) {
            return null;
        }
        class_243 class_2432 = class_13092.method_30950(f);
        class_243 class_2433 = class_13092.method_19538();
        class_238 class_2383 = class_13092.method_5829().method_989(class_2432.field_1352 - class_2433.field_1352, class_2432.field_1351 - class_2433.field_1351, class_2432.field_1350 - class_2433.field_1350).method_1009(0.05, Math.max(0.05, (double)class_13092.method_17682() * 0.035), 0.05);
        float f2 = Float.POSITIVE_INFINITY;
        float f3 = Float.POSITIVE_INFINITY;
        float f4 = Float.NEGATIVE_INFINITY;
        float f5 = Float.NEGATIVE_INFINITY;
        for (int i = 0; i < 2; ++i) {
            double d = i == 0 ? class_2383.field_1323 : class_2383.field_1320;
            for (int j = 0; j < 2; ++j) {
                double d2 = j == 0 ? class_2383.field_1322 : class_2383.field_1325;
                for (int k = 0; k < 2; ++k) {
                    double d3 = k == 0 ? class_2383.field_1321 : class_2383.field_1324;
                    class_243 class_2434 = VnNnNnvuvn.primaryVal(new class_243(d, d2, d3));
                    if (class_2434 == null || class_2434.field_1350 <= (double)0.001f || class_2434.field_1350 > 1.0) {
                        return null;
                    }
                    f2 = Math.min(f2, (float)class_2434.field_1352);
                    f3 = Math.min(f3, (float)class_2434.field_1351);
                    f4 = Math.max(f4, (float)class_2434.field_1352);
                    f5 = Math.max(f5, (float)class_2434.field_1351);
                }
            }
        }
        if (!(Float.isFinite(f2) && Float.isFinite(f3) && Float.isFinite(f4) && Float.isFinite(f5))) {
            return null;
        }
        if (f4 < 0.0f || f5 < 0.0f || f2 > (float)n || f3 > (float)n2) {
            return null;
        }
        float f6 = Math.max(1.0f, f4 - f2);
        float f7 = Math.max(1.0f, f5 - f3);
        float f8 = Math.min(96.0f, Math.max(18.0f, f6 * 0.28f));
        float f9 = Math.min(96.0f, Math.max(18.0f, f7 * 0.18f));
        float f10 = Math.max(0.0f, f2 - f8);
        float f11 = Math.max(0.0f, f3 - f9);
        float f12 = Math.min((float)n, f4 + f8);
        float f13 = Math.min((float)n2, f5 + f9);
        float f14 = f12 - f10;
        float f15 = f13 - f11;
        return f14 > 2.0f && f15 > 2.0f ? new cursorVal(f10, f11, f14, f15) : null;
    }

    private static ThemePalette timerVal() {
        NvVNvUvunNNu nvVNvUvunNNu = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null ? ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal() : NvVNvUvunNNu.WILD;
        return ThemePalette.primaryVal(nvVNvUvunNNu, NeumorphicThemeRenderer.marginVal());
    }

    private void primaryVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_1309 class_13092, float f) {
        class_243 class_2432 = class_13092.method_30950(f);
        double d = class_2432.field_1352;
        double d2 = class_2432.field_1351;
        double d3 = class_2432.field_1350;
        class_243 class_2433 = TargetESPModule.mc.field_1773.method_19418().method_19326();
        class_45872.method_22903();
        class_45872.method_22904(d - class_2433.field_1352, d2 - class_2433.field_1351 + (double)(class_13092.method_17682() / 1.75f), d3 - class_2433.field_1350);
        class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(-TargetESPModule.mc.field_1773.method_19418().method_19330()));
        class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(TargetESPModule.mc.field_1773.method_19418().method_19329()));
        long l = System.currentTimeMillis();
        float f2 = (float)VnNnNnvuvn.marginVal(0.0, 720.0, (Math.sin((double)l / 900.0) + 1.0) / 2.0 * 360.0 * 2.0);
        class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(f2));
        sourceVal.primaryVal();
        int n = class_13092.field_6235;
        float f3 = (float)Math.sin((double)n * 0.15707963267948966);
        sourceVal.primaryVal((double)f3, (double)0.4f, Easing.timerVal);
        float f4 = sourceVal.weightVal();
        float f5 = (float)factorVal.chunkVal();
        int n2 = ColorUtil.tertiaryVal(200, 70, 70, (int)(255.0f * f5));
        int n3 = ColorUtil.weightVal(ColorUtil.tertiaryVal(ColorUtil.primaryVal(), f5), n2, sourceVal.weightVal());
        float f6 = 1.7f - 0.9f * f5 + (0.35f - 0.35f * f4);
        class_45872.method_22905(f6, f6, 1.0f);
        class_1921 class_19212 = VuunNUUUvu;
        Matrix4f matrix4f = class_45872.method_23760().method_23761();
        class_4588 class_45882 = class_45982.getBuffer(class_19212);
        TargetESPModule.primaryVal(class_45882, matrix4f, n3, (int)(255.0f * f5));
        class_45872.method_22909();
    }

    private void secondaryVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_1309 class_13092, float f) {
        class_243 class_2432 = class_13092.method_30950(f);
        double d = class_2432.field_1352;
        double d2 = class_2432.field_1351;
        double d3 = class_2432.field_1350;
        class_243 class_2433 = TargetESPModule.mc.field_1773.method_19418().method_19326();
        class_45872.method_22903();
        class_45872.method_22904(d - class_2433.field_1352, d2 - class_2433.field_1351 + (double)(class_13092.method_17682() / 1.75f), d3 - class_2433.field_1350);
        class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(-TargetESPModule.mc.field_1773.method_19418().method_19330()));
        class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(TargetESPModule.mc.field_1773.method_19418().method_19329()));
        long l = System.currentTimeMillis();
        float f2 = (float)VnNnNnvuvn.marginVal(0.0, 720.0, (Math.sin((double)l / 1600.0) + 1.0) / 2.0 * 360.0 * 2.0);
        class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(f2));
        sourceVal.primaryVal();
        int n = class_13092.field_6235;
        float f3 = (float)Math.sin((double)n * 0.15707963267948966);
        sourceVal.primaryVal((double)f3, (double)0.4f, Easing.timerVal);
        float f4 = sourceVal.weightVal();
        float f5 = (float)factorVal.chunkVal();
        int n2 = ColorUtil.tertiaryVal(200, 70, 70, (int)(255.0f * f5));
        int n3 = ColorUtil.weightVal(ColorUtil.tertiaryVal(ColorUtil.primaryVal(), f5), n2, sourceVal.weightVal());
        float f6 = 1.5f - 0.9f * f5 + (0.35f - 0.35f * f4);
        class_45872.method_22905(f6, f6, 1.0f);
        class_1921 class_19212 = NNUUNUuVNNVn;
        Matrix4f matrix4f = class_45872.method_23760().method_23761();
        class_4588 class_45882 = class_45982.getBuffer(class_19212);
        TargetESPModule.primaryVal(class_45882, matrix4f, n3, (int)(255.0f * f5));
        class_45872.method_22909();
    }

    private void tertiaryVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_1309 class_13092, float f) {
        class_243 class_2432 = class_13092.method_30950(f);
        double d = class_2432.field_1352;
        double d2 = class_2432.field_1351;
        double d3 = class_2432.field_1350;
        class_243 class_2433 = TargetESPModule.mc.field_1773.method_19418().method_19326();
        class_45872.method_22903();
        class_45872.method_22904(d - class_2433.field_1352, d2 - class_2433.field_1351 + (double)(class_13092.method_17682() / 1.75f), d3 - class_2433.field_1350);
        class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(-TargetESPModule.mc.field_1773.method_19418().method_19330()));
        class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(TargetESPModule.mc.field_1773.method_19418().method_19329()));
        long l = System.currentTimeMillis();
        float f2 = (float)VnNnNnvuvn.marginVal(0.0, 720.0, (Math.sin((double)l / 1000.0) + 1.0) / 2.0 * 360.0 * 2.0);
        class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(f2));
        sourceVal.primaryVal();
        int n = class_13092.field_6235;
        float f3 = (float)Math.sin((double)n * 0.15707963267948966);
        sourceVal.primaryVal((double)f3, (double)0.4f, Easing.timerVal);
        float f4 = sourceVal.weightVal();
        float f5 = (float)factorVal.chunkVal();
        int n2 = ColorUtil.tertiaryVal(200, 70, 70, (int)(255.0f * f5));
        int n3 = ColorUtil.weightVal(ColorUtil.tertiaryVal(ColorUtil.primaryVal(), f5), n2, sourceVal.weightVal());
        float f6 = 1.25f - 0.6f * f5 + (0.35f - 0.35f * f4);
        class_45872.method_22905(f6, f6, 1.0f);
        class_1921 class_19212 = VvVvnNUnvuvV;
        Matrix4f matrix4f = class_45872.method_23760().method_23761();
        class_4588 class_45882 = class_45982.getBuffer(class_19212);
        TargetESPModule.primaryVal(class_45882, matrix4f, n3, (int)(255.0f * f5));
        class_45872.method_22909();
    }

    private void marginVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_1309 class_13092, float f) {
        int n;
        float f2;
        if (class_13092 == null) {
            return;
        }
        class_243 class_2432 = TargetESPModule.mc.field_1773.method_19418().method_19326();
        double d = class_13092.field_6038 + (class_13092.method_23317() - class_13092.field_6038) * (double)f;
        double d2 = class_13092.field_5971 + (class_13092.method_23318() - class_13092.field_5971) * (double)f;
        double d3 = class_13092.field_5989 + (class_13092.method_23321() - class_13092.field_5989) * (double)f;
        class_45872.method_22903();
        class_45872.method_22904(d - class_2432.field_1352, d2 - class_2432.field_1351, d3 - class_2432.field_1350);
        float f3 = (float)factorVal.chunkVal();
        float f4 = class_13092.method_17682();
        double d4 = class_13092.method_17681() * 1.0f - 0.2f * sourceVal.weightVal();
        int n2 = ColorUtil.tertiaryVal(200, 70, 70, (int)(255.0f * f3));
        sourceVal.primaryVal();
        int n3 = class_13092.field_6235;
        float f5 = (float)Math.sin((double)n3 * 0.15707963267948966);
        sourceVal.primaryVal((double)f5, (double)0.4f, Easing.timerVal);
        Matrix4f matrix4f = class_45872.method_23760().method_23761();
        double d5 = 1800.0;
        double d6 = (double)System.currentTimeMillis() % d5;
        boolean bl = d6 > d5 / 2.0;
        double d7 = d6 / (d5 / 2.0);
        d7 = bl ? d7 - 1.0 : 1.0 - d7;
        d7 = d7 < 0.5 ? 2.0 * d7 * d7 : 1.0 - Math.pow(-2.0 * d7 + 2.0, 2.0) / 2.0;
        double d8 = (double)(f4 / 1.25f) * (d7 > 0.5 ? 1.0 - d7 : d7) * (double)(bl ? -1 : 1);
        class_4588 class_45882 = class_45982.getBuffer(UnvuVuVnNuvu);
        for (int i = 0; i <= 360; i += 5) {
            double d9 = Math.toRadians(i);
            float f6 = (float)(Math.cos(d9) * d4);
            f2 = (float)(Math.sin(d9) * d4);
            int n4 = ColorUtil.weightVal(ColorUtil.tertiaryVal(ColorUtil.secondaryVal(ColorUtil.weightVal(ColorUtil.primaryVal(), 0.5f), ColorUtil.weightVal(ColorUtil.primaryVal(), 1.0f), i * 4, 1), f3), n2, sourceVal.weightVal());
            n = n4 >> 16 & 0xFF;
            int n5 = n4 >> 8 & 0xFF;
            int n6 = n4 & 0xFF;
            class_45882.method_22918(matrix4f, f6, (float)((double)f4 * d7), f2).method_1336(n, n5, n6, (int)(180.0f * f3));
            class_45882.method_22918(matrix4f, f6, (float)((double)f4 * d7 + d8), f2).method_1336(n, n5, n6, 0);
        }
        class_4588 class_45883 = class_45982.getBuffer(UvNNVUVNVuvV);
        for (int i = 0; i <= 360; i += 5) {
            double d10 = Math.toRadians(i);
            f2 = (float)(Math.cos(d10) * d4);
            float f7 = (float)(Math.sin(d10) * d4);
            n = ColorUtil.weightVal(ColorUtil.tertiaryVal(ColorUtil.secondaryVal(ColorUtil.weightVal(ColorUtil.primaryVal(), 0.5f), ColorUtil.weightVal(ColorUtil.primaryVal(), 1.0f), i * 4, 1), f3), n2, sourceVal.weightVal());
            class_45883.method_22918(matrix4f, f2, (float)((double)f4 * d7), f7).method_39415(ColorUtil.weightVal(n, (int)(255.0f * f3)));
        }
        class_45872.method_22909();
    }

    private void weightVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_1309 class_13092, float f) {
        if (class_13092 == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (this.trackVal == 0L) {
            this.trackVal = l;
        }
        long l2 = l - this.trackVal;
        if (l2 > 0L) {
            this.widthRef += (float)(5L * l2) / 900.0f;
        }
        this.trackVal = l;
        class_243 class_2432 = class_13092.method_30950(f);
        class_243 class_2433 = TargetESPModule.mc.field_1773.method_19418().method_19326();
        double d = class_2432.field_1352 - class_2433.field_1352;
        double d2 = class_2432.field_1351 - class_2433.field_1351;
        double d3 = class_2432.field_1350 - class_2433.field_1350;
        float f2 = (float)factorVal.chunkVal();
        sourceVal.primaryVal();
        int n = class_13092.field_6235;
        float f3 = (float)Math.sin((double)n * 0.15707963267948966);
        sourceVal.primaryVal((double)f3, (double)0.4f, Easing.timerVal);
        float f4 = sourceVal.weightVal();
        int n2 = ColorUtil.primaryVal();
        int n3 = ColorUtil.tertiaryVal(200, 70, 70, (int)(255.0f * f2));
        int n4 = ColorUtil.weightVal(ColorUtil.tertiaryVal(n2, f2), n3, f4);
        class_1921 class_19212 = tokenVal;
        int n5 = 3;
        int n6 = 12;
        int n7 = 3 * n5;
        class_45872.method_22903();
        class_4184 class_41842 = TargetESPModule.mc.field_1773.method_19418();
        for (int i = 0; i < n7; i += n5) {
            for (int j = 0; j < n6; ++j) {
                float f5 = this.widthRef + (float)j * 0.1f;
                float f6 = 0.75f;
                float f7 = 0.5f;
                int n8 = (int)Math.pow(i, 2.0);
                class_45872.method_22903();
                double d4 = d + (double)f6 * Math.sin(f5 + (float)n8);
                double d5 = d2 + (double)f7 + (double)0.3f * Math.sin(this.widthRef + (float)j * 0.2f) + (double)(0.2f * (float)i);
                double d6 = d3 + (double)f6 * Math.cos(f5 - (float)n8);
                class_45872.method_22904(d4, d5, d6);
                float f8 = 0.005f + (float)j / 2000.0f;
                class_45872.method_22905(f8, f8, f8);
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(-class_41842.method_19330()));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(class_41842.method_19329()));
                Matrix4f matrix4f = class_45872.method_23760().method_23761();
                class_4588 class_45882 = class_45982.getBuffer(class_19212);
                int n9 = n4;
                int n10 = n9 >> 16 & 0xFF;
                int n11 = n9 >> 8 & 0xFF;
                int n12 = n9 & 0xFF;
                int n13 = (int)(f2 * 255.0f);
                int n14 = -25;
                int n15 = 50;
                class_45882.method_22918(matrix4f, (float)n14, (float)(n14 + n15), 0.0f).method_1336(n10, n11, n12, n13).method_22913(0.0f, 1.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
                class_45882.method_22918(matrix4f, (float)(n14 + n15), (float)(n14 + n15), 0.0f).method_1336(n10, n11, n12, n13).method_22913(1.0f, 1.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
                class_45882.method_22918(matrix4f, (float)(n14 + n15), (float)n14, 0.0f).method_1336(n10, n11, n12, n13).method_22913(1.0f, 0.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
                class_45882.method_22918(matrix4f, (float)n14, (float)n14, 0.0f).method_1336(n10, n11, n12, n13).method_22913(0.0f, 0.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
                class_45872.method_22909();
            }
        }
        class_45872.method_22909();
    }

    private void paramVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_1309 class_13092, float f) {
        long l;
        if (class_13092 == null) {
            return;
        }
        long l2 = System.currentTimeMillis();
        if (this.trackVal == 0L) {
            this.trackVal = l2;
        }
        if ((l = l2 - this.trackVal) > 0L) {
            this.widthRef += (float)(5L * l) / 200.0f;
        }
        this.trackVal = l2;
        class_243 class_2432 = class_13092.method_30950(f);
        class_243 class_2433 = TargetESPModule.mc.field_1773.method_19418().method_19326();
        double d = class_2432.field_1352 - class_2433.field_1352;
        double d2 = class_2432.field_1351 + (double)1.1f - class_2433.field_1351;
        double d3 = class_2432.field_1350 - class_2433.field_1350;
        float f2 = (float)factorVal.chunkVal();
        class_1921 class_19212 = tokenVal;
        int n = 17;
        int n2 = 6;
        float f3 = 1.25f;
        float f4 = 1.1f;
        float f5 = this.widthRef;
        class_4184 class_41842 = TargetESPModule.mc.field_1773.method_19418();
        double d4 = class_13092.method_17681() + 0.12f;
        boolean bl = TargetESPModule.mc.field_1724.method_6057((class_1297)class_13092);
        class_4588 class_45882 = class_45982.getBuffer(class_19212);
        sourceVal.primaryVal();
        int n3 = class_13092.field_6235;
        float f6 = (float)Math.sin((double)n3 * 0.15707963267948966);
        sourceVal.primaryVal((double)f6, (double)0.4f, Easing.timerVal);
        float f7 = sourceVal.weightVal();
        int n4 = TargetESPModule.primaryVal(255, f7);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j <= n; ++j) {
                double d5 = Math.toRadians((((float)j / 1.5f + f5) * (float)n2 + (float)(i * 120)) % (float)(n2 * 360));
                double d6 = Math.sin(Math.toRadians(f5 * 2.0f + (float)(j * (i + 1))) * (double)f4) / (double)f3;
                float f8 = (float)j / (float)n;
                class_45872.method_22903();
                class_45872.method_22904(d + Math.cos(d5) * d4, d2 + d6, d3 + Math.sin(d5) * d4);
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(-class_41842.method_19330()));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(class_41842.method_19329()));
                Matrix4f matrix4f = class_45872.method_23760().method_23761();
                int n5 = TargetESPModule.primaryVal(n4, (int)(255.0f * f8 * f2));
                int n6 = n5 >> 16 & 0xFF;
                int n7 = n5 >> 8 & 0xFF;
                int n8 = n5 & 0xFF;
                int n9 = n5 >> 24 & 0xFF;
                float f9 = Math.max(0.25f * f8, 0.22f);
                class_45882.method_22918(matrix4f, -f9, f9, 0.0f).method_1336(n6, n7, n8, n9).method_22913(0.0f, 1.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
                class_45882.method_22918(matrix4f, f9, f9, 0.0f).method_1336(n6, n7, n8, n9).method_22913(1.0f, 1.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
                class_45882.method_22918(matrix4f, f9, -f9, 0.0f).method_1336(n6, n7, n8, n9).method_22913(1.0f, 0.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
                class_45882.method_22918(matrix4f, -f9, -f9, 0.0f).method_1336(n6, n7, n8, n9).method_22913(0.0f, 0.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
                class_45872.method_22909();
            }
        }
    }

    private static float anchorVal() {
        return (float)(System.currentTimeMillis() % 1000000L) / 1000.0f;
    }

    private float primaryVal(class_1309 class_13092) {
        sourceVal.primaryVal();
        int n = class_13092.field_6235;
        float f = (float)Math.sin((double)n * 0.15707963267948966);
        sourceVal.primaryVal((double)f, (double)0.4f, Easing.timerVal);
        return sourceVal.weightVal();
    }

    private void primaryVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_4184 class_41842, class_1921 class_19212, double d, double d2, double d3, float f, int n, int n2) {
        if (n2 <= 0) {
            return;
        }
        class_45872.method_22903();
        class_45872.method_22904(d, d2, d3);
        class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(-class_41842.method_19330()));
        class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(class_41842.method_19329()));
        class_45872.method_22905(f, f, f);
        TargetESPModule.primaryVal(class_45982.getBuffer(class_19212), class_45872.method_23760().method_23761(), n, n2);
        class_45872.method_22909();
    }

    private void extraVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_1309 class_13092, float f) {
        if (class_13092 == null) {
            return;
        }
        class_4184 class_41842 = TargetESPModule.mc.field_1773.method_19418();
        class_243 class_2432 = class_41842.method_19326();
        class_243 class_2433 = class_13092.method_30950(f);
        float f2 = (float)factorVal.chunkVal();
        float f3 = this.primaryVal(class_13092);
        int n = TargetESPModule.primaryVal(255, f3) & 0xFFFFFF;
        double d = class_2433.field_1352 - class_2432.field_1352;
        double d2 = class_2433.field_1350 - class_2432.field_1350;
        double d3 = class_2433.field_1351 - class_2432.field_1351 + (double)class_13092.method_17682() * 0.5;
        double d4 = (double)class_13092.method_17681() / 2.0 + 0.5;
        double d5 = (double)class_13092.method_17682() * 0.18;
        int n2 = 16;
        float f4 = TargetESPModule.anchorVal();
        for (int i = 0; i < n2; ++i) {
            double d6 = Math.PI * 2 / (double)n2 * (double)i + (double)f4 * 1.4;
            double d7 = d + Math.cos(d6) * d4;
            double d8 = d2 + Math.sin(d6) * d4;
            double d9 = d3 + Math.sin((double)f4 * 2.2 + (double)i * 0.6) * d5;
            float f5 = 0.55f + 0.45f * (float)Math.sin((double)f4 * 2.0 + (double)i);
            int n3 = (int)(215.0f * f2 * f5);
            float f6 = 0.3f + 0.06f * (float)Math.sin((double)f4 * 3.0 + (double)i);
            this.primaryVal(class_45872, class_45982, class_41842, tokenVal, d7, d9, d8, f6, n, n3);
        }
    }

    private void limitVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_1309 class_13092, float f) {
        if (class_13092 == null) {
            return;
        }
        class_4184 class_41842 = TargetESPModule.mc.field_1773.method_19418();
        class_243 class_2432 = class_41842.method_19326();
        class_243 class_2433 = class_13092.method_30950(f);
        float f2 = (float)factorVal.chunkVal();
        float f3 = this.primaryVal(class_13092);
        int n = TargetESPModule.primaryVal(255, f3) & 0xFFFFFF;
        double d = class_2433.field_1352 - class_2432.field_1352;
        double d2 = class_2433.field_1350 - class_2432.field_1350;
        double d3 = class_2433.field_1351 - class_2432.field_1351 - 0.1;
        double d4 = (double)class_13092.method_17681() / 2.0 + 0.32;
        double d5 = (double)class_13092.method_17682() + 0.2;
        double d6 = 2.5;
        int n2 = 18;
        float f4 = TargetESPModule.anchorVal();
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j <= n2; ++j) {
                double d7 = (double)j / (double)n2;
                double d8 = d7 * d6 * Math.PI * 2.0 + (double)f4 * 2.0 + (double)i * Math.PI;
                double d9 = d + Math.cos(d8) * d4;
                double d10 = d2 + Math.sin(d8) * d4;
                double d11 = d3 + d7 * d5;
                int n3 = (int)((double)(220.0f * f2) * (0.3 + 0.7 * Math.sin(d7 * Math.PI)));
                this.primaryVal(class_45872, class_45982, class_41842, tokenVal, d9, d11, d10, 0.24f, n, n3);
            }
        }
    }

    private void speedVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_1309 class_13092, float f) {
        if (class_13092 == null) {
            return;
        }
        class_4184 class_41842 = TargetESPModule.mc.field_1773.method_19418();
        class_243 class_2432 = class_41842.method_19326();
        class_243 class_2433 = class_13092.method_30950(f);
        float f2 = (float)factorVal.chunkVal();
        float f3 = this.primaryVal(class_13092);
        int n = TargetESPModule.primaryVal(255, f3) & 0xFFFFFF;
        double d = class_2433.field_1352 - class_2432.field_1352;
        double d2 = class_2433.field_1350 - class_2432.field_1350;
        double d3 = class_2433.field_1351 - class_2432.field_1351 + (double)class_13092.method_17682() * 0.5;
        double d4 = (double)class_13092.method_17681() / 2.0 + 0.55;
        int n2 = 14;
        float f4 = TargetESPModule.anchorVal();
        for (int i = 0; i < n2; ++i) {
            double d5 = Math.PI * 2 / (double)n2 * (double)i + (double)f4 * 1.1;
            double d6 = d + Math.cos(d5) * d4;
            double d7 = d2 + Math.sin(d5) * d4;
            double d8 = d3 + Math.sin((double)f4 * 2.0 + (double)i) * 0.12;
            class_45872.method_22903();
            class_45872.method_22904(d6, d8, d7);
            class_45872.method_22903();
            float f5 = (f4 * 50.0f + (float)i * 28.0f) % 360.0f;
            class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(f5));
            class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f5 * 0.7f));
            Matrix4f matrix4f = class_45872.method_23760().method_23761();
            float f6 = 0.16f + 0.02f * (float)Math.sin((double)f4 * 3.0 + (double)i);
            ShapeRendererUtil.WildClient.Box.primaryVal(class_45982.getBuffer(twigB), matrix4f, TargetESPModule.primaryVal(n, (int)(70.0f * f2)), f6);
            ShapeRendererUtil.WildClient.Box.secondaryVal(class_45982.getBuffer(twigC), matrix4f, TargetESPModule.primaryVal(n, (int)(230.0f * f2)), f6);
            class_45872.method_22909();
            class_45872.method_22903();
            class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(-class_41842.method_19330()));
            class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(class_41842.method_19329()));
            float f7 = f6 * 2.4f;
            class_45872.method_22905(f7, f7, f7);
            TargetESPModule.primaryVal(class_45982.getBuffer(NUVvUUVuVNVv), class_45872.method_23760().method_23761(), n, (int)(60.0f * f2));
            class_45872.method_22909();
            class_45872.method_22909();
        }
    }

    private void widthVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_1309 class_13092, float f) {
        if (class_13092 == null) {
            return;
        }
        class_4184 class_41842 = TargetESPModule.mc.field_1773.method_19418();
        class_243 class_2432 = class_41842.method_19326();
        class_243 class_2433 = class_13092.method_30950(f);
        float f2 = (float)factorVal.chunkVal();
        float f3 = this.primaryVal(class_13092);
        int n = TargetESPModule.primaryVal(TargetESPModule.primaryVal(255, f3) & 0xFFFFFF, (int)(220.0f * f2));
        double d = class_2433.field_1352 - class_2432.field_1352;
        double d2 = class_2433.field_1351 - class_2432.field_1351 + (double)class_13092.method_17682() * 0.5;
        double d3 = class_2433.field_1350 - class_2432.field_1350;
        float f4 = (float)(Math.max((double)class_13092.method_17681(), (double)class_13092.method_17682() * 0.5) * 0.72 + 0.3 + (double)f3 * 0.2);
        float f5 = TargetESPModule.anchorVal();
        class_45872.method_22903();
        class_45872.method_22904(d, d2, d3);
        class_45872.method_22903();
        class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(f5 * 38.0f));
        TargetESPModule.primaryVal(class_45982.getBuffer(twigC), class_45872.method_23760().method_23761(), f4, 40, n);
        class_45872.method_22909();
        class_45872.method_22903();
        class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(f5 * 30.0f));
        class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(90.0f));
        TargetESPModule.primaryVal(class_45982.getBuffer(twigC), class_45872.method_23760().method_23761(), f4, 40, n);
        class_45872.method_22909();
        class_45872.method_22903();
        class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f5 * 26.0f + 90.0f));
        class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(90.0f));
        TargetESPModule.primaryVal(class_45982.getBuffer(twigC), class_45872.method_23760().method_23761(), f4, 40, n);
        class_45872.method_22909();
        class_45872.method_22909();
    }

    private static void primaryVal(class_4588 class_45882, Matrix4f matrix4f, float f, int n, int n2) {
        int n3 = n2 >> 16 & 0xFF;
        int n4 = n2 >> 8 & 0xFF;
        int n5 = n2 & 0xFF;
        int n6 = n2 >>> 24 & 0xFF;
        for (int i = 0; i < n; ++i) {
            double d = Math.PI * 2 / (double)n * (double)i;
            double d2 = Math.PI * 2 / (double)n * (double)(i + 1);
            class_45882.method_22918(matrix4f, (float)(Math.cos(d) * (double)f), 0.0f, (float)(Math.sin(d) * (double)f)).method_1336(n3, n4, n5, n6);
            class_45882.method_22918(matrix4f, (float)(Math.cos(d2) * (double)f), 0.0f, (float)(Math.sin(d2) * (double)f)).method_1336(n3, n4, n5, n6);
        }
    }

    static void primaryVal(class_4588 class_45882, Matrix4f matrix4f, int n, int n2) {
        int n3 = n >> 16 & 0xFF;
        int n4 = n >> 8 & 0xFF;
        int n5 = n & 0xFF;
        class_45882.method_22918(matrix4f, -0.5f, -0.5f, 0.0f).method_1336(n3, n4, n5, n2).method_22913(0.0f, 1.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
        class_45882.method_22918(matrix4f, 0.5f, -0.5f, 0.0f).method_1336(n3, n4, n5, n2).method_22913(1.0f, 1.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
        class_45882.method_22918(matrix4f, 0.5f, 0.5f, 0.0f).method_1336(n3, n4, n5, n2).method_22913(1.0f, 0.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
        class_45882.method_22918(matrix4f, -0.5f, 0.5f, 0.0f).method_1336(n3, n4, n5, n2).method_22913(0.0f, 0.0f).method_22922(class_4608.field_21444).method_60803(0xF000F0).method_22914(0.0f, 0.0f, 1.0f);
    }

    private static class_1921 primaryVal(class_2960 class_29602, RenderPipeline renderPipeline) {
        return class_1921.method_24049((String)class_29602.toString(), (int)1024, (boolean)false, (boolean)true, (RenderPipeline)renderPipeline, (class_1921.class_4688)class_1921.class_4688.method_23598().method_34577((class_4668.class_5939)new class_4668.class_4683(class_29602, false)).method_23617(false));
    }

    private static int primaryVal(int n, float f) {
        int n2 = 6061311;
        try {
            NvVNvUvunNNu nvVNvUvunNNu;
            nvVNvUvunNNu = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null ? ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal() : NvVNvUvunNNu.WILD;
            if (nvVNvUvunNNu == NvVNvUvunNNu.CUSTOM && ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal != null) {
                n2 = ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal.limitVal() & 0xFFFFFF;
            } else if (nvVNvUvunNNu != null && nvVNvUvunNNu.primaryVal() != null) {
                n2 = nvVNvUvunNNu.primaryVal().getRGB() & 0xFFFFFF;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        float f2 = f < 0.0f ? 0.0f : Math.min(f, 1.0f);
        int n3 = n2 >> 16 & 0xFF;
        int n4 = n2 >> 8 & 0xFF;
        int n5 = n2 & 0xFF;
        int n6 = Math.round((float)n3 + (float)(235 - n3) * f2);
        int n7 = Math.round((float)n4 + (float)(70 - n4) * f2);
        int n8 = Math.round((float)n5 + (float)(70 - n5) * f2);
        int n9 = Math.max(0, Math.min(255, n));
        return n9 << 24 | n6 << 16 | n7 << 8 | n8;
    }

    static int primaryVal(int n, int n2) {
        return Math.max(0, Math.min(255, n2)) << 24 | n & 0xFFFFFF;
    }

    private void chunkVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_1309 class_13092, float f) {
        Matrix4f matrix4f;
        float f2;
        float f3;
        float f4;
        double d;
        double d2;
        double d3;
        double d4;
        int n;
        int n2;
        class_310 class_3102 = class_310.method_1551();
        if (class_13092 == null) {
            return;
        }
        double d5 = 0.3 + (double)(class_13092.method_17681() / 2.0f);
        sourceVal.primaryVal();
        int n3 = class_13092.field_6235;
        float f5 = (float)Math.sin((double)n3 * 0.15707963267948966);
        sourceVal.primaryVal((double)f5, (double)0.4f, Easing.timerVal);
        float f6 = sourceVal.weightVal();
        float f7 = 30.0f;
        float f8 = 0.4f - 0.1f * f6;
        double d6 = 6 - (int)(1.0f * f6);
        int n4 = 40 - (int)(12.0f * f6);
        class_243 class_2432 = class_3102.field_1773.method_19418().method_19326();
        class_4184 class_41842 = class_3102.field_1773.method_19418();
        if (stageVal == 0L) {
            stageVal = System.currentTimeMillis();
        }
        long l = System.currentTimeMillis();
        class_243 class_2433 = class_13092.method_30950(f);
        class_2433 = new class_243(class_2433.field_1352, class_2433.field_1351 + 0.32 + (double)(class_13092.method_17682() / 2.0f), class_2433.field_1350);
        double d7 = class_2433.field_1352 + 0.2;
        double d8 = class_2433.field_1351;
        double d9 = class_2433.field_1350;
        class_1921 class_19212 = tokenVal;
        class_4588 class_45882 = class_45982.getBuffer(class_19212);
        float f9 = (float)factorVal.chunkVal();
        int n5 = n2 = TargetESPModule.primaryVal((int)(255.0f * f9), f6);
        int n6 = TargetESPModule.primaryVal(n2, (int)(210.0f * f9));
        int n7 = TargetESPModule.primaryVal(n2, (int)(150.0f * f9));
        int n8 = TargetESPModule.primaryVal(n2, (int)(90.0f * f9));
        class_45872.method_22903();
        class_45872.method_22904(d7 - class_2432.field_1352, d8 - class_2432.field_1351, d9 - class_2432.field_1350);
        float f10 = 0.3f;
        for (n = 0; n < n4; ++n) {
            d4 = (double)0.05f * ((double)(l - stageVal) - (double)n * d6) / (double)f7;
            d3 = Math.sin(d4 * Math.PI) * d5;
            d2 = Math.cos(d4 * Math.PI) * d5;
            d = Math.cos(d4 * Math.PI) * d5;
            f4 = (float)n / (float)(n4 - 1);
            f3 = 1.0f - f4 * f10;
            f2 = f8 * f3;
            class_45872.method_22903();
            class_45872.method_22904(d3, d, -d2);
            class_45872.method_46416(-f2 / 2.0f, -f2 / 2.0f, 0.0f);
            class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(-class_41842.method_19330()));
            class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(class_41842.method_19329()));
            class_45872.method_46416(f2 / 2.0f, f2 / 2.0f, 0.0f);
            matrix4f = class_45872.method_23760().method_23761();
            this.primaryVal(class_45882, matrix4f, n5, n6, n7, n8, f2);
            class_45872.method_22909();
        }
        for (n = 0; n < n4; ++n) {
            d4 = (double)0.05f * ((double)(l - stageVal) - (double)n * d6) / (double)f7;
            d3 = Math.sin(d4 * Math.PI) * d5;
            d2 = Math.cos(d4 * Math.PI) * d5;
            d = Math.sin(d4 * Math.PI) * d5;
            f4 = (float)n / (float)(n4 - 1);
            f3 = 1.0f - f4 * f10;
            f2 = f8 * f3;
            class_45872.method_22903();
            class_45872.method_22904(-d3, d, -d2);
            class_45872.method_46416(-f2 / 2.0f, -f2 / 2.0f, 0.0f);
            class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(-class_41842.method_19330()));
            class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(class_41842.method_19329()));
            class_45872.method_46416(f2 / 2.0f, f2 / 2.0f, 0.0f);
            matrix4f = class_45872.method_23760().method_23761();
            this.primaryVal(class_45882, matrix4f, n5, n6, n7, n8, f2);
            class_45872.method_22909();
        }
        for (n = 0; n < n4; ++n) {
            d4 = (double)0.05f * ((double)(l - stageVal) - (double)n * d6) / (double)f7;
            d3 = Math.sin(d4 * Math.PI) * d5;
            d2 = Math.cos(d4 * Math.PI) * d5;
            d = Math.sin(d4 * Math.PI) * d5;
            f4 = (float)n / (float)(n4 - 1);
            f3 = 1.0f - f4 * f10;
            f2 = f8 * f3;
            class_45872.method_22903();
            class_45872.method_22904(d3, d, d2);
            class_45872.method_46416(-f2 / 2.0f, -f2 / 2.0f, 0.0f);
            class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(-class_41842.method_19330()));
            class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(class_41842.method_19329()));
            class_45872.method_46416(f2 / 2.0f, f2 / 2.0f, 0.0f);
            matrix4f = class_45872.method_23760().method_23761();
            this.primaryVal(class_45882, matrix4f, n5, n6, n7, n8, f2);
            class_45872.method_22909();
        }
        class_45872.method_22909();
    }

    private void primaryVal(class_4588 class_45882, Matrix4f matrix4f, int n, int n2, int n3, int n4, float f) {
        int n5 = n >> 16 & 0xFF;
        int n6 = n >> 8 & 0xFF;
        int n7 = n & 0xFF;
        int n8 = n >> 24 & 0xFF;
        int n9 = n2 >> 16 & 0xFF;
        int n10 = n2 >> 8 & 0xFF;
        int n11 = n2 & 0xFF;
        int n12 = n2 >> 24 & 0xFF;
        int n13 = n3 >> 16 & 0xFF;
        int n14 = n3 >> 8 & 0xFF;
        int n15 = n3 & 0xFF;
        int n16 = n3 >> 24 & 0xFF;
        int n17 = n4 >> 16 & 0xFF;
        int n18 = n4 >> 8 & 0xFF;
        int n19 = n4 & 0xFF;
        int n20 = n4 >> 24 & 0xFF;
        class_45882.method_22918(matrix4f, 0.0f, -f, 0.0f).method_22913(0.0f, 0.0f).method_1336(n5, n6, n7, n8);
        class_45882.method_22918(matrix4f, -f, -f, 0.0f).method_22913(0.0f, 1.0f).method_1336(n9, n10, n11, n12);
        class_45882.method_22918(matrix4f, -f, 0.0f, 0.0f).method_22913(1.0f, 1.0f).method_1336(n13, n14, n15, n16);
        class_45882.method_22918(matrix4f, 0.0f, 0.0f, 0.0f).method_22913(1.0f, 0.0f).method_1336(n17, n18, n19, n20);
    }

    private void blockRef(class_4587 class_45872, class_4597.class_4598 class_45982, class_1309 class_13092, float f) {
        if (class_13092 == null) {
            return;
        }
        class_243 class_2432 = TargetESPModule.mc.field_1773.method_19418().method_19326();
        long l = System.currentTimeMillis();
        int n = 24;
        double d = 0.4 + (double)(class_13092.method_17681() / 2.0f) + (double)0.35f - (double)(0.35f * factorVal.weightVal());
        double d2 = class_13092.method_17682();
        class_243 class_2433 = class_13092.method_30950(f);
        float f2 = (float)factorVal.chunkVal();
        sourceVal.primaryVal();
        int n2 = class_13092.field_6235;
        float f3 = (float)Math.sin((double)n2 * 0.15707963267948966);
        sourceVal.primaryVal((double)f3, (double)0.4f, Easing.timerVal);
        float f4 = sourceVal.weightVal();
        int n3 = TargetESPModule.primaryVal(Math.round(70.0f * f2), f4);
        int n4 = TargetESPModule.primaryVal(Math.round(225.0f * f2), f4);
        int n5 = TargetESPModule.primaryVal(255, f4);
        for (int i = 0; i < n; ++i) {
            double d3 = Math.sin((double)i * 132.12 + 4.12);
            double d4 = Math.cos((double)i * 453.21 + 1.23);
            double d5 = Math.sin((double)i * 789.34 + 9.87);
            double d6 = d;
            double d7 = 1.0;
            double d8 = Math.PI * 2 / (double)n * (double)i;
            double d9 = (double)l / 6000.0 * (Math.PI * 2) * d7;
            double d10 = d9 + d8;
            double d11 = Math.cos(d10) * d6;
            double d12 = Math.sin(d10) * d6;
            double d13 = 1.0 + d3 * 0.2;
            double d14 = d8 + d5 * 2.0;
            double d15 = Math.sin((double)l / 9000.0 * (Math.PI * 2) * d13 + d14) * 0.45 + 0.55;
            double d16 = d15 * d2;
            double d17 = class_2433.field_1352 + d11 - class_2432.field_1352;
            double d18 = class_2433.field_1351 + d16 - class_2432.field_1351;
            double d19 = class_2433.field_1350 + d12 - class_2432.field_1350;
            class_45872.method_22903();
            class_45872.method_22904(d17, d18, d19);
            float f5 = 1.0f + 0.15f * (float)Math.sin((double)l / 400.0 + (double)i * 1.5);
            float f6 = 0.19f * f5;
            double d20 = (double)f4 * (0.5 + 0.5 * Math.sin((double)i * 123.45));
            if (d20 > 0.05) {
                f6 = (float)((double)f6 * (1.0 - d20 * 0.2));
                double d21 = d20 * 0.4;
                class_45872.method_22904(Math.cos(d10) * d21, 0.0, Math.sin(d10) * d21);
            }
            class_45872.method_22903();
            float f7 = 12000.0f + (float)d5 * 2000.0f;
            float f8 = (float)(l % (long)Math.abs(f7)) / Math.abs(f7) * 360.0f;
            if (i % 3 == 0) {
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(f8));
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f8));
            } else if (i % 3 == 1) {
                class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(f8));
                class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(f8));
            } else {
                class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f8));
                class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees(f8));
            }
            class_4588 class_45882 = class_45982.getBuffer(twigB);
            Matrix4f matrix4f = class_45872.method_23760().method_23761();
            ShapeRendererUtil.WildClient.Box.primaryVal(class_45882, matrix4f, n3, f6);
            class_4588 class_45883 = class_45982.getBuffer(twigC);
            ShapeRendererUtil.WildClient.Box.secondaryVal(class_45883, matrix4f, n4, f6);
            class_45872.method_22909();
            class_45872.method_22903();
            class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(-TargetESPModule.mc.field_1773.method_19418().method_19330()));
            class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(TargetESPModule.mc.field_1773.method_19418().method_19329()));
            class_4588 class_45884 = class_45982.getBuffer(NUVvUUVuVNVv);
            Matrix4f matrix4f2 = class_45872.method_23760().method_23761();
            float f9 = f6 * 2.0f;
            class_45872.method_22905(f9, f9, f9);
            TargetESPModule.primaryVal(class_45884, matrix4f2, n5, (int)(70.0f * f2));
            class_45872.method_22909();
            class_45872.method_22909();
        }
    }

    private void holderVal(class_4587 class_45872, class_4597.class_4598 class_45982, class_1309 class_13092, float f) {
        if (class_13092 == null) {
            this.modeRef.clear();
            return;
        }
        Iterator<WildClient> iterator = this.modeRef.iterator();
        while (iterator.hasNext()) {
            WildClient modeVal = iterator.next();
            if (modeVal.blockRef.paramVal() == AnimDirection.FORWARDS || !(modeVal.blockRef.speedVal() <= 0.0f)) continue;
            iterator.remove();
        }
        long l = System.currentTimeMillis();
        heightRef = Math.max(0.001f, Math.min(0.1f, (float)(l - angleVal) / 1000.0f));
        angleVal = l;
        if (this.modeRef.size() < 50) {
            this.countRef += heightRef;
            while (this.countRef >= 0.02f && this.modeRef.size() < 50) {
                this.countRef -= 0.02f;
                for (int i = 0; i < 1 && this.modeRef.size() < 50; ++i) {
                    double d = UuvVnuU.primaryVal(0.0f, 360.0f);
                    double d2 = Math.cos(d * Math.PI / 180.0) * (double)0.7f;
                    double d3 = UuvVnuU.blockRef(0.04f, 0.2f);
                    double d4 = Math.sin(d * Math.PI / 180.0) * (double)0.7f;
                    this.modeRef.add(new WildClient(class_13092, d2, d3, d4));
                }
            }
        }
        if (!this.modeRef.isEmpty()) {
            float f2 = (float)factorVal.chunkVal();
            sourceVal.primaryVal();
            int n = class_13092.field_6235;
            float f3 = (float)Math.sin((double)n * 0.15707963267948966);
            sourceVal.primaryVal((double)f3, (double)0.4f, Easing.timerVal);
            float f4 = sourceVal.weightVal();
            int n2 = TargetESPModule.primaryVal(255, f4);
            int n3 = TargetESPModule.primaryVal(255, f4);
            class_243 class_2432 = TargetESPModule.mc.field_1773.method_19418().method_19326();
            float f5 = TargetESPModule.mc.field_1773.method_19418().method_19329();
            float f6 = TargetESPModule.mc.field_1773.method_19418().method_19330();
            for (WildClient modeVal : this.modeRef) {
                modeVal.primaryVal(f);
                modeVal.primaryVal(class_45872, class_45982, n2, n3, f2, f4, f, class_2432, f5, f6, NUVvUUVuVNVv);
            }
        }
    }

    static {
        String[] stringArray = new String[5];
        stringArray[0] = "Normal";
        stringArray[1] = "New";
        stringArray[2] = "Old";
        stringArray[3] = "Orbit";
        stringArray[4] = "Spiral";
        depthVal = new ModeSetting("Ghost mode", "Normal", stringArray).primaryVal(() -> !countVal.secondaryVal("Ghosts"));
        String[] stringArray2 = new String[3];
        stringArray2[0] = "Client";
        stringArray2[1] = "Diamond Shape";
        stringArray2[2] = "Diamond Shape 2";
        descRef = new ModeSetting("Image mode", "Client", stringArray2).primaryVal(() -> !countVal.secondaryVal("Image"));
        String[] stringArray3 = new String[3];
        stringArray3[0] = "New";
        stringArray3[1] = "Old";
        stringArray3[2] = "Orbit";
        activeVal = new ModeSetting("Cube mode", "New", stringArray3).primaryVal(() -> !countVal.secondaryVal("Cubes"));
        radiusVal = new ShaderPresetSetting("Foundry Shader", SurfaceTarget.ESP);
        phaseVal = class_2960.method_60655((String)guardVal, (String)"textures/world/target.png");
        limitRef = class_2960.method_60655((String)guardVal, (String)"textures/world/targetn2.png");
        paramRef = class_2960.method_60655((String)guardVal, (String)"textures/world/targetn.png");
        groupVal = class_2960.method_60655((String)guardVal, (String)"textures/world/glow.png");
        layerVal = class_2960.method_60655((String)guardVal, (String)"textures/world/dashbloom.png");
        factorVal = new AnimatedValue();
        sourceVal = new AnimatedValue();
        stageVal = 0L;
        angleVal = System.currentTimeMillis();
        heightRef = 0.0f;
        VUuuVUnun = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56864}).withLocation(class_2960.method_60655((String)guardVal, (String)"pipeline/world/textured_quads")).withVertexFormat(class_290.field_1575, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        RenderPipeline.Snippet[] snippetArray = new RenderPipeline.Snippet[1];
        snippetArray[0] = class_10799.field_56864;
        vVVuuVVv = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])snippetArray).withLocation(class_2960.method_60655((String)guardVal, (String)"pipeline/world/textured_quads")).withVertexFormat(class_290.field_1575, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        VuunNUUUvu = TargetESPModule.primaryVal(phaseVal, vVVuuVVv);
        NNUUNUuVNNVn = TargetESPModule.primaryVal(paramRef, vVVuuVVv);
        VvVvnNUnvuvV = TargetESPModule.primaryVal(limitRef, vVVuuVVv);
        tokenVal = TargetESPModule.primaryVal(groupVal, VUuuVUnun);
        NUVvUUVuVNVv = TargetESPModule.primaryVal(layerVal, VUuuVUnun);
        nodeB = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)"minecraft", (String)"rendertype_lequal_depth_test")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27380).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        UNvvunVVn = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)"minecraft", (String)"rendertype_lines")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_29345).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        UnvuVuVnNuvu = class_1921.method_24049((String)"ring_strip", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)nodeB, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        UvNNVUVNVuvV = class_1921.method_24049((String)"ring_line", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)UNvvunVVn, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        NnunUUnU = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)guardVal, (String)"pipeline/world/color_quads")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        nvuVvuNnNUnv = class_1921.method_24049((String)"color_quads", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)NnunUUnU, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        nodeF = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)"minecraft", (String)"rendertype_lines")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27377).withCull(false).withDepthTestFunction(DepthTestFunction.NO_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        nodeH = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)guardVal, (String)"targetesp_cube_lines")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_29344).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.LIGHTNING).build());
        OCOocoOoOO = class_1921.method_24049((String)"targetesp_cube_lines", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)nodeH, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        o0Ooc0COOoc = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])new RenderPipeline.Snippet[]{class_10799.field_56860}).withLocation(class_2960.method_60655((String)guardVal, (String)"targetesp_cube_fill")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_27382).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).build());
        twigB = class_1921.method_24049((String)"targetesp_cube_fill", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)o0Ooc0COOoc, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
        RenderPipeline.Snippet[] snippetArray2 = new RenderPipeline.Snippet[1];
        snippetArray2[0] = class_10799.field_56860;
        UnUUVuVunvVu = class_10799.method_67887((RenderPipeline)RenderPipeline.builder((RenderPipeline.Snippet[])snippetArray2).withLocation(class_2960.method_60655((String)guardVal, (String)"targetesp_cube_outline")).withVertexFormat(class_290.field_1576, VertexFormat.class_5596.field_29344).withCull(false).withDepthTestFunction(DepthTestFunction.LEQUAL_DEPTH_TEST).withDepthWrite(false).withBlend(BlendFunction.TRANSLUCENT).build());
        twigC = class_1921.method_24049((String)"targetesp_cube_outline", (int)1024, (boolean)false, (boolean)true, (RenderPipeline)UnUUVuVunvVu, (class_1921.class_4688)class_1921.class_4688.method_23598().method_23617(false));
    }

    static final class cursorVal
     {
        final float x;
        final float y;
        final float w;
        final float h;

        cursorVal(float f, float f2, float f3, float f4) {
            this.x = f;
            this.y = f2;
            this.w = f3;
            this.h = f4;
        }

        @Override
        public final String toString() {
            return "nvnNNunvv[" + "x=" + this.x + ", " + "y=" + this.y + ", " + "w=" + this.w + ", " + "h=" + this.h + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.x, this.y, this.w, this.h);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            cursorVal that = (cursorVal)object;
            return java.util.Objects.equals(this.x, that.x) && java.util.Objects.equals(this.y, that.y) && java.util.Objects.equals(this.w, that.w) && java.util.Objects.equals(this.h, that.h);}

        public float x() {
            return this.x;
        }

        public float y() {
            return this.y;
        }

        public float w() {
            return this.w;
        }

        public float h() {
            return this.h;
        }
    }

    static class WildClient {
        double primaryVal;
        double secondaryVal;
        double tertiaryVal;
        double marginVal;
        double weightVal;
        double paramVal;
        double extraVal;
        double limitVal;
        double speedVal;
        long widthVal;
        class_1309 chunkVal;
        AnimatedFloat blockRef = new EaseInOutQuadAnim(500, 1.0);
        private double holderVal;

        public WildClient(class_1309 class_13092, double d, double d2, double d3) {
            this.primaryVal = d;
            this.secondaryVal = d2;
            this.tertiaryVal = d3;
            this.chunkVal = class_13092;
            this.widthVal = System.currentTimeMillis();
            this.holderVal = UuvVnuU.blockRef(0.01f, 0.04f);
        }

        public long primaryVal() {
            return this.widthVal;
        }

        public void primaryVal(float f) {
            long l = System.currentTimeMillis();
            long l2 = l - this.primaryVal();
            this.blockRef.secondaryVal(l2 <= 800L ? AnimDirection.FORWARDS : AnimDirection.BACKWARDS);
            this.secondaryVal += this.holderVal * (double)(heightRef * 60.0f);
            if (this.chunkVal != null) {
                class_243 class_2432 = this.chunkVal.method_30950(f);
                this.extraVal = this.primaryVal + class_2432.field_1352;
                this.limitVal = this.secondaryVal + class_2432.field_1351;
                this.speedVal = this.tertiaryVal + class_2432.field_1350;
            }
        }

        public void primaryVal(class_4587 class_45872, class_4597.class_4598 class_45982, int n, int n2, float f, float f2, float f3, class_243 class_2432, float f4, float f5, class_1921 class_19212) {
            long l = System.currentTimeMillis();
            double d = (double)(l - this.primaryVal()) / 10.0;
            double d2 = UuvVnuU.extraVal((double)0.2f);
            this.marginVal = UuvVnuU.tertiaryVal(this.marginVal, this.extraVal - class_2432.field_1352, d2);
            this.weightVal = UuvVnuU.tertiaryVal(this.weightVal, this.limitVal - class_2432.field_1351, d2);
            this.paramVal = UuvVnuU.tertiaryVal(this.paramVal, this.speedVal - class_2432.field_1350, d2);
            float f6 = this.blockRef.speedVal();
            if (f6 <= 0.0f) {
                return;
            }
            float f7 = 1.0f + 0.15f * (float)Math.sin((double)(l - this.primaryVal()) / 400.0);
            float f8 = 0.12f + 0.04f * f6;
            class_45872.method_22903();
            class_45872.method_22904(this.marginVal, this.weightVal, this.paramVal);
            class_45872.method_22903();
            class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees((float)d));
            class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees((float)d));
            class_45872.method_22907((Quaternionfc)class_7833.field_40718.rotationDegrees((float)d));
            Matrix4f matrix4f = class_45872.method_23760().method_23761();
            int n3 = TargetESPModule.primaryVal(n, (int)(70.0f * f * f6));
            class_4588 class_45882 = class_45982.getBuffer(twigB);
            ShapeRendererUtil.WildClient.Box.primaryVal(class_45882, matrix4f, n3, f8);
            int n4 = TargetESPModule.primaryVal(n, (int)(225.0f * f * f6));
            class_4588 class_45883 = class_45982.getBuffer(twigC);
            ShapeRendererUtil.WildClient.Box.secondaryVal(class_45883, matrix4f, n4, f8);
            class_45872.method_22909();
            class_45872.method_22903();
            class_45872.method_22907((Quaternionfc)class_7833.field_40716.rotationDegrees(-f5));
            class_45872.method_22907((Quaternionfc)class_7833.field_40714.rotationDegrees(f4));
            class_4588 class_45884 = class_45982.getBuffer(class_19212);
            Matrix4f matrix4f2 = class_45872.method_23760().method_23761();
            float f9 = f8 * 2.0f;
            class_45872.method_22905(f9, f9, f9);
            TargetESPModule.primaryVal(class_45884, matrix4f2, n2, (int)(70.0f * f * f6));
            class_45872.method_22909();
            class_45872.method_22909();
        }
    }
}

