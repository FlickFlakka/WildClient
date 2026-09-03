package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import net.minecraft.class_1661;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_3675;
import net.minecraft.class_408;

@HudElementInfo(primaryVal = "ServerHelper", secondaryVal = "w")
public final class ServerHelperHud extends ThemeSettings {
   private static final ServerHelperHud primaryVal = new ServerHelperHud();
   private static final class_310 limitRef = class_310.method_1551();
   private static final AnimatedDouble paramRef = new AnimatedDouble();
   private static final AnimatedDouble groupVal = new AnimatedDouble();
   private static final AnimatedDouble layerVal = new AnimatedDouble();
   private static final AnimatedDouble slotVal = new AnimatedDouble();
   private static final Map<String, AnimatedDouble> themeVal = new HashMap<>();
   static final Map<class_1792, class_1799> stageVal = new HashMap<>();
   private static final Map<Integer, String> widthRef = new HashMap<>();
   private static boolean trackVal;
   private final BoolSetting modeRef = new BoolSetting("Show keybinds", true);
   private final List<ServerHelperHud.cursorVal> angleVal = new ArrayList<>(12);
   private final List<ServerHelperHud.cursorVal> heightRef = new ArrayList<>(12);
   private final List<ServerHelperHud.WildClient> levelVal = new ArrayList<>(12);

   private ServerHelperHud() {
      this.primaryVal(this.modeRef);
      HudSettingsPersistence.primaryVal(this);
   }

   private void primaryVal(List<ServerHelperHud.cursorVal> var1, class_1792 var2, int var3) {
      this.primaryVal(var1, var2.method_7876(), var2, var1x -> var1x.method_31574(var2), var3);
   }

   private void primaryVal(List<ServerHelperHud.cursorVal> var1, String var2, class_1792 var3, Predicate<class_1799> var4, int var5) {
      boolean var6 = var5 != -1 && var5 != 0;
      String var7 = var6 ? primaryVal(var5) : "";
      var1.add(new ServerHelperHud.cursorVal(var2, var3, var4, var7, var6));
   }

   private static String primaryVal(int var0) {
      String var1 = widthRef.get(var0);
      if (var1 != null) {
         return var1;
      }

      String var2 = var0 > 0 ? class_3675.method_15985(var0, -1).method_1441() : "";
      String var3 = ServerHelperModule.countVal.primaryVal(var0, var2);
      widthRef.put(var0, var3);
      return var3;
   }

   private List<ServerHelperHud.cursorVal> weightRef() {
      this.angleVal.clear();
      List var1 = this.angleVal;
      ServerHelperModule var2 = ServerHelperModule.countVal;
      if (var2 == null) {
         return var1;
      }

      if (var2.depthVal.secondaryVal("FunTime")) {
         this.primaryVal(
            var1,
            "ft_disorientation",
            class_1802.field_8449,
            var2.primaryVal(SpecialItemUtil::limitRef, "Disorientation"),
            var2.radiusVal.tertiaryVal()
         );
         this.primaryVal(
            var1,
            "ft_light_dust",
            class_1802.field_8479,
            var2.primaryVal(SpecialItemUtil::phaseVal, "Explicit Dust"),
            var2.factorVal.tertiaryVal()
         );
         this.primaryVal(
            var1, "ft_trap", class_1802.field_22021, var2.primaryVal(SpecialItemUtil::paramRef, "Rag"), var2.phaseVal.tertiaryVal()
         );
         this.primaryVal(
            var1,
            "ft_freezing_snowball",
            class_1802.field_8543,
            var2.primaryVal(SpecialItemUtil::vVVuuVVv, "Freezing Snowball"),
            var2.limitRef.tertiaryVal()
         );
         this.primaryVal(
            var1,
            "ft_gods_aura",
            class_1802.field_8614,
            var2.primaryVal(SpecialItemUtil::VuunNUUUvu, "Divine Aura"),
            var2.sourceVal.tertiaryVal()
         );
         this.primaryVal(
            var1, "ft_plast", class_1802.field_8551, var2.primaryVal(SpecialItemUtil::layerVal, "Layer"), var2.extraRef.tertiaryVal()
         );
         this.primaryVal(
            var1,
            "ft_potion_assassin",
            class_1802.field_8436,
            var2.primaryVal(SpecialItemUtil::depthVal, "Assassin's Potion"),
            var2.paramRef.tertiaryVal()
         );
         this.primaryVal(
            var1,
            "ft_potion_paladin",
            class_1802.field_8436,
            var2.primaryVal(
               SpecialItemUtil::factorVal,
               "Paladin's Potion",
               "Paladin's Potion"
            ),
            var2.groupVal.tertiaryVal()
         );
         this.primaryVal(
            var1,
            "ft_potion_sleep",
            class_1802.field_8436,
            var2.primaryVal(SpecialItemUtil::extraRef, "Sleeping Potion"),
            var2.layerVal.tertiaryVal()
         );
         this.primaryVal(
            var1,
            "ft_potion_wrath",
            class_1802.field_8436,
            var2.primaryVal(SpecialItemUtil::descRef, "Potion of Wrath"),
            var2.slotVal.tertiaryVal()
         );
         this.primaryVal(
            var1,
            "ft_potion_holy_water",
            class_1802.field_8436,
            var2.primaryVal(SpecialItemUtil::radiusVal, "Holy Water"),
            var2.themeVal.tertiaryVal()
         );
         this.primaryVal(
            var1,
            "ft_potion_radiation",
            class_1802.field_8436,
            var2.primaryVal(SpecialItemUtil::sourceVal, "Radiation Potion"),
            var2.stageVal.tertiaryVal()
         );
         this.primaryVal(
            var1,
            "ft_potion_hlopushka",
            class_1802.field_8436,
            var2.primaryVal(SpecialItemUtil::activeVal, "Firecracker"),
            var2.widthRef.tertiaryVal()
         );
      } else if (var2.depthVal.secondaryVal("HolyWorld")) {
         this.primaryVal(var1, "hw_trap", class_1802.field_8882, ServerItemCatalog::primaryVal, var2.modeRef.tertiaryVal());
         this.primaryVal(var1, "hw_freezing_snowball", class_1802.field_8543, ServerItemCatalog::secondaryVal, var2.angleVal.tertiaryVal());
         this.primaryVal(var1, "hw_stan", class_1802.field_8137, ServerItemCatalog::tertiaryVal, var2.heightRef.tertiaryVal());
         this.primaryVal(var1, "hw_explosive_trap", class_1802.field_8662, ServerItemCatalog::marginVal, var2.levelVal.tertiaryVal());
      }

      this.primaryVal(
         var1, "utility_shulker", class_1802.field_8545, var0 -> var0.method_7909().toString().contains("shulker_box"), var2.UuNnnVnuNNV.tertiaryVal()
      );
      this.primaryVal(var1, class_1802.field_49098, var2.depthRef.tertiaryVal());
      this.primaryVal(var1, class_1802.field_8233, var2.entryVal.tertiaryVal());
      return var1;
   }

