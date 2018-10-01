package six.ca.dagger101.third.dagger

import dagger.Component
import six.ca.dagger101.third.ThirdDemo

@Component(modules = [CriticalModule::class])
interface CriticalComponent {  //注意, 声明为class时编译出错: "error: @Component may only be applied to an interface or abstract class"
    fun inject(receiver: ThirdDemo)
}

