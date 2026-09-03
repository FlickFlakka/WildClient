/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import ru.metaculture.protection.LerpUtil;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.VuuUvnvnuu;
import ru.metaculture.protection.MsdfFontAtlas;
import ru.metaculture.protection.FontObject;
import ru.metaculture.protection.Renderer2DBackend;

public final class FontRegistry {
    private static final Map<String, MsdfFontAtlas> speedVal = new HashMap<String, MsdfFontAtlas>();
    private static final Map<String, FontObject> widthVal = new HashMap<String, FontObject>();
    private static final Map<String, FontSource> chunkVal = new LinkedHashMap<String, FontSource>();
    private static Renderer2DBackend blockRef;
    private static boolean holderVal;
    private static boolean timerVal;
    private static long anchorVal;
    public static FontObject primaryVal;
    public static FontObject secondaryVal;
    public static FontObject tertiaryVal;
    public static FontObject marginVal;
    public static FontObject weightVal;
    public static FontObject paramVal;
    public static FontObject extraVal;
    public static FontObject limitVal;

    private FontRegistry() {
    }

    public static synchronized void primaryVal(Renderer2DBackend vnuUvuuNVNUU2, Renderer2D heightVal) {
        FontRegistry.primaryVal(vnuUvuuNVNUU2);
        Objects.requireNonNull(heightVal, "renderer");
        if (timerVal) {
            return;
        }
        heightVal.primaryVal(primaryVal, FontRegistry.primaryVal(primaryVal));
        heightVal.primaryVal(secondaryVal, FontRegistry.primaryVal(secondaryVal));
        heightVal.primaryVal(tertiaryVal, FontRegistry.primaryVal(tertiaryVal));
        heightVal.primaryVal(marginVal, FontRegistry.primaryVal(marginVal));
        heightVal.primaryVal(weightVal, FontRegistry.primaryVal(weightVal));
        heightVal.primaryVal(paramVal, FontRegistry.primaryVal(paramVal));
        heightVal.primaryVal(extraVal, FontRegistry.primaryVal(extraVal));
        heightVal.primaryVal(limitVal, FontRegistry.primaryVal(limitVal));
        timerVal = true;
    }

    public static synchronized FontObject primaryVal(String string, String string2, String string3) {
        FontRegistry.weightVal();
        Objects.requireNonNull(string, "id");
        Objects.requireNonNull(string2, "jsonResourcePath");
        Objects.requireNonNull(string3, "textureResourcePath");
        if (speedVal.containsKey(string)) {
            throw new IllegalStateException("Font already registered: " + string);
        }
        MsdfFontAtlas nNvnvuvVuUVU2 = MsdfFontAtlas.primaryVal(blockRef, string2, string3);
        speedVal.put(string, nNvnvuvVuUVU2);
        chunkVal.put(string, new FontSource(string2, string3));
        FontObject twigJ = new FontObject(string);
        widthVal.put(string, twigJ);
        return twigJ;
    }

    public static synchronized void primaryVal() {
        if (!holderVal || blockRef == null) {
            return;
        }
        for (Map.Entry<String, FontSource> entry : chunkVal.entrySet()) {
            String string = entry.getKey();
            MsdfFontAtlas nNvnvuvVuUVU2 = speedVal.get(string);
            if (nNvnvuvVuUVU2 != null) {
                nNvnvuvVuUVU2.primaryVal(blockRef);
                continue;
            }
            try {
                FontSource modeVal = entry.getValue();
                MsdfFontAtlas nNvnvuvVuUVU3 = MsdfFontAtlas.primaryVal(blockRef, modeVal.json, modeVal.texture);
                speedVal.put(string, nNvnvuvVuUVU3);
            }
            catch (Throwable throwable) {}
        }
    }

