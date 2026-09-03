package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntPredicate;
import net.minecraft.class_1304;
import net.minecraft.class_1799;
import net.minecraft.class_310;
import net.minecraft.class_437;

public final class BotManagementPanel {
   private static final long primaryVal = 4000L;
   private static final long secondaryVal = 2500L;
   private static final String[] tertiaryVal = new String[]{"Wild", "Swift", "Nova", "Frost", "Shadow", "Lunar", "Pixel", "Turbo", "Lucky", "Silent"};
   private static final String[] marginVal = new String[]{"Fox", "Wolf", "Bot", "Raven", "Panda", "Ghost", "Tiger", "Moth", "Bee", "Axolotl"};
   private final BotManagementPanel.DelayedFuse weightVal = new BotManagementPanel.DelayedFuse(16, var0 -> var0 < 128 && (Character.isLetterOrDigit(var0) || var0 == 95));
   private final BotManagementPanel.DelayedFuse paramVal = new BotManagementPanel.DelayedFuse(255, var0 -> var0 >= 32 && var0 < 127 && !Character.isWhitespace(var0));
   private final BotManagementPanel.DelayedFuse extraVal = new BotManagementPanel.DelayedFuse(256, var0 -> var0 >= 32 && !Character.isISOControl(var0));
   private String limitVal;
   private String speedVal;
   private long widthVal;
   private boolean chunkVal;
   private float blockRef;
   private String holderVal = "";
   private boolean timerVal;
   private long anchorVal;

   public void primaryVal(Renderer2D var1, ClickGuiState var2, ElementAnimState var3, ThemeContext var4) {
      GuiMetrics var5 = var4.weightVal();
      ThemePalette var6 = var4.paramVal();
      BotManagementPanel.cursorVal var7 = BotManagementPanel.cursorVal.of(var3, var5);
      List var8 = this.primaryVal(var2.OCOocoOoOO());
      HeadlessBotHostManager.WildClient var9 = this.primaryVal(var8);
      this.primaryVal(var1, var2, var5, var6, var7, var8, var9);
      this.primaryVal(var1, var2, var5, var6, var7, var9);
      this.primaryVal(var1, var5, var6, var7);
      if (this.chunkVal) {
         this.primaryVal(var1, var2, var5, var6, var7);
      }
   }

   public boolean primaryVal(ClickGuiState var1, ElementAnimState var2, ThemeContext var3, float var4, float var5, int var6) {
      BotManagementPanel.cursorVal var7 = BotManagementPanel.cursorVal.of(var2, var3.weightVal());
      if (!var7.content.contains(var4, var5)) {
         this.secondaryVal();
         return false;
      }

      var1.speedVal(false);
      if (var6 != 0 && var6 != 1) {
         return true;
      }

      if (this.chunkVal) {
         if (var6 != 0) {
            return true;
         }

         if (var7.randomNameButton.contains(var4, var5)) {
            this.weightVal.primaryVal(paramVal());
            this.weightVal.primaryVal(true);
            this.paramVal.primaryVal(false);
            return true;
         }

         boolean var14 = this.weightVal.primaryVal(var7.nameField, var4, var5);
         boolean var16 = this.paramVal.primaryVal(var7.addressField, var4, var5);
         if (!var14 && !var16) {
            this.weightVal.primaryVal(false);
            this.paramVal.primaryVal(false);
         }

         if (var7.addSubmit.contains(var4, var5)) {
            this.weightVal();
         } else if (var7.addCancel.contains(var4, var5) || !var7.modal.contains(var4, var5)) {
            this.marginVal();
         }

         return true;
      } else {
         if (var6 == 0 && var7.addButton.contains(var4, var5)) {
            this.tertiaryVal();
            return true;
         }

         if (var6 == 0 && var7.hostButton.contains(var4, var5)) {
            this.secondaryVal();
            var1.activeVal();
            var1.primaryVal((HeadlessBotSession)null);
            var1.primaryVal(var1.NUVvUUVuVNVv());
            return true;
         }

         List<HeadlessBotHostManager.WildClient> var8 = this.primaryVal(var1.OCOocoOoOO());
         if (var7.listViewport.contains(var4, var5)) {
            float var9 = var7.rowHeight;
            float var10 = var7.listViewport.y - this.blockRef;

            for (HeadlessBotHostManager.WildClient var12 : var8) {
               BotManagementPanel.VvunVVUvUNnv var13 = new BotManagementPanel.VvunVVUvUNnv(var7.listViewport.x, var10, var7.listViewport.w, var9);
               if (var13.intersects(var7.listViewport) && var13.contains(var4, var5)) {
                  this.secondaryVal(var12.name());
                  this.extraVal.primaryVal(false);
                  if (var6 == 1 && var12.bot() != null) {
                     if (HeadlessBotHostManager.primaryVal() == var12.bot()) {
                        HeadlessBotHostManager.marginVal();
                        this.primaryVal(
                           "Control returned to the main account",
                           false
                        );
                     } else if (!HeadlessBotHostManager.primaryVal(var12.bot())) {
                        this.primaryVal(
                           "Bot is not ready for control yet",
                           true
                        );
                     }
                  }

                  return true;
               }

               var10 += var9 + var7.rowGap;
            }
         }

         if (var6 != 0) {
            this.extraVal.primaryVal(false);
            return true;
         }

         HeadlessBotHostManager.WildClient var15 = this.primaryVal(var8);
         if (var15 == null) {
            this.extraVal.primaryVal(false);
            return true;
         }

         this.extraVal.primaryVal(var7.chatField.contains(var4, var5));
         if (this.extraVal.secondaryVal()) {
            return true;
         }

         HeadlessBotSession var17 = var15.bot();
         if (var7.controlButton.contains(var4, var5)) {
            if (var17 != null && var17.widthVal()) {
               if (HeadlessBotHostManager.primaryVal() == var17) {
                  HeadlessBotHostManager.marginVal();
                  this.primaryVal(
                     "Control returned to Host", false
                  );
               } else if (HeadlessBotHostManager.primaryVal(var17)) {
                  this.primaryVal(
                     "You are now controlling " + var17.primaryVal(),
                     false
                  );
               } else {
                  this.primaryVal(
                     "Failed to switch control",
                     true
                  );
               }
            } else {
               this.primaryVal(
                  "Bot is not in the game world",
                  true
               );
            }
         } else if (var7.modulesButton.contains(var4, var5)) {
            if (var17 != null && var17.widthVal()) {
               var1.activeVal();
               var1.primaryVal(var17);
               var1.primaryVal(var1.NUVvUUVuVNVv());
            } else {
               this.primaryVal(
                  "Modules become available after the bot logs in",
                  true
               );
            }
         } else if (var7.reconnectButton.contains(var4, var5)) {
            if (HeadlessBotHostManager.secondaryVal(var15.name())) {
               this.primaryVal(
                  "Reconnection started",
                  false
               );
            } else {
               this.primaryVal(
                  "Failed to start reconnection",
                  true
               );
            }
         } else if (var7.disconnectButton.contains(var4, var5)) {
            if (HeadlessBotHostManager.tertiaryVal(var15.name())) {
               this.primaryVal(
                  "Bot disconnected, profile saved",
                  false
               );
            } else {
               this.primaryVal("Bot is already disconnected", true);
            }
         } else if (var7.forgetButton.contains(var4, var5)) {
            long var18 = System.currentTimeMillis();
            if (!var15.name().equalsIgnoreCase(this.speedVal) || var18 - this.widthVal > 2500L) {
               this.speedVal = var15.name();
               this.widthVal = var18;
               this.primaryVal(
                  "Click «Delete?» again",
                  true
               );
            } else if (HeadlessBotHostManager.marginVal(var15.name())) {
               this.secondaryVal((String)null);
               this.primaryVal("Profile deleted", false);
            } else {
               this.primaryVal("First disconnect the bot", true);
            }
         } else if (var7.sendButton.contains(var4, var5)) {
            this.primaryVal(var15);
         }

         return true;
      }
   }

   public boolean primaryVal(float var1, float var2, int var3) {
      return this.chunkVal || this.weightVal.secondaryVal() || this.paramVal.secondaryVal() || this.extraVal.secondaryVal();
   }