   public static ServerHelperHud secondaryVal() {
      return primaryVal;
   }

   public static void primaryVal(Renderer2D var0, class_332 var1) {
      primaryVal.secondaryVal(var0, var1);
   }

   private void secondaryVal(Renderer2D var1, class_332 var2) {
      if (limitRef.field_1724 != null) {
         List<ServerHelperHud.cursorVal> var3 = this.weightRef();
         this.heightRef.clear();
         List<ServerHelperHud.cursorVal> var4 = this.heightRef;

         for (ServerHelperHud.cursorVal var6 : var3) {
            AnimatedDouble var7 = themeVal.computeIfAbsent(var6.primaryVal, var0 -> new AnimatedDouble());
            var7.primaryVal();
            var7.primaryVal(var6.weightVal ? 1.0 : 0.0, 0.2F, Easings.timerVal, false);
            if (var7.weightVal() > 0.001F || var6.weightVal) {
               var4.add(var6);
            }
         }

         boolean var65 = limitRef.field_1755 instanceof class_408;
         boolean var66 = !var4.isEmpty() || var65;
         paramRef.primaryVal();
         groupVal.primaryVal();
         paramRef.primaryVal(var66 ? 1.0 : 0.0, 0.18F, Easings.timerVal, false);
         if (var66) {
            if (!trackVal) {
               groupVal.paramVal(-10.0);
            }

            groupVal.primaryVal(0.0, 0.2F, Easings.timerVal, false);
         } else {
            if (trackVal) {
               groupVal.paramVal(0.0);
            }

            groupVal.primaryVal(10.0, 0.2F, Easings.timerVal, false);
         }

         trackVal = var66;
         float var67 = paramRef.weightVal();
         if (!(var67 <= 0.01F)) {
            float var8 = 7.0F;
            float var9 = 46.0F;
            float var10 = 5.0F;
            float var11 = 0.0F;
            boolean var12 = true;

            for (ServerHelperHud.cursorVal var14 : var4) {
               float var15 = themeVal.get(var14.primaryVal).weightVal();
               if (!(var15 <= 0.01F)) {
                  if (!var12) {
                     var11 += var10 * var15;
                  }

                  var11 += var9 * var15;
                  var12 = false;
               }
            }

            if (var4.isEmpty()) {
               var11 = var9;
            }

            float var69 = var11 + var8 * 2.0F;
            float var70 = var9 + var8 * 2.0F;
            layerVal.primaryVal();
            slotVal.primaryVal();
            layerVal.primaryVal(var69, 0.18F, Easings.timerVal, false);
            slotVal.primaryVal(var70, 0.18F, Easings.timerVal, false);
            float var71 = layerVal.weightVal();
            float var16 = slotVal.weightVal();
            float var17 = limitRef.method_22683().method_4489();
            float var18 = limitRef.method_22683().method_4506();
            float var19 = (var17 - var71) / 2.0F;
            float var20 = var18 - var16 - 60.0F;
            HudLayoutManager.cursorVal var21 = HudLayoutManager.primaryVal().primaryVal("HUD_ServerHelper", var19, var20, var71, var16);
            float var22 = var21.secondaryVal + groupVal.weightVal();
            float var23 = var21.tertiaryVal;
            float var24 = var21.marginVal;
            float var25 = var21.weightVal;
            this.primaryVal(var22, var23, var24, var25);
            float var26 = var24 / Math.max(1.0F, var71);
            float var27 = var25 / Math.max(1.0F, var16);
            float var28 = Math.min(var26, var27);
            float var29 = var9 * var28;
            float var30 = var10 * var26;
            float var31 = var11 * var26;
            float var32 = var67 * this.depthVal.tertiaryVal();
            float var33 = this.widthVal(var32);
            int var34 = this.primaryVal(var32);
            int var35 = this.marginVal(var32);
            boolean var36 = this.chunkVal();
            float var37 = 14.0F;
            this.primaryVal(var1, var22, var23, var24, var25, var37, var32);
            var1.primaryVal(var22, var23, var24, var25, var37, var37, var37, var37);
            float var38 = var23 + (var25 - var29) / 2.0F;
            float var39 = var22 + (var24 - var31) / 2.0F;
            this.levelVal.clear();
            var12 = true;

            for (ServerHelperHud.cursorVal var41 : var4) {
               float var42 = themeVal.get(var41.primaryVal).weightVal();
               if (!(var42 <= 0.01F)) {
                  if (!var12) {
                     var39 += var30 * var42;
                  }

                  var12 = false;
                  float var43 = var39;
                  int var44 = (int)(255.0F * var32 * var42);
                  int var45 = this.widthVal() ? ColorUtil.tertiaryVal(255, 255, 255, (int)(5.0F * var33 * var42)) : this.secondaryVal(var33 * var42);
                  float var46 = (1.0F - var42) * 8.0F * var27;
                  float var47 = var38 + var46;
                  if (!var36 && !this.blockRef() && !this.holderVal()) {
                     var1.primaryVal(var43, var47, var29, var29, 6.0F * var28, var45);
                  } else {
                     this.secondaryVal(var1, var43, var47, var29, var29, 6.0F * var28, var32 * var42);
                  }

                  class_1661 var48 = limitRef.field_1724.method_31548();
                  class_1799 var49 = var41.primaryVal.startsWith("ft_potion_") ? var41.paramVal : null;
                  int var50 = 0;
                  int var51 = 0;

                  for (int var52 = var48.method_5439(); var51 < var52; var51++) {
                     class_1799 var53 = var48.method_5438(var51);
                     if (!var53.method_7960() && var41.primaryVal(var53)) {
                        var50 += var53.method_7947();
                        if (var49 == null) {
                           var49 = var53;
                        }
                     }
                  }

                  if (var49 == null) {
                     var49 = var41.paramVal;
                  }

                  if (this.modeRef.tertiaryVal()) {
                     var51 = this.paramVal(var32 * var42);
                     var1.primaryVal(FontRegistry.marginVal, var43 + 4.0F * var26, var47 + 12.0F * var27, 16.0F * var28, var41.marginVal, var51);
                  }

                  float var82 = 1.3F * var28;
                  float var83 = 16.0F * var82;
                  float var84 = var43 + (var29 - var83) / 2.0F;
                  float var54 = var47 + (var29 - var83) / 2.0F;
                  String var55 = String.valueOf(var50);
                  int var56 = var50 > 0 ? ColorUtil.tertiaryVal(200, 200, 200, var44) : ColorUtil.tertiaryVal(255, 60, 60, var44);
                  float var57 = (this.modeRef.tertiaryVal() ? 18.0F : 23.0F) * var28;
                  float var58 = TextMeasureCache.primaryVal(FontRegistry.marginVal, var55, var57).primaryVal;
                  float var59 = this.modeRef.tertiaryVal() ? 4.0F : 5.0F;
                  long var60 = CoolDownsHud.primaryVal(var41.secondaryVal);
                  String var62 = var60 > 0L ? primaryVal(var60) : "";
                  float var63 = primaryVal(var62, 20.0F * var28, var29 - 6.0F * var26, var28);
                  float var64 = var62.isEmpty() ? 0.0F : TextMeasureCache.secondaryVal(FontRegistry.marginVal, var62, var63);
                  this.levelVal
                     .add(
                        new ServerHelperHud.WildClient(
                           var49,
                           var43,
                           var47,
                           var29,
                           6.0F * var28,
                           var84,
                           var54,
                           var82,
                           var32 * var42,
                           var43 + var29 - var58 - 4.0F * var26,
                           var47 + var29 - var59 * var27,
                           var57,
                           var55,
                           var56,
                           var62,
                           var43 + (var29 - var64) * 0.5F,
                           var47 + var29 * 0.5F + 5.0F * var28,
                           var63,
                           ColorUtil.primaryVal(this.extraVal(var32 * var42), var44)
                        )
                     );
                  var39 += var29 * var42;
               }
            }

            var1.tertiaryVal();

            for (int var72 = 0; var72 < this.levelVal.size(); var72++) {
               ServerHelperHud.WildClient var74 = this.levelVal.get(var72);
               if (var74.alpha >= 0.35F) {
                  NuNvVUuUUnun.primaryVal(var1, var74.stack, var74.itemX, var74.itemY, var74.itemScale, var72, false, 0);
               }
            }

            var1.tertiaryVal();
            boolean var73 = false;

            for (int var75 = 0; var75 < this.levelVal.size(); var75++) {
               if (this.levelVal.get(var75).hasCooldown()) {
                  var73 = true;
                  break;
               }
            }

            if (var73) {
               var1.primaryVal(18.0F);

               for (ServerHelperHud.WildClient var78 : this.levelVal) {
                  if (var78.hasCooldown()) {
                     var1.primaryVal(var78.slotX, var78.slotY, var78.slotSize, var78.slotSize, var78.slotRadius, var78.alpha);
                     var1.primaryVal(
                        var78.slotX, var78.slotY, var78.slotSize, var78.slotSize, var78.slotRadius, ColorUtil.tertiaryVal(0, 0, 0, (int)(116.0F * var78.alpha))
                     );
                  }
               }
            }

            for (ServerHelperHud.WildClient var79 : this.levelVal) {
               if (var79.hasCooldown()) {
                  int var80 = ColorUtil.tertiaryVal(0, 0, 0, (int)(130.0F * var79.alpha));
                  var1.primaryVal(FontRegistry.marginVal, var79.cooldownX + 1.0F, var79.cooldownY + 1.0F, var79.cooldownFont, var79.cooldown, var80);
                  var1.primaryVal(FontRegistry.marginVal, var79.cooldownX, var79.cooldownY, var79.cooldownFont, var79.cooldown, var79.cooldownColor);
               } else {
                  var1.primaryVal(FontRegistry.marginVal, var79.countX, var79.countY, var79.countFont, var79.count, var79.countColor);
               }
            }

            var1.tertiaryVal();
            var1.paramVal();
            HudLayoutManager.primaryVal().primaryVal(var21);
            UuUuVnVvnvn.primaryVal(var1, this, var21, HudLayoutManager.primaryVal(), limitRef.method_22683().method_4486(), limitRef.method_22683().method_4502());
         }
      }
   }

