package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_437;

public class AutoBuyScreen extends class_437 {
   private static volatile boolean primaryVal = false;
   private static final String[] secondaryVal = new String[]{"FunTime", "SpookyTime", "HolyWorld"};
   private static final String[] tertiaryVal = new String[]{"FT", "SP", "HW"};
   private final List<String> marginVal = Arrays.asList(
      "Sphere of Chaos",
      "Sphere of the Titan",
      "Sphere of Ares",
      "Sphere of the Beast",
      "Demon Talisman",
      "Punisher Talisman",
      "Crusher Helmet",
      "Crusher Chestplate",
      "Crusher Leggings",
      "Crusher Boots",
      "Crusher Sword",
      "Crusher Pickaxe",
      "Crusher Bow",
      "Crusher Crossbow",
      "Crusher Trident",
      "Crusher Mace",
      "Crusher Elytra",
      "Crusher Fishing Rod"
   );
   private final List<String> weightVal = Arrays.asList(
      "Explicit Dust",
      "Disorientation",
      "Rag",
      "Sphere Lockpick"
   );
   private final List<String> paramVal = ServerItemCatalog.primaryVal().stream().map(ServerItemCatalog.AccessGuardException::key).toList();
   private final List<AutoBuyScreen.WildClient> extraVal = new ArrayList<>();
   private final List<AutoBuyScreen.WildClient> limitVal = new ArrayList<>();
   private AutoBuyScreen.WildClient speedVal = null;
   private float widthVal = 0.0F;
   private float chunkVal = 0.0F;
   private float blockRef = 0.0F;
   private String holderVal = null;
   private float timerVal;
   private float anchorVal;
   private float weightRef;
   private float bufferVal;
   private final int countVal = Renderer2D.VvunVVUvUNnv.marginVal(21, 23, 30, 120);
   private final int depthVal = Renderer2D.VvunVVUvUNnv.marginVal(12, 43, 64, 150);
   private final int descRef = Renderer2D.VvunVVUvUNnv.marginVal(24, 88, 124, 255);
   private final int activeVal = Renderer2D.VvunVVUvUNnv.marginVal(0, 0, 0, 70);

   public AutoBuyScreen() {
      super(class_2561.method_43470("AutoBuy Panel"));
      this.secondaryVal();
      primaryVal();
   }

   private void secondaryVal() {
      this.extraVal.clear();
      this.limitVal.clear();
      AutoBuyModule.UuNnnVnuNNV.forEach((var1, var2) -> this.extraVal.add(new AutoBuyScreen.WildClient(var1, String.valueOf(var2))));
      AutoBuyModule.entryVal.forEach(var1 -> this.limitVal.add(new AutoBuyScreen.WildClient(var1, "")));
   }

   public static void primaryVal() {
      if (!primaryVal) {
         primaryVal = true;
         EventManager.register(
            new Object() {
               // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
               // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
               @Subscribe
               public void primaryVal(RenderHudEvent var1) {
                  class_310 var2 = var1.tertiaryVal();
                  if (var2 != null && var2.field_1755 instanceof AutoBuyScreen var3 && var2.method_22683() != null) {
                     int var12 = (int)(var2.field_1729.method_1603() * var2.method_22683().method_4486() / var2.method_22683().method_4489());
                     int var5 = (int)(var2.field_1729.method_1604() * var2.method_22683().method_4502() / var2.method_22683().method_4506());
                     GuiRippleEffect var6 = GuiRippleEffect.primaryVal();
                     boolean var7 = var6.primaryVal(var3) && var6.primaryVal(var2.method_22683().method_4489(), var2.method_22683().method_4506());
                     boolean var10 = false /* VF: Semaphore variable */;

                     try {
                        var10 = true;
                        var3.primaryVal(var1.marginVal(), var1.limitVal(), var12, var5);
                        var1.marginVal().tertiaryVal();
                        var10 = false;
                     } finally {
                        if (var10) {
                           if (var7) {
                              var6.tertiaryVal();
                           }
                        }
                     }

                     if (var7) {
                        var6.tertiaryVal();
                     }
                  }
               }
            }
         );
      }
   }

   public void method_25394(class_332 var1, int var2, int var3, float var4) {
      super.method_25394(var1, var2, var3, var4);
   }

