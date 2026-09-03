/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_243
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587$class_4665
 *  net.minecraft.class_4588
 *  org.joml.Matrix3f
 *  org.joml.Matrix3fc
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Vector3f
 */
package ru.metaculture.protection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import net.minecraft.class_243;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import org.joml.Matrix3f;
import org.joml.Matrix3fc;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import ru.metaculture.protection.WorldRenderContext;
import ru.metaculture.protection.VvUNvVNnuUNU;

public final class WorldGeometryBuilder {
    private static final float primaryVal = 1.0E-6f;
    private final class_4184 secondaryVal;
    private final Matrix4f tertiaryVal;
    private final Matrix3f marginVal;
    private final class_4588 weightVal;
    private final class_243 paramVal;

    public WorldGeometryBuilder(WorldRenderContext vUVnuvunnvuV, class_4587.class_4665 class_46652, class_4588 class_45882) {
        this(Objects.requireNonNull(vUVnuvunnvuV, "renderer").primaryVal(), class_46652, class_45882);
    }

    public WorldGeometryBuilder(class_4184 class_41842, class_4587.class_4665 class_46652, class_4588 class_45882) {
        this.secondaryVal = Objects.requireNonNull(class_41842, "camera");
        Objects.requireNonNull(class_46652, "entry");
        this.weightVal = Objects.requireNonNull(class_45882, "consumer");
        this.paramVal = this.secondaryVal.method_19326();
        this.tertiaryVal = new Matrix4f((Matrix4fc)class_46652.method_23761());
        this.marginVal = new Matrix3f((Matrix3fc)class_46652.method_23762());
    }

    public void primaryVal(class_243 class_2432, class_243 class_2433, class_243 class_2434, class_243 class_2435, int n) {
        this.primaryVal(class_2432, class_2433, class_2434, class_2435, n, n, n, n);
    }

    public void primaryVal(class_243 class_2432, class_243 class_2433, class_243 class_2434, class_243 class_2435, int n, int n2, int n3, int n4) {
        Objects.requireNonNull(class_2432, "v0");
        Objects.requireNonNull(class_2433, "v1");
        Objects.requireNonNull(class_2434, "v2");
        Objects.requireNonNull(class_2435, "v3");
        this.primaryVal(class_2432, n);
        this.primaryVal(class_2433, n2);
        this.primaryVal(class_2434, n3);
        this.primaryVal(class_2435, n4);
    }

    public void primaryVal(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, int n) {
        this.primaryVal(new class_243(d, d2, d3), new class_243(d4, d5, d6), new class_243(d7, d8, d9), new class_243(d10, d11, d12), n);
    }

    public void primaryVal(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n) {
        this.primaryVal(new class_243(d, d2, d3), new class_243(d4, d5, d6), new class_243(d7, d8, d9), new class_243(d10, d11, d12), f, f2, f3, f4, f5, f6, f7, f8, n);
    }

    public void primaryVal(class_243 class_2432, class_243 class_2433, int n) {
        block3: {
            block2: {
                Objects.requireNonNull(class_2432, "min");
                Objects.requireNonNull(class_2433, "max");
                if (class_2432.field_1352 > class_2433.field_1352 || class_2432.field_1351 > class_2433.field_1351) break block2;
                if (!(class_2432.field_1350 > class_2433.field_1350)) break block3;
            }
            throw new IllegalArgumentException("Minimum corner must be less than or equal to maximum corner.");
        }
        class_243 class_2434 = new class_243(class_2432.field_1352, class_2432.field_1351, class_2432.field_1350);
        class_243 class_2435 = new class_243(class_2432.field_1352, class_2432.field_1351, class_2433.field_1350);
        class_243 class_2436 = new class_243(class_2432.field_1352, class_2433.field_1351, class_2432.field_1350);
        class_243 class_2437 = new class_243(class_2432.field_1352, class_2433.field_1351, class_2433.field_1350);
        class_243 class_2438 = new class_243(class_2433.field_1352, class_2432.field_1351, class_2432.field_1350);
        class_243 class_2439 = new class_243(class_2433.field_1352, class_2432.field_1351, class_2433.field_1350);
        class_243 class_24310 = new class_243(class_2433.field_1352, class_2433.field_1351, class_2432.field_1350);
        class_243 class_24311 = new class_243(class_2433.field_1352, class_2433.field_1351, class_2433.field_1350);
        this.primaryVal(class_2434, class_2438, class_24310, class_2436, n);
        this.primaryVal(class_2435, class_2437, class_24311, class_2439, n);
        this.primaryVal(class_2434, class_2435, class_2439, class_2438, n);
        this.primaryVal(class_2436, class_24310, class_24311, class_2437, n);
        this.primaryVal(class_2434, class_2436, class_2437, class_2435, n);
        this.primaryVal(class_2438, class_2439, class_24311, class_24310, n);
    }

