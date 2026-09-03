/*
 * Decompiled with CFR 0.152.
 */
package ru.metaculture.protection;

public interface InputSimulator {
    public void moveCursor(float var1, float var2);

    public void press(float var1, float var2, int var3);

    public void release(float var1, float var2, int var3);

    public void scroll(float var1, float var2, double var3);

    public void keyPress(int var1, int var2, int var3);

    public void keyRelease(int var1, int var2, int var3);

    public void type(char var1, int var2);
}

