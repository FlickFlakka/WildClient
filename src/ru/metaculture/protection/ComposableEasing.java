/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

@FunctionalInterface
public interface ComposableEasing {
    public float ease(float var1);

    public static ComposableEasing primaryVal() {
        return f -> f;
    }

    default public ComposableEasing primaryVal(ComposableEasing duneG) {
        if (duneG == null) {
            return this;
        }
        return f -> duneG.ease(this.ease(f));
    }
}

