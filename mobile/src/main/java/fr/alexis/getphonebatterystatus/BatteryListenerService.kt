package fr.alexis.getphonebatterystatus

import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import com.google.android.gms.wearable.*
import fr.alexis.getphonebatterystatus.BatteryStatus.batteryCharging
import fr.alexis.getphonebatterystatus.BatteryStatus.batteryLevel

class BatteryListenerService : WearableListenerService(), BatteryUpdateInterface {


    override fun onCreate() {
        super.onCreate()
        val batteryReceiver = BatteryReceiver(this)
        val batteryFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        registerReceiver(batteryReceiver, batteryFilter)
        println("register ok")
    }
    override fun batteryDataChanged() {
        sendBatteryDataToWear()
        println("yo2")
        println("$batteryLevel $batteryCharging")

    }

    private fun sendBatteryDataToWear() {
        val dataMap = DataMap().apply {
            putInt("battery_level", BatteryStatus.batteryLevel)
            putInt("battery_charging", BatteryStatus.batteryCharging)
        }
        val dataItem = PutDataMapRequest.create("/battery_data").apply {
            dataMap.putAll(this.dataMap)
        }.asPutDataRequest()
        dataItem.setUrgent()
        val dataClient = Wearable.getDataClient(applicationContext)
        val putDataTask = dataClient.putDataItem(dataItem)
        putDataTask.addOnSuccessListener {
            Log.i("Succès", "Envoye des données batterie = $batteryLevel ainsi qu'elle charge = $batteryCharging ")
        }
        putDataTask.addOnFailureListener { exception ->
            Log.i("Echec","Erreur dans l'envoie des donnéées $exception")
        }
    }
}