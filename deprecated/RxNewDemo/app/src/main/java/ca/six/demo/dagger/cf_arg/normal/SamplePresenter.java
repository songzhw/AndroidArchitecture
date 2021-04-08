package ca.six.demo.dagger.cf_arg.normal;

public class SamplePresenter {
    private ISampleView view;

    public SamplePresenter(ISampleView view) {
        this.view = view;
        view.viewReady();
    }
}