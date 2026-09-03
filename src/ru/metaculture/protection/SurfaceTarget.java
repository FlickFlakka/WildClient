/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public enum SurfaceTarget {
    PREVIEW_ONLY("preview", "Preview", "live editor preview", false, false, false, false, false),
    HUD("hud", "HUD", "screen-space HUD shader", false, true, false, false, true),
    MODULE_CARD("module_card", "Module Card", "module row surface and hover body", false, true, false, false, true),
    PANEL_BACKGROUND("panel_background", "Panel Background", "dock and settings panel surface", true, false, false, false, true),
    AUDIT_PANEL("audit_panel", "Audit Panel", "verification and diagnostics panel surface", true, true, false, false, false),
    BUTTON("button", "Button", "interactive button surface", false, true, false, false, true),
    HEALTH_BAR("health_bar", "Health Bar", "bar fill and shield style shader", false, true, false, false, true),
    ESP("esp", "ESP", "entity silhouette shader", false, false, true, false, true),
    CHAMS("chams", "Chams", "model-space entity material overlay", false, false, true, true, true),
    SKY("sky", "Sky", "world sky and atmospheric pass", false, false, false, false, true),
    NAMETAG("nametag", "Nametag", "billboard nametag surface", false, true, false, true, true),
    TRAILS("trails", "Trails", "motion trail ribbon material", false, false, true, true, true),
    BACKGROUND("background", "Background", "full-screen interface background", true, false, false, false, true),
    MENU_BACKGROUND("menu_bg", "Menu Background", "legacy full ClickGUI background", true, false, false, false, false),
    MENU_PANEL_BG("menu_panel", "Panel Background", "legacy panel surface", true, false, false, false, false),
    HUD_OVERLAY("hud_overlay", "HUD Overlay", "legacy HUD overlay", false, true, false, false, false),
    ESP_OVERLAY("esp_overlay", "ESP Overlay", "legacy ESP fill", false, false, true, false, false),
    ENTITY_HIGHLIGHT("entity_highlight", "Entity Highlight", "legacy entity highlight", false, false, false, true, false);
    private final String primaryVal;
    private final String secondaryVal;
    private final String tertiaryVal;
    private final boolean marginVal;
    private final boolean weightVal;
    private final boolean paramVal;
    private final boolean extraVal;
    private final boolean limitVal;
    private SurfaceTarget(String string2, String string3, String string4, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.primaryVal = string2;
        this.secondaryVal = string3;
        this.tertiaryVal = string4;
        this.marginVal = bl;
        this.weightVal = bl2;
        this.paramVal = bl3;
        this.extraVal = bl4;
        this.limitVal = bl5;
    }

    public String primaryVal() {
        return this.primaryVal;
    }

    public String secondaryVal() {
        return this.secondaryVal;
    }

    public String tertiaryVal() {
        return this.tertiaryVal;
    }

    public SurfaceTarget marginVal() {
        return switch (this.ordinal()) {
            default -> throw new MatchException(null, null);
            case 7, 8, 11, 16, 17 -> ESP;
            case 1, 2, 3, 4, 5, 6, 10, 14, 15 -> HUD;
            case 9, 12, 13 -> BACKGROUND;
            case 0 -> PREVIEW_ONLY;
        };
    }

    public String weightVal() {
        return switch (this.ordinal()) {
            default -> throw new MatchException(null, null);
            case 1, 2, 5, 6, 15 -> "HUD";
            case 3, 4, 12, 13, 14 -> "Interface";
            case 7, 8, 10, 11, 16, 17 -> "Entity";
            case 9 -> "World";
            case 0 -> "System";
        };
    }

    public boolean paramVal() {
        return this.marginVal() == HUD || this == PANEL_BACKGROUND || this == AUDIT_PANEL || this == MENU_PANEL_BG;
    }

    public boolean extraVal() {
        return this.limitVal;
    }

    public boolean limitVal() {
        return this.marginVal() == ESP;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean speedVal() {
        if (this.marginVal() != BACKGROUND) return false;
        if (this == BACKGROUND) return true;
        if (this != MENU_BACKGROUND) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean widthVal() {
        if (!this.marginVal) return false;
        if (this == MENU_PANEL_BG) return true;
        if (this == PANEL_BACKGROUND) return true;
        if (this != AUDIT_PANEL) return false;
        return true;
    }

    public boolean chunkVal() {
        return this.marginVal() == HUD;
    }

    public boolean blockRef() {
        return this.marginVal() == ESP && !this.extraVal;
    }

    public boolean holderVal() {
        return this.extraVal;
    }

    public static SurfaceTarget[] timerVal() {
        SurfaceTarget[] vnuVUNUvArray = new SurfaceTarget[3];
        vnuVUNUvArray[0] = HUD;
        vnuVUNUvArray[1] = BACKGROUND;
        vnuVUNUvArray[2] = ESP;
        return vnuVUNUvArray;
    }

    public static SurfaceTarget primaryVal(String string) {
        if (string == null) {
            return PREVIEW_ONLY;
        }
        String string2 = string.trim();
        for (SurfaceTarget vnuVUNUv : SurfaceTarget.values()) {
            if (!vnuVUNUv.primaryVal.equals(string2)) {
                if (!vnuVUNUv.name().equalsIgnoreCase(string2)) continue;
            }
            return vnuVUNUv;
        }
        return PREVIEW_ONLY;
    }}

