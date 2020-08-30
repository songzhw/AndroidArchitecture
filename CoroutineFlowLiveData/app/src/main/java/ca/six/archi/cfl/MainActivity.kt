package ca.six.archi.cfl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ca.six.archi.cfl.core.Http

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Http.service.login();
    }
}