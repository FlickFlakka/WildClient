/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.LinkedHashMap;
import java.util.Map;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.VuuUvnvnuu;
import ru.metaculture.protection.FontObject;

public final class TextMeasureCache {
    private static final int primaryVal = 4096;
    private static final Map<CacheKey, TextSize> secondaryVal = new LinkedHashMap<CacheKey, TextSize>(1024, 0.75f, true){

        @Override
        protected boolean removeEldestEntry(Map.Entry<CacheKey, TextSize> entry) {
            return this.size() > 4096;
        }
    };

    private TextMeasureCache() {
    }

    public static TextSize primaryVal(FontObject twigJ, String string, float f) {
        CacheKey modeVal;
        TextSize panelVal;
        if (string == null) {
            string = "";
        }
        if ((panelVal = secondaryVal.get(modeVal = new CacheKey(twigJ, string, Float.floatToIntBits(f)))) != null) {
            return panelVal;
        }
        VuuUvnvnuu.cursorVal nvnNNunvv3 = Renderer2D.primaryVal(twigJ, string, f);
        panelVal = new TextSize(nvnNNunvv3.primaryVal, nvnNNunvv3.secondaryVal);
        secondaryVal.put(modeVal, panelVal);
        return panelVal;
    }

    public static float secondaryVal(FontObject twigJ, String string, float f) {
        return TextMeasureCache.primaryVal((FontObject)twigJ, (String)string, (float)f).primaryVal;
    }

    public static float tertiaryVal(FontObject twigJ, String string, float f) {
        return TextMeasureCache.primaryVal((FontObject)twigJ, (String)string, (float)f).secondaryVal;
    }

    public static void primaryVal() {
        secondaryVal.clear();
    }

    record CacheKey(FontObject font, String text, int sizeBits) {
    }

    public static final class TextSize {
        public final float primaryVal;
        public final float secondaryVal;

        TextSize(float f, float f2) {
            this.primaryVal = f;
            this.secondaryVal = f2;
        }
    }
}

