package ca.six.archi.cfl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import ca.six.archi.cfl.core.Http
import ca.six.archi.cfl.data.Plant
import ca.six.oneadapter.lib.OneDiffAdapter
import ca.six.oneadapter.lib.RvViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {
    lateinit var adapter: OneDiffAdapter<Plant>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diffCallback = object : DiffUtil.ItemCallback<Plant>() {
            override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean = oldItem.plantId == newItem.plantId
            override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean = oldItem == newItem
        }

        rv.layoutManager = GridLayoutManager(this, 3)
        adapter = object : OneDiffAdapter<Plant>(diffCallback, R.layout.item_plants) {
            override fun apply(vh: RvViewHolder, value: Plant, position: Int) {
                //vh.setSrc(R.id.ivPlant, value.imageUrl)
                vh.setText(R.id.tvPlant, value.name)
            }

        }
        rv.adapter = adapter


        val vm = ViewModelProvider(this).get(MainViewModel::class.java)
        vm.getPlants().observe(this) { resp ->
            println("szw Actv: ${Thread.currentThread().name}") //=> main线程
            adapter.refresh(resp)
        }

    }
}

class MainViewModel : ViewModel() {

    fun getPlants(): LiveData<List<Plant>> {
        // liveData{}如果没有参数Dispatcher.IO的话, 那其lambda就是运行在主线程上!
        return liveData(Dispatchers.IO) {
            println("szw thread = ${Thread.currentThread().name}")
            val resp = Http.service.getAllPlants()
            emit(resp)  //=> liveData{}其实是返回一个CoroutineLiveData. 这个emit()即是CoroutineLiveData的方法!
        }
    }

}