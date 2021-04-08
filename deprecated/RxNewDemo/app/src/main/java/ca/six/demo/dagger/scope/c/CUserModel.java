package ca.six.demo.dagger.scope.c;

import ca.six.demo.dagger.scope.User;
import dagger.Module;
import dagger.Provides;

// UserModel类是用@UserScope修饰的， 所以这要新建个CModel类
@Module
public class CUserModel {
    @Provides User getuser(){
        return new User();
    }
}
