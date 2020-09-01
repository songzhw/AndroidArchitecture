package ca.six.archi.cfl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ca.six.archi.cfl.core.Http
import ca.six.archi.cfl.data.Plant
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {
    var isGrid = true
    val gridDisplayLiveData = MutableLiveData(true)
    val listDisplayLiveData = MutableLiveData(false)

    fun getPlants(): LiveData<List<Plant>> {
        // liveData{}如果没有参数Dispatcher.IO的话, 那其lambda就是运行在主线程上!
        return liveData(Dispatchers.IO) {
            val resp = Http.service.getAllPlants()
            emit(resp)  //=> liveData{}其实是返回一个CoroutineLiveData. 这个emit()即是CoroutineLiveData的方法!
        }
    }

    fun updateDisplay() {
        if (isGrid) {
            listDisplayLiveData.postValue(true)
        } else {
            gridDisplayLiveData.postValue(true)
        }
        isGrid = !isGrid
    }

}