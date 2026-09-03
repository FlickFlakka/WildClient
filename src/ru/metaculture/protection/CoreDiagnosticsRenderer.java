/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import net.minecraft.class_310;
import org.wild.module.api.Module;
import ru.metaculture.profile.Profile;
import ru.metaculture.protection.SpringConfig;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.FloatingElementTransform;
import ru.metaculture.protection.GlPixelStoreFix;
import ru.metaculture.protection.UnUnVNnvnV;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.VwVVvwWW;
import ru.metaculture.protection.ProfileAvatarTextureLoader;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.ThemeContext;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.SpringStepper;
import ru.metaculture.protection.UiRenderUtil;
import ru.metaculture.protection.ElementAnimState;
import ru.metaculture.protection.FontRegistry;
import ru.metaculture.protection.ClickGuiState;
import ru.metaculture.protection.CoreDiagnosticsManager;
import ru.metaculture.protection.GlowRingRenderer;
import ru.metaculture.protection.AvatarShaderRenderer;

public final class CoreDiagnosticsRenderer {
    private static final float primaryVal = 330.0f;
    private static final float secondaryVal = 18.0f;
    private static final float tertiaryVal = 108.0f;
    private static final float marginVal = 126.0f;
    private static final float weightVal = 32.0f;
    private static final float paramVal = 32.0f;
    private static final float extraVal = 10.0f;
    private static final float limitVal = 34.0f;
    private static final float speedVal = 7.0f;
    private static final float widthVal = 56.0f;
    private static final float chunkVal = 8.0f;
    private static final float blockRef = 12.0f;
    private static final float holderVal = 24.0f;
    private static final float timerVal = 8.0f;
    private static final float anchorVal = 4.0f;
    private static final float weightRef = 4.0f;
    private static final float bufferVal = 9.0f;
    private static final int countVal = 4;
    private static final int depthVal = 5;
    private static final String descRef = "UID";
    private static final String activeVal = "SYSTEM";
    private static final String radiusVal = "SHADER PIPELINE";
    private static final String factorVal = "Theme";
    private static final String sourceVal = "Modules";
    private static final String extraRef = "Wild Core";
    private static final String phaseVal = "Build";
    private static final String limitRef = "Shader Stage";
    private static final String paramRef = "Shader Exception";
    private static final String groupVal = "CFI chain";
    private static final String layerVal = "Frames";
    private static final String slotVal = "Anomalies";
    private static final String themeVal = "Texture Units";
    private static final String stageVal = "Matrices";
    private static final String widthRef = "Mixin policy";
    private static final String trackVal = "Diagnostics";
    private static final String modeRef = "Close";
    private static final String angleVal = CoreDiagnosticsRenderer.primaryVal("wild-1.21.8-1787661348375");
    private static final VwVVvwWW heightRef = new VwVVvwWW();
    private static final SpringConfig levelVal = SpringConfig.holderVal();
    private static final SpringConfig UuNnnVnuNNV = SpringConfig.holderVal();
    private static final SpringConfig depthRef = SpringConfig.holderVal();
    private static final SpringConfig speedRef = SpringConfig.anchorVal();
    private final UnUnVNnvnV countRef = new UnUnVNnvnV();
    private final SpringStepper entryVal = new SpringStepper(0.0f);
    private final SpringStepper guardVal = new SpringStepper(0.0f);
    private final SpringStepper VUuuVUnun = new SpringStepper(0.0f);
    private String vVVuuVVv = "0";
    private String VuunNUUUvu = "0";
    private String NNUUNUuVNNVn = "";
    private String VvVvnNUnvuvV = "CORRUPTED";
    private int tokenVal = Integer.MIN_VALUE;
    private int NUVvUUVuVNVv = Integer.MIN_VALUE;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, ElementAnimState uVUvuUUNVUv2, ThemeContext nodeE, float f) {
        float f2 = !chunkRef.twigD() && chunkRef.vvNvvuUUUVvv() ? 1.0f : 0.0f;
        FloatingElementTransform reedA = FloatingElementTransform.resolve(f, uVUvuUUNVUv2, nodeE.weightVal());
        float f3 = reedA.alpha();
        if (!reedA.visible()) {
            heightRef.paramVal();
            return;
        }
        float f4 = CoreDiagnosticsRenderer.tertiaryVal(this.entryVal.primaryVal(f2, f2 > 0.0f ? levelVal : speedRef));
        float f5 = CoreDiagnosticsRenderer.tertiaryVal(this.guardVal.primaryVal(f2, f2 > 0.0f ? UuNnnVnuNNV : speedRef));
        float f6 = CoreDiagnosticsRenderer.tertiaryVal(this.VUuuVUnun.primaryVal(f2, f2 > 0.0f ? depthRef : speedRef));
        CoreDiagnosticsManager.primaryVal().primaryVal(this.countRef);
        this.primaryVal();
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        float f7 = CoreDiagnosticsRenderer.primaryVal(uVUvuUUNVUv2, cacheVal);
        float f8 = CoreDiagnosticsRenderer.secondaryVal(uVUvuUUNVUv2, cacheVal);
        float f9 = CoreDiagnosticsRenderer.primaryVal(cacheVal);
        float f10 = CoreDiagnosticsRenderer.tertiaryVal(uVUvuUUNVUv2, cacheVal);
        float f11 = CoreDiagnosticsRenderer.primaryVal(cacheVal, f10);
        heightVal.weightVal(f3);
        heightVal.primaryVal(reedA.translateX(), reedA.translateY());
        try {
            heightVal.primaryVal(reedA.scale(), reedA.pivotX(), reedA.pivotY());
            try {
                this.primaryVal(heightVal, cacheVal, configVal, f7, f8, f9, f10, cacheVal.primaryVal(14.0f), f3);
                heightVal.tertiaryVal();
                heightVal.primaryVal(f7, f8, f9, f10, cacheVal.primaryVal(14.0f), cacheVal.primaryVal(14.0f), cacheVal.primaryVal(14.0f), cacheVal.primaryVal(14.0f));
                try {
                    float f12 = CoreDiagnosticsRenderer.primaryVal(f4, 0.0f, 0.72f);
                    heightVal.weightVal(f12);
                    heightVal.primaryVal(cacheVal.primaryVal(-10.0f) * (1.0f - f12), 0.0f);
                    try {
                        this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f7, f8, f9, f11, f3 * f12);
                    }
                    finally {
                        heightVal.limitVal();
                        heightVal.widthVal();
                    }
                    float f13 = CoreDiagnosticsRenderer.primaryVal(f5, 0.22f, 0.92f);
                    heightVal.weightVal(f13);
                    heightVal.primaryVal(cacheVal.primaryVal(12.0f) * (1.0f - f13), 0.0f);
                    try {
                        this.secondaryVal(heightVal, chunkRef, cacheVal, configVal, f7, f8, f9, f10, f11);
                    }
                    finally {
                        heightVal.limitVal();
                        heightVal.widthVal();
                    }
                    float f14 = CoreDiagnosticsRenderer.primaryVal(f6, 0.42f, 1.0f);
                    heightVal.weightVal(f14);
                    heightVal.primaryVal(0.0f, cacheVal.primaryVal(10.0f) * (1.0f - f14));
                    try {
                        this.primaryVal(heightVal, chunkRef, cacheVal, configVal, uVUvuUUNVUv2);
                    }
                    finally {
                        heightVal.limitVal();
                        heightVal.widthVal();
                    }
                }
                finally {
                    heightVal.tertiaryVal();
                    heightVal.paramVal();
                }
            }
            finally {
                heightVal.speedVal();
            }
        }
        finally {
            heightVal.limitVal();
            heightVal.widthVal();
        }
    }

    private void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, float f6) {
        if (!configVal.activeVal()) {
            heightVal.primaryVal(f, f2, f3, f4, f5, cacheVal.primaryVal(30.0f) * f6, cacheVal.primaryVal(6.0f), ThemePalette.primaryVal(0, 0, 0, Math.round(140.0f * f6)));
        }
        heightVal.primaryVal(f, f2, f3, f4, f5, configVal.activeVal() ? 0.92f : 0.86f);
        int n = configVal.activeVal() ? ThemePalette.primaryVal(255, 255, 255, 234) : ThemePalette.primaryVal(ThemePalette.primaryVal(6, 8, 15, 246), ThemePalette.primaryVal(configVal.descRef(), 118), 0.12f);
        heightVal.primaryVal(f, f2, f3, f4, f5, n);
        int n2 = configVal.activeVal() ? ThemePalette.primaryVal(255, 255, 255, 150) : ThemePalette.primaryVal(configVal.depthVal(), 38);
        heightVal.primaryVal(f, f2, f3, f4, f5, n2, Math.max(1.0f, cacheVal.primaryVal(1.0f)));
        heightVal.primaryVal(f + cacheVal.primaryVal(1.0f), f2 + cacheVal.primaryVal(1.0f), Math.max(1.0f, f3 - cacheVal.primaryVal(2.0f)), Math.max(1.0f, f4 - cacheVal.primaryVal(2.0f)), Math.max(0.0f, f5 - cacheVal.primaryVal(1.0f)), configVal.activeVal() ? ThemePalette.primaryVal(255, 255, 255, 70) : configVal.chunkVal(), 0.5f);
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5) {
        float f6 = cacheVal.primaryVal(18.0f);
        float f7 = CoreDiagnosticsRenderer.marginVal(f + f6);
        float f8 = CoreDiagnosticsRenderer.marginVal(f2 + f6);
        float f9 = CoreDiagnosticsRenderer.marginVal(f3 - f6 * 2.0f);
        float f10 = CoreDiagnosticsRenderer.marginVal(f4 - cacheVal.primaryVal(8.0f));
        float f11 = cacheVal.primaryVal(12.0f);
        this.primaryVal(heightVal, cacheVal, configVal, f7, f8, f9, f10, f11);
        float f12 = CoreDiagnosticsRenderer.marginVal(CoreDiagnosticsRenderer.secondaryVal(f9 * 0.26f, cacheVal.primaryVal(64.0f), cacheVal.primaryVal(72.0f)));
        float f13 = CoreDiagnosticsRenderer.marginVal(f7 + cacheVal.primaryVal(16.0f));
        float f14 = CoreDiagnosticsRenderer.marginVal(f8 + (f10 - f12) * 0.5f);
        this.primaryVal(heightVal, cacheVal, configVal, f13, f14, f12, f5);
        int n = this.countRef.extraRef == 0 ? configVal.primaryVal() : configVal.secondaryVal();
        float f15 = this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f7, f8, f9, f10, n);
        float f16 = f14 + f12 * 0.5f;
        float f17 = CoreDiagnosticsRenderer.marginVal(f13 + f12 + cacheVal.primaryVal(16.0f));
        float f18 = CoreDiagnosticsRenderer.marginVal(f17 + cacheVal.primaryVal(9.0f));
        float f19 = Math.max(cacheVal.primaryVal(56.0f), f15 - cacheVal.primaryVal(12.0f) - f18);
        heightVal.secondaryVal(f17, CoreDiagnosticsRenderer.marginVal(f16 - cacheVal.primaryVal(15.0f)), cacheVal.primaryVal(1.0f), cacheVal.primaryVal(10.0f), cacheVal.primaryVal(1.0f), ThemePalette.primaryVal(configVal.depthVal(), 255), ThemePalette.primaryVal(configVal.descRef(), 255));
        this.primaryVal(heightVal, chunkRef, cacheVal, FontRegistry.marginVal, f18, CoreDiagnosticsRenderer.marginVal(f16 - cacheVal.primaryVal(20.0f)), cacheVal.primaryVal(20.0f), 16.0f, Profile.getUsername(), UiRenderUtil.primaryVal(configVal), f19);
        this.primaryVal(heightVal, chunkRef, cacheVal, FontRegistry.primaryVal, f18, CoreDiagnosticsRenderer.marginVal(f16 + cacheVal.primaryVal(2.0f)), cacheVal.primaryVal(15.0f), 8.0f, "UID " + this.vVVuuVVv, UiRenderUtil.secondaryVal(configVal), f19);
    }

    private void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5) {
        if (configVal.activeVal()) {
            heightVal.primaryVal(f, f2 + cacheVal.primaryVal(2.0f), f3, f4, f5, cacheVal.primaryVal(12.0f), cacheVal.primaryVal(1.5f), ThemePalette.primaryVal(46, 59, 70, 20));
            int n = ThemePalette.primaryVal(255, 255, 255, 240);
            int n2 = ThemePalette.primaryVal(n, ThemePalette.primaryVal(configVal.depthVal(), 255), 0.14f);
            int n3 = ThemePalette.primaryVal(n, ThemePalette.primaryVal(configVal.descRef(), 255), 0.09f);
            int n4 = ThemePalette.primaryVal(n, ThemePalette.primaryVal(configVal.depthVal(), 255), 0.035f);
            heightVal.primaryVal(f, f2, f3, f4, f5, n2, n4, n3, n4);
            heightVal.secondaryVal(f, f2, f3, f4 * 0.42f, f5, f5, 0.0f, 0.0f, ThemePalette.primaryVal(255, 255, 255, 140), ThemePalette.primaryVal(255, 255, 255, 0));
            heightVal.primaryVal(f, f2, f3, f4, f5, ThemePalette.primaryVal(configVal.depthVal(), 44), Math.max(1.0f, cacheVal.primaryVal(0.9f)));
            return;
        }
        heightVal.primaryVal(f, f2 + cacheVal.primaryVal(3.0f), f3, f4, f5, cacheVal.primaryVal(22.0f), cacheVal.primaryVal(3.0f), ThemePalette.primaryVal(0, 0, 0, 128));
        int n = ThemePalette.primaryVal(9, 12, 21, 240);
        int n5 = ThemePalette.primaryVal(n, ThemePalette.primaryVal(configVal.depthVal(), 255), 0.3f);
        int n6 = ThemePalette.primaryVal(n, ThemePalette.primaryVal(configVal.depthVal(), 255), 0.09f);
        int n7 = ThemePalette.primaryVal(n, ThemePalette.primaryVal(configVal.descRef(), 255), 0.24f);
        int n8 = ThemePalette.primaryVal(n, ThemePalette.primaryVal(configVal.descRef(), 255), 0.06f);
        heightVal.primaryVal(f, f2, f3, f4, f5, n5, n6, n7, n8);
        heightVal.secondaryVal(f, f2, f3, f4 * 0.46f, f5, f5, 0.0f, 0.0f, ThemePalette.primaryVal(configVal.countVal(), 18), ThemePalette.primaryVal(0, 0, 0, 0));
        heightVal.primaryVal(f, f2, f3, f4, f5, ThemePalette.primaryVal(configVal.depthVal(), 42), Math.max(1.0f, cacheVal.primaryVal(0.9f)));
        heightVal.primaryVal(f + cacheVal.primaryVal(1.0f), f2 + cacheVal.primaryVal(1.0f), Math.max(1.0f, f3 - cacheVal.primaryVal(2.0f)), Math.max(1.0f, f4 - cacheVal.primaryVal(2.0f)), Math.max(0.0f, f5 - cacheVal.primaryVal(1.0f)), configVal.chunkVal(), 0.5f);
    }

    private float primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, int n) {
        String string = CoreDiagnosticsRenderer.secondaryVal(this.countRef.secondaryVal);
        float f5 = Math.min(f3 * 0.3f, UiRenderUtil.primaryVal(cacheVal, FontRegistry.marginVal, string, 8.0f));
        float f6 = cacheVal.primaryVal(22.0f);
        float f7 = CoreDiagnosticsRenderer.marginVal(f5 + cacheVal.primaryVal(28.0f));
        float f8 = CoreDiagnosticsRenderer.marginVal(f + f3 - cacheVal.primaryVal(14.0f) - f7);
        float f9 = CoreDiagnosticsRenderer.marginVal(f2 + (f4 - f6) * 0.5f);
        boolean bl = UiRenderUtil.primaryVal(chunkRef, f8, f9, f7, f6);
        float f10 = chunkRef.primaryVal("profile:chip:hover", bl ? 1.0f : 0.0f, SpringConfig.chunkVal());
        int n2 = ThemePalette.primaryVal(n, Math.round((configVal.activeVal() ? 24.0f : 34.0f) + 18.0f * f10));
        heightVal.primaryVal(f8, f9, f7, f6, f6 * 0.5f, n2);
        heightVal.primaryVal(f8, f9, f7, f6, f6 * 0.5f, ThemePalette.primaryVal(n, Math.round(96.0f + 60.0f * f10)), cacheVal.primaryVal(0.6f));
        heightVal.secondaryVal(f8 + cacheVal.primaryVal(10.0f), f9 + f6 * 0.5f, cacheVal.primaryVal(2.2f), 0.0f, 1.0f, ThemePalette.primaryVal(n, 232));
        int n3 = configVal.activeVal() ? n : ThemePalette.primaryVal(n, configVal.countVal(), 0.22f);
        this.primaryVal(heightVal, chunkRef, cacheVal, FontRegistry.marginVal, f8 + cacheVal.primaryVal(17.0f), f9, f6, 8.0f, string, n3, f7 - cacheVal.primaryVal(24.0f));
        return f8;
    }

    private void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4) {
        float f5 = f3 * 0.5f;
        float f6 = f + f5;
        float f7 = f2 + f5;
        heightVal.primaryVal(f - cacheVal.primaryVal(2.0f), f2 - cacheVal.primaryVal(2.0f), f3 + cacheVal.primaryVal(4.0f), f3 + cacheVal.primaryVal(4.0f), f5 + cacheVal.primaryVal(4.0f), cacheVal.primaryVal(20.0f), cacheVal.primaryVal(2.5f), ThemePalette.primaryVal(configVal.depthVal(), configVal.activeVal() ? 44 : 92));
        int n = ProfileAvatarTextureLoader.primaryVal();
        if (n > 0) {
            heightVal.secondaryVal(f6, f7, f5, 0.0f, 1.0f, configVal.activeVal() ? ThemePalette.primaryVal(244, 246, 250, 255) : ThemePalette.primaryVal(9, 12, 20, 255));
            heightVal.tertiaryVal();
            AvatarShaderRenderer.primaryVal(f, f2, f3, n, configVal.depthVal(), configVal.descRef(), f4, configVal.activeVal());
        } else {
            heightVal.secondaryVal(f6, f7, f5 + cacheVal.primaryVal(2.5f), 0.0f, 1.0f, configVal.activeVal() ? ThemePalette.primaryVal(255, 255, 255, 250) : ThemePalette.primaryVal(6, 9, 16, 255));
            heightVal.secondaryVal(f6, f7, f5 + cacheVal.primaryVal(1.0f), 0.0f, 1.0f, ThemePalette.primaryVal(configVal.depthVal(), configVal.activeVal() ? 150 : 224));
            heightVal.secondaryVal(f6, f7, f5 - cacheVal.primaryVal(0.5f), 0.0f, 1.0f, configVal.activeVal() ? ThemePalette.primaryVal(250, 251, 254, 255) : ThemePalette.primaryVal(13, 18, 30, 255));
            GlowRingRenderer.primaryVal(heightVal, cacheVal, f6, f7 + cacheVal.primaryVal(0.6f), cacheVal.primaryVal(1.12f), UiRenderUtil.marginVal(configVal), ThemePalette.primaryVal(configVal.descRef(), configVal.activeVal() ? 28 : 62));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void secondaryVal(Renderer2D heightVal, ClickGuiState chunkRef, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5) {
        float f6 = CoreDiagnosticsRenderer.primaryVal(f, cacheVal);
        float f7 = CoreDiagnosticsRenderer.primaryVal(f2, cacheVal, f5);
        float f8 = CoreDiagnosticsRenderer.secondaryVal(f3, cacheVal);
        float f9 = CoreDiagnosticsRenderer.primaryVal(f2, f4, cacheVal, f5);
        float f10 = CoreDiagnosticsRenderer.extraVal(cacheVal);
        if (f10 <= f9 + cacheVal.primaryVal(1.0f)) {
            heightRef.paramVal();
        }
        heightRef.marginVal(7.5f);
        heightRef.primaryVal(true);
        heightRef.primaryVal(Math.max(f10, f9), f9);
        heightRef.tertiaryVal();
        float f11 = CoreDiagnosticsRenderer.secondaryVal(heightRef.limitVal(), Math.min(0.0f, heightRef.speedVal()), 0.0f);
        float f12 = cacheVal.primaryVal(10.0f);
        heightVal.tertiaryVal();
        heightVal.primaryVal(f6, f7, f8, f9, f12, f12, f12, f12);
        try {
            float f13 = CoreDiagnosticsRenderer.marginVal(f7 + cacheVal.primaryVal(4.0f) + f11);
            f13 = this.tertiaryVal(heightVal, chunkRef, cacheVal, configVal, f6, f7, f8, f9, f13);
            f13 = this.primaryVal(heightVal, cacheVal, configVal, f6, f7, f8, f9, f13, activeVal);
            f13 = this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f6, f7, f8, f9, f13, factorVal, chunkRef.nodeF().name(), configVal.depthVal(), 0);
            f13 = this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f6, f7, f8, f9, f13, extraRef, this.countRef.extraRef == 0 ? CoreDiagnosticsRenderer.secondaryVal(this.countRef.secondaryVal) : CoreDiagnosticsRenderer.secondaryVal(this.countRef.weightVal), this.countRef.extraRef == 0 ? configVal.depthVal() : configVal.secondaryVal(), 1);
            f13 = this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f6, f7, f8, f9, f13, phaseVal, angleVal, configVal.descRef(), 2);
            f13 = this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f6, f7, f8, f9, f13, stageVal, this.weightVal(), this.primaryVal(configVal), 3);
            f13 = CoreDiagnosticsRenderer.marginVal(f13 + cacheVal.primaryVal(8.0f));
            f13 = this.primaryVal(heightVal, cacheVal, configVal, f6, f7, f8, f9, f13, radiusVal);
            f13 = this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f6, f7, f8, f9, f13, limitRef, CoreDiagnosticsRenderer.secondaryVal(this.countRef.anchorVal), configVal.depthVal(), 4);
            f13 = this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f6, f7, f8, f9, f13, paramRef, CoreDiagnosticsRenderer.secondaryVal(this.countRef.weightRef), "0".equals(this.countRef.countVal) ? configVal.descRef() : configVal.secondaryVal(), 5);
            f13 = this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f6, f7, f8, f9, f13, groupVal, CoreDiagnosticsRenderer.secondaryVal(this.countRef.tertiaryVal), configVal.depthVal(), 6);
            f13 = this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f6, f7, f8, f9, f13, themeVal, this.paramVal(), configVal.depthVal(), 7);
            this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f6, f7, f8, f9, f13, widthRef, CoreDiagnosticsRenderer.secondaryVal(this.countRef.holderVal), configVal.descRef(), 8);
        }
        finally {
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
        this.secondaryVal(heightVal, cacheVal, configVal, f6, f7, f8, f9, f10, f11);
        this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f6, f7, f8, f9, f10, f11);
    }

    public static void primaryVal(float f) {
        float f2 = Math.min(0.0f, heightRef.speedVal());
        heightRef.primaryVal(f2 * Math.max(0.0f, Math.min(1.0f, f)));
    }

    private float tertiaryVal(Renderer2D heightVal, ClickGuiState chunkRef, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5) {
        float f6 = cacheVal.primaryVal(56.0f);
        if (f5 + f6 >= f2 - cacheVal.primaryVal(3.0f)) {
            if (f5 <= f2 + f4 + cacheVal.primaryVal(3.0f)) {
                float f7 = CoreDiagnosticsRenderer.marginVal(f + cacheVal.primaryVal(4.0f));
                float f8 = Math.max(cacheVal.primaryVal(120.0f), f3 - cacheVal.primaryVal(13.0f));
                float f9 = cacheVal.primaryVal(8.0f);
                float f10 = CoreDiagnosticsRenderer.marginVal((f8 - f9 * 2.0f) / 3.0f);
                float f11 = CoreDiagnosticsRenderer.marginVal(f7 + (f10 + f9) * 2.0f);
                int n = this.countRef.extraRef == 0 ? configVal.primaryVal() : configVal.secondaryVal();
                this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f7, f5, f10, f6, this.VuunNUUUvu, sourceVal, configVal.depthVal(), 0);
                this.primaryVal(heightVal, chunkRef, cacheVal, configVal, CoreDiagnosticsRenderer.marginVal(f7 + f10 + f9), f5, f10, f6, CoreDiagnosticsRenderer.secondaryVal(this.countRef.radiusVal), layerVal, configVal.descRef(), 1);
                this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f11, f5, Math.max(cacheVal.primaryVal(40.0f), f7 + f8 - f11), f6, CoreDiagnosticsRenderer.secondaryVal(this.countRef.activeVal), slotVal, n, 2);
            }
        }
        return CoreDiagnosticsRenderer.marginVal(f5 + f6 + cacheVal.primaryVal(12.0f));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, String string, String string2, int n, int n2) {
        float f5 = CoreDiagnosticsRenderer.marginVal(f);
        float f6 = CoreDiagnosticsRenderer.marginVal(f2);
        float f7 = CoreDiagnosticsRenderer.primaryVal(f5, f3);
        float f8 = CoreDiagnosticsRenderer.primaryVal(f6, f4);
        boolean bl = UiRenderUtil.primaryVal(chunkRef, f5, f6, f7, f8);
        float f9 = chunkRef.primaryVal("profile:tile:hover:" + n2, bl ? 1.0f : 0.0f, SpringConfig.chunkVal());
        float f10 = CoreDiagnosticsRenderer.secondaryVal(f9);
        heightVal.primaryVal(0.0f, -cacheVal.primaryVal(0.9f) * f10);
        heightVal.primaryVal(1.0f + f10 * 0.009f, f5 + f7 * 0.5f, f6 + f8 * 0.5f);
        try {
            int n3;
            float f11 = cacheVal.primaryVal(10.0f);
            int n4 = n3 = configVal.activeVal() ? ThemePalette.primaryVal(UiRenderUtil.primaryVal(configVal, 0.16f), ThemePalette.primaryVal(n, 30), 0.1f + f10 * 0.26f) : ThemePalette.primaryVal(ThemePalette.primaryVal(8, 12, 23, 186), ThemePalette.primaryVal(n, 58), 0.16f + f10 * 0.16f);
            if (f10 > 0.01f) {
                heightVal.primaryVal(f5, f6, f7, f8, f11, cacheVal.primaryVal(8.0f) * f10, cacheVal.primaryVal(1.4f), ThemePalette.primaryVal(n, Math.round(30.0f * f10)));
            }
            heightVal.primaryVal(f5, f6, f7, f8, f11, n3);
            heightVal.primaryVal(f5, f6, f7, f8, f11, ThemePalette.primaryVal(configVal.activeVal() ? ThemePalette.primaryVal(255, 255, 255, 70) : configVal.chunkVal(), ThemePalette.primaryVal(n, 150), f10), cacheVal.primaryVal(0.55f + f10 * 0.3f));
            this.primaryVal(heightVal, chunkRef, cacheVal, FontRegistry.marginVal, CoreDiagnosticsRenderer.marginVal(f5 + cacheVal.primaryVal(12.0f)), CoreDiagnosticsRenderer.marginVal(f6 + cacheVal.primaryVal(7.0f)), cacheVal.primaryVal(24.0f), 15.0f, CoreDiagnosticsRenderer.secondaryVal(string), UiRenderUtil.primaryVal(configVal), f7 - cacheVal.primaryVal(22.0f));
            this.primaryVal(heightVal, chunkRef, cacheVal, FontRegistry.primaryVal, CoreDiagnosticsRenderer.marginVal(f5 + cacheVal.primaryVal(12.0f)), CoreDiagnosticsRenderer.marginVal(f6 + f8 - cacheVal.primaryVal(24.0f)), cacheVal.primaryVal(16.0f), 7.0f, string2, ThemePalette.primaryVal(UiRenderUtil.secondaryVal(configVal), UiRenderUtil.primaryVal(configVal), f10 * 0.24f), f7 - cacheVal.primaryVal(22.0f));
        }
        finally {
            heightVal.speedVal();
            heightVal.limitVal();
        }
    }

    private float primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, String string) {
        float f6 = cacheVal.primaryVal(24.0f);
        if (f5 + f6 >= f2 - cacheVal.primaryVal(3.0f) && f5 <= f2 + f4 + cacheVal.primaryVal(3.0f)) {
            float f7 = CoreDiagnosticsRenderer.marginVal(f + cacheVal.primaryVal(6.0f));
            float f8 = CoreDiagnosticsRenderer.marginVal(f + f3 - cacheVal.primaryVal(9.0f));
            float f9 = cacheVal.primaryVal(16.0f);
            float f10 = CoreDiagnosticsRenderer.marginVal(f5 + f6 - f9 - cacheVal.primaryVal(2.0f));
            UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.marginVal, f7, f10, f9, 7.5f, string, UiRenderUtil.secondaryVal(configVal));
            float f11 = UiRenderUtil.primaryVal(cacheVal, FontRegistry.marginVal, string, 7.5f);
            float f12 = CoreDiagnosticsRenderer.marginVal(f7 + f11 + cacheVal.primaryVal(10.0f));
            float f13 = f8 - f12;
            if (f13 > cacheVal.primaryVal(8.0f)) {
                heightVal.primaryVal(f12, CoreDiagnosticsRenderer.marginVal(f10 + f9 * 0.5f), f13, Math.max(1.0f, cacheVal.primaryVal(1.0f)), cacheVal.primaryVal(0.5f), configVal.activeVal() ? ThemePalette.primaryVal(0, 0, 0, 26) : configVal.blockRef());
            }
        }
        return CoreDiagnosticsRenderer.marginVal(f5 + f6);
    }

    private float primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, String string, String string2, int n, int n2) {
        float f6 = cacheVal.primaryVal(34.0f);
        if (f5 + f6 >= f2 - cacheVal.primaryVal(3.0f)) {
            if (f5 <= f2 + f4 + cacheVal.primaryVal(3.0f)) {
                float f7 = f + cacheVal.primaryVal(4.0f);
                float f8 = Math.max(cacheVal.primaryVal(80.0f), f3 - cacheVal.primaryVal(13.0f));
                this.secondaryVal(heightVal, chunkRef, cacheVal, configVal, f7, f5, f8, f6, string, string2, n, n2);
            }
        }
        return CoreDiagnosticsRenderer.marginVal(f5 + f6 + cacheVal.primaryVal(7.0f));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void secondaryVal(Renderer2D heightVal, ClickGuiState chunkRef, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, String string, String string2, int n, int n2) {
        float f5 = CoreDiagnosticsRenderer.marginVal(f);
        float f6 = CoreDiagnosticsRenderer.marginVal(f2);
        float f7 = CoreDiagnosticsRenderer.primaryVal(f5, f3);
        float f8 = CoreDiagnosticsRenderer.primaryVal(f6, f4);
        boolean bl = UiRenderUtil.primaryVal(chunkRef, f5, f6, f7, f8);
        float f9 = chunkRef.primaryVal("profile:row:hover:" + n2, bl ? 1.0f : 0.0f, SpringConfig.chunkVal());
        float f10 = CoreDiagnosticsRenderer.secondaryVal(f9);
        heightVal.primaryVal(0.0f, -cacheVal.primaryVal(0.9f) * f10);
        heightVal.primaryVal(1.0f + f10 * 0.009f, f5 + f7 * 0.5f, f6 + f8 * 0.5f);
        try {
            int n3 = configVal.activeVal() ? ThemePalette.primaryVal(UiRenderUtil.primaryVal(configVal, 0.14f), ThemePalette.primaryVal(n, 30), 0.08f + f10 * 0.28f) : ThemePalette.primaryVal(ThemePalette.primaryVal(8, 12, 23, 164), ThemePalette.primaryVal(n, 52), 0.14f + f10 * 0.16f);
            if (f10 > 0.01f) {
                heightVal.primaryVal(f5, f6, f7, f8, cacheVal.primaryVal(9.0f), cacheVal.primaryVal(7.0f) * f10, cacheVal.primaryVal(1.2f), ThemePalette.primaryVal(n, Math.round(28.0f * f10)));
            }
            heightVal.primaryVal(f5, f6, f7, f8, cacheVal.primaryVal(9.0f), n3);
            heightVal.primaryVal(f5, f6, f7, f8, cacheVal.primaryVal(9.0f), ThemePalette.primaryVal(configVal.activeVal() ? ThemePalette.primaryVal(255, 255, 255, 70) : configVal.chunkVal(), ThemePalette.primaryVal(n, 154), f10), cacheVal.primaryVal(0.55f + f10 * 0.3f));
            if (f10 > 0.01f) {
                heightVal.primaryVal(f5 + cacheVal.primaryVal(1.2f), f6 + f8 * 0.27f, cacheVal.primaryVal(1.8f), f8 * 0.46f, cacheVal.primaryVal(0.9f), ThemePalette.primaryVal(n, Math.round(196.0f * f10)));
            }
            this.primaryVal(heightVal, cacheVal, f5 + cacheVal.primaryVal(17.0f), f6 + f8 * 0.5f, n2, n, configVal);
            float f11 = CoreDiagnosticsRenderer.marginVal(f5 + cacheVal.primaryVal(34.0f));
            float f12 = CoreDiagnosticsRenderer.marginVal(f5 + f7 * 0.52f);
            int n4 = ThemePalette.primaryVal(UiRenderUtil.secondaryVal(configVal), UiRenderUtil.primaryVal(configVal), f10 * 0.28f);
            this.primaryVal(heightVal, chunkRef, cacheVal, FontRegistry.primaryVal, f11, f6, f8, 8.0f, string, n4, Math.max(cacheVal.primaryVal(34.0f), f12 - f11 - cacheVal.primaryVal(10.0f)));
            this.primaryVal(heightVal, chunkRef, cacheVal, FontRegistry.marginVal, f12, f6, f8, 8.5f, CoreDiagnosticsRenderer.secondaryVal(string2), UiRenderUtil.primaryVal(configVal), Math.max(cacheVal.primaryVal(42.0f), f5 + f7 - f12 - cacheVal.primaryVal(12.0f)));
        }
        finally {
            heightVal.speedVal();
            heightVal.limitVal();
        }
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, GuiMetrics cacheVal, ThemePalette configVal, ElementAnimState uVUvuUUNVUv2) {
        float f = this.weightVal(uVUvuUUNVUv2, cacheVal);
        float f2 = this.marginVal(uVUvuUUNVUv2, cacheVal);
        float f3 = this.tertiaryVal(cacheVal);
        this.primaryVal(heightVal, chunkRef, cacheVal, configVal, f2, f, f3, trackVal, configVal.depthVal(), 0);
        this.primaryVal(heightVal, chunkRef, cacheVal, configVal, this.paramVal(uVUvuUUNVUv2, cacheVal), this.extraVal(uVUvuUUNVUv2, cacheVal), this.weightVal(cacheVal), modeRef, UiRenderUtil.primaryVal(configVal), 2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, String string, int n, int n2) {
        float f4 = CoreDiagnosticsRenderer.marginVal(f);
        float f5 = CoreDiagnosticsRenderer.marginVal(f2);
        float f6 = CoreDiagnosticsRenderer.primaryVal(f4, f3);
        float f7 = cacheVal.primaryVal(n2 == 2 ? 32.0f : 32.0f);
        boolean bl = UiRenderUtil.primaryVal(chunkRef, f4, f5, f6, f7);
        float f8 = chunkRef.primaryVal("profile:action:hover:" + n2, bl ? 1.0f : 0.0f, SpringConfig.widthVal());
        float f9 = CoreDiagnosticsRenderer.secondaryVal(f8);
        heightVal.primaryVal(0.0f, -cacheVal.primaryVal(1.0f) * f9);
        heightVal.primaryVal(1.0f + f9 * 0.014f, f4 + f6 * 0.5f, f5 + f7 * 0.5f);
        try {
            int n3 = configVal.activeVal() ? ThemePalette.primaryVal(UiRenderUtil.primaryVal(configVal, 0.25f), ThemePalette.primaryVal(n, 42), f9 * 0.34f) : ThemePalette.primaryVal(ThemePalette.primaryVal(8, 12, 23, 188), ThemePalette.primaryVal(n, 68), 0.18f + f9 * 0.22f);
            if (f9 > 0.01f) {
                heightVal.primaryVal(f4, f5, f6, f7, cacheVal.primaryVal(9.0f), cacheVal.primaryVal(8.0f) * f9, cacheVal.primaryVal(1.5f), ThemePalette.primaryVal(n, Math.round(34.0f * f9)));
            }
            heightVal.primaryVal(f4, f5, f6, f7, cacheVal.primaryVal(9.0f), n3);
            heightVal.primaryVal(f4, f5, f6, f7, cacheVal.primaryVal(9.0f), ThemePalette.primaryVal(n, Math.round((configVal.activeVal() ? 58.0f : 84.0f) + 92.0f * f9)), cacheVal.primaryVal(0.6f + 0.25f * f9));
            this.secondaryVal(heightVal, cacheVal, f4 + cacheVal.primaryVal(17.0f), f5 + f7 * 0.5f, n2, n, configVal);
            this.primaryVal(heightVal, chunkRef, cacheVal, FontRegistry.marginVal, f4 + cacheVal.primaryVal(34.0f + f9 * 1.5f), f5, f7, 8.5f, string, UiRenderUtil.primaryVal(configVal), f6 - cacheVal.primaryVal(44.0f));
        }
        finally {
            heightVal.speedVal();
            heightVal.limitVal();
        }
    }

    private void secondaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, float f6) {
        int n;
        int n2;
        float f7 = cacheVal.primaryVal(12.0f);
        n2 = configVal.activeVal() ? ThemePalette.primaryVal(255, 255, 255, 142) : ThemePalette.primaryVal(5, 7, 13, 166);
        n = configVal.activeVal() ? ThemePalette.primaryVal(255, 255, 255, 0) : ThemePalette.primaryVal(5, 7, 13, 0);
        if (f6 < -cacheVal.primaryVal(0.5f)) {
            heightVal.secondaryVal(f, f2, f3, f7, n2, n);
        }
        if (f5 + f6 > f4 + cacheVal.primaryVal(0.5f)) {
            heightVal.secondaryVal(f, f2 + f4 - f7, f3, f7, n, n2);
        }
    }

    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = Math.max(0.0f, f5 - f4);
        if (f7 <= cacheVal.primaryVal(1.0f)) {
            return;
        }
        float f8 = Math.max(cacheVal.primaryVal(4.0f), cacheVal.primaryVal(5.0f));
        float f9 = CoreDiagnosticsRenderer.marginVal(f + f3 - f8);
        float f10 = Math.max(cacheVal.primaryVal(24.0f), f4 * f4 / Math.max(f4, f5));
        float f11 = CoreDiagnosticsRenderer.marginVal(f2 + (f4 - f10) * (Math.abs(f6) / Math.max(1.0f, f7)));
        UiRenderUtil.primaryVal(heightVal, cacheVal, configVal, f9, f2, f8, f4, f11, f10, 0.0f, 0.48f, 3L, chunkRef.nodeD(), chunkRef.NnuUnUNnu(), CoreDiagnosticsRenderer::primaryVal);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void primaryVal(Renderer2D heightVal, ClickGuiState chunkRef, GuiMetrics cacheVal, FontObject twigJ, float f, float f2, float f3, float f4, String string, int n, float f5) {
        String string2 = CoreDiagnosticsRenderer.secondaryVal(string);
        float f6 = CoreDiagnosticsRenderer.marginVal(f);
        float f7 = CoreDiagnosticsRenderer.marginVal(f2);
        float f8 = Math.max(cacheVal.primaryVal(8.0f), CoreDiagnosticsRenderer.marginVal(f5));
        float f9 = CoreDiagnosticsRenderer.marginVal(f3);
        float f10 = UiRenderUtil.primaryVal(cacheVal, twigJ, string2, f4);
        float f11 = Math.max(0.0f, f10 - f8 + cacheVal.primaryVal(8.0f));
        float f12 = 0.0f;
        if (f11 > cacheVal.primaryVal(1.0f)) {
            if (UiRenderUtil.primaryVal(chunkRef.nodeD(), chunkRef.NnuUnUNnu(), f6, f7, f8, f9)) {
                float f13 = (float)(System.currentTimeMillis() % 2600L) / 2600.0f;
                float f14 = f13 < 0.5f ? f13 * 2.0f : 2.0f - f13 * 2.0f;
                f12 = CoreDiagnosticsRenderer.marginVal(f11 * f14);
            }
        }
        heightVal.tertiaryVal();
        heightVal.primaryVal(f6, f7, f8, f9, 0.0f, 0.0f, 0.0f, 0.0f);
        try {
            GlPixelStoreFix.primaryVal();
            UiRenderUtil.primaryVal(heightVal, cacheVal, twigJ, f6 - f12, f7, f9, f4, string2, n);
        }
        finally {
            GlPixelStoreFix.secondaryVal();
            heightVal.tertiaryVal();
            heightVal.paramVal();
        }
    }

    private void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, float f, float f2, int n, int n2, ThemePalette configVal) {
        float f3 = cacheVal.primaryVal(1.0f);
        int n3 = ThemePalette.primaryVal(n2, 216);
        heightVal.primaryVal(f - 5.8f * f3, f2 - 5.8f * f3, 11.6f * f3, 11.6f * f3, 3.5f * f3, ThemePalette.primaryVal(n3, 132), Math.max(0.65f, cacheVal.primaryVal(0.65f)));
        if (n % 3 == 0) {
            heightVal.primaryVal(f - 3.8f * f3, f2 + 2.0f * f3, 7.6f * f3, 1.5f * f3, 0.75f * f3, n3);
            heightVal.primaryVal(f - 1.0f * f3, f2 - 4.2f * f3, 2.0f * f3, 8.0f * f3, 1.0f * f3, ThemePalette.primaryVal(n3, 196));
        } else if (n % 3 == 1) {
            heightVal.primaryVal(f - 4.0f * f3, f2 - 2.7f * f3, 8.0f * f3, 1.5f * f3, 0.75f * f3, n3);
            heightVal.primaryVal(f - 4.0f * f3, f2 + 1.4f * f3, 8.0f * f3, 1.5f * f3, 0.75f * f3, ThemePalette.primaryVal(n3, 186));
        } else {
            heightVal.secondaryVal(f - 3.2f * f3, f2, 1.7f * f3, 0.0f, 1.0f, n3);
            heightVal.secondaryVal(f + 3.2f * f3, f2, 1.7f * f3, 0.0f, 1.0f, ThemePalette.primaryVal(n3, 188));
            heightVal.primaryVal(f - 1.6f * f3, f2 - 0.7f * f3, 3.2f * f3, 1.4f * f3, 0.7f * f3, ThemePalette.primaryVal(UiRenderUtil.primaryVal(configVal), 156));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void secondaryVal(Renderer2D heightVal, GuiMetrics cacheVal, float f, float f2, int n, int n2, ThemePalette configVal) {
        float f3 = cacheVal.primaryVal(1.0f);
        int n3 = ThemePalette.primaryVal(n == 2 ? UiRenderUtil.primaryVal(configVal) : n2, 234);
        if (n == 0) {
            heightVal.primaryVal(f - 6.0f * f3, f2 - 5.5f * f3, 12.0f * f3, 11.0f * f3, 3.0f * f3, ThemePalette.primaryVal(n3, 118), Math.max(0.6f, cacheVal.primaryVal(0.6f)));
            heightVal.primaryVal(f - 3.6f * f3, f2 + 1.6f * f3, 1.4f * f3, 3.0f * f3, 0.7f * f3, n3);
            heightVal.primaryVal(f - 0.7f * f3, f2 - 1.6f * f3, 1.4f * f3, 6.2f * f3, 0.7f * f3, n3);
            heightVal.primaryVal(f + 2.2f * f3, f2 - 4.0f * f3, 1.4f * f3, 8.6f * f3, 0.7f * f3, n3);
        } else if (n == 1) {
            heightVal.primaryVal(f - 5.2f * f3, f2 - 4.0f * f3, 10.4f * f3, 1.4f * f3, 0.7f * f3, n3);
            heightVal.primaryVal(f - 5.2f * f3, f2 - 0.5f * f3, 10.4f * f3, 1.4f * f3, 0.7f * f3, n3);
            heightVal.primaryVal(f - 5.2f * f3, f2 + 3.0f * f3, 7.4f * f3, 1.4f * f3, 0.7f * f3, ThemePalette.primaryVal(n3, 188));
        } else {
            heightVal.primaryVal(f, f2);
            heightVal.secondaryVal(45.0f);
            try {
                heightVal.primaryVal(-4.9f * f3, -0.8f * f3, 9.8f * f3, 1.6f * f3, 0.8f * f3, n3);
                heightVal.primaryVal(-0.8f * f3, -4.9f * f3, 1.6f * f3, 9.8f * f3, 0.8f * f3, n3);
            }
            finally {
                heightVal.extraVal();
                heightVal.limitVal();
            }
        }
    }

    public static boolean primaryVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal, float f, float f2, double d) {
        if (!CoreDiagnosticsRenderer.primaryVal(uVUvuUUNVUv2, cacheVal, f, f2)) {
            return false;
        }
        heightRef.primaryVal(d);
        return true;
    }

    public static boolean primaryVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal, float f, float f2) {
        float f3 = CoreDiagnosticsRenderer.primaryVal(uVUvuUUNVUv2, cacheVal);
        float f4 = CoreDiagnosticsRenderer.secondaryVal(uVUvuUUNVUv2, cacheVal);
        float f5 = CoreDiagnosticsRenderer.tertiaryVal(uVUvuUUNVUv2, cacheVal);
        float f6 = CoreDiagnosticsRenderer.primaryVal(cacheVal, f5);
        return UiRenderUtil.primaryVal(f, f2, CoreDiagnosticsRenderer.primaryVal(f3, cacheVal), CoreDiagnosticsRenderer.primaryVal(f4, cacheVal, f6), CoreDiagnosticsRenderer.secondaryVal(CoreDiagnosticsRenderer.primaryVal(cacheVal), cacheVal), CoreDiagnosticsRenderer.primaryVal(f4, f5, cacheVal, f6));
    }

    public static float primaryVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        return CoreDiagnosticsRenderer.marginVal(uVUvuUUNVUv2.anchorVal() + cacheVal.primaryVal(18.0f));
    }

    public static float secondaryVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        return CoreDiagnosticsRenderer.marginVal(uVUvuUUNVUv2.weightRef() + cacheVal.primaryVal(18.0f));
    }

    static float primaryVal(GuiMetrics cacheVal) {
        return CoreDiagnosticsRenderer.marginVal(CoreDiagnosticsRenderer.secondaryVal(cacheVal.primaryVal(330.0f), cacheVal.primaryVal(292.0f), Math.max(cacheVal.primaryVal(306.0f), cacheVal.speedVal() * 0.48f)));
    }

    public static float tertiaryVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        float f = CoreDiagnosticsRenderer.secondaryVal(uVUvuUUNVUv2, cacheVal);
        return Math.max(cacheVal.primaryVal(352.0f), CoreDiagnosticsRenderer.marginVal(uVUvuUUNVUv2.weightRef() + uVUvuUUNVUv2.countVal()) - f);
    }

    public float secondaryVal(GuiMetrics cacheVal) {
        return CoreDiagnosticsRenderer.primaryVal(cacheVal);
    }

    public float marginVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        return CoreDiagnosticsRenderer.marginVal(CoreDiagnosticsRenderer.primaryVal(uVUvuUUNVUv2, cacheVal) + cacheVal.primaryVal(18.0f));
    }

    public float weightVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        return CoreDiagnosticsRenderer.marginVal(this.extraVal(uVUvuUUNVUv2, cacheVal) - cacheVal.primaryVal(10.0f) - this.marginVal(cacheVal));
    }

    public float tertiaryVal(GuiMetrics cacheVal) {
        return CoreDiagnosticsRenderer.marginVal(CoreDiagnosticsRenderer.primaryVal(cacheVal) - cacheVal.primaryVal(36.0f));
    }

    public float marginVal(GuiMetrics cacheVal) {
        return CoreDiagnosticsRenderer.marginVal(cacheVal.primaryVal(32.0f));
    }

    public float paramVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        return CoreDiagnosticsRenderer.marginVal(CoreDiagnosticsRenderer.primaryVal(uVUvuUUNVUv2, cacheVal) + cacheVal.primaryVal(18.0f));
    }

    public float extraVal(ElementAnimState uVUvuUUNVUv2, GuiMetrics cacheVal) {
        return CoreDiagnosticsRenderer.marginVal(CoreDiagnosticsRenderer.secondaryVal(uVUvuUUNVUv2, cacheVal) + CoreDiagnosticsRenderer.tertiaryVal(uVUvuUUNVUv2, cacheVal) - cacheVal.primaryVal(18.0f) - this.paramVal(cacheVal));
    }

    public float weightVal(GuiMetrics cacheVal) {
        return CoreDiagnosticsRenderer.marginVal(CoreDiagnosticsRenderer.primaryVal(cacheVal) - cacheVal.primaryVal(36.0f));
    }

    public float paramVal(GuiMetrics cacheVal) {
        return CoreDiagnosticsRenderer.marginVal(cacheVal.primaryVal(32.0f));
    }

    private static float primaryVal(GuiMetrics cacheVal, float f) {
        float f2 = cacheVal.primaryVal(74.0f);
        float f3 = f - cacheVal.primaryVal(36.0f) - f2 - cacheVal.primaryVal(150.0f);
        return CoreDiagnosticsRenderer.marginVal(CoreDiagnosticsRenderer.secondaryVal(f * 0.27f, cacheVal.primaryVal(108.0f), Math.max(cacheVal.primaryVal(108.0f), Math.min(cacheVal.primaryVal(126.0f), f3))));
    }

    private static float primaryVal(float f, GuiMetrics cacheVal) {
        return CoreDiagnosticsRenderer.marginVal(f + cacheVal.primaryVal(18.0f));
    }

    private static float primaryVal(float f, GuiMetrics cacheVal, float f2) {
        return CoreDiagnosticsRenderer.marginVal(f + cacheVal.primaryVal(18.0f) + f2 + cacheVal.primaryVal(8.0f));
    }

    private static float secondaryVal(float f, GuiMetrics cacheVal) {
        return CoreDiagnosticsRenderer.marginVal(f - cacheVal.primaryVal(36.0f));
    }

    private static float primaryVal(float f, float f2, GuiMetrics cacheVal, float f3) {
        float f4 = CoreDiagnosticsRenderer.primaryVal(f, cacheVal, f3);
        float f5 = CoreDiagnosticsRenderer.marginVal(f + f2 - cacheVal.primaryVal(18.0f) - cacheVal.primaryVal(74.0f) - cacheVal.primaryVal(12.0f));
        return Math.max(cacheVal.primaryVal(80.0f), f5 - f4);
    }

    private static float extraVal(GuiMetrics cacheVal) {
        int n = 9;
        float f = cacheVal.primaryVal((float)n * 34.0f + (float)(n - 1) * 7.0f);
        return CoreDiagnosticsRenderer.marginVal(cacheVal.primaryVal(132.0f) + f);
    }

    private void primaryVal() {
        String string;
        int n;
        int n2 = CoreDiagnosticsRenderer.secondaryVal();
        if (n2 != this.tokenVal) {
            this.tokenVal = n2;
            this.vVVuuVVv = Integer.toString(n2);
        }
        if ((n = this.tertiaryVal()) != this.NUVvUUVuVNVv) {
            this.NUVvUUVuVNVv = n;
            this.VuunNUUUvu = Integer.toString(n);
        }
        if (!(string = CoreDiagnosticsRenderer.secondaryVal(this.countRef.extraVal)).equals(this.NNUUNUuVNNVn)) {
            this.NNUUNUuVNNVn = string;
            this.VvVvnNUnvuvV = CoreDiagnosticsRenderer.primaryVal(string, "finite") ? "OK" : "CORRUPTED";
        }
    }

    private static int secondaryVal() {
        try {
            return Profile.getUid();
        }
        catch (Throwable throwable) {
            return 0;
        }
    }

    private int tertiaryVal() {
        try {
            if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
                return 0;
            }
            ArrayList<Module> arrayList = WildClient.primaryVal.secondaryVal.secondaryVal();
            int n = 0;
            for (int i = 0; i < arrayList.size(); ++i) {
                if (!((Module)arrayList.get((int)i)).enabled) continue;
                ++n;
            }
            return n;
        }
        catch (Throwable throwable) {
            return 0;
        }
    }

    private String marginVal() {
        try {
            class_310 class_3102 = class_310.method_1551();
            if (class_3102 != null && class_3102.method_1548() != null) {
                return class_3102.method_1548().method_1676();
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return "Player";
    }

    private String weightVal() {
        return this.VvVvnNUnvuvV;
    }

    private String paramVal() {
        return this.countRef.extraRef == 0 ? "Isolated [TextureUnitGuard]" : CoreDiagnosticsRenderer.secondaryVal(this.countRef.paramVal);
    }

    private int primaryVal(ThemePalette configVal) {
        return "OK".equals(this.VvVvnNUnvuvV) ? configVal.depthVal() : configVal.secondaryVal();
    }

    private static boolean primaryVal(String string, String string2) {
        int n = string.length() - string2.length();
        for (int i = 0; i <= n; ++i) {
            if (!string.regionMatches(true, i, string2, 0, string2.length())) continue;
            return true;
        }
        return false;
    }

    private static String primaryVal(String string) {
        if (string == null || string.isBlank()) {
            return "unknown";
        }
        if (string.length() <= 26) {
            return string;
        }
        return string.substring(0, 23) + "...";
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static String secondaryVal(String string) {
        if (string == null) return "none";
        if (string.isBlank()) {
            return "none";
        }
        String string2 = string;
        return string2;
    }

    private static float primaryVal(float f, float f2, float f3) {
        return CoreDiagnosticsRenderer.tertiaryVal((f - f2) / Math.max(0.001f, f3 - f2));
    }

    private static float secondaryVal(float f) {
        float f2 = CoreDiagnosticsRenderer.tertiaryVal(f);
        return f2 * f2 * (3.0f - 2.0f * f2);
    }

    private static float tertiaryVal(float f) {
        return f < 0.0f ? 0.0f : Math.min(f, 1.0f);
    }

    private static float secondaryVal(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    private static float marginVal(float f) {
        return Math.round(f);
    }

    private static float primaryVal(float f, float f2) {
        return Math.max(0.0f, CoreDiagnosticsRenderer.marginVal(f + f2) - CoreDiagnosticsRenderer.marginVal(f));
    }
}

