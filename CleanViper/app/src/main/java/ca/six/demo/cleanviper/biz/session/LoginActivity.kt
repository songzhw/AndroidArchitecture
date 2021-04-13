package ca.six.demo.cleanviper.biz.session

import android.os.Bundle
import android.view.Window
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import androidx.appcompat.app.AppCompatActivity
import ca.six.demo.cleanviper.R
import ca.six.demo.cleanviper.ext.RxCleanerInjected
import ca.six.demo.cleanviper.ext.stringContent
import ca.six.demo.cleanviper.router.core.Router
import kotlinx.android.synthetic.main.activity_login.*

interface ILoginView {
    fun continueNav()
}

class LoginActivity : AppCompatActivity(), RxCleanerInjected, ILoginView {
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login) //上面两个得在加载layout文件之前

        lifecycle.addObserver(rxCleaner)
        presenter = LoginPresenter(this) //TODO 改为DI
        presenter.disposables = disposables

        btnLogin.setOnClickListener {
            presenter.login(etLoginName.stringContent(), etLoginPwd.stringContent())
        }
    }

    override fun continueNav() {
        Router.continueNav(this)
    }

}