package six.ca.dagger101.seventeen_mapkey

import dagger.Component
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

enum class Sense constructor(val num: Int, val desp : String, val isSome : Boolean){
    Happy(10, "test", true),
    Sad(22, "rel", false);
}

@MapKey
annotation class SenseKey(val value : Sense)

@Module
class Sense1Module {
    @Provides @IntoMap @SenseKey(Sense.Happy)
    fun get() : String = "okay"
}

@Module
class Sense2Module {
    @Provides @IntoMap @SenseKey(Sense.Sad)
    fun get() : String = "bad"
}

@Component(modules = [Sense1Module::class, Sense2Module::class])
interface SenseComponent {
    fun inject(receiver: SeventeenDemo)
}