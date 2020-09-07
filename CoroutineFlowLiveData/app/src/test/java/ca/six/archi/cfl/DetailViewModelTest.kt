package ca.six.archi.cfl

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import ca.six.archi.cfl.biz.DetailViewModel
import ca.six.archi.cfl.core.DepProvider
import ca.six.archi.cfl.core.db.PlantDao
import ca.six.archi.cfl.core.db.PrevPlant
import ca.six.archi.cfl.data.Plant
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class DetailViewModelTest {
    // 应对LiveData
    @get:Rule var rule1 = InstantTaskExecutorRule()

    // 应对Coroutine
    @ExperimentalCoroutinesApi
    @get:Rule var rule2 = MainCoroutineRule()


    @Before
    fun setup() {
        val prevPlant = PrevPlant(1, Plant("5", "5", "5", 3))
        val db = mock(PlantDao::class.java)
        `when`(db.getPreviousPlant()).thenReturn(prevPlant)
        println("szw pro = $DepProvider")
        println("szw db  = ${DepProvider.db}")
        DepProvider.db = db;
    }

    @ExperimentalCoroutinesApi
    @Test
    fun getAndSetNewPreviousPlant() {
        // 应对viewModelScope.launch(dispatch)
        val testDispatcher = TestCoroutineDispatcher()
        val vm = DetailViewModel()
        vm.dispatch = testDispatcher

        val curr = Plant("10", "10", "10", 5)
        vm.getPrevPlant(curr)
        val prev = vm.previousPlantLiveData.value
        assertEquals(5, prev?.plant?.plantId)
    }

}