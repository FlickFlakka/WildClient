/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.blaze3d.textures.GpuTexture
 *  net.minecraft.class_1044
 *  net.minecraft.class_10868
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  org.lwjgl.opengl.GL11
 */
package ru.metaculture.protection;

import com.mojang.blaze3d.textures.GpuTexture;
import net.minecraft.class_1044;
import net.minecraft.class_10868;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import org.lwjgl.opengl.GL11;
import ru.metaculture.protection.ThemePalette;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.SurfaceTarget;
import ru.metaculture.protection.ThemeContext;
import ru.metaculture.protection.GuiMetrics;
import ru.metaculture.protection.UiRenderUtil;
import ru.metaculture.protection.FontRegistry;

public final class ThemePreviewRenderer {
    private ThemePreviewRenderer() {
    }

    public static void primaryVal(Renderer2D heightVal, ThemeContext nodeE, SurfaceTarget vnuVUNUv, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (vnuVUNUv == null) {
            vnuVUNUv = SurfaceTarget.PREVIEW_ONLY;
        }
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        switch (vnuVUNUv) {
            case BACKGROUND: 
            case MENU_BACKGROUND: {
                ThemePreviewRenderer.primaryVal(heightVal, cacheVal, configVal, f, f2, f3, f4, f7);
                break;
            }
            case MENU_PANEL_BG: {
                ThemePreviewRenderer.secondaryVal(heightVal, cacheVal, configVal, f, f2, f3, f4);
                break;
            }
            case HUD: 
            case HUD_OVERLAY: {
                ThemePreviewRenderer.marginVal(heightVal, cacheVal, configVal, f, f2, f3, f4);
                break;
            }
            case ESP: 
            case ESP_OVERLAY: {
                ThemePreviewRenderer.secondaryVal(heightVal, cacheVal, configVal, f, f2, f3, f4, f7);
                break;
            }
            case ENTITY_HIGHLIGHT: {
                ThemePreviewRenderer.extraVal(heightVal, cacheVal, configVal, f, f2, f3, f4);
                break;
            }
            case PREVIEW_ONLY: {
                ThemePreviewRenderer.primaryVal(heightVal, f, f2, f3, f4);
            }
        }
    }

    public static void primaryVal(Renderer2D heightVal, ThemeContext nodeE, SurfaceTarget vnuVUNUv, float f, float f2, float f3, float f4, float f5, float f6) {
        if (vnuVUNUv == null) {
            return;
        }
        GuiMetrics cacheVal = nodeE.weightVal();
        ThemePalette configVal = nodeE.paramVal();
        switch (vnuVUNUv) {
            case ENTITY_HIGHLIGHT: {
                ThemePreviewRenderer.limitVal(heightVal, cacheVal, configVal, f, f2, f3, f4);
                break;
            }
            case ESP: 
            case ESP_OVERLAY: {
                ThemePreviewRenderer.paramVal(heightVal, cacheVal, configVal, f, f2, f3, f4);
                break;
            }
            case HUD: 
            case HUD_OVERLAY: {
                ThemePreviewRenderer.weightVal(heightVal, cacheVal, configVal, f, f2, f3, f4);
                break;
            }
            case MENU_PANEL_BG: {
                ThemePreviewRenderer.tertiaryVal(heightVal, cacheVal, configVal, f, f2, f3, f4);
                break;
            }
            case BACKGROUND: 
            case MENU_BACKGROUND: {
                ThemePreviewRenderer.primaryVal(heightVal, cacheVal, configVal, f, f2, f3, f4);
                break;
            }
        }
    }

    private static void primaryVal(Renderer2D heightVal, float f, float f2, float f3, float f4) {
        heightVal.primaryVal(f, f2, f3, f4, 0.0f, ThemePalette.primaryVal(3, 5, 9, 240));
    }

