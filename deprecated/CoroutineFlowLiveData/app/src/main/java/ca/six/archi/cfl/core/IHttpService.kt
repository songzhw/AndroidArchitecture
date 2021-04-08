package ca.six.archi.cfl.core

import ca.six.archi.cfl.data.Plant
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IHttpService {
    @GET("plants.json")
    suspend fun getAllPlants() : List<Plant>

    @GET("custom_plant_sort_order.json")
    suspend fun getCustomPlantSortOrder() : List<Plant>

}


object Http {
    val service: IHttpService by lazy {
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/googlecodelabs/kotlin-coroutines/master/advanced-coroutines-codelab/sunflower/src/main/assets/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IHttpService::class.java)
    }

}