   public void primaryVal(Renderer2D var1, class_332 var2, int var3, int var4) {
      AutoBuyModule var5 = (AutoBuyModule)ru.metaculture.protection.WildClient.primaryVal.secondaryVal.secondaryVal(AutoBuyModule.class);
      if (var5 != null && var5.enabled) {
         float var6 = (float)this.field_22787.method_22683().method_4489() / this.field_22787.method_22683().method_4486();
         float var7 = 350.0F;
         float var8 = 180.0F;
         float var9 = 15.0F;
         float var10 = var7 + var9 + var8;
         float var11 = 260.0F;
         float var12 = (this.field_22787.method_22683().method_4486() - var10) / 2.0F;
         float var13 = (this.field_22787.method_22683().method_4502() - var11) / 2.0F;
         var1.tertiaryVal(var6);
         float var14 = var12;
         float var15 = var13;
         var1.primaryVal(23.0F);
         var1.primaryVal((float)var14, var15, var7, var11, (float)6.0F, (float)this.countVal);
         var1.primaryVal(var14, var15, var7, var11, 6.0F, this.countVal);
         float var16 = var14 + var7 + var9;
         float var17 = var13;
         var1.primaryVal(23.0F);
         var1.primaryVal((float)var16, var17, var8, var11, (float)6.0F, (float)this.countVal);
         var1.primaryVal(var16, var17, var8, var11, 6.0F, this.countVal);
         float var18 = 13.0F;
         float var19 = Renderer2D.primaryVal(FontRegistry.marginVal, "D", var18).primaryVal;
         float var20 = Renderer2D.primaryVal(FontRegistry.primaryVal, "Autobuy |", var18).primaryVal;
         float var21 = var19 + 4.0F + var20 + 8.0F;

         for (String var25 : tertiaryVal) {
            var21 += Renderer2D.primaryVal(FontRegistry.marginVal, var25, var18).primaryVal + 12.0F;
         }

         var1.primaryVal(var14 + 10.0F, var15 + 10.0F, var21 + 10.0F, 24.0F, 6.0F, Renderer2D.VvunVVUvUNnv.marginVal(20, 20, 25, 200));
         var1.primaryVal(FontRegistry.marginVal, var14 + 18.0F, var15 + 15.0F, var18, "D", Renderer2D.VvunVVUvUNnv.marginVal(80, 90, 160, 255));
         var1.primaryVal(
            FontRegistry.primaryVal, var14 + 18.0F + var19 + 4.0F, var15 + 15.0F, var18, "Autobuy |", Renderer2D.VvunVVUvUNnv.marginVal(100, 100, 100, 255)
         );
         float var46 = var14 + 18.0F + var19 + 4.0F + var20 + 10.0F;

         for (int var47 = 0; var47 < secondaryVal.length; var47++) {
            boolean var49 = var5.radiusVal.tertiaryVal().equals(secondaryVal[var47]);
            var1.primaryVal(
               FontRegistry.marginVal, var46, var15 + 15.0F, var18, tertiaryVal[var47], var49 ? -1 : Renderer2D.VvunVVUvUNnv.marginVal(120, 120, 120, 255)
            );
            var46 += Renderer2D.primaryVal(FontRegistry.marginVal, tertiaryVal[var47], var18).primaryVal + 12.0F;
         }

         float var48 = Renderer2D.primaryVal(FontRegistry.primaryVal, "Autopars", var18).primaryVal;
         var1.primaryVal(var16 + 10.0F, var17 + 10.0F, var19 + 4.0F + var48 + 16.0F, 24.0F, 6.0F, Renderer2D.VvunVVUvUNnv.marginVal(20, 20, 25, 200));
         var1.primaryVal(FontRegistry.marginVal, var16 + 18.0F, var17 + 15.0F, var18, "D", Renderer2D.VvunVVUvUNnv.marginVal(80, 90, 160, 255));
         var1.primaryVal(
            FontRegistry.primaryVal, var16 + 18.0F + var19 + 4.0F, var17 + 15.0F, var18, "Autopars", Renderer2D.VvunVVUvUNnv.marginVal(100, 100, 100, 255)
         );
         float var50 = var15 + 45.0F;
         float var51 = var11 - 55.0F;
         float var26 = 160.0F;
         float var27 = 160.0F;
         float var28 = var14 + 10.0F;
         float var29 = var28 + var26 + 10.0F;
         float var30 = var16 + 10.0F;
         float var31 = var8 - 20.0F;
         var1.primaryVal(var28, var50, var26 + 10.0F + var27, var51, 6.0F, this.depthVal);
         var1.primaryVal(var30, var50, var31, var51, 6.0F, this.depthVal);
         List var32 = this.primaryVal(var5);
         var1.primaryVal(var28, var50, var26, var51, 8.0F, 8.0F, 8.0F, 8.0F);
         float var33 = 32.0F;
         float var34 = 8.0F;
         int var35 = (int)((var26 - 16.0F) / (var33 + var34));
         float var36 = var28 + 10.0F;
         float var37 = var50 + 10.0F + this.widthVal;

         for (int var38 = 0; var38 < var32.size(); var38++) {
            float var39 = var36 + var38 % var35 * (var33 + var34);
            float var40 = var37 + var38 / var35 * (var33 + var34);
            var1.primaryVal(var39, var40, var33, var33, 6.0F, this.activeVal);
            if (var2 != null) {
               VnuunNV.primaryVal(var2, (String)var32.get(var38), var39 + 8.0F, var40 + 8.0F);
            }
         }

         var1.paramVal();
         var1.primaryVal(var29, var50, var27, var51, 8.0F, 8.0F, 8.0F, 8.0F);
         float var52 = var50 + 10.0F + this.chunkVal;

         for (int var53 = this.extraVal.size() - 1; var53 >= 0; var53--) {
            AutoBuyScreen.WildClient var56 = this.extraVal.get(var53);
            var56.tertiaryVal.primaryVal();
            var56.tertiaryVal.primaryVal(var56.marginVal ? 0.0 : 1.0, 0.2F, Easings.timerVal, false);
            if (var56.marginVal && var56.tertiaryVal.weightVal() < 0.01F) {
               AutoBuyModule.UuNnnVnuNNV.remove(var56.primaryVal);
               this.extraVal.remove(var53);
            } else {
               float var41 = 46.0F * var56.tertiaryVal.weightVal();
               float var42 = var29 + 8.0F;
               var1.primaryVal(var42, var52, var27 - 16.0F, var41, 6.0F, this.descRef);
               var1.primaryVal(var42 + 6.0F, var52 + 6.0F, 34.0F, 34.0F, 4.0F, this.activeVal);
               if (var2 != null) {
                  VnuunNV.primaryVal(var2, var56.primaryVal, var42 + 15.0F, var52 + 15.0F);
               }

               var1.primaryVal(var42, var52, var27 - 16.0F, var41, 6.0F, 6.0F, 6.0F, 6.0F);
               var1.primaryVal(FontRegistry.primaryVal, var42 + 48.0F, var52 + 10.0F, var18, ServerItemCatalog.marginVal(var56.primaryVal), -1);
               var1.primaryVal(
                  FontRegistry.primaryVal,
                  var42 + 48.0F,
                  var52 + 26.0F,
                  11.0F,
                  "Price: ",
                  Renderer2D.VvunVVUvUNnv.marginVal(180, 180, 180, 255)
               );
               float var43 = var42 + 48.0F + Renderer2D.primaryVal(FontRegistry.primaryVal, "Price: ", 11.0F).primaryVal;
               boolean var44 = this.speedVal == var56;
               var1.primaryVal(var43, var52 + 24.0F, 60.0F, 16.0F, 4.0F, Renderer2D.VvunVVUvUNnv.marginVal(15, 20, 25, 200));
               if (var44) {
                  var1.primaryVal(var43, var52 + 24.0F, 60.0F, 16.0F, 4.0F, Renderer2D.VvunVVUvUNnv.marginVal(80, 150, 220, 255), 1.0F);
               }

               String var45 = var56.secondaryVal + (var44 && System.currentTimeMillis() % 1000L > 500L ? "_" : "");
               var1.primaryVal(FontRegistry.primaryVal, var43 + 4.0F, var52 + 26.0F, 11.0F, var45, -1);
               var1.paramVal();
               var52 += var41 + 8.0F;
            }
         }

         var1.paramVal();
         var1.primaryVal(var30, var50, var31, var51, 8.0F, 8.0F, 8.0F, 8.0F);
         if (this.limitVal.isEmpty()) {
            float var54 = var30 + var31 / 2.0F;
            var1.primaryVal(
               FontRegistry.primaryVal,
               var54
                  - Renderer2D.primaryVal(FontRegistry.primaryVal, "TO PARSE THE PRICE OF THE", 11.0F).primaryVal
                     / 2.0F,
               var50 + var51 / 2.0F - 18.0F,
               11.0F,
               "TO PARSE THE PRICE OF THE",
               Renderer2D.VvunVVUvUNnv.marginVal(80, 110, 130, 180)
            );
            var1.primaryVal(
               FontRegistry.primaryVal,
               var54 - Renderer2D.primaryVal(FontRegistry.primaryVal, "ITEM,", 11.0F).primaryVal / 2.0F,
               var50 + var51 / 2.0F - 4.0F,
               11.0F,
               "ITEM,",
               Renderer2D.VvunVVUvUNnv.marginVal(80, 110, 130, 180)
            );
            var1.primaryVal(
               FontRegistry.primaryVal,
               var54
                  - Renderer2D.primaryVal(
                           FontRegistry.primaryVal, "MOVE IT TO", 11.0F
                        )
                        .primaryVal
                     / 2.0F,
               var50 + var51 / 2.0F + 10.0F,
               11.0F,
               "MOVE IT TO",
               Renderer2D.VvunVVUvUNnv.marginVal(80, 110, 130, 180)
            );
            var1.primaryVal(
               FontRegistry.primaryVal,
               var54 - Renderer2D.primaryVal(FontRegistry.primaryVal, "ONE OF THE SLOTS", 11.0F).primaryVal / 2.0F,
               var50 + var51 / 2.0F + 24.0F,
               11.0F,
               "ONE OF THE SLOTS",
               Renderer2D.VvunVVUvUNnv.marginVal(80, 110, 130, 180)
            );
         } else {
            float var55 = var50 + 10.0F + this.blockRef;

            for (int var57 = this.limitVal.size() - 1; var57 >= 0; var57--) {
               AutoBuyScreen.WildClient var58 = this.limitVal.get(var57);
               var58.tertiaryVal.primaryVal();
               var58.tertiaryVal.primaryVal(var58.marginVal ? 0.0 : 1.0, 0.2F, Easings.timerVal, false);
               if (var58.marginVal && var58.tertiaryVal.weightVal() < 0.01F) {
                  AutoBuyModule.entryVal.remove(var58.primaryVal);
                  this.limitVal.remove(var57);
               } else {
                  float var59 = 46.0F * var58.tertiaryVal.weightVal();
                  float var60 = var30 + 8.0F;
                  var1.primaryVal(var60, var55, var31 - 16.0F, var59, 6.0F, this.descRef);
                  var1.primaryVal(var60 + 6.0F, var55 + 6.0F, 34.0F, 34.0F, 4.0F, this.activeVal);
                  if (var2 != null) {
                     VnuunNV.primaryVal(var2, var58.primaryVal, var60 + 15.0F, var55 + 15.0F);
                  }

                  var1.primaryVal(var60, var55, var31 - 16.0F, var59, 6.0F, 6.0F, 6.0F, 6.0F);
                  var1.primaryVal(FontRegistry.primaryVal, var60 + 48.0F, var55 + 17.0F, var18, ServerItemCatalog.marginVal(var58.primaryVal), -1);
                  var1.paramVal();
                  var55 += var59 + 8.0F;
               }
            }
         }

         var1.paramVal();
         if (this.holderVal != null) {
            var1.primaryVal(this.timerVal, this.anchorVal, 32.0F, 32.0F, 6.0F, Renderer2D.VvunVVUvUNnv.marginVal(255, 255, 255, 180));
            if (var2 != null) {
               VnuunNV.primaryVal(var2, this.holderVal, this.timerVal + 8.0F, this.anchorVal + 8.0F);
            }

            this.timerVal = var3 - this.weightRef;
            this.anchorVal = var4 - this.bufferVal;
         }

         var1.limitVal();
      } else {
         this.field_22787.method_1507(null);
      }
   }

