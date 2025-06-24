package com.autonotify

import android.service.quicksettings.TileService
import android.content.Intent

class TileReceiver : TileService() {
    override fun onClick() {
        // Opens minimal UI activity
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivityAndCollapse(intent)
    }
}
