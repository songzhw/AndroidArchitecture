package six.ca.dagger101.twenty_sub_module_arg

import android.app.Activity
import android.os.Bundle
import dagger.*
import javax.inject.Inject


// = = = = = = = = =
@Module
class TeaModule{
    @Provides
    fun tea(teaId : Int) = "Tea $teaId"  //这teaID若是string, 就会有DuplicatedBinding错误. 即与component.getTea()的返回值重叠了
}

@Subcomponent(modules = [TeaModule::class])
interface TeaComponent {
    fun inject(receiver: TwentySolution02)

    @Subcomponent.Builder
    interface Builder {
        fun build() : TeaComponent
        @BindsInstance fun teaId(id: Int) : Builder
    }

}

// = = = = = = = = =

@Module
class DrinkModule {
    @Provides
    fun drink() = true
}

@Component(modules = [DrinkModule::class])
interface DrinkComponent {
    fun drink(): Boolean
    fun teaComponent(): TeaComponent
}

// = = = = = = = = =
class TwentySolution02 : Activity() {
    @Inject lateinit var teaName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerDrinkComponent.create()
                .teaComponent()
                .teaId(321)
                .build()
                .inject(this)

        println("szw 20-Approach02  :  $teaName")  //=> szw 20-Approach02  :  Tea 321

    }
}
