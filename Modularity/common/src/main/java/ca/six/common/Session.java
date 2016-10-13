package ca.six.common;

/**
 * Created by songzhw on 2016-10-12
 */

public class Session {
    public User user;

    private Session() {
    }

    public static Session instance = new Session();

    public static Session getInstance() {
        return instance;
    }
}
