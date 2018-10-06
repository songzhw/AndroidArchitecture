package six.ca.dagger101.nine.di

import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Provides
import six.ca.dagger101.nine.Cam
import six.ca.dagger101.nine.NineActivity

@Module
class CamModule {
    @Provides
    fun cam(): Cam {
        return Cam()
    }
}

@Component(
        dependencies = [PackComponent::class],
        modules = [CamModule::class]
)
interface CamComponent {
    fun inject(receiver: NineActivity)
}

