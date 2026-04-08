package com.example.novoturbo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button boostButton;
    private PermissionHelper permissionHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionHelper = new PermissionHelper(this);
        boostButton = findViewById(R.id.boost_button);

        checkAndRequestPermissions();

        boostButton.setOnClickListener(v -> handleBoostClick());
    }

    private void checkAndRequestPermissions() {
        if (!Settings.canDrawOverlays(this)) {
            Toast.makeText(this, "Нужно разрешение на оверлей", Toast.LENGTH_SHORT).show();
            permissionHelper.requestOverlayPermission();
        }

        if (!permissionHelper.hasUsageStatsPermission()) {
            Toast.makeText(this, "Нужен доступ к статистике", Toast.LENGTH_SHORT).show();
            permissionHelper.requestUsageStatsPermission();
        }
    }

    private void handleBoostClick() {
        if (!Settings.canDrawOverlays(this)) {
            Toast.makeText(this, "Сначала разрешите оверлей", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, OverlayService.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent);
        } else {
            startService(intent);
        }

        Intent detectorIntent = new Intent(this, GameDetector.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(detectorIntent);
        } else {
            startService(detectorIntent);
        }

        Toast.makeText(this, "Boost активирован!", Toast.LENGTH_SHORT).show();
    }
}