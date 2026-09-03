package ru.metaculture.protection;

import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import net.minecraft.class_10868;
import net.minecraft.class_276;
import net.minecraft.class_310;
import org.lwjgl.opengl.ARBDrawInstanced;
import org.lwjgl.opengl.ARBInstancedArrays;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GL31;
import org.lwjgl.opengl.GL33;
import org.lwjgl.opengl.GL43;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.opengl.GLDebugMessageCallback;
import org.lwjgl.opengl.KHRDebug;

public final class Renderer2DBackend {
   private static final int primaryVal = 4096;
   private static final int secondaryVal = 16;
   private static final int tertiaryVal = 144;
   private static final int marginVal = 0;
   private static final int weightVal = 1;
   private static final int paramVal = 2;
   private static final int extraVal = 3;
   private static final int limitVal = 16;
   private static final int speedVal = 32;
   private static final int widthVal = 64;
   private static final int chunkVal = 128;
   private static final int blockRef = 67108864;
   private static final int holderVal = 134217728;
   private static final int timerVal = 268435456;
   private static final int anchorVal = 29;
   private static final int weightRef = 7;
   private static final float[] bufferVal = new float[]{1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F};
   private final boolean countVal;
   private final boolean depthVal;
   private final boolean descRef;
   private final boolean activeVal;
   private final ShaderProgram radiusVal;
   private final int factorVal;
   private final int sourceVal;
   private final int extraRef;
   private final ByteBuffer phaseVal;
   private int limitRef = 0;
   private GLStateSnapshot.Snapshot paramRef;
   private int groupVal;
   private int layerVal;
   private int slotVal = -1;
   private int themeVal = -1;
   private boolean stageVal = false;
   private int widthRef = 0;
   private int trackVal = 0;
   private int modeRef = Integer.MAX_VALUE;
   private int angleVal = Integer.MAX_VALUE;
   private float heightRef = 0.0F;
   private float levelVal = 0.0F;
   private float UuNnnVnuNNV = 0.0F;
   private float depthRef = 0.0F;
   private final Int2IntOpenHashMap speedRef = new Int2IntOpenHashMap(16);
   private final int[] countRef = new int[16];
   private final int[] entryVal = new int[16];
   private int guardVal = 0;
   private int VUuuVUnun = -1;
   private boolean vVVuuVVv = false;
   private int VuunNUUUvu = 0;
   private int NNUUNUuVNNVn = 0;
   private int VvVvnNUnvuvV = 0;
   private int tokenVal = 0;
   private int NUVvUUVuVNVv = 0;
   private int nodeB = 0;
   private int UNvvunVVn = 0;
   private int UnvuVuVnNuvu = 0;
   private float UvNNVUVNVuvV = 0.5F;
   private float NnunUUnU = 0.5F;
   private int nvuVvuNnNUnv = 0;
   private int nodeF = 0;
   private int nodeH = 0;
   private int OCOocoOoOO = 0;
   private final DepthRenderTarget o0Ooc0COOoc = new DepthRenderTarget();
   private int twigB = 0;
   private int UnUUVuVunvVu = 0;
   private int twigC = 0;
   private ShaderProgram UVnuVUUVnnU;
   private int VunnVNvNV = -1;
   private final Renderer2DBackend.VvunVVUvUNnv twigD = new Renderer2DBackend.VvunVVUvUNnv();
   private int nodeD = 0;
   private int NnuUnUNnu = 0;
   private ShaderProgram UnnnvvU;
   private int VUUnuVvVu = -1;
   private int VvVuvUvvNNVv = -1;
   private int UnnNNvuvvUU = -1;
   private int twigA = -1;
   private int itemC = -1;
   private int itemB = -1;
   private int VvuUUUNNNv = -1;
   private int uuuVnuvnnNnU = -1;
   private int nodeJ = -1;
   private int twigH = -1;
   private int vuvvuVuVv = -1;
   private int uunNUuunVU = -1;
   private int NvnuuuvnVV = -1;
   private int NnUVNnuvUv = -1;
   private final float[] UuuuNNunN = new float[24];
   private final List<Renderer2DBackend.VvunVVUvUNnv> NNVNuUvVn = new ArrayList<>();
   private int vuNnuUnu = 0;
   private int uuvvuNvuUNVV = 0;
   private int uVvunVUNuUvu = 0;
   private ShaderProgram NVNnnvVnvV;
   private int vUNuuvvnVnv = -1;
   private int unnnNUNnVu = -1;
   private int twigF = -1;
   private int itemG = -1;
   private int nvuUVvuuN = -1;
   private int itemJ = -1;
   private int spanC = -1;
   private int VnnnvUunNvuu = -1;
   private int VuuUVVu = -1;
   private int partJ = -1;
   private int VuNVnvNNuNnn = -1;
   private int uvVuuuvvVU = -1;
   private int NNnvvunuVNUn = -1;
   private int nVuuUnnUUVU = -1;
   private final float[] nUununvNvvn = new float[24];
   private ShaderProgram NuvunVvnnN;
   private int vuvnnvuNVvu = -1;
   private int NVvnvnn = -1;
   private int partG = -1;
   private int NUuVnnuUnvu = -1;
   private int vnuNNVvVVuN = -1;
   private int Oco0Oococc = -1;
   private int itemF = -1;
   private int spanA = -1;
   private int UvuVvvVuUuuu = -1;
   private int NUUVUvvuNNVU = -1;
   private int VUNvNUuNVnn = -1;
   private int UNNunNuUNVuU = -1;
   private int itemE = -1;
   private int VUVvNvvVUN = -1;
   private int UvvNuvUNNNUv = -1;
   private int NunUUVVVuu = -1;
   private int spanE = -1;
   private int vvVVVvVNVVVN = -1;
   private ShaderProgram uUuuVvVunVVu;
   private int partA = -1;
   private int vunuUUVVUv = -1;
   private int uuuNUnuvvNNv = -1;
   private int unUVnu = -1;
   private int NvNUuuuvUvu = -1;
   private int nNVVUnuVVVuV = -1;
   private int vnVuunuNN = -1;
   private int UvUNuNvvNVNv = -1;
   private int partB = -1;
   private int UVUnUvUNU = -1;
   private int UvUnnnn = -1;
   private int partF = -1;
   private int VnvunuuvUNu = -1;
   private final GLStateSnapshot.Snapshot spanF = new GLStateSnapshot.Snapshot();
   private GLDebugMessageCallback spanG;
   private final NvNNUUUNVNnU vNUUvuuVU = new NvNNUUUNVNnU(32856, 5121);
   private final NvNNUUUNVNnU unitB = new NvNNUUUNVNnU(32856, 5121);
   private int UvNNNUvNnUUV = 0;
   private int spanH = 0;
   private int OCCc0co0OOC = 0;
   private float unUvvVVVVUu = 1.0F;
   private float unitG = 1.0F;
   private int unitI = 0;
   private int NunnVUUuvUV = 0;
   private int unitD = 0;
   private int VNvuVnvnun = 0;
   private int unVVnuunNU = 0;
   private boolean vVnuVVvVNuNu = false;
   private boolean cellD = false;
   private static final ConcurrentHashMap<Integer, Long> nvnUvvnUUN = new ConcurrentHashMap<>();
   private static final AtomicLong uuuvuUUNVVUN = new AtomicLong();
   private static final AtomicInteger linkJ = new AtomicInteger();
   private static final long NvUVuUNUUNvv = 5000L;
   private static final long NnvVNVnn = 1000L;
   private static final int linkA = 8;

   private static int primaryVal(int var0) {
      int var1 = var0 >> 16 & 0xFF;
      int var2 = var0 >> 8 & 0xFF;
      int var3 = var0 & 0xFF;
      int var4 = var0 >>> 24 & 0xFF;
      return var4 << 24 | var3 << 16 | var2 << 8 | var1;
   }

   private void paramVal() {
      this.secondaryVal(1);
   }

   private void secondaryVal(int var1) {
      if (var1 > 0) {
         if (var1 > 4096) {
            throw new IllegalArgumentException("additionalInstances must be between 1 and 4096");
         }

         if (this.limitRef + var1 > 4096) {
            this.secondaryVal();
            this.limitRef = 0;
            this.phaseVal.clear();
            this.extraVal();
         }
      }
   }

   private void extraVal() {
      this.speedRef.clear();
      this.guardVal = 0;
   }

   public Renderer2DBackend() {
      this.speedRef.defaultReturnValue(-1);
      GLCapabilities var1 = GL.getCapabilities();
      this.countVal = var1.OpenGL43;
      this.depthVal = var1.OpenGL43 || var1.GL_KHR_debug;
      boolean var2 = var1.glVertexAttribDivisor != 0L;
      boolean var3 = var1.glVertexAttribDivisorARB != 0L;
      boolean var4 = var1.glDrawArraysInstanced != 0L;
      boolean var5 = var1.glDrawArraysInstancedARB != 0L;
      boolean var6 = var2 || var3;
      boolean var7 = var4 || var5;
      this.descRef = !var2 && var3;
      this.activeVal = !var4 && var5;
      if (this.countVal || var6 && var7) {
         String var8 = this.countVal ? "assets/wild/shaders/shape.vert" : "assets/wild/shaders/shape_compat.vert";
         String var9 = UvnUNnnVnu.primaryVal(var8);
         String var10 = UvnUNnnVnu.primaryVal("assets/wild/shaders/shape.frag");
         this.radiusVal = new ShaderProgram(var9, var10);
         this.factorVal = GL30.glGenVertexArrays();
         int var11 = GL15.glGenBuffers();
         GL30.glBindVertexArray(this.factorVal);
         GL15.glBindBuffer(34962, var11);
         float[] var12 = new float[]{-0.02F, -0.02F, 2.04F, -0.02F, -0.02F, 2.04F};
         GL15.glBufferData(34962, var12, 35044);
         GL20.glEnableVertexAttribArray(0);
         GL20.glVertexAttribPointer(0, 2, 5126, false, 0, 0L);
         int var13 = 0;
         if (!this.countVal) {
            var13 = GL15.glGenBuffers();
            GL15.glBindBuffer(34962, var13);
            GL15.glBufferData(34962, 589824L, 35040);
            short var14 = 144;
            long var15 = 0L;
            GL20.glEnableVertexAttribArray(1);
            GL20.glVertexAttribPointer(1, 4, 5126, false, var14, var15);
            this.paramVal(1, 1);
            var15 += 16L;
            GL20.glEnableVertexAttribArray(2);
            GL20.glVertexAttribPointer(2, 4, 5126, false, var14, var15);
            this.paramVal(2, 1);
            var15 += 16L;
            GL20.glEnableVertexAttribArray(3);
            GL30.glVertexAttribIPointer(3, 4, 5124, var14, var15);
            this.paramVal(3, 1);
            var15 += 16L;
            GL20.glEnableVertexAttribArray(4);
            GL20.glVertexAttribPointer(4, 4, 5126, false, var14, var15);
            this.paramVal(4, 1);
            var15 += 16L;
            GL20.glEnableVertexAttribArray(5);
            GL20.glVertexAttribPointer(5, 4, 5126, false, var14, var15);
            this.paramVal(5, 1);
            var15 += 16L;
            GL20.glEnableVertexAttribArray(6);
            GL30.glVertexAttribIPointer(6, 4, 5125, var14, var15);
            this.paramVal(6, 1);
            var15 += 16L;
            GL20.glEnableVertexAttribArray(7);
            GL20.glVertexAttribPointer(7, 4, 5126, false, var14, var15);
            this.paramVal(7, 1);
            var15 += 16L;
            GL20.glEnableVertexAttribArray(8);
            GL20.glVertexAttribPointer(8, 4, 5126, false, var14, var15);
            this.paramVal(8, 1);
            var15 += 16L;
            GL20.glEnableVertexAttribArray(9);
            GL30.glVertexAttribIPointer(9, 1, 5124, var14, var15);
            this.paramVal(9, 1);
            var15 += 4L;
            GL20.glEnableVertexAttribArray(10);
            GL30.glVertexAttribIPointer(10, 1, 5124, var14, var15);
            this.paramVal(10, 1);
            GL15.glBindBuffer(34962, 0);
         }

         GL15.glBindBuffer(34962, 0);
         GL30.glBindVertexArray(0);
         this.extraRef = var13;
         this.phaseVal = ByteBuffer.allocateDirect(589824).order(ByteOrder.nativeOrder());
         if (this.countVal) {
            this.sourceVal = GL15.glGenBuffers();
            GL15.glBindBuffer(37074, this.sourceVal);
            GL15.glBufferData(37074, 589824L, 35040);
            GL15.glBindBuffer(37074, 0);
         } else {
            this.sourceVal = 0;
         }

         if (this.depthVal) {
            this.primaryVal(var1);
         }
      } else {
         throw new IllegalStateException("OpenGL instanced rendering is required when shader storage buffers are unavailable");
      }
   }

   private void limitVal() {
      if (this.UnUUVuVunvVu == 0) {
         this.UnUUVuVunvVu = GL30.glGenVertexArrays();
         this.twigC = GL15.glGenBuffers();
         GL30.glBindVertexArray(this.UnUUVuVunvVu);
         GL15.glBindBuffer(34962, this.twigC);
         float[] var1 = new float[]{
            -1.0F,
            -1.0F,
            0.0F,
            0.0F,
            1.0F,
            -1.0F,
            1.0F,
            0.0F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            -1.0F,
            -1.0F,
            0.0F,
            0.0F,
            1.0F,
            1.0F,
            1.0F,
            1.0F,
            -1.0F,
            1.0F,
            0.0F,
            1.0F
         };
         GL15.glBufferData(34962, var1, 35044);
         byte var2 = 16;
         GL20.glEnableVertexAttribArray(0);
         GL20.glVertexAttribPointer(0, 2, 5126, false, var2, 0L);
         GL20.glEnableVertexAttribArray(1);
         GL20.glVertexAttribPointer(1, 2, 5126, false, var2, 8L);
         GL15.glBindBuffer(34962, 0);
         GL30.glBindVertexArray(0);
      }
   }

   private ShaderProgram speedVal() {
      if (this.UVnuVUUVnnU != null) {
         return this.UVnuVUUVnnU;
      }

      String var1 = UvnUNnnVnu.primaryVal("assets/wild/shaders/blur/blur_fullscreen.vert");
      String var2 = "#version 330 core\nlayout(location = 0) out vec4 fragColor;\nin vec2 vUv;\nuniform sampler2D uSource;\nvoid main() {\n    fragColor = texture(uSource, vUv);\n}";
      this.UVnuVUUVnnU = new ShaderProgram(var1, var2);
      this.VunnVNvNV = this.UVnuVUUVnnU.primaryVal("uSource");
      return this.UVnuVUUVnnU;
   }

