package ru.metaculture.protection;

import java.util.List;
import net.minecraft.class_1041;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;
import org.lwjgl.opengl.GL11;

public final class ProxyScreen extends class_437 implements WildScreenMarker {
   private static final ThemeSwatchCatalog primaryVal = ThemeSwatchCatalog.primaryVal();
   private static final int secondaryVal = 14;
   private final class_437 tertiaryVal;
   private final OoCO0O0oc0c marginVal = new OoCO0O0oc0c();
   private final ProxyScreen.VvunVVUvUNnv weightVal = new ProxyScreen.VvunVVUvUNnv("Host", false, 255, ProxyScreen.DelayedFuse.HOST);
   private final ProxyScreen.VvunVVUvUNnv paramVal = new ProxyScreen.VvunVVUvUNnv("Port", false, 5, ProxyScreen.DelayedFuse.PORT);
   private final ProxyScreen.VvunVVUvUNnv extraVal = new ProxyScreen.VvunVVUvUNnv("Username", false, 128, ProxyScreen.DelayedFuse.TEXT);
   private final ProxyScreen.VvunVVUvUNnv limitVal = new ProxyScreen.VvunVVUvUNnv("Password", true, 256, ProxyScreen.DelayedFuse.SECRET);
   private final List<ProxyScreen.VvunVVUvUNnv> speedVal = List.of(this.weightVal, this.paramVal, this.extraVal, this.limitVal);
   private final List<ProxyScreen.cursorVal> widthVal = List.of(
      new ProxyScreen.cursorVal("Socks5", ProxyScreen.WildClient.TYPE),
      new ProxyScreen.cursorVal("Enabled", ProxyScreen.WildClient.ENABLED),
      new ProxyScreen.cursorVal("Paste", ProxyScreen.WildClient.PASTE),
      new ProxyScreen.cursorVal("Test", ProxyScreen.WildClient.TEST),
      new ProxyScreen.cursorVal("Save", ProxyScreen.WildClient.SAVE),
      new ProxyScreen.cursorVal("Back", ProxyScreen.WildClient.BACK)
   );
   private final ProxyScreen.FingerprintCrypto[] chunkVal = new ProxyScreen.FingerprintCrypto[14];
   private final VvVVnnNNNuV.LicenseValidator blockRef = new VvVVnnNNNuV.LicenseValidator(10, 14);
   private final GLStateSnapshot.Snapshot holderVal = new GLStateSnapshot.Snapshot();
   private final GLStateSnapshot.Snapshot timerVal = new GLStateSnapshot.Snapshot();
   private final SpringInterpolator anchorVal = new SpringInterpolator(SpringConfig.weightVal());
   private final SpringInterpolator weightRef = new SpringInterpolator(SpringConfig.weightVal());
   private long bufferVal;
   private long countVal;
   private long depthVal;
   private float descRef;
   private float activeVal;
   private float radiusVal;
   private float factorVal;
   private float sourceVal;
   private float extraRef;
   private float phaseVal;
   private float limitRef;
   private float paramRef;
   private float groupVal;
   private float layerVal;
   private boolean slotVal;
   private boolean themeVal;
   private boolean stageVal;
   private int widthRef;
   private int trackVal;
   private int modeRef = -6357021;
   private int angleVal = -11341636;
   private NvVNvUvunNNu heightRef = NvVNvUvunNNu.AURORA;
   private boolean levelVal;
   private boolean UuNnnVnuNNV;
   private boolean depthRef;
   private String speedRef = "Socks5";
   private String countRef = "Proxy disabled";
   private int entryVal;

   public ProxyScreen(class_437 var1) {
      super(class_2561.method_43470("Proxy"));
      this.tertiaryVal = var1;

      for (int var2 = 0; var2 < this.chunkVal.length; var2++) {
         this.chunkVal[var2] = new ProxyScreen.FingerprintCrypto();
      }
   }

   protected void method_25426() {
      super.method_25426();
      this.bufferVal = System.nanoTime();
      this.countVal = this.bufferVal;
      this.depthVal = this.bufferVal;
      this.slotVal = false;
      this.themeVal = false;
      this.stageVal = false;
      this.widthRef = 0;
      this.trackVal = 0;
      this.anchorVal.primaryVal(0.0F);
      this.weightRef.primaryVal(0.0F);
      if (!this.UuNnnVnuNNV) {
         ProxyManager.WildClient var1 = ProxyManager.tertiaryVal();
         this.depthRef = var1.enabled();
         this.speedRef = ProxyManager.secondaryVal(var1.type());
         this.weightVal.factorVal = var1.host();
         this.paramVal.factorVal = var1.port();
         this.extraVal.factorVal = var1.username();
         this.limitVal.factorVal = var1.password();

         for (ProxyScreen.VvunVVUvUNnv var3 : this.speedVal) {
            var3.sourceVal = var3.factorVal.length();
         }

         this.countRef = this.depthRef ? "Proxy enabled" : "Proxy disabled";
         this.UuNnnVnuNNV = true;
      }

      for (ProxyScreen.VvunVVUvUNnv var6 : this.speedVal) {
         var6.weightVal();
      }

      for (ProxyScreen.cursorVal var7 : this.widthVal) {
         var7.primaryVal();
      }
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      this.primaryVal(var2, var3, var4, false);
   }

   @Override
   public void primaryVal(int var1, int var2, float var3) {
      this.primaryVal(var1, var2, var3, true);
   }

   private void primaryVal(int var1, int var2, float var3, boolean var4) {
      class_1041 var5 = this.field_22787 == null ? null : this.field_22787.method_22683();
      if (var5 != null && !var5.method_65966() && var5.method_4489() > 0 && var5.method_4506() > 0) {
         int var6 = var5.method_4489();
         int var7 = var5.method_4506();
         long var8 = System.nanoTime();
         float var10 = Math.max(0.001F, Math.min(0.05F, (float)(var8 - this.countVal) / 1.0E9F));
         this.countVal = var8;
         this.descRef = (float)(var8 - this.bufferVal) / 1.0E9F;
         if (this.primaryVal(var5, var6, var7, var1, var2, var8)) {
            var10 = 0.001F;
         }

         this.weightVal();
         this.primaryVal(var5, var1, var2, var10, var8);
         this.secondaryVal(var6, var7, var10);
         this.paramVal();
         float var11 = (this.activeVal / Math.max(1.0F, var6) - 0.5F) * 2.0F;
         float var12 = (this.radiusVal / Math.max(1.0F, var7) - 0.5F) * 2.0F;
         float var13 = this.anchorVal.primaryVal(var11, var10);
         float var14 = this.weightRef.primaryVal(var12, var10);
         this.primaryVal(var6, var7, var13, var14, var10);
         int var15 = GL11.glGetInteger(36006);
         this.primaryVal(var6, var7, var15, var13, var14, var8);
         if (var4) {
            GLStateSnapshot.secondaryVal(this.holderVal);

            try {
               this.marginVal.primaryVal(this.blockRef);
            } finally {
               GLStateSnapshot.tertiaryVal(this.holderVal);
            }

            this.primaryVal(this.blockRef);
         }
      }
   }

