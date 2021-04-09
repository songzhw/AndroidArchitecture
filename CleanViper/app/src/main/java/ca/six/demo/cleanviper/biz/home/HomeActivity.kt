package ca.six.demo.cleanviper.biz.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.demo.cleanviper.R
import ca.six.demo.cleanviper.core.di.HttpInjected
import ca.six.demo.cleanviper.ext.RxDisposableCleaner
import ca.six.demo.cleanviper.ext.clearedBy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeActivity : AppCompatActivity(R.layout.activity_main), HttpInjected, RxDisposableCleaner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        http.getChapters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { detail ->
                println("szw chapters = ${detail.chapters?.size}")
            }
            .clearedBy(_allSubscriptions)
    }
}