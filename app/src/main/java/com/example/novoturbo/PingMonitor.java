// PingMonitor.java

package com.example.novoturbo;

public class PingMonitor {
    public void startMonitoring() {
        new Thread(() -> {
            while (true) {
                // Simulated ping check
                System.out.println("Pinging server...");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}
