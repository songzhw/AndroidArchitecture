package ca.six.demo.cleanviper.core.base

import android.os.Bundle
import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import ca.six.demo.cleanviper.ext.RxCleanerInjected

// 1. 两种CF全兼顾.  平时多用layoutId的; 要是全屏的, 要先设置flag再调用setContentView()的, 就用无参CF
// 2. 兼有RxCleanerInjected的功能
open class BaseActivity : AppCompatActivity, RxCleanerInjected {
    constructor() : super()

    @ContentView
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(rxCleaner)
    }
}
