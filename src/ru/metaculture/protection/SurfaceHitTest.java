/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class SurfaceHitTest {
    private SurfaceHitTest() {
    }

    public static WildClient primaryVal(cursorVal panelVal, float f, float f2) {
        boolean bl;
        if (panelVal == null || panelVal.main() == null) {
            return WildClient.NONE;
        }
        boolean bl2 = panelVal.main().contains(f, f2);
        boolean bl3 = bl = panelVal.themeRendered() && panelVal.theme() != null && panelVal.theme().contains(f, f2);
        if (bl && (!bl2 || panelVal.themeOnTop())) {
            return new WildClient(DelayedFuse.THEME, panelVal.themeInteractive(), panelVal.theme().localX(f), panelVal.theme().localY(f2));
        }
        if (bl2) {
            return new WildClient(DelayedFuse.MAIN, true, panelVal.main().localX(f), panelVal.main().localY(f2));
        }
        if (bl) {
            return new WildClient(DelayedFuse.THEME, panelVal.themeInteractive(), panelVal.theme().localX(f), panelVal.theme().localY(f2));
        }
        return WildClient.NONE;
    }

    public record cursorVal(VvunVVUvUNnv main, VvunVVUvUNnv theme, boolean themeRendered, boolean themeInteractive, boolean themeOnTop) {
    }

    public record VvunVVUvUNnv(float x, float y, float width, float height, float radius, float scale) {
        public VvunVVUvUNnv {
            width = Math.max(0.0f, width);
            height = Math.max(0.0f, height);
            radius = Math.max(0.0f, Math.min(radius, Math.min(width, height) * 0.5f));
            scale = Math.max(0.001f, scale);
        }

        public boolean contains(float f, float f2) {
            float f3 = this.x + this.width * 0.5f;
            float f4 = this.y + this.height * 0.5f;
            float f5 = f3 + (f - f3) / this.scale;
            float f6 = f4 + (f2 - f4) / this.scale;
            float f7 = this.width * 0.5f;
            float f8 = this.height * 0.5f;
            float f9 = Math.abs(f5 - f3) - f7 + this.radius;
            float f10 = Math.abs(f6 - f4) - f8 + this.radius;
            float f11 = Math.max(f9, 0.0f);
            float f12 = Math.max(f10, 0.0f);
            float f13 = Math.min(Math.max(f9, f10), 0.0f) + (float)Math.sqrt(f11 * f11 + f12 * f12) - this.radius;
            return f13 <= 0.0f;
        }

        public float localX(float f) {
            float f2 = this.x + this.width * 0.5f;
            return f2 + (f - f2) / this.scale;
        }

        public float localY(float f) {
            float f2 = this.y + this.height * 0.5f;
            return f2 + (f - f2) / this.scale;
        }
    }

    public record WildClient(DelayedFuse surface, boolean interactive, float localX, float localY) {
        static final WildClient NONE = new WildClient(DelayedFuse.NONE, false, 0.0f, 0.0f);

        public boolean blocksLower() {
            return this.surface != DelayedFuse.NONE;
        }
    }

    public enum DelayedFuse {
    NONE,
    MAIN,
    THEME;
}
}

