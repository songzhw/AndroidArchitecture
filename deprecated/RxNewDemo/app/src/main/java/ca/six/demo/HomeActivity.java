package ca.six.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import ca.six.demo.rx.binding.Binds;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class HomeActivity extends AppCompatActivity {

    private TextView tvMessage;
    private CompositeDisposable allDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvMessage = (TextView) findViewById(R.id.message);
        Button btn = (Button)findViewById(R.id.btnHome);

        Disposable disposableClick = Binds.clicks(btn)
                .throttleFirst(2, TimeUnit.SECONDS)
                .subscribe( (obj) -> {
                        System.out.println("szw click btn1 "+ System.currentTimeMillis());
                });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        Disposable disposableNav = Binds.nav(navigation)
                .subscribe( (item) -> tvMessage.setText(item.getTitle()));

        allDisposable = new CompositeDisposable();
        allDisposable.addAll(disposableClick, disposableNav);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        allDisposable.clear();
    }
}

/*
[CompositeDisposable]

// Using clear will clear all, but can accept new disposable
disposables.clear();

// Using dispose will clear all and set isDisposed = true, so it will not accept any new disposable
disposables.dispose();

 */