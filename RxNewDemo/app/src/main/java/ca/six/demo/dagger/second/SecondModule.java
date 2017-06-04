package ca.six.demo.dagger.second;

import dagger.Module;
import dagger.Provides;

@Module
public class SecondModule {
    @Provides Banana getBanana(){
        return new Banana();
    }
}
