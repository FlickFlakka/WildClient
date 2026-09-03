package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.class_1297;
import net.minecraft.class_1542;
import net.minecraft.class_1799;
import net.minecraft.class_243;
import net.minecraft.class_2767;
import net.minecraft.class_3414;
import net.minecraft.class_3532;
import net.minecraft.class_408;
import net.minecraft.class_4184;
import org.lwjgl.glfw.GLFW;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@ModuleRegister(
   primaryVal = "GeyserHelper",
   tertiaryVal = ModuleCategory.Player,
   secondaryVal = "Highlights loot obtainable from the 'Geyser' event on FunTime"
)
public class GeyserHelperModule extends Module {
   private final Map<class_1542, Long> activeVal = new ConcurrentHashMap<>();
   private final List<GeyserHelperModule.cursorVal> radiusVal = new ArrayList<>();
   private final Map<Integer, Long> factorVal = new ConcurrentHashMap<>();
   public final BoolSetting countVal = new BoolSetting(
      "Sync with NameTags", true
   );
   public final ModeSetting depthVal = new ModeSetting(
         "Style",
         "Dark",
         "Dark",
         "Light",
         "Blur"
      )
      .primaryVal(this.countVal::tertiaryVal);
   public final FloatSetting descRef = new FloatSetting("Transparency", 1.0F, 0.1F, 1.0F, 0.05F, true)
      .primaryVal(this.countVal::tertiaryVal);
   private final SettingHolder sourceVal = new SettingHolder() {};
   private boolean extraRef = false;
   private float phaseVal = 0.0F;
   private float limitRef = 0.0F;
   private float paramRef = 0.0F;
   private float groupVal = 0.0F;
   private float layerVal = 0.0F;
   private boolean slotVal = false;
   private long themeVal = 0L;
   private final List<GeyserHelperModule.WildClient> stageVal = new ArrayList<>();
   private int widthRef;
   private int trackVal;
   private float modeRef = 1.0F;
   private String angleVal = "Dark";

   public GeyserHelperModule() {
      this.addSettings(this.countVal, this.depthVal, this.descRef);
      this.sourceVal.primaryVal(this.countVal);
      this.sourceVal.primaryVal(this.depthVal);
      this.sourceVal.primaryVal(this.descRef);
   }

   @Override
   public void onEnable() {
      super.onEnable();
      this.factorVal.clear();
   }

   @Override
   public void onDisable() {
      super.onDisable();
      this.activeVal.clear();
      this.radiusVal.clear();
      this.factorVal.clear();
      this.extraRef = false;
      this.layerVal = 0.0F;
   }

   @Subscribe
   public void primaryVal(PacketEvent var1) {
      if (mc.field_1687 != null) {
         if (var1.marginVal() instanceof class_2767 var2) {
            String var4 = ((class_3414)var2.method_11894().comp_349()).toString();
            if (this.primaryVal(var4)) {
               this.primaryVal(var2.method_11890(), var2.method_11889(), var2.method_11893());
            }
         }
      }
   }

   @Subscribe
   public void primaryVal(TickEvent var1) {
      if (mc.field_1687 != null) {
         this.activeVal.keySet().removeIf(var0 -> !var0.method_5805() || var0.method_6983().method_7960());
      }
   }

