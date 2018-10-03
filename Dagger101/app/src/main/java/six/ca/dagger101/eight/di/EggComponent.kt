package six.ca.dagger101.eight.di

import dagger.Component
import six.ca.dagger101.eight.EggActivity

@Component(modules = [EggModule::class])
interface EggComponent {
    fun inject(receiver: EggActivity)
}