    public static synchronized void secondaryVal() {
        if (!holderVal || blockRef == null) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - anchorVal < 1000L) {
            return;
        }
        anchorVal = l;
        for (MsdfFontAtlas nNvnvuvVuUVU2 : speedVal.values()) {
            if (nNvnvuvVuUVU2 == null) continue;
            if (nNvnvuvVuUVU2.secondaryVal()) continue;
            nNvnvuvVuUVU2.primaryVal(blockRef);
        }
    }

    public static synchronized VuuUvnvnuu primaryVal(FontObject twigJ) {
        FontRegistry.weightVal();
        MsdfFontAtlas nNvnvuvVuUVU2 = FontRegistry.secondaryVal(twigJ);
        return new VuuUvnvnuu(blockRef, nNvnvuvVuUVU2);
    }

    public static synchronized float primaryVal(FontObject twigJ, int n, float f) {
        FontRegistry.weightVal();
        if (twigJ == null || f <= 0.0f) {
            return 0.0f;
        }
        MsdfFontAtlas nNvnvuvVuUVU2 = FontRegistry.secondaryVal(twigJ);
        MsdfFontAtlas.WildClient modeVal = nNvnvuvVuUVU2.primaryVal(n);
        if (modeVal == null || !modeVal.secondaryVal) {
            return 0.0f;
        }
        float f2 = Math.max(1.0E-6f, nNvnvuvVuUVU2.paramVal());
        float f3 = f / f2;
        return LerpUtil.primaryVal(modeVal.paramVal, modeVal.marginVal, f3);
    }

    public static synchronized float secondaryVal(FontObject twigJ, int n, float f) {
        FontRegistry.weightVal();
        if (twigJ == null || f <= 0.0f) {
            return 0.0f;
        }
        MsdfFontAtlas nNvnvuvVuUVU2 = FontRegistry.secondaryVal(twigJ);
        MsdfFontAtlas.WildClient modeVal = nNvnvuvVuUVU2.primaryVal(n);
        if (modeVal == null || !modeVal.secondaryVal) {
            return 0.0f;
        }
        float f2 = Math.max(1.0E-6f, nNvnvuvVuUVU2.paramVal());
        float f3 = f / f2;
        return LerpUtil.primaryVal(modeVal.tertiaryVal, modeVal.weightVal, f3);
    }

    public static synchronized FontObject primaryVal(String string) {
        FontRegistry.weightVal();
        FontObject twigJ = widthVal.get(string);
        if (twigJ == null) {
            throw new IllegalArgumentException("Font not registered: " + string);
        }
        return twigJ;
    }

    public static synchronized FontObject tertiaryVal() {
        FontRegistry.weightVal();
        return limitVal;
    }

    static synchronized MsdfFontAtlas secondaryVal(FontObject twigJ) {
        FontRegistry.weightVal();
        MsdfFontAtlas nNvnvuvVuUVU2 = speedVal.get(twigJ.primaryVal);
        if (nNvnvuvVuUVU2 == null) {
            throw new IllegalStateException("Font not registered: " + twigJ.primaryVal);
        }
        return nNvnvuvVuUVU2;
    }

    private static void primaryVal(Renderer2DBackend vnuUvuuNVNUU2) {
        Objects.requireNonNull(vnuUvuuNVNUU2, "backend");
        if (holderVal) {
            if (blockRef != vnuUvuuNVNUU2) {
                throw new IllegalStateException("FontRegistry already initialized with a different backend instance");
            }
            return;
        }
        blockRef = vnuUvuuNVNUU2;
        holderVal = true;
        FontRegistry.marginVal();
    }

    private static void marginVal() {
        primaryVal = FontRegistry.primaryVal("inter_medium", "assets/wild/fonts/medium.json", "assets/wild/fonts/medium.png");
        secondaryVal = FontRegistry.primaryVal("inter_medium_ext", "assets/wild/fonts/Inter_Medium.json", "assets/wild/fonts/Inter_Medium.png");
        tertiaryVal = FontRegistry.primaryVal("icons", "assets/wild/fonts/icons.json", "assets/wild/fonts/icons.png");
        marginVal = FontRegistry.primaryVal("inter_semibold", "assets/wild/fonts/semibold.json", "assets/wild/fonts/semibold.png");
        weightVal = FontRegistry.primaryVal("new_ico", "assets/wild/fonts/new_ico.json", "assets/wild/fonts/new_ico.png");
        paramVal = FontRegistry.primaryVal("notifff", "assets/wild/fonts/notifff.json", "assets/wild/fonts/notifff.png");
        extraVal = FontRegistry.primaryVal("waypoints", "assets/wild/fonts/waypoint_icons.json", "assets/wild/fonts/waypoint_icons.png");
        limitVal = FontRegistry.primaryVal("wild", "assets/wild/fonts/wild.json", "assets/wild/fonts/wildICO.png");
    }

    private static void weightVal() {
        if (!holderVal || blockRef == null) {
            throw new IllegalStateException("FontRegistry.initialize(backend, renderer) must be called before use");
        }
    }

    static {
        holderVal = false;
        timerVal = false;
    }

    static final class FontSource
     {
        final String json;
        final String texture;

        FontSource(String string, String string2) {
            this.json = string;
            this.texture = string2;
        }

        @Override
        public final String toString() {
            return "FontSource[" + "json=" + this.json + ", " + "texture=" + this.texture + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.json, this.texture);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            FontSource that = (FontSource)object;
            return java.util.Objects.equals(this.json, that.json) && java.util.Objects.equals(this.texture, that.texture);}

        public String json() {
            return this.json;
        }

        public String texture() {
            return this.texture;
        }
    }
}

