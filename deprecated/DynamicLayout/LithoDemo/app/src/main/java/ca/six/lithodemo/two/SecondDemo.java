package ca.six.lithodemo.two;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.OrientationHelper;

import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentInfo;
import com.facebook.litho.LithoView;
import com.facebook.litho.widget.LinearLayoutInfo;
import com.facebook.litho.widget.Recycler;
import com.facebook.litho.widget.RecyclerBinder;


public class SecondDemo extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ComponentContext ctx = new ComponentContext(this);
        final RecyclerBinder binder = new RecyclerBinder(ctx,
                new LinearLayoutInfo(this, OrientationHelper.VERTICAL, false));
        final Component component = Recycler.create(ctx)
                .binder(binder).build();

        final Component text = ListItem.create(ctx).build();
        for(int i = 0 ; i < 23; i++){
            binder.insertItemAt(i, ComponentInfo.create().component(text).build());
        }

        final LithoView view = LithoView.create(this, component);
        setContentView(view);
    }
}
