package ca.six.demo.dagger.whole.biz.detail;

import ca.six.demo.dagger.whole.core.AppComponent;
import ca.six.demo.dagger.whole.dagger.PerActivity;
import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class)
public interface PetDetailComponent {
    void inject(PetDetailActivity activity);
}
