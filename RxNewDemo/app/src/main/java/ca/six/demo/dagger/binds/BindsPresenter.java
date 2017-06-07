package ca.six.demo.dagger.binds;

import javax.inject.Inject;

public class BindsPresenter implements IBindsPresenter{
    @Inject BindsDataService dataService;
    @Inject User user;

    @Inject  public BindsPresenter() {
    }

    @Override
    public void init() {
        System.out.println("szw init() : service = "+dataService.id);
        System.out.println("szw init() : user = "+user.id);
    }
}