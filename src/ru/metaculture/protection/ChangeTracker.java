package ru.metaculture.protection;

public final class ChangeTracker {
   private long primaryVal;
   private long secondaryVal;
   private boolean tertiaryVal;

   public synchronized void primaryVal() {
      this.primaryVal++;
      this.tertiaryVal = false;
   }

   public synchronized void secondaryVal() {
      this.secondaryVal = this.primaryVal;
      this.tertiaryVal = true;
   }

   public synchronized boolean tertiaryVal() {
      boolean var1 = this.tertiaryVal && this.secondaryVal == this.primaryVal;
      this.tertiaryVal = false;
      return var1;
   }

   public synchronized void marginVal() {
      this.tertiaryVal = false;
   }
}
