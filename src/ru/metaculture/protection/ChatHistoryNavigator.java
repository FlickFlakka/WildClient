/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

import java.util.ArrayDeque;

public final class ChatHistoryNavigator {
    private static final int primaryVal = 50;
    private final ArrayDeque<String> secondaryVal = new ArrayDeque();
    private final ArrayDeque<String> tertiaryVal = new ArrayDeque();

    public void primaryVal(String string) {
        if (string == null || string.equals(this.secondaryVal.peekLast())) {
            return;
        }
        this.secondaryVal.addLast(string);
        while (this.secondaryVal.size() > 50) {
            this.secondaryVal.pollFirst();
        }
        this.tertiaryVal.clear();
    }

    public String secondaryVal(String string) {
        if (string == null) {
            return null;
        }
        while (!this.secondaryVal.isEmpty()) {
            if (!string.equals(this.secondaryVal.peekLast())) break;
            this.secondaryVal.pollLast();
        }
        if (this.secondaryVal.isEmpty()) {
            return null;
        }
        this.tertiaryVal.addLast(string);
        return this.secondaryVal.pollLast();
    }

    public String tertiaryVal(String string) {
        if (string == null) {
            return null;
        }
        while (!this.tertiaryVal.isEmpty()) {
            if (!string.equals(this.tertiaryVal.peekLast())) break;
            this.tertiaryVal.pollLast();
        }
        if (this.tertiaryVal.isEmpty()) {
            return null;
        }
        this.secondaryVal.addLast(string);
        return this.tertiaryVal.pollLast();
    }

    public boolean primaryVal() {
        return !this.secondaryVal.isEmpty();
    }

    public boolean secondaryVal() {
        return !this.tertiaryVal.isEmpty();
    }

    public void tertiaryVal() {
        this.secondaryVal.clear();
        this.tertiaryVal.clear();
    }
}

