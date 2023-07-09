package fr.alexis.getphonebatterystatus.presentation.theme

interface OnBatteryDataReceive {
    fun onBatteryDataReceive(level: Int, state: Int)
}