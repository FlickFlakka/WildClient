/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_2561
 *  net.minecraft.class_332
 *  net.minecraft.class_437
 */
package ru.metaculture.protection;

import net.minecraft.class_2561;
import net.minecraft.class_332;
import net.minecraft.class_437;
import ru.metaculture.protection.MenuModule;
import ru.metaculture.protection.UnUvnuVNNN;
import ru.metaculture.protection.Renderer2D;
import ru.metaculture.protection.VvNUnuUUuN;

public final class ModernClickGuiScreen
extends class_437 {
    private final UnUvnuVNNN primaryVal = new UnUvnuVNNN();

    public ModernClickGuiScreen() {
        super((class_2561)class_2561.method_43470((String)"Wild Modern ClickGUI"));
    }

    public UnUvnuVNNN primaryVal() {
        return this.primaryVal;
    }

    protected void method_25426() {
        super.method_25426();
        this.primaryVal.primaryVal(this.field_22787);
        VvNUnuUUuN.tertiaryVal();
    }

    public void method_25394(class_332 class_3322, int n, int n2, float f) {
        if (!this.tertiaryVal()) {
            this.primaryVal.extraVal();
            return;
        }
        this.primaryVal.primaryVal(this.primaryVal(n), this.secondaryVal(n2));
    }

    public void method_25420(class_332 class_3322, int n, int n2, float f) {
    }

    public void method_52752(class_332 class_3322) {
    }

    public void primaryVal(Renderer2D heightVal, class_332 class_3322, int n, int n2, float f) {
        if (!this.secondaryVal(n, n2)) {
            this.primaryVal.extraVal();
            return;
        }
        this.primaryVal.primaryVal(this.field_22787, class_3322, heightVal, n, n2, f);
        if (this.primaryVal.tertiaryVal()) {
            this.weightVal();
        }
    }

    public boolean method_25402(double d, double d2, int n) {
        if (!this.tertiaryVal()) {
            this.primaryVal.extraVal();
            return true;
        }
        if (this.primaryVal.marginVal()) {
            return true;
        }
        this.primaryVal.primaryVal(this.primaryVal(d), this.secondaryVal(d2), n);
        return true;
    }

    public boolean method_25406(double d, double d2, int n) {
        if (!this.tertiaryVal()) {
            this.primaryVal.extraVal();
            return true;
        }
        if (this.primaryVal.marginVal()) {
            return true;
        }
        this.primaryVal.secondaryVal(this.primaryVal(d), this.secondaryVal(d2), n);
        return true;
    }

    public boolean method_25403(double d, double d2, int n, double d3, double d4) {
        if (!this.tertiaryVal()) {
            this.primaryVal.extraVal();
            return true;
        }
        if (this.primaryVal.marginVal()) {
            return true;
        }
        this.primaryVal.primaryVal(this.primaryVal(d), this.secondaryVal(d2), n, this.tertiaryVal(d3), this.marginVal(d4));
        return true;
    }

    public boolean method_25401(double d, double d2, double d3, double d4) {
        double d5;
        double d6;
        block5: {
            block6: {
                if (!this.tertiaryVal()) {
                    this.primaryVal.extraVal();
                    return true;
                }
                if (this.primaryVal.marginVal()) {
                    return true;
                }
                d6 = d3;
                d5 = d4;
                if (d6 != 0.0) break block5;
                if (ModernClickGuiScreen.method_25442()) break block6;
                if (!ModernClickGuiScreen.method_25441()) break block5;
            }
            d6 = d4;
            d5 = 0.0;
        }
        this.primaryVal.primaryVal(this.primaryVal(d), this.secondaryVal(d2), d6, d5);
        return true;
    }

    public boolean method_25404(int n, int n2, int n3) {
        if (n == 300) {
            return super.method_25404(n, n2, n3);
        }
        if (!this.tertiaryVal()) {
            this.primaryVal.extraVal();
            return true;
        }
        if (n == 256 && this.primaryVal.marginVal()) {
            this.weightVal();
            return true;
        }
        if (n == this.marginVal()) {
            if (!this.primaryVal.weightVal()) {
                this.method_25419();
                return true;
            }
        }
        if (this.primaryVal.marginVal()) {
            return true;
        }
        if (this.primaryVal.primaryVal(n)) {
            return true;
        }
        return super.method_25404(n, n2, n3);
    }

    public boolean method_25400(char c, int n) {
        if (!this.tertiaryVal()) {
            this.primaryVal.extraVal();
            return true;
        }
        if (this.primaryVal.marginVal()) {
            return true;
        }
        if (this.primaryVal.primaryVal(c)) {
            return true;
        }
        return super.method_25400(c, n);
    }

    public void method_25419() {
        if (!this.primaryVal.secondaryVal()) {
            this.weightVal();
        }
    }

    public void method_25432() {
        this.primaryVal.limitVal();
        super.method_25432();
    }

    public boolean method_25421() {
        return false;
    }

    public void primaryVal(int n, int n2) {
        block3: {
            block2: {
                if (n <= 0) break block2;
                if (n2 > 0) break block3;
            }
            this.primaryVal.extraVal();
        }
    }

    public void primaryVal(boolean bl) {
        if (!bl) {
            this.primaryVal.extraVal();
        }
    }

    private float primaryVal(double d) {
        if (this.field_22787 == null || this.field_22787.method_22683() == null) {
            return (float)d;
        }
        int n = this.field_22787.method_22683().method_4489();
        int n2 = this.field_22787.method_22683().method_4486();
        if (n <= 0 || n2 <= 0) {
            return (float)d;
        }
        return (float)(d * (double)n / Math.max(1.0, (double)n2));
    }

    private float secondaryVal(double d) {
        if (this.field_22787 == null || this.field_22787.method_22683() == null) {
            return (float)d;
        }
        int n = this.field_22787.method_22683().method_4506();
        int n2 = this.field_22787.method_22683().method_4502();
        if (n <= 0 || n2 <= 0) {
            return (float)d;
        }
        return (float)(d * (double)n / Math.max(1.0, (double)n2));
    }

    private float tertiaryVal(double d) {
        int n;
        int n2;
        block5: {
            block4: {
                if (this.field_22787 == null || this.field_22787.method_22683() == null) {
                    return (float)d;
                }
                n2 = this.field_22787.method_22683().method_4489();
                n = this.field_22787.method_22683().method_4486();
                if (n2 <= 0) break block4;
                if (n > 0) break block5;
            }
            return (float)d;
        }
        return (float)(d * (double)n2 / Math.max(1.0, (double)n));
    }

    private float marginVal(double d) {
        if (this.field_22787 == null || this.field_22787.method_22683() == null) {
            return (float)d;
        }
        int n = this.field_22787.method_22683().method_4506();
        int n2 = this.field_22787.method_22683().method_4502();
        if (n <= 0 || n2 <= 0) {
            return (float)d;
        }
        return (float)(d * (double)n / Math.max(1.0, (double)n2));
    }

    private boolean secondaryVal() {
        if (this.field_22787 == null || this.field_22787.method_22683() == null) {
            return false;
        }
        return this.secondaryVal(this.field_22787.method_22683().method_4489(), this.field_22787.method_22683().method_4506());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean secondaryVal(int n, int n2) {
        if (this.field_22787 == null) return false;
        if (this.field_22787.method_22683() == null) {
            return false;
        }
        if (n <= 0) return false;
        if (n2 <= 0) return false;
        if (this.field_22787.method_22683().method_4489() <= 0) return false;
        if (this.field_22787.method_22683().method_4506() <= 0) return false;
        if (this.field_22787.method_22683().method_4486() <= 0) return false;
        if (this.field_22787.method_22683().method_4502() <= 0) return false;
        return true;
    }

    private boolean tertiaryVal() {
        return this.secondaryVal() && this.field_22787.method_1569();
    }

    private int marginVal() {
        MenuModule nnNvuuvuNu = MenuModule.anchorVal();
        return nnNvuuvuNu == null || nnNvuuvuNu.keyIndex == -1 ? 344 : nnNvuuvuNu.keyIndex;
    }

    private void weightVal() {
        this.primaryVal.limitVal();
        if (this.field_22787 != null) {
            this.field_22787.method_1507(null);
        }
    }
}