   public void method_25420(class_332 var1, int var2, int var3, float var4) {
   }

   public void method_52752(class_332 var1) {
   }

   public boolean method_25421() {
      return false;
   }

   public boolean method_25422() {
      return false;
   }

   public void method_25419() {
      this.primaryVal(ProxyScreen.WildClient.BACK);
   }

   public void method_25432() {
      this.entryVal++;
      this.marginVal.close();
      super.method_25432();
   }

   public boolean method_25402(double var1, double var3, int var5) {
      if (var5 == 0 && this.field_22787 != null && this.field_22787.method_22683() != null) {
         float var6 = this.primaryVal(this.field_22787.method_22683(), var1);
         float var7 = this.secondaryVal(this.field_22787.method_22683(), var3);

         for (ProxyScreen.VvunVVUvUNnv var9 : this.speedVal) {
            if (var9.primaryVal(var6, var7)) {
               this.primaryVal(var9);
               var9.blockRef = 1.0F;
               return true;
            }
         }

         this.tertiaryVal();

         for (ProxyScreen.cursorVal var11 : this.widthVal) {
            if (var11.primaryVal(var6, var7)) {
               var11.blockRef = 1.0F;
               var11.holderVal = 1.0F;
               this.primaryVal(var11.descRef);
               return true;
            }
         }

         return true;
      } else {
         return super.method_25402(var1, var3, var5);
      }
   }

   public boolean method_25400(char var1, int var2) {
      ProxyScreen.VvunVVUvUNnv var3 = this.marginVal();
      if (var3 == null) {
         return super.method_25400(var1, var2);
      }

      if (var1 >= ' ' && var1 != 127) {
         var3.secondaryVal(String.valueOf(var1));
      }

      return true;
   }

   public boolean method_25404(int var1, int var2, int var3) {
      boolean var4 = (var3 & 2) != 0 || (var3 & 8) != 0;
      ProxyScreen.VvunVVUvUNnv var5 = this.marginVal();
      if (var1 == 256) {
         if (var5 != null) {
            this.tertiaryVal();
            return true;
         } else {
            this.primaryVal(ProxyScreen.WildClient.BACK);
            return true;
         }
      } else {
         if (var1 == 258) {
            this.primaryVal((var3 & 1) != 0 ? -1 : 1);
            return true;
         }

         if (var5 != null) {
            if (var4) {
               if (var1 == 65) {
                  var5.phaseVal = true;
                  return true;
               }

               if (var1 == 67) {
                  if (this.field_22787 != null && this.field_22787.field_1774 != null && var5.phaseVal) {
                     this.field_22787.field_1774.method_1455(var5.factorVal);
                  }

                  return true;
               }

               if (var1 == 86) {
                  if (this.field_22787 != null && this.field_22787.field_1774 != null) {
                     var5.secondaryVal(this.field_22787.field_1774.method_1460());
                  }

                  return true;
               }
            }

            if (var1 == 259) {
               var5.secondaryVal();
               return true;
            }

            if (var1 == 261) {
               var5.tertiaryVal();
               return true;
            }

            if (var1 == 263) {
               var5.phaseVal = false;
               var5.sourceVal = primaryVal(var5.sourceVal - 1, 0, var5.factorVal.length());
               return true;
            }

            if (var1 == 262) {
               var5.phaseVal = false;
               var5.sourceVal = primaryVal(var5.sourceVal + 1, 0, var5.factorVal.length());
               return true;
            }

            if (var1 == 268) {
               var5.phaseVal = false;
               var5.sourceVal = 0;
               return true;
            }

            if (var1 == 269) {
               var5.phaseVal = false;
               var5.sourceVal = var5.factorVal.length();
               return true;
            }

            if (var1 != 257 && var1 != 335) {
               return true;
            }

            this.primaryVal(ProxyScreen.WildClient.SAVE);
            return true;
         } else {
            if (var4 && var1 == 86) {
               this.primaryVal(ProxyScreen.WildClient.PASTE);
               return true;
            }

            if (var1 != 257 && var1 != 335) {
               return super.method_25404(var1, var2, var3);
            }

            this.primaryVal(ProxyScreen.WildClient.SAVE);
            return true;
         }
      }
   }

   private void primaryVal(ProxyScreen.WildClient var1) {
      class_310 var2 = this.field_22787 == null ? class_310.method_1551() : this.field_22787;
      if (var2 != null) {
         switch (var1) {
            case TYPE:
               this.speedRef = "Socks5".equals(this.speedRef) ? "Socks4" : "Socks5";
               this.countRef = this.speedRef + " selected";
               break;
            case ENABLED:
               this.depthRef = !this.depthRef;
               if (this.depthRef) {
                  this.countRef = "Proxy enabled";
               } else {
                  ProxyManager.primaryVal(this.secondaryVal(false));
                  this.countRef = "Proxy disabled";
               }
               break;
            case PASTE:
               this.primaryVal(var2);
               break;
            case TEST:
               this.secondaryVal(var2);
               break;
            case SAVE:
               this.primaryVal(false);
               break;
            case BACK:
               var2.execute(() -> var2.method_1507(this.tertiaryVal));
         }
      }
   }

   private void primaryVal(class_310 var1) {
      String var2 = "";

      try {
         var2 = var1.field_1774 == null ? "" : var1.field_1774.method_1460();
      } catch (Throwable var4) {
      }

      ProxyManager.cursorVal var3 = ProxyManager.primaryVal(var2);
      if (!var3.host().isBlank() && !var3.port().isBlank()) {
         this.speedRef = ProxyManager.secondaryVal(var3.type());
         this.weightVal.primaryVal(var3.host());
         this.paramVal.primaryVal(var3.port());
         this.extraVal.primaryVal(var3.username());
         this.limitVal.primaryVal(var3.password());
         this.depthRef = true;
         this.tertiaryVal();
         this.countRef = "Proxy imported";
      } else {
         this.countRef = "Clipboard has no proxy";
      }
   }

