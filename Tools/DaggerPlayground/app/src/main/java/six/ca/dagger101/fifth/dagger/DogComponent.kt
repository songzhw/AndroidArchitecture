package six.ca.dagger101.fifth.dagger

import dagger.Component
import six.ca.dagger101.fifth.FifthDemo

@Component(modules = [DogModule::class, DogHouseNameModule::class])
interface DogComponent {
    fun inject(receiver: FifthDemo)
}