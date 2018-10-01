package six.ca.dagger101.six

import android.app.Activity
import android.os.Bundle
import javax.inject.Inject

class SixDemo : Activity(){
    @Inject lateinit var song1 : Song
    @Inject lateinit var song2 : Song

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerSongComponent.builder()
                .build()
                .inject(this)

        //=> szw six.ca.dagger101.six.Song@de8e82e    six.ca.dagger101.six.Song@de8e82e
        println("szw $song1    $song2")
    }
}