package ca.six.demo.dagger.cf_args;

import javax.inject.Inject;

public class ForthPresenter {
    private IForthView view;

    @Inject
    public ForthPresenter(IForthView view) {
        this.view = view;
        view.viewReady();
    }
}