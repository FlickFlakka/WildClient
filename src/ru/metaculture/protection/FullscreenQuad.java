/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.opengl.GL15
 *  org.lwjgl.opengl.GL20
 *  org.lwjgl.opengl.GL30
 */
package ru.metaculture.protection;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public final class FullscreenQuad
implements AutoCloseable {
    private final int primaryVal = GL30.glGenVertexArrays();
    private final int secondaryVal = GL15.glGenBuffers();

    public FullscreenQuad() {
        GL30.glBindVertexArray((int)this.primaryVal);
        GL15.glBindBuffer((int)34962, (int)this.secondaryVal);
        float[] fArray = new float[12];
        fArray[0] = 0.0f;
        fArray[1] = 0.0f;
        fArray[2] = 1.0f;
        fArray[3] = 0.0f;
        fArray[4] = 1.0f;
        fArray[5] = 1.0f;
        fArray[6] = 0.0f;
        fArray[7] = 0.0f;
        fArray[8] = 1.0f;
        fArray[9] = 1.0f;
        fArray[10] = 0.0f;
        fArray[11] = 1.0f;
        float[] fArray2 = fArray;
        GL15.glBufferData((int)34962, (float[])fArray2, (int)35044);
        GL20.glEnableVertexAttribArray((int)0);
        GL20.glVertexAttribPointer((int)0, (int)2, (int)5126, (boolean)false, (int)8, (long)0L);
        GL15.glBindBuffer((int)34962, (int)0);
        GL30.glBindVertexArray((int)0);
    }

    public void primaryVal() {
        GL30.glBindVertexArray((int)this.primaryVal);
        GL11.glDrawArrays((int)4, (int)0, (int)6);
        GL30.glBindVertexArray((int)0);
    }

    @Override
    public void close() {
        GL30.glDeleteVertexArrays((int)this.primaryVal);
        GL15.glDeleteBuffers((int)this.secondaryVal);
    }
}

