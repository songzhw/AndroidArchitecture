package six.ca.dagger101.twentythree_scope_peractivity

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Scope
import javax.inject.Singleton

class HttpEngine23

// 每个页面都需要HttpEngine, 没必要每个都创建一个. 所以可以是一个全局存在的单例
@Module
class Common23Module {
    @Singleton @Provides
    fun httpClient() : HttpEngine23 {
        return HttpEngine23()
    }
}

@Singleton
@Component(modules = [Common23Module::class])
interface Common23Component {
    fun http() : HttpEngine23
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity

@Module
class One23Module {
    @PerActivity @Provides
    fun name1() = "name1"
}

@PerActivity
@Component(modules = [One23Module::class], dependencies = [Common23Component::class])
interface One23Component {
    fun inject(receiver: Page23One)
}


@Module
class Two23Module {
    @PerActivity @Provides
    fun name2() = "name2"
}

@PerActivity
@Component(modules = [Two23Module::class], dependencies = [Common23Component::class])
interface Two23Component {
    fun inject(receiver: Page23Two)
}