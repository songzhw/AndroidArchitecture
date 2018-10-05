package six.ca.dagger101.sixteen_intomap

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntKey
import dagger.multibindings.IntoMap

@Module
class Sun161Module {
    @Provides @IntoMap @IntKey(23)
    fun one(): String = "Jordan"
}

@Module
class Sun162Module {
    @Provides @IntoMap @IntKey(8)
    fun two() : String = "kobe"
}

@Component(modules = [Sun161Module::class, Sun162Module::class])
interface Sun16Component {
    fun inject(receiver: SixteenDemo)
}