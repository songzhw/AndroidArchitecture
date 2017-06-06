package ca.six.demo.dagger.cf_arg;

import dagger.Module;
import dagger.Provides;

@Module
public class SampleViewModule {
    private ISampleView view;

    public SampleViewModule(ISampleView view) {
        this.view = view;
    }

    @Provides ISampleView getView(){
        return view;
    }
}