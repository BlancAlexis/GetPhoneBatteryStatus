package fr.alexis.getphonebatterystatus

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.wearable.MessageClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val messageClient : MessageClient
        messageClient.addListener {  }
        messageClient.se

        setContentView(R.layout.activity_main)
    }

}

