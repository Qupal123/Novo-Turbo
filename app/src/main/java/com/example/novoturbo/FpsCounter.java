// FpsCounter.java

package com.example.novoturbo;

public class FpsCounter {
    private int frames;
    private long lastTime;

    public FpsCounter() {
        frames = 0;
        lastTime = System.currentTimeMillis();
    }

    public void tick() {
        frames++;
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime >= 1000) {
            System.out.println("FPS: " + frames);
            frames = 0;
            lastTime = currentTime;
        }
    }
}