   public boolean method_25402(double var1, double var3, int var5) {
      AutoBuyModule var6 = (AutoBuyModule)ru.metaculture.protection.WildClient.primaryVal.secondaryVal.secondaryVal(AutoBuyModule.class);
      float var7 = 350.0F;
      float var8 = 180.0F;
      float var9 = 15.0F;
      float var10 = var7 + var9 + var8;
      float var11 = 260.0F;
      float var12 = (this.field_22789 - var10) / 2.0F;
      float var13 = (this.field_22790 - var11) / 2.0F;
      float var14 = var12;
      float var15 = var13;
      float var16 = var14 + var7 + var9;
      float var17 = 13.0F;
      float var18 = Renderer2D.primaryVal(FontRegistry.marginVal, "Litka", var17).primaryVal;
      float var19 = Renderer2D.primaryVal(FontRegistry.primaryVal, "Autobuy |", var17).primaryVal;
      float var20 = var14 + 18.0F + var18 + 4.0F + var19 + 10.0F;

      for (int var21 = 0; var21 < secondaryVal.length; var21++) {
         float var22 = Renderer2D.primaryVal(FontRegistry.marginVal, tertiaryVal[var21], var17).primaryVal;
         if (var1 >= var20 - 4.0F && var1 <= var20 + var22 + 6.0F && var3 >= var15 + 10.0F && var3 <= var15 + 34.0F) {
            var6.radiusVal.weightVal = secondaryVal[var21];
            var6.radiusVal.limitVal = var6.radiusVal.marginVal.indexOf(secondaryVal[var21]);
            return true;
         }

         var20 += var22 + 12.0F;
      }

      float var38 = var15 + 45.0F;
      float var39 = var11 - 55.0F;
      float var23 = var14 + 10.0F;
      float var24 = 160.0F;
      float var25 = var23 + var24 + 10.0F;
      float var26 = 160.0F;
      float var27 = var16 + 10.0F;
      float var28 = var8 - 20.0F;
      if (var5 == 1) {
         if (var1 >= var25 && var1 <= var25 + var26 && var3 >= var38 && var3 <= var38 + var39) {
            float var29 = var38 + 10.0F + this.chunkVal;

            for (AutoBuyScreen.WildClient var31 : this.extraVal) {
               if (var3 >= var29 && var3 <= var29 + 46.0F) {
                  var31.marginVal = true;
                  return true;
               }

               var29 += 54.0F;
            }
         }

         if (var1 >= var27 && var1 <= var27 + var28 && var3 >= var38 && var3 <= var38 + var39) {
            float var40 = var38 + 10.0F + this.blockRef;

            for (AutoBuyScreen.WildClient var46 : this.limitVal) {
               if (var3 >= var40 && var3 <= var40 + 46.0F) {
                  var46.marginVal = true;
                  return true;
               }

               var40 += 54.0F;
            }
         }
      }

      this.speedVal = null;
      if (var5 == 0) {
         float var41 = var38 + 10.0F + this.chunkVal;

         for (AutoBuyScreen.WildClient var47 : this.extraVal) {
            if (var3 >= var41 + 24.0F && var3 <= var41 + 40.0F && var1 >= var25 + 48.0F && var1 <= var25 + 150.0F) {
               this.speedVal = var47;
               return true;
            }

            var41 += 54.0F;
         }
      }

      if (var5 == 0 && var1 >= var23 && var1 <= var23 + var24 && var3 >= var38 && var3 <= var38 + var39) {
         List var42 = this.primaryVal(var6);
         float var45 = 32.0F;
         float var48 = 8.0F;
         int var32 = (int)((var24 - 16.0F) / (var45 + var48));
         float var33 = var23 + 10.0F;
         float var34 = var38 + 10.0F + this.widthVal;

         for (int var35 = 0; var35 < var42.size(); var35++) {
            float var36 = var33 + var35 % var32 * (var45 + var48);
            float var37 = var34 + var35 / var32 * (var45 + var48);
            if (var1 >= var36 && var1 <= var36 + var45 && var3 >= var37 && var3 <= var37 + var45) {
               this.holderVal = (String)var42.get(var35);
               this.weightRef = (float)var1 - var36;
               this.bufferVal = (float)var3 - var37;
               this.timerVal = var36;
               this.anchorVal = var37;
               return true;
            }
         }
      }

      return super.method_25402(var1, var3, var5);
   }

