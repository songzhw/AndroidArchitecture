package com.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sample.mvp_basic.tasks.TasksActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickMainMvp(View v){
        startActivity(new Intent(this, TasksActivity.class));
    }

    public void onClickMainMvpLoader(View v){
//        startActivity(new Intent(this, TasksActivity.class));
    }

    public void onClickMainMvpBinding(View v){
//        startActivity(new Intent(this, TasksActivity.class));
    }

}
