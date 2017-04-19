package ca.six.lithodemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.Text;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ComponentContext ctx = new ComponentContext(this);
        final LithoView view = LithoView.create(this,
                Text.create(ctx)
                    .text("Hello, Litho (facebook)")
                    .textSizeDip(28)
                    .build()
            );
        setContentView(view);
    }
}


/*
1. Emualtor is okay. But the app on Nexus 6p will crash. Crash info is :
dlopen failed: "/data/data/ca.six.lithodemo/lib-main/libgnustl_shared.so" is 32-bit instead of 64-bi

2. LithoView is a ViewGroup (according to UI Automator View)

3.

 */