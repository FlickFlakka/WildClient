/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import ru.metaculture.protection.NvvuunnVUV;
import ru.metaculture.protection.GlDiagnostics;
import ru.metaculture.protection.MatrixDiagnostics;
import ru.metaculture.protection.CoreDiagnosticsManager;

final class DebugSnapshotWriter {
    private static final DateTimeFormatter primaryVal = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

    DebugSnapshotWriter() {
    }

    Path primaryVal(CoreDiagnosticsManager vVnvuVuVvnun2, int n, int n2, int n3) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
        try (DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);){
            dataOutputStream.writeInt(1465077328);
            dataOutputStream.writeInt(1);
            this.primaryVal(dataOutputStream);
            this.primaryVal(dataOutputStream, vVnvuVuVvnun2, n, n2, n3);
            this.secondaryVal(dataOutputStream);
            this.tertiaryVal(dataOutputStream);
            this.primaryVal(dataOutputStream, vVnvuVuVvnun2);
            this.marginVal(dataOutputStream);
            this.weightVal(dataOutputStream);
        }
        byte[] byArray = NvvuunnVUV.primaryVal(byteArrayOutputStream.toByteArray());
        Path path = this.primaryVal();
        Path path2 = path.resolve(vVnvuVuVvnun2.primaryVal(n) + "-" + primaryVal.format(LocalDateTime.now()) + ".wildsnap");
        Files.write(path2, byArray, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE);
        return path2;
    }

    Path primaryVal() throws Exception {
        Path path = Path.of(System.getProperty("user.dir", "."), "wild", "debug", "snapshots");
        Files.createDirectories(path, new FileAttribute[0]);
        return path;
    }

    private void primaryVal(DataOutputStream dataOutputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
        try (DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);){
            dataOutputStream2.writeUTF("wild-1.21.8-1787661348375");
            dataOutputStream2.writeUTF("1.21.8");
            dataOutputStream2.writeUTF("stable");
        }
        DebugSnapshotWriter.primaryVal(dataOutputStream, 1, byteArrayOutputStream.toByteArray());
    }

    private void primaryVal(DataOutputStream dataOutputStream, CoreDiagnosticsManager vVnvuVuVvnun2, int n, int n2, int n3) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
        try (DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);){
            dataOutputStream2.writeInt(n);
            dataOutputStream2.writeInt(n2);
            dataOutputStream2.writeInt(n3);
            dataOutputStream2.writeLong(vVnvuVuVvnun2.countVal());
            dataOutputStream2.writeLong(vVnvuVuVvnun2.depthVal());
            dataOutputStream2.writeInt(vVnvuVuVvnun2.descRef());
        }
        DebugSnapshotWriter.primaryVal(dataOutputStream, 2, byteArrayOutputStream.toByteArray());
    }

    private void secondaryVal(DataOutputStream dataOutputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(64);
        try (DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);){
            GlDiagnostics.primaryVal(dataOutputStream2);
        }
        DebugSnapshotWriter.primaryVal(dataOutputStream, 3, byteArrayOutputStream.toByteArray());
    }

    private void tertiaryVal(DataOutputStream dataOutputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(96);
        try (DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);){
            MatrixDiagnostics.primaryVal(dataOutputStream2);
        }
        DebugSnapshotWriter.primaryVal(dataOutputStream, 4, byteArrayOutputStream.toByteArray());
    }

    private void primaryVal(DataOutputStream dataOutputStream, CoreDiagnosticsManager vVnvuVuVvnun2) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try (DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);){
            vVnvuVuVvnun2.primaryVal(dataOutputStream2);
        }
        DebugSnapshotWriter.primaryVal(dataOutputStream, 5, byteArrayOutputStream.toByteArray());
    }

    private void marginVal(DataOutputStream dataOutputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
        try (DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);){
            dataOutputStream2.writeUTF(DebugSnapshotWriter.primaryVal("os.name"));
            dataOutputStream2.writeUTF(DebugSnapshotWriter.primaryVal("os.arch"));
            dataOutputStream2.writeUTF(DebugSnapshotWriter.primaryVal("java.version"));
            dataOutputStream2.writeUTF(DebugSnapshotWriter.primaryVal("java.vm.name"));
        }
        DebugSnapshotWriter.primaryVal(dataOutputStream, 6, byteArrayOutputStream.toByteArray());
    }

    private void weightVal(DataOutputStream dataOutputStream) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
        try (DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);){
            dataOutputStream2.writeUTF("inject-only-runtime");
            dataOutputStream2.writeUTF("no-lvt-runtime");
        }
        DebugSnapshotWriter.primaryVal(dataOutputStream, 7, byteArrayOutputStream.toByteArray());
    }

    private static String primaryVal(String string) {
        String string2;
        block3: {
            block2: {
                string2 = System.getProperty(string, "unknown");
                if (string2 == null) break block2;
                if (!string2.isBlank()) break block3;
            }
            return "unknown";
        }
        return string2.replace('\n', ' ').replace('\r', ' ').trim();
    }

    private static void primaryVal(DataOutputStream dataOutputStream, int n, byte[] byArray) throws Exception {
        dataOutputStream.writeShort(n);
        dataOutputStream.writeInt(byArray.length);
        dataOutputStream.write(byArray);
    }
}

