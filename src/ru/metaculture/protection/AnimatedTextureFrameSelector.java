/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import com.mojang.logging.LogUtils;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import net.minecraft.class_2960;
import net.minecraft.class_310;
import net.minecraft.class_3298;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public class AnimatedTextureFrameSelector {
    private final List<WildClient> primaryVal = new ArrayList<>();
    private int secondaryVal;

    /*
     * Reconstructed 2026-09-01 from bytecode (NUvnVVvun.<init>(class_2960))
     * via Vineflower + javap cross-check. Static GIF loader: composites each
     * frame onto an ARGB canvas and uploads one GL texture per frame.
     */
    public AnimatedTextureFrameSelector(class_2960 class_29602) {
        Optional optional = class_310.method_1551().method_1478().method_14486(class_29602);
        if (optional.isEmpty()) {
            LogUtils.getLogger().error("GIF file not found at path: {}", (Object)class_29602);
        } else {
            try (InputStream inputStream = ((class_3298)optional.get()).method_14482();
                 ImageInputStream imageInputStream = ImageIO.createImageInputStream(inputStream);) {
                ImageReader imageReader = ImageIO.getImageReadersByFormatName("gif").next();
                imageReader.setInput(imageInputStream);
                int n = imageReader.getNumImages(true);
                BufferedImage bufferedImage = null;
                Graphics2D graphics2D = null;
                int n2 = 0;
                int n3 = 0;
                for (int i = 0; i < n; ++i) {
                    BufferedImage bufferedImage2 = imageReader.read(i);
                    if (bufferedImage == null) {
                        n2 = bufferedImage2.getWidth();
                        n3 = bufferedImage2.getHeight();
                        bufferedImage = new BufferedImage(n2, n3, 2);
                        graphics2D = bufferedImage.createGraphics();
                        graphics2D.setBackground(new Color(0, 0, 0, 0));
                        graphics2D.clearRect(0, 0, n2, n3);
                    }
                    int n4 = 0;
                    int n5 = 0;
                    int n6 = 100;
                    String string = "none";
                    try {
                        Node node = imageReader.getImageMetadata(i).getAsTree("javax_imageio_gif_image_1.0");
                        for (int j = 0; j < node.getChildNodes().getLength(); ++j) {
                            Node node2 = node.getChildNodes().item(j);
                            if (node2.getNodeName().equals("ImageDescriptor")) {
                                NamedNodeMap namedNodeMap = node2.getAttributes();
                                if (namedNodeMap.getNamedItem("imageLeftPosition") != null) {
                                    n4 = Integer.parseInt(namedNodeMap.getNamedItem("imageLeftPosition").getNodeValue());
                                }
                                if (namedNodeMap.getNamedItem("imageTopPosition") != null) {
                                    n5 = Integer.parseInt(namedNodeMap.getNamedItem("imageTopPosition").getNodeValue());
                                }
                            } else if (node2.getNodeName().equals("GraphicControlExtension")) {
                                NamedNodeMap namedNodeMap = node2.getAttributes();
                                if (namedNodeMap.getNamedItem("delayTime") != null) {
                                    n6 = Integer.parseInt(namedNodeMap.getNamedItem("delayTime").getNodeValue()) * 10;
                                }
                                if (namedNodeMap.getNamedItem("disposalMethod") != null) {
                                    string = namedNodeMap.getNamedItem("disposalMethod").getNodeValue();
                                }
                            }
                        }
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                    if (n6 <= 0) {
                        n6 = 100;
                    }
                    graphics2D.drawImage(bufferedImage2, n4, n5, null);
                    int[] nArray = new int[n2 * n3];
                    bufferedImage.getRGB(0, 0, n2, n3, nArray, 0, n2);
                    if (string.equals("restoreToBackgroundColor")) {
                        graphics2D.clearRect(n4, n5, bufferedImage2.getWidth(), bufferedImage2.getHeight());
                    }
                    ByteBuffer byteBuffer = BufferUtils.createByteBuffer(n2 * n3 * 4);
                    for (int k = 0; k < n3; ++k) {
                        for (int l = 0; l < n2; ++l) {
                            int n7 = nArray[k * n2 + l];
                            byteBuffer.put((byte)(n7 >> 16 & 0xFF));
                            byteBuffer.put((byte)(n7 >> 8 & 0xFF));
                            byteBuffer.put((byte)(n7 & 0xFF));
                            byteBuffer.put((byte)(n7 >> 24 & 0xFF));
                        }
                    }
                    byteBuffer.flip();
                    int n8 = GL11.glGenTextures();
                    GL11.glBindTexture(3553, n8);
                    GL11.glPixelStorei(3317, 1);
                    GL11.glTexParameteri(3553, 10241, 9729);
                    GL11.glTexParameteri(3553, 10240, 9729);
                    GL11.glTexParameteri(3553, 10242, 33071);
                    GL11.glTexParameteri(3553, 10243, 33071);
                    GL11.glTexImage2D(3553, 0, 32856, n2, n3, 0, 6408, 5121, byteBuffer);
                    this.primaryVal.add(new WildClient(n8, n6));
                    this.secondaryVal += n6;
                }
                if (graphics2D != null) {
                    graphics2D.dispose();
                }
                imageReader.dispose();
            }
            catch (Exception exception) {
                LogUtils.getLogger().error("Error processing GIF file", exception);
            }
        }
    }

    public int primaryVal() {
        if (this.primaryVal.isEmpty()) {
            return -1;
        }
        if (this.primaryVal.size() == 1) {
            return this.primaryVal.getFirst().id();
        }
        int n = (int)(System.currentTimeMillis() % (long)Math.max(1, this.secondaryVal));
        int n2 = 0;
        for (WildClient modeVal : this.primaryVal) {
            if (n > (n2 += modeVal.delay())) continue;
            return modeVal.id();
        }
        return this.primaryVal.getLast().id();
    }

    record WildClient(int id, int delay) {
    }
}

