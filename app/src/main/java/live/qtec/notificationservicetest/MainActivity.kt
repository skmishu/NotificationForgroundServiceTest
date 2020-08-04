package live.qtec.notificationservicetest

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var editTextInput: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextInput = findViewById(R.id.edit_text_input)

        btnStart.setOnClickListener { startService() }
        btnStop.setOnClickListener { stopService() }
    }

    fun startService() {
        val input = editTextInput!!.text.toString()
        val serviceIntent = Intent(this, ExampleService::class.java)
        serviceIntent.putExtra("inputExtra", input)
        ContextCompat.startForegroundService(this, serviceIntent)
    }

    fun stopService() {
        val serviceIntent = Intent(this, ExampleService::class.java)
        stopService(serviceIntent)
    }
}