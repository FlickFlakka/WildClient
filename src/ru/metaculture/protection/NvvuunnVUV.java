/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.NamedParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class NvvuunnVUV {
    private static final byte[] primaryVal;
    private static final byte[] secondaryVal;
    private static final byte[] tertiaryVal;
    private static final String marginVal = "MCowBQYDK2VuAyEAKimzdBToBe4IjoYMuCYjJrr36rpeC+pSXoyJ9NSdR38=";
    private static final SecureRandom weightVal;

    private NvvuunnVUV() {
    }

    public static byte[] primaryVal(byte[] byArray) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("X25519");
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(marginVal)));
        return NvvuunnVUV.primaryVal(byArray, publicKey);
    }

    static byte[] primaryVal(byte[] byArray, PublicKey publicKey) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("X25519");
        keyPairGenerator.initialize(NamedParameterSpec.X25519);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        KeyAgreement keyAgreement = KeyAgreement.getInstance("X25519");
        keyAgreement.init(keyPair.getPrivate());
        keyAgreement.doPhase(publicKey, true);
        byte[] byArray2 = keyAgreement.generateSecret();
        byte[] byArray3 = NvvuunnVUV.secondaryVal(byArray2, keyPair.getPublic().getEncoded());
        byte[] byArray4 = new byte[12];
        weightVal.nextBytes(byArray4);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, (Key)new SecretKeySpec(byArray3, "AES"), new GCMParameterSpec(128, byArray4));
        byte[] byArray5 = cipher.doFinal(byArray);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(byArray5.length + 128);
        byteArrayOutputStream.writeBytes(primaryVal);
        NvvuunnVUV.primaryVal(byteArrayOutputStream, keyPair.getPublic().getEncoded().length);
        byteArrayOutputStream.writeBytes(keyPair.getPublic().getEncoded());
        byteArrayOutputStream.write(byArray4.length);
        byteArrayOutputStream.writeBytes(byArray4);
        NvvuunnVUV.secondaryVal(byteArrayOutputStream, byArray5.length);
        byteArrayOutputStream.writeBytes(byArray5);
        Arrays.fill(byArray2, (byte)0);
        Arrays.fill(byArray3, (byte)0);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] primaryVal(byte[] byArray, byte[] byArray2) throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.wrap(byArray);
        for (byte by : primaryVal) {
            if (byteBuffer.get() == by) continue;
            throw new IllegalArgumentException("bad wildsnap magic");
        }
        int n = Short.toUnsignedInt(byteBuffer.getShort());
        byte[] byArray3 = new byte[n];
        byteBuffer.get(byArray3);
        int n2 = Byte.toUnsignedInt(byteBuffer.get());
        byte[] byArray4 = new byte[n2];
        byteBuffer.get(byArray4);
        int n3 = byteBuffer.getInt();
        byte[] byArray5 = new byte[n3];
        byteBuffer.get(byArray5);
        KeyFactory keyFactory = KeyFactory.getInstance("X25519");
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(byArray3));
        PrivateKey privateKey = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(byArray2));
        KeyAgreement keyAgreement = KeyAgreement.getInstance("X25519");
        keyAgreement.init(privateKey);
        keyAgreement.doPhase(publicKey, true);
        byte[] byArray6 = keyAgreement.generateSecret();
        byte[] byArray7 = NvvuunnVUV.secondaryVal(byArray6, byArray3);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, (Key)new SecretKeySpec(byArray7, "AES"), new GCMParameterSpec(128, byArray4));
        byte[] byArray8 = cipher.doFinal(byArray5);
        Arrays.fill(byArray6, (byte)0);
        Arrays.fill(byArray7, (byte)0);
        return byArray8;
    }

    private static byte[] secondaryVal(byte[] byArray, byte[] byArray2) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(secondaryVal, "HmacSHA256"));
        byte[] byArray3 = mac.doFinal(byArray);
        mac.init(new SecretKeySpec(byArray3, "HmacSHA256"));
        mac.update(tertiaryVal);
        mac.update(byArray2);
        mac.update((byte)1);
        byte[] byArray4 = mac.doFinal();
        Arrays.fill(byArray3, (byte)0);
        return Arrays.copyOf(byArray4, 32);
    }

    private static void primaryVal(ByteArrayOutputStream byteArrayOutputStream, int n) {
        byteArrayOutputStream.write(n >>> 8 & 0xFF);
        byteArrayOutputStream.write(n & 0xFF);
    }

    private static void secondaryVal(ByteArrayOutputStream byteArrayOutputStream, int n) {
        byteArrayOutputStream.write(n >>> 24 & 0xFF);
        byteArrayOutputStream.write(n >>> 16 & 0xFF);
        byteArrayOutputStream.write(n >>> 8 & 0xFF);
        byteArrayOutputStream.write(n & 0xFF);
    }

    static {
        byte[] byArray = new byte[4];
        byArray[0] = 87;
        byArray[1] = 83;
        byArray[2] = 78;
        byArray[3] = 49;
        primaryVal = byArray;
        secondaryVal = "WildSnap-v1".getBytes(StandardCharsets.UTF_8);
        tertiaryVal = "wildsnap/aes-gcm".getBytes(StandardCharsets.UTF_8);
        weightVal = new SecureRandom();
    }
}

