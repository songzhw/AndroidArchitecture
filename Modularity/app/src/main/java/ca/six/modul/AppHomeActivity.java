package ca.six.modul;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ca.six.common.L;
import ca.six.common.LoginActivity;
import ca.six.common.Session;
import ca.six.common.utils.JumpUtils;

public class AppHomeActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_home);

        findViewById(R.id.tvHomeStock).setOnClickListener(this);
        findViewById(R.id.tvHomeOption).setOnClickListener(this);
        L.d("AppHomeActivity onCreate()");
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.tvHomeStock:
                if(Session.getInstance().user == null){
                    Intent it = new Intent(this, LoginActivity.class);
                    startActivityForResult(it, 11);
                } else {
                    jump2Stock();
                }
                break;
            case R.id.tvHomeOption:
                jump2Option();
        }
    }

    private void jump2Stock(){
//        Intent it = new Intent(this, StockActivity.class);
//        startActivity(it);
        JumpUtils.jump2(this, "ca.six.biz1","StockActivity");
    }

    private void jump2Option(){
        JumpUtils.jumpImplicit2(this, "ca.six.biz2.OptionActivity");
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


