package ca.six.archi.cfl

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import ca.six.archi.cfl.core.DepProvider
import ca.six.archi.cfl.core.Http
import ca.six.archi.cfl.core.IHttpService
import ca.six.archi.cfl.data.Plant
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MainViewModelTest {
    @get:Rule var rule1 = InstantTaskExecutorRule()

    @ExperimentalCoroutinesApi
    @get:Rule var rule2 = MainCoroutineRule()

    @Before
    fun setup() = runBlocking {
        val data = arrayListOf(
            Plant("1", "1", "1", 9),
            Plant("2", "2", "2", 3),
            Plant("3", "3", "3", 3),
            Plant("5", "5", "5", 3)
        )
        val mockHttp = mock(IHttpService::class.java)
        `when`(mockHttp.getAllPlants()).thenReturn(data)
        DepProvider.http = mockHttp
    }

    @After
    fun clear() {
        DepProvider.http = Http.service
    }

    @ExperimentalCoroutinesApi
    @Test
    fun fetchPlants() {
        val testDispatcher = TestCoroutineDispatcher()
        val vm = MainViewModel()
        vm.dispatch = testDispatcher
        assertEquals(0, vm.data.size)

        vm.fetchPlants()
        assertEquals(4, vm.data.size)
    }


    @Test
    fun updateDisplayThreeTimes_shouldFirstGridThenListThenGrid() {
        val vm = MainViewModel()
        assertTrue(vm.isGrid)
        assertNull(vm.listDisplayLiveData.value)

        vm.updateDisplay()
        assertFalse(vm.isGrid)
        assertTrue(vm.listDisplayLiveData.value!!)

        vm.updateDisplay()
        assertTrue(vm.isGrid)
    }

    @Test
    fun filterData() {
        val data = arrayListOf(
            Plant("1", "1", "1", 9),
            Plant("2", "2", "2", 3),
            Plant("3", "3", "3", 3),
            Plant("5", "5", "5", 3)
        )
        val vm = MainViewModel()
        vm.data.clear()
        vm.data.addAll(data)

        vm.filterData()
        assertEquals(3, vm.dataLiveData.value?.size)

        vm.filterData()
        assertEquals(4, vm.dataLiveData.value?.size)
        assertFalse(vm.isFiltered)
    }

}