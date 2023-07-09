package fr.alexis.getphonebatterystatus

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.wearable.MessageClient
import fr.alexis.getphonebatterystatus.BatteryStatus.batteryCharging
import fr.alexis.getphonebatterystatus.BatteryStatus.batteryLevel

class MainActivity : AppCompatActivity(),BatteryUpdateInterface {
    override fun onStart() {
        super.onStart()
 val bat = BatteryReceiver(this)
        val filter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(bat, filter)

    }

    override fun batteryDataChanged() {
        println("$batteryLevel $batteryCharging")
    }
}

