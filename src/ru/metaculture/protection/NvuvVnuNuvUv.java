/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  net.minecraft.class_2535
 *  net.minecraft.class_2547
 *  net.minecraft.class_2561
 *  net.minecraft.class_2596
 *  net.minecraft.class_2803
 *  net.minecraft.class_2817
 *  net.minecraft.class_2896
 *  net.minecraft.class_2899
 *  net.minecraft.class_2901
 *  net.minecraft.class_2905
 *  net.minecraft.class_2907
 *  net.minecraft.class_2909
 *  net.minecraft.class_2913
 *  net.minecraft.class_2917
 *  net.minecraft.class_310
 *  net.minecraft.class_3515
 *  net.minecraft.class_7648
 *  net.minecraft.class_7701
 *  net.minecraft.class_7756
 *  net.minecraft.class_8593
 *  net.minecraft.class_8675
 *  net.minecraft.class_8709
 *  net.minecraft.class_8710
 *  net.minecraft.class_9088
 *  net.minecraft.class_9091
 *  net.minecraft.class_9157
 *  net.minecraft.class_9782
 *  net.minecraft.class_9812
 *  net.minecraft.client.ClientBrandRetriever
 */
package ru.metaculture.protection;

import com.mojang.authlib.GameProfile;
import java.math.BigInteger;
import java.security.Key;
import java.security.PublicKey;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import net.minecraft.class_2535;
import net.minecraft.class_2547;
import net.minecraft.class_2561;
import net.minecraft.class_2596;
import net.minecraft.class_2803;
import net.minecraft.class_2817;
import net.minecraft.class_2896;
import net.minecraft.class_2899;
import net.minecraft.class_2901;
import net.minecraft.class_2905;
import net.minecraft.class_2907;
import net.minecraft.class_2909;
import net.minecraft.class_2913;
import net.minecraft.class_2917;
import net.minecraft.class_310;
import net.minecraft.class_3515;
import net.minecraft.class_7648;
import net.minecraft.class_7701;
import net.minecraft.class_7756;
import net.minecraft.class_8593;
import net.minecraft.class_8675;
import net.minecraft.class_8709;
import net.minecraft.class_8710;
import net.minecraft.class_9088;
import net.minecraft.class_9091;
import net.minecraft.class_9157;
import net.minecraft.class_9782;
import net.minecraft.class_9812;
import net.minecraft.client.ClientBrandRetriever;
import ru.metaculture.protection.BotConnector;
import ru.metaculture.protection.HeadlessBotHostManager;
import ru.metaculture.protection.BotConfigNetworkHandler;
import ru.metaculture.protection.HeadlessBotSession;

public final class NvuvVnuNuvUv
implements class_2896 {
    private final class_310 primaryVal = class_310.method_1551();
    private final class_2535 secondaryVal;
    private final HeadlessBotSession tertiaryVal;

    public NvuvVnuNuvUv(class_2535 class_25352, HeadlessBotSession vUNVNUnuv2) {
        this.secondaryVal = class_25352;
        this.tertiaryVal = vUNVNUnuv2;
    }

    public void method_12587(class_2905 class_29052) {
        class_2917 class_29172;
        Cipher cipher;
        Cipher cipher2;
        if (!HeadlessBotHostManager.weightVal(this.tertiaryVal)) {
            HeadlessBotHostManager.tertiaryVal(this.tertiaryVal);
            return;
        }
        if (class_29052.method_56013()) {
            String string = "Online-mode authentication is not supported for bot sessions";
            HeadlessBotHostManager.primaryVal(this.tertiaryVal, string);
            BotConnector.primaryVal(this.tertiaryVal, "\u00a7c" + string);
            this.secondaryVal.method_10747((class_2561)class_2561.method_43470((String)"Wild bots support offline-mode servers only (online-mode auth requires a per-account session)"));
            return;
        }
        try {
            SecretKey secretKey = class_3515.method_15239();
            PublicKey publicKey = class_29052.method_12611();
            new BigInteger(class_3515.method_15240((String)class_29052.method_12610(), (PublicKey)publicKey, (SecretKey)secretKey)).toString(16);
            cipher2 = class_3515.method_15235((int)2, (Key)secretKey);
            cipher = class_3515.method_15235((int)1, (Key)secretKey);
            class_29172 = new class_2917(secretKey, publicKey, class_29052.method_12613());
        }
        catch (Exception exception) {
            HeadlessBotHostManager.primaryVal(this.tertiaryVal, "Login protocol error: " + exception.getClass().getSimpleName());
            throw new IllegalStateException("Protocol error", exception);
        }
        this.secondaryVal.method_10752((class_2596)class_29172, class_7648.method_45084(() -> this.secondaryVal.method_10746(cipher2, cipher)));
    }

    public void method_12588(class_2901 class_29012) {
        if (!HeadlessBotHostManager.weightVal(this.tertiaryVal)) {
            HeadlessBotHostManager.tertiaryVal(this.tertiaryVal);
            return;
        }
        HeadlessBotHostManager.primaryVal(this.tertiaryVal, HeadlessBotHostManager.cursorVal.CONFIGURING, "Configuring session ...");
        GameProfile gameProfile = class_29012.comp_2363();
        class_8675 class_86752 = new class_8675(gameProfile, this.primaryVal.method_47601().method_47706(false, null, null), class_7756.method_45738().method_45926(), class_7701.field_40183, null, null, null, Map.of(), null, Map.of(), class_9782.field_51977);
        this.secondaryVal.method_56330(class_9157.field_48699, new BotConfigNetworkHandler(this.primaryVal, this.secondaryVal, class_86752, this.tertiaryVal));
        this.secondaryVal.method_10743((class_2596)class_8593.field_48252);
        this.secondaryVal.method_56329(class_9157.field_48698);
        this.secondaryVal.method_10743((class_2596)new class_2817((class_8710)new class_8709(ClientBrandRetriever.getClientModName())));
        this.secondaryVal.method_10743((class_2596)new class_2803(this.primaryVal.field_1690.method_53842()));
    }

    public void method_12584(class_2909 class_29092) {
        HeadlessBotHostManager.primaryVal(this.tertiaryVal, "Login rejected: " + class_29092.comp_4195().getString());
        this.secondaryVal.method_10747(class_29092.comp_4195());
    }

    public void method_12585(class_2907 class_29072) {
        if (!this.secondaryVal.method_10756()) {
            this.secondaryVal.method_10760(class_29072.method_12634(), false);
        }
    }

    public void method_12586(class_2899 class_28992) {
        this.secondaryVal.method_10743((class_2596)new class_2913(class_28992.comp_1567(), null));
    }

    public void method_55845(class_9088 class_90882) {
        this.secondaryVal.method_10743((class_2596)new class_9091(class_90882.comp_2194(), null));
    }

    public void method_10839(class_9812 class_98122) {
        String string = "login disconnected: " + class_98122.comp_2853().getString();
        HeadlessBotHostManager.primaryVal(this.tertiaryVal, string);
        BotConnector.primaryVal(this.tertiaryVal, "\u00a7c" + string);
        HeadlessBotHostManager.tertiaryVal(this.tertiaryVal);
    }

    public boolean method_48106() {
        return this.secondaryVal.method_10758();
    }
}

