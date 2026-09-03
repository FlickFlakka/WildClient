package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.class_10055;
import net.minecraft.class_1044;
import net.minecraft.class_10868;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_1297;
import net.minecraft.class_1304;
import net.minecraft.class_1309;
import net.minecraft.class_1429;
import net.minecraft.class_1531;
import net.minecraft.class_1542;
import net.minecraft.class_1569;
import net.minecraft.class_1621;
import net.minecraft.class_1646;
import net.minecraft.class_1657;
import net.minecraft.class_1799;
import net.minecraft.class_238;
import net.minecraft.class_243;
import net.minecraft.class_2561;
import net.minecraft.class_2583;
import net.minecraft.class_2960;
import net.minecraft.class_332;
import net.minecraft.class_3532;
import net.minecraft.class_408;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_490;
import net.minecraft.class_5251;
import net.minecraft.class_5498;
import net.minecraft.class_591;
import net.minecraft.class_630;
import net.minecraft.class_640;
import net.minecraft.class_742;
import net.minecraft.class_897;
import net.minecraft.class_9334;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.glfw.GLFW;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "NameTags",
   secondaryVal = "Entity tags",
   tertiaryVal = ModuleCategory.Visuals
)
public class NameTagsModule extends Module {
   private static final float speedRef = 0.0625F;
   private static final long countRef = 250L;
   public final ModeSetting countVal = new ModeSetting(
      "Display mode", "Legacy", "Legacy", "New"
   );
   private static final int entryVal = Renderer2D.VvunVVUvUNnv.tertiaryVal(88, 220, 116, 255);
   private static final String guardVal = "Players";
   private static final String VUuuVUnun = "Naked";
   private static final String vVVuuVVv = "Mobs";
   private static final String VuunNUUUvu = "Animals";
   private static final String NNUUNUuVNNVn = "Items";
   public final SettingGroup depthVal = new SettingGroup(
         "Targets",
         new BoolSetting("Players", true),
         new BoolSetting("Naked", true),
         new BoolSetting("Mobs", false),
         new BoolSetting("Animals", false),
         new BoolSetting("Items", false)
      )
      .primaryVal(() -> this.countVal.secondaryVal("New"));
   public final SettingGroup descRef = new SettingGroup("Type", new BoolSetting("Player", true), new BoolSetting("Hologram", true))
      .primaryVal(() -> this.countVal.secondaryVal("New"));
   public final BoolSetting activeVal = new BoolSetting("Armor", true)
      .primaryVal(() -> this.countVal.secondaryVal("Legacy") && !this.depthVal.secondaryVal("Players"));
   public final BoolSetting radiusVal = new BoolSetting("Right hand", true)
      .primaryVal(() -> this.countVal.secondaryVal("Legacy") && !this.depthVal.secondaryVal("Players"));
   public final BoolSetting factorVal = new BoolSetting("Left hand", true)
      .primaryVal(() -> this.countVal.secondaryVal("Legacy") && !this.depthVal.secondaryVal("Players"));
   public final BoolSetting sourceVal = new BoolSetting("Effects", true)
      .primaryVal(() -> !this.countVal.secondaryVal("Legacy"));
   public final BoolSetting extraRef = new BoolSetting("HP bar", true)
      .primaryVal(() -> !this.countVal.secondaryVal("Legacy"));
   public final BoolSetting phaseVal = new BoolSetting("Invisibles", true)
      .primaryVal(() -> this.countVal.secondaryVal("Legacy"));
   public final BoolSetting limitRef = new BoolSetting("Info on hover", true)
      .primaryVal(() -> this.countVal.secondaryVal("Legacy"));
   public final FloatSetting paramRef = new FloatSetting("Size", 1.2F, 0.75F, 1.9F, 0.05F, true)
      .primaryVal(() -> this.countVal.secondaryVal("Legacy"));
   public final FloatSetting groupVal = new FloatSetting("Tag size", 1.0F, 0.5F, 2.5F, 0.05F, false)
      .primaryVal(() -> this.countVal.secondaryVal("New"));
   public final FloatSetting layerVal = new FloatSetting(
         "Detail radius", 11.0F, 2.0F, 32.0F, 0.5F, false
      )
      .primaryVal(() -> this.countVal.secondaryVal("Legacy"));
   public final ModeSetting slotVal = new ModeSetting(
         "Outline mode",
         "Boxes",
         "Boxes",
         "Skeleton",
         "Don't Render"
      )
      .primaryVal(() -> !this.countVal.secondaryVal("Legacy"));
   public final ModeSetting themeVal = new ModeSetting(
         "Style",
         "Dark",
         "Dark",
         "Light",
         "Blur",
         "Neumorphism",
         "Ferrofluid"
      )
      .primaryVal(() -> this.countVal.secondaryVal("New"));
   public final BoolSetting stageVal = new BoolSetting(
         "Show head", true
      )
      .primaryVal(() -> this.countVal.secondaryVal("New"));
   public final BoolSetting widthRef = new BoolSetting(
         "Show full names", false
      )
      .primaryVal(() -> this.countVal.secondaryVal("New"));
   public final BoolSetting trackVal = new BoolSetting(
         "Item highlighting", true
      )
      .primaryVal(() -> this.countVal.secondaryVal("New"));
   public final BoolSetting modeRef = new BoolSetting("Tag shadow", true)
      .primaryVal(() -> this.countVal.secondaryVal("New"));
   public final BoolSetting angleVal = new BoolSetting("Text gradient", false)
      .primaryVal(() -> this.countVal.secondaryVal("New"));
   public final BoolSetting heightRef = new BoolSetting(
         "Item color in gradient", true
      )
      .primaryVal(() -> this.countVal.secondaryVal("New") || !this.angleVal.tertiaryVal());
   public final ColorSetting levelVal = new ColorSetting(
         "Second text color", 47.0F, 0.45F, 1.0F
      )
      .secondaryVal(() -> this.countVal.secondaryVal("New") || !this.angleVal.tertiaryVal());
   public final FloatSetting UuNnnVnuNNV = new FloatSetting(
         "Gradient speed", 1.0F, 0.2F, 3.0F, 0.1F, false
      )
      .primaryVal(() -> this.countVal.secondaryVal("New") || !this.angleVal.tertiaryVal());
   public final FloatSetting depthRef = new FloatSetting("Transparency", 1.0F, 0.1F, 1.0F, 0.05F, true);
   private final UuNuuVUnv VvVvnNUnvuvV = new UuNuuVUnv();
   private final Map<class_1657, NameTagsModule.AccessGuardException> tokenVal = new HashMap<>();
   private final Map<class_1309, NameTagsModule.AccessGuardException> NUVvUUVuVNVv = new HashMap<>();
   private final Map<class_1542, NameTagsModule.AccessGuardException> nodeB = new HashMap<>();
   private final Map<Integer, NameTagsModule.cursorVal> UNvvunVVn = new HashMap<>();
   private final List<NameTagsModule.DelayedFuse> UnvuVuVnNuvu = new ArrayList<>();
   private final Set<Integer> UvNNVUVNVuvV = new HashSet<>();
   private final List<class_1799> NnunUUnU = new ArrayList<>();
   private final List<class_1799> nvuVvuNnNUnv = new ArrayList<>();
   private final class_4587 nodeF = new class_4587();
   private final Vector3f nodeH = new Vector3f();
   private final List<NameTagsModule.VvunVVUvUNnv> OCOocoOoOO = new ArrayList<>();
   private final List<float[]> o0Ooc0COOoc = new ArrayList<>();
   private boolean twigB;
   private float UnUUVuVunvVu;
   private float twigC;
   private float UVnuVUUVnnU;
   private float VunnVNvNV;
   private final Map<String, Float> twigD = new HashMap<>();
   private final Map<Integer, Long> nodeD = new HashMap<>();
   private final SettingHolder NnuUnUNnu = new SettingHolder() {};
   private boolean UnnnvvU = false;
   private float VUUnuVvVu = 0.0F;
   private float VvVuvUvvNNVv = 0.0F;
   private float UnnNNvuvvUU = 0.0F;
   private float twigA = 0.0F;
   private float itemC = 0.0F;
   private boolean itemB = false;
   private boolean VvuUUUNNNv = false;
   private long uuuVnuvnnNnU = 0L;
   private int nodeJ;
   private int twigH;
   private int vuvvuVuVv;
   private int uunNUuunVU;
   private int NvnuuuvnVV;
   private int NnUVNnuvUv;
   private static final ThemeSwatchCatalog UuuuNNunN = ThemeSwatchCatalog.primaryVal();

