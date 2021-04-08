package six.ca.dagger101.second

import dagger.Module
import dagger.Provides

@Module
class SecondModule {

    // 下面两种写法都是行的. 我试过了
//    val banana: Banana
//        @Provides get() = Banana()

    @Provides
    fun getBanana(): Banana {
        return Banana()
    }

}