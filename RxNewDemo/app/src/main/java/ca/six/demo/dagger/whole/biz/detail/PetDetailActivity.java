package ca.six.demo.dagger.whole.biz.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;

import javax.inject.Inject;

import ca.six.demo.dagger.whole.core.BaseActivity;
import okhttp3.OkHttpClient;


public class PetDetailActivity extends BaseActivity {
    @Inject Context app;
    @Inject OkHttpClient http;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        System.out.println("szw PetDetailPage : app = " + app);
        System.out.println("szw PetDetailPage : http = " + http);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
//            startActivity(new Intent(this, PetDetailActivity.class));
        }
        return super.onTouchEvent(event);
    }
}
