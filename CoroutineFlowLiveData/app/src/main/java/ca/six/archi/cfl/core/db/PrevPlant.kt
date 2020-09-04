package ca.six.archi.cfl.core.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ca.six.archi.cfl.data.Plant

@Entity(tableName = "prev_plant")
class PrevPlant(
    @PrimaryKey val id: Int,
    @Embedded val plant: Plant
)