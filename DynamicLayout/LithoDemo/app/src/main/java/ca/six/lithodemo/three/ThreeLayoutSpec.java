package ca.six.lithodemo.three;

import android.graphics.Color;

import com.facebook.litho.Column;
import com.facebook.litho.Component;
import com.facebook.litho.ComponentContext;
import com.facebook.litho.ComponentLayout;
import com.facebook.litho.annotations.LayoutSpec;
import com.facebook.litho.annotations.OnCreateLayout;
import com.facebook.litho.annotations.Prop;
import com.facebook.litho.annotations.ResType;
import com.facebook.litho.widget.Text;
import com.facebook.yoga.YogaEdge;

@LayoutSpec
public class ThreeLayoutSpec {

    @OnCreateLayout
    static ComponentLayout onCreateLayout(ComponentContext ctx,
          @Prop int color, @Prop String title, @Prop String subtitle,
          @Prop(optional = true, resType = ResType.DIMEN_OFFSET) int shadowRadius){
        Component.Builder<Text> c1 = Text.create(ctx)
                .text(title)
                .textSizeSp(40);
        Component.Builder<Text> c2 = Text.create(ctx)
                .text(subtitle)
                .textSizeDip(22);

        // `Column` is like a <div> in HTML
        return Column.create(ctx)
                .paddingDip(YogaEdge.ALL, 16)
                .backgroundColor(color)
                .child(c1)
                .child(c2)
                .build();
    }
}
