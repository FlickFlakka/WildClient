/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class PartyState {
    private final List<Member> primaryVal = new ArrayList<Member>();
    private UUID secondaryVal;
    private UUID tertiaryVal;
    private String marginVal = "";

    public boolean primaryVal() {
        return this.secondaryVal != null;
    }

    public String secondaryVal() {
        return this.marginVal;
    }

    public UUID tertiaryVal() {
        return this.tertiaryVal;
    }

    public List<Member> marginVal() {
        return Collections.unmodifiableList(this.primaryVal);
    }

    public int weightVal() {
        return this.primaryVal.size();
    }

    public boolean primaryVal(UUID uUID) {
        return this.tertiaryVal != null && this.tertiaryVal.equals(uUID);
    }

    public Member primaryVal(String string) {
        for (Member modeVal : this.primaryVal) {
            if (!modeVal.username().equalsIgnoreCase(string)) continue;
            return modeVal;
        }
        return null;
    }

    void primaryVal(UUID uUID, UUID uUID2, String string, List<Member> list) {
        this.secondaryVal = uUID;
        this.tertiaryVal = uUID2;
        this.marginVal = string == null ? "" : string;
        this.primaryVal.clear();
        this.primaryVal.addAll(list);
    }

    void paramVal() {
        this.secondaryVal = null;
        this.tertiaryVal = null;
        this.marginVal = "";
        this.primaryVal.clear();
    }

    public record Member(UUID uuid, String username) {
    }
}