   public boolean primaryVal(float var1, float var2, int var3, float var4, float var5) {
      return this.chunkVal;
   }

   public boolean primaryVal(ClickGuiState var1, ElementAnimState var2, ThemeContext var3, float var4, float var5, double var6) {
      BotManagementPanel.cursorVal var8 = BotManagementPanel.cursorVal.of(var2, var3.weightVal());
      if (!var8.listViewport.contains(var4, var5)) {
         return var8.content.contains(var4, var5);
      }

      List var9 = this.primaryVal(var1.OCOocoOoOO());
      float var10 = var9.size() * var8.rowHeight + Math.max(0, var9.size() - 1) * var8.rowGap;
      float var11 = Math.max(0.0F, var10 - var8.listViewport.h);
      this.blockRef = primaryVal(this.blockRef - (float)var6 * var3.weightVal().primaryVal(34.0F), 0.0F, var11);
      return true;
   }

   public boolean primaryVal(ClickGuiState var1, int var2) {
      if (this.chunkVal) {
         if (var2 == 256) {
            this.marginVal();
            return true;
         } else if (var2 == 258) {
            boolean var4 = this.weightVal.secondaryVal();
            this.weightVal.primaryVal(!var4);
            this.paramVal.primaryVal(var4);
            return true;
         } else if (var2 == 257 || var2 == 335) {
            this.weightVal();
            return true;
         } else {
            return !this.weightVal.primaryVal(var2) && !this.paramVal.primaryVal(var2) ? true : true;
         }
      } else if (this.extraVal.secondaryVal()) {
         if (var2 == 256) {
            this.extraVal.primaryVal(false);
            return true;
         }

         if (var2 != 257 && var2 != 335) {
            return this.extraVal.primaryVal(var2);
         }

         HeadlessBotHostManager.WildClient var3 = this.limitVal == null ? null : HeadlessBotHostManager.primaryVal(this.limitVal);
         if (var3 != null) {
            this.primaryVal(var3);
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean primaryVal(char var1) {
      return !this.chunkVal ? this.extraVal.primaryVal(var1) : this.weightVal.primaryVal(var1) || this.paramVal.primaryVal(var1);
   }

   public boolean primaryVal() {
      return this.chunkVal || this.weightVal.secondaryVal() || this.paramVal.secondaryVal() || this.extraVal.secondaryVal();
   }

   public void secondaryVal() {
      this.marginVal();
      this.extraVal.primaryVal(false);
      this.extraVal.primaryVal("");
      this.speedVal = null;
   }

   private void primaryVal(
      Renderer2D var1, ClickGuiState var2, GuiMetrics var3, ThemePalette var4, BotManagementPanel.cursorVal var5, List<HeadlessBotHostManager.WildClient> var6, HeadlessBotHostManager.WildClient var7
   ) {
      this.primaryVal(var1, var3, var4, var5.listPanel, 0.0F);
      String var8 = "Bots:";
      float var9 = var5.listPanel.x + var3.primaryVal(12.0F);
      float var10 = var5.listPanel.y + var3.primaryVal(11.0F);
      UiRenderUtil.primaryVal(var1, var3, FontRegistry.marginVal, var9, var10, 11.0F, var8, UiRenderUtil.primaryVal(var4));
      String var11 = var2.OCOocoOoOO();
      int var12 = var11 != null && !var11.isBlank() ? HeadlessBotHostManager.secondaryVal().size() : var6.size();
      String var13 = Integer.toString(var12);
      float var14 = UiRenderUtil.primaryVal(var3, FontRegistry.marginVal, var8, 11.0F);
      UiRenderUtil.primaryVal(var1, var3, FontRegistry.marginVal, var9 + var14, var10, 11.0F, var13, var4.marginVal());
      this.primaryVal(var1, var2, var3, var4, var5.hostButton, "Host", BotManagementPanel.WildClient.NORMAL, var2.extraVal() == null);
      this.primaryVal(var1, var2, var3, var4, var5.addButton, "+ Add", BotManagementPanel.WildClient.ACCENT, false);
      float var15 = var6.size() * var5.rowHeight + Math.max(0, var6.size() - 1) * var5.rowGap;
      float var16 = Math.max(0.0F, var15 - var5.listViewport.h);
      this.blockRef = primaryVal(this.blockRef, 0.0F, var16);
      var1.tertiaryVal();
      var1.primaryVal(
         var5.listViewport.x,
         var5.listViewport.y,
         var5.listViewport.w,
         var5.listViewport.h,
         var3.primaryVal(6.0F),
         var3.primaryVal(6.0F),
         var3.primaryVal(6.0F),
         var3.primaryVal(6.0F)
      );

      try {
         float var17 = var5.listViewport.y - this.blockRef;

         for (HeadlessBotHostManager.WildClient var19 : var6) {
            BotManagementPanel.VvunVVUvUNnv var20 = new BotManagementPanel.VvunVVUvUNnv(
               var5.listViewport.x, var17, var5.listViewport.w - (var16 > 0.0F ? var3.primaryVal(5.0F) : 0.0F), var5.rowHeight
            );
            if (var20.intersects(var5.listViewport)) {
               this.primaryVal(var1, var2, var3, var4, var20, var19, var7 != null && var7.name().equalsIgnoreCase(var19.name()));
            }

            var17 += var5.rowHeight + var5.rowGap;
         }

         if (var6.isEmpty()) {
            this.primaryVal(var1, var3, var4, var5.listViewport);
         }
      } finally {
         var1.tertiaryVal();
         var1.paramVal();
      }

      if (var16 > 0.0F) {
         float var24 = var5.listViewport.h;
         float var25 = Math.max(var3.primaryVal(28.0F), var24 * (var24 / (var24 + var16)));
         float var26 = var5.listViewport.y + (var24 - var25) * (this.blockRef / var16);
         var1.primaryVal(
            var5.listViewport.x + var5.listViewport.w - var3.primaryVal(2.5F),
            var5.listViewport.y,
            var3.primaryVal(1.5F),
            var24,
            var3.primaryVal(1.0F),
            var4.widthVal()
         );
         var1.primaryVal(
            var5.listViewport.x + var5.listViewport.w - var3.primaryVal(3.0F),
            var26,
            var3.primaryVal(2.5F),
            var25,
            var3.primaryVal(1.5F),
            ThemePalette.primaryVal(var4.depthVal(), 150)
         );
      }
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, GuiMetrics var3, ThemePalette var4, BotManagementPanel.VvunVVUvUNnv var5, HeadlessBotHostManager.WildClient var6, boolean var7) {
      boolean var8 = var5.contains(var2.nodeD(), var2.NnuUnUNnu());
      float var9 = var7 ? 1.0F : (var8 ? 0.55F : 0.0F);
      int var10 = ThemePalette.primaryVal(
         UiRenderUtil.primaryVal(var4, var8 ? 1.0F : 0.0F), ThemePalette.primaryVal(var4.descRef(), var4.activeVal() ? 34 : 48), var7 ? 0.42F : 0.0F
      );
      var1.primaryVal(var5.x, var5.y, var5.w, var5.h, var3.primaryVal(8.0F), var10);
      var1.primaryVal(
         var5.x,
         var5.y,
         var5.w,
         var5.h,
         var3.primaryVal(8.0F),
         ThemePalette.primaryVal(var4.chunkVal(), ThemePalette.primaryVal(var4.depthVal(), 145), var9),
         Math.max(0.55F, var3.primaryVal(0.6F))
      );
      int var11 = primaryVal(var4, var6);
      float var12 = var5.x + var3.primaryVal(13.0F);
      float var13 = var5.y + var3.primaryVal(17.0F);
      var1.secondaryVal(var12, var13, var3.primaryVal(3.3F), 0.0F, 1.0F, ThemePalette.primaryVal(var11, 48));
      var1.secondaryVal(var12, var13, var3.primaryVal(1.8F), 0.0F, 1.0F, var11);
      UiRenderUtil.primaryVal(
         var1,
         var3,
         FontRegistry.marginVal,
         var5.x + var3.primaryVal(23.0F),
         var5.y + var3.primaryVal(9.0F),
         10.5F,
         primaryVal(var6.name(), var5.w - var3.primaryVal(36.0F), var3, FontRegistry.marginVal, 10.5F),
         UiRenderUtil.primaryVal(var4)
      );
      UiRenderUtil.primaryVal(
         var1,
         var3,
         FontRegistry.primaryVal,
         var5.x + var3.primaryVal(13.0F),
         var5.y + var3.primaryVal(29.0F),
         8.2F,
         primaryVal(var6.address(), var5.w - var3.primaryVal(25.0F), var3, FontRegistry.primaryVal, 8.2F),
         UiRenderUtil.secondaryVal(var4)
      );
      String var14 = secondaryVal(var6);
      UiRenderUtil.primaryVal(
         var1,
         var3,
         FontRegistry.primaryVal,
         var5.x + var3.primaryVal(13.0F),
         var5.y + var3.primaryVal(43.0F),
         7.5F,
         primaryVal(var14, var5.w - var3.primaryVal(25.0F), var3, FontRegistry.primaryVal, 7.5F),
         ThemePalette.primaryVal(var11, 215)
      );
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, BotManagementPanel.VvunVVUvUNnv var4) {
      float var5 = var4.y + var4.h * 0.46F;
      var1.secondaryVal(var4.x + var4.w * 0.5F, var5 - var2.primaryVal(17.0F), var2.primaryVal(15.0F), 0.0F, 1.0F, var3.widthVal());
      primaryVal(var1, var2, var4.x + var4.w * 0.5F, var5 - var2.primaryVal(17.0F), UiRenderUtil.tertiaryVal(var3));
      String var6 = "No bots yet";
      float var7 = UiRenderUtil.primaryVal(var2, FontRegistry.marginVal, var6, 10.0F);
      UiRenderUtil.primaryVal(
         var1, var2, FontRegistry.marginVal, var4.x + (var4.w - var7) * 0.5F, var5 + var2.primaryVal(5.0F), 10.0F, var6, UiRenderUtil.secondaryVal(var3)
      );
      String var8 = "Click «Add»";
      float var9 = UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var8, 8.0F);
      UiRenderUtil.primaryVal(
         var1, var2, FontRegistry.primaryVal, var4.x + (var4.w - var9) * 0.5F, var5 + var2.primaryVal(23.0F), 8.0F, var8, UiRenderUtil.tertiaryVal(var3)
      );
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, GuiMetrics var3, ThemePalette var4, BotManagementPanel.cursorVal var5, HeadlessBotHostManager.WildClient var6) {
      this.primaryVal(var1, var3, var4, var5.detailPanel, 0.0F);
      if (var6 == null) {
         String var13 = "Select a bot on the left";
         float var14 = UiRenderUtil.primaryVal(var3, FontRegistry.marginVal, var13, 12.0F);
         UiRenderUtil.primaryVal(
            var1,
            var3,
            FontRegistry.marginVal,
            var5.detailPanel.x + (var5.detailPanel.w - var14) * 0.5F,
            var5.detailPanel.y + var5.detailPanel.h * 0.44F,
            12.0F,
            var13,
            UiRenderUtil.secondaryVal(var4)
         );
      } else {
         HeadlessBotSession var7 = var6.bot();
         int var8 = primaryVal(var4, var6);
         var1.secondaryVal(
            var5.detailPanel.x + var3.primaryVal(17.0F),
            var5.detailPanel.y + var3.primaryVal(22.0F),
            var3.primaryVal(4.0F),
            0.0F,
            1.0F,
            ThemePalette.primaryVal(var8, 55)
         );
         var1.secondaryVal(var5.detailPanel.x + var3.primaryVal(17.0F), var5.detailPanel.y + var3.primaryVal(22.0F), var3.primaryVal(2.2F), 0.0F, 1.0F, var8);
         UiRenderUtil.primaryVal(
            var1,
            var3,
            FontRegistry.marginVal,
            var5.detailPanel.x + var3.primaryVal(29.0F),
            var5.detailPanel.y + var3.primaryVal(11.0F),
            13.0F,
            primaryVal(var6.name(), var5.detailPanel.w - var3.primaryVal(125.0F), var3, FontRegistry.marginVal, 13.0F),
            UiRenderUtil.primaryVal(var4)
         );
         float var9 = var5.detailPanel.x + var3.primaryVal(29.0F);
         float var10 = Math.max(var3.primaryVal(24.0F), var5.forgetButton.x - var9 - var3.primaryVal(8.0F));
         UiRenderUtil.primaryVal(
            var1,
            var3,
            FontRegistry.primaryVal,
            var9,
            var5.detailPanel.y + var3.primaryVal(31.0F),
            8.5F,
            primaryVal(var6.address() + "  \u00b7  " + marginVal(var6.status()), var10, var3, FontRegistry.primaryVal, 8.5F),
            UiRenderUtil.secondaryVal(var4)
         );
         boolean var11 = var6.name().equalsIgnoreCase(this.speedVal) && System.currentTimeMillis() - this.widthVal <= 2500L;
         this.primaryVal(
            var1,
            var2,
            var3,
            var4,
            var5.forgetButton,
            var11 ? "Delete?" : "Delete",
            BotManagementPanel.WildClient.DANGER,
            var11
         );
         String var12 = var7 != null && HeadlessBotHostManager.primaryVal() == var7
            ? "Go back"
            : "Control";
         this.primaryVal(var1, var2, var3, var4, var5.controlButton, var12, BotManagementPanel.WildClient.ACCENT, var7 != null && HeadlessBotHostManager.primaryVal() == var7);
         this.primaryVal(var1, var2, var3, var4, var5.modulesButton, "Modules", BotManagementPanel.WildClient.NORMAL, false);
         this.primaryVal(var1, var2, var3, var4, var5.reconnectButton, "Reconnect", BotManagementPanel.WildClient.NORMAL, false);
         this.primaryVal(var1, var2, var3, var4, var5.disconnectButton, "Disconnect", BotManagementPanel.WildClient.DANGER, false);
         this.extraVal
            .primaryVal(
               var1,
               var3,
               var4,
               var5.chatField,
               "Message or /command",
               var2.nodeD(),
               var2.NnuUnUNnu()
            );
         this.primaryVal(var1, var2, var3, var4, var5.sendButton, "Send", BotManagementPanel.WildClient.ACCENT, false);
         if (var7 != null && var7.limitVal() != null && var7.widthVal()) {
            this.primaryVal(var1, var3, var4, var5, var7);
            this.primaryVal(var1, var2, var3, var4, var5, var7);
         }
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, BotManagementPanel.cursorVal var4, HeadlessBotSession var5) {
      var1.primaryVal(var4.stats.x, var4.stats.y, var4.stats.w, var4.stats.h, var2.primaryVal(7.0F), UiRenderUtil.primaryVal(var3, 0.0F));
      var1.primaryVal(var4.stats.x, var4.stats.y, var4.stats.w, var4.stats.h, var2.primaryVal(7.0F), var3.chunkVal(), Math.max(0.5F, var2.primaryVal(0.55F)));
      if (var5 != null && var5.limitVal() != null && var5.widthVal()) {
         HeadlessBotNetworkHandler var6 = var5.limitVal();
         String var7 = String.format(Locale.ROOT, "HP %.1f / %.1f", var6.method_6032(), var6.method_6063());
         String var8 = "Food " + var6.method_7344().method_7586();
         String var9 = "XP " + var6.field_7520;
         String var10 = "XYZ " + var6.method_31477() + "  " + var6.method_31478() + "  " + var6.method_31479();
         String[] var11 = new String[]{var7, var8, var9, var10};
         int[] var12 = new int[]{var3.primaryVal(), var3.tertiaryVal(), var3.marginVal(), UiRenderUtil.secondaryVal(var3)};
         float var13 = var2.primaryVal(8.0F);
         float var14 = (var4.stats.w - var13 * 2.0F) / var11.length;

         for (int var15 = 0; var15 < var11.length; var15++) {
            String var16 = primaryVal(var11[var15], var14 - var2.primaryVal(5.0F), var2, FontRegistry.primaryVal, 8.2F);
            float var17 = UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var16, 8.2F);
            float var18 = var4.stats.x + var13 + var15 * var14 + (var14 - var17) * 0.5F;
            UiRenderUtil.primaryVal(var1, var2, FontRegistry.primaryVal, var18, var4.stats.y, var4.stats.h, 8.2F, var16, var12[var15]);
         }
      }
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, GuiMetrics var3, ThemePalette var4, BotManagementPanel.cursorVal var5, HeadlessBotSession var6) {
      this.primaryVal(var1, var3, var4, var5.inventoryTab, "Inventory");
      float var7 = var5.inventoryArea.x - var3.primaryVal(8.0F);
      float var8 = var5.inventoryArea.y - var3.primaryVal(5.0F);
      float var9 = var5.inventoryArea.w + var3.primaryVal(16.0F);
      float var10 = var5.inventoryArea.h + var3.primaryVal(5.0F);
      int var11 = ThemePalette.primaryVal(UiRenderUtil.limitVal(var4), var4.countVal(), var4.activeVal() ? 0.025F : 0.045F);
      var1.primaryVal(var7, var8, var9, var10, var3.primaryVal(9.0F), var11);
      var1.primaryVal(
         var7,
         var8,
         var9,
         var10,
         var3.primaryVal(9.0F),
         var4.activeVal() ? UiRenderUtil.secondaryVal(var4, 0.92F) : var4.timerVal(),
         Math.max(0.65F, var3.primaryVal(0.7F))
      );
      if (var6 != null && var6.limitVal() != null && var6.widthVal()) {
         class_1799 var12 = this.secondaryVal(var1, var2, var3, var4, var5, var6);
         if (var12 != null && !var12.method_7960()) {
            String var13 = var12.method_7964().getString();
            if (var12.method_7947() > 1) {
               var13 = var13 + " \u00d7" + var12.method_7947();
            }

            UiRenderUtil.primaryVal(
               var1,
               var3,
               FontRegistry.primaryVal,
               var5.inventoryArea.x,
               var5.inventoryArea.y + var5.inventoryArea.h - var3.primaryVal(15.0F),
               8.3F,
               primaryVal(var13, var5.inventoryArea.w, var3, FontRegistry.primaryVal, 8.3F),
               UiRenderUtil.secondaryVal(var4)
            );
         }
      }
   }

   private class_1799 secondaryVal(Renderer2D var1, ClickGuiState var2, GuiMetrics var3, ThemePalette var4, BotManagementPanel.cursorVal var5, HeadlessBotSession var6) {
      float var7 = var5.slot;
      float var8 = var5.inventoryArea.x;
      float var9 = var5.inventoryArea.y + var3.primaryVal(3.0F);
      class_1799 var10 = class_1799.field_8037;

      for (int var11 = 0; var11 < 4; var11++) {
         if (var11 == 3) {
            var9 += var3.primaryVal(5.0F);
         }

         for (int var12 = 0; var12 < 9; var12++) {
            int var13 = var11 < 3 ? 9 + var11 * 9 + var12 : var12;
            BotManagementPanel.VvunVVUvUNnv var14 = new BotManagementPanel.VvunVVUvUNnv(
               var8 + var12 * var7, var9 + var11 * var7, var7 - var3.primaryVal(2.0F), var7 - var3.primaryVal(2.0F)
            );
            boolean var15 = var11 == 3 && var6.limitVal().method_31548().method_67532() == var12;
            class_1799 var16 = var6.limitVal().method_31548().method_5438(var13);
            this.primaryVal(var1, var2, var3, var4, var14, var16, var13, var15);
            if (var14.contains(var2.nodeD(), var2.NnuUnUNnu())) {
               var10 = var16;
            }
         }
      }

      float var17 = var8 + var7 * 9.0F + var3.primaryVal(10.0F);
      class_1304[] var18 = new class_1304[]{class_1304.field_6169, class_1304.field_6174, class_1304.field_6172, class_1304.field_6166};

      for (int var19 = 0; var19 < var18.length; var19++) {
         BotManagementPanel.VvunVVUvUNnv var21 = new BotManagementPanel.VvunVVUvUNnv(var17, var9 + var19 * var7, var7 - var3.primaryVal(2.0F), var7 - var3.primaryVal(2.0F));
         class_1799 var23 = var6.limitVal().method_6118(var18[var19]);
         this.primaryVal(var1, var2, var3, var4, var21, var23, 100 + var19, false);
         if (var21.contains(var2.nodeD(), var2.NnuUnUNnu())) {
            var10 = var23;
         }
      }

      BotManagementPanel.VvunVVUvUNnv var20 = new BotManagementPanel.VvunVVUvUNnv(
         var17 + var7 + var3.primaryVal(4.0F), var9 + var7 * 3.0F, var7 - var3.primaryVal(2.0F), var7 - var3.primaryVal(2.0F)
      );
      class_1799 var22 = var6.limitVal().method_6079();
      this.primaryVal(var1, var2, var3, var4, var20, var22, 110, false);
      if (var20.contains(var2.nodeD(), var2.NnuUnUNnu())) {
         var10 = var22;
      }

      return var10;
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, GuiMetrics var3, ThemePalette var4, BotManagementPanel.VvunVVUvUNnv var5, class_1799 var6, int var7, boolean var8) {
      boolean var9 = var5.contains(var2.nodeD(), var2.NnuUnUNnu());
      int var10 = ThemePalette.primaryVal(UiRenderUtil.limitVal(var4), var4.countVal(), var4.activeVal() ? 0.055F : 0.085F);
      float var11 = var8 ? 0.28F : (var9 ? 0.13F : 0.0F);
      var1.primaryVal(var5.x, var5.y, var5.w, var5.h, var3.primaryVal(5.0F), ThemePalette.primaryVal(var10, var4.descRef(), var11));
      var1.primaryVal(
         var5.x,
         var5.y,
         var5.w,
         var5.h,
         var3.primaryVal(5.0F),
         var8 ? ThemePalette.primaryVal(var4.depthVal(), 210) : (var9 ? ThemePalette.primaryVal(var4.depthVal(), 112) : var4.timerVal()),
         var8 ? Math.max(0.9F, var3.primaryVal(1.0F)) : Math.max(0.65F, var3.primaryVal(0.7F))
      );
      if (var6 != null && !var6.method_7960()) {
         float var12 = Math.min(var3.primaryVal(17.0F), var5.w - var3.primaryVal(5.0F));
         float var13 = var5.x + (var5.w - var12) * 0.5F;
         float var14 = var5.y + (var5.h - var12) * 0.5F;
         NuNvVUuUUnun.primaryVal(var1, var6.method_7972(), var13, var14, var12 / 16.0F, var7, true, var7);
      }
   }

   private void primaryVal(Renderer2D var1, ClickGuiState var2, GuiMetrics var3, ThemePalette var4, BotManagementPanel.cursorVal var5) {
      var1.primaryVal(
         var5.content.x, var5.content.y, var5.content.w, var5.content.h, var3.primaryVal(4.0F), ThemePalette.primaryVal(0, 0, 0, var4.activeVal() ? 72 : 124)
      );
      UiRenderUtil.primaryVal(
         var1, var3, var4, var5.modal.x, var5.modal.y, var5.modal.w, var5.modal.h, var3.primaryVal(14.0F), var3.primaryVal(24.0F), var3.primaryVal(2.0F), 0.9F
      );
      var1.primaryVal(var5.modal.x, var5.modal.y, var5.modal.w, var5.modal.h, var3.primaryVal(14.0F), UiRenderUtil.limitVal(var4));
      var1.primaryVal(
         var5.modal.x,
         var5.modal.y,
         var5.modal.w,
         var5.modal.h,
         var3.primaryVal(14.0F),
         ThemePalette.primaryVal(var4.depthVal(), 108),
         Math.max(0.75F, var3.primaryVal(0.75F))
      );
      UiRenderUtil.primaryVal(
         var1,
         var3,
         FontRegistry.marginVal,
         var5.modal.x + var3.primaryVal(18.0F),
         var5.modal.y + var3.primaryVal(16.0F),
         12.0F,
         "Add bot",
         UiRenderUtil.primaryVal(var4)
      );
      UiRenderUtil.primaryVal(
         var1, var3, FontRegistry.primaryVal, var5.nameField.x, var5.nameField.y - var3.primaryVal(13.0F), 7.5F, "Nickname", UiRenderUtil.tertiaryVal(var4)
      );
      UiRenderUtil.primaryVal(
         var1,
         var3,
         FontRegistry.primaryVal,
         var5.addressField.x,
         var5.addressField.y - var3.primaryVal(13.0F),
         7.5F,
         "Server",
         UiRenderUtil.tertiaryVal(var4)
      );
      this.weightVal.primaryVal(var1, var3, var4, var5.nameField, "Bot_1", var2.nodeD(), var2.NnuUnUNnu());
      this.primaryVal(var1, var2, var3, var4, var5.randomNameButton, "RND", BotManagementPanel.WildClient.NORMAL, false);
      this.paramVal.primaryVal(var1, var3, var4, var5.addressField, "play.example.net:25565", var2.nodeD(), var2.NnuUnUNnu());
      this.primaryVal(var1, var2, var3, var4, var5.addCancel, "Cancel", BotManagementPanel.WildClient.NORMAL, false);
      this.primaryVal(var1, var2, var3, var4, var5.addSubmit, "Connect", BotManagementPanel.WildClient.ACCENT, false);
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, BotManagementPanel.cursorVal var4) {
      if (!this.holderVal.isBlank() && System.currentTimeMillis() - this.anchorVal <= 4000L) {
         int var5 = this.timerVal ? var3.secondaryVal() : var3.primaryVal();
         float var6 = Math.min(
            var4.detailPanel.w - var2.primaryVal(24.0F), UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, this.holderVal, 8.2F) + var2.primaryVal(20.0F)
         );
         float var7 = var4.detailPanel.x + (var4.detailPanel.w - var6) * 0.5F;
         float var8 = var4.detailPanel.y + var4.detailPanel.h - var2.primaryVal(31.0F);
         var1.primaryVal(var7, var8, var6, var2.primaryVal(22.0F), var2.primaryVal(11.0F), ThemePalette.primaryVal(var5, var3.activeVal() ? 34 : 45));
         var1.primaryVal(var7, var8, var6, var2.primaryVal(22.0F), var2.primaryVal(11.0F), ThemePalette.primaryVal(var5, 120), Math.max(0.5F, var2.primaryVal(0.55F)));
         String var9 = primaryVal(this.holderVal, var6 - var2.primaryVal(16.0F), var2, FontRegistry.primaryVal, 8.2F);
         float var10 = UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var9, 8.2F);
         UiRenderUtil.primaryVal(var1, var2, FontRegistry.primaryVal, var7 + (var6 - var10) * 0.5F, var8, var2.primaryVal(22.0F), 8.2F, var9, var5);
      }
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, BotManagementPanel.VvunVVUvUNnv var4, float var5) {
      int var6 = ThemePalette.primaryVal(
         ThemePalette.primaryVal(UiRenderUtil.extraVal(var3), UiRenderUtil.limitVal(var3), 0.22F + primaryVal(var5, 0.0F, 1.0F) * 0.08F), 255
      );
      var1.primaryVal(var4.x, var4.y, var4.w, var4.h, var2.primaryVal(10.0F), var6);
      var1.primaryVal(
         var4.x,
         var4.y,
         var4.w,
         var4.h,
         var2.primaryVal(10.0F),
         var3.activeVal() ? UiRenderUtil.secondaryVal(var3, 0.82F) : var3.chunkVal(),
         Math.max(0.55F, var2.primaryVal(0.6F))
      );
   }

