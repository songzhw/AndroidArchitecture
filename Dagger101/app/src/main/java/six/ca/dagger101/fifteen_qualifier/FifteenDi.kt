package six.ca.dagger101.fifteen_qualifier

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class BeijingOpera


@Module
class ShengModule {
    @Provides @IntoSet @BeijingOpera
    fun getSheng() : String {
        return "Sheng"
    }
}

@Module
class DangModule {
    @Provides @IntoSet @BeijingOpera
    fun getDang() : String {
        return "Dang"
    }
}


@Module
class PopModule {
    @Provides @IntoSet
    fun getPop() : String {
        return "pop"
    }
}

@Component(modules = [ShengModule::class, DangModule::class, PopModule::class])
interface SingerComponent {
    fun inject(receiver: FifteenActivity)
}