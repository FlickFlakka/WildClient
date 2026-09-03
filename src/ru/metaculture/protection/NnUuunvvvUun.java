package ru.metaculture.protection;

import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongIterator;
import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.util.Arrays;
import java.util.Map;
import net.minecraft.class_1923;
import net.minecraft.class_2338;
import net.minecraft.class_2586;
import net.minecraft.class_2680;
import net.minecraft.class_2806;
import net.minecraft.class_2818;
import net.minecraft.class_2826;
import net.minecraft.class_3532;
import net.minecraft.class_4076;
import net.minecraft.class_638;
import net.minecraft.class_2338.class_2339;

public final class NnUuunvvvUun {
   public static final int primaryVal = 520;
   private static final long secondaryVal = 400000L;
   private static final long tertiaryVal = 2000000L;
   private static final int marginVal = 48;
   private static final int weightVal = 33;
   private static final int paramVal = 35;
   private static final int extraVal = 32768;
   private static final int limitVal = 4096;
   private static final int speedVal = 512;
   private static final int widthVal = 4000;
   private static final int chunkVal = 4352;
   private static final int blockRef = 64;
   private static final int holderVal = 8192;
   private static final int[] timerVal;
   private static final int[] anchorVal;
   private static final int[] weightRef;
   private final Long2ObjectOpenHashMap<NnUuunvvvUun.cursorVal> bufferVal = new Long2ObjectOpenHashMap();
   private final LongLinkedOpenHashSet countVal = new LongLinkedOpenHashSet();
   private final LongOpenHashSet depthVal = new LongOpenHashSet();
   private final LongOpenHashSet descRef = new LongOpenHashSet();
   private final LongOpenHashSet activeVal = new LongOpenHashSet();
   private final Object radiusVal = new Object();
   private final LongOpenHashSet factorVal = new LongOpenHashSet();
   private final LongOpenHashSet sourceVal = new LongOpenHashSet();
   private final LongOpenHashSet extraRef = new LongOpenHashSet();
   private final long[] phaseVal = new long[4352];
   private final byte[] limitRef = new byte[4352];
   private final class_2339 paramRef = new class_2339();
   private final long[] groupVal = new long[8192];
   private final byte[] layerVal = new byte[8192];
   private final int[] slotVal = new int[8192];
   private final long[] themeVal = new long[8192];
   private final byte[] stageVal = new byte[8192];
   private final int[] widthRef = new int[65];
   private final int[] trackVal = new int[65];
   private int modeRef;
   private final long[] angleVal = new long[512];
   private final byte[] heightRef = new byte[512];
   private final int[] levelVal = new int[512];
   private int UuNnnVnuNNV;
   private final NnUuunvvvUun.WildClient depthRef = new NnUuunvvvUun.WildClient();
   private int speedRef;
   private int countRef;
   private int entryVal;
   private int guardVal = Integer.MIN_VALUE;
   private int VUuuVUnun = Integer.MIN_VALUE;
   private boolean vVVuuVVv;
   private boolean VuunNUUUvu;
   private boolean NNUUNUuVNNVn;
   private boolean VvVvnNUnvuvV;
   private volatile boolean tokenVal;
   private double NUVvUUVuVNVv;
   private double nodeB;
   private int UNvvunVVn;
   private int UnvuVuVnNuvu = 33;

   public void primaryVal(int var1) {
      this.UnvuVuVnNuvu = class_3532.method_15340(var1, 1, 33);
   }

   public void primaryVal() {
      this.bufferVal.clear();
      this.bufferVal.trim();
      this.countVal.clear();
      this.countVal.trim();
      synchronized (this.radiusVal) {
         this.depthVal.clear();
         this.descRef.clear();
         this.activeVal.clear();
      }

      this.factorVal.clear();
      this.sourceVal.clear();
      this.extraRef.clear();
      this.depthRef.secondaryVal();
      this.UuNnnVnuNNV = 0;
      this.tokenVal = false;
      this.guardVal = Integer.MIN_VALUE;
      this.VUuuVUnun = Integer.MIN_VALUE;
      this.speedRef = 0;
      this.countRef = 0;
      this.VvVvnNUnvuvV = true;
      this.vVVuuVVv = true;
   }

