package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_10868;
import net.minecraft.class_124;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_2960;
import net.minecraft.class_5250;
import net.minecraft.class_5481;
import net.minecraft.class_640;
import net.minecraft.class_8685;
import net.minecraft.class_8685.class_7920;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "ProtectInfo",
   secondaryVal = "Hides nicknames, domains, brands, and replaces the scoreboard",
   tertiaryVal = ModuleCategory.Visuals
)
public class ProtectInfoModule extends Module {
   private static final String paramRef = "Text";
   private static final String groupVal = "Outgoing chat";
   private static final String layerVal = "Domains/IP";
   private static final String slotVal = "Skins";
   private static final String themeVal = "Item Frames";
   private static final String stageVal = "Paintings";
   private static final String[] widthRef = new String[]{
      "Funtime",
      "Spookytime",
      "HolyWorld",
      "LonyGrief",
      "Wellmine",
      "ArtyGrief",
      "Aresmine",
      "Triada",
      "SlimeWorld",
      "VimeMC",
      "ReallyWorld",
      "MineBlaze",
      "DexLand",
      "TeslaCraft",
      "MusteryWorld",
      "Gamely",
      "SunRise",
      "MSTNetwork",
      "ReallyGrief",
      "MineLand",
      "LastCraft",
      "McSkill",
      "Hypixel",
      "FunTime",
      "Fun Time",
      "funtime",
      "Funtime",
      "Fun time",
      "Fun-Time",
      "Fun_time",
      "FT",
      "spacetimes",
      "spookytime",
      "GuvsHvh"
   };
   private static final String trackVal = "Source obtained by Uelm & Claude";
   private static final Pattern modeRef = Pattern.compile("(?iu)\\b(" + String.join("|", widthRef) + ")\\s*\\.\\s*([a-z\u0430-\u044f]{2,12})\\b");
   private static final Pattern angleVal = Pattern.compile(
      "(?iu)(?<![\\w.@-])(?!wildclient\\.org\\b)(?:https?://)?(?:[a-z0-9-]+\\.)+(?:ru|su|fun|net|org|com|me|pw|xyz|pro|gg|top|site|online)\\b(?:/[\\w\\-./?=&%#+~@:]*)?"
   );
   private static final Pattern heightRef = Pattern.compile("\\b(?:\\d{1,3}\\.){3}\\d{1,3}(?::\\d{2,5})?\\b");
   private static final Pattern[] levelVal = activeVal();
   private static final class_2960 UuNnnVnuNNV = class_2960.method_60655("wild", "textures/png/zov.png");
   private static final class_2960 depthRef = class_2960.method_60655("wild", "textures/png/obla.png");
   private static final class_2960 speedRef = class_2960.method_60655("wild", "textures/protect/streamer_skin.png");
   private static class_8685 countRef;
   private static final Pattern entryVal = Pattern.compile("(?i)(?:\\u00A7|\\u0412\\u00A7)[0-9a-fk-or]");
   private static final Pattern guardVal = Pattern.compile(
      "(?iu)(?:\u0430\u043d\u0430\u0440\u0445(?:\u0438\u044f|\u0438\u0438)?|anarchy|an)\\s*(?:[-:#\u2116]|\\s)*\\d{1,5}"
   );
   public final BoolSetting countVal = new BoolSetting("Friends", false);
   public final SettingGroup depthVal = new SettingGroup(
      "What to hide",
      new BoolSetting("Custom nickname", true),
      new BoolSetting("All nicknames", false),
      new BoolSetting("Anarchy", false)
   );
   public final SettingGroup descRef = new SettingGroup(
      "Protection",
      new BoolSetting("Text", true),
      new BoolSetting("Outgoing chat", true),
      new BoolSetting("Domains/IP", true),
      new BoolSetting("Skins", true),
      new BoolSetting("Item Frames", true),
      new BoolSetting("Paintings", true)
   );
   public final StringFilterSetting activeVal = new StringFilterSetting("Replacement", "Wild");
   public final StringFilterSetting radiusVal = new StringFilterSetting("Custom nickname", "Protect");
   public final StringFilterSetting factorVal = new StringFilterSetting(
      "Custom anarchy", "Hidden"
   );
   public final BoolSetting sourceVal = new BoolSetting("Scoreboard color", true);
   public final ModeSetting extraRef = new ModeSetting(
      "Tint",
      "Cyan",
      "Cyan",
      "Dark Blue"
   );
   public final BoolSetting phaseVal = new BoolSetting("Render PNG", false);
   public final ModeSetting limitRef = new ModeSetting(
      "PNG variant ",
      "Sharp",
      "Creep",
      "Sharp"
   );

