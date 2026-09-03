package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import net.minecraft.class_1268;
import net.minecraft.class_1269;
import net.minecraft.class_1297;
import net.minecraft.class_304;
import net.minecraft.class_3532;
import net.minecraft.class_3675;
import net.minecraft.class_3965;
import net.minecraft.class_3966;
import org.wild.mixin.acceser.ClientPlayerInteractionManagerAccessor;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;

@RequiresRole(tertiaryVal = {"lichoday", "bitrixtime", "oblamovvv"})
@ModuleRegister(
   primaryVal = "ActionRecorder",
   secondaryVal = "Records and replays player actions",
   tertiaryVal = ModuleCategory.Player,
   marginVal = ModuleBadge.NEW
)
public class ActionRecorderModule extends Module {
   private static final String countVal = "KEY";
   private static final String depthVal = "MOUSE";
   private static final String descRef = "SCROLL";
   private final StringFilterSetting activeVal = new StringFilterSetting("File", "default").primaryVal(48);
   private final KeybindSetting radiusVal = new KeybindSetting("Record Key", -1);
   private final KeybindSetting factorVal = new KeybindSetting("Play Key", -1);
   private final KeybindSetting sourceVal = new KeybindSetting("Stop Key", -1);
   private final BoolSetting extraRef = new BoolSetting("Infinite Loop", false);
   private final FloatSetting phaseVal = new FloatSetting("Loops", 1.0F, 1.0F, 20.0F, 1.0F, false).primaryVal(this.extraRef::tertiaryVal);
   private final FloatSetting limitRef = new FloatSetting("Play Duration Sec", 0.0F, 0.0F, 600.0F, 1.0F, false);
   private final FloatSetting paramRef = new FloatSetting("Record Limit Sec", 0.0F, 0.0F, 600.0F, 1.0F, false);
   private final BoolSetting groupVal = new BoolSetting("Auto Save", true);
   private final BoolSetting layerVal = new BoolSetting("Rotation Controller", true);
   private final FloatSetting slotVal = new FloatSetting("Min Rotation Speed", 1.0F, 0.2F, 180.0F, 0.1F, false).primaryVal(() -> !this.layerVal.tertiaryVal());
   private final Gson themeVal = new GsonBuilder().setPrettyPrinting().create();
   private final NnuUuVVVvUu stageVal = new NnuUuVVVvUu();
   private ActionRecorderModule.VvunVVUvUNnv widthRef;
   private ActionRecorderModule.VvunVVUvUNnv trackVal;
   private boolean modeRef;
   private boolean angleVal;
   private int heightRef;
   private int levelVal;
   private int UuNnnVnuNNV;
   private int depthRef = -1;
   private float speedRef;
   private float countRef;
   private float entryVal;
   private float guardVal;
   private boolean VUuuVUnun;
   private boolean vVVuuVVv;
   private boolean VuunNUUUvu;
   private double NNUUNUuVNNVn;
   private double VvVvnNUnvuvV;
   private boolean tokenVal;
   private boolean NUVvUUVuVNVv;
   private boolean nodeB;

   public ActionRecorderModule() {
      this.addSettings(
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
         this.slotVal
      );
   }

   @Override
   public void onDisable() {
      if (this.modeRef) {
         this.tertiaryVal(this.groupVal.tertiaryVal());
      }

      if (this.angleVal) {
         this.marginVal(false);
      }

      super.onDisable();
   }

   @Subscribe
   public void primaryVal(MouseButtonEvent var1) {
      if (var1.paramVal() == 1 && this.radiusVal.tertiaryVal() != -1 && var1.marginVal() == this.radiusVal.tertiaryVal()) {
         this.blockRef();
         var1.secondaryVal();
      } else if (var1.paramVal() == 1 && this.factorVal.tertiaryVal() != -1 && var1.marginVal() == this.factorVal.tertiaryVal()) {
         this.holderVal();
         var1.secondaryVal();
      } else if (var1.paramVal() == 1 && this.sourceVal.tertiaryVal() != -1 && var1.marginVal() == this.sourceVal.tertiaryVal()) {
         this.weightRef();
         var1.secondaryVal();
      } else {
         if (this.modeRef && var1.marginVal() >= 0 && !this.marginVal(var1.marginVal())) {
            this.primaryVal(
               ActionRecorderModule.WildClient.primaryVal(
                  this.heightRef, this.widthRef.paramVal.size(), var1.marginVal(), var1.weightVal(), var1.paramVal(), var1.extraVal()
               )
            );
         }
      }
   }

