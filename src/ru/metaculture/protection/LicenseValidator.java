/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 */
package ru.metaculture.protection;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.lang.invoke.MethodHandle;
import java.lang.runtime.ObjectMethods;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import ru.metaculture.protection.NuvUnNnV;
import ru.metaculture.protection.HwidUtils;

public final class LicenseValidator {
    private static final long primaryVal = Long.getLong("wild.license.cacheTtlMs", 30000L) * 1000000L;
    private static volatile WildClient secondaryVal;

    private LicenseValidator() {
    }

    public static boolean primaryVal() {
        WildClient modeVal;
        long l = System.nanoTime();
        long l2 = NuvUnNnV.tertiaryVal();
        WildClient nodeC = secondaryVal;
        if (!(nodeC == null || l - nodeC.checkedAtNano > primaryVal || nodeC.valid && l2 >= nodeC.validUntil)) {
            return nodeC.valid;
        }
        secondaryVal = modeVal = LicenseValidator.primaryVal(l, l2);
        return modeVal.valid;
    }

    public static boolean secondaryVal() {
        WildClient modeVal;
        long l = System.nanoTime();
        long l2 = NuvUnNnV.tertiaryVal();
        WildClient nodeC = secondaryVal;
        if (nodeC != null && l - nodeC.checkedAtNano <= primaryVal) {
            return nodeC.fileMissing;
        }
        secondaryVal = modeVal = LicenseValidator.primaryVal(l, l2);
        return modeVal.fileMissing;
    }

    private static WildClient primaryVal(long l, long l2) {
        Path path;
        long l3 = 0L;
        try {
            path = LicenseValidator.tertiaryVal();
        }
        catch (Throwable throwable) {
            return new WildClient(false, l3, l, true);
        }
        if (path == null || !Files.exists(path, new LinkOption[0])) {
            return new WildClient(false, l3, l, true);
        }
        try {
            String string;
            JsonObject jsonObject = LicenseValidator.primaryVal(path);
            String string2 = jsonObject.get("payload").getAsString();
            String string3 = jsonObject.get("signature").getAsString();
            byte[] byArray = Base64.getUrlDecoder().decode(string2);
            byte[] byArray2 = Base64.getUrlDecoder().decode(string3);
            if (!LicenseValidator.primaryVal(byArray, byArray2, LicenseValidator.marginVal())) {
                return new WildClient(false, l3, l, false);
            }
            JsonObject jsonObject2 = JsonParser.parseString((String)new String(byArray, StandardCharsets.UTF_8)).getAsJsonObject();
            long l4 = l3 = jsonObject2.has("validUntil") ? jsonObject2.get("validUntil").getAsLong() : 0L;
            if (l3 <= l2) {
                return new WildClient(false, l3, l, false);
            }
            String string4 = string = jsonObject2.has("hwidHash") ? jsonObject2.get("hwidHash").getAsString() : "";
            if (string.isBlank()) {
                return new WildClient(false, l3, l, false);
            }
            if (!HwidUtils.primaryVal(string)) {
                return new WildClient(false, l3, l, false);
            }
            return new WildClient(true, l3, l, false);
        }
        catch (Throwable throwable) {
            return new WildClient(false, l3, l, false);
        }
    }

    private static JsonObject primaryVal(Path path) throws Exception {
        String string = Files.readString(path, StandardCharsets.UTF_8);
        return JsonParser.parseString((String)string).getAsJsonObject();
    }

    private static Path tertiaryVal() {
        String string = System.getProperty("wild.license.path");
        if (string != null && !string.isBlank()) {
            return Path.of(string, new String[0]);
        }
        String string2 = System.getenv("WILD_LICENSE_PATH");
        if (string2 != null && !string2.isBlank()) {
            return Path.of(string2, new String[0]);
        }
        String string3 = System.getenv("APPDATA");
        if (string3 != null && !string3.isBlank()) {
            String[] stringArray = new String[2];
            stringArray[0] = "WildClient";
            stringArray[1] = "license.json";
            Path path = Path.of(string3, stringArray);
            if (Files.exists(path, new LinkOption[0])) {
                return path;
            }
        }
        return Path.of(System.getProperty("user.home", "."), ".wildclient", "license.json");
    }

    private static PublicKey marginVal() throws Exception {
        String string = "-----BEGIN PUBLIC KEY-----\nMCowBQYDK2VwAyEAgqu9hOrz4JQKl2izQlnpj+d8jkT988LVfYfXPvKyt2Y=\n-----END PUBLIC KEY-----\n".replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "").replaceAll("\\s+", "");
        byte[] byArray = Base64.getDecoder().decode(string);
        return KeyFactory.getInstance("Ed25519").generatePublic(new X509EncodedKeySpec(byArray));
    }

    private static boolean primaryVal(byte[] byArray, byte[] byArray2, PublicKey publicKey) throws Exception {
        Signature signature = Signature.getInstance("Ed25519");
        signature.initVerify(publicKey);
        signature.update(byArray);
        return signature.verify(byArray2);
    }

    static final class WildClient
     {
        final boolean valid;
        final long validUntil;
        final long checkedAtNano;
        final boolean fileMissing;

        WildClient(boolean bl, long l, long l2, boolean bl2) {
            this.valid = bl;
            this.validUntil = l;
            this.checkedAtNano = l2;
            this.fileMissing = bl2;
        }

        @Override
        public final String toString() {
            return "WildClient[" + "valid=" + this.valid + ", " + "validUntil=" + this.validUntil + ", " + "checkedAtNano=" + this.checkedAtNano + ", " + "fileMissing=" + this.fileMissing + "]";
            }

        @Override
        public final int hashCode() {
            return java.util.Objects.hash(this.valid, this.validUntil, this.checkedAtNano, this.fileMissing);}

        @Override
        public final boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }
            WildClient that = (WildClient)object;
            return java.util.Objects.equals(this.valid, that.valid) && java.util.Objects.equals(this.validUntil, that.validUntil) && java.util.Objects.equals(this.checkedAtNano, that.checkedAtNano) && java.util.Objects.equals(this.fileMissing, that.fileMissing);}

        public boolean valid() {
            return this.valid;
        }

        public long validUntil() {
            return this.validUntil;
        }

        public long checkedAtNano() {
            return this.checkedAtNano;
        }

        public boolean fileMissing() {
            return this.fileMissing;
        }
    }
}

