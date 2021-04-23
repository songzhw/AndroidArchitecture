package ca.six.demo.cleanviper;

import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

class Temp extends AppCompatActivity {
    public Temp() {
        super();
    }

    @ContentView
    public Temp(@LayoutRes int contentLayoutId) {
        super(contentLayoutId);
    }
}