   @Subscribe
   public void primaryVal(MouseClickEvent var1) {
      if (!var1.speedVal() && this.modeRef) {
         if (!this.marginVal(-100 - var1.marginVal())) {
            this.primaryVal(
               ActionRecorderModule.WildClient.primaryVal(this.heightRef, this.widthRef.paramVal.size(), var1.marginVal(), var1.weightVal(), var1.paramVal())
            );
         }
      }
   }

   @Subscribe
   public void primaryVal(MouseScrollEvent var1) {
      if (!var1.limitVal() && this.modeRef) {
         if ((!(var1.weightVal() > 0.0) || !this.marginVal(-200)) && (!(var1.weightVal() < 0.0) || !this.marginVal(-201))) {
            this.primaryVal(ActionRecorderModule.WildClient.primaryVal(this.heightRef, this.widthRef.paramVal.size(), var1.marginVal(), var1.weightVal()));
         }
      }
   }

   @Subscribe(priority = 4)
   public void primaryVal(MovementInputEvent var1) {
      if (this.angleVal) {
         ActionRecorderModule.cursorVal var2 = this.secondaryVal(this.levelVal);
         if (var2 != null) {
            var1.primaryVal(var2.limitVal);
            var1.secondaryVal(var2.speedVal);
            var1.primaryVal(var2.widthVal);
            var1.secondaryVal(var2.chunkVal);
            var1.tertiaryVal(var2.blockRef);
         }
      } else {
         if (this.modeRef) {
            this.entryVal = var1.tertiaryVal();
            this.guardVal = var1.marginVal();
            this.VUuuVUnun = var1.weightVal();
            this.vVVuuVVv = var1.paramVal();
            this.VuunNUUUvu = var1.extraVal();
         }
      }
   }

   @Subscribe(priority = 4)
   public void primaryVal(MouseMoveEvent var1) {
      if (this.angleVal) {
         var1.secondaryVal();
      } else {
         if (this.modeRef) {
            this.NNUUNUuVNNVn = this.NNUUNUuVNNVn + var1.tertiaryVal();
            this.VvVvnNUnvuvV = this.VvVvnNUnvuvV + var1.marginVal();
         }
      }
   }

   @Subscribe(priority = 4)
   public void primaryVal(PlayerMovementEvent var1) {
      if (this.angleVal) {
         ActionRecorderModule.cursorVal var2 = this.secondaryVal(this.levelVal);
         if (var2 != null) {
            this.primaryVal(var2);
            this.primaryVal(var2, var1);
            this.primaryVal(this.levelVal);
         }
      }
   }

   @Subscribe
   public void primaryVal(PostClientTickEvent var1) {
      if (this.modeRef) {
         this.bufferVal();
         this.heightRef++;
         if (this.paramRef.tertiaryVal() > 0.0F && this.heightRef >= Math.round(this.paramRef.tertiaryVal() * 20.0F)) {
            this.tertiaryVal(this.groupVal.tertiaryVal());
         }
      }

      if (this.angleVal) {
         if (this.depthRef != this.levelVal) {
            ActionRecorderModule.cursorVal var2 = this.secondaryVal(this.levelVal);
            if (var2 != null) {
               this.primaryVal(var2);
            }

            this.primaryVal(this.levelVal);
         }

         this.descRef();
      }
   }

   @Subscribe
   public void primaryVal(PostWorldJoinEvent var1) {
      this.weightRef();
   }

   @Subscribe
   public void primaryVal(WorldJoinEvent var1) {
      this.weightRef();
   }

   private void blockRef() {
      if (this.modeRef) {
         this.tertiaryVal(this.groupVal.tertiaryVal());
      } else {
         this.timerVal();
      }
   }

