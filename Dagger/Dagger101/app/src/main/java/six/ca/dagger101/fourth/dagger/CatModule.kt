package six.ca.dagger101.fourth.dagger

import dagger.Module
import dagger.Provides
import six.ca.dagger101.fourth.Cat
import six.ca.dagger101.fourth.CatService

@Module
class CatModule {
    @Provides
    fun cat(catService: CatService): Cat {
        return Cat(catService)
    }

    @Provides
    fun catService() : CatService {
        return CatService()
    }
}