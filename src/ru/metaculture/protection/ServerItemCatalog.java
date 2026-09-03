package ru.metaculture.protection;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import net.minecraft.class_1320;
import net.minecraft.class_1322;
import net.minecraft.class_1792;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1887;
import net.minecraft.class_2561;
import net.minecraft.class_2960;
import net.minecraft.class_5134;
import net.minecraft.class_6880;
import net.minecraft.class_9285;
import net.minecraft.class_9290;
import net.minecraft.class_9296;
import net.minecraft.class_9304;
import net.minecraft.class_9334;
import net.minecraft.class_9285.class_9287;

public class ServerItemCatalog {
   private static final String primaryVal = "holyworld:";
   private static final double secondaryVal = 1.0E-4;
   private static final Map<String, String> tertiaryVal = Map.of("sweeping", "sweeping_edge");
   private static final Map<String, List<String>> marginVal = Map.ofEntries(
      Map.entry(
         "spawner-getter-enchant",
         List.of(
            "spawner", "getspawner", "spawnergetter"
         )
      ),
      Map.entry("impenetrable-enchant-custom", List.of("unbreakable", "impenetrable")),
      Map.entry("drill-enchant-custom", List.of("drill", "bulldozer", "drill")),
      Map.entry("exp-enchant-custom", List.of("experienced", "experience", "exp")),
      Map.entry(
         "foundry-enchant-custom",
         List.of("autosmelt", "autosmelt", "foundry")
      ),
      Map.entry("internal-enchant-custom", List.of("internal", "builtin")),
      Map.entry("magnet-enchant-custom", List.of("magnet", "magnet")),
      Map.entry("critical-enchant-custom", List.of("crit", "critical")),
      Map.entry("destroyer-enchant-custom", List.of("destroyer", "destroyer")),
      Map.entry("rich-enchant-custom", List.of("rich", "rich")),
      Map.entry("mob-farmer-enchant", List.of("farmer", "farmer", "mobfarmer"))
   );
   static final Map<String, Integer> weightVal = new HashMap<>();
   private static final List<ServerItemCatalog.AccessGuardException> paramVal = List.of(
      secondaryVal("Infinity Helmet", class_1802.field_22027)
         .secondaryVal(
            "minecraft:blast_protection:5",
            "minecraft:projectile_protection:5",
            "minecraft:aqua_affinity:1",
            "minecraft:fire_protection:5",
            "minecraft:unbreaking:5",
            "minecraft:respiration:3",
            "minecraft:protection:5"
         )
         .primaryVal(primaryVal("minecraft:armor", 3.0), primaryVal("minecraft:armor_toughness", 3.0), primaryVal("minecraft:knockback_resistance", 0.1F))
         .primaryVal(new String[]{"Unbreakable II"})
         .secondaryVal(),
      secondaryVal("Infinity Chestplate", class_1802.field_22028)
         .secondaryVal(
            "minecraft:blast_protection:5",
            "minecraft:fire_protection:5",
            "minecraft:projectile_protection:5",
            "minecraft:unbreaking:5",
            "minecraft:protection:5"
         )
         .primaryVal(primaryVal("minecraft:armor", 8.0), primaryVal("minecraft:armor_toughness", 3.0), primaryVal("minecraft:knockback_resistance", 0.1F))
         .primaryVal(new String[]{"Unbreakable II"})
         .secondaryVal(),
      secondaryVal("Infinity Leggings", class_1802.field_22029)
         .secondaryVal(
            "minecraft:blast_protection:5",
            "minecraft:fire_protection:5",
            "minecraft:projectile_protection:5",
            "minecraft:unbreaking:5",
            "minecraft:protection:5"
         )
         .primaryVal(primaryVal("minecraft:armor", 6.0), primaryVal("minecraft:armor_toughness", 3.0), primaryVal("minecraft:knockback_resistance", 0.1F))
         .primaryVal(new String[]{"Unbreakable II"})
         .secondaryVal(),
      secondaryVal("Infinity Boots", class_1802.field_22030)
         .secondaryVal(
            "minecraft:blast_protection:5",
            "minecraft:projectile_protection:5",
            "minecraft:feather_falling:4",
            "minecraft:depth_strider:3",
            "minecraft:fire_protection:5",
            "minecraft:unbreaking:5",
            "minecraft:protection:5",
            "minecraft:soul_speed:3"
         )
         .primaryVal(primaryVal("minecraft:armor", 3.0), primaryVal("minecraft:armor_toughness", 3.0), primaryVal("minecraft:knockback_resistance", 0.1F))
         .primaryVal(new String[]{"Unbreakable II"})
         .secondaryVal(),
      secondaryVal("Infinity Talisman", class_1802.field_8288)
         .secondaryVal("minecraft:unbreaking:1")
         .primaryVal(new ServerItemCatalog.WildClient[]{primaryVal("minecraft:armor", 2.0)})
         .primaryVal(
            "• Max Health II",
            "• Armor II",
            "• Damage II",
            "• Speed II"
         )
         .secondaryVal(),
      secondaryVal("Eternity Pickaxe", class_1802.field_22024)
         .secondaryVal("minecraft:efficiency:10", "minecraft:fortune:5", "minecraft:unbreaking:5", "minecraft:mending:1")
         .primaryVal(primaryVal("minecraft:attack_damage", 5.0), primaryVal("minecraft:attack_speed", -2.8F))
         .primaryVal(
            "Magnetism I",
            "Unbreaking I",
            "Auto-smelting",
            "Experienced III",
            "Drill II"
         )
         .secondaryVal(),
      secondaryVal("Eternity Helmet", class_1802.field_22027)
         .secondaryVal(
            "minecraft:blast_protection:5",
            "minecraft:projectile_protection:5",
            "minecraft:aqua_affinity:1",
            "minecraft:fire_protection:5",
            "minecraft:unbreaking:5",
            "minecraft:respiration:3",
            "minecraft:protection:5"
         )
         .primaryVal(primaryVal("minecraft:armor", 3.0), primaryVal("minecraft:armor_toughness", 3.0), primaryVal("minecraft:knockback_resistance", 0.1F))
         .primaryVal(new String[]{"Unbreakable I"})
         .secondaryVal(),
      secondaryVal("Eternity Chestplate", class_1802.field_22028)
         .secondaryVal(
            "minecraft:blast_protection:5",
            "minecraft:fire_protection:5",
            "minecraft:projectile_protection:5",
            "minecraft:unbreaking:5",
            "minecraft:protection:5"
         )
         .primaryVal(primaryVal("minecraft:armor", 8.0), primaryVal("minecraft:armor_toughness", 3.0), primaryVal("minecraft:knockback_resistance", 0.1F))
         .primaryVal(new String[]{"Unbreakable I"})
         .secondaryVal(),
      secondaryVal("Eternity Leggings", class_1802.field_22029)
         .secondaryVal(
            "minecraft:blast_protection:5",
            "minecraft:fire_protection:5",
            "minecraft:projectile_protection:5",
            "minecraft:unbreaking:5",
            "minecraft:protection:5"
         )
         .primaryVal(primaryVal("minecraft:armor", 6.0), primaryVal("minecraft:armor_toughness", 3.0), primaryVal("minecraft:knockback_resistance", 0.1F))
         .primaryVal(new String[]{"Unbreakable I"})
         .secondaryVal(),
      secondaryVal("Eternity Boots", class_1802.field_22030)
         .secondaryVal(
            "minecraft:fire_protection:5",
            "minecraft:soul_speed:3",
            "minecraft:blast_protection:5",
            "minecraft:unbreaking:5",
            "minecraft:protection:5",
            "minecraft:projectile_protection:5",
            "minecraft:depth_strider:3",
            "minecraft:feather_falling:4"
         )
         .primaryVal(primaryVal("minecraft:armor", 3.0), primaryVal("minecraft:armor_toughness", 3.0), primaryVal("minecraft:knockback_resistance", 0.1F))
         .primaryVal(new String[]{"Unbreakable I"})
         .secondaryVal(),
      secondaryVal("Eternity Sword", class_1802.field_22022)
         .secondaryVal(
            "minecraft:smite:7",
            "minecraft:bane_of_arthropods:7",
            "minecraft:fire_aspect:2",
            "minecraft:mending:1",
            "minecraft:sweeping_edge:3",
            "minecraft:unbreaking:5",
            "minecraft:looting:5",
            "minecraft:sharpness:7"
         )
         .primaryVal(primaryVal("minecraft:attack_damage", 7.0), primaryVal("minecraft:attack_speed", -2.4F))
         .primaryVal(
            "Destroyer II",
            "Rich I",
            "Critical II"
         )
         .secondaryVal(),
      secondaryVal("Eternity Talisman", class_1802.field_8288)
         .secondaryVal("minecraft:unbreaking:1")
         .primaryVal(new ServerItemCatalog.WildClient[]{primaryVal("minecraft:armor", 2.0)})
         .primaryVal(
            "• Speed II", "• Damage II", "• Armor II"
         )
         .secondaryVal(),
      secondaryVal("Sphere of Eternity", class_1802.field_8575)
         .primaryVal(new ServerItemCatalog.WildClient[]{primaryVal("minecraft:armor", 2.0)})
         .primaryVal(
            "• Armor II", "• Speed II", "• Damage II"
         )
         .primaryVal(
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGM5MzY1NjQyYzZlZGRjZmVkZjViNWUxNGUyYmM3MTI1N2Q5ZTRhMzM2M2QxMjNjNmYzM2M1NWNhZmJmNmQifX19"
         )
         .secondaryVal(),
      secondaryVal("Stinger Pickaxe", class_1802.field_22024)
         .secondaryVal("minecraft:efficiency:8", "minecraft:unbreaking:4", "minecraft:mending:1", "minecraft:fortune:4")
         .primaryVal(primaryVal("minecraft:attack_damage", 5.0), primaryVal("minecraft:attack_speed", -2.8F))
         .primaryVal(
            "Unbreaking I",
            "Auto-smelting",
            "Experienced III",
            "Drill I"
         )
         .secondaryVal(),
      secondaryVal("Stinger Helmet", class_1802.field_22027)
         .secondaryVal(
            "minecraft:fire_protection:4",
            "minecraft:blast_protection:4",
            "minecraft:aqua_affinity:1",
            "minecraft:unbreaking:4",
            "minecraft:protection:5",
            "minecraft:projectile_protection:4",
            "minecraft:respiration:3"
         )
         .primaryVal(primaryVal("minecraft:armor", 3.0), primaryVal("minecraft:armor_toughness", 3.0), primaryVal("minecraft:knockback_resistance", 0.1F))
         .secondaryVal(),
      secondaryVal("Stinger Chestplate", class_1802.field_22028)
         .secondaryVal(
            "minecraft:blast_protection:4",
            "minecraft:fire_protection:4",
            "minecraft:unbreaking:4",
            "minecraft:protection:5",
            "minecraft:projectile_protection:4"
         )
         .primaryVal(primaryVal("minecraft:armor", 8.0), primaryVal("minecraft:armor_toughness", 3.0), primaryVal("minecraft:knockback_resistance", 0.1F))
         .primaryVal(new String[]{"Unbreakable I"})
         .secondaryVal(),
      secondaryVal("Stinger Leggings", class_1802.field_22029)
         .secondaryVal(
            "minecraft:blast_protection:4",
            "minecraft:fire_protection:4",
            "minecraft:unbreaking:4",
            "minecraft:protection:4",
            "minecraft:projectile_protection:4"
         )
         .primaryVal(primaryVal("minecraft:armor", 6.0), primaryVal("minecraft:armor_toughness", 3.0), primaryVal("minecraft:knockback_resistance", 0.1F))
         .primaryVal(new String[]{"Unbreakable I"})
         .secondaryVal(),
      secondaryVal("Stinger Boots", class_1802.field_22030)
         .secondaryVal(
            "minecraft:fire_protection:4",
            "minecraft:soul_speed:3",
            "minecraft:blast_protection:4",
            "minecraft:unbreaking:4",
            "minecraft:protection:4",
            "minecraft:projectile_protection:4",
            "minecraft:depth_strider:3",
            "minecraft:feather_falling:4"
         )
         .primaryVal(primaryVal("minecraft:armor", 3.0), primaryVal("minecraft:armor_toughness", 3.0), primaryVal("minecraft:knockback_resistance", 0.1F))
         .secondaryVal(),
      secondaryVal("Stinger Sword", class_1802.field_22022)
         .secondaryVal(
            "minecraft:smite:7",
            "minecraft:bane_of_arthropods:7",
            "minecraft:fire_aspect:2",
            "minecraft:mending:1",
            "minecraft:sweeping_edge:3",
            "minecraft:unbreaking:4",
            "minecraft:looting:5",
            "minecraft:sharpness:6"
         )
         .primaryVal(primaryVal("minecraft:attack_damage", 7.0), primaryVal("minecraft:attack_speed", -2.4F))
         .primaryVal("Rich I", "Critical II")
         .secondaryVal(),
      secondaryVal("Stinger Talisman", class_1802.field_8288)
         .secondaryVal("minecraft:unbreaking:1")
         .primaryVal(new ServerItemCatalog.WildClient[]{primaryVal("minecraft:armor", 2.0)})
         .primaryVal(
            "• Speed I", "• Armor II", "• Damage II"
         )
         .secondaryVal(),
      secondaryVal("Sphere of the Stinger", class_1802.field_8575)
         .primaryVal(new ServerItemCatalog.WildClient[]{primaryVal("minecraft:armor", 2.0)})
         .primaryVal(
            "• Armor II", "• Speed I", "• Damage II"
         )
         .primaryVal(
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGM5MzY1NjQyYzZlZGRjZmVkZjViNWUxNGUyYmM3MTI1N2Q5ZTRhMzM2M2QxMjNjNmYzM2M1NWNhZmJmNmQifX19"
         )
         .secondaryVal(),
      secondaryVal("Sphere of Cerberus", class_1802.field_8575)
         .primaryVal(new ServerItemCatalog.WildClient[]{primaryVal("minecraft:waypoint_transmit_range", -1.0)})
         .primaryVal(
            "Curse of Vanishing",
            "• Haste I",
            "• Damage V"
         )
         .primaryVal(
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjA5NWE3ZmQ5MGRhYTFiYmU3MDY5MDg5NzQwZTA1ZDBiZmM2NjI5NmVlM2M0MGVlNzFhNGUwYTY2MTZiMmJiYyJ9fX0="
         )
         .secondaryVal(),
      secondaryVal("Sphere of the Flash", class_1802.field_8575)
         .primaryVal(new ServerItemCatalog.WildClient[]{primaryVal("minecraft:armor", 1.0)})
         .primaryVal(
            "Curse of Vanishing",
            "• Armor I",
            "• Speed III"
         )
         .primaryVal(
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzc0MDBlYTE5ZGJkODRmNzVjMzlhZDY4MjNhYzRlZjc4NmYzOWY0OGZjNmY4NDYwMjM2NmFjMjliODM3NDIyIn19fQ=="
         )
         .secondaryVal(),
      secondaryVal("Legendary Sphere", class_1802.field_8575)
         .primaryVal(new ServerItemCatalog.WildClient[]{primaryVal("minecraft:waypoint_transmit_range", -1.0)})
         .primaryVal(new String[]{"• Damage III"})
         .primaryVal(
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGM5MzY1NjQyYzZlZGRjZmVkZjViNWUxNGUyYmM3MTI1N2Q5ZTRhMzM2M2QxMjNjNmYzM2M1NWNhZmJmNmQifX19"
         )
         .secondaryVal(),
      secondaryVal("Mythical Sphere", class_1802.field_8575)
         .primaryVal(new ServerItemCatalog.WildClient[]{primaryVal("minecraft:armor", 2.0)})
         .primaryVal("• Armor II", "• Damage III")
         .primaryVal(
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmFmZjJlYjQ5OGU1YzZhMDQ0ODRmMGM5Zjc4NWI0NDg0NzlhYjIxM2RmOTVlYzkxMTc2YTMwOGExMmFkZDcwIn19fQ=="
         )
         .secondaryVal(),
      secondaryVal("Mythical Sphere", class_1802.field_8575)
         .primaryVal(new ServerItemCatalog.WildClient[]{primaryVal("minecraft:armor", 3.0)})
         .primaryVal("• Speed II", "• Armor III")
         .primaryVal(
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmFmZjJlYjQ5OGU1YzZhMDQ0ODRmMGM5Zjc4NWI0NDg0NzlhYjIxM2RmOTVlYzkxMTc2YTMwOGExMmFkZDcwIn19fQ=="
         )
         .secondaryVal(),
      secondaryVal("Golden Spawner", class_1802.field_8849)
         .primaryVal(
            "Features:",
            "virtually farms mobs",
            ".  without spawning entities;",
            "loot and experience accumulate",
            ".  in internal storage;",
            "inserting an egg may",
            ".  break the spawner.",
            "Destruction chance: 50.6%"
         )
         .secondaryVal(),
      secondaryVal("Explosive substance", class_1802.field_19060)
         .primaryVal(
            "Features:",
            "used only for crafting",
            ".   explosive items;",
            "can be crafted back into 9 gunpowder."
         )
         .secondaryVal(),
      secondaryVal("100", class_1802.field_8287)
         .primaryVal(
            "The bottle contains 30971 experience (level 100)",
            "Throw the bottle to get experience"
         )
         .secondaryVal(),
      secondaryVal("Mysterious Spawner", class_1802.field_8849)
         .primaryVal(
            "Potential contents:",
            "• Brutal Piglin — 25.0%",
            "• Witch — 7.0%",
            "• Blaze — 20.0%",
            "• Zombie — 18.0%",
            "• Skeleton — 30.0%",
            "▍ May contain a random mob,",
            "▍ with a chance from the list above."
         )
         .secondaryVal(),
      secondaryVal(
            "Mysterious Spawn Egg",
            class_1802.field_8254
         )
         .primaryVal(
            "Potential contents:",
            "• Brutal Piglin — 25.0%",
            "• Witch — 7.0%",
            "• Blaze — 20.0%",
            "• Zombie — 18.0%",
            "• Skeleton — 30.0%",
            "▍ May contain a random mob,",
            "▍ with a chance from the list above."
         )
         .secondaryVal(),
      secondaryVal(
            "Mysterious Spawn Egg",
            class_1802.field_8503
         )
         .primaryVal(
            "Potential contents:",
            "• Brutal Piglin — 33.0%",
            "• Creeper — 2.0%",
            "• Blaze — 17.5%",
            "• Zombie — 17.5%",
            "• Skeleton — 30.0%",
            "▍ May contain a random mob,",
            "▍ with a chance from the list above."
         )
         .secondaryVal(),
      secondaryVal(
            "Mysterious Spawn Egg",
            class_1802.field_25777
         )
         .primaryVal(
            "Potential contents:",
            "• Brutal Piglin — 50.0%",
            "• Witch — 4.0%",
            "• Mini-Zombie — 20.0%",
            "• Creeper — 1.0%",
            "• Blaze — 25.0%",
            "▍ May contain a random mob,",
            "▍ with a chance from the list above."
         )
         .secondaryVal(),
      secondaryVal("Rag", class_1802.field_8882).secondaryVal(),
      secondaryVal(
            "Snowball",
            class_1802.field_8543,
            "Freezing Snowball",
            "Freezing Snowball"
         )
         .secondaryVal(),
      secondaryVal("Stun", class_1802.field_8137).secondaryVal(),
      secondaryVal(
            "Explosive Rag",
            class_1802.field_8662,
            new String[]{"Explosive"}
         )
         .secondaryVal(),
      secondaryVal("C4", class_1802.field_8626)
         .primaryVal(
            "Features:",
            "destroys netherite claim blocks;",
            "explodes obsidian blocks."
         )
         .secondaryVal(),
      secondaryVal("Justice", class_1802.field_8574)
         .primaryVal(
            "Features:",
            "when the item is in your inventory, you gain",
            ".   protection from various debuffs: blindness",
            ".   bounciness, poison, wither",
            ".   slowness and weakness."
         )
         .secondaryVal(),
      secondaryVal("Armored Elytra", class_1802.field_8833)
         .primaryVal(new ServerItemCatalog.WildClient[]{primaryVal("minecraft:armor", 8.0)})
         .primaryVal(
            "Features:",
            "has the properties of a diamond chestplate;",
            "allows flying like a regular elytra;",
            "enchantments can be applied."
         )
         .secondaryVal(),
      secondaryVal("Eternity Crossbow", class_1802.field_8399)
         .secondaryVal("minecraft:piercing:5", "minecraft:multishot:1", "minecraft:unbreaking:3", "minecraft:quick_charge:3")
         .primaryVal(new String[]{"Stun II"})
         .secondaryVal(),
      secondaryVal(
            "Sphere of ᴀʀᴍᴏʀᴛᴀʟɪᴛʏ",
            class_1802.field_8575,
            "Sphere of armortlity",
            "Sphere of armortality"
         )
         .primaryVal(new ServerItemCatalog.WildClient[]{primaryVal("minecraft:armor", 2.0)})
         .primaryVal(
            "• Armor II",
            "• Max Health II",
            "• Damage II"
         )
         .primaryVal(
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWE2MmI5ZGU2YTI2Yjg2ODY5Y2EyMmVhNDBmMWJkZTgwYTA0MzBhNTQ1NDdiZWNjZThmZGE4NzA3Nzc3MjU4ZiJ9fX0="
         )
         .secondaryVal(),
      secondaryVal("Sphere of immortality", class_1802.field_8575)
         .primaryVal(new ServerItemCatalog.WildClient[]{primaryVal("minecraft:waypoint_transmit_range", -1.0)})
         .primaryVal("• Speed II", "• Damage III")
         .primaryVal(
            "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODNlZDRjZTIzOTMzZTY2ZTA0ZGYxNjA3MDY0NGY3NTk5ZWViNTUzMDdmN2VhZmU4ZDkyZjQwZmIzNTIwODYzYyJ9fX0="
         )
         .secondaryVal(),
      secondaryVal("15", class_1802.field_8287)
         .primaryVal(
            "The bottle contains 315 experience (level 15)",
            "Throw the bottle to get experience"
         )
         .secondaryVal(),
      secondaryVal("50", class_1802.field_8287)
         .primaryVal(
            "The bottle contains 5345 experience (level 50)",
            "Throw the bottle to get experience"
         )
         .secondaryVal(),
      secondaryVal("Special Compass", class_1802.field_8251)
         .secondaryVal("minecraft:luck_of_the_sea:1")
         .primaryVal(
            "Features:",
            "- leads to the nearest or a random",
            "- can be used once every 8 hours."
         )
         .secondaryVal(),
      secondaryVal("TNT Cannon", class_1802.field_8357)
         .secondaryVal("minecraft:soul_speed:10")
         .primaryVal(
            "Features:",
            "- launches flying dynamite",
            ".   at a speed of up to 5 blocks per second;",
            "- retains properties when launched",
            ".   of special dynamite and pyrotechnics;",
            "- can be broken in someone else's claim.",
            "● This item can"
         )
         .secondaryVal(),
      secondaryVal("Infinity Sword", class_1802.field_22022)
         .secondaryVal(
            "minecraft:sharpness:8",
            "minecraft:unbreaking:5",
            "minecraft:mending:1",
            "minecraft:fire_aspect:2",
            "minecraft:bane_of_arthropods:7",
            "minecraft:sweeping_edge:3",
            "minecraft:smite:7",
            "minecraft:looting:5"
         )
         .primaryVal(primaryVal("minecraft:attack_damage", 7.0), primaryVal("minecraft:attack_speed", -2.4F))
         .primaryVal(
            "Rich VI",
            "Destroyer II",
            "Critical II"
         )
         .secondaryVal(),
      secondaryVal("Sword of Cerberus ", class_1802.field_22022)
         .secondaryVal(
            "minecraft:sharpness:9",
            "minecraft:unbreaking:5",
            "minecraft:mending:1",
            "minecraft:fire_aspect:2",
            "minecraft:bane_of_arthropods:7",
            "minecraft:sweeping_edge:3",
            "minecraft:smite:7",
            "minecraft:looting:5"
         )
         .primaryVal(primaryVal("minecraft:attack_damage", 7.0), primaryVal("minecraft:attack_speed", -2.4F))
         .primaryVal(
            "Rich VI",
            "Destroyer III",
            "Critical II",
            "● This item can"
         )
         .secondaryVal(),
      secondaryVal("Indestructible Elytra", class_1802.field_8833).secondaryVal(),
      secondaryVal("Sword of Profitable Farming", class_1802.field_22022)
         .primaryVal(primaryVal("minecraft:attack_damage", 7.0), primaryVal("minecraft:attack_speed", -2.4F))
         .primaryVal(
            "Farmer II",
            "● This item can"
         )
         .secondaryVal(),
      secondaryVal(
            "Infinity Backpack",
            class_1802.field_8548,
            new String[]{"- Iɴғɪɴɪᴛʏ Backpack -"}
         )
         .primaryVal(
            "Features:",
            "- cannot be placed on the ground;",
            "- capacity 36 slots;",
            "● This item can"
         )
         .secondaryVal(),
      secondaryVal(
            "Backpack level 1",
            class_1802.field_8520,
            "Backpack level I",
            "Backpack (level I)"
         )
         .primaryVal(
            "Features:",
            "- cannot be placed on the ground;",
            "- capacity 9 slots;"
         )
         .secondaryVal(),
      secondaryVal(
            "Backpack level 2",
            class_1802.field_8829,
            "Backpack level II",
            "Backpack (level II)"
         )
         .primaryVal(
            "Features:",
            "- cannot be placed on the ground;",
            "- capacity 15 slots;"
         )
         .secondaryVal(),
      secondaryVal(
            "Backpack level 3",
            class_1802.field_8676,
            "Backpack level III",
            "Backpack (level III)"
         )
         .primaryVal(
            "Features:",
            "- cannot be placed on the ground;",
            "- capacity 21 slots;",
            "● This item can"
         )
         .secondaryVal(),
      secondaryVal(
            "Backpack level 4",
            class_1802.field_8050,
            "Backpack level IV",
            "Backpack (level IV)"
         )
         .primaryVal(
            "Features:",
            "- cannot be placed on the ground;",
            "- capacity 27 slots;",
            "● This item can"
         )
         .secondaryVal(),
      secondaryVal("Rune of Immortality", class_1802.field_8492)
         .secondaryVal("minecraft:luck_of_the_sea:1")
         .primaryVal(
            "Rune effect",
            "Features:",
            "after activating a totem with this effect,",
            ".   you gain immunity to damage",
            ".   lasting 3 seconds;",
            "the ability to apply this effect",
            ".   to a totem via an anvil;"
         )
         .secondaryVal(),
      secondaryVal("Healing Potion", class_1802.field_8574).secondaryVal(),
      secondaryVal("Turtle Master Potion", class_1802.field_8574)
         .secondaryVal(),
      secondaryVal("Turtle Master Potion", class_1802.field_8574)
         .secondaryVal(),
      secondaryVal("Ender Pearl", class_1802.field_8634).secondaryVal(),
      secondaryVal("Dynamite a", class_1802.field_8626)
         .primaryVal(
            "Features:",
            "has a 3x larger explosion radius."
         )
         .secondaryVal(),
      secondaryVal("Dynamite b", class_1802.field_8626)
         .primaryVal(
            "Features:",
            "has a 10x larger explosion radius."
         )
         .secondaryVal(),
      secondaryVal("Dynamite b2", class_1802.field_8626)
         .primaryVal(
            "Features:",
            "explodes almost all blocks",
            ".   within a 12 block radius;",
            "does not work on all standard",
            ".   claimed territories;"
         )
         .secondaryVal(),
      secondaryVal("C4 explosive", class_1802.field_8626)
         .primaryVal(
            "Features:",
            "destroys netherite claim blocks;",
            "explodes obsidian blocks."
         )
         .secondaryVal()
   );
   private static final Map<String, ServerItemCatalog.AccessGuardException> extraVal = secondaryVal();

