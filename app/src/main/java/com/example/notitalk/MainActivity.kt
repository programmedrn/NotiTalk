package com.example.notitalk

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("MAIN ACTIVITY", "on load")
        setContentView(R.layout.activity_main)
//        if (permissionGranted())
//            startActivity(Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

    /**
     * Notification 접근 권한 체크 메서드
     * @return 접근권한이 있을 경우 true, 아니면 false
     */
    private fun isNotificationPermissionAllowed(): Boolean {
        return NotificationManagerCompat.getEnabledListenerPackages(applicationContext)
            .any { enabledPackageName ->
                enabledPackageName == packageName
            }
    }

    private fun permissionGranted(): Boolean {
        val sets =
            NotificationManagerCompat.getEnabledListenerPackages(this)
        return sets.contains(packageName)
    }
}