   public void secondaryVal() {
      this.VvVvnNUnvuvV = true;
   }

   public boolean tertiaryVal() {
      boolean var1 = this.vVVuuVVv;
      this.vVVuuVVv = false;
      return var1;
   }

   public void primaryVal(int var1, int var2, int var3) {
      long var4 = class_2338.method_10064(var1, var2, var3);
      synchronized (this.radiusVal) {
         if (this.depthVal.size() >= 32768) {
            this.tokenVal = true;
         } else {
            this.depthVal.add(var4);
         }
      }
   }

   public void primaryVal(long[] var1, int var2) {
      if (var2 > 0) {
         synchronized (this.radiusVal) {
            if (this.depthVal.size() + var2 > 32768) {
               this.tokenVal = true;
            } else {
               for (int var4 = 0; var4 < var2; var4++) {
                  this.depthVal.add(var1[var4]);
               }
            }
         }
      }
   }

   public void primaryVal(int var1, int var2) {
      long var3 = class_1923.method_8331(var1, var2);
      synchronized (this.radiusVal) {
         if (this.descRef.size() >= 32768) {
            this.tokenVal = true;
         } else {
            this.descRef.add(var3);
            this.activeVal.remove(var3);
         }
      }
   }

   public void secondaryVal(int var1, int var2) {
      long var3 = class_1923.method_8331(var1, var2);
      synchronized (this.radiusVal) {
         if (this.activeVal.size() >= 32768) {
            this.tokenVal = true;
         } else {
            this.activeVal.add(var3);
            this.descRef.remove(var3);
         }
      }
   }

   public void primaryVal(class_638 var1, int var2, int var3) {
      int var4 = var1.method_32890();
      int var5 = var1.method_32891();
      if (var4 != this.countRef || var5 != this.entryVal) {
         this.countRef = var4;
         this.speedRef = Math.min(var4, 64);
         this.entryVal = var5;
         this.bufferVal.clear();
         this.countVal.clear();
         this.VvVvnNUnvuvV = true;
         this.vVVuuVVv = true;
      }

      boolean var6 = var2 != this.guardVal || var3 != this.VUuuVUnun;
      this.guardVal = var2;
      this.VUuuVUnun = var3;
      if (var6) {
         this.speedVal();
      }

      if (this.tokenVal) {
         this.tokenVal = false;
         this.VvVvnNUnvuvV = true;
      }

      if (this.VvVvnNUnvuvV) {
         this.VvVvnNUnvuvV = false;
         this.limitVal();
      }

      this.primaryVal(var1);
      this.widthVal();
      this.secondaryVal(var1);
   }

   private void limitVal() {
      int var1 = weightRef[this.UnvuVuVnNuvu];

      for (int var2 = 0; var2 < var1; var2++) {
         long var3 = class_1923.method_8331(this.guardVal + timerVal[var2], this.VUuuVUnun + anchorVal[var2]);
         NnUuunvvvUun.cursorVal var5 = (NnUuunvvvUun.cursorVal)this.bufferVal.get(var3);
         if (var5 != null) {
            var5.primaryVal = 0L;
         }

         this.countVal.add(var3);
      }
   }

