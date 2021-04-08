package ca.six.mvi.biz.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ca.six.mvi.R
import java.util.*

class HomeActivity : AppCompatActivity() {
    lateinit var presenter : HomePresenter //TODO has a chance to inject it ?!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter = HomePresenter(this)
        presenter.onCreate()
    }


    fun render(data : HomeData){
        if(data.isLoading){
            // show pb
        } else if(data.isError){
            // show error
        } else if(data.todos != null){
            if(data.todos?.size == 0){
                // show empty view
            } else {
                // recyclerview
            }
        }
    }
}