   private void primaryVal(
      Renderer2D var1, ClickGuiState var2, GuiMetrics var3, ThemePalette var4, BotManagementPanel.VvunVVUvUNnv var5, String var6, BotManagementPanel.WildClient var7, boolean var8
   ) {
      boolean var9 = var5.contains(var2.nodeD(), var2.NnuUnUNnu());
      float var10 = var8 ? 1.0F : (var9 ? 0.72F : 0.0F);
      int var11 = var7 == BotManagementPanel.WildClient.DANGER ? var4.secondaryVal() : var4.depthVal();
      int var12 = ThemePalette.primaryVal(UiRenderUtil.limitVal(var4), var4.countVal(), var4.activeVal() ? 0.045F : 0.085F);
      int var13 = var7 == BotManagementPanel.WildClient.ACCENT
         ? ThemePalette.primaryVal(var12, var4.descRef(), 0.24F)
         : (var7 == BotManagementPanel.WildClient.DANGER ? ThemePalette.primaryVal(var12, var4.secondaryVal(), 0.11F) : var12);
      var1.primaryVal(var5.x, var5.y, var5.w, var5.h, var3.primaryVal(6.0F), ThemePalette.primaryVal(var13, var11, var10 * 0.16F));
      int var14 = var4.activeVal() ? UiRenderUtil.secondaryVal(var4, 0.95F) : var4.anchorVal();
      var1.primaryVal(
         var5.x,
         var5.y,
         var5.w,
         var5.h,
         var3.primaryVal(6.0F),
         ThemePalette.primaryVal(var14, ThemePalette.primaryVal(var11, 185), var10 * 0.78F),
         Math.max(0.7F, var3.primaryVal(0.75F))
      );
      float var15 = UiRenderUtil.primaryVal(var3, FontRegistry.marginVal, var6, 8.2F);
      UiRenderUtil.primaryVal(
         var1,
         var3,
         FontRegistry.marginVal,
         var5.x + (var5.w - var15) * 0.5F,
         var5.y,
         var5.h,
         8.2F,
         var6,
         var7 == BotManagementPanel.WildClient.DANGER
            ? ThemePalette.primaryVal(UiRenderUtil.secondaryVal(var4), var4.secondaryVal(), 0.78F + var10 * 0.22F)
            : ThemePalette.primaryVal(UiRenderUtil.secondaryVal(var4), UiRenderUtil.primaryVal(var4), 0.68F + var10 * 0.32F)
      );
   }

