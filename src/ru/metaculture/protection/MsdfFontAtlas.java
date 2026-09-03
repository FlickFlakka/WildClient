/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  it.unimi.dsi.fastutil.ints.Int2ObjectMap
 *  it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
 *  it.unimi.dsi.fastutil.longs.Long2FloatMap
 *  it.unimi.dsi.fastutil.longs.Long2FloatOpenHashMap
 *  it.unimi.dsi.fastutil.objects.ObjectIterator
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.stb.STBImage
 *  org.lwjgl.system.MemoryStack
 */
package ru.metaculture.protection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2FloatMap;
import it.unimi.dsi.fastutil.longs.Long2FloatOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Iterator;
import java.util.Objects;
import org.lwjgl.opengl.GL11;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import ru.metaculture.protection.UvnUNnnVnu;
import ru.metaculture.protection.Renderer2DBackend;

final class MsdfFontAtlas {
    private final String primaryVal;
    private final String secondaryVal;
    private final Int2ObjectMap<WildClient> tertiaryVal;
    private final Long2FloatMap marginVal;
    private volatile int weightVal;
    private final int paramVal;
    private final int extraVal;
    private final float limitVal;
    private final float speedVal;
    private final float widthVal;
    private final float chunkVal;
    private final float blockRef;
    private float holderVal;

    private MsdfFontAtlas(String string, String string2, int n, int n2, int n3, float f, float f2, float f3, float f4, float f5, Int2ObjectMap<WildClient> int2ObjectMap, Long2FloatMap long2FloatMap) {
        this.primaryVal = string;
        this.secondaryVal = string2;
        this.weightVal = n;
        this.paramVal = n2;
        this.extraVal = n3;
        this.limitVal = f;
        this.speedVal = f2;
        this.widthVal = f3;
        this.chunkVal = f4;
        this.blockRef = f5;
        this.tertiaryVal = int2ObjectMap;
        this.marginVal = long2FloatMap;
    }

    static MsdfFontAtlas primaryVal(Renderer2DBackend vnuUvuuNVNUU2, String string, String string2) {
        JsonArray jsonElement2;
        float f;
        float f2;
        Objects.requireNonNull(vnuUvuuNVNUU2, "backend");
        Objects.requireNonNull(string, "jsonResourcePath");
        Objects.requireNonNull(string2, "textureResourcePath");
        String string3 = UvnUNnnVnu.primaryVal(string);
        JsonObject jsonObject = JsonParser.parseString((String)string3).getAsJsonObject();
        JsonObject jsonObject2 = jsonObject.getAsJsonObject("atlas");
        if (jsonObject2 == null) {
            throw new IllegalStateException("Missing 'atlas' section in MSDF font: " + string);
        }
        int n = jsonObject2.get("width").getAsInt();
        int n2 = jsonObject2.get("height").getAsInt();
        if (n <= 0 || n2 <= 0) {
            throw new IllegalStateException("Invalid MSDF atlas dimensions in font: " + string);
        }
        float f3 = jsonObject2.has("distanceRange") ? jsonObject2.get("distanceRange").getAsFloat() : 6.0f;
        JsonObject jsonObject3 = jsonObject.getAsJsonObject("metrics");
        if (jsonObject3 == null) {
            throw new IllegalStateException("Missing 'metrics' section in MSDF font: " + string);
        }
        float f4 = jsonObject3.has("emSize") ? jsonObject3.get("emSize").getAsFloat() : 1.0f;
        float f5 = f2 = jsonObject3.has("lineHeight") ? jsonObject3.get("lineHeight").getAsFloat() : f4;
        float f6 = f = jsonObject3.has("ascender") ? jsonObject3.get("ascender").getAsFloat() : f2;
        float f7 = jsonObject3.has("descender") ? jsonObject3.get("descender").getAsFloat() : 0.0f;
        float f8 = Math.abs(f7);
        Int2ObjectOpenHashMap int2ObjectOpenHashMap = new Int2ObjectOpenHashMap();
        JsonArray jsonArray = jsonObject.getAsJsonArray("glyphs");
        if (jsonArray != null) {
            for (JsonElement glyphElement : jsonArray) {
                WildClient modeVal;
                JsonObject jsonObject4;
                JsonObject object = glyphElement.getAsJsonObject();
                int n3 = object.get("unicode").getAsInt();
                float f9 = object.has("advance") ? object.get("advance").getAsFloat() : 0.0f;
                JsonObject jsonObject5 = object.has("planeBounds") ? object.getAsJsonObject("planeBounds") : null;
                JsonObject jsonObject6 = jsonObject4 = object.has("atlasBounds") ? object.getAsJsonObject("atlasBounds") : null;
                if (jsonObject5 == null || jsonObject4 == null) {
                    modeVal = new WildClient(f9);
                } else {
                    float f10 = jsonObject5.get("left").getAsFloat();
                    float f11 = jsonObject5.get("bottom").getAsFloat();
                    float f12 = jsonObject5.get("right").getAsFloat();
                    float f13 = jsonObject5.get("top").getAsFloat();
                    float f14 = jsonObject4.get("left").getAsFloat();
                    float f15 = jsonObject4.get("bottom").getAsFloat();
                    float f16 = jsonObject4.get("right").getAsFloat();
                    float f17 = jsonObject4.get("top").getAsFloat();
                    modeVal = new WildClient(f9, f10, f11, f12, f13, f14, f15, f16, f17, n, n2);
                }
                int2ObjectOpenHashMap.put(n3, (Object)modeVal);
            }
        }
        Long2FloatOpenHashMap iterator = new Long2FloatOpenHashMap();
        iterator.defaultReturnValue(0.0f);
        jsonElement2 = jsonObject.getAsJsonArray("kerning");
        if (jsonElement2 != null) {
            Iterator<JsonElement> kerningIter = jsonElement2.iterator();
            while (kerningIter.hasNext()) {
                JsonElement jsonElement3 = kerningIter.next();
                JsonObject jsonObject7 = jsonElement3.getAsJsonObject();
                int n4 = jsonObject7.get("unicode1").getAsInt();
                int n5 = jsonObject7.get("unicode2").getAsInt();
                float f18 = jsonObject7.has("advance") ? jsonObject7.get("advance").getAsFloat() : 0.0f;
                iterator.put(MsdfFontAtlas.secondaryVal(n4, n5), f18);
            }
        }
        cursorVal object = MsdfFontAtlas.primaryVal(vnuUvuuNVNUU2, string2);
        return new MsdfFontAtlas(string, string2, object.textureId, object.width, object.height, f3, f4, f2, f, f8, (Int2ObjectMap<WildClient>)int2ObjectOpenHashMap, (Long2FloatMap)iterator);
    }

