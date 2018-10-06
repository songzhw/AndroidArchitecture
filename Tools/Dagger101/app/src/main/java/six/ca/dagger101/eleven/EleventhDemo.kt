package six.ca.dagger101.eleven

import android.os.Bundle

class EleventhDemo : Base11Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerAppSpComonent.builder()
                .application(this.application)
                .build()
                .inject(this)

        println("szw sp = $sp")
    }

}