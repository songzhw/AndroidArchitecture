package ca.six.archi.cfl.core.db

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ca.six.archi.cfl.data.Plant
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "prev_plant")
class PrevPlant(
    @PrimaryKey val id: Int,
    @Embedded val plant: Plant
)