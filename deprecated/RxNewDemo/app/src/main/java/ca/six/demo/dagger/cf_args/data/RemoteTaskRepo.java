package ca.six.demo.dagger.cf_args.data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class RemoteTaskRepo implements IDataSource {

    @Inject
    public RemoteTaskRepo() {
    }

    @Override
    public List<String> getNames() {
        List<String> ret = new ArrayList<>();
        ret.add("remote");
        return ret;
    }
}