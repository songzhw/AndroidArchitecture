package ca.six.mvi.biz.home

import org.json.JSONArray
import org.json.JSONObject


class Todo {
    var position: Int
    var description: String

    constructor(position: Int, description: String){
        this.position = position
        this.description = description
    }

    constructor(json : JSONObject){
        this.position = json.optInt("pos")
        this.description = json.optString("desp")
    }


    fun createWithJsonArray(array: JSONArray): ArrayList<Todo> {
        val result = ArrayList<Todo>()

        for (i in 0 until array.length()) {
            val obj = Todo(array.optJSONObject(i))
            result.add(obj)
        }

        return result
    }

}