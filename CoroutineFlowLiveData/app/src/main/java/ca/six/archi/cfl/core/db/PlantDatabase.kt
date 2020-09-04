package ca.six.archi.cfl.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ca.six.archi.cfl.data.Plant

@Database(entities = arrayOf(Plant::class, PrevPlant::class), version = 1)
abstract class PlantDatabase : RoomDatabase() {
    abstract fun plantDao(): PlantDao
}