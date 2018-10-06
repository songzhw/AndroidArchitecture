package six.ca.dagger101.twentyone_named

import android.app.Activity
import android.os.Bundle
import dagger.*
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Qualifier
import dagger.Provides


open class MyContext @Inject constructor()
class MyActivity : MyContext()
class MyApplication : MyContext()

@Module
class MyContextModule {
    @Provides  @Named("app")
    fun getApplication() : MyContext{
        return MyApplication()
    }

    @Provides  @Named("activity")
    fun getMyActivity() : MyContext {
        return MyActivity()
    }

}

@Component(modules = [MyContextModule::class])
interface MyContextComponent {
    fun inject(activity: TwentyOneDemo)
}



// = = = = = = = = =
class TwentyOneDemo : Activity() {
    @Inject @Named("app") lateinit var app: MyContext
    @Inject @Named("activity") lateinit var actv: MyContext

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerMyContextComponent.create()
                .inject(this)

        println("szw 21  :  $app,  $actv")
        //=> szw 21  :
        //      six.ca.dagger101.twentyone_named.MyApplication@fb69e15,
        //      six.ca.dagger101.twentyone_named.MyActivity@e29e52a

    }
}
