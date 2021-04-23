package ca.six.demo.cleanviper.biz.session

import android.os.Bundle
import android.view.Window
import android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN
import androidx.appcompat.app.AppCompatActivity
import ca.six.demo.cleanviper.R
import ca.six.demo.cleanviper.core.base.BaseActivity
import ca.six.demo.cleanviper.ext.*
import ca.six.demo.cleanviper.router.core.Router
import com.github.ybq.android.spinkit.SpinKitView
import kotlinx.android.synthetic.main.activity_login.*

interface ILoginView {
    fun continueNav()
    fun toast(msg: String)
}

class LoginActivity : BaseActivity(), ILoginView {
    lateinit var presenter: LoginPresenter
    lateinit var spinView: SpinKitView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(FLAG_FULLSCREEN, FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login) //上面两个得在加载layout文件之前

        presenter = LoginPresenter(this) //TODO 改为DI
        presenter.disposables = disposables

        btnLogin.setOnClickListener {
            spinView = showProgress()
            presenter.login(etLoginName.stringContent(), etLoginPwd.stringContent())
        }
    }

    override fun continueNav() {
        hideProgress(spinView)
        Router.continueNav(this)
        this.finish()
    }

    override fun toast(msg: String) {
        hideProgress(spinView)
        this.showToast(msg)
    }

}