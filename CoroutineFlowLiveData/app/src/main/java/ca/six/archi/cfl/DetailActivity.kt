package ca.six.archi.cfl

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import ca.six.archi.cfl.core.DepProvider
import ca.six.archi.cfl.core.db.PrevPlant
import ca.six.archi.cfl.data.Plant
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailActivity : AppCompatActivity(R.layout.activity_detail) {
    lateinit var vm: DetailViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val plant = intent.getParcelableExtra<Plant>("plant")
        Glide.with(this).load(plant?.imageUrl).into(ivDetail)
        tvDetailTitle.text = plant?.name
        tvDetailDesp.text = plant?.description
        tvDetailId.text = plant?.plantId

        vm = ViewModelProvider(this).get(DetailViewModel::class.java)

        vm.previousPlantLiveData.observe(this) {
            ivPrevPlant.visibility = if (it == null) View.GONE else
                if (it.plant.plantId == plant.plantId) View.GONE else View.VISIBLE
            println("szw prevPlant = ${it.plant}")
        }
        vm.setPreviousPlant(plant)

    }
}

class DetailViewModel : ViewModel() {
    var previousPlantLiveData = DepProvider.db.getPreviousPlant()

    fun setPreviousPlant(prevPlant: Plant) {
        println("szw inset $prevPlant")
        viewModelScope.launch(Dispatchers.IO) {
            val plant = PrevPlant(1, prevPlant) //id故意取成都是1, 这样才会有replace效果
            DepProvider.db.insertPreviousPlant(plant)
        }
    }
}