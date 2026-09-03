/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

public final class FingerprintCrypto {
    public static final String primaryVal = "server-key-1";
    static final int secondaryVal = 446;
    private static final String marginVal = "-----BEGIN PUBLIC KEY-----\nMIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEA0QoLnE+hVCxsFnkwpKOD\nDOho6OoakoXkVlWMTSBRFzPJJkeFdiw++SfdW0YJtQIZuekmf5eZGqZTLXKBI8Jq\ngk/pX6qGmNeARjF2V5W1isT2xTxAAS5LefbWTDTuT2vLtdL5lcG3KZa3PnAoiaA3\n2E8gyE/ME/7LEI6lZXhmVIPMLBWyOdB4O9QBks1iX8tDbwQNTG30UIjYWAq9ZoeF\nkGe0amY9snhTEnhI+NvqCT486uOhVLsSQeggDgjj5jEAwJicUxVwALnJRDRn+rfJ\n4vPUpaYik12tIIbu4jEH5KVieWtMvY4or0Q9RxlMzBhbf0s6nElcAXY2cmocl8LK\niPCHhiaKyG1wEcbTFA+YqW/f6iEzi3Me5eSb/WAhpcFLRJi0H17cgBbINr4S3+DF\nLCEXVNEr33WKncrauNvsa0nwBQIfjJBS3DfKODRg11cvT1NWJxFP1MoVJzxxXoHk\nJGLMEuKPGYbC5IdidWV5+iGfxOoUzhKppDauntDRCqqS4F9eS0DsuQ1Z04x8Z/YG\nUq+2eFbrA/k3H8SLz4me8D9XH6fQJlGcpzZnhP7/2jKOuptfxWpnukL8Ysi7xF5+\n7htZciGCZpZ1DXxYpnNjxIYGzD9aKNpXWAUeZqXtvzvBjDcl/UGdMyPWeJlCfXZg\noJwlnWSm4E/mdVe0DS8V/PkCAwEAAQ==\n-----END PUBLIC KEY-----";
    public static final boolean tertiaryVal = FingerprintCrypto.tertiaryVal();
    private static volatile PublicKey weightVal;

    private FingerprintCrypto() {
    }

    public static WildClient primaryVal(String string) {
        byte[] byArray = string.getBytes(StandardCharsets.UTF_8);
        if (byArray.length > 446) {
            throw new DelayedFuse(byArray.length, 446);
        }
        byte[] byArray2 = FingerprintCrypto.primaryVal(byArray, FingerprintCrypto.secondaryVal());
        String string2 = Base64.getUrlEncoder().withoutPadding().encodeToString(byArray2);
        return new WildClient(1, primaryVal, string2, System.currentTimeMillis() / 1000L, UUID.randomUUID().toString());
    }

    public static void primaryVal() {
        WildClient modeVal;
        boolean bl;
        if (!tertiaryVal) {
            return;
        }
        String string = "FAKE-SMBIOS|FAKE-DISK|FAKE-BOARD|FAKE-CPU|FAKE-DEVICE";
        System.out.println("[FingerprintCrypto] \u2500\u2500 self-test \u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
        try {
            FingerprintCrypto.secondaryVal();
            bl = true;
        }
        catch (Exception exception) {
            boolean bl2 = false;
            System.out.println("[FingerprintCrypto] RSA public key loaded: false \u2014 " + exception.getMessage());
            System.out.println("[FingerprintCrypto] \u2500\u2500 self-test FAILED \u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
            return;
        }
        System.out.println("[FingerprintCrypto] RSA public key loaded: " + bl);
        System.out.println("[FingerprintCrypto] RSA algorithm: RSA-OAEP-SHA256");
        try {
            modeVal = FingerprintCrypto.primaryVal(string);
        }
        catch (Exception exception) {
            System.out.println("[FingerprintCrypto] encrypt() FAILED \u2014 " + exception.getMessage());
            System.out.println("[FingerprintCrypto] \u2500\u2500 self-test FAILED \u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
            return;
        }
        System.out.println("[FingerprintCrypto] encryptedPayload length: " + modeVal.encryptedPayload().length());
        System.out.println("[FingerprintCrypto] requestId:               " + modeVal.requestId());
        System.out.println("[FingerprintCrypto] timestamp:               " + modeVal.timestamp());
        Object[] objectArray = new Object[5];
        objectArray[0] = modeVal.v();
        objectArray[1] = modeVal.kid();
        objectArray[2] = modeVal.encryptedPayload().substring(0, Math.min(24, modeVal.encryptedPayload().length()));
        objectArray[3] = modeVal.timestamp();
        objectArray[4] = modeVal.requestId();
        System.out.printf("[FingerprintCrypto] DTO preview: {\"v\":%d,\"kid\":\"%s\",\"encryptedPayload\":\"%s...\",\"timestamp\":%d,\"requestId\":\"%s\"}%n", objectArray);
        System.out.println("[FingerprintCrypto] \u2500\u2500 self-test OK \u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static PublicKey secondaryVal() {
        PublicKey publicKey = weightVal;
        if (publicKey != null) {
            return publicKey;
        }
        Class<FingerprintCrypto> clazz = FingerprintCrypto.class;
        synchronized (FingerprintCrypto.class) {
            publicKey = weightVal;
            if (publicKey != null) {
                // ** MonitorExit[var1_1] (shouldn't be in output)
                return publicKey;
            }
            weightVal = FingerprintCrypto.secondaryVal(marginVal);
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return weightVal;
        }
    }

    private static PublicKey secondaryVal(String string) {
        byte[] byArray;
        String string2 = string.replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s+", "");
        try {
            byArray = Base64.getDecoder().decode(string2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new VvunVVUvUNnv("PEM contains invalid Base64", illegalArgumentException);
        }
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(byArray));
        }
        catch (Exception exception) {
            throw new VvunVVUvUNnv("Cannot parse RSA-4096 public key: " + exception.getMessage(), exception);
        }
    }

    private static byte[] primaryVal(byte[] byArray, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPPadding");
            OAEPParameterSpec oAEPParameterSpec = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
            cipher.init(1, (Key)publicKey, oAEPParameterSpec);
            return cipher.doFinal(byArray);
        }
        catch (Exception exception) {
            throw new cursorVal("RSA-OAEP-SHA256 encryption failed: " + exception.getMessage(), exception);
        }
    }

    private static boolean tertiaryVal() {
        String string = System.getProperty("wild.crypto.selftest");
        if (string != null) {
            return Boolean.parseBoolean(string.trim());
        }
        return "true".equalsIgnoreCase(System.getenv("WILD_CRYPTO_SELFTEST"));
    }

    public static final class DelayedFuse
    extends RuntimeException {
        public DelayedFuse(int n, int n2) {
            super("Payload too large for RSA-4096-OAEP-SHA256: " + n + " bytes (max " + n2 + ")");
        }
    }

    public record WildClient(int v, String kid, String encryptedPayload, long timestamp, String requestId) {
    }

    public static final class VvunVVUvUNnv
    extends RuntimeException {
        public VvunVVUvUNnv(String string, Throwable throwable) {
            super(string, throwable);
        }
    }

    public static final class cursorVal
    extends RuntimeException {
        public cursorVal(String string, Throwable throwable) {
            super(string, throwable);
        }
    }
}

