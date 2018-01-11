package mycity.com.citymanage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import mycity.com.citymanage.R;

/**
 * Created by Administrator on 2017/12/28.
 */

public class LeftRiZhi extends Activity {
    private ImageView btn_return;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.left_rizhi);
        btn_return=(ImageView) findViewById(R.id.img_return);
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