   public boolean method_25406(double var1, double var3, int var5) {
      if (this.holderVal != null && var5 == 0) {
         float var6 = 350.0F;
         float var7 = 180.0F;
         float var8 = 15.0F;
         float var9 = var6 + var8 + var7;
         float var10 = 260.0F;
         float var11 = (this.field_22789 - var9) / 2.0F;
         float var12 = (this.field_22790 - var10) / 2.0F;
         float var13 = var12 + 45.0F;
         float var14 = var10 - 55.0F;
         float var15 = var11 + 10.0F + 160.0F + 10.0F;
         float var16 = 160.0F;
         float var17 = var11 + var6 + var8 + 10.0F;
         float var18 = var7 - 20.0F;
         if (var1 >= var15 && var1 <= var15 + var16 && var3 >= var13 && var3 <= var13 + var14) {
            if (this.extraVal.stream().noneMatch(var1x -> var1x.primaryVal.equals(this.holderVal))) {
               this.extraVal.add(new AutoBuyScreen.WildClient(this.holderVal, ""));
               AutoBuyModule.UuNnnVnuNNV.put(this.holderVal, 0L);
            }
         } else if (var1 >= var17
            && var1 <= var17 + var18
            && var3 >= var13
            && var3 <= var13 + var14
            && this.limitVal.stream().noneMatch(var1x -> var1x.primaryVal.equals(this.holderVal))) {
            this.limitVal.add(new AutoBuyScreen.WildClient(this.holderVal, ""));
            if (!AutoBuyModule.entryVal.contains(this.holderVal)) {
               AutoBuyModule.entryVal.add(this.holderVal);
            }
         }

         this.holderVal = null;
         return true;
      } else {
         return super.method_25406(var1, var3, var5);
      }
   }

