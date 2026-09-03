/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package ru.metaculture.protection;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import ru.metaculture.protection.StudioModelData;

public final class GlTextureCache {
    private static final GlTextureCache primaryVal = new GlTextureCache();
    private static final int secondaryVal = -1;
    private final Map<String, Integer> tertiaryVal = new HashMap<String, Integer>();

    private GlTextureCache() {
    }

    public static GlTextureCache primaryVal() {
        return primaryVal;
    }

    public int primaryVal(String string, int n, StudioModelData linkD) {
        StudioModelData.FingerprintCrypto unitC;
        block6: {
            block5: {
                if (linkD == null) {
                    return 0;
                }
                unitC = linkD.primaryVal(n);
                if (unitC == null) break block5;
                if (unitC.secondaryVal().length != 0) break block6;
            }
            return 0;
        }
        String string2 = string + "|" + n;
        Integer n2 = this.tertiaryVal.get(string2);
        if (n2 != null) {
            return n2 == -1 ? 0 : n2;
        }
        int n3 = this.primaryVal(unitC);
        this.tertiaryVal.put(string2, n3 <= 0 ? -1 : n3);
        return n3 <= 0 ? 0 : n3;
    }

    /*
     * Reconstructed 2026-09-01 from bytecode
     * via Vineflower + javap cross-check. Decodes the fingerprint texture data
     * with STB, uploads it as a GL texture, restores the previous GL state and
     * frees all native resources (STB image, MemoryStack, memAlloc buffer).
     */
    private int primaryVal(StudioModelData.FingerprintCrypto fingerprintCrypto) {
        byte[] byArray = fingerprintCrypto.secondaryVal();
        ByteBuffer byteBuffer = MemoryUtil.memAlloc(byArray.length);
        try {
            byteBuffer.put(byArray).flip();
            try (MemoryStack memoryStack = MemoryStack.stackPush()) {
                IntBuffer intBuffer = memoryStack.mallocInt(1);
                IntBuffer intBuffer2 = memoryStack.mallocInt(1);
                IntBuffer intBuffer3 = memoryStack.mallocInt(1);
                ByteBuffer byteBuffer2 = STBImage.stbi_load_from_memory(byteBuffer, intBuffer, intBuffer2, intBuffer3, 4);
                if (byteBuffer2 == null) {
                    System.out.println("[Studio] texture decode failed: " + STBImage.stbi_failure_reason());
                    return 0;
                }
                try {
                    int n = intBuffer.get(0);
                    int n2 = intBuffer2.get(0);
                    long l = (long)n * (long)n2 * 4L;
                    int n3 = GL11.glGetInteger(3379);
                    if (n <= 0 || n2 <= 0 || n > n3 || n2 > n3 || l > (long)byteBuffer2.remaining()) {
                        System.out.println("[Studio] invalid texture dimensions: " + n + "x" + n2);
                        return 0;
                    }
                    int n4 = GL11.glGetInteger(32873);
                    int n5 = GL11.glGetInteger(35055);
                    int n6 = GL11.glGetInteger(3317);
                    int n7 = GL11.glGetInteger(3314);
                    int n8 = GL11.glGetInteger(3315);
                    int n9 = GL11.glGetInteger(3316);
                    int n10 = GL11.glGetInteger(3312);
                    int n11 = GL11.glGetInteger(3313);
                    int n12 = 0;
                    try {
                        n12 = GL11.glGenTextures();
                        GL11.glBindTexture(3553, n12);
                        GL11.glTexParameteri(3553, 10241, 9728);
                        GL11.glTexParameteri(3553, 10240, 9728);
                        GL11.glTexParameteri(3553, 10242, 33071);
                        GL11.glTexParameteri(3553, 10243, 33071);
                        GL15.glBindBuffer(35052, 0);
                        GL11.glPixelStorei(3317, 1);
                        GL11.glPixelStorei(3314, 0);
                        GL11.glPixelStorei(3315, 0);
                        GL11.glPixelStorei(3316, 0);
                        GL11.glPixelStorei(3312, 0);
                        GL11.glPixelStorei(3313, 0);
                        GL11.glTexImage2D(3553, 0, 32856, n, n2, 0, 6408, 5121, byteBuffer2);
                    }
                    catch (Throwable throwable) {
                        if (n12 > 0) {
                            GL11.glDeleteTextures(n12);
                        }
                        System.out.println("[Studio] texture upload failed: " + throwable.getClass().getSimpleName() + ": " + throwable.getMessage());
                        return 0;
                    }
                    finally {
                        GL11.glPixelStorei(3313, n11);
                        GL11.glPixelStorei(3312, n10);
                        GL11.glPixelStorei(3316, n9);
                        GL11.glPixelStorei(3315, n8);
                        GL11.glPixelStorei(3314, n7);
                        GL11.glPixelStorei(3317, n6);
                        GL15.glBindBuffer(35052, n5);
                        GL11.glBindTexture(3553, n4);
                    }
                    return n12;
                }
                finally {
                    STBImage.stbi_image_free(byteBuffer2);
                }
            }
        }
        catch (Throwable throwable) {
            System.out.println("[Studio] texture upload failed: " + throwable.getClass().getSimpleName() + ": " + throwable.getMessage());
            return 0;
        }
        finally {
            MemoryUtil.memFree(byteBuffer);
        }
    }

    public void primaryVal(String string) {
        String string2 = string + "|";
        this.tertiaryVal.entrySet().removeIf(entry -> {
            if (((String)entry.getKey()).startsWith(string2)) {
                return false;
            }
            int n = (Integer)entry.getValue();
            if (n > 0) {
                try {
                    GL11.glDeleteTextures((int)n);
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            return true;
        });
    }
}

