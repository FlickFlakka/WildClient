/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_11469
 *  net.minecraft.class_1291
 *  net.minecraft.class_1294
 *  net.minecraft.class_2394
 *  net.minecraft.class_2960
 *  net.minecraft.class_366
 *  net.minecraft.class_367
 *  net.minecraft.class_368
 *  net.minecraft.class_372
 *  net.minecraft.class_6880
 *  net.minecraft.class_7923
 */
package ru.metaculture.protection;

import java.util.Iterator;
import java.util.Locale;
import net.minecraft.class_11469;
import net.minecraft.class_1291;
import net.minecraft.class_1294;
import net.minecraft.class_2394;
import net.minecraft.class_2960;
import net.minecraft.class_366;
import net.minecraft.class_367;
import net.minecraft.class_368;
import net.minecraft.class_372;
import net.minecraft.class_6880;
import net.minecraft.class_7923;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.SettingGroup;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@ModuleRegister(primaryVal="Removals", secondaryVal="Flexible disabling of annoying overlays, effects, particles and sounds", tertiaryVal=ModuleCategory.Misc)
public class RemovalsModule
extends Module {
    public static final String FIRE_KEY = "Fire";
    public static final String WATER_OVERLAY_KEY = "Water";
    public static final String IN_WALL_OVERLAY_KEY = "In-Wall Overlay";
    public static final String PUMPKIN_OVERLAY_KEY = "Pumpkin";
    public static final String POWDER_SNOW_OVERLAY_KEY = "Powder Snow";
    public static final String SPYGLASS_OVERLAY_KEY = "Spyglass";
    public static final String PORTAL_OVERLAY_KEY = "Portal";
    public static final String NAUSEA_SCREEN_KEY = "Nausea (Screen)";
    public static final String VIGNETTE_KEY = "Vignette";
    public static final String DAMAGE_SHAKE_KEY = "Damage Shake";
    public static final String DARKNESS_KEY = "Darkness";
    public static final String BLINDNESS_KEY = "Blindness";
    public static final String NAUSEA_EFFECT_KEY = "Nausea (Effect)";
    public static final String FOG_KEY = "Fog";
    public static final String EFFECT_ICONS_KEY = "Effect Icons";
    public static final String EXPLOSIONS_KEY = "Explosions";
    public static final String TOTEM_KEY = "Totem";
    public static final String POTION_EFFECTS_KEY = "Potion Effects";
    public static final String CRITS_HITS_KEY = "Crits and Hits";
    public static final String ENCHANT_TABLE_KEY = "Enchant Table";
    public static final String WATER_DRIPS_KEY = "Water Drips";
    public static final String REDSTONE_KEY = "Redstone";
    public static final String SMOKE_FIRE_KEY = "Smoke and Fire";
    public static final String HEARTS_VILLAGER_KEY = "Hearts and Villager";
    public static final String PORTAL_PARTICLES_KEY = "Portal Particles";
    public static final String FIREWORK_PARTICLES_KEY = "Firework Particles";
    public static final String DRAGON_SCULK_KEY = "Dragon and Sculk";
    public static final String NATURE_AMBIENT_KEY = "Nature Ambient";
    public static final String WIND_CHARGE_KEY = "Wind Charge";
    public static final String EXPLOSION_SOUND_KEY = "Explosions (Sound)";
    public static final String PISTONS_KEY = "Pistons";
    public static final String WATER_LAVA_SOUND_KEY = "Water and Lava";
    public static final String AMBIENT_CAVES_MOBS_KEY = "Ambient (Caves, Mobs)";
    public static final String PORTAL_SOUND_KEY = "Portals (Sound)";
    public static final String BEACON_KEY = "Beacon";
    public static final String XP_LEVELUP_KEY = "Experience and Level Up";
    public static final String ITEM_PICKUP_KEY = "Item Pickup";
    public static final String FIREWORK_SOUND_KEY = "Fireworks (Sound)";
    public static final String NOTE_BLOCKS_KEY = "Note Blocks";
    public static final String DOORS_CONTAINERS_KEY = "Doors and Containers";
    public static final String THUNDER_LIGHTNING_KEY = "Thunder and Lightning";
    public static final String BELL_KEY = "Bell";
    public static final String TOTEM_SOUND_KEY = "Totems (Sound)";
    public static final String ANVIL_KEY = "Anvil";
    public static final String ELYTRA_KEY = "Elytra";
    public static final String BOSS_ROAR_KEY = "Bosses (Roar)";
    public static final String WIND_MACE_KEY = "Wind Charge and Mace";
    public static final String GRASS_KEY = "Grass";
    public static final String PLANTS_FLOWERS_KEY = "Plants and Flowers";
    public static final String FOLIAGE_KEY = "Foliage";
    public static final String SNOW_LAYER_KEY = "Snow (Layer)";
    public static final String ARMOR_STANDS_KEY = "Armor Stands";
    public static final String ITEM_FRAMES_KEY = "Item Frames";
    public static final String PAINTINGS_KEY = "Paintings";
    public static final String ITEM_DROPS_KEY = "Item Drops";
    public static final String XP_ORBS_KEY = "XP Orbs";
    public static final String WEATHER_KEY = "Weather (Rain/Snow)";
    public static final String WATER_FLUID_KEY = "Water (Fluid)";
    public static final String LAVA_FLUID_KEY = "Lava (Fluid)";
    public static final String NARRATOR_KEY = "Narrator";
    public static final String TOASTS_ACHIEVEMENTS_KEY = "Toasts and Achievements";
    public static final String TOTEM_ANIMATION_KEY = "Totem Animation";
    public static final SettingGroup screenOverlaysGroup;
    public static final SettingGroup effectsAndFogGroup;
    public static final SettingGroup particlesGroup;
    public static final SettingGroup soundsGroup;
    public static final SettingGroup worldAndEntitiesGroup;
    public static final SettingGroup interfaceGroup;
    public static final BoolSetting dontHideMapsToggle;
    public static final StringFilterSetting customSoundsFilter;
    public static final StringFilterSetting customParticlesFilter;
    private static final SoundParticleFilter[] soundFilterEntries;
    private static final SoundParticleFilter[] particleFilterEntries;
    private static RemovalsModule instance;
    private int lastStateHash = -1;

    public RemovalsModule() {
        instance = this;
        Setting[] nvUuvVvuuNArray = new Setting[9];
        nvUuvVvuuNArray[0] = screenOverlaysGroup;
        nvUuvVvuuNArray[1] = effectsAndFogGroup;
        nvUuvVvuuNArray[2] = particlesGroup;
        nvUuvVvuuNArray[3] = soundsGroup;
        nvUuvVvuuNArray[4] = worldAndEntitiesGroup;
        nvUuvVvuuNArray[5] = dontHideMapsToggle;
        nvUuvVvuuNArray[6] = interfaceGroup;
        nvUuvVvuuNArray[7] = customSoundsFilter;
        nvUuvVvuuNArray[8] = customParticlesFilter;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.lastStateHash = this.holderVal();
        this.timerVal();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.timerVal();
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        int n = this.holderVal();
        if (n != this.lastStateHash) {
            this.lastStateHash = n;
            this.timerVal();
        }
    }

    private int holderVal() {
        if (!this.enabled) {
            return 0;
        }
        int n = 1;
        if (worldAndEntitiesGroup.secondaryVal(GRASS_KEY)) {
            n |= 2;
        }
        if (worldAndEntitiesGroup.secondaryVal(PLANTS_FLOWERS_KEY)) {
            n |= 4;
        }
        if (worldAndEntitiesGroup.secondaryVal(FOLIAGE_KEY)) {
            n |= 8;
        }
        if (worldAndEntitiesGroup.secondaryVal(SNOW_LAYER_KEY)) {
            n |= 0x10;
        }
        return n;
    }

    private void timerVal() {
        block3: {
            block2: {
                if (ru.metaculture.protection.WildClient.layerVal() || RemovalsModule.mc.field_1724 == null) break block2;
                if (RemovalsModule.mc.field_1769 == null) break block2;
                if (RemovalsModule.mc.field_1687 != null) break block3;
            }
            return;
        }
        RemovalsModule.mc.field_1769.method_3279();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(String string) {
        if (!RemovalsModule.bufferVal()) {
            return false;
        }
        if (screenOverlaysGroup.secondaryVal(string)) return true;
        if (effectsAndFogGroup.secondaryVal(string)) return true;
        if (worldAndEntitiesGroup.secondaryVal(string)) return true;
        if (!interfaceGroup.secondaryVal(string)) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean secondaryVal(String string) {
        if (!RemovalsModule.bufferVal()) return false;
        if (!worldAndEntitiesGroup.secondaryVal(string)) return false;
        return true;
    }

    public static boolean primaryVal(class_6880<class_1291> class_68802) {
        if (!RemovalsModule.bufferVal()) {
            return false;
        }
        if (class_68802 == class_1294.field_38092) {
            return effectsAndFogGroup.secondaryVal(DARKNESS_KEY);
        }
        if (class_68802 == class_1294.field_5919) {
            return effectsAndFogGroup.secondaryVal(BLINDNESS_KEY);
        }
        if (class_68802 == class_1294.field_5916) {
            return effectsAndFogGroup.secondaryVal(NAUSEA_EFFECT_KEY);
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean primaryVal(class_2394 class_23942) {
        if (!RemovalsModule.bufferVal()) return false;
        if (!particlesGroup.secondaryVal(WATER_DRIPS_KEY)) return false;
        return true;
    }

    public static boolean primaryVal(class_2960 class_29602) {
        if (!RemovalsModule.bufferVal() || class_29602 == null || !RemovalsModule.weightRef()) {
            return false;
        }
        String string = class_29602.method_12832();
        for (SoundParticleFilter filterEntry : soundFilterEntries) {
            if (!soundsGroup.secondaryVal(filterEntry.key)) continue;
            if (!filterEntry.matches(string)) continue;
            return true;
        }
        return RemovalsModule.primaryVal(customSoundsFilter.tertiaryVal(), class_29602);
    }

    public static boolean secondaryVal(class_2394 class_23942) {
        if (!RemovalsModule.bufferVal() || class_23942 == null || !RemovalsModule.anchorVal()) {
            return false;
        }
        class_2960 class_29602 = class_7923.field_41180.method_10221(class_23942.method_10295());
        if (class_29602 == null) {
            return false;
        }
        String string = class_29602.method_12832();
        for (SoundParticleFilter filterEntry : particleFilterEntries) {
            if (!particlesGroup.secondaryVal(filterEntry.key)) continue;
            if (!filterEntry.matches(string)) continue;
            return true;
        }
        return RemovalsModule.primaryVal(customParticlesFilter.tertiaryVal(), class_29602);
    }

    public static boolean primaryVal(class_368 class_3682) {
        if (!RemovalsModule.bufferVal() || class_3682 == null || !interfaceGroup.secondaryVal(TOASTS_ACHIEVEMENTS_KEY)) {
            return false;
        }
        return class_3682 instanceof class_367 || class_3682 instanceof class_366 || class_3682 instanceof class_372 || class_3682 instanceof class_11469;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean blockRef() {
        if (!RemovalsModule.bufferVal()) return false;
        if (!interfaceGroup.secondaryVal(NARRATOR_KEY)) return false;
        return true;
    }

    private static boolean primaryVal(String string, class_2960 class_29602) {
        block4: {
            block3: {
                if (string == null) break block3;
                if (!string.isBlank()) break block4;
            }
            return false;
        }
        String string2 = class_29602.toString();
        String[] stringArray = string.toLowerCase(Locale.ROOT).split(",");
        int n = stringArray.length;
        for (int i = 0; i < n; ++i) {
            String string3 = stringArray[i];
            String string4 = string3.trim();
            if (string4.isEmpty() || !string2.contains(string4)) continue;
            return true;
        }
        return false;
    }

    private static boolean anchorVal() {
        for (BoolSetting vvNnnUNnVvn2 : RemovalsModule.particlesGroup.marginVal) {
            if (!vvNnnUNnVvn2.tertiaryVal()) continue;
            return true;
        }
        return !customParticlesFilter.tertiaryVal().isBlank();
    }

    private static boolean weightRef() {
        Iterator<BoolSetting> iterator = RemovalsModule.soundsGroup.marginVal.iterator();
        while (iterator.hasNext()) {
            BoolSetting vvNnnUNnVvn2 = iterator.next();
            if (!vvNnnUNnVvn2.tertiaryVal()) continue;
            return true;
        }
        return !customSoundsFilter.tertiaryVal().isBlank();
    }

    private static boolean bufferVal() {
        RemovalsModule uuUnvvnNUU2 = RemovalsModule.countVal();
        return uuUnvvnNUU2 != null && uuUnvvnNUU2.enabled;
    }

    private static RemovalsModule countVal() {
        block5: {
            block4: {
                if (instance != null) {
                    return instance;
                }
                if (ru.metaculture.protection.WildClient.primaryVal == null) break block4;
                if (ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null) break block5;
            }
            return null;
        }
        return ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(RemovalsModule.class);
    }

    static {
        BoolSetting[] vvNnnUNnVvnArray = new BoolSetting[10];
        vvNnnUNnVvnArray[0] = new BoolSetting(FIRE_KEY, false);
        vvNnnUNnVvnArray[1] = new BoolSetting(WATER_OVERLAY_KEY, false);
        vvNnnUNnVvnArray[2] = new BoolSetting(IN_WALL_OVERLAY_KEY, false);
        vvNnnUNnVvnArray[3] = new BoolSetting(PUMPKIN_OVERLAY_KEY, false);
        vvNnnUNnVvnArray[4] = new BoolSetting(POWDER_SNOW_OVERLAY_KEY, false);
        vvNnnUNnVvnArray[5] = new BoolSetting(SPYGLASS_OVERLAY_KEY, false);
        vvNnnUNnVvnArray[6] = new BoolSetting(PORTAL_OVERLAY_KEY, false);
        vvNnnUNnVvnArray[7] = new BoolSetting(NAUSEA_SCREEN_KEY, false);
        vvNnnUNnVvnArray[8] = new BoolSetting(VIGNETTE_KEY, false);
        vvNnnUNnVvnArray[9] = new BoolSetting(DAMAGE_SHAKE_KEY, false);
        screenOverlaysGroup = new SettingGroup("Screen Overlays", vvNnnUNnVvnArray);
        BoolSetting[] vvNnnUNnVvnArray2 = new BoolSetting[5];
        vvNnnUNnVvnArray2[0] = new BoolSetting(DARKNESS_KEY, false);
        vvNnnUNnVvnArray2[1] = new BoolSetting(BLINDNESS_KEY, false);
        vvNnnUNnVvnArray2[2] = new BoolSetting(NAUSEA_EFFECT_KEY, false);
        vvNnnUNnVvnArray2[3] = new BoolSetting(FOG_KEY, false);
        vvNnnUNnVvnArray2[4] = new BoolSetting(EFFECT_ICONS_KEY, false);
        effectsAndFogGroup = new SettingGroup("Effects and Fog", vvNnnUNnVvnArray2);
        BoolSetting[] vvNnnUNnVvnArray3 = new BoolSetting[14];
        vvNnnUNnVvnArray3[0] = new BoolSetting(EXPLOSIONS_KEY, false);
        vvNnnUNnVvnArray3[1] = new BoolSetting(TOTEM_KEY, false);
        vvNnnUNnVvnArray3[2] = new BoolSetting(POTION_EFFECTS_KEY, false);
        vvNnnUNnVvnArray3[3] = new BoolSetting(CRITS_HITS_KEY, false);
        vvNnnUNnVvnArray3[4] = new BoolSetting(ENCHANT_TABLE_KEY, false);
        vvNnnUNnVvnArray3[5] = new BoolSetting(WATER_DRIPS_KEY, false);
        vvNnnUNnVvnArray3[6] = new BoolSetting(REDSTONE_KEY, false);
        vvNnnUNnVvnArray3[7] = new BoolSetting(SMOKE_FIRE_KEY, false);
        vvNnnUNnVvnArray3[8] = new BoolSetting(HEARTS_VILLAGER_KEY, false);
        vvNnnUNnVvnArray3[9] = new BoolSetting(PORTAL_PARTICLES_KEY, false);
        vvNnnUNnVvnArray3[10] = new BoolSetting(FIREWORK_PARTICLES_KEY, false);
        vvNnnUNnVvnArray3[11] = new BoolSetting(DRAGON_SCULK_KEY, false);
        vvNnnUNnVvnArray3[12] = new BoolSetting(NATURE_AMBIENT_KEY, false);
        vvNnnUNnVvnArray3[13] = new BoolSetting(WIND_CHARGE_KEY, false);
        particlesGroup = new SettingGroup("Particles", vvNnnUNnVvnArray3);
        BoolSetting[] vvNnnUNnVvnArray4 = new BoolSetting[18];
        vvNnnUNnVvnArray4[0] = new BoolSetting(EXPLOSION_SOUND_KEY, false);
        vvNnnUNnVvnArray4[1] = new BoolSetting(PISTONS_KEY, false);
        vvNnnUNnVvnArray4[2] = new BoolSetting(WATER_LAVA_SOUND_KEY, false);
        vvNnnUNnVvnArray4[3] = new BoolSetting(AMBIENT_CAVES_MOBS_KEY, false);
        vvNnnUNnVvnArray4[4] = new BoolSetting(PORTAL_SOUND_KEY, false);
        vvNnnUNnVvnArray4[5] = new BoolSetting(BEACON_KEY, false);
        vvNnnUNnVvnArray4[6] = new BoolSetting(XP_LEVELUP_KEY, false);
        vvNnnUNnVvnArray4[7] = new BoolSetting(ITEM_PICKUP_KEY, false);
        vvNnnUNnVvnArray4[8] = new BoolSetting(FIREWORK_SOUND_KEY, false);
        vvNnnUNnVvnArray4[9] = new BoolSetting(NOTE_BLOCKS_KEY, false);
        vvNnnUNnVvnArray4[10] = new BoolSetting(DOORS_CONTAINERS_KEY, false);
        vvNnnUNnVvnArray4[11] = new BoolSetting(THUNDER_LIGHTNING_KEY, false);
        vvNnnUNnVvnArray4[12] = new BoolSetting(BELL_KEY, false);
        vvNnnUNnVvnArray4[13] = new BoolSetting(TOTEM_SOUND_KEY, false);
        vvNnnUNnVvnArray4[14] = new BoolSetting(ANVIL_KEY, false);
        vvNnnUNnVvnArray4[15] = new BoolSetting(ELYTRA_KEY, false);
        vvNnnUNnVvnArray4[16] = new BoolSetting(BOSS_ROAR_KEY, false);
        vvNnnUNnVvnArray4[17] = new BoolSetting(WIND_MACE_KEY, false);
        soundsGroup = new SettingGroup("Sounds", vvNnnUNnVvnArray4);
        BoolSetting[] vvNnnUNnVvnArray5 = new BoolSetting[12];
        vvNnnUNnVvnArray5[0] = new BoolSetting(GRASS_KEY, true);
        vvNnnUNnVvnArray5[1] = new BoolSetting(PLANTS_FLOWERS_KEY, true);
        vvNnnUNnVvnArray5[2] = new BoolSetting(FOLIAGE_KEY, false);
        vvNnnUNnVvnArray5[3] = new BoolSetting(SNOW_LAYER_KEY, false);
        vvNnnUNnVvnArray5[4] = new BoolSetting(ARMOR_STANDS_KEY, true);
        vvNnnUNnVvnArray5[5] = new BoolSetting(ITEM_FRAMES_KEY, true);
        vvNnnUNnVvnArray5[6] = new BoolSetting(PAINTINGS_KEY, true);
        vvNnnUNnVvnArray5[7] = new BoolSetting(ITEM_DROPS_KEY, false);
        vvNnnUNnVvnArray5[8] = new BoolSetting(XP_ORBS_KEY, false);
        vvNnnUNnVvnArray5[9] = new BoolSetting(WEATHER_KEY, false);
        vvNnnUNnVvnArray5[10] = new BoolSetting(WATER_FLUID_KEY, false);
        vvNnnUNnVvnArray5[11] = new BoolSetting(LAVA_FLUID_KEY, false);
        worldAndEntitiesGroup = new SettingGroup("World and Entities", vvNnnUNnVvnArray5);
        BoolSetting[] vvNnnUNnVvnArray6 = new BoolSetting[3];
        vvNnnUNnVvnArray6[0] = new BoolSetting(NARRATOR_KEY, true);
        vvNnnUNnVvnArray6[1] = new BoolSetting(TOASTS_ACHIEVEMENTS_KEY, false);
        vvNnnUNnVvnArray6[2] = new BoolSetting(TOTEM_ANIMATION_KEY, false);
        interfaceGroup = new SettingGroup("Interface", vvNnnUNnVvnArray6);
        dontHideMapsToggle = new BoolSetting("Don't Hide Maps", true).primaryVal(() -> !worldAndEntitiesGroup.secondaryVal(ITEM_FRAMES_KEY));
        customSoundsFilter = new StringFilterSetting("Custom Sounds (comma-separated)", "").primaryVal(512);
        customParticlesFilter = new StringFilterSetting("Custom Particles (comma-separated)", "").primaryVal(512);
        SoundParticleFilter[] filterArray = new SoundParticleFilter[18];
        filterArray[0] = new SoundParticleFilter(EXPLOSION_SOUND_KEY, "explode");
        String[] stringArray = new String[1];
        stringArray[0] = "piston";
        filterArray[1] = new SoundParticleFilter(PISTONS_KEY, stringArray);
        String[] stringArray2 = new String[5];
        stringArray2[0] = "water";
        stringArray2[1] = "lava";
        stringArray2[2] = "bubble";
        stringArray2[3] = "splash";
        stringArray2[4] = "swim";
        filterArray[2] = new SoundParticleFilter(WATER_LAVA_SOUND_KEY, stringArray2);
        filterArray[3] = new SoundParticleFilter(AMBIENT_CAVES_MOBS_KEY, "ambient");
        filterArray[4] = new SoundParticleFilter(PORTAL_SOUND_KEY, "portal");
        filterArray[5] = new SoundParticleFilter(BEACON_KEY, "beacon");
        filterArray[6] = new SoundParticleFilter(XP_LEVELUP_KEY, "experience_orb", "levelup");
        String[] stringArray3 = new String[1];
        stringArray3[0] = "item.pickup";
        filterArray[7] = new SoundParticleFilter(ITEM_PICKUP_KEY, stringArray3);
        filterArray[8] = new SoundParticleFilter(FIREWORK_SOUND_KEY, "firework");
        String[] stringArray4 = new String[1];
        stringArray4[0] = "note_block";
        filterArray[9] = new SoundParticleFilter(NOTE_BLOCKS_KEY, stringArray4);
        filterArray[10] = new SoundParticleFilter(DOORS_CONTAINERS_KEY, "door", "chest", "barrel", "shulker_box", "ender_chest");
        filterArray[11] = new SoundParticleFilter(THUNDER_LIGHTNING_KEY, "thunder", "lightning");
        String[] stringArray5 = new String[1];
        stringArray5[0] = "bell";
        filterArray[12] = new SoundParticleFilter(BELL_KEY, stringArray5);
        String[] stringArray6 = new String[1];
        stringArray6[0] = "totem";
        filterArray[13] = new SoundParticleFilter(TOTEM_SOUND_KEY, stringArray6);
        filterArray[14] = new SoundParticleFilter(ANVIL_KEY, "anvil");
        filterArray[15] = new SoundParticleFilter(ELYTRA_KEY, "elytra");
        filterArray[16] = new SoundParticleFilter(BOSS_ROAR_KEY, "wither.spawn", "wither.death", "ender_dragon.death", "ender_dragon.growl");
        filterArray[17] = new SoundParticleFilter(WIND_MACE_KEY, "wind_charge", "breeze", "mace.smash");
        soundFilterEntries = filterArray;
        SoundParticleFilter[] filterArray2 = new SoundParticleFilter[14];
        filterArray2[0] = new SoundParticleFilter(EXPLOSIONS_KEY, "explosion");
        String[] stringArray7 = new String[1];
        stringArray7[0] = "totem_of_undying";
        filterArray2[1] = new SoundParticleFilter(TOTEM_KEY, stringArray7);
        filterArray2[2] = new SoundParticleFilter(POTION_EFFECTS_KEY, "effect");
        String[] stringArray8 = new String[4];
        stringArray8[0] = "crit";
        stringArray8[1] = "enchanted_hit";
        stringArray8[2] = "sweep_attack";
        stringArray8[3] = "damage_indicator";
        filterArray2[3] = new SoundParticleFilter(CRITS_HITS_KEY, stringArray8);
        filterArray2[4] = new SoundParticleFilter(ENCHANT_TABLE_KEY, "enchant", "nautilus").excluding("enchanted_hit");
        filterArray2[5] = new SoundParticleFilter(WATER_DRIPS_KEY, "water", "splash", "bubble", "fishing", "rain", "lava");
        String[] stringArray9 = new String[1];
        stringArray9[0] = "dust";
        filterArray2[6] = new SoundParticleFilter(REDSTONE_KEY, stringArray9).excluding("falling_dust");
        String[] stringArray10 = new String[4];
        stringArray10[0] = "smoke";
        stringArray10[1] = "flame";
        stringArray10[2] = "campfire";
        stringArray10[3] = "spark";
        filterArray2[7] = new SoundParticleFilter(SMOKE_FIRE_KEY, stringArray10);
        String[] stringArray11 = new String[3];
        stringArray11[0] = "heart";
        stringArray11[1] = "angry_villager";
        stringArray11[2] = "happy_villager";
        filterArray2[8] = new SoundParticleFilter(HEARTS_VILLAGER_KEY, stringArray11);
        filterArray2[9] = new SoundParticleFilter(PORTAL_PARTICLES_KEY, "portal");
        filterArray2[10] = new SoundParticleFilter(FIREWORK_PARTICLES_KEY, "firework", "flash");
        String[] stringArray12 = new String[5];
        stringArray12[0] = "sculk";
        stringArray12[1] = "dragon_breath";
        stringArray12[2] = "sonic_boom";
        stringArray12[3] = "shriek";
        stringArray12[4] = "vibration";
        filterArray2[11] = new SoundParticleFilter(DRAGON_SCULK_KEY, stringArray12);
        String[] stringArray13 = new String[6];
        stringArray13[0] = "white_ash";
        stringArray13[1] = "spore";
        stringArray13[2] = "mycelium";
        stringArray13[3] = "leaves";
        stringArray13[4] = "snowflake";
        stringArray13[5] = "cherry";
        filterArray2[12] = new SoundParticleFilter(NATURE_AMBIENT_KEY, stringArray13);
        filterArray2[13] = new SoundParticleFilter(WIND_CHARGE_KEY, "gust");
        particleFilterEntries = filterArray2;
    }

    static final class SoundParticleFilter {
        final String key;
        final String[] includeKeywords;
        String[] excludeKeywords = new String[0];

        SoundParticleFilter(String key, String ... includeKeywords) {
            this.key = key;
            this.includeKeywords = includeKeywords;
        }

        SoundParticleFilter excluding(String ... excludeKeywords) {
            this.excludeKeywords = excludeKeywords;
            return this;
        }

        boolean matches(String id) {
            for (String excludeKeyword : this.excludeKeywords) {
                if (!id.contains(excludeKeyword)) continue;
                return false;
            }
            for (String includeKeyword : this.includeKeywords) {
                if (!id.contains(includeKeyword)) continue;
                return true;
            }
            return false;
        }
    }
}

