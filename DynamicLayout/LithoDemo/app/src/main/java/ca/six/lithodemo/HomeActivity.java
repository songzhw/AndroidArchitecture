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