   public ProtectInfoModule() {
      this.radiusVal.primaryVal(() -> !this.depthVal.secondaryVal("Custom nickname"));
      this.factorVal.primaryVal(() -> !this.depthVal.secondaryVal("Anarchy"));
      this.extraRef.primaryVal(() -> !this.sourceVal.tertiaryVal());
      this.limitRef.primaryVal(() -> !this.phaseVal.tertiaryVal());
      this.addSettings(
         this.countVal,
         this.depthVal,
         this.descRef,
         this.activeVal,
         this.radiusVal,
         this.factorVal,
         this.sourceVal,
         this.extraRef,
         this.phaseVal,
         this.limitRef
      );
   }

   @Subscribe
   public void primaryVal(RenderHudEvent var1) {
      if (this.phaseVal.tertiaryVal() && mc.field_1687 != null && mc.field_1724 != null) {
         Renderer2D var2 = var1.marginVal();
         float var3 = 220.0F;
         float var4 = 250.0F;
         float var5 = var1.paramVal();
         float var6 = var1.extraVal();
         float var7 = var5 - var3 - 2.0F - 5.0F;
         float var8 = var6 / 2.0F - var4 / 2.0F - 60.0F;
         class_2960 var9 = this.limitRef.tertiaryVal().equals("Sharp") ? UuNnnVnuNNV : depthRef;
         int var10 = primaryVal(var9);
         if (var10 > 0) {
            GlStateManager._bindTexture(var10);
            GlStateManager._texParameter(3553, 10240, 9728);
            GlStateManager._texParameter(3553, 10241, 9728);
            var2.weightVal(1.0F);
            float var11 = var7 + var3 / 2.0F;
            float var12 = var8 + var4 / 2.0F;
            var2.primaryVal(var11, var12);
            var2.secondaryVal(1.0F, -1.0F);
            var2.primaryVal(-var11, -var12);
            var2.primaryVal(var10, var7, var8, var3, var4);
            var2.limitVal();
            var2.speedVal();
            var2.limitVal();
            var2.widthVal();
         }
      }
   }

   public static boolean blockRef() {
      ProtectInfoModule var0 = countVal();
      return var0 != null && var0.enabled;
   }

   public static String primaryVal(String var0) {
      ProtectInfoModule var1 = countVal();
      if (var1 != null && var1.enabled) {
         String var2 = secondaryVal(var0, var1);
         return !var1.descRef.secondaryVal("Text")
            ? var2
            : primaryVal(var2, var1.descRef.secondaryVal("Domains/IP"), depthVal());
      } else {
         return var0;
      }
   }

   public static String secondaryVal(String var0) {
      ProtectInfoModule var1 = countVal();
      if (var1 != null && var1.enabled && var1.descRef.secondaryVal("Outgoing chat")) {
         String var2 = secondaryVal(var0, var1);
         return primaryVal(var2, var1.descRef.secondaryVal("Domains/IP"), depthVal());
      } else {
         return var0;
      }
   }

   public static class_5481 primaryVal(class_5481 var0) {
      ProtectInfoModule var1 = countVal();
      if (var0 != null && var1 != null && var1.enabled && var1.descRef.secondaryVal("Text")) {
         ArrayList var2 = new ArrayList();
         StringBuilder var3 = new StringBuilder();
         var0.accept((var2x, var3x, var4x) -> {
            String var5x = new String(Character.toChars(var4x));
            var2.add(new ProtectInfoModule.cursorVal(var5x, var3x));
            var3.append(var5x);
            return true;
         });
         String var4 = var3.toString();
         ProtectInfoModule.WildClient var5 = primaryVal(var2, var4, var1.descRef.secondaryVal("Domains/IP"), depthVal());
         return !var5.changed ? var0 : var1x -> {
            int var2x = 0;

            for (ProtectInfoModule.cursorVal var4x : var5.tokens) {
               for (int var5x = 0; var5x < var4x.text.length(); var2x++) {
                  int var6 = var4x.text.codePointAt(var5x);
                  if (!var1x.accept(var2x, var4x.style, var6)) {
                     return false;
                  }

                  var5x += Character.charCount(var6);
               }
            }

            return true;
         };
      } else {
         return var0;
      }
   }

   public static boolean holderVal() {
      ProtectInfoModule var0 = countVal();
      return var0 != null && var0.enabled && var0.descRef.secondaryVal("Skins");
   }

   public static boolean timerVal() {
      ProtectInfoModule var0 = countVal();
      return var0 != null && var0.enabled && var0.descRef.secondaryVal("Item Frames");
   }

