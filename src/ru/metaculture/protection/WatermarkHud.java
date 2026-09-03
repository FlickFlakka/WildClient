package ru.metaculture.protection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ru.metaculture.profile.Profile;

@HudElementInfo(primaryVal = "WaterMark", secondaryVal = "w")
public final class WatermarkHud extends ThemeSettings {
   private static final WatermarkHud primaryVal = new WatermarkHud();
   private static final AnimatedDouble limitRef = new AnimatedDouble();
   private static int paramRef = 0;
   private final SimpleDateFormat groupVal = new SimpleDateFormat("HH:mm");
   private final Map<String, AnimatedDouble> layerVal = new HashMap<>();
   private final List<WatermarkHud.WildClient> slotVal = new ArrayList<>(4);
   private final SettingGroup themeVal = new SettingGroup(
      "Display",
      new BoolSetting("Username", true),
      new BoolSetting("UID", true),
      new BoolSetting("FPS", true),
      new BoolSetting("Time", true)
   );
   private float stageVal = 0.0F;
   private float widthRef = 0.0F;
   private float trackVal = 0.0F;
   private float modeRef = 0.0F;

   private WatermarkHud() {
      this.primaryVal(this.themeVal);
      HudSettingsPersistence.primaryVal(this);
   }

   public static WatermarkHud secondaryVal() {
      return primaryVal;
   }

   public static void primaryVal(Renderer2D var0) {
      primaryVal.secondaryVal(var0);
   }

   private boolean primaryVal(float var1, float var2, float var3, float var4, float var5, float var6) {
      return var1 >= var3 && var1 <= var3 + var5 && var2 >= var4 && var2 <= var4 + var6;
   }

   private void primaryVal(String var1, String var2, String var3, String var4, List<WatermarkHud.WildClient> var5) {
      AnimatedDouble var6 = this.layerVal.computeIfAbsent(var1, var0 -> new AnimatedDouble());
      var6.primaryVal();
      var6.primaryVal(this.themeVal.secondaryVal(var1) ? 1.0 : 0.0, 0.2F, Easings.timerVal, false);
      if (var6.weightVal() > 0.01F) {
         WatermarkHud.WildClient var7 = new WatermarkHud.WildClient(var1, var2, var3, var4);
         var7.paramVal = var6.weightVal();
         var5.add(var7);
      }
   }

