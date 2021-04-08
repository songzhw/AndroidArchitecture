package ca.six.navimgr;

import ca.six.navimgr.lib.IPrecondition;


public class SecurePrecondition implements IPrecondition {

    @Override
    public boolean isValid() {
        return UserManager.hasId;
    }

}
