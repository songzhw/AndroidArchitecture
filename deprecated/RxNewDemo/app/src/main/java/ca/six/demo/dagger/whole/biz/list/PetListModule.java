package ca.six.demo.dagger.whole.biz.list;

import dagger.Module;
import dagger.Provides;

@Module
public class PetListModule {
    private final IPetListView view;

    public PetListModule(IPetListView view) {
        this.view = view;
    }

    @Provides
    public IPetListView getPetListView(){
        return view;
    }
}
