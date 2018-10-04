package six.ca.dagger101.eleven

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

@SuppressLint("Registered")
open class Base11Activity : Activity() {
    @Inject lateinit var sp : SharedPreferences
}