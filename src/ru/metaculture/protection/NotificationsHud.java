package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lombok.Generated;
import net.minecraft.class_1044;
import net.minecraft.class_1074;
import net.minecraft.class_10868;
import net.minecraft.class_124;
import net.minecraft.class_1293;
import net.minecraft.class_1304;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_2960;
import net.minecraft.class_408;
import net.minecraft.class_9334;

@HudElementInfo(primaryVal = "Notifications", secondaryVal = "w")
public final class NotificationsHud extends ThemeSettings {
   public static final String primaryVal = "Modules";
   public static final String limitRef = "Item swap";
   public static final String paramRef = "Effects";
   public static final String groupVal = "Low HP";
   public static final String layerVal = "Warnings";
   public static final String slotVal = "Armor breaking";
   private static final NotificationsHud themeVal = new NotificationsHud();
   private static final List<NotificationsHud.WildClient> stageVal = new ArrayList<>();
   private static final Map<String, NotificationsHud.cursorVal> widthRef = new HashMap<>();
   private static final AnimatedDouble trackVal = new AnimatedDouble();
   private static final float modeRef = 40.0F;
   private static final float angleVal = 22.0F;
   private static final float heightRef = 28.0F;
   private static final float levelVal = 8.0F;
   private static final int UuNnnVnuNNV = 5;
   private static final float depthRef = 220.0F;
   private static final class_1304[] speedRef = new class_1304[]{class_1304.field_6166, class_1304.field_6172, class_1304.field_6174, class_1304.field_6169};
   private static final int[] countRef = new int[]{100, 100, 100, 100};
   private static final class_1792[] entryVal = new class_1792[4];
   private static final String guardVal = "Swapped to » ";
   private static final String VUuuVUnun = "About to break » ";
   private static final class_2960 vVVuuVVv = class_2960.method_60655("minecraft", "textures/gui/sprites/hud/heart/full.png");
   private static float VuunNUUUvu = Float.NaN;
   private static boolean NNUUNUuVNNVn;
   private final SettingGroup VvVvnNUnvuvV = new SettingGroup(
      "Show",
      new BoolSetting("Modules", true),
      new BoolSetting("Item swap", true),
      new BoolSetting("Effects", true),
      new BoolSetting("Low HP", true),
      new BoolSetting("Warnings", true),
      new BoolSetting("Armor breaking", true)
   );

   private NotificationsHud() {
      this.primaryVal(this.VvVvnNUnvuvV);
      HudSettingsPersistence.primaryVal(this);
   }

   public static NotificationsHud secondaryVal() {
      return themeVal;
   }

   public static boolean marginVal(String var0) {
      return themeVal.VvVvnNUnvuvV.secondaryVal(var0);
   }

   public static void weightRef() {
      if (MinecraftAccessor.a_.field_1724 != null && MinecraftAccessor.a_.field_1687 != null) {
         if (marginVal("Effects")) {
            bufferVal();
         } else {
            widthRef.clear();
         }

         if (marginVal("Low HP")) {
            descRef();
         } else {
            NNUUNUuVNNVn = false;
         }

         if (marginVal("Armor breaking")) {
            countVal();
         } else {
            depthVal();
         }
      } else {
         widthRef.clear();
         NNUUNUuVNNVn = false;
         depthVal();
      }
   }

   public static void primaryVal(String var0, String var1, long var2) {
      primaryVal(var0, var1, var2, "Warnings");
   }

   public static void primaryVal(String var0, String var1, long var2, String var4) {
      if (marginVal(var4)) {
         stageVal.add(new NotificationsHud.WildClient(var0, var1, var2));
      }
   }

   public static void primaryVal(class_1799 var0, String var1, long var2) {
      if (marginVal("Item swap")) {
         String var4 = weightVal(var1);
         if ((var4 == null || var4.isEmpty()) && var0 != null && !var0.method_7960()) {
            var4 = weightVal(var0.method_7964().getString());
         }

         if (var4 == null || var4.isEmpty()) {
            var4 = "item";
         }

         int var5 = paramVal(var1);
         if (var5 == 0 && var0 != null && var0.method_57826(class_9334.field_49631)) {
            var5 = paramVal(var0.method_7964().getString());
         }

         String var6 = "Swapped to » " + var4;
         if (var0 != null && !var0.method_7960()) {
            stageVal.add(
               new NotificationsHud.WildClient(var0.method_7972(), var6, "Swapped to » ".length(), var5, var2)
            );
         } else {
            NotificationsHud.WildClient var7 = new NotificationsHud.WildClient("i", var6, var2);
            var7.limitVal = "Swapped to » ".length();
            var7.speedVal = var5;
            stageVal.add(var7);
         }
      }
   }