   public void secondaryVal(Renderer2D var1) {
      if (MinecraftAccessor.a_.field_1724 != null) {
         limitRef.primaryVal();
         limitRef.primaryVal(1.0, 0.22F, Easings.timerVal, false);
         float var2 = limitRef.weightVal();
         if (!(var2 <= 0.01F)) {
            float var3 = HudLayoutManager.primaryVal().extraVal();
            float var4 = HudLayoutManager.primaryVal().limitVal();
            boolean var5 = HudLayoutManager.primaryVal().widthVal();
            boolean var6 = HudLayoutManager.primaryVal().speedVal();
            String var7 = HudLayoutManager.primaryVal().chunkVal();
            if (this.trackVal > 0.0F && this.primaryVal(var3, var4, this.stageVal, this.widthRef, this.trackVal, this.modeRef) && var7 == null) {
               if (var5) {
                  MinecraftAccessor.a_.field_1774.method_1455(Profile.getUsername());
               }

               if (var6) {
                  HudLayoutManager.primaryVal().secondaryVal();
               }
            }

            int var8 = MinecraftAccessor.a_.method_47599();
            paramRef = paramRef + (int)((var8 - paramRef) * UuvVnuU.paramVal(0.2F));
            int var9 = Profile.getUid();
            boolean var10 = HudModule.holderVal();
            HudElementRegistry.WildClient var11 = var10 ? HudElementRegistry.primaryVal("HUD_WaterMark") : null;
            float var12 = var10 ? var11.blockRef : 24.0F;
            float var13 = var10 ? var11.holderVal : 24.0F;
            float var14 = var10 ? var11.limitVal : 7.0F;
            float var15 = 10.0F;
            float var16 = var10 ? var11.speedVal : 5.0F;
            float var17 = var10 ? var11.chunkVal : 32.0F;
            this.slotVal.clear();
            List<WatermarkHud.WildClient> var18 = this.slotVal;
            this.primaryVal("Username", "r", Profile.getUsername(), "", var18);
            this.primaryVal("FPS", "u", String.valueOf(paramRef), "fps", var18);
            this.primaryVal("Time", "y", this.groupVal.format(System.currentTimeMillis()), "", var18);
            this.primaryVal("UID", "t", String.valueOf(var9), "uid", var18);
            float var19 = 32.0F;
            float var20 = var14 + var19;

            for (WatermarkHud.WildClient var22 : var18) {
               float var23 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var22.tertiaryVal, var12).primaryVal;
               float var24 = var22.marginVal.isEmpty() ? 0.0F : TextMeasureCache.primaryVal(FontRegistry.primaryVal, var22.marginVal, var12).primaryVal;
               float var25 = TextMeasureCache.primaryVal(FontRegistry.limitVal, var22.secondaryVal, var13).primaryVal;
               float var26 = var25 + 8.0F + var23 + var24 + var15 * 2.0F;
               var22.weightVal = var26 * var22.paramVal;
               var20 += var16 * var22.paramVal + var22.weightVal;
            }

            var20 += var14;
            float var59 = var17 + var14 * 2.0F;
            HudLayoutManager.cursorVal var60 = HudLayoutManager.primaryVal().primaryVal("HUD_WaterMark", 10.0F, 10.0F, var20, var59);
            float var61 = var60.secondaryVal;
            float var62 = var60.tertiaryVal;
            float var63 = var60.marginVal;
            float var64 = var60.weightVal;
            this.primaryVal(var61, var62, var63, var64);
            float var27 = var63 / Math.max(1.0F, var20);
            float var28 = var64 / Math.max(1.0F, var59);
            float var29 = Math.min(var27, var28);
            float var30 = var14 * var27;
            float var31 = var14 * var28;
            float var32 = var16 * var27;
            float var33 = var19 * var27;
            float var34 = var17 * var28;
            float var35 = var2 * this.depthVal.tertiaryVal();
            int var36 = this.secondaryVal(var35);
            int var37 = this.marginVal(var35);
            int var38 = this.weightVal(var35);
            int var39 = this.extraVal(var35);
            float var40 = var10 ? var11.primaryVal : 14.0F;
            this.primaryVal(var1, var61, var62, var63, var64, var40, var35);
            float var41 = var61 + var30;
            float var42 = var62 + var31;
            if (this.blockRef() || this.holderVal()) {
               this.secondaryVal(var1, var41, var42, var33, var34, 11.0F, var35);
            } else if (!this.primaryVal(var41, var42, var33, var34, 11.0F, false, var35, 1)) {
               var1.primaryVal(var41, var42, var33, var34, 11.0F, 4.0F, 4.0F, 11.0F, var36);
               if (this.weightVal()) {
                  var1.primaryVal(var41, var42, var33, var34, 11.0F, 4.0F, 4.0F, 11.0F, var37, Math.max(1.0F, this.tertiaryVal() * 0.65F));
               }
            }

            float var43 = (var10 ? var11.holderVal : 26.0F) * var29;
            float var44 = TextMeasureCache.primaryVal(FontRegistry.limitVal, "w", var43).primaryVal;
            var1.primaryVal(FontRegistry.limitVal, var41 + (var33 - var44) / 2.0F, var42 + var34 / 2.0F + 5.5F * var28, var43, "w", var39);
            float var45 = var41 + var33;

            for (int var46 = 0; var46 < var18.size(); var46++) {
               WatermarkHud.WildClient var47 = (WatermarkHud.WildClient)var18.get(var46);
               var45 += var32 * var47.paramVal;
               float var48 = var47.weightVal * var27;
               boolean var49 = var46 == var18.size() - 1;
               if (var47.primaryVal.equals("Username")) {
                  this.stageVal = var45;
                  this.widthRef = var42;
                  this.trackVal = var48;
                  this.modeRef = var34;
               }

               int var50 = ColorUtil.primaryVal(var36, (int)(ColorUtil.primaryVal(var36) * var47.paramVal));
               int var51 = ColorUtil.primaryVal(var39, (int)(ColorUtil.primaryVal(var39) * var47.paramVal));
               int var52 = ColorUtil.primaryVal(var38, (int)(ColorUtil.primaryVal(var38) * var47.paramVal));
               boolean var53 = var47.primaryVal.equals("Username") && var6 && var7 == null && this.primaryVal(var3, var4, var45, var42, var48, var34);
               if (!this.blockRef() && !this.holderVal()) {
                  if (!this.primaryVal(var45, var42, var48, var34, 11.0F, var53, var35 * var47.paramVal, var53 ? 2 : 1)) {
                     var1.primaryVal(var45, var42, var48, var34, 4.0F, var49 ? 11.0F : 4.0F, var49 ? 11.0F : 4.0F, 4.0F, var50);
                  }
               } else {
                  this.secondaryVal(var1, var45, var42, var48, var34, 11.0F, var35 * var47.paramVal);
               }

               var1.primaryVal(var45, var42, var48, var34, 4.0F, var49 ? 11.0F : 4.0F, var49 ? 11.0F : 4.0F, 4.0F);
               float var54 = var45 + var15 * var27;
               float var55 = var42 + var34 / 2.0F + 4.5F * var28;
               float var56 = var13 * var29;
               float var57 = var12 * var29;
               var1.primaryVal(FontRegistry.limitVal, var54, var55 + 1.0F * var28, var56, var47.secondaryVal, var51);
               var54 += TextMeasureCache.primaryVal(FontRegistry.limitVal, var47.secondaryVal, var56).primaryVal + 5.0F * var27;
               var1.primaryVal(FontRegistry.primaryVal, var54, var55, var57, var47.tertiaryVal, var52);
               if (!var47.marginVal.isEmpty()) {
                  var54 += TextMeasureCache.primaryVal(FontRegistry.primaryVal, var47.tertiaryVal, var57).primaryVal;
                  var1.primaryVal(FontRegistry.primaryVal, var54, var55, var57, var47.marginVal, var51);
               }

               var1.paramVal();
               var45 += var48;
            }

            HudLayoutManager.primaryVal().primaryVal(var60);
            UuUuVnVvnvn.primaryVal(
               var1, this, var60, HudLayoutManager.primaryVal(), MinecraftAccessor.a_.method_22683().method_4486(), MinecraftAccessor.a_.method_22683().method_4502()
            );
         }
      }
   }

   static class WildClient {
      final String primaryVal;
      final String secondaryVal;
      final String tertiaryVal;
      final String marginVal;
      float weightVal;
      float paramVal = 1.0F;

      WildClient(String var1, String var2, String var3, String var4) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
      }
   }
}