    public void secondaryVal(class_243 class_2432, class_243 class_2433, int n) {
        this.primaryVal(class_2432, class_2433, n, n);
    }

    public void primaryVal(class_243 class_2432, class_243 class_2433, int n, int n2) {
        Objects.requireNonNull(class_2432, "start");
        Objects.requireNonNull(class_2433, "end");
        Vector3f vector3f = this.primaryVal(class_2432, class_2433);
        this.primaryVal(class_2432, n, vector3f);
        this.primaryVal(class_2433, n2, vector3f);
    }

    public void primaryVal(class_243 class_2432, class_243 class_2433, class_243 class_2434, class_243 class_2435, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n) {
        this.primaryVal(class_2432, class_2433, class_2434, class_2435, f, f2, f3, f4, f5, f6, f7, f8, n, n, n, n);
    }

    public void primaryVal(class_243 class_2432, class_243 class_2433, class_243 class_2434, class_243 class_2435, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n, int n2, int n3, int n4) {
        Objects.requireNonNull(class_2432, "v0");
        Objects.requireNonNull(class_2433, "v1");
        Objects.requireNonNull(class_2434, "v2");
        Objects.requireNonNull(class_2435, "v3");
        this.primaryVal(class_2432, f, f2, n);
        this.primaryVal(class_2433, f3, f4, n2);
        this.primaryVal(class_2434, f5, f6, n3);
        this.primaryVal(class_2435, f7, f8, n4);
    }

    private void primaryVal(class_243 class_2432, int n) {
        class_243 class_2433 = this.primaryVal(class_2432);
        class_4588 class_45882 = this.weightVal.method_22918(this.tertiaryVal, (float)class_2433.field_1352, (float)class_2433.field_1351, (float)class_2433.field_1350);
        class_45882.method_1336(VvUNvVNnuUNU.secondaryVal(n), VvUNvVNnuUNU.tertiaryVal(n), VvUNvVNnuUNU.marginVal(n), VvUNvVNnuUNU.primaryVal(n));
        this.primaryVal(class_45882);
    }

    private void primaryVal(class_243 class_2432, float f, float f2, int n) {
        class_243 class_2433 = this.primaryVal(class_2432);
        class_4588 class_45882 = this.weightVal.method_22918(this.tertiaryVal, (float)class_2433.field_1352, (float)class_2433.field_1351, (float)class_2433.field_1350);
        class_45882.method_22913(f, f2);
        class_45882.method_1336(VvUNvVNnuUNU.secondaryVal(n), VvUNvVNnuUNU.tertiaryVal(n), VvUNvVNnuUNU.marginVal(n), VvUNvVNnuUNU.primaryVal(n));
        this.primaryVal(class_45882);
    }

    private void primaryVal(class_243 class_2432, int n, Vector3f vector3f) {
        class_243 class_2433 = this.primaryVal(class_2432);
        class_4588 class_45882 = this.weightVal.method_22918(this.tertiaryVal, (float)class_2433.field_1352, (float)class_2433.field_1351, (float)class_2433.field_1350);
        class_45882.method_1336(VvUNvVNnuUNU.secondaryVal(n), VvUNvVNnuUNU.tertiaryVal(n), VvUNvVNnuUNU.marginVal(n), VvUNvVNnuUNU.primaryVal(n));
        class_45882.method_22914(vector3f.x, vector3f.y, vector3f.z);
        this.primaryVal(class_45882);
    }

    private void primaryVal(class_4588 class_45882) {
        Objects.requireNonNull(class_45882, "vertex");
        try {
            Method method = class_45882.getClass().getMethod("next", new Class[0]);
            method.invoke((Object)class_45882, new Object[0]);
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new IllegalStateException("Unable to access vertex finalization method", illegalAccessException);
        }
        catch (InvocationTargetException invocationTargetException) {
            Throwable throwable = invocationTargetException.getCause();
            if (throwable instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException)throwable;
                throw runtimeException;
            }
            if (throwable instanceof Error) {
                Error error = (Error)throwable;
                throw error;
            }
            throw new IllegalStateException("Vertex finalization failed", throwable);
        }
    }

    private class_243 primaryVal(class_243 class_2432) {
        return class_2432.method_1020(this.paramVal);
    }

    private Vector3f primaryVal(class_243 class_2432, class_243 class_2433) {
        class_243 class_2434 = class_2433.method_1020(class_2432);
        Vector3f vector3f = new Vector3f((float)class_2434.field_1352, (float)class_2434.field_1351, (float)class_2434.field_1350);
        if (vector3f.lengthSquared() <= 1.0E-6f) {
            vector3f.set(0.0f, 1.0f, 0.0f);
        }
        vector3f.normalize();
        this.marginVal.transform(vector3f);
        if (vector3f.lengthSquared() <= 1.0E-6f) {
            vector3f.set(0.0f, 1.0f, 0.0f);
        }
        vector3f.normalize();
        return vector3f;
    }
}

