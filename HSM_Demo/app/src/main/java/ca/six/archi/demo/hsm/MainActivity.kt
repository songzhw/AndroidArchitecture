package ca.six.archi.demo.hsm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var parents: Array<IState> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ary : Array<Int> = arrayOf()
        ary.set(2, 20)
        println("szw ary = $ary") //=> crash : ArrayIndexOutOfBoundsException: length=0; index=2
    }
}

interface IState {
    val parents: Array<IState>
        get() = arrayOf()
}

object LoggedOut: IState
