/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.BufferUtils
 */
package ru.metaculture.protection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import org.lwjgl.BufferUtils;

public final class UvnUNnnVnu {
    private UvnUNnnVnu() {
    }

    /*
     * Enabled aggressive exception aggregation
     */
    public static String primaryVal(String string) {
        ClassLoader classLoader = UvnUNnnVnu.class.getClassLoader();
        String string2 = UvnUNnnVnu.tertiaryVal(string);
        try (InputStream inputStream = classLoader.getResourceAsStream(string2);){
            String string3;
            if (inputStream == null) {
                throw new IllegalStateException("Resource not found: " + string);
            }
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));){
                String string4;
                StringBuilder stringBuilder = new StringBuilder();
                while ((string4 = bufferedReader.readLine()) != null) {
                    stringBuilder.append(string4).append('\n');
                }
                string3 = stringBuilder.toString();
            }
            return string3;
        }
        catch (IOException iOException) {
            throw new RuntimeException("Failed to read resource: " + string, iOException);
        }
    }

    public static ByteBuffer secondaryVal(String string) {
        ClassLoader classLoader = UvnUNnnVnu.class.getClassLoader();
        String string2 = UvnUNnnVnu.tertiaryVal(string);
        try (InputStream inputStream = classLoader.getResourceAsStream(string2)) {
            if (inputStream == null) {
                throw new IllegalStateException("Resource not found: " + string);
            }
            byte[] byArray = inputStream.readAllBytes();
            ByteBuffer byteBuffer2 = BufferUtils.createByteBuffer((int)byArray.length);
            byteBuffer2.put(byArray).flip();
            return byteBuffer2;
        }
        catch (IOException iOException) {
            throw new RuntimeException("Failed to read resource: " + string, iOException);
        }
    }

    private static String tertiaryVal(String string) {
        if (string == null) {
            throw new IllegalArgumentException("path");
        }
        return string.startsWith("/") ? string.substring(1) : string;
    }
}

