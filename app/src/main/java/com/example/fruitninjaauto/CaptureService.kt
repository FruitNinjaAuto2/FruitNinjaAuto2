package com.example.fruitninjaauto

import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.projection.MediaProjection
import android.media.projection.MediaProjectionManager
import android.os.IBinder

class CaptureService : Service() {

    companion object {
        var mediaProjection: MediaProjection? = null

        fun startCapture(
            context: Context,
            resultCode: Int,
            data: Intent
        ) {
            val manager =
                context.getSystemService(Context.MEDIA_PROJECTION_SERVICE)
                        as MediaProjectionManager

            mediaProjection = manager.getMediaProjection(resultCode, data)
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
