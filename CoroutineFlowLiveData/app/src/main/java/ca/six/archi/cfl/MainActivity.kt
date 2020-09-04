package ca.six.archi.cfl

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.six.archi.cfl.data.Plant
import ca.six.oneadapter.lib.OneDiffAdapter
import ca.six.oneadapter.lib.RvViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: OneDiffAdapter<Plant>
    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diffCallback = object : DiffUtil.ItemCallback<Plant>() {
            override fun areItemsTheSame(oldItem: Plant, newItem: Plant): Boolean = oldItem.plantId == newItem.plantId
            override fun areContentsTheSame(oldItem: Plant, newItem: Plant): Boolean = oldItem == newItem
        }

        rv.layoutManager = GridLayoutManager(this, 2)
        adapter = object : OneDiffAdapter<Plant>(diffCallback, R.layout.item_plants) {
            override fun apply(vh: RvViewHolder, value: Plant, position: Int) {
                val iv = vh.getView<ImageView>(R.id.ivPlant)
                Glide.with(this@MainActivity).load(value.imageUrl).into(iv)
                // Picasso.get().load(value.imageUrl).into(iv); //让界面超级卡, 故我改为Glide
                vh.setText(R.id.tvPlant, value.name)
            }
        }
        rv.addOnItemTouchListener(object : OnRvItemClickListener(rv) {
            override fun onItemClick(vh: RecyclerView.ViewHolder) {
                val position = vh.adapterPosition
                println("szw click: ${vm.getPlant(position)}")
            }
        })
        rv.adapter = adapter


        vm = ViewModelProvider(this).get(MainViewModel::class.java)
        vm.dataLiveData.observe(this) { resp ->
            adapter.refresh(resp)
        }

        vm.gridDisplayLiveData.observe(this) { isGrid ->
            rv.layoutManager = GridLayoutManager(this, 2)
        }
        vm.listDisplayLiveData.observe(this) { isList ->
            rv.layoutManager = LinearLayoutManager(this)
        }

        vm.fetchPlants()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuDisplay -> {
                vm.updateDisplay()
                item.setIcon(vm.displayIcon)
                true
            }
            R.id.menuFilter -> {
                vm.filterData()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}

