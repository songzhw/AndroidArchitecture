package ca.six.lithodemo.three;

import android.app.Activity;
import android.graphics.Color;
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


public class ThirdDemo extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ComponentContext ctx = new ComponentContext(this);
        final RecyclerBinder binder = new RecyclerBinder(ctx,
                new LinearLayoutInfo(this, OrientationHelper.VERTICAL, false));
        final Component component = Recycler.create(ctx)
                .binder(binder).build();

        for(int i = 0 ; i < 33; i++){
            Component item = ThreeLayout.create(ctx)
                    .color(i % 2 == 0 ? Color.WHITE : Color.LTGRAY)
                    .title("Title "+i)
                    .subtitle("text "+(10+i))
                    .shadowRadiusDip(i)
                    .build();
            binder.insertItemAt(i, ComponentInfo.create().component(item).build());
        }

        final LithoView view = LithoView.create(this, component);
        setContentView(view);
    }
}