   public boolean method_25401(double var1, double var3, double var5, double var7) {
      float var9 = 350.0F;
      float var10 = 180.0F;
      float var11 = 15.0F;
      float var12 = var9 + var11 + var10;
      float var13 = 260.0F;
      float var14 = (this.field_22789 - var12) / 2.0F;
      float var15 = (this.field_22790 - var13) / 2.0F;
      float var16 = var15 + 45.0F;
      float var17 = var13 - 55.0F;
      float var18 = var14 + 10.0F;
      float var19 = 160.0F;
      float var20 = var18 + var19 + 10.0F;
      float var21 = 160.0F;
      float var22 = var14 + var9 + var11 + 10.0F;
      float var23 = var10 - 20.0F;
      if (var1 >= var18 && var1 <= var18 + var19 && var3 >= var16 && var3 <= var16 + var17) {
         this.widthVal += (float)(var7 * 22.0);
         if (this.widthVal > 0.0F) {
            this.widthVal = 0.0F;
         }
      } else if (var1 >= var20 && var1 <= var20 + var21 && var3 >= var16 && var3 <= var16 + var17) {
         this.chunkVal += (float)(var7 * 22.0);
         if (this.chunkVal > 0.0F) {
            this.chunkVal = 0.0F;
         }
      } else if (var1 >= var22 && var1 <= var22 + var23 && var3 >= var16 && var3 <= var16 + var17) {
         this.blockRef += (float)(var7 * 22.0);
         if (this.blockRef > 0.0F) {
            this.blockRef = 0.0F;
         }
      }

      return super.method_25401(var1, var3, var5, var7);
   }

