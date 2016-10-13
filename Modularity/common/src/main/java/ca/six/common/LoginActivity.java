package ca.six.common;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName;
    private EditText etPwd;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = (EditText) findViewById(R.id.etName);
        etPwd = (EditText) findViewById(R.id.etPwd);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String pwd = etPwd.getText().toString();
        String name = etName.getText().toString();
        if("123".equals(pwd) && "szw".equals(name)) {
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
            Session.getInstance().user = new User("szw", true);
        } else {
            Toast.makeText(this, "Error name/pwd", Toast.LENGTH_SHORT).show();
        }
    }
}