   private static String primaryVal(long var0) {
      int var2 = Math.max(1, (int)Math.ceil(var0 / 1000.0));
      return var2 + "sec";
   }

   private static float primaryVal(String var0, float var1, float var2, float var3) {
      if (var0 != null && !var0.isEmpty()) {
         float var4 = TextMeasureCache.secondaryVal(FontRegistry.marginVal, var0, var1);
         return var4 <= var2 ? var1 : Math.max(12.0F * var3, var1 * var2 / Math.max(1.0F, var4));
      } else {
         return var1;
      }
   }

   record WildClient(
      class_1799 stack,
      float slotX,
      float slotY,
      float slotSize,
      float slotRadius,
      float itemX,
      float itemY,
      float itemScale,
      float alpha,
      float countX,
      float countY,
      float countFont,
      String count,
      int countColor,
      String cooldown,
      float cooldownX,
      float cooldownY,
      float cooldownFont,
      int cooldownColor
   ) {

      boolean hasCooldown() {
         return this.cooldown != null && !this.cooldown.isEmpty();
      }
   }

   static class cursorVal {
      final String primaryVal;
      final class_1792 secondaryVal;
      final Predicate<class_1799> tertiaryVal;
      final String marginVal;
      final boolean weightVal;
      final class_1799 paramVal;

      cursorVal(String var1, class_1792 var2, Predicate<class_1799> var3, String var4, boolean var5) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal = var3;
         this.marginVal = var4;
         this.weightVal = var5;
         this.paramVal = ServerHelperHud.stageVal.computeIfAbsent(var2, class_1799::new);
      }

      boolean primaryVal(class_1799 var1) {
         try {
            return this.tertiaryVal.test(var1);
         } catch (Throwable var3) {
            return false;
         }
      }
   }
}
