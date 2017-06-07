package ca.six.demo.dagger.binds;

import javax.inject.Inject;

public class BindsDataService {
    public int id;

    @Inject
    public BindsDataService() {
        id = 22;
    }
}