   private void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, BotManagementPanel.VvunVVUvUNnv var4, String var5) {
      int var6 = ThemePalette.primaryVal(UiRenderUtil.limitVal(var3), var3.countVal(), var3.activeVal() ? 0.04F : 0.075F);
      var1.primaryVal(var4.x, var4.y, var4.w, var4.h, var2.primaryVal(5.0F), ThemePalette.primaryVal(var6, var3.descRef(), 0.24F));
      var1.primaryVal(var4.x, var4.y, var4.w, var4.h, var2.primaryVal(5.0F), ThemePalette.primaryVal(var3.depthVal(), 180), Math.max(0.65F, var2.primaryVal(0.7F)));
      float var7 = UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var5, 8.0F);
      UiRenderUtil.primaryVal(var1, var2, FontRegistry.primaryVal, var4.x + (var4.w - var7) * 0.5F, var4.y, var4.h, 8.0F, var5, var3.marginVal());
   }

   private void tertiaryVal() {
      this.chunkVal = true;
      this.extraVal.primaryVal(false);
      this.extraVal.primaryVal("");
      this.speedVal = null;
      this.weightVal.primaryVal(paramVal());
      this.paramVal.primaryVal(extraVal());
      this.weightVal.primaryVal(true);
      this.paramVal.primaryVal(false);
   }

   private void marginVal() {
      this.chunkVal = false;
      this.weightVal.primaryVal(false);
      this.paramVal.primaryVal(false);
   }

   private void weightVal() {
      String var1 = this.weightVal.primaryVal().trim();
      String var2 = this.paramVal.primaryVal().trim();
      if (!var1.isEmpty() && !var2.isEmpty()) {
         if (BotConnector.primaryVal(var1, var2)) {
            this.secondaryVal(var1);
            this.marginVal();
            this.primaryVal("Connection started", false);
         } else {
            this.primaryVal(
               "Check nickname, address, or duplicates",
               true
            );
         }
      } else {
         this.primaryVal(
            "Specify nickname and server address",
            true
         );
      }
   }

   private static String paramVal() {
      ThreadLocalRandom var0 = ThreadLocalRandom.current();

      for (int var1 = 0; var1 < 24; var1++) {
         String var2 = tertiaryVal[var0.nextInt(tertiaryVal.length)] + marginVal[var0.nextInt(marginVal.length)] + var0.nextInt(10, 1000);
         if (var2.length() > 16) {
            var2 = var2.substring(0, 16);
         }

         if (HeadlessBotHostManager.primaryVal(var2) == null) {
            return var2;
         }
      }

      String var3 = "Bot" + Integer.toUnsignedString(var0.nextInt(), 36);
      return var3.substring(0, Math.min(16, var3.length()));
   }

   private void primaryVal(HeadlessBotHostManager.WildClient var1) {
      HeadlessBotSession var2 = var1.bot();
      String var3 = this.extraVal.primaryVal().trim();
      if (var2 != null && var2.primaryVal(var3)) {
         this.extraVal.primaryVal("");
         this.primaryVal(
            "Message sent from " + var1.name(),
            false
         );
      } else {
         this.primaryVal(
            "Message not sent: bot is offline or text is invalid",
            true
         );
      }
   }

   private List<HeadlessBotHostManager.WildClient> primaryVal(String var1) {
      ArrayList<HeadlessBotHostManager.WildClient> var2 = new ArrayList<>(HeadlessBotHostManager.secondaryVal());
      var2.sort(
         Comparator.<HeadlessBotHostManager.WildClient>comparingInt(var0 -> tertiaryVal(var0.state() == null ? "" : var0.state().name()))
            .thenComparing(HeadlessBotHostManager.WildClient::name, String.CASE_INSENSITIVE_ORDER)
      );
      String var3 = var1 == null ? "" : var1.trim().toLowerCase(Locale.ROOT);
      if (!var3.isEmpty()) {
         var2.removeIf(
            var1x -> !var1x.name().toLowerCase(Locale.ROOT).contains(var3)
               && !var1x.address().toLowerCase(Locale.ROOT).contains(var3)
               && !marginVal(var1x.status()).toLowerCase(Locale.ROOT).contains(var3)
         );
      }

      return var2;
   }

   private HeadlessBotHostManager.WildClient primaryVal(List<HeadlessBotHostManager.WildClient> var1) {
      HeadlessBotHostManager.WildClient var2 = this.limitVal == null ? null : HeadlessBotHostManager.primaryVal(this.limitVal);
      if (var2 != null) {
         String var3 = var2.name();
         if (var1.stream().noneMatch(var1x -> var1x.name().equalsIgnoreCase(var3))) {
            this.secondaryVal((String)null);
            var2 = null;
         }
      }

      if (var2 == null && !var1.isEmpty()) {
         var2 = (HeadlessBotHostManager.WildClient)var1.get(0);
         this.secondaryVal(var2.name());
      }

      return var2;
   }

   private void secondaryVal(String var1) {
      boolean var2 = this.limitVal == null ? var1 != null : var1 == null || !this.limitVal.equalsIgnoreCase(var1);
      this.limitVal = var1;
      if (var2) {
         this.extraVal.primaryVal(false);
         this.extraVal.primaryVal("");
         this.speedVal = null;
      }
   }

   private void primaryVal(String var1, boolean var2) {
      this.holderVal = var1 == null ? "" : var1;
      this.timerVal = var2;
      this.anchorVal = System.currentTimeMillis();
   }

   private static int primaryVal(ThemePalette var0, HeadlessBotHostManager.WildClient var1) {
      String var2 = var1.state() == null ? "" : var1.state().name();
      if ("JOINED".equals(var2)) {
         return var0.primaryVal();
      } else if ("ERROR".equals(var2)) {
         return var0.secondaryVal();
      } else {
         return !"DISCONNECTED".equals(var2) && !"SAVED".equals(var2) ? var0.tertiaryVal() : UiRenderUtil.secondaryVal(var0);
      }
   }

   private static int tertiaryVal(String var0) {
      return switch (var0) {
         case "JOINED" -> 0;
         case "RESOLVING", "CONNECTING", "LOGIN", "CONFIGURING", "RECONFIGURING" -> 1;
         case "ERROR" -> 2;
         default -> 3;
      };
   }

   private static String secondaryVal(HeadlessBotHostManager.WildClient var0) {
      String var1 = marginVal(var0.status());
      if (!var1.isBlank()) {
         return var1;
      }

      String var2 = var0.state() == null ? "SAVED" : var0.state().name();

      return switch (var2) {
         case "JOINED" -> "In-game";
         case "RESOLVING" -> "Finding server";
         case "CONNECTING" -> "Connecting";
         case "LOGIN" -> "Logging in";
         case "CONFIGURING" -> "Setup";
         case "RECONFIGURING" -> "Changing server";
         case "ERROR" -> "Error";
         case "DISCONNECTED" -> "Disconnected";
         default -> "Saved";
      };
   }

   private static String marginVal(String var0) {
      return var0 == null ? "" : var0.replaceAll("(?i)\u00a7[0-9A-FK-OR]", "").replace("\u00c2", "").trim();
   }

   private static String extraVal() {
      class_310 var0 = class_310.method_1551();
      return var0 != null && var0.method_1558() != null ? var0.method_1558().field_3761 : "";
   }

   private static String primaryVal(String var0, float var1, GuiMetrics var2, FontObject var3, float var4) {
      String var5 = var0 == null ? "" : var0;
      if (UiRenderUtil.primaryVal(var2, var3, var5, var4) <= var1) {
         return var5;
      }

      String var6 = "\u2026";
      int var7 = var5.length();

      while (var7 > 0 && UiRenderUtil.primaryVal(var2, var3, var5.substring(0, var7) + var6, var4) > var1) {
         var7--;
      }

      return var7 <= 0 ? var6 : var5.substring(0, var7) + var6;
   }

   private static void primaryVal(Renderer2D var0, GuiMetrics var1, float var2, float var3, int var4) {
      float var5 = var1.primaryVal(0.8F);
      var0.primaryVal(var2 - 7.0F * var5, var3 - 5.0F * var5, 14.0F * var5, 10.0F * var5, 3.0F * var5, var4, Math.max(0.7F, var1.primaryVal(0.75F)));
      var0.secondaryVal(var2 - 3.0F * var5, var3 - 1.0F * var5, 1.3F * var5, 0.0F, 1.0F, var4);
      var0.secondaryVal(var2 + 3.0F * var5, var3 - 1.0F * var5, 1.3F * var5, 0.0F, 1.0F, var4);
      var0.primaryVal(var2 - 3.0F * var5, var3 + 2.5F * var5, 6.0F * var5, Math.max(0.7F, var1.primaryVal(0.65F)), 0.4F * var5, var4);
   }

   private static float primaryVal(float var0, float var1, float var2) {
      return Math.max(var1, Math.min(var2, var0));
   }

   enum WildClient {
      NORMAL,
      ACCENT,
      DANGER;
   }

   record VvunVVUvUNnv(float x, float y, float w, float h) {

      boolean contains(float var1, float var2) {
         return var1 >= this.x && var2 >= this.y && var1 < this.x + this.w && var2 < this.y + this.h;
      }

      boolean intersects(BotManagementPanel.VvunVVUvUNnv var1) {
         return this.x < var1.x + var1.w && this.x + this.w > var1.x && this.y < var1.y + var1.h && this.y + this.h > var1.y;
      }
   }

   record cursorVal(
      BotManagementPanel.VvunVVUvUNnv content,
      BotManagementPanel.VvunVVUvUNnv listPanel,
      BotManagementPanel.VvunVVUvUNnv listViewport,
      BotManagementPanel.VvunVVUvUNnv addButton,
      BotManagementPanel.VvunVVUvUNnv hostButton,
      BotManagementPanel.VvunVVUvUNnv detailPanel,
      BotManagementPanel.VvunVVUvUNnv forgetButton,
      BotManagementPanel.VvunVVUvUNnv controlButton,
      BotManagementPanel.VvunVVUvUNnv modulesButton,
      BotManagementPanel.VvunVVUvUNnv reconnectButton,
      BotManagementPanel.VvunVVUvUNnv disconnectButton,
      BotManagementPanel.VvunVVUvUNnv chatField,
      BotManagementPanel.VvunVVUvUNnv sendButton,
      BotManagementPanel.VvunVVUvUNnv stats,
      BotManagementPanel.VvunVVUvUNnv inventoryTab,
      BotManagementPanel.VvunVVUvUNnv inventoryArea,
      BotManagementPanel.VvunVVUvUNnv modal,
      BotManagementPanel.VvunVVUvUNnv nameField,
      BotManagementPanel.VvunVVUvUNnv randomNameButton,
      BotManagementPanel.VvunVVUvUNnv addressField,
      BotManagementPanel.VvunVVUvUNnv addCancel,
      BotManagementPanel.VvunVVUvUNnv addSubmit,
      float rowHeight,
      float rowGap,
      float slot
   ) {

      static BotManagementPanel.cursorVal of(ElementAnimState var0, GuiMetrics var1) {
         float var2 = var1.primaryVal(13.0F);
         BotManagementPanel.VvunVVUvUNnv var3 = new BotManagementPanel.VvunVVUvUNnv(var0.anchorVal(), var0.weightRef(), var0.bufferVal(), var0.countVal());
         float var4 = var3.x + var2;
         float var5 = var3.y + var2;
         float var6 = var3.w - var2 * 2.0F;
         float var7 = var3.h - var2 * 2.0F;
         float var8 = var1.primaryVal(10.0F);
         float var9 = Math.min(var1.primaryVal(226.0F), var6 * 0.34F);
         BotManagementPanel.VvunVVUvUNnv var10 = new BotManagementPanel.VvunVVUvUNnv(var4, var5, var9, var7);
         BotManagementPanel.VvunVVUvUNnv var11 = new BotManagementPanel.VvunVVUvUNnv(var4 + var9 + var8, var5, var6 - var9 - var8, var7);
         BotManagementPanel.VvunVVUvUNnv var12 = new BotManagementPanel.VvunVVUvUNnv(
            var10.x + var10.w - var1.primaryVal(82.0F), var10.y + var1.primaryVal(7.0F), var1.primaryVal(73.0F), var1.primaryVal(25.0F)
         );
         BotManagementPanel.VvunVVUvUNnv var13 = new BotManagementPanel.VvunVVUvUNnv(var12.x - var1.primaryVal(56.0F), var12.y, var1.primaryVal(50.0F), var12.h);
         BotManagementPanel.VvunVVUvUNnv var14 = new BotManagementPanel.VvunVVUvUNnv(
            var10.x + var1.primaryVal(8.0F), var10.y + var1.primaryVal(41.0F), var10.w - var1.primaryVal(16.0F), var10.h - var1.primaryVal(49.0F)
         );
         BotManagementPanel.VvunVVUvUNnv var15 = new BotManagementPanel.VvunVVUvUNnv(
            var11.x + var11.w - var1.primaryVal(73.0F), var11.y + var1.primaryVal(9.0F), var1.primaryVal(63.0F), var1.primaryVal(25.0F)
         );
         float var16 = var11.y + var1.primaryVal(54.0F);
         float var17 = var1.primaryVal(5.0F);
         float var18 = (var11.w - var1.primaryVal(20.0F) - var17 * 3.0F) / 4.0F;
         float var19 = var11.x + var1.primaryVal(10.0F);
         BotManagementPanel.VvunVVUvUNnv var20 = new BotManagementPanel.VvunVVUvUNnv(var19, var16, var18, var1.primaryVal(28.0F));
         BotManagementPanel.VvunVVUvUNnv var21 = new BotManagementPanel.VvunVVUvUNnv(var19 + var18 + var17, var16, var18, var1.primaryVal(28.0F));
         BotManagementPanel.VvunVVUvUNnv var22 = new BotManagementPanel.VvunVVUvUNnv(var19 + (var18 + var17) * 2.0F, var16, var18, var1.primaryVal(28.0F));
         BotManagementPanel.VvunVVUvUNnv var23 = new BotManagementPanel.VvunVVUvUNnv(var19 + (var18 + var17) * 3.0F, var16, var18, var1.primaryVal(28.0F));
         float var24 = var16 + var1.primaryVal(36.0F);
         BotManagementPanel.VvunVVUvUNnv var25 = new BotManagementPanel.VvunVVUvUNnv(var11.x + var11.w - var1.primaryVal(86.0F), var24, var1.primaryVal(76.0F), var1.primaryVal(29.0F));
         BotManagementPanel.VvunVVUvUNnv var26 = new BotManagementPanel.VvunVVUvUNnv(
            var11.x + var1.primaryVal(10.0F), var24, var25.x - var11.x - var1.primaryVal(17.0F), var1.primaryVal(29.0F)
         );
         BotManagementPanel.VvunVVUvUNnv var27 = new BotManagementPanel.VvunVVUvUNnv(
            var11.x + var1.primaryVal(10.0F), var24 + var1.primaryVal(38.0F), var11.w - var1.primaryVal(20.0F), var1.primaryVal(34.0F)
         );
         float var28 = var1.primaryVal(25.0F);
         float var29 = Math.min(var11.w - var1.primaryVal(24.0F), var28 * 11.0F + var1.primaryVal(12.0F));
         float var30 = var28 * 4.0F + var1.primaryVal(24.0F);
         float var31 = var11.x + (var11.w - var29) * 0.5F;
         float var32 = var1.primaryVal(30.0F) + var30 + var1.primaryVal(5.0F);
         float var33 = var27.y + var27.h + var1.primaryVal(9.0F);
         float var34 = var11.y + var11.h - var1.primaryVal(39.0F);
         float var35 = Math.max(0.0F, var34 - var33);
         float var36 = var33 + Math.max(0.0F, (var35 - var32) * 0.5F);
         BotManagementPanel.VvunVVUvUNnv var37 = new BotManagementPanel.VvunVVUvUNnv(var31 + (var29 - var1.primaryVal(80.0F)) * 0.5F, var36, var1.primaryVal(80.0F), var1.primaryVal(24.0F));
         BotManagementPanel.VvunVVUvUNnv var38 = new BotManagementPanel.VvunVVUvUNnv(var31, var36 + var1.primaryVal(30.0F), var29, var30);
         float var39 = Math.min(var1.primaryVal(430.0F), var3.w - var1.primaryVal(44.0F));
         float var40 = var1.primaryVal(164.0F);
         BotManagementPanel.VvunVVUvUNnv var41 = new BotManagementPanel.VvunVVUvUNnv(var3.x + (var3.w - var39) * 0.5F, var3.y + (var3.h - var40) * 0.5F, var39, var40);
         float var42 = var41.y + var1.primaryVal(58.0F);
         float var43 = var1.primaryVal(96.0F);
         BotManagementPanel.VvunVVUvUNnv var44 = new BotManagementPanel.VvunVVUvUNnv(var41.x + var1.primaryVal(18.0F), var42, var43, var1.primaryVal(30.0F));
         BotManagementPanel.VvunVVUvUNnv var45 = new BotManagementPanel.VvunVVUvUNnv(var44.x + var44.w + var1.primaryVal(6.0F), var42, var1.primaryVal(30.0F), var1.primaryVal(30.0F));
         BotManagementPanel.VvunVVUvUNnv var46 = new BotManagementPanel.VvunVVUvUNnv(
            var45.x + var45.w + var1.primaryVal(9.0F),
            var42,
            var41.x + var41.w - var1.primaryVal(18.0F) - var45.x - var45.w - var1.primaryVal(9.0F),
            var1.primaryVal(30.0F)
         );
         float var47 = var1.primaryVal(181.0F);
         float var48 = var41.x + (var41.w - var47) * 0.5F;
         BotManagementPanel.VvunVVUvUNnv var49 = new BotManagementPanel.VvunVVUvUNnv(var48, var41.y + var1.primaryVal(103.0F), var1.primaryVal(76.0F), var1.primaryVal(29.0F));
         BotManagementPanel.VvunVVUvUNnv var50 = new BotManagementPanel.VvunVVUvUNnv(var49.x + var49.w + var1.primaryVal(7.0F), var49.y, var1.primaryVal(98.0F), var1.primaryVal(29.0F));
         return new BotManagementPanel.cursorVal(
            var3,
            var10,
            var14,
            var12,
            var13,
            var11,
            var15,
            var20,
            var21,
            var22,
            var23,
            var26,
            var25,
            var27,
            var37,
            var38,
            var41,
            var44,
            var45,
            var46,
            var49,
            var50,
            var1.primaryVal(57.0F),
            var1.primaryVal(6.0F),
            var28
         );
      }
   }

   static final class DelayedFuse {
      private final int primaryVal;
      private final IntPredicate secondaryVal;
      private String tertiaryVal = "";
      private int marginVal;
      private int weightVal;
      private boolean paramVal;
      private long extraVal;

      DelayedFuse(int var1, IntPredicate var2) {
         this.primaryVal = var1;
         this.secondaryVal = var2;
      }

      String primaryVal() {
         return this.tertiaryVal;
      }

      void primaryVal(String var1) {
         this.tertiaryVal = var1 == null ? "" : var1.substring(0, Math.min(this.primaryVal, var1.length()));
         this.marginVal = this.tertiaryVal.length();
         this.weightVal = this.marginVal;
      }

      boolean secondaryVal() {
         return this.paramVal;
      }

      void primaryVal(boolean var1) {
         this.paramVal = var1;
         if (var1) {
            this.marginVal = Math.min(this.marginVal, this.tertiaryVal.length());
            this.weightVal = this.marginVal;
            this.extraVal = System.currentTimeMillis();
         }
      }

      boolean primaryVal(BotManagementPanel.VvunVVUvUNnv var1, float var2, float var3) {
         boolean var4 = var1.contains(var2, var3);
         this.primaryVal(var4);
         if (var4) {
            this.marginVal = this.tertiaryVal.length();
            this.weightVal = this.marginVal;
         }

         return var4;
      }

      boolean primaryVal(char var1) {
         if (this.paramVal && this.secondaryVal.test(var1)) {
            this.tertiaryVal(Character.toString(var1));
            return true;
         } else {
            return false;
         }
      }

      boolean primaryVal(int var1) {
         if (!this.paramVal) {
            return false;
         }

         boolean var2 = class_437.method_25441();
         boolean var3 = class_437.method_25442();
         class_310 var4 = class_310.method_1551();
         if (var2) {
            if (var1 == 65) {
               this.weightVal = 0;
               this.marginVal = this.tertiaryVal.length();
               return true;
            }

            if (var1 == 67) {
               if (this.tertiaryVal() && var4 != null) {
                  var4.field_1774.method_1455(this.marginVal());
               }

               return true;
            }

            if (var1 == 88) {
               if (this.tertiaryVal() && var4 != null) {
                  var4.field_1774.method_1455(this.marginVal());
                  this.tertiaryVal("");
               }

               return true;
            }

            if (var1 == 86) {
               if (var4 != null) {
                  this.secondaryVal(var4.field_1774.method_1460());
               }

               return true;
            }
         }

         switch (var1) {
            case 259:
               if (this.tertiaryVal()) {
                  this.tertiaryVal("");
               } else if (this.marginVal > 0) {
                  this.tertiaryVal = this.tertiaryVal.substring(0, this.marginVal - 1) + this.tertiaryVal.substring(this.marginVal);
                  this.marginVal--;
                  this.weightVal = this.marginVal;
               }
               break;
            case 260:
            case 264:
            case 265:
            case 266:
            case 267:
            default:
               return true;
            case 261:
               if (this.tertiaryVal()) {
                  this.tertiaryVal("");
               } else if (this.marginVal < this.tertiaryVal.length()) {
                  this.tertiaryVal = this.tertiaryVal.substring(0, this.marginVal) + this.tertiaryVal.substring(this.marginVal + 1);
                  this.weightVal = this.marginVal;
               }
               break;
            case 262:
               this.primaryVal(this.marginVal + 1, var3);
               break;
            case 263:
               this.primaryVal(this.marginVal - 1, var3);
               break;
            case 268:
               this.primaryVal(0, var3);
               break;
            case 269:
               this.primaryVal(this.tertiaryVal.length(), var3);
         }

         this.extraVal = System.currentTimeMillis();
         return true;
      }

      void primaryVal(Renderer2D var1, GuiMetrics var2, ThemePalette var3, BotManagementPanel.VvunVVUvUNnv var4, String var5, float var6, float var7) {
         boolean var8 = var4.contains(var6, var7);
         float var9 = this.paramVal ? 1.0F : (var8 ? 0.55F : 0.0F);
         int var10 = ThemePalette.primaryVal(UiRenderUtil.limitVal(var3), var3.countVal(), var3.activeVal() ? 0.04F : 0.075F);
         var1.primaryVal(var4.x, var4.y, var4.w, var4.h, var2.primaryVal(6.0F), ThemePalette.primaryVal(var10, var3.descRef(), var9 * 0.12F));
         var1.primaryVal(
            var4.x,
            var4.y,
            var4.w,
            var4.h,
            var2.primaryVal(6.0F),
            ThemePalette.primaryVal(var3.timerVal(), ThemePalette.primaryVal(var3.depthVal(), 180), var9),
            this.paramVal ? Math.max(0.85F, var2.primaryVal(0.9F)) : Math.max(0.65F, var2.primaryVal(0.7F))
         );
         String var11 = this.tertiaryVal.isEmpty() && !this.paramVal ? var5 : this.tertiaryVal;
         int var12 = this.tertiaryVal.isEmpty() && !this.paramVal ? UiRenderUtil.tertiaryVal(var3) : UiRenderUtil.primaryVal(var3);
         float var13 = var4.w - var2.primaryVal(16.0F);
         String var14 = primaryVal(var11, var13, var2, 8.7F);
         UiRenderUtil.primaryVal(var1, var2, FontRegistry.primaryVal, var4.x + var2.primaryVal(8.0F), var4.y, var4.h, 8.7F, var14, var12);
         if (this.paramVal && (System.currentTimeMillis() - this.extraVal) % 1000L < 530L) {
            String var15 = this.tertiaryVal.substring(0, Math.min(this.marginVal, this.tertiaryVal.length()));
            float var16 = UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var15, 8.7F);
            float var17 = Math.min(var4.x + var4.w - var2.primaryVal(7.0F), var4.x + var2.primaryVal(8.0F) + var16);
            var1.primaryVal(var17, var4.y + var2.primaryVal(6.0F), Math.max(1.0F, var2.primaryVal(0.75F)), var4.h - var2.primaryVal(12.0F), 0.0F, var3.depthVal());
         }
      }

      private void secondaryVal(String var1) {
         if (var1 != null && !var1.isEmpty()) {
            StringBuilder var2 = new StringBuilder();
            var1.codePoints().forEach(var2x -> {
               if (this.secondaryVal.test(var2x) && var2.length() < this.primaryVal) {
                  var2.appendCodePoint(var2x);
               }
            });
            this.tertiaryVal(var2.toString());
         }
      }

      private void tertiaryVal(String var1) {
         int var2 = Math.min(this.marginVal, this.weightVal);
         int var3 = Math.max(this.marginVal, this.weightVal);
         int var4 = this.primaryVal - (this.tertiaryVal.length() - (var3 - var2));
         String var5 = var1 == null ? "" : var1.substring(0, Math.min(var4, var1.length()));
         this.tertiaryVal = this.tertiaryVal.substring(0, var2) + var5 + this.tertiaryVal.substring(var3);
         this.marginVal = var2 + var5.length();
         this.weightVal = this.marginVal;
         this.extraVal = System.currentTimeMillis();
      }

      private void primaryVal(int var1, boolean var2) {
         this.marginVal = Math.max(0, Math.min(this.tertiaryVal.length(), var1));
         if (!var2) {
            this.weightVal = this.marginVal;
         }

         this.extraVal = System.currentTimeMillis();
      }

      private boolean tertiaryVal() {
         return this.marginVal != this.weightVal;
      }

      private String marginVal() {
         return this.tertiaryVal.substring(Math.min(this.marginVal, this.weightVal), Math.max(this.marginVal, this.weightVal));
      }

      private static String primaryVal(String var0, float var1, GuiMetrics var2, float var3) {
         if (UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, var0, var3) <= var1) {
            return var0;
         }

         int var4 = 0;

         while (var4 < var0.length() && UiRenderUtil.primaryVal(var2, FontRegistry.primaryVal, "\u2026" + var0.substring(var4), var3) > var1) {
            var4++;
         }

         return "\u2026" + var0.substring(Math.min(var4, var0.length()));
      }
   }
}
