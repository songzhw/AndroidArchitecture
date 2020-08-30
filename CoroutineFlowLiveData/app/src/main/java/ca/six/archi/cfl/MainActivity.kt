package ca.six.archi.cfl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import ca.six.archi.cfl.core.Http
import ca.six.archi.cfl.core.LoginResponse
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = ViewModelProvider(this).get(MainViewModel::class.java)
        vm.login().observe(this) { resp ->
            println("szw result = $resp")
        }
    }
}

class MainViewModel : ViewModel() {

    fun login(): LiveData<LoginResponse> {
        val loginLiveData = liveData(Dispatchers.IO) {
            val resp = Http.service.login()
            emit(resp)
        }
        return loginLiveData
    }
}