   private void secondaryVal(class_310 var1) {
      this.secondaryVal();
      ProxyManager.WildClient var2 = this.secondaryVal(true);
      String var3 = ProxyManager.primaryVal(var2, true);
      if (var3 != null) {
         this.countRef = var3;
      } else {
         int var4 = ++this.entryVal;
         this.countRef = "Checking proxy...";
         ProxyManager.primaryVal(var2, "mc.funtime.su", 25565, 8000).whenComplete((var4x, var5) -> var1.execute(() -> {
            if (var4 == this.entryVal) {
               if (var5 != null) {
                  this.countRef = "Proxy failed: " + var5.getClass().getSimpleName();
               } else {
                  if (var4x.success()) {
                     this.depthRef = true;
                     ProxyManager.primaryVal(var2);
                     this.countRef = "Proxy OK and enabled: " + var4x.millis() + " ms";
                  } else {
                     this.countRef = "Proxy failed: " + var4x.message();
                  }
               }
            }
         }));
      }
   }

   private void primaryVal(boolean var1) {
      this.secondaryVal();
      ProxyManager.WildClient var2 = this.secondaryVal(true);
      String var3 = ProxyManager.primaryVal(var2, true);
      if (var3 != null) {
         this.countRef = var3;
      } else {
         this.depthRef = true;
         ProxyManager.primaryVal(var2);
         this.countRef = "Proxy saved and enabled";
         if (var1 && this.field_22787 != null) {
            this.field_22787.method_1507(this.tertiaryVal);
         }
      }
   }

   private void secondaryVal() {
      String var1 = this.weightVal.factorVal;
      ProxyManager.cursorVal var2 = ProxyManager.primaryVal(var1);
      if (!var2.host().isBlank()) {
         this.weightVal.primaryVal(var2.host());
         if (!var2.port().isBlank()) {
            this.paramVal.primaryVal(var2.port());
         }

         if (!var2.username().isBlank()) {
            this.extraVal.primaryVal(var2.username());
         }

         if (!var2.password().isBlank()) {
            this.limitVal.primaryVal(var2.password());
         }

         this.speedRef = ProxyManager.secondaryVal(var2.type());
      } else {
         ProxyManager.cursorVal var3 = ProxyManager.primaryVal(this.weightVal.factorVal + ":" + this.paramVal.factorVal);
         if (!var3.host().isBlank()) {
            this.weightVal.primaryVal(var3.host());
         }
      }
   }

   private ProxyManager.WildClient secondaryVal(boolean var1) {
      return new ProxyManager.WildClient(var1, this.speedRef, this.weightVal.factorVal, this.paramVal.factorVal, this.extraVal.factorVal, this.limitVal.factorVal);
   }

   private void primaryVal(ProxyScreen.VvunVVUvUNnv var1) {
      for (ProxyScreen.VvunVVUvUNnv var3 : this.speedVal) {
         var3.extraRef = var3 == var1;
         var3.phaseVal = false;
         if (var3.extraRef) {
            var3.sourceVal = var3.factorVal.length();
         }
      }
   }

   private void primaryVal(int var1) {
      ProxyScreen.VvunVVUvUNnv var2 = this.marginVal();
      int var3 = var2 == null ? (var1 > 0 ? -1 : this.speedVal.size()) : this.speedVal.indexOf(var2);
      int var4 = Math.floorMod(var3 + var1, this.speedVal.size());
      this.primaryVal(this.speedVal.get(var4));
   }

   private void tertiaryVal() {
      for (ProxyScreen.VvunVVUvUNnv var2 : this.speedVal) {
         var2.extraRef = false;
         var2.phaseVal = false;
      }
   }

   private ProxyScreen.VvunVVUvUNnv marginVal() {
      for (ProxyScreen.VvunVVUvUNnv var2 : this.speedVal) {
         if (var2.extraRef) {
            return var2;
         }
      }

      return null;
   }

   private void weightVal() {
      NvVNvUvunNNu var1 = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal()
         : NvVNvUvunNNu.AURORA;
      this.heightRef = var1;
      this.levelVal = primaryVal.tertiaryVal(var1);
      this.modeRef = primaryVal.marginVal(var1);
      this.angleVal = primaryVal.weightVal(var1);
   }

   private boolean primaryVal(class_1041 var1, int var2, int var3, int var4, int var5, long var6) {
      if (this.widthRef == var2 && this.trackVal == var3) {
         return false;
      }

      this.widthRef = var2;
      this.trackVal = var3;
      float var8 = secondaryVal(this.primaryVal(var1, var4), 0.0F, var2);
      float var9 = secondaryVal(this.secondaryVal(var1, var5), 0.0F, var3);
      this.activeVal = this.extraRef = this.groupVal = var8;
      this.radiusVal = this.phaseVal = this.layerVal = var9;
      this.factorVal = this.sourceVal = 0.0F;
      this.limitRef = this.paramRef = 0.0F;
      this.slotVal = true;
      this.themeVal = true;
      this.stageVal = true;
      this.depthVal = var6;
      this.anchorVal.primaryVal(0.0F);
      this.weightRef.primaryVal(0.0F);
      this.extraVal();
      this.primaryVal(var8, var9, 0.12F);
      return true;
   }

   private void primaryVal(class_1041 var1, int var2, int var3, float var4, long var5) {
      float var7 = this.primaryVal(var1, var2);
      float var8 = this.secondaryVal(var1, var3);
      if (!this.slotVal) {
         this.activeVal = var7;
         this.radiusVal = var8;
         this.factorVal = 0.0F;
         this.sourceVal = 0.0F;
         this.slotVal = true;
      } else {
         float var9 = var7 - this.activeVal;
         float var10 = var8 - this.radiusVal;
         float var11 = secondaryVal(var9, var10);
         if (var11 > 0.2F) {
            this.factorVal = secondaryVal(var9 / Math.max(1.0F, var1.method_4489()) / var4, -3.0F, 3.0F);
            this.sourceVal = secondaryVal(var10 / Math.max(1.0F, var1.method_4506()) / var4, -3.0F, 3.0F);
         } else {
            float var12 = (float)Math.pow(8.0E-4F, var4);
            this.factorVal *= var12;
            this.sourceVal *= var12;
         }

         this.activeVal = var7;
         this.radiusVal = var8;
         if (var11 > 1.5F) {
            this.depthVal = var5;
         }
      }
   }

