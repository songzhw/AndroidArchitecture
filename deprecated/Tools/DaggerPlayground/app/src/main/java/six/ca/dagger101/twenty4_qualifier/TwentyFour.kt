package six.ca.dagger101.twenty4_qualifier


import android.app.Activity
import android.os.Bundle
import dagger.*
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Qualifier




// = = = = = = = = =
@Module
class PaperModule {
    @Provides @Named("child")
    fun paper(paperId: String) = "Paper $paperId"
}

@Subcomponent(modules = [PaperModule::class])
interface PaperComponent {
    fun inject(receiver: TwentyFourDemo)

    @Subcomponent.Builder
    interface Builder {
        fun build(): PaperComponent
        @BindsInstance fun paperId(id: String): Builder
    }

}

// = = = = = = = = =

@Module
class BookModule {
    @Provides @Named("parent")
    fun book() = "book"
}

@Component(modules = [BookModule::class])
interface BookComponent {
    @Named("parent") fun book(): String
    fun paperComponentBuilder(): PaperComponent.Builder
}

// = = = = = = = = =
class TwentyFourDemo : Activity() {
    @field: [Inject Named("child")]
    lateinit var paperName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        DaggerBookComponent.create()
                .paperComponentBuilder()
                .paperId("string paper id")
                .build()
                .inject(this)

        println("szw 22  :  $paperName")  //=> szw 22  :  Paper 555

    }
}