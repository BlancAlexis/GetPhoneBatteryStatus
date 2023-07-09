package fr.alexis.getphonebatterystatus.presentation

import com.google.android.gms.wearable.DataEvent
import com.google.android.gms.wearable.DataEventBuffer
import com.google.android.gms.wearable.DataMapItem
import com.google.android.gms.wearable.WearableListenerService

class PhoneBatteryStateListener
    : WearableListenerService() {
    override fun onDataChanged(dataEvents: DataEventBuffer) {
        println("onDataChanged")
        for (event in dataEvents) {
            if (event.type == DataEvent.TYPE_CHANGED && event.dataItem.uri.path == "/battery_data") {
                val dataMap = DataMapItem.fromDataItem(event.dataItem).dataMap
                val batteryLevel = dataMap.getInt("battery_level", 0)
                val batteryCharging = dataMap.getInt("battery_charging", -1)
            }
        }
    }
}