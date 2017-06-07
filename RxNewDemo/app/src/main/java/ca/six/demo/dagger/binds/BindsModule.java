package ca.six.demo.dagger.binds;

import dagger.Module;
import dagger.Provides;

@Module
public class BindsModule {

    @Provides
    IBindsPresenter getBindsPresenter(){
        return new BindsPresenter();
    };
}
