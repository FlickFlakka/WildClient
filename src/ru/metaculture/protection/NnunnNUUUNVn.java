/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  org.apache.commons.io.FilenameUtils
 */
package ru.metaculture.protection;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FilenameUtils;
import org.wild.module.api.Module;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.ConfigFile;
import ru.metaculture.protection.UnvUUvuVNunV;
import ru.metaculture.protection.HudLayoutManager;
import ru.metaculture.protection.HudSettingsPersistence;
import ru.metaculture.sdk.Compile;
import ru.metaculture.sdk.Loader;

public final class NnunnNUUUNVn
extends UnvUUvuVNunV<ConfigFile> {
    public static final File primaryVal;
    private static final ArrayList<ConfigFile> secondaryVal;
    private static final long tertiaryVal = 350L;
    private final ScheduledExecutorService marginVal = Executors.newSingleThreadScheduledExecutor(runnable -> {
        Thread thread = new Thread(runnable, "Wild-Config-Autosave");
        thread.setDaemon(true);
        return thread;
    });
    private final Object weightVal = new Object();
    private ScheduledFuture<?> paramVal;
    private boolean extraVal;
    private boolean limitVal;

    @Compile
    private static File extraVal() {
        File file = WildClient.primaryVal != null ? WildClient.primaryVal.paramVal : WildClient.secondaryVal();
        return new File(file, "configs" + File.separator + "cfg");
    }

    public NnunnNUUUNVn() {
        if (primaryVal != null && !primaryVal.exists() && !primaryVal.mkdirs()) {
            System.out.println("[ConfigManager] Warning: cannot create config directory at " + primaryVal.getAbsolutePath());
        }
        this.primaryVal(NnunnNUUUNVn.limitVal());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Compile
    private static ArrayList<ConfigFile> limitVal() {
        ArrayList<ConfigFile> arrayList = secondaryVal;
        synchronized (arrayList) {
            File[] fileArray;
            File[] fileArray2 = fileArray = primaryVal == null ? null : primaryVal.listFiles();
            if (fileArray != null) {
                for (File file : fileArray) {
                    if (!FilenameUtils.getExtension((String)file.getName()).equals("json")) continue;
                    secondaryVal.add(new ConfigFile(FilenameUtils.removeExtension((String)file.getName())));
                }
            }
            return secondaryVal;
        }
    }

    @Compile
    public static ArrayList<ConfigFile> primaryVal() {
        return secondaryVal;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Compile
    public void secondaryVal() {
        if (primaryVal == null) {
            return;
        }
        if (!primaryVal.exists() && !primaryVal.mkdirs()) {
            System.out.println("[ConfigManager] Warning: cannot create config dir on load");
            return;
        }
        ArrayList<ConfigFile> arrayList = secondaryVal;
        synchronized (arrayList) {
            secondaryVal.clear();
            File[] fileArray = primaryVal.listFiles(File::isFile);
            if (fileArray != null) {
                for (File file : fileArray) {
                    String string = FilenameUtils.removeExtension((String)file.getName()).replace(" ", "");
                    secondaryVal.add(new ConfigFile(string));
                }
            }
        }
    }

    @Compile
    public synchronized boolean primaryVal(String string) {
        if (string == null) {
            return false;
        }
        ConfigFile coreA = this.tertiaryVal(string);
        if (coreA == null) {
            return false;
        }
        try (BufferedReader bufferedReader = Files.newBufferedReader(coreA.primaryVal().toPath(), StandardCharsets.UTF_8)) {
            JsonObject jsonObject = JsonParser.parseReader((Reader)bufferedReader).getAsJsonObject();
            return this.primaryVal(string, jsonObject);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Compile
    public synchronized boolean primaryVal(String string, JsonObject jsonObject) {
        if (string == null || jsonObject == null) {
            return false;
        }
        ConfigFile coreA = this.tertiaryVal(string);
        if (coreA == null) {
            coreA = new ConfigFile(string);
            this.paramVal().add(coreA);
        }
        coreA.primaryVal(jsonObject);
        return true;
    }

    public synchronized boolean secondaryVal(String string) {
        if (string == null) {
            return false;
        }
        ConfigFile coreA = this.tertiaryVal(string);
        if (coreA == null) {
            try {
                coreA = new ConfigFile(string);
                this.paramVal().add(coreA);
            }
            catch (Throwable throwable) {
                System.out.println("[ConfigManager] Cannot create config '" + string + "': " + throwable.getMessage());
                return false;
            }
        }
        Object object = coreA.primaryVal();
        if (object == null) {
            return false;
        }
        File file = ((File)object).getParentFile();
        if (file != null && !file.exists() && !file.mkdirs()) {
            System.out.println("[ConfigManager] Cannot create directory for '" + string + "'");
            return false;
        }
        String string2;
        try {
            string2 = new GsonBuilder().setPrettyPrinting().create().toJson((JsonElement)coreA.tertiaryVal());
        }
        catch (Throwable throwable) {
            System.out.println("[ConfigManager] Failed to serialize config '" + string + "': " + throwable.getMessage());
            return false;
        }
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(((File)object).toPath(), StandardCharsets.UTF_8, new OpenOption[0])) {
            bufferedWriter.write(string2);
            return true;
        }
        catch (IOException iOException) {
            System.out.println("[ConfigManager] I/O error saving '" + string + "': " + iOException.getMessage());
            return false;
        }
    }

    public ConfigFile tertiaryVal(String string) {
        if (string == null) {
            return null;
        }
        for (ConfigFile coreA : this.paramVal()) {
            if (!coreA.secondaryVal().equalsIgnoreCase(string)) continue;
            return coreA;
        }
        if (new File(primaryVal, string + ".json").exists()) {
            return new ConfigFile(string);
        }
        return null;
    }

    @Compile
    public boolean marginVal(String string) {
        if (string == null) {
            return false;
        }
        ConfigFile coreA = this.tertiaryVal(string);
        if (coreA == null) {
            return false;
        }
        File file = coreA.primaryVal();
        this.paramVal().remove(coreA);
        return file.exists() && file.delete();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void tertiaryVal() {
        if (WildClient.primaryVal == null || WildClient.primaryVal.holderVal == null) {
            return;
        }
        Object object = this.weightVal;
        synchronized (object) {
            if (this.limitVal) {
                return;
            }
            this.extraVal = true;
            if (this.paramVal != null) {
                this.paramVal.cancel(false);
            }
            this.paramVal = this.marginVal.schedule(this::speedVal, 350L, TimeUnit.MILLISECONDS);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void marginVal() {
        boolean bl;
        Object object = this.weightVal;
        synchronized (object) {
            if (this.limitVal) {
                return;
            }
            this.limitVal = true;
            bl = this.extraVal;
            this.extraVal = false;
            if (this.paramVal != null) {
                this.paramVal.cancel(false);
                this.paramVal = null;
            }
        }
        if (bl) {
            this.secondaryVal("default");
        }
        this.marginVal.shutdown();
        try {
            this.marginVal.awaitTermination(1L, TimeUnit.SECONDS);
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void speedVal() {
        Object object = this.weightVal;
        synchronized (object) {
            if (!this.extraVal) {
                this.paramVal = null;
                return;
            }
            this.extraVal = false;
            this.paramVal = null;
        }
        if (!this.secondaryVal("default")) {
            object = this.weightVal;
            synchronized (object) {
                if (!this.limitVal) {
                    this.extraVal = true;
                    this.paramVal = this.marginVal.schedule(this::speedVal, 350L, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    @Compile
    public boolean weightVal() {
        if (WildClient.primaryVal == null || WildClient.primaryVal.secondaryVal == null) {
            return false;
        }
        for (Module module : WildClient.primaryVal.secondaryVal.primaryVal) {
            module.resetModule();
        }
        HudLayoutManager.primaryVal().primaryVal(Map.of());
        HudSettingsPersistence.tertiaryVal();
        return this.primaryVal("default");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static /* synthetic */ boolean primaryVal(File file) {
        if (file.isDirectory()) return false;
        if (!FilenameUtils.getExtension((String)file.getName()).equals("json")) return false;
        return true;
    }

    static {
        Loader.initialize();
        primaryVal = NnunnNUUUNVn.extraVal();
        secondaryVal = new ArrayList();
    }
}

