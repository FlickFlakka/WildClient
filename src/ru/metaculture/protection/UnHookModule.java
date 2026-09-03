/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  net.minecraft.class_310
 */
package ru.metaculture.protection;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Generated;
import net.minecraft.class_310;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.WildClient;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.RequiresRole;

@RequiresRole(tertiaryVal={"lichoday"})
@ModuleRegister(primaryVal="UnHook", tertiaryVal=ModuleCategory.Misc, secondaryVal="Safe client hiding, restore with Ctrl + Right Shift or type your login in chat.")
public class UnHookModule
extends Module {
    public final String countVal = System.getProperty("user.home") + "/AppData/Roaming/.tlauncher/legacy/Minecraft/game/";
    private static String activeVal = "1";
    public static boolean depthVal = false;
    public static File descRef;
    private final List<Module> radiusVal = new ArrayList<Module>();

    public UnHookModule() {
        this.addSettings(new Setting[0]);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        depthVal = true;
        WildClient.primaryVal.secondaryVal(true);
        String string = this.countVal;
        if (string != null && !string.isEmpty()) {
            descRef = new File(string, "resourcepacks");
        }
        this.radiusVal.clear();
        for (Module module : WildClient.primaryVal.blockRef().secondaryVal()) {
            if (module == this || !module.enabled) continue;
            this.radiusVal.add(module);
            module.setEnabled(false);
        }
        this.holderVal();
        this.timerVal();
        if (UnHookModule.mc.field_1705 != null) {
            String string3 = WildClient.primaryVal.paramRef();
            UnHookModule.mc.field_1705.method_1743().method_1809().removeIf(string2 -> {
                if (string2.startsWith(string3)) return true;
                if (!string2.startsWith("#")) return false;
                return true;
            });
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        depthVal = false;
        WildClient.primaryVal.speedVal = false;
        Iterator<Module> iterator = this.radiusVal.iterator();
        while (iterator.hasNext()) {
            Module module = iterator.next();
            if (module.enabled) continue;
            module.setEnabled(true);
        }
        this.radiusVal.clear();
    }

    private void holderVal() {
        Path path;
        block4: {
            path = UnHookModule.mc.method_1551().field_1697.toPath().resolve("logs/latest.log");
            if (Files.exists(path, new LinkOption[0])) break block4;
            return;
        }
        try {
            String string2 = this.countVal;
            Path path2 = Paths.get(string2, "logs");
            Path path3 = path2.resolve("latest.log");
            if (!Files.exists(path2, new LinkOption[0])) {
                Files.createDirectories(path2, new FileAttribute[0]);
            }
            List<String> list = Files.readAllLines(path, StandardCharsets.UTF_8);
            List list2 = list.stream().filter(string -> !string.contains("Wild \u00bb")).filter(string -> !string.contains("[Wild]")).filter(string -> !string.contains("[Config]")).filter(string -> !string.contains("[Manager]")).filter(string -> !string.contains("[Baritone]")).filter(string -> !string.contains("baritone")).filter(string -> !string.contains("- wild")).filter(string -> !string.contains("Mod wild")).filter(string -> !string.contains("wild_mixins")).filter(string -> !string.contains("wild:")).filter(string -> !string.contains("wild/")).filter(string -> !string.contains("assets/wild")).filter(string -> !string.contains("org.wild")).filter(string -> !string.contains("org/wild")).filter(string -> !string.contains("[Client]")).filter(string -> !string.contains("[ConfigManager]")).filter(string -> !string.contains("[EventManager]")).filter(string -> !string.contains("[SoundUtil]")).filter(string -> !string.contains("[WildGuard]")).filter(string -> !string.contains("[FingerprintCrypto]")).filter(string -> !string.contains("Wild-")).filter(string -> !string.contains("Logs sanitized")).filter(string -> !string.contains("ScreenRenderDiagnostics")).filter(string -> !string.contains("[ScreenRender]")).filter(string -> !string.contains("Stardust")).filter(string -> !string.contains("Reloading ResourceManager")).filter(string -> !string.contains("black_icons")).collect(Collectors.toList());
            Files.write(path3, list2, StandardCharsets.UTF_8, new OpenOption[0]);
            File file = path3.toFile();
            long l = System.currentTimeMillis();
            file.setLastModified(l - 3600000L);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void timerVal() {
        try {
            String string = class_310.method_1551().field_1697.getAbsolutePath().replace("\\", "\\\\");
            String string2 = "*FunTime*;*Wild*;*Execution*;*baritone*;*bariton*";
            File file = File.createTempFile("sys_cleaner_v2", ".ps1");
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("$baritoneDir = \"" + string + "\\\\baritone\"");
            arrayList.add("if (Test-Path $baritoneDir) {");
            arrayList.add("    Remove-Item -Path $baritoneDir -Recurse -Force -ErrorAction SilentlyContinue");
            arrayList.add("}");
            arrayList.add("$everythingIni = \"$env:APPDATA\\Everything\\Everything.ini\"");
            arrayList.add("if (Test-Path $everythingIni) {");
            arrayList.add("    $content = Get-Content $everythingIni");
            arrayList.add("    $foldersToAdd = \"" + string + ";" + string2 + "\"");
            arrayList.add("    if ($content -match \"exclude_folders=(.*)\") {");
            arrayList.add("        $current = $matches[1]");
            arrayList.add("        if ($current -notlike \"*$foldersToAdd*\") {");
            arrayList.add("            $newExcludes = if ($current) { \"$current;$foldersToAdd\" } else { $foldersToAdd }");
            arrayList.add("            $content = $content -replace \"exclude_folders=.*\", \"exclude_folders=$newExcludes\"");
            arrayList.add("        }");
            arrayList.add("    }");
            arrayList.add("    $filesToAdd = \"" + string2 + "\"");
            arrayList.add("    if ($content -match \"exclude_files=(.*)\") {");
            arrayList.add("        $currentFiles = $matches[1]");
            arrayList.add("        if ($currentFiles -notlike \"*$filesToAdd*\") {");
            arrayList.add("            $newFileExcludes = if ($currentFiles) { \"$currentFiles;$filesToAdd\" } else { $filesToAdd }");
            arrayList.add("            $content = $content -replace \"exclude_files=.*\", \"exclude_files=$newFileExcludes\"");
            arrayList.add("        }");
            arrayList.add("    }");
            arrayList.add("    $content | Set-Content $everythingIni");
            arrayList.add("    Stop-Process -Name \"Everything\" -Force -ErrorAction SilentlyContinue");
            arrayList.add("    Start-Process \"Everything.exe\" -WindowStyle Hidden -ErrorAction SilentlyContinue");
            arrayList.add("}");
            arrayList.add("Remove-Item \"$env:APPDATA\\Microsoft\\Windows\\Recent\\*FunTime*\" -Force -ErrorAction SilentlyContinue");
            arrayList.add("Remove-Item \"$env:APPDATA\\Microsoft\\Windows\\Recent\\*Wild*\" -Force -ErrorAction SilentlyContinue");
            arrayList.add("Remove-Item \"$env:APPDATA\\Microsoft\\Windows\\Recent\\*Execution*\" -Force -ErrorAction SilentlyContinue");
            arrayList.add("Remove-Item \"$env:APPDATA\\Microsoft\\Windows\\Recent\\*bariton*\" -Force -ErrorAction SilentlyContinue");
            arrayList.add("$rbPath = \"$env:SystemDrive\\`$Recycle.Bin\"");
            arrayList.add("$sidFolders = @()");
            arrayList.add("if (Test-Path $rbPath) { $sidFolders = Get-ChildItem -Path $rbPath -Force -Directory -ErrorAction SilentlyContinue }");
            arrayList.add("Clear-RecycleBin -Force -ErrorAction SilentlyContinue");
            arrayList.add("Start-Sleep -Milliseconds 1500");
            arrayList.add("$targetTime = (Get-Date).AddHours(-1)");
            arrayList.add("if ($sidFolders) {");
            arrayList.add("    foreach ($folder in $sidFolders) {");
            arrayList.add("        try {");
            arrayList.add("            $fItem = Get-Item -Path $folder.FullName -Force -ErrorAction Stop");
            arrayList.add("            $fItem.LastWriteTime = $targetTime");
            arrayList.add("            $fItem.LastAccessTime = $targetTime");
            arrayList.add("        } catch {}");
            arrayList.add("    }");
            arrayList.add("}");
            Files.write(file.toPath(), arrayList, StandardCharsets.UTF_8, new OpenOption[0]);
            String string3 = "powershell.exe -WindowStyle Hidden -ExecutionPolicy Bypass -File \"" + file.getAbsolutePath() + "\"";
            Runtime.getRuntime().exec(string3);
            file.deleteOnExit();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Generated
    public static String blockRef() {
        return activeVal;
    }
}

