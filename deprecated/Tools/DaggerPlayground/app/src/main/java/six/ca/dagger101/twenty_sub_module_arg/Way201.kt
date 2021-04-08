package six.ca.dagger101.twenty_sub_module_arg

import android.app.Activity
import android.os.Bundle
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Inject

// = = = = = = = = =
@Module
class BeerModule(val name: String) {
    @Provides
    fun beer() = "beer $name"
}

@Subcomponent(modules = [BeerModule::class])
interface BeerComponent {
    fun inject(receiver: TwentySolution01)
}

// = = = = = = = = =

@Module
class AlcoholModule{
    @Provides
    fun alcohol() = true  //刚开始写成也返回String. 编译就出错: "Dagger/DuplicateBindings error"
}

@Component(modules = [AlcoholModule::class])
interface AlcoholComponent {
    fun alcohol() : Boolean
    fun beerComponent(beerModule : BeerModule) : BeerComponent
}

// = = = = = = = = =
class TwentySolution01 : Activity(){
    @Inject lateinit var beerName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerAlcoholComponent.create()
                .beerComponent(BeerModule("szw"))
                .inject(this)

        println("szw 20-Approach01  :  $beerName") //=> bear szw
    }
}