   private void holderVal() {
      if (this.angleVal) {
         this.marginVal(true);
      } else {
         if (this.modeRef) {
            this.tertiaryVal(this.groupVal.tertiaryVal());
         }

         this.anchorVal();
      }
   }

   private void timerVal() {
      if (!this.paramRef()) {
         ChatLogger.primaryVal("[ActionRecorder] Player is not ready.");
      } else {
         if (this.angleVal) {
            this.marginVal(false);
         }

         this.widthRef = new ActionRecorderModule.VvunVVUvUNnv();
         this.widthRef.secondaryVal = System.currentTimeMillis();
         this.widthRef.tertiaryVal = this.phaseVal();
         this.modeRef = true;
         this.heightRef = 0;
         this.speedRef = mc.field_1724.method_36454();
         this.countRef = mc.field_1724.method_36455();
         this.entryVal = 0.0F;
         this.guardVal = 0.0F;
         this.VUuuVUnun = false;
         this.vVVuuVVv = false;
         this.VuunNUUUvu = false;
         this.NNUUNUuVNNVn = 0.0;
         this.VvVvnNUnvuvV = 0.0;
         ChatLogger.primaryVal("[ActionRecorder] Recording: " + this.widthRef.tertiaryVal);
      }
   }

   private void tertiaryVal(boolean var1) {
      if (this.modeRef) {
         this.modeRef = false;
         if (var1 && this.widthRef != null) {
            this.primaryVal(this.widthRef);
         }

         int var2 = this.widthRef != null && this.widthRef.weightVal != null ? this.widthRef.weightVal.size() : 0;
         ChatLogger.primaryVal("[ActionRecorder] Recording stopped. Ticks: " + var2);
      }
   }

   private void anchorVal() {
      if (!this.paramRef()) {
         ChatLogger.primaryVal("[ActionRecorder] Player is not ready.");
      } else {
         ActionRecorderModule.VvunVVUvUNnv var1 = this.radiusVal();
         if (var1 != null && var1.weightVal != null && !var1.weightVal.isEmpty()) {
            this.secondaryVal(var1);
            this.trackVal = var1;
            this.angleVal = true;
            this.levelVal = 0;
            this.UuNnnVnuNNV = 0;
            this.depthRef = -1;
            this.tokenVal = false;
            this.NUVvUUVuVNVv = false;
            this.nodeB = false;
            ChatLogger.primaryVal("[ActionRecorder] Playback: " + this.trackVal.tertiaryVal);
         } else {
            ChatLogger.primaryVal("[ActionRecorder] Recording is empty or missing.");
         }
      }
   }

   private void marginVal(boolean var1) {
      if (this.angleVal) {
         this.angleVal = false;
         this.trackVal = null;
         this.levelVal = 0;
         this.UuNnnVnuNNV = 0;
         this.depthRef = -1;
         this.tokenVal = false;
         this.NUVvUUVuVNVv = false;
         this.nodeB = false;
         this.stageVal.primaryVal();
         this.limitRef();
         if (var1) {
            ChatLogger.primaryVal("[ActionRecorder] Playback stopped.");
         }
      }
   }

   private void weightRef() {
      if (this.modeRef) {
         this.tertiaryVal(this.groupVal.tertiaryVal());
      }

      if (this.angleVal) {
         this.marginVal(false);
      }
   }

