package six.ca.dagger101.eight.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import six.ca.dagger101.eight.EggPresenter
import six.ca.dagger101.eight.EggService
import six.ca.dagger101.eight.IEggPresenter

@Module
abstract class EggModule {

//    @Provides
//    fun eggService(): EggService {
//        return EggService()
//    }
//
//    @Provides
//    fun eggPresenter(eggService: EggService): IEggPresenter {
//        return EggPresenter(eggService)
//    }


    // ======================

    @Binds
    abstract fun eggPresenter(presenter: EggPresenter): IEggPresenter

    // Error: @binds method must have exactly one parameter, whose type is assignable to the return type
    @Binds
    abstract fun eggService() : EggService

}