package ca.six.demo.dagger.cf_arg;

import javax.inject.Inject;

public class SamplePresenter {
    private ISampleView view;

    @Inject
    public SamplePresenter(ISampleView view) {
        this.view = view;
        view.viewReady();
    }
}