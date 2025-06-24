package com.autonotify

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.autonotify.model.AppDatabase
import com.autonotify.model.Contact
import com.autonotify.model.Message
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var platformSpinner: Spinner
    private lateinit var contactInput: EditText
    private lateinit var messageSpinner: Spinner
    private lateinit var sendBtn: Button

    private val platforms = arrayOf("SMS", "WhatsApp", "Telegram")
    private val messages = arrayOf("Call me", "Reached", "On my way", "Busy right now")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        platformSpinner = findViewById(R.id.platformSpinner)
        messageSpinner = findViewById(R.id.messageSpinner)
        contactInput = findViewById(R.id.contactInput)
        sendBtn = findViewById(R.id.sendBtn)

        platformSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, platforms)
        messageSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, messages)

        sendBtn.setOnClickListener {
            val contact = contactInput.text.toString()
            val message = messageSpinner.selectedItem.toString()
            val platform = platformSpinner.selectedItem.toString()

            if (contact.isNotEmpty()) {
                Dispatcher.sendMessage(this, contact, message, platform)

                // ✅ Save contact + message to Room DB in background
                val db = AppDatabase.getDatabase(this)
                CoroutineScope(Dispatchers.IO).launch {
                    db.contactDao().insert(Contact(name = "Unknown", number = contact))
                    db.messageDao().insert(Message(text = message))
                }

            } else {
                Toast.makeText(this, "Enter contact number", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
