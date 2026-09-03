/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public final class NodeGraphMetadata {
    private String primaryVal = "";
    private String secondaryVal = "";
    private String tertiaryVal = "";
    private String marginVal = "Custom";
    private String weightVal = "local";
    private String paramVal = "Host Rectangle";
    private String extraVal = "";
    private long limitVal;
    private long speedVal;
    private boolean widthVal;

    public NodeGraphMetadata() {
        long l;
        this.limitVal = l = System.currentTimeMillis();
        this.speedVal = l;
    }

    public NodeGraphMetadata primaryVal() {
        NodeGraphMetadata itemH = new NodeGraphMetadata();
        itemH.primaryVal(this);
        return itemH;
    }

    public void primaryVal(NodeGraphMetadata itemH) {
        if (itemH == null) {
            return;
        }
        this.primaryVal = itemH.primaryVal;
        this.secondaryVal = itemH.secondaryVal;
        this.tertiaryVal = itemH.tertiaryVal;
        this.marginVal = itemH.marginVal;
        this.weightVal = itemH.weightVal;
        this.paramVal = itemH.paramVal;
        this.extraVal = itemH.extraVal;
        this.limitVal = itemH.limitVal;
        this.speedVal = itemH.speedVal;
        this.widthVal = itemH.widthVal;
    }

    public String secondaryVal() {
        return this.primaryVal;
    }

    public void primaryVal(String string) {
        this.primaryVal = NodeGraphMetadata.limitVal(string);
    }

    public String tertiaryVal() {
        return this.secondaryVal;
    }

    public void secondaryVal(String string) {
        this.secondaryVal = NodeGraphMetadata.limitVal(string);
    }

    public String marginVal() {
        return this.tertiaryVal;
    }

    public void tertiaryVal(String string) {
        this.tertiaryVal = NodeGraphMetadata.limitVal(string);
    }

    public String weightVal() {
        return this.marginVal;
    }

    public void marginVal(String string) {
        String string2 = NodeGraphMetadata.limitVal(string);
        this.marginVal = string2.isBlank() ? "Custom" : string2;
    }

    public String paramVal() {
        return this.weightVal;
    }

    public void weightVal(String string) {
        String string2 = NodeGraphMetadata.limitVal(string);
        this.weightVal = string2.isBlank() ? "local" : string2;
    }

    public String extraVal() {
        return this.paramVal;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void paramVal(String string) {
        String string2 = NodeGraphMetadata.limitVal(string);
        if (!"Inset Shape".equals(string2) && !"Full Quad".equals(string2)) {
            this.paramVal = "Host Rectangle";
            return;
        }
        this.paramVal = string2;
    }

    public String limitVal() {
        return this.extraVal;
    }

    public void extraVal(String string) {
        this.extraVal = NodeGraphMetadata.limitVal(string);
    }

    public long speedVal() {
        return this.limitVal;
    }

    public void primaryVal(long l) {
        this.limitVal = Math.max(0L, l);
    }

    public long widthVal() {
        return this.speedVal;
    }

    public void secondaryVal(long l) {
        this.speedVal = Math.max(0L, l);
    }

    public boolean chunkVal() {
        return this.widthVal;
    }

    public void primaryVal(boolean bl) {
        this.widthVal = bl;
    }

    public void primaryVal(String string, String string2) {
        long l = System.currentTimeMillis();
        if (this.limitVal <= 0L) {
            this.limitVal = l;
        }
        if (this.speedVal <= 0L) {
            this.speedVal = l;
        }
        if (this.primaryVal.isBlank()) {
            this.primaryVal(string);
        }
        if (this.secondaryVal.isBlank()) {
            this.secondaryVal(string2);
        }
        if (this.marginVal.isBlank()) {
            this.marginVal = "Custom";
        }
        if (this.weightVal.isBlank()) {
            this.weightVal = "local";
        }
        if (this.paramVal.isBlank()) {
            this.paramVal = "Host Rectangle";
        }
    }

    private static String limitVal(String string) {
        if (string == null) {
            return "";
        }
        String string2 = string.trim().replaceAll("\\s+", " ");
        return string2.length() > 128 ? string2.substring(0, 128) : string2;
    }
}

