package com.example.fruitninjaauto

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class FruitAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // حاليًا لا ينفذ أي حركة تلقائية
    }

    override fun onInterrupt() {
        // إيقاف الخدمة
    }
}
