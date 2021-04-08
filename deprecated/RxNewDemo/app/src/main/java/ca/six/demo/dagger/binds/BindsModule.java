package ca.six.demo.dagger.binds;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class BindsModule {
    @Binds
    abstract IBindsPresenter getBindsPresenter(BindsPresenter presenter);
}
