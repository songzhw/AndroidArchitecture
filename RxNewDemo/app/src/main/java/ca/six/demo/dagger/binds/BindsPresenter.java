package ca.six.demo.dagger.binds;

public class BindsPresenter implements IBindsPresenter{

    // 有Module的情形下， CF可以不用加@Inject的
    // 若又有Module， 又有@Inject. Component会先去查Module维度的，找到停止找@Inject维度的了
    public BindsPresenter() {
        init();
    }

    @Override
    public void init() {
        System.out.println("szw init();");
    }
}