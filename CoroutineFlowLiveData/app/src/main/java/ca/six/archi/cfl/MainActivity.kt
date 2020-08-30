package ca.six.archi.cfl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import ca.six.archi.cfl.core.Http
import ca.six.archi.cfl.core.LoginResponse

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = ViewModelProvider(this).get(MainViewModel::class.java)
        vm.loginLiveData.observe(this) { resp ->
            println("szw result = $resp")
        }
    }
}

class MainViewModel : ViewModel() {
    lateinit var loginLiveData: LiveData<LoginResponse>

    fun login() {
        loginLiveData = liveData {
            Http.service.login()
        }
    }
}