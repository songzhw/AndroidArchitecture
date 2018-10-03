package six.ca.dagger101.nine.di

import dagger.Component
import dagger.Module
import dagger.Provides


class Food

class Cloth

@Module
class PackModule {
    @Provides
    internal fun provideCloth(): Cloth {
        return Cloth()
    }

    @Provides
    internal fun provideFood(): Food {
        return Food()
    }
}

@Component(modules = [PackModule::class])
interface PackComponent {
    val cloth: Cloth
}