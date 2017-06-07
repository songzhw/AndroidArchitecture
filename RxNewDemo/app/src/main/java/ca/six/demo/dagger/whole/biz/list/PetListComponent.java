package ca.six.demo.dagger.whole.biz.list;

import ca.six.demo.dagger.whole.biz.detail.PetDetailActivity;
import ca.six.demo.dagger.whole.biz.list.PetListActivity;
import ca.six.demo.dagger.whole.biz.list.PetListModule;
import ca.six.demo.dagger.whole.core.AppComponent;
import ca.six.demo.dagger.whole.dagger.PerActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = {PetListModule.class} )
public interface PetListComponent {
    void inject(PetListActivity activity);
}
