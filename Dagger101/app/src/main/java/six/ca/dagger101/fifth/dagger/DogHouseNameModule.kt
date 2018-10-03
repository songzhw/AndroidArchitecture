package six.ca.dagger101.fifth.dagger

import dagger.Module
import dagger.Provides

@Module
class DogHouseNameModule {

    @Provides
    fun getDogHouseName() : String {
        return "dog house 007"
    }

}