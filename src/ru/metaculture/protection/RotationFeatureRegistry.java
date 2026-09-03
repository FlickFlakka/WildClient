package ru.metaculture.protection;

import java.util.HashMap;

public final class RotationFeatureRegistry extends HashMap<Class<? extends RotationFeature>, RotationFeature> {
   public void primaryVal() {
      this.primaryVal(new MouseLookOverride(), new RotationController(), new InteractAckGate(), new RotationDebugLogger());
      this.values().forEach(var0 -> EventManager.register(var0));
   }

   public void primaryVal(RotationFeature... var1) {
      for (RotationFeature var5 : var1) {
         this.put((Class<? extends RotationFeature>)var5.getClass(), var5);
      }
   }

   public void secondaryVal(RotationFeature... var1) {
      for (RotationFeature var5 : var1) {
         EventManager.unregister(var5);
         this.remove(var5.getClass());
      }
   }

   public <T extends RotationFeature> T primaryVal(Class<T> var1) {
      return this.values().stream().filter(var1x -> var1x.getClass() == var1).map(var1::cast).findFirst().orElse(null);
   }
}
