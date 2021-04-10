package ca.six.demo.cleanviper.core.session

object UserSession {
    var session: String? = null
    var isVip = false

    fun hasLoggedIn() = session != null

}