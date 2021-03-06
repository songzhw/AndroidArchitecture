package six.ca.dagger101.second;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

public class SecondDemo extends Activity {
    @Inject Banana banana;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerSecondComponent.builder()
                .secondModule(new SecondModule())
                .build()
                .inject(this);

        System.out.println("szw banana = "+banana.toString());
    }
}