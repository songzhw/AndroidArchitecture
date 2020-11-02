package ca.six.archi.cfl.biz

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ca.six.archi.cfl.R
import ca.six.archi.cfl.core.App
import ca.six.archi.cfl.data.Plant
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

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
        vm.injector = App.injector

        vm.previousPlantLiveData.observe(this) { prevPlant ->
            println("szw prevPlant = ${prevPlant.plant}")
            ivPrevPlant.visibility = if (prevPlant == null) View.GONE else View.VISIBLE
            ivPrevPlant.setOnClickListener {
                val intent = Intent(this, DetailActivity::class.java)
                    .putExtra("plant", prevPlant.plant)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }

        vm.getPrevPlant(plant)

    }

}
