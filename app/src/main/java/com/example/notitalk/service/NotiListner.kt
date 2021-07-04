package com.example.notitalk.service

import android.app.Notification
import android.graphics.drawable.Icon
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log


class NotiListener: NotificationListenerService() {

    private val TAG = "NOTIFI"

    override fun onListenerConnected() {
        super.onListenerConnected()
        Log.e("kobbi","MyNotificationListener.onListenerConnected()")
        Log.d("NotificationListener", "CONNECTED NOTIFICATION LISTENER");
    }

    override fun onListenerDisconnected() {
        super.onListenerDisconnected()
        Log.e("kobbi","MyNotificationListener.onListenerDisconnected()")
        Log.d("NotificationListener", "DISCONNECTED NOTIFICATION LISTENER");
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification) {
        super.onNotificationRemoved(sbn)
        Log.d(
            TAG, "onNotificationRemoved ~ " +
                    " packageName: " + sbn.packageName +
                    " id: " + sbn.id
        )
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        super.onNotificationPosted(sbn)
        val notification: Notification = sbn.notification
        val extras = sbn.notification.extras
        val title = extras.getString(Notification.EXTRA_TITLE)
        val text = extras.getCharSequence(Notification.EXTRA_TEXT)
        val subText = extras.getCharSequence(Notification.EXTRA_SUB_TEXT)
//        val smallIcon: Icon = notification.getSmallIcon()
//        val largeIcon: Icon = notification.getLargeIcon()
        Log.d(
            TAG, "onNotificationPosted ~ " +
                    " packageName: " + sbn.packageName +
                    " id: " + sbn.id +
                    " postTime: " + sbn.postTime +
                    " title: " + title +
                    " text : " + text +
                    " subText: " + subText
        )
    }
}