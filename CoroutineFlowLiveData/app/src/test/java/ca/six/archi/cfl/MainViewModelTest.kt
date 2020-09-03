package ca.six.archi.cfl

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.*
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {
    @get:Rule var rule = InstantTaskExecutorRule()

    @Test
    fun updateDisplayThreeTimes_shouldFirstGridThenListThenGrid() {
        val vm = MainViewModel()
        assertTrue(vm.isGrid)

        vm.updateDisplay()
        assertFalse(vm.isGrid)

        vm.updateDisplay()
        assertTrue(vm.isGrid)
    }
}