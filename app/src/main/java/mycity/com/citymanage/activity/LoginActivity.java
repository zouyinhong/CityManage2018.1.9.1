package mycity.com.citymanage.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import mycity.com.citymanage.R;

public class LoginActivity extends AppCompatActivity {
  private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        btn_login=(Button) findViewById(R.id.login_btn);
        btn_login.setOnClickListener(new LoginOnClick());

    }

    private class LoginOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent();
            intent.setClass(LoginActivity.this,MainActivityfirst.class);
            startActivity(intent);
        }
    }
}
