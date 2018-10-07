package six.ca.dagger101.ten.di

import dagger.Component
import dagger.Module
import dagger.Provides
import six.ca.dagger101.nine.di.Cloth
import six.ca.dagger101.nine.di.Food

@Module
class PackModule2 {
    @Provides
    internal fun provideCloth(): Cloth {
        return Cloth()
    }

    @Provides
    internal fun provideFood(): Food {
        return Food()
    }
}

@Component(modules = [PackModule2::class])
interface PackComponent2 {
    fun miComponent() : MiComponent //提供获取Subcomponent对象的方法
}