/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class SafeCloser {
    private SafeCloser() {
    }

    public static <T> VvunVVUvUNnv primaryVal(T t, Closer<T> modeVal, ClosedChecker<T> panelVal) {
        if (t == null) {
            return new VvunVVUvUNnv(true, null);
        }
        try {
            modeVal.close(t);
            return new VvunVVUvUNnv(true, null);
        }
        catch (RuntimeException runtimeException) {
            try {
                return new VvunVVUvUNnv(panelVal.isClosed(t), runtimeException);
            }
            catch (RuntimeException runtimeException2) {
                if (runtimeException2 != runtimeException) {
                    runtimeException.addSuppressed(runtimeException2);
                }
                return new VvunVVUvUNnv(false, runtimeException);
            }
        }
    }

    public record VvunVVUvUNnv(boolean released, RuntimeException failure) {
    }

    @FunctionalInterface
    public static interface Closer<T> {
        public void close(T var1);
    }

    @FunctionalInterface
    public static interface ClosedChecker<T> {
        public boolean isClosed(T var1);
    }
}

