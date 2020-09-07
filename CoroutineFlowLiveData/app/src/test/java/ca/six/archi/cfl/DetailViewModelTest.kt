package ca.six.archi.cfl

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import ca.six.archi.cfl.biz.DetailViewModel
import ca.six.archi.cfl.core.DepProvider
import ca.six.archi.cfl.core.db.PlantDao
import ca.six.archi.cfl.core.db.PrevPlant
import ca.six.archi.cfl.data.Plant
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class DetailViewModelTest {
    // 应对LiveData
    @get:Rule var rule1 = InstantTaskExecutorRule()

    // 应对Coroutine
    @ExperimentalCoroutinesApi
    @get:Rule var rule2 = MainCoroutineRule()

    lateinit var injector : DepProvider


    @Before
    fun setup() {
        injector = mock(DepProvider::class.java)
        val prevPlant = PrevPlant(1, Plant("5", "5", "5", 3))
        val db = mock(PlantDao::class.java)
        `when`(db.getPreviousPlant()).thenReturn(prevPlant)
        `when`(injector.db).thenReturn(db)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getAndSetNewPreviousPlant() {
        println("szw test0 : ${injector.db}")
        // 应对viewModelScope.launch(dispatch)
        val testDispatcher = TestCoroutineDispatcher()
        val vm = DetailViewModel()
        vm.injector = injector
        vm.dispatch = testDispatcher

        val curr = Plant("10", "10", "10", 5)
        vm.getPrevPlant(curr)
        val prev = vm.previousPlantLiveData.value
        println("szw prev = $prev")
        assertEquals(5, prev?.plant?.plantId)
    }

}