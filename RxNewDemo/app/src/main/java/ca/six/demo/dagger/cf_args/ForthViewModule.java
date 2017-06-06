package ca.six.demo.dagger.cf_args;

import dagger.Module;
import dagger.Provides;

@Module
public class ForthViewModule {
    private IForthView view;

    public ForthViewModule(IForthView view) {
        this.view = view;
    }

    @Provides
    IForthView getView(){
        return view;
    }
}