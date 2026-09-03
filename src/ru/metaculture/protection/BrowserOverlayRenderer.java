/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.cinemamod.mcef.MCEF
 *  com.cinemamod.mcef.MCEFBrowser
 *  net.minecraft.class_2960
 */
package ru.metaculture.protection;

import com.cinemamod.mcef.MCEF;
import com.cinemamod.mcef.MCEFBrowser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.class_2960;
import ru.metaculture.protection.AimReticleRenderer;
import ru.metaculture.protection.WildRenderLayers;
import ru.metaculture.protection.InputSimulator;
import ru.metaculture.protection.WorldRenderContext;
import ru.metaculture.protection.MediaSessionRegistry;
import ru.metaculture.protection.BrowserTabState;
import ru.metaculture.protection.PanelRayHitTester;
import ru.metaculture.protection.WorldGeometryBuilder;
import ru.metaculture.protection.AimOverlayRenderer;

public final class BrowserOverlayRenderer
implements AimOverlayRenderer {
    private static final int primaryVal = 1280;
    private static final int secondaryVal = 720;
    private static final int tertiaryVal = 6;
    private final Map<UUID, BrowserTab> marginVal = new HashMap<UUID, BrowserTab>();
    private final List<UUID> weightVal = new ArrayList<UUID>();
    private final AimOverlayRenderer paramVal = new AimReticleRenderer();

    @Override
    public void primaryVal(List<MediaSessionRegistry.MediaSession> list) {
        this.secondaryVal(list);
        if (!MCEF.isInitialized()) {
            return;
        }
        for (int i = 0; i < list.size(); ++i) {
            MediaSessionRegistry.MediaSession modeVal = list.get(i);
            if (modeVal.source().isEmpty()) {
                this.tertiaryVal(modeVal.id());
                continue;
            }
            this.marginVal.computeIfAbsent(modeVal.id(), uUID -> new BrowserTab()).secondaryVal(modeVal.source());
        }
    }

    @Override
    public InputSimulator primaryVal(UUID uUID) {
        BrowserTab panelVal = this.marginVal.get(uUID);
        MCEFBrowser mCEFBrowser = panelVal == null ? null : panelVal.tertiaryVal();
        return mCEFBrowser == null ? null : new BrowserInputBridge(mCEFBrowser);
    }

    @Override
    public BrowserTabState secondaryVal(UUID uUID) {
        return this.marginVal.get(uUID);
    }

    @Override
    public void primaryVal(WorldRenderContext vUVnuvunnvuV, PanelRayHitTester nnunnunvvuv2, MediaSessionRegistry.MediaSession modeVal, long l, int n) {
        class_2960 class_29602;
        BrowserTab panelVal = this.marginVal.get(modeVal.id());
        class_29602 = panelVal == null ? null : panelVal.secondaryVal(panelVal.secondaryVal());
        if (class_29602 == null) {
            this.paramVal.primaryVal(vUVnuvunnvuV, nnunnunvvuv2, modeVal, l, n);
            return;
        }
        WorldGeometryBuilder cellC = new WorldGeometryBuilder(vUVnuvunnvuV, vUVnuvunnvuV.secondaryVal().method_23760(), vUVnuvunnvuV.primaryVal(WildRenderLayers.secondaryVal(class_29602)));
        double d = -nnunnunvvuv2.marginVal();
        double d2 = nnunnunvvuv2.marginVal();
        double d3 = -nnunnunvvuv2.weightVal();
        double d4 = nnunnunvvuv2.weightVal();
        cellC.primaryVal(nnunnunvvuv2.primaryVal(d, 0.0), nnunnunvvuv2.primaryVal(d3), nnunnunvvuv2.secondaryVal(d, 0.0), nnunnunvvuv2.primaryVal(d2, 0.0), nnunnunvvuv2.primaryVal(d3), nnunnunvvuv2.secondaryVal(d2, 0.0), nnunnunvvuv2.primaryVal(d2, 0.0), nnunnunvvuv2.primaryVal(d4), nnunnunvvuv2.secondaryVal(d2, 0.0), nnunnunvvuv2.primaryVal(d, 0.0), nnunnunvvuv2.primaryVal(d4), nnunnunvvuv2.secondaryVal(d, 0.0), 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, -1);
    }

    @Override
    public void primaryVal() {
        for (BrowserTab panelVal : this.marginVal.values()) {
            panelVal.marginVal();
        }
        this.marginVal.clear();
        this.paramVal.primaryVal();
    }

    private void tertiaryVal(UUID uUID) {
        BrowserTab panelVal = this.marginVal.remove(uUID);
        if (panelVal != null) {
            panelVal.marginVal();
        }
    }

    private void secondaryVal(List<MediaSessionRegistry.MediaSession> list) {
        this.weightVal.clear();
        for (UUID uUID : this.marginVal.keySet()) {
            if (BrowserOverlayRenderer.primaryVal(list, uUID)) continue;
            this.weightVal.add(uUID);
        }
        for (int i = 0; i < this.weightVal.size(); ++i) {
            this.tertiaryVal(this.weightVal.get(i));
        }
    }

    private static boolean primaryVal(List<MediaSessionRegistry.MediaSession> list, UUID uUID) {
        for (int i = 0; i < list.size(); ++i) {
            if (!list.get(i).id().equals(uUID)) continue;
            return true;
        }
        return false;
    }

    static final class BrowserTab
    implements BrowserTabState {
        private final List<MCEFBrowser> primaryVal = new ArrayList<MCEFBrowser>();
        private final List<String> secondaryVal = new ArrayList<String>();
        private int tertiaryVal;

        BrowserTab() {
        }

        @Override
        public int primaryVal() {
            return this.primaryVal.size();
        }

        @Override
        public int secondaryVal() {
            return this.tertiaryVal;
        }

        @Override
        public String primaryVal(int n) {
            return n < 0 || n >= this.secondaryVal.size() ? "" : this.secondaryVal.get(n);
        }

        @Override
        public class_2960 secondaryVal(int n) {
            block3: {
                block2: {
                    if (n < 0) break block2;
                    if (n < this.primaryVal.size()) break block3;
                }
                return null;
            }
            MCEFBrowser mCEFBrowser = this.primaryVal.get(n);
            return mCEFBrowser.isTextureReady() ? mCEFBrowser.getTextureLocation() : null;
        }

        @Override
        public void tertiaryVal(int n) {
            if (n >= 0 && n < this.primaryVal.size()) {
                this.tertiaryVal = n;
            }
        }

        @Override
        public void primaryVal(String string) {
            if (this.primaryVal.size() >= 6 || !string.startsWith("https://")) {
                return;
            }
            this.primaryVal.add(MCEF.createBrowser((String)string, (boolean)false, (int)1280, (int)720));
            this.secondaryVal.add(string);
            this.tertiaryVal = this.primaryVal.size() - 1;
        }

        @Override
        public void marginVal(int n) {
            if (n < 0 || n >= this.primaryVal.size() || this.primaryVal.size() <= 1) {
                return;
            }
            this.primaryVal.remove(n).close();
            this.secondaryVal.remove(n);
            this.tertiaryVal = Math.clamp(this.tertiaryVal >= n ? (long)(this.tertiaryVal - 1) : (long)this.tertiaryVal, 0, this.primaryVal.size() - 1);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        MCEFBrowser tertiaryVal() {
            if (this.tertiaryVal < 0) return null;
            if (this.tertiaryVal >= this.primaryVal.size()) {
                return null;
            }
            MCEFBrowser mCEFBrowser = this.primaryVal.get(this.tertiaryVal);
            return mCEFBrowser;
        }

        void secondaryVal(String string) {
            int n = this.secondaryVal.indexOf(string);
            if (n >= 0) {
                this.tertiaryVal = n;
                return;
            }
            if (this.primaryVal.isEmpty()) {
                this.primaryVal(string);
                return;
            }
            this.primaryVal.get(this.tertiaryVal).loadURL(string);
            this.secondaryVal.set(this.tertiaryVal, string);
        }

        void marginVal() {
            for (int i = 0; i < this.primaryVal.size(); ++i) {
                this.primaryVal.get(i).close();
            }
            this.primaryVal.clear();
            this.secondaryVal.clear();
            this.tertiaryVal = 0;
        }
    }

    record BrowserInputBridge(MCEFBrowser browser) implements InputSimulator
    {
        @Override
        public void moveCursor(float f, float f2) {
            this.browser.sendMouseMove(BrowserInputBridge.pixelX(f), BrowserInputBridge.pixelY(f2));
        }

        @Override
        public void press(float f, float f2, int n) {
            this.browser.sendMousePress(BrowserInputBridge.pixelX(f), BrowserInputBridge.pixelY(f2), n);
        }

        @Override
        public void release(float f, float f2, int n) {
            this.browser.sendMouseRelease(BrowserInputBridge.pixelX(f), BrowserInputBridge.pixelY(f2), n);
        }

        @Override
        public void scroll(float f, float f2, double d) {
            this.browser.sendMouseWheel(BrowserInputBridge.pixelX(f), BrowserInputBridge.pixelY(f2), d, 0);
        }

        @Override
        public void keyPress(int n, int n2, int n3) {
            this.browser.sendKeyPress(n, (long)n2, n3);
        }

        @Override
        public void keyRelease(int n, int n2, int n3) {
            this.browser.sendKeyRelease(n, (long)n2, n3);
        }

        @Override
        public void type(char c, int n) {
            this.browser.sendKeyTyped(c, n);
        }

        private static int pixelX(float f) {
            return Math.round(Math.max(0.0f, Math.min(1.0f, f)) * 1280.0f);
        }

        private static int pixelY(float f) {
            return Math.round(Math.max(0.0f, Math.min(1.0f, f)) * 720.0f);
        }
    }
}

