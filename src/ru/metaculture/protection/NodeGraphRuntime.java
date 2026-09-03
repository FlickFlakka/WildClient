package ru.metaculture.protection;

import com.mojang.blaze3d.opengl.GlStateManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;
import net.minecraft.class_1297;
import org.json.JSONArray;
import org.json.JSONObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public final class NodeGraphRuntime {
   private static final NodeGraphRuntime primaryVal = new NodeGraphRuntime();
   static final float[] secondaryVal = new float[]{0.0F, 0.0F, 0.0F, 0.0F};
   private static final int tertiaryVal = 48;
   private static final long marginVal = 33L;
   private static final int weightVal = 6;
   private static final int paramVal = 7;
   private final Map<String, NodeGraphRuntime.DelayedFuse> extraVal = new LinkedHashMap<>();
   private final Map<String, float[]> limitVal = new HashMap<>();
   private final Map<String, Integer> speedVal = new HashMap<>();
   private final Map<String, NodeGraphRuntime.cursorVal> widthVal = new LinkedHashMap<>(16, 0.75F, true);
   private final NodeGraphRuntime.WildClient chunkVal = new NodeGraphRuntime.WildClient();
   private final NodeGraphRuntime.VvunVVUvUNnv blockRef = new NodeGraphRuntime.VvunVVUvUNnv();
   private boolean holderVal;

   private NodeGraphRuntime() {
   }

   public static NodeGraphRuntime primaryVal() {
      return primaryVal;
   }

   public synchronized void primaryVal(NodeDefinitionRegistry var1) {
      if (var1 != null) {
         if (!this.holderVal) {
            this.limitVal();
            NodeGraphCompiler.primaryVal(this::secondaryVal);
            this.holderVal = true;
         }

         for (NodeGraphRuntime.DelayedFuse var3 : this.extraVal.values()) {
            if (var1.primaryVal(var3.id()) == null) {
               var1.primaryVal(var3.toNodeDefinition());
            }
         }

         secondaryVal(var1);
      }
   }

   public synchronized void primaryVal(NodeGraphRuntime.DelayedFuse var1) {
      if (var1 != null) {
         this.extraVal.put(var1.id(), var1);
      }
   }

   public synchronized NodeGraphRuntime.DelayedFuse primaryVal(String var1) {
      return this.extraVal.get(var1);
   }

   public synchronized Collection<NodeGraphRuntime.DelayedFuse> secondaryVal() {
      return Collections.unmodifiableCollection(new ArrayList<>(this.extraVal.values()));
   }

   public synchronized List<NodeGraphRuntime.DelayedFuse> primaryVal(SurfaceTarget var1) {
      SurfaceTarget var2 = var1 == null ? SurfaceTarget.PREVIEW_ONLY : var1.marginVal();
      ArrayList var3 = new ArrayList();

      for (NodeGraphRuntime.DelayedFuse var5 : this.extraVal.values()) {
         if (var5.target().marginVal() == var2) {
            var3.add(var5);
         }
      }

      return var3;
   }

   public NodeGraphRuntime.WildClient tertiaryVal() {
      return this.chunkVal;
   }

   public NodeGraphRuntime.VvunVVUvUNnv marginVal() {
      return this.blockRef;
   }

   public synchronized String secondaryVal(SurfaceTarget var1) {
      if (var1 != null && var1 != SurfaceTarget.PREVIEW_ONLY) {
         StringBuilder var2 = new StringBuilder();

         for (NodeGraphRuntime.DelayedFuse var4 : this.extraVal.values()) {
            if (var4.target().marginVal() == var1 && !var4.glslPreamble().isBlank()) {
               var2.append(var4.glslPreamble());
               if (!var4.glslPreamble().endsWith("\n")) {
                  var2.append('\n');
               }
            }
         }

         return var2.toString();
      } else {
         return "";
      }
   }

   public boolean primaryVal(NodeDefinition var1, String var2, NodeDefinition var3, String var4) {
      return this.secondaryVal(var1, var2, var3, var4) == null;
   }

   public String secondaryVal(NodeDefinition var1, String var2, NodeDefinition var3, String var4) {
      if (var1 != null && var3 != null) {
         NodePort var5 = var1.secondaryVal(var2);
         if (var5 == null) {
            return var1.primaryVal() + " has no output slot '" + var2 + "'";
         }

         NodePort var6 = var3.primaryVal(var4);
         if (var6 == null) {
            return var3.primaryVal() + " has no input slot '" + var4 + "'";
         }

         NodeGraphRuntime.FingerprintCrypto var7 = NodeGraphRuntime.FingerprintCrypto.primaryVal(var5.type());
         NodeGraphRuntime.FingerprintCrypto var8 = NodeGraphRuntime.FingerprintCrypto.primaryVal(var6.type());
         return var5.type() != var6.type() ? "type mismatch: " + var7.primaryVal() + " -> " + var8.primaryVal() : null;
      } else {
         return "unknown node definition";
      }
   }

   public JSONObject primaryVal(NodeDefinition var1) {
      JSONObject var2 = new JSONObject();
      if (var1 == null) {
         return var2;
      }

      var2.put("id", var1.primaryVal());
      JSONArray var3 = new JSONArray();

      for (NodePort var5 : var1.weightVal()) {
         var3.put(primaryVal(var5));
      }

      JSONArray var7 = new JSONArray();

      for (NodePort var6 : var1.paramVal()) {
         var7.put(primaryVal(var6));
      }

      var2.put("inputs", var3);
      var2.put("outputs", var7);
      return var2;
   }

   public JSONArray primaryVal(NodeGraph var1, NodeDefinitionRegistry var2) {
      JSONArray var3 = new JSONArray();
      if (var1 != null && var2 != null) {
         for (NodeConnection var5 : var1.marginVal()) {
            NodeInstance var6 = var1.tertiaryVal(var5.primaryVal());
            NodeInstance var7 = var1.tertiaryVal(var5.tertiaryVal());
            if (var6 != null && var7 != null) {
               NodeDefinition var8 = var2.primaryVal(var6.secondaryVal());
               NodeDefinition var9 = var2.primaryVal(var7.secondaryVal());
               if (this.primaryVal(var8, var5.secondaryVal(), var9, var5.marginVal())) {
                  JSONObject var10 = new JSONObject();
                  var10.put("from", var5.primaryVal());
                  var10.put("fromSlot", var5.secondaryVal());
                  var10.put("to", var5.tertiaryVal());
                  var10.put("toSlot", var5.marginVal());
                  var10.put("type", var8.secondaryVal(var5.secondaryVal()).type().primaryVal());
                  var3.put(var10);
               }
            }
         }

         return var3;
      } else {
         return var3;
      }
   }

   public int primaryVal(NodeGraph var1, JSONArray var2, NodeDefinitionRegistry var3) {
      if (var1 != null && var2 != null && var3 != null) {
         int var4 = 0;

         for (int var5 = 0; var5 < var2.length(); var5++) {
            JSONObject var6 = var2.optJSONObject(var5);
            if (var6 != null) {
               String var7 = var6.optString("from", "");
               String var8 = var6.optString("fromSlot", "");
               String var9 = var6.optString("to", "");
               String var10 = var6.optString("toSlot", "");
               NodeInstance var11 = var1.tertiaryVal(var7);
               NodeInstance var12 = var1.tertiaryVal(var9);
               if (var11 != null && var12 != null) {
                  NodeDefinition var13 = var3.primaryVal(var11.secondaryVal());
                  NodeDefinition var14 = var3.primaryVal(var12.secondaryVal());
                  if (this.primaryVal(var13, var8, var14, var10)) {
                     String var15 = var6.optString("type", "");
                     if ((var15.isBlank() || var15.equals(var13.secondaryVal(var8).type().primaryVal())) && var1.primaryVal(var7, var8, var9, var10, var3)) {
                        var4++;
                     }
                  }
               }
            }
         }

         return var4;
      } else {
         return 0;
      }
   }

   public synchronized void primaryVal(String var1, float var2, float var3, float var4, float var5) {
      if (var1 != null && !var1.isBlank()) {
         this.limitVal.put(var1, new float[]{var2, var3, var4, var5});
      }
   }

   public synchronized void primaryVal(String var1, int var2) {
      if (var1 != null && !var1.isBlank()) {
         if (var2 <= 0) {
            this.speedVal.remove(var1);
         } else {
            this.speedVal.put(var1, var2);
         }
      }
   }

   public void primaryVal(float var1, float var2, float var3, float var4) {
      this.primaryVal("uRadii", Math.max(0.0F, var1), Math.max(0.0F, var2), Math.max(0.0F, var3), Math.max(0.0F, var4));
   }

   public synchronized void primaryVal(ShaderProgram var1, SurfaceTarget var2) {
      if (var1 != null) {
         SurfaceTarget var3 = var2 == null ? SurfaceTarget.PREVIEW_ONLY : var2.marginVal();

         for (NodeGraphRuntime.DelayedFuse var5 : this.extraVal.values()) {
            if (var5.target().marginVal() == var3) {
               for (NodeGraphRuntime.FatalErrorHandler var7 : var5.uniforms()) {
                  int var8 = var1.primaryVal(var7.name());
                  if (var8 >= 0) {
                     float[] var9 = this.limitVal.getOrDefault(var7.name(), var7.defaults());
                     switch (var7.kind()) {
                        case SAMPLER2D:
                           GL13.glActiveTexture(33984 + var7.textureUnit());
                           GL11.glBindTexture(3553, this.tertiaryVal(var7.name()));
                           GL20.glUniform1i(var8, var7.textureUnit());
                           break;
                        case VEC4:
                           GL20.glUniform4f(var8, var9[0], var9[1], var9[2], var9[3]);
                           break;
                        case VEC2:
                           GL20.glUniform2f(var8, var9[0], var9[1]);
                           break;
                        case FLOAT:
                           GL20.glUniform1f(var8, var9[0]);
                           break;
                        case INT:
                           GL20.glUniform1i(var8, Math.round(var9[0]));
                     }
                  }
               }
            }
         }

         GL13.glActiveTexture(33984);
      }
   }

   private int tertiaryVal(String var1) {
      Integer var2 = this.speedVal.get(var1);
      if (var2 != null && var2 > 0) {
         return var2;
      } else if ("uMask".equals(var1)) {
         int var4 = this.chunkVal.marginVal();
         return var4 > 0 ? var4 : ThemeShaderProgramCache.primaryVal().weightVal();
      } else if ("uDepth".equals(var1)) {
         int var3 = this.chunkVal.weightVal();
         return var3 > 0 ? var3 : ThemeShaderProgramCache.primaryVal().weightVal();
      } else {
         return ThemeShaderProgramCache.primaryVal().weightVal();
      }
   }

   public boolean primaryVal(
      String var1,
      ShaderCompileResult var2,
      Map<String, float[]> var3,
      float var4,
      float var5,
      float var6,
      float var7,
      int var8,
      int var9,
      float var10,
      float var11,
      ThemePalette var12,
      float var13
   ) {
      int var14 = this.chunkVal.marginVal();
      return var14 <= 0
         ? false
         : this.primaryVal(var1, var2, var3, SurfaceTarget.ESP, var14, var4, var5, var6, var7, var4, var5, var6, var7, 0.0F, var8, var9, var10, var11, var12, var13);
   }

   public boolean primaryVal(
      String var1,
      ShaderCompileResult var2,
      Map<String, float[]> var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      int var12,
      int var13,
      float var14,
      float var15,
      ThemePalette var16,
      float var17
   ) {
      this.primaryVal(var8, var9, var10, var11);
      float var18 = Math.max(Math.max(var8, var9), Math.max(var10, var11));
      return this.primaryVal(
         var1,
         var2,
         var3,
         SurfaceTarget.HUD,
         ThemeShaderProgramCache.primaryVal().weightVal(),
         var4,
         var5,
         var6,
         var7,
         var4,
         var5,
         var6,
         var7,
         var18,
         var12,
         var13,
         var14,
         var15,
         var16,
         var17
      );
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private boolean primaryVal(
      String var1,
      ShaderCompileResult var2,
      Map<String, float[]> var3,
      SurfaceTarget var4,
      int var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13,
      float var14,
      int var15,
      int var16,
      float var17,
      float var18,
      ThemePalette var19,
      float var20
   ) {
      if (var2 != null && var2.ok() && var15 > 0 && var16 > 0 && !(var8 <= 0.0F) && !(var9 <= 0.0F) && !(var20 <= 0.001F)) {
         ShaderProgram var21 = ThemeShaderProgramCache.primaryVal().primaryVal(var1, var2);
         FullscreenQuad var22 = ThemeShaderProgramCache.primaryVal().secondaryVal();
         if (var21 != null && var22 != null) {
            GLStateSnapshot.Snapshot var23 = GLStateSnapshot.primaryVal();
            boolean var31 = false /* VF: Semaphore variable */;

            boolean var28;
            try {
               var31 = true;
               GL11.glViewport(0, 0, var15, var16);
               GL11.glDisable(2929);
               GL11.glDisable(2884);
               GL11.glDepthMask(false);
               GlStateManager._enableBlend();
               GL11.glEnable(3042);
               GL14.glBlendFuncSeparate(770, 771, 1, 771);
               GL11.glDisable(36281);
               var21.primaryVal();
               GL13.glActiveTexture(33984);
               GL11.glBindTexture(3553, var5 > 0 ? var5 : ThemeShaderProgramCache.primaryVal().weightVal());
               primaryVal(var21, "u_DiffuseMap", 0);
               primaryVal(var21, "uViewport", var15, var16);
               primaryVal(var21, "uRect", var6, var7, var8, var9);
               primaryVal(var21, "u_ElementRect", var10, var11, var12, var13);
               primaryVal(var21, "u_ElementRadius", Math.max(0.0F, var14));
               primaryVal(var21, "u_GlobalUV", var10 / Math.max(1.0F, var15), var11 / Math.max(1.0F, var16));
               primaryVal(var21, "u_Resolution", Math.max(1.0F, var15), Math.max(1.0F, var16));
               primaryVal(var21, "u_Time", ThemeShaderProgramCache.primaryVal().tertiaryVal());
               primaryVal(var21, "u_Mouse", var17 - var10, var18 - var11);
               int var24 = var19 == null ? -1 : var19.depthVal();
               int var25 = var19 == null ? -16777216 : var19.descRef();
               int var26 = var19 == null ? -15724520 : var19.paramVal();
               int var27 = var19 == null ? -14671832 : var19.extraVal();
               primaryVal(var21, "u_AccentTop", primaryVal(var24, 16), primaryVal(var24, 8), primaryVal(var24, 0));
               primaryVal(var21, "u_AccentBottom", primaryVal(var25, 16), primaryVal(var25, 8), primaryVal(var25, 0));
               primaryVal(var21, "u_ThemeColors[0]", primaryVal(var26, 16), primaryVal(var26, 8), primaryVal(var26, 0), primaryVal(var26, 24));
               primaryVal(var21, "u_ThemeColors[1]", primaryVal(var27, 16), primaryVal(var27, 8), primaryVal(var27, 0), primaryVal(var27, 24));
               primaryVal(var21, "u_ThemeColors[2]", primaryVal(var24, 16), primaryVal(var24, 8), primaryVal(var24, 0), var20);
               primaryVal(var21, "u_ThemeColors[3]", primaryVal(var25, 16), primaryVal(var25, 8), primaryVal(var25, 0), var20);
               primaryVal(var21, "u_Alpha", var20);
               primaryVal(var21, var2, var3);
               this.primaryVal(var21, var4);
               var22.primaryVal();
               var28 = true;
               var31 = false;
            } finally {
               if (var31) {
                  GL13.glActiveTexture(33984);
                  GL11.glBindTexture(3553, 0);
                  GLStateSnapshot.tertiaryVal(var23);
               }
            }

            GL13.glActiveTexture(33984);
            GL11.glBindTexture(3553, 0);
            GLStateSnapshot.tertiaryVal(var23);
            return var28;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public synchronized int primaryVal(
      NodeGraphCompiler var1, NodeDefinitionRegistry var2, NodeGraph var3, String var4, float var5, float var6, ThemePalette var7, float var8, float var9
   ) {
      if (var1 != null && var2 != null && var3 != null && var4 != null && !(var5 <= 2.0F) && !(var6 <= 2.0F)) {
         NodeInstance var10 = var3.tertiaryVal(var4);
         NodeDefinition var11 = var10 == null ? null : var2.primaryVal(var10.secondaryVal());
         NodePort var12 = secondaryVal(var11);
         if (var12 == null) {
            return 0;
         }

         NodeGraphRuntime.cursorVal var13 = this.widthVal.computeIfAbsent(var4, var0 -> new NodeGraphRuntime.cursorVal());
         int var14 = var3.weightVal();
         if (var13.secondaryVal == null || var13.weightVal != var14 || !var12.id().equals(var13.tertiaryVal)) {
            NodeGraph var15 = var3.weightVal(var4);
            var15.primaryVal(SurfaceTarget.PREVIEW_ONLY.primaryVal());
            var13.secondaryVal = var1.primaryVal(var15, var4, var12.id(), var12.type());
            var13.weightVal = var14;
            var13.tertiaryVal = var12.id();
            var13.limitVal = 0L;
            String var16 = var13.secondaryVal == null ? "" : "__template_preview_" + var13.secondaryVal.hash();
            if (!var13.marginVal.isEmpty() && !var13.marginVal.equals(var16)) {
               ThemeShaderProgramCache.primaryVal().tertiaryVal(var13.marginVal);
            }

            var13.marginVal = var16;
         }

         if (var13.secondaryVal != null && var13.secondaryVal.ok()) {
            long var24 = System.currentTimeMillis();
            int var17 = Math.max(32, Math.min(512, (int)Math.ceil(var5)));
            int var18 = Math.max(32, Math.min(384, (int)Math.ceil(var6)));
            if (var24 - var13.limitVal >= 33L || var13.paramVal != var17 || var13.extraVal != var18) {
               GLStateSnapshot.Snapshot var19 = GLStateSnapshot.primaryVal();

               try {
                  var13.primaryVal.primaryVal(var17, var18);
                  if (!var13.primaryVal.paramVal()) {
                     return 0;
                  }

                  var13.primaryVal.primaryVal();
                  GL11.glDisable(3089);
                  GlStateManager._enableBlend();
                  GL11.glEnable(3042);
                  GL11.glClearColor(0.008F, 0.01F, 0.015F, 0.0F);
                  GL11.glClear(16384);
                  ThemeShaderRenderer.primaryVal(var13.marginVal, var13.secondaryVal, 0.0F, 0.0F, var17, var18, var17, var18, var8, var9, var7, 1.0F);
                  var13.limitVal = var24;
                  var13.paramVal = var17;
                  var13.extraVal = var18;
               } finally {
                  GLStateSnapshot.tertiaryVal(var19);
               }
            }

            var13.speedVal = var24;
            this.extraVal();
            return var13.primaryVal.tertiaryVal();
         } else {
            return 0;
         }
      } else {
         return 0;
      }
   }

   public synchronized void secondaryVal(String var1) {
      NodeGraphRuntime.cursorVal var2 = this.widthVal.remove(var1);
      if (var2 != null) {
         primaryVal(var2);
      }
   }

   public synchronized void weightVal() {
      for (NodeGraphRuntime.cursorVal var2 : this.widthVal.values()) {
         primaryVal(var2);
      }

      this.widthVal.clear();
   }

   public synchronized void paramVal() {
      this.weightVal();
      this.chunkVal.close();
      this.blockRef.close();
   }

   private void extraVal() {
      while (this.widthVal.size() > 48) {
         Entry var1 = this.widthVal.entrySet().iterator().next();
         primaryVal((NodeGraphRuntime.cursorVal)var1.getValue());
         this.widthVal.remove(var1.getKey());
      }
   }

   private static void primaryVal(NodeGraphRuntime.cursorVal var0) {
      var0.primaryVal.close();
      if (!var0.marginVal.isEmpty()) {
         ThemeShaderProgramCache.primaryVal().tertiaryVal(var0.marginVal);
         var0.marginVal = "";
      }
   }

   private static NodePort secondaryVal(NodeDefinition var0) {
      if (var0 != null && !var0.paramVal().isEmpty()) {
         for (NodePort var2 : var0.paramVal()) {
            if ("color".equals(var2.id()) || "mask".equals(var2.id()) || "value".equals(var2.id())) {
               return var2;
            }
         }

         return var0.paramVal().get(0);
      } else {
         return null;
      }
   }

   private static JSONObject primaryVal(NodePort var0) {
      JSONObject var1 = new JSONObject();
      var1.put("id", var0.id());
      var1.put("label", var0.label());
      var1.put("type", var0.type().primaryVal());
      var1.put("direction", var0.direction().name().toLowerCase(Locale.ROOT));
      return var1;
   }

   private static void primaryVal(ShaderProgram var0, ShaderCompileResult var1, Map<String, float[]> var2) {
      if (var1 != null && !var1.exposedUniforms().isEmpty()) {
         for (ShaderUniformParam var4 : var1.exposedUniforms()) {
            float[] var5 = var2 == null ? null : (float[])var2.get(var4.uniformName());
            if (var5 == null) {
               var5 = var4.defaults();
            }

            if (var4.kind() == ShaderUniformParam.WildClient.FLOAT) {
               primaryVal(var0, var4.uniformName(), var5[0]);
            } else {
               primaryVal(var0, var4.uniformName(), var5[0], var5[1], var5[2], var5[3]);
            }
         }
      }
   }

   private void limitVal() {
      this.primaryVal(
         new NodeGraphRuntime.DelayedFuse(
            "template_esp_dual_pass",
            "ESP Dual-Pass Source",
            "isolated entity mask and scene depth samplers",
            "Template",
            SurfaceTarget.ESP,
            216.0F,
            List.of(),
            List.of(
               NodeGraphRuntime.AccessGuardException.output("mask", "mask", NodeGraphRuntime.FingerprintCrypto.FLOAT),
               NodeGraphRuntime.AccessGuardException.output("depth", "depth", NodeGraphRuntime.FingerprintCrypto.FLOAT),
               NodeGraphRuntime.AccessGuardException.output("uv", "uv", NodeGraphRuntime.FingerprintCrypto.VEC2)
            ),
            "uniform sampler2D uMask;\nuniform sampler2D uDepth;\n\nfloat wild_template_mask(vec2 uv) {\n    return step(0.001, texture(uMask, uv).a);\n}\n\nfloat wild_template_depth(vec2 uv) {\n    float d = texture(uDepth, uv).r;\n    float ndc = d * 2.0 - 1.0;\n    float near = 0.05;\n    float far = 1024.0;\n    return clamp((2.0 * near) / (far + near - ndc * (far - near)), 0.0, 1.0);\n}\n",
            List.of(NodeGraphRuntime.FatalErrorHandler.sampler("uMask", 6), NodeGraphRuntime.FatalErrorHandler.sampler("uDepth", 7)),
            (var0, var1, var2) -> {
               boolean var3 = var0.primaryVal() == SurfaceTarget.ESP;

               return switch (var2) {
                  case "mask" -> var3 ? "wild_template_mask(wild_diffuse_uv())" : "step(0.001, texture(u_DiffuseMap, wild_diffuse_uv()).a)";
                  case "depth" -> var3 ? "wild_template_depth(wild_diffuse_uv())" : "clamp(1.0 - texture(u_DiffuseMap, wild_diffuse_uv()).a, 0.0, 1.0)";
                  default -> "wild_diffuse_uv()";
               };
            }
         )
      );
      this.primaryVal(
         new NodeGraphRuntime.DelayedFuse(
            "template_hud_roundrect",
            "SDF RoundRect Plate",
            "per-corner rounded plate driven by uRect and uRadii",
            "Template",
            SurfaceTarget.HUD,
            224.0F,
            List.of(
               NodeGraphRuntime.AccessGuardException.input("color", "color", NodeGraphRuntime.FingerprintCrypto.VEC4, "u_ThemeColors[0]"),
               NodeGraphRuntime.AccessGuardException.input("softness", "soft", NodeGraphRuntime.FingerprintCrypto.FLOAT, "1.0")
            ),
            List.of(
               NodeGraphRuntime.AccessGuardException.output("color", "color", NodeGraphRuntime.FingerprintCrypto.VEC4),
               NodeGraphRuntime.AccessGuardException.output("mask", "distance", NodeGraphRuntime.FingerprintCrypto.FLOAT)
            ),
            "uniform vec4 uRadii;\n\nfloat wild_template_corner_pick(vec2 p, vec4 radii) {\n    float top = mix(radii.x, radii.y, step(0.0, p.x));\n    float bottom = mix(radii.w, radii.z, step(0.0, p.x));\n    return mix(top, bottom, step(0.0, p.y));\n}\n\nfloat wild_template_roundrect_distance() {\n    vec2 screenPx = vec2(gl_FragCoord.x, u_Resolution.y - gl_FragCoord.y);\n    vec2 p = screenPx - u_ElementRect.xy - u_ElementRect.zw * 0.5;\n    vec2 halfSize = max(u_ElementRect.zw * 0.5, vec2(0.5));\n    float radiiSum = uRadii.x + uRadii.y + uRadii.z + uRadii.w;\n    vec4 radii = mix(vec4(u_ElementRadius), uRadii, step(0.001, radiiSum));\n    float r = clamp(wild_template_corner_pick(p, radii), 0.0, min(halfSize.x, halfSize.y));\n    vec2 q = abs(p) - halfSize + vec2(r);\n    return length(max(q, vec2(0.0))) - r + min(max(q.x, q.y), 0.0);\n}\n\nfloat wild_template_roundrect_alpha(float d, float softness) {\n    float aa = max(fwidth(d), max(softness, 0.0001));\n    return 1.0 - smoothstep(0.0, aa, d);\n}\n",
            List.of(NodeGraphRuntime.FatalErrorHandler.vec4("uRadii", 0.0F, 0.0F, 0.0F, 0.0F)),
            (var0, var1, var2) -> {
               if (var0.secondaryVal()) {
                  return "mask".equals(var2)
                     ? "wild_template_roundrect_distance()"
                     : "vec4(("
                        + var0.primaryVal(var1, "color")
                        + ").rgb, ("
                        + var0.primaryVal(var1, "color")
                        + ").a * wild_template_roundrect_alpha(wild_template_roundrect_distance(), "
                        + var0.primaryVal(var1, "softness")
                        + "))";
               }

               String var3 = "wild_sdf_round_box(uv, vec2(0.0), vec2(0.42, 0.30), 0.08, 0.0)";
               return "mask".equals(var2)
                  ? var3
                  : "vec4((" + var0.primaryVal(var1, "color") + ").rgb, (" + var0.primaryVal(var1, "color") + ").a * wild_sdf_alpha(" + var3 + "))";
            }
         )
      );
   }

   private static void secondaryVal(NodeDefinitionRegistry var0) {
      if (var0.primaryVal("int_value") == null) {
         var0.primaryVal(
            new NodeDefinition(
               "int_value",
               "Integer",
               "Constants",
               154.0F,
               List.of(),
               List.of(NodePort.output("value", "value", UniformType.INT)),
               (var0x, var1, var2) -> String.valueOf(Math.round(var1.primaryVal("value", 1.0F)))
            )
         );
      }

      if (var0.primaryVal("int_to_float") == null) {
         var0.primaryVal(
            new NodeDefinition(
               "int_to_float",
               "Int \u2192 Float",
               "Math",
               174.0F,
               List.of(NodePort.input("i", "i", UniformType.INT, "0")),
               List.of(NodePort.output("value", "value", UniformType.FLOAT)),
               (var0x, var1, var2) -> "float(" + var0x.primaryVal(var1, "i") + ")"
            )
         );
      }

      if (var0.primaryVal("float_to_int") == null) {
         var0.primaryVal(
            new NodeDefinition(
               "float_to_int",
               "Float \u2192 Int",
               "Math",
               174.0F,
               List.of(NodePort.input("x", "x", UniformType.FLOAT, "0.0")),
               List.of(NodePort.output("value", "value", UniformType.INT)),
               (var0x, var1, var2) -> "int(floor((" + var0x.primaryVal(var1, "x") + ") + 0.5))"
            )
         );
      }
   }

   static float primaryVal(int var0, int var1) {
      return (var0 >>> var1 & 0xFF) / 255.0F;
   }

   static void primaryVal(ShaderProgram var0, String var1, float var2) {
      int var3 = var0.primaryVal(var1);
      if (var3 >= 0) {
         GL20.glUniform1f(var3, var2);
      }
   }

   private static void primaryVal(ShaderProgram var0, String var1, int var2) {
      int var3 = var0.primaryVal(var1);
      if (var3 >= 0) {
         GL20.glUniform1i(var3, var2);
      }
   }

   static void primaryVal(ShaderProgram var0, String var1, float var2, float var3) {
      int var4 = var0.primaryVal(var1);
      if (var4 >= 0) {
         GL20.glUniform2f(var4, var2, var3);
      }
   }

   private static void primaryVal(ShaderProgram var0, String var1, float var2, float var3, float var4) {
      int var5 = var0.primaryVal(var1);
      if (var5 >= 0) {
         GL20.glUniform3f(var5, var2, var3, var4);
      }
   }

   static void primaryVal(ShaderProgram var0, String var1, float var2, float var3, float var4, float var5) {
      int var6 = var0.primaryVal(var1);
      if (var6 >= 0) {
         GL20.glUniform4f(var6, var2, var3, var4, var5);
      }
   }

   public static final class WildClient implements AutoCloseable {
      private static final String primaryVal = "foundry_template_esp";
      private final DepthRenderTarget secondaryVal = new DepthRenderTarget();
      private GLStateSnapshot.Snapshot tertiaryVal;
      private boolean marginVal;

      public void primaryVal(Predicate<class_1297> var1) {
         EntityFramebufferCapture.primaryVal().primaryVal("foundry_template_esp", true, var1);
         this.marginVal = true;
      }

      public void primaryVal() {
         EntityFramebufferCapture.primaryVal().primaryVal("foundry_template_esp");
         this.marginVal = false;
      }

      public boolean secondaryVal() {
         return this.marginVal;
      }

      public boolean tertiaryVal() {
         return EntityFramebufferCapture.primaryVal().tertiaryVal();
      }

      public int marginVal() {
         EntityFramebufferCapture var1 = EntityFramebufferCapture.primaryVal();
         return var1.tertiaryVal() && var1.marginVal() > 0 ? var1.marginVal() : this.secondaryVal.secondaryVal;
      }

      public int weightVal() {
         EntityFramebufferCapture var1 = EntityFramebufferCapture.primaryVal();
         return var1.tertiaryVal() && var1.weightVal() > 0 ? var1.weightVal() : this.secondaryVal.tertiaryVal;
      }

      public int paramVal() {
         EntityFramebufferCapture var1 = EntityFramebufferCapture.primaryVal();
         return var1.tertiaryVal() && var1.weightRef() > 0 ? var1.weightRef() : this.secondaryVal.marginVal;
      }

      public int extraVal() {
         EntityFramebufferCapture var1 = EntityFramebufferCapture.primaryVal();
         return var1.tertiaryVal() && var1.bufferVal() > 0 ? var1.bufferVal() : this.secondaryVal.weightVal;
      }

      public boolean primaryVal(int var1, int var2) {
         if (var1 > 0 && var2 > 0 && this.tertiaryVal == null) {
            try {
               this.secondaryVal.primaryVal(var1, var2);
            } catch (IllegalStateException var4) {
               return false;
            }

            this.tertiaryVal = GLStateSnapshot.primaryVal();
            GL30.glBindFramebuffer(36008, GLStateSnapshot.primaryVal(this.tertiaryVal.primaryVal));
            GL30.glBindFramebuffer(36009, this.secondaryVal.primaryVal);
            GL30.glBlitFramebuffer(0, 0, var1, var2, 0, 0, var1, var2, 256, 9728);
            GL30.glBindFramebuffer(36160, this.secondaryVal.primaryVal);
            GL11.glViewport(0, 0, var1, var2);
            GL11.glDisable(3089);
            GL30.glClearBufferfv(6144, 0, NodeGraphRuntime.secondaryVal);
            GL11.glEnable(2929);
            GL11.glDepthMask(false);
            return true;
         } else {
            return false;
         }
      }

      public void limitVal() {
         if (this.tertiaryVal != null) {
            GLStateSnapshot.tertiaryVal(this.tertiaryVal);
            this.tertiaryVal = null;
         }
      }

      @Override
      public void close() {
         if (this.marginVal) {
            this.primaryVal();
         }

         this.limitVal();
         this.secondaryVal.primaryVal();
      }
   }

   public record FatalErrorHandler(String name, NodeGraphRuntime.FatalErrorHandler.WildClient kind, int textureUnit, float[] defaults) {
      public FatalErrorHandler(String name, NodeGraphRuntime.FatalErrorHandler.WildClient kind, int textureUnit, float[] defaults) {
         if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("uniform name required");
         }

         if (kind == null) {
            throw new IllegalArgumentException("uniform kind required for " + name);
         }

         defaults = defaults == null ? new float[4] : Arrays.copyOf(defaults, 4);
         this.name = name;
         this.kind = kind;
         this.textureUnit = textureUnit;
         this.defaults = defaults;
      }

      public static NodeGraphRuntime.FatalErrorHandler sampler(String var0, int var1) {
         return new NodeGraphRuntime.FatalErrorHandler(var0, NodeGraphRuntime.FatalErrorHandler.WildClient.SAMPLER2D, var1, null);
      }

      public static NodeGraphRuntime.FatalErrorHandler vec4(String var0, float var1, float var2, float var3, float var4) {
         return new NodeGraphRuntime.FatalErrorHandler(var0, NodeGraphRuntime.FatalErrorHandler.WildClient.VEC4, -1, new float[]{var1, var2, var3, var4});
      }

      public static NodeGraphRuntime.FatalErrorHandler vec2(String var0, float var1, float var2) {
         return new NodeGraphRuntime.FatalErrorHandler(var0, NodeGraphRuntime.FatalErrorHandler.WildClient.VEC2, -1, new float[]{var1, var2, 0.0F, 0.0F});
      }

      public static NodeGraphRuntime.FatalErrorHandler scalar(String var0, float var1) {
         return new NodeGraphRuntime.FatalErrorHandler(var0, NodeGraphRuntime.FatalErrorHandler.WildClient.FLOAT, -1, new float[]{var1, 0.0F, 0.0F, 0.0F});
      }

      public static NodeGraphRuntime.FatalErrorHandler integer(String var0, int var1) {
         return new NodeGraphRuntime.FatalErrorHandler(var0, NodeGraphRuntime.FatalErrorHandler.WildClient.INT, -1, new float[]{var1, 0.0F, 0.0F, 0.0F});
      }

      public enum WildClient {
         SAMPLER2D,
         VEC4,
         VEC2,
         FLOAT,
         INT;
      }
   }

   public enum FingerprintCrypto {
      VEC4("vec4", 4, ThemePalette.primaryVal(255, 61, 158, 255)),
      VEC2("vec2", 2, ThemePalette.primaryVal(177, 140, 255, 255)),
      FLOAT("float", 1, ThemePalette.primaryVal(53, 228, 255, 255)),
      INT("int", 1, ThemePalette.primaryVal(155, 255, 61, 255));

      private final String primaryVal;
      private final int secondaryVal;
      private final int tertiaryVal;

      FingerprintCrypto(String var3, int var4, int var5) {
         this.primaryVal = var3;
         this.secondaryVal = var4;
         this.tertiaryVal = var5;
      }

      public String primaryVal() {
         return this.primaryVal;
      }

      public int secondaryVal() {
         return this.secondaryVal;
      }

      public int tertiaryVal() {
         return this.tertiaryVal;
      }

      public boolean primaryVal(NodeGraphRuntime.FingerprintCrypto var1) {
         return this == var1;
      }

      public UniformType marginVal() {
         return switch (this) {
            case VEC4 -> UniformType.VEC4;
            case VEC2 -> UniformType.VEC2;
            case FLOAT -> UniformType.FLOAT;
            case INT -> UniformType.INT;
         };
      }

      public static NodeGraphRuntime.FingerprintCrypto primaryVal(UniformType var0) {
         if (var0 == null) {
            return FLOAT;
         }

         return switch (var0) {
            case VEC4 -> VEC4;
            case VEC3 -> VEC4;
            case VEC2 -> VEC2;
            case FLOAT -> FLOAT;
            case INT -> INT;
         };
      }

      public static int secondaryVal(UniformType var0) {
         if (var0 == null) {
            return FLOAT.tertiaryVal;
         }

         return switch (var0) {
            case VEC4 -> VEC4.tertiaryVal;
            case VEC3 -> ThemePalette.primaryVal(250, 176, 96, 255);
            case VEC2 -> VEC2.tertiaryVal;
            case FLOAT -> FLOAT.tertiaryVal;
            case INT -> INT.tertiaryVal;
         };
      }
   }

   public static final class VvunVVUvUNnv implements AutoCloseable {
      private ShaderProgram primaryVal;
      private boolean secondaryVal;

      public boolean primaryVal(
         float var1,
         float var2,
         float var3,
         float var4,
         float var5,
         float var6,
         float var7,
         float var8,
         int var9,
         int var10,
         float var11,
         float var12,
         int var13,
         int var14,
         float var15
      ) {
         if (!this.secondaryVal && !(var3 <= 0.0F) && !(var4 <= 0.0F) && var13 > 0 && var14 > 0 && !(var15 <= 0.001F)) {
            ShaderProgram var16 = this.primaryVal();
            FullscreenQuad var17 = ThemeShaderProgramCache.primaryVal().secondaryVal();
            if (var16 != null && var17 != null) {
               GLStateSnapshot.Snapshot var18 = GLStateSnapshot.primaryVal();

               try {
                  GL11.glViewport(0, 0, var13, var14);
                  GL11.glDisable(2929);
                  GL11.glDisable(2884);
                  GL11.glDepthMask(false);
                  GlStateManager._enableBlend();
                  GL11.glEnable(3042);
                  GL14.glBlendFuncSeparate(770, 771, 1, 771);
                  GL11.glDisable(36281);
                  var16.primaryVal();
                  NodeGraphRuntime.primaryVal(var16, "uViewport", var13, var14);
                  NodeGraphRuntime.primaryVal(var16, "uRect", var1, var2, var3, var4);
                  NodeGraphRuntime.primaryVal(var16, "uRadii", Math.max(0.0F, var5), Math.max(0.0F, var6), Math.max(0.0F, var7), Math.max(0.0F, var8));
                  NodeGraphRuntime.primaryVal(
                     var16,
                     "uTint",
                     NodeGraphRuntime.primaryVal(var9, 16),
                     NodeGraphRuntime.primaryVal(var9, 8),
                     NodeGraphRuntime.primaryVal(var9, 0),
                     NodeGraphRuntime.primaryVal(var9, 24)
                  );
                  NodeGraphRuntime.primaryVal(
                     var16,
                     "uStrokeTint",
                     NodeGraphRuntime.primaryVal(var10, 16),
                     NodeGraphRuntime.primaryVal(var10, 8),
                     NodeGraphRuntime.primaryVal(var10, 0),
                     NodeGraphRuntime.primaryVal(var10, 24)
                  );
                  NodeGraphRuntime.primaryVal(var16, "uStrokeWidth", Math.max(0.0F, var11));
                  NodeGraphRuntime.primaryVal(var16, "uSoftness", Math.max(0.0F, var12));
                  NodeGraphRuntime.primaryVal(var16, "uAlpha", var15);
                  var17.primaryVal();
                  return true;
               } finally {
                  GLStateSnapshot.tertiaryVal(var18);
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      }

      private ShaderProgram primaryVal() {
         if (this.primaryVal != null) {
            return this.primaryVal;
         }

         try {
            this.primaryVal = ShaderProgram.primaryVal("assets/wild/shaders/foundry/roundrect.vert", "assets/wild/shaders/foundry/roundrect.frag");
            return this.primaryVal;
         } catch (Throwable var2) {
            this.secondaryVal = true;
            return null;
         }
      }

      @Override
      public void close() {
         if (this.primaryVal != null) {
            this.primaryVal.secondaryVal();
            this.primaryVal = null;
         }

         this.secondaryVal = false;
      }
   }

   public record AccessGuardException(String id, String label, NodeGraphRuntime.FingerprintCrypto type, PortDirection direction, String defaultExpression) {
      public AccessGuardException(String id, String label, NodeGraphRuntime.FingerprintCrypto type, PortDirection direction, String defaultExpression) {
         if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("slot id required");
         }

         if (type != null && direction != null) {
            label = label != null && !label.isBlank() ? label : id;
            defaultExpression = defaultExpression == null ? "" : defaultExpression;
            this.id = id;
            this.label = label;
            this.type = type;
            this.direction = direction;
            this.defaultExpression = defaultExpression;
         } else {
            throw new IllegalArgumentException("slot type and direction required for " + id);
         }
      }

      public static NodeGraphRuntime.AccessGuardException input(String var0, String var1, NodeGraphRuntime.FingerprintCrypto var2, String var3) {
         return new NodeGraphRuntime.AccessGuardException(var0, var1, var2, PortDirection.INPUT, var3);
      }

      public static NodeGraphRuntime.AccessGuardException output(String var0, String var1, NodeGraphRuntime.FingerprintCrypto var2) {
         return new NodeGraphRuntime.AccessGuardException(var0, var1, var2, PortDirection.OUTPUT, "");
      }

      public NodePort toPinTemplate() {
         return new NodePort(this.id, this.label, this.type.marginVal(), this.direction, this.defaultExpression);
      }
   }

   static final class cursorVal {
      final VvNNUnNNVn primaryVal = new VvNNUnNNVn();
      ShaderCompileResult secondaryVal;
      String tertiaryVal = "";
      String marginVal = "";
      int weightVal = Integer.MIN_VALUE;
      int paramVal;
      int extraVal;
      long limitVal;
      long speedVal;
   }

   public record DelayedFuse(
      String id,
      String title,
      String description,
      String category,
      SurfaceTarget target,
      float nodeWidth,
      List<NodeGraphRuntime.AccessGuardException> inputs,
      List<NodeGraphRuntime.AccessGuardException> outputs,
      String glslPreamble,
      List<NodeGraphRuntime.FatalErrorHandler> uniforms,
      VnNnvvVUN emitter
   ) {
      public DelayedFuse(
         String id,
         String title,
         String description,
         String category,
         SurfaceTarget target,
         float nodeWidth,
         List<NodeGraphRuntime.AccessGuardException> inputs,
         List<NodeGraphRuntime.AccessGuardException> outputs,
         String glslPreamble,
         List<NodeGraphRuntime.FatalErrorHandler> uniforms,
         VnNnvvVUN emitter
      ) {
         if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("template id required");
         }

         if (target != null && emitter != null) {
            title = title != null && !title.isBlank() ? title : id;
            description = description == null ? "" : description;
            category = category != null && !category.isBlank() ? category : "Template";
            inputs = inputs == null ? List.of() : List.copyOf(inputs);
            outputs = outputs == null ? List.of() : List.copyOf(outputs);
            glslPreamble = glslPreamble == null ? "" : glslPreamble;
            uniforms = uniforms == null ? List.of() : List.copyOf(uniforms);
            this.id = id;
            this.title = title;
            this.description = description;
            this.category = category;
            this.target = target;
            this.nodeWidth = nodeWidth;
            this.inputs = inputs;
            this.outputs = outputs;
            this.glslPreamble = glslPreamble;
            this.uniforms = uniforms;
            this.emitter = emitter;
         } else {
            throw new IllegalArgumentException("template target and emitter required for " + id);
         }
      }

      public NodeDefinition toNodeDefinition() {
         ArrayList var1 = new ArrayList(this.inputs.size());

         for (NodeGraphRuntime.AccessGuardException var3 : this.inputs) {
            var1.add(var3.toPinTemplate());
         }

         ArrayList var5 = new ArrayList(this.outputs.size());

         for (NodeGraphRuntime.AccessGuardException var4 : this.outputs) {
            var5.add(var4.toPinTemplate());
         }

         return new NodeDefinition(this.id, this.title, this.category, this.nodeWidth, var1, var5, this.emitter);
      }
   }
}
