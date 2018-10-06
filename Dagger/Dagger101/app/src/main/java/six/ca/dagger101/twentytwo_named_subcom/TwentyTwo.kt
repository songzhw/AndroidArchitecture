package six.ca.dagger101.twentytwo_named_subcom

import android.app.Activity
import android.os.Bundle
import dagger.*
import javax.inject.Inject
import javax.inject.Named


// = = = = = = = = =
@Module
class BulbModule {
    @Provides @Named("child")
    fun bulb(bulbId: Int) = "Bulb $bulbId"
}

@Subcomponent(modules = [BulbModule::class])
interface BulbComponent {
    fun inject(receiver: TwentyTwoDemo)

    @Subcomponent.Builder
    interface Builder {
        fun build(): BulbComponent
        @BindsInstance fun bulbId(id: Int): Builder
    }

}

// = = = = = = = = =

@Module
class LampModule {
    @Provides @Named("parent")
    fun lamp() = "lamp"
}

@Component(modules = [LampModule::class])
interface LampComponent {
    @Named("parent") fun lamp(): String
    fun bulbComponentBuilder(): BulbComponent.Builder
}

// = = = = = = = = =
class TwentyTwoDemo : Activity() {
    @field: [Inject Named("child")]
    lateinit var bulbName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        DaggerLampComponent.create()
                .bulbComponentBuilder()
                .bulbId(555)
                .build()
                .inject(this)

        println("szw 22  :  $bulbName")  //=> szw 22  :  Bulb 555

    }
}