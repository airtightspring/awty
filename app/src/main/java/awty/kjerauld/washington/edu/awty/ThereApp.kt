package awty.kjerauld.washington.edu.awty

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

val prefs: Prefs by lazy {
    ThereApp.prefs!!
}

class ThereApp: Application() {

    companion object Companion {
        fun create(): ThereApp = ThereApp()

        var prefs: Prefs? = null
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }
}

class Prefs (context: Context) {
    val PREFS_FILENAME = "awty.kjerauld.washington.edu.awty.prefs"
    val messageString = "Message String"
    val PHONE_NUMBER = "Phone Number"
    val MESSAGE = "Message"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0);

    var checkMessageString: String
        get() = prefs.getString(messageString, "")
        set(value) = prefs.edit().putString(messageString, value).apply()

    var checkPhoneNumber: String
        get() = prefs.getString(PHONE_NUMBER, "")
        set(value) = prefs.edit().putString(PHONE_NUMBER, value).apply()

    var checkMessage: String
        get() = prefs.getString(MESSAGE, "")
        set(value) = prefs.edit().putString(MESSAGE, value).apply()
}