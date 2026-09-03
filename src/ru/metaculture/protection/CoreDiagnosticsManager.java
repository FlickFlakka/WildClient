/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.logging.LogUtils
 *  net.minecraft.class_156
 *  net.minecraft.class_310
 *  org.slf4j.Logger
 */
package ru.metaculture.protection;

import com.mojang.logging.LogUtils;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Locale;
import net.minecraft.class_156;
import net.minecraft.class_310;
import org.slf4j.Logger;
import ru.metaculture.protection.RingLogBuffer;
import ru.metaculture.protection.GlDiagnosticCode;
import ru.metaculture.protection.DiagnosticCodeSource;
import ru.metaculture.protection.GlDiagnostics;
import ru.metaculture.protection.UnUnVNnvnV;
import ru.metaculture.protection.MatrixDiagnostics;
import ru.metaculture.protection.ProgressReporter;
import ru.metaculture.protection.ShaderFailureFormatter;
import ru.metaculture.protection.DebugSnapshotWriter;
import ru.metaculture.protection.FnvHasher;

public final class CoreDiagnosticsManager {
    private static final CoreDiagnosticsManager primaryVal = new CoreDiagnosticsManager();
    private static final long secondaryVal = 2400000000L;
    private static final long tertiaryVal = 250000000L;
    private static final long marginVal = 100000000L;
    private static final int weightVal = 65536;
    private static final Logger paramVal = LogUtils.getLogger();
    private final FnvHasher extraVal = new FnvHasher();
    private final ProgressReporter limitVal = new ProgressReporter();
    private final RingLogBuffer speedVal = new RingLogBuffer();
    private final DebugSnapshotWriter widthVal = new DebugSnapshotWriter();
    private long chunkVal;
    private long blockRef;
    private long holderVal;
    private long timerVal = -1L;
    private long anchorVal = -1L;
    private boolean weightRef;
    private boolean bufferVal;
    private boolean countVal;
    private boolean depthVal;
    private boolean descRef;
    private boolean activeVal;
    private long radiusVal;
    private int factorVal;
    private int sourceVal;
    private int extraRef;
    private String phaseVal = "0x0000000000000000";
    private String limitRef = "none";
    private String paramRef = "none";
    private String groupVal = "GL clean";
    private String layerVal = "Matrix finite";
    private String slotVal = "waiting";
    private String themeVal = "waiting  none";
    private String stageVal = "none";
    private String widthRef = "none";
    private String trackVal = "Waiting";
    private String modeRef = "Inject HEAD/TAIL";
    private String angleVal = "Local encrypted";
    private String heightRef = "none";
    private String levelVal = "none";
    private String UuNnnVnuNNV = "none";
    private String depthRef = "0";
    private String speedRef = "latest.log";
    private String countRef = "latest.log";
    private final String[] entryVal = new String[96];
    private final int[] guardVal = new int[96];
    private String VUuuVUnun = "0";
    private String vVVuuVVv = "0";
    private int VuunNUUUvu;
    private int NNUUNUuVNNVn;
    private boolean VvVvnNUnvuvV;

    private CoreDiagnosticsManager() {
        this.limitVal.primaryVal(this.extraVal);
        this.factorVal();
    }

    public static CoreDiagnosticsManager primaryVal() {
        return primaryVal;
    }

    public void secondaryVal() {
        if (this.weightRef) {
            this.secondaryVal(8193, 257);
        }
        this.weightRef = true;
        this.secondaryVal(257);
    }

    public void tertiaryVal() {
        if (!this.weightRef) {
            this.secondaryVal(8193, 258);
        }
        this.secondaryVal(258);
        this.weightRef = false;
        this.activeVal();
    }

    public void marginVal() {
        ++this.chunkVal;
        if (this.bufferVal) {
            this.secondaryVal(8193, 513);
        }
        this.bufferVal = true;
        this.secondaryVal(513);
        boolean bl = MatrixDiagnostics.primaryVal(this.extraVal);
        if (!bl) {
            this.secondaryVal(12289, 513);
        }
    }

    public void weightVal() {
        if (!this.bufferVal) {
            this.secondaryVal(8193, 514);
        }
        this.secondaryVal(514);
        this.bufferVal = false;
        int n = GlDiagnostics.marginVal();
        if (n != 0) {
            this.tertiaryVal(n);
        }
    }

