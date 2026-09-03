/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_310
 *  net.minecraft.class_412
 *  net.minecraft.class_419
 *  net.minecraft.class_437
 *  net.minecraft.class_442
 *  net.minecraft.class_500
 *  net.minecraft.class_639
 *  net.minecraft.class_642
 *  net.minecraft.class_9812
 */
package ru.metaculture.protection;

import java.util.Locale;
import net.minecraft.class_310;
import net.minecraft.class_412;
import net.minecraft.class_419;
import net.minecraft.class_437;
import net.minecraft.class_442;
import net.minecraft.class_500;
import net.minecraft.class_639;
import net.minecraft.class_642;
import net.minecraft.class_9812;
import ru.metaculture.protection.VvVVnnNNNuV;
import ru.metaculture.protection.MultiplayerScreen;
import ru.metaculture.protection.UnHookModule;

public final class ServerTransferRetryHandler {
    private static final long primaryVal = 3500L;
    private static final Object secondaryVal = new Object();
    private static volatile long tertiaryVal;
    private static volatile class_642 marginVal;
    private static volatile boolean weightVal;
    private static volatile class_642 paramVal;

    private ServerTransferRetryHandler() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal(class_642 class_6422, class_9812 class_98122) {
        class_310 class_3102;
        String string;
        if (class_98122 == null || class_98122.comp_2853() == null) {
            return;
        }
        try {
            string = ServerTransferRetryHandler.primaryVal(class_98122.comp_2853().getString());
        }
        catch (Throwable throwable) {
            return;
        }
        if (!ServerTransferRetryHandler.secondaryVal(string)) {
            return;
        }
        class_642 class_6423 = class_6422;
        if (class_6423 == null && (class_3102 = class_310.method_1551()) != null) {
            try {
                class_6423 = class_3102.method_1558();
            }
            catch (Throwable throwable) {
                class_6423 = null;
            }
        }
        if (class_6423 == null) {
            class_6423 = paramVal;
        }
        if (class_6423 == null) {
            return;
        }
        class_642 class_6424;
        try {
            class_6424 = ServerTransferRetryHandler.primaryVal(class_6423);
        }
        catch (Throwable throwable) {
            return;
        }
        Object object = secondaryVal;
        synchronized (object) {
            marginVal = class_6424;
            tertiaryVal = System.currentTimeMillis() + 3500L;
            weightVal = true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal(class_310 class_3102) {
        class_642 class_6422;
        long l;
        if (!weightVal || class_3102 == null) {
            return;
        }
        try {
            ServerTransferRetryHandler.secondaryVal(class_3102);
        }
        catch (Throwable throwable) {
        }
        if (!(class_3102.field_1755 instanceof class_419)) {
            return;
        }
        Object object = secondaryVal;
        synchronized (object) {
            if (!weightVal) {
                // MONITOREXIT @DISABLED, blocks:[1, 4, 13] lbl22 : MonitorExitStatement: MONITOREXIT : var4_3
                return;
            }
            l = tertiaryVal;
            class_6422 = marginVal;
        }
        if (System.currentTimeMillis() < l) {
            return;
        }
        if (class_3102.method_1562() != null) {
            return;
        }
        if (class_6422 == null || class_6422.field_3761 == null || class_6422.field_3761.isBlank()) {
            ServerTransferRetryHandler.primaryVal();
            return;
        }
        try {
            object = class_639.method_2950((String)class_6422.field_3761);
            class_412.method_36877((class_437)ServerTransferRetryHandler.secondaryVal(), (class_310)class_3102, (class_639)object, (class_642)class_6422, (boolean)false, null);
        }
        catch (Throwable throwable) {
        }
        finally {
            ServerTransferRetryHandler.primaryVal();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void primaryVal() {
        Object object = secondaryVal;
        synchronized (object) {
            weightVal = false;
            tertiaryVal = 0L;
            marginVal = null;
        }
    }

    public static void secondaryVal(class_310 class_3102) {
        class_642 class_6422;
        block5: {
            if (class_3102 == null) {
                return;
            }
            if (class_3102.method_1562() == null) {
                return;
            }
            class_6422 = class_3102.method_1558();
            if (class_6422 != null && class_6422.field_3761 != null && !class_6422.field_3761.isBlank()) break block5;
            return;
        }
        try {
            paramVal = ServerTransferRetryHandler.primaryVal(class_6422);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static class_642 primaryVal(class_642 class_6422) {
        class_642 class_6423 = new class_642(class_6422.field_3752, class_6422.field_3761, class_6422.method_55616());
        class_6423.method_2996(class_6422);
        return class_6423;
    }

    private static class_437 secondaryVal() {
        if (UnHookModule.depthVal) {
            return new class_500((class_437)new class_442());
        }
        return new MultiplayerScreen(new VvVVnnNNNuV());
    }

    private static String primaryVal(String string) {
        if (string == null || string.isBlank()) {
            return "";
        }
        return string.replaceAll("\u00a7.", "").replace('\u00a7', ' ').toLowerCase(Locale.ROOT).trim();
    }

    private static boolean secondaryVal(String string) {
        if (string == null) {
            return false;
        }
        return string.contains("you are switching servers too often") || string.contains("network protocol error") || string.contains("network protocol error") || string.contains("too many server transfers") || string.contains("too many moves between servers");
    }
}

