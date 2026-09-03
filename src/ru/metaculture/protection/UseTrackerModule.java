package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_1839;
import net.minecraft.class_1844;
import net.minecraft.class_1890;
import net.minecraft.class_2561;
import net.minecraft.class_2663;
import net.minecraft.class_2783;
import net.minecraft.class_6880;
import net.minecraft.class_9334;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "UseTracker",
   tertiaryVal = ModuleCategory.Misc,
   secondaryVal = "Tracking totems/effects/consumables on players"
)
public class UseTrackerModule extends Module {
   private static final String countVal = "Totem pop";
   private static final String depthVal = "Potions received";
   private static final String descRef = "Items eaten";
   private static final int activeVal = 31;
   private static final long radiusVal = 500L;
   private final SettingGroup factorVal = new SettingGroup(
      "Track",
      new BoolSetting("Totem pop", true),
      new BoolSetting("Potions received", true),
      new BoolSetting("Items eaten", true)
   );
   private final Map<UUID, Map<String, class_1293>> sourceVal = new HashMap<>();
   private static final Map<UUID, Boolean> extraRef = new HashMap<>();
   private final Map<UUID, class_1799> phaseVal = new HashMap<>();
   private final Map<UUID, Integer> limitRef = new HashMap<>();
   private final VuNvNNvVV paramRef = new VuNvNNvVV();

