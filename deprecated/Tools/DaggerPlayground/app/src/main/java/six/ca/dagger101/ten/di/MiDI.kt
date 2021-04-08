package six.ca.dagger101.ten.di

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import six.ca.dagger101.ten.Mi
import six.ca.dagger101.ten.TenActivity

@Module
class MiModule {
    @Provides
    fun mi(): Mi {
        return Mi()
    }
}

@Subcomponent(modules = [MiModule::class])
interface MiComponent {
    fun inject(receiver: TenActivity)
}