   public static List<ServerItemCatalog.AccessGuardException> primaryVal() {
      return paramVal;
   }

   public static boolean primaryVal(String var0) {
      return var0 != null && var0.startsWith("holyworld:");
   }

   public static boolean secondaryVal(String var0) {
      return tertiaryVal(var0) != null;
   }

   public static ServerItemCatalog.AccessGuardException tertiaryVal(String var0) {
      if (var0 != null && !var0.isBlank()) {
         ServerItemCatalog.AccessGuardException var1 = extraVal.get(var0);
         return var1 != null ? var1 : extraVal.get(holderVal(blockRef(var0)));
      } else {
         return null;
      }
   }

   public static String marginVal(String var0) {
      ServerItemCatalog.AccessGuardException var1 = tertiaryVal(var0);
      return var1 == null ? var0 : var1.label();
   }

   public static String weightVal(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String[] var1 = var0.split(":");
         return var1.length >= 2 ? speedVal(var1[0] + ":" + var1[1]) : speedVal(var0);
      } else {
         return "";
      }
   }

   public static class_1799 paramVal(String var0) {
      ServerItemCatalog.AccessGuardException var1 = tertiaryVal(var0);
      if (var1 == null) {
         return class_1799.field_8037;
      } else {
         return var1.item() == class_1802.field_8575 && var1.texture() != null && !var1.texture().isBlank()
            ? secondaryVal(var1.texture(), var1.label())
            : new class_1799(var1.item());
      }
   }

   public static boolean primaryVal(class_1799 var0) {
      return primaryVal("Rag", var0);
   }

   public static boolean secondaryVal(class_1799 var0) {
      return primaryVal("Snowball", var0);
   }

   public static boolean tertiaryVal(class_1799 var0) {
      return primaryVal("Stun", var0);
   }

   public static boolean marginVal(class_1799 var0) {
      return primaryVal("Explosive Rag", var0);
   }

   public static boolean primaryVal(String var0, class_1799 var1, String var2) {
      ServerItemCatalog.AccessGuardException var3 = tertiaryVal(var0);
      if (var3 != null && var1 != null && !var1.method_7960() && var1.method_31574(var3.item())) {
         String var4 = holderVal(var2);
         if (var4.isEmpty()) {
            var4 = holderVal(var1.method_7964().getString());
         }

         String var5 = holderVal(extraVal(var1));
         return secondaryVal(var3, var1, var4, var5);
      } else {
         return false;
      }
   }

   private static boolean primaryVal(String var0, class_1799 var1) {
      ServerItemCatalog.AccessGuardException var2 = tertiaryVal(var0);
      return var2 != null && primaryVal(var2, var1, weightVal(var1), paramVal(var1));
   }

   public static boolean primaryVal(ServerItemCatalog.AccessGuardException var0, class_1799 var1, String var2, String var3) {
      return primaryVal(var0, var1, var2, var3, true, true, true, true);
   }

   public static boolean primaryVal(ServerItemCatalog.AccessGuardException var0, class_1799 var1, String var2, String var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      if (var0 != null && var1 != null && !var1.method_7960() && var1.method_31574(var0.item())) {
         String var8 = var2 == null ? "" : var2;
         if (var8.isEmpty()) {
            var8 = holderVal(var1.method_7964().getString());
         }

         String var9 = var3 == null ? "" : var3;
         if (var9.isEmpty()) {
            var9 = var8;
         }

         return secondaryVal(var0, var1, var8, var9, var4, var5, var6, var7);
      } else {
         return false;
      }
   }

   public static boolean primaryVal(ServerItemCatalog.AccessGuardException var0, class_1799 var1, String var2, String var3, Set<String> var4) {
      if (var0 != null && var1 != null && !var1.method_7960() && var1.method_31574(var0.item())) {
         String var5 = var2 == null ? "" : var2;
         if (var5.isEmpty()) {
            var5 = holderVal(var1.method_7964().getString());
         }

         String var6 = var3 == null ? "" : var3;
         if (var6.isEmpty()) {
            var6 = var5;
         }

         return secondaryVal(var0, var1, var5, var6, var4);
      } else {
         return false;
      }
   }

   public static String weightVal(class_1799 var0) {
      if (var0 != null && !var0.method_7960()) {
         StringBuilder var1 = new StringBuilder();
         var1.append(var0.method_7964().getString()).append(' ');
         class_9290 var2 = (class_9290)var0.method_58694(class_9334.field_49632);
         if (var2 != null) {
            for (class_2561 var4 : var2.comp_2400()) {
               var1.append(var4.getString()).append(' ');
            }
         }

         return holderVal(var1.toString());
      } else {
         return "";
      }
   }

   public static String paramVal(class_1799 var0) {
      return var0 != null && !var0.method_7960() ? holderVal(extraVal(var0)) : "";
   }

   public static String extraVal(String var0) {
      return var0 == null ? "" : anchorVal(timerVal(var0)).trim();
   }

   private static boolean secondaryVal(ServerItemCatalog.AccessGuardException var0, class_1799 var1, String var2, String var3) {
      if (primaryVal(var0, var2)) {
         return false;
      }

      if (var3.isEmpty()) {
         var3 = var2;
      }

      boolean var4 = primaryVal(var2, var0.aliases());
      if (!var4) {
         return false;
      } else {
         return !var0.hasRequirements() ? true : secondaryVal(var0, var1, var2, var3, true, true, true, true);
      }
   }

   private static boolean secondaryVal(ServerItemCatalog.AccessGuardException var0, class_1799 var1, String var2, String var3, boolean var4, boolean var5, boolean var6, boolean var7) {
      if (primaryVal(var0, var2)) {
         return false;
      }

      if (var3.isEmpty()) {
         var3 = var2;
      }

      boolean var8 = primaryVal(var2, var0.aliases());
      if (!var8) {
         return false;
      } else {
         return !var0.hasRequirements()
            ? true
            : (!var4 || secondaryVal(var0, var3))
               && (!var5 || primaryVal(var0, var1, var3))
               && (!var6 || secondaryVal(var0, var1, var3))
               && (!var7 || tertiaryVal(var0, var1, var3));
      }
   }

   private static boolean secondaryVal(ServerItemCatalog.AccessGuardException var0, class_1799 var1, String var2, String var3, Set<String> var4) {
      if (primaryVal(var0, var2)) {
         return false;
      }

      if (var3.isEmpty()) {
         var3 = var2;
      }

      boolean var5 = primaryVal(var2, var0.aliases());
      if (!var5) {
         return false;
      } else {
         return !var0.hasRequirements()
            ? true
            : secondaryVal(var0, var3) && primaryVal(var0, var1, var3) && primaryVal(var0, var1, var3, var4) && tertiaryVal(var0, var1, var3);
      }
   }

   private static boolean primaryVal(ServerItemCatalog.AccessGuardException var0, String var1) {
      String var2 = holderVal(var0.label());
      return var2.equals("elytra")
            && var1.contains("armoredelytra")
         || var2.equals("dynamiteb") && var1.contains("dynamiteb2")
         || var2.equals("turtlemasterpotion")
            && (
               var1.contains("turtlemasterpotionii")
                  || var1.contains("turtlemasterii")
                  || var1.contains("turtlemaster2")
            );
   }

   private static boolean secondaryVal(ServerItemCatalog.AccessGuardException var0, String var1) {
      for (String var3 : var0.lore()) {
         String var4 = holderVal(var3);
         if (!var4.isEmpty() && !var1.contains(var4)) {
            return false;
         }
      }

      return true;
   }

   private static boolean primaryVal(ServerItemCatalog.AccessGuardException var0, class_1799 var1, String var2) {
      for (ServerItemCatalog.WildClient var4 : var0.attributes()) {
         if (!primaryVal(var1, var4) && !primaryVal(var4, var2)) {
            return false;
         }
      }

      return true;
   }

   private static boolean secondaryVal(ServerItemCatalog.AccessGuardException var0, class_1799 var1, String var2) {
      for (String var4 : var0.enchantments()) {
         ServerItemCatalog.DelayedFuse var5 = widthVal(var4);
         if (var5 != null) {
            if (limitVal(var5.id())) {
               if (!primaryVal(var1, var5.id(), var5.level()) && !primaryVal(var2, var5.raw())) {
                  return false;
               }
            } else {
               boolean var6 = primaryVal(var2, var5.raw()) || primaryVal(var2, var5);
               if (var0.strictCheck() && !var6) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   private static boolean primaryVal(ServerItemCatalog.AccessGuardException var0, class_1799 var1, String var2, Set<String> var3) {
      for (String var5 : var0.enchantments()) {
         if (var3 == null || var3.contains(weightVal(var5))) {
            ServerItemCatalog.DelayedFuse var6 = widthVal(var5);
            if (var6 != null) {
               if (limitVal(var6.id())) {
                  if (!primaryVal(var1, var6.id(), var6.level()) && !primaryVal(var2, var6.raw())) {
                     return false;
                  }
               } else {
                  boolean var7 = primaryVal(var2, var6.raw()) || primaryVal(var2, var6);
                  if (var0.strictCheck() && !var7) {
                     return false;
                  }
               }
            }
         }
      }

      return true;
   }

   private static boolean tertiaryVal(ServerItemCatalog.AccessGuardException var0, class_1799 var1, String var2) {
      if (var0.effects().isEmpty()) {
         return true;
      }

      boolean var3 = var2.contains("hms")
         || var1.method_58694(class_9334.field_49636) != null
         || primaryVal(
            var2,
            List.of(
               "damage",
               "armor",
               "speed",
               "health",
               "damage",
               "armor",
               "speed",
               "health"
            )
         );
      if (!var3) {
         return true;
      }

      for (String var5 : var0.effects()) {
         if (!secondaryVal(var5, var1, var2)) {
            return false;
         }
      }

      return true;
   }

   private static boolean secondaryVal(String var0, class_1799 var1, String var2) {
      String var3 = holderVal(var0);
      if (!var3.isEmpty() && var2.contains(var3)) {
         return true;
      }

      ServerItemCatalog.VvunVVUvUNnv var4 = chunkVal(var0);
      if (var4 == null) {
         return true;
      }

      class_6880 var5 = switch (var4.type()) {
         case "damage" -> class_5134.field_23721;
         case "armor" -> class_5134.field_23724;
         case "speed" -> class_5134.field_23719;
         case "health" -> class_5134.field_23716;
         default -> null;
      };
      return var5 != null && primaryVal(var1, var5, var4.level()) ? true : primaryVal(var2, var4.type(), var4.level());
   }

   private static boolean primaryVal(String var0, String var1, double var2) {
      String var4 = primaryVal(var2);
      String var5 = primaryVal((int)var2);

      for (String var11 : switch (var1) {
         case "damage" -> List.of("damage", "damage");
         case "armor" -> List.of("armor", "armor");
         case "speed" -> List.of("speed", "speed");
         case "health" -> List.of("health", "health");
         default -> List.of(var1);
      }) {
         String var9 = holderVal(var11);
         if (var0.contains(var9 + var4) || var0.contains(var4 + var9) || !var5.isEmpty() && (var0.contains(var9 + var5) || var0.contains(var5 + var9))) {
            return true;
         }
      }

      return false;
   }

   private static boolean primaryVal(String var0, ServerItemCatalog.DelayedFuse var1) {
      List<String> var2 = marginVal.getOrDefault(var1.id(), List.of());
      if (var2.isEmpty()) {
         return false;
      }

      String var3 = primaryVal((double)var1.level());
      String var4 = primaryVal(var1.level());

      for (String var6 : var2) {
         String var7 = holderVal(var6);
         if (!var7.isEmpty()) {
            if (!var0.contains(var7 + var3) && !var0.contains(var3 + var7)) {
               if (var4.isEmpty() || !var0.contains(var7 + var4) && !var0.contains(var4 + var7)) {
                  if (var1.level() <= 1 && var0.contains(var7)) {
                     return true;
                  }
                  continue;
               }

               return true;
            }

            return true;
         }
      }

      return false;
   }

   private static boolean primaryVal(String var0, String var1) {
      String var2 = holderVal(var1);
      return !var2.isEmpty() && var0.contains(var2);
   }

   private static boolean primaryVal(ServerItemCatalog.WildClient var0, String var1) {
      String var2 = secondaryVal(var0.value());
      String var3 = primaryVal(var0);
      if (!var3.isEmpty()) {
         if (var1.contains(var3 + var2)) {
            return true;
         }

         if (var1.contains(var2 + var3)) {
            return true;
         }
      }

      return false;
   }

   private static boolean primaryVal(class_1799 var0, ServerItemCatalog.WildClient var1) {
      class_9285 var2 = (class_9285)var0.method_58694(class_9334.field_49636);
      if (var2 == null) {
         return false;
      }

      for (class_9287 var4 : var2.comp_2393()) {
         class_1322 var5 = var4.comp_2396();
         if (primaryVal(var1, var4.comp_2395()) && Math.abs(var5.comp_2449() - var1.value()) <= 1.0E-4) {
            return true;
         }
      }

      return false;
   }

   private static boolean primaryVal(class_1799 var0, class_6880<class_1320> var1, double var2) {
      class_9285 var4 = (class_9285)var0.method_58694(class_9334.field_49636);
      if (var4 == null) {
         return false;
      }

      for (class_9287 var6 : var4.comp_2393()) {
         class_1322 var7 = var6.comp_2396();
         if (var6.comp_2395().equals(var1) && Math.abs(var7.comp_2449() - var2) <= 1.0E-4) {
            return true;
         }
      }

      return false;
   }

   private static boolean primaryVal(ServerItemCatalog.WildClient var0, class_6880<class_1320> var1) {
      if (var0.attribute() != null && var0.attribute().equals(var1)) {
         return true;
      }

      String var2 = weightRef(var0.id());
      String var3 = weightRef(secondaryVal(var1));
      return !var2.isEmpty() && var2.equals(var3);
   }

   private static boolean primaryVal(class_1799 var0, String var1, int var2) {
      class_9304 var3 = (class_9304)var0.method_58694(class_9334.field_49633);
      if (var3 != null && !var3.method_57543()) {
         String var4 = speedVal(var1);

         for (Entry var6 : var3.method_57539()) {
            String var7 = primaryVal((class_6880<class_1887>)var6.getKey());
            if (var4.equals(speedVal(var7)) && var6.getIntValue() >= var2) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private static String primaryVal(class_6880<class_1887> var0) {
      Optional<class_2960> var1 = var0.method_40230().map(var0x -> var0x.method_29177());
      return var1.<String>map(class_2960::toString).orElse("");
   }

   private static boolean limitVal(String var0) {
      String var1 = speedVal(var0);

      return switch (var1) {
         case "aqua_affinity", "blast_protection", "depth_strider", "efficiency", "feather_falling", "fire_aspect", "fire_protection", "fortune", "luck_of_the_sea", "looting", "mending", "projectile_protection", "protection", "respiration", "sharpness", "smite", "soul_speed", "sweeping_edge", "thorns", "unbreaking", "bane_of_arthropods" -> true;
         default -> false;
      };
   }

   private static String speedVal(String var0) {
      String var1 = var0 == null ? "" : var0.toLowerCase(Locale.ROOT).trim();
      int var2 = var1.indexOf(58);
      if (var2 >= 0 && var1.substring(0, var2).indexOf(45) < 0) {
         var1 = var1.substring(var2 + 1);
      }

      return tertiaryVal.getOrDefault(var1, var1);
   }

   private static ServerItemCatalog.DelayedFuse widthVal(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String var1 = var0.trim();
         int var2 = var1.lastIndexOf(58);
         String var3 = var2 > 0 ? var1.substring(0, var2).trim().toLowerCase(Locale.ROOT) : var1.toLowerCase(Locale.ROOT);
         int var4 = 1;
         if (var2 > 0 && var2 < var1.length() - 1) {
            try {
               var4 = Integer.parseInt(var1.substring(var2 + 1).replaceAll("[^0-9]", ""));
            } catch (NumberFormatException var6) {
               var4 = 1;
            }
         }

         return new ServerItemCatalog.DelayedFuse(var0, var3, Math.max(1, var4));
      } else {
         return null;
      }
   }

   private static ServerItemCatalog.VvunVVUvUNnv chunkVal(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String[] var1 = var0.split(":", 2);
         if (var1.length != 2) {
            return null;
         }

         String var2 = var1[0].toLowerCase(Locale.ROOT).replace("hms-", "").trim();

         try {
            return new ServerItemCatalog.VvunVVUvUNnv(var2, Double.parseDouble(var1[1].replace(',', '.')));
         } catch (NumberFormatException var4) {
            return null;
         }
      } else {
         return null;
      }
   }

   private static Map<String, ServerItemCatalog.AccessGuardException> secondaryVal() {
      HashMap var0 = new HashMap();

      for (ServerItemCatalog.AccessGuardException var2 : paramVal) {
         var0.put(var2.key(), var2);
         var0.put(holderVal(var2.label()), var2);

         for (String var4 : var2.aliases()) {
            if (!var4.isEmpty()) {
               var0.putIfAbsent(var4, var2);
            }
         }
      }

      return Map.copyOf(var0);
   }

   private static ServerItemCatalog.AccessGuardException primaryVal(String var0, class_1792 var1, String... var2) {
      return secondaryVal(var0, var1, var2).secondaryVal();
   }

   private static ServerItemCatalog.cursorVal secondaryVal(String var0, class_1792 var1, String... var2) {
      return new ServerItemCatalog.cursorVal(var0, var1, var2);
   }

   private static ServerItemCatalog.WildClient primaryVal(class_6880<class_1320> var0, double var1) {
      return new ServerItemCatalog.WildClient(var0, secondaryVal(var0), var1);
   }

   private static ServerItemCatalog.WildClient primaryVal(String var0, double var1) {
      return new ServerItemCatalog.WildClient(null, var0, var1);
   }

   private static class_1799 secondaryVal(String var0, String var1) {
      class_1799 var2 = new class_1799(class_1802.field_8575);
      UUID var3 = UUID.nameUUIDFromBytes(("holyworld:" + var1 + var0).getBytes(StandardCharsets.UTF_8));
      GameProfile var4 = new GameProfile(var3, "");
      var4.getProperties().put("textures", new Property("textures", var0));
      var2.method_57379(class_9334.field_49617, new class_9296(var4));
      return var2;
   }

   private static String blockRef(String var0) {
      return primaryVal(var0) ? var0.substring("holyworld:".length()) : var0;
   }

   static String holderVal(String var0) {
      return var0 == null
         ? ""
         : anchorVal(timerVal(var0).replaceAll("(?i)\u00a7[0-9A-FK-OR]", "").toLowerCase(Locale.ROOT)).replaceAll("[^\\p{L}\\p{N}]+", "");
   }

   private static String timerVal(String var0) {
      return var0.replace("\u1d00", "a")
         .replace("\u0299", "b")
         .replace("\u1d04", "c")
         .replace("\u1d05", "d")
         .replace("\u1d07", "e")
         .replace("g", "f")
         .replace("\u0262", "g")
         .replace("\u029c", "h")
         .replace("\u026a", "i")
         .replace("\u1d0a", "j")
         .replace("\u1d0b", "k")
         .replace("\u029f", "l")
         .replace("\u1d0d", "m")
         .replace("\u0274", "n")
         .replace("\u1d0f", "o")
         .replace("\u1d18", "p")
         .replace("\u01eb", "q")
         .replace("\u0280", "r")
         .replace("s", "s")
         .replace("\u1d1b", "t")
         .replace("\u1d1c", "u")
         .replace("\u1d20", "v")
         .replace("\u1d21", "w")
         .replace("x", "x")
         .replace("\u028f", "y")
         .replace("\u1d22", "z");
   }

   private static String anchorVal(String var0) {
      return var0.replace("infinity", "infinity")
         .replace("eternity", "eternity")
         .replace("eternity", "eternity")
         .replace("stinger", "stinger");
   }

   private static boolean primaryVal(String var0, List<String> var1) {
      if (var0 != null && !var0.isEmpty()) {
         for (String var3 : var1) {
            if (var3 != null && !var3.isEmpty() && var0.contains(var3)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private static String extraVal(class_1799 var0) {
      StringBuilder var1 = new StringBuilder();
      var1.append(var0.method_7964().getString()).append(' ');
      class_9290 var2 = (class_9290)var0.method_58694(class_9334.field_49632);
      if (var2 != null) {
         for (class_2561 var4 : var2.comp_2400()) {
            var1.append(var4.getString()).append(' ');
         }
      }

      var1.append(var0.method_57353());
      return var1.toString();
   }

   private static String primaryVal(ServerItemCatalog.WildClient var0) {
      String var1 = weightRef(var0.id());
      if (!var1.isEmpty()) {
         return holderVal(var1);
      } else {
         class_6880 var2 = var0.attribute();
         if (var2 == null) {
            return "";
         } else if (var2.equals(class_5134.field_23721)) {
            return "attackdamage";
         } else if (var2.equals(class_5134.field_23724)) {
            return "armor";
         } else if (var2.equals(class_5134.field_23719)) {
            return "movementspeed";
         } else {
            return var2.equals(class_5134.field_23716) ? "maxhealth" : "";
         }
      }
   }

   private static String secondaryVal(class_6880<class_1320> var0) {
      return var0 == null ? "" : var0.method_40230().map(var0x -> var0x.method_29177().toString()).orElse("");
   }

   private static String weightRef(String var0) {
      if (var0 == null) {
         return "";
      }

      String var1 = var0.toLowerCase(Locale.ROOT).trim();
      if (var1.startsWith("minecraft:")) {
         var1 = var1.substring("minecraft:".length());
      }

      if (var1.startsWith("generic.")) {
         var1 = var1.substring("generic.".length());
      }

      return var1.replace('.', '_');
   }

   private static String primaryVal(double var0) {
      return var0 == Math.rint(var0) ? String.valueOf((int)var0) : secondaryVal(var0);
   }

   private static String secondaryVal(double var0) {
      return var0 == Math.rint(var0) ? String.valueOf((int)var0) : String.valueOf(var0).replace(".", "");
   }

   private static String primaryVal(int var0) {
      return switch (var0) {
         case 1 -> "i";
         case 2 -> "ii";
         case 3 -> "iii";
         case 4 -> "iv";
         case 5 -> "v";
         case 6 -> "vi";
         case 7 -> "vii";
         case 8 -> "viii";
         case 9 -> "ix";
         case 10 -> "x";
         default -> "";
      };
   }

   public record WildClient(class_6880<class_1320> attribute, String id, double value) {
   }

   record VvunVVUvUNnv(String type, double level) {
   }

   public record AccessGuardException(
      String key,
      String label,
      class_1792 item,
      List<String> aliases,
      List<String> lore,
      List<String> enchantments,
      List<String> effects,
      List<ServerItemCatalog.WildClient> attributes,
      String texture,
      boolean strictCheck
   ) {
      boolean hasRequirements() {
         return !this.lore.isEmpty() || !this.enchantments.isEmpty() || !this.effects.isEmpty() || !this.attributes.isEmpty();
      }
   }

   static final class cursorVal {
      private final String primaryVal;
      private final class_1792 secondaryVal;
      private final List<String> tertiaryVal = new ArrayList<>();
      private final List<String> marginVal = new ArrayList<>();
      private final List<String> weightVal = new ArrayList<>();
      private final List<String> paramVal = new ArrayList<>();
      private final List<ServerItemCatalog.WildClient> extraVal = new ArrayList<>();
      private String limitVal;
      private boolean speedVal;

      cursorVal(String var1, class_1792 var2, String... var3) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
         this.tertiaryVal.add(ServerItemCatalog.holderVal(var1));

         for (String var7 : var3) {
            this.tertiaryVal.add(ServerItemCatalog.holderVal(var7));
         }
      }

      ServerItemCatalog.cursorVal primaryVal(String... var1) {
         this.marginVal.addAll(List.of(var1));
         return this;
      }

      ServerItemCatalog.cursorVal secondaryVal(String... var1) {
         this.weightVal.addAll(List.of(var1));
         return this;
      }

      private ServerItemCatalog.cursorVal tertiaryVal(String... var1) {
         this.paramVal.addAll(List.of(var1));
         return this;
      }

      ServerItemCatalog.cursorVal primaryVal(ServerItemCatalog.WildClient... var1) {
         this.extraVal.addAll(List.of(var1));
         return this;
      }

      ServerItemCatalog.cursorVal primaryVal(String var1) {
         this.limitVal = var1;
         return this;
      }

      private ServerItemCatalog.cursorVal primaryVal() {
         this.speedVal = true;
         return this;
      }

      ServerItemCatalog.AccessGuardException secondaryVal() {
         String var1 = "holyworld:" + ServerItemCatalog.holderVal(this.primaryVal);
         int var2 = ServerItemCatalog.weightVal.merge(var1, 1, Integer::sum);
         return new ServerItemCatalog.AccessGuardException(
            var2 == 1 ? var1 : var1 + ":" + var2,
            this.primaryVal,
            this.secondaryVal,
            List.copyOf(this.tertiaryVal),
            List.copyOf(this.marginVal),
            List.copyOf(this.weightVal),
            List.copyOf(this.paramVal),
            List.copyOf(this.extraVal),
            this.limitVal,
            this.speedVal
         );
      }
   }

   record DelayedFuse(String raw, String id, int level) {
   }
}
