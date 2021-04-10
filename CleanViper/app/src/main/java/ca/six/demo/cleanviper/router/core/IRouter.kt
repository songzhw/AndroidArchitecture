package ca.six.demo.cleanviper.router.core

import java.util.HashMap

interface IRouter {
    fun registerRoute(map: HashMap<String, Station>)
}