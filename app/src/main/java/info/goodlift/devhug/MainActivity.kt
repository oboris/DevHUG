package info.goodlift.devhug

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.things.pio.PeripheralManager
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val exitBtn : Button = findViewById(R.id.exit_button)
        exitBtn.setOnClickListener(this)

        val manager=PeripheralManager.getInstance()
        Log.d(TAG, "Available GPIO: " + manager.gpioList)
    }

    companion object{
        private const val TAG = "MainActivity"
    }

    override fun onClick(p0: View?) {
        exitProcess(-1)
    }
}