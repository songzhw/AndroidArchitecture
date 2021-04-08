package ca.six.archi.cfl

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import ca.six.archi.cfl.biz.MainViewModel
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
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MainViewModelTest {
    // 应对LiveData
    @get:Rule var rule1 = InstantTaskExecutorRule()

    // 应对Coroutine
    @ExperimentalCoroutinesApi
    @get:Rule var rule2 = MainCoroutineRule()

    lateinit var depProvider: DepProvider

    val data = arrayListOf(
        Plant("1", "1", "1", 9),
        Plant("2", "2", "2", 3),
        Plant("3", "3", "3", 3),
        Plant("5", "5", "5", 3)
    )

    // 备注: 2020.09.07
    // 我晕, 后来发现, 这里会报错"method setUp() should be void), 是说它要返回void, 但有了runnBlocking后,它返回的不是void.
    // 麻烦就麻烦在, 这个@before以前也成功了. 现在反而失败了.
    // 于是我把runBlocking移到下面方法中, 竟然又不检查 返回要为void了. 我也是晕!!
//    @Before
//    fun setUp() = runBlocking {
//        val mockHttp = mock(IHttpService::class.java)
//        `when`(mockHttp.getAllPlants()).thenReturn(data)
//        `when`(depProvider.http).thenReturn(mockHttp)
//    }


    @ExperimentalCoroutinesApi
    @Test
    fun fetchPlants() = runBlocking{
        depProvider = mock(DepProvider::class.java)
        val mockHttp = mock(IHttpService::class.java)
        `when`(mockHttp.getAllPlants()).thenReturn(data)
        `when`(depProvider.http).thenReturn(mockHttp)

        // 应对viewModelScope.launch(dispatch)
        val testDispatcher = TestCoroutineDispatcher()
        val vm = MainViewModel()
        vm.injector = depProvider
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
        val vm = MainViewModel()
        vm.data.clear()
        vm.data.addAll(data)

        vm.filterData()
        assertEquals(3, vm.dataLiveData.value?.size)

        vm.filterData()
        assertEquals(4, vm.dataLiveData.value?.size)
        assertFalse(vm.isFiltered)
    }

    // vm.fetchPlant needs the coroutine, so w eneed the `runBlocking` here
    @Test
    fun getPlant() = runBlocking{
        depProvider = mock(DepProvider::class.java)
        val mockHttp = mock(IHttpService::class.java)
        `when`(mockHttp.getAllPlants()).thenReturn(data)
        `when`(depProvider.http).thenReturn(mockHttp)

        // 应对viewModelScope.launch(dispatch)
        val testDispatcher = TestCoroutineDispatcher()
        val vm = MainViewModel()
        vm.injector = depProvider
        vm.dispatch = testDispatcher
        vm.fetchPlants()

        val plant = vm.getPlant(0)
        assertEquals(plant.description, "1")

        vm.filterData()
        val plant2 = vm.getPlant(0)
        assertEquals(plant2.name, "2")

        vm.filterData()
        val plant3 = vm.getPlant(0)
        assertEquals(plant3.plantId, "1")
    }
}