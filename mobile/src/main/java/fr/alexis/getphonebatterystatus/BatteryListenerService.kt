package fr.alexis.getphonebatterystatus

import android.util.Log
import com.google.android.gms.wearable.*
import fr.alexis.getphonebatterystatus.BatteryStatus.batteryCharging
import fr.alexis.getphonebatterystatus.BatteryStatus.batteryLevel

class BatteryListenerService : WearableListenerService(), BatteryUpdateInterface {
    override fun batteryDataChanged() {
        sendBatteryDataToWear()
    }

    fun sendBatteryDataToWear() {
        val dataMap = DataMap().apply {
            putInt("battery_level", BatteryStatus.batteryLevel)
            putInt("battery_charging", BatteryStatus.batteryCharging)
        }
        val dataItem = PutDataMapRequest.create("/battery_data").apply {
            dataMap.putAll(dataMap)
        }.asPutDataRequest()

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