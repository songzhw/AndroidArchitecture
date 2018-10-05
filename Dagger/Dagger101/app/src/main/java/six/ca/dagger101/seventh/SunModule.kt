package six.ca.dagger101.seventh

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SunModule {

    @Singleton
    @Provides
    fun getSun(): Sun {
        return Sun()
    }

}