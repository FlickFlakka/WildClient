package ru.metaculture.protection;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionException;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_5250;
import net.minecraft.class_5251;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public class ConfigCommand extends ChatCommand {
   private final File primaryVal;

   public ConfigCommand() {
      super(
         "config",
         "Configuration management",
         ".config <save/load/cloudload/cloudlist/list/delete/dir/reset> <name>"
      );
      this.primaryVal = NnunnNUUUNVn.primaryVal;
      this.primaryVal("load", this::marginVal);
      this.primaryVal("delete", this::marginVal);
      this.primaryVal("dir", List::of);
      this.primaryVal("reset", List::of);
      this.primaryVal("save", this::marginVal);
      this.primaryVal("list", List::of);
      this.primaryVal("cloudload", CloudConfigManager::secondaryVal);
      this.primaryVal("cloudlist", List::of);
   }

   private List<String> marginVal() {
      if (!this.primaryVal.exists()) {
         return List.of();
      }

      File[] var1 = this.primaryVal.listFiles((var0, var1x) -> var1x.endsWith(".cfg") || var1x.endsWith(".json"));
      return var1 == null ? List.of() : Arrays.stream(var1).map(var0 -> {
         String var1x = var0.getName();
         return var1x.substring(0, var1x.lastIndexOf(46));
      }).distinct().sorted(String.CASE_INSENSITIVE_ORDER).toList();
   }

   @Compile
   @Override
   public void secondaryVal(String[] var1) {
      if (WildClient.primaryVal.holderVal == null) {
         ChatLogger.primaryVal(
            "§cConfiguration system not yet initialized."
         );
      } else if (var1.length == 0) {
         ChatLogger.primaryVal("§cUsage: " + this.primaryVal());
      } else {
         switch (var1[0].toLowerCase()) {
            case "save":
               this.tertiaryVal(var1);
               break;
            case "load":
               this.marginVal(var1);
               break;
            case "cloudload":
               this.weightVal(var1);
               break;
            case "cloudlist":
               this.weightVal();
               break;
            case "delete":
               this.paramVal(var1);
               break;
            case "list":
               this.extraVal();
               break;
            case "dir":
               this.paramVal();
               break;
            case "reset":
               this.limitVal();
               break;
            default:
               ChatLogger.primaryVal(
                  "§cUnknown subcommand. Use: save, load, cloudload, cloudlist, delete, list, dir, reset"
               );
         }
      }
   }

   @Compile
   private void tertiaryVal(String[] var1) {
      if (var1.length < 2) {
         ChatLogger.primaryVal(
            "§cSpecify a config name."
         );
      } else {
         String var2 = var1[1];
         if (WildClient.primaryVal.holderVal.secondaryVal(var2)) {
            ChatLogger.primaryVal(
               "§aConfig §f'"
                  + var2
                  + "' §asuccessfully saved."
            );
         } else {
            ChatLogger.primaryVal(
               "§cFailed to save config §f'"
                  + var2
                  + "'\u00a7c."
            );
         }
      }
   }

   @Compile
   private void marginVal(String[] var1) {
      if (var1.length < 2) {
         ChatLogger.primaryVal(
            "§cSpecify a config name to load."
         );
      } else {
         String var2 = var1[1];
         NnunnNUUUNVn var3 = WildClient.primaryVal.holderVal;
         if (var3 != null && var3.primaryVal(var2)) {
            ChatLogger.primaryVal(
               "§aConfig §f'"
                  + var2
                  + "' §asuccessfully loaded."
            );
         } else {
            this.primaryVal(var2, false);
         }
      }
   }

   @Compile
   private void weightVal(String[] var1) {
      if (var1.length < 2) {
         ChatLogger.primaryVal(
            "§cSpecify a Cloud Config name to load."
         );
      } else {
         this.primaryVal(var1[1], true);
      }
   }

   private void primaryVal(String var1, boolean var2) {
      if (var2) {
         ChatLogger.primaryVal(
            "§7Forcibly loading Cloud Config §f'"
               + var1
               + "'\u00a77..."
         );
      } else {
         ChatLogger.primaryVal(
            "§7Local config §f'"
               + var1
               + "' §7not found. Requesting cloud..."
         );
      }

      CloudConfigManager.primaryVal(var1)
         .whenComplete(
            (var2x, var3) -> this.primaryVal(
               () -> {
                  if (var3 != null) {
                     ChatLogger.primaryVal("§cCloud Config error: §7" + this.primaryVal(var3));
                  } else {
                     if (var2x != null && var2x.success()) {
                        ChatLogger.primaryVal(
                           "\u00a7aCloud Config \u00a7f'"
                              + var2x.name()
                              + "' §aloaded and saved."
                        );
                     } else {
                        String var4 = var2x != null && var2x.error() != null
                           ? var2x.error()
                           : "unknown error";
                        ChatLogger.primaryVal(
                           "\u00a7cCloud Config \u00a7f'" + var1 + "' §cnot loaded: §7" + var4
                        );
                     }
                  }
               }
            )
         );
   }

   @Compile
   private void weightVal() {
      ChatLogger.primaryVal("§7Requesting list of Cloud Configs...");
      CloudConfigManager.primaryVal()
         .whenComplete(
            (var1, var2) -> this.primaryVal(
               () -> {
                  if (var2 != null) {
                     ChatLogger.primaryVal("§cCloud Config index error: §7" + this.primaryVal(var2));
                  } else if (var1 != null && var1.success()) {
                     if (var1.names().isEmpty()) {
                        ChatLogger.primaryVal("§7Cloud Config index is empty.");
                     } else {
                        this.primaryVal("Cloud Configs", var1.names());
                     }
                  } else {
                     String var3 = var1 != null && var1.error() != null
                        ? var1.error()
                        : "unknown error";
                     ChatLogger.primaryVal(
                        "§cFailed to load cloudlist: §7"
                           + var3
                     );
                  }
               }
            )
         );
   }

   @Compile
   private void paramVal(String[] var1) {
      if (var1.length < 2) {
         ChatLogger.primaryVal(
            "§cSpecify a config name to delete."
         );
      } else {
         String var2 = var1[1];
         if (WildClient.primaryVal.holderVal.marginVal(var2)) {
            ChatLogger.primaryVal("§aConfig §f'" + var2 + "' §adeleted.");
         } else {
            ChatLogger.primaryVal("§cConfig §f'" + var2 + "' §cnot found.");
         }
      }
   }

   @Compile
   private void paramVal() {
      try {
         if (!this.primaryVal.exists()) {
            this.primaryVal.mkdirs();
         }

         String var1 = System.getProperty("os.name").toLowerCase();
         if (var1.contains("win")) {
            Runtime.getRuntime().exec(new String[]{"explorer", this.primaryVal.getAbsolutePath()});
         } else if (var1.contains("mac")) {
            Runtime.getRuntime().exec(new String[]{"open", this.primaryVal.getAbsolutePath()});
         } else {
            Runtime.getRuntime().exec(new String[]{"xdg-open", this.primaryVal.getAbsolutePath()});
         }

         ChatLogger.primaryVal(
            "§aConfig folder opened!"
         );
         ChatLogger.primaryVal("§7Path: §f" + this.primaryVal.getAbsolutePath());
      } catch (Exception var2) {
         ChatLogger.primaryVal(
            "§cFailed to open the config folder."
         );
      }
   }

   @Compile
   private void extraVal() {
      List<ConfigFile> var1 = WildClient.primaryVal.holderVal.paramVal();
      if (var1.isEmpty()) {
         ChatLogger.primaryVal(
            "§7No configs available."
         );
      } else {
         this.primaryVal(
            "Available configs",
            var1.stream().map(ConfigFile::secondaryVal).toList()
         );
      }
   }

   @Compile
   private void limitVal() {
      if (WildClient.primaryVal.holderVal.weightVal()) {
         ChatLogger.primaryVal(
            "§aConfig reset: modules disabled, keybinds and settings restored to defaults."
         );
      } else {
         ChatLogger.primaryVal(
            "§cFailed to reset config."
         );
      }
   }

   private void primaryVal(String var1, List<String> var2) {
      class_5250 var3 = class_2561.method_43470("\u00a7f" + var1 + ": ");
      int var4 = AccentColor.primaryVal();

      for (int var5 = 0; var5 < var2.size(); var5++) {
         class_5250 var6 = class_2561.method_43470((String)var2.get(var5)).method_10862(class_2583.field_24360.method_27703(class_5251.method_27717(var4)));
         var3.method_10852(var6);
         if (var5 < var2.size() - 1) {
            var3.method_10852(class_2561.method_43470("\u00a77 | "));
         }
      }

      if (a_.field_1724 != null) {
         a_.field_1724.method_7353(var3, false);
      } else {
         ChatLogger.primaryVal(var1 + ": " + String.join(", ", var2));
      }
   }

   private void primaryVal(Runnable var1) {
      if (a_ == null) {
         var1.run();
      } else {
         a_.execute(var1);
      }
   }

   private String primaryVal(Throwable var1) {
      Throwable var2 = var1;

      while (var2 instanceof CompletionException && var2.getCause() != null) {
         var2 = var2.getCause();
      }

      String var3 = var2 == null ? null : var2.getMessage();
      return var3 != null && !var3.isBlank() ? var3 : "unknown error";
   }

   static {
      Loader.initialize();
   }
}
