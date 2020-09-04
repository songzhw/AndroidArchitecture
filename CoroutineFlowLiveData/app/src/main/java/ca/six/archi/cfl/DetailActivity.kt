package ca.six.archi.cfl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import ca.six.archi.cfl.core.DepProvider
import ca.six.archi.cfl.data.Plant
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity(R.layout.activity_detail) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val plant = intent.getParcelableExtra<Plant>("plant")
        Glide.with(this).load(plant?.imageUrl).into(ivDetail)
        tvDetailTitle.text = plant?.name
        tvDetailDesp.text = plant?.description
        tvDetailId.text = plant?.plantId


        DepProvider.db.

    }
}

class DetailViewModel : ViewModel() {

}