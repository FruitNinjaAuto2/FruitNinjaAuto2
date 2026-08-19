package com.example.fruitninjaauto

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class FruitAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // سيتم إضافة منطق تقطيع الفواكه هنا لاحقاً
    }

    override fun onInterrupt() {
    }
}