   public static boolean anchorVal() {
      ProtectInfoModule var0 = countVal();
      return var0 != null && var0.enabled && var0.descRef.secondaryVal("Paintings");
   }

   public static boolean weightRef() {
      ProtectInfoModule var0 = countVal();
      return var0 != null && var0.enabled && var0.sourceVal.tertiaryVal();
   }

   public static class_8685 bufferVal() {
      if (countRef == null) {
         countRef = new class_8685(speedRef, null, null, null, class_7920.field_41122, true);
      }

      return countRef;
   }

   public static class_2561 primaryVal(class_2561 var0) {
      if (var0 != null && mc.field_1724 != null) {
         ProtectInfoModule var1 = countVal();
         if (var1 != null && var1.enabled) {
            class_5250 var2 = class_2561.method_43473();
            var0.method_27658((var1x, var2x) -> {
               String var3 = primaryVal(var2x);
               var2.method_10852(class_2561.method_43470(var3).method_10862(var1x));
               return Optional.empty();
            }, class_2583.field_24360);
            return var2;
         } else {
            return var0;
         }
      } else {
         return var0;
      }
   }

   public static class_2561 secondaryVal(class_2561 var0) {
      class_2561 var1 = primaryVal(var0);
      return !weightRef() ? var1 : primaryVal(var1, descRef());
   }

   public static String tertiaryVal(String var0) {
      return primaryVal(var0);
   }

   public static String primaryVal(String var0, ProtectInfoModule var1) {
      if (var0 != null && !var0.isEmpty()) {
         String var2 = secondaryVal(var0, var1);
         if (var1.descRef.secondaryVal("Text")) {
            var2 = primaryVal(var2, var1.descRef.secondaryVal("Domains/IP"), primaryVal(var1));
         }

         return var2;
      } else {
         return var0;
      }
   }

   private static ProtectInfoModule countVal() {
      return ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(ProtectInfoModule.class)
         : null;
   }

   private static String depthVal() {
      ProtectInfoModule var0 = countVal();
      return primaryVal(var0);
   }

   private static String primaryVal(ProtectInfoModule var0) {
      if (var0 == null) {
         return "Wild";
      }

      String var1 = var0.activeVal.tertiaryVal().trim();
      return var1.isEmpty() ? "Wild" : var1;
   }

   private static class_124 descRef() {
      ProtectInfoModule var0 = countVal();
      return var0 != null && "Dark Blue".equals(var0.extraRef.tertiaryVal())
         ? class_124.field_1058
         : class_124.field_1075;
   }

   private static String secondaryVal(String var0, ProtectInfoModule var1) {
      if (var0 != null && !var0.isEmpty()) {
         String var2 = var0;
         if (var1.depthVal.secondaryVal("Custom nickname")) {
            var2 = tertiaryVal(var2, var1);
         }

         if (var1.depthVal.secondaryVal("All nicknames")) {
            var2 = weightVal(var2, var1);
         }

         if (var1.countVal.tertiaryVal()) {
            var2 = marginVal(var2, var1);
         }

         if (var1.depthVal.secondaryVal("Anarchy")) {
            ServerProfileTracker.primaryVal.primaryVal(500L);
            var2 = secondaryVal(var2, var1.factorVal.tertiaryVal(), ServerProfileTracker.primaryVal.tertiaryVal());
         }

         return var2;
      } else {
         return var0;
      }
   }

   private static String tertiaryVal(String var0, ProtectInfoModule var1) {
      String var2 = secondaryVal(var1);
      String var3 = var0;
      if (mc != null) {
         if (mc.method_1548() != null) {
            var3 = primaryVal(var3, mc.method_1548().method_1676(), var2);
         }

         if (mc.field_1724 != null) {
            var3 = primaryVal(var3, mc.field_1724.method_7334() == null ? null : mc.field_1724.method_7334().getName(), var2);
            var3 = primaryVal(var3, mc.field_1724.method_5477() == null ? null : mc.field_1724.method_5477().getString(), var2);
         }
      }

      return primaryVal(var3, ServerProfileTracker.secondaryVal, var2);
   }

   private static String marginVal(String var0, ProtectInfoModule var1) {
      String var2 = secondaryVal(var1);
      String var3 = var0;
      List<String> var4 = FriendCommand.marginVal();
      if (var4 != null && !var4.isEmpty()) {
         for (String var6 : var4) {
            var3 = primaryVal(var3, var6, var2);
         }

         return var3;
      } else {
         return var3;
      }
   }

