// BackgroundKiller.java

package com.example.novoturbo;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;

public class BackgroundKiller {
    private final Context context;

    public BackgroundKiller(Context context) {
        this.context = context;
    }

    public void killBackgroundProcesses() {
        ActivityManager activityManager = (ActivityManager)
                context.getSystemService(Context.ACTIVITY_SERVICE);
        for (String appPackage : activityManager.getRunningAppProcesses()) {
            if (appPackage.equals(context.getPackageName())) {
                Process.killProcess(Process.myPid());
            }
        }
    }
}
