package ca.six.demo.core

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import retrofit2.Retrofit
import javax.inject.Inject

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    @Inject lateinit var retrofit : Retrofit
}