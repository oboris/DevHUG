package info.goodlift.devhug

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.things.pio.PeripheralManager
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val hat = Devices()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exitBtn: Button = findViewById(R.id.exit_button)
        exitBtn.setOnClickListener(this)

        val manager = PeripheralManager.getInstance()
        Log.d(TAG, "Available GPIO: " + manager.gpioList)

        hat.apply {

            buttonA.onClick {
                if (it) {
                    ledRed.toggle()
                }
            }
            buttonB.onClick {
                if (it) {
                    ledGreen.toggle()
                }
            }
            buttonC.onClick {
                if (it) {
                    ledBlue.toggle()
                }
            }
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onClick(p0: View?) {
        exitProcess(-1)
    }

    override fun onDestroy() {
        hat.onDestroy()
        super.onDestroy()
    }
}