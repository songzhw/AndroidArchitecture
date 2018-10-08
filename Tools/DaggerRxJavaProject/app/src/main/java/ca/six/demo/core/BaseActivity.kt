package ca.six.demo.core

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ca.six.demo.core.di.PerActivity
import retrofit2.Retrofit
import javax.inject.Inject

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    lateinit var retrofit : Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val appComponent = (application as BaseApp).appComponent
        val builder = appComponent
                .httpComponentBuilder()
        println("szw $this: [$appComponent,  $builder]") // so this is the problem: builder is not the same
        retrofit = builder
                .baseHttpUrl("https://api.github.com")
                .build()
                .retrofit()
    }
}