package ca.six.mvi.biz.home

import ca.six.mvi.utils.http.HttpEngine

class HomePresenter {

    fun onCreate(){
        HttpEngine().get("http://localhost:8899/todos")
    }
}