   public UseTrackerModule() {
      this.addSettings(this.factorVal);
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         if (this.weightRef()) {
            this.blockRef();
         } else {
            this.phaseVal.clear();
            this.limitRef.clear();
         }

         if (!this.anchorVal()) {
            this.sourceVal.clear();
         } else if (this.paramRef.weightVal(500L)) {
            this.paramRef.primaryVal();
            this.holderVal();
         }
      } else {
         this.bufferVal();
      }
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      if (var1.weightVal().equals(PacketEvent.PacketDirection.RECEIVE) && mc.field_1687 != null && mc.field_1724 != null) {
         if (var1.marginVal() instanceof class_2663 var2) {
            this.primaryVal(var2);
         }

         if (var1.marginVal() instanceof class_2783 var4) {
            this.primaryVal(var4);
         }
      }
   }

   private void blockRef() {
      HashSet var1 = new HashSet();

      for (class_1657 var3 : mc.field_1687.method_18456()) {
         if (var3 != null && var3.method_5805() && !this.secondaryVal(var3)) {
            UUID var4 = var3.method_5667();
            var1.add(var4);
            if (var3.method_6115()) {
               this.phaseVal.computeIfAbsent(var4, var1x -> var3.method_6030().method_7972());
               this.limitRef.putIfAbsent(var4, var3.field_6012);
            } else {
               class_1799 var5 = this.phaseVal.remove(var4);
               Integer var6 = this.limitRef.remove(var4);
               if (var5 != null && !var5.method_7960() && var6 != null && var3.field_6012 - var6 >= 31) {
                  class_1839 var7 = var5.method_7976();

                  String var8 = switch (var7) {
                     case field_8946 -> "drank";
                     case field_8950 -> "ate";
                     default -> null;
                  };
                  if (var8 != null) {
                     String var9 = this.primaryVal(var5.method_7964().getString());
                     String var10 = this.primaryVal(var5);
                     String var11 = var10.isEmpty() ? "" : " \u00a78(\u00a77" + var10 + "\u00a78)";
                     this.secondaryVal("\u00a7f" + var3.method_5477().getString() + "\u00a77 " + var8 + " \u00a7f" + var9 + var11);
                  }
               }
            }
         }
      }

      this.phaseVal.keySet().removeIf(var1x -> !var1.contains(var1x));
      this.limitRef.keySet().removeIf(var1x -> !var1.contains(var1x));
   }

   private void primaryVal(class_2663 var1) {
      if (this.timerVal() && var1.method_11470() == 35) {
         if (var1.method_11469(mc.field_1687) instanceof class_1657 var3 && !this.secondaryVal(var3)) {
            boolean var4 = class_1890.method_58117(var3.method_6079())
               || class_1890.method_58117(var3.method_6047())
               || var3.method_6079().method_7958()
               || var3.method_6047().method_7958();
            extraRef.put(var3.method_5667(), var4);
            this.secondaryVal(
               "\u00a7f"
                  + var3.method_5477().getString()
                  + "§7 lost totem of undying, enchanted: "
                  + (var4 ? "\u00a7a" : "\u00a7c")
                  + "\u2b24"
            );
         }
      }
   }

   private void primaryVal(class_2783 var1) {
      if (this.anchorVal()) {
         if (mc.field_1687.method_8469(var1.method_11943()) instanceof class_1657 var3) {
            UUID var4 = var3.method_5667();
            HashMap var5 = new HashMap<>(this.sourceVal.getOrDefault(var4, Map.of()));
            var5.putAll(this.primaryVal(var3));
            class_1293 var6 = new class_1293(
               var1.method_11946(), var1.method_11944(), var1.method_11945(), var1.method_11950(), var1.method_11949(), var1.method_11942()
            );
            String var7 = this.primaryVal(var1.method_11946(), var1.method_11945());
            var5.put(var7, var6);
            HashSet var8 = new HashSet();
            var8.add(var7);
            this.primaryVal(var3, var5, var8);
            this.sourceVal.put(var4, var5);
         }
      }
   }

   private void holderVal() {
      HashSet var1 = new HashSet();

      for (class_1657 var3 : mc.field_1687.method_18456()) {
         if (var3 != null && var3.method_5805()) {
            UUID var4 = var3.method_5667();
            var1.add(var4);
            Map<String, class_1293> var5 = this.sourceVal.getOrDefault(var4, Map.of());
            Map<String, class_1293> var6 = this.primaryVal(var3);
            HashSet<String> var7 = new HashSet<String>();

            for (Entry<String, class_1293> var9 : var6.entrySet()) {
               class_1293 var10 = (class_1293)var5.get(var9.getKey());
               if (var10 == null || this.primaryVal(var10, (class_1293)var9.getValue())) {
                  var7.add((String)var9.getKey());
               }
            }

            if (!var7.isEmpty()) {
               this.primaryVal(var3, var6, var7);
            }

            this.sourceVal.put(var4, var6);
         }
      }

      this.sourceVal.keySet().removeIf(var1x -> !var1.contains(var1x));
   }

   private boolean primaryVal(class_1293 var1, class_1293 var2) {
      return var1.method_5578() != var2.method_5578() ? true : var2.method_5584() > var1.method_5584() + 20;
   }

   private void primaryVal(class_1657 var1, Map<String, class_1293> var2, Set<String> var3) {
      ArrayList<UseTrackerModule.cursorVal> var4 = new ArrayList<>();
      this.primaryVal(var2, var3, var4, UseTrackerModule.cursorVal.KILLER, "effect.minecraft.strength:3", "effect.minecraft.resistance:0");
      this.primaryVal(var2, var3, var4, UseTrackerModule.cursorVal.URINE, "effect.minecraft.jump_boost:0", "effect.minecraft.speed:2");
      this.primaryVal(var2, var3, var4, UseTrackerModule.cursorVal.MEDIC, "effect.minecraft.health_boost:2", "effect.minecraft.regeneration:2");
      this.primaryVal(
         var2,
         var3,
         var4,
         UseTrackerModule.cursorVal.BURP,
         "effect.minecraft.blindness:0",
         "effect.minecraft.glowing:0",
         "effect.minecraft.hunger:9",
         "effect.minecraft.slowness:2",
         "effect.minecraft.wither:4"
      );
      this.primaryVal(var2, var3, var4, UseTrackerModule.cursorVal.FLASH, "effect.minecraft.blindness:0", "effect.minecraft.glowing:0");
      this.primaryVal(
         var2,
         var3,
         var4,
         UseTrackerModule.cursorVal.SULFURIC_ACID,
         "effect.minecraft.poison:1",
         "effect.minecraft.slowness:3",
         "effect.minecraft.weakness:2",
         "effect.minecraft.wither:4"
      );
      this.primaryVal(
         var2,
         var3,
         var4,
         UseTrackerModule.cursorVal.WINNER,
         "effect.minecraft.health_boost:1",
         "effect.minecraft.invisibility:0",
         "effect.minecraft.regeneration:1",
         "effect.minecraft.resistance:0"
      );
      if (var4.isEmpty()) {
         for (String var9 : var3) {
            class_1293 var7 = (class_1293)var2.get(var9);
            if (var7 != null) {
               this.primaryVal(var1, var7);
            }
         }
      } else {
         for (UseTrackerModule.cursorVal var6 : var4) {
            this.primaryVal(var1, var6);
         }
      }
   }

   private void primaryVal(class_1657 var1, class_1293 var2) {
      String var3 = this.primaryVal(class_2561.method_43471(((class_1291)var2.method_5579().comp_349()).method_5567()).getString());
      int var4 = Math.max(0, var2.method_5578()) + 1;
      String var5 = this.primaryVal(var2);
      this.secondaryVal(
         "\u00a7f"
            + var1.method_5477().getString()
            + "§7 received §f"
            + var3
            + " "
            + var4
            + "§7 for §f"
            + var5
      );
   }

   private boolean primaryVal(Map<String, class_1293> var1, Set<String> var2, List<UseTrackerModule.cursorVal> var3, UseTrackerModule.cursorVal var4, String... var5) {
      HashSet var6 = new HashSet<>(Arrays.asList(var5));
      boolean var7 = var6.stream().allMatch(var1::containsKey);
      boolean var8 = var6.stream().anyMatch(var2::contains);
      if (var7 && var8) {
         var3.add(var4);
         var2.removeAll(var6);
         return true;
      } else {
         return false;
      }
   }

   private Map<String, class_1293> primaryVal(class_1657 var1) {
      HashMap var2 = new HashMap();

      for (class_1293 var4 : var1.method_6026()) {
         var2.put(this.primaryVal(var4.method_5579(), var4.method_5578()), var4);
      }

      return var2;
   }

   private String primaryVal(class_6880<class_1291> var1, int var2) {
      return ((class_1291)var1.comp_349()).method_5567() + ":" + var2;
   }

   private void primaryVal(class_1657 var1, UseTrackerModule.cursorVal var2) {
      this.secondaryVal("\u00a7f" + var1.method_5477().getString() + "§7 received §f" + this.primaryVal(var2.primaryVal));
   }

   private String primaryVal(class_1799 var1) {
      class_1844 var2 = (class_1844)var1.method_58694(class_9334.field_49651);
      if (var2 == null) {
         return "";
      }

      StringBuilder var3 = new StringBuilder();

      for (class_1293 var5 : var2.method_57397()) {
         if (!var3.isEmpty()) {
            var3.append("\u00a78, \u00a77");
         }

         String var6 = this.primaryVal(class_2561.method_43471(((class_1291)var5.method_5579().comp_349()).method_5567()).getString());
         int var7 = Math.max(0, var5.method_5578()) + 1;
         var3.append(var6).append(" ").append(var7).append("§7 for §f").append(this.primaryVal(var5));
      }

      return var3.toString();
   }

   private String primaryVal(class_1293 var1) {
      if (var1.method_48559()) {
         return "\u221e";
      }

      int var2 = var1.method_5584() / 20;
      int var3 = var2 / 60;
      var2 %= 60;
      return var3 > 0 ? var3 + " min " + var2 + " sec" : var2 + " sec";
   }

   private boolean timerVal() {
      return this.factorVal.secondaryVal("Totem pop");
   }

   private boolean anchorVal() {
      return this.factorVal.secondaryVal("Potions received");
   }

   private boolean weightRef() {
      return this.factorVal.secondaryVal("Items eaten");
   }

   private boolean secondaryVal(class_1657 var1) {
      return mc.field_1724 != null && var1.method_5667().equals(mc.field_1724.method_5667());
   }

   private String primaryVal(String var1) {
      return var1 == null ? "" : var1.replaceAll("\u00a7[0-9a-fk-orA-FK-OR]", "");
   }

   private void secondaryVal(String var1) {
      ChatLogger.primaryVal(var1);
   }

   private void bufferVal() {
      this.sourceVal.clear();
      extraRef.clear();
      this.phaseVal.clear();
      this.limitRef.clear();
   }

   @Override
   public void onDisable() {
      this.bufferVal();
      super.onDisable();
   }

   record WildClient(class_6880<class_1291> effect, int durationSeconds, int amplifier) {
      int durationTicks() {
         return this.durationSeconds * 20;
      }
   }

   enum cursorVal {
      FLASH(
         "§6[★] §eFlash",
         List.of(new UseTrackerModule.WildClient(class_1294.field_5919, 20, 0), new UseTrackerModule.WildClient(class_1294.field_5912, 240, 0))
      ),
      KILLER(
         "§4[★] §cKiller's Potion",
         List.of(new UseTrackerModule.WildClient(class_1294.field_5907, 180, 0), new UseTrackerModule.WildClient(class_1294.field_5910, 90, 3))
      ),
      BURP(
         "§c[★] §6Potion of Belching",
         List.of(
            new UseTrackerModule.WildClient(class_1294.field_5919, 10, 0),
            new UseTrackerModule.WildClient(class_1294.field_5912, 180, 0),
            new UseTrackerModule.WildClient(class_1294.field_5903, 90, 9),
            new UseTrackerModule.WildClient(class_1294.field_5909, 180, 2),
            new UseTrackerModule.WildClient(class_1294.field_5920, 30, 4)
         )
      ),
      SULFURIC_ACID(
         "§2[★] §aSulfuric Acid",
         List.of(
            new UseTrackerModule.WildClient(class_1294.field_5899, 50, 1),
            new UseTrackerModule.WildClient(class_1294.field_5909, 90, 3),
            new UseTrackerModule.WildClient(class_1294.field_5911, 90, 2),
            new UseTrackerModule.WildClient(class_1294.field_5920, 30, 4)
         )
      ),
      MEDIC(
         "§5[★] §dMedic's Potion",
         List.of(new UseTrackerModule.WildClient(class_1294.field_5914, 45, 2), new UseTrackerModule.WildClient(class_1294.field_5924, 45, 2))
      ),
      WINNER(
         "§2[★] §aVictor's Potion",
         List.of(
            new UseTrackerModule.WildClient(class_1294.field_5914, 180, 1),
            new UseTrackerModule.WildClient(class_1294.field_5905, 900, 0),
            new UseTrackerModule.WildClient(class_1294.field_5924, 60, 1),
            new UseTrackerModule.WildClient(class_1294.field_5907, 60, 0)
         )
      ),
      URINE(
         "§3[★] §bFlash's Urine",
         List.of(new UseTrackerModule.WildClient(class_1294.field_5913, 120, 1), new UseTrackerModule.WildClient(class_1294.field_5904, 120, 2))
      );

      final String primaryVal;
      private final List<UseTrackerModule.WildClient> secondaryVal;

      cursorVal(String var3, List<UseTrackerModule.WildClient> var4) {
         this.primaryVal = var3;
         this.secondaryVal = var4;
      }
   }
}
