/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;
import org.wild.module.api.Module;
import ru.metaculture.profile.Profile;
import ru.metaculture.profile.Role;
import ru.metaculture.protection.PredictionsModule;
import ru.metaculture.protection.CocoaFarmModule;
import ru.metaculture.protection.ChamsModule;
import ru.metaculture.protection.BaseFinderModule;
import ru.metaculture.protection.NoFallModule;
import ru.metaculture.protection.ServerHelperModule;
import ru.metaculture.protection.ClientUtilModule;
import ru.metaculture.protection.AutoFTCraftMembranaModule;
import ru.metaculture.protection.ChestStealerModule;
import ru.metaculture.protection.AutoPotionModule;
import ru.metaculture.protection.HitSoundsModule;
import ru.metaculture.protection.NameTagsModule;
import ru.metaculture.protection.ElytraTargetModule;
import ru.metaculture.protection.VisibleEatingModule;
import ru.metaculture.protection.MenuModule;
import ru.metaculture.protection.JesusModule;
import ru.metaculture.protection.RotationLabModule;
import ru.metaculture.protection.CameraClipModule;
import ru.metaculture.protection.AutoAncientBotModule;
import ru.metaculture.protection.AttackEffectModule;
import ru.metaculture.protection.CriticalsModule;
import ru.metaculture.protection.AutoCraftModule;
import ru.metaculture.protection.StardustModule;
import ru.metaculture.protection.ServerDHelperModule;
import ru.metaculture.protection.UseTrackerModule;
import ru.metaculture.protection.TimerModule;
import ru.metaculture.protection.ElytraHelperModule;
import ru.metaculture.protection.ParticlesModule;
import ru.metaculture.protection.GlowESPModule;
import ru.metaculture.protection.ColorPlusModule;
import ru.metaculture.protection.AutoDuelModule;
import ru.metaculture.protection.AutoTotemModule;
import ru.metaculture.protection.SpiderModule;
import ru.metaculture.protection.OpenWallsModule;
import ru.metaculture.protection.AntiBotModule;
import ru.metaculture.protection.ProtectInfoModule;
import ru.metaculture.protection.FakePlayerModule;
import ru.metaculture.protection.AutoLeaveModule;
import ru.metaculture.protection.EmeraldArmorFarmModule;
import ru.metaculture.protection.SwingAnimationModule;
import ru.metaculture.protection.AutoPottBotModule;
import ru.metaculture.protection.ClickPearlModule;
import ru.metaculture.protection.PvPSafeModule;
import ru.metaculture.protection.MotionBlurModule;
import ru.metaculture.protection.PartyModule;
import ru.metaculture.protection.AntiCrystalModule;
import ru.metaculture.protection.DeadEffectModule;
import ru.metaculture.protection.HitBoxModule;
import ru.metaculture.protection.AutoAuthModule;
import ru.metaculture.protection.NoWebModule;
import ru.metaculture.protection.TrailsModule;
import ru.metaculture.protection.BlockESPModule;
import ru.metaculture.protection.AutoResellModule;
import ru.metaculture.protection.TotemVoicesModule;
import ru.metaculture.protection.PotionCombinerModule;
import ru.metaculture.protection.AutoDodgeModule;
import ru.metaculture.protection.FreeLockModule;
import ru.metaculture.protection.TargetPearlModule;
import ru.metaculture.protection.WindHopModule;
import ru.metaculture.protection.SpeedModule;
import ru.metaculture.protection.GrimGlideModule;
import ru.metaculture.protection.AutoSellModule;
import ru.metaculture.protection.ChatHelperModule;
import ru.metaculture.protection.NoPushModule;
import ru.metaculture.protection.GeyserHelperModule;
import ru.metaculture.protection.BlinkModule;
import ru.metaculture.protection.ESPModule;
import ru.metaculture.protection.FreeCameraModule;
import ru.metaculture.protection.ClanUpgradeModule;
import ru.metaculture.protection.LockSlotsModule;
import ru.metaculture.protection.ElytraMotionModule;
import ru.metaculture.protection.AirStuckModule;
import ru.metaculture.protection.AutoLesModule;
import ru.metaculture.protection.ItemScrollerModule;
import ru.metaculture.protection.BlockOutlineModule;
import ru.metaculture.protection.AnimationsModule;
import ru.metaculture.protection.NoSlowModule;
import ru.metaculture.protection.AspectRationModule;
import ru.metaculture.protection.AutoFTObsidianFarmModule;
import ru.metaculture.protection.AutoFishModule;
import ru.metaculture.protection.HandsModule;
import ru.metaculture.protection.ArrowsModule;
import ru.metaculture.protection.PlayerHelperModule;
import ru.metaculture.protection.NoDelayModule;
import ru.metaculture.protection.AutoToolModule;
import ru.metaculture.protection.FastBowModule;
import ru.metaculture.protection.AutoAcceptModule;
import ru.metaculture.protection.ItemPhysicModule;
import ru.metaculture.protection.HudModule;
import ru.metaculture.protection.InvMoveModule;
import ru.metaculture.protection.JumpCircleModule;
import ru.metaculture.protection.TargetESPModule;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.TapeMouseModule;
import ru.metaculture.protection.RequiresRole;
import ru.metaculture.protection.FastBreakModule;
import ru.metaculture.protection.AncientXrayModule;
import ru.metaculture.protection.CapeModule;
import ru.metaculture.protection.SprintModule;
import ru.metaculture.protection.UnHookModule;
import ru.metaculture.protection.FullBrightModule;
import ru.metaculture.protection.AntiAFKModule;
import ru.metaculture.protection.VelocityModule;
import ru.metaculture.protection.AutoGAppleModule;
import ru.metaculture.protection.ActionRecorderModule;
import ru.metaculture.protection.ChorusFarmModule;
import ru.metaculture.protection.AttackAuraModule;
import ru.metaculture.protection.RemovalsModule;
import ru.metaculture.protection.AutoBuyModule;
import ru.metaculture.protection.ScreensModule;
import ru.metaculture.protection.ScaffoldModule;
import ru.metaculture.protection.WorldTweaksModule;
import ru.metaculture.protection.AppleFarmerModule;
import ru.metaculture.protection.ChinaHatModule;
import ru.metaculture.protection.AutoExplosionModule;
import ru.metaculture.protection.WardenFarmModule;
import ru.metaculture.protection.FriendManagerModule;
import ru.metaculture.protection.AutoSwapModule;
import ru.metaculture.protection.AutoDropModule;
import ru.metaculture.protection.DragonFlyModule;
import ru.metaculture.protection.AhHelperModule;
import ru.metaculture.protection.SeeInvisiblesModule;
import ru.metaculture.protection.AutoWoodModule;
import ru.metaculture.protection.AutoVillageTradeModule;
import ru.metaculture.protection.ServerJoinerModule;
import ru.metaculture.protection.CreeperFarmModule;
import ru.metaculture.protection.NoInteractModule;
import ru.metaculture.protection.TriggerBotModule;
import ru.metaculture.protection.AtmoDawnFogModule;
import ru.metaculture.protection.MoneyFarmModule;
import ru.metaculture.protection.TestModule;
import ru.metaculture.protection.AutoInvisibleModule;

