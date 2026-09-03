/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package ru.metaculture.protection;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.util.Locale;
import lombok.Generated;

public final class NvnvUnUnnuvV {
    private static boolean primaryVal = false;

    public static native void primaryVal();

    public static native void secondaryVal();

    public static native void tertiaryVal();

    public static native void primaryVal(long var0);

    @Generated
    public static boolean marginVal() {
        return primaryVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static {
        block0: {
            if (!System.getProperty("os.name", "").toLowerCase(Locale.ROOT).contains("win")) break block0;
            Path path = null;
            try {
                path = Files.createTempFile("wild_media_controller", ".dll", new FileAttribute[0]);
                try (InputStream inputStream = NvnvUnUnnuvV.class.getResourceAsStream("/assets/wild/natives/MediaController.dll");){
                    if (inputStream != null) {
                        Files.copy(inputStream, path, StandardCopyOption.REPLACE_EXISTING);
                        System.load(path.toAbsolutePath().toString());
                        primaryVal = true;
                    }
                    if (inputStream == null) break block0;
                }
            }
            catch (Exception | UnsatisfiedLinkError throwable) {
                primaryVal = false;
            }
            finally {
                if (path != null) {
                    path.toFile().deleteOnExit();
                }
            }
        }
    }
}

