package ca.six.mvi.biz.home

import ca.six.mvi.utils.http.HttpCode
import ca.six.mvi.utils.http.HttpEngine
import io.reactivex.Flowable
import org.json.JSONArray
import org.json.JSONObject

class HomeModel {
    fun getTodoList(): Flowable<HomeData> {
        val flow = HttpEngine().get("http://192.168.2.26:8899/todos") // 取到Flowable<Response>
                .map { resp ->
                    val responseJson = JSONObject(resp.body()?.string())
                    val respCode = responseJson.get("code")
                    val isOkay = respCode == HttpCode.OK
                    if (isOkay) {
                        val todoJsonArray = responseJson["todos"] as JSONArray
                        val todoList: List<Todo> = Todo.createWithJsonArray(todoJsonArray)
                        HomeData(todoList)
                    } else {
                        HomeData(RuntimeException("error : code = $respCode"))
                    }
                }
//                .startWith(HomeData(isLoading = true)) //TODO
                .onErrorReturn { error -> HomeData(error) }
        return flow
    }

}