package ca.six.archi.cfl.biz

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ca.six.archi.cfl.core.DepProvider
import ca.six.archi.cfl.core.db.PrevPlant
import ca.six.archi.cfl.data.Plant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    var injector: DepProvider? = null
    var previousPlantLiveData = MutableLiveData<PrevPlant>()
    var dispatch = Dispatchers.IO

    fun getPrevPlant(currentPlant: Plant) {
        viewModelScope.launch(dispatch) {
            val plant = injector?.db?.getPreviousPlant()
            previousPlantLiveData.postValue(plant);

            //取到prevPlant后才写入新的prevPlant, 不然成了livedata中的prev与currentPlant一样了
            setPreviousPlant(currentPlant)
        }
    }

    private fun setPreviousPlant(prevPlant: Plant) {
        println("szw inset $prevPlant")
        viewModelScope.launch(dispatch) {
            val plant = PrevPlant(1, prevPlant) //id故意取成都是1, 这样才会有replace效果
            injector?.db?.insertPreviousPlant(plant)
        }
    }
}