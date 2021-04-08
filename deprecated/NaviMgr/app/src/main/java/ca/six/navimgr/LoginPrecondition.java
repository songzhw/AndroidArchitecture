package ca.six.navimgr;

import ca.six.navimgr.lib.IPrecondition;


public class LoginPrecondition implements IPrecondition {

    @Override
    public boolean isValid() {
        return UserManager.isLogin;
    }

}
