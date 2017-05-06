package ca.six.demo.biz.main;

import ca.six.demo.domain.entity.User;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivitiesModule {
    @Provides
    User fetchUser(String name){
        return new User(name);
    }

    @Provides
    String getName(){
        return "bing bong";
    }

}
