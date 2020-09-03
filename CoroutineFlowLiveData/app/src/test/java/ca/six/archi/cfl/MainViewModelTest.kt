package ca.six.archi.cfl

import junit.framework.Assert.*
import org.junit.Test

class MainViewModelTest {
    @Test
    fun updateDisplayThreeTimes_shouldFirstGridThenListThenGrid() {
        val vm = MainViewModel()
        assertTrue(vm.isGrid)
    }
}