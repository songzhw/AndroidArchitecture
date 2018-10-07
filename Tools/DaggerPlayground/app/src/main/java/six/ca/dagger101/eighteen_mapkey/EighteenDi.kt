package six.ca.dagger101.eighteen_mapkey

import android.app.Activity
import android.os.Bundle
import dagger.Component
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Inject
import kotlin.reflect.KClass

class Worker18

/*
error:
@AutoAnnotation is a necessary dependency if @MapKey(unwrapValue = false).
Add a dependency on com.google.auto.value:auto-value:1.6.2

但我加了:
implementation "com.google.auto.value:auto-value:1.6.2"
kapt "com.google.auto.value:auto-value:1.6.2"
都不行
 */



/*
@MapKey(unwrapValue = false)
annotation class Key18(
        val name: String,
        val implementingClass: KClass<*>,
        val thresholds: IntArray)

@Module
class Module18 {
    @Provides
    @IntoMap
    @Key18(name = "szw", implementingClass = Worker18::class, thresholds = [1, 4, 3])
    fun provide(): String {
        return "value18"
    }
}

@Component(modules = [Module18::class])
interface Component18 {
    fun inject(receiver: EighteenDemo)
}

class EighteenDemo : Activity() {
    @Inject lateinit var map : Map<Key18, String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        map.forEach { k, v ->
            println("szw key18 : ${k.name}, ${k.thresholds}, ${k.implementingClass}")
            println("szw value18: $v")
        }

    }
}
*/