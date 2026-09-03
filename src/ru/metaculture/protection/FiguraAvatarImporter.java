/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_156
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import java.io.File;
import java.lang.reflect.Method;
import net.minecraft.class_156;
import net.minecraft.class_310;
import ru.metaculture.protection.StudioAssetLibrary;

public final class FiguraAvatarImporter {
    private FiguraAvatarImporter() {
    }

    public static File primaryVal() {
        try {
            CharSequence charSequence;
            Class<?> clazz = Class.forName("org.lwjgl.util.tinyfd.TinyFileDialogs");
            Class<?> clazz2 = Class.forName("org.lwjgl.PointerBuffer");
            Method method = clazz.getMethod("tinyfd_openFileDialog", CharSequence.class, CharSequence.class, clazz2, CharSequence.class, Boolean.TYPE);
            Object[] objectArray = new Object[5];
            objectArray[0] = "Import Figura avatar";
            objectArray[1] = "";
            objectArray[2] = null;
            objectArray[3] = "Figura avatar (.zip)";
            objectArray[4] = false;
            Object object = method.invoke(null, objectArray);
            if (object instanceof CharSequence && (charSequence = (CharSequence)object).length() > 0) {
                File file = new File(charSequence.toString());
                return file.exists() ? file : null;
            }
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        return null;
    }

    public static void secondaryVal() {
        File file;
        try {
            file = StudioAssetLibrary.primaryVal().secondaryVal();
            if (!file.exists()) {
                file.mkdirs();
            }
            class_156.method_668().method_672(file);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
        class_310 class_3102 = class_310.method_1551();
        if (class_3102 != null) {
            // empty if block
        }
    }
}

