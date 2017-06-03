package six.ca.demo.dagger2.second;

import dagger.Module;
import dagger.Provides;

@Module
public class SecondModule {
    @Provides Banana getBanana(){
        return new Banana();
    }
}
