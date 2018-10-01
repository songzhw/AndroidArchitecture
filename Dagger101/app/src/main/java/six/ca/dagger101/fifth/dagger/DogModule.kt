package six.ca.dagger101.fifth.dagger

import dagger.Module
import dagger.Provides
import six.ca.dagger101.fifth.Dog
import six.ca.dagger101.fifth.DogHouse
import six.ca.dagger101.fifth.DogService

@Module
class DogModule {
    @Provides
    fun dog(service: DogService, house: DogHouse): Dog {
        return Dog(service, house)
    }

    @Provides
    fun dogHouse() : DogHouse{
        return DogHouse("five")
    }
}