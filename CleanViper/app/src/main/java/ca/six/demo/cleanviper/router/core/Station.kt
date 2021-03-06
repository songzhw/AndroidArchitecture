package ca.six.demo.cleanviper.router.core

import android.app.Activity

class Station(var target: String, val clazz: Class<out Activity>) {

    val preconditionList: ArrayList<Precondition> = arrayListOf()

    fun addPrecondition(precondition: Precondition): Station {
        preconditionList.add(precondition)
        return this
    }

}