   @Subscribe
   public void primaryVal(RenderHudEvent var1) {
      if (mc.field_1687 != null && mc.field_1724 != null) {
         this.stageVal.clear();
         this.blockRef();
         float var2 = mc.method_61966().method_60637(true);
         Renderer2D var3 = var1.marginVal();
         class_4184 var4 = mc.field_1773.method_19418();
         class_243 var5 = var4.method_19326();
         float var6 = (float)mc.field_1729.method_1603();
         float var7 = (float)mc.field_1729.method_1604();
         boolean var8 = mc.field_1755 instanceof class_408;
         this.radiusVal.clear();
         NameTagsModule var9 = this.holderVal();
         boolean var10 = var9 != null && var9.enabled && var9.depthVal.secondaryVal("Items");
         HashSet var11 = new HashSet();
         if (!this.activeVal.isEmpty()) {
            for (Entry var13 : this.activeVal.entrySet()) {
               class_1542 var14 = (class_1542)var13.getKey();
               class_243 var15 = var14.method_30950(var2);
               double var16 = var10 ? 0.52 : 0.7;
               class_243 var18 = new class_243(var15.field_1352, var15.field_1351 + var16, var15.field_1350);
               if (!(var18.method_1025(var5) < 1.0E-6)) {
                  class_243 var19 = VnNnNnvuvn.primaryVal(var18);
                  if (!(var19.field_1350 <= 0.001F) && !(var19.field_1350 > 1.0)) {
                     double var20 = var5.method_1022(var18);
                     var11.add(var14.method_5628());
                     this.factorVal.putIfAbsent(var14.method_5628(), System.currentTimeMillis());
                     float var22 = class_3532.method_15363((float)(System.currentTimeMillis() - this.factorVal.get(var14.method_5628())) / 300.0F, 0.0F, 1.0F);
                     float var23 = 1.0F - (float)Math.pow(1.0F - var22, 4.0);
                     this.primaryVal(var3, var14, (Long)var13.getValue(), (float)var19.field_1352, (float)var19.field_1351, (float)var20, var10, var23);
                  }
               }
            }
         }

         this.factorVal.keySet().retainAll(var11);
         this.primaryVal(var3);
         if (var8) {
            boolean var24 = GLFW.glfwGetMouseButton(mc.method_22683().method_4490(), 0) == 1;
            boolean var25 = var24 && !this.slotVal;
            this.slotVal = var24;
            if (var25 && System.currentTimeMillis() - this.themeVal > 150L) {
               this.themeVal = System.currentTimeMillis();
               boolean var26 = false;

               for (GeyserHelperModule.WildClient var30 : this.stageVal) {
                  if (this.primaryVal(var6, var7, var30.x, var30.y, var30.w, var30.h)) {
                     var26 = true;
                     this.extraRef = !this.extraRef;
                     if (this.extraRef) {
                        this.phaseVal = var30.x;
                        this.limitRef = var30.y;
                        this.paramRef = var30.w;
                        this.groupVal = var30.h;
                     }
                     break;
                  }
               }

               if (!var26 && this.extraRef) {
                  boolean var29 = this.primaryVal(var6, var7, this.phaseVal - 250.0F, this.limitRef - 150.0F, 600.0F, 500.0F);
                  if (!var29) {
                     this.extraRef = false;
                  }
               }
            }

            float var27 = this.extraRef ? 1.0F : 0.0F;
            this.layerVal = this.layerVal + (var27 - this.layerVal) * 0.15F;
            if (this.layerVal > 0.01F) {
               UuUuVnVvnvn.primaryVal(
                  var3,
                  this.sourceVal,
                  this.phaseVal,
                  this.limitRef,
                  this.paramRef,
                  this.groupVal,
                  mc.method_22683().method_4486(),
                  mc.method_22683().method_4502(),
                  this.layerVal,
                  var6,
                  var7,
                  var25,
                  var24
               );
            }
         } else {
            this.extraRef = false;
            this.layerVal = 0.0F;
            this.slotVal = false;
         }
      }
   }

   private void primaryVal(Renderer2D var1, class_1542 var2, long var3, float var5, float var6, float var7, boolean var8, float var9) {
      float var10 = (float)class_3532.method_15350(16.0 / Math.max(var7, 12.0), 0.75, 1.15);
      float var11 = 6.0F * var10;
      class_1799 var12 = var2.method_6983();
      float var13 = 24.0F * var10;
      long var14 = System.currentTimeMillis() - var3;
      String var16 = String.format("%.0f sec", (float)var14 / 1000.0F);
      float var17 = 6.0F * var10;
      float var18 = 20.0F * var10;
      float var19 = Renderer2D.primaryVal(FontRegistry.primaryVal, var16, var13).primaryVal + var17 * 2.0F;
      if (var8) {
         float var20 = 12.0F * var10;
         float var21 = var20 * var9;
         float var22 = var6 + var21;
         float var23 = var5 - var19 / 2.0F;
         this.primaryVal(var1, var23, var22, var19, var18, var11, var9);
         var1.primaryVal(FontRegistry.primaryVal, var23 + var17, var22 + 14.0F * var10, var13, var16, this.primaryVal(this.trackVal, var9));
         this.stageVal.add(new GeyserHelperModule.WildClient(var23, var22, var19, var18));
      } else {
         float var28 = 8.0F * var10 * (1.0F - var9);
         float var29 = var6 + var28;
         float var30 = 22.0F * var10;
         float var31 = 4.0F * var10;
         float var24 = var30 + var31 + var19;
         float var25 = var5 - var24 / 2.0F;
         this.primaryVal(var1, var25, var29, var30, var30, var11, var9);
         float var26 = var29 + (var30 - var18) / 2.0F;
         this.primaryVal(var1, var25 + var30 + var31, var26, var19, var18, var11, var9);
         var1.primaryVal(FontRegistry.primaryVal, var25 + var30 + var31 + var17, var26 + 14.0F * var10, var13, var16, this.primaryVal(this.trackVal, var9));
         float var27 = (var30 - 16.0F * var10) / 2.0F;
         this.radiusVal.add(new GeyserHelperModule.cursorVal(var12, var25 + var27, var29 + var27, var25, var29, var30, var2.method_5628(), var10));
         this.stageVal.add(new GeyserHelperModule.WildClient(var25, var29, var24, var30));
      }
   }