   public NameTagsModule() {
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
         this.limitRef,
         this.paramRef,
         this.groupVal,
         this.layerVal,
         this.slotVal,
         this.depthRef,
         this.themeVal,
         this.stageVal,
         this.widthRef,
         this.trackVal,
         this.modeRef,
         this.angleVal,
         this.heightRef,
         this.levelVal,
         this.UuNnnVnuNNV
      );
      this.NnuUnUNnu.primaryVal(this.groupVal);
      this.NnuUnUNnu.primaryVal(this.depthVal);
      this.NnuUnUNnu.primaryVal(this.descRef);
      this.NnuUnUNnu.primaryVal(this.activeVal);
      this.NnuUnUNnu.primaryVal(this.radiusVal);
      this.NnuUnUNnu.primaryVal(this.factorVal);
      this.NnuUnUNnu.primaryVal(this.sourceVal);
      this.NnuUnUNnu.primaryVal(this.extraRef);
      this.NnuUnUNnu.primaryVal(this.slotVal);
      this.NnuUnUNnu.primaryVal(this.depthRef);
      this.NnuUnUNnu.primaryVal(this.themeVal);
      this.NnuUnUNnu.primaryVal(this.stageVal);
      this.NnuUnUNnu.primaryVal(this.widthRef);
      this.NnuUnUNnu.primaryVal(this.trackVal);
      this.NnuUnUNnu.primaryVal(this.modeRef);
      this.NnuUnUNnu.primaryVal(this.angleVal);
      this.NnuUnUNnu.primaryVal(this.heightRef);
      this.NnuUnUNnu.primaryVal(this.levelVal);
      this.NnuUnUNnu.primaryVal(this.UuNnnVnuNNV);
   }

   @Override
   public void onEnable() {
      this.VvVvnNUnvuvV.primaryVal();
      this.nodeD.clear();
      this.twigD.clear();
      this.UNvvunVVn.clear();
      super.onEnable();
   }

   @Override
   public void onDisable() {
      this.VvVvnNUnvuvV.primaryVal();
      this.nodeD.clear();
      this.twigD.clear();
      this.UNvvunVVn.clear();
      super.onDisable();
   }

   @Subscribe
   public void primaryVal(WorldJoinEvent var1) {
      this.VvVvnNUnvuvV.primaryVal();
      this.tokenVal.clear();
      this.NUVvUUVuVNVv.clear();
      this.nodeB.clear();
      this.UnvuVuVnNuvu.clear();
      this.UNvvunVVn.clear();
      this.twigD.clear();
      this.nodeD.clear();
   }

   @Subscribe(priority = 0)
   public void primaryVal(RenderHudEvent var1) {
      if (this.enabled && !(mc.field_1755 instanceof class_490)) {
         if (this.countVal.secondaryVal("New")) {
            this.VvVvnNUnvuvV.primaryVal(var1, this);
         } else {
            this.secondaryVal(var1);
         }
      }
   }

   public boolean primaryVal(int var1) {
      return this.enabled && var1 == 60;
   }

   private void secondaryVal(RenderHudEvent var1) {
      if (mc.field_1687 != null && mc.field_1724 != null) {
         this.blockRef();
         this.OCOocoOoOO.clear();
         this.o0Ooc0COOoc.clear();
         float var2 = mc.method_61966().method_60637(true);
         this.primaryVal(var2);
         this.holderVal();
         Renderer2D var3 = var1.marginVal();
         class_332 var4 = var1.limitVal();
         this.UnvuVuVnNuvu.clear();
         float var5 = (float)mc.field_1729.method_1603();
         float var6 = (float)mc.field_1729.method_1604();
         boolean var7 = mc.field_1755 instanceof class_408;
         Set var8 = this.UvNNVUVNVuvV;
         var8.clear();
         if (!this.tokenVal.isEmpty() || !this.NUVvUUVuVNVv.isEmpty() || !this.nodeB.isEmpty()) {
            for (Entry var10 : this.tokenVal.entrySet()) {
               class_1657 var11 = (class_1657)var10.getKey();
               NameTagsModule.AccessGuardException var12 = (NameTagsModule.AccessGuardException)var10.getValue();
               if (!this.primaryVal(var12)) {
                  var8.add(var11.method_5628());
                  this.nodeD.putIfAbsent(var11.method_5628(), System.currentTimeMillis());
                  float var13 = class_3532.method_15363((float)(System.currentTimeMillis() - this.nodeD.get(var11.method_5628())) / 300.0F, 0.0F, 1.0F);
                  this.primaryVal(var3, var4, var11, var12, var5, var6, var7, var2, var13);
               }
            }

            for (Entry var20 : this.NUVvUUVuVNVv.entrySet()) {
               class_1309 var23 = (class_1309)var20.getKey();
               NameTagsModule.AccessGuardException var26 = (NameTagsModule.AccessGuardException)var20.getValue();
               if (!this.primaryVal(var26)) {
                  var8.add(var23.method_5628());
                  this.nodeD.putIfAbsent(var23.method_5628(), System.currentTimeMillis());
                  float var29 = class_3532.method_15363((float)(System.currentTimeMillis() - this.nodeD.get(var23.method_5628())) / 300.0F, 0.0F, 1.0F);
                  if (!(var23 instanceof class_1646 var14 && this.primaryVal(var3, var14, var26, var29))) {
                     this.primaryVal(var3, var23, var26, var5, var6, var7, var29);
                  }
               }
            }

            for (Entry var21 : this.nodeB.entrySet()) {
               class_1542 var24 = (class_1542)var21.getKey();
               NameTagsModule.AccessGuardException var27 = (NameTagsModule.AccessGuardException)var21.getValue();
               if (!this.primaryVal(var27)) {
                  var8.add(var24.method_5628());
                  this.nodeD.putIfAbsent(var24.method_5628(), System.currentTimeMillis());
                  float var30 = class_3532.method_15363((float)(System.currentTimeMillis() - this.nodeD.get(var24.method_5628())) / 300.0F, 0.0F, 1.0F);
                  class_1799 var32 = var24.method_6983();
                  this.primaryVal(var3, var24, var27, var32, var30);
               }
            }
         }

         this.nodeD.keySet().retainAll(var8);
         this.primaryVal(var3, var4);
         if (var7) {
            boolean var19 = GLFW.glfwGetMouseButton(mc.method_22683().method_4490(), 0) == 1;
            boolean var22 = GLFW.glfwGetMouseButton(mc.method_22683().method_4490(), 1) == 1;
            boolean var25 = var19 && !this.itemB;
            boolean var28 = var22 && !this.VvuUUUNNNv;
            this.itemB = var19;
            this.VvuUUUNNNv = var22;
            boolean var31 = this.primaryVal(var3, var5, var6, var19, var25);
            if (!var31 && (var25 || var28) && System.currentTimeMillis() - this.uuuVnuvnnNnU > 150L) {
               this.uuuVnuvnnNnU = System.currentTimeMillis();
               boolean var33 = false;

               for (NameTagsModule.VvunVVUvUNnv var16 : this.OCOocoOoOO) {
                  if (this.primaryVal(var5, var6, var16.x, var16.y, var16.w, var16.h)) {
                     var33 = true;
                     if (var25) {
                        this.UnnnvvU = !this.UnnnvvU;
                        if (this.UnnnvvU) {
                           this.VUUnuVvVu = var16.x;
                           this.VvVuvUvvNNVv = var16.y;
                           this.UnnNNvuvvUU = var16.w;
                           this.twigA = var16.h;
                        }
                     } else if (var16.playerName != null) {
                        FriendCommand.secondaryVal(var16.playerName);
                     }
                     break;
                  }
               }

               if (var25 && !var33 && this.UnnnvvU) {
                  UuUuVnVvnvn.WildClient var35 = UuUuVnVvnvn.primaryVal(var3, this.NnuUnUNnu, this.VUUnuVvVu, this.VvVuvUvvNNVv, this.UnnNNvuvvUU, this.twigA);
                  if (!var35.contains(var5, var6, 8.0F)) {
                     this.UnnnvvU = false;
                  }
               }
            }

            float var34 = this.UnnnvvU ? 1.0F : 0.0F;
            this.itemC = this.itemC + (var34 - this.itemC) * 0.15F;
            if (this.itemC > 0.01F) {
               UuUuVnVvnvn.primaryVal(
                  var3,
                  this.NnuUnUNnu,
                  this.VUUnuVvVu,
                  this.VvVuvUvvNNVv,
                  this.UnnNNvuvvUU,
                  this.twigA,
                  mc.method_22683().method_4486(),
                  mc.method_22683().method_4502(),
                  this.itemC,
                  var5,
                  var6,
                  var25,
                  var19
               );
            }
         } else {
            this.UnnnvvU = false;
            this.itemC = 0.0F;
            this.itemB = false;
            this.VvuUUUNNNv = false;
            this.twigB = false;
         }
      }
   }

   private boolean primaryVal(Renderer2D var1, float var2, float var3, boolean var4, boolean var5) {
      float var6 = 9.0F;
      if (this.twigB) {
         if (!var4) {
            this.twigB = false;
            if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.holderVal != null) {
               ru.metaculture.protection.WildClient.primaryVal.holderVal.tertiaryVal();
            }
         } else {
            float var7 = (var2 - this.UVnuVUUVnnU + (var3 - this.VunnVNvNV)) * 0.5F;
            float var8 = (this.twigC + var7) / Math.max(1.0F, this.twigC);
            this.groupVal.primaryVal(this.UnUUVuVunvVu * var8);
         }
      }

      for (float[] var13 : this.o0Ooc0COOoc) {
         float var9 = var13[0] + var13[2];
         float var10 = var13[1] + var13[3];
         boolean var11 = !this.twigB && var2 >= var9 - var6 && var2 <= var9 + 2.0F && var3 >= var10 - var6 && var3 <= var10 + 2.0F;
         if (var11 && var5) {
            this.twigB = true;
            this.UnUUVuVunvVu = this.groupVal.tertiaryVal();
            this.twigC = var13[2];
            this.UVnuVUUVnnU = var2;
            this.VunnVNvNV = var3;
         }

         this.primaryVal(var1, var9, var10, var11);
      }

      return this.twigB;
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, boolean var4) {
      int var5 = var4 ? Renderer2D.VvunVVUvUNnv.tertiaryVal(255, 255, 255, 180) : Renderer2D.VvunVVUvUNnv.tertiaryVal(255, 255, 255, 55);
      float var6 = 2.0F;
      float var7 = 4.0F;
      var1.primaryVal(var2 - var6, var3 - var6, var6, var6, 1.0F, var5);
      var1.primaryVal(var2 - var6 - var7, var3 - var6, var6, var6, 1.0F, var5);
      var1.primaryVal(var2 - var6, var3 - var6 - var7, var6, var6, 1.0F, var5);
   }

   private void blockRef() {
      float var1 = this.depthRef.tertiaryVal();
      String var2 = this.themeVal.tertiaryVal();
      if (var2.equals("Light")) {
         this.nodeJ = Renderer2D.VvunVVUvUNnv.tertiaryVal(240, 240, 245, (int)(255.0F * var1));
         this.twigH = Renderer2D.VvunVVUvUNnv.tertiaryVal(220, 220, 225, (int)(200.0F * var1));
         this.vuvvuVuVv = Renderer2D.VvunVVUvUNnv.tertiaryVal(200, 200, 200, (int)(180.0F * var1));
         this.uunNUuunVU = Renderer2D.VvunVVUvUNnv.tertiaryVal(170, 170, 170, (int)(255.0F * var1));
         this.NvnuuuvnVV = Renderer2D.VvunVVUvUNnv.tertiaryVal(30, 30, 30, 255);
         this.NnUVNnuvUv = Renderer2D.VvunVVUvUNnv.tertiaryVal(100, 100, 100, 255);
      } else if (var2.equals("Blur")) {
         this.nodeJ = Renderer2D.VvunVVUvUNnv.tertiaryVal(10, 10, 10, (int)(120.0F * var1));
         this.twigH = Renderer2D.VvunVVUvUNnv.tertiaryVal(30, 30, 30, (int)(90.0F * var1));
         this.vuvvuVuVv = Renderer2D.VvunVVUvUNnv.tertiaryVal(255, 255, 255, (int)(40.0F * var1));
         this.uunNUuunVU = Renderer2D.VvunVVUvUNnv.tertiaryVal(255, 255, 255, (int)(90.0F * var1));
         this.NvnuuuvnVV = Renderer2D.VvunVVUvUNnv.tertiaryVal(250, 250, 250, 255);
         this.NnUVNnuvUv = Renderer2D.VvunVVUvUNnv.tertiaryVal(200, 200, 200, 255);
      } else if (var2.equals("Neumorphism")) {
         this.nodeJ = NeumorphicThemeRenderer.primaryVal(var1);
         this.twigH = NeumorphicThemeRenderer.primaryVal(var1);
         this.vuvvuVuVv = Renderer2D.VvunVVUvUNnv.tertiaryVal(0, 0, 0, 0);
         this.uunNUuunVU = Renderer2D.VvunVVUvUNnv.tertiaryVal(0, 0, 0, 0);
         this.NvnuuuvnVV = NeumorphicThemeRenderer.secondaryVal(1.0F);
         this.NnUVNnuvUv = NeumorphicThemeRenderer.tertiaryVal(1.0F);
      } else {
         this.nodeJ = Renderer2D.VvunVVUvUNnv.tertiaryVal(25, 25, 26, (int)(255.0F * var1));
         this.twigH = Renderer2D.VvunVVUvUNnv.tertiaryVal(35, 35, 35, (int)(170.0F * var1));
         this.vuvvuVuVv = Renderer2D.VvunVVUvUNnv.tertiaryVal(78, 78, 78, (int)(176.0F * var1));
         this.uunNUuunVU = Renderer2D.VvunVVUvUNnv.tertiaryVal(120, 120, 120, (int)(255.0F * var1));
         this.NvnuuuvnVV = Renderer2D.VvunVVUvUNnv.tertiaryVal(240, 240, 240, 255);
         this.NnUVNnuvUv = Renderer2D.VvunVVUvUNnv.tertiaryVal(200, 200, 200, 255);
      }

      this.primaryVal(var1, var2);
   }

   private void primaryVal(float var1, String var2) {
      NvVNvUvunNNu var3 = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal()
         : NvVNvUvunNNu.WILD;
      boolean var4 = "Light".equals(var2) || UuuuNNunN.tertiaryVal(var3) || NeumorphicThemeRenderer.marginVal();
      ThemePalette var5 = ThemePalette.primaryVal(var3, var4);
      int var6 = ColorUtil.tertiaryVal(var5.depthVal(), var5.descRef(), 0.42F);
      if (var4 && !"Neumorphism".equals(var2)) {
         this.nodeJ = ColorUtil.primaryVal(ColorUtil.tertiaryVal(-196865, var5.depthVal(), 0.026F), (int)(184.0F * var1));
         this.twigH = ColorUtil.primaryVal(ColorUtil.tertiaryVal(-1, var5.descRef(), 0.04F), (int)(210.0F * var1));
         this.vuvvuVuVv = ColorUtil.primaryVal(ColorUtil.tertiaryVal(-15261133, var6, 0.34F), (int)(48.0F * var1));
         this.uunNUuunVU = ColorUtil.primaryVal(ColorUtil.tertiaryVal(-15261133, var6, 0.56F), (int)(92.0F * var1));
         this.NvnuuuvnVV = ColorUtil.primaryVal(ColorUtil.tertiaryVal(-15722718, var5.depthVal(), 0.035F), 255);
         this.NnUVNnuvUv = ColorUtil.primaryVal(ColorUtil.tertiaryVal(-12168086, var5.descRef(), 0.055F), 255);
      } else if ("Ferrofluid".equals(var2)) {
         this.nodeJ = ColorUtil.primaryVal(ColorUtil.tertiaryVal(-15657182, var5.depthVal(), 0.1F), (int)(230.0F * var1));
         this.twigH = ColorUtil.primaryVal(ColorUtil.tertiaryVal(-15393492, var5.descRef(), 0.14F), (int)(235.0F * var1));
         this.vuvvuVuVv = ColorUtil.primaryVal(var6, (int)(72.0F * var1));
         this.uunNUuunVU = ColorUtil.primaryVal(var6, (int)(122.0F * var1));
         this.NvnuuuvnVV = Renderer2D.VvunVVUvUNnv.tertiaryVal(246, 248, 255, 255);
         this.NnUVNnuvUv = Renderer2D.VvunVVUvUNnv.tertiaryVal(188, 197, 214, 255);
      }
   }

   private void primaryVal(Renderer2D var1, class_332 var2, class_1657 var3, NameTagsModule.AccessGuardException var4, float var5, float var6, boolean var7, float var8, float var9) {
      float var10 = (float)class_3532.method_15350(16.0 / Math.max(var4.distance(), 12.0), 0.75, 1.15) * this.groupVal.tertiaryVal();
      float var11 = Math.abs(var4.feetY() - var4.headY());
      float var12 = Math.max(4.0F * var10, var4.boxRight() - var4.boxLeft());
      float var13 = var4.boxLeft();
      float var14 = Math.min(var4.headY(), var4.feetY());
      float var15 = 6.0F * var10;
      String var16 = var3.method_7334() != null ? var3.method_7334().getName() : var3.method_5477().getString();
      String var17 = ProtectInfoModule.primaryVal(var16);
      String var18 = TargetHud.primaryVal(var3);
      int var19 = TargetHud.primaryVal(var3, Renderer2D.VvunVVUvUNnv.primaryVal(255, 70, 70), 255);
      boolean var20 = FriendCommand.primaryVal(var16);
      if (this.slotVal.secondaryVal("Boxes")) {
         float var21 = var12 * 0.25F;
         float var22 = Math.max(1.0F, 1.5F * var10);
         long var23 = System.currentTimeMillis();
         float var25 = (float)(Math.sin(var23 / 200.0) + 1.0) / 2.0F;
         int var26 = this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(150, 150, 150, 150), Renderer2D.VvunVVUvUNnv.tertiaryVal(255, 255, 255, 220), var25 * 0.4F);
         var26 = this.primaryVal(var26, var9);
         var1.primaryVal(var13, var14, var21, var22, 0.0F, var26);
         var1.primaryVal(var13, var14, var22, var21, 0.0F, var26);
         var1.primaryVal(var13 + var12 - var21, var14, var21, var22, 0.0F, var26);
         var1.primaryVal(var13 + var12 - var22, var14, var22, var21, 0.0F, var26);
         var1.primaryVal(var13, var14 + var11 - var22, var21, var22, 0.0F, var26);
         var1.primaryVal(var13, var14 + var11 - var21, var22, var21, 0.0F, var26);
         var1.primaryVal(var13 + var12 - var21, var14 + var11 - var22, var21, var22, 0.0F, var26);
         var1.primaryVal(var13 + var12 - var22, var14 + var11 - var21, var22, var21, 0.0F, var26);
      } else if (this.slotVal.secondaryVal("Skeleton")) {
         this.primaryVal(var1, var3, var9);
      } else {
         this.slotVal.secondaryVal("Don't Render");
      }

      float var60 = TargetHud.primaryVal((class_1309)var3);
      String var61 = Integer.toString(Math.round(var60));
      String var62 = " HP";
      String var24 = var20 ? "[FRIEND] " : "";
      float var63 = 22.0F * var10;
      float var65 = 22.0F * var10;
      float var27 = 16.0F * var10;
      float var28 = 6.0F * var10;
      float var29 = 4.0F * var10;
      float var30 = 22.0F * var10;
      float var31 = var24.isEmpty() ? 0.0F : Renderer2D.primaryVal(FontRegistry.primaryVal, var24, var63).primaryVal;
      float var32 = Renderer2D.primaryVal(FontRegistry.primaryVal, var17, var63).primaryVal;
      float var33 = var18.isEmpty() ? 0.0F : Renderer2D.primaryVal(FontRegistry.primaryVal, var18, var65).primaryVal;
      float var34 = Renderer2D.primaryVal(FontRegistry.primaryVal, var61, var63).primaryVal;
      float var35 = Renderer2D.primaryVal(FontRegistry.primaryVal, var62, var63).primaryVal;
      float var36 = var31 + (var18.isEmpty() ? 0.0F : var33 + var29) + var32 + var29 + var34 + var35;
      float var37 = var36 + var28 * 2.0F;
      float var38 = var37 + (this.stageVal.tertiaryVal() ? var30 + var29 : 0.0F);
      float var39 = var4.screenX() - var38 / 2.0F;
      float var40 = var14 - var30 - 8.0F * var10;
      UvVNVNVuNN.primaryVal(var3.method_5667(), var40);
      List<class_1799> var41 = this.NnunUUnU;
      var41.clear();
      if (this.activeVal.tertiaryVal()) {
         class_1799 var42 = var3.method_6118(class_1304.field_6169);
         if (!var42.method_7960()) {
            var41.add(var42);
         }

         class_1799 var43 = var3.method_6118(class_1304.field_6174);
         if (!var43.method_7960()) {
            var41.add(var43);
         }

         class_1799 var44 = var3.method_6118(class_1304.field_6172);
         if (!var44.method_7960()) {
            var41.add(var44);
         }

         class_1799 var45 = var3.method_6118(class_1304.field_6166);
         if (!var45.method_7960()) {
            var41.add(var45);
         }
      }

      if (!var41.isEmpty()) {
         float var66 = 18.0F * var10;
         float var71 = 4.0F * var10;
         float var75 = var41.size() * var66 + (var41.size() - 1) * var71;
         float var77 = var4.screenX() - var75 / 2.0F;
         float var46 = var40 - var66 - 6.0F * var10;
         UvVNVNVuNN.primaryVal(var3.method_5667(), var46);
         int var47 = 0;

         for (class_1799 var49 : var41) {
            this.primaryVal(var1, var77, var46, var66, var66, var15, var9, var49);
            this.primaryVal(var3, var49, var77 + var10, var46 + var10, var47, var10, 0);
            var77 += var66 + var71;
            var47++;
         }
      }

      float var67 = var39;
      if (this.stageVal.tertiaryVal()) {
         this.primaryVal(var1, var67, var40, var30, var30, var15, var9, 0.0F);
         float var72 = var30 - 4.0F * var10;
         this.primaryVal(var1, var3, var67 + 2.0F * var10, var40 + 2.0F * var10, var72, var9);
         var67 += var30 + var29;
      }

      if (var20) {
         int var73 = this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(25, 80, 25, 255), var9);
         var1.primaryVal(var67, var40, var37, var30, var15, var73);
      } else {
         this.primaryVal(var1, var67, var40, var37, var30, var15, var9, 0.0F);
      }

      this.OCOocoOoOO.add(new NameTagsModule.VvunVVUvUNnv(var67, var40, var37, var30, var16));
      if (var7) {
         this.o0Ooc0COOoc.add(new float[]{var67, var40, var37, var30});
      }

      var67 += var28;
      float var74 = var40 + 15.0F * var10;
      if (!var24.isEmpty()) {
         var1.primaryVal(FontRegistry.primaryVal, var67, var74, var63, var24, this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(60, 150, 255, 255), var9));
         var67 += var31;
      }

      if (!var18.isEmpty()) {
         var1.primaryVal(FontRegistry.primaryVal, var67, var74, var65, var18, this.primaryVal(var19, var9));
         var67 += var33 + var29;
      }

      this.primaryVal(var1, FontRegistry.primaryVal, var67, var74, var63, var17, this.primaryVal(var20 ? entryVal : this.NvnuuuvnVV, var9));
      var67 += var32 + var29;
      var1.primaryVal(FontRegistry.primaryVal, var67, var74, var63, var61, this.primaryVal(this.primaryVal(var60, var3.method_6063()), var9));
      var67 += var34;
      var1.primaryVal(FontRegistry.primaryVal, var67, var74, var63, var62, this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(150, 150, 150, 255), var9));
      float var76 = class_3532.method_15363(var60 / var3.method_6063(), 0.0F, 1.0F);
      int var78 = this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(60, 150, 255, 255), var9);
      float var79 = 2.0F * var10;
      float var80 = var13 - var79 - 4.0F * var10;
      if (this.extraRef.tertiaryVal()) {
         var1.primaryVal(var80, var14, var79, var11, 1.0F, this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(0, 0, 0, 100), var9));
         float var81 = var11 * var76;
         var1.primaryVal(var80, var14 + (var11 - var81), var79, var81, 1.0F, var78);
      }

      float var82 = var13 + var12 + 8.0F * var10;
      float var83 = var14;
      float var50 = 20.0F * var10;
      if (this.sourceVal.tertiaryVal()) {
         for (class_1293 var52 : var3.method_6026()) {
            String var53 = class_2561.method_43471(var52.method_5586()).getString();
            int var54 = var52.method_5578() + 1;
            String var55 = var53 + (var54 > 1 ? " " + var54 : "");
            int var56 = ((class_1291)var52.method_5579().comp_349()).method_5573() ? this.NvnuuuvnVV : Renderer2D.VvunVVUvUNnv.tertiaryVal(255, 60, 60, 255);
            var1.primaryVal(FontRegistry.primaryVal, var82, var83 + 10.0F * var10, var50, var55, this.primaryVal(var56, var9));
            var83 += 12.0F * var10;
         }
      }

      List var84 = this.nvuVvuNnNUnv;
      var84.clear();
      if (this.factorVal.tertiaryVal() && !var3.method_6079().method_7960()) {
         var84.add(var3.method_6079());
      }

      if (this.radiusVal.tertiaryVal() && !var3.method_6047().method_7960()) {
         var84.add(var3.method_6047());
      }

      float var85 = var14 + var11 + 6.0F * var10;
      float var86 = 22.0F * var10;
      float var87 = 4.0F * var10;
      if (this.widthRef.tertiaryVal()) {
         float var88 = var85;

         for (int var90 = 0; var90 < var84.size(); var90++) {
            var88 += this.primaryVal(var1, var3, (class_1799)var84.get(var90), var4.screenX(), var88, var10, var9, 99 + var90, 1) + 3.0F * var10;
         }
      } else {
         float var89 = var84.size() * var86 + Math.max(0, var84.size() - 1) * var87;
         float var91 = var4.screenX() - var89 / 2.0F;

         for (int var57 = 0; var57 < var84.size(); var57++) {
            class_1799 var58 = (class_1799)var84.get(var57);
            this.primaryVal(var1, var91, var85, var86, var86, var15, var9, var58);
            float var59 = 3.0F * var10;
            this.primaryVal(var3, var58, var91 + var59, var85 + var59, 99 + var57, var10, 1);
            var91 += var86 + var87;
         }
      }
   }

   private float primaryVal(Renderer2D var1, class_1657 var2, class_1799 var3, float var4, float var5, float var6, float var7, int var8, int var9) {
      float var10 = 22.0F * var6;
      float var11 = var10;
      float var12 = 4.0F * var6;
      float var13 = 7.0F * var6;
      float var14 = 18.0F * var6;
      float var15 = Math.max(70.0F * var6, Math.min(190.0F * var6, mc.method_22683().method_4489() * 0.28F));
      String var16 = this.primaryVal(this.primaryVal(var3, true), var14, var15);
      float var17 = Renderer2D.primaryVal(FontRegistry.secondaryVal, var16, var14).primaryVal;
      float var18 = var17 + var13 * 2.0F;
      float var19 = var11 + var12 + var18;
      float var20 = var4 - var19 / 2.0F;
      float var21 = 6.0F * var6;
      this.primaryVal(var1, var20, var5, var11, var11, var21, var7, var3);
      this.primaryVal(var2, var3, var20 + 3.0F * var6, var5 + 3.0F * var6, var8, var6, var9);
      float var22 = var20 + var11 + var12;
      this.primaryVal(var1, var22, var5, var18, var10, var21, var7, var3);
      this.primaryVal(var1, FontRegistry.secondaryVal, var22 + var13, var5 + 15.0F * var6, var14, var16, var3, var8, var7);
      return var10;
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, float var6, float var7, class_1799 var8) {
      if (this.trackVal.tertiaryVal()) {
         int var9 = this.primaryVal(var8, var7);
         var1.primaryVal(var2, var3, var4, var5, var6, 5.0F, 1.0F, this.primaryVal(var9, 0.55F));
      }

      this.primaryVal(var1, var2, var3, var4, var5, var6, var7, 0.0F);
   }

   public static void primaryVal(class_10055 var0, class_591 var1, class_4587 var2) {
      if (ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null) {
         NameTagsModule var3 = ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(NameTagsModule.class);
         if (var3 != null) {
            var3.secondaryVal(var0, var1, var2);
         }
      }
   }

   private void secondaryVal(class_10055 var1, class_591 var2, class_4587 var3) {
      if (this.enabled && mc != null && mc.field_1724 != null && mc.field_1687 != null) {
         if (!(mc.field_1755 instanceof class_490)) {
            if (this.countVal.secondaryVal("Legacy") && this.slotVal.secondaryVal("Skeleton")) {
               if (var1 != null && var2 != null && var3 != null) {
                  if (!var1.field_53542 && !var1.field_53333 && !var1.field_53461) {
                     if (var1.field_53528 != mc.field_1724.method_5628() || mc.field_1690.method_31044() != class_5498.field_26664) {
                        class_243 var4 = mc.field_1773.method_19418().method_19326();
                        ArrayList var5 = new ArrayList(14);
                        class_243 var6 = this.primaryVal(var2.field_3391, var3, var4, 0.0F, 0.0F, 0.0F);
                        class_243 var7 = this.primaryVal(var2.field_3391, var3, var4, 0.0F, 6.0F, 0.0F);
                        class_243 var8 = this.primaryVal(var2.field_3391, var3, var4, 0.0F, 12.0F, 0.0F);
                        class_243 var9 = this.primaryVal(var2.field_3398, var3, var4, 0.0F, -8.0F, 0.0F);
                        class_243 var10 = this.primaryVal(var2.field_3398, var3, var4, 0.0F, 0.0F, 0.0F);
                        class_243 var11 = this.primaryVal(var2.field_3401, var3, var4, 0.0F, 0.0F, 0.0F);
                        class_243 var12 = this.primaryVal(var2.field_3401, var3, var4, 0.0F, 4.5F, 0.0F);
                        class_243 var13 = this.primaryVal(var2.field_3401, var3, var4, 0.0F, 10.0F, 0.0F);
                        class_243 var14 = this.primaryVal(var2.field_27433, var3, var4, 0.0F, 0.0F, 0.0F);
                        class_243 var15 = this.primaryVal(var2.field_27433, var3, var4, 0.0F, 4.5F, 0.0F);
                        class_243 var16 = this.primaryVal(var2.field_27433, var3, var4, 0.0F, 10.0F, 0.0F);
                        class_243 var17 = this.primaryVal(var2.field_3392, var3, var4, 0.0F, 0.0F, 0.0F);
                        class_243 var18 = this.primaryVal(var2.field_3392, var3, var4, 0.0F, 6.0F, 0.0F);
                        class_243 var19 = this.primaryVal(var2.field_3392, var3, var4, 0.0F, 12.0F, 0.0F);
                        class_243 var20 = this.primaryVal(var2.field_3397, var3, var4, 0.0F, 0.0F, 0.0F);
                        class_243 var21 = this.primaryVal(var2.field_3397, var3, var4, 0.0F, 6.0F, 0.0F);
                        class_243 var22 = this.primaryVal(var2.field_3397, var3, var4, 0.0F, 12.0F, 0.0F);
                        this.primaryVal(var5, var6, var7);
                        this.primaryVal(var5, var7, var8);
                        this.primaryVal(var5, var9, var10);
                        this.primaryVal(var5, var14, var11);
                        this.primaryVal(var5, var20, var17);
                        this.primaryVal(var5, var14, var15);
                        this.primaryVal(var5, var15, var16);
                        this.primaryVal(var5, var11, var12);
                        this.primaryVal(var5, var12, var13);
                        this.primaryVal(var5, var20, var21);
                        this.primaryVal(var5, var21, var22);
                        this.primaryVal(var5, var17, var18);
                        this.primaryVal(var5, var18, var19);
                        if (!var5.isEmpty()) {
                           this.UNvvunVVn.put(var1.field_53528, new NameTagsModule.cursorVal(var5, System.currentTimeMillis()));
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private class_243 primaryVal(class_630 var1, class_4587 var2, class_243 var3, float var4, float var5, float var6) {
      this.nodeF.method_34426();
      this.nodeF.method_23760().method_23761().set(var2.method_23760().method_23761());
      var1.method_22703(this.nodeF);
      Matrix4f var7 = this.nodeF.method_23760().method_23761();
      Vector3f var8 = this.nodeH.set(var4 * 0.0625F, var5 * 0.0625F, var6 * 0.0625F);
      var7.transformPosition(var8);
      return var3.method_1031(var8.x, var8.y, var8.z);
   }

   private void primaryVal(List<NameTagsModule.WildClient> var1, class_243 var2, class_243 var3) {
      if (var2 != null && var3 != null) {
         var1.add(new NameTagsModule.WildClient(var2, var3));
      }
   }

   private void primaryVal(Renderer2D var1, class_1657 var2, float var3) {
      NameTagsModule.cursorVal var4 = this.UNvvunVVn.get(var2.method_5628());
      if (var4 != null && System.currentTimeMillis() - var4.capturedAt() <= 250L) {
         for (NameTagsModule.WildClient var6 : var4.bones()) {
            this.primaryVal(var1, var6.start(), var6.end(), var3);
         }
      }
   }

   private void holderVal() {
      long var1 = System.currentTimeMillis();
      this.UNvvunVVn.entrySet().removeIf(var2 -> var1 - var2.getValue().capturedAt() > 250L);
   }

   private void primaryVal(Renderer2D var1, class_243 var2, class_243 var3, float var4) {
      class_243 var5 = this.primaryVal(var2.field_1352, var2.field_1351, var2.field_1350);
      class_243 var6 = this.primaryVal(var3.field_1352, var3.field_1351, var3.field_1350);
      if (var5 != null && var6 != null) {
         double var7 = mc.field_1773.method_19418().method_19326().method_1022(var2);
         float var9 = class_3532.method_15363((float)(12.0 / Math.max(var7, 1.0)), 1.0F, 10.0F);
         float var10 = var4 * this.depthRef.tertiaryVal();
         int var11 = this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(200, 200, 210, 255), var10);
         float var12 = (float)Math.hypot(var6.field_1352 - var5.field_1352, var6.field_1351 - var5.field_1351);
         float var13 = (float)Math.toDegrees(Math.atan2(var6.field_1351 - var5.field_1351, var6.field_1352 - var5.field_1352));
         var1.primaryVal((float)var5.field_1352, (float)var5.field_1351);
         var1.secondaryVal(var13);
         if (!(var7 > 12.0) && !(var9 < 2.0F)) {
            int var14 = this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(20, 20, 20, 180), var10);
            int var15 = this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(255, 255, 255, 255), var10);
            var1.primaryVal(0.0F, -var9 * 0.3F, var12, var9 * 0.6F, 0.0F, var11);
            var1.primaryVal(0.0F, -var9 * 0.1F, var12, var9 * 0.2F, 0.0F, var15);
         } else {
            var1.primaryVal(0.0F, -var9 / 2.0F, var12, var9, 0.0F, var11);
         }

         var1.extraVal();
         var1.limitVal();
      }
   }

   private class_243 primaryVal(double var1, double var3, double var5) {
      class_4184 var7 = mc.field_1773.method_19418();
      class_243 var8 = new class_243(var1, var3, var5);
      if (var8.method_1025(var7.method_19326()) < 1.0E-6) {
         return null;
      }

      class_243 var9 = VnNnNnvuvn.primaryVal(var8);
      return !(var9.field_1350 <= 0.001F) && !(var9.field_1350 > 1.0) ? var9 : null;
   }

   private void primaryVal(float var1) {
      this.tokenVal.clear();
      this.NUVvUUVuVNVv.clear();
      this.nodeB.clear();
      if (mc.field_1687 != null && mc.field_1724 != null) {
         if (this.depthVal.secondaryVal("Players")) {
            this.secondaryVal(var1);
         }

         if (this.depthVal.secondaryVal("Mobs")
            || this.depthVal.secondaryVal("Animals")
            || this.anchorVal()) {
            this.tertiaryVal(var1);
         }

         if (this.depthVal.secondaryVal("Items")) {
            this.marginVal(var1);
         }
      }
   }

   private void secondaryVal(float var1) {
      for (class_1657 var3 : mc.field_1687.method_18456()) {
         if (var3 != null
            && var3.method_5805()
            && (var3 != mc.field_1724 || !mc.field_1690.method_31044().method_31034())
            && (this.depthVal.secondaryVal("Naked") || var3.method_6096() != 0 || var3 == mc.field_1724)) {
            NameTagsModule.AccessGuardException var4 = this.primaryVal(var1, var3, var3.method_17682() + 0.2, 0.02);
            if (var4 != null) {
               this.tokenVal.put(var3, var4);
            }
         }
      }
   }

   private void tertiaryVal(float var1) {
      AutoVillageTradeModule var2 = this.timerVal();

      for (class_1297 var4 : mc.field_1687.method_18112()) {
         if (var4 instanceof class_1309 var5
            && var5.method_5805()
            && var5 != mc.field_1724
            && !(var5 instanceof class_1657)
            && !(var5 instanceof class_1531)) {
            boolean var6 = var5 instanceof class_1646 var7 && var2 != null && var2.primaryVal(var7) != null;
            if ((!this.primaryVal(var5) || this.depthVal.secondaryVal("Mobs") || var6)
               && (!this.secondaryVal(var5) || this.depthVal.secondaryVal("Animals"))
               && (this.primaryVal(var5) || this.secondaryVal(var5) || var6)) {
               NameTagsModule.AccessGuardException var8 = this.primaryVal(var1, var5, var5.method_17682() + 0.18, 0.02);
               if (var8 != null) {
                  this.NUVvUUVuVNVv.put(var5, var8);
               }
            }
         }
      }
   }

   private void marginVal(float var1) {
      for (class_1297 var3 : mc.field_1687.method_18112()) {
         if (var3 instanceof class_1542 var4 && var4.method_5805() && !var4.method_6983().method_7960()) {
            NameTagsModule.AccessGuardException var5 = this.primaryVal(var1, var4, 0.52, 0.0);
            if (var5 != null) {
               this.nodeB.put(var4, var5);
            }
         }
      }
   }

   private NameTagsModule.AccessGuardException primaryVal(float var1, class_1297 var2, double var3, double var5) {
      class_4184 var7 = mc.field_1773.method_19418();
      class_243 var8 = var7.method_19326();
      class_243 var9 = var2.method_30950(var1);
      class_238 var10 = var2.method_5829();
      class_243 var11 = var2.method_19538();
      class_238 var12 = var10.method_989(var9.field_1352 - var11.field_1352, var9.field_1351 - var11.field_1351, var9.field_1350 - var11.field_1350);
      class_238 var13 = new class_238(
         var12.field_1323 - 0.02, var9.field_1351 + var5, var12.field_1321 - 0.02, var12.field_1320 + 0.02, var9.field_1351 + var3, var12.field_1324 + 0.02
      );
      NameTagsModule.AccessGuardException var14 = this.primaryVal(var13, var8);
      if (var14 != null) {
         return var14;
      } else {
         class_243 var15 = new class_243(var9.field_1352, var9.field_1351 + var3, var9.field_1350);
         class_243 var16 = new class_243(var9.field_1352, var9.field_1351 + var5, var9.field_1350);
         if (var15.method_1025(var8) < 1.0E-6) {
            return null;
         } else {
            class_243 var17 = VnNnNnvuvn.primaryVal(var15);
            class_243 var18 = VnNnNnvuvn.primaryVal(var16);
            if (var17.field_1350 <= 0.001F || var17.field_1350 > 1.0) {
               return null;
            } else if (!(var18.field_1350 <= 0.001F) && !(var18.field_1350 > 1.0)) {
               double var19 = var8.method_1022(var15);
               float var21 = Math.abs((float)var18.field_1351 - (float)var17.field_1351);
               float var22 = var21 * 0.45F;
               float var23 = (float)var17.field_1352;
               return new NameTagsModule.AccessGuardException(
                  var23, (float)var17.field_1351, (float)var18.field_1351, (float)var17.field_1350, var19, var23 - var22 / 2.0F, var23 + var22 / 2.0F
               );
            } else {
               return null;
            }
         }
      }
   }

   private NameTagsModule.AccessGuardException primaryVal(class_238 var1, class_243 var2) {
      float var3 = Float.POSITIVE_INFINITY;
      float var4 = Float.POSITIVE_INFINITY;
      float var5 = Float.NEGATIVE_INFINITY;
      float var6 = Float.NEGATIVE_INFINITY;
      float var7 = 0.0F;
      double var8 = (var1.field_1323 + var1.field_1320) * 0.5;
      double var10 = (var1.field_1322 + var1.field_1325) * 0.5;
      double var12 = (var1.field_1321 + var1.field_1324) * 0.5;

      for (int var14 = 0; var14 < 2; var14++) {
         double var15 = var14 == 0 ? var1.field_1323 : var1.field_1320;

         for (int var17 = 0; var17 < 2; var17++) {
            double var18 = var17 == 0 ? var1.field_1322 : var1.field_1325;

            for (int var20 = 0; var20 < 2; var20++) {
               double var21 = var20 == 0 ? var1.field_1321 : var1.field_1324;
               class_243 var23 = VnNnNnvuvn.primaryVal(new class_243(var15, var18, var21));
               if (var23 == null || var23.field_1350 <= 0.001F || var23.field_1350 > 1.0) {
                  return null;
               }

               var3 = Math.min(var3, (float)var23.field_1352);
               var4 = Math.min(var4, (float)var23.field_1351);
               var5 = Math.max(var5, (float)var23.field_1352);
               var6 = Math.max(var6, (float)var23.field_1351);
               var7 += (float)var23.field_1350;
            }
         }
      }

      if (Float.isFinite(var3) && Float.isFinite(var4) && Float.isFinite(var5) && Float.isFinite(var6)) {
         double var24 = var2.method_1022(new class_243(var8, var10, var12));
         return new NameTagsModule.AccessGuardException((var3 + var5) * 0.5F, var4, var6, var7 / 8.0F, var24, var3, var5);
      } else {
         return null;
      }
   }

   private boolean primaryVal(NameTagsModule.AccessGuardException var1) {
      return var1 == null || var1.depth() <= 0.001F || var1.depth() > 1.0F;
   }

   private int primaryVal(float var1, float var2) {
      float var3 = class_3532.method_15363(var1 / Math.max(1.0F, var2), 0.0F, 1.0F);
      int var4 = var3 >= 0.5F ? (int)(255.0F * (1.0F - var3) * 2.0F) : 255;
      int var5 = var3 >= 0.5F ? 255 : (int)(255.0F * var3 * 2.0F);
      return Renderer2D.VvunVVUvUNnv.tertiaryVal(var4, var5, 50, 255);
   }

   private boolean primaryVal(Renderer2D var1, class_1646 var2, NameTagsModule.AccessGuardException var3, float var4) {
      AutoVillageTradeModule var5 = this.timerVal();
      if (var5 == null) {
         return false;
      } else {
         AutoVillageTradeModule.cursorVal var6 = var5.primaryVal(var2);
         if (var6 != null && var6.itemStack() != null && !var6.itemStack().method_7960()) {
            class_1799 var7 = var6.itemStack();
            float var8 = (float)class_3532.method_15350(16.0 / Math.max(var3.distance(), 12.0), 0.75, 1.15) * this.groupVal.tertiaryVal();
            float var9 = 6.0F * var8;
            float var10 = 18.0F * var8;
            float var11 = 22.0F * var8;
            float var12 = 4.0F * var8;
            float var13 = 6.0F * var8;
            String var14 = var6.price() + " emer. · x" + var6.availableAmount();
            float var15 = Renderer2D.primaryVal(FontRegistry.secondaryVal, var14, var10).primaryVal;
            float var16 = var15 + var13 * 2.0F;
            float var17 = var11 + var12 + var16;
            float var18 = var3.screenX() - var17 / 2.0F;
            float var19 = var3.headY() - 18.0F * var8;
            this.primaryVal(var1, var18, var19, var11, var11, var9, var4, var7);
            float var20 = (var11 - 16.0F * var8) / 2.0F;
            this.primaryVal(mc.field_1724, var7, var18 + var20, var19 + var20, var2.method_5628(), var8, 0);
            float var21 = var18 + var11 + var12;
            this.primaryVal(var1, var21, var19, var16, var11, var9, var4, var7);
            this.primaryVal(var1, FontRegistry.secondaryVal, var21 + var13, var19 + 15.0F * var8, var10, var14, var7, var2.method_5628(), var4);
            return true;
         } else {
            return false;
         }
      }
   }

   private AutoVillageTradeModule timerVal() {
      return ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.secondaryVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.secondaryVal.primaryVal(AutoVillageTradeModule.class)
         : null;
   }

   private boolean anchorVal() {
      AutoVillageTradeModule var1 = this.timerVal();
      return var1 != null && var1.enabled;
   }

   private void primaryVal(Renderer2D var1, class_1309 var2, NameTagsModule.AccessGuardException var3, float var4, float var5, boolean var6, float var7) {
      float var8 = (float)class_3532.method_15350(6.0 / Math.max(var3.distance(), 1.0), 0.45, 1.0) * this.groupVal.tertiaryVal();
      float var9 = 6.0F * var8;
      String var10 = ProtectInfoModule.primaryVal(var2.method_5477().getString());
      float var11 = var2.method_6032() + var2.method_6067();
      float var12 = var2.method_6063();
      String var13 = " " + String.format("%.1f", var11).replace(',', '.');
      if (var13.endsWith(".0")) {
         var13 = var13.substring(0, var13.length() - 2);
      }

      float var14 = 22.0F * var8;
      float var15 = Renderer2D.primaryVal(FontRegistry.primaryVal, var10, var14).primaryVal;
      float var16 = Renderer2D.primaryVal(FontRegistry.primaryVal, var13, var14).primaryVal;
      float var17 = this.stageVal.tertiaryVal() ? 14.0F * var8 : 0.0F;
      float var18 = this.stageVal.tertiaryVal() ? 4.0F * var8 : 0.0F;
      float var19 = var17 + var18 + var15 + var16;
      float var20 = var19 + 16.0F * var8;
      float var21 = 17.0F * var8;
      float var22 = var3.screenX() - var20 / 2.0F;
      float var23 = var3.headY() - 18.0F * var8;
      boolean var24 = var6 && this.primaryVal(var4, var5, var22, var23, var20, var21);
      String var25 = var2.method_5845();
      float var26 = this.twigD.getOrDefault(var25, 0.0F);
      float var27 = var24 && !this.UnnnvvU ? 1.0F : 0.0F;
      var26 += (var27 - var26) * 0.15F;
      this.twigD.put(var25, var26);
      this.primaryVal(var1, var22, var23, var20, var21, var9, var7, var26);
      float var28 = var3.screenX() - var19 / 2.0F;
      if (this.stageVal.tertiaryVal()) {
         this.primaryVal(var1, var2, var28, var23 + 1.5F * var8, var17, var7);
         var28 += var17 + var18;
      }

      this.primaryVal(var1, FontRegistry.primaryVal, var28, var23 + 12.2F * var8, var14, var10, this.primaryVal(this.NnUVNnuvUv, var7));
      var28 += var15;
      var1.primaryVal(FontRegistry.primaryVal, var28, var23 + 12.2F * var8, var14, var13, this.primaryVal(this.primaryVal(var11, var12), var7));
   }

   private void primaryVal(Renderer2D var1, String var2, float var3, float var4, float var5, float var6) {
      if (mc.method_1562() != null) {
         class_640 var7 = null;

         for (class_640 var9 : mc.method_1562().method_2880()) {
            if (var9.method_2966().getName().equalsIgnoreCase(var2)) {
               var7 = var9;
               break;
            }
         }

         if (var7 != null) {
            try {
               class_2960 var13 = var7.method_52810().comp_1626();
               class_1044 var14 = mc.method_1531().method_4619(var13);
               if (var14 != null && var14.method_68004() instanceof class_10868 var10 && var10.method_68427() > 0) {
                  int var15 = var10.method_68427();
                  GlStateManager._bindTexture(var15);
                  var1.weightVal(var6);
                  var1.primaryVal(var15, var3, var4, var5, var5, 0.125F, 0.125F, 0.25F, 0.25F, 3.0F);
                  var1.primaryVal(var15, var3, var4, var5, var5, 0.625F, 0.125F, 0.75F, 0.25F, 3.0F);
                  var1.widthVal();
               }
            } catch (Throwable var12) {
            }
         }
      }
   }

   private void primaryVal(Renderer2D var1, class_1309 var2, float var3, float var4, float var5, float var6) {
      boolean var7 = false;
      if (var2 instanceof class_1657 var8) {
         if (var8 instanceof class_742 var9) {
            try {
               class_2960 var10 = var9.method_52814().comp_1626();
               class_1044 var11 = mc.method_1531().method_4619(var10);
               if (var11 != null && var11.method_68004() instanceof class_10868 var12 && var12.method_68427() > 0) {
                  int var38 = var12.method_68427();
                  GlStateManager._bindTexture(var38);
                  var1.weightVal(var6);
                  var1.primaryVal(var38, var3, var4, var5, var5, 0.125F, 0.125F, 0.25F, 0.25F, 3.0F);
                  var1.primaryVal(var38, var3, var4, var5, var5, 0.625F, 0.125F, 0.75F, 0.25F, 3.0F);
                  var1.widthVal();
                  var7 = true;
               }
            } catch (Throwable var19) {
            }
         }

         if (!var7 && mc.method_1562() != null) {
            class_640 var22 = null;

            for (class_640 var29 : mc.method_1562().method_2880()) {
               if (var29.method_2966().getId().equals(var8.method_5667()) || var29.method_2966().getName().equalsIgnoreCase(var8.method_5477().getString())) {
                  var22 = var29;
                  break;
               }
            }

            if (var22 != null) {
               try {
                  class_2960 var26 = var22.method_52810().comp_1626();
                  class_1044 var30 = mc.method_1531().method_4619(var26);
                  if (var30 != null && var30.method_68004() instanceof class_10868 var34 && var34.method_68427() > 0) {
                     int var40 = var34.method_68427();
                     GlStateManager._bindTexture(var40);
                     var1.weightVal(var6);
                     var1.primaryVal(var40, var3, var4, var5, var5, 0.125F, 0.125F, 0.25F, 0.25F, 3.0F);
                     var1.primaryVal(var40, var3, var4, var5, var5, 0.625F, 0.125F, 0.75F, 0.25F, 3.0F);
                     var1.widthVal();
                     var7 = true;
                  }
               } catch (Throwable var18) {
               }
            }
         }
      } else {
         try {
            class_897 var23 = mc.method_1561().method_3953(var2);
            class_2960 var27 = null;

            for (Method var14 : var23.getClass().getMethods()) {
               if (var14.getReturnType() == class_2960.class
                  && var14.getParameterCount() == 1
                  && var14.getParameterTypes()[0].isAssignableFrom(var2.getClass())) {
                  var14.setAccessible(true);
                  var27 = (class_2960)var14.invoke(var23, var2);
                  break;
               }
            }

            if (var27 != null) {
               class_1044 var32 = mc.method_1531().method_4619(var27);
               if (var32 != null && var32.method_68004() instanceof class_10868 var36 && var36.method_68427() > 0) {
                  int var43 = var36.method_68427();
                  GlStateManager._bindTexture(var43);
                  var1.weightVal(var6);
                  float var45 = 0.125F;
                  float var15 = 0.125F;
                  float var16 = 0.25F;
                  float var17 = 0.25F;
                  if (var2 instanceof class_1429) {
                     var45 = 0.0F;
                     var15 = 0.125F;
                     var16 = 0.125F;
                     var17 = 0.25F;
                  }

                  var1.primaryVal(var43, var3, var4, var5, var5, var45, var15, var16, var17, 3.0F);
                  var1.widthVal();
                  var7 = true;
               }
            }
         } catch (Throwable var20) {
         }
      }

      if (!var7) {
         int var21 = this.primaryVal(ColorUtil.tertiaryVal(30, 30, 30, 120), var6);
         var1.primaryVal(var3, var4, var5, var5, 4.0F, var21);
         String var24 = ProtectInfoModule.primaryVal(var2.method_5477().getString());
         String var28 = var24.isEmpty() ? "?" : var24.substring(0, 1).toUpperCase();
         int var33 = this.primaryVal(ColorUtil.tertiaryVal(200, 200, 200, 200), var6);
         float var37 = var5 * 0.65F;
         float var44 = Renderer2D.primaryVal(FontRegistry.marginVal, var28, var37).primaryVal;
         var1.primaryVal(FontRegistry.marginVal, var3 + (var5 - var44) / 2.0F, var4 + var5 / 2.0F + var37 * 0.35F, var37, var28, var33);
      }
   }

   private void primaryVal(Renderer2D var1, class_1542 var2, NameTagsModule.AccessGuardException var3, class_1799 var4, float var5) {
      float var6 = (float)class_3532.method_15350(16.0 / Math.max(var3.distance(), 12.0), 0.75, 1.15) * this.groupVal.tertiaryVal();
      float var7 = 6.0F * var6;
      float var8 = 20.0F * var6;
      String var9 = this.primaryVal(
         this.primaryVal(var4, this.widthRef.tertiaryVal()),
         var8,
         Math.max(86.0F * var6, Math.min(190.0F * var6, mc.method_22683().method_4489() * 0.3F))
      );
      float var10 = 22.0F * var6;
      float var11 = 4.0F * var6;
      float var12 = Renderer2D.primaryVal(FontRegistry.secondaryVal, var9, var8).primaryVal;
      float var13 = 6.0F * var6;
      float var14 = var12 + var13 * 2.0F;
      float var15 = var10 + var11 + var14;
      float var16 = var3.screenX() - var15 / 2.0F;
      float var17 = var3.headY() - 12.0F * var6;
      this.primaryVal(var1, var16, var17, var10, var10, var7, var5, var4);
      float var18 = (var10 - 16.0F * var6) / 2.0F;
      this.primaryVal(mc.field_1724, var4, var16 + var18, var17 + var18, var2.method_5628(), var6, 0);
      float var19 = var16 + var10 + var11;
      this.primaryVal(var1, var19, var17, var14, var10, var7, var5, var4);
      this.primaryVal(var1, FontRegistry.secondaryVal, var19 + var13, var17 + 15.0F * var6, var8, var9, var4, var2.method_5628(), var5);
   }

   private void primaryVal(Renderer2D var1, FontObject var2, float var3, float var4, float var5, String var6, int var7) {
      if (!this.angleVal.tertiaryVal()) {
         var1.primaryVal(var2, var3, var4, var5, var6, var7);
      } else {
         int var8 = Renderer2D.VvunVVUvUNnv.chunkVal(this.levelVal.limitVal(), var7 >>> 24 & 0xFF);
         var1.primaryVal(var2, var3, var4, var5, var6, var7, var8, this.weightRef());
      }
   }

   private void primaryVal(Renderer2D var1, FontObject var2, float var3, float var4, float var5, String var6, class_1799 var7, int var8, float var9) {
      if (!this.angleVal.tertiaryVal()) {
         var1.primaryVal(var2, var3, var4, var5, var6, this.secondaryVal(var7, var9));
      } else if (!this.heightRef.tertiaryVal()) {
         this.primaryVal(var1, var2, var3, var4, var5, var6, this.secondaryVal(var7, var9));
      } else {
         int[] var10 = NuNvVUuUUnun.primaryVal(var7, var8);
         if (var10 == null) {
            var10 = NuNvVUuUUnun.primaryVal();
         }

         int var11 = Math.round(255.0F * class_3532.method_15363(var9, 0.0F, 1.0F));
         int var12 = Renderer2D.VvunVVUvUNnv.tertiaryVal(0, 0, 0, Math.round(185.0F * class_3532.method_15363(var9, 0.0F, 1.0F)));
         var1.primaryVal(var2, var3 + Math.max(0.45F, var5 * 0.035F), var4 + Math.max(0.45F, var5 * 0.035F), var5, var6, var12);
         var1.primaryVal(
            var2, var3, var4, var5, var6, Renderer2D.VvunVVUvUNnv.chunkVal(var10[0], var11), Renderer2D.VvunVVUvUNnv.chunkVal(var10[1], var11), this.weightRef()
         );
      }
   }

   private float weightRef() {
      float var1 = Math.max(600.0F, 2600.0F / Math.max(0.1F, this.UuNnnVnuNNV.tertiaryVal()));
      return (float)(System.currentTimeMillis() % (long)var1) / var1;
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (!(var7 <= 0.05F)) {
         if (this.themeVal.tertiaryVal().equals("Neumorphism")) {
            float var9 = var7 * this.depthRef.tertiaryVal();
            float var10 = 4.8F + var8 * 1.8F;
            float var11 = 16.0F + var8 * 4.0F;
            float var12 = 0.72F + var8 * 0.12F;
            if (NeumorphicThemeRenderer.primaryVal(null, var2, var3, var4, var5, var6, var10, var11, var12, 1, false, var9)) {
               return;
            }
         }

         if (this.themeVal.tertiaryVal().equals("Blur")) {
            var1.primaryVal(23.0F);
            var1.primaryVal(var2, var3, var4, var5, var6, var7 * this.depthRef.tertiaryVal());
         }

         int var13 = this.primaryVal(this.vuvvuVuVv, this.uunNUuunVU, var8);
         int var15 = this.primaryVal(this.nodeJ, this.twigH, var8);
         var15 = this.primaryVal(var15, var7);
         var13 = this.primaryVal(var13, var7);
         if (this.modeRef.tertiaryVal()) {
            var1.primaryVal(var2, var3, var4, var5, var6, this.bufferVal() ? 7.0F : 5.0F, 1.0F, this.weightVal(var7));
         }

         var1.primaryVal(var2, var3, var4, var5, var6, var15);
         var1.primaryVal(var2, var3, var4, var5, var6, var13, 1.0F);
      }
   }

   private boolean bufferVal() {
      NvVNvUvunNNu var1 = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal()
         : NvVNvUvunNNu.WILD;
      return "Light".equals(this.themeVal.tertiaryVal()) || UuuuNNunN.tertiaryVal(var1) || NeumorphicThemeRenderer.marginVal();
   }

   private int weightVal(float var1) {
      if (!this.bufferVal()) {
         return this.primaryVal(Renderer2D.VvunVVUvUNnv.tertiaryVal(0, 0, 0, 120), var1);
      }

      NvVNvUvunNNu var2 = ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.chunkVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.chunkVal.secondaryVal()
         : NvVNvUvunNNu.WILD;
      ThemePalette var3 = ThemePalette.primaryVal(var2, true);
      int var4 = ColorUtil.tertiaryVal(-10787208, var3.descRef(), 0.1F);
      return ColorUtil.primaryVal(var4, (int)(48.0F * Math.max(0.0F, Math.min(1.0F, var1 * this.depthRef.tertiaryVal()))));
   }

   private int primaryVal(int var1, int var2, float var3) {
      int var4 = var1 >> 24 & 0xFF;
      int var5 = var1 >> 16 & 0xFF;
      int var6 = var1 >> 8 & 0xFF;
      int var7 = var1 & 0xFF;
      int var8 = var2 >> 24 & 0xFF;
      int var9 = var2 >> 16 & 0xFF;
      int var10 = var2 >> 8 & 0xFF;
      int var11 = var2 & 0xFF;
      int var12 = (int)(var4 + (var8 - var4) * var3);
      int var13 = (int)(var5 + (var9 - var5) * var3);
      int var14 = (int)(var6 + (var10 - var6) * var3);
      int var15 = (int)(var7 + (var11 - var7) * var3);
      return Renderer2D.VvunVVUvUNnv.tertiaryVal(var13, var14, var15, var12);
   }

   private void primaryVal(class_1657 var1, class_1799 var2, float var3, float var4, int var5, float var6, int var7) {
      if (var2 != null && !var2.method_7960()) {
         this.UnvuVuVnNuvu.add(new NameTagsModule.DelayedFuse(var1, var2.method_7972(), var3, var4, var5, var6, var7));
      }
   }

   private void primaryVal(Renderer2D var1, class_332 var2) {
      if (!this.UnvuVuVnNuvu.isEmpty()) {
         this.UnvuVuVnNuvu.sort(Comparator.comparingInt(NameTagsModule.DelayedFuse::priority));

         for (NameTagsModule.DelayedFuse var4 : this.UnvuVuVnNuvu) {
            NuNvVUuUUnun.primaryVal(var1, var4.stack(), var4.x(), var4.y(), var4.scale(), var4.seed(), false, var4.priority());
         }

         this.UnvuVuVnNuvu.clear();
      }
   }

   private boolean primaryVal(class_1309 var1) {
      return var1 instanceof class_1569 || var1 instanceof class_1621 || var1 instanceof class_1646;
   }

   private boolean secondaryVal(class_1309 var1) {
      return var1 instanceof class_1429;
   }

   private int primaryVal(class_1799 var1, float var2) {
      boolean var3 = var1 != null && !var1.method_7960() && var1.method_57826(class_9334.field_49631);
      int var4 = this.secondaryVal(var1, var2);
      int var5 = var3
         ? Renderer2D.VvunVVUvUNnv.tertiaryVal(
            Renderer2D.VvunVVUvUNnv.holderVal(var4), Renderer2D.VvunVVUvUNnv.timerVal(var4), Renderer2D.VvunVVUvUNnv.anchorVal(var4), 210
         )
         : Renderer2D.VvunVVUvUNnv.tertiaryVal(142, 148, 158, 135);
      return this.primaryVal(var5, var2);
   }

   private int secondaryVal(class_1799 var1, float var2) {
      boolean var3 = this.bufferVal();
      int var4 = var3 ? Renderer2D.VvunVVUvUNnv.chunkVal(this.NvnuuuvnVV, 255) : Renderer2D.VvunVVUvUNnv.tertiaryVal(220, 255, 245, 255);
      if (var1 != null && !var1.method_7960()) {
         int[] var5 = new int[]{var4};

         try {
            class_2561 var6 = var1.method_7964();
            var6.method_27658(
               (var1x, var2x) -> {
                  class_5251 var3x = var1x.method_10973();
                  if (var3x != null && var2x != null && !var2x.isBlank()) {
                     var5[0] = Renderer2D.VvunVVUvUNnv.tertiaryVal(
                        var3x.method_27716() >> 16 & 0xFF, var3x.method_27716() >> 8 & 0xFF, var3x.method_27716() & 0xFF, 255
                     );
                     return Optional.of(Boolean.TRUE);
                  } else {
                     return Optional.empty();
                  }
               },
               class_2583.field_24360
            );
         } catch (Throwable var7) {
         }

         int var8 = var5[0];
         if (var3 && secondaryVal(var8)) {
            var8 = Renderer2D.VvunVVUvUNnv.chunkVal(this.NvnuuuvnVV, 255);
         }

         return this.primaryVal(var8, var2);
      } else {
         return this.primaryVal(var4, var2);
      }
   }

   private static boolean secondaryVal(int var0) {
      int var1 = var0 >> 16 & 0xFF;
      int var2 = var0 >> 8 & 0xFF;
      int var3 = var0 & 0xFF;
      return var1 * 0.299F + var2 * 0.587F + var3 * 0.114F >= 205.0F;
   }

   private String primaryVal(class_1799 var1, boolean var2) {
      if (var1 != null && !var1.method_7960()) {
         int var3 = Math.max(1, var1.method_7947());
         String var4 = var1.method_7964().getString().replaceAll("\u00a7.", "").replaceAll("\\p{Cntrl}", "").replaceAll("\\s+", " ").trim();
         if (var4.isEmpty()) {
            var4 = "Item";
         }

         if (!var2 && var4.length() > 22) {
            var4 = var4.substring(0, 19).trim() + "...";
         }

         return var4 + (var3 > 1 ? " x" + var3 : "");
      } else {
         return "Empty";
      }
   }

   private String primaryVal(String var1, float var2, float var3) {
      if (var1 == null || var1.isEmpty()) {
         return "";
      }

      if (Renderer2D.primaryVal(FontRegistry.secondaryVal, var1, var2).primaryVal <= var3) {
         return var1;
      }

      String var4 = "...";
      float var5 = Renderer2D.primaryVal(FontRegistry.secondaryVal, var4, var2).primaryVal;
      int var6 = var1.length();

      while (var6 > 0 && Renderer2D.primaryVal(FontRegistry.secondaryVal, var1.substring(0, var6), var2).primaryVal + var5 > var3) {
         var6--;
      }

      return var6 <= 0 ? var4 : var1.substring(0, var6).trim() + var4;
   }

   private int primaryVal(int var1, float var2) {
      int var3 = var1 >> 24 & 0xFF;
      int var4 = var1 >> 16 & 0xFF;
      int var5 = var1 >> 8 & 0xFF;
      int var6 = var1 & 0xFF;
      return Renderer2D.VvunVVUvUNnv.tertiaryVal(var4, var5, var6, (int)(var3 * var2));
   }

   private boolean primaryVal(float var1, float var2, float var3, float var4, float var5, float var6) {
      return var1 >= var3 && var1 <= var3 + var5 && var2 >= var4 && var2 <= var4 + var6;
   }

   record WildClient(class_243 start, class_243 end) {
   }

   record VvunVVUvUNnv(float x, float y, float w, float h, String playerName) {
   }

   record AccessGuardException(float screenX, float headY, float feetY, float depth, double distance, float boxLeft, float boxRight) {
   }

   record cursorVal(List<NameTagsModule.WildClient> bones, long capturedAt) {
   }

   record DelayedFuse(class_1657 player, class_1799 stack, float x, float y, int seed, float scale, int priority) {
   }
}
