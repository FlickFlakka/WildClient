/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 */
package ru.metaculture.protection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import ru.metaculture.protection.OcOOo0COoCoc;

public final class FontMetricsCache {
    private static final Gson blockRef = new GsonBuilder().create();
    public int primaryVal;
    public int secondaryVal;
    public int tertiaryVal;
    public float marginVal;
    public float weightVal;
    public float paramVal;
    public float extraVal;
    public float limitVal;
    public OcOOo0COoCoc speedVal;
    public float[][] widthVal;
    public float[][] chunkVal;

    public FontMetricsCache() {
    }

    public FontMetricsCache(int n, int n2, int n3, OcOOo0COoCoc ocOOo0COoCoc, float[][] fArray, float[][] fArray2) {
        this.primaryVal = n;
        this.secondaryVal = n2;
        this.tertiaryVal = n3;
        this.speedVal = ocOOo0COoCoc;
        this.widthVal = fArray;
        this.chunkVal = fArray2;
    }

    public boolean primaryVal(int n, int n2) {
        return this.speedVal != null && this.speedVal.primaryVal(n, n2) && this.primaryVal == n && this.secondaryVal == n2 && this.widthVal != null && this.chunkVal != null;
    }

    public float secondaryVal(int n, int n2) {
        return FontMetricsCache.primaryVal(this.widthVal, n, n2);
    }

    public float tertiaryVal(int n, int n2) {
        return FontMetricsCache.primaryVal(this.chunkVal, n, n2);
    }

    public int primaryVal(int n) {
        if (this.widthVal == null || n < 0 || n >= this.widthVal.length || this.widthVal[n] == null) {
            return 0;
        }
        return this.widthVal[n].length;
    }

    private static float primaryVal(float[][] fArray, int n, int n2) {
        if (fArray == null || n < 0 || n >= fArray.length) {
            return 0.0f;
        }
        float[] fArray2 = fArray[n];
        if (fArray2 == null || fArray2.length == 0) {
            return 0.0f;
        }
        return fArray2[Math.floorMod(n2, fArray2.length)];
    }

    public boolean primaryVal(Path path) {
        try {
            Files.createDirectories(path.getParent(), new FileAttribute[0]);
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardCharsets.UTF_8, new OpenOption[0]);){
                blockRef.toJson((Object)this, (Appendable)bufferedWriter);
            }
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public static FontMetricsCache secondaryVal(Path path) {
        if (!Files.isRegularFile(path, new LinkOption[0])) {
            return null;
        }
        try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            return (FontMetricsCache)blockRef.fromJson((Reader)bufferedReader, FontMetricsCache.class);
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}

