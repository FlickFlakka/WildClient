/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1921
 *  net.minecraft.class_243
 *  net.minecraft.class_310
 *  net.minecraft.class_4184
 *  net.minecraft.class_4587
 *  net.minecraft.class_4588
 *  net.minecraft.class_4597
 *  net.minecraft.class_4597$class_4598
 *  net.minecraft.class_9779
 *  net.minecraft.class_9799
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 */
package ru.metaculture.protection;

import java.util.Objects;
import net.minecraft.class_1921;
import net.minecraft.class_243;
import net.minecraft.class_310;
import net.minecraft.class_4184;
import net.minecraft.class_4587;
import net.minecraft.class_4588;
import net.minecraft.class_4597;
import net.minecraft.class_9779;
import net.minecraft.class_9799;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import ru.metaculture.protection.WildRenderLayers;
import ru.metaculture.protection.WorldGeometryBuilder;

public final class WorldRenderContext
implements AutoCloseable {
    private static final int primaryVal = 262144;
    private static final class_9799 secondaryVal = new class_9799(262144);
    private static final class_4597.class_4598 tertiaryVal = class_4597.method_22991((class_9799)secondaryVal);
    private final class_4184 marginVal;
    private final class_4587 weightVal;
    private final Matrix4f paramVal;
    private final Matrix4f extraVal;
    private final Matrix4f limitVal;
    private final class_9799 speedVal;
    private final class_4597.class_4598 widthVal;
    private final float chunkVal;
    private boolean blockRef;

    private WorldRenderContext(class_4184 class_41842, class_4587 class_45872, Matrix4f matrix4f, Matrix4f matrix4f2, Matrix4f matrix4f3, class_9799 class_97992, class_4597.class_4598 class_45982, float f) {
        this.marginVal = class_41842;
        this.weightVal = class_45872;
        this.paramVal = matrix4f;
        this.extraVal = matrix4f2;
        this.limitVal = matrix4f3;
        this.speedVal = class_97992;
        this.widthVal = class_45982;
        this.chunkVal = f;
    }

    public static WorldRenderContext primaryVal(class_310 class_3102, class_9779 class_97792, class_4184 class_41842, Matrix4f matrix4f, Matrix4f matrix4f2) {
        Objects.requireNonNull(class_3102, "client");
        Objects.requireNonNull(class_97792, "tickCounter");
        Objects.requireNonNull(class_41842, "camera");
        Objects.requireNonNull(matrix4f, "positionMatrix");
        Objects.requireNonNull(matrix4f2, "projectionMatrix");
        class_4587 class_45872 = new class_4587();
        Matrix4f matrix4f3 = new Matrix4f((Matrix4fc)matrix4f);
        Matrix4f matrix4f4 = new Matrix4f((Matrix4fc)matrix4f3);
        class_45872.method_34425((Matrix4fc)new Matrix4f((Matrix4fc)matrix4f3));
        secondaryVal.method_60809();
        class_9799 class_97992 = secondaryVal;
        class_4597.class_4598 class_45982 = tertiaryVal;
        float f = class_97792.method_60637(false);
        return new WorldRenderContext(class_41842, class_45872, matrix4f3, matrix4f4, new Matrix4f((Matrix4fc)matrix4f2), class_97992, class_45982, f);
    }

    public class_4184 primaryVal() {
        return this.marginVal;
    }

    public class_4587 secondaryVal() {
        return this.weightVal;
    }

    public Matrix4f tertiaryVal() {
        return new Matrix4f((Matrix4fc)this.paramVal);
    }

    public Matrix4f marginVal() {
        return new Matrix4f((Matrix4fc)this.extraVal);
    }

    public Matrix4f weightVal() {
        return new Matrix4f((Matrix4fc)this.limitVal);
    }

    public float paramVal() {
        return this.chunkVal;
    }

    public class_4597.class_4598 extraVal() {
        if (this.blockRef) {
            throw new IllegalStateException("Cannot access buffers after the world renderer has been closed.");
        }
        return this.widthVal;
    }

    public class_4588 primaryVal(class_1921 class_19212) {
        Objects.requireNonNull(class_19212, "layer");
        if (this.blockRef) {
            throw new IllegalStateException("Cannot request buffers after the world renderer has been closed.");
        }
        return this.widthVal.getBuffer(class_19212);
    }

    public void primaryVal(class_243 class_2432, class_243 class_2433, class_243 class_2434, class_243 class_2435, int n, boolean bl) {
        Objects.requireNonNull(class_2432, "v0");
        Objects.requireNonNull(class_2433, "v1");
        Objects.requireNonNull(class_2434, "v2");
        Objects.requireNonNull(class_2435, "v3");
        class_1921 class_19212 = bl ? WildRenderLayers.primaryVal() : WildRenderLayers.secondaryVal();
        WorldGeometryBuilder cellC = new WorldGeometryBuilder(this, this.weightVal.method_23760(), this.primaryVal(class_19212));
        cellC.primaryVal(class_2432, class_2433, class_2434, class_2435, n);
    }

    public void primaryVal(class_243 class_2432, class_243 class_2433, class_243 class_2434, class_243 class_2435, int n, int n2, int n3, int n4) {
        this.primaryVal(class_2432, class_2433, class_2434, class_2435, n, n2, n3, n4, true);
    }

    public void primaryVal(class_243 class_2432, class_243 class_2433, class_243 class_2434, class_243 class_2435, int n, int n2, int n3, int n4, boolean bl) {
        Objects.requireNonNull(class_2432, "v0");
        Objects.requireNonNull(class_2433, "v1");
        Objects.requireNonNull(class_2434, "v2");
        Objects.requireNonNull(class_2435, "v3");
        class_1921 class_19212 = bl ? WildRenderLayers.marginVal() : WildRenderLayers.weightVal();
        WorldGeometryBuilder cellC = new WorldGeometryBuilder(this, this.weightVal.method_23760(), this.primaryVal(class_19212));
        cellC.primaryVal(class_2432, class_2433, class_2434, class_2435, n, n2, n3, n4);
    }

    public void primaryVal(class_243 class_2432, class_243 class_2433, int n, boolean bl) {
        Objects.requireNonNull(class_2432, "min");
        Objects.requireNonNull(class_2433, "max");
        class_1921 class_19212 = bl ? WildRenderLayers.primaryVal() : WildRenderLayers.tertiaryVal();
        WorldGeometryBuilder cellC = new WorldGeometryBuilder(this, this.weightVal.method_23760(), this.primaryVal(class_19212));
        cellC.primaryVal(class_2432, class_2433, n);
    }

    public void primaryVal(class_243 class_2432, class_243 class_2433, double d, int n, boolean bl) {
        Objects.requireNonNull(class_2432, "start");
        Objects.requireNonNull(class_2433, "end");
        if (!Double.isFinite(d)) {
            throw new IllegalArgumentException("Line width must be finite.");
        }
        if (d < 0.0) {
            throw new IllegalArgumentException("Line width cannot be negative.");
        }
        class_1921 class_19212 = bl ? WildRenderLayers.primaryVal(d) : WildRenderLayers.secondaryVal(d);
        WorldGeometryBuilder cellC = new WorldGeometryBuilder(this, this.weightVal.method_23760(), this.primaryVal(class_19212));
        cellC.secondaryVal(class_2432, class_2433, n);
    }

    public void primaryVal(class_243 class_2432, class_243 class_2433, class_243 class_2434, class_243 class_2435, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, int n) {
        Objects.requireNonNull(class_2432, "v0");
        Objects.requireNonNull(class_2433, "v1");
        Objects.requireNonNull(class_2434, "v2");
        Objects.requireNonNull(class_2435, "v3");
        class_1921 class_19212 = WildRenderLayers.paramVal();
        WorldGeometryBuilder cellC = new WorldGeometryBuilder(this, this.weightVal.method_23760(), this.primaryVal(class_19212));
        cellC.primaryVal(class_2432, class_2433, class_2434, class_2435, f, f2, f3, f4, f5, f6, f7, f8, n);
    }

    public void limitVal() {
        if (this.blockRef) {
            return;
        }
        this.widthVal.method_22993();
    }

    @Override
    public void close() {
        if (this.blockRef) {
            return;
        }
        this.blockRef = true;
        this.widthVal.method_22993();
        this.speedVal.method_60809();
    }
}

