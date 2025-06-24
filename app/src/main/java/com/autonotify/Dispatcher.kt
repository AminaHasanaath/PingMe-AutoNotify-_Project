package com.autonotify

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.telephony.SmsManager
import android.widget.Toast

object Dispatcher {

    fun sendMessage(
        context: Context,
        contactNumber: String,
        message: String,
        platform: String
    ) {
        when (platform) {
            "SMS" -> sendSMS(context, contactNumber, message)
            "WhatsApp" -> sendViaWhatsApp(context, contactNumber, message)
            "Telegram" -> sendViaTelegram(context, message)
            else -> Toast.makeText(context, "Invalid platform selected", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendSMS(context: Context, number: String, message: String) {
        try {
            val smsManager = SmsManager.getDefault()
            smsManager.sendTextMessage(number, null, message, null, null)
            Toast.makeText(context, "SMS sent!", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {
            Toast.makeText(context, "SMS failed: ${e.message}", Toast.LENGTH_LONG).show()
        }
    }

    private fun sendViaWhatsApp(context: Context, number: String, message: String) {
        try {
            val uri = Uri.parse("https://wa.me/$number?text=${Uri.encode(message)}")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("com.whatsapp")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "WhatsApp not installed or failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendViaTelegram(context: Context, message: String) {
        try {
            val uri = Uri.parse("https://t.me/share/url?url=${Uri.encode(message)}")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.setPackage("org.telegram.messenger")
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Telegram not installed or failed", Toast.LENGTH_SHORT).show()
        }
    }
}
