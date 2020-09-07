package ca.six.archi.cfl.core

import androidx.room.Room
import ca.six.archi.cfl.core.db.PlantDao
import ca.six.archi.cfl.core.db.PlantDatabase

object DepProvider {
    var http = Http.service

    var db = DB.dao

}

object DB {
    val dao: PlantDao by lazy {
        Room.databaseBuilder(App.app!!, PlantDatabase::class.java, "plants")
            .build()
            .plantDao()
    }

}