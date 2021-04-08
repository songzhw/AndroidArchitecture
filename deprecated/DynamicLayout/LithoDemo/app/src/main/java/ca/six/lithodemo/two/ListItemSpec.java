package ca.six.lithodemo.two;

import android.graphics.Color;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;

@LayoutSpec
public class ListItemSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(ComponentContext ctx){
        Component.Builder<Text> c1 = Text.create(ctx)
                .text("Warning, please pay attention")
                .textSizeSp(40);
        Component.Builder<Text> c2 = Text.create(ctx)
                .text("Happy Fool day, it's a joke")
                .textSizeDip(22);

        // `Column` is like a <div> in HTML
        return Column.create(ctx)
                .paddingDip(YogaEdge.ALL, 16)
                .backgroundColor(Color.GRAY)
                .child(c1)
                .child(c2)
                .build();
    }
}