   private static String weightVal(String var0, ProtectInfoModule var1) {
      if (mc != null && mc.method_1562() != null) {
         String var2 = secondaryVal(var1);
         String var3 = var0;

         for (class_640 var5 : mc.method_1562().method_2880()) {
            if (var5 != null && var5.method_2966() != null) {
               var3 = primaryVal(var3, var5.method_2966().getName(), var2);
            }
         }

         return var3;
      } else {
         return var0;
      }
   }

   private static String secondaryVal(ProtectInfoModule var0) {
      String var1 = var0.radiusVal.tertiaryVal();
      return var1 != null && !var1.isBlank() ? var1 : "Protect";
   }

   private static String primaryVal(String var0, String var1, String var2) {
      if (var0 != null && !var0.isEmpty() && var1 != null) {
         String var3 = var2 != null && !var2.isBlank() ? var2 : "Protect";
         String var4 = entryVal.matcher(var1).replaceAll("").trim();
         if (!var4.isEmpty() && !var4.equalsIgnoreCase("N/A") && !var4.equalsIgnoreCase(var3)) {
            Pattern var5 = Pattern.compile(Pattern.quote(var4), 66);
            Matcher var6 = var5.matcher(var0);
            StringBuilder var7 = new StringBuilder(var0.length());

            while (var6.find()) {
               String var8 = var6.group();
               if (primaryVal(var0, var6.start(), var6.end()) && !primaryVal(var0, var6.start(), var6.end(), var4, var3)) {
                  var6.appendReplacement(var7, Matcher.quoteReplacement(var3));
               } else {
                  var6.appendReplacement(var7, Matcher.quoteReplacement(var8));
               }
            }

            var6.appendTail(var7);
            return var7.toString();
         } else {
            return var0;
         }
      } else {
         return var0;
      }
   }

   private static boolean primaryVal(String var0, int var1, int var2) {
      return (var1 <= 0 || !primaryVal(var0.charAt(var1 - 1))) && (var2 >= var0.length() || !primaryVal(var0.charAt(var2)));
   }

   private static boolean primaryVal(char var0) {
      return Character.isLetterOrDigit(var0) || var0 == '_';
   }

