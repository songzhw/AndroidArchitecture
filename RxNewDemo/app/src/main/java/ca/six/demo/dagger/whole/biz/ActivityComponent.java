package ca.six.demo.dagger.whole.biz;

import ca.six.demo.dagger.whole.biz.detail.PetDetailActivity;
import ca.six.demo.dagger.whole.biz.list.PetListActivity;
import ca.six.demo.dagger.whole.core.AppComponent;
import ca.six.demo.dagger.whole.dagger.PerActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {
    void inject(PetListActivity activity);
    void inject(PetDetailActivity activity);
}