    public void paramVal() {
        if (this.countVal) {
            this.secondaryVal(8193, 769);
        }
        this.countVal = true;
        this.secondaryVal(769);
    }

    public void extraVal() {
        if (!this.countVal) {
            this.secondaryVal(8193, 770);
        }
        this.secondaryVal(770);
        this.countVal = false;
    }

    public void primaryVal(int n, int n2) {
        if (this.depthVal) {
            this.secondaryVal(8193, 1025);
        }
        this.depthVal = true;
        this.secondaryVal(1025);
        this.extraVal.primaryVal(n);
        this.extraVal.primaryVal(n2);
    }

    public void limitVal() {
        if (!this.depthVal) {
            this.secondaryVal(8193, 1026);
        }
        this.secondaryVal(1026);
        this.depthVal = false;
    }

    public void speedVal() {
        if (this.descRef) {
            this.secondaryVal(8193, 1281);
        }
        this.descRef = true;
        this.secondaryVal(1281);
    }

    public void primaryVal(int n, int n2, int n3) {
        this.secondaryVal(1282);
        this.descRef = false;
        int n4 = GlDiagnostics.primaryVal();
        int n5 = GlDiagnostics.secondaryVal();
        int n6 = GlDiagnostics.tertiaryVal();
        if (n != n4 || n2 != n5 || n3 != n6) {
            this.secondaryVal(4098, n4 ^ n5 ^ n6);
        }
    }

    public void primaryVal(DiagnosticCodeSource silkE) {
        if (silkE == null) {
            return;
        }
        this.extraVal.primaryVal(silkE.primaryVal());
        silkE.primaryVal(this.limitVal);
    }

    public void widthVal() {
        long l = System.nanoTime();
        int n = (int)(this.extraVal.primaryVal() ^ l >>> 13 ^ 0x5001L);
        this.limitRef = this.primaryVal(n);
        this.paramRef = GlDiagnosticCode.primaryVal(20481);
        this.activeVal = true;
        this.factorVal = n;
        this.sourceVal = 20481;
        this.extraRef = 0;
        this.radiusVal = l;
        this.slotVal = "waiting";
        this.trackVal = "Manual snapshot";
        this.themeVal = "pending  " + this.limitRef;
        paramVal.info("[WildCore] tracker={} code={} snapshot=pending", (Object)this.limitRef, (Object)this.paramRef);
    }

    public void chunkVal() {
        try {
            Path path = this.widthVal.primaryVal();
            class_156.method_668().method_672(path.toFile());
        }
        catch (Throwable throwable) {
            this.slotVal = "folder unavailable";
            this.trackVal = "Open folder failed";
            paramVal.warn("[WildCore] tracker={} code=OPEN_FOLDER_FAILED", (Object)this.limitRef);
        }
    }

    public void blockRef() {
        try {
            Path path = this.radiusVal();
            Files.createDirectories(path, new FileAttribute[0]);
            class_156.method_668().method_672(path.toFile());
            this.speedRef = "logs opened";
        }
        catch (Throwable throwable) {
            this.speedRef = "open error";
            paramVal.warn("[WildCore] tracker={} code=OPEN_LOGS_FAILED", (Object)this.limitRef);
        }
    }

    public void holderVal() {
        this.VvVvnNUnvuvV = true;
        this.holderVal = 0L;
        this.weightRef();
    }

    public void timerVal() {
        this.VvVvnNUnvuvV = !this.VvVvnNUnvuvV;
        if (this.VvVvnNUnvuvV) {
            this.holderVal = 0L;
            this.weightRef();
        }
    }

    public void anchorVal() {
        this.VvVvnNUnvuvV = false;
    }

