package fr.alexis.getphonebatterystatus

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import com.google.android.gms.wearable.DataMap
import com.google.android.gms.wearable.PutDataMapRequest
import com.google.android.gms.wearable.Wearable
import fr.alexis.getphonebatterystatus.BatteryStatus.batteryCharging
import fr.alexis.getphonebatterystatus.BatteryStatus.batteryLevel

class BatteryReceiver(private val batteryUpdateInterface: BatteryUpdateInterface) : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BATTERY_CHANGED) {
            BatteryStatus.batteryLevel = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            when (intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)) {
                -1 ->{
                    BatteryStatus.batteryCharging=-1
                }
                BatteryManager.BATTERY_PLUGGED_AC -> {
                    BatteryStatus.batteryCharging=BatteryManager.BATTERY_PLUGGED_AC
                }
                BatteryManager.BATTERY_PLUGGED_USB -> {
                    BatteryStatus.batteryCharging=BatteryManager.BATTERY_PLUGGED_USB
                }
                BatteryManager.BATTERY_PLUGGED_WIRELESS -> {
                    BatteryStatus.batteryCharging=BatteryManager.BATTERY_PLUGGED_WIRELESS
                }
            }
            batteryUpdateInterface.batteryDataChanged()
        }
    }
}