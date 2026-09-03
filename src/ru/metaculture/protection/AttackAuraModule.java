package ru.metaculture.protection;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.class_1268;
import net.minecraft.class_1294;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1421;
import net.minecraft.class_1429;
import net.minecraft.class_1480;
import net.minecraft.class_1531;
import net.minecraft.class_1569;
import net.minecraft.class_1621;
import net.minecraft.class_1646;
import net.minecraft.class_1657;
import net.minecraft.class_1713;
import net.minecraft.class_1792;
import net.minecraft.class_1802;
import net.minecraft.class_1819;
import net.minecraft.class_2338;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2680;
import net.minecraft.class_2868;
import net.minecraft.class_2879;
import net.minecraft.class_304;
import net.minecraft.class_3489;
import net.minecraft.class_3532;
import net.minecraft.class_3988;
import net.minecraft.class_746;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "AttackAura",
   secondaryVal = "Automatically hits entity targets",
   tertiaryVal = ModuleCategory.Combat,
   marginVal = {ModuleBadge.RISKY, ModuleBadge.GRIM}
)
public class AttackAuraModule extends Module {
   public static FloatSetting countVal = new FloatSetting("Attack radius", 3.0F, 3.0F, 6.0F, 0.1F, false);
   public static FloatSetting depthVal = new FloatSetting(
      "Detection radius", 1.0F, 0.0F, 5.0F, 0.1F, false
   );
   public static ModeSetting descRef = new ModeSetting(
      "Rotation mode", "Smooth", bufferVal()
   );
   public static ButtonSetting activeVal = new ButtonSetting(
         "Rotation constructor", 0
      )
      .secondaryVal("Open")
      .primaryVal(AttackAuraModule::NnunUUnU)
      .primaryVal(() -> !descRef.secondaryVal("Custom"));
   public static FloatSetting radiusVal = new FloatSetting("AI Jitter", 1.0F, 0.0F, 2.0F, 0.05F, false).primaryVal(() -> !descRef.secondaryVal("AI"));
   public static BoolSetting factorVal = new BoolSetting("AI Debug Log", false).primaryVal(() -> !descRef.secondaryVal("AI"));
   public static BoolSetting sourceVal = new BoolSetting("AI Human Misses", false).primaryVal(() -> !descRef.secondaryVal("AI"));
   public static ButtonSetting extraRef = new ButtonSetting("AI Lab", 0)
      .secondaryVal("Open")
      .primaryVal(AttackAuraModule::nvuVvuNnNUnv)
      .primaryVal(() -> !descRef.secondaryVal("AI"));
   public static ModeSetting phaseVal = new ModeSetting("Snap mode", "Fast", "Fast", "Smooth", "Random")
      .primaryVal(() -> !descRef.secondaryVal("Snap") && !descRef.secondaryVal("FOV"));
   public static FloatSetting limitRef = new FloatSetting("FOV", 90.0F, 5.0F, 180.0F, 1.0F, true).primaryVal(() -> !descRef.secondaryVal("FOV"));
   public static BoolSetting paramRef = new BoolSetting("Display FOV", true)
      .primaryVal(() -> !descRef.secondaryVal("FOV"));
   public static FloatSetting groupVal = new FloatSetting("Legit speed", 0.08F, 0.02F, 0.4F, 0.01F, false)
      .primaryVal(() -> !descRef.secondaryVal("Legit"));
   public static BoolSetting layerVal = new BoolSetting("SidePoint Extra Checks", false).primaryVal(() -> !descRef.secondaryVal("Side Point"));
   public static DynamicActionButton slotVal = new DynamicActionButton("Neuro Status", 0, NuUvVVvUVVUV::tertiaryVal)
      .secondaryVal(() -> !descRef.secondaryVal("Neuro") || !countVal());
   public static BoolSetting themeVal = new BoolSetting("Neuro Debug", false).primaryVal(() -> !descRef.secondaryVal("Neuro") || !countVal());
   public static ModeSetting stageVal = new ModeSetting("Neuro Profile", "Human", "Stable", "Human", "Dynamic")
      .primaryVal(() -> !descRef.secondaryVal("Neuro") || !countVal());
   public static FloatSetting widthRef = new FloatSetting("Neuro Strength", 1.25F, 0.0F, 2.0F, 0.05F, false)
      .primaryVal(() -> !descRef.secondaryVal("Neuro") || !countVal());
   public static BoolSetting trackVal = new BoolSetting("Neuro Client Finish", false).primaryVal(() -> !descRef.secondaryVal("Neuro") || !countVal());
   public static SettingGroup modeRef = new SettingGroup(
      "Targets",
      new BoolSetting("Players", true),
      new BoolSetting("Naked", true),
      new BoolSetting("Invisibles", true),
      new BoolSetting("Naked Invisibles", false),
      new BoolSetting("Friends", false),
      new BoolSetting("NPC", true),
      new BoolSetting("Mobs", false),
      new BoolSetting("Animals", false),
      new BoolSetting("Villagers", false)
   );
   public static ModeSetting angleVal = new ModeSetting(
      "Hit timing",
      "Fast",
      "Fast",
      "Dynamic"
   );
   public static BoolSetting heightRef = new BoolSetting(
      "Adaptive timing", false
   );
   public static ModeSetting levelVal = new ModeSetting(
      "Sprint mode",
      "Normal",
      "Normal",
      "Updated",
      "Test",
      "Legit"
   );
   public static SettingGroup UuNnnVnuNNV = new SettingGroup(
      "Checks before hit",
      new BoolSetting("Hit through blocks", false),
      new BoolSetting("Hit only with weapon", false),
      new BoolSetting("Don't hit while eating", true),
      new BoolSetting("Don't hit in containers ", false),
      new BoolSetting("Break Shield", false),
      new BoolSetting("Shield Disable", false)
   );
   public static SettingGroup depthRef = new SettingGroup(
      "Additional settings",
      new BoolSetting(
         "Advanced attack settings",
         true
      ),
      new BoolSetting("Smart Crits", false),
      new BoolSetting(
         "Increased hit distance",
         false
      ),
      new BoolSetting(
         "Priority to nearest target", false
      )
   );
   public static FloatSetting speedRef = new FloatSetting(
         "Attack radius for mobs", 3.0F, 3.0F, 6.0F, 0.1F, false
      )
      .primaryVal(
         () -> !depthRef.secondaryVal(
               "Advanced attack settings"
            )
            && !modeRef.secondaryVal("Mobs")
      );
   public static FloatSetting countRef = new FloatSetting(
         "Attack radius for players",
         3.0F,
         3.0F,
         6.0F,
         0.1F,
         false
      )
      .primaryVal(
         () -> !depthRef.secondaryVal(
               "Advanced attack settings"
            )
            && !modeRef.secondaryVal("Players")
      );
   public static ModeSetting entryVal = new ModeSetting(
      "Movement mode",
      "Default",
      "Default",
      "Free",
      "Target",
      "Pursuit"
   );
   public static BoolSetting guardVal = new BoolSetting("Mace", false);
   public static ModeSetting VUuuVUnun = new ModeSetting(
         "Mace mode",
         "Auto",
         "Auto",
         "Keybind"
      )
      .primaryVal(() -> !guardVal.tertiaryVal());
   public static KeybindSetting vVVuuVVv = new KeybindSetting("Mace button", -1)
      .primaryVal(() -> !guardVal.tertiaryVal() || !VUuuVUnun.secondaryVal("Keybind"));
   public static FloatSetting VuunNUUUvu = new FloatSetting("Mace height", 2.0F, 0.5F, 6.0F, 0.1F, false)
      .primaryVal(() -> !guardVal.tertiaryVal() || !VUuuVUnun.secondaryVal("Auto"));
   public static BoolSetting NNUUNUuVNNVn = new BoolSetting("Damage boost", false)
      .primaryVal(() -> !guardVal.tertiaryVal());
   public static BoolSetting VvVvnNUnvuvV = new BoolSetting("Mace debug", false)
      .primaryVal(() -> !guardVal.tertiaryVal());
   public static class_1309 tokenVal;
   public static boolean NUVvUUVuVNVv = false;
   private static final Runnable nodeF = AuraHumanizer::primaryVal;
   private static final Runnable nodeH = AuraRotationStrategy::primaryVal;
   private static long OCOocoOoOO = 0L;
   private static boolean o0Ooc0COOoc = false;
   private static float twigB = 0.0F;
   private static long UnUUVuVunvVu = 0L;
   private static float twigC = 0.0F;
   private static long UVnuVUUVnnU = 0L;
   private static long VunnVNvNV = 0L;
   private static int twigD = Integer.MIN_VALUE;
   private boolean nodeD = false;
   private boolean NnuUnUNnu = false;
   private static final String UnnnvvU = "AuraMace";
   private static final int VUUnuVvVu = 40;
   private static final int VvVuvUvvNNVv = 4;
   private static final long UnnNNvuvvUU = 300L;
   static int twigA = 0;
   private static int itemC = 0;
   private static boolean itemB = false;
   private static int VvuUUUNNNv = -1;
   private static int uuuVnuvnnNnU = -1;
   private static boolean nodeJ = false;
   private static int twigH = -1;
   private static boolean vuvvuVuVv = false;
   private static boolean uunNUuunVU = false;
   private static int NvnuuuvnVV = 0;
   private static int NnUVNnuvUv = 0;
   private static long UuuuNNunN = 0L;
   public static long nodeB = 0L;
   public static long UNvvunVVn = ThreadLocalRandom.current().nextLong(90000L, 180000L);
   public static boolean UnvuVuVnNuvu = false;
   public static long UvNNVUVNVuvV = 0L;
   public static int NnunUUnU = 0;