   private void bufferVal() {
      if (this.paramRef() && this.widthRef != null) {
         ActionRecorderModule.cursorVal var1 = new ActionRecorderModule.cursorVal();
         var1.primaryVal = this.heightRef;
         var1.secondaryVal = mc.field_1724.method_36454();
         var1.tertiaryVal = mc.field_1724.method_36455();
         var1.marginVal = Math.abs(class_3532.method_15393(var1.secondaryVal - this.speedRef));
         var1.weightVal = Math.abs(var1.tertiaryVal - this.countRef);
         var1.paramVal = this.NNUUNUuVNNVn;
         var1.extraVal = this.VvVvnNUnvuvV;
         var1.limitVal = this.entryVal;
         var1.speedVal = this.guardVal;
         var1.widthVal = this.VUuuVUnun;
         var1.chunkVal = this.vVVuuVVv;
         var1.blockRef = this.VuunNUUUvu;
         var1.holderVal = mc.field_1724.method_31548().method_67532();
         var1.timerVal = mc.field_1724.method_18798().field_1352;
         var1.anchorVal = mc.field_1724.method_18798().field_1351;
         var1.weightRef = mc.field_1724.method_18798().field_1350;
         var1.bufferVal = Math.hypot(var1.timerVal, var1.weightRef);
         this.widthRef.weightVal.add(var1);
         this.speedRef = var1.secondaryVal;
         this.countRef = var1.tertiaryVal;
         this.NNUUNUuVNNVn = 0.0;
         this.VvVvnNUnvuvV = 0.0;
      }
   }

   private void primaryVal(ActionRecorderModule.WildClient var1) {
      if (this.widthRef != null && this.widthRef.paramVal != null) {
         this.widthRef.paramVal.add(var1);
      }
   }

   private void primaryVal(ActionRecorderModule.cursorVal var1) {
      if (!this.paramRef()) {
         this.marginVal(false);
      } else {
         this.tertiaryVal(var1.holderVal);
         mc.field_1690.field_1894.method_23481(var1.limitVal > 0.0F);
         mc.field_1690.field_1881.method_23481(var1.limitVal < 0.0F);
         mc.field_1690.field_1913.method_23481(var1.speedVal > 0.0F);
         mc.field_1690.field_1849.method_23481(var1.speedVal < 0.0F);
         mc.field_1690.field_1903.method_23481(var1.widthVal);
         mc.field_1690.field_1832.method_23481(var1.chunkVal);
         mc.field_1690.field_1867.method_23481(var1.blockRef);
         mc.field_1690.field_1886.method_23481(this.tokenVal);
         mc.field_1690.field_1904.method_23481(this.NUVvUUVuVNVv);
         mc.field_1690.field_1871.method_23481(this.nodeB);
         mc.field_1724.method_5728(var1.blockRef);
      }
   }

   private void primaryVal(ActionRecorderModule.cursorVal var1, PlayerMovementEvent var2) {
      if (mc.field_1724 != null) {
         if (this.layerVal.tertiaryVal()) {
            float var3 = Math.abs(class_3532.method_15393(var1.secondaryVal - mc.field_1724.method_36454()));
            float var4 = Math.abs(var1.tertiaryVal - mc.field_1724.method_36455());
            float var5 = Math.max(this.slotVal.tertiaryVal(), Math.max(var1.marginVal, var3));
            float var6 = Math.max(this.slotVal.tertiaryVal(), Math.max(var1.weightVal, var4));
            this.stageVal.primaryVal(new Rotation(var1.secondaryVal, var1.tertiaryVal), var5, var6, 1, 30);
            var2.primaryVal(mc.field_1724.method_36454());
            var2.secondaryVal(mc.field_1724.method_36455());
         } else {
            mc.field_1724.method_36456(var1.secondaryVal);
            mc.field_1724.method_36457(var1.tertiaryVal);
            var2.primaryVal(var1.secondaryVal);
            var2.secondaryVal(var1.tertiaryVal);
         }
      }
   }

   private void primaryVal(int var1) {
      if (this.trackVal != null && this.trackVal.paramVal != null && this.depthRef != var1) {
         this.depthRef = var1;

         for (ActionRecorderModule.WildClient var3 : this.trackVal.paramVal) {
            if (var3.primaryVal == var1) {
               this.secondaryVal(var3);
            }
         }
      }
   }

   private void secondaryVal(ActionRecorderModule.WildClient var1) {
      if ("KEY".equals(var1.tertiaryVal)) {
         this.tertiaryVal(var1);
      } else if ("MOUSE".equals(var1.tertiaryVal)) {
         this.marginVal(var1);
      }
   }

