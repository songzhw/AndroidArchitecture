package ca.six.demo.dagger.cf_args;

import dagger.Module;
import dagger.Provides;

@Module
public class ForthViewModule {
    private ForthPresenter view;

    public ForthViewModule(ForthPresenter view) {
        this.view = view;
    }

    @Provides
    ForthPresenter getView(){
        return view;
    }
}