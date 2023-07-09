package fr.alexis.getphonebatterystatus.presentation

interface OnBatteryDataReceive {
    fun onBatteryDataReceive(level: Int, state: Int)
}