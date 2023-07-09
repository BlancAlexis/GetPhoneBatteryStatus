package fr.alexis.getphonebatterystatus.presentation

fun interface OnBatteryDataReceive {
    fun onBatteryDataReceive(level: Int, state: Int)
}