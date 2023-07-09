/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter and
 * https://github.com/android/wear-os-samples/tree/main/ComposeAdvanced to find the most up to date
 * changes to the libraries and their usages.
 */

package fr.alexis.getphonebatterystatus.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import fr.alexis.getphonebatterystatus.R
import fr.alexis.getphonebatterystatus.presentation.theme.GetPhoneBatteryStatusTheme
import fr.alexis.getphonebatterystatus.presentation.theme.OnBatteryDataReceive

class MainActivity : ComponentActivity(),OnBatteryDataReceive {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WearApp("Damien la con dta mère")
        }
    }
    override fun onBatteryDataReceive(level: Int, state: Int) {
        Log.i("Montre","Levell $level State $state")
    }
}

@Composable
fun WearApp(greetingName: String) {
    GetPhoneBatteryStatusTheme {
        /* If you have enough items in your list, use [ScalingLazyColumn] which is an optimized
         * version of LazyColumn for wear devices with some added features. For more information,
         * see d.android.com/wear/compose.
         */
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            verticalArrangement = Arrangement.Center
        ) {
batteryLevel(greetingName = 5)
            batteryState(greetingName = 2)
        }
        }
    }

@Composable
fun batteryLevel(greetingName: Int) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = "Battery Level: $greetingName",
        style = TextStyle(fontSize = 20.sp)
    )
}
@Composable
fun batteryState(greetingName: Int) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.primary,
        text = "Battery State: $greetingName",
        style = TextStyle(fontSize = 20.sp)
    )
}

@Preview(device = Devices.WEAR_OS_SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp("toudou le loup")
}