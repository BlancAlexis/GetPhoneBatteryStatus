package fr.alexis.getphonebatterystatus

import com.google.android.gms.wearable.*

class BatteryListenerService : WearableListenerService(), BatteryUpdateInterface {
    override fun onDataChanged(dataEvents: DataEventBuffer) {
        for (event in dataEvents) {
            if (event.type == DataEvent.TYPE_CHANGED && event.dataItem.uri.path == "/battery_data") {
                val dataMap = DataMapItem.fromDataItem(event.dataItem).dataMap
                val batteryLevel = dataMap.getInt("battery_level", 0)
                val batteryCharging = dataMap.getInt("battery_charging", -1)
                // Mettez à jour l'interface utilisateur avec les données de la batterie
            }
        }
    }

    override fun batteryDataChanged() {
        onDataChanged()
    }
    val dataMapToSend = DataMap().apply {
        putInt("battery_level", BatteryStatus.batteryLevel)
        putInt("battery_charging", BatteryStatus.batteryCharging)
    }

    val dataItem = PutDataMapRequest.create("/battery_data").apply {
        dataMap = this.dataMapToSend
    }.asPutDataRequest()

    val dataClient = Wearable.getDataClient(context!!)
    dataClient.putDataItem(dataItem)
}
}