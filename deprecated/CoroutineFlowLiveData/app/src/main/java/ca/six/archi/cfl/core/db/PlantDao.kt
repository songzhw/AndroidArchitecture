package ca.six.archi.cfl.core.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPreviousPlant(plant: PrevPlant)

    @Query("SELECT * FROM prev_plant")
    fun getPreviousPlant(): PrevPlant

    // Entity是Plant, 变成"表名"就会是小写plant
    @Query("SELECT * FROM prev_plant")
    fun getPreviousPlantAsLiveData(): LiveData<PrevPlant>

    @Query("SELECT * FROM prev_plant")
    fun getPreviousPlantAsFlow(): Flow<PrevPlant>
}