package six.ca.dagger101.eight

import javax.inject.Inject

interface IEggPresenter {
    fun getNames(): List<String>
}

class EggPresenter
    @Inject constructor(val service: EggService)
    : IEggPresenter {

    override fun getNames(): List<String> {
        return listOf("a", "1", "bo", "ca")
    }

}