    private static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5) {
        float f6;
        int n;
        heightVal.primaryVal(f, f2, f3, f4, 0.0f, ThemePalette.primaryVal(11, 13, 21, 232));
        int n2 = (int)(f3 / cacheVal.primaryVal(14.0f)) + 1;
        int n3 = (int)(f4 / cacheVal.primaryVal(14.0f)) + 1;
        for (n = 0; n < n2; ++n) {
            f6 = f + (float)n * cacheVal.primaryVal(14.0f);
            heightVal.primaryVal(f6, f2, 1.0f, f4, 0.0f, ThemePalette.primaryVal(255, 255, 255, 5));
        }
        for (n = 0; n < n3; ++n) {
            f6 = f2 + (float)n * cacheVal.primaryVal(14.0f);
            heightVal.primaryVal(f, f6, f3, 1.0f, 0.0f, ThemePalette.primaryVal(255, 255, 255, 5));
        }
        float f7 = (float)Math.sin((double)f5 * Math.PI * 2.0) * 0.5f + 0.5f;
        heightVal.primaryVal(f + f3 * 0.2f, f2 + f4 * 0.2f, f3 * 0.6f, f4 * 0.6f, Math.min(f3, f4) * 0.3f, Math.min(f3, f4) * 0.3f, Math.min(f3, f4) * 0.1f, ThemePalette.primaryVal(configVal.depthVal(), Math.round(18.0f + 22.0f * f7)));
    }

    private static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4) {
        float f5 = cacheVal.primaryVal(12.0f);
        float f6 = f + f5;
        float f7 = f2 + f5;
        float f8 = f3 - f5 * 2.0f;
        float f9 = f4 - f5 * 2.0f;
        heightVal.primaryVal(f6, f7, f8, f9, cacheVal.primaryVal(8.0f), ThemePalette.primaryVal(configVal.paramVal(), 132));
        heightVal.primaryVal(f6, f7, f8, f9, cacheVal.primaryVal(8.0f), ThemePalette.primaryVal(configVal.depthVal(), 96), 0.7f);
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.marginVal, f6 + cacheVal.primaryVal(10.0f), f7 + cacheVal.primaryVal(8.0f), 9.0f, "ClickGUI mock", configVal.countVal());
        float f10 = cacheVal.primaryVal(10.0f);
        for (int i = 0; i < 4; ++i) {
            heightVal.primaryVal(f6 + cacheVal.primaryVal(10.0f) + (float)i * cacheVal.primaryVal(14.0f), f7 + f9 - cacheVal.primaryVal(18.0f), f10, f10, f10 * 0.5f, ThemePalette.primaryVal(configVal.depthVal(), 156 - i * 28));
        }
    }

    private static void secondaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4) {
        heightVal.primaryVal(f, f2, f3, f4, 0.0f, ThemePalette.primaryVal(9, 11, 17, 232));
    }

    private static void tertiaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4) {
        float f5 = cacheVal.primaryVal(10.0f);
        float f6 = cacheVal.primaryVal(20.0f);
        heightVal.primaryVal(f + f5, f2 + f5, f3 - f5 * 2.0f, f6, cacheVal.primaryVal(6.0f), ThemePalette.primaryVal(255, 255, 255, 14));
        heightVal.primaryVal(f + f5 + cacheVal.primaryVal(6.0f), f2 + f5 + cacheVal.primaryVal(6.0f), cacheVal.primaryVal(8.0f), cacheVal.primaryVal(8.0f), 2.0f, configVal.depthVal());
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.marginVal, f + f5 + cacheVal.primaryVal(20.0f), f2 + f5 + cacheVal.primaryVal(4.0f), 9.0f, "Module name", configVal.countVal());
        float f7 = cacheVal.primaryVal(14.0f);
        float f8 = f2 + f5 + f6 + cacheVal.primaryVal(6.0f);
        for (int i = 0; i < 3; ++i) {
            heightVal.primaryVal(f + f5, f8 + (float)i * (f7 + cacheVal.primaryVal(4.0f)), f3 - f5 * 2.0f, f7, cacheVal.primaryVal(4.0f), ThemePalette.primaryVal(255, 255, 255, 12));
            heightVal.primaryVal(f + f5 + cacheVal.primaryVal(4.0f), f8 + (float)i * (f7 + cacheVal.primaryVal(4.0f)) + cacheVal.primaryVal(2.0f), cacheVal.primaryVal(8.0f), cacheVal.primaryVal(8.0f), 1.0f, ThemePalette.primaryVal(configVal.descRef(), 200));
        }
    }

    private static void marginVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4) {
        heightVal.primaryVal(f, f2, f3, f4, 0.0f, ThemePalette.primaryVal(35, 50, 78, 192));
        heightVal.primaryVal(f, f2 + f4 * 0.62f, f3, f4 * 0.38f, 0.0f, ThemePalette.primaryVal(56, 86, 52, 200));
        heightVal.primaryVal(f, f2 + f4 - cacheVal.primaryVal(4.0f), f3, cacheVal.primaryVal(4.0f), 0.0f, ThemePalette.primaryVal(28, 34, 22, 220));
    }

    private static void weightVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4) {
        float f5;
        int n;
        float f6 = cacheVal.primaryVal(160.0f);
        float f7 = cacheVal.primaryVal(20.0f);
        float f8 = f + (f3 - f6) * 0.5f;
        float f9 = f2 + f4 - f7 - cacheVal.primaryVal(10.0f);
        heightVal.primaryVal(f8, f9, f6, f7, 2.0f, ThemePalette.primaryVal(20, 22, 28, 200));
        heightVal.primaryVal(f8, f9, f6, f7, 2.0f, ThemePalette.primaryVal(50, 52, 62, 220), 0.7f);
        for (n = 0; n < 9; ++n) {
            f5 = f6 / 9.0f;
            heightVal.primaryVal(f8 + (float)n * f5 + 1.0f, f9 + 1.0f, f5 - 2.0f, f7 - 2.0f, 1.0f, n == 4 ? ThemePalette.primaryVal(220, 220, 220, 110) : ThemePalette.primaryVal(255, 255, 255, 16));
        }
        for (n = 0; n < 10; ++n) {
            f5 = f9 - cacheVal.primaryVal(12.0f);
            heightVal.primaryVal(f8 + (float)n * cacheVal.primaryVal(7.0f) + cacheVal.primaryVal(3.0f), f5, cacheVal.primaryVal(6.0f), cacheVal.primaryVal(6.0f), 1.0f, ThemePalette.primaryVal(220, 40, 40, 230));
        }
        for (n = 0; n < 10; ++n) {
            f5 = f9 - cacheVal.primaryVal(20.0f);
            heightVal.primaryVal(f8 + f6 - (float)(n + 1) * cacheVal.primaryVal(7.0f) - cacheVal.primaryVal(3.0f), f5, cacheVal.primaryVal(6.0f), cacheVal.primaryVal(6.0f), 1.0f, ThemePalette.primaryVal(54, 84, 250, 230));
        }
        heightVal.primaryVal(f8 + f6 * 0.5f - 1.0f, f2 + f4 * 0.5f - cacheVal.primaryVal(4.0f), 2.0f, cacheVal.primaryVal(8.0f), 0.0f, ThemePalette.primaryVal(255, 255, 255, 220));
        heightVal.primaryVal(f8 + f6 * 0.5f - cacheVal.primaryVal(4.0f), f2 + f4 * 0.5f - 1.0f, cacheVal.primaryVal(8.0f), 2.0f, 0.0f, ThemePalette.primaryVal(255, 255, 255, 220));
    }

    private static void secondaryVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        heightVal.primaryVal(f, f2, f3, f4, 0.0f, ThemePalette.primaryVal(14, 18, 28, 232));
        for (int i = 0; i < 20; ++i) {
            f7 = f + (float)(i * 67 % (int)f3);
            f6 = f2 + (float)(i * 41 % (int)f4);
            heightVal.primaryVal(f7, f6, 1.0f, 1.0f, 0.0f, ThemePalette.primaryVal(255, 255, 255, 22));
        }
        float f8 = (float)Math.sin((double)f5 * Math.PI * 2.0) * cacheVal.primaryVal(8.0f);
        f7 = cacheVal.primaryVal(40.0f);
        f6 = cacheVal.primaryVal(28.0f);
        ThemePreviewRenderer.primaryVal(heightVal, cacheVal, f + f3 * 0.28f + f8, f2 + f4 * 0.36f, f7 * 0.55f, f7, configVal.depthVal());
        ThemePreviewRenderer.primaryVal(heightVal, cacheVal, f + f3 * 0.6f - f8 * 0.6f, f2 + f4 * 0.48f, f6 * 0.55f, f6, configVal.descRef());
    }

    private static void primaryVal(Renderer2D heightVal, GuiMetrics cacheVal, float f, float f2, float f3, float f4, int n) {
        heightVal.primaryVal(f, f2, f3, f4, 1.0f, ThemePalette.primaryVal(n, 220), 1.2f);
        float f5 = f3 * 0.4f;
        heightVal.primaryVal(f + (f3 - f5) * 0.5f, f2 - f5 - 1.0f, f5, f5, 1.0f, ThemePalette.primaryVal(n, 80));
        heightVal.primaryVal(f + (f3 - f5) * 0.5f, f2 - f5 - 1.0f, f5, f5, 1.0f, ThemePalette.primaryVal(n, 220), 1.0f);
    }

    private static void paramVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4) {
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f + cacheVal.primaryVal(8.0f), f2 + cacheVal.primaryVal(6.0f), 8.0f, "ESP fill preview", ThemePalette.primaryVal(configVal.countVal(), 192));
    }

    private static void extraVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4) {
        heightVal.primaryVal(f, f2, f3, f4, 0.0f, ThemePalette.primaryVal(7, 9, 14, 240));
        float f5 = Math.min(f3, f4) * 0.55f;
        heightVal.primaryVal(f + f3 * 0.5f - f5 * 0.5f, f2 + f4 * 0.5f - f5 * 0.5f, f5, f5, f5 * 0.5f, f5 * 0.45f, f5 * 0.1f, ThemePalette.primaryVal(configVal.descRef(), 56));
        for (int i = 0; i < 6; ++i) {
            float f6 = (float)i / 6.0f;
            heightVal.primaryVal(f, f2 + f4 * f6, f3, 1.0f, 0.0f, ThemePalette.primaryVal(255, 255, 255, 6));
        }
    }

    private static void limitVal(Renderer2D heightVal, GuiMetrics cacheVal, ThemePalette configVal, float f, float f2, float f3, float f4) {
        float f5 = Math.min(f3, f4) * 0.36f;
        float f6 = f + (f3 - f5) * 0.5f;
        float f7 = f2 + (f4 - f5) * 0.5f - cacheVal.primaryVal(4.0f);
        boolean bl = false;
        try {
            class_310 class_3102 = class_310.method_1551();
            if (class_3102 != null && class_3102.field_1724 != null) {
                GpuTexture gpuTexture;
                class_2960 class_29602 = class_3102.method_1582().method_52862(class_3102.field_1724.method_7334()).comp_1626();
                class_1044 class_10443 = class_3102.method_1531().method_4619(class_29602);
                if (class_10443 != null && (gpuTexture = class_10443.method_68004()) instanceof class_10868) {
                    class_10868 class_108682 = (class_10868)gpuTexture;
                    if (class_108682.method_68427() > 0) {
                        int n = class_108682.method_68427();
                        GL11.glBindTexture((int)3553, (int)n);
                        GL11.glTexParameteri((int)3553, (int)10241, (int)9728);
                        GL11.glTexParameteri((int)3553, (int)10240, (int)9728);
                        heightVal.primaryVal(n, f6, f7, f5, f5, 0.125f, 0.125f, 0.25f, 0.25f, f5 * 0.18f);
                        heightVal.primaryVal(n, f6, f7, f5, f5, 0.625f, 0.125f, 0.75f, 0.25f, f5 * 0.18f);
                        bl = true;
                    }
                }
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        if (!bl) {
            heightVal.primaryVal(f6, f7, f5, f5, f5 * 0.18f, ThemePalette.primaryVal(configVal.depthVal(), 200));
            UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.marginVal, f6, f7, f5, f5 * 0.42f, "P", configVal.countVal());
        }
        heightVal.primaryVal(f6, f7, f5, f5, f5 * 0.18f, ThemePalette.primaryVal(configVal.depthVal(), 156), 0.8f);
        UiRenderUtil.primaryVal(heightVal, cacheVal, FontRegistry.primaryVal, f + cacheVal.primaryVal(8.0f), f2 + f4 - cacheVal.primaryVal(14.0f), 8.0f, "Entity overlay preview", ThemePalette.primaryVal(configVal.countVal(), 192));
    }
}

