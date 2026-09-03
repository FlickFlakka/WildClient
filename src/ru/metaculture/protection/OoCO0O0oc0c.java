package ru.metaculture.protection;

import net.minecraft.class_1041;
import net.minecraft.class_10868;
import net.minecraft.class_276;
import net.minecraft.class_310;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public final class OoCO0O0oc0c implements AutoCloseable {
   public static final int primaryVal = 14;
   private static final String secondaryVal = "assets/wild/shaders/mainmenu/menu_quad.vert";
   private static final String[] tertiaryVal = marginVal();
   private static final float marginVal = 12.0F;
   private static final float weightVal = 30.0F;
   private static final float paramVal = 0.22F;
   private static final float extraVal = 0.17F;
   private static final float limitVal = 0.62F;
   private static final float speedVal = 3.0F;
   private static final float widthVal = 0.005F;
   private static final float chunkVal = -0.62F;
   private static final float blockRef = (float) (Math.PI * 2);
   private static final float holderVal = 0.85F;
   private static final float timerVal = 0.3F;
   private static final float anchorVal = 0.52F;
   private static final float weightRef = 0.004F;
   private static final float bufferVal = 0.7139F;
   private static final float countVal = 24.0F;
   private static final float depthVal = 0.6F;
   private static final float descRef = 0.6F;
   private static final float activeVal = 1.0F;
   private static final float radiusVal = 0.42F;
   private static final float factorVal = 7.0F;
   private static final float sourceVal = 2.4F;
   private static final float extraRef = 2.2F;
   private static final float phaseVal = 0.8F;
   private static final float limitRef = 0.33F;
   private static final float paramRef = 38.0F;
   private static final float groupVal = 16.0F;
   private static final float layerVal = 9.0F;
   private static final float slotVal = 3.0F;
   private static final float themeVal = 0.48F;
   private static final float stageVal = 3.4F;
   private static final float widthRef = 6.0F;
   private final ShaderProgramCache trackVal = new ShaderProgramCache();
   private final GLStateSnapshot.Snapshot modeRef = new GLStateSnapshot.Snapshot();
   private final GLStateSnapshot.Snapshot angleVal = new GLStateSnapshot.Snapshot();
   private final VvNNUnNNVn heightRef = new VvNNUnNNVn();
   private final VvNNUnNNVn levelVal = new VvNNUnNNVn();
   private final VvNNUnNNVn UuNnnVnuNNV = new VvNNUnNNVn();
   private final VvNNUnNNVn depthRef = new VvNNUnNNVn();
   private final VvNNUnNNVn speedRef = new VvNNUnNNVn();
   private final VvNNUnNNVn countRef = new VvNNUnNNVn();
   private final VvNNUnNNVn entryVal = new VvNNUnNNVn();
   private final VvNNUnNNVn guardVal = new VvNNUnNNVn();
   private final VvNNUnNNVn VUuuVUnun = new VvNNUnNNVn();
   private final VvNNUnNNVn vVVuuVVv = new VvNNUnNNVn();
   private final VvNNUnNNVn VuunNUUUvu = new VvNNUnNNVn();
   private final VvNNUnNNVn NNUUNUuVNNVn = new VvNNUnNNVn();
   private final VvNNUnNNVn VvVvnNUnvuvV = new VvNNUnNNVn();
   private final VvNNUnNNVn tokenVal = new VvNNUnNNVn();
   private ShaderProgramCache.CompiledShader NUVvUUVuVNVv;
   private ShaderProgramCache.CompiledShader nodeB;
   private float[] UNvvunVVn = new float[8];
   private int UnvuVuVnNuvu;
   private int UvNNVUVNVuvV;
   private int NnunUUnU;
   private int nvuVvuNnNUnv;
   private float nodeF;
   private float nodeH;
   private float OCOocoOoOO;
   private float o0Ooc0COOoc;
   private boolean twigB;
   private ShaderProgramCache.CompiledShader UnUUVuVunvVu;
   private ShaderProgramCache.CompiledShader twigC;
   private ShaderProgramCache.CompiledShader UVnuVUUVnnU;
   private ShaderProgramCache.CompiledShader VunnVNvNV;
   private ShaderProgramCache.CompiledShader twigD;
   private ShaderProgramCache.CompiledShader nodeD;
   private ShaderProgramCache.CompiledShader NnuUnUNnu;
   private ShaderProgramCache.CompiledShader UnnnvvU;
   private ShaderProgramCache.CompiledShader VUUnuVvVu;
   private ShaderProgramCache.CompiledShader VvVuvUvvNNVv;
   private float UnnNNvuvvUU;
   private float twigA;
   private float itemC = 1.0F;
   private float itemB;
   private boolean VvuUUUNNNv;
   private ShaderProgramCache.CompiledShader uuuVnuvnnNnU;
   private ShaderProgramCache.CompiledShader nodeJ;
   private ShaderProgramCache.CompiledShader twigH;
   private ShaderProgramCache.CompiledShader vuvvuVuVv;
   private ShaderProgramCache.CompiledShader uunNUuunVU;
   private ShaderProgramCache.CompiledShader NvnuuuvnVV;
   private ShaderProgramCache.CompiledShader NnUVNnuvUv;
   private ShaderProgramCache.CompiledShader UuuuNNunN;
   private FullscreenQuad NNVNuUvVn;
   private int vuNnuUnu;
   private int uuvvuNvuUNVV;
   private int uVvunVUNuUvu;
   private int NVNnnvVnvV;
   private int vUNuuvvnVnv;
   private int unnnNUNnVu;
   private int twigF;
   private int itemG;
   private float nvuUVvuuN;
   private float itemJ;
   private float spanC;
   private float VnnnvUunNvuu;
   private float VuuUVVu;
   private float partJ;
   private float VuNVnvNNuNnn;
   private float uvVuuuvvVU;
   private int NNnvvunuVNUn;
   private int nVuuUnnUUVU;
   private float nUununvNvvn = -1.0F;
   private float NuvunVvnnN;
   private float vuvnnvuNVvu;
   private float NVvnvnn = 12.0F;
   private float partG;
   private float NUuVnnuUnvu;
   private float vnuNNVvVVuN;
   private float Oco0Oococc;
   private float itemF;
   private float spanA;
   private boolean UvuVvvVuUuuu;
   private boolean NUUVUvvuNNVU;
   private boolean VUNvNUuNVnn;
   private boolean UNNunNuUNVuU;
   private int itemE = -1;
   private int VUVvNvvVUN = -1;

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public boolean primaryVal(VvVVnnNNNuV.LicenseValidator var1) {
      if (this.VUNvNUuNVnn) {
         return false;
      }

      if (var1 != null && var1.widthVal() > 0 && var1.chunkVal() > 0) {
         long var2 = primaryVal(class_310.method_1551(), var1.widthVal(), var1.chunkVal());
         if (var2 >= 0L && primaryVal(var2) == var1.widthVal() && secondaryVal(var2) == var1.chunkVal()) {
            GLStateSnapshot.secondaryVal(this.modeRef);
            boolean var4 = false;
            boolean var12 = false /* VF: Semaphore variable */;

            int var15;
            label142: {
               boolean var17;
               label141: {
                  label140: {
                     boolean var9;
                     label139: {
                        try {
                           var12 = true;
                           this.tertiaryVal();
                           this.primaryVal();
                           if (this.VUNvNUuNVnn) {
                              var15 = 0;
                              var12 = false;
                              break label142;
                           }

                           var15 = var1.widthVal();
                           int var6 = var1.chunkVal();
                           GL11.glDisable(3089);
                           GL11.glDisable(36281);
                           GL11.glColorMask(true, true, true, true);
                           this.heightRef.secondaryVal(var15, var6);
                           if (!this.heightRef.paramVal()) {
                              var17 = false;
                              var12 = false;
                              break label141;
                           }

                           this.tertiaryVal(var1);
                           this.marginVal(var1);
                           if (this.UNNunNuUNVuU) {
                              var17 = false;
                              var12 = false;
                              break label140;
                           }

                           this.UvuVvvVuUuuu = this.secondaryVal(var15, var6);
                           GL11.glDisable(2929);
                           GL11.glDisable(2884);
                           if (this.UvuVvvVuUuuu) {
                              this.primaryVal(this.levelVal, this.vuNnuUnu, this.uuvvuNvuUNVV);
                              this.primaryVal(var1, this.vuNnuUnu, this.uuvvuNvuUNVV);
                              this.primaryVal(var1, this.vuNnuUnu, this.uuvvuNvuUNVV, var1.modeRef());
                              this.secondaryVal();
                           }

                           var17 = this.limitVal(var1) && this.speedVal(var1);
                           if (var17 && this.twigB) {
                              this.primaryVal(this.twigH, this.guardVal, 1.0F, 1.0F, this.VUuuVUnun, this.NnunUUnU, this.nvuVvuNnNUnv);
                           }

                           GL30.glBindFramebuffer(36160, var1.blockRef());
                           int var8 = GL30.glCheckFramebufferStatus(36009);
                           if (var8 != 36053) {
                              ScreenRenderDiagnostics.primaryVal("MainMenuRenderer", null, "draw framebuffer incomplete status=0x" + Integer.toHexString(var8), null);
                              var9 = false;
                              var12 = false;
                              break label139;
                           }

                           GL11.glViewport(0, 0, var15, var6);
                           if (this.UvuVvvVuUuuu) {
                              this.weightRef(var1);
                           } else {
                              this.primaryVal(var1, var15, var6);
                              this.primaryVal(var1, var15, var6, 1.0F);
                           }

                           if (var17) {
                              this.widthVal(var1);
                           }

                           this.paramVal(var1);
                           this.timerVal(var1);
                           this.anchorVal(var1);
                           this.extraVal(var1);
                           this.chunkVal(var1);
                           this.blockRef(var1);
                           var4 = true;
                           var12 = false;
                        } finally {
                           if (var12) {
                              this.tertiaryVal(2, 0);
                              this.tertiaryVal(1, 0);
                              this.primaryVal(0);
                              GL20.glUseProgram(0);
                              GLStateSnapshot.tertiaryVal(this.modeRef);
                           }
                        }

                        this.tertiaryVal(2, 0);
                        this.tertiaryVal(1, 0);
                        this.primaryVal(0);
                        GL20.glUseProgram(0);
                        GLStateSnapshot.tertiaryVal(this.modeRef);
                        return var4;
                     }

                     this.tertiaryVal(2, 0);
                     this.tertiaryVal(1, 0);
                     this.primaryVal(0);
                     GL20.glUseProgram(0);
                     GLStateSnapshot.tertiaryVal(this.modeRef);
                     return var9;
                  }

                  this.tertiaryVal(2, 0);
                  this.tertiaryVal(1, 0);
                  this.primaryVal(0);
                  GL20.glUseProgram(0);
                  GLStateSnapshot.tertiaryVal(this.modeRef);
                  return var17;
               }

               this.tertiaryVal(2, 0);
               this.tertiaryVal(1, 0);
               this.primaryVal(0);
               GL20.glUseProgram(0);
               GLStateSnapshot.tertiaryVal(this.modeRef);
               return var17;
            }

            this.tertiaryVal(2, 0);
            this.tertiaryVal(1, 0);
            this.primaryVal(0);
            GL20.glUseProgram(0);
            GLStateSnapshot.tertiaryVal(this.modeRef);
            return var15 != 0;
         } else {
            ScreenRenderDiagnostics.primaryVal("MainMenuRenderer", null, "frame metrics mismatch requested=" + var1.widthVal() + "x" + var1.chunkVal(), null);
            return false;
         }
      } else {
         ScreenRenderDiagnostics.primaryVal("MainMenuRenderer", null, "invalid state dimensions", null);
         return false;
      }
   }

   private void tertiaryVal(VvVVnnNNNuV.LicenseValidator var1) {
      int var2 = var1.widthVal();
      int var3 = var1.chunkVal();
      float var4 = Math.max(0.35F, Math.min(1.0F, var1.modeRef()));
      this.vuNnuUnu = Math.max(2, Math.min(var2, Math.round(var2 * var4)));
      this.uuvvuNvuUNVV = Math.max(2, Math.min(var3, Math.round(var3 * var4)));
      int var5 = Math.max(2, var2 / 2);
      int var6 = Math.max(2, var3 / 2);
      int var7 = Math.max(2, var2 / 4);
      int var8 = Math.max(2, var3 / 4);
      this.vUNuuvvnVnv = Math.max(2, Math.min(var5, Math.round(this.vuNnuUnu * 0.5F)));
      this.unnnNUNnVu = Math.max(2, Math.min(var6, Math.round(this.uuvvuNvuUNVV * 0.5F)));
      this.twigF = Math.max(2, Math.min(var7, Math.round(this.vuNnuUnu * 0.25F)));
      this.itemG = Math.max(2, Math.min(var8, Math.round(this.uuvvuNvuUNVV * 0.25F)));
      this.nvuUVvuuN = (float)this.vuNnuUnu / var2;
      this.itemJ = (float)this.uuvvuNvuUNVV / var3;
      boolean var9 = var1.entryVal() || var1.speedRef() || var1.countRef();
      float var10 = Math.max(0.42F, Math.min(1.0F, var4 * (var9 ? 1.0F : 0.6F)));
      this.uVvunVUNuUvu = Math.max(2, Math.min(var2, Math.round(var2 * var10)));
      this.NVNnnvVnvV = Math.max(2, Math.min(var3, Math.round(var3 * var10)));
      this.spanC = (float)this.uVvunVUNuUvu / var2;
      this.VnnnvUunNvuu = (float)this.NVNnnvVnvV / var3;
      this.VuuUVVu = (float)this.vUNuuvvnVnv / var5;
      this.partJ = (float)this.unnnNUNnVu / var6;
      this.VuNVnvNNuNnn = (float)this.twigF / var7;
      this.uvVuuuvvVU = (float)this.itemG / var8;
   }

   private void primaryVal(VvNNUnNNVn var1, int var2, int var3) {
      var1.primaryVal();
      GL11.glViewport(0, 0, var2, var3);
   }

   private void marginVal(VvVVnnNNNuV.LicenseValidator var1) {
      ShaderProgramCache.CompiledShader var2 = this.bufferVal(var1);
      if (var2 == null) {
         this.UNNunNuUNVuU = true;
      } else {
         this.UNNunNuUNVuU = false;
         this.primaryVal(this.heightRef, this.uVvunVUNuUvu, this.NVNnnvVnvV);
         GL11.glDisable(3042);
         GL11.glDisable(2929);
         GL11.glDisable(2884);
         if (var1.speedRef() || var1.countRef() || var1.entryVal()) {
            GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
            GL11.glClear(16384);
            GL11.glEnable(3042);
            GL14.glBlendFuncSeparate(770, 771, 1, 771);
         }

         var2.primaryVal();
         this.primaryVal(var2, this.uVvunVUNuUvu, this.NVNnnvVnvV, 0.0F, 0.0F, this.uVvunVUNuUvu, this.NVNnnvVnvV);
         var2.primaryVal("uTime", var1.timerVal());
         var2.primaryVal("uResolution", this.uVvunVUNuUvu, this.NVNnnvVnvV);
         var2.primaryVal("uMouse", var1.bufferVal(), var1.countVal());
         var2.primaryVal("uMouseVelocity", var1.depthVal(), var1.descRef());
         var2.primaryVal("uAccentTop", var1.factorVal(), var1.sourceVal(), var1.extraRef());
         var2.primaryVal("uAccentBottom", var1.phaseVal(), var1.limitRef(), var1.paramRef());
         var2.primaryVal("uActivity", var1.trackVal());
         var2.primaryVal("uDetail", var1.angleVal());
         var2.primaryVal("uAlpha", 1.0F);
         var2.primaryVal("uLightMode", var1.guardVal() ? 1.0F : 0.0F);
         this.primaryVal(var2, var1);
         this.NNVNuUvVn.primaryVal();
         GL11.glDisable(3042);
      }
   }

   private void primaryVal(VvVVnnNNNuV.LicenseValidator var1, int var2, int var3) {
      if (this.twigD != null) {
         GL11.glDisable(3042);
         this.twigD.primaryVal();
         this.primaryVal(this.twigD, var2, var3, 0.0F, 0.0F, var2, var3);
         this.twigD.primaryVal("uTexture", 0);
         this.twigD.primaryVal("uTextureSize", this.heightRef.marginVal(), this.heightRef.weightVal());
         this.twigD.primaryVal("uSourceScale", this.spanC, this.VnnnvUunNvuu);
         this.twigD.primaryVal("uParallax", var1.groupVal(), var1.layerVal());
         this.twigD.primaryVal("uTime", var1.timerVal());
         this.twigD.primaryVal("uEntry", var1.levelVal());
         this.twigD.primaryVal("uClickFlash", var1.UuNnnVnuNNV());
         this.twigD.primaryVal("uLightMode", var1.guardVal() ? 1.0F : 0.0F);
         this.twigD.primaryVal("uSakura", var1.speedRef() ? 1.0F : 0.0F);
         this.twigD.primaryVal("uVernal", var1.countRef() ? 1.0F : 0.0F);
         this.twigD.primaryVal("uHour", var1.extraVal());
         this.primaryVal(this.heightRef.tertiaryVal());
         this.NNVNuUvVn.primaryVal();
      }
   }

   private void primaryVal(VvVVnnNNNuV.LicenseValidator var1, int var2, int var3, float var4) {
      float var5 = var1.heightRef();
      if (this.nodeD != null && !(var5 <= 0.002F)) {
         GL11.glEnable(3042);
         if (var1.guardVal()) {
            GL14.glBlendFuncSeparate(770, 771, 1, 771);
         } else {
            GL14.glBlendFuncSeparate(770, 1, 1, 1);
         }

         this.nodeD.primaryVal();
         this.primaryVal(this.nodeD, var2, var3, 0.0F, 0.0F, var2, var3);
         this.nodeD.primaryVal("uTime", var1.timerVal());
         this.nodeD.primaryVal("uResolution", var2, var3);
         this.nodeD.primaryVal("uMouse", var1.bufferVal(), var1.countVal());
         this.nodeD.primaryVal("uParallax", var1.slotVal() * var4, var1.themeVal() * var4);
         this.nodeD.primaryVal("uAccentTop", var1.factorVal(), var1.sourceVal(), var1.extraRef());
         this.nodeD.primaryVal("uAccentBottom", var1.phaseVal(), var1.limitRef(), var1.paramRef());
         this.nodeD.primaryVal("uEntry", var1.levelVal() * var5);
         this.nodeD.primaryVal("uLightMode", var1.guardVal() ? 1.0F : 0.0F);
         this.primaryVal(this.nodeD, var1);
         this.NNVNuUvVn.primaryVal();
         GL14.glBlendFuncSeparate(770, 771, 1, 771);
      }
   }

   private boolean weightVal(VvVVnnNNNuV.LicenseValidator var1) {
      if (this.NvnuuuvnVV != null && this.NnUVNnuvUv != null) {
         float var2 = VvVVnnNNNuV.primaryVal(var1.chunkVal());
         if (this.nUununvNvvn == var2 && this.countRef.paramVal()) {
            return true;
         }

         VuuUvnvnuu var3 = Renderer2D.primaryVal(FontRegistry.marginVal);
         VuuUvnvnuu var4 = Renderer2D.primaryVal(FontRegistry.primaryVal);
         VuuUvnvnuu var5 = Renderer2D.primaryVal(FontRegistry.limitVal);
         if (var3 != null && var4 != null) {
            float var6 = Math.min(30.0F, Math.max(12.0F, var2 * 0.22F));
            float var7 = var6 + 4.0F;
            int var8 = Math.round(var6 + var2 * 0.62F) + 12;
            float var9 = VvVVnnNNNuV.primaryVal(var2) * 0.5F;
            float var10 = VvVVnnNNNuV.tertiaryVal(var2) * 0.5F;
            float var11 = VvVVnnNNNuV.primaryVal(var2) * 0.83F * 0.5F;
            float var12 = VvVVnnNNNuV.secondaryVal(var2);
            float var13 = VvVVnnNNNuV.primaryVal(var3, var9);
            float var14 = var4.primaryVal("Source obtained by Uelm & Claude", var10);
            float var15 = var5 == null ? 0.0F : var5.primaryVal("w", var11);
            float var16 = var15 > 0.0F ? var2 * 0.3F : 0.0F;
            float var17 = var15 + var16 + var13;
            float var18 = var2 * 1.1F;
            float var19 = var2 * 0.98F;
            float var20 = var19 + var10 * 0.9F;
            int var21 = (int)Math.ceil(Math.max(var17, var14));
            int var22 = var21 + var8 * 2;
            int var23 = (int)Math.ceil(var18 + var20) + var8 * 2;
            if (var22 > 2 && var23 > 2) {
               float var24 = var8 + var21 * 0.5F;
               float var25 = var8 + var18;
               float var26 = var24 - var17 * 0.5F;
               float var27 = var26 + var15 + var16;
               float var28 = var24 - var14 * 0.5F;
               this.countRef.primaryVal(var22, var23);
               if (!this.countRef.paramVal()) {
                  return false;
               }

               this.countRef.primaryVal();
               GL11.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
               GL11.glClear(16384);
               GL11.glEnable(3042);
               GL14.glBlendFuncSeparate(1, 1, 1, 1);
               GL20.glBlendEquation(32776);
               this.NvnuuuvnVV.primaryVal();
               this.NvnuuuvnVV.primaryVal("uAtlas", 0);
               this.NvnuuuvnVV.primaryVal("uMaskRange", var6);
               GL11.glColorMask(true, false, false, false);
               if (var5 != null) {
                  float var29 = (var5.secondaryVal("w", var11) + var5.tertiaryVal("w", var11)) * 0.5F;
                  float var30 = var25 - var12 * 0.5F + var29 + var2 * 0.0188F;
                  this.primaryVal(var5, "w", var11, var26, var30, var22, var23, var7);
               }

               this.primaryVal(var3, "WILD", var9, 0.08F * var9, var27, var25, var22, var23, var7);
               GL11.glColorMask(false, true, false, false);
               this.primaryVal(var4, "Source obtained by Uelm & Claude", var10, var28, var25 + var19, var22, var23, var7);
               GL11.glColorMask(true, true, true, true);
               GL20.glBlendEquation(32774);
               GL11.glDisable(3042);
               this.NNnvvunuVNUn = var22;
               this.nVuuUnnUUVU = var23;
               this.vnuNNVvVVuN = var28;
               this.Oco0Oococc = var25 + var19 - var10 * 0.78F;
               this.itemF = var14;
               this.spanA = var10 * 1.02F;
               if (!this.primaryVal(var22, var23, var6, var2)) {
                  return false;
               }

               this.nUununvNvvn = var2;
               this.NuvunVvnnN = var12;
               this.NVvnvnn = var6;
               this.vuvnnvuNVvu = var25;
               this.partG = -var24;
               this.NUuVnnuUnvu = -var25;
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private void primaryVal(VuuUvnvnuu var1, String var2, float var3, float var4, float var5, float var6, int var7, int var8, float var9) {
      for (int var10 = 0; var10 < var2.length(); var10++) {
         String var11 = var2.substring(var10, var10 + 1);
         float var12 = var1.primaryVal(var2.substring(0, var10), var3) + var4 * var10;
         this.primaryVal(var1, var11, var3, var5 + var12, var6, var7, var8, var9);
      }
   }

   private boolean primaryVal(int var1, int var2, float var3, float var4) {
      if (this.UuuuNNunN == null) {
         return false;
      }

      this.entryVal.primaryVal(var1, var2);
      if (!this.entryVal.paramVal()) {
         return false;
      }

      this.entryVal.primaryVal();
      GL11.glViewport(0, 0, var1, var2);
      GL11.glDisable(3042);
      GL11.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GL11.glClear(16384);
      this.UuuuNNunN.primaryVal();
      this.primaryVal(this.UuuuNNunN, var1, var2, 0.0F, 0.0F, var1, var2);
      this.UuuuNNunN.primaryVal("uMask", 0);
      this.UuuuNNunN.primaryVal("uMaskSize", var1, var2);
      this.UuuuNNunN.primaryVal("uMaskRange", var3);
      this.UuuuNNunN.primaryVal("uTightRadius", Math.max(3.0F, var4 * 0.17F));
      this.UuuuNNunN.primaryVal("uWideRadius", Math.max(8.0F, var4 * 0.62F));
      this.primaryVal(this.countRef.tertiaryVal());
      this.NNVNuUvVn.primaryVal();
      return true;
   }

   private void primaryVal(VuuUvnvnuu var1, String var2, float var3, float var4, float var5, int var6, int var7, float var8) {
      int var9 = var1.primaryVal();

      for (VuuUvnvnuu.WildClient var11 : var1.primaryVal(var2, var3, var4, var5)) {
         float var12 = var11.tertiaryVal - var11.primaryVal + var8 * 2.0F;
         float var13 = var11.marginVal - var11.secondaryVal + var8 * 2.0F;
         this.primaryVal(this.NvnuuuvnVV, var6, var7, var11.primaryVal - var8, var11.secondaryVal - var8, var12, var13);
         this.NvnuuuvnVV.primaryVal("uGlyphUv", var11.weightVal, var11.paramVal, var11.extraVal, var11.limitVal);
         this.NvnuuuvnVV.primaryVal("uQuadSize", var12, var13);
         this.NvnuuuvnVV.primaryVal("uPadPx", var8);
         this.NvnuuuvnVV.primaryVal("uRangePx", var11.speedVal);
         this.primaryVal(var9);
         this.NNVNuUvVn.primaryVal();
      }
   }

   private void paramVal(VvVVnnNNNuV.LicenseValidator var1) {
      VvVVnnNNNuV.FingerprintCrypto var2 = var1.limitVal();
      if (!(var2.tertiaryVal() <= 0.0F) && !(var2.marginVal() <= 0.0F)) {
         if (this.weightVal(var1) && this.countRef.paramVal() && this.entryVal.paramVal()) {
            float var3 = this.nUununvNvvn;
            float var4 = var2.primaryVal() + var2.tertiaryVal() * 0.5F;
            float var5 = var2.secondaryVal() + var2.marginVal() * 0.5F;
            float var6 = var5 + this.NuvunVvnnN * 0.5F;
            float var7 = var4 + this.partG;
            float var8 = var6 + this.NUuVnnuUnvu;
            float var9 = 1.0F + 0.005F * (0.5F - 0.5F * (float)Math.cos(var1.holderVal() * (float) (Math.PI * 2.0 / 3.0)));
            float var10 = var4 + var1.stageVal() * -0.62F;
            float var11 = var5 + var1.widthRef() * -0.62F;
            float var12 = var10 + (var7 - var4) * var9;
            float var13 = var11 + (var8 - var5) * var9;
            float var14 = this.NNnvvunuVNUn * var9;
            float var15 = this.nVuuUnnUUVU * var9;
            GL30.glBindFramebuffer(36160, var1.blockRef());
            GL11.glViewport(0, 0, var1.widthVal(), var1.chunkVal());
            GL11.glEnable(3042);
            GL14.glBlendFuncSeparate(770, 771, 1, 771);
            VvNNUnNNVn var16 = this.UvuVvvVuUuuu && this.speedRef.paramVal() ? this.speedRef : this.heightRef;
            VvNNUnNNVn var17 = this.UvuVvvVuUuuu && this.levelVal.paramVal() ? this.levelVal : this.heightRef;
            this.NnUVNnuvUv.primaryVal();
            this.primaryVal(this.NnUVNnuvUv, var1.widthVal(), var1.chunkVal(), var12, var13, var14, var15);
            this.NnUVNnuvUv.primaryVal("uMask", 0);
            this.NnUVNnuvUv.primaryVal("uBlur", 1);
            this.NnUVNnuvUv.primaryVal("uSharp", 2);
            this.NnUVNnuvUv.primaryVal("uShadow", 3);
            this.NnUVNnuvUv.primaryVal("uMaskSize", this.NNnvvunuVNUn, this.nVuuUnnUUVU);
            this.NnUVNnuvUv.primaryVal("uBlurSize", var16.marginVal(), var16.weightVal());
            this.NnUVNnuvUv.primaryVal("uSharpSize", var17.marginVal(), var17.weightVal());
            this.NnUVNnuvUv
               .primaryVal(
                  "uSourceScale", var16 == this.speedRef ? this.VuuUVVu : this.spanC, var16 == this.speedRef ? this.partJ : this.VnnnvUunNvuu
               );
            this.NnUVNnuvUv
               .primaryVal(
                  "uSharpScale", var17 == this.levelVal ? this.nvuUVvuuN : this.spanC, var17 == this.levelVal ? this.itemJ : this.VnnnvUunNvuu
               );
            this.NnUVNnuvUv.primaryVal("uMaskRange", this.NVvnvnn);
            this.NnUVNnuvUv.primaryVal("uPointer", (var1.anchorVal() - var12) / var9, (var1.weightRef() - var13) / var9);
            this.NnUVNnuvUv.primaryVal("uLockupMetrics", var3, this.vuvnnvuNVvu);
            this.NnUVNnuvUv.primaryVal("uAccentTop", var1.factorVal(), var1.sourceVal(), var1.extraRef());
            this.NnUVNnuvUv.primaryVal("uAccentBottom", var1.phaseVal(), var1.limitRef(), var1.paramRef());
            this.NnUVNnuvUv.primaryVal("uTime", var1.holderVal());
            this.NnUVNnuvUv.primaryVal("uEntry", var1.levelVal());
            this.NnUVNnuvUv.primaryVal("uPointerActive", var1.radiusVal());
            this.NnUVNnuvUv.primaryVal("uSignature", var1.depthRef());
            this.NnUVNnuvUv.primaryVal("uSignatureLead", var1.paramVal());
            this.NnUVNnuvUv.primaryVal("uInkRect", this.vnuNNVvVVuN, this.Oco0Oococc, this.itemF, this.spanA);
            this.NnUVNnuvUv.primaryVal("uLightMode", var1.guardVal() ? 1.0F : 0.0F);
            this.tertiaryVal(3, this.entryVal.tertiaryVal());
            this.tertiaryVal(1, var16.tertiaryVal());
            this.tertiaryVal(2, var17.tertiaryVal());
            this.primaryVal(this.countRef.tertiaryVal());
            this.NNVNuUvVn.primaryVal();
            this.tertiaryVal(3, 0);
            this.tertiaryVal(2, 0);
         }
      }
   }

   private void extraVal(VvVVnnNNNuV.LicenseValidator var1) {
      if (this.NnuUnUNnu != null) {
         boolean var2 = this.UvuVvvVuUuuu && this.levelVal.paramVal();
         VvNNUnNNVn var3 = this.UvuVvvVuUuuu && this.speedRef.paramVal() ? this.speedRef : this.heightRef;
         VvNNUnNNVn var4 = var2 ? this.levelVal : this.heightRef;
         GL11.glEnable(3042);
         GL14.glBlendFuncSeparate(770, 771, 1, 771);
         this.NnuUnUNnu.primaryVal();
         this.NnuUnUNnu.primaryVal("uBackground", 0);
         this.NnuUnUNnu.primaryVal("uSharp", 1);
         this.NnuUnUNnu.primaryVal("uBackdrop", var2 ? 1.0F : 0.0F);
         this.NnuUnUNnu.primaryVal("uTextureSize", var3.marginVal(), var3.weightVal());
         this.NnuUnUNnu.primaryVal("uSharpSize", var4.marginVal(), var4.weightVal());
         this.NnuUnUNnu
            .primaryVal("uSourceScale", var3 == this.speedRef ? this.VuuUVVu : this.spanC, var3 == this.speedRef ? this.partJ : this.VnnnvUunNvuu);
         this.NnuUnUNnu
            .primaryVal("uSharpScale", var4 == this.levelVal ? this.nvuUVvuuN : this.spanC, var4 == this.levelVal ? this.itemJ : this.VnnnvUunNvuu);
         this.NnuUnUNnu.primaryVal("uTime", var1.holderVal());
         this.NnuUnUNnu.primaryVal("uAccentTop", var1.factorVal(), var1.sourceVal(), var1.extraRef());
         this.NnuUnUNnu.primaryVal("uAccentBottom", var1.phaseVal(), var1.limitRef(), var1.paramRef());
         this.NnuUnUNnu.primaryVal("uLightMode", var1.guardVal() ? 1.0F : 0.0F);
         this.tertiaryVal(1, var4.tertiaryVal());
         this.primaryVal(var3.tertiaryVal());

         for (int var5 = 0; var5 < var1.primaryVal(); var5++) {
            VvVVnnNNNuV.cursorVal var6 = var1.primaryVal(var5);
            float var7 = var6.bufferVal();
            float var8 = var6.extraVal() - var7;
            float var9 = var6.limitVal() - var7;
            float var10 = var6.speedVal() + var7 * 2.0F;
            float var11 = var6.widthVal() + var7 * 2.0F;
            this.primaryVal(this.NnuUnUNnu, var1.widthVal(), var1.chunkVal(), var8, var9, var10, var11);
            this.NnuUnUNnu.primaryVal("uButton", var7, var7, var6.speedVal(), var6.widthVal());
            float var12 = Math.max(var6.countVal(), 0.001F);
            this.NnuUnUNnu.primaryVal("uLocalMouse", var6.depthVal(), var6.descRef());
            this.NnuUnUNnu.primaryVal("uPointerLocal", var6.marginVal() * var6.speedVal() / var12, var6.weightVal() * var6.widthVal() / var12);
            this.NnuUnUNnu.primaryVal("uPointerValid", var6.tertiaryVal() ? 1.0F : 0.0F);
            this.NnuUnUNnu.primaryVal("uRadius", var6.chunkVal());
            this.NnuUnUNnu.primaryVal("uHover", var6.blockRef());
            this.NnuUnUNnu.primaryVal("uMagnet", var6.holderVal());
            this.NnuUnUNnu.primaryVal("uPress", var6.timerVal());
            this.NnuUnUNnu.primaryVal("uEntry", var6.anchorVal());
            this.NnuUnUNnu.primaryVal("uFlash", var6.weightRef());
            this.NnuUnUNnu.primaryVal("uWave", var6.secondaryVal());
            this.NnuUnUNnu.primaryVal("uScale", var6.countVal());
            this.NnuUnUNnu.primaryVal("uSeed", var5 * 0.7139F);
            this.NNVNuUvVn.primaryVal();
         }
      }
   }

   private boolean limitVal(VvVVnnNNNuV.LicenseValidator var1) {
      if (this.NUVvUUVuVNVv != null && this.nodeB != null && this.NNVNuUvVn != null) {
         int var2 = var1.widthVal();
         int var3 = var1.chunkVal();
         this.guardVal.secondaryVal(Math.max(2, var2 / 2), Math.max(2, var3 / 2));
         if (!this.guardVal.paramVal()) {
            this.twigB = false;
            return false;
         }

         this.UnvuVuVnNuvu = this.guardVal.marginVal();
         this.UvNNVUVNVuvV = this.guardVal.weightVal();
         if (this.twigH != null && var1.modeRef() >= 0.6F) {
            this.VUuuVUnun.secondaryVal(Math.max(2, var2 / 4), Math.max(2, var3 / 4));
            this.NnunUUnU = this.VUuuVUnun.marginVal();
            this.nvuVvuNnNUnv = this.VUuuVUnun.weightVal();
            this.twigB = this.VUuuVUnun.paramVal();
         } else {
            this.twigB = false;
         }

         return true;
      } else {
         this.twigB = false;
         return false;
      }
   }

   private boolean speedVal(VvVVnnNNNuV.LicenseValidator var1) {
      int var2 = var1.primaryVal();
      if (var2 <= 0) {
         return false;
      }

      if (this.UNvvunVVn.length < var2) {
         this.UNvvunVVn = new float[Math.max(var2, this.UNvvunVVn.length * 2)];
      }

      int var3 = 0;
      float var4 = Float.MAX_VALUE;
      float var5 = Float.MAX_VALUE;
      float var6 = -Float.MAX_VALUE;
      float var7 = -Float.MAX_VALUE;

      for (int var8 = 0; var8 < var2; var8++) {
         VvVVnnNNNuV.cursorVal var9 = var1.primaryVal(var8);
         float var10 = Math.max(secondaryVal(var9.blockRef(), 0.0F, 1.0F), secondaryVal(var9.holderVal(), 0.0F, 1.0F) * 0.85F);
         float var11 = secondaryVal(var9.anchorVal(), 0.0F, 1.0F);
         float var12 = primaryVal(0.3F, 1.0F, var10) * var11;
         var12 = Math.max(var12, secondaryVal(var9.primaryVal(), 0.0F, 1.0F) * 0.52F * var11);
         var12 = Math.max(var12, secondaryVal(var9.weightRef(), 0.0F, 1.0F));
         if (var12 <= 0.004F) {
            this.UNvvunVVn[var8] = 0.0F;
         } else {
            this.UNvvunVVn[var8] = var12;
            var3++;
            float var13 = var9.bufferVal();
            var4 = Math.min(var4, var9.extraVal() - var13);
            var5 = Math.min(var5, var9.limitVal() - var13);
            var6 = Math.max(var6, var9.extraVal() + var9.speedVal() + var13);
            var7 = Math.max(var7, var9.limitVal() + var9.widthVal() + var13);
         }
      }

      if (var3 == 0) {
         return false;
      }

      float var16 = var1.widthVal();
      float var17 = var1.chunkVal();
      this.nodeF = Math.max(0.0F, var4 - 24.0F);
      this.nodeH = Math.max(0.0F, var5 - 24.0F);
      this.OCOocoOoOO = Math.min(var16, var6 + 24.0F) - this.nodeF;
      this.o0Ooc0COOoc = Math.min(var17, var7 + 24.0F) - this.nodeH;
      if (!(this.OCOocoOoOO <= 1.0F) && !(this.o0Ooc0COOoc <= 1.0F)) {
         float var18 = this.UnvuVuVnNuvu / Math.max(1.0F, var16);
         float var19 = this.UvNNVUVNVuvV / Math.max(1.0F, var17);
         this.primaryVal(this.guardVal, this.UnvuVuVnNuvu, this.UvNNVUVNVuvV);
         GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
         GL11.glClear(16384);
         GL11.glEnable(3042);
         GL20.glBlendEquationSeparate(32774, 32776);
         GL14.glBlendFuncSeparate(1, 1, 1, 1);
         this.NUVvUUVuVNVv.primaryVal();
         this.NUVvUUVuVNVv.primaryVal("uTime", var1.holderVal());
         this.NUVvUUVuVNVv.primaryVal("uAccentTop", var1.factorVal(), var1.sourceVal(), var1.extraRef());
         this.NUVvUUVuVNVv.primaryVal("uAccentBottom", var1.phaseVal(), var1.limitRef(), var1.paramRef());
         this.NUVvUUVuVNVv.primaryVal("uLightMode", var1.guardVal() ? 1.0F : 0.0F);

         for (int var22 = 0; var22 < var2; var22++) {
            float var23 = this.UNvvunVVn[var22];
            if (!(var23 <= 0.0F)) {
               VvVVnnNNNuV.cursorVal var14 = var1.primaryVal(var22);
               float var15 = var14.bufferVal();
               this.primaryVal(
                  this.NUVvUUVuVNVv,
                  this.UnvuVuVnNuvu,
                  this.UvNNVUVNVuvV,
                  (var14.extraVal() - var15) * var18,
                  (var14.limitVal() - var15) * var19,
                  (var14.speedVal() + var15 * 2.0F) * var18,
                  (var14.widthVal() + var15 * 2.0F) * var19
               );
               this.NUVvUUVuVNVv.primaryVal("uButton", var15 * var18, var15 * var19, var14.speedVal() * var18, var14.widthVal() * var19);
               this.NUVvUUVuVNVv.primaryVal("uRadius", var14.chunkVal() * var18);
               this.NUVvUUVuVNVv.primaryVal("uScale", var14.countVal());
               this.NUVvUUVuVNVv.primaryVal("uDrive", var23);
               this.NUVvUUVuVNVv.primaryVal("uPress", var14.timerVal());
               this.NUVvUUVuVNVv.primaryVal("uFlash", var14.weightRef());
               this.NUVvUUVuVNVv
                  .primaryVal(
                     "uPointerLocal",
                     var14.marginVal() * var14.speedVal() * var18 / Math.max(var14.countVal(), 0.001F),
                     var14.weightVal() * var14.widthVal() * var19 / Math.max(var14.countVal(), 0.001F)
                  );
               this.NUVvUUVuVNVv.primaryVal("uPointerValid", var14.tertiaryVal() ? 1.0F : 0.0F);
               this.NUVvUUVuVNVv.primaryVal("uLocalMouse", var14.depthVal(), var14.descRef());
               this.NUVvUUVuVNVv.primaryVal("uSteady", secondaryVal(var14.primaryVal(), 0.0F, 1.0F) * (1.0F - secondaryVal(var14.blockRef(), 0.0F, 1.0F)));
               this.NUVvUUVuVNVv.primaryVal("uSeed", var22 * 0.7139F);
               this.NNVNuUvVn.primaryVal();
            }
         }

         GL20.glBlendEquationSeparate(32774, 32774);
         GL11.glDisable(3042);
         return true;
      } else {
         return false;
      }
   }

   private void widthVal(VvVVnnNNNuV.LicenseValidator var1) {
      GL11.glEnable(3042);
      GL14.glBlendFuncSeparate(1, 771, 0, 1);
      VvNNUnNNVn var2 = this.twigB ? this.VUuuVUnun : this.guardVal;
      this.nodeB.primaryVal();
      this.primaryVal(this.nodeB, var1.widthVal(), var1.chunkVal(), this.nodeF, this.nodeH, this.OCOocoOoOO, this.o0Ooc0COOoc);
      this.nodeB.primaryVal("uGlow", 0);
      this.nodeB.primaryVal("uBloom", 1);
      this.nodeB.primaryVal("uGlowTexel", 1.0F / Math.max(1, this.guardVal.marginVal()), 1.0F / Math.max(1, this.guardVal.weightVal()));
      this.nodeB.primaryVal("uBloomTexel", 1.0F / Math.max(1, var2.marginVal()), 1.0F / Math.max(1, var2.weightVal()));
      this.nodeB.primaryVal("uSourceScale", 1.0F, 1.0F);
      this.nodeB.primaryVal("uBloomAmount", this.twigB ? 1.0F : 0.0F);
      this.nodeB.primaryVal("uLightMode", var1.guardVal() ? 1.0F : 0.0F);
      this.tertiaryVal(1, var2.tertiaryVal());
      this.primaryVal(this.guardVal.tertiaryVal());
      this.NNVNuUvVn.primaryVal();
      GL14.glBlendFuncSeparate(770, 771, 1, 771);
   }

   private static float primaryVal(float var0, float var1, float var2) {
      float var3 = secondaryVal((var2 - var0) / Math.max(var1 - var0, 1.0E-5F), 0.0F, 1.0F);
      return var3 * var3 * (3.0F - 2.0F * var3);
   }

   private void chunkVal(VvVVnnNNNuV.LicenseValidator var1) {
      if (this.UnnnvvU != null) {
         VvVVnnNNNuV.VvunVVUvUNnv var2 = var1.speedVal();
         if (!(var2.marginVal() <= 1.0F) && !(var2.weightVal() <= 1.0F) && !(var2.speedVal() <= 0.001F)) {
            VvNNUnNNVn var3 = this.UvuVvvVuUuuu && this.speedRef.paramVal() ? this.speedRef : this.heightRef;
            GL11.glEnable(3042);
            GL14.glBlendFuncSeparate(770, 771, 1, 771);
            this.UnnnvvU.primaryVal();
            this.UnnnvvU.primaryVal("uBackground", 0);
            this.UnnnvvU.primaryVal("uTextureSize", var3.marginVal(), var3.weightVal());
            this.UnnnvvU
               .primaryVal(
                  "uSourceScale", var3 == this.speedRef ? this.VuuUVVu : this.spanC, var3 == this.speedRef ? this.partJ : this.VnnnvUunNvuu
               );
            this.UnnnvvU.primaryVal("uTime", var1.holderVal());
            this.UnnnvvU.primaryVal("uAccentTop", var1.factorVal(), var1.sourceVal(), var1.extraRef());
            this.UnnnvvU.primaryVal("uAccentBottom", var1.phaseVal(), var1.limitRef(), var1.paramRef());
            this.UnnnvvU.primaryVal("uLightMode", var1.guardVal() ? 1.0F : 0.0F);
            this.primaryVal(var3.tertiaryVal());
            this.UnnnvvU.primaryVal("uLocalMouse", var2.widthVal(), var2.chunkVal());
            float var4 = var2.countVal() > 0.0F ? var2.countVal() : 40.0F;
            this.primaryVal(
               var1,
               var2.secondaryVal(),
               var2.tertiaryVal(),
               var2.marginVal(),
               var2.weightVal(),
               var2.paramVal(),
               var4,
               var2.extraVal(),
               var2.speedVal(),
               var2.limitVal(),
               var2.blockRef(),
               var2.holderVal(),
               var2.timerVal(),
               var2.anchorVal(),
               var2.weightRef(),
               var2.bufferVal()
            );
         }
      }
   }

   private void blockRef(VvVVnnNNNuV.LicenseValidator var1) {
      if (this.VUUnuVvVu != null && var1.secondaryVal() > 0) {
         VvNNUnNNVn var2 = this.UvuVvvVuUuuu && this.speedRef.paramVal() ? this.speedRef : this.heightRef;
         boolean var3 = var2 == this.speedRef;
         this.primaryVal(var1, var2, var3 ? this.VuuUVVu : this.spanC, var3 ? this.partJ : this.VnnnvUunNvuu, false);
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public boolean secondaryVal(VvVVnnNNNuV.LicenseValidator var1) {
      if (this.VUNvNUuNVnn || !this.NUUVUvvuNNVU || this.VUUnuVvVu == null || this.NNVNuUvVn == null) {
         return false;
      }

      if (var1 != null && var1.tertiaryVal() > 0) {
         int var2 = var1.widthVal();
         int var3 = var1.chunkVal();
         if (var2 > 0 && var3 > 0) {
            GLStateSnapshot.secondaryVal(this.angleVal);
            boolean var12 = false /* VF: Semaphore variable */;

            boolean var16;
            label117: {
               boolean var17;
               label116: {
                  try {
                     var12 = true;
                     this.tertiaryVal();
                     GL11.glDisable(3089);
                     GL11.glDisable(36281);
                     GL11.glDisable(2929);
                     GL11.glDisable(2884);
                     GL11.glColorMask(true, true, true, true);
                     boolean var4 = this.secondaryVal(var1, var2, var3);
                     GL30.glBindFramebuffer(36160, var1.blockRef());
                     if (GL30.glCheckFramebufferStatus(36009) != 36053) {
                        var16 = false;
                        var12 = false;
                        break label117;
                     }

                     GL11.glViewport(0, 0, var2, var3);
                     float var6;
                     float var7;
                     VvNNUnNNVn var15;
                     if (var4) {
                        var15 = this.tokenVal;
                        var6 = 1.0F;
                        var7 = 1.0F;
                     } else {
                        var15 = this.UvuVvvVuUuuu && this.speedRef.paramVal() ? this.speedRef : this.heightRef;
                        var17 = var15 == this.speedRef;
                        var6 = var17 ? this.VuuUVVu : this.spanC;
                        var7 = var17 ? this.partJ : this.VnnnvUunNvuu;
                     }

                     this.primaryVal(var1, var15, var6, var7, true);
                     var17 = true;
                     var12 = false;
                     break label116;
                  } catch (Throwable var13) {
                     ScreenRenderDiagnostics.primaryVal("MainMenuRenderer", null, "overlay pass failed", var13);
                     var16 = false;
                     var12 = false;
                  } finally {
                     if (var12) {
                        this.tertiaryVal(2, 0);
                        this.tertiaryVal(1, 0);
                        this.primaryVal(0);
                        GL20.glUseProgram(0);
                        GLStateSnapshot.tertiaryVal(this.angleVal);
                     }
                  }

                  this.tertiaryVal(2, 0);
                  this.tertiaryVal(1, 0);
                  this.primaryVal(0);
                  GL20.glUseProgram(0);
                  GLStateSnapshot.tertiaryVal(this.angleVal);
                  return var16;
               }

               this.tertiaryVal(2, 0);
               this.tertiaryVal(1, 0);
               this.primaryVal(0);
               GL20.glUseProgram(0);
               GLStateSnapshot.tertiaryVal(this.angleVal);
               return var17;
            }

            this.tertiaryVal(2, 0);
            this.tertiaryVal(1, 0);
            this.primaryVal(0);
            GL20.glUseProgram(0);
            GLStateSnapshot.tertiaryVal(this.angleVal);
            return var16;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private boolean secondaryVal(VvVVnnNNNuV.LicenseValidator var1, int var2, int var3) {
      if (this.twigH != null && this.vuvvuVuVv != null) {
         int var4 = Math.max(2, var2 / 2);
         int var5 = Math.max(2, var3 / 2);
         int var6 = Math.max(2, var2 / 4);
         int var7 = Math.max(2, var3 / 4);
         int var8 = Math.max(2, var2 / 8);
         int var9 = Math.max(2, var3 / 8);
         int var10 = Math.max(2, var2 / 16);
         int var11 = Math.max(2, var3 / 16);
         this.vVVuuVVv.primaryVal(var4, var5);
         this.VuunNUUUvu.primaryVal(var6, var7);
         this.NNUUNUuVNNVn.primaryVal(var8, var9);
         this.VvVvnNUnvuvV.primaryVal(var10, var11);
         this.tokenVal.primaryVal(var4, var5);
         if (this.vVVuuVVv.paramVal()
            && this.VuunNUUUvu.paramVal()
            && this.NNUUNUuVNNVn.paramVal()
            && this.VvVvnNUnvuvV.paramVal()
            && this.tokenVal.paramVal()) {
            GL30.glBindFramebuffer(36008, var1.blockRef());
            GL30.glBindFramebuffer(36009, this.vVVuuVVv.secondaryVal());
            if (GL30.glCheckFramebufferStatus(36008) == 36053 && GL30.glCheckFramebufferStatus(36009) == 36053) {
               GL30.glBlitFramebuffer(0, 0, var2, var3, 0, 0, var4, var5, 16384, 9729);
               this.primaryVal(this.twigH, this.vVVuuVVv, 1.0F, 1.0F, this.VuunNUUUvu, var6, var7);
               this.primaryVal(this.twigH, this.VuunNUUUvu, 1.0F, 1.0F, this.NNUUNUuVNNVn, var8, var9);
               this.primaryVal(this.twigH, this.NNUUNUuVNNVn, 1.0F, 1.0F, this.VvVvnNUnvuvV, var10, var11);
               this.primaryVal(this.vuvvuVuVv, this.VvVvnNUnvuvV, 1.0F, 1.0F, this.NNUUNUuVNNVn, var8, var9);
               this.primaryVal(this.vuvvuVuVv, this.NNUUNUuVNNVn, 1.0F, 1.0F, this.VuunNUUUvu, var6, var7);
               this.primaryVal(this.vuvvuVuVv, this.VuunNUUUvu, 1.0F, 1.0F, this.tokenVal, var4, var5);
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private void holderVal(VvVVnnNNNuV.LicenseValidator var1) {
      int var2 = var1.widthVal();
      int var3 = var1.chunkVal();
      float var4 = Math.max(Math.min(var2, var3), 1) / 1080.0F;
      this.UnnNNvuvvUU = Math.max(7.0F * var4, 1.5F);
      this.twigA = Math.max(38.0F * var4, 4.0F);
      this.itemC = var4;
      this.itemB = Math.max(this.twigA * 3.4F + 16.0F * var4, this.UnnNNvuvvUU * 3.4F + 2.4F * var4) + 6.0F * var4;
      this.VvuUUUNNNv = false;
   }

   private void primaryVal(VvVVnnNNNuV.LicenseValidator var1, VvVVnnNNNuV.HeartbeatService var2) {
      if (this.VvVuvUvvNNVv != null) {
         float var3 = var2.primaryVal();
         if (!(var2.tertiaryVal() > 0.004F) && !(var3 <= 0.004F)) {
            this.VvVuvUvvNNVv.primaryVal();
            if (!this.VvuUUUNNNv) {
               this.VvVuvUvvNNVv.primaryVal("uLightMode", var1.guardVal() ? 1.0F : 0.0F);
               this.VvVuvUvvNNVv.primaryVal("uContact", this.UnnNNvuvvUU, 2.4F * this.itemC, 2.2F * this.itemC, 0.8F * this.itemC);
               this.VvVuvUvvNNVv.primaryVal("uAmbient", this.twigA, 16.0F * this.itemC, 9.0F * this.itemC, 3.0F * this.itemC);
               this.VvVuvUvvNNVv.primaryVal("uGains", 0.33F, 0.48F);
               this.VvuUUUNNNv = true;
            }

            float var4 = this.itemB;
            this.primaryVal(
               this.VvVuvUvvNNVv,
               var1.widthVal(),
               var1.chunkVal(),
               var2.widthVal() - var4,
               var2.chunkVal() - var4,
               var2.blockRef() + var4 * 2.0F,
               var2.holderVal() + var4 * 2.0F
            );
            this.VvVuvUvvNNVv.primaryVal("uContent", var4, var4, var2.blockRef(), var2.holderVal());
            this.VvVuvUvvNNVv.primaryVal("uRadius", var2.timerVal());
            this.VvVuvUvvNNVv.primaryVal("uEntry", var2.weightRef());
            this.VvVuvUvvNNVv.primaryVal("uReveal", var2.depthVal());
            this.VvVuvUvvNNVv.primaryVal("uRevealDir", var2.descRef());
            this.VvVuvUvvNNVv.primaryVal("uOpacity", Math.min(var3, 1.0F));
            this.NNVNuUvVn.primaryVal();
         }
      }
   }

   private void primaryVal(VvVVnnNNNuV.LicenseValidator var1, VvNNUnNNVn var2, float var3, float var4, boolean var5) {
      int var6 = var5 ? var1.tertiaryVal() : var1.secondaryVal();
      if (var6 > 0 && var2 != null && var2.paramVal()) {
         this.holderVal(var1);
         GL11.glEnable(3042);
         GL14.glBlendFuncSeparate(770, 771, 1, 771);
         this.VUUnuVvVu.primaryVal();
         this.VUUnuVvVu.primaryVal("uBackground", 0);
         this.VUUnuVvVu.primaryVal("uTextureSize", var2.marginVal(), var2.weightVal());
         this.VUUnuVvVu.primaryVal("uSourceScale", var3, var4);
         this.VUUnuVvVu.primaryVal("uTime", var1.holderVal());
         this.VUUnuVvVu.primaryVal("uAccentTop", var1.factorVal(), var1.sourceVal(), var1.extraRef());
         this.VUUnuVvVu.primaryVal("uAccentBottom", var1.phaseVal(), var1.limitRef(), var1.paramRef());
         this.VUUnuVvVu.primaryVal("uLightMode", var1.guardVal() ? 1.0F : 0.0F);
         this.primaryVal(var2.tertiaryVal());

         for (int var7 = 0; var7 < var6; var7++) {
            VvVVnnNNNuV.HeartbeatService var8 = var5 ? var1.paramVal(var7) : var1.tertiaryVal(var7);
            if (!(var8.blockRef() <= 1.0F) && !(var8.holderVal() <= 1.0F) && !(var8.weightRef() <= 0.002F)) {
               this.primaryVal(var1, var8);
               this.VUUnuVvVu.primaryVal();
               float var9 = var8.anchorVal() > 0.0F ? var8.anchorVal() : 32.0F;
               this.primaryVal(
                  this.VUUnuVvVu,
                  var1.widthVal(),
                  var1.chunkVal(),
                  var8.widthVal() - var9,
                  var8.chunkVal() - var9,
                  var8.blockRef() + var9 * 2.0F,
                  var8.holderVal() + var9 * 2.0F
               );
               this.VUUnuVvVu.primaryVal("uContent", var9, var9, var8.blockRef(), var8.holderVal());
               this.VUUnuVvVu.primaryVal("uRadius", var8.timerVal());
               this.VUUnuVvVu.primaryVal("uEntry", var8.weightRef());
               this.VUUnuVvVu.primaryVal("uHover", var8.bufferVal());
               this.VUUnuVvVu.primaryVal("uGlow", var8.countVal());
               this.VUUnuVvVu.primaryVal("uReveal", var8.depthVal());
               this.VUUnuVvVu.primaryVal("uRevealDir", var8.descRef());
               this.VUUnuVvVu.primaryVal("uPointerLocal", var8.activeVal(), var8.radiusVal());
               this.VUUnuVvVu.primaryVal("uRow", var8.factorVal(), var8.sourceVal(), var8.extraRef(), var8.phaseVal());
               this.VUUnuVvVu.primaryVal("uRowRadius", var8.limitRef());
               this.VUUnuVvVu.primaryVal("uRowGlow", var8.paramRef());
               this.VUUnuVvVu.primaryVal("uChevron", var8.marginVal(), var8.weightVal(), var8.paramVal(), var8.extraVal());
               this.VUUnuVvVu.primaryVal("uChevronDir", var8.limitVal());
               this.VUUnuVvVu.primaryVal("uChevronAlpha", var8.speedVal());
               this.VUUnuVvVu.primaryVal("uScrim", var8.tertiaryVal());
               this.VUUnuVvVu.primaryVal("uDensity", var8.secondaryVal());
               this.NNVNuUvVn.primaryVal();
            }
         }
      }
   }

   private void timerVal(VvVVnnNNNuV.LicenseValidator var1) {
      VvVVnnNNNuV.DelayedFuse var2 = var1.marginVal();
      if (this.uuuVnuvnnNnU != null && !(var2.marginVal() <= 0.5F) && !(var2.extraVal() <= 0.004F) && !(var2.limitVal() <= 0.004F)) {
         float var3 = Math.max(var2.weightVal(), var2.marginVal() * 1.6F);
         float var4 = var2.secondaryVal() - var3;
         float var5 = var2.tertiaryVal() - var3;
         float var6 = var3 * 2.0F;
         GL11.glEnable(3042);
         GL14.glBlendFuncSeparate(770, 771, 1, 771);
         this.uuuVnuvnnNnU.primaryVal();
         this.primaryVal(this.uuuVnuvnnNnU, var1.widthVal(), var1.chunkVal(), var4, var5, var6, var6);
         this.uuuVnuvnnNnU.primaryVal("uBody", var3, var3, var2.marginVal(), var3);
         this.uuuVnuvnnNnU.primaryVal("uAccentTop", var1.factorVal(), var1.sourceVal(), var1.extraRef());
         this.uuuVnuvnnNnU.primaryVal("uAccentBottom", var1.phaseVal(), var1.limitRef(), var1.paramRef());
         this.uuuVnuvnnNnU.primaryVal("uPhase", var2.paramVal());
         this.uuuVnuvnnNnU.primaryVal("uTime", var1.holderVal());
         this.uuuVnuvnnNnU.primaryVal("uEntry", var2.limitVal());
         this.uuuVnuvnnNnU.primaryVal("uAlpha", var2.extraVal());
         this.uuuVnuvnnNnU.primaryVal("uSeed", var2.speedVal());
         this.uuuVnuvnnNnU.primaryVal("uLightMode", var1.guardVal() ? 1.0F : 0.0F);
         this.uuuVnuvnnNnU.primaryVal("uPointer", var1.anchorVal() - var4, var1.weightRef() - var5);
         this.NNVNuUvVn.primaryVal();
      }
   }

   private void anchorVal(VvVVnnNNNuV.LicenseValidator var1) {
      VvVVnnNNNuV.AccessGuardException var2 = var1.weightVal();
      if (this.nodeJ != null && !(var2.tertiaryVal() <= 0.5F) && !(var2.paramVal() <= 0.004F) && !(var2.weightVal() <= 0.004F)) {
         VvNNUnNNVn var3 = this.UvuVvvVuUuuu && this.speedRef.paramVal() ? this.speedRef : this.heightRef;
         if (var3.paramVal()) {
            boolean var4 = var3 == this.speedRef;
            float var5 = Math.max(var2.marginVal(), var2.tertiaryVal() * 1.7F);
            float var6 = var2.primaryVal() - var5;
            float var7 = var2.secondaryVal() - var5;
            float var8 = var5 * 2.0F;
            GL11.glEnable(3042);
            GL14.glBlendFuncSeparate(770, 771, 1, 771);
            this.nodeJ.primaryVal();
            this.nodeJ.primaryVal("uBackground", 0);
            this.nodeJ.primaryVal("uTextureSize", var3.marginVal(), var3.weightVal());
            this.nodeJ.primaryVal("uSourceScale", var4 ? this.VuuUVVu : this.spanC, var4 ? this.partJ : this.VnnnvUunNvuu);
            this.primaryVal(this.nodeJ, var1.widthVal(), var1.chunkVal(), var6, var7, var8, var8);
            this.nodeJ.primaryVal("uGem", var5, var5, var2.tertiaryVal(), var5);
            this.nodeJ.primaryVal("uAccentTop", var1.factorVal(), var1.sourceVal(), var1.extraRef());
            this.nodeJ.primaryVal("uAccentBottom", var1.phaseVal(), var1.limitRef(), var1.paramRef());
            this.nodeJ.primaryVal("uRadius", var2.tertiaryVal());
            this.nodeJ.primaryVal("uTime", var1.holderVal());
            this.nodeJ.primaryVal("uEntry", var2.weightVal());
            this.nodeJ.primaryVal("uAlpha", var2.paramVal());
            this.nodeJ.primaryVal("uSeed", var2.extraVal());
            this.nodeJ.primaryVal("uLightMode", var1.guardVal() ? 1.0F : 0.0F);
            this.nodeJ.primaryVal("uPointer", var2.limitVal() - var6, var2.speedVal() - var7);
            this.primaryVal(var3.tertiaryVal());
            this.NNVNuUvVn.primaryVal();
         }
      }
   }

   private void primaryVal(
      VvVVnnNNNuV.LicenseValidator var1,
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
      float var14,
      float var15,
      float var16
   ) {
      this.primaryVal(this.UnnnvvU, var1.widthVal(), var1.chunkVal(), var2 - var7, var3 - var7, var4 + var7 * 2.0F, var5 + var7 * 2.0F);
      this.UnnnvvU.primaryVal("uContent", var7, var7, var4, var5);
      this.UnnnvvU.primaryVal("uRadius", var6);
      this.UnnnvvU.primaryVal("uHover", var8);
      this.UnnnvvU.primaryVal("uEntry", var9);
      this.UnnnvvU.primaryVal("uFlash", var10);
      this.UnnnvvU.primaryVal("uPill", var11, var12, var13, var14);
      this.UnnnvvU.primaryVal("uPillRadius", var1.speedVal().primaryVal());
      this.UnnnvvU.primaryVal("uPillGlow", var15);
      this.UnnnvvU.primaryVal("uPillVelocity", var16);
      this.NNVNuUvVn.primaryVal();
   }

   private void primaryVal(ShaderProgramCache.CompiledShader var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      var1.primaryVal("uViewport", var2, var3);
      var1.primaryVal("uRect", var4, var5, var6, var7);
   }

   private void primaryVal(ShaderProgramCache.CompiledShader var1, VvVVnnNNNuV.LicenseValidator var2) {
      for (int var3 = 0; var3 < 14; var3++) {
         VvVVnnNNNuV.TelemetryStateStore var4 = var2.widthVal(var3);
         var1.primaryVal(tertiaryVal[var3], var4.primaryVal(), var4.secondaryVal(), var4.tertiaryVal(), var4.marginVal());
      }
   }

   private static float secondaryVal(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   private void primaryVal() {
      if (!this.NUUVUvvuNNVU) {
         if (this.NNVNuUvVn == null) {
            this.NNVNuUvVn = new FullscreenQuad();
         }

         this.twigD = this.trackVal
            .secondaryVal("composite", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_composite.frag");
         this.nodeD = this.trackVal
            .secondaryVal("particles", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_particles.frag");
         this.NnuUnUNnu = this.trackVal
            .secondaryVal("buttons", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_button.frag");
         this.UnnnvvU = this.trackVal.secondaryVal("capsule", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_capsule.frag");
         this.VUUnuVvVu = this.trackVal.secondaryVal("panel", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_panel.frag");
         this.VvVuvUvvNNVv = this.trackVal
            .secondaryVal("panel_shadow", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_panel_shadow.frag");
         this.uuuVnuvnnNnU = this.trackVal
            .secondaryVal("celestial", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_celestial.frag");
         this.nodeJ = this.trackVal.secondaryVal("gem", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_gem.frag");
         this.twigH = this.trackVal
            .secondaryVal("blur_down", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_blur_down.frag");
         this.vuvvuVuVv = this.trackVal
            .secondaryVal("blur_up", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_blur_up.frag");
         this.uunNUuunVU = this.trackVal.secondaryVal("blit", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_blit.frag");
         this.NUVvUUVuVNVv = this.trackVal
            .secondaryVal("button_glow", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_button_glow.frag");
         this.nodeB = this.trackVal
            .secondaryVal("glow_composite", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_glow_composite.frag");
         this.NvnuuuvnVV = this.trackVal
            .secondaryVal("sdf_bake", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_sdf_bake.frag");
         this.NnUVNnuvUv = this.trackVal
            .secondaryVal("lockup", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_lockup.frag");
         this.UuuuNNunN = this.trackVal
            .secondaryVal("lockup_shadow", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_lockup_shadow.frag");
         this.VUNvNUuNVnn = this.twigD == null || this.NnuUnUNnu == null;
         this.NUUVUvvuNNVU = true;
      }
   }

   private boolean secondaryVal(int var1, int var2) {
      if (this.twigH != null && this.vuvvuVuVv != null && this.uunNUuunVU != null) {
         this.levelVal.primaryVal(var1, var2);
         this.UuNnnVnuNNV.primaryVal(Math.max(2, var1 / 2), Math.max(2, var2 / 2));
         this.depthRef.primaryVal(Math.max(2, var1 / 4), Math.max(2, var2 / 4));
         this.speedRef.primaryVal(Math.max(2, var1 / 2), Math.max(2, var2 / 2));
         return this.levelVal.paramVal() && this.UuNnnVnuNNV.paramVal() && this.depthRef.paramVal() && this.speedRef.paramVal();
      } else {
         return false;
      }
   }

   private void primaryVal(ShaderProgramCache.CompiledShader var1, VvNNUnNNVn var2, float var3, float var4, VvNNUnNNVn var5, int var6, int var7) {
      this.primaryVal(var5, var6, var7);
      GL11.glDisable(3042);
      var1.primaryVal();
      this.primaryVal(var1, var6, var7, 0.0F, 0.0F, var6, var7);
      var1.primaryVal("uSource", 0);
      var1.primaryVal("uSourceTexel", 1.0F / Math.max(1, var2.marginVal()), 1.0F / Math.max(1, var2.weightVal()));
      var1.primaryVal("uSourceScale", var3, var4);
      this.primaryVal(var2.tertiaryVal());
      this.NNVNuUvVn.primaryVal();
   }

   private void secondaryVal() {
      this.primaryVal(this.twigH, this.levelVal, this.nvuUVvuuN, this.itemJ, this.UuNnnVnuNNV, this.vUNuuvvnVnv, this.unnnNUNnVu);
      this.primaryVal(this.twigH, this.UuNnnVnuNNV, this.VuuUVVu, this.partJ, this.depthRef, this.twigF, this.itemG);
      this.primaryVal(this.vuvvuVuVv, this.depthRef, this.VuNVnvNNuNnn, this.uvVuuuvvVU, this.speedRef, this.vUNuuvvnVnv, this.unnnNUNnVu);
   }

   private void weightRef(VvVVnnNNNuV.LicenseValidator var1) {
      GL11.glDisable(3042);
      this.uunNUuunVU.primaryVal();
      this.primaryVal(this.uunNUuunVU, var1.widthVal(), var1.chunkVal(), 0.0F, 0.0F, var1.widthVal(), var1.chunkVal());
      this.uunNUuunVU.primaryVal("uSource", 0);
      this.uunNUuunVU.primaryVal("uSourceScale", this.nvuUVvuuN, this.itemJ);
      this.uunNUuunVU.primaryVal("uSourceTexel", 1.0F / Math.max(1, this.levelVal.marginVal()), 1.0F / Math.max(1, this.levelVal.weightVal()));
      this.primaryVal(this.levelVal.tertiaryVal());
      this.NNVNuUvVn.primaryVal();
   }

   private ShaderProgramCache.CompiledShader bufferVal(VvVVnnNNNuV.LicenseValidator var1) {
      if (var1.entryVal()) {
         if (this.VunnVNvNV == null) {
            this.VunnVNvNV = this.trackVal
               .secondaryVal("midnight_azure", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/midnight_azure.frag");
         }

         return this.VunnVNvNV;
      } else if (var1.countRef()) {
         if (this.UVnuVUUVnnU == null) {
            this.UVnuVUUVnnU = this.trackVal
               .secondaryVal("vernal_solstice", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/vernal_solstice.frag");
         }

         return this.UVnuVUUVnnU;
      } else if (var1.speedRef()) {
         if (this.twigC == null) {
            this.twigC = this.trackVal
               .secondaryVal("sakura_breeze", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/sakura_breeze.frag");
         }

         return this.twigC;
      } else {
         if (this.UnUUVuVunvVu == null) {
            this.UnUUVuVunvVu = this.trackVal
               .secondaryVal("nebula", "assets/wild/shaders/mainmenu/menu_quad.vert", "assets/wild/shaders/mainmenu/menu_nebula.frag");
         }

         return this.UnUUVuVunvVu;
      }
   }

   private void tertiaryVal() {
      this.itemE = -1;
      this.VUVvNvvVUN = -1;
      this.trackVal.primaryVal();
   }

   private void primaryVal(int var1) {
      if (this.itemE != 33984) {
         GL13.glActiveTexture(33984);
         this.itemE = 33984;
         this.VUVvNvvVUN = -1;
      }

      if (this.VUVvNvvVUN != var1) {
         GL11.glBindTexture(3553, var1);
         this.VUVvNvvVUN = var1;
      }
   }

   private void tertiaryVal(int var1, int var2) {
      GL13.glActiveTexture(33984 + var1);
      GL11.glBindTexture(3553, var2);
      this.itemE = -1;
      this.VUVvNvvVUN = -1;
   }

   public static long primaryVal(class_310 var0, int var1, int var2) {
      if (var0 != null && GLFW.glfwGetCurrentContext() != 0L) {
         class_1041 var3 = var0.method_22683();
         if (var3 != null && !var3.method_65966()) {
            int var4 = var3.method_4489();
            int var5 = var3.method_4506();
            if (var4 > 0 && var5 > 0 && var1 > 0 && var2 > 0) {
               class_276 var6 = var0.method_1522();
               if (var6 != null && var6.field_1482 > 0 && var6.field_1481 > 0) {
                  if (var6.method_30277() instanceof class_10868 var8) {
                     int var9 = var8.method_68427();
                     if (var9 > 0 && GL11.glIsTexture(var9)) {
                        var4 = Math.min(var4, var6.field_1482);
                        var5 = Math.min(var5, var6.field_1481);
                        return var4 > 0 && var5 > 0 ? (long)var4 << 32 | var5 & 4294967295L : -1L;
                     } else {
                        return -1L;
                     }
                  } else {
                     return -1L;
                  }
               } else {
                  return -1L;
               }
            } else {
               return -1L;
            }
         } else {
            return -1L;
         }
      } else {
         return -1L;
      }
   }

   public static int primaryVal(long var0) {
      return (int)(var0 >>> 32);
   }

   public static int secondaryVal(long var0) {
      return (int)var0;
   }

   public static OoCO0O0oc0c.WildClient secondaryVal(class_310 var0, int var1, int var2) {
      long var3 = primaryVal(var0, var1, var2);
      if (var3 < 0L) {
         return null;
      }

      int var6 = var0.method_1522().method_30277() instanceof class_10868 var7 ? var7.method_68427() : 0;
      return new OoCO0O0oc0c.WildClient(primaryVal(var3), secondaryVal(var3), var6);
   }

   private static String[] marginVal() {
      String[] var0 = new String[14];

      for (int var1 = 0; var1 < var0.length; var1++) {
         var0[var1] = "uTrail[" + var1 + "]";
      }

      return var0;
   }

   @Override
   public void close() {
      this.heightRef.close();
      this.levelVal.close();
      this.UuNnnVnuNNV.close();
      this.depthRef.close();
      this.speedRef.close();
      this.countRef.close();
      this.entryVal.close();
      this.guardVal.close();
      this.VUuuVUnun.close();
      this.vVVuuVVv.close();
      this.VuunNUUUvu.close();
      this.NNUUNUuVNNVn.close();
      this.VvVvnNUnvuvV.close();
      this.tokenVal.close();
      this.twigB = false;
      this.nUununvNvvn = -1.0F;
      this.vuvnnvuNVvu = 0.0F;
      this.UvuVvvVuUuuu = false;
      if (this.NNVNuUvVn != null) {
         this.NNVNuUvVn.close();
         this.NNVNuUvVn = null;
      }

      this.trackVal.close();
      this.UnUUVuVunvVu = null;
      this.twigC = null;
      this.UVnuVUUVnnU = null;
      this.VunnVNvNV = null;
      this.twigD = null;
      this.nodeD = null;
      this.NnuUnUNnu = null;
      this.UnnnvvU = null;
      this.VUUnuVvVu = null;
      this.VvVuvUvvNNVv = null;
      this.uuuVnuvnnNnU = null;
      this.twigH = null;
      this.vuvvuVuVv = null;
      this.uunNUuunVU = null;
      this.NvnuuuvnVV = null;
      this.NnUVNnuvUv = null;
      this.UuuuNNunN = null;
      this.NUVvUUVuVNVv = null;
      this.nodeB = null;
      this.NUUVUvvuNNVU = false;
      this.VUNvNUuNVnn = false;
      this.UNNunNuUNVuU = false;
   }

   public void primaryVal(int var1, int var2) {
      try {
         this.heightRef.close();
         this.levelVal.close();
         this.UuNnnVnuNNV.close();
         this.depthRef.close();
         this.speedRef.close();
         this.countRef.close();
         this.entryVal.close();
         this.guardVal.close();
         this.VUuuVUnun.close();
         this.vVVuuVVv.close();
         this.VuunNUUUvu.close();
         this.NNUUNUuVNNVn.close();
         this.VvVvnNUnvuvV.close();
         this.tokenVal.close();
         this.twigB = false;
         this.nUununvNvvn = -1.0F;
         this.vuvnnvuNVvu = 0.0F;
         this.UvuVvvVuUuuu = false;
      } catch (Throwable var4) {
      }
   }

   public record WildClient(int width, int height, int colorTexture) {
   }
}
