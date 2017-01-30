package cn.six.lab.decopuled_base.delegate;

import android.app.Activity;

import cn.six.lab.R;
import cn.six.lab.decopuled_base.ActivityDelegate;

/**
 * Created by songzhw on 2017-01-29
 */

public class RefreshActivityDelegate extends ActivityDelegate {

    private final IRefreshActionListener listener;

    public RefreshActivityDelegate(Activity activity, IRefreshActionListener listener) {
        super(activity);
        this.listener = listener;
    }

    @Override
    protected void onPostCreate() {
//        MyActionBar actionBar = activity.findViewById(R.id.ab);
//        actionBar.addRightButton(new RefreshAction(listener));
    }
}