   private void tertiaryVal(ActionRecorderModule.WildClient var1) {
      boolean var2 = var1.paramVal != 0;
      if (this.primaryVal(mc.field_1690.field_1886, var1.marginVal, var1.weightVal)) {
         this.tokenVal = var2;
         mc.field_1690.field_1886.method_23481(var2);
         if (var2) {
            this.countVal();
         }
      } else if (this.primaryVal(mc.field_1690.field_1904, var1.marginVal, var1.weightVal)) {
         this.NUVvUUVuVNVv = var2;
         mc.field_1690.field_1904.method_23481(var2);
         if (var2) {
            this.depthVal();
         }
      } else if (this.primaryVal(mc.field_1690.field_1871, var1.marginVal, var1.weightVal)) {
         this.nodeB = var2;
         mc.field_1690.field_1871.method_23481(var2);
      } else {
         if (var2 && mc.field_1690.field_1852 != null) {
            for (int var3 = 0; var3 < mc.field_1690.field_1852.length; var3++) {
               if (this.primaryVal(mc.field_1690.field_1852[var3], var1.marginVal, var1.weightVal)) {
                  this.tertiaryVal(var3);
                  return;
               }
            }
         }
      }
   }

   private void marginVal(ActionRecorderModule.WildClient var1) {
      boolean var2 = var1.paramVal != 0;
      if (var1.marginVal == 0) {
         this.tokenVal = var2;
         mc.field_1690.field_1886.method_23481(var2);
         if (var2) {
            this.countVal();
         }
      } else if (var1.marginVal == 1) {
         this.NUVvUUVuVNVv = var2;
         mc.field_1690.field_1904.method_23481(var2);
         if (var2) {
            this.depthVal();
         }
      } else {
         if (var1.marginVal == 2) {
            this.nodeB = var2;
            mc.field_1690.field_1871.method_23481(var2);
         }
      }
   }

   private void countVal() {
      if (this.paramRef() && mc.field_1755 == null) {
         if (mc.field_1765 instanceof class_3966 var1) {
            class_1297 var4 = var1.method_17782();
            if (var4 != null) {
               mc.field_1761.method_2918(mc.field_1724, var4);
               mc.field_1724.method_6104(class_1268.field_5808);
               return;
            }
         }

         if (mc.field_1765 instanceof class_3965 var3 && mc.field_1761.method_2910(var3.method_17777(), var3.method_17780())) {
            mc.field_1724.method_6104(class_1268.field_5808);
         }
      }
   }

   private void depthVal() {
      if (this.paramRef() && mc.field_1755 == null) {
         if (mc.field_1765 instanceof class_3965 var1) {
            class_1269 var4 = mc.field_1761.method_2896(mc.field_1724, class_1268.field_5808, var1);
            if (var4 != class_1269.field_5811 && var4 != class_1269.field_5814) {
               mc.field_1724.method_6104(class_1268.field_5808);
               return;
            }
         }

         class_1269 var3 = mc.field_1761.method_2919(mc.field_1724, class_1268.field_5808);
         if (var3 != class_1269.field_5811 && var3 != class_1269.field_5814) {
            mc.field_1724.method_6104(class_1268.field_5808);
         }
      }
   }

   private void descRef() {
      int var1 = this.activeVal();
      if (var1 <= 0) {
         this.marginVal(false);
      } else if (this.levelVal + 1 < var1) {
         this.levelVal++;
      } else {
         this.UuNnnVnuNNV++;
         if (!this.extraRef.tertiaryVal() && this.UuNnnVnuNNV >= Math.max(1, Math.round(this.phaseVal.tertiaryVal()))) {
            this.marginVal(true);
         } else {
            this.levelVal = 0;
            this.depthRef = -1;
            this.tokenVal = false;
            this.NUVvUUVuVNVv = false;
            this.nodeB = false;
         }
      }
   }

   private int activeVal() {
      if (this.trackVal != null && this.trackVal.weightVal != null) {
         int var1 = this.trackVal.weightVal.size();
         if (this.limitRef.tertiaryVal() > 0.0F) {
            var1 = Math.min(var1, Math.max(1, Math.round(this.limitRef.tertiaryVal() * 20.0F)));
         }

         return var1;
      } else {
         return 0;
      }
   }

