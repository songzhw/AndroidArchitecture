package cn.six.lab.decopuled_base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by songzhw on 2017-01-28
 */

public abstract class ZBaseActivity extends Activity {
    protected ActivityDelegateHelper delegater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        delegater = new ActivityDelegateHelper(this);
        initDelegater();
        delegater.onCreate(savedInstanceState);
    }

    public abstract void initDelegater();

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        delegater.onPostCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        delegater.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        delegater.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        delegater.onStop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        delegater.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        delegater.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        delegater.onActivityResult(requestCode, resultCode, data);
    }

}