   private static String[] bufferVal() {
      return countVal()
         ? new String[]{
            "Matrix", "Random Smooth ", "Snap", "FOV", "Smooth ", "FunTime", "FT-New", "FTTESTT", "SpookyTime", "ST-Test", "Legit", "Custom", "AI", "Neuro"
         }
         : new String[]{"Matrix", "Random Smooth ", "Snap", "FOV", "Smooth ", "FunTime", "FT-New", "SpookyTime", "ST-Test", "Legit", "Custom", "AI"};
   }

   private static boolean countVal() {
      return ModuleManager.primaryVal(AttackAuraModule.WildClient.class.getAnnotation(RequiresRole.class));
   }

   private static boolean depthVal() {
      return (descRef.secondaryVal("Neuro") || descRef.secondaryVal("FTTESTT")) && !countVal();
   }

   public AttackAuraModule() {
      AdaptiveCombatUtil.widthVal();
      this.addSettings(
         countVal,
         depthVal,
         descRef,
         activeVal,
         radiusVal,
         factorVal,
         sourceVal,
         extraRef,
         phaseVal,
         limitRef,
         paramRef,
         groupVal,
         slotVal,
         themeVal,
         stageVal,
         widthRef,
         trackVal,
         modeRef,
         angleVal,
         heightRef,
         levelVal,
         UuNnnVnuNNV,
         depthRef,
         speedRef,
         countRef,
         entryVal,
         guardVal,
         VUuuVUnun,
         vVVuuVVv,
         VuunNUUUvu,
         NNUUNUuVNNVn,
         VvVvnNUnvuvV,
         ElytraTargetModule.activeVal
      );
   }

   public static boolean blockRef() {
      return twigA != 0;
   }

   @Subscribe
   public void primaryVal(RenderHudEvent var1) {
      if (this.enabled && !anchorVal() && descRef.secondaryVal("FOV") && var1.marginVal() != null && paramRef.tertiaryVal()) {
         NuunNNvUNun.primaryVal(var1.marginVal(), limitRef.tertiaryVal(), var1.paramVal(), var1.extraVal());
      }
   }

   @Subscribe
   public void primaryVal(PostClientTickEvent var1) {
      CritTimingHelper.tertiaryVal();
      if (anchorVal()) {
         AuraHumanizer.tertiaryVal();
         SnapAimEngine.primaryVal();
         AuraRotationStrategy.secondaryVal();
         this.nodeF();
         this.nodeH();
      } else if (tokenVal != null && mc.field_1724 != null && mc.field_1687 != null) {
         this.nodeB();
         if (!descRef.secondaryVal("Legit")) {
            this.radiusVal();
         }
      } else {
         AuraHumanizer.tertiaryVal();
         SnapAimEngine.primaryVal();
         AuraRotationStrategy.secondaryVal();
         this.nodeF();
         this.nodeH();
      }
   }

   @Subscribe
   public void primaryVal(CameraRotationEvent var1) {
      if (!anchorVal() && descRef.secondaryVal("Legit")) {
         if (tokenVal != null && mc.field_1724 != null && mc.field_1687 != null) {
            VvVvuVVU.primaryVal(tokenVal, var1);
         }
      }
   }

   @Subscribe
   public void primaryVal(MovementInputEvent var1) {
      if (!anchorVal() && levelVal.secondaryVal("Test")) {
         if (tokenVal != null && mc.field_1724 != null && mc.field_1687 != null && mc.field_1755 == null) {
            class_243 var2 = tokenVal.method_19538()
               .method_1031(0.0, tokenVal.method_17682() * 0.5, 0.0)
               .method_1020(mc.field_1724.method_33571());
            float var3 = (float)Math.toDegrees(Math.atan2(-var2.field_1352, var2.field_1350));
            MovementUtil.primaryVal(var1, var3);
            if (AdaptiveCombatUtil.secondaryVal(tokenVal, secondaryVal(tokenVal))) {
               var1.primaryVal(0.0F);
               var1.secondaryVal(0.0F);
            }
         }
      }
   }

