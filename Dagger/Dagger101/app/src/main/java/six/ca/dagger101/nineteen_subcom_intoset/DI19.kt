package six.ca.dagger101.nineteen_subcom_intoset

import android.app.Activity
import android.os.Bundle
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.multibindings.IntoSet
import javax.inject.Inject

// = = = = = = = Parent DI = = = = = =
@Module
class MaModule {
    @Provides @IntoSet
    fun honey(): String = "honey"
}

@Module
class BaModule {
    @Provides @IntoSet
    fun salt(): String = "salt"
}

@Component(modules = [MaModule::class, BaModule::class])
interface ParentComponent {
    fun foods(): Set<String>
    fun child() : ChildComponent
}

// = = = = = = Child DI = = = = = =
@Module
class ChildModule {
    @Provides @IntoSet
    fun msg() : String = "msg"
}

@Subcomponent(modules = [ChildModule::class])
interface ChildComponent {
    fun foods(): Set<String>
//    fun inject(receiver : NineteenDemo)
}


// = = = = = = Activity = = = = = =
class NineteenDemo : Activity() {
    @Inject lateinit var foods : Set<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val set1 = DaggerParentComponent.create()
                .foods()
        set1.forEach { println("szw parent : $it") }


        foods = DaggerParentComponent.create()
                .child()
                .foods()

        foods.forEach { println("szw child : $it") }
    }
}