   private static boolean primaryVal(String var0, int var1, int var2, String var3, String var4) {
      if (var4 != null && !var4.isEmpty()) {
         Matcher var5 = Pattern.compile(Pattern.quote(var3), 66).matcher(var4);

         while (var5.find()) {
            String var6 = var4.substring(0, var5.start());
            String var7 = var4.substring(var5.end());
            int var8 = var1 - var6.length();
            int var9 = var2 + var7.length();
            if (var8 >= 0
               && var9 <= var0.length()
               && var0.regionMatches(true, var8, var6, 0, var6.length())
               && var0.regionMatches(true, var2, var7, 0, var7.length())) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private static String secondaryVal(String var0, String var1, String var2) {
      if (var0 != null && !var0.isEmpty()) {
         String var3 = var1 != null && !var1.isBlank() ? var1 : "Hidden";
         String var4 = guardVal.matcher(var0).replaceAll(Matcher.quoteReplacement(var3));
         if (var2 != null && !var2.equals("N/A") && !var2.isBlank()) {
            String var5 = entryVal.matcher(var4).replaceAll("").trim();
            if (var5.equals(var2) || var5.equals("-" + var2) || var5.equals("#" + var2) || var5.equals("\u2116" + var2)) {
               return var3;
            }

            Pattern var6 = Pattern.compile(
               "(?iu)(?:\u0430\u043d\u0430\u0440\u0445(?:\u0438\u044f|\u0438\u0438)?|anarchy|an)\\s*(?:[-:#\u2116]|\\s)*" + Pattern.quote(var2)
            );
            var4 = var6.matcher(var4).replaceAll(Matcher.quoteReplacement(var3));
         }

         return var4;
      } else {
         return var0;
      }
   }

   private static class_2561 primaryVal(class_2561 var0, class_124 var1) {
      class_5250 var2 = class_2561.method_43473();
      var0.method_27658((var2x, var3) -> {
         class_2583 var4 = var2x.method_10977(var1);
         var2.method_10852(class_2561.method_43470(var3).method_10862(var4));
         return Optional.empty();
      }, class_2583.field_24360);
      return var2;
   }

   private static String primaryVal(String var0, boolean var1, String var2) {
      if (var0 != null && !var0.isEmpty()) {
         String var3 = var0;
         if (var1) {
            var3 = weightVal(var3);
            var3 = marginVal(var3);
            var3 = heightRef.matcher(var3).replaceAll(Matcher.quoteReplacement("wildclient.org"));
         }

         for (Pattern var7 : levelVal) {
            var3 = var7.matcher(var3).replaceAll(Matcher.quoteReplacement(var2));
         }

         return var3;
      } else {
         return var0;
      }
   }

   private static ProtectInfoModule.WildClient primaryVal(List<ProtectInfoModule.cursorVal> var0, String var1, boolean var2, String var3) {
      ProtectInfoModule.WildClient var4 = new ProtectInfoModule.WildClient(var0, var1, false);
      if (var2) {
         var4 = primaryVal(var4, angleVal, var0x -> "wildclient.org");
         var4 = primaryVal(var4, modeRef, var0x -> "wildclient.org");
         var4 = primaryVal(var4, heightRef, var0x -> "wildclient.org");
      }

      for (Pattern var8 : levelVal) {
         var4 = primaryVal(var4, var8, var1x -> var3);
      }

      return var4;
   }

   private static ProtectInfoModule.WildClient primaryVal(ProtectInfoModule.WildClient var0, Pattern var1, Function<Matcher, String> var2) {
      Matcher var3 = var1.matcher(var0.text);
      if (!var3.find()) {
         return var0;
      }

      ArrayList var4 = new ArrayList();
      int var5 = 0;

      do {
         primaryVal(var0.tokens, var4, var5, var3.start());
         var4.add(new ProtectInfoModule.cursorVal((String)var2.apply(var3), primaryVal(var0.tokens, var3.start())));
         var5 = var3.end();
      } while (var3.find());

      primaryVal(var0.tokens, var4, var5, var0.text.length());
      return new ProtectInfoModule.WildClient(var4, primaryVal(var4), true);
   }

   private static void primaryVal(List<ProtectInfoModule.cursorVal> var0, List<ProtectInfoModule.cursorVal> var1, int var2, int var3) {
      if (var2 < var3) {
         int var4 = 0;

         for (ProtectInfoModule.cursorVal var6 : var0) {
            int var7 = var4;
            int var8 = var4 + var6.text.length();
            var4 = var8;
            int var9 = Math.max(var2, var7);
            int var10 = Math.min(var3, var8);
            if (var9 < var10) {
               var1.add(new ProtectInfoModule.cursorVal(var6.text.substring(var9 - var7, var10 - var7), var6.style));
            }
         }
      }
   }

   private static class_2583 primaryVal(List<ProtectInfoModule.cursorVal> var0, int var1) {
      int var2 = 0;
      class_2583 var3 = class_2583.field_24360;

      for (ProtectInfoModule.cursorVal var5 : var0) {
         int var6 = var2 + var5.text.length();
         if (var1 < var6) {
            return var5.style;
         }

         var2 = var6;
         var3 = var5.style;
      }

      return var3;
   }

   private static String primaryVal(List<ProtectInfoModule.cursorVal> var0) {
      StringBuilder var1 = new StringBuilder();

      for (ProtectInfoModule.cursorVal var3 : var0) {
         var1.append(var3.text);
      }

      return var1.toString();
   }

   private static String marginVal(String var0) {
      return modeRef.matcher(var0).replaceAll(Matcher.quoteReplacement("wildclient.org"));
   }

   private static String weightVal(String var0) {
      return angleVal.matcher(var0).replaceAll(Matcher.quoteReplacement("wildclient.org"));
   }

   private static Pattern[] activeVal() {
      Pattern[] var0 = new Pattern[widthRef.length];

      for (int var1 = 0; var1 < widthRef.length; var1++) {
         var0[var1] = Pattern.compile("(?iu)(?<![\\p{L}\\p{N}])" + paramVal(widthRef[var1]) + "(?![\\p{L}\\p{N}])");
      }

      return var0;
   }

   private static String paramVal(String var0) {
      StringBuilder var1 = new StringBuilder();

      for (int var2 = 0; var2 < var0.length(); var2++) {
         if (var2 > 0) {
            var1.append("[\\s._-]*");
         }

         var1.append(Pattern.quote(String.valueOf(var0.charAt(var2))));
      }

      return var1.toString();
   }

   private static int primaryVal(class_2960 var0) {
      if (var0 == null) {
         return -1;
      } else {
         class_1060 var1 = mc.method_1531();
         if (var1 == null) {
            return -1;
         } else {
            class_1044 var2 = var1.method_4619(var0);
            if (var2 == null) {
               return -1;
            } else {
               return var2.method_68004() instanceof class_10868 var4 ? var4.method_68427() : -1;
            }
         }
      }
   }

   record WildClient(List<ProtectInfoModule.cursorVal> tokens, String text, boolean changed) {
   }

   record cursorVal(String text, class_2583 style) {
   }
}