   private void secondaryVal(int var1, int var2, float var3) {
      if (!this.themeVal) {
         this.extraRef = this.activeVal;
         this.phaseVal = this.radiusVal;
         this.limitRef = 0.0F;
         this.paramRef = 0.0F;
         this.themeVal = true;
      } else {
         float var4 = this.extraRef;
         float var5 = this.phaseVal;
         float var6 = secondaryVal(this.activeVal - this.extraRef, this.radiusVal - this.phaseVal);
         float var7 = (1.0F - (float)Math.pow(3.5E-5F, var3)) * (0.72F + secondaryVal(var6 / 520.0F, 0.0F, 0.42F));
         this.extraRef = this.extraRef + (this.activeVal - this.extraRef) * secondaryVal(var7, 0.05F, 0.26F);
         this.phaseVal = this.phaseVal + (this.radiusVal - this.phaseVal) * secondaryVal(var7, 0.05F, 0.26F);
         float var8 = secondaryVal((this.extraRef - var4) / Math.max(1.0F, var1) / var3, -1.8F, 1.8F);
         float var9 = secondaryVal((this.phaseVal - var5) / Math.max(1.0F, var2) / var3, -1.8F, 1.8F);
         float var10 = 1.0F - (float)Math.pow(0.0025F, var3);
         this.limitRef = this.limitRef + (var8 - this.limitRef) * var10;
         this.paramRef = this.paramRef + (var9 - this.paramRef) * var10;
      }
   }

   private void paramVal() {
      if (PerformanceModeUtil.tertiaryVal() && MenuModule.primaryVal(MenuModule.countRef)) {
         if (!this.stageVal) {
            this.groupVal = this.extraRef;
            this.layerVal = this.phaseVal;
            this.stageVal = true;
            this.primaryVal(this.extraRef, this.phaseVal, 0.3F);
         } else {
            float var1 = secondaryVal(this.extraRef - this.groupVal, this.phaseVal - this.layerVal);
            if (var1 > 5.5F) {
               this.primaryVal(this.extraRef, this.phaseVal, secondaryVal(var1 / 190.0F, 0.1F, 0.48F));
               this.groupVal = this.extraRef;
               this.layerVal = this.phaseVal;
            }
         }
      }
   }

   private void extraVal() {
      for (ProxyScreen.FingerprintCrypto var4 : this.chunkVal) {
         var4.primaryVal = 0.0F;
         var4.secondaryVal = 0.0F;
         var4.tertiaryVal = -100.0F;
         var4.marginVal = 0.0F;
      }
   }

   private void primaryVal(float var1, float var2, float var3) {
      int var4 = 0;
      float var5 = -1.0F;

      for (int var6 = 0; var6 < this.chunkVal.length; var6++) {
         float var7 = this.descRef - this.chunkVal[var6].tertiaryVal;
         if (this.chunkVal[var6].marginVal <= 0.0F) {
            var4 = var6;
            break;
         }

         if (var7 > var5) {
            var5 = var7;
            var4 = var6;
         }
      }

      this.chunkVal[var4].primaryVal = var1;
      this.chunkVal[var4].secondaryVal = var2;
      this.chunkVal[var4].tertiaryVal = this.descRef;
      this.chunkVal[var4].marginVal = var3;
   }

   private void primaryVal(int var1, int var2, float var3, float var4, float var5) {
      float var6 = primaryVal(var1, var2);
      boolean var7 = var1 < 980.0F * var6;
      float var8 = 46.0F * var6;
      float var9 = 18.0F * var6;
      float var10 = 16.0F * var6;
      float var11 = var7 ? secondaryVal(var1 * 0.68F, 300.0F * var6, 520.0F * var6) : secondaryVal(var1 * 0.2F, 280.0F * var6, 410.0F * var6);
      float var12 = var7 ? var11 : var11 * 2.0F + var10;
      float var13 = 42.0F * var6;
      float var14 = 10.0F * var6;
      float var15 = var7 ? (var12 - var14) * 0.5F : secondaryVal(var1 * 0.072F, 96.0F * var6, 128.0F * var6);
      int var16 = var7 ? 2 : 6;
      int var17 = var7 ? 3 : 1;
      float var18 = var16 * var15 + (var16 - 1) * var14;
      float var19 = var7 ? this.speedVal.size() * var8 + (this.speedVal.size() - 1) * var9 : var8 * 2.0F + var9;
      float var20 = var17 * var13 + (var17 - 1) * var14;
      float var21 = var19 + 34.0F * var6 + var20;
      float var22 = var1 * 0.5F + var3 * 1.35F * var6;
      float var23 = var2 * 0.305F + var4 * 0.92F * var6;
      if (var23 + var21 > var2 - 58.0F * var6) {
         var23 = var2 - var21 - 58.0F * var6;
      }

      var23 = Math.max(var2 * 0.21F, var23);
      float var24 = var22 - var12 * 0.5F;

      for (int var25 = 0; var25 < this.speedVal.size(); var25++) {
         ProxyScreen.VvunVVUvUNnv var26 = this.speedVal.get(var25);
         int var27 = var7 ? 0 : var25 % 2;
         int var28 = var7 ? var25 : var25 / 2;
         float var29 = var24 + var27 * (var11 + var10);
         float var30 = var23 + var28 * (var8 + var9);
         this.primaryVal(var26, var29, var30, var11, var8, var8 * 0.5F, var5, var6);
      }

      float var32 = var22 - var18 * 0.5F;
      float var33 = var23 + var19 + 34.0F * var6;

      for (int var34 = 0; var34 < this.widthVal.size(); var34++) {
         ProxyScreen.cursorVal var35 = this.widthVal.get(var34);
         int var36 = var34 % var16;
         int var37 = var34 / var16;
         var35.primaryVal = this.secondaryVal(var35.descRef);
         var35.tertiaryVal = var32 + var36 * (var15 + var14);
         var35.marginVal = var33 + var37 * (var13 + var14);
         var35.extraVal = var15;
         var35.limitVal = var13;
         var35.speedVal = var13 * 0.5F;
         var35.countVal = 46.0F * var6;
         var35.depthVal = tertiaryVal(secondaryVal((this.descRef - 0.32F - var34 * 0.035F) / 0.76F, 0.0F, 1.0F));
         this.primaryVal(var35, var5, var6);
      }
   }

