package ca.six.demo.dagger.whole.biz.list;

import javax.inject.Inject;

public class PetListPresenter {
    @Inject IPetListView view;

    @Inject public PetListPresenter(IPetListView view) {
        this.view = view;
        view.viewReady();
    }
}
