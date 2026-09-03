/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1297
 *  net.minecraft.class_239$class_240
 *  net.minecraft.class_243
 *  net.minecraft.class_3532
 *  net.minecraft.class_3959
 *  net.minecraft.class_3959$class_242
 *  net.minecraft.class_3959$class_3960
 *  net.minecraft.class_3965
 *  net.minecraft.class_408
 *  org.joml.Matrix4f
 *  org.joml.Matrix4fc
 *  org.joml.Vector3f
 */
package ru.metaculture.protection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.minecraft.class_1297;
import net.minecraft.class_239;
import net.minecraft.class_243;
import net.minecraft.class_3532;
import net.minecraft.class_3959;
import net.minecraft.class_3965;
import net.minecraft.class_408;
import org.joml.Matrix4f;
import org.joml.Matrix4fc;
import org.joml.Vector3f;
import org.wild.module.api.Module;
import org.wild.module.api.ModuleRegister;
import ru.metaculture.protection.AimReticleRenderer;
import ru.metaculture.protection.MediaPanelInteractionController;
import ru.metaculture.protection.StringFilterSetting;
import ru.metaculture.protection.InputSimulator;
import ru.metaculture.protection.PartyEndpoint;
import ru.metaculture.protection.MouseScrollEvent;
import ru.metaculture.protection.LicenseKeyUtil;
import ru.metaculture.protection.PartyManager;
import ru.metaculture.protection.MediaWorldPanelRenderer;
import ru.metaculture.protection.MouseClickEvent;
import ru.metaculture.protection.VvUUVVVNNUN;
import ru.metaculture.protection.MediaSessionRegistry;
import ru.metaculture.protection.FloatSetting;
import ru.metaculture.protection.BrowserTabState;
import ru.metaculture.protection.TickEvent;
import ru.metaculture.protection.PartyState;
import ru.metaculture.protection.PanelRayHitTester;
import ru.metaculture.protection.ScreenKeyEvent;
import ru.metaculture.protection.Setting;
import ru.metaculture.protection.ModuleCategory;
import ru.metaculture.protection.RequiresRole;
import ru.metaculture.protection.RenderWorldLastEvent;
import ru.metaculture.protection.KeybindSetting;
import ru.metaculture.protection.AimOverlayRenderer;
import ru.metaculture.protection.ButtonSetting;
import ru.metaculture.protection.BrowserOverlayRenderer;
import ru.metaculture.protection.ChatLogger;
import ru.metaculture.protection.Subscribe;
import ru.metaculture.protection.BoolSetting;

