/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.List;
import java.util.UUID;
import ru.metaculture.protection.InputSimulator;
import ru.metaculture.protection.WorldRenderContext;
import ru.metaculture.protection.MediaSessionRegistry;
import ru.metaculture.protection.BrowserTabState;
import ru.metaculture.protection.PanelRayHitTester;

public interface AimOverlayRenderer {
    public void primaryVal(List<MediaSessionRegistry.MediaSession> var1);

    public InputSimulator primaryVal(UUID var1);

    public BrowserTabState secondaryVal(UUID var1);

    public void primaryVal(WorldRenderContext var1, PanelRayHitTester var2, MediaSessionRegistry.MediaSession var3, long var4, int var6);

    public void primaryVal();
}

