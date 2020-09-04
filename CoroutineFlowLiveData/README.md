#CoroutineFlowLiveData Demo

A sample project in 2020 to demonstrate how to use C, F, L together.
It contains:
* Coroutine
* Flow
* LiveData
* ViewModel


functionality:
1). main page: retrofit fetches the data, activity shows them
2). detail pag: ROOM save the last visit plant, and you can go to the last visit plant (detail page) in your current plant page

Note:
1. If a data involves database cache and http service, this is complex, and we should use `Repository` class to handle this kind of logic
Otherwise, we can just use http service, no `Repository` class is necessary

