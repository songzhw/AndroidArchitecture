package ca.six.demo.dagger.cf_args;

import javax.inject.Inject;

import ca.six.demo.dagger.cf_args.data.TaskRepo;

public class ForthPresenter {
    private TaskRepo repo;
    private IForthView view;

    @Inject
    public ForthPresenter(IForthView view, TaskRepo repo) {
        this.repo = repo;
        this.view = view;
        view.viewReady();
    }
}