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
            println("szw main: ${Thread.currentThread().name}") //=> main线程
        }
    }
}

class MainViewModel : ViewModel() {

    fun login(): LiveData<LoginResponse> {
        // liveData{}如果没有参数Dispatcher.IO的话, 那其lambda就是运行在主线程上!
        return liveData(Dispatchers.IO) {
            println("szw thread = ${Thread.currentThread().name}")
            val resp = Http.service.login()
            emit(resp)  //=> liveData{}其实是返回一个CoroutineLiveData. 这个emit()即是CoroutineLiveData的方法!
        }
    }
}