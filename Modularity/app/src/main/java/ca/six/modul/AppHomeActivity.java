package ca.six.modul;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import ca.six.common.LoginActivity;
import ca.six.common.Session;
import ca.six.common.utils.JumpUtils;

public class AppHomeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);

        findViewById(R.id.tvHomeStock).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.tvHomeStock:
                if(Session.getInstance().user == null){
                    Intent it = new Intent(this, LoginActivity.class);
                    startActivityForResult(it, 11);
                }
                break;
        }
    }

    private void jump2Stock(){
//        Intent it = new Intent(this, StockActivity.class);
//        startActivity(it);
        JumpUtils.jump2(this, "ca.six.biz1","StockActivity");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            switch(requestCode){
                case 11:
                    jump2Stock();
                    break;
            }
        }
    }
}