   public static void primaryVal(String var0, String var1) {
      if (marginVal("Effects")) {
         stageVal.add(
            new NotificationsHud.WildClient(
               extraVal(var0), var1 + " » About to run out", 2200L
            )
         );
      }
   }

   public static void secondaryVal(String var0, String var1) {
      if (marginVal("Effects")) {
         stageVal.add(new NotificationsHud.WildClient(extraVal(var0), "Expired » " + var1, 2200L));
      }
   }

   public static void primaryVal(class_1799 var0, int var1) {
      if (marginVal("Armor breaking") && var0 != null && !var0.method_7960()) {
         String var2 = "About to break » " + var1 + "%";
         int var3 = ColorUtil.tertiaryVal(255, 70, 70, 255);
         stageVal.add(
            new NotificationsHud.WildClient(
               var0.method_7972(), var2, "About to break » ".length(), var3, 2600L
            )
         );
      }
   }

   public static void primaryVal(String var0, boolean var1) {
      if (marginVal("Modules")) {
         for (NotificationsHud.WildClient var3 : stageVal) {
            if (var3.marginVal() && var3.paramVal().equals(var0)) {
               var3.secondaryVal(var1);
               var3.primaryVal(System.currentTimeMillis());
               return;
            }
         }

         stageVal.add(new NotificationsHud.WildClient(var0, var1, 1000L));
      }
   }

   public static void primaryVal(Renderer2D var0) {
      themeVal.secondaryVal(var0);
   }

