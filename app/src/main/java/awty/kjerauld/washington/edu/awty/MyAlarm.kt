package awty.kjerauld.washington.edu.awty

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager
import android.util.Log;
import android.widget.Toast;

class MyAlarm : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        var logMessage = "No Message Set"

        var myMessage = "No Message Set"

        var myPhoneNumber = "No Phone Set"

        if (ThereApp.prefs?.checkMessageString != null) {
            logMessage = ThereApp.prefs?.checkMessageString.toString()
        }

        if (ThereApp.prefs?.checkMessage != null) {
            myMessage = ThereApp.prefs?.checkMessage.toString()
        }

        if (ThereApp.prefs?.checkPhoneNumber != null) {
            myPhoneNumber = ThereApp.prefs?.checkPhoneNumber.toString()
        }

        val fakePhone = SmsManager.getDefault()
        fakePhone.sendTextMessage(myPhoneNumber, null, myMessage, null, null)

        //Toast.makeText(context, logMessage, Toast.LENGTH_LONG).show()

        Log.d("AlarmLogTest", logMessage)
    }

}