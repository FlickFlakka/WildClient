/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.properties.Property
 *  net.minecraft.class_1799
 *  net.minecraft.class_1802
 *  net.minecraft.class_1935
 *  net.minecraft.class_332
 *  net.minecraft.class_9296
 *  net.minecraft.class_9334
 */
package ru.metaculture.protection;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.minecraft.class_1799;
import net.minecraft.class_1802;
import net.minecraft.class_1935;
import net.minecraft.class_332;
import net.minecraft.class_9296;
import net.minecraft.class_9334;
import ru.metaculture.protection.ServerItemCatalog;

public class VnuunNV {
    private static final Map<String, class_1799> primaryVal = new HashMap<String, class_1799>();

    public static void primaryVal(class_332 class_3322, String string, float f, float f2) {
        class_1799 class_17992 = VnuunNV.primaryVal(string);
        if (class_17992 != null) {
            if (!class_17992.method_7960()) {
                class_3322.method_51427(class_17992, (int)f, (int)f2);
            }
        }
    }

    public static class_1799 primaryVal(String string) {
        class_1799 class_17992;
        if (primaryVal.containsKey(string)) {
            return primaryVal.get(string);
        }
        if (ServerItemCatalog.secondaryVal(string)) {
            class_1799 class_17993 = ServerItemCatalog.paramVal(string);
            if (class_17993.method_7960()) {
                return class_17993;
            }
            primaryVal.put(string, class_17993);
            return class_17993;
        }
        switch (string) {
            case "Sphere of Chaos": {
                class_17992 = VnuunNV.secondaryVal("ewogICJ0aW1lc3RhbXAiIDogMTc1MDI3ODY0MTkwMCwKICAicHJvZmlsZUlkIiA6ICIxNzRjZmRiNGEzY2I0M2I1YmZjZGU0MjRjM2JiMmM2ZSIsCiAgInByb2ZpbGVOYW1lIiA6ICJtYXJhZWwxOCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS9lN2E3YWU3Y2RjZjYxNmU4YjdhNDIyMWE2MjFiMjQzNTc1M2M2MGVkNmEyNThlYTA2MGRhZTMwMDJmZmU5ZTI4IiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=");
                break;
            }
            case "Sphere of the Titan": {
                class_17992 = VnuunNV.secondaryVal("ewogICJ0aW1lc3RhbXAiIDogMTc1MDM1NDQ1NTE5MiwKICAicHJvZmlsZUlkIiA6ICJkOTcwYzEzZTM4YWI0NzlhOTY1OGM1ZDQ1MjZkMTM0YiIsCiAgInByb2ZpbGVOYW1lIiA6ICJDcmltcHlMYWNlODUxMjciLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODFlOTY5ODQ1OGI3ODQxYzk2YWU0ZjI0ZWM4NGFlMDE3MjQxMDA2NDFjNTY0ZTJhN2IxODVmNDA2ZThlZDIzIiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=");
                break;
            }
            case "Sphere of Ares": {
                class_17992 = VnuunNV.secondaryVal("ewogICJ0aW1lc3RhbXAiIDogMTc1MDM0Mzc3NDI1NSwKICAicHJvZmlsZUlkIiA6ICJhZWNkODIxZTQyYzE0ZDJlOThmNTA1OTg1MWI5OWMzNyIsCiAgInByb2ZpbGVOYW1lIiA6ICJqdXNhbXUiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzE2YWRjNmJhZmNiNTdmZDcwN2RlZTdkZDZhNzM2ZmUxMjY3MTFkNTNhMWZkNmNlNzg5ZGE0MWIzYmUxM2YyYSIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9CiAgfQp9");
                break;
            }
            case "Sphere of the Beast": {
                class_17992 = VnuunNV.secondaryVal("ewogICJ0aW1lc3RhbXAiIDogMTc1MDM0MzgzNDkzMCwKICAicHJvZmlsZUlkIiA6ICI1MzUzNWIxN2M0ZDY0NWQ0YWUwY2U2ZjM4Zjk0NTFjYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJVYml2aXMiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTQxMWFjMTczODFiOWZjZTliYWIzYzcyYWZkYjdmMTk4NTcwZGFmNDczMmJkODExZDMxYzIyN2Q4MGZhMzliMSIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9CiAgfQp9");
                break;
            }
            case "Sphere of the Hydra": {
                class_17992 = VnuunNV.secondaryVal("ewogICJ0aW1lc3RhbXAiIDogMTc1MDI3ODUzMjE4MywKICAicHJvZmlsZUlkIiA6ICI1OGZmZWI5NTMxNGQ0ODcwYTQwYjVjYjQyZDRlYTU5OCIsCiAgInByb2ZpbGVOYW1lIiA6ICJTa2luREJuZXQiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2UzYzExOGQ2OTZkOTEwZTU0ZGUwMmNhNGQ4MDc1NDNmOWIxOGMwMDhjOTgzOGQyZmY2OTM3NzYyMmZiMWQzMiIsCiAgICAgICJtZXRhZGF0YSIgOiB7CiAgICAgICAgIm1vZGVsIiA6ICJzbGltIgogICAgICB9CiAgICB9CiAgfQp9");
                break;
            }
            case "Sphere of Icarus": {
                class_17992 = VnuunNV.secondaryVal("ewogICJ0aW1lc3RhbXAiIDogMTc1MDI3ODU4MjQ5MSwKICAicHJvZmlsZUlkIiA6ICJhZWNkODIxZTQyYzE0ZDJlOThmNTA1OTg1MWI5OWMzNyIsCiAgInByb2ZpbGVOYW1lIiA6ICJSb2RyaVgyMDc1IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2M2ODAzZTZkNTY2N2EyZDYxMDYyOGJjM2IzMmY4NjNjZGE0OTVjNDY1NjE2ZGU2NTVjYjMyOTkzM2I2MWFmNzciLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==");
                break;
            }
            case "Sphere of Eris": {
                class_17992 = VnuunNV.secondaryVal("ewogICJ0aW1lc3RhbXAiIDogMTc1MDM0Mzg2MTE4NywKICAicHJvZmlsZUlkIiA6ICJlZGUyYzdhMGFjNjM0MTNiYjA5ZDNmMGJlZTllYzhlYyIsCiAgInByb2ZpbGVOYW1lIiA6ICJ0aGVEZXZKYWRlIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzZlNGUyZjEwNDdmM2VjNmU5ZTQ1OTE4NDczOWUzM2I3YzFmYzYzYWQ4MjAyYmRhYjlmMDI0NTA4YWRkMjNlNWIiLAogICAgICAibWV0YWRhdGEiIDogewogICAgICAgICJtb2RlbCIgOiAic2xpbSIKICAgICAgfQogICAgfQogIH0KfQ==");
                break;
            }
            case "Sphere of the Satyr": {
                class_17992 = VnuunNV.secondaryVal("ewogICJ0aW1lc3RhbXAiIDogMTc1MDI3ODYwODUyOCwKICAicHJvZmlsZUlkIiA6ICJkMTQ4NjFiM2UwZmM0Njk5OTFlMTcyNTllMzdiZjZhZCIsCiAgInByb2ZpbGVOYW1lIiA6ICJyYXhpdG9jbCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS83NzFhOWE0OThiNGZhNWVjNDkzNjJmOWJjODhlZGE0ZjUyYjA0ZGU0OWQ3NWFhM2NhMzMyYTFmZWExYWEwZTU3IiwKICAgICAgIm1ldGFkYXRhIiA6IHsKICAgICAgICAibW9kZWwiIDogInNsaW0iCiAgICAgIH0KICAgIH0KICB9Cn0=");
                break;
            }
            case "Demon Talisman": 
            case "Punisher Talisman": 
            case "Talisman of Gloom": 
            case "Talisman of Fury": 
            case "Tyrant's Talisman": 
            case "Crusher's Talisman": 
            case "Talisman of Discord": 
            case "Infinity Talisman": 
            case "Stinger's Talisman": 
            case "Totem of Undying": 
            case "Totem of undying": 
            case "Totem": {
                class_17992 = new class_1799((class_1935)class_1802.field_8288);
                break;
            }
            case "Crusher Items": 
            case "Crusher Set": 
            case "Crusher Sword": {
                class_17992 = new class_1799((class_1935)class_1802.field_22022);
                break;
            }
            case "Crusher Armor": 
            case "Crusher Armor with spikes": 
            case "Crusher Armor spike": 
            case "Crusher Armor without spikes": 
            case "Crusher Armor without spike": 
            case "Crusher Chestplate": {
                class_17992 = new class_1799((class_1935)class_1802.field_22028);
                break;
            }
            case "Crusher Helmet": {
                class_17992 = new class_1799((class_1935)class_1802.field_22027);
                break;
            }
            case "Crusher Leggings": {
                class_17992 = new class_1799((class_1935)class_1802.field_22029);
                break;
            }
            case "Crusher Boots": {
                class_17992 = new class_1799((class_1935)class_1802.field_22030);
                break;
            }
            case "Crusher Pickaxe": {
                class_17992 = new class_1799((class_1935)class_1802.field_22024);
                break;
            }
            case "Crusher Bow": {
                class_17992 = new class_1799((class_1935)class_1802.field_8102);
                break;
            }
            case "Crusher Crossbow": {
                class_17992 = new class_1799((class_1935)class_1802.field_8399);
                break;
            }
            case "Crusher Trident": {
                class_17992 = new class_1799((class_1935)class_1802.field_8547);
                break;
            }
            case "Crusher Mace": {
                class_17992 = new class_1799((class_1935)class_1802.field_49814);
                break;
            }
            case "Crusher Elytra": {
                class_17992 = new class_1799((class_1935)class_1802.field_8833);
                break;
            }
            case "Crusher Fishing Rod": {
                class_17992 = new class_1799((class_1935)class_1802.field_8378);
                break;
            }
            case "Assassin's Potion": 
            case "Potion of Wrath": 
            case "Firecracker": 
            case "Holy Water": 
            case "Paladin's Potion": 
            case "Radiation Potion": 
            case "Sleeping Potion": {
                class_17992 = new class_1799((class_1935)class_1802.field_8436);
                break;
            }
            case "Explicit Dust": {
                class_17992 = new class_1799((class_1935)class_1802.field_8479);
                break;
            }
            case "Disorientation": {
                class_17992 = new class_1799((class_1935)class_1802.field_8449);
                break;
            }
            case "Rag": {
                class_17992 = new class_1799((class_1935)class_1802.field_22021);
                break;
            }
            case "Sphere Lockpick": {
                class_17992 = new class_1799((class_1935)class_1802.field_8366);
                break;
            }
            case "Layer": {
                class_17992 = new class_1799((class_1935)class_1802.field_8551);
                break;
            }
            case "Experience 15": 
            case "Experience 30": 
            case "Experience 45": 
            case "Experience 50": 
            case "Bottle o' Enchanting": {
                class_17992 = new class_1799((class_1935)class_1802.field_8287);
                break;
            }
            case "White": 
            case "Black": {
                class_17992 = new class_1799((class_1935)class_1802.field_8626);
                break;
            }
            case "Block Damager": {
                class_17992 = new class_1799((class_1935)class_1802.field_16538);
                break;
            }
            case "Chunk Loader": {
                class_17992 = new class_1799((class_1935)class_1802.field_8238);
                break;
            }
            case "Beacon": {
                class_17992 = new class_1799((class_1935)class_1802.field_8668);
                break;
            }
            case "Cursed Soul": {
                class_17992 = new class_1799((class_1935)class_1802.field_22016);
                break;
            }
            case "Dragon Skin": {
                class_17992 = new class_1799((class_1935)class_1802.field_8407);
                break;
            }
            case "Fire Tornado": {
                class_17992 = new class_1799((class_1935)class_1802.field_8814);
                break;
            }
            case "Freezing Snowball": {
                class_17992 = new class_1799((class_1935)class_1802.field_8543);
                break;
            }
            case "Divine Aura": {
                class_17992 = new class_1799((class_1935)class_1802.field_8614);
                break;
            }
            case "Silver": {
                class_17992 = new class_1799((class_1935)class_1802.field_8675);
                break;
            }
            case "Divine Touch": 
            case "Mighty Blow": {
                class_17992 = new class_1799((class_1935)class_1802.field_8335);
                break;
            }
            case "Mega Bulldozer": {
                class_17992 = new class_1799((class_1935)class_1802.field_22024);
                break;
            }
            case "Indestructible Elytra": {
                class_17992 = new class_1799((class_1935)class_1802.field_8833);
                break;
            }
            case "Enchanted Golden Apple": 
            case "Enchanted apple": {
                class_17992 = new class_1799((class_1935)class_1802.field_8367);
                break;
            }
            case "Golden Apple":
            case "Apple": {
                class_17992 = new class_1799((class_1935)class_1802.field_8463);
                break;
            }
            case "Diamond": 
            case "Diamonds": {
                class_17992 = new class_1799((class_1935)class_1802.field_8477);
                break;
            }
            case "Ender Pearl":
            case "Pearl": {
                class_17992 = new class_1799((class_1935)class_1802.field_8634);
                break;
            }
            case "End Crystal": 
            case "End crystal": 
            case "Crystal": {
                class_17992 = new class_1799((class_1935)class_1802.field_8301);
                break;
            }
            case "Obsidian": {
                class_17992 = new class_1799((class_1935)class_1802.field_8281);
                break;
            }
            case "Respawn Anchor": 
            case "Respawn anchor": 
            case "Anchor": {
                class_17992 = new class_1799((class_1935)class_1802.field_23141);
                break;
            }
            case "Glowstone": {
                class_17992 = new class_1799((class_1935)class_1802.field_8801);
                break;
            }
            case "Cobweb": {
                class_17992 = new class_1799((class_1935)class_1802.field_8786);
                break;
            }
            case "Arrow": 
            case "Arrows": {
                class_17992 = new class_1799((class_1935)class_1802.field_8107);
                break;
            }
            case "Spawner": {
                class_17992 = new class_1799((class_1935)class_1802.field_8849);
                break;
            }
            default: {
                class_17992 = new class_1799((class_1935)class_1802.field_8077);
            }
        }
        class_1799 class_17995 = class_17992;
        primaryVal.put(string, class_17995);
        return class_17995;
    }

    private static class_1799 secondaryVal(String string) {
        class_1799 class_17992 = new class_1799((class_1935)class_1802.field_8575);
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "CustomHead");
        gameProfile.getProperties().put("textures", new Property("textures", string));
        class_17992.method_57379(class_9334.field_49617, new class_9296(gameProfile));
        return class_17992;
    }
}