   private void secondaryVal(Renderer2D var1) {
      if (MinecraftAccessor.a_.field_1724 != null) {
         boolean var2 = MinecraftAccessor.a_.field_1755 instanceof class_408;
         stageVal.removeIf(var0 -> {
            var0.anchorVal().primaryVal();
            return var0.tertiaryVal() && var0.anchorVal().weightVal() <= 0.01F;
         });
         trackVal.primaryVal();
         trackVal.primaryVal(stageVal.isEmpty() && var2 ? 1.0 : 0.0, 0.22F, Easings.timerVal, false);
         float var3 = trackVal.weightVal();
         float var4 = 38.0F;
         float var5 = 5.0F;
         float var6 = 28.0F;
         if (stageVal.isEmpty()) {
            if (!(var3 <= 0.01F)) {
               String var23 = "Set the position";
               float var24 = 24.0F;
               float var26 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var23, var24).primaryVal;
               float var28 = var26 + 20.0F;
               int var30 = MinecraftAccessor.a_.method_22683().method_4489();
               int var31 = MinecraftAccessor.a_.method_22683().method_4506();
               float var32 = var31 / 2.0F + 140.0F;
               HudLayoutManager.cursorVal var33 = this.primaryVal(var4, var4, var32, var30, var31);
               float var34 = VuunNUUUvu - var28 * 0.5F;
               float var35 = var33.tertiaryVal;
               float var36 = var4;
               this.primaryVal(var34, var35, var28, var36);
               float var37 = this.depthVal.tertiaryVal() * var3;
               int var38 = this.weightVal(var37);
               float var20 = 12.0F;
               this.primaryVal(var1, var34, var35, var28, var36, var20, var37);
               String var21 = primaryVal(var23, var24, Math.max(0.0F, var28 - 20.0F));
               float var22 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var21, var24).primaryVal;
               var1.primaryVal(var34, var35, Math.max(1.0F, var28), Math.max(1.0F, var36), var20, var20, var20, var20);
               var1.primaryVal(FontRegistry.primaryVal, var34 + (var28 - var22) / 2.0F, var35 + var36 / 2.0F + 3.0F, var24, var21, var38);
               var1.paramVal();
               HudLayoutManager.primaryVal().primaryVal(var33);
               UuUuVnVvnvn.primaryVal(
                  var1, this, var33, HudLayoutManager.primaryVal(), MinecraftAccessor.a_.method_22683().method_4486(), MinecraftAccessor.a_.method_22683().method_4502()
               );
            }
         } else {
            float var7 = 0.0F;
            float var8 = 0.0F;

            for (NotificationsHud.WildClient var10 : stageVal) {
               float var11 = primaryVal(var10, var6);
               if (var11 > var7) {
                  var7 = var11;
               }

               var8 += (var4 + var5) * var10.anchorVal().weightVal();
            }

            int var25 = MinecraftAccessor.a_.method_22683().method_4489();
            int var27 = MinecraftAccessor.a_.method_22683().method_4506();
            float var29 = var27 / 2.0F + 140.0F;
            HudLayoutManager.cursorVal var12 = this.primaryVal(var8 > 0.0F ? var8 : var4, var4, var29, var25, var27);
            float var13 = var12.tertiaryVal;
            this.primaryVal(VuunNUUUvu - var7 * 0.5F, var13, var7, Math.max(var4, var12.weightVal));

            for (int var14 = stageVal.size() - 1; var14 >= 0; var14--) {
               NotificationsHud.WildClient var15 = stageVal.get(var14);
               boolean var16 = !var15.tertiaryVal();
               var15.anchorVal().primaryVal(var16 ? 1.0 : 0.0, 0.24F, Easings.timerVal, false);
               float var17 = var15.anchorVal().weightVal();
               if (!(var17 <= 0.01F)) {
                  float var18 = primaryVal(var15, var6);
                  float var19 = VuunNUUUvu - var18 * 0.5F;
                  this.primaryVal(var1, var19, var13, var18, var4, var17, var15, var6);
                  var13 += (var4 + var5) * var17;
               }
            }

            HudLayoutManager.primaryVal().primaryVal(var12);
            UuUuVnVvnvn.primaryVal(
               var1, this, var12, HudLayoutManager.primaryVal(), MinecraftAccessor.a_.method_22683().method_4486(), MinecraftAccessor.a_.method_22683().method_4502()
            );
         }
      }
   }

   private HudLayoutManager.cursorVal primaryVal(float var1, float var2, float var3, int var4, int var5) {
      if (!Float.isFinite(VuunNUUUvu)) {
         HudLayoutManager.FingerprintCrypto var6 = HudLayoutManager.primaryVal().weightVal().get("HUD_Notifications");
         if (var6 != null && var4 > 0) {
            VuunNUUUvu = var6.nx() * var4 + 110.0F;
         } else {
            VuunNUUUvu = var4 * 0.5F;
         }
      }

      float var8 = VuunNUUUvu - 110.0F;
      HudLayoutManager.cursorVal var7 = HudLayoutManager.primaryVal().primaryVal("HUD_Notifications", var8, var3, 220.0F, var1 > 0.0F ? var1 : var2);
      VuunNUUUvu = var7.secondaryVal + var7.marginVal * 0.5F;
      return var7;
   }

   private static float primaryVal(NotificationsHud.WildClient var0, float var1) {
      float var2 = TextMeasureCache.primaryVal(FontRegistry.primaryVal, var0.paramVal(), var1).primaryVal;
      return var0.marginVal() ? var2 + 20.0F + 5.0F + 40.0F : var2 + 20.0F + 5.0F + 28.0F;
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, float var6, NotificationsHud.WildClient var7, float var8) {
      float var9 = this.depthVal.tertiaryVal() * var6;
      int var10 = (int)(255.0F * var9);
      int var11 = this.primaryVal(var9);
      int var12 = this.marginVal(var9);
      int var13 = this.weightVal(var9);
      int var14 = this.extraVal(var9);
      float var15 = 14.0F;
      float var16 = 0.8F + 0.2F * var6;
      var1.primaryVal(var16, var2 + var4 / 2.0F, var3 + var5 / 2.0F);

      try {
         this.primaryVal(var1, var2, var3, var4, var5, var15, var9);
         var1.primaryVal(var2, var3, Math.max(1.0F, var4), Math.max(1.0F, var5), var15, var15, var15, var15);

         try {
            if (var7.marginVal()) {
               var7.weightRef().primaryVal();
               var7.weightRef().primaryVal(var7.extraVal() ? 1.0 : 0.0, 0.15F, Easings.timerVal, false);
               float var17 = var7.weightRef().weightVal();
               float var18 = var2 + 10.0F;
               float var19 = var2 + var4 - 10.0F;
               float var20 = Math.max(0.0F, var19 - var18);
               float var21 = Math.min(40.0F, var20);
               float var22 = Math.min(22.0F, Math.max(8.0F, var5 - 8.0F));
               float var23 = var19 - var21;
               float var24 = var3 + var5 / 2.0F - var22 / 2.0F;
               if (var21 >= 8.0F) {
                  if (!this.blockRef() && !this.holderVal()) {
                     if (!this.primaryVal(var23, var24, var21, var22, var22 / 2.0F, true, var9, 2)) {
                        var1.primaryVal(var23, var24, var21, var22, var22 / 2.0F, var11);
                     }
                  } else {
                     this.secondaryVal(var1, var23, var24, var21, var22, var22 / 2.0F, var9);
                  }

                  if (var17 > 0.01F) {
                     float var25 = 3.0F;
                     float var26 = Math.max(1.0F, var21 - var25 * 2.0F);
                     float var27 = Math.max(1.0F, var22 - var25 * 2.0F);
                     float var28 = Math.max(Math.min(var27, var26), var26 * var17);
                     float var29 = var27 / 2.0F;
                     var1.primaryVal(var23 + var25, var24 + var25, var26, var27, var29, var29, var29, var29);
                     var1.secondaryVal(var23 + var25, var24 + var25, var28, var27, var29, this.limitVal(var9), this.speedVal(var9));
                     var1.paramVal();
                  }

                  float var54 = Math.max(1.0F, Math.min(var22 - 4.0F, var21 - 4.0F) / 2.0F);
                  float var56 = var23 + 2.0F + var54 + Math.max(0.0F, var21 - var22) * var17;
                  float var58 = var24 + var22 / 2.0F;
                  boolean var60 = HudLayoutManager.primaryVal().speedVal()
                     && primaryVal(HudLayoutManager.primaryVal().extraVal(), HudLayoutManager.primaryVal().limitVal(), var23, var24, var21, var22);
                  if (!this.blockRef() && !this.holderVal()) {
                     if (!this.primaryVal(var56 - var54, var58 - var54, var54 * 2.0F, var54 * 2.0F, var54, var60, var9, var60 ? 2 : 1)) {
                        var1.secondaryVal(var56, var58, var54, 0.0F, 360.0F, ColorUtil.tertiaryVal(255, 255, 255, var10));
                     }
                  } else {
                     this.secondaryVal(var1, var56 - var54, var58 - var54, var54 * 2.0F, var54 * 2.0F, var54, var9);
                  }
               }

               float var55 = var18;
               float var57 = Math.max(0.0F, var23 - 5.0F - var55);
               String var59 = primaryVal(var7.paramVal(), var8, var57);
               if (!var59.isEmpty()) {
                  var1.primaryVal(FontRegistry.primaryVal, var55, primaryVal(var3, var5), var8, var59, var13);
               }
            } else {
               float var38 = var2 + 10.0F;
               float var39 = var3 + var5 * 0.5F;
               if (var7.primaryVal()) {
                  float var42 = Math.max(0.65F, (var5 - 10.0F) / 20.0F);
                  float var46 = 16.0F * var42;
                  float var50 = var38 + (28.0F - var46) * 0.5F;
                  float var52 = var39 - var46 * 0.5F;
                  var1.tertiaryVal();
                  NuNvVUuUUnun.primaryVal(var1, var7.limitVal(), var50, var52, var42, var7.speedVal(), false, 0);
               } else if (var7.secondaryVal()) {
                  float var41 = Math.max(14.0F, (var5 - 10.0F) * 0.62F);
                  float var45 = var38 + (28.0F - var41) * 0.5F;
                  float var49 = var39 - var41 * 0.5F;
                  primaryVal(var1, var7.widthVal(), var45, var49, var41, var9);
               } else {
                  int var40 = ColorUtil.primaryVal(var14, (int)(ColorUtil.primaryVal(var14) * var6));
                  String var44 = var7.weightVal();
                  float var48 = primaryVal(var3, var5);
                  if (var44.contains("on")) {
                     var1.primaryVal(FontRegistry.weightVal, var38, var48, 28.0F, "n", var40);
                  } else if (var44.contains("off")) {
                     var1.primaryVal(FontRegistry.weightVal, var38, var48, 28.0F, "l", var40);
                  } else if (var44.contains("warn") || var44.contains("gg")) {
                     var1.primaryVal(FontRegistry.paramVal, var38, var48 - 2.0F, 24.0F, var44.contains("warn") ? "i" : "y", var40);
                  } else if (var44.contains("cfg")) {
                     var1.primaryVal(FontRegistry.tertiaryVal, var38, var48 - 2.0F, 22.0F, "G", var40);
                  } else {
                     var1.primaryVal(FontRegistry.tertiaryVal, var38, var48, 28.0F, var44, var40);
                  }
               }

               float var43 = var38 + 28.0F + 5.0F;
               float var47 = Math.max(0.0F, var2 + var4 - 10.0F - var43);
               String var51 = primaryVal(var7.paramVal(), var8, var47);
               int var53 = Math.min(var7.chunkVal(), var51.length());
               primaryVal(var1, var43, primaryVal(var3, var5), var8, var51, var13, var53, var7.blockRef(), var9);
            }
         } finally {
            var1.paramVal();
         }
      } finally {
         var1.limitVal();
      }
   }

   private static float primaryVal(float var0, float var1) {
      return var0 + var1 * 0.5F + 5.0F;
   }

   private static void primaryVal(Renderer2D var0, float var1, float var2, float var3, String var4, int var5, int var6, int var7, float var8) {
      if (var4 != null && !var4.isEmpty()) {
         if (var7 != 0 && var6 > 0 && var6 < var4.length()) {
            String var9 = var4.substring(0, var6);
            String var10 = var4.substring(var6);
            if (!var9.isEmpty()) {
               var0.primaryVal(FontRegistry.primaryVal, var1, var2, var3, var9, var5);
            }

            float var11 = var9.isEmpty() ? 0.0F : TextMeasureCache.primaryVal(FontRegistry.primaryVal, var9, var3).primaryVal;
            int var12 = ColorUtil.primaryVal(var7, Math.round(ColorUtil.primaryVal(var7) * var8));
            if (!var10.isEmpty()) {
               var0.primaryVal(FontRegistry.primaryVal, var1 + var11, var2, var3, var10, var12);
            }
         } else {
            var0.primaryVal(FontRegistry.primaryVal, var1, var2, var3, var4, var5);
         }
      }
   }

   private static String primaryVal(String var0, float var1, float var2) {
      if (var0 != null && !var0.isEmpty() && !(var2 <= 1.0F)) {
         if (TextMeasureCache.primaryVal(FontRegistry.primaryVal, var0, var1).primaryVal <= var2) {
            return var0;
         }

         String var3 = "...";
         if (TextMeasureCache.primaryVal(FontRegistry.primaryVal, var3, var1).primaryVal > var2) {
            return "";
         }

         for (int var4 = var0.length(); var4 > 0; var4--) {
            String var5 = var0.substring(0, var4).trim() + var3;
            if (TextMeasureCache.primaryVal(FontRegistry.primaryVal, var5, var1).primaryVal <= var2) {
               return var5;
            }
         }

         return var3;
      } else {
         return "";
      }
   }

   private static boolean primaryVal(float var0, float var1, float var2, float var3, float var4, float var5) {
      return var0 >= var2 && var0 <= var2 + var4 && var1 >= var3 && var1 <= var3 + var5;
   }

   private static void bufferVal() {
      HashSet var0 = new HashSet();

      for (class_1293 var2 : MinecraftAccessor.a_.field_1724.method_6026()) {
         if (!RemovalsModule.primaryVal(var2.method_5579())) {
            String var3 = var2.method_5579().method_55840();
            var0.add(var3);
            NotificationsHud.cursorVal var4 = widthRef.computeIfAbsent(var3, var0x -> new NotificationsHud.cursorVal());
            var4.primaryVal = weightVal(class_1074.method_4662(var2.method_5586(), new Object[0]));
            if (var2.method_48559()) {
               var4.primaryVal();
            } else {
               int var5 = Math.max(0, (int)Math.ceil(var2.method_5584() / 20.0));
               primaryVal(var3, var4.primaryVal, var5, var4);
            }
         }
      }

      Iterator var6 = widthRef.entrySet().iterator();

      while (var6.hasNext()) {
         Entry var7 = (Entry)var6.next();
         if (!var0.contains(var7.getKey())) {
            String var8 = ((NotificationsHud.cursorVal)var7.getValue()).primaryVal;
            if (var8 != null && !var8.isEmpty()) {
               secondaryVal((String)var7.getKey(), var8);
            }

            var6.remove();
         }
      }
   }

   private static void primaryVal(String var0, String var1, int var2, NotificationsHud.cursorVal var3) {
      if (var2 > 5) {
         var3.primaryVal();
      } else {
         if (var2 >= 1 && !var3.secondaryVal) {
            var3.secondaryVal = true;
            primaryVal(var0, var1);
         }
      }
   }

   private static void countVal() {
      for (int var0 = 0; var0 < speedRef.length; var0++) {
         class_1799 var1 = MinecraftAccessor.a_.field_1724.method_6118(speedRef[var0]);
         if (var1 != null && !var1.method_7960() && var1.method_7963()) {
            if (entryVal[var0] != var1.method_7909()) {
               entryVal[var0] = var1.method_7909();
               countRef[var0] = 100;
            }

            int var2 = var1.method_7936();
            if (var2 > 0) {
               int var3 = var2 - var1.method_7919();
               int var4 = (int)Math.floor(var3 * 100.0 / var2);
               if (var4 > 30) {
                  countRef[var0] = 100;
               } else {
                  int var5 = var4 <= 10 ? 10 : (var4 <= 20 ? 20 : 30);
                  if (var5 < countRef[var0]) {
                     countRef[var0] = var5;
                     primaryVal(var1, var4);
                  }
               }
            }
         } else {
            countRef[var0] = 100;
            entryVal[var0] = null;
         }
      }
   }

   private static void depthVal() {
      for (int var0 = 0; var0 < countRef.length; var0++) {
         countRef[var0] = 100;
         entryVal[var0] = null;
      }
   }

   private static void descRef() {
      float var0 = MinecraftAccessor.a_.field_1724.method_6032() + MinecraftAccessor.a_.field_1724.method_6067();
      if (var0 <= 8.0F && var0 > 0.0F && !NNUUNUuVNNVn) {
         if (marginVal("Low HP")) {
            stageVal.add(new NotificationsHud.WildClient(vVVuuVVv, "Low HP » " + String.format("%.1f", var0), 2500L));
         }

         NNUUNUuVNNVn = true;
      } else {
         if (var0 > 10.0F) {
            NNUUNUuVNNVn = false;
         }
      }
   }

   private static String weightVal(String var0) {
      return var0 != null && !var0.isEmpty() ? var0.replaceAll("(?i)\\u0412?\\u00A7[0-9A-FK-OR]", "").replace("\u00a7", "").replace('\u00a0', ' ').trim() : "";
   }

   private static int paramVal(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         Integer var1 = null;

         for (int var2 = 0; var2 < var0.length(); var2++) {
            char var3 = var0.charAt(var2);
            if (var3 == 167 || var3 == '&') {
               if (var2 + 1 >= var0.length()) {
                  break;
               }

               if ((var0.charAt(var2 + 1) == 'x' || var0.charAt(var2 + 1) == 'X') && var2 + 13 < var0.length()) {
                  Integer var6 = primaryVal(var0, var2 + 2);
                  if (var6 != null) {
                     var1 = var6;
                  }

                  var2 += 13;
               } else {
                  class_124 var4 = class_124.method_544(var0.charAt(var2 + 1));
                  if (var4 != null) {
                     if (var4 == class_124.field_1070) {
                        var1 = null;
                     } else {
                        Integer var5 = var4.method_532();
                        if (var5 != null) {
                           var1 = 0xFF000000 | var5;
                        }
                     }
                  }
               }
            }
         }

         return var1 == null ? 0 : var1;
      } else {
         return 0;
      }
   }

   private static Integer primaryVal(String var0, int var1) {
      int var2 = 0;
      int var3 = 0;

      for (int var4 = var1; var4 < var0.length() && var3 < 6; var4++) {
         char var5 = var0.charAt(var4);
         if (var5 == 167 || var5 == '&') {
            if (++var4 >= var0.length()) {
               return null;
            }

            var5 = var0.charAt(var4);
         }

         int var6 = primaryVal(var5);
         if (var6 < 0) {
            return null;
         }

         var2 = var2 << 4 | var6;
         var3++;
      }

      return var3 == 6 ? 0xFF000000 | var2 : null;
   }

   private static int primaryVal(char var0) {
      if (var0 >= '0' && var0 <= '9') {
         return var0 - 48;
      } else if (var0 >= 'a' && var0 <= 'f') {
         return var0 - 97 + 10;
      } else {
         return var0 >= 65 && var0 <= 70 ? var0 - 65 + 10 : -1;
      }
   }

   private static class_2960 extraVal(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         int var1 = var0.indexOf(58);
         String var2 = var1 > 0 ? var0.substring(0, var1) : "minecraft";
         String var3 = var1 > 0 && var1 + 1 < var0.length() ? var0.substring(var1 + 1) : var0;
         return class_2960.method_60655(var2, "textures/mob_effect/" + var3 + ".png");
      } else {
         return class_2960.method_60655("minecraft", "textures/mob_effect/strength.png");
      }
   }

   private static void primaryVal(Renderer2D var0, class_2960 var1, float var2, float var3, float var4, float var5) {
      if (var0 != null && var1 != null && MinecraftAccessor.a_ != null && MinecraftAccessor.a_.method_1531() != null) {
         class_1044 var6 = MinecraftAccessor.a_.method_1531().method_4619(var1);
         if (var6 != null && var6.method_68004() instanceof class_10868 var7 && var7.method_68427() > 0) {
            var0.tertiaryVal();
            var0.weightVal(var5);
            var0.primaryVal(var7.method_68427(), var2, var3, var4, var4, 0.0F, 0.0F, 1.0F, 1.0F);
            var0.widthVal();
         }
      }
   }

   public static class WildClient {
      private boolean primaryVal;
      private String secondaryVal;
      private String tertiaryVal;
      private boolean marginVal;
      private class_1799 weightVal;
      private int paramVal;
      private class_2960 extraVal;
      int limitVal;
      int speedVal;
      private long widthVal;
      private long chunkVal;
      private AnimatedDouble blockRef = new AnimatedDouble();
      private AnimatedDouble holderVal = new AnimatedDouble();

      public WildClient(String var1, String var2, long var3) {
         this.primaryVal = false;
         this.secondaryVal = var1;
         this.tertiaryVal = var2;
         this.chunkVal = var3;
         this.widthVal = System.currentTimeMillis();
      }

      public WildClient(class_1799 var1, String var2, int var3, int var4, long var5) {
         this.primaryVal = false;
         this.weightVal = var1;
         this.paramVal = var1.hashCode();
         this.tertiaryVal = var2;
         this.limitVal = var3;
         this.speedVal = var4;
         this.chunkVal = var5;
         this.widthVal = System.currentTimeMillis();
      }

      public WildClient(class_2960 var1, String var2, long var3) {
         this.primaryVal = false;
         this.extraVal = var1;
         this.tertiaryVal = var2;
         this.chunkVal = var3;
         this.widthVal = System.currentTimeMillis();
      }

      public boolean primaryVal() {
         return this.weightVal != null && !this.weightVal.method_7960();
      }

      public boolean secondaryVal() {
         return this.extraVal != null;
      }

      public WildClient(String var1, boolean var2, long var3) {
         this.primaryVal = true;
         this.tertiaryVal = var1;
         this.marginVal = var2;
         this.chunkVal = var3;
         this.widthVal = System.currentTimeMillis();
         this.holderVal.paramVal(var2 ? 1.0 : 0.0);
      }

      public boolean tertiaryVal() {
         return System.currentTimeMillis() - this.widthVal > this.chunkVal;
      }

      @Generated
      public boolean marginVal() {
         return this.primaryVal;
      }

      @Generated
      public String weightVal() {
         return this.secondaryVal;
      }

      @Generated
      public String paramVal() {
         return this.tertiaryVal;
      }

      @Generated
      public boolean extraVal() {
         return this.marginVal;
      }

      @Generated
      public class_1799 limitVal() {
         return this.weightVal;
      }

      @Generated
      public int speedVal() {
         return this.paramVal;
      }

      @Generated
      public class_2960 widthVal() {
         return this.extraVal;
      }

      @Generated
      public int chunkVal() {
         return this.limitVal;
      }

      @Generated
      public int blockRef() {
         return this.speedVal;
      }

      @Generated
      public long holderVal() {
         return this.widthVal;
      }

      @Generated
      public long timerVal() {
         return this.chunkVal;
      }

      @Generated
      public AnimatedDouble anchorVal() {
         return this.blockRef;
      }

      @Generated
      public AnimatedDouble weightRef() {
         return this.holderVal;
      }

      @Generated
      public void primaryVal(boolean var1) {
         this.primaryVal = var1;
      }

      @Generated
      public void primaryVal(String var1) {
         this.secondaryVal = var1;
      }

      @Generated
      public void secondaryVal(String var1) {
         this.tertiaryVal = var1;
      }

      @Generated
      public void secondaryVal(boolean var1) {
         this.marginVal = var1;
      }

      @Generated
      public void primaryVal(class_1799 var1) {
         this.weightVal = var1;
      }

      @Generated
      public void primaryVal(int var1) {
         this.paramVal = var1;
      }

      @Generated
      public void primaryVal(class_2960 var1) {
         this.extraVal = var1;
      }

      @Generated
      public void secondaryVal(int var1) {
         this.limitVal = var1;
      }

      @Generated
      public void tertiaryVal(int var1) {
         this.speedVal = var1;
      }

      @Generated
      public void primaryVal(long var1) {
         this.widthVal = var1;
      }

      @Generated
      public void secondaryVal(long var1) {
         this.chunkVal = var1;
      }

      @Generated
      public void primaryVal(AnimatedDouble var1) {
         this.blockRef = var1;
      }

      @Generated
      public void secondaryVal(AnimatedDouble var1) {
         this.holderVal = var1;
      }

      @Generated
      @Override
      public boolean equals(Object var1) {
         if (var1 == this) {
            return true;
         } else if (!(var1 instanceof NotificationsHud.WildClient var2)) {
            return false;
         } else {
            if (!var2.primaryVal(this)) {
               return false;
            }

            if (this.marginVal() != var2.marginVal()) {
               return false;
            }

            if (this.extraVal() != var2.extraVal()) {
               return false;
            }

            if (this.speedVal() != var2.speedVal()) {
               return false;
            }

            if (this.chunkVal() != var2.chunkVal()) {
               return false;
            }

            if (this.blockRef() != var2.blockRef()) {
               return false;
            }

            if (this.holderVal() != var2.holderVal()) {
               return false;
            }

            if (this.timerVal() != var2.timerVal()) {
               return false;
            }

            String var3 = this.weightVal();
            String var4 = var2.weightVal();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               String var5 = this.paramVal();
               String var6 = var2.paramVal();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  class_1799 var7 = this.limitVal();
                  class_1799 var8 = var2.limitVal();
                  if (var7 == null ? var8 == null : var7.equals(var8)) {
                     class_2960 var9 = this.widthVal();
                     class_2960 var10 = var2.widthVal();
                     if (var9 == null ? var10 == null : var9.equals(var10)) {
                        AnimatedDouble var11 = this.anchorVal();
                        AnimatedDouble var12 = var2.anchorVal();
                        if (var11 == null ? var12 == null : var11.equals(var12)) {
                           AnimatedDouble var13 = this.weightRef();
                           AnimatedDouble var14 = var2.weightRef();
                           return var13 == null ? var14 == null : var13.equals(var14);
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
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
      }

      @Generated
      protected boolean primaryVal(Object var1) {
         return var1 instanceof NotificationsHud.WildClient;
      }

      @Generated
      @Override
      public int hashCode() {
         byte var1 = 59;
         int var2 = 1;
         var2 = var2 * 59 + (this.marginVal() ? 79 : 97);
         var2 = var2 * 59 + (this.extraVal() ? 79 : 97);
         var2 = var2 * 59 + this.speedVal();
         var2 = var2 * 59 + this.chunkVal();
         var2 = var2 * 59 + this.blockRef();
         long var3 = this.holderVal();
         var2 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
         long var5 = this.timerVal();
         var2 = var2 * 59 + (int)(var5 >>> 32 ^ var5);
         String var7 = this.weightVal();
         var2 = var2 * 59 + (var7 == null ? 43 : var7.hashCode());
         String var8 = this.paramVal();
         var2 = var2 * 59 + (var8 == null ? 43 : var8.hashCode());
         class_1799 var9 = this.limitVal();
         var2 = var2 * 59 + (var9 == null ? 43 : var9.hashCode());
         class_2960 var10 = this.widthVal();
         var2 = var2 * 59 + (var10 == null ? 43 : var10.hashCode());
         AnimatedDouble var11 = this.anchorVal();
         var2 = var2 * 59 + (var11 == null ? 43 : var11.hashCode());
         AnimatedDouble var12 = this.weightRef();
         return var2 * 59 + (var12 == null ? 43 : var12.hashCode());
      }

      @Generated
      @Override
      public String toString() {
         return "NotificationsHUD.Notification(isToggle="
            + this.marginVal()
            + ", icon="
            + this.weightVal()
            + ", text="
            + this.paramVal()
            + ", toggleState="
            + this.extraVal()
            + ", itemStack="
            + this.limitVal()
            + ", itemSeed="
            + this.speedVal()
            + ", textureIconId="
            + this.widthVal()
            + ", highlightStart="
            + this.chunkVal()
            + ", highlightColor="
            + this.blockRef()
            + ", createTime="
            + this.holderVal()
            + ", duration="
            + this.timerVal()
            + ", animation="
            + this.anchorVal()
            + ", toggleAnim="
            + this.weightRef()
            + ")";
      }
   }

   static final class cursorVal {
      String primaryVal = "";
      boolean secondaryVal;

      void primaryVal() {
         this.secondaryVal = false;
      }
   }
}
