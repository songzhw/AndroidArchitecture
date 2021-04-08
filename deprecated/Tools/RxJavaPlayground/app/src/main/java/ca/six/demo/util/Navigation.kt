package ca.six.demo.util

import android.app.Activity
import android.content.Intent
import kotlin.reflect.KClass

fun Activity.nav(clazz: Class<out Activity>){
    startActivity(Intent(this, clazz))
}