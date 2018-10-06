package six.ca.dagger101.fourth.dagger

import dagger.Component
import six.ca.dagger101.fourth.ForthDemo

@Component(modules = [CatModule::class])
interface CatComponent {
    fun inject(receiver: ForthDemo)
}