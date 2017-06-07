package ca.six.demo.dagger.scope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModel {

    @Singleton
    @Provides
    public User getUser(){
        return new User();
    }
}