   private void speedVal() {
      if (!this.bufferVal.isEmpty()) {
         LongIterator var1 = this.bufferVal.keySet().iterator();

         while (var1.hasNext()) {
            long var2 = var1.nextLong();
            if (Math.abs(class_1923.method_8325(var2) - this.guardVal) > 35 || Math.abs(class_1923.method_8332(var2) - this.VUuuVUnun) > 35) {
               NnUuunvvvUun.cursorVal var4 = (NnUuunvvvUun.cursorVal)this.bufferVal.get(var2);
               if (var4 != null && var4.secondaryVal != 0L) {
                  this.vVVuuVVv = true;
               }

               var1.remove();
               this.countVal.remove(var2);
            }
         }
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // $VF: Could not create synchronized statement, marking monitor enters and exits
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   private void primaryVal(class_638 var1) {
      long[] var2 = this.extraRef.toLongArray();
      long[] var3 = this.sourceVal.toLongArray();
      long[] var4 = this.factorVal.toLongArray();
      this.extraRef.clear();
      this.sourceVal.clear();
      this.factorVal.clear();
      int var5 = (int)this.radiusVal;
      synchronized (this.radiusVal){} // $VF: monitorenter 
      boolean var12 = false /* VF: Semaphore variable */;

      try {
         var12 = true;
         if (!this.activeVal.isEmpty()) {
            this.extraRef.addAll(this.activeVal);
            this.activeVal.clear();
         }

         if (!this.descRef.isEmpty()) {
            this.sourceVal.addAll(this.descRef);
            this.descRef.clear();
         }

         if (!this.depthVal.isEmpty()) {
            this.factorVal.addAll(this.depthVal);
            this.depthVal.clear();
         }

         // $VF: monitorexit
         var12 = false;
      } finally {
         if (var12) {
            // $VF: monitorexit
         }
      }

      for (long var8 : var2) {
         NnUuunvvvUun.cursorVal var10 = (NnUuunvvvUun.cursorVal)this.bufferVal.remove(var8);
         this.countVal.remove(var8);
         if (var10 != null && var10.secondaryVal != 0L) {
            this.vVVuuVVv = true;
         }
      }

      for (long var21 : var3) {
         NnUuunvvvUun.cursorVal var23 = (NnUuunvvvUun.cursorVal)this.bufferVal.get(var21);
         if (var23 != null) {
            var23.primaryVal = 0L;
         }

         this.countVal.addAndMoveToFirst(var21);
      }

      var5 = 0;

      for (long var9 : var4) {
         if (var5++ >= 4096) {
            this.factorVal.add(var9);
         } else {
            this.primaryVal(var1, var9);
         }
      }

      if (this.depthRef.primaryVal()) {
         this.depthRef.primaryVal(AnimationClock.primaryVal(), 4000);
      }
   }

   private void primaryVal(class_638 var1, long var2) {
      int var4 = class_2338.method_10061(var2);
      int var5 = class_2338.method_10071(var2);
      int var6 = class_2338.method_10083(var2);
      NnUuunvvvUun.cursorVal var7 = (NnUuunvvvUun.cursorVal)this.bufferVal.get(class_1923.method_8331(var4 >> 4, var6 >> 4));
      if (var7 != null) {
         int var8 = (var5 >> 4) - this.entryVal;
         if (var8 >= 0 && var8 < this.speedRef) {
            int var9 = this.primaryVal(var1, var4, var5, var6);
            LongByteMap var10 = var7.tertiaryVal == null ? null : var7.tertiaryVal[var8];
            byte var11 = var10 == null ? -1 : var10.primaryVal(var2);
            if (var11 != var9) {
               int var12 = AnimationClock.primaryVal();
               if (var9 < 0) {
                  var10.secondaryVal(var2);
                  if (var10.primaryVal() == 0) {
                     var7.secondaryVal &= ~(1L << var8);
                  }

                  this.primaryVal(var2, var11, var12);
               } else {
                  if (var7.tertiaryVal == null) {
                     var7.tertiaryVal = new LongByteMap[this.speedRef];
                  }

                  if (var10 == null) {
                     var10 = new LongByteMap();
                     var7.tertiaryVal[var8] = var10;
                  }

                  var10.primaryVal(var2, (byte)var9);
                  var7.secondaryVal |= 1L << var8;
                  this.depthRef.primaryVal(var2, var12);
               }

               this.vVVuuVVv = true;
            }
         }
      }
   }

   private int primaryVal(class_638 var1, int var2, int var3, int var4) {
      this.paramRef.method_10103(var2, var3, var4);
      class_2680 var5 = var1.method_8320(this.paramRef);
      int var6 = RegistryIdUtil.primaryVal(var5);
      if (var6 >= 0) {
         return var6;
      }

      if (!var5.method_31709()) {
         return -1;
      }

      class_2586 var7 = var1.method_8321(this.paramRef);
      return var7 == null ? -1 : RegistryIdUtil.primaryVal(var7.method_11017());
   }

   private void primaryVal(long var1, byte var3, int var4) {
      if (var3 >= 0) {
         for (int var5 = 0; var5 < this.UuNnnVnuNNV; var5++) {
            if (this.angleVal[var5] == var1) {
               this.heightRef[var5] = var3;
               this.levelVal[var5] = var4;
               return;
            }
         }

         if (this.UuNnnVnuNNV == 512) {
            System.arraycopy(this.angleVal, 1, this.angleVal, 0, 511);
            System.arraycopy(this.heightRef, 1, this.heightRef, 0, 511);
            System.arraycopy(this.levelVal, 1, this.levelVal, 0, 511);
            this.UuNnnVnuNNV--;
         }

         this.angleVal[this.UuNnnVnuNNV] = var1;
         this.heightRef[this.UuNnnVnuNNV] = var3;
         this.levelVal[this.UuNnnVnuNNV] = var4;
         this.UuNnnVnuNNV++;
      }
   }

   private void widthVal() {
      if (this.UuNnnVnuNNV != 0) {
         int var1 = AnimationClock.primaryVal();
         int var2 = 0;

         for (int var3 = 0; var3 < this.UuNnnVnuNNV; var3++) {
            if (var1 - this.levelVal[var3] <= 520) {
               this.angleVal[var2] = this.angleVal[var3];
               this.heightRef[var2] = this.heightRef[var3];
               this.levelVal[var2] = this.levelVal[var3];
               var2++;
            }
         }

         this.UuNnnVnuNNV = var2;
      }
   }

   private void secondaryVal(class_638 var1) {
      if (!this.countVal.isEmpty()) {
         long var2 = this.countVal.size() >= 48 ? 2000000L : 400000L;
         long var4 = System.nanoTime() + var2;
         int var6 = 0;

         while (!this.countVal.isEmpty()) {
            if ((++var6 & 63) == 0 && System.nanoTime() >= var4) {
               return;
            }

            long var7 = this.countVal.firstLong();
            int var9 = class_1923.method_8325(var7);
            int var10 = class_1923.method_8332(var7);
            class_2818 var11 = var1.method_2935().method_2857(var9, var10, class_2806.field_12803, false);
            if (var11 == null) {
               this.countVal.removeFirstLong();
               NnUuunvvvUun.cursorVal var12 = (NnUuunvvvUun.cursorVal)this.bufferVal.remove(var7);
               if (var12 != null && var12.secondaryVal != 0L) {
                  this.vVVuuVVv = true;
               }
            } else {
               NnUuunvvvUun.cursorVal var13 = (NnUuunvvvUun.cursorVal)this.bufferVal.get(var7);
               if (var13 == null) {
                  var13 = new NnUuunvvvUun.cursorVal();
                  var13.marginVal = AnimationClock.primaryVal();
                  this.bufferVal.put(var7, var13);
               }

               if (this.primaryVal(var11, var13, var9, var10, var4)) {
                  this.countVal.removeFirstLong();
               }

               if (System.nanoTime() >= var4) {
                  return;
               }
            }
         }
      }
   }

   private boolean primaryVal(class_2818 var1, NnUuunvvvUun.cursorVal var2, int var3, int var4, long var5) {
      class_2826[] var7 = var1.method_12006();
      int var8 = Math.min(var7.length, this.speedRef);
      long var9 = var8 >= 64 ? -1L : (1L << var8) - 1L;
      this.primaryVal(var1, var8);

      for (int var11 = 0; var11 < var8; var11++) {
         if ((var2.primaryVal & 1L << var11) == 0L) {
            this.primaryVal(var1, var7[var11], var2, var11, var3, var4);
            var2.primaryVal |= 1L << var11;
            if (System.nanoTime() >= var5) {
               break;
            }
         }
      }

      return (var2.primaryVal & var9) == var9;
   }

   private void primaryVal(class_2818 var1, int var2) {
      this.modeRef = 0;
      int var3 = Math.min(var2, 64);
      Arrays.fill(this.widthRef, 0, var3 + 1, 0);
      Map<class_2338, class_2586> var4 = var1.method_12214();
      if (!var4.isEmpty()) {
         for (class_2586 var6 : var4.values()) {
            if (this.modeRef == 8192) {
               break;
            }

            int var7 = RegistryIdUtil.primaryVal(var6.method_11017());
            if (var7 >= 0) {
               class_2338 var8 = var6.method_11016();
               int var9 = (var8.method_10264() >> 4) - this.entryVal;
               if (var9 >= 0 && var9 < var3) {
                  this.groupVal[this.modeRef] = class_2338.method_10064(var8.method_10263(), var8.method_10264(), var8.method_10260());
                  this.layerVal[this.modeRef] = (byte)var7;
                  this.slotVal[this.modeRef] = var9;
                  this.modeRef++;
                  this.widthRef[var9 + 1]++;
               }
            }
         }
      }

      for (int var10 = 0; var10 < var3; var10++) {
         this.widthRef[var10 + 1] = this.widthRef[var10 + 1] + this.widthRef[var10];
      }

      System.arraycopy(this.widthRef, 0, this.trackVal, 0, var3 + 1);

      for (int var11 = 0; var11 < this.modeRef; var11++) {
         int var12 = this.trackVal[this.slotVal[var11]]++;
         this.themeVal[var12] = this.groupVal[var11];
         this.stageVal[var12] = this.layerVal[var11];
      }
   }

   private void primaryVal(class_2818 var1, class_2826 var2, NnUuunvvvUun.cursorVal var3, int var4, int var5, int var6) {
      int var7 = 0;
      int var8 = var5 << 4;
      int var9 = var6 << 4;
      int var10 = this.entryVal + var4 << 4;
      if (var2 != null && !var2.method_38292() && var2.method_19523(RegistryIdUtil.primaryVal())) {
         for (int var11 = 0; var11 < 16; var11++) {
            for (int var12 = 0; var12 < 16; var12++) {
               for (int var13 = 0; var13 < 16; var13++) {
                  class_2680 var14 = var2.method_12254(var13, var11, var12);
                  int var15 = RegistryIdUtil.primaryVal(var14);
                  if (var15 >= 0) {
                     this.phaseVal[var7] = class_2338.method_10064(var8 + var13, var10 + var11, var9 + var12);
                     this.limitRef[var7] = (byte)var15;
                     var7++;
                  }
               }
            }
         }
      }

      if (var4 < 64) {
         int var16 = this.widthRef[var4 + 1];

         for (int var18 = this.widthRef[var4]; var18 < var16 && var7 != 4352; var18++) {
            this.phaseVal[var7] = this.themeVal[var18];
            this.limitRef[var7] = this.stageVal[var18];
            var7++;
         }
      }

      LongByteMap var17 = var3.tertiaryVal == null ? null : var3.tertiaryVal[var4];
      if (var7 == 0) {
         if (var17 != null && var17.primaryVal() != 0) {
            var17.weightVal();
            var3.secondaryVal &= ~(1L << var4);
            this.vVVuuVVv = true;
         }
      } else {
         if (var17 != null && var17.primaryVal() == var7) {
            boolean var19 = true;

            for (int var21 = 0; var21 < var7; var21++) {
               if (var17.primaryVal(this.phaseVal[var21]) != this.limitRef[var21]) {
                  var19 = false;
                  break;
               }
            }

            if (var19) {
               var3.secondaryVal |= 1L << var4;
               return;
            }
         }

         if (var3.tertiaryVal == null) {
            var3.tertiaryVal = new LongByteMap[this.speedRef];
         }

         if (var17 == null) {
            var17 = new LongByteMap();
            var3.tertiaryVal[var4] = var17;
         } else {
            var17.weightVal();
         }

         for (int var20 = 0; var20 < var7; var20++) {
            var17.primaryVal(this.phaseVal[var20], this.limitRef[var20]);
         }

         var3.secondaryVal |= 1L << var4;
         this.vVVuuVVv = true;
      }
   }

   private boolean primaryVal(long var1) {
      int var3 = class_2338.method_10061(var1);
      int var4 = class_2338.method_10071(var1);
      int var5 = class_2338.method_10083(var1);
      NnUuunvvvUun.cursorVal var6 = (NnUuunvvvUun.cursorVal)this.bufferVal.get(class_1923.method_8331(var3 >> 4, var5 >> 4));
      if (var6 != null && var6.tertiaryVal != null) {
         int var7 = (var4 >> 4) - this.entryVal;
         if (var7 >= 0 && var7 < this.speedRef) {
            LongByteMap var8 = var6.tertiaryVal[var7];
            return var8 != null && var8.primaryVal(var1) != -1;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public int primaryVal(long[] var1, byte[] var2, int[] var3, int var4, int var5, int var6, double var7, double var9, double var11, double var13) {
      this.VuunNUUUvu = false;
      this.NNUUNUuVNNVn = false;
      this.NUVvUUVuVNVv = 0.0;
      this.UNvvunVVn = 0;
      if (var4 > 0 && var5 != 0 && this.speedRef != 0 && this.guardVal != Integer.MIN_VALUE) {
         int var15 = AnimationClock.primaryVal();
         double var16 = var13 * var13;
         int var18 = 0;

         for (int var19 = 0; var19 < this.UuNnnVnuNNV && var18 < var4; var19++) {
            byte var20 = this.heightRef[var19];
            if ((var5 & 1 << var20) != 0 && var15 - this.levelVal[var19] <= 520) {
               long var21 = this.angleVal[var19];
               if (!this.primaryVal(var21) && this.primaryVal(var21, var7, var9, var11, var16)) {
                  var1[var18] = var21;
                  var2[var18] = var20;
                  var3[var18] = AnimationClock.primaryVal(this.levelVal[var19]) | 65536;
                  var18++;
                  this.UNvvunVVn++;
               }
            }
         }

         boolean var40 = (var5 & 4095) != 0;
         boolean var41 = (var5 & 4190208) != 0;
         int var42 = class_3532.method_15340((int)Math.ceil(var13 / 16.0) + 1, 1, 33);
         int var22 = class_3532.method_15340(class_4076.method_18675(class_3532.method_15357(var9)) - this.entryVal, 0, Math.max(this.speedRef - 1, 0));
         int var23 = weightRef[var42];

         for (int var24 = 0; var24 < var23; var24++) {
            if (var18 >= var4) {
               this.VuunNUUUvu = true;
               break;
            }

            int var25 = timerVal[var24];
            int var26 = anchorVal[var24];
            NnUuunvvvUun.cursorVal var27 = (NnUuunvvvUun.cursorVal)this.bufferVal
               .get(class_1923.method_8331(this.guardVal + var25, this.VUuuVUnun + var26));
            if (var27 != null && var27.secondaryVal != 0L && var27.tertiaryVal != null) {
               boolean var28 = var40 && Math.abs(var25) <= var6 && Math.abs(var26) <= var6;
               if (var41 || var28) {
                  for (int var29 = 0; var29 < this.speedRef * 2 && var18 < var4; var29++) {
                     int var30 = var29 + 1 >> 1;
                     if (var30 >= this.speedRef) {
                        break;
                     }

                     int var31 = (var29 & 1) == 0 ? var22 - var30 : var22 + var30;
                     if (var31 >= 0 && var31 < this.speedRef && (var27.secondaryVal & 1L << var31) != 0L) {
                        LongByteMap var32 = var27.tertiaryVal[var31];
                        if (var32 != null) {
                           long[] var33 = var32.tertiaryVal();
                           byte[] var34 = var32.marginVal();

                           for (int var35 = 0; var35 < var34.length; var35++) {
                              byte var36 = var34[var35];
                              if (var36 != -1 && (var5 & 1 << var36) != 0 && (var36 >= 12 || var28)) {
                                 long var37 = var33[var35];
                                 if (!this.primaryVal(var37, var7, var9, var11, var16)) {
                                    this.VuunNUUUvu = true;
                                 } else {
                                    if (var18 >= var4) {
                                       this.VuunNUUUvu = true;
                                       break;
                                    }

                                    int var39 = this.depthRef.secondaryVal(var37, var27.marginVal);
                                    var1[var18] = var37;
                                    var2[var18] = var36;
                                    if (var15 - var39 > 4000) {
                                       var3[var18] = 65535;
                                    } else {
                                       var3[var18] = AnimationClock.primaryVal(var39);
                                       this.NNUUNUuVNNVn = true;
                                    }

                                    this.NUVvUUVuVNVv = Math.max(this.NUVvUUVuVNVv, this.nodeB);
                                    var18++;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         return var18;
      } else {
         return 0;
      }
   }

   public boolean marginVal() {
      return this.VuunNUUUvu;
   }

   public boolean weightVal() {
      return this.NNUUNUuVNNVn;
   }

   public double paramVal() {
      return Math.sqrt(this.NUVvUUVuVNVv);
   }

   public int extraVal() {
      return this.UNvvunVVn;
   }

   private boolean primaryVal(long var1, double var3, double var5, double var7, double var9) {
      double var11 = class_2338.method_10061(var1) + 0.5 - var3;
      double var13 = class_2338.method_10071(var1) + 0.5 - var5;
      double var15 = class_2338.method_10083(var1) + 0.5 - var7;
      this.nodeB = var11 * var11 + var13 * var13 + var15 * var15;
      return this.nodeB <= var9;
   }

   static {
      byte var0 = 67;
      int var1 = var0 * var0;
      int[] var2 = new int[var1];
      int[] var3 = new int[var1];
      long[] var4 = new long[var1];
      int var5 = 0;

      for (int var6 = -33; var6 <= 33; var6++) {
         for (int var7 = -33; var7 <= 33; var7++) {
            var2[var5] = var6;
            var3[var5] = var7;
            int var8 = Math.max(Math.abs(var6), Math.abs(var7));
            var4[var5] = (long)var8 << 40 | (long)(var6 * var6 + var7 * var7) << 16 | var5;
            var5++;
         }
      }

      Arrays.sort(var4);
      timerVal = new int[var1];
      anchorVal = new int[var1];

      for (int var9 = 0; var9 < var1; var9++) {
         int var11 = (int)(var4[var9] & 65535L);
         timerVal[var9] = var2[var11];
         anchorVal[var9] = var3[var11];
      }

      weightRef = new int[34];
      int var10 = 0;

      for (int var12 = 0; var12 <= 33; var12++) {
         while (var10 < var1 && Math.max(Math.abs(timerVal[var10]), Math.abs(anchorVal[var10])) <= var12) {
            var10++;
         }

         weightRef[var12] = var10;
      }
   }

   static final class WildClient {
      private long[] primaryVal = new long[1024];
      private int[] secondaryVal = new int[1024];
      private boolean[] tertiaryVal = new boolean[1024];
      private int marginVal = 1023;
      private int weightVal;

      int primaryVal(long var1) {
         long var3 = var1 * -7046029254386353131L;
         var3 ^= var3 >>> 32;
         return (int)var3 & this.marginVal;
      }

      void primaryVal(long var1, int var3) {
         int var4;
         for (var4 = this.primaryVal(var1); this.tertiaryVal[var4]; var4 = var4 + 1 & this.marginVal) {
            if (this.primaryVal[var4] == var1) {
               this.secondaryVal[var4] = var3;
               return;
            }
         }

         this.tertiaryVal[var4] = true;
         this.primaryVal[var4] = var1;
         this.secondaryVal[var4] = var3;
         this.weightVal++;
      }

      int secondaryVal(long var1, int var3) {
         for (int var4 = this.primaryVal(var1); this.tertiaryVal[var4]; var4 = var4 + 1 & this.marginVal) {
            if (this.primaryVal[var4] == var1) {
               return this.secondaryVal[var4];
            }
         }

         return var3;
      }

      boolean primaryVal() {
         return this.weightVal >= this.primaryVal.length >> 1;
      }

      void primaryVal(int var1, int var2) {
         long[] var3 = this.primaryVal;
         int[] var4 = this.secondaryVal;
         boolean[] var5 = this.tertiaryVal;
         this.primaryVal = new long[var3.length];
         this.secondaryVal = new int[var3.length];
         this.tertiaryVal = new boolean[var3.length];
         this.weightVal = 0;

         for (int var6 = 0; var6 < var5.length; var6++) {
            if (var5[var6] && var1 - var4[var6] <= var2) {
               this.primaryVal(var3[var6], var4[var6]);
            }
         }
      }

      void secondaryVal() {
         Arrays.fill(this.tertiaryVal, false);
         this.weightVal = 0;
      }
   }

   static final class cursorVal {
      long primaryVal;
      long secondaryVal;
      LongByteMap[] tertiaryVal;
      int marginVal;
   }
}