   @Subscribe
   public void primaryVal(AuraTickEvent var1) {
      if (!anchorVal()) {
         if (UuNnnVnuNNV.secondaryVal("Sync with TPS")) {
            this.nodeB();
            if (!levelVal.secondaryVal("Legit") && this.limitRef()) {
               mc.field_1724.method_5728(false);
               mc.field_1690.field_1867.method_23481(false);
            }

            if (!this.stageVal()) {
               this.timerVal();
            }
         }
      }
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      this.trackVal();
      if (anchorVal()) {
         this.nodeF();
         this.sourceVal();
         this.paramRef();
         MovementUtil.tertiaryVal();
      } else if (!mc.field_1724.method_5805()) {
         this.nodeF();
         this.sourceVal();
         this.paramRef();
         MovementUtil.tertiaryVal();
         this.toggle();
      } else {
         if (tokenVal == null || !this.tertiaryVal(tokenVal)) {
            this.layerVal();
         }

         if (tokenVal == null) {
            AuraHumanizer.tertiaryVal();
            CritAimHelper.marginVal();
            AuraRotationStrategy.secondaryVal();
            this.nodeF();
            this.nodeH();
            this.sourceVal();
            this.paramRef();
            MovementUtil.tertiaryVal();
         } else if (mc.field_1755 != null) {
            this.sourceVal();
            this.paramRef();
            this.groupVal();
         } else if (twigA != 0) {
            this.sourceVal();
            this.paramRef();
            MovementUtil.tertiaryVal();
            InputFreezeManager.primaryVal().primaryVal("AuraMace");
         } else {
            this.extraRef();
            if (entryVal.secondaryVal("Free")) {
               this.sourceVal();
               MovementUtil.primaryVal(mc.field_1773.method_19418().method_19330());
            } else if (entryVal.secondaryVal("Target")) {
               this.sourceVal();
               MovementUtil.primaryVal(mc.field_1724.method_36454(), tokenVal.method_19538());
            } else {
               MovementUtil.tertiaryVal();
            }

            if (entryVal.secondaryVal("Pursuit")) {
               this.factorVal();
            } else {
               this.sourceVal();
            }

            if (!UuNnnVnuNNV.secondaryVal("Sync with TPS")) {
               this.nodeB();
               if (!levelVal.secondaryVal("Legit") && this.limitRef()) {
                  mc.field_1724.method_5728(false);
                  mc.field_1690.field_1867.method_23481(false);
               }

               if (!this.stageVal()) {
                  this.timerVal();
               }
            }
         }
      }
   }

   public static float primaryVal(class_1309 var0) {
      if (var0 == null) {
         return countVal.tertiaryVal();
      }

      float var1 = countVal.tertiaryVal();
      if (depthRef.secondaryVal(
         "Advanced attack settings"
      )) {
         if (var0 instanceof class_1657) {
            var1 = countRef.tertiaryVal();
         } else {
            var1 = speedRef.tertiaryVal();
         }
      }

      if (depthRef.secondaryVal(
         "Increased hit distance"
      )) {
         float var2 = var0.method_6032() + var0.method_6067();
         if (var2 >= 10.0F && var2 <= 12.0F) {
            long var3 = System.currentTimeMillis();
            if (var3 >= OCOocoOoOO) {
               if (ThreadLocalRandom.current().nextInt(100) < 25) {
                  o0Ooc0COOoc = true;
                  twigB = 0.1F + ThreadLocalRandom.current().nextFloat() * 0.05F;
                  OCOocoOoOO = var3 + ThreadLocalRandom.current().nextLong(400L, 700L);
               } else {
                  o0Ooc0COOoc = false;
                  twigB = 0.0F;
                  OCOocoOoOO = var3 + ThreadLocalRandom.current().nextLong(1500L, 2500L);
               }
            }

            if (o0Ooc0COOoc) {
               return var1 + twigB;
            }
         } else {
            o0Ooc0COOoc = false;
            twigB = 0.0F;
         }
      }

      return var1;
   }

   public static float[] secondaryVal(class_1309 var0) {
      float var1 = primaryVal(var0);
      return new float[]{var1, depthVal.tertiaryVal(), var1 + depthVal.tertiaryVal()};
   }

   public boolean holderVal() {
      return true;
   }

