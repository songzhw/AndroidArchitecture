package ca.six.archi.cfl.core

import androidx.room.Room
import ca.six.archi.cfl.core.db.PlantDatabase

class DepProvider {
    var http = Http.service

    // kotlin中 provider.db其实又是member, 又是getter function. 这就有利于我们在test中使用when(..)thenReturn().
    // --> 主要是因为: mockedProvider.db = mockedDB是不行的, 不能重写mocked对象的成员. 我试过, 失败了.
    var db = Room.databaseBuilder(App.app!!, PlantDatabase::class.java, "plants")
        .build()
        .plantDao()

}
