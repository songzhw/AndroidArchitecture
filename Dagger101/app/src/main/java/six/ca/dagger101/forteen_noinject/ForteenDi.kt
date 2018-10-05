package six.ca.dagger101.forteen_noinject

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class OneModule {
    @Provides @IntoSet
    fun one() : String = "one"
}

@Module
class NameModule {
    @Provides
    fun name() : String = "szw"
}

@Component(modules = [OneModule::class, NameModule::class])
interface ForteenComponent {
    fun numbers() : Set<String>
    fun name() : String
}