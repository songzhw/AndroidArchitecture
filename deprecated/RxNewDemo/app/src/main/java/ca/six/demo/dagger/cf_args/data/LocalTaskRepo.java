package ca.six.demo.dagger.cf_args.data;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class LocalTaskRepo implements IDataSource {

    @Inject
    public LocalTaskRepo() {
    }

    @Override
    public List<String> getNames() {
        List<String> ret = new ArrayList<>();
        ret.add("local");
        ret.add("local2");
        return ret;
    }
}