   private ActionRecorderModule.cursorVal secondaryVal(int var1) {
      if (this.trackVal != null && this.trackVal.weightVal != null && !this.trackVal.weightVal.isEmpty()) {
         int var2 = Math.max(0, Math.min(var1, this.trackVal.weightVal.size() - 1));
         ActionRecorderModule.cursorVal var3 = this.trackVal.weightVal.get(var2);
         if (var3.primaryVal == var1) {
            return var3;
         }

         for (ActionRecorderModule.cursorVal var5 : this.trackVal.weightVal) {
            if (var5.primaryVal == var1) {
               return var5;
            }
         }

         return var3;
      } else {
         return null;
      }
   }

   private void primaryVal(ActionRecorderModule.VvunVVUvUNnv var1) {
      try {
         this.secondaryVal(var1);
         Path var2 = this.factorVal();
         Files.createDirectories(var2.getParent());

         try (BufferedWriter var3 = Files.newBufferedWriter(var2, StandardCharsets.UTF_8)) {
            this.themeVal.toJson(var1, var3);
         }

         ChatLogger.primaryVal("[ActionRecorder] Saved: " + var2.getFileName());
      } catch (Throwable var8) {
         ChatLogger.primaryVal("[ActionRecorder] Save failed: " + var8.getMessage());
      }
   }

   private ActionRecorderModule.VvunVVUvUNnv radiusVal() {
      try {
         Path var1 = this.factorVal();
         if (!Files.isRegularFile(var1)) {
            return null;
         }

         try (BufferedReader var2 = Files.newBufferedReader(var1, StandardCharsets.UTF_8)) {
            return (ActionRecorderModule.VvunVVUvUNnv)this.themeVal.fromJson(var2, ActionRecorderModule.VvunVVUvUNnv.class);
         }
      } catch (Throwable var7) {
         ChatLogger.primaryVal("[ActionRecorder] Load failed: " + var7.getMessage());
         return null;
      }
   }

   private void secondaryVal(ActionRecorderModule.VvunVVUvUNnv var1) {
      if (var1.weightVal == null) {
         var1.weightVal = new ArrayList<>();
      }

      if (var1.paramVal == null) {
         var1.paramVal = new ArrayList<>();
      }

      var1.primaryVal = 1;
      var1.tertiaryVal = this.phaseVal();
      var1.marginVal = var1.weightVal.size();
      var1.weightVal.sort(Comparator.comparingInt(var0 -> var0.primaryVal));
      var1.paramVal.sort(Comparator.<ActionRecorderModule.WildClient>comparingInt(var0 -> var0.primaryVal).thenComparingInt(var0 -> var0.secondaryVal));
   }

   private Path factorVal() {
      return this.sourceVal().resolve(this.extraRef());
   }

   private Path sourceVal() {
      return ru.metaculture.protection.WildClient.primaryVal != null && ru.metaculture.protection.WildClient.primaryVal.paramVal != null
         ? ru.metaculture.protection.WildClient.primaryVal.paramVal.toPath().resolve("action_records")
         : mc.field_1697.toPath().resolve("Wild").resolve("action_records");
   }

   private String extraRef() {
      String var1 = this.phaseVal();
      return var1.endsWith(".json") ? var1 : var1 + ".json";
   }

   private String phaseVal() {
      String var1 = this.activeVal.tertiaryVal();
      if (var1 == null || var1.isBlank()) {
         var1 = "default";
      }

      var1 = var1.trim().replace('\\', '/');
      int var2 = var1.lastIndexOf(47);
      if (var2 >= 0) {
         var1 = var1.substring(var2 + 1);
      }

      String var3 = var1.replaceAll("[^a-zA-Z0-9._-]", "_");
      if (var3.isBlank() || var3.equals(".") || var3.equals("..")) {
         var3 = "default";
      }

      if (var3.endsWith(".json")) {
         var3 = var3.substring(0, var3.length() - 5);
      }

      return var3;
   }

