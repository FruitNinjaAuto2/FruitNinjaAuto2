package com.example.fruitninjaauto

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.view.accessibility.AccessibilityEvent

class FruitAccessibilityService : AccessibilityService() {

    private var running = false

    override fun onServiceConnected() {
        super.onServiceConnected()

        // الخدمة تشتغل، لكن لا تبدأ السحب تلقائيًا
        running = false
    }

    private fun startCutting() {
        if (running) return

        running = true

        swipe(150f, 900f, 930f, 500f)

        android.os.Handler(mainLooper).postDelayed({
            if (running) {
                swipe(150f, 650f, 930f, 300f)
            }
        }, 250)

        android.os.Handler(mainLooper).postDelayed({
            if (running) {
                running = false
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
        // لا يوجد تشغيل تلقائي حاليًا
    }

    override fun onInterrupt() {
        running = false
    }
}