   private void primaryVal(ProxyScreen.VvunVVUvUNnv var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      var1.tertiaryVal = var2;
      var1.marginVal = var3;
      var1.extraVal = var4;
      var1.limitVal = var5;
      var1.speedVal = var6;
      var1.countVal = 50.0F * var8;
      var1.depthVal = tertiaryVal(secondaryVal((this.descRef - 0.22F - this.speedVal.indexOf(var1) * 0.04F) / 0.82F, 0.0F, 1.0F));
      this.primaryVal(var1, var7, var8);
      var1.limitRef = var1.limitRef + ((var1.extraRef ? 1.0F : 0.0F) - var1.limitRef) * (1.0F - (float)Math.pow(1.0E-4F, var7));
   }

   private void primaryVal(ProxyScreen.AccessGuardException var1, float var2, float var3) {
      float var4 = primaryVal(this.activeVal, this.radiusVal, var1.tertiaryVal, var1.marginVal, var1.extraVal, var1.limitVal, var1.speedVal);
      boolean var5 = var4 <= 0.0F;
      float var6 = 1.0F - tertiaryVal(secondaryVal(Math.max(0.0F, var4) / Math.max(1.0F, 28.0F * var3), 0.0F, 1.0F));
      float var7 = var1 instanceof ProxyScreen.VvunVVUvUNnv var8 && var8.extraRef ? 0.52F : 0.0F;
      float var13 = Math.max(var5 ? Math.max(0.74F, var6) : var6 * 0.48F, var7);
      var1.widthVal = var1.widthVal + ((var5 ? 1.0F : 0.0F) - var1.widthVal) * (1.0F - (float)Math.pow(1.0E-4F, var2));
      var1.chunkVal = var1.chunkVal + (var13 - var1.chunkVal) * (1.0F - (float)Math.pow(1.4E-4F, var2));
      var1.blockRef = var1.blockRef + (0.0F - var1.blockRef) * (1.0F - (float)Math.pow(1.8E-5F, var2));
      var1.holderVal = var1.holderVal + (0.0F - var1.holderVal) * (1.0F - (float)Math.pow(6.0E-6F, var2));
      float var9 = secondaryVal((this.extraRef - var1.tertiaryVal) / Math.max(1.0F, var1.extraVal), 0.0F, 1.0F);
      float var10 = secondaryVal((this.phaseVal - var1.marginVal) / Math.max(1.0F, var1.limitVal), 0.0F, 1.0F);
      float var11 = 1.0F - (float)Math.pow(2.2E-4F, var2);
      var1.anchorVal = var1.anchorVal + (var9 - var1.anchorVal) * var11;
      var1.weightRef = var1.weightRef + (var10 - var1.weightRef) * var11;
      float var12 = 1.0F + var1.chunkVal * 0.04F - var1.blockRef * 0.065F + var7 * 0.018F;
      var1.timerVal = var1.secondaryVal.primaryVal(var12, var2);
      var1.weightVal = var1.tertiaryVal + (var1.anchorVal - 0.5F) * 5.0F * var3 * var1.chunkVal;
      var1.paramVal = var1.marginVal + (var1.weightRef - 0.5F) * 3.5F * var3 * var1.chunkVal - var1.widthVal * 1.2F * var3;
      var1.bufferVal = secondaryVal(
         secondaryVal(this.limitRef, this.paramRef) * 0.42F * var1.chunkVal + Math.abs(var1.secondaryVal.secondaryVal()) * 0.04F, 0.0F, 1.0F
      );
   }

