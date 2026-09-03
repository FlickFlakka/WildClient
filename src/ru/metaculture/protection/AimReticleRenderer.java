/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.List;
import java.util.UUID;
import ru.metaculture.protection.WildRenderLayers;
import ru.metaculture.protection.InputSimulator;
import ru.metaculture.protection.WorldRenderContext;
import ru.metaculture.protection.MediaSessionRegistry;
import ru.metaculture.protection.BrowserTabState;
import ru.metaculture.protection.PanelRayHitTester;
import ru.metaculture.protection.WorldGeometryBuilder;
import ru.metaculture.protection.AimOverlayRenderer;

public final class AimReticleRenderer
implements AimOverlayRenderer {
    @Override
    public void primaryVal(List<MediaSessionRegistry.MediaSession> list) {
    }

    @Override
    public InputSimulator primaryVal(UUID uUID) {
        return null;
    }

    @Override
    public BrowserTabState secondaryVal(UUID uUID) {
        return null;
    }

    @Override
    public void primaryVal(WorldRenderContext vUVnuvunnvuV, PanelRayHitTester nnunnunvvuv2, MediaSessionRegistry.MediaSession modeVal, long l, int n) {
        WorldGeometryBuilder cellC = new WorldGeometryBuilder(vUVnuvunnvuV, vUVnuvunnvuV.secondaryVal().method_23760(), vUVnuvunnvuV.primaryVal(WildRenderLayers.marginVal()));
        this.primaryVal(cellC, nnunnunvvuv2, -nnunnunvvuv2.marginVal(), nnunnunvvuv2.marginVal(), -nnunnunvvuv2.weightVal(), nnunnunvvuv2.weightVal(), 0.0, -15987696);
        float f = 0.25f + 0.35f * (float)Math.abs(Math.sin((double)System.currentTimeMillis() / 600.0));
        double d = nnunnunvvuv2.marginVal() * 0.06;
        double d2 = Math.min(d * 0.22, nnunnunvvuv2.weightVal() * 0.03);
        this.primaryVal(cellC, nnunnunvvuv2, -d, d, -d2, d2, 0.002, AimReticleRenderer.primaryVal(n, f));
    }

    @Override
    public void primaryVal() {
    }

    static int primaryVal(int n, float f) {
        int n2 = Math.round(Math.max(0.0f, Math.min(1.0f, f)) * (float)(n >>> 24 & 0xFF));
        return n2 << 24 | n & 0xFFFFFF;
    }

    private void primaryVal(WorldGeometryBuilder cellC, PanelRayHitTester nnunnunvvuv2, double d, double d2, double d3, double d4, double d5, int n) {
        cellC.primaryVal(nnunnunvvuv2.primaryVal(d, d5), nnunnunvvuv2.primaryVal(d3), nnunnunvvuv2.secondaryVal(d, d5), nnunnunvvuv2.primaryVal(d2, d5), nnunnunvvuv2.primaryVal(d3), nnunnunvvuv2.secondaryVal(d2, d5), nnunnunvvuv2.primaryVal(d2, d5), nnunnunvvuv2.primaryVal(d4), nnunnunvvuv2.secondaryVal(d2, d5), nnunnunvvuv2.primaryVal(d, d5), nnunnunvvuv2.primaryVal(d4), nnunnunvvuv2.secondaryVal(d, d5), n);
    }
}

