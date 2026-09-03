/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1921
 *  net.minecraft.class_2960
 */
package ru.metaculture.protection;

import java.util.List;
import java.util.UUID;
import net.minecraft.class_1921;
import net.minecraft.class_2960;
import ru.metaculture.protection.AimReticleRenderer;
import ru.metaculture.protection.MediaPanelInteractionController;
import ru.metaculture.protection.WildRenderLayers;
import ru.metaculture.protection.WorldRenderContext;
import ru.metaculture.protection.VvUUVVVNNUN;
import ru.metaculture.protection.MediaSessionRegistry;
import ru.metaculture.protection.BrowserTabState;
import ru.metaculture.protection.PanelRayHitTester;
import ru.metaculture.protection.WorldGeometryBuilder;
import ru.metaculture.protection.AimOverlayRenderer;

public final class MediaWorldPanelRenderer {
    private final PanelRayHitTester primaryVal = new PanelRayHitTester();
    private final AimOverlayRenderer secondaryVal;

    public MediaWorldPanelRenderer(AimOverlayRenderer unUNvvnuUNn2) {
        this.secondaryVal = unUNvvnuUNn2;
    }

    public AimOverlayRenderer primaryVal() {
        return this.secondaryVal;
    }

    public void primaryVal(WorldRenderContext vUVnuvunnvuV, List<MediaSessionRegistry.MediaSession> list, MediaSessionRegistry silkJ, MediaPanelInteractionController coo00OCoOo, UUID uUID, boolean bl, long l, int n) {
        this.primaryVal(vUVnuvunnvuV, list, coo00OCoOo);
        this.primaryVal(vUVnuvunnvuV, list, silkJ, coo00OCoOo, n, l);
        this.primaryVal(vUVnuvunnvuV, list, coo00OCoOo, uUID, bl, n);
        this.secondaryVal(vUVnuvunnvuV, list, coo00OCoOo, uUID, bl, n);
    }

    private void primaryVal(WorldRenderContext vUVnuvunnvuV, List<MediaSessionRegistry.MediaSession> list, MediaPanelInteractionController coo00OCoOo) {
        WorldGeometryBuilder cellC = MediaWorldPanelRenderer.primaryVal(vUVnuvunnvuV, WildRenderLayers.primaryVal());
        for (int i = 0; i < list.size(); ++i) {
            this.primaryVal(list.get(i), coo00OCoOo);
            double d = this.primaryVal.chunkVal();
            this.primaryVal(cellC, -this.primaryVal.marginVal() - d, this.primaryVal.marginVal() + d, -this.primaryVal.weightVal() - d, this.primaryVal.weightVal() + d, -0.014, -15592938);
        }
    }

    private void primaryVal(WorldRenderContext vUVnuvunnvuV, List<MediaSessionRegistry.MediaSession> list, MediaSessionRegistry silkJ, MediaPanelInteractionController coo00OCoOo, int n, long l) {
        for (int i = 0; i < list.size(); ++i) {
            MediaSessionRegistry.MediaSession modeVal = list.get(i);
            this.primaryVal(modeVal, coo00OCoOo);
            this.secondaryVal.primaryVal(vUVnuvunnvuV, this.primaryVal, modeVal, silkJ.primaryVal(modeVal, l), n);
        }
    }

    private void primaryVal(WorldRenderContext vUVnuvunnvuV, List<MediaSessionRegistry.MediaSession> list, MediaPanelInteractionController coo00OCoOo, UUID uUID, boolean bl, int n) {
        for (int i = 0; i < list.size(); ++i) {
            int n2;
            MediaSessionRegistry.MediaSession modeVal = list.get(i);
            BrowserTabState nVnnVNuNNVUU2 = this.secondaryVal.secondaryVal(modeVal.id());
            if (nVnnVNuNNVUU2 == null || !MediaPanelInteractionController.primaryVal(modeVal, uUID, bl) || !modeVal.id().equals(coo00OCoOo.secondaryVal())) continue;
            this.primaryVal(modeVal, coo00OCoOo);
            WorldGeometryBuilder cellC = MediaWorldPanelRenderer.primaryVal(vUVnuvunnvuV, WildRenderLayers.marginVal());
            for (n2 = 0; n2 <= nVnnVNuNNVUU2.primaryVal(); ++n2) {
                boolean bl2;
                boolean bl3 = bl2 = n2 == nVnnVNuNNVUU2.primaryVal();
                this.primaryVal(cellC, n2, !bl2 && n2 == nVnnVNuNNVUU2.secondaryVal() ? n : -870704608);
            }
            for (n2 = 0; n2 < nVnnVNuNNVUU2.primaryVal(); ++n2) {
                class_2960 class_29602 = nVnnVNuNNVUU2.secondaryVal(n2);
                if (class_29602 == null) continue;
                this.primaryVal(vUVnuvunnvuV, n2, class_29602);
            }
            this.primaryVal(cellC, nVnnVNuNNVUU2.primaryVal());
        }
    }

