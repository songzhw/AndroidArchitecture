package ca.six.demo.dagger.binds;

import javax.inject.Inject;

public class User {
    public int id;

    @Inject public User(){
        id = 100;
    }
}
