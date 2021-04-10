package ca.six.demo.cleanviper.biz.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.six.demo.cleanviper.R
import ca.six.demo.cleanviper.core.di.HttpInjected
import ca.six.demo.cleanviper.ext.RxCleanerInjected
import ca.six.demo.cleanviper.ext.clearedBy
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeActivity : AppCompatActivity(R.layout.activity_main), HttpInjected, RxCleanerInjected {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(rxCleaner)

        http.getChapters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMapIterable { resp -> resp.chapters }
            .subscribe { cahpter ->
                println("szw chapters = $cahpter")
            }
            .clearedBy(disposables)
    }
}