   private void primaryVal(int var1, int var2, int var3, float var4, float var5, long var6) {
      float var8 = Math.max(0.0F, (float)(var6 - this.depthVal) / 1.0E9F);
      float var9 = secondaryVal(secondaryVal(this.limitRef, this.paramRef), 0.0F, 3.0F);
      float var10 = Math.max((float)Math.exp(-var8 * 1.28F), secondaryVal(var9 * 0.24F, 0.0F, 1.0F));
      float var11 = tertiaryVal(secondaryVal(this.descRef / 0.88F, 0.0F, 1.0F));
      float var12 = primaryVal(var1, var2);
      float var13 = 0.0F;
      int var14 = 0;

      for (ProxyScreen.VvunVVUvUNnv var16 : this.speedVal) {
         this.primaryVal(var14++, var16, var16.depthVal);
         var13 = Math.max(var13, var16.holderVal);
      }

      for (ProxyScreen.cursorVal var20 : this.widthVal) {
         this.primaryVal(var14++, var20, var20.depthVal);
         var13 = Math.max(var13, var20.holderVal);
      }

      this.blockRef.speedVal(var14);

      for (int var19 = 0; var19 < 14; var19++) {
         ProxyScreen.FingerprintCrypto var21 = this.chunkVal[var19];
         float var17 = Math.max(0.0F, this.descRef - var21.tertiaryVal);
         this.blockRef
            .widthVal(var19)
            .primaryVal(var21.primaryVal / Math.max(1.0F, var1), var21.secondaryVal / Math.max(1.0F, var2), var17, var17 > 3.1F ? 0.0F : var21.marginVal);
      }

      this.blockRef.limitVal().primaryVal(0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
      this.blockRef.primaryVal(var1, var2, var3, this.descRef * 0.58F, this.descRef * 0.58F);
      this.blockRef.primaryVal(this.extraRef, this.phaseVal, this.limitRef * 0.56F, this.paramRef * 0.56F, var9 * 0.56F, 0.0F);
      this.blockRef.primaryVal(this.modeRef, this.angleVal);
      this.blockRef.secondaryVal(-var4 * 8.0E-4F, -var5 * 6.2E-4F, var4 * 0.92F * var12, var5 * 0.78F * var12, var4 * 1.25F * var12, var5 * 1.05F * var12);
      this.blockRef.tertiaryVal(var10 * 0.64F, var10 > 0.1F ? 0.86F : 0.74F, 0.0F, 0.0F, 0.56F + var11 * 0.24F, secondaryVal(var13, 0.0F, 1.0F));
      this.blockRef
         .primaryVal(
            this.heightRef == NvVNvUvunNNu.SAKURA_BREEZE,
            this.heightRef == NvVNvUvunNNu.VERNAL_SOLSTICE,
            this.heightRef == NvVNvUvunNNu.MIDNIGHT_AZURE,
            this.levelVal
         );
   }

   private void primaryVal(int var1, ProxyScreen.AccessGuardException var2, float var3) {
      this.blockRef
         .primaryVal(var1)
         .primaryVal(
            var2.primaryVal,
            var2.weightVal,
            var2.paramVal,
            var2.extraVal,
            var2.limitVal,
            var2.speedVal,
            var2.widthVal,
            var2.chunkVal,
            var2.blockRef,
            var3,
            var2.holderVal,
            var2.countVal,
            var2.timerVal,
            var2.anchorVal,
            var2.weightRef,
            var2.bufferVal
         );
   }

   private void primaryVal(VvVVnnNNNuV.LicenseValidator var1) {
      try {
         ru.metaculture.protection.WildClient.speedVal();
         Renderer2D var2 = ru.metaculture.protection.WildClient.primaryVal();
         if (var2 == null) {
            return;
         }

         GLStateSnapshot.secondaryVal(this.timerVal);

         try {
            var2.primaryVal(var1.widthVal(), var1.chunkVal());
            float var3 = primaryVal(var1.widthVal(), var1.chunkVal());
            float var4 = tertiaryVal(secondaryVal(this.descRef / 0.82F, 0.0F, 1.0F));
            float var5 = var1.widthVal() * 0.5F + var1.stageVal() * 0.12F;
            float var6 = var1.chunkVal() * 0.126F + var1.widthRef() * 0.08F;
            var2.primaryVal(FontRegistry.marginVal, var5, var6, 40.0F * var3, "Proxy", this.primaryVal(0.94F * var4), "c");
            var2.primaryVal(
               FontRegistry.primaryVal, var5, var6 + 30.0F * var3, 24.0F * var3, this.speedRef + "  /  " + this.countRef, this.secondaryVal(0.52F * var4), "c"
            );

            for (ProxyScreen.VvunVVUvUNnv var8 : this.speedVal) {
               this.primaryVal(var2, var8, var3);
            }

            for (ProxyScreen.cursorVal var15 : this.widthVal) {
               this.primaryVal(var2, var15, var3);
            }

            this.primaryVal(var2, var1, var3);
            var2.secondaryVal();
         } finally {
            GLStateSnapshot.tertiaryVal(this.timerVal);
         }
      } catch (Throwable var13) {
      }
   }

   private void primaryVal(Renderer2D var1, VvVVnnNNNuV.LicenseValidator var2, float var3) {
      String var4 = this.limitVal();
      if (!var4.isBlank()) {
         float var5 = 25.0F * var3;
         float var6 = var2.widthVal() * 0.5F;
         float var7 = var2.chunkVal() - 30.0F * var3;
         var1.primaryVal(FontRegistry.primaryVal, var6, var7, var5, var4, this.secondaryVal(0.4F * var2.levelVal()), "c");
      }
   }

   private void primaryVal(Renderer2D var1, ProxyScreen.VvunVVUvUNnv var2, float var3) {
      float var4 = var2.depthVal;
      String var5 = var2.descRef ? "*".repeat(var2.factorVal.length()) : var2.factorVal;
      boolean var6 = var5.isBlank();
      float var7 = 22.0F * var3;
      float var8 = var2.weightVal + var7;
      float var9 = Math.max(8.0F * var3, var2.extraVal - var7 * 2.0F);
      float var10 = 25.0F * var3;
      boolean var11 = var6 && !var2.extraRef;
      String var12 = var11 ? var2.primaryVal : var5;
      int var13 = var11 ? this.secondaryVal(0.42F * var4) : this.primaryVal((0.78F + var2.limitRef * 0.18F) * var4);
      if (!var6 || var2.extraRef) {
         var1.primaryVal(
            FontRegistry.primaryVal,
            var2.weightVal + 18.0F * var3,
            var2.paramVal - 7.0F * var3,
            20.0F * var3,
            var2.primaryVal,
            this.secondaryVal((0.3F + var2.limitRef * 0.28F) * var4)
         );
      }

      var1.primaryVal(
         var8,
         var2.paramVal + 3.0F * var3,
         var9,
         var2.limitVal - 6.0F * var3,
         var2.speedVal * 0.55F,
         var2.speedVal * 0.55F,
         var2.speedVal * 0.55F,
         var2.speedVal * 0.55F
      );
      if (!var12.isBlank()) {
         if (var11) {
            primaryVal(var1, FontRegistry.primaryVal, var2.weightVal, var2.paramVal, var2.extraVal, var2.limitVal, var10, var12, var13);
         } else {
            float var14 = primaryVal(FontRegistry.primaryVal, var10, var2.paramVal, var2.limitVal);
            if (var2.phaseVal) {
               float var15 = Renderer2D.primaryVal(FontRegistry.primaryVal, var12, var10).primaryVal;
               var1.primaryVal(
                  marginVal(var8 - var2.groupVal - 2.0F * var3),
                  var2.paramVal + var2.limitVal * 0.25F,
                  var15 + 4.0F * var3,
                  var2.limitVal * 0.5F,
                  2.0F * var3,
                  primaryVal(0.25F, 0.55F, 0.95F, 0.45F * var4)
               );
            }

            var1.primaryVal(FontRegistry.primaryVal, marginVal(var8 - var2.groupVal), marginVal(var14), var10, var12, var13);
         }
      }

      if (var2.extraRef) {
         int var24 = primaryVal(var2.sourceVal, 0, var5.length());
         String var25 = var5.substring(0, var24);
         float var16 = Renderer2D.primaryVal(FontRegistry.primaryVal, var25, var10).primaryVal;
         if (var2.phaseVal) {
            var16 = Renderer2D.primaryVal(FontRegistry.primaryVal, var5, var10).primaryVal;
         }

         float var17 = var2.groupVal;
         float var18 = var9 - 9.0F * var3;
         if (var16 - var17 > var18) {
            var17 = var16 - var18;
         }

         if (var16 - var17 < 0.0F) {
            var17 = var16;
         }

         var17 = Math.max(0.0F, var17);
         var2.groupVal = var2.groupVal + (var17 - var2.groupVal) * 0.3F;
         var2.paramRef = var2.paramRef + (var16 - var2.paramRef) * 0.3F;
         float var19 = 0.54F + 0.46F * (float)Math.sin(this.descRef * 5.4F);
         if (!var2.phaseVal) {
            int var20 = primaryVal(this.angleVal, this.modeRef, var19, (0.42F + var19 * 0.36F) * var4);
            float var21 = var8 + var2.paramRef - var2.groupVal + 2.0F * var3;
            float var22 = 20.0F * var3;
            float var23 = var2.paramVal + (var2.limitVal - var22) * 0.5F;
            var1.primaryVal(marginVal(var21), marginVal(var23), Math.max(1.25F * var3, 1.0F), var22, 1.0F * var3, var20);
         }

         var1.primaryVal(
            var2.weightVal,
            var2.paramVal,
            var2.extraVal,
            var2.limitVal,
            var2.speedVal,
            primaryVal(this.angleVal, this.modeRef, var19, 0.24F * var4 * (0.35F + var2.limitRef * 0.65F)),
            1.0F * var3
         );
      }

      var1.paramVal();
   }

   private void primaryVal(Renderer2D var1, ProxyScreen.cursorVal var2, float var3) {
      float var4 = var2.depthVal * 0.9F;
      String var5 = primaryVal(var2.primaryVal, var2.extraVal - 18.0F * var3, 24.0F * var3, FontRegistry.primaryVal);
      primaryVal(var1, FontRegistry.primaryVal, var2.weightVal, var2.paramVal, var2.extraVal, var2.limitVal, 24.0F * var3, var5, this.primaryVal(var4));
   }

   private String secondaryVal(ProxyScreen.WildClient var1) {
      return switch (var1) {
         case TYPE -> this.speedRef;
         case ENABLED -> this.depthRef ? "Enabled" : "Disabled";
         case PASTE -> "Paste";
         case TEST -> "Test";
         case SAVE -> "Save";
         case BACK -> "Back";
      };
   }

   private String limitVal() {
      String var1 = this.weightVal.factorVal.trim();
      String var2 = this.paramVal.factorVal.trim();
      if (var1.isBlank() || var2.isBlank()) {
         return "";
      } else {
         return "Socks5".equals(this.speedRef) && !this.extraVal.factorVal.isBlank()
            ? this.extraVal.factorVal + ":" + "*".repeat(Math.min(10, this.limitVal.factorVal.length())) + "@" + var1 + ":" + var2
            : var1 + ":" + var2;
      }
   }

   private int primaryVal(float var1) {
      return this.levelVal ? primaryVal(0.1F, 0.1F, 0.1F, var1) : primaryVal(1.0F, 1.0F, 1.0F, var1);
   }

   private int secondaryVal(float var1) {
      return this.levelVal ? primaryVal(0.4F, 0.4F, 0.4F, var1) : primaryVal(0.8F, 0.86F, 0.9F, var1);
   }

   private static void primaryVal(Renderer2D var0, FontObject var1, float var2, float var3, float var4, float var5, float var6, String var7, int var8) {
      String var9 = var7 == null ? "" : var7;
      float var10 = Renderer2D.primaryVal(var1, var9, var6).primaryVal;
      float var11 = marginVal(var2 + (var4 - var10) * 0.5F);
      float var12 = marginVal(primaryVal(var1, var6, var3, var5));
      var0.primaryVal(var1, var11, var12, var6, var9, var8);
   }

   private float primaryVal(class_1041 var1, double var2) {
      return (float)(var2 * var1.method_4489() / Math.max(1.0, var1.method_4486()));
   }

   private float secondaryVal(class_1041 var1, double var2) {
      return (float)(var2 * var1.method_4506() / Math.max(1.0, var1.method_4502()));
   }

   private static float primaryVal(FontObject var0, float var1, float var2, float var3) {
      try {
         return var2 + var3 * 0.5F + FontRegistry.primaryVal(var0, 72, var1 * 0.5F);
      } catch (Throwable var5) {
         return var2 + var3 * 0.5F + var1 * 0.18F;
      }
   }

   private static String primaryVal(String var0, float var1, float var2, FontObject var3) {
      if (var0 == null) {
         return "";
      }

      if (var1 <= 0.0F) {
         return "";
      }

      if (Renderer2D.primaryVal(var3, var0, var2).primaryVal <= var1) {
         return var0;
      }

      String var4 = "...";
      if (Renderer2D.primaryVal(var3, var4, var2).primaryVal > var1) {
         return "";
      }

      int var5 = 1;
      int var6 = var0.length();
      int var7 = 1;

      while (var5 <= var6) {
         int var8 = var5 + var6 >>> 1;
         if (Renderer2D.primaryVal(var3, var0.substring(0, var8) + var4, var2).primaryVal <= var1) {
            var7 = var8;
            var5 = var8 + 1;
         } else {
            var6 = var8 - 1;
         }
      }

      return var0.substring(0, var7) + var4;
   }

   private static float primaryVal(float var0, float var1) {
      return secondaryVal(Math.min(var0 / 1920.0F, var1 / 1080.0F) * 1.16F, 0.72F, 1.34F);
   }

   static float primaryVal(float var0, float var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = var2 + var4 * 0.5F;
      float var8 = var3 + var5 * 0.5F;
      float var9 = var4 * 0.5F - var6;
      float var10 = var5 * 0.5F - var6;
      float var11 = Math.abs(var0 - var7) - var9;
      float var12 = Math.abs(var1 - var8) - var10;
      float var13 = Math.max(var11, 0.0F);
      float var14 = Math.max(var12, 0.0F);
      return (float)Math.sqrt(var13 * var13 + var14 * var14) + Math.min(Math.max(var11, var12), 0.0F) - var6;
   }

   private static float secondaryVal(float var0, float var1) {
      return (float)Math.sqrt(var0 * var0 + var1 * var1);
   }

   private static float tertiaryVal(float var0) {
      float var1 = secondaryVal(var0, 0.0F, 1.0F);
      return var1 * var1 * var1 * (var1 * (var1 * 6.0F - 15.0F) + 10.0F);
   }

   private static float secondaryVal(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   static int primaryVal(int var0, int var1, int var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   private static float marginVal(float var0) {
      return Math.round(var0);
   }

   private static float secondaryVal(int var0) {
      return (var0 >> 16 & 0xFF) / 255.0F;
   }

   private static float tertiaryVal(int var0) {
      return (var0 >> 8 & 0xFF) / 255.0F;
   }

   private static float marginVal(int var0) {
      return (var0 & 0xFF) / 255.0F;
   }

   private static int primaryVal(float var0, float var1, float var2, float var3) {
      int var4 = Math.round(secondaryVal(var0, 0.0F, 1.0F) * 255.0F);
      int var5 = Math.round(secondaryVal(var1, 0.0F, 1.0F) * 255.0F);
      int var6 = Math.round(secondaryVal(var2, 0.0F, 1.0F) * 255.0F);
      int var7 = Math.round(secondaryVal(var3, 0.0F, 1.0F) * 255.0F);
      return var7 << 24 | var4 << 16 | var5 << 8 | var6;
   }

   private static int primaryVal(int var0, int var1, float var2, float var3) {
      float var4 = secondaryVal(var2, 0.0F, 1.0F);
      int var5 = ColorUtil.marginVal(var0, var1, var4);
      int var6 = Math.round(secondaryVal(var3, 0.0F, 1.0F) * 255.0F);
      return var6 << 24 | var5;
   }

   enum WildClient {
      TYPE,
      ENABLED,
      PASTE,
      TEST,
      SAVE,
      BACK;
   }

   static final class FingerprintCrypto {
      float primaryVal;
      float secondaryVal;
      float tertiaryVal = -100.0F;
      float marginVal;
   }

   static final class VvunVVUvUNnv extends ProxyScreen.AccessGuardException {
      final boolean descRef;
      private final int activeVal;
      private final ProxyScreen.DelayedFuse radiusVal;
      String factorVal = "";
      int sourceVal;
      boolean extraRef;
      boolean phaseVal;
      float limitRef;
      float paramRef;
      float groupVal;

      VvunVVUvUNnv(String var1, boolean var2, int var3, ProxyScreen.DelayedFuse var4) {
         super(var1);
         this.descRef = var2;
         this.activeVal = var3;
         this.radiusVal = var4;
      }

      void primaryVal(String var1) {
         this.factorVal = this.tertiaryVal(var1 == null ? "" : var1);
         if (this.factorVal.length() > this.activeVal) {
            this.factorVal = this.factorVal.substring(0, this.activeVal);
         }

         this.sourceVal = this.factorVal.length();
         this.phaseVal = false;
         this.paramRef = 0.0F;
         this.groupVal = 0.0F;
      }

      void secondaryVal(String var1) {
         String var2 = this.tertiaryVal(var1 == null ? "" : var1);
         if (!var2.isEmpty()) {
            if (this.phaseVal) {
               this.factorVal = "";
               this.sourceVal = 0;
               this.phaseVal = false;
            }

            int var3 = this.activeVal - this.factorVal.length();
            if (var3 > 0) {
               if (var2.length() > var3) {
                  var2 = var2.substring(0, var3);
               }

               int var4 = ProxyScreen.primaryVal(this.sourceVal, 0, this.factorVal.length());
               this.factorVal = this.factorVal.substring(0, var4) + var2 + this.factorVal.substring(var4);
               this.sourceVal = var4 + var2.length();
            }
         }
      }

      void secondaryVal() {
         if (this.phaseVal) {
            this.marginVal();
         } else if (this.sourceVal > 0 && !this.factorVal.isEmpty()) {
            int var1 = ProxyScreen.primaryVal(this.sourceVal, 0, this.factorVal.length());
            if (var1 > 0) {
               this.factorVal = this.factorVal.substring(0, var1 - 1) + this.factorVal.substring(var1);
               this.sourceVal = var1 - 1;
            }
         }
      }

      void tertiaryVal() {
         if (this.phaseVal) {
            this.marginVal();
         } else {
            int var1 = ProxyScreen.primaryVal(this.sourceVal, 0, this.factorVal.length());
            if (var1 < this.factorVal.length()) {
               this.factorVal = this.factorVal.substring(0, var1) + this.factorVal.substring(var1 + 1);
               this.sourceVal = var1;
            }
         }
      }

      private void marginVal() {
         this.factorVal = "";
         this.sourceVal = 0;
         this.paramRef = 0.0F;
         this.groupVal = 0.0F;
         this.phaseVal = false;
      }

      void weightVal() {
         this.primaryVal();
         this.extraRef = false;
         this.phaseVal = false;
         this.limitRef = 0.0F;
         this.paramRef = 0.0F;
         this.groupVal = 0.0F;
         this.sourceVal = ProxyScreen.primaryVal(this.sourceVal, 0, this.factorVal.length());
      }

      private String tertiaryVal(String var1) {
         StringBuilder var2 = new StringBuilder(var1.length());

         for (int var3 = 0; var3 < var1.length(); var3++) {
            char var4 = var1.charAt(var3);
            if (var4 >= ' '
               && var4 != 127
               && (this.radiusVal != ProxyScreen.DelayedFuse.PORT || var4 >= '0' && var4 <= '9')
               && (this.radiusVal != ProxyScreen.DelayedFuse.HOST && this.radiusVal != ProxyScreen.DelayedFuse.TEXT || !Character.isWhitespace(var4))) {
               var2.append(var4);
            }
         }

         return var2.toString();
      }
   }

   static class AccessGuardException {
      protected String primaryVal;
      protected final SpringInterpolator secondaryVal = new SpringInterpolator(SpringConfig.weightVal());
      protected float tertiaryVal;
      protected float marginVal;
      protected float weightVal;
      protected float paramVal;
      protected float extraVal;
      protected float limitVal;
      protected float speedVal;
      protected float widthVal;
      protected float chunkVal;
      protected float blockRef;
      protected float holderVal;
      protected float timerVal = 1.0F;
      protected float anchorVal = 0.5F;
      protected float weightRef = 0.5F;
      protected float bufferVal;
      protected float countVal;
      protected float depthVal;

      protected AccessGuardException(String var1) {
         this.primaryVal = var1;
      }

      protected boolean primaryVal(float var1, float var2) {
         return ProxyScreen.primaryVal(var1, var2, this.tertiaryVal, this.marginVal, this.extraVal, this.limitVal, this.speedVal) <= 0.0F;
      }

      protected void primaryVal() {
         this.widthVal = 0.0F;
         this.chunkVal = 0.0F;
         this.blockRef = 0.0F;
         this.holderVal = 0.0F;
         this.bufferVal = 0.0F;
         this.depthVal = 0.0F;
         this.timerVal = 1.0F;
         this.anchorVal = 0.5F;
         this.weightRef = 0.5F;
         this.secondaryVal.primaryVal(1.0F);
      }
   }

   static final class cursorVal extends ProxyScreen.AccessGuardException {
      final ProxyScreen.WildClient descRef;

      cursorVal(String var1, ProxyScreen.WildClient var2) {
         super(var1);
         this.descRef = var2;
      }
   }

   enum DelayedFuse {
      HOST,
      PORT,
      TEXT,
      SECRET;
   }
}
