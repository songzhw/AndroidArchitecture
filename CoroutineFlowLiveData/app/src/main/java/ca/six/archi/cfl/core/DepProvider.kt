package ca.six.archi.cfl.core

import androidx.room.Room
import ca.six.archi.cfl.core.db.PlantDatabase

object DepProvider {
    var http = Http.service

    // crash
    var db =
        Room.databaseBuilder(App.app!!, PlantDatabase::class.java, "plants")
            .build()
            .plantDao()

}