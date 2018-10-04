package six.ca.dagger101.thirteen_intoset

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet

@Module
class ThunderModule {
    @Provides @IntoSet
    fun getThunder() : String{
        return "thunder"
    }
}

@Module
class WindModule {
    @Provides @IntoSet
    fun getWind() : String {
        return "wind"
    }
}


@Component(modules = [ThunderModule::class, WindModule::class])
interface WeatherComponent {
    fun inject(receiver: ThirteenDemo)
}