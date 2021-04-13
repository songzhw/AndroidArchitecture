package ca.six.demo.cleanviper.core.session

object UserSession {
    var session: String? = null
    var isVip = false

    fun hasLoggedIn() = session != null

    override fun toString(): String {
        return "[UserSession : isVip = $isVip, session = $session]"
    }
}


class UserHttpResponse {
    var session: String = ""
        set(value) {
            println("szw Response: set session")
            UserSession.session = value
            field = value
        }

    var permissions: Array<String> = emptyArray()
        set(value) {
            println("szw Response: set permission")
            UserSession.isVip = permissions.contains("vip")
            field = value
        }


    override fun toString(): String {
        return "[UserHttpResponse: permissions = ${permissions}, session = ${session}]"
    }
}