   public void timerVal() {
      assert mc.field_1724 != null;
      if (twigA == 0) {
         float var1 = primaryVal(tokenVal);
         if (!(HitboxAimUtil.paramVal(tokenVal) >= var1)) {
            float[] var2 = secondaryVal(tokenVal);
            var2 = new float[]{var2[0], var2[1], var2[0] + var2[1]};
            if (!mc.field_1724.method_6059(class_1294.field_5919)
               && !mc.field_1724.method_70987()
               && levelVal.secondaryVal("Normal")) {
               boolean var20 = true;
            } else {
               boolean var10000 = false;
            }

            if (tokenVal != null) {
               if (!descRef.secondaryVal("FOV") || NuunNNvUNun.primaryVal(tokenVal, limitRef.tertiaryVal())) {
                  if (!descRef.secondaryVal("AI") || VuUvvnuUu.radiusVal()) {
                     AdaptiveCombatUtil.primaryVal(tokenVal, true, this.holderVal(), false);
                     boolean var4 = descRef.secondaryVal("FT-New");
                     boolean var5 = guardVal.tertiaryVal() && mc.field_1724.method_6047().method_7909() == class_1802.field_49814;
                     boolean var6 = var5 && NNUUNUuVNNVn.tertiaryVal();
                     if (!var6 || this.descRef()) {
                        boolean var7;
                        if (var5 && itemB) {
                           long var8 = VUuuVUnun.secondaryVal("Auto") ? -2000L : 0L;
                           boolean var10 = HitboxAimUtil.primaryVal(tokenVal, var2[0], true);
                           boolean var11 = AdaptiveCombatUtil.primaryVal(var8);
                           boolean var12 = !this.holderVal() || AdaptiveCombatUtil.primaryVal(tokenVal, var2[0]);
                           boolean var13 = !VUuuVUnun.secondaryVal("Auto") || !uunNUuunVU;
                           var7 = twigA == 0 && !vuvvuVuVv && var13 && var10 && var11 && var12;
                        } else if (var4) {
                           var7 = CritTimingHelper.primaryVal(tokenVal, 0) && (!this.holderVal() || AdaptiveCombatUtil.primaryVal(tokenVal, var2[0]));
                        } else {
                           var7 = AdaptiveCombatUtil.primaryVal(tokenVal, this.holderVal(), true, true, UnvuVuVnNuvu(), var2);
                        }

                        if (var7) {
                           if (var4) {
                              if (!CritTimingHelper.secondaryVal(tokenVal)) {
                                 return;
                              }

                              if (!CritTimingHelper.primaryVal(UuNnnVnuNNV.secondaryVal("Shield Disable"))) {
                                 return;
                              }
                           }

                           if (var4 || !heightRef.tertiaryVal() || var6 || !AdaptiveCombatUtil.primaryVal(tokenVal)) {
                              Runnable[] var15 = AdaptiveCombatUtil.primaryVal(
                                 tokenVal, !var4 && UuNnnVnuNNV.secondaryVal("Break Shield")
                              );
                              Runnable[] var9 = AdaptiveCombatUtil.primaryVal(!var4);
                              Runnable[] var16 = AdaptiveCombatUtil.secondaryVal(false);
                              Runnable var17 = () -> {
                                 var16[0].run();
                                 var9[0].run();
                                 var15[0].run();
                              };
                              Runnable var18 = () -> {
                                 var15[1].run();
                                 var9[1].run();
                                 var16[1].run();
                              };
                              if (!var4
                                 && UuNnnVnuNNV.secondaryVal("Shield Disable")
                                 && mc.field_1724.method_6030().method_7909().equals(class_1802.field_8255)
                                 && mc.field_1724.method_6115()) {
                                 mc.field_1761.method_2897(mc.field_1724);
                              }

                              if (!var4 && heightRef.tertiaryVal() && !var6) {
                                 Runnable var19 = descRef.secondaryVal("FunTime") ? nodeF : (descRef.secondaryVal("ST-Test") ? nodeH : null);
                                 AdaptiveCombatUtil.primaryVal(tokenVal, var17, var18, class_1268.field_5808, true, var19);
                              } else {
                                 if (AdaptiveCombatUtil.primaryVal(tokenVal, var17, var18, class_1268.field_5808, true)) {
                                    if (descRef.secondaryVal("FunTime")) {
                                       AuraHumanizer.primaryVal();
                                    } else if (var4) {
                                       CritTimingHelper.marginVal();
                                    } else if (descRef.secondaryVal("SpookyTime")) {
                                       AimJitterUtil.primaryVal();
                                    } else if (descRef.secondaryVal("ST-Test")) {
                                       AuraRotationStrategy.primaryVal();
                                    }

                                    this.NNUUNUuVNNVn();
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private boolean descRef() {
      if (mc.field_1687 != null && this.activeVal()) {
         class_243 var1 = mc.field_1724.method_18798();
         class_238 var2 = mc.field_1724.method_5829();
         class_243 var3 = class_1297.method_20736(
            mc.field_1724, var1, var2, mc.field_1687, mc.field_1687.method_20743(mc.field_1724, var2.method_18804(var1))
         );
         return var3.field_1351 > var1.field_1351 + 1.0E-7;
      } else {
         return true;
      }
   }

   private boolean activeVal() {
      return mc.field_1724 != null
         && !mc.field_1724.method_24828()
         && !mc.field_1724.method_6128()
         && mc.field_1724.method_18798().field_1351 < -1.0E-4;
   }

   private void radiusVal() {
      if (tokenVal != null && !anchorVal() && !depthVal() && (twigA == 0 || nodeJ)) {
         if (!descRef.secondaryVal("FT-New")) {
            CombatAimEngine.tertiaryVal();
            SnapAimEngine.secondaryVal();
         }

         if (!descRef.secondaryVal("ST-Test")) {
            AuraRotationStrategy.secondaryVal();
         }

         this.nodeB();
         double var1 = mc.field_1724.method_23318() - tokenVal.method_23318();
         boolean var3 = mc.field_1724.method_6047().method_7909() == class_1802.field_49814;
         boolean var4 = !mc.field_1724.method_24828() && (var1 >= 2.0 || var3);
         if (!descRef.secondaryVal("Legit") && var3 && var4 && mc.field_1724.method_23318() > tokenVal.method_23318()) {
            VvUNVunnuu.primaryVal(tokenVal);
         } else if (!descRef.secondaryVal("Legit") && guardVal.tertiaryVal() && var3) {
            LookAtEntityUtil.primaryVal(tokenVal);
         } else {
            float[] var5 = secondaryVal(tokenVal);
            var5 = new float[]{var5[0], var5[1], var5[0] + var5[1]};
            boolean var6 = AdaptiveCombatUtil.primaryVal(tokenVal, false, true, true, UnvuVuVnNuvu(), var5);
            switch (descRef.tertiaryVal()) {
               case "Random Smooth ":
                  AuraTargetJitter.primaryVal(
                     tokenVal, AdaptiveCombatUtil.primaryVal(tokenVal, false, true, true, primaryVal(-50L), var5), primaryVal(tokenVal), this.stageVal()
                  );
                  break;
               case "Matrix":
                  if (GameContextUtils.primaryVal("spookytime")) {
                     VvUNVunnuu.primaryVal(tokenVal, var6);
                  } else if (GameContextUtils.primaryVal("holy")) {
                     VvUNVunnuu.secondaryVal(tokenVal, var6);
                  } else if (GameContextUtils.primaryVal("ares")) {
                     VvUNVunnuu.tertiaryVal(tokenVal, var6);
                  } else {
                     VvUNVunnuu.primaryVal(tokenVal, var6);
                  }
                  break;
               case "Snap":
                  VvUNVunnuu.primaryVal(tokenVal, AdaptiveCombatUtil.primaryVal(tokenVal, false, true, true, primaryVal(-50L), var5), phaseVal.tertiaryVal());
                  break;
               case "FOV":
                  boolean var9 = NuunNNvUNun.primaryVal(tokenVal, limitRef.tertiaryVal());
                  boolean var10 = var9 && AdaptiveCombatUtil.primaryVal(tokenVal, false, true, true, primaryVal(-50L), var5);
                  VvUNVunnuu.secondaryVal(tokenVal, var10, phaseVal.tertiaryVal());
                  break;
               case "Smooth ":
                  LookAtEntityUtil.primaryVal(tokenVal);
                  break;
               case "FunTime":
                  AuraHumanizer.primaryVal(tokenVal);
                  break;
               case "FT-New":
                  SnapAimEngine.primaryVal(tokenVal);
                  break;
               case "FTTESTT":
                  CritAimHelper.primaryVal(tokenVal);
                  break;
               case "SpookyTime":
                  AimJitterUtil.primaryVal(tokenVal);
                  break;
               case "ST-Test":
                  AuraRotationStrategy.primaryVal(tokenVal, var6);
                  break;
               case "Custom":
                  CustomRotationController.primaryVal(tokenVal);
                  break;
               case "Lony Grief":
                  HumanizedAimController.primaryVal(tokenVal);
                  break;
               case "Side Point":
                  SilentAimEngine.primaryVal(tokenVal);
                  break;
               case "AI":
                  VuUvvnuUu.primaryVal(tokenVal);
                  break;
               case "Neuro":
                  NuUvVVvUVVUV.primaryVal(tokenVal, var6, this.stageVal(), themeVal.tertiaryVal());
            }
         }
      }
   }

   private void factorVal() {
      if (mc.field_1724 != null && tokenVal != null && mc.field_1690 != null && mc.method_22683() != null) {
         if (!mc.field_1724.method_6115()
            && !mc.field_1724.method_5715()
            && !mc.field_1724.method_5765()
            && mc.field_1755 == null) {
            float[] var1 = MovementUtil.secondaryVal();
            float var2 = var1[0];
            float var3 = var1[1];
            class_243 var4 = tokenVal.method_19538();
            if (var2 != 0.0F || var3 != 0.0F) {
               class_243 var5 = this.primaryVal(tokenVal.method_36454());
               class_243 var6 = this.primaryVal(tokenVal.method_36454() + 90.0F);
               var4 = var4.method_1019(var5.method_1021(var2)).method_1019(var6.method_1021(-var3));
            }

            class_243 var16 = var4.method_1020(mc.field_1724.method_19538());
            if (var16.field_1352 * var16.field_1352 + var16.field_1350 * var16.field_1350 < 1.0E-4) {
               this.primaryVal(1.0F, 0.0F, true, false);
            } else {
               float var17 = (float)class_3532.method_15338(Math.toDegrees(Math.atan2(var16.field_1350, var16.field_1352)) - 90.0);
               float var7 = PositionSyncTracker.primaryVal(mc.field_1724.method_36454());
               float var8 = 0.0F;
               float var9 = 0.0F;
               float var10 = Float.MAX_VALUE;

               for (float var11 = -1.0F; var11 <= 1.0F; var11++) {
                  for (float var12 = -1.0F; var12 <= 1.0F; var12++) {
                     if (var11 != 0.0F || var12 != 0.0F) {
                        double var13 = class_3532.method_15338(Math.toDegrees(MovementUtil.primaryVal(var7, var11, var12)));
                        float var15 = this.primaryVal(var17, (float)var13);
                        if (var15 < var10) {
                           var10 = var15;
                           var8 = var11;
                           var9 = var12;
                        }
                     }
                  }
               }

               boolean var18 = mc.field_1724.field_5976 && mc.field_1724.method_24828();
               this.primaryVal(var8, var9, true, var18);
            }
         } else {
            this.sourceVal();
         }
      } else {
         this.sourceVal();
      }
   }

   private class_243 primaryVal(float var1) {
      double var2 = Math.toRadians(var1);
      return new class_243(-Math.sin(var2), 0.0, Math.cos(var2));
   }

   private float primaryVal(float var1, float var2) {
      return Math.abs(class_3532.method_15393(var1 - var2));
   }

   private void primaryVal(float var1, float var2, boolean var3, boolean var4) {
      if (mc.field_1690 != null) {
         this.nodeD = true;
         mc.field_1690.field_1894.method_23481(var1 > 0.0F);
         mc.field_1690.field_1881.method_23481(var1 < 0.0F);
         mc.field_1690.field_1913.method_23481(var2 > 0.0F);
         mc.field_1690.field_1849.method_23481(var2 < 0.0F);
         boolean var5 = var3;
         if (levelVal.secondaryVal("Legit")
            && tokenVal != null
            && AdaptiveCombatUtil.secondaryVal(tokenVal, secondaryVal(tokenVal))) {
            mc.field_1724.method_5728(false);
            var5 = false;
         }

         mc.field_1690.field_1867.method_23481(var5);
         if (var4) {
            mc.field_1690.field_1903.method_23481(true);
         } else if (!this.secondaryVal(mc.field_1690.field_1903)) {
            mc.field_1690.field_1903.method_23481(false);
         }
      }
   }

   private void sourceVal() {
      if (this.nodeD && mc.field_1690 != null) {
         this.nodeD = false;
         this.primaryVal(mc.field_1690.field_1894);
         this.primaryVal(mc.field_1690.field_1881);
         this.primaryVal(mc.field_1690.field_1913);
         this.primaryVal(mc.field_1690.field_1849);
         this.primaryVal(mc.field_1690.field_1903);
         this.primaryVal(mc.field_1690.field_1867);
      }
   }

   private void extraRef() {
      if (levelVal.secondaryVal("Legit")
         && mc.field_1724 != null
         && mc.field_1687 != null
         && mc.field_1690 != null
         && mc.field_1755 == null) {
         this.NnuUnUNnu = true;
         boolean var1 = this.limitRef();
         if (var1) {
            mc.field_1724.method_5728(false);
            mc.field_1690.field_1867.method_23481(false);
         } else {
            mc.field_1690.field_1867.method_23481(this.phaseVal());
         }
      } else {
         this.paramRef();
      }
   }

   private boolean phaseVal() {
      return mc.field_1690 == null ? false : this.secondaryVal(mc.field_1690.field_1894) && !this.secondaryVal(mc.field_1690.field_1881);
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      if (descRef.secondaryVal("FT-New") && var1.tertiaryVal()) {
         if (var1.marginVal() instanceof class_2879 || var1.marginVal() instanceof class_2868) {
            CritTimingHelper.weightVal();
         }
      }
   }

   private boolean limitRef() {
      if (tokenVal == null || mc.field_1724 == null) {
         return false;
      } else {
         return descRef.secondaryVal("FT-New") ? CritTimingHelper.primaryVal(tokenVal) : AdaptiveCombatUtil.secondaryVal(tokenVal, secondaryVal(tokenVal));
      }
   }

   private void paramRef() {
      if (this.NnuUnUNnu && mc.field_1690 != null) {
         this.NnuUnUNnu = false;
         this.primaryVal(mc.field_1690.field_1867);
      }
   }

   private void groupVal() {
      if (mc.field_1690 != null) {
         mc.field_1690.field_1894.method_23481(false);
         mc.field_1690.field_1881.method_23481(false);
         mc.field_1690.field_1913.method_23481(false);
         mc.field_1690.field_1849.method_23481(false);
         mc.field_1690.field_1903.method_23481(false);
         this.primaryVal(mc.field_1690.field_1867);
      }
   }

   private void primaryVal(class_304 var1) {
      if (var1 != null) {
         var1.method_23481(this.secondaryVal(var1));
      }
   }

   private boolean secondaryVal(class_304 var1) {
      return var1 == null ? false : var1.method_1434();
   }

   private void layerVal() {
      class_1309 var1 = tokenVal;
      class_1309 var2 = null;
      double var3 = Double.MAX_VALUE;
      class_243 var5 = mc.field_1724.method_33571();
      class_243 var6 = mc.field_1724.method_5828(1.0F).method_1029();

      for (class_1297 var8 : mc.field_1687.method_18112()) {
         if (var8 instanceof class_1309 var9 && this.tertiaryVal(var9)) {
            double var10;
            if (depthRef.secondaryVal(
               "Priority to nearest target"
            )) {
               var10 = mc.field_1724.method_5858(var9);
            } else {
               class_243 var12 = var9.method_19538().method_1031(0.0, var9.method_17682() * 0.5, 0.0);
               class_243 var13 = var12.method_1020(var5).method_1029();
               var10 = Math.acos(class_3532.method_15350(var6.method_1026(var13), -1.0, 1.0));
            }

            if (var10 < var3) {
               var3 = var10;
               var2 = var9;
            }
         }
      }

      tokenVal = var2;
      if (descRef.secondaryVal("FunTime") && var1 != null && var2 == null) {
         AuraHumanizer.secondaryVal();
      }
   }

   private float slotVal() {
      return primaryVal(tokenVal) + depthVal.tertiaryVal();
   }

   private boolean tertiaryVal(class_1309 var1) {
      return this.primaryVal(var1, primaryVal(var1) + depthVal.tertiaryVal());
   }

   private boolean primaryVal(class_1309 var1, float var2) {
      if (var1 instanceof class_746 || var1 == mc.field_1724) {
         return false;
      }

      if (var1.method_5805() && !var1.method_5655() && !(var1 instanceof class_1531)) {
         if (mc.field_1724.method_5739(var1) > var2) {
            return false;
         }

         if (!UuNnnVnuNNV.secondaryVal("Hit through blocks")
            && !mc.field_1724.method_6057(var1)) {
            return false;
         }

         if (!modeRef.secondaryVal("NPC") && this.marginVal(var1)) {
            return false;
         }

         if (var1 instanceof class_1657 var7) {
            if (!var7.method_68878() && !var7.method_7325()) {
               boolean var8 = FriendCommand.primaryVal(var7.method_5477().getString());
               if (var8 && !modeRef.secondaryVal("Friends")) {
                  return false;
               } else if (!var8 && !modeRef.secondaryVal("Players")) {
                  return false;
               } else {
                  boolean var9 = !this.primaryVal(var7);
                  boolean var6 = var7.method_5767();
                  if (AntiBotModule.primaryVal(var7)) {
                     return false;
                  } else if (var6) {
                     return var9
                        ? modeRef.secondaryVal("Naked Invisibles")
                        : modeRef.secondaryVal("Invisibles");
                  } else {
                     return !var9 || modeRef.secondaryVal("Naked");
                  }
               }
            } else {
               return false;
            }
         } else {
            boolean var3 = var1 instanceof class_1569 || var1 instanceof class_1621;
            boolean var4 = var1 instanceof class_1646 || var1 instanceof class_3988;
            boolean var5 = var1 instanceof class_1429 || var1 instanceof class_1646 || var1 instanceof class_1480 || var1 instanceof class_1421;
            if (var3 && modeRef.secondaryVal("Mobs")) {
               return true;
            } else {
               return var4 && modeRef.secondaryVal("Villagers")
                  ? true
                  : var5 && modeRef.secondaryVal("Animals");
            }
         }
      } else {
         return false;
      }
   }

   private boolean primaryVal(class_1657 var1) {
      return !var1.method_6118(class_1304.field_6169).method_7960()
         || !var1.method_6118(class_1304.field_6174).method_7960()
         || !var1.method_6118(class_1304.field_6172).method_7960()
         || !var1.method_6118(class_1304.field_6166).method_7960();
   }

   private boolean marginVal(class_1309 var1) {
      String var2 = this.secondaryVal(var1.method_5477().getString());
      String var3 = this.secondaryVal(var1.method_5476().getString());
      String var4 = var1.method_5797() == null ? "" : this.secondaryVal(var1.method_5797().getString());
      String var5 = "";
      String var6 = "";
      if (var1.method_5781() != null) {
         var5 = this.secondaryVal(var1.method_5781().method_1144().getString());
         var6 = this.secondaryVal(var1.method_5781().method_1136().getString());
      }

      if (this.primaryVal(var2) || this.primaryVal(var3) || this.primaryVal(var4) || this.primaryVal(var5) || this.primaryVal(var6)) {
         return true;
      } else if (!(var1 instanceof class_1657 var7)) {
         return false;
      } else {
         boolean var8 = mc.method_1562() != null && mc.method_1562().method_2871(var7.method_5667()) == null;
         boolean var9 = var2.matches("\\d{1,8}") || var2.startsWith("cit-");
         return var8 || var9 && (!var3.equals(var2) || !var5.isEmpty() || !var6.isEmpty());
      }
   }

   private boolean primaryVal(String var1) {
      return var1.contains("npc")
         || var1.contains("znpc")
         || var1.contains("npc")
         || var1.contains("mentor");
   }

   private String secondaryVal(String var1) {
      return var1 == null ? "" : var1.replaceAll("(?i)\u00a7.", "").replaceAll("(?i)&.", "").replaceAll("\\p{Cntrl}", "").trim().toLowerCase(Locale.ROOT);
   }

   @Override
   public void onEnable() {
      FreeLockModule var1 = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(FreeLockModule.class)
         : null;
      if (var1 != null && var1.enabled && var1.blockRef()) {
         this.enabled = false;
         ChatLogger.primaryVal(
            "Disable FreeLock before enabling AttackAura"
         );
      } else {
         CritTimingHelper.primaryVal();
         super.onEnable();
      }
   }

   @Override
   public void toggle() {
      super.toggle();
      this.themeVal();
   }

   private void themeVal() {
      this.VvVvnNUnvuvV();
      this.nodeF();
      this.nodeH();
      AdaptiveCombatUtil.chunkVal();
      this.sourceVal();
      this.paramRef();
      VuUvvnuUu.factorVal();
      AuraHumanizer.secondaryVal();
      CombatAimEngine.tertiaryVal();
      CritAimHelper.weightVal();
      AimJitterUtil.secondaryVal();
      AuraRotationStrategy.tertiaryVal();
      tokenVal = null;
      InputFreezeManager.primaryVal().secondaryVal("Aura");
      if (mc.field_1724 != null) {
         UnvuVuVnNuvu = false;
         UvNNVUVNVuvV = 0L;
      }

      o0Ooc0COOoc = false;
      twigB = 0.0F;
      OCOocoOoOO = 0L;
      twigC = 0.0F;
      UnUUVuVunvVu = 0L;
      UVnuVUUVnnU = 0L;
      VunnVNvNV = 0L;
      twigD = Integer.MIN_VALUE;
   }

   private boolean stageVal() {
      return anchorVal()
         ? true
         : mc.field_1724.method_6115()
               && UuNnnVnuNNV.secondaryVal("Don't hit while eating")
               && !(mc.field_1724.method_6030().method_7909() instanceof class_1819)
            || mc.field_1755 != null
               && UuNnnVnuNNV.secondaryVal("Don't hit in containers ")
            || !mc.field_1724.method_6047().method_31573(class_3489.field_42611)
               && !mc.field_1724.method_6047().method_31573(class_3489.field_42612)
               && mc.field_1724.method_6047().method_7909() != class_1802.field_49814
               && UuNnnVnuNNV.secondaryVal("Hit only with weapon");
   }

   private int primaryVal(class_1792 var1) {
      if (mc.field_1724 == null) {
         return -1;
      }

      for (int var2 = 0; var2 < 9; var2++) {
         if (mc.field_1724.method_31548().method_5438(var2).method_7909() == var1) {
            return var2;
         }
      }

      return -1;
   }

   private int widthRef() {
      if (mc.field_1724 == null) {
         return -1;
      }

      for (int var1 = 0; var1 < 9; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_31573(class_3489.field_42611)) {
            return var1;
         }
      }

      return -1;
   }

   @Subscribe
   public void primaryVal(MouseButtonEvent var1) {
      if (this.enabled && guardVal.tertiaryVal() && VUuuVUnun.secondaryVal("Keybind")) {
         if (vVVuuVVv.tertiaryVal() != -1 && var1.marginVal() == vVVuuVVv.tertiaryVal() && var1.paramVal() == 1) {
            if (mc.field_1755 == null && !anchorVal()) {
               this.heightRef();
            }
         }
      }
   }

   @Subscribe
   public void primaryVal(MouseClickEvent var1) {
      if (!var1.speedVal()) {
         if (this.enabled && guardVal.tertiaryVal() && VUuuVUnun.secondaryVal("Keybind")) {
            int var2 = -100 - var1.marginVal();
            if (vVVuuVVv.tertiaryVal() != -1 && vVVuuVVv.tertiaryVal() == var2 && var1.widthVal()) {
               if (mc.field_1755 == null && !anchorVal()) {
                  this.heightRef();
               }
            }
         }
      }
   }

   private void trackVal() {
      if (mc.field_1724 == null || mc.field_1687 == null || mc.field_1761 == null) {
         this.tokenVal();
      } else if (twigA != 0) {
         this.depthRef();
      } else if (guardVal.tertiaryVal() && !anchorVal()) {
         if (mc.field_1755 == null) {
            if (VUuuVUnun.secondaryVal("Auto")) {
               this.modeRef();
            }
         }
      } else {
         if (itemB) {
            this.UuNnnVnuNNV();
         }
      }
   }

   private void modeRef() {
      class_1309 var1 = this.angleVal();
      boolean var2 = var1 != null && mc.field_1724.method_23318() - var1.method_23318() >= VuunNUUUvu.tertiaryVal();
      if (!itemB) {
         if (!var2) {
            uunNUuunVU = false;
         } else {
            if (!uunNUuunVU && mc.field_1724.method_6047().method_7909() != class_1802.field_49814 && this.NUVvUUVuVNVv() != -1) {
               NvnuuuvnVV = 0;
               this.levelVal();
            }
         }
      } else {
         NvnuuuvnVV++;
         if (vuvvuVuVv || NvnuuuvnVV > 40 && (!NNUUNUuVNNVn.tertiaryVal() || !this.activeVal())) {
            uunNUuunVU = true;
            this.UuNnnVnuNNV();
         }
      }
   }

   private class_1309 angleVal() {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         float var1 = primaryVal((class_1309)null) + depthVal.tertiaryVal() + VuunNUUUvu.tertiaryVal() + 2.0F;
         double var2 = primaryVal((class_1309)null) + depthVal.tertiaryVal() + 1.5;
         double var4 = var2 * var2;
         class_1309 var6 = null;
         double var7 = Double.MAX_VALUE;

         for (class_1297 var10 : mc.field_1687.method_18112()) {
            if (var10 instanceof class_1309 var11 && !(mc.field_1724.method_23318() - var11.method_23318() < VuunNUUUvu.tertiaryVal())) {
               double var12 = var11.method_23317() - mc.field_1724.method_23317();
               double var14 = var11.method_23321() - mc.field_1724.method_23321();
               double var16 = var12 * var12 + var14 * var14;
               if (!(var16 > var4) && this.primaryVal(var11, var1) && var16 < var7) {
                  var7 = var16;
                  var6 = var11;
               }
            }
         }

         return var6;
      } else {
         return null;
      }
   }

   private void heightRef() {
      if (twigA == 0 && mc.field_1724 != null) {
         if (itemB) {
            this.UuNnnVnuNNV();
         } else {
            this.levelVal();
         }
      }
   }

   private boolean levelVal() {
      if (!itemB && twigA == 0 && mc.field_1724 != null) {
         if (VUuuVUnun.secondaryVal("Auto") && System.currentTimeMillis() < UuuuNNunN) {
            return false;
         }

         if (mc.field_1724.method_6047().method_7909() == class_1802.field_49814) {
            return false;
         }

         int var1 = this.NUVvUUVuVNVv();
         if (var1 == -1) {
            return false;
         }

         int var2 = mc.field_1724.method_31548().method_67532();
         if (var1 == var2) {
            return false;
         }

         uuuVnuvnnNnU = var2;
         if (var1 < 9) {
            nodeJ = true;
            twigH = var1;
            VvuUUUNNNv = -1;
         } else {
            nodeJ = false;
            twigH = -1;
            VvuUUUNNNv = var1;
         }

         this.tertiaryVal(
            nodeJ
               ? "swap IN hotbar slot=" + var1
               : "swap IN inventory slot=" + var1
         );
         twigA = 1;
         itemC = 0;
         this.vVVuuVVv();
         return true;
      } else {
         return false;
      }
   }

   private boolean UuNnnVnuNNV() {
      if (itemB && twigA == 0) {
         this.tertiaryVal("swap OUT start");
         twigA = 11;
         itemC = 0;
         this.vVVuuVVv();
         return true;
      } else {
         return false;
      }
   }

   private void depthRef() {
      InputFreezeManager.primaryVal().primaryVal("AuraMace");
      this.VuunNUUUvu();
      if (itemC > 0) {
         itemC--;
      } else {
         switch (twigA) {
            case 1:
               twigA = 2;
               itemC = 0;
               break;
            case 2:
               this.entryVal();
               itemB = true;
               twigA = 3;
               itemC = 1;
               break;
            case 3:
               this.VUuuVUnun();
               break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            default:
               this.VUuuVUnun();
               break;
            case 11:
               twigA = 12;
               itemC = 0;
               break;
            case 12:
               this.guardVal();
               NnUVNnuvUv = 4;
               twigA = 13;
               itemC = 1;
               break;
            case 13:
               if (this.speedRef()) {
                  this.countRef();
               } else if (NnUVNnuvUv > 0) {
                  NnUVNnuvUv--;
                  this.guardVal();
                  itemC = 1;
               } else {
                  this.countRef();
               }
         }
      }
   }

   private boolean speedRef() {
      return mc.field_1724 == null ? true : mc.field_1724.method_6047().method_7909() != class_1802.field_49814;
   }

   private void countRef() {
      this.tertiaryVal("restored");
      itemB = false;
      VvuUUUNNNv = -1;
      uuuVnuvnnNnU = -1;
      nodeJ = false;
      twigH = -1;
      NnUVNnuvUv = 0;
      vuvvuVuVv = false;
      UuuuNNunN = System.currentTimeMillis() + 300L;
      this.VUuuVUnun();
   }

   private void entryVal() {
      if (mc.field_1724 != null && mc.field_1761 != null) {
         if (nodeJ) {
            if (twigH >= 0 && twigH <= 8) {
               mc.field_1724.method_31548().method_61496(twigH);
            }
         } else if (VvuUUUNNNv >= 0 && uuuVnuvnnNnU >= 0 && uuuVnuvnnNnU <= 8) {
            this.tertiaryVal("clickSlot IN");
            mc.field_1761
               .method_2906(mc.field_1724.field_7498.field_7763, VvuUUUNNNv, uuuVnuvnnNnU, class_1713.field_7791, mc.field_1724);
         }
      }
   }

   private void guardVal() {
      if (mc.field_1724 != null && mc.field_1761 != null) {
         if (nodeJ) {
            if (uuuVnuvnnNnU >= 0 && uuuVnuvnnNnU <= 8) {
               mc.field_1724.method_31548().method_61496(uuuVnuvnnNnU);
            }
         } else if (VvuUUUNNNv >= 0 && uuuVnuvnnNnU >= 0 && uuuVnuvnnNnU <= 8) {
            this.tertiaryVal("clickSlot OUT");
            mc.field_1761
               .method_2906(mc.field_1724.field_7498.field_7763, VvuUUUNNNv, uuuVnuvnnNnU, class_1713.field_7791, mc.field_1724);
         }
      }
   }

   private void VUuuVUnun() {
      twigA = 0;
      itemC = 0;
      InputFreezeManager.primaryVal().secondaryVal("AuraMace");
   }

   private void vVVuuVVv() {
      AdaptiveCombatUtil.chunkVal();
      InputFreezeManager.primaryVal().primaryVal("AuraMace");
      this.VuunNUUUvu();
   }

   private void VuunNUUUvu() {
      SprintModule.radiusVal = 2;
      if (mc.field_1690 != null) {
         mc.field_1690.field_1867.method_23481(false);
      }

      if (mc.field_1724 != null) {
         mc.field_1724.method_5728(false);
      }
   }

   private void tertiaryVal(String var1) {
      if (VvVvnNUnvuvV.tertiaryVal()) {
         int var2 = 0;
         int var3 = 0;
         if (mc.field_1724 != null && mc.field_1724.field_3913 != null) {
            var2 = (mc.field_1724.field_3913.field_54155.comp_3159() ? 1 : 0) - (mc.field_1724.field_3913.field_54155.comp_3160() ? 1 : 0);
            var3 = (mc.field_1724.field_3913.field_54155.comp_3161() ? 1 : 0) - (mc.field_1724.field_3913.field_54155.comp_3162() ? 1 : 0);
         }

         ChatLogger.primaryVal("[Mace] " + var1 + " (fwd=" + var2 + " str=" + var3 + ")");
      }
   }

   private void NNUUNUuVNNVn() {
      if (guardVal.tertiaryVal() && VUuuVUnun.secondaryVal("Auto") && itemB && mc.field_1724 != null) {
         if (mc.field_1724.method_6047().method_7909() == class_1802.field_49814) {
            vuvvuVuVv = true;
            uunNUuunVU = true;
         }
      }
   }

   private void VvVvnNUnvuvV() {
      if (mc.field_1724 != null && mc.field_1761 != null) {
         if (itemB) {
            this.guardVal();
         }

         this.tokenVal();
      } else {
         this.tokenVal();
      }
   }

   private void tokenVal() {
      if (twigA != 0) {
         InputFreezeManager.primaryVal().secondaryVal("AuraMace");
      }

      twigA = 0;
      itemC = 0;
      itemB = false;
      VvuUUUNNNv = -1;
      uuuVnuvnnNnU = -1;
      nodeJ = false;
      twigH = -1;
      vuvvuVuVv = false;
      uunNUuunVU = false;
      NvnuuuvnVV = 0;
      NnUVNnuvUv = 0;
      UuuuNNunN = 0L;
   }

   private int NUVvUUVuVNVv() {
      if (mc.field_1724 == null) {
         return -1;
      }

      for (int var1 = 0; var1 < 36; var1++) {
         if (mc.field_1724.method_31548().method_5438(var1).method_7909() == class_1802.field_49814) {
            return var1;
         }
      }

      return -1;
   }

   public static boolean anchorVal() {
      return ServerHelperModule.tokenVal || ClickPearlModule.descRef || AutoSwapModule.sourceVal || AutoTotemModule.countVal;
   }

   private void nodeB() {
      if (!UNvvunVVn()) {
         twigC = 0.0F;
         UnUUVuVunvVu = 0L;
      } else {
         long var1 = System.currentTimeMillis();
         if (var1 >= UnUUVuVunvVu || twigC <= 0.0F) {
            twigC = ThreadLocalRandom.current().nextFloat(0.08F, 0.32F);
            UnUUVuVunvVu = var1 + ThreadLocalRandom.current().nextLong(55L, 130L);
         }

         mc.field_1724.field_6017 = twigC;
      }
   }

   private static boolean UNvvunVVn() {
      return mc.field_1724 != null && mc.field_1687 != null && mc.field_1724.method_24828() && weightRef();
   }

   public static boolean weightRef() {
      if (mc.field_1724 != null && mc.field_1687 != null) {
         class_2338 var0 = class_2338.method_49637(
            mc.field_1724.method_23317(), mc.field_1724.method_5829().field_1322 - 0.05, mc.field_1724.method_23321()
         );
         class_2338 var1 = class_2338.method_49637(
            mc.field_1724.method_23317(), mc.field_1724.method_5829().field_1325 + 0.2, mc.field_1724.method_23321()
         );
         return primaryVal(var0) && primaryVal(var1);
      } else {
         return false;
      }
   }

   private static boolean primaryVal(class_2338 var0) {
      class_2680 var1 = mc.field_1687.method_8320(var0);
      return !var1.method_26220(mc.field_1687, var0).method_1110();
   }

   private static long UnvuVuVnNuvu() {
      return primaryVal(0L);
   }

   private static long primaryVal(long var0) {
      if (depthRef.secondaryVal("Smart Crits") && mc.field_1724 != null && tokenVal != null) {
         long var2 = System.currentTimeMillis();
         int var4 = tokenVal.method_5628();
         if (var4 != twigD || var2 >= UVnuVUUVnnU || AdaptiveCombatUtil.anchorVal() < 75.0F) {
            twigD = var4;
            VunnVNvNV = UvNNVUVNVuvV();
            UVnuVUUVnnU = var2 + ThreadLocalRandom.current().nextLong(95L, 180L);
         }

         return var0 + VunnVNvNV;
      } else {
         return var0;
      }
   }

   private static long UvNNVUVNVuvV() {
      long var0 = -35L;
      long var2 = 28L;
      boolean var4 = mc.field_1724.field_6017 > 0.0 || mc.field_1724.method_18798().field_1351 < -0.0784;
      if (var4) {
         var0 -= 18L;
         var2 -= 8L;
      }

      if (UNvvunVVn()) {
         var0 -= 22L;
         var2 -= 6L;
      } else if (mc.field_1724.method_24828()) {
         var0 += 8L;
         var2 += 18L;
      }

      if (tokenVal.field_6235 > 0) {
         var0 = Math.max(var0, 4L);
         var2 += 34L;
      }

      double var5 = primaryVal(tokenVal) - HitboxAimUtil.paramVal(tokenVal);
      if (var5 < 0.35F) {
         var0 += 10L;
         var2 += 22L;
      } else if (var5 > 1.0) {
         var0 -= 8L;
      }

      if (var2 < var0) {
         var2 = var0;
      }

      return ThreadLocalRandom.current().nextLong(var0, var2 + 1L);
   }

   @Override
   public void onDisable() {
      MovementUtil.tertiaryVal();
      this.VvVvnNUnvuvV();
      this.nodeF();
      this.nodeH();
      AdaptiveCombatUtil.chunkVal();
      this.paramRef();
      AuraHumanizer.secondaryVal();
      CritAimHelper.marginVal();
      AuraRotationStrategy.secondaryVal();
      CritTimingHelper.secondaryVal();
      CombatAimEngine.tertiaryVal();
      super.onDisable();
   }

   private static void NnunUUnU() {
      if (mc != null) {
         mc.execute(() -> mc.method_1507(new RotationBuilderScreen()));
      }
   }

   private static void nvuVvuNnNUnv() {
      if (mc != null) {
         mc.execute(() -> mc.method_1507(new AimLabScreen()));
      }
   }

   private void nodeF() {
      if (descRef.secondaryVal("Lony Grief")) {
         HumanizedAimController.primaryVal();
      }

      if (descRef.secondaryVal("Side Point")) {
         SilentAimEngine.primaryVal();
      }
   }

   private void nodeH() {
      if (descRef.secondaryVal("Neuro")) {
         NuUvVVvUVVUV.primaryVal(trackVal.tertiaryVal());
      }
   }

   @RequiresRole(tertiaryVal = {"lichoday", "bitrixtime", "oblamovvv"})
   static final class WildClient {
      private WildClient() {
      }
   }
}
