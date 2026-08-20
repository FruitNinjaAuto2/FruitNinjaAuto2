package com.example.fruitninjaauto

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.view.accessibility.AccessibilityEvent
import android.os.Handler
import android.os.Looper

class FruitAccessibilityService : AccessibilityService() {

    private val handler = Handler(Looper.getMainLooper())
    private var running = false

    override fun onServiceConnected() {
        super.onServiceConnected()

        running = true
        startCutting()
    }

    private fun startCutting() {
        if (!running) return

        // حركة تجريبية من اليسار إلى اليمين
        swipe(150f, 900f, 930f, 500f)

        handler.postDelayed({
            if (running) {
                swipe(150f, 650f, 930f, 300f)
            }
        }, 250)

        handler.postDelayed({
            if (running) {
                startCutting()
            }
        }, 600)
    }

    private fun swipe(
        startX: Float,
        startY: Float,
        endX: Float,
        endY: Float
    ) {
        val path = Path()
        path.moveTo(startX, startY)
        path.lineTo(endX, endY)

        val gesture = GestureDescription.Builder()
            .addStroke(
                GestureDescription.StrokeDescription(
                    path,
                    0,
                    300
                )
            )
            .build()

        dispatchGesture(gesture, null, null)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // لاحقاً نضيف هنا منطق اكتشاف الفواكه
    }

    override fun onInterrupt() {
        running = false
        handler.removeCallbacksAndMessages(null)
    }
}
