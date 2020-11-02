package ca.six.archi.demo.hsm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

interface IState {

}

object LoggedOut : IState
object LoggedIn: IState
object LoggedIn_Abnormal: LoggedIn