public class ModuleManager {
    public final ArrayList<Module> primaryVal = new ArrayList();

    public ModuleManager() {
        this.primaryVal();
    }

    public void primaryVal() {
        this.secondaryVal(new ClientUtilModule());
        this.secondaryVal(new MenuModule());
        this.secondaryVal(new UnHookModule());
        this.secondaryVal(new AntiCrystalModule());
        this.secondaryVal(new AutoGAppleModule());
        this.secondaryVal(new AutoSwapModule());
        this.secondaryVal(new AutoExplosionModule());
        this.secondaryVal(new AutoTotemModule());
        this.secondaryVal(new FastBowModule());
        this.secondaryVal(new HitBoxModule());
        this.secondaryVal(new HitSoundsModule());
        this.secondaryVal(new ColorPlusModule());
        this.secondaryVal(new VelocityModule());
        this.secondaryVal(new AhHelperModule());
        this.secondaryVal(new AppleFarmerModule());
        this.secondaryVal(new ScaffoldModule());
        this.secondaryVal(new CocoaFarmModule());
        this.secondaryVal(new ChorusFarmModule());
        this.secondaryVal(new AutoBuyModule());
        this.secondaryVal(new AutoDropModule());
        this.secondaryVal(new LockSlotsModule());
        this.secondaryVal(new AutoLeaveModule());
        this.secondaryVal(new AutoAncientBotModule());
        this.secondaryVal(new AutoFTCraftMembranaModule());
        this.secondaryVal(new AutoSellModule());
        this.secondaryVal(new AutoResellModule());
        this.secondaryVal(new BaseFinderModule());
        this.secondaryVal(new FreeLockModule());
        this.secondaryVal(new FriendManagerModule());
        this.secondaryVal(new ItemScrollerModule());
        this.secondaryVal(new RemovalsModule());
        this.secondaryVal(new SeeInvisiblesModule());
        this.secondaryVal(new ServerDHelperModule());
        this.secondaryVal(new ServerJoinerModule());
        this.secondaryVal(new ServerHelperModule());
        this.secondaryVal(new TotemVoicesModule());
        this.secondaryVal(new UseTrackerModule());
        this.secondaryVal(new AutoDodgeModule());
        this.secondaryVal(new DragonFlyModule());
        this.secondaryVal(new GrimGlideModule());
        this.secondaryVal(new InvMoveModule());
        this.secondaryVal(new NoFallModule());
        this.secondaryVal(new NoSlowModule());
        this.secondaryVal(new NoWebModule());
        this.secondaryVal(new SpeedModule());
        this.secondaryVal(new SpiderModule());
        this.secondaryVal(new SprintModule());
        this.secondaryVal(new TimerModule());
        this.secondaryVal(new AntiAFKModule());
        this.secondaryVal(new ActionRecorderModule());
        this.secondaryVal(new RotationLabModule());
        this.secondaryVal(new AutoFishModule());
        this.secondaryVal(new ChestStealerModule());
        this.secondaryVal(new AutoToolModule());
        this.secondaryVal(new FakePlayerModule());
        this.secondaryVal(new CameraClipModule());
        this.secondaryVal(new ElytraHelperModule());
        this.secondaryVal(new FreeCameraModule());
        this.secondaryVal(new ClickPearlModule());
        this.secondaryVal(new NoDelayModule());
        this.secondaryVal(new NoInteractModule());
        this.secondaryVal(new NoPushModule());
        this.secondaryVal(new OpenWallsModule());
        this.secondaryVal(new PlayerHelperModule());
        this.secondaryVal(new WindHopModule());
        this.secondaryVal(new BlinkModule());
        this.secondaryVal(new AncientXrayModule());
        this.secondaryVal(new AnimationsModule());
        this.secondaryVal(new AttackEffectModule());
        this.secondaryVal(new ArrowsModule());
        this.secondaryVal(new AspectRationModule());
        this.secondaryVal(new BlockOutlineModule());
        this.secondaryVal(new BlockESPModule());
        this.secondaryVal(new WorldTweaksModule());
        this.secondaryVal(new MotionBlurModule());
        this.secondaryVal(new ChamsModule());
        this.secondaryVal(new ESPModule());
        this.secondaryVal(new GlowESPModule());
        this.secondaryVal(new HandsModule());
        this.secondaryVal(new ChinaHatModule());
        this.secondaryVal(new HudModule());
        this.secondaryVal(new ItemPhysicModule());
        this.secondaryVal(new JumpCircleModule());
        this.secondaryVal(new AtmoDawnFogModule());
        this.secondaryVal(new DeadEffectModule());
        this.secondaryVal(new NameTagsModule());
        this.secondaryVal(new FullBrightModule());
        this.secondaryVal(new ParticlesModule());
        this.secondaryVal(new PredictionsModule());
        this.secondaryVal(new ProtectInfoModule());
        this.secondaryVal(new PvPSafeModule());
        this.secondaryVal(new SwingAnimationModule());
        this.secondaryVal(new StardustModule());
        this.secondaryVal(new TargetESPModule());
        this.secondaryVal(new VisibleEatingModule());
        this.secondaryVal(new JesusModule());
        this.secondaryVal(new ElytraMotionModule());
        this.secondaryVal(new ChatHelperModule());
        this.secondaryVal(new CreeperFarmModule());
        this.secondaryVal(new TapeMouseModule());
        this.secondaryVal(new AutoCraftModule());
        this.secondaryVal(new AttackAuraModule());
        this.secondaryVal(new TriggerBotModule());
        this.secondaryVal(new CriticalsModule());
        this.secondaryVal(new ElytraTargetModule());
        this.secondaryVal(new TargetPearlModule());
        this.secondaryVal(new AntiBotModule());
        this.secondaryVal(new AutoPotionModule());
        this.secondaryVal(new AutoInvisibleModule());
        this.secondaryVal(new AutoDuelModule());
        this.secondaryVal(new AirStuckModule());
        this.secondaryVal(new FastBreakModule());
        this.secondaryVal(new AutoLesModule());
        this.secondaryVal(new TrailsModule());
        this.secondaryVal(new ScreensModule());
        this.secondaryVal(new AutoAcceptModule());
        this.secondaryVal(new GeyserHelperModule());
        this.secondaryVal(new TestModule());
        this.secondaryVal(new AutoAuthModule());
        this.secondaryVal(new PotionCombinerModule());
        this.secondaryVal(new MoneyFarmModule());
        this.secondaryVal(new EmeraldArmorFarmModule());
        this.secondaryVal(new AutoVillageTradeModule());
        this.secondaryVal(new ClanUpgradeModule());
        this.secondaryVal(new PartyModule());
        this.secondaryVal(new CapeModule());
        this.secondaryVal(new AutoPottBotModule());
        this.secondaryVal(new WardenFarmModule());
        this.secondaryVal(new AutoWoodModule());
        this.secondaryVal(new AutoFTObsidianFarmModule());
        this.primaryVal.sort(Comparator.comparing(module -> module.getDisplayName().toLowerCase()));
        System.out.println("[Manager] register " + this.primaryVal.size() + " modules.");
    }