@RequiresRole(tertiaryVal={"lichoday"})
@ModuleRegister(primaryVal="Screens", tertiaryVal=ModuleCategory.Visuals, secondaryVal="Shared room screens: creation, placement, and synchronized viewing")
public class ScreensModule
extends Module {
    public final StringFilterSetting countVal = new StringFilterSetting("Server", "49.12.210.82");
    public final ButtonSetting depthVal = new ButtonSetting("Connect to server", 0).primaryVal(this::blockRef);
    public final ButtonSetting descRef = new ButtonSetting("Create room", 0).primaryVal(this::holderVal);
    public final StringFilterSetting activeVal = new StringFilterSetting("Room code", "");
    public final ButtonSetting radiusVal = new ButtonSetting("Connect", 0).primaryVal(this::timerVal);
    public final KeybindSetting factorVal = new KeybindSetting("Create screen", -1);
    public final ButtonSetting sourceVal = new ButtonSetting("Remove screens", 0).primaryVal(this::bufferVal);
    public final FloatSetting extraRef = new FloatSetting("Rotation", 0.0f, 0.0f, 355.0f, 5.0f, false);
    public final BoolSetting phaseVal = new BoolSetting("Track direction", false);
    public final StringFilterSetting limitRef = new StringFilterSetting("Link", "https://www.google.com");
    public final ButtonSetting paramRef = new ButtonSetting("Open on screen", 0).primaryVal(this::countVal);
    public final StringFilterSetting groupVal = new StringFilterSetting("Transfer control", "");
    public final ButtonSetting layerVal = new ButtonSetting("Transfer", 0).primaryVal(this::anchorVal);
    private final MediaPanelInteractionController slotVal = new MediaPanelInteractionController();
    private final PanelRayHitTester themeVal = new PanelRayHitTester();
    private final MediaWorldPanelRenderer stageVal = new MediaWorldPanelRenderer(ScreensModule.slotVal());
    private final Matrix4f widthRef = new Matrix4f();
    private final Vector3f trackVal = new Vector3f();
    private final Vector3f modeRef = new Vector3f();
    private final int[] angleVal = new int[4];
    private final Map<UUID, double[]> heightRef = new HashMap<UUID, double[]>();
    private final Set<UUID> levelVal = new HashSet<UUID>();
    private class_243 UuNnnVnuNNV = class_243.field_1353;
    private boolean depthRef;
    private long speedRef;
    private UUID countRef;
    private long entryVal;
    private double guardVal;
    private double VUuuVUnun;
    private double vVVuuVVv;
    private double VuunNUUUvu;
    private double NNUUNUuVNNVn;
    private double VvVvnNUnvuvV;

    public ScreensModule() {
        Setting[] nvUuvVvuuNArray = new Setting[13];
        nvUuvVvuuNArray[0] = this.countVal;
        nvUuvVvuuNArray[1] = this.depthVal;
        nvUuvVvuuNArray[2] = this.descRef;
        nvUuvVvuuNArray[3] = this.activeVal;
        nvUuvVvuuNArray[4] = this.radiusVal;
        nvUuvVvuuNArray[5] = this.factorVal;
        nvUuvVvuuNArray[6] = this.sourceVal;
        nvUuvVvuuNArray[7] = this.extraRef;
        nvUuvVvuuNArray[8] = this.phaseVal;
        nvUuvVvuuNArray[9] = this.limitRef;
        nvUuvVvuuNArray[10] = this.paramRef;
        nvUuvVvuuNArray[11] = this.groupVal;
        nvUuvVvuuNArray[12] = this.layerVal;
        this.addSettings(nvUuvVvuuNArray);
    }

    @Override
    public void onDisable() {
        this.slotVal.timerVal();
        this.heightRef.clear();
        this.levelVal.clear();
        this.stageVal.primaryVal().primaryVal();
        super.onDisable();
    }

    @Subscribe
    public void primaryVal(ScreenKeyEvent vaseD) {
        if (ScreensModule.mc.field_1724 == null || ScreensModule.mc.field_1755 != null || vaseD.marginVal() != 1) {
            return;
        }
        if (this.factorVal.tertiaryVal() != -1 && vaseD.tertiaryVal() == this.factorVal.tertiaryVal()) {
            this.weightRef();
        }
    }

    @Subscribe
    public void primaryVal(MouseScrollEvent uVNVVUunvN) {
        if (ScreensModule.mc.field_1724 == null || !(ScreensModule.mc.field_1755 instanceof class_408)) {
            return;
        }
        InputSimulator edgeC = this.sourceVal();
        if (edgeC == null) {
            return;
        }
        edgeC.scroll(this.themeVal.speedVal(), this.themeVal.widthVal(), uVNVVUunvN.weightVal());
        uVNVVUunvN.secondaryVal();
    }

    @Subscribe
    public void primaryVal(MouseClickEvent spanI) {
        block10: {
            block9: {
                if (ScreensModule.mc.field_1724 == null) {
                    return;
                }
                if (ScreensModule.mc.field_1755 instanceof class_408) {
                    this.secondaryVal(spanI);
                    return;
                }
                if (ScreensModule.mc.field_1755 != null) break block9;
                if (spanI.marginVal() == 0) break block10;
            }
            return;
        }
        if (spanI.chunkVal()) {
            this.descRef();
            return;
        }
        if (!spanI.widthVal() || this.slotVal.tertiaryVal() == VvUUVVVNNUN.NONE) {
            return;
        }
        MediaSessionRegistry.MediaSession modeVal = PartyManager.primaryVal().tertiaryVal().primaryVal(this.slotVal.primaryVal());
        if (modeVal == null) {
            return;
        }
        this.secondaryVal(1.0f);
        if (this.slotVal.primaryVal(modeVal, this.guardVal, this.VUuuVUnun, this.vVVuuVVv, this.VuunNUUUvu, this.NNUUNUuVNNVn, this.VvVvnNUnvuvV)) {
            spanI.secondaryVal();
        }
    }

    @Subscribe
    public void primaryVal(TickEvent nVunNNvuv2) {
        PartyManager cellI = PartyManager.primaryVal();
        cellI.blockRef();
        if (ScreensModule.mc.field_1724 == null) {
            this.slotVal.timerVal();
            return;
        }
        this.stageVal.primaryVal().primaryVal(cellI.tertiaryVal().primaryVal());
        this.limitRef();
        this.paramRef();
        if (this.slotVal.marginVal()) {
            return;
        }
        this.secondaryVal(1.0f);
        this.slotVal.primaryVal(cellI.tertiaryVal().primaryVal(), cellI.limitVal(), this.layerVal(), this.guardVal, this.VUuuVUnun, this.vVVuuVVv, this.VuunNUUUvu, this.NNUUNUuVNNVn, this.VvVvnNUnvuvV);
        this.groupVal();
    }

    @Subscribe
    public void primaryVal(RenderWorldLastEvent partI) {
        if (ScreensModule.mc.field_1724 == null) {
            return;
        }
        PartyManager cellI = PartyManager.primaryVal();
        List<MediaSessionRegistry.MediaSession> list = cellI.tertiaryVal().primaryVal();
        this.secondaryVal(partI);
        if (list.isEmpty()) {
            return;
        }
        this.factorVal();
        this.primaryVal(partI.weightVal().paramVal());
        this.stageVal.primaryVal(partI.weightVal(), list, cellI.tertiaryVal(), this.slotVal, cellI.limitVal(), this.layerVal(), cellI.marginVal().secondaryVal(), -8426497);
    }

    private void secondaryVal(RenderWorldLastEvent partI) {
        this.widthRef.set((Matrix4fc)partI.weightVal().weightVal()).mul((Matrix4fc)partI.weightVal().tertiaryVal());
        this.UuNnnVnuNNV = partI.weightVal().primaryVal().method_19326();
        this.depthRef = true;
    }

    private void blockRef() {
        String string = this.countVal.tertiaryVal().trim();
        if (string.isEmpty()) {
            ChatLogger.primaryVal("Specify server address");
            return;
        }
        PartyManager.primaryVal().primaryVal(PartyEndpoint.primaryVal(string, 7331));
        ChatLogger.primaryVal("Connecting to " + string + ":7331");
    }

    private void holderVal() {
        if (ScreensModule.themeVal()) {
            return;
        }
        String string = LicenseKeyUtil.primaryVal();
        if (!PartyManager.primaryVal().primaryVal(string)) {
            ChatLogger.primaryVal("No connection to Wild server");
            return;
        }
        this.activeVal.secondaryVal(string);
        ChatLogger.primaryVal("Room code: " + string);
    }

    private void timerVal() {
        if (ScreensModule.themeVal()) {
            return;
        }
        String string = LicenseKeyUtil.primaryVal(this.activeVal.tertiaryVal());
        if (!LicenseKeyUtil.secondaryVal(string)) {
            ChatLogger.primaryVal("Invalid code format");
            return;
        }
        PartyManager.primaryVal().secondaryVal(string);
    }

    private void anchorVal() {
        PartyState nnnvUNUvVUVU2 = PartyManager.primaryVal().secondaryVal();
        PartyState.Member modeVal = nnnvUNUvVUVU2.primaryVal(this.groupVal.tertiaryVal().trim());
        if (modeVal == null) {
            ChatLogger.primaryVal("No such member in the room");
            return;
        }
        PartyManager.primaryVal().primaryVal(modeVal.uuid());
    }

    private void weightRef() {
        PartyManager cellI = PartyManager.primaryVal();
        if (!cellI.secondaryVal().primaryVal()) {
            ChatLogger.primaryVal("First create a room or join one");
            return;
        }
        if (cellI.tertiaryVal().secondaryVal() >= 5) {
            ChatLogger.primaryVal("Room already has the maximum number of screens");
            return;
        }
        double d = Math.toRadians(ScreensModule.mc.field_1724.method_36454());
        cellI.primaryVal(ScreensModule.mc.field_1724.method_23317() - Math.sin(d) * 5.0, ScreensModule.mc.field_1724.method_23320(), ScreensModule.mc.field_1724.method_23321() + Math.cos(d) * 5.0, ScreensModule.mc.field_1724.method_36454() + 180.0f, 6.4f, 3.6f);
    }

    private void bufferVal() {
        PartyManager cellI = PartyManager.primaryVal();
        List<MediaSessionRegistry.MediaSession> list = cellI.tertiaryVal().primaryVal();
        UUID uUID = cellI.limitVal();
        boolean bl = this.layerVal();
        for (int i = 0; i < list.size(); ++i) {
            MediaSessionRegistry.MediaSession modeVal = list.get(i);
            if (!MediaPanelInteractionController.primaryVal(modeVal, uUID, bl)) continue;
            cellI.secondaryVal(modeVal.id());
        }
        this.slotVal.timerVal();
    }

    private void countVal() {
        MediaSessionRegistry.MediaSession modeVal = PartyManager.primaryVal().tertiaryVal().primaryVal(this.slotVal.secondaryVal());
        if (modeVal == null) {
            ChatLogger.primaryVal("Aim at the screen you are controlling");
            return;
        }
        String string = this.limitRef.tertiaryVal().trim();
        if (!string.startsWith("https://")) {
            ChatLogger.primaryVal("Link must start with https://");
            return;
        }
        PartyManager.primaryVal().primaryVal(modeVal.id(), string, true, 0L, 1.0f);
    }

    private void primaryVal(float f) {
        if (!this.slotVal.marginVal()) {
            return;
        }
        this.secondaryVal(f);
        this.slotVal.primaryVal(this.depthVal());
        this.slotVal.primaryVal(this.guardVal, this.VUuuVUnun, this.vVVuuVVv, this.VuunNUUUvu, this.NNUUNUuVNNVn, this.VvVvnNUnvuvV);
        if (this.slotVal.primaryVal(System.currentTimeMillis())) {
            this.activeVal();
        }
    }

    private double depthVal() {
        double d = this.slotVal.blockRef();
        class_3965 class_39652 = ScreensModule.mc.field_1687.method_17742(new class_3959(new class_243(this.guardVal, this.VUuuVUnun, this.vVVuuVVv), new class_243(this.guardVal + this.VuunNUUUvu * d, this.VUuuVUnun + this.NNUUNUuVNNVn * d, this.vVVuuVVv + this.VvVvnNUnvuvV * d), class_3959.class_3960.field_17558, class_3959.class_242.field_1348, (class_1297)ScreensModule.mc.field_1724));
        if (class_39652.method_17783() != class_239.class_240.field_1332) {
            return d;
        }
        double d2 = class_39652.method_17784().method_1022(new class_243(this.guardVal, this.VUuuVUnun, this.vVVuuVVv));
        return Math.max(1.0, d2 - (double)this.slotVal.widthVal() * 0.5 - 0.35);
    }

    private void descRef() {
        if (!this.slotVal.marginVal()) {
            return;
        }
        this.activeVal();
        this.slotVal.holderVal();
    }

    private void activeVal() {
        UUID uUID = this.slotVal.weightVal();
        if (uUID == null) {
            return;
        }
        PartyManager.primaryVal().primaryVal(uUID, this.slotVal.paramVal(), this.slotVal.extraVal(), this.slotVal.limitVal(), this.slotVal.speedVal(), this.slotVal.widthVal(), this.slotVal.chunkVal());
    }

    private void secondaryVal(MouseClickEvent spanI) {
        if (spanI.widthVal() && this.radiusVal()) {
            spanI.secondaryVal();
            return;
        }
        InputSimulator edgeC = this.sourceVal();
        if (edgeC == null) {
            return;
        }
        if (spanI.widthVal()) {
            edgeC.press(this.themeVal.speedVal(), this.themeVal.widthVal(), spanI.marginVal());
        } else if (spanI.chunkVal()) {
            edgeC.release(this.themeVal.speedVal(), this.themeVal.widthVal(), spanI.marginVal());
        } else {
            return;
        }
        spanI.secondaryVal();
    }

    private boolean radiusVal() {
        MediaSessionRegistry.MediaSession modeVal;
        block8: {
            block7: {
                modeVal = this.extraRef();
                if (modeVal == null) break block7;
                if (this.themeVal.bufferVal()) break block8;
            }
            return false;
        }
        BrowserTabState nVnnVNuNNVUU2 = this.stageVal.primaryVal().secondaryVal(modeVal.id());
        if (nVnnVNuNNVUU2 == null) {
            return false;
        }
        int n = this.themeVal.countVal();
        if (n < 0 || n > nVnnVNuNNVUU2.primaryVal()) {
            return false;
        }
        if (n == nVnnVNuNNVUU2.primaryVal()) {
            nVnnVNuNNVUU2.primaryVal(this.limitRef.tertiaryVal().trim());
        } else {
            nVnnVNuNNVUU2.tertiaryVal(n);
        }
        PartyManager.primaryVal().primaryVal(modeVal.id(), nVnnVNuNNVUU2.primaryVal(nVnnVNuNNVUU2.secondaryVal()), true, 0L, 1.0f);
        return true;
    }

    private void factorVal() {
        InputSimulator edgeC = this.sourceVal();
        if (edgeC != null) {
            edgeC.moveCursor(this.themeVal.speedVal(), this.themeVal.widthVal());
        }
    }

    private InputSimulator sourceVal() {
        MediaSessionRegistry.MediaSession modeVal = this.extraRef();
        if (modeVal == null || !this.themeVal.sourceVal()) {
            return null;
        }
        return this.stageVal.primaryVal().primaryVal(modeVal.id());
    }

    private MediaSessionRegistry.MediaSession extraRef() {
        if (!(ScreensModule.mc.field_1755 instanceof class_408) || !this.phaseVal()) {
            return null;
        }
        PartyManager cellI = PartyManager.primaryVal();
        List<MediaSessionRegistry.MediaSession> list = cellI.tertiaryVal().primaryVal();
        UUID uUID = cellI.limitVal();
        boolean bl = this.layerVal();
        MediaSessionRegistry.MediaSession modeVal = null;
        double d = Double.MAX_VALUE;
        for (int i = 0; i < list.size(); ++i) {
            MediaSessionRegistry.MediaSession nodeC = list.get(i);
            if (!MediaPanelInteractionController.primaryVal(nodeC, uUID, bl)) continue;
            this.themeVal.primaryVal(nodeC);
            if (!this.themeVal.primaryVal(this.guardVal, this.VUuuVUnun, this.vVVuuVVv, this.VuunNUUUvu, this.NNUUNUuVNNVn, this.VvVvnNUnvuvV)) continue;
            if (!this.themeVal.sourceVal() && !this.themeVal.bufferVal() || !(this.themeVal.limitVal() < d)) continue;
            d = this.themeVal.limitVal();
            modeVal = nodeC;
        }
        if (modeVal != null) {
            this.themeVal.primaryVal(modeVal);
            this.themeVal.primaryVal(this.guardVal, this.VUuuVUnun, this.vVVuuVVv, this.VuunNUUUvu, this.NNUUNUuVNNVn, this.VvVvnNUnvuvV);
        }
        return modeVal;
    }

    private boolean phaseVal() {
        int n;
        int n2;
        block3: {
            block2: {
                n2 = mc.method_22683().method_4489();
                n = mc.method_22683().method_4506();
                float f = mc.method_22683().method_4495();
                if (!this.depthRef || n2 <= 0 || n <= 0) break block2;
                if (!(f <= 0.0f)) break block3;
            }
            return false;
        }
        this.angleVal[0] = 0;
        this.angleVal[1] = 0;
        this.angleVal[2] = n2;
        this.angleVal[3] = n;
        this.widthRef.unprojectRay((float)ScreensModule.mc.field_1729.method_1603(), (float)n - (float)ScreensModule.mc.field_1729.method_1604(), this.angleVal, this.trackVal, this.modeRef);
        this.guardVal = this.UuNnnVnuNNV.field_1352 + (double)this.trackVal.x;
        this.VUuuVUnun = this.UuNnnVnuNNV.field_1351 + (double)this.trackVal.y;
        this.vVVuuVVv = this.UuNnnVnuNNV.field_1350 + (double)this.trackVal.z;
        this.VuunNUUUvu = this.modeRef.x;
        this.NNUUNUuVNNVn = this.modeRef.y;
        this.VvVvnNUnvuvV = this.modeRef.z;
        return true;
    }

    private void limitRef() {
        PartyManager cellI = PartyManager.primaryVal();
        String string = this.limitRef.tertiaryVal().trim();
        if (!string.startsWith("https://")) {
            return;
        }
        List<MediaSessionRegistry.MediaSession> list = cellI.tertiaryVal().primaryVal();
        UUID uUID = cellI.limitVal();
        for (int i = 0; i < list.size(); ++i) {
            MediaSessionRegistry.MediaSession modeVal = list.get(i);
            if (uUID == null || !uUID.equals(modeVal.owner()) || !modeVal.source().isEmpty() || !this.levelVal.add(modeVal.id())) continue;
            cellI.primaryVal(modeVal.id(), string, true, 0L, 1.0f);
        }
    }

    private void paramRef() {
        if (!this.phaseVal.tertiaryVal()) {
            this.heightRef.clear();
            return;
        }
        PartyManager cellI = PartyManager.primaryVal();
        List<MediaSessionRegistry.MediaSession> list = cellI.tertiaryVal().primaryVal();
        UUID uUID = cellI.limitVal();
        float f = ScreensModule.mc.field_1724.method_36454();
        for (int i = 0; i < list.size(); ++i) {
            MediaSessionRegistry.MediaSession modeVal = list.get(i);
            if (uUID == null || !uUID.equals(modeVal.owner())) continue;
            double[] dArray = this.heightRef.get(modeVal.id());
            if (dArray == null) {
                this.heightRef.put(modeVal.id(), this.primaryVal(modeVal, f));
                continue;
            }
            this.primaryVal(modeVal, dArray, f);
        }
    }

    private double[] primaryVal(MediaSessionRegistry.MediaSession modeVal, float f) {
        double d = modeVal.x() - ScreensModule.mc.field_1724.method_23317();
        double d2 = modeVal.z() - ScreensModule.mc.field_1724.method_23321();
        return new double[]{Math.sqrt(d * d + d2 * d2), Math.toDegrees(Math.atan2(d2, d)) - (double)f, modeVal.y() - ScreensModule.mc.field_1724.method_23320(), modeVal.yaw() - f};
    }

    private void primaryVal(MediaSessionRegistry.MediaSession modeVal, double[] dArray, float f) {
        long l;
        double d = Math.toRadians(dArray[1] + (double)f);
        double d2 = ScreensModule.mc.field_1724.method_23317() + Math.cos(d) * dArray[0];
        double d3 = ScreensModule.mc.field_1724.method_23321() + Math.sin(d) * dArray[0];
        double d4 = ScreensModule.mc.field_1724.method_23320() + dArray[2];
        if (Math.abs(d2 - modeVal.x()) < 0.02) {
            if (Math.abs(d4 - modeVal.y()) < 0.02) {
                if (Math.abs(d3 - modeVal.z()) < 0.02) {
                    return;
                }
            }
        }
        if ((l = System.currentTimeMillis()) - this.speedRef < 100L) {
            return;
        }
        this.speedRef = l;
        PartyManager.primaryVal().primaryVal(modeVal.id(), d2, d4, d3, (float)(dArray[3] + (double)f), modeVal.width(), modeVal.height());
    }

    private void groupVal() {
        MediaSessionRegistry.MediaSession modeVal = PartyManager.primaryVal().tertiaryVal().primaryVal(this.slotVal.secondaryVal());
        if (modeVal == null) {
            this.countRef = null;
            return;
        }
        if (!modeVal.id().equals(this.countRef)) {
            this.countRef = modeVal.id();
            this.extraRef.primaryVal(modeVal.yaw());
            return;
        }
        if (Math.abs(this.extraRef.tertiaryVal() - modeVal.yaw()) < 2.5f) {
            return;
        }
        long l = System.currentTimeMillis();
        if (l - this.entryVal < 100L) {
            return;
        }
        this.entryVal = l;
        PartyManager.primaryVal().primaryVal(modeVal.id(), modeVal.x(), modeVal.y(), modeVal.z(), this.extraRef.tertiaryVal(), modeVal.width(), modeVal.height());
    }

    private void secondaryVal(float f) {
        class_243 class_2432 = ScreensModule.mc.field_1724.method_5828(f);
        this.guardVal = class_3532.method_16436((double)f, (double)ScreensModule.mc.field_1724.field_6038, (double)ScreensModule.mc.field_1724.method_23317());
        this.VUuuVUnun = class_3532.method_16436((double)f, (double)ScreensModule.mc.field_1724.field_5971, (double)ScreensModule.mc.field_1724.method_23318()) + ScreensModule.mc.field_1724.method_23320() - ScreensModule.mc.field_1724.method_23318();
        this.vVVuuVVv = class_3532.method_16436((double)f, (double)ScreensModule.mc.field_1724.field_5989, (double)ScreensModule.mc.field_1724.method_23321());
        this.VuunNUUUvu = class_2432.field_1352;
        this.NNUUNUuVNNVn = class_2432.field_1351;
        this.VvVvnNUnvuvV = class_2432.field_1350;
    }

    private boolean layerVal() {
        UUID uUID = PartyManager.primaryVal().limitVal();
        return uUID != null && PartyManager.primaryVal().secondaryVal().primaryVal(uUID);
    }

    private static AimOverlayRenderer slotVal() {
        try {
            return new BrowserOverlayRenderer();
        }
        catch (Throwable throwable) {
            return new AimReticleRenderer();
        }
    }

    private static boolean themeVal() {
        if (PartyManager.primaryVal().paramVal()) {
            return false;
        }
        ChatLogger.primaryVal("No connection to Wild server");
        return true;
    }
}