   public boolean method_25400(char var1, int var2) {
      if (this.speedVal != null && Character.isDigit(var1) && this.speedVal.secondaryVal.length() < 12) {
         this.speedVal.secondaryVal = this.speedVal.secondaryVal + var1;
         this.primaryVal(this.speedVal);
         return true;
      } else {
         return super.method_25400(var1, var2);
      }
   }

   public boolean method_25404(int var1, int var2, int var3) {
      if (this.speedVal != null) {
         if (var1 == 259 && !this.speedVal.secondaryVal.isEmpty()) {
            this.speedVal.secondaryVal = this.speedVal.secondaryVal.substring(0, this.speedVal.secondaryVal.length() - 1);
            this.primaryVal(this.speedVal);
            return true;
         }

         if (var1 == 257 || var1 == 256) {
            this.speedVal = null;
            return true;
         }
      }

      return super.method_25404(var1, var2, var3);
   }

   private List<String> primaryVal(AutoBuyModule var1) {
      if (var1.radiusVal.tertiaryVal().equals("SpookyTime")) {
         return this.weightVal;
      } else {
         return var1.radiusVal.tertiaryVal().equals("HolyWorld") ? this.paramVal : this.marginVal;
      }
   }

   private void primaryVal(AutoBuyScreen.WildClient var1) {
      try {
         if (this.extraVal.contains(var1)) {
            long var2 = var1.secondaryVal.isEmpty() ? 0L : Long.parseLong(var1.secondaryVal);
            AutoBuyModule.UuNnnVnuNNV.put(var1.primaryVal, var2);
         }

         if (ru.metaculture.protection.WildClient.primaryVal.holderVal != null) {
            ru.metaculture.protection.WildClient.primaryVal.holderVal.tertiaryVal();
         }
      } catch (Exception var4) {
      }
   }

   public boolean method_25421() {
      return false;
   }

   class WildClient {
      String primaryVal;
      String secondaryVal;
      AnimatedDouble tertiaryVal = new AnimatedDouble();
      boolean marginVal = false;

      WildClient(String var2, String var3) {
         this.primaryVal = var2;
         this.secondaryVal = var3;
      }
   }
}
