package ca.six.demo.cleanviper.core.di

import ca.six.demo.cleanviper.core.http.HttpService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/* 依赖集中处, 方便集成测试*/
object DepStore {
    var http: HttpService = Retrofit.Builder()
        .baseUrl("https://run.mocky.io/v3")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build()
        .create(HttpService::class.java)


}