package ca.six.archi.cfl

import androidx.annotation.DrawableRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import ca.six.archi.cfl.core.Http
import ca.six.archi.cfl.data.Plant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var isGrid = true
    val gridDisplayLiveData = MutableLiveData<Boolean>() //CF中不给初始值, 就不会页面一启动就先发送值
    val listDisplayLiveData = MutableLiveData<Boolean>() //CF中不给初始值, 就不会页面一启动就先发送值
    @DrawableRes var displayIcon: Int = R.drawable.ic_grid

    var isFiltered = false
    val dataLiveData = MutableLiveData<List<Plant>>()
    val data = ArrayList<Plant>()



//    fun getPlants(): LiveData<List<Plant>> {
//        // liveData{}如果没有参数Dispatcher.IO的话, 那其lambda就是运行在主线程上!
//        return liveData(Dispatchers.IO) {
//            val resp = Http.service.getAllPlants()
//            emit(resp)  //=> liveData{}其实是返回一个CoroutineLiveData. 这个emit()即是CoroutineLiveData的方法!
//        }
//    }

    fun fetchPlants() {
        // 若直接使用viewModelSceop.launch{..}, 那就是运行在main线程上了!!!
        viewModelScope.launch(Dispatchers.IO) {
            println("szw vm: thread = ${Thread.currentThread().name}")
            val resp = Http.service.getAllPlants()
            dataLiveData.postValue(resp)

            data.clear()
            data.addAll(resp)
        }
    }

    fun updateDisplay() {
        if (isGrid) {
            listDisplayLiveData.postValue(true)
            displayIcon = R.drawable.ic_list
        } else {
            gridDisplayLiveData.postValue(true)
            displayIcon = R.drawable.ic_grid
        }
        isGrid = !isGrid
    }

    fun filterData() {
        if (isFiltered) {
            dataLiveData.postValue(data)
        } else {
            val newData = data.filter { it.growZoneNumber == 3 }
            dataLiveData.postValue(newData)
        }
        isFiltered = !isFiltered
    }

}