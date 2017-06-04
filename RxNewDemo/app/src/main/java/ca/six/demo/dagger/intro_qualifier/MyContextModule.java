package ca.six.demo.dagger.intro_qualifier;

import javax.inject.Named;

import ca.six.demo.dagger.intro_qualifier.ctx.MyActivity;
import ca.six.demo.dagger.intro_qualifier.ctx.MyApplication;
import ca.six.demo.dagger.intro_qualifier.ctx.MyContext;
import dagger.Module;
import dagger.Provides;

@Module
public class MyContextModule {
    @Provides @Named("app") MyContext getApplication(){
        return new MyApplication();
    }

    @Provides @Named("activity") MyContext getActivity(){
        return new MyActivity();
    }

}
