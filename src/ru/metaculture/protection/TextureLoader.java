/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.stb.STBImage
 *  org.lwjgl.system.MemoryStack
 */
package ru.metaculture.protection;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import ru.metaculture.protection.UvnUNnnVnu;
import ru.metaculture.protection.Renderer2DBackend;

public final class TextureLoader {
    private static Renderer2DBackend primaryVal;
    private static final Map<String, Integer> secondaryVal;
    private static final Set<String> tertiaryVal;
    private static int marginVal;

    private TextureLoader() {
    }

    public static void primaryVal(Renderer2DBackend vnuUvuuNVNUU2) {
        primaryVal = vnuUvuuNVNUU2;
    }

    public static int primaryVal(String string) {
        if (primaryVal == null) {
            throw new IllegalStateException("TextureLoader.initialize() must be called first");
        }
        Integer n = secondaryVal.get(string);
        if (n != null) {
            return n;
        }
        int n2 = TextureLoader.secondaryVal(string);
        if (n2 > 0) {
            secondaryVal.put(string, n2);
            return n2;
        }
        if (tertiaryVal.add(string)) {
            System.err.println("[TextureLoader] Falling back for: " + string);
        }
        return TextureLoader.primaryVal();
    }

    public static synchronized int primaryVal() {
        if (marginVal != 0) {
            return marginVal;
        }
        try {
            ByteBuffer byteBuffer = BufferUtils.createByteBuffer((int)4);
            byteBuffer.put((byte)0).put((byte)0).put((byte)0).put((byte)0).flip();
            int n = GL11.glGenTextures();
            if (n <= 0) {
                return 0;
            }
            int n2 = GL11.glGetInteger((int)32873);
            GL11.glBindTexture((int)3553, (int)n);
            GL11.glTexParameteri((int)3553, (int)10241, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
            GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
            GL11.glTexImage2D((int)3553, (int)0, (int)32856, (int)1, (int)1, (int)0, (int)6408, (int)5121, (ByteBuffer)byteBuffer);
            GL11.glBindTexture((int)3553, (int)n2);
            marginVal = n;
            return n;
        }
        catch (Throwable throwable) {
            return 0;
        }
    }

    private static int secondaryVal(String string) {
        ByteBuffer byteBuffer;
        try {
            byteBuffer = UvnUNnnVnu.secondaryVal(string);
        }
        catch (Exception exception) {
            System.err.println("Failed to read texture resource: " + string);
            exception.printStackTrace();
            return 0;
        }
        try (MemoryStack memoryStack = MemoryStack.stackPush();){
            IntBuffer intBuffer = memoryStack.mallocInt(1);
            IntBuffer intBuffer2 = memoryStack.mallocInt(1);
            IntBuffer intBuffer3 = memoryStack.mallocInt(1);
            ByteBuffer byteBuffer2 = STBImage.stbi_load_from_memory((ByteBuffer)byteBuffer, (IntBuffer)intBuffer, (IntBuffer)intBuffer2, (IntBuffer)intBuffer3, (int)4);
            if (byteBuffer2 == null) {
                System.err.println("Failed to decode texture: " + string + " - " + STBImage.stbi_failure_reason());
                int n = 0;
                return n;
            }
            int n = intBuffer.get(0);
            int n2 = intBuffer2.get(0);
            int n3 = primaryVal.primaryVal(n, n2, byteBuffer2);
            STBImage.stbi_image_free((ByteBuffer)byteBuffer2);
            System.out.println("[TextureLoader] Loaded: " + string + " (" + n + "x" + n2 + ") -> ID " + n3);
            int n4 = n3;
            return n4;
        }
    }

    public static void secondaryVal() {
        secondaryVal.clear();
        tertiaryVal.clear();
    }

    static {
        secondaryVal = new HashMap<String, Integer>();
        tertiaryVal = ConcurrentHashMap.newKeySet();
    }
}