   private void tertiaryVal(int var1) {
      if (mc.field_1724 != null && var1 >= 0 && var1 <= 8) {
         if (mc.field_1724.method_31548().method_67532() != var1) {
            mc.field_1724.method_31548().method_61496(var1);
            if (mc.field_1761 instanceof ClientPlayerInteractionManagerAccessor var2) {
               var2.invokeSyncSelectedSlot();
            }
         }
      }
   }

   private boolean primaryVal(class_304 var1, int var2, int var3) {
      return var1 != null && var1.method_1417(var2, var3);
   }

   private boolean marginVal(int var1) {
      return var1 != -1 && (var1 == this.radiusVal.tertiaryVal() || var1 == this.factorVal.tertiaryVal() || var1 == this.sourceVal.tertiaryVal());
   }

   private void limitRef() {
      if (mc.field_1690 != null) {
         this.primaryVal(mc.field_1690.field_1894);
         this.primaryVal(mc.field_1690.field_1881);
         this.primaryVal(mc.field_1690.field_1913);
         this.primaryVal(mc.field_1690.field_1849);
         this.primaryVal(mc.field_1690.field_1903);
         this.primaryVal(mc.field_1690.field_1832);
         this.primaryVal(mc.field_1690.field_1867);
         mc.field_1690.field_1886.method_23481(false);
         mc.field_1690.field_1904.method_23481(false);
         mc.field_1690.field_1871.method_23481(false);
         if (mc.field_1724 != null) {
            mc.field_1724.method_5728(false);
         }
      }
   }

   private void primaryVal(class_304 var1) {
      if (var1 != null && mc.method_22683() != null) {
         boolean var2 = class_3675.method_15987(mc.method_22683().method_4490(), var1.method_1429().method_1444());
         var1.method_23481(var2);
      }
   }

   private boolean paramRef() {
      return mc.field_1724 != null && mc.field_1687 != null && mc.field_1761 != null && mc.field_1690 != null;
   }

   static final class WildClient {
      int primaryVal;
      int secondaryVal;
      String tertiaryVal;
      int marginVal;
      int weightVal;
      int paramVal;
      int extraVal;
      double limitVal;
      double speedVal;

      private WildClient() {
      }

      static ActionRecorderModule.WildClient primaryVal(int var0, int var1, int var2, int var3, int var4, int var5) {
         ActionRecorderModule.WildClient var6 = new ActionRecorderModule.WildClient();
         var6.primaryVal = var0;
         var6.secondaryVal = var1;
         var6.tertiaryVal = "KEY";
         var6.marginVal = var2;
         var6.weightVal = var3;
         var6.paramVal = var4;
         var6.extraVal = var5;
         return var6;
      }

      static ActionRecorderModule.WildClient primaryVal(int var0, int var1, int var2, int var3, int var4) {
         ActionRecorderModule.WildClient var5 = new ActionRecorderModule.WildClient();
         var5.primaryVal = var0;
         var5.secondaryVal = var1;
         var5.tertiaryVal = "MOUSE";
         var5.marginVal = var2;
         var5.paramVal = var3;
         var5.extraVal = var4;
         return var5;
      }

      static ActionRecorderModule.WildClient primaryVal(int var0, int var1, double var2, double var4) {
         ActionRecorderModule.WildClient var6 = new ActionRecorderModule.WildClient();
         var6.primaryVal = var0;
         var6.secondaryVal = var1;
         var6.tertiaryVal = "SCROLL";
         var6.limitVal = var2;
         var6.speedVal = var4;
         return var6;
      }
   }

   static final class VvunVVUvUNnv {
      int primaryVal = 1;
      long secondaryVal;
      String tertiaryVal = "default";
      int marginVal;
      List<ActionRecorderModule.cursorVal> weightVal = new ArrayList<>();
      List<ActionRecorderModule.WildClient> paramVal = new ArrayList<>();
   }

   static final class cursorVal {
      int primaryVal;
      float secondaryVal;
      float tertiaryVal;
      float marginVal;
      float weightVal;
      double paramVal;
      double extraVal;
      float limitVal;
      float speedVal;
      boolean widthVal;
      boolean chunkVal;
      boolean blockRef;
      int holderVal;
      double timerVal;
      double anchorVal;
      double weightRef;
      double bufferVal;
   }
}
