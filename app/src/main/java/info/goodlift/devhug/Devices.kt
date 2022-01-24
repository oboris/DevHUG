package info.goodlift.devhug

import com.google.android.things.contrib.driver.button.Button
import com.google.android.things.contrib.driver.rainbowhat.RainbowHat
import com.google.android.things.pio.Gpio

class Devices {
    private val TAG = "EasyRainbowHat"

    private var initButtonA = false
    private var initButtonB = false
    private var initButtonC = false
    private var initLedRed = false
    private var initLedGreen = false
    private var initLedBlue = false

//    val buttonA: Button by lazy { initButtonA = true; RainbowHat.openButtonA() }
    val buttonA: Button
    val buttonB: Button by lazy { initButtonB = true; RainbowHat.openButtonB() }
    val buttonC: Button by lazy { initButtonC = true; RainbowHat.openButtonC() }

    val ledRed: Gpio by lazy { initLedRed = true; RainbowHat.openLedRed() }
    val ledGreen: Gpio by lazy { initLedGreen = true; RainbowHat.openLedGreen() }
    val ledBlue: Gpio by lazy { initLedBlue = true; RainbowHat.openLedBlue() }



    fun Button.onClick(onPress: (Boolean) -> Unit) = setOnButtonEventListener { _, pressed -> onPress(pressed) }

    fun Gpio.on() { value = true }

    fun Gpio.off() { value = false }

    fun Gpio.toggle(){value = !value}

    fun onDestroy() {
        if (initButtonA) buttonA.close()
        if (initButtonB) buttonB.close()
        if (initButtonC) buttonC.close()

        if (initLedRed) ledRed.close()
        if (initLedGreen) ledGreen.close()
        if (initLedBlue) ledBlue.close()
    }
}