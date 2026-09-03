package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.minecraft.class_634;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public final class AhSearchCommand extends ChatCommand {
   public AhSearchCommand() {
      super(
         "ahsearch",
         "Search listings by name and max price",
         ".ahsearch <name> <max price>"
      );
   }

   @Compile
   @Override
   public void secondaryVal(String[] var1) {
      ArrayList var2 = new ArrayList();

      for (String var6 : var1) {
         if (var6 != null && !var6.isBlank()) {
            var2.add(var6.trim());
         }
      }

      if (var2.size() == 1 && this.primaryVal((String)var2.getFirst())) {
         AhHelperModule.blockRef();
         ChatLogger.primaryVal(
            "§7[AhHelper] Search filter cleared."
         );
      } else {
         int var8 = this.primaryVal(var2);
         if (var8 <= 0) {
            this.marginVal();
         } else {
            Long var9 = this.secondaryVal(var2.subList(var8, var2.size()));
            if (var9 != null && var9 > 0L) {
               String var10 = String.join(" ", var2.subList(0, var8)).trim();
               if (var10.isEmpty()) {
                  this.marginVal();
               } else {
                  AhHelperModule var11 = null;
                  if (WildClient.primaryVal != null && WildClient.primaryVal.secondaryVal != null) {
                     ModuleManager var7 = WildClient.primaryVal.secondaryVal;
                     if (var7 != null) {
                        var11 = var7.primaryVal(AhHelperModule.class);
                     }
                  }

                  if (var11 != null && !var11.enabled) {
                     var11.setEnabled(true);
                  }

                  AhHelperModule.primaryVal(var10, var9);
                  if (a_.field_1724 != null && a_.field_1724.field_3944 != null) {
                     class_634 var12 = a_.field_1724.field_3944;
                     if (var12 != null) {
                        var12.method_45730("ah search " + var10);
                     }
                  }

                  BoolSetting var13 = AhHelperModule.descRef;
                  ChatLogger.primaryVal(
                     "§7[AhHelper] Filter "
                        + (
                           var13 != null && var13.tertiaryVal()
                              ? "§aenabled"
                              : "§eset, checkbox disabled"
                        )
                        + "\u00a77: \u00a7f"
                        + var10
                        + " §7up to §f"
                        + this.primaryVal(var9)
                        + "$"
                  );
               }
            } else {
               ChatLogger.primaryVal(
                  "§c[AhHelper] Max price must be a positive number."
               );
            }
         }
      }
   }

   @Override
   public List<String> primaryVal(String[] var1) {
      String var2 = var1.length == 0 ? "" : var1[var1.length - 1].toLowerCase(Locale.ROOT);
      return List.of("clear").stream().filter(var1x -> var1x.startsWith(var2)).toList();
   }

   private int primaryVal(List<String> var1) {
      if (var1.size() >= 2 && this.primaryVal((String)var1.getLast())) {
         int var2 = var1.size() - 1;

         while (var2 > 1 && this.secondaryVal((String)var1.get(var2)) == 3 && this.primaryVal((String)var1.get(var2 - 1))) {
            var2--;
         }

         return var2;
      } else {
         return -1;
      }
   }

   private Long secondaryVal(List<String> var1) {
      StringBuilder var2 = new StringBuilder();

      for (String var4 : var1) {
         var2.append(var4.replaceAll("[^0-9]", ""));
      }

      if (var2.isEmpty()) {
         return null;
      }

      try {
         return Long.parseLong(var2.toString());
      } catch (NumberFormatException var5) {
         return null;
      }
   }

   private boolean primaryVal(String var1) {
      return var1 != null && var1.matches("[0-9][0-9_.,]*");
   }

   private int secondaryVal(String var1) {
      return var1.replaceAll("[^0-9]", "").length();
   }

   private boolean tertiaryVal(String var1) {
      return var1.equalsIgnoreCase("clear") || var1.equalsIgnoreCase("off") || var1.equalsIgnoreCase("reset");
   }

   private String primaryVal(long var1) {
      return String.format(Locale.ROOT, "%,d", var1).replace(',', ' ');
   }

   private void marginVal() {
      ChatLogger.primaryVal("§cUsage: " + this.tertiaryVal());
      ChatLogger.primaryVal(
         "§7Example: §f.ahsearch enchanted golden apple 100 000"
      );
      ChatLogger.primaryVal("§7Reset: §f.ahsearch clear");
   }

   static {
      Loader.initialize();
   }
}
