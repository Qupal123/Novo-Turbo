// GameDetector.java

package com.example.novoturbo;

import android.app.ActivityManager;
import android.content.Context;
import java.util.List;

public class GameDetector {
    private final Context context;

    public GameDetector(Context context) {
        this.context = context;
    }

    public boolean isGameRunning(String gamePackage) {
        ActivityManager activityManager = (ActivityManager)
                context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningProcesses =
                activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo process : runningProcesses) {
            if (process.processName.equals(gamePackage)) {
                return true;
            }
        }
        return false;
    }
}
