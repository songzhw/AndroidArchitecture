package ca.six.biz1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PreStockActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_stock);

        Button btn = new Button(this);
        btn.setText("-> Stock");
        btn.setOnClickListener(this);
        setContentView(btn);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, StockActivity.class);
        it.putExtra("key", "23");
        startActivity(it);
    }
}
