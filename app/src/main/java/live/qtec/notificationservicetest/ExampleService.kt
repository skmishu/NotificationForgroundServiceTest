package live.qtec.notificationservicetest

import android.R
import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.annotation.Nullable
import androidx.core.app.NotificationCompat


class ExampleService : Service() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val input = intent.getStringExtra("inputExtra")
        val notificationIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0)
        val notification: Notification = NotificationCompat.Builder(this, "ExampleServiceChannel")
            .setContentTitle("Example Service")
            .setContentText(input)
            .setSmallIcon(R.drawable.ic_btn_speak_now)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1, notification)

        //do heavy work on a background thread
        //stopSelf();

        return START_NOT_STICKY//todo: change it to sticky so that android starts the service again
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    @Nullable
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }


}