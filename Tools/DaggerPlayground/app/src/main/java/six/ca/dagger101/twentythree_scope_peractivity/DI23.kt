package six.ca.dagger101.twentythree_scope_peractivity

import dagger.Component
import dagger.Module
import dagger.Provides

class HttpEngine23


@Module
class One23Module {
    @Provides
    fun http() = HttpEngine23()
}

@Component(modules = [One23Module::class])
interface One23Component {
    fun inject(receiver: Page23One)
}


@Module
class Two23Module {
    @Provides
    fun http() = HttpEngine23()
}

@Component(modules = [Two23Module::class])
interface Two23Component {
    fun inject(receiver: Page23Two)
}