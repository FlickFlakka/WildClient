package ru.metaculture.protection;

public final class AccessGuardException extends RuntimeException {
   public AccessGuardException() {
      super((String)null);
   }

   public AccessGuardException(String var1) {
      super(var1 != null && !var1.isBlank() ? var1 : null);
   }
}
