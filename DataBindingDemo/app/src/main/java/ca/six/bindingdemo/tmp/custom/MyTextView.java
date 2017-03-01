package ca.six.bindingdemo.tmp.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by songzhw on 2017-02-28
 */

public class MyTextView extends TextView implements View.OnClickListener {
    private ICustomListener listener;

    public MyTextView(Context context) {
        super(context);
        init(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        this.setOnClickListener(this);
    }

    public void setListener(ICustomListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        System.out.println("szw CustomView click 01");
        if(listener != null){
            System.out.println("szw CustomView click 02");
            listener.onChange(v);
        }
    }
}