    private void secondaryVal(Module module) {
        if (module != null) {
            this.primaryVal.add(module);
        }
    }

    public ArrayList<Module> secondaryVal() {
        return this.primaryVal.stream().filter(this::primaryVal).collect(Collectors.toCollection(ArrayList::new));
    }

    public <T extends Module> T primaryVal(Class<T> clazz) {
        Iterator<Module> iterator = this.primaryVal.iterator();
        while (iterator.hasNext()) {
            Module module = iterator.next();
            if (module.getClass() != clazz) continue;
            return (T)module;
        }
        return null;
    }

    public Module secondaryVal(Class<?> clazz) {
        Iterator<Module> iterator = this.primaryVal.iterator();
        while (iterator.hasNext()) {
            Module module = iterator.next();
            if (module.getClass() != clazz) continue;
            return module;
        }
        return null;
    }

    public ArrayList<Module> primaryVal(ModuleCategory linkC) {
        return this.primaryVal.stream().filter(this::primaryVal).filter(module -> module.category == linkC).collect(Collectors.toCollection(ArrayList::new));
    }

    public Module[] primaryVal(int n) {
        return (Module[])this.primaryVal.stream().filter(this::primaryVal).filter(module -> module.keyIndex == n).toArray(Module[]::new);
    }

    public boolean primaryVal(Module module) {
        if (module == null) {
            return false;
        }
        return ModuleManager.primaryVal(module.getRequiresRole());
    }

    public boolean tertiaryVal(Class<? extends Module> clazz) {
        if (clazz == null) {
            return false;
        }
        return ModuleManager.primaryVal(clazz.getAnnotation(RequiresRole.class));
    }

    public static boolean primaryVal(RequiresRole sackD) {
        boolean bl;
        if (sackD == null) {
            return true;
        }
        boolean bl2 = bl = sackD.primaryVal() != Role.DEFAULT || sackD.secondaryVal().length > 0 || sackD.tertiaryVal().length > 0 || sackD.marginVal().length > 0;
        if (!bl) {
            return true;
        }
        if (Profile.isUid(sackD.marginVal())) {
            return true;
        }
        if (Profile.isUsername(sackD.tertiaryVal())) {
            return true;
        }
        if (Profile.hasRole(sackD.secondaryVal())) {
            return true;
        }
        return sackD.primaryVal() != Role.DEFAULT && Profile.hasRoleAtLeast(sackD.primaryVal());
    }
}

