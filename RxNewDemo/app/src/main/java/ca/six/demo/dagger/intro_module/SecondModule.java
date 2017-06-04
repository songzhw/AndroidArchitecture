package ca.six.demo.dagger.intro_module;

import dagger.Module;
import dagger.Provides;

@Module
public class SecondModule {
    @Provides Banana getBanana(){
        return new Banana();
    }
}
