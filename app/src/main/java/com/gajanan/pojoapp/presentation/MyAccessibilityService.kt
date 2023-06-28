package com.gajanan.pojoapp.presentation

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast

class MyAccessibilityService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event?.packageName == "com.whatsapp") {
            Toast.makeText(applicationContext, "WhatsApp Launched", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onInterrupt() {}
}