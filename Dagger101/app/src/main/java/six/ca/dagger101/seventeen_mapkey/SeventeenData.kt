package six.ca.dagger101.seventeen_mapkey

import dagger.Component
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

enum class Sense constructor(val num: Int, val desp : String, val isSome : Boolean){
    Happy(10, "test", true),
    Sad(22, "rel", false);
}