   private void widthVal() {
      if (this.nodeD == 0) {
         this.nodeD = GL30.glGenVertexArrays();
         this.NnuUnUNnu = GL15.glGenBuffers();
         GL30.glBindVertexArray(this.nodeD);
         GL15.glBindBuffer(34962, this.NnuUnUNnu);
         GL15.glBufferData(34962, 96L, 35040);
         byte var1 = 16;
         GL20.glEnableVertexAttribArray(0);
         GL20.glVertexAttribPointer(0, 2, 5126, false, var1, 0L);
         GL20.glEnableVertexAttribArray(1);
         GL20.glVertexAttribPointer(1, 2, 5126, false, var1, 8L);
         GL15.glBindBuffer(34962, 0);
         GL30.glBindVertexArray(0);
      }

      if (this.UnnnvvU == null) {
         this.UnnnvvU = ShaderProgram.primaryVal("assets/wild/shaders/postfx/scroll_layer.vert", "assets/wild/shaders/postfx/scroll_layer.frag");
         this.VUUnuVvVu = this.UnnnvvU.primaryVal("uSource");
         this.VvVuvUvvNNVv = this.UnnnvvU.primaryVal("uViewport");
         this.UnnNNvuvvUU = this.UnnnvvU.primaryVal("uSize");
         this.twigA = this.UnnnvvU.primaryVal("uTextureSize");
         this.itemC = this.UnnnvvU.primaryVal("uRadii");
         this.itemB = this.UnnnvvU.primaryVal("uClipRect");
         this.VvuUUUNNNv = this.UnnnvvU.primaryVal("uClipRadii");
         this.uuuVnuvnnNnU = this.UnnnvvU.primaryVal("uFadePx");
         this.nodeJ = this.UnnnvvU.primaryVal("uEdgeBlurPx");
         this.twigH = this.UnnnvvU.primaryVal("uMotionBlurPx");
         this.vuvvuVuVv = this.UnnnvvU.primaryVal("uMotionStrength");
         this.uunNUuunVU = this.UnnnvvU.primaryVal("uFocusStrength");
         this.NvnuuuvnVV = this.UnnnvvU.primaryVal("uDirection");
         this.NnUVNnuvUv = this.UnnnvvU.primaryVal("uAlpha");
      }
   }

   private void chunkVal() {
      if (this.uuvvuNvuUNVV == 0) {
         this.uuvvuNvuUNVV = GL30.glGenVertexArrays();
         this.uVvunVUNuUvu = GL15.glGenBuffers();
         GL30.glBindVertexArray(this.uuvvuNvuUNVV);
         GL15.glBindBuffer(34962, this.uVvunVUNuUvu);
         GL15.glBufferData(34962, 96L, 35040);
         byte var1 = 16;
         GL20.glEnableVertexAttribArray(0);
         GL20.glVertexAttribPointer(0, 2, 5126, false, var1, 0L);
         GL20.glEnableVertexAttribArray(1);
         GL20.glVertexAttribPointer(1, 2, 5126, false, var1, 8L);
         GL15.glBindBuffer(34962, 0);
         GL30.glBindVertexArray(0);
      }

      if (this.NVNnnvVnvV == null) {
         this.NVNnnvVnvV = ShaderProgram.primaryVal("assets/wild/shaders/card_transition.vert", "assets/wild/shaders/card_transition.frag");
         this.vUNuuvvnVnv = this.NVNnnvVnvV.primaryVal("u_texture");
         this.unnnNUNnVu = this.NVNnnvVnvV.primaryVal("u_viewport");
         this.twigF = this.NVNnnvVnvV.primaryVal("u_resolution");
         this.itemG = this.NVNnnvVnvV.primaryVal("u_time");
         this.nvuUVvuuN = this.NVNnnvVnvV.primaryVal("u_progress");
         this.itemJ = this.NVNnnvVnvV.primaryVal("u_color");
         this.spanC = this.NVNnnvVnvV.primaryVal("u_borderColor");
         this.VnnnvUunNvuu = this.NVNnnvVnvV.primaryVal("u_emissiveColor");
         this.VuuUVVu = this.NVNnnvVnvV.primaryVal("u_emissiveColor2");
         this.partJ = this.NVNnnvVnvV.primaryVal("u_radius");
         this.VuNVnvNNuNnn = this.NVNnnvVnvV.primaryVal("u_alpha");
         this.uvVuuuvvVU = this.NVNnnvVnvV.primaryVal("u_clipRect");
         this.NNnvvunuVNUn = this.NVNnnvVnvV.primaryVal("u_clipRadii");
         this.nVuuUnnUUVU = this.NVNnnvVnvV.primaryVal("u_textureScale");
      }
   }

   private void blockRef() {
      this.chunkVal();
      if (this.NuvunVvnnN == null) {
         this.NuvunVvnnN = ShaderProgram.primaryVal("assets/wild/shaders/card_transition.vert", "assets/wild/shaders/entity/nametag_plasma.frag");
         this.vuvnnvuNVvu = this.NuvunVvnnN.primaryVal("u_texture");
         this.NVvnvnn = this.NuvunVvnnN.primaryVal("u_viewport");
         this.partG = this.NuvunVvnnN.primaryVal("u_resolution");
         this.NUuVnnuUnvu = this.NuvunVvnnN.primaryVal("u_time");
         this.vnuNNVvVVuN = this.NuvunVvnnN.primaryVal("u_progress");
         this.Oco0Oococc = this.NuvunVvnnN.primaryVal("u_contentReveal");
         this.itemF = this.NuvunVvnnN.primaryVal("u_focus");
         this.spanA = this.NuvunVvnnN.primaryVal("u_threat");
         this.UvuVvvVuUuuu = this.NuvunVvnnN.primaryVal("u_exposure");
         this.NUUVUvvuNNVU = this.NuvunVvnnN.primaryVal("u_color");
         this.VUNvNUuNVnn = this.NuvunVvnnN.primaryVal("u_borderColor");
         this.UNNunNuUNVuU = this.NuvunVvnnN.primaryVal("u_emissiveColor");
         this.itemE = this.NuvunVvnnN.primaryVal("u_emissiveColor2");
         this.VUVvNvvVUN = this.NuvunVvnnN.primaryVal("u_radius");
         this.UvvNuvUNNNUv = this.NuvunVvnnN.primaryVal("u_alpha");
         this.NunUUVVVuu = this.NuvunVvnnN.primaryVal("u_clipRect");
         this.spanE = this.NuvunVvnnN.primaryVal("u_clipRadii");
         this.vvVVVvVNVVVN = this.NuvunVvnnN.primaryVal("u_textureScale");
      }
   }

   private void holderVal() {
      this.chunkVal();
      if (this.uUuuVvVunVVu == null) {
         this.uUuuVvVunVVu = ShaderProgram.primaryVal("assets/wild/shaders/card_transition.vert", "assets/wild/shaders/fbo_mask.frag");
         this.partA = this.uUuuVvVunVVu.primaryVal("u_texture");
         this.vunuUUVVUv = this.uUuuVvVunVVu.primaryVal("u_viewport");
         this.uuuNUnuvvNNv = this.uUuuVvVunVVu.primaryVal("u_resolution");
         this.unUVnu = this.uUuuVvVunVVu.primaryVal("u_time");
         this.NvNUuuuvUvu = this.uUuuVvVunVVu.primaryVal("u_progress");
         this.nNVVUnuVVVuV = this.uUuuVvVunVVu.primaryVal("u_color");
         this.vnVuunuNN = this.uUuuVvVunVVu.primaryVal("u_borderColor");
         this.UvUNuNvvNVNv = this.uUuuVvVunVVu.primaryVal("u_emissiveColor");
         this.partB = this.uUuuVvVunVVu.primaryVal("u_radius");
         this.UVUnUvUNU = this.uUuuVvVunVVu.primaryVal("u_alpha");
         this.UvUnnnn = this.uUuuVvVunVVu.primaryVal("u_clipRect");
         this.partF = this.uUuuVvVunVVu.primaryVal("u_clipRadii");
         this.VnvunuuvUNu = this.uUuuVvVunVVu.primaryVal("u_textureScale");
      }
   }

   public Renderer2DBackend.cursorVal primaryVal(int var1, int var2) {
      return this.primaryVal(this.twigD, var1, var2, false);
   }

   public Renderer2DBackend.cursorVal secondaryVal(int var1, int var2) {
      if (var1 > 0 && var2 > 0 && this.groupVal > 0 && this.layerVal > 0) {
         int var3 = this.vuNnuUnu;
         Renderer2DBackend.VvunVVUvUNnv var4 = this.tertiaryVal(var3);
         this.vuNnuUnu++;

         try {
            Renderer2DBackend.cursorVal var5 = this.primaryVal(var4, var1, var2, true);
            if (var5 == null) {
               this.vuNnuUnu = var3;
            }

            return var5;
         } catch (RuntimeException | Error var6) {
            this.vuNnuUnu = var3;
            throw var6;
         }
      } else {
         return null;
      }
   }

   private Renderer2DBackend.VvunVVUvUNnv tertiaryVal(int var1) {
      while (this.NNVNuUvVn.size() <= var1) {
         this.NNVNuUvVn.add(new Renderer2DBackend.VvunVVUvUNnv());
      }

      return this.NNVNuUvVn.get(var1);
   }

   private Renderer2DBackend.cursorVal primaryVal(Renderer2DBackend.VvunVVUvUNnv var1, int var2, int var3, boolean var4) {
      this.secondaryVal();
      if (var2 > 0 && var3 > 0 && this.groupVal > 0 && this.layerVal > 0) {
         int var5 = var2;
         int var6 = var3;
         int var7 = this.groupVal;
         int var8 = this.layerVal;
         boolean var9 = this.stageVal;
         int var10 = this.widthRef;
         int var11 = this.trackVal;
         int var12 = this.modeRef;
         int var13 = this.angleVal;
         float var14 = this.heightRef;
         float var15 = this.levelVal;
         float var16 = this.UuNnnVnuNNV;
         float var17 = this.depthRef;
         boolean var18 = this.vVnuVVvVNuNu;
         GLStateSnapshot.Snapshot var19 = GLStateSnapshot.secondaryVal(var1.weightVal);

         try {
            this.secondaryVal(var1, var5, var6, var4);
            Renderer2DBackend.cursorVal var20 = var1.paramVal
               .primaryVal(
                  var1.secondaryVal,
                  var5,
                  var6,
                  var1.tertiaryVal,
                  var1.marginVal,
                  var19,
                  var7,
                  var8,
                  var9,
                  var10,
                  var11,
                  var12,
                  var13,
                  var14,
                  var15,
                  var16,
                  var17,
                  var18,
                  var4
               );
            GL30.glBindFramebuffer(36160, var1.primaryVal);
            GL11.glDrawBuffer(36064);
            GL11.glViewport(0, 0, var5, var6);
            GL11.glEnable(3089);
            GL11.glScissor(0, 0, var5, var6);
            GL11.glDisable(2929);
            GL11.glDisable(2884);
            GL11.glDisable(36281);
            GL11.glColorMask(true, true, true, true);
            GL11.glDepthMask(false);
            GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
            GL11.glClear(16384);
            GL11.glDisable(3089);
            this.groupVal = var5;
            this.layerVal = var6;
            this.stageVal = false;
            this.widthRef = 0;
            this.trackVal = 0;
            this.modeRef = var5;
            this.angleVal = var6;
            this.heightRef = 0.0F;
            this.levelVal = 0.0F;
            this.UuNnnVnuNNV = 0.0F;
            this.depthRef = 0.0F;
            this.vVnuVVvVNuNu = false;
            this.radiusVal.primaryVal();
            GL30.glBindVertexArray(this.factorVal);
            if (this.VUuuVUnun == -1) {
               this.VUuuVUnun = this.radiusVal.primaryVal("uViewport");
            }

            GL20.glUniform2f(this.VUuuVUnun, var5, var6);
            this.timerVal();
            this.extraVal();
            return var20;
         } catch (RuntimeException | Error var21) {
            this.groupVal = var7;
            this.layerVal = var8;
            this.stageVal = var9;
            this.widthRef = var10;
            this.trackVal = var11;
            this.modeRef = var12;
            this.angleVal = var13;
            this.heightRef = var14;
            this.levelVal = var15;
            this.UuNnnVnuNNV = var16;
            this.depthRef = var17;
            this.vVnuVVvVNuNu = var18;
            GLStateSnapshot.tertiaryVal(var19);
            this.radiusVal.primaryVal();
            GL30.glBindVertexArray(this.factorVal);
            if (this.VUuuVUnun == -1) {
               this.VUuuVUnun = this.radiusVal.primaryVal("uViewport");
            }

            GL20.glUniform2f(this.VUuuVUnun, this.groupVal, this.layerVal);
            this.timerVal();
            throw var21;
         }
      } else {
         return null;
      }
   }

   public void primaryVal(Renderer2DBackend.cursorVal var1) {
      this.secondaryVal();
      if (var1 != null) {
         this.groupVal = var1.extraVal();
         this.layerVal = var1.limitVal();
         this.stageVal = var1.speedVal();
         this.widthRef = var1.widthVal();
         this.trackVal = var1.chunkVal();
         this.modeRef = var1.blockRef();
         this.angleVal = var1.holderVal();
         this.heightRef = var1.timerVal();
         this.levelVal = var1.anchorVal();
         this.UuNnnVnuNNV = var1.weightRef();
         this.depthRef = var1.bufferVal();
         this.vVnuVVvVNuNu = var1.countVal();
         GLStateSnapshot.tertiaryVal(var1.paramVal());
         this.radiusVal.primaryVal();
         GL30.glBindVertexArray(this.factorVal);
         if (this.VUuuVUnun == -1) {
            this.VUuuVUnun = this.radiusVal.primaryVal("uViewport");
         }

         GL20.glUniform2f(this.VUuuVUnun, this.groupVal, this.layerVal);
         this.timerVal();
         this.extraVal();
         if (var1.depthVal()) {
            this.vuNnuUnu = Math.max(0, this.vuNnuUnu - 1);
         }
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void primaryVal(
      int var1,
      int var2,
      int var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float var15,
      float var16,
      float var17,
      float var18,
      float[] var19,
      int var20,
      int var21,
      int var22,
      int var23,
      float var24,
      float var25,
      float var26,
      float var27
   ) {
      if (var1 > 0 && var2 > 0 && var3 > 0 && !(var6 <= 0.0F) && !(var7 <= 0.0F)) {
         this.secondaryVal();
         float[] var28 = var19 != null && var19.length >= 6 ? var19 : bufferVal;
         float var29 = var4;
         float var30 = var5;
         float var31 = var4 + var6;
         float var32 = var5 + var7;
         float var33 = primaryVal(var28, var29, var30);
         float var34 = secondaryVal(var28, var29, var30);
         float var35 = primaryVal(var28, var31, var30);
         float var36 = secondaryVal(var28, var31, var30);
         float var37 = primaryVal(var28, var31, var32);
         float var38 = secondaryVal(var28, var31, var32);
         float var39 = primaryVal(var28, var29, var32);
         float var40 = secondaryVal(var28, var29, var32);
         primaryVal(this.UuuuNNunN, var33, var34, var35, var36, var37, var38, var39, var40);
         GLStateSnapshot.Snapshot var41 = GLStateSnapshot.secondaryVal(this.spanF);
         boolean var44 = false /* VF: Semaphore variable */;

         try {
            var44 = true;
            this.widthVal();
            GL11.glDisable(3089);
            GL11.glDisable(2929);
            GL11.glDisable(2884);
            GL11.glDisable(36281);
            GL11.glEnable(3042);
            if (this.vVnuVVvVNuNu) {
               GL14.glBlendFuncSeparate(1, 1, 1, 771);
            } else {
               GL14.glBlendFuncSeparate(1, 771, 1, 771);
            }

            this.UnnnvvU.primaryVal();
            if (this.VUUnuVvVu >= 0) {
               GL20.glUniform1i(this.VUUnuVvVu, 0);
            }

            if (this.VvVuvUvvNNVv >= 0) {
               GL20.glUniform2f(this.VvVuvUvvNNVv, this.groupVal, this.layerVal);
            }

            if (this.UnnNNvuvvUU >= 0) {
               GL20.glUniform2f(this.UnnNNvuvvUU, var6, var7);
            }

            if (this.twigA >= 0) {
               GL20.glUniform2f(this.twigA, var2, var3);
            }

            if (this.itemC >= 0) {
               GL20.glUniform4f(this.itemC, var8, var9, var10, var11);
            }

            if (this.itemB >= 0) {
               GL20.glUniform4f(this.itemB, var20, var21, var22, var23);
            }

            if (this.VvuUUUNNNv >= 0) {
               GL20.glUniform4f(this.VvuUUUNNNv, var24, var25, var26, var27);
            }

            if (this.uuuVnuvnnNnU >= 0) {
               GL20.glUniform1f(this.uuuVnuvnnNnU, Math.max(0.0F, var12));
            }

            if (this.nodeJ >= 0) {
               GL20.glUniform1f(this.nodeJ, Math.max(0.0F, var13));
            }

            if (this.twigH >= 0) {
               GL20.glUniform1f(this.twigH, Math.max(0.0F, var14));
            }

            if (this.vuvvuVuVv >= 0) {
               GL20.glUniform1f(this.vuvvuVuVv, Math.max(0.0F, Math.min(1.0F, var15)));
            }

            if (this.uunNUuunVU >= 0) {
               GL20.glUniform1f(this.uunNUuunVU, Math.max(0.0F, Math.min(1.0F, var16)));
            }

            if (this.NvnuuuvnVV >= 0) {
               GL20.glUniform1f(this.NvnuuuvnVV, var17 < 0.0F ? -1.0F : 1.0F);
            }

            if (this.NnUVNnuvUv >= 0) {
               GL20.glUniform1f(this.NnUVNnuvUv, Math.max(0.0F, Math.min(1.0F, var18)));
            }

            GL13.glActiveTexture(33984);
            GL11.glBindTexture(3553, var1);
            GL30.glBindVertexArray(this.nodeD);
            GL15.glBindBuffer(34962, this.NnuUnUNnu);
            GL15.glBufferSubData(34962, 0L, this.UuuuNNunN);
            FrameStatsTracker.primaryVal().primaryVal(2);
            GL11.glDrawArrays(4, 0, 6);
            var44 = false;
         } finally {
            if (var44) {
               GL30.glBindVertexArray(0);
               GL15.glBindBuffer(34962, 0);
               GL20.glUseProgram(0);
               GLStateSnapshot.tertiaryVal(var41);
               this.radiusVal.primaryVal();
               GL30.glBindVertexArray(this.factorVal);
               if (this.VUuuVUnun == -1) {
                  this.VUuuVUnun = this.radiusVal.primaryVal("uViewport");
               }

               GL20.glUniform2f(this.VUuuVUnun, this.groupVal, this.layerVal);
               this.timerVal();
            }
         }

         GL30.glBindVertexArray(0);
         GL15.glBindBuffer(34962, 0);
         GL20.glUseProgram(0);
         GLStateSnapshot.tertiaryVal(var41);
         this.radiusVal.primaryVal();
         GL30.glBindVertexArray(this.factorVal);
         if (this.VUuuVUnun == -1) {
            this.VUuuVUnun = this.radiusVal.primaryVal("uViewport");
         }

         GL20.glUniform2f(this.VUuuVUnun, this.groupVal, this.layerVal);
         this.timerVal();
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void primaryVal(
      int var1,
      int var2,
      int var3,
      int var4,
      int var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      int var11,
      int var12,
      int var13,
      int var14,
      float var15,
      float var16,
      float var17,
      float[] var18,
      int var19,
      int var20,
      int var21,
      int var22,
      float var23,
      float var24,
      float var25,
      float var26
   ) {
      if (var1 > 0 && var2 > 0 && var3 > 0 && var4 > 0 && var5 > 0 && !(var8 <= 0.0F) && !(var9 <= 0.0F)) {
         this.secondaryVal();
         float[] var27 = var18 != null && var18.length >= 6 ? var18 : bufferVal;
         float var28 = var6;
         float var29 = var7;
         float var30 = var6 + var8;
         float var31 = var7 + var9;
         float var32 = primaryVal(var27, var28, var29);
         float var33 = secondaryVal(var27, var28, var29);
         float var34 = primaryVal(var27, var30, var29);
         float var35 = secondaryVal(var27, var30, var29);
         float var36 = primaryVal(var27, var30, var31);
         float var37 = secondaryVal(var27, var30, var31);
         float var38 = primaryVal(var27, var28, var31);
         float var39 = secondaryVal(var27, var28, var31);
         primaryVal(this.nUununvNvvn, var32, var33, var34, var35, var36, var37, var38, var39);
         GLStateSnapshot.Snapshot var40 = GLStateSnapshot.secondaryVal(this.spanF);
         boolean var43 = false /* VF: Semaphore variable */;

         try {
            var43 = true;
            this.chunkVal();
            GL11.glDisable(3089);
            GL11.glDisable(2929);
            GL11.glDisable(2884);
            GL11.glDisable(36281);
            GL11.glEnable(3042);
            if (this.vVnuVVvVNuNu) {
               GL14.glBlendFuncSeparate(1, 1, 1, 771);
            } else {
               GL14.glBlendFuncSeparate(1, 771, 1, 771);
            }

            this.NVNnnvVnvV.primaryVal();
            if (this.vUNuuvvnVnv >= 0) {
               GL20.glUniform1i(this.vUNuuvvnVnv, 0);
            }

            if (this.unnnNUNnVu >= 0) {
               GL20.glUniform2f(this.unnnNUNnVu, this.groupVal, this.layerVal);
            }

            if (this.twigF >= 0) {
               GL20.glUniform2f(this.twigF, var8, var9);
            }

            if (this.itemG >= 0) {
               GL20.glUniform1f(this.itemG, var16);
            }

            if (this.nvuUVvuuN >= 0) {
               GL20.glUniform1f(this.nvuUVvuuN, Math.max(0.0F, Math.min(1.0F, var15)));
            }

            if (this.itemJ >= 0) {
               extraVal(this.itemJ, var11);
            }

            if (this.spanC >= 0) {
               extraVal(this.spanC, var12);
            }

            if (this.VnnnvUunNvuu >= 0) {
               extraVal(this.VnnnvUunNvuu, var13);
            }

            if (this.VuuUVVu >= 0) {
               extraVal(this.VuuUVVu, var14);
            }

            if (this.partJ >= 0) {
               GL20.glUniform1f(this.partJ, Math.max(0.0F, var10));
            }

            if (this.VuNVnvNNuNnn >= 0) {
               GL20.glUniform1f(this.VuNVnvNNuNnn, Math.max(0.0F, Math.min(1.0F, var17)));
            }

            if (this.uvVuuuvvVU >= 0) {
               GL20.glUniform4f(this.uvVuuuvvVU, var19, var20, var21, var22);
            }

            if (this.NNnvvunuVNUn >= 0) {
               GL20.glUniform4f(this.NNnvvunuVNUn, var23, var24, var25, var26);
            }

            if (this.nVuuUnnUUVU >= 0) {
               GL20.glUniform2f(this.nVuuUnnUUVU, (float)var4 / var2, (float)var5 / var3);
            }

            GL13.glActiveTexture(33984);
            GL11.glBindTexture(3553, var1);
            GL30.glBindVertexArray(this.uuvvuNvuUNVV);
            GL15.glBindBuffer(34962, this.uVvunVUNuUvu);
            GL15.glBufferSubData(34962, 0L, this.nUununvNvvn);
            FrameStatsTracker.primaryVal().primaryVal(2);
            GL11.glDrawArrays(4, 0, 6);
            var43 = false;
         } finally {
            if (var43) {
               GL30.glBindVertexArray(0);
               GL15.glBindBuffer(34962, 0);
               GL20.glUseProgram(0);
               GLStateSnapshot.tertiaryVal(var40);
               this.radiusVal.primaryVal();
               GL30.glBindVertexArray(this.factorVal);
               if (this.VUuuVUnun == -1) {
                  this.VUuuVUnun = this.radiusVal.primaryVal("uViewport");
               }

               GL20.glUniform2f(this.VUuuVUnun, this.groupVal, this.layerVal);
               this.timerVal();
            }
         }

         GL30.glBindVertexArray(0);
         GL15.glBindBuffer(34962, 0);
         GL20.glUseProgram(0);
         GLStateSnapshot.tertiaryVal(var40);
         this.radiusVal.primaryVal();
         GL30.glBindVertexArray(this.factorVal);
         if (this.VUuuVUnun == -1) {
            this.VUuuVUnun = this.radiusVal.primaryVal("uViewport");
         }

         GL20.glUniform2f(this.VUuuVUnun, this.groupVal, this.layerVal);
         this.timerVal();
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void primaryVal(
      int var1,
      int var2,
      int var3,
      int var4,
      int var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      int var11,
      int var12,
      int var13,
      int var14,
      float var15,
      float var16,
      float var17,
      float var18,
      float var19,
      float var20,
      float var21,
      float[] var22,
      int var23,
      int var24,
      int var25,
      int var26,
      float var27,
      float var28,
      float var29,
      float var30
   ) {
      if (var1 > 0 && var2 > 0 && var3 > 0 && var4 > 0 && var5 > 0 && !(var8 <= 0.0F) && !(var9 <= 0.0F)) {
         this.secondaryVal();
         float[] var31 = var22 != null && var22.length >= 6 ? var22 : bufferVal;
         float var32 = var6;
         float var33 = var7;
         float var34 = var6 + var8;
         float var35 = var7 + var9;
         float var36 = primaryVal(var31, var32, var33);
         float var37 = secondaryVal(var31, var32, var33);
         float var38 = primaryVal(var31, var34, var33);
         float var39 = secondaryVal(var31, var34, var33);
         float var40 = primaryVal(var31, var34, var35);
         float var41 = secondaryVal(var31, var34, var35);
         float var42 = primaryVal(var31, var32, var35);
         float var43 = secondaryVal(var31, var32, var35);
         primaryVal(this.nUununvNvvn, var36, var37, var38, var39, var40, var41, var42, var43);
         GLStateSnapshot.Snapshot var44 = GLStateSnapshot.secondaryVal(this.spanF);
         boolean var47 = false /* VF: Semaphore variable */;

         try {
            var47 = true;
            this.blockRef();
            GL11.glDisable(3089);
            GL11.glDisable(2929);
            GL11.glDisable(2884);
            GL11.glDisable(36281);
            GL11.glEnable(3042);
            if (this.vVnuVVvVNuNu) {
               GL14.glBlendFuncSeparate(1, 1, 1, 771);
            } else {
               GL14.glBlendFuncSeparate(1, 771, 1, 771);
            }

            this.NuvunVvnnN.primaryVal();
            if (this.vuvnnvuNVvu >= 0) {
               GL20.glUniform1i(this.vuvnnvuNVvu, 0);
            }

            if (this.NVvnvnn >= 0) {
               GL20.glUniform2f(this.NVvnvnn, this.groupVal, this.layerVal);
            }

            if (this.partG >= 0) {
               GL20.glUniform2f(this.partG, var8, var9);
            }

            if (this.NUuVnnuUnvu >= 0) {
               GL20.glUniform1f(this.NUuVnnuUnvu, var17);
            }

            if (this.vnuNNVvVVuN >= 0) {
               GL20.glUniform1f(this.vnuNNVvVVuN, Math.max(0.0F, Math.min(1.0F, var15)));
            }

            if (this.Oco0Oococc >= 0) {
               GL20.glUniform1f(this.Oco0Oococc, Math.max(0.0F, Math.min(1.0F, var16)));
            }

            if (this.itemF >= 0) {
               GL20.glUniform1f(this.itemF, Math.max(0.0F, Math.min(1.0F, var18)));
            }

            if (this.spanA >= 0) {
               GL20.glUniform1f(this.spanA, Math.max(0.0F, Math.min(1.0F, var19)));
            }

            if (this.UvuVvvVuUuuu >= 0) {
               GL20.glUniform1f(this.UvuVvvVuUuuu, Math.max(0.0F, Math.min(1.0F, var20)));
            }

            if (this.NUUVUvvuNNVU >= 0) {
               extraVal(this.NUUVUvvuNNVU, var11);
            }

            if (this.VUNvNUuNVnn >= 0) {
               extraVal(this.VUNvNUuNVnn, var12);
            }

            if (this.UNNunNuUNVuU >= 0) {
               extraVal(this.UNNunNuUNVuU, var13);
            }

            if (this.itemE >= 0) {
               extraVal(this.itemE, var14);
            }

            if (this.VUVvNvvVUN >= 0) {
               GL20.glUniform1f(this.VUVvNvvVUN, Math.max(0.0F, var10));
            }

            if (this.UvvNuvUNNNUv >= 0) {
               GL20.glUniform1f(this.UvvNuvUNNNUv, Math.max(0.0F, Math.min(1.0F, var21)));
            }

            if (this.NunUUVVVuu >= 0) {
               GL20.glUniform4f(this.NunUUVVVuu, var23, var24, var25, var26);
            }

            if (this.spanE >= 0) {
               GL20.glUniform4f(this.spanE, var27, var28, var29, var30);
            }

            if (this.vvVVVvVNVVVN >= 0) {
               GL20.glUniform2f(this.vvVVVvVNVVVN, (float)var4 / var2, (float)var5 / var3);
            }

            GL13.glActiveTexture(33984);
            GL11.glBindTexture(3553, var1);
            GL30.glBindVertexArray(this.uuvvuNvuUNVV);
            GL15.glBindBuffer(34962, this.uVvunVUNuUvu);
            GL15.glBufferSubData(34962, 0L, this.nUununvNvvn);
            FrameStatsTracker.primaryVal().primaryVal(2);
            GL11.glDrawArrays(4, 0, 6);
            var47 = false;
         } finally {
            if (var47) {
               GL30.glBindVertexArray(0);
               GL15.glBindBuffer(34962, 0);
               GL20.glUseProgram(0);
               GLStateSnapshot.tertiaryVal(var44);
               this.radiusVal.primaryVal();
               GL30.glBindVertexArray(this.factorVal);
               if (this.VUuuVUnun == -1) {
                  this.VUuuVUnun = this.radiusVal.primaryVal("uViewport");
               }

               GL20.glUniform2f(this.VUuuVUnun, this.groupVal, this.layerVal);
               this.timerVal();
            }
         }

         GL30.glBindVertexArray(0);
         GL15.glBindBuffer(34962, 0);
         GL20.glUseProgram(0);
         GLStateSnapshot.tertiaryVal(var44);
         this.radiusVal.primaryVal();
         GL30.glBindVertexArray(this.factorVal);
         if (this.VUuuVUnun == -1) {
            this.VUuuVUnun = this.radiusVal.primaryVal("uViewport");
         }

         GL20.glUniform2f(this.VUuuVUnun, this.groupVal, this.layerVal);
         this.timerVal();
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void primaryVal(
      int var1,
      int var2,
      int var3,
      int var4,
      int var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      int var11,
      int var12,
      int var13,
      float var14,
      float var15,
      float var16,
      float[] var17,
      int var18,
      int var19,
      int var20,
      int var21,
      float var22,
      float var23,
      float var24,
      float var25
   ) {
      if (var1 > 0 && var2 > 0 && var3 > 0 && var4 > 0 && var5 > 0 && !(var8 <= 0.0F) && !(var9 <= 0.0F)) {
         this.secondaryVal();
         float[] var26 = var17 != null && var17.length >= 6 ? var17 : bufferVal;
         float var27 = var6;
         float var28 = var7;
         float var29 = var6 + var8;
         float var30 = var7 + var9;
         float var31 = primaryVal(var26, var27, var28);
         float var32 = secondaryVal(var26, var27, var28);
         float var33 = primaryVal(var26, var29, var28);
         float var34 = secondaryVal(var26, var29, var28);
         float var35 = primaryVal(var26, var29, var30);
         float var36 = secondaryVal(var26, var29, var30);
         float var37 = primaryVal(var26, var27, var30);
         float var38 = secondaryVal(var26, var27, var30);
         primaryVal(this.nUununvNvvn, var31, var32, var33, var34, var35, var36, var37, var38);
         GLStateSnapshot.Snapshot var39 = GLStateSnapshot.secondaryVal(this.spanF);
         boolean var42 = false /* VF: Semaphore variable */;

         try {
            var42 = true;
            this.holderVal();
            GL11.glDisable(3089);
            GL11.glDisable(2929);
            GL11.glDisable(2884);
            GL11.glDisable(36281);
            GL11.glEnable(3042);
            if (this.vVnuVVvVNuNu) {
               GL14.glBlendFuncSeparate(1, 1, 1, 771);
            } else {
               GL14.glBlendFuncSeparate(1, 771, 1, 771);
            }

            this.uUuuVvVunVVu.primaryVal();
            if (this.partA >= 0) {
               GL20.glUniform1i(this.partA, 0);
            }

            if (this.vunuUUVVUv >= 0) {
               GL20.glUniform2f(this.vunuUUVVUv, this.groupVal, this.layerVal);
            }

            if (this.uuuNUnuvvNNv >= 0) {
               GL20.glUniform2f(this.uuuNUnuvvNNv, var8, var9);
            }

            if (this.unUVnu >= 0) {
               GL20.glUniform1f(this.unUVnu, var15);
            }

            if (this.NvNUuuuvUvu >= 0) {
               GL20.glUniform1f(this.NvNUuuuvUvu, Math.max(0.0F, Math.min(1.0F, var14)));
            }

            if (this.nNVVUnuVVVuV >= 0) {
               extraVal(this.nNVVUnuVVVuV, var11);
            }

            if (this.vnVuunuNN >= 0) {
               extraVal(this.vnVuunuNN, var12);
            }

            if (this.UvUNuNvvNVNv >= 0) {
               extraVal(this.UvUNuNvvNVNv, var13);
            }

            if (this.partB >= 0) {
               GL20.glUniform1f(this.partB, Math.max(0.0F, var10));
            }

            if (this.UVUnUvUNU >= 0) {
               GL20.glUniform1f(this.UVUnUvUNU, Math.max(0.0F, Math.min(1.0F, var16)));
            }

            if (this.UvUnnnn >= 0) {
               GL20.glUniform4f(this.UvUnnnn, var18, var19, var20, var21);
            }

            if (this.partF >= 0) {
               GL20.glUniform4f(this.partF, var22, var23, var24, var25);
            }

            if (this.VnvunuuvUNu >= 0) {
               GL20.glUniform2f(this.VnvunuuvUNu, (float)var4 / var2, (float)var5 / var3);
            }

            GL13.glActiveTexture(33984);
            GL11.glBindTexture(3553, var1);
            GL30.glBindVertexArray(this.uuvvuNvuUNVV);
            GL15.glBindBuffer(34962, this.uVvunVUNuUvu);
            GL15.glBufferSubData(34962, 0L, this.nUununvNvvn);
            FrameStatsTracker.primaryVal().primaryVal(2);
            GL11.glDrawArrays(4, 0, 6);
            var42 = false;
         } finally {
            if (var42) {
               GL30.glBindVertexArray(0);
               GL15.glBindBuffer(34962, 0);
               GL20.glUseProgram(0);
               GLStateSnapshot.tertiaryVal(var39);
               this.radiusVal.primaryVal();
               GL30.glBindVertexArray(this.factorVal);
               if (this.VUuuVUnun == -1) {
                  this.VUuuVUnun = this.radiusVal.primaryVal("uViewport");
               }

               GL20.glUniform2f(this.VUuuVUnun, this.groupVal, this.layerVal);
               this.timerVal();
            }
         }

         GL30.glBindVertexArray(0);
         GL15.glBindBuffer(34962, 0);
         GL20.glUseProgram(0);
         GLStateSnapshot.tertiaryVal(var39);
         this.radiusVal.primaryVal();
         GL30.glBindVertexArray(this.factorVal);
         if (this.VUuuVUnun == -1) {
            this.VUuuVUnun = this.radiusVal.primaryVal("uViewport");
         }

         GL20.glUniform2f(this.VUuuVUnun, this.groupVal, this.layerVal);
         this.timerVal();
      }
   }

   public void tertiaryVal(int var1, int var2) {
      if (var1 > 0 && var2 > 0) {
         this.paramRef = GLStateSnapshot.primaryVal();
         this.groupVal = var1;
         this.layerVal = var2;
         this.limitRef = 0;
         this.phaseVal.clear();
         this.extraVal();
         this.radiusVal.primaryVal();
         if (this.VUuuVUnun == -1) {
            this.VUuuVUnun = this.radiusVal.primaryVal("uViewport");
         }

         GL30.glBindVertexArray(this.factorVal);
         GL20.glUniform2f(this.VUuuVUnun, var1, var2);
         this.unitI = 0;
         this.VNvuVnvnun = 0;
         this.unVVnuunNU = 0;
         this.NunnVUUuvUV = 0;
         this.unitD = 0;
         this.vVnuVVvVNuNu = false;
         GL11.glDisable(2929);
         GL11.glDisable(2884);
         GL11.glDisable(3089);
         this.timerVal();
         GL11.glViewport(0, 0, var1, var2);
         GL11.glColorMask(true, true, true, true);
         if (!this.vVVuuVVv) {
            for (int var3 = 0; var3 < 16; var3++) {
               int var4 = this.radiusVal.primaryVal("uTextures[" + var3 + "]");
               if (var4 != -1) {
                  GL20.glUniform1i(var4, var3);
               }
            }

            this.vVVuuVVv = true;
         }
      } else {
         this.groupVal = 0;
         this.layerVal = 0;
         this.limitRef = 0;
         this.phaseVal.clear();
         this.extraVal();
         this.countVal();
      }
   }

   public void primaryVal() {
      this.secondaryVal();
      GL30.glBindVertexArray(0);
      GL20.glUseProgram(0);
      if (this.paramRef != null) {
         GL20.glUseProgram(this.paramRef.limitRef);
         GL30.glBindVertexArray(this.paramRef.paramRef);
         GL15.glBindBuffer(34962, this.paramRef.groupVal);
         GL15.glBindBuffer(34963, this.paramRef.layerVal);
         GL13.glActiveTexture(this.paramRef.slotVal);
         GL11.glBindTexture(3553, this.paramRef.themeVal);
         GL11.glPixelStorei(3317, this.paramRef.widthRef);
         primaryVal(3089, this.paramRef.paramVal);
         primaryVal(2929, this.paramRef.limitVal);
         primaryVal(2884, this.paramRef.speedVal);
         primaryVal(3042, this.paramRef.widthVal);
         primaryVal(36281, this.paramRef.chunkVal);
         GL14.glBlendFuncSeparate(this.paramRef.blockRef, this.paramRef.holderVal, this.paramRef.timerVal, this.paramRef.anchorVal);
         GL11.glColorMask(this.paramRef.weightRef, this.paramRef.bufferVal, this.paramRef.countVal, this.paramRef.depthVal);
         GL11.glDepthMask(this.paramRef.descRef);
         GL11.glViewport(this.paramRef.weightVal[0], this.paramRef.weightVal[1], this.paramRef.weightVal[2], this.paramRef.weightVal[3]);
         GL11.glScissor(this.paramRef.extraVal[0], this.paramRef.extraVal[1], this.paramRef.extraVal[2], this.paramRef.extraVal[3]);
      }

      this.paramRef = null;
      this.limitRef = 0;
      this.phaseVal.clear();
   }

   private void paramVal(int var1, int var2) {
      if (this.descRef) {
         ARBInstancedArrays.glVertexAttribDivisorARB(var1, var2);
      } else {
         GL33.glVertexAttribDivisor(var1, var2);
      }
   }

   private static void primaryVal(int var0, boolean var1) {
      if (var1) {
         GL11.glEnable(var0);
      } else {
         GL11.glDisable(var0);
      }
   }

   private static void extraVal(int var0, int var1) {
      float var2 = (var1 >>> 24 & 0xFF) / 255.0F;
      float var3 = (var1 >>> 16 & 0xFF) / 255.0F;
      float var4 = (var1 >>> 8 & 0xFF) / 255.0F;
      float var5 = (var1 & 0xFF) / 255.0F;
      GL20.glUniform4f(var0, var3, var4, var5, var2);
   }

   public void secondaryVal() {
      if (this.limitRef > 0) {
         if (this.groupVal > 0 && this.layerVal > 0) {
            this.phaseVal.limit(this.limitRef * 144);
            this.phaseVal.position(0);
            int var1 = GL11.glGetInteger(34229);
            int var2 = GL11.glGetInteger(35725);
            GL30.glBindVertexArray(this.factorVal);
            this.radiusVal.primaryVal();
            GL20.glUniform2f(this.VUuuVUnun, this.groupVal, this.layerVal);
            GL11.glViewport(0, 0, this.groupVal, this.layerVal);
            this.timerVal();
            GL11.glDisable(2929);
            GL11.glDisable(2884);
            GL11.glColorMask(true, true, true, true);
            if (this.countVal) {
               GL15.glBindBuffer(37074, this.sourceVal);
               GL15.glBufferSubData(37074, 0L, this.phaseVal);
               GL43.glBindBufferBase(37074, 0, this.sourceVal);
            } else {
               GL15.glBindBuffer(34962, this.extraRef);
               GL15.glBufferSubData(34962, 0L, this.phaseVal);
               GL15.glBindBuffer(34962, 0);
            }

            int var3 = GL11.glGetInteger(34016);
            int var4 = this.guardVal;

            for (int var5 = 0; var5 < var4; var5++) {
               GL13.glActiveTexture(33984 + var5);
               this.entryVal[var5] = GL11.glGetInteger(32873);
               int var6 = this.countRef[var5];
               GL11.glBindTexture(3553, var6);
            }

            int var7 = Math.max(0, this.limitRef);
            if (var7 > 0) {
               FrameStatsTracker.primaryVal().primaryVal(var7);
            }

            if (this.countVal) {
               GL11.glDrawArrays(4, 0, this.limitRef * 3);
            } else if (this.activeVal) {
               ARBDrawInstanced.glDrawArraysInstancedARB(4, 0, 3, this.limitRef);
            } else {
               GL31.glDrawArraysInstanced(4, 0, 3, this.limitRef);
            }

            for (int var8 = 0; var8 < var4; var8++) {
               GL13.glActiveTexture(33984 + var8);
               GL11.glBindTexture(3553, this.entryVal[var8]);
            }

            GL13.glActiveTexture(var3);
            GL30.glBindVertexArray(var1);
            GL20.glUseProgram(var2);
            this.limitRef = 0;
            this.phaseVal.clear();
            this.extraVal();
         } else {
            this.limitRef = 0;
            this.phaseVal.clear();
            this.extraVal();
         }
      }
   }

   public void primaryVal(boolean var1) {
      this.vVnuVVvVNuNu = var1;
   }

   public void tertiaryVal() {
      this.timerVal();
   }

   private void timerVal() {
      GL11.glEnable(3042);
      if (this.vVnuVVvVNuNu) {
         GL14.glBlendFuncSeparate(1, 1, 1, 771);
      } else {
         GL14.glBlendFuncSeparate(1, 771, 1, 771);
      }
   }

   public void secondaryVal(boolean var1) {
      this.stageVal = var1;
      if (!var1) {
         this.heightRef = 0.0F;
         this.levelVal = 0.0F;
         this.UuNnnVnuNNV = 0.0F;
         this.depthRef = 0.0F;
      }
   }

   public void primaryVal(int var1, int var2, int var3, int var4, float var5, float var6, float var7, float var8) {
      this.widthRef = var1;
      this.trackVal = var2;
      this.modeRef = var3;
      this.angleVal = var4;
      this.heightRef = var5;
      this.levelVal = var6;
      this.UuNnnVnuNNV = var7;
      this.depthRef = var8;
   }

   public void primaryVal(float[] var1) {
   }

   public void primaryVal(float var1, float var2) {
      if (!Float.isFinite(var1) || !Float.isFinite(var2)) {
         throw new IllegalArgumentException("Blur capture scale must be finite");
      }

      if (!(var1 <= 0.0F) && !(var2 <= 0.0F)) {
         this.UvNNVUVNVuvV = var1;
         this.NnunUUnU = var2;
      } else {
         throw new IllegalArgumentException("Blur capture scale must be positive");
      }
   }

   private void primaryVal(
      int var1,
      float var2,
      float var3,
      float var4,
      float var5,
      int var6,
      int var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      float[] var15,
      float var16,
      float var17,
      float var18,
      float var19,
      int var20,
      float var21,
      float var22,
      int var23
   ) {
      if (this.limitRef >= 4096) {
         throw new IllegalStateException("Instance capacity exceeded without prior ensureInstanceCapacity call");
      }

      int var24 = this.limitRef * 144;
      this.phaseVal.position(var24);
      primaryVal(this.phaseVal, var15, var2, var3, var4, var5);
      int var25 = this.stageVal ? this.widthRef : 0;
      int var26 = this.stageVal ? this.trackVal : 0;
      int var27 = this.stageVal ? this.modeRef : this.groupVal;
      int var28 = this.stageVal ? this.angleVal : this.layerVal;
      float var29 = this.stageVal ? this.heightRef : 0.0F;
      float var30 = this.stageVal ? this.levelVal : 0.0F;
      float var31 = this.stageVal ? this.UuNnnVnuNNV : 0.0F;
      float var32 = this.stageVal ? this.depthRef : 0.0F;
      this.phaseVal.putInt(var25);
      this.phaseVal.putInt(var26);
      this.phaseVal.putInt(var27);
      this.phaseVal.putInt(var28);
      this.phaseVal.putFloat(var29);
      this.phaseVal.putFloat(var30);
      this.phaseVal.putFloat(var31);
      this.phaseVal.putFloat(var32);
      this.phaseVal.putFloat(var2);
      this.phaseVal.putFloat(var3);
      this.phaseVal.putFloat(var4);
      this.phaseVal.putFloat(var5);
      this.phaseVal.putInt(primaryVal(var6));
      this.phaseVal.putInt(primaryVal(var7));
      this.phaseVal.putInt(primaryVal(var8));
      this.phaseVal.putInt(primaryVal(var9));
      float var33 = primaryVal(var10);
      float var34 = primaryVal(var11);
      float var35 = primaryVal(var12);
      float var36 = primaryVal(var13);
      this.phaseVal.putFloat(var33);
      this.phaseVal.putFloat(var34);
      this.phaseVal.putFloat(var35);
      this.phaseVal.putFloat(var36);
      this.phaseVal.putFloat(var16);
      this.phaseVal.putFloat(var17);
      this.phaseVal.putFloat(var18);
      this.phaseVal.putFloat(var19);
      int var37 = var1;
      if (var1 == 1 || var1 == 2) {
         int var38 = Math.max(0, Math.min(255, Math.round(var14)));
         var37 |= var38 << 2;
      }

      if (var1 == 2) {
         float var44 = var21;
         var44 %= 360.0F;
         if (var44 < 0.0F) {
            var44 += 360.0F;
         }

         int var39 = Math.max(0, Math.min(255, Math.round(var44 / 360.0F * 255.0F)));
         float var40 = Math.max(0.0F, Math.min(1.0F, var22));
         int var41 = Math.max(0, Math.min(255, Math.round(var40 * 255.0F)));
         var37 |= var39 << 10;
         var37 |= var41 << 18;
      }

      if (var1 == 3 && var14 > 0.0F) {
         var37 |= 4;
      }

      var37 |= var23;
      this.phaseVal.putInt(var37);
      this.phaseVal.putInt(var20);
      this.phaseVal.putInt(0);
      this.phaseVal.putInt(0);
      this.limitRef++;
   }

   private static void primaryVal(ByteBuffer var0, float[] var1, float var2, float var3, float var4, float var5) {
      float[] var6 = var1 != null && var1.length >= 6 ? var1 : bufferVal;
      float var7 = var2;
      float var8 = var3;
      float var9 = var2 + var4;
      float var10 = var3 + var5;
      primaryVal(var0, var6, var7, var8);
      primaryVal(var0, var6, var9, var8);
      primaryVal(var0, var6, var9, var10);
      primaryVal(var0, var6, var7, var10);
   }

   private static void primaryVal(ByteBuffer var0, float[] var1, float var2, float var3) {
      float var4 = var1[0] * var2 + var1[1] * var3 + var1[2];
      float var5 = var1[3] * var2 + var1[4] * var3 + var1[5];
      var0.putFloat(var4);
      var0.putFloat(var5);
   }

   private static void primaryVal(float[] var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      var0[0] = var1;
      var0[1] = var2;
      var0[2] = 0.0F;
      var0[3] = 1.0F;
      var0[4] = var3;
      var0[5] = var4;
      var0[6] = 1.0F;
      var0[7] = 1.0F;
      var0[8] = var5;
      var0[9] = var6;
      var0[10] = 1.0F;
      var0[11] = 0.0F;
      var0[12] = var1;
      var0[13] = var2;
      var0[14] = 0.0F;
      var0[15] = 1.0F;
      var0[16] = var5;
      var0[17] = var6;
      var0[18] = 1.0F;
      var0[19] = 0.0F;
      var0[20] = var7;
      var0[21] = var8;
      var0[22] = 0.0F;
      var0[23] = 0.0F;
   }

   private static float primaryVal(float[] var0, float var1, float var2) {
      return var0[0] * var1 + var0[1] * var2 + var0[2];
   }

   private static float secondaryVal(float[] var0, float var1, float var2) {
      return var0[3] * var1 + var0[4] * var2 + var0[5];
   }

   private static float primaryVal(float var0) {
      if (!Float.isFinite(var0)) {
         return 0.0F;
      } else {
         return var0 <= 0.0F ? 0.0F : var0;
      }
   }

   private static float secondaryVal(float var0) {
      return Math.max(0.0F, Math.min(1.0F, var0));
   }

   private void primaryVal(
      int var1,
      float var2,
      float var3,
      float var4,
      float var5,
      int var6,
      float var7,
      float var8,
      float[] var9,
      float var10,
      float var11,
      float var12,
      float var13,
      int var14,
      float var15,
      float var16
   ) {
      this.primaryVal(
         var1, var2, var3, var4, var5, var6, var6, var6, var6, var7, var7, var7, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16, 0
      );
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, float[] var10) {
      this.paramVal();
      this.primaryVal(0, var1, var2, var3, var4, var9, var9, var9, var9, var5, var6, var7, var8, 0.0F, var10, 0.0F, 0.0F, 1.0F, 1.0F, -1, 0.0F, 1.0F, 0);
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, float var10, float[] var11) {
      this.paramVal();
      this.primaryVal(1, var1, var2, var3, var4, var9, var9, var9, var9, var5, var6, var7, var8, var10, var11, 0.0F, 0.0F, 1.0F, 1.0F, -1, 0.0F, 1.0F, 0);
   }

   public void primaryVal(
      float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, int var10, int var11, int var12, float[] var13
   ) {
      this.paramVal();
      this.primaryVal(0, var1, var2, var3, var4, var9, var10, var11, var12, var5, var6, var7, var8, 0.0F, var13, 0.0F, 0.0F, 1.0F, 1.0F, -1, 0.0F, 1.0F, 0);
   }

   public void primaryVal(
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      int var6,
      int var7,
      int var8,
      int var9,
      float var10,
      float var11,
      float var12,
      float var13,
      boolean var14,
      int var15,
      float[] var16
   ) {
      this.primaryVal(var1, var2, var3, var4, var5, var5, var5, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15, var16);
   }

   public void primaryVal(
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      int var9,
      int var10,
      int var11,
      int var12,
      float var13,
      float var14,
      float var15,
      float var16,
      boolean var17,
      int var18,
      float[] var19
   ) {
      this.paramVal();
      int var20 = Math.max(0, Math.min(7, var18));
      int var21 = 134217728 | (var17 ? 268435456 : 0) | var20 << 29;
      this.primaryVal(
         0, var1, var2, var3, var4, var9, var10, var12, var11, var5, var6, var7, var8, 0.0F, var19, var13, var14, var15, var16, -1, 0.0F, 1.0F, var21
      );
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, int var6, float[] var7) {
      this.primaryVal(var1, var2, var3, var4, var5, 0.0F, var6, var7);
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, int var7, float[] var8) {
      float var9 = var3 * 2.0F;
      this.paramVal();
      this.primaryVal(2, var1 - var3, var2 - var3, var9, var9, var7, 0.0F, var6, var8, 0.0F, 0.0F, 1.0F, 1.0F, -1, var4, var5);
   }

   public void primaryVal(
      float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, int var11, float[] var12
   ) {
      if (!(var3 <= 0.0F) && !(var4 <= 0.0F)) {
         float var13 = var9 > 0.0F ? var9 : 0.0F;
         float var14 = var10 > 0.0F ? var10 : 0.0F;
         float var15 = var14 + var13 * 3.0F;
         float var16 = var1 - var15;
         float var17 = var2 - var15;
         float var18 = var3 + var15 * 2.0F;
         float var19 = var4 + var15 * 2.0F;
         if (!(var18 <= 0.0F) && !(var19 <= 0.0F)) {
            this.paramVal();
            this.primaryVal(
               0,
               var16,
               var17,
               var18,
               var19,
               var11,
               var11,
               var11,
               var11,
               var5,
               var6,
               var7,
               var8,
               0.0F,
               var12,
               var3,
               var4,
               Math.max(var13, 0.001F),
               var14,
               0,
               0.0F,
               1.0F,
               67108864
            );
         }
      }
   }

   public void primaryVal(int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10, float[] var11) {
      this.paramVal();
      int var12 = this.marginVal(var1);
      this.primaryVal(3, var2, var3, var4, var5, var10, 0.0F, 0.0F, var11, var6, var7, var8, var9, var12, 0.0F, 1.0F);
   }

   public void primaryVal(
      int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, int var11, float[] var12
   ) {
      this.paramVal();
      int var13 = this.marginVal(var1);
      this.primaryVal(3, var2, var3, var4, var5, var11, var10, 0.0F, var12, var6, var7, var8, var9, var13, 0.0F, 1.0F);
   }

   public void secondaryVal(int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10, float[] var11) {
      this.primaryVal(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, false);
   }

   public void primaryVal(
      int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10, float[] var11, boolean var12
   ) {
      this.paramVal();
      int var13 = this.marginVal(var1);
      int var14 = var12 ? 64 : 0;
      this.primaryVal(
         3, var2, var3, var4, var5, var10, var10, var10, var10, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, var11, var6, var7, var8, var9, var13, 0.0F, 1.0F, var14
      );
   }

   public void secondaryVal(
      int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, int var11, float[] var12
   ) {
      this.primaryVal(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, false);
   }

   public void primaryVal(
      int var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      int var11,
      float[] var12,
      boolean var13
   ) {
      this.paramVal();
      int var14 = this.marginVal(var1);
      int var15 = var13 ? 64 : 0;
      this.primaryVal(
         3, var2, var3, var4, var5, var11, var11, var11, var11, var10, var10, var10, var10, 1.0F, var12, var6, var7, var8, var9, var14, 0.0F, 1.0F, var15
      );
   }

   public void tertiaryVal(
      int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, int var11, float[] var12
   ) {
      this.paramVal();
      this.secondaryVal(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, false);
   }

   public void secondaryVal(
      int var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      int var11,
      float[] var12,
      boolean var13
   ) {
      this.primaryVal(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var10, var10, var10, var11, var12, var13);
   }

   public void primaryVal(
      int var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      int var14,
      float[] var15,
      boolean var16
   ) {
      this.paramVal();
      int var17 = this.marginVal(var1);
      byte var18 = 8;
      if (var16) {
         var18 |= 32;
      }

      this.primaryVal(
         3, var2, var3, var4, var5, var14, var14, var14, var14, var10, var11, var12, var13, 1.0F, var15, var6, var7, var8, var9, var17, 0.0F, 1.0F, var18
      );
   }

   public void tertiaryVal(int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10, float[] var11) {
      this.paramVal();
      int var12 = this.marginVal(var1);
      byte var13 = 8;
      this.primaryVal(
         3, var2, var3, var4, var5, var10, var10, var10, var10, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, var11, var6, var7, var8, var9, var12, 0.0F, 1.0F, var13
      );
   }

   public void marginVal(
      int var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, int var11, float[] var12
   ) {
      if (var1 > 0) {
         this.paramVal();
         int var13 = this.marginVal(var1);
         float var14 = var2 > 0.0F ? var2 : 0.001F;
         this.primaryVal(
            3, var3, var4, var5, var6, var11, var11, var11, var11, var14, var14, var14, var14, 0.0F, var12, var7, var8, var9, var10, var13, 0.0F, 1.0F, 16
         );
      }
   }

   private int marginVal(int var1) {
      int var2 = this.speedRef.get(var1);
      if (var2 >= 0) {
         return var2;
      }

      if (this.guardVal >= 16) {
         this.secondaryVal();
         this.extraVal();
      }

      int var3 = this.guardVal++;
      this.countRef[var3] = var1;
      this.speedRef.put(var1, var3);
      return var3;
   }

   public void primaryVal(ByteBuffer var1, int var2) {
   }

   public int primaryVal(int var1, int var2, ByteBuffer var3) {
      if (var1 <= 0 || var2 <= 0) {
         throw new IllegalArgumentException("Invalid MSDF texture dimensions: " + var1 + "x" + var2);
      }

      if (var3 == null) {
         throw new IllegalArgumentException("data");
      }

      int var4 = GL11.glGetInteger(34016);
      int var5 = GL11.glGetInteger(32873);
      int var6 = GL11.glGetInteger(3317);
      int var7 = GL11.glGetInteger(3314);
      int var8 = GL11.glGenTextures();

      try {
         GL13.glActiveTexture(33984);
         GL11.glBindTexture(3553, var8);
         GL11.glTexParameteri(3553, 10241, 9729);
         GL11.glTexParameteri(3553, 10240, 9729);
         GL12.glTexParameteri(3553, 33084, 0);
         GL12.glTexParameteri(3553, 33085, 0);
         GL11.glTexParameteri(3553, 10242, 33071);
         GL11.glTexParameteri(3553, 10243, 33071);
         GL11.glPixelStorei(3317, 1);
         GL12.glPixelStorei(3314, 0);
         var3.rewind();
         GL11.glTexImage2D(3553, 0, 32856, var1, var2, 0, 6408, 5121, var3);
         return var8;
      } finally {
         GL12.glPixelStorei(3314, var7);
         GL11.glPixelStorei(3317, var6);
         GL11.glBindTexture(3553, var5);
         GL13.glActiveTexture(var4);
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public int marginVal(int var1, int var2) {
      int var3 = GL11.glGetInteger(34016);
      int var4 = GL11.glGetInteger(32873);
      int var5 = GL11.glGetInteger(3317);
      int var6 = GL11.glGetInteger(3314);
      int var7 = GL11.glGenTextures();
      boolean var11 = false /* VF: Semaphore variable */;

      int var8;
      try {
         var11 = true;
         GL13.glActiveTexture(33984);
         GL11.glBindTexture(3553, var7);
         GL11.glTexParameteri(3553, 10241, 9729);
         GL11.glTexParameteri(3553, 10240, 9729);
         GL12.glTexParameteri(3553, 33084, 0);
         GL12.glTexParameteri(3553, 33085, 0);
         GL11.glTexParameteri(3553, 10242, 33071);
         GL11.glTexParameteri(3553, 10243, 33071);
         GL11.glTexParameteri(3553, 36418, 6403);
         GL11.glTexParameteri(3553, 36419, 6403);
         GL11.glTexParameteri(3553, 36420, 6403);
         GL11.glTexParameteri(3553, 36421, 6403);
         GL11.glPixelStorei(3317, 1);
         GL12.glPixelStorei(3314, 0);
         GlTextureUpload.primaryVal(33321, var1, var2, 6403, 5121);
         var8 = var7;
         var11 = false;
      } finally {
         if (var11) {
            GL12.glPixelStorei(3314, var6);
            GL11.glPixelStorei(3317, var5);
            GL11.glBindTexture(3553, var4);
            GL13.glActiveTexture(var3);
         }
      }

      GL12.glPixelStorei(3314, var6);
      GL11.glPixelStorei(3317, var5);
      GL11.glBindTexture(3553, var4);
      GL13.glActiveTexture(var3);
      return var8;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void primaryVal(int var1, int var2, int var3, int var4, int var5, ByteBuffer var6) {
      int var7 = GL11.glGetInteger(34016);
      int var8 = GL11.glGetInteger(32873);
      int var9 = GL11.glGetInteger(3317);
      int var10 = GL11.glGetInteger(3314);
      boolean var13 = false /* VF: Semaphore variable */;

      try {
         var13 = true;
         var6.order(ByteOrder.nativeOrder());
         GL13.glActiveTexture(33984);
         GL11.glBindTexture(3553, var1);
         GL11.glPixelStorei(3317, 1);
         GL12.glPixelStorei(3314, 0);
         GL11.glTexSubImage2D(3553, 0, var2, var3, var4, var5, 6403, 5121, var6);
         var13 = false;
      } finally {
         if (var13) {
            GL12.glPixelStorei(3314, var10);
            GL11.glPixelStorei(3317, var9);
            GL11.glBindTexture(3553, var8);
            GL13.glActiveTexture(var7);
         }
      }

      GL12.glPixelStorei(3314, var10);
      GL11.glPixelStorei(3317, var9);
      GL11.glBindTexture(3553, var8);
      GL13.glActiveTexture(var7);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void primaryVal(int var1, int var2, int var3, int var4, int var5, ByteBuffer var6, int var7) {
      int var8 = GL11.glGetInteger(34016);
      int var9 = GL11.glGetInteger(32873);
      int var10 = GL11.glGetInteger(3317);
      int var11 = GL11.glGetInteger(3314);
      boolean var14 = false /* VF: Semaphore variable */;

      try {
         var14 = true;
         var6.order(ByteOrder.nativeOrder());
         GL13.glActiveTexture(33984);
         GL11.glBindTexture(3553, var1);
         GL11.glPixelStorei(3317, 1);
         GL12.glPixelStorei(3314, var7);
         GL11.glTexSubImage2D(3553, 0, var2, var3, var4, var5, 6403, 5121, var6);
         var14 = false;
      } finally {
         if (var14) {
            GL12.glPixelStorei(3314, var11);
            GL11.glPixelStorei(3317, var10);
            GL11.glBindTexture(3553, var9);
            GL13.glActiveTexture(var8);
         }
      }

      GL12.glPixelStorei(3314, var11);
      GL11.glPixelStorei(3317, var10);
      GL11.glBindTexture(3553, var9);
      GL13.glActiveTexture(var8);
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void primaryVal(int var1, int var2, boolean var3) {
      if (var1 > 0 && var2 > 0) {
         int var4 = var3 ? this.VuunNUUUvu : this.nvuVvuNnNUnv;
         int var5 = var3 ? this.tokenVal : this.OCOocoOoOO;
         int var6 = var3 ? this.NNUUNUuVNNVn : this.nodeF;
         int var7 = var3 ? this.VvVvnNUnvuvV : this.nodeH;
         if (var4 == 0 || var5 == 0 || var1 != var6 || var2 != var7 || !GL11.glIsTexture(var4) || !GL30.glIsFramebuffer(var5)) {
            int var8 = 0;
            int var9 = 0;
            GLStateSnapshot.Snapshot var10 = GLStateSnapshot.primaryVal();
            boolean var15 = false /* VF: Semaphore variable */;

            try {
               var15 = true;
               var8 = GL11.glGenTextures();
               GL11.glBindTexture(3553, var8);
               GL11.glTexParameteri(3553, 10241, 9729);
               GL11.glTexParameteri(3553, 10240, 9729);
               GL11.glTexParameteri(3553, 10242, 33071);
               GL11.glTexParameteri(3553, 10243, 33071);
               GlTextureUpload.primaryVal(32856, var1, var2, 6408, 5121);
               var9 = GL30.glGenFramebuffers();
               GL30.glBindFramebuffer(36160, var9);
               GL30.glFramebufferTexture2D(36160, 36064, 3553, var8, 0);
               GL11.glDrawBuffer(36064);
               int var11 = GL30.glCheckFramebufferStatus(36160);
               if (var11 != 36053) {
                  throw new IllegalStateException("Capture FBO incomplete: status=" + var11);
               }

               var15 = false;
            } catch (RuntimeException | Error var16) {
               if (var9 != 0) {
                  GL30.glDeleteFramebuffers(var9);
               }

               if (var8 != 0) {
                  GL11.glDeleteTextures(var8);
               }

               throw var16;
            } finally {
               if (var15) {
                  GLStateSnapshot.tertiaryVal(var10);
               }
            }

            GLStateSnapshot.tertiaryVal(var10);
            if (var5 != 0) {
               GL30.glDeleteFramebuffers(var5);
            }

            if (var4 != 0) {
               GL11.glDeleteTextures(var4);
            }

            if (var3) {
               this.VuunNUUUvu = var8;
               this.tokenVal = var9;
               this.NNUUNUuVNNVn = var1;
               this.VvVvnNUnvuvV = var2;
            } else {
               this.nvuVvuNnNUnv = var8;
               this.OCOocoOoOO = var9;
               this.nodeF = var1;
               this.nodeH = var2;
            }
         }
      } else {
         if (var3) {
            this.tertiaryVal(true);
         } else {
            this.tertiaryVal(false);
         }
      }
   }

   private void secondaryVal(Renderer2DBackend.VvunVVUvUNnv var1, int var2, int var3, boolean var4) {
      if (var1 != null) {
         if (var2 > 0 && var3 > 0) {
            boolean var5 = var1.secondaryVal != 0 && var1.primaryVal != 0;
            boolean var6 = var1.tertiaryVal >= var2 && var1.marginVal >= var3;
            boolean var7 = var1.tertiaryVal == var2 && var1.marginVal == var3;
            if (!var5 || (var4 ? !var6 : !var7)) {
               int var8 = var4 ? CapacityUtil.primaryVal(var5 ? var1.tertiaryVal : 0, var2) : var2;
               int var9 = var4 ? CapacityUtil.primaryVal(var5 ? var1.marginVal : 0, var3) : var3;
               int var10 = 0;
               int var11 = 0;
               GLStateSnapshot.Snapshot var12 = GLStateSnapshot.primaryVal();

               try {
                  var10 = GL11.glGenTextures();
                  GL11.glBindTexture(3553, var10);
                  GL11.glTexParameteri(3553, 10241, 9729);
                  GL11.glTexParameteri(3553, 10240, 9729);
                  GL11.glTexParameteri(3553, 10242, 33071);
                  GL11.glTexParameteri(3553, 10243, 33071);
                  GlTextureUpload.primaryVal(32856, var8, var9, 6408, 5121);
                  var11 = GL30.glGenFramebuffers();
                  GL30.glBindFramebuffer(36160, var11);
                  GL30.glFramebufferTexture2D(36160, 36064, 3553, var10, 0);
                  GL11.glDrawBuffer(36064);
                  GL11.glReadBuffer(36064);
                  int var13 = GL30.glCheckFramebufferStatus(36160);
                  if (var13 != 36053) {
                     throw new IllegalStateException("Layer framebuffer incomplete: status=" + var13);
                  }
               } catch (RuntimeException | Error var17) {
                  if (var11 != 0) {
                     GL30.glDeleteFramebuffers(var11);
                  }

                  if (var10 != 0) {
                     GL11.glDeleteTextures(var10);
                  }

                  throw var17;
               } finally {
                  GLStateSnapshot.tertiaryVal(var12);
               }

               this.primaryVal(var1);
               var1.secondaryVal = var10;
               var1.primaryVal = var11;
               var1.tertiaryVal = var8;
               var1.marginVal = var9;
            }
         } else {
            this.primaryVal(var1);
         }
      }
   }

   private void primaryVal(Renderer2DBackend.VvunVVUvUNnv var1) {
      if (var1 != null) {
         if (var1.primaryVal != 0) {
            GL30.glDeleteFramebuffers(var1.primaryVal);
            var1.primaryVal = 0;
         }

         if (var1.secondaryVal != 0) {
            GL11.glDeleteTextures(var1.secondaryVal);
            var1.secondaryVal = 0;
         }

         var1.tertiaryVal = 0;
         var1.marginVal = 0;
      }
   }

   private void anchorVal() {
      for (Renderer2DBackend.VvunVVUvUNnv var2 : this.NNVNuUvVn) {
         this.primaryVal(var2);
      }

      this.NNVNuUvVn.clear();
      this.vuNnuUnu = 0;
   }

   private void limitVal(int var1, int var2) {
      this.primaryVal(var1, var2, this.UvNNVUVNVuvV, this.NnunUUnU);
   }

   private void primaryVal(int var1, int var2, float var3, float var4) {
      if (var1 <= 0 || var2 <= 0) {
         this.depthVal();
      } else {
         if (!Float.isFinite(var3) || !Float.isFinite(var4)) {
            throw new IllegalArgumentException("Blur capture scale must be finite");
         }

         if (!(var3 <= 0.0F) && !(var4 <= 0.0F)) {
            int var5 = Math.max(1, var1);
            int var6 = Math.max(1, var2);
            int var7 = Math.max(1, Math.round(var5 * var3));
            int var8 = Math.max(1, Math.round(var6 * var4));
            if (this.NUVvUUVuVNVv == 0
               || this.UnvuVuVnNuvu == 0
               || var7 != this.nodeB
               || var8 != this.UNvvunVVn
               || !GL11.glIsTexture(this.NUVvUUVuVNVv)
               || !GL30.glIsFramebuffer(this.UnvuVuVnNuvu)) {
               int var9 = 0;
               int var10 = 0;
               GLStateSnapshot.Snapshot var11 = GLStateSnapshot.primaryVal();

               try {
                  var9 = GL11.glGenTextures();
                  GL11.glBindTexture(3553, var9);
                  GL11.glTexParameteri(3553, 10241, 9729);
                  GL11.glTexParameteri(3553, 10240, 9729);
                  GL11.glTexParameteri(3553, 10242, 33071);
                  GL11.glTexParameteri(3553, 10243, 33071);
                  GlTextureUpload.primaryVal(32856, var7, var8, 6408, 5121);
                  var10 = GL30.glGenFramebuffers();
                  GL30.glBindFramebuffer(36160, var10);
                  GL30.glFramebufferTexture2D(36160, 36064, 3553, var9, 0);
                  GL11.glDrawBuffer(36064);
                  int var12 = GL30.glCheckFramebufferStatus(36160);
                  if (var12 != 36053) {
                     throw new IllegalStateException("Downscaled capture FBO incomplete: status=" + var12);
                  }
               } catch (RuntimeException | Error var16) {
                  if (var10 != 0) {
                     GL30.glDeleteFramebuffers(var10);
                  }

                  if (var9 != 0) {
                     GL11.glDeleteTextures(var9);
                  }

                  throw var16;
               } finally {
                  GLStateSnapshot.tertiaryVal(var11);
               }

               if (this.UnvuVuVnNuvu != 0) {
                  GL30.glDeleteFramebuffers(this.UnvuVuVnNuvu);
               }

               if (this.NUVvUUVuVNVv != 0) {
                  GL11.glDeleteTextures(this.NUVvUUVuVNVv);
               }

               this.UnvuVuVnNuvu = var10;
               this.NUVvUUVuVNVv = var9;
               this.nodeB = var7;
               this.UNvvunVVn = var8;
            }
         } else {
            throw new IllegalArgumentException("Blur capture scale must be positive");
         }
      }
   }

   public int primaryVal(int var1, int var2, int var3, int var4) {
      return this.primaryVal(var1, var2, var3, var4, true);
   }

   public int primaryVal(int var1, int var2, int var3, int var4, boolean var5) {
      if (var3 > 0 && var4 > 0 && this.groupVal > 0 && this.layerVal > 0) {
         this.primaryVal(var3, var4, var5);
         int var6 = var5 ? this.tokenVal : this.OCOocoOoOO;
         int var7 = var5 ? this.VuunNUUUvu : this.nvuVvuNnNUnv;
         if (var6 != 0 && var7 != 0) {
            int var8 = GL11.glGetInteger(36006);
            int var9 = Math.max(0, Math.min(var1, this.groupVal));
            int var10 = Math.max(0, Math.min(this.layerVal, this.layerVal - var2 - var4));
            int var11 = Math.min(var3, this.groupVal - var9);
            int var12 = Math.min(var4, this.layerVal - var10);
            if (var11 > 0 && var12 > 0) {
               GLStateSnapshot.Snapshot var13 = GLStateSnapshot.primaryVal();

               try {
                  boolean var14 = GL11.glIsEnabled(3089);
                  boolean var15 = GL11.glIsEnabled(36281);
                  if (var14) {
                     GL11.glDisable(3089);
                  }

                  if (var15) {
                     GL11.glDisable(36281);
                  }

                  GL30.glBindFramebuffer(36008, var8);
                  GL11.glReadBuffer(var8 == 0 ? 1029 : 36064);
                  GL30.glBindFramebuffer(36009, var6);
                  GL11.glDrawBuffer(36064);
                  GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
                  GL11.glClear(16384);
                  weightRef();
                  GL30.glBlitFramebuffer(var9, var10, var9 + var11, var10 + var12, 0, 0, var3, var4, 16384, 9728);
                  if (GL11.glGetError() != 0) {
                     return 0;
                  }

                  if (var14) {
                     GL11.glEnable(3089);
                  }

                  if (var15) {
                     GL11.glEnable(36281);
                  }
               } finally {
                  GLStateSnapshot.tertiaryVal(var13);
               }

               return var7;
            } else {
               return 0;
            }
         } else {
            return 0;
         }
      } else {
         return 0;
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public boolean primaryVal(int var1, int var2, float var3) {
      if (var1 > 0 && var2 > 0) {
         float var4 = 1.0F;
         float var5 = 1.0F;
         float var6 = this.UvNNVUVNVuvV;
         float var7 = this.NnunUUnU;
         float var8 = this.vNUUvuuVU.secondaryVal();
         if (var3 > var8) {
            float var9 = this.vNUUvuuVU.primaryVal();
            float var10 = Math.max(var3, var9);
            float var11 = var8 / var10;
            var11 = Math.max(var11, 0.2F);
            var4 = Math.min(var4, var11);
            var5 = Math.min(var5, var11);
         }

         var4 = Math.max(var4, var6);
         var5 = Math.max(var5, var7);
         this.primaryVal(var1, var2, var4, var5);
         if (this.NUVvUUVuVNVv != 0 && this.UnvuVuVnNuvu != 0) {
            float var26 = (float)this.nodeB / Math.max(1, var1);
            float var27 = (float)this.UNvvunVVn / Math.max(1, var2);
            GLStateSnapshot.Snapshot var29 = GLStateSnapshot.primaryVal();
            boolean var22 = false /* VF: Semaphore variable */;

            int var34;
            label145: {
               boolean var35;
               label157: {
                  try {
                     var22 = true;
                     boolean var12 = GL11.glIsEnabled(3089);
                     boolean var13 = GL11.glIsEnabled(36281);
                     if (var12) {
                        GL11.glDisable(3089);
                     }

                     if (var13) {
                        GL11.glDisable(36281);
                     }

                     boolean var14 = false;
                     class_310 var15 = class_310.method_1551();
                     if (var15 != null && var15.method_22683() != null && !var15.method_22683().method_65966()) {
                        class_276 var16 = var15.method_1522();
                        if (var16 != null && var16.method_30277() instanceof class_10868 var18) {
                           int var19 = var18.method_68427();
                           if (var19 > 0) {
                              if (this.twigB == 0) {
                                 this.twigB = GL30.glGenFramebuffers();
                              }

                              GL30.glBindFramebuffer(36008, this.twigB);
                              GL30.glFramebufferTexture2D(36008, 36064, 3553, var19, 0);
                              GL11.glReadBuffer(36064);
                              var14 = GL30.glCheckFramebufferStatus(36008) == 36053;
                           }
                        }
                     }

                     if (!var14) {
                        this.UvNNNUvNnUUV = 0;
                        this.spanH = 0;
                        this.OCCc0co0OOC = 0;
                        this.unUvvVVVVUu = 1.0F;
                        this.unitG = 1.0F;
                        var34 = 0;
                        var22 = false;
                        break label145;
                     }

                     GL30.glBindFramebuffer(36009, this.UnvuVuVnNuvu);
                     GL11.glDrawBuffer(36064);
                     weightRef();
                     GL30.glBlitFramebuffer(0, 0, var1, var2, 0, 0, this.nodeB, this.UNvvunVVn, 16384, 9729);
                     var34 = GL11.glGetError();
                     if (var34 != 0) {
                        weightRef();
                        GL30.glBlitFramebuffer(0, 0, var1, var2, 0, 0, this.nodeB, this.UNvvunVVn, 16384, 9728);
                        var34 = GL11.glGetError();
                     }

                     if (var34 != 0) {
                        this.UvNNNUvNnUUV = 0;
                        this.spanH = 0;
                        this.OCCc0co0OOC = 0;
                        this.unUvvVVVVUu = 1.0F;
                        this.unitG = 1.0F;
                        var35 = false;
                        var22 = false;
                        break label157;
                     }

                     if (var12) {
                        GL11.glEnable(3089);
                     }

                     if (var13) {
                        GL11.glEnable(36281);
                        var22 = false;
                     } else {
                        var22 = false;
                     }
                  } finally {
                     if (var22) {
                        GLStateSnapshot.tertiaryVal(var29);
                     }
                  }

                  GLStateSnapshot.tertiaryVal(var29);
                  float var30 = (float)Math.sqrt(Math.max(0.0F, var26) * Math.max(0.0F, var27));
                  float var31 = Math.max(0.0F, var3) * var30;
                  int var32 = this.vNUUvuuVU.primaryVal(this.NUVvUUVuVNVv, this.nodeB, this.UNvvunVVn, var31);
                  if (var32 == 0) {
                     this.UvNNNUvNnUUV = 0;
                     this.spanH = 0;
                     this.OCCc0co0OOC = 0;
                     this.unUvvVVVVUu = 1.0F;
                     this.unitG = 1.0F;
                     return false;
                  }

                  this.UvNNNUvNnUUV = var32;
                  this.spanH = this.nodeB;
                  this.OCCc0co0OOC = this.UNvvunVVn;
                  this.unUvvVVVVUu = var26;
                  this.unitG = var27;
                  return true;
               }

               GLStateSnapshot.tertiaryVal(var29);
               return var35;
            }

            GLStateSnapshot.tertiaryVal(var29);
            return var34 == 0;
         } else {
            this.UvNNNUvNnUUV = 0;
            this.spanH = 0;
            this.OCCc0co0OOC = 0;
            this.unUvvVVVVUu = 1.0F;
            this.unitG = 1.0F;
            return false;
         }
      } else {
         this.UvNNNUvNnUUV = 0;
         this.spanH = 0;
         this.OCCc0co0OOC = 0;
         this.unUvvVVVVUu = 1.0F;
         this.unitG = 1.0F;
         return false;
      }
   }

   private static void weightRef() {
      while (GL11.glGetError() != 0) {
      }
   }

   public boolean primaryVal(int var1, int var2, int var3, int var4, float var5) {
      if (var3 > 0 && var4 > 0) {
         int var6 = this.primaryVal(var1, var2, var3, var4, false);
         if (var6 <= 0) {
            this.unitI = 0;
            this.VNvuVnvnun = 0;
            this.unVVnuunNU = 0;
            this.NunnVUUuvUV = 0;
            this.unitD = 0;
            return false;
         } else {
            int var7 = this.unitB.primaryVal(var6, var3, var4, var5);
            this.unitI = var7;
            this.VNvuVnvnun = var3;
            this.unVVnuunNU = var4;
            this.NunnVUUuvUV = var1;
            this.unitD = var2;
            return var7 != 0;
         }
      } else {
         this.unitI = 0;
         this.VNvuVnvnun = 0;
         this.unVVnuunNU = 0;
         this.NunnVUUuvUV = 0;
         this.unitD = 0;
         return false;
      }
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float[] var7) {
      this.primaryVal(var1, var2, var3, var4, var5, var5, var5, var5, var6, var7);
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float[] var10) {
      if (this.UvNNNUvNnUUV != 0) {
         this.paramVal();
         int var11 = (int)(Math.max(0.0F, Math.min(1.0F, var9)) * 255.0F) << 24 | 16777215;
         float var12 = this.spanH > 0 ? this.unUvvVVVVUu / this.spanH : 0.0F;
         float var13 = this.OCCc0co0OOC > 0 ? -this.unitG / this.OCCc0co0OOC : 0.0F;
         float var14 = 0.0F;
         float var15 = this.OCCc0co0OOC > 0 ? 1.0F : 0.0F;
         this.primaryVal(this.UvNNNUvNnUUV, var1, var2, var3, var4, var12, var13, var14, var15, var5, var6, var7, var8, var11, var10, true);
      }
   }

   public boolean primaryVal(
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      int var9,
      float var10,
      int var11,
      float var12,
      float[] var13
   ) {
      if (this.UvNNNUvNnUUV == 0) {
         return false;
      }

      this.paramVal();
      int var14 = this.marginVal(this.UvNNNUvNnUUV);
      int var15 = Math.round(secondaryVal(var10) * 255.0F) << 24 | var9 & 16777215;
      int var16 = Math.round(secondaryVal(var12) * 255.0F) << 24 | var9 & 16777215;
      float var17 = this.spanH > 0 ? this.unUvvVVVVUu / this.spanH : 0.0F;
      float var18 = this.OCCc0co0OOC > 0 ? -this.unitG / this.OCCc0co0OOC : 0.0F;
      float var19 = this.OCCc0co0OOC > 0 ? 1.0F : 0.0F;
      short var20 = 168;
      this.primaryVal(
         3, var1, var2, var3, var4, var9, var11, var16, var15, var5, var6, var7, var8, 1.0F, var13, var17, var18, 0.0F, var19, var14, 0.0F, 1.0F, var20
      );
      return true;
   }

   public void primaryVal(float var1, float var2, float var3, float var4, float var5, float var6, float[] var7, int var8, int var9, int var10, int var11) {
      if (this.unitI != 0) {
         if (var10 > 0 && var11 > 0) {
            if (this.VNvuVnvnun == var10 && this.unVVnuunNU == var11 && this.NunnVUUuvUV == var8 && this.unitD == var9) {
               this.paramVal();
               int var12 = (int)(Math.max(0.0F, Math.min(1.0F, var6)) * 255.0F) << 24 | 16777215;
               float var13 = 0.0F;
               float var14 = 1.0F;
               float var15 = 1.0F;
               float var16 = 0.0F;
               this.secondaryVal(this.unitI, var1, var2, var3, var4, var13, var14, var15, var16, var5, var12, var7, false);
            }
         }
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public Renderer2DBackend.WildClient marginVal() {
      class_310 var1 = class_310.method_1551();
      if (var1 != null && var1.method_22683() != null && !var1.method_22683().method_65966()) {
         class_276 var2 = var1.method_1522();
         if (var2 == null) {
            return new Renderer2DBackend.WildClient(0, 0, 0, 0);
         }

         if (var2.method_30277() instanceof class_10868 var4) {
            int var5 = var4.method_68427();
            if (var5 <= 0) {
               return new Renderer2DBackend.WildClient(0, 0, 0, 0);
            }

            int var6 = var1.method_22683().method_4489();
            int var7 = var1.method_22683().method_4506();
            if (var6 > 0 && var7 > 0 && var2.field_1482 > 0 && var2.field_1481 > 0) {
               this.o0Ooc0COOoc.primaryVal(var6, var7);
               if (this.o0Ooc0COOoc.primaryVal != 0 && this.o0Ooc0COOoc.secondaryVal != 0 && this.o0Ooc0COOoc.tertiaryVal != 0) {
                  this.limitVal();
                  ShaderProgram var8 = this.speedVal();
                  GLStateSnapshot.Snapshot var9 = GLStateSnapshot.primaryVal();
                  boolean var13 = false /* VF: Semaphore variable */;

                  Renderer2DBackend.WildClient var15;
                  label99: {
                     label98: {
                        try {
                           var13 = true;
                           GL30.glBindFramebuffer(36160, this.o0Ooc0COOoc.primaryVal);
                           GL11.glDrawBuffer(36064);
                           if (GL30.glCheckFramebufferStatus(36160) != 36053) {
                              var15 = new Renderer2DBackend.WildClient(0, 0, 0, 0);
                              var13 = false;
                              break label99;
                           }

                           GL11.glViewport(0, 0, var6, var7);
                           GL11.glDisable(3089);
                           GL11.glDisable(2884);
                           GL11.glDisable(3042);
                           GL11.glDisable(2929);
                           GL11.glDisable(36281);
                           GL11.glColorMask(true, true, true, true);
                           GL11.glDepthMask(false);
                           weightRef();
                           var8.primaryVal();
                           if (this.VunnVNvNV >= 0) {
                              GL20.glUniform1i(this.VunnVNvNV, 0);
                           }

                           GL13.glActiveTexture(33984);
                           GL11.glBindTexture(3553, var5);
                           GL30.glBindVertexArray(this.UnUUVuVunvVu);
                           FrameStatsTracker.primaryVal().primaryVal(2);
                           GL11.glDrawArrays(4, 0, 6);
                           GL30.glBindVertexArray(0);
                           if (GL11.glGetError() != 0) {
                              var15 = new Renderer2DBackend.WildClient(0, 0, 0, 0);
                              var13 = false;
                              break label98;
                           }

                           var13 = false;
                        } finally {
                           if (var13) {
                              GL13.glActiveTexture(33984);
                              GL11.glBindTexture(3553, 0);
                              GL20.glUseProgram(0);
                              GLStateSnapshot.tertiaryVal(var9);
                           }
                        }

                        GL13.glActiveTexture(33984);
                        GL11.glBindTexture(3553, 0);
                        GL20.glUseProgram(0);
                        GLStateSnapshot.tertiaryVal(var9);
                        return new Renderer2DBackend.WildClient(this.o0Ooc0COOoc.secondaryVal, 0, var6, var7);
                     }

                     GL13.glActiveTexture(33984);
                     GL11.glBindTexture(3553, 0);
                     GL20.glUseProgram(0);
                     GLStateSnapshot.tertiaryVal(var9);
                     return var15;
                  }

                  GL13.glActiveTexture(33984);
                  GL11.glBindTexture(3553, 0);
                  GL20.glUseProgram(0);
                  GLStateSnapshot.tertiaryVal(var9);
                  return var15;
               } else {
                  return new Renderer2DBackend.WildClient(0, 0, 0, 0);
               }
            } else {
               return new Renderer2DBackend.WildClient(0, 0, 0, 0);
            }
         } else {
            return new Renderer2DBackend.WildClient(0, 0, 0, 0);
         }
      } else {
         return new Renderer2DBackend.WildClient(0, 0, 0, 0);
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public void primaryVal(int var1, int var2, int var3) {
      if (var1 > 0 && var2 > 0 && var3 > 0) {
         this.limitVal();
         ShaderProgram var4 = this.speedVal();
         GLStateSnapshot.Snapshot var5 = GLStateSnapshot.primaryVal();
         boolean var8 = false /* VF: Semaphore variable */;

         try {
            var8 = true;
            GL30.glBindFramebuffer(36160, 0);
            GL11.glViewport(0, 0, var2, var3);
            GL11.glDisable(3089);
            GL11.glDisable(2884);
            GL11.glDisable(2929);
            GL11.glDisable(3042);
            GL11.glDisable(36281);
            var4.primaryVal();
            if (this.VunnVNvNV >= 0) {
               GL20.glUniform1i(this.VunnVNvNV, 0);
            }

            GL13.glActiveTexture(33984);
            GL11.glBindTexture(3553, var1);
            GL30.glBindVertexArray(this.UnUUVuVunvVu);
            FrameStatsTracker.primaryVal().primaryVal(2);
            GL11.glDrawArrays(4, 0, 6);
            GL30.glBindVertexArray(0);
            var8 = false;
         } finally {
            if (var8) {
               GL13.glActiveTexture(33984);
               GL11.glBindTexture(3553, 0);
               GL20.glUseProgram(0);
               GLStateSnapshot.tertiaryVal(var5);
            }
         }

         GL13.glActiveTexture(33984);
         GL11.glBindTexture(3553, 0);
         GL20.glUseProgram(0);
         GLStateSnapshot.tertiaryVal(var5);
      }
   }

   public void primaryVal(int var1, int var2, int var3, ShaderProgram var4, Runnable var5, boolean var6) {
      if (var1 > 0 && var2 > 0 && var3 > 0 && var4 != null) {
         this.limitVal();
         GLStateSnapshot.Snapshot var7 = GLStateSnapshot.primaryVal();

         try {
            int var8 = GL11.glGetInteger(36006);
            GL30.glBindFramebuffer(36009, var8);
            GL11.glViewport(0, 0, var2, var3);
            GL11.glDisable(3089);
            GL11.glDisable(2884);
            GL11.glDisable(2929);
            if (var6) {
               GL11.glEnable(3042);
               GL14.glBlendFuncSeparate(770, 771, 1, 771);
            } else {
               GL11.glDisable(3042);
            }

            GL11.glDisable(36281);
            var4.primaryVal();
            if (var5 != null) {
               var5.run();
            }

            GL13.glActiveTexture(33984);
            GL11.glBindTexture(3553, var1);
            GL30.glBindVertexArray(this.UnUUVuVunvVu);
            FrameStatsTracker.primaryVal().primaryVal(2);
            GL11.glDrawArrays(4, 0, 6);
            GL30.glBindVertexArray(0);
         } finally {
            GL13.glActiveTexture(33984);
            GL11.glBindTexture(3553, 0);
            GL20.glUseProgram(0);
            GLStateSnapshot.tertiaryVal(var7);
         }
      }
   }

   public void weightVal(int var1, int var2) {
      if (!this.cellD) {
         if (var1 > 0 && var2 > 0) {
            if (var1 != this.slotVal || var2 != this.themeVal) {
               this.slotVal = var1;
               this.themeVal = var2;
               this.bufferVal();
            }
         } else {
            this.groupVal = 0;
            this.layerVal = 0;
            this.slotVal = -1;
            this.themeVal = -1;
            this.bufferVal();
         }
      }
   }

   private void bufferVal() {
      this.countVal();
      this.tertiaryVal(true);
      this.tertiaryVal(false);
      this.depthVal();
      this.primaryVal(this.twigD);
      this.anchorVal();
      this.o0Ooc0COOoc.primaryVal();
      this.vNUUvuuVU.marginVal();
      this.unitB.marginVal();
      if (this.twigB != 0) {
         GL30.glDeleteFramebuffers(this.twigB);
         this.twigB = 0;
      }
   }

   private void countVal() {
      this.UvNNNUvNnUUV = 0;
      this.spanH = 0;
      this.OCCc0co0OOC = 0;
      this.unUvvVVVVUu = 1.0F;
      this.unitG = 1.0F;
      this.unitI = 0;
      this.NunnVUUuvUV = 0;
      this.unitD = 0;
      this.VNvuVnvnun = 0;
      this.unVVnuunNU = 0;
   }

   private void tertiaryVal(boolean var1) {
      if (var1) {
         if (this.tokenVal != 0) {
            GL30.glDeleteFramebuffers(this.tokenVal);
            this.tokenVal = 0;
         }

         if (this.VuunNUUUvu != 0) {
            GL11.glDeleteTextures(this.VuunNUUUvu);
            this.VuunNUUUvu = 0;
         }

         this.NNUUNUuVNNVn = 0;
         this.VvVvnNUnvuvV = 0;
      } else {
         if (this.OCOocoOoOO != 0) {
            GL30.glDeleteFramebuffers(this.OCOocoOoOO);
            this.OCOocoOoOO = 0;
         }

         if (this.nvuVvuNnNUnv != 0) {
            GL11.glDeleteTextures(this.nvuVvuNnNUnv);
            this.nvuVvuNnNUnv = 0;
         }

         this.nodeF = 0;
         this.nodeH = 0;
      }
   }

   private void depthVal() {
      if (this.UnvuVuVnNuvu != 0) {
         GL30.glDeleteFramebuffers(this.UnvuVuVnNuvu);
         this.UnvuVuVnNuvu = 0;
      }

      if (this.NUVvUUVuVNVv != 0) {
         GL11.glDeleteTextures(this.NUVvUUVuVNVv);
         this.NUVvUUVuVNVv = 0;
      }

      this.nodeB = 0;
      this.UNvvunVVn = 0;
   }

   public void weightVal() {
      if (!this.cellD) {
         this.cellD = true;
         this.vNUUvuuVU.tertiaryVal();
         this.unitB.tertiaryVal();
         this.o0Ooc0COOoc.primaryVal();
         if (this.twigB != 0) {
            GL30.glDeleteFramebuffers(this.twigB);
            this.twigB = 0;
         }

         if (this.UnUUVuVunvVu != 0) {
            GL30.glDeleteVertexArrays(this.UnUUVuVunvVu);
            this.UnUUVuVunvVu = 0;
         }

         if (this.twigC != 0) {
            GL15.glDeleteBuffers(this.twigC);
            this.twigC = 0;
         }

         if (this.nodeD != 0) {
            GL30.glDeleteVertexArrays(this.nodeD);
            this.nodeD = 0;
         }

         if (this.NnuUnUNnu != 0) {
            GL15.glDeleteBuffers(this.NnuUnUNnu);
            this.NnuUnUNnu = 0;
         }

         if (this.uuvvuNvuUNVV != 0) {
            GL30.glDeleteVertexArrays(this.uuvvuNvuUNVV);
            this.uuvvuNvuUNVV = 0;
         }

         if (this.uVvunVUNuUvu != 0) {
            GL15.glDeleteBuffers(this.uVvunVUNuUvu);
            this.uVvunVUNuUvu = 0;
         }

         this.primaryVal(this.twigD);
         this.anchorVal();
         if (this.tokenVal != 0) {
            GL30.glDeleteFramebuffers(this.tokenVal);
            this.tokenVal = 0;
         }

         if (this.VuunNUUUvu != 0) {
            GL11.glDeleteTextures(this.VuunNUUUvu);
            this.VuunNUUUvu = 0;
         }

         this.NNUUNUuVNNVn = 0;
         this.VvVvnNUnvuvV = 0;
         if (this.UnvuVuVnNuvu != 0) {
            GL30.glDeleteFramebuffers(this.UnvuVuVnNuvu);
            this.UnvuVuVnNuvu = 0;
         }

         if (this.NUVvUUVuVNVv != 0) {
            GL11.glDeleteTextures(this.NUVvUUVuVNVv);
            this.NUVvUUVuVNVv = 0;
         }

         this.nodeB = 0;
         this.UNvvunVVn = 0;
         if (this.OCOocoOoOO != 0) {
            GL30.glDeleteFramebuffers(this.OCOocoOoOO);
            this.OCOocoOoOO = 0;
         }

         if (this.nvuVvuNnNUnv != 0) {
            GL11.glDeleteTextures(this.nvuVvuNnNUnv);
            this.nvuVvuNnNUnv = 0;
         }

         this.nodeF = 0;
         this.nodeH = 0;
         this.UvNNNUvNnUUV = 0;
         this.spanH = 0;
         this.OCCc0co0OOC = 0;
         this.unUvvVVVVUu = 1.0F;
         this.unitG = 1.0F;
         this.unitI = 0;
         this.VNvuVnvnun = 0;
         this.unVVnuunNU = 0;
         this.NunnVUUuvUV = 0;
         this.unitD = 0;
         this.extraVal();
         GL30.glBindVertexArray(0);
         GL20.glUseProgram(0);
         if (this.factorVal != 0) {
            GL30.glDeleteVertexArrays(this.factorVal);
         }

         if (this.sourceVal != 0) {
            GL15.glDeleteBuffers(this.sourceVal);
         }

         if (this.extraRef != 0) {
            GL15.glDeleteBuffers(this.extraRef);
         }

         this.radiusVal.secondaryVal();
         if (this.UVnuVUUVnnU != null) {
            this.UVnuVUUVnnU.secondaryVal();
            this.UVnuVUUVnnU = null;
         }

         if (this.UnnnvvU != null) {
            this.UnnnvvU.secondaryVal();
            this.UnnnvvU = null;
         }

         if (this.NVNnnvVnvV != null) {
            this.NVNnnvVnvV.secondaryVal();
            this.NVNnnvVnvV = null;
         }

         if (this.NuvunVvnnN != null) {
            this.NuvunVvnnN.secondaryVal();
            this.NuvunVvnnN = null;
         }

         if (this.uUuuVvVunVVu != null) {
            this.uUuuVvVunVVu.secondaryVal();
            this.uUuuVvVunVVu = null;
         }

         if (this.spanG != null) {
            this.spanG.free();
            this.spanG = null;
         }
      }
   }

   private void primaryVal(GLCapabilities var1) {
      if (this.spanG == null) {
         this.spanG = GLDebugMessageCallback.create((var0, var1x, var2, var3, var4, var5, var7) -> {
            if (var3 != 33387 && var3 != 37192) {
               long var9 = System.currentTimeMillis();
               Long var11 = nvnUvvnUUN.get(var2);
               if (var11 == null || var9 - var11 >= 5000L) {
                  nvnUvvnUUN.put(var2, var9);
                  long var12 = uuuvuUUNVVUN.get();
                  if (var9 - var12 > 1000L) {
                     uuuvuUUNVVUN.set(var9);
                     linkJ.set(0);
                  }

                  if (linkJ.incrementAndGet() <= 8) {
                     String var14 = GLDebugMessageCallback.getMessage(var4, var5);
                     System.err.println("[OpenGL] " + var14 + " (severity=" + weightVal(var3) + ")");
                  }
               }
            }
         });
         if (var1.OpenGL43) {
            GL11.glEnable(37600);
            GL43.glDebugMessageCallback(this.spanG, 0L);
            GL43.glDebugMessageControl(4352, 4352, 33387, (int[])null, false);
            GL43.glDebugMessageControl(4352, 4352, 37192, (int[])null, false);
         } else {
            GL11.glEnable(37600);
            KHRDebug.glDebugMessageCallback(this.spanG, 0L);
            KHRDebug.glDebugMessageControl(4352, 4352, 33387, (int[])null, false);
            KHRDebug.glDebugMessageControl(4352, 4352, 37192, (int[])null, false);
         }
      }
   }

   private static String weightVal(int var0) {
      return switch (var0) {
         case 33387 -> "NOTIFICATION";
         case 37190 -> "HIGH";
         case 37191 -> "MEDIUM";
         case 37192 -> "LOW";
         default -> Integer.toString(var0);
      };
   }

   public record WildClient(int colorTexture, int depthTexture, int width, int height) {
   }

   static final class VvunVVUvUNnv {
      int primaryVal;
      int secondaryVal;
      int tertiaryVal;
      int marginVal;
      final GLStateSnapshot.Snapshot weightVal = new GLStateSnapshot.Snapshot();
      final Renderer2DBackend.cursorVal paramVal = new Renderer2DBackend.cursorVal();
   }

   public static final class cursorVal {
      private int primaryVal;
      private int secondaryVal;
      private int tertiaryVal;
      private int marginVal;
      private int weightVal;
      private GLStateSnapshot.Snapshot paramVal;
      private int extraVal;
      private int limitVal;
      private boolean speedVal;
      private int widthVal;
      private int chunkVal;
      private int blockRef;
      private int holderVal;
      private float timerVal;
      private float anchorVal;
      private float weightRef;
      private float bufferVal;
      private boolean countVal;
      private boolean depthVal;

      Renderer2DBackend.cursorVal primaryVal(
         int var1,
         int var2,
         int var3,
         int var4,
         int var5,
         GLStateSnapshot.Snapshot var6,
         int var7,
         int var8,
         boolean var9,
         int var10,
         int var11,
         int var12,
         int var13,
         float var14,
         float var15,
         float var16,
         float var17,
         boolean var18,
         boolean var19
      ) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
         this.weightVal = var5;
         this.paramVal = var6;
         this.extraVal = var7;
         this.limitVal = var8;
         this.speedVal = var9;
         this.widthVal = var10;
         this.chunkVal = var11;
         this.blockRef = var12;
         this.holderVal = var13;
         this.timerVal = var14;
         this.anchorVal = var15;
         this.weightRef = var16;
         this.bufferVal = var17;
         this.countVal = var18;
         this.depthVal = var19;
         return this;
      }

      public int primaryVal() {
         return this.primaryVal;
      }

      public int secondaryVal() {
         return this.secondaryVal;
      }

      public int tertiaryVal() {
         return this.tertiaryVal;
      }

      public int marginVal() {
         return this.marginVal;
      }

      public int weightVal() {
         return this.weightVal;
      }

      public GLStateSnapshot.Snapshot paramVal() {
         return this.paramVal;
      }

      public int extraVal() {
         return this.extraVal;
      }

      public int limitVal() {
         return this.limitVal;
      }

      public boolean speedVal() {
         return this.speedVal;
      }

      public int widthVal() {
         return this.widthVal;
      }

      public int chunkVal() {
         return this.chunkVal;
      }

      public int blockRef() {
         return this.blockRef;
      }

      public int holderVal() {
         return this.holderVal;
      }

      public float timerVal() {
         return this.timerVal;
      }

      public float anchorVal() {
         return this.anchorVal;
      }

      public float weightRef() {
         return this.weightRef;
      }

      public float bufferVal() {
         return this.bufferVal;
      }

      public boolean countVal() {
         return this.countVal;
      }

      public boolean depthVal() {
         return this.depthVal;
      }
   }
}
