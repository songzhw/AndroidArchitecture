package ca.six.demo.cleanviper.entity

data class UserPermissions(val permissions: Array<String>)

data class UserSession(val session: String, val permissions: UserPermissions)