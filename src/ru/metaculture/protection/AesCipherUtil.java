/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AesCipherUtil {
    public static final String primaryVal = "AES";
    public static final String secondaryVal = "gUhDvBzdE4xq5f4BxkPvxv70VY44WsuH1O6s2nZ2F9U1w9y1VVG1mXQcUfbJM2DDUCd8NvtM0L4O1t1nn8FwwAVYlChNncdagiv9UR8FpLXXF8iMAtlWY4mEnYtLHPB3";

    public static String primaryVal(String string, String string2) throws Exception {
        Cipher cipher = Cipher.getInstance(primaryVal);
        cipher.init(1, new SecretKeySpec(AesCipherUtil.primaryVal(string2), primaryVal));
        return Base64.getEncoder().encodeToString(cipher.doFinal(string.getBytes(StandardCharsets.UTF_8)));
    }

    public static String secondaryVal(String string, String string2) throws Exception {
        Cipher cipher = Cipher.getInstance(primaryVal);
        cipher.init(2, new SecretKeySpec(AesCipherUtil.primaryVal(string2), primaryVal));
        return new String(cipher.doFinal(Base64.getDecoder().decode(string)), StandardCharsets.UTF_8);
    }

    public static byte[] primaryVal(String string) throws Exception {
        return MessageDigest.getInstance("SHA-256").digest(string.getBytes(StandardCharsets.UTF_8));
    }

    private AesCipherUtil() {
    }
}

