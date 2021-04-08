package ca.six.mvi.biz.home

class HomeData {
    var isError: Boolean = false
    var isLoading: Boolean = false
    var error: Throwable? = null
    var todos: List<Todo>? = null

    constructor(error: Throwable){
        this.error = error
        this.isError = true
    }

    constructor(isLoading: Boolean){
        this.isLoading = isLoading
    }

    constructor(todos: List<Todo>?) {
        this.todos = todos
    }

    override fun toString(): String {
        return "HomeData(isError=$isError, isLoading=$isLoading, error=$error, todos=$todos)"
    }


//    class Empty : HomeData{}
//    class Loading : HomeData {}
//    class TodoList(val todos: ArrayList<Todos>) : HomeData { }
//    class Error(val error: Throwable) : HomeData { }

}