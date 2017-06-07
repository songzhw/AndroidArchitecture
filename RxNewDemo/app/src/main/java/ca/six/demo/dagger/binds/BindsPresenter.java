package ca.six.demo.dagger.binds;

import javax.inject.Inject;

public class BindsPresenter implements IBindsPresenter{
    @Inject BindsDataService dataService; // 新加个@Inject

    @Inject  public BindsPresenter() { // CF干掉了参数
    }

    @Override
    public void init() {
        System.out.println("szw init();"+dataService.id);
    }
}