// OverlayWindow.java

package com.example.novoturbo;

import android.content.Context;
import android.view.WindowManager;
import android.view.View;

public class OverlayWindow {
    private final WindowManager windowManager;
    private View overlayView;

    public OverlayWindow(Context context) {
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }

    public void createOverlay(int layoutResource) {
        overlayView = View.inflate(context, layoutResource, null);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        windowManager.addView(overlayView, params);
    }

    public void removeOverlay() {
        if (overlayView != null) {
            windowManager.removeView(overlayView);
        }
    }
}