    public void weightRef() {
        Path path = this.radiusVal().resolve("latest.log");
        this.countRef = "latest.log";
        this.factorVal();
        if (!Files.exists(path, new LinkOption[0])) {
            this.timerVal = -1L;
            this.anchorVal = -1L;
            this.speedRef = "latest.log not found";
            this.tertiaryVal("WARN latest.log not found", 2);
            return;
        }
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(path.toFile(), "r");){
            long l = randomAccessFile.length();
            this.timerVal = l;
            this.anchorVal = Files.getLastModifiedTime(path, new LinkOption[0]).toMillis();
            int n = (int)Math.min(65536L, l);
            byte[] byArray = new byte[n];
            randomAccessFile.seek(Math.max(0L, l - (long)n));
            randomAccessFile.readFully(byArray);
            this.primaryVal(new String(byArray, StandardCharsets.UTF_8));
            this.speedRef = "loaded " + this.NNUUNUuVNNVn;
        }
        catch (Throwable throwable) {
            this.speedRef = "read failed";
            this.tertiaryVal("ERROR " + throwable.getClass().getSimpleName(), 3);
            paramVal.warn("[WildCore] tracker={} code=READ_LOG_FAILED", (Object)this.limitRef);
        }
    }

    public boolean bufferVal() {
        return this.VvVvnNUnvuvV;
    }

    public void primaryVal(String string, Throwable throwable) {
        ++this.VuunNUUUvu;
        this.heightRef = CoreDiagnosticsManager.secondaryVal(string, 96);
        this.levelVal = throwable == null ? "unknown" : CoreDiagnosticsManager.secondaryVal(throwable.getClass().getName(), 96);
        this.UuNnnVnuNNV = throwable == null ? "no throwable" : CoreDiagnosticsManager.secondaryVal(throwable.getMessage(), 160);
        this.depthRef = Integer.toString(this.VuunNUUUvu);
        this.speedRef = "shader exception";
        this.tertiaryVal(ShaderFailureFormatter.primaryVal(this.heightRef, this.VuunNUUUvu), 3);
        int n = 0;
        Throwable throwable2 = throwable;
        if (throwable2 == null) {
            this.tertiaryVal("cause[0]=unknown", 3);
            this.tertiaryVal("message=no throwable", 3);
        }
        block0: for (int n2 = 0; throwable2 != null && n2 < 3; throwable2 = throwable2.getCause(), ++n2) {
            this.tertiaryVal(ShaderFailureFormatter.primaryVal(n2, throwable2), 3);
            this.tertiaryVal(ShaderFailureFormatter.primaryVal(throwable2), 3);
            String string2 = ShaderFailureFormatter.secondaryVal(throwable2);
            if (!"none".equals(string2)) {
                this.tertiaryVal(string2, 4);
            }
            StackTraceElement[] stackTraceElementArray = throwable2.getStackTrace();
            for (int i = 0; i < stackTraceElementArray.length; ++i) {
                if (n >= 14) continue block0;
                this.tertiaryVal(ShaderFailureFormatter.primaryVal(stackTraceElementArray[i]), 3);
                ++n;
            }
        }
        this.secondaryVal(24577, this.UuNnnVnuNNV.hashCode());
        Object[] objectArray = new Object[4];
        objectArray[0] = this.limitRef;
        objectArray[1] = this.heightRef;
        objectArray[2] = this.levelVal;
        objectArray[3] = throwable;
        paramVal.error("[WildCore] tracker={} shaderStage={} exception={}", objectArray);
    }

    public void primaryVal(String string, int n) {
        if (n == 0) {
            return;
        }
        this.secondaryVal(4097, n);
        this.groupVal = GlDiagnostics.primaryVal(n);
        this.speedRef = "OpenGL error";
        this.tertiaryVal(ShaderFailureFormatter.secondaryVal(string, n), 4);
        this.tertiaryVal(ShaderFailureFormatter.primaryVal(), 4);
    }

    public void secondaryVal(String string, Throwable throwable) {
        this.primaryVal(string, throwable);
        if (throwable instanceof Error) {
            Error error = (Error)throwable;
            throw error;
        }
        if (throwable instanceof RuntimeException) {
            RuntimeException runtimeException = (RuntimeException)throwable;
            throw runtimeException;
        }
        throw new IllegalStateException("WildCore shader failure at " + this.heightRef, throwable);
    }

    public void primaryVal(UnUnVNnvnV cellG) {
        if (cellG == null) {
            return;
        }
        cellG.secondaryVal = this.speedVal.primaryVal() == 0 ? "Nominal" : "Anomaly";
        cellG.tertiaryVal = this.phaseVal;
        cellG.marginVal = this.limitRef;
        cellG.weightVal = this.paramRef;
        cellG.paramVal = this.groupVal;
        cellG.extraVal = this.layerVal;
        cellG.limitVal = this.slotVal;
        cellG.speedVal = this.themeVal;
        cellG.widthVal = this.stageVal;
        cellG.chunkVal = this.widthRef;
        cellG.blockRef = this.trackVal;
        cellG.holderVal = this.modeRef;
        cellG.timerVal = this.angleVal;
        cellG.anchorVal = this.heightRef;
        cellG.weightRef = this.levelVal;
        cellG.bufferVal = this.UuNnnVnuNNV;
        cellG.countVal = this.depthRef;
        cellG.depthVal = this.speedRef;
        cellG.descRef = this.countRef;
        cellG.activeVal = this.VUuuVUnun;
        cellG.radiusVal = this.vVVuuVVv;
        cellG.extraRef = this.speedVal.primaryVal();
        cellG.phaseVal = this.speedVal.secondaryVal();
        cellG.limitRef = this.NNUUNUuVNNVn;
        cellG.layerVal = this.VvVvnNUnvuvV;
        for (int i = 0; i < 96; ++i) {
            cellG.factorVal[i] = this.entryVal[i];
            cellG.sourceVal[i] = this.guardVal[i];
        }
        cellG.paramRef = this.chunkVal;
        cellG.groupVal = this.activeVal;
    }

    long countVal() {
        return this.extraVal.primaryVal();
    }

    long depthVal() {
        return this.chunkVal;
    }

    int descRef() {
        return this.speedVal.primaryVal();
    }

    void primaryVal(DataOutputStream dataOutputStream) throws IOException {
        this.speedVal.primaryVal(dataOutputStream);
    }

    String primaryVal(int n) {
        return "WS-" + CoreDiagnosticsManager.marginVal(n);
    }

    private void secondaryVal(int n) {
        this.extraVal.primaryVal(n);
        this.extraVal.secondaryVal(this.chunkVal);
    }

    private void tertiaryVal(int n) {
        this.primaryVal("GameRenderer.tail", n);
    }

    private void secondaryVal(int n, int n2) {
        long l = System.nanoTime();
        int n3 = (int)(this.extraVal.primaryVal() ^ l >>> 11 ^ (long)n << 16 ^ (long)n2);
        this.speedVal.primaryVal(l, n3, n, n2, this.extraVal.primaryVal());
        this.limitRef = this.primaryVal(n3);
        this.paramRef = GlDiagnosticCode.primaryVal(n);
        this.primaryVal(l, n3, n, n2);
        paramVal.warn("[WildCore] tracker={} code={} snapshot=pending", (Object)this.limitRef, (Object)this.paramRef);
    }

    private void primaryVal(long l, int n, int n2, int n3) {
        if (this.activeVal) {
            return;
        }
        this.activeVal = true;
        this.factorVal = n;
        this.sourceVal = n2;
        this.extraRef = n3;
        this.radiusVal = l + 2400000000L;
        this.slotVal = "waiting";
        this.trackVal = "Waiting to record";
    }

    private void activeVal() {
        block10: {
            block9: {
                long l = System.nanoTime();
                if (l - this.blockRef >= 250000000L) {
                    this.blockRef = l;
                    this.phaseVal = "0x" + Long.toUnsignedString(this.extraVal.primaryVal(), 16);
                    this.VUuuVUnun = Integer.toString(this.speedVal.primaryVal());
                    this.vVVuuVVv = Long.toString(this.chunkVal);
                    this.depthRef = Integer.toString(this.VuunNUUUvu);
                    this.themeVal = this.slotVal + "  " + this.limitRef;
                    String string = this.trackVal = this.activeVal ? "Waiting to record" : this.slotVal;
                    if (this.speedVal.primaryVal() == 0) {
                        this.groupVal = "GL clean";
                        this.layerVal = "Matrix finite";
                    }
                }
                if (this.VvVvnNUnvuvV) {
                    if (l - this.holderVal >= 100000000L) {
                        this.holderVal = l;
                        this.sourceVal();
                    }
                }
                if (!this.activeVal) break block9;
                if (l >= this.radiusVal) break block10;
            }
            return;
        }
        this.activeVal = false;
        this.slotVal = "recording";
        this.trackVal = "Recording";
        try {
            Path path = this.widthVal.primaryVal(this, this.factorVal, this.sourceVal, this.extraRef);
            this.stageVal = path.toString();
            this.widthRef = path.getFileName().toString();
            this.slotVal = "recorded";
            this.trackVal = "Recorded";
        }
        catch (Throwable throwable) {
            this.slotVal = "error";
            this.trackVal = "Snapshot error";
            int n = 16385;
            int n2 = throwable.getClass().getName().hashCode();
            long l = this.extraVal.primaryVal();
            int n3 = (int)(l ^ (long)n2 ^ (long)n);
            this.speedVal.primaryVal(System.nanoTime(), n3, n, n2, l);
            this.limitRef = this.primaryVal(n3);
            this.paramRef = GlDiagnosticCode.primaryVal(n);
            paramVal.warn("[WildCore] tracker={} code={} snapshot=failed", (Object)this.limitRef, (Object)this.paramRef);
        }
    }

    private static String marginVal(int n) {
        String string = Integer.toUnsignedString(n, 16).toUpperCase(Locale.ROOT);
        if (string.length() >= 8) {
            return string.substring(string.length() - 8);
        }
        return "00000000".substring(string.length()) + string;
    }

    private static String secondaryVal(String string, int n) {
        if (string == null || string.isBlank()) {
            return "none";
        }
        String string2 = string.replace('\n', ' ').replace('\r', ' ').trim();
        if (string2.length() <= n) {
            return string2;
        }
        return string2.substring(0, Math.max(0, n - 3)) + "...";
    }

    private Path radiusVal() {
        class_310 class_3102 = class_310.method_1551();
        return (class_3102 == null ? Path.of(System.getProperty("user.dir", "."), new String[0]) : class_3102.field_1697.toPath()).resolve("logs");
    }

    private void factorVal() {
        this.NNUUNUuVNNVn = 0;
        for (int i = 0; i < this.entryVal.length; ++i) {
            this.entryVal[i] = "";
            this.guardVal[i] = 0;
        }
    }

    private void sourceVal() {
        Path path = this.radiusVal().resolve("latest.log");
        try {
            if (!Files.exists(path, new LinkOption[0])) {
                if (this.timerVal != -1L || this.NNUUNUuVNNVn == 0) {
                    this.weightRef();
                }
                return;
            }
            long l = Files.size(path);
            long l2 = Files.getLastModifiedTime(path, new LinkOption[0]).toMillis();
            if (l != this.timerVal || l2 != this.anchorVal) {
                this.weightRef();
            }
        }
        catch (Throwable throwable) {
            this.weightRef();
        }
    }

    private void primaryVal(String string) {
        if (string == null || string.isEmpty()) {
            this.tertiaryVal("INFO latest.log is empty", 1);
            return;
        }
        int n = 0;
        int n2 = string.length();
        for (int i = 0; i <= n2; ++i) {
            if (i != n2) {
                if (string.charAt(i) != '\n') continue;
            }
            int n3 = i;
            if (n3 > n && string.charAt(n3 - 1) == '\r') {
                --n3;
            }
            if (n3 > n) {
                String string2 = CoreDiagnosticsManager.secondaryVal(string.substring(n, n3), 170);
                this.tertiaryVal(string2, this.secondaryVal(string2));
            }
            n = i + 1;
        }
        if (this.NNUUNUuVNNVn == 0) {
            this.tertiaryVal("INFO latest.log has no visible lines", 1);
        }
    }

    private void tertiaryVal(String string, int n) {
        int n2;
        if (this.NNUUNUuVNNVn < this.entryVal.length) {
            this.entryVal[this.NNUUNUuVNNVn] = string;
            this.guardVal[this.NNUUNUuVNNVn] = n;
            ++this.NNUUNUuVNNVn;
            return;
        }
        for (n2 = 1; n2 < this.entryVal.length; ++n2) {
            this.entryVal[n2 - 1] = this.entryVal[n2];
            this.guardVal[n2 - 1] = this.guardVal[n2];
        }
        n2 = this.entryVal.length - 1;
        this.entryVal[n2] = string;
        this.guardVal[n2] = n;
    }

    private int secondaryVal(String string) {
        block12: {
            block11: {
                block10: {
                    block9: {
                        if (string == null) {
                            return 0;
                        }
                        if (this.primaryVal(string, "ERROR") || this.primaryVal(string, "Exception")) break block9;
                        if (!this.primaryVal(string, "Crash")) break block10;
                    }
                    return 3;
                }
                if (this.primaryVal(string, "WARN")) {
                    return 2;
                }
                if (this.primaryVal(string, "Shader") || this.primaryVal(string, "GL_")) break block11;
                if (!this.primaryVal(string, "OpenGL")) break block12;
            }
            return 4;
        }
        if (this.primaryVal(string, "DEBUG") || this.primaryVal(string, "TRACE")) {
            return 0;
        }
        return 1;
    }

    private boolean primaryVal(String string, String string2) {
        return string.indexOf(string2) >= 0;
    }
}

