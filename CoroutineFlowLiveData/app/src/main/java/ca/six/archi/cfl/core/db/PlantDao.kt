package ca.six.archi.cfl.core.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ca.six.archi.cfl.data.Plant
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPlant(plant: Plant)

    // Entity是Plant, 变成"表名"就会是小写
    @Query("SELECT * FROM plant")
    fun getPreviousPlant(): LiveData<Plant>

    @Query("SELECT * FROM plant")
    fun getPreviousPlantAsFlow(): Flow<Plant>
}