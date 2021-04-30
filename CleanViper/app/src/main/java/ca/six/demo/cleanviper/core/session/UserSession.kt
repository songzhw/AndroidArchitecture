package ca.six.demo.cleanviper.core.session

object UserSession {
    var session: String? = null
    var isVip = false

    fun hasLoggedIn() = session != null

    fun convertFrom(response: UserHttpResponse) {
        session = response.session
        isVip = response.permissions.contains("vip")
    }

    fun reset () {
        session = null
        isVip = false
    }

    override fun toString(): String {
        return "[UserSession : isVip = $isVip, session = $session]"
    }
}


data class UserHttpResponse(val session: String, val permissions: Array<String>)