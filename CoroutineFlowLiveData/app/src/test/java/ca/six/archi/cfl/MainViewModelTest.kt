package ca.six.archi.cfl

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import ca.six.archi.cfl.data.Plant
import junit.framework.Assert.*
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    @get:Rule var rule1 = InstantTaskExecutorRule()
    @get:Rule var rule2 = MainCoroutineRule()

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
    }

    @Test
    fun fetchPlants() {
        val vm = MainViewModel()
        vm.fetchPlants()
        println(vm.data)
    }
}