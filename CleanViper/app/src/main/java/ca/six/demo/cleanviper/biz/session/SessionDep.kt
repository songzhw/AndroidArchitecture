package ca.six.demo.cleanviper.biz.session

object SessionDepStore {
    var loginPresenter: LoginPresenter? = null
        get() = LoginPresenter()
        set(value) { field = value }
}