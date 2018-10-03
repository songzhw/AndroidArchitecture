package six.ca.dagger101.seventh

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [SunModule::class])
interface SunComponent {
    fun inject(receiver: SevenDemo)
    fun inject(receiver: SevenDemo2)
}