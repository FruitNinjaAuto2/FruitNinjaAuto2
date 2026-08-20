package com.example.fruitninjaauto

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder

class CaptureService : Service() {

    companion object {

        fun startCapture(
            context: Context,
            resultCode: Int,
            data: Intent
        ) {
            // سيتم تفعيل التقاط الشاشة بعد نجاح البناء
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
