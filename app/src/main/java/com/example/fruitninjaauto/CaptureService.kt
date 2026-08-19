package com.example.fruitninjaauto

import android.app.Service
import android.content.Intent
import android.media.projection.MediaProjection
import android.os.IBinder

class CaptureService : Service() {

    companion object {
        var mediaProjection: MediaProjection? = null

        fun start(
            service: CaptureService,
            resultCode: Int,
            data: Intent
        ) {
            val manager =
                service.getSystemService(MEDIA_PROJECTION_SERVICE)
                        as android.media.projection.MediaProjectionManager

            mediaProjection =
                manager.getMediaProjection(resultCode, data)
        }
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
