package fr.alexis.getphonebatterystatus

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import fr.alexis.getphonebatterystatus.BatteryStatus.batteryCharging
import fr.alexis.getphonebatterystatus.BatteryStatus.batteryLevel

class MainActivity : AppCompatActivity(){
    override fun onStart() {
        super.onStart()
        val intent = Intent(this, BatteryListenerService::class.java)
        startService(intent)
    }
}

