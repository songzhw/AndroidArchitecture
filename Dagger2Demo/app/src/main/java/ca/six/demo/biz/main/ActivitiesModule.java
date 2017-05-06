package ca.six.demo.biz.main;

import ca.six.demo.domain.entity.User;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivitiesModule {
    @Provides
    User fetchUser(){
        return new User("testName");
    }
}