    private void secondaryVal(WorldRenderContext vUVnuvunnvuV, List<MediaSessionRegistry.MediaSession> list, MediaPanelInteractionController coo00OCoOo, UUID uUID, boolean bl, int n) {
        WorldGeometryBuilder cellC = MediaWorldPanelRenderer.primaryVal(vUVnuvunnvuV, WildRenderLayers.marginVal());
        for (int i = 0; i < list.size(); ++i) {
            MediaSessionRegistry.MediaSession modeVal = list.get(i);
            this.primaryVal(modeVal, coo00OCoOo);
            if (!MediaPanelInteractionController.primaryVal(modeVal, uUID, bl)) continue;
            if (!MediaWorldPanelRenderer.primaryVal(coo00OCoOo, modeVal.id())) {
                continue;
            }
            boolean bl2 = MediaWorldPanelRenderer.primaryVal(coo00OCoOo, modeVal.id(), VvUUVVVNNUN.MOVE);
            this.primaryVal(cellC, -this.primaryVal.depthVal(), this.primaryVal.depthVal(), this.primaryVal.activeVal(), this.primaryVal.descRef(), 0.012, AimReticleRenderer.primaryVal(bl2 ? n : -1, bl2 ? 0.95f : 0.5f));
        }
    }

    private void primaryVal(WorldGeometryBuilder cellC, int n, int n2) {
        this.primaryVal(cellC, this.primaryVal.primaryVal(n), this.primaryVal.primaryVal(n) + this.primaryVal.holderVal(), this.primaryVal.anchorVal(), this.primaryVal.weightRef(), 0.008, n2);
    }

    private void primaryVal(WorldRenderContext vUVnuvunnvuV, int n, class_2960 class_29602) {
        double d = this.primaryVal.blockRef() * 0.09;
        double d2 = this.primaryVal.primaryVal(n) + d;
        double d3 = this.primaryVal.primaryVal(n) + this.primaryVal.holderVal() - d;
        double d4 = this.primaryVal.anchorVal() + d;
        double d5 = this.primaryVal.weightRef() - d;
        MediaWorldPanelRenderer.primaryVal(vUVnuvunnvuV, WildRenderLayers.secondaryVal(class_29602)).primaryVal(this.primaryVal.primaryVal(d2, 0.011), this.primaryVal.primaryVal(d4), this.primaryVal.secondaryVal(d2, 0.011), this.primaryVal.primaryVal(d3, 0.011), this.primaryVal.primaryVal(d4), this.primaryVal.secondaryVal(d3, 0.011), this.primaryVal.primaryVal(d3, 0.011), this.primaryVal.primaryVal(d5), this.primaryVal.secondaryVal(d3, 0.011), this.primaryVal.primaryVal(d2, 0.011), this.primaryVal.primaryVal(d5), this.primaryVal.secondaryVal(d2, 0.011), 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, -1);
    }

    private void primaryVal(WorldGeometryBuilder cellC, int n) {
        double d = this.primaryVal.primaryVal(n) + this.primaryVal.holderVal() * 0.5;
        double d2 = this.primaryVal.anchorVal() + this.primaryVal.blockRef() * 0.5;
        double d3 = this.primaryVal.blockRef() * 0.22;
        double d4 = this.primaryVal.blockRef() * 0.055;
        this.primaryVal(cellC, d - d3, d + d3, d2 - d4, d2 + d4, 0.013, -855638017);
        this.primaryVal(cellC, d - d4, d + d4, d2 - d3, d2 + d3, 0.013, -855638017);
    }

    private static WorldGeometryBuilder primaryVal(WorldRenderContext vUVnuvunnvuV, class_1921 class_19212) {
        return new WorldGeometryBuilder(vUVnuvunnvuV, vUVnuvunnvuV.secondaryVal().method_23760(), vUVnuvunnvuV.primaryVal(class_19212));
    }

    private void primaryVal(MediaSessionRegistry.MediaSession modeVal, MediaPanelInteractionController coo00OCoOo) {
        if (coo00OCoOo.primaryVal(modeVal.id())) {
            this.primaryVal.primaryVal(coo00OCoOo.paramVal(), coo00OCoOo.extraVal(), coo00OCoOo.limitVal(), coo00OCoOo.speedVal(), coo00OCoOo.widthVal(), coo00OCoOo.chunkVal());
            return;
        }
        this.primaryVal.primaryVal(modeVal);
    }

    private void primaryVal(WorldGeometryBuilder cellC, double d, double d2, double d3, double d4, double d5, int n) {
        cellC.primaryVal(this.primaryVal.primaryVal(d, d5), this.primaryVal.primaryVal(d3), this.primaryVal.secondaryVal(d, d5), this.primaryVal.primaryVal(d2, d5), this.primaryVal.primaryVal(d3), this.primaryVal.secondaryVal(d2, d5), this.primaryVal.primaryVal(d2, d5), this.primaryVal.primaryVal(d4), this.primaryVal.secondaryVal(d2, d5), this.primaryVal.primaryVal(d, d5), this.primaryVal.primaryVal(d4), this.primaryVal.secondaryVal(d, d5), n);
    }

    private static boolean primaryVal(MediaPanelInteractionController coo00OCoOo, UUID uUID) {
        return coo00OCoOo.marginVal() ? coo00OCoOo.primaryVal(uUID) : uUID.equals(coo00OCoOo.secondaryVal());
    }

    private static boolean primaryVal(MediaPanelInteractionController coo00OCoOo, UUID uUID, VvUUVVVNNUN vvUUVVVNNUN) {
        if (coo00OCoOo.marginVal()) {
            return coo00OCoOo.primaryVal(uUID);
        }
        return vvUUVVVNNUN == coo00OCoOo.tertiaryVal() && uUID.equals(coo00OCoOo.primaryVal());
    }
}