    void primaryVal(Renderer2DBackend vnuUvuuNVNUU2) {
        Objects.requireNonNull(vnuUvuuNVNUU2, "backend");
        int n = this.weightVal;
        try {
            cursorVal panelVal = MsdfFontAtlas.primaryVal(vnuUvuuNVNUU2, this.secondaryVal);
            if (panelVal.width != this.paramVal || panelVal.height != this.extraVal) {
                if (panelVal.textureId > 0) {
                    GL11.glDeleteTextures((int)panelVal.textureId);
                }
                return;
            }
            this.weightVal = panelVal.textureId;
        }
        catch (Throwable throwable) {
            return;
        }
        if (n > 0 && n != this.weightVal) {
            try {
                GL11.glDeleteTextures((int)n);
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static cursorVal primaryVal(Renderer2DBackend vnuUvuuNVNUU2, String string) {
        ByteBuffer byteBuffer = UvnUNnnVnu.secondaryVal(string);
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            cursorVal panelVal;
            IntBuffer intBuffer = memoryStack.mallocInt(1);
            IntBuffer intBuffer2 = memoryStack.mallocInt(1);
            IntBuffer intBuffer3 = memoryStack.mallocInt(1);
            ByteBuffer byteBuffer2 = STBImage.stbi_load_from_memory((ByteBuffer)byteBuffer, (IntBuffer)intBuffer, (IntBuffer)intBuffer2, (IntBuffer)intBuffer3, (int)4);
            if (byteBuffer2 == null) {
                throw new IllegalStateException("Failed to load MSDF atlas '" + string + "': " + STBImage.stbi_failure_reason());
            }
            try {
                int n = intBuffer.get(0);
                int n2 = intBuffer2.get(0);
                int n3 = vnuUvuuNVNUU2.primaryVal(n, n2, byteBuffer2);
                panelVal = new cursorVal(n3, n, n2);
            }
            catch (Throwable throwable) {
                STBImage.stbi_image_free((ByteBuffer)byteBuffer2);
                throw throwable;
            }
            STBImage.stbi_image_free((ByteBuffer)byteBuffer2);
            return panelVal;
        }
    }

    int primaryVal() {
        return this.weightVal;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    boolean secondaryVal() {
        int n = this.weightVal;
        if (n <= 0) return false;
        if (!GL11.glIsTexture((int)n)) return false;
        return true;
    }

    int tertiaryVal() {
        return this.paramVal;
    }

    int marginVal() {
        return this.extraVal;
    }

    float weightVal() {
        return this.limitVal;
    }

    float paramVal() {
        return this.speedVal;
    }

    float extraVal() {
        return this.widthVal;
    }

    float limitVal() {
        return this.chunkVal;
    }

    float speedVal() {
        return this.blockRef;
    }

    WildClient primaryVal(int n) {
        return (WildClient)this.tertiaryVal.get(n);
    }

    float widthVal() {
        float f = this.holderVal;
        if (f > 0.0f) {
            return f;
        }
        float f2 = 0.0f;
        ObjectIterator objectIterator = this.tertiaryVal.values().iterator();
        while (objectIterator.hasNext()) {
            WildClient modeVal = (WildClient)objectIterator.next();
            if (!modeVal.secondaryVal) continue;
            float f3 = modeVal.weightVal - modeVal.tertiaryVal;
            float f4 = Math.abs(modeVal.speedVal - modeVal.extraVal);
            if (!(f3 > 1.0E-5f) || !(f4 > 1.0E-6f)) continue;
            f2 = f4 * (float)this.paramVal / f3;
            break;
        }
        this.holderVal = f2 > 0.0f ? f2 : 1.0f;
        return this.holderVal;
    }

    float chunkVal() {
        return this.limitVal * 0.5f / this.widthVal();
    }

    float primaryVal(int n, int n2) {
        return this.marginVal.get(MsdfFontAtlas.secondaryVal(n, n2));
    }

    private static long secondaryVal(int n, int n2) {
        return (long)n << 32 | (long)n2 & 0xFFFFFFFFL;
    }

    static float primaryVal(float f) {
        return MsdfFontAtlas.primaryVal(f, 0.0f, 1.0f);
    }

    static float primaryVal(float f, float f2, float f3) {
        if (!Float.isFinite(f)) {
            return f2;
        }
        return Math.max(f2, Math.min(f3, f));
    }

    static final class WildClient {
        final float primaryVal;
        final boolean secondaryVal;
        final float tertiaryVal;
        final float marginVal;
        final float weightVal;
        final float paramVal;
        final float extraVal;
        final float limitVal;
        final float speedVal;
        final float widthVal;

        WildClient(float f) {
            this.primaryVal = f;
            this.secondaryVal = false;
            this.tertiaryVal = 0.0f;
            this.marginVal = 0.0f;
            this.weightVal = 0.0f;
            this.paramVal = 0.0f;
            this.extraVal = 0.0f;
            this.limitVal = 0.0f;
            this.speedVal = 0.0f;
            this.widthVal = 0.0f;
        }

        WildClient(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, int n, int n2) {
            this.primaryVal = f;
            this.secondaryVal = true;
            this.tertiaryVal = f2;
            this.marginVal = f3;
            this.weightVal = f4;
            this.paramVal = f5;
            float f10 = 1.0f / Math.max(1.0f, (float)n);
            float f11 = 1.0f / Math.max(1.0f, (float)n2);
            float f12 = MsdfFontAtlas.primaryVal(Math.min(f6, f8) * f10);
            float f13 = MsdfFontAtlas.primaryVal(Math.max(f6, f8) * f10);
            float f14 = MsdfFontAtlas.primaryVal(Math.min(f7, f9) * f11);
            float f15 = MsdfFontAtlas.primaryVal(Math.max(f7, f9) * f11);
            this.extraVal = MsdfFontAtlas.primaryVal(f12, 0.0f, 1.0f);
            this.speedVal = MsdfFontAtlas.primaryVal(f13, 0.0f, 1.0f);
            float f16 = MsdfFontAtlas.primaryVal(f14, 0.0f, 1.0f);
            float f17 = MsdfFontAtlas.primaryVal(f15, 0.0f, 1.0f);
            this.limitVal = 1.0f - f16;
            this.widthVal = 1.0f - f17;
        }
    }

    static final class cursorVal
     {
        final int textureId;
        final int width;
        final int height;

        cursorVal(int n, int n2, int n3) {
            this.textureId = n;
            this.width = n2;
            this.height = n3;
        }

        @Override
        public final String toString() {
            return "nvnNNunvv[" + "textureId=" + this.textureId + ", " + "width=" + this.width + ", " + "height=" + this.height + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.textureId, this.width, this.height);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            cursorVal that = (cursorVal)object;
            return java.util.Objects.equals(this.textureId, that.textureId) && java.util.Objects.equals(this.width, that.width) && java.util.Objects.equals(this.height, that.height);}

        public int textureId() {
            return this.textureId;
        }

        public int width() {
            return this.width;
        }

        public int height() {
            return this.height;
        }
    }
}

