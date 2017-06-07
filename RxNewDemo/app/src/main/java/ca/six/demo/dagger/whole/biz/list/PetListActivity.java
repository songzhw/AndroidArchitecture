package ca.six.demo.dagger.whole.biz.list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;

import javax.inject.Inject;

import ca.six.demo.dagger.whole.biz.detail.PetDetailActivity;
import ca.six.demo.dagger.whole.core.WholeApp;
import okhttp3.OkHttpClient;


public class PetListActivity extends Activity implements IPetListView {
    @Inject Context app;
    @Inject OkHttpClient http;
    @Inject PetListPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerPetListComponent.builder()
                .appComponent( ((WholeApp) getApplication()).getAppComponent())
                .petListModule(new PetListModule(this))
                .build()
                .inject(this);

        System.out.println("szw PetListPage : app = " + app);
        System.out.println("szw PetListPage : http = " + http);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            startActivity(new Intent(this, PetDetailActivity.class));
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void viewReady() {
        System.out.println("szw PetListPage : viewReady()");
    }
}
