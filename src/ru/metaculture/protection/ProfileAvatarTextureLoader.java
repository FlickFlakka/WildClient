/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.logging.LogUtils
 *  net.minecraft.class_2960
 *  net.minecraft.class_310
 *  net.minecraft.class_3298
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import com.mojang.logging.LogUtils;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Optional;
import javax.imageio.ImageIO;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3298;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import ru.metaculture.protection.GLStateSnapshot;

final class ProfileAvatarTextureLoader {
    private static final class_2960 primaryVal = class_2960.method_60655((String)"wild", (String)"textures/profile/gigachad.jpg");
    private static final int secondaryVal = 256;
    private static final float tertiaryVal = 0.45f;
    private static final float marginVal = 0.27f;
    private static final float weightVal = 0.42f;
    private static int paramVal;
    private static boolean extraVal;
    private static int overrideTextureId = -1;

    private ProfileAvatarTextureLoader() {
    }

    static int primaryVal() {
        if (overrideTextureId != -1) {
            return overrideTextureId;
        }
        if (!extraVal) {
            extraVal = true;
            paramVal = ProfileAvatarTextureLoader.secondaryVal();
        }
        return paramVal;
    }

    /**
     * Swaps in an external image (e.g. a downloaded Discord avatar) in place of the
     * bundled placeholder. Must be called on the render thread since it touches GL.
     */
    static void setOverrideTextureFromFile(java.io.File file) {
        try {
            BufferedImage image = ImageIO.read(file);
            if (image == null) {
                return;
            }
            BufferedImage square = new BufferedImage(256, 256, 2);
            Graphics2D graphics2D = square.createGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.drawImage(image, 0, 0, 256, 256, 0, 0, image.getWidth(), image.getHeight(), null);
            graphics2D.dispose();
            ByteBuffer byteBuffer = ProfileAvatarTextureLoader.secondaryVal(square);
            int newTextureId = ProfileAvatarTextureLoader.primaryVal(byteBuffer, 256, 256);
            if (overrideTextureId != -1) {
                GL11.glDeleteTextures(overrideTextureId);
            }
            overrideTextureId = newTextureId;
        } catch (Throwable throwable) {
            LogUtils.getLogger().error("[WildClient] failed to load discord avatar texture", throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static int secondaryVal() {
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 == null) return -1;
        if (class_3102.method_1478() == null) {
            return -1;
        }
        Optional optional = class_3102.method_1478().method_14486(primaryVal);
        if (optional.isEmpty()) {
            return -1;
        }
        try {
            BufferedImage bufferedImage;
            InputStream inputStream;
            block9: {
                int n2;
                inputStream = ((class_3298)optional.get()).method_14482();
                try {
                    bufferedImage = ImageIO.read(inputStream);
                    if (bufferedImage != null) break block9;
                    n2 = -1;
                    if (inputStream == null) return n2;
                }
                catch (Throwable throwable) {
                    if (inputStream == null) throw throwable;
                    try {
                        inputStream.close();
                        throw throwable;
                    }
                    catch (Throwable throwable2) {
                        throwable.addSuppressed(throwable2);
                    }
                    throw throwable;
                }
                inputStream.close();
                return n2;
            }
            BufferedImage bufferedImage2 = ProfileAvatarTextureLoader.primaryVal(bufferedImage);
            ByteBuffer byteBuffer = ProfileAvatarTextureLoader.secondaryVal(bufferedImage2);
            int n = ProfileAvatarTextureLoader.primaryVal(byteBuffer, bufferedImage2.getWidth(), bufferedImage2.getHeight());
            if (inputStream == null) return n;
            inputStream.close();
            return n;
        }
        catch (Throwable throwable3) {
            LogUtils.getLogger().error("[WildClient] failed to load profile avatar texture", throwable3);
            return -1;
        }
    }

    private static BufferedImage primaryVal(BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int n3 = Math.max(1, Math.min(Math.min(n, n2), Math.round(0.42f * (float)n2)));
        int n4 = Math.max(0, Math.min(n - n3, Math.round(0.45f * (float)n) - n3 / 2));
        int n5 = Math.max(0, Math.min(n2 - n3, Math.round(0.27f * (float)n2) - n3 / 2));
        BufferedImage bufferedImage2 = new BufferedImage(256, 256, 2);
        Graphics2D graphics2D = bufferedImage2.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(bufferedImage, 0, 0, 256, 256, n4, n5, n4 + n3, n5 + n3, null);
        graphics2D.dispose();
        return bufferedImage2;
    }

    private static ByteBuffer secondaryVal(BufferedImage bufferedImage) {
        int n = bufferedImage.getWidth();
        int n2 = bufferedImage.getHeight();
        int[] nArray = new int[n * n2];
        bufferedImage.getRGB(0, 0, n, n2, nArray, 0, n);
        ByteBuffer byteBuffer = BufferUtils.createByteBuffer((int)(n * n2 * 4));
        for (int i = 0; i < n2; ++i) {
            for (int j = 0; j < n; ++j) {
                int n3 = nArray[i * n + j];
                byteBuffer.put((byte)(n3 >> 16 & 0xFF));
                byteBuffer.put((byte)(n3 >> 8 & 0xFF));
                byteBuffer.put((byte)(n3 & 0xFF));
                byteBuffer.put((byte)(n3 >> 24 & 0xFF));
            }
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static int primaryVal(ByteBuffer byteBuffer, int n, int n2) {
        GLStateSnapshot.Snapshot modeVal = GLStateSnapshot.primaryVal();
        try {
            int n3 = GL11.glGenTextures();
            GL11.glBindTexture((int)3553, (int)n3);
            GL11.glPixelStorei((int)3317, (int)1);
            GL11.glTexParameteri((int)3553, (int)10241, (int)9987);
            GL11.glTexParameteri((int)3553, (int)10240, (int)9729);
            GL11.glTexParameteri((int)3553, (int)10242, (int)33071);
            GL11.glTexParameteri((int)3553, (int)10243, (int)33071);
            GL11.glTexImage2D((int)3553, (int)0, (int)32856, (int)n, (int)n2, (int)0, (int)6408, (int)5121, (ByteBuffer)byteBuffer);
            GL30.glGenerateMipmap((int)3553);
            int n4 = n3;
            return n4;
        }
        finally {
            GLStateSnapshot.tertiaryVal(modeVal);
        }
    }
}