   private void blockRef() {
      NameTagsModule var1 = this.holderVal();
      boolean var2 = this.countVal.tertiaryVal() && var1 != null;
      String var3 = var2 ? var1.themeVal.tertiaryVal() : this.depthVal.tertiaryVal();
      float var4 = var2 ? var1.depthRef.tertiaryVal() : this.descRef.tertiaryVal();
      if (var3.equals("Light")) {
         this.widthRef = Renderer2D.VvunVVUvUNnv.tertiaryVal(240, 240, 245, (int)(255.0F * var4));
         this.trackVal = Renderer2D.VvunVVUvUNnv.tertiaryVal(30, 30, 30, 255);
      } else if (var3.equals("Blur")) {
         this.widthRef = Renderer2D.VvunVVUvUNnv.tertiaryVal(10, 10, 10, (int)(120.0F * var4));
         this.trackVal = Renderer2D.VvunVVUvUNnv.tertiaryVal(250, 250, 250, 255);
      } else {
         this.widthRef = Renderer2D.VvunVVUvUNnv.tertiaryVal(25, 25, 26, (int)(255.0F * var4));
         this.trackVal = Renderer2D.VvunVVUvUNnv.tertiaryVal(240, 240, 240, 255);
      }

      this.modeRef = var4;
      this.angleVal = var3;
   }

   private NameTagsModule holderVal() {
      try {
         return (NameTagsModule)ru.metaculture.protection.WildClient.primaryVal.secondaryVal.secondaryVal(NameTagsModule.class);
      } catch (Exception var2) {
         return null;
      }
   }

   private void primaryVal(Renderer2D var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = this.modeRef * var7;
      if (!(var8 <= 0.05F)) {
         if (this.angleVal.equals("Blur")) {
            var1.primaryVal(23.0F);
            var1.primaryVal(var2, var3, var4, var5, var6, var8);
         }

         int var9 = this.primaryVal(this.widthRef, var7);
         var1.primaryVal(var2, var3, var4, var5, var6, var9);
      }
   }

   private int primaryVal(int var1, float var2) {
      int var3 = var1 >> 24 & 0xFF;
      int var4 = var1 >> 16 & 0xFF;
      int var5 = var1 >> 8 & 0xFF;
      int var6 = var1 & 0xFF;
      return Renderer2D.VvunVVUvUNnv.tertiaryVal(var4, var5, var6, (int)(var3 * var2));
   }

   private boolean primaryVal(String var1) {
      String var2 = var1.toLowerCase();
      return var2.contains("extinguish") || var2.contains("fizz") || var2.contains("burn") || var2.contains("lava");
   }

   private void primaryVal(double var1, double var3, double var5) {
      mc.execute(() -> {
         if (mc.field_1687 != null) {
            for (class_1297 var8 : mc.field_1687.method_18112()) {
               if (var8 instanceof class_1542 var9 && var9.method_5649(var1, var3, var5) <= 9.0) {
                  this.activeVal.putIfAbsent(var9, System.currentTimeMillis());
               }
            }
         }
      });
   }

   private boolean primaryVal(float var1, float var2, float var3, float var4, float var5, float var6) {
      return var1 >= var3 && var1 <= var3 + var5 && var2 >= var4 && var2 <= var4 + var6;
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void primaryVal(Renderer2D var1) {
      if (var1 != null && !this.radiusVal.isEmpty()) {
         for (GeyserHelperModule.cursorVal var3 : this.radiusVal) {
            float var4 = NuNvVUuUUnun.primaryVal(var3.clipX());
            float var5 = NuNvVUuUUnun.primaryVal(var3.clipY());
            float var6 = Math.max(1.0F, NuNvVUuUUnun.primaryVal(var3.clipSize()));
            var1.tertiaryVal();
            var1.primaryVal(var4, var5, var6, var6, var6 * 0.27F, var6 * 0.27F, var6 * 0.27F, var6 * 0.27F);
            boolean var9 = false /* VF: Semaphore variable */;

            try {
               var9 = true;
               NuNvVUuUUnun.primaryVal(
                  var1,
                  var3.stack(),
                  NuNvVUuUUnun.primaryVal(var3.x()),
                  NuNvVUuUUnun.primaryVal(var3.y()),
                  NuNvVUuUUnun.tertiaryVal(var3.scale()),
                  var3.seed(),
                  true,
                  var3.seed()
               );
               var9 = false;
            } finally {
               if (var9) {
                  var1.tertiaryVal();
                  var1.paramVal();
               }
            }

            var1.tertiaryVal();
            var1.paramVal();
         }

         this.radiusVal.clear();
      }
   }

   record WildClient(float x, float y, float w, float h) {
   }

   record cursorVal(class_1799 stack, float x, float y, float clipX, float clipY, float clipSize, int seed, float scale) {
   }
}
