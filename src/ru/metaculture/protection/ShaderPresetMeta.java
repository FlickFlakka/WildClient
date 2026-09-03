package ru.metaculture.protection;

public final class ShaderPresetMeta {
   private final String primaryVal;
   private String secondaryVal;
   private String tertiaryVal;
   private String marginVal;
   private String weightVal;
   private String paramVal;
   private String extraVal;
   private String limitVal;
   private String speedVal;
   private long widthVal;
   private long chunkVal;
   private boolean blockRef;

   public ShaderPresetMeta(String var1, String var2, String var3, String var4, long var5) {
      this(var1, var2, var3, var4, "", "", "Custom", "user", "saved", var5, var5, false);
   }

   public ShaderPresetMeta(String var1, String var2, String var3, String var4, String var5, String var6, String var7, long var8, long var10, boolean var12) {
      this(var1, var2, var3, var4, var5, var6, var7, "user", "saved", var8, var10, var12);
   }

   public ShaderPresetMeta(
      String var1,
      String var2,
      String var3,
      String var4,
      String var5,
      String var6,
      String var7,
      String var8,
      String var9,
      long var10,
      long var12,
      boolean var14
   ) {
      this.primaryVal = var1;
      this.secondaryVal = var2;
      this.tertiaryVal = var3;
      this.marginVal = var4;
      this.weightVal = var5 == null ? "" : var5;
      this.paramVal = var6 == null ? "" : var6;
      this.extraVal = var7 != null && !var7.isBlank() ? var7 : "Custom";
      this.limitVal = var8 != null && !var8.isBlank() ? var8 : "user";
      this.speedVal = var9 != null && !var9.isBlank() ? var9 : "saved";
      this.widthVal = var10;
      this.chunkVal = var12;
      this.blockRef = var14;
   }

   public String primaryVal() {
      return this.primaryVal;
   }

   public String secondaryVal() {
      return this.secondaryVal;
   }

   public void primaryVal(String var1) {
      if (var1 != null && !var1.isBlank()) {
         this.secondaryVal = var1;
      }
   }

   public String tertiaryVal() {
      return this.tertiaryVal;
   }

   public void secondaryVal(String var1) {
      this.tertiaryVal = var1;
   }

   public String marginVal() {
      return this.marginVal;
   }

   public void tertiaryVal(String var1) {
      this.marginVal = var1;
   }

   public String weightVal() {
      return this.weightVal;
   }

   public void marginVal(String var1) {
      this.weightVal = var1 == null ? "" : var1;
   }

   public String paramVal() {
      return this.paramVal;
   }

   public void weightVal(String var1) {
      this.paramVal = var1 == null ? "" : var1;
   }

   public String extraVal() {
      return this.extraVal;
   }

   public void paramVal(String var1) {
      this.extraVal = var1 != null && !var1.isBlank() ? var1 : "Custom";
   }

   public String limitVal() {
      return this.limitVal;
   }

   public void extraVal(String var1) {
      this.limitVal = var1 != null && !var1.isBlank() ? var1 : "user";
   }

   public String speedVal() {
      return this.speedVal;
   }

   public void limitVal(String var1) {
      this.speedVal = var1 != null && !var1.isBlank() ? var1 : "saved";
   }

   public long widthVal() {
      return this.widthVal;
   }

   public void primaryVal(long var1) {
      this.widthVal = var1;
   }

   public long chunkVal() {
      return this.chunkVal;
   }

   public void secondaryVal(long var1) {
      this.chunkVal = var1;
   }

   public boolean blockRef() {
      return this.blockRef;
   }

   public void primaryVal(boolean var1) {
      this.blockRef = var1;
   }
}
