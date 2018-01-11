package mycity.com.citymanage.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import mycity.com.citymanage.R;

/**    一键采集模块
 * Created by Administrator on 2017/12/25.
 */

public class Acquistion extends Activity {
    private ImageView img_return;
    private Spinner sp_hangye,sp_fenlei;
    private ImageView img_location,img_camera,img_add;
    private EditText et_context;
    private LinearLayout layout_caozuo;
    private Button btn_commit;
    private String arrhangye[] = new String[] { "执法", "道桥", "园林", "环卫", "市容"};
    private String arrfenlei[] = new String[] { "占道经营", "店外经营", "乱贴乱画", "其他"};
    private boolean  addclickflag=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_acquistion);
        img_return=(ImageView) findViewById(R.id.img_return);
        img_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        sp_hangye=(Spinner)findViewById(R.id.sp_hangye);
        sp_fenlei=(Spinner)findViewById(R.id.sp_fenlei);
        img_location=(ImageView) findViewById(R.id.img_location);
        img_camera=(ImageView) findViewById(R.id.img_camera);
        img_add=(ImageView) findViewById(R.id.img_add);
        et_context=(EditText) findViewById(R.id.et_content);
        layout_caozuo=(LinearLayout) findViewById(R.id.layout_caozuo);
        btn_commit=(Button) findViewById(R.id.btn_commit);
        img_location.setOnClickListener(new LocationOnClick());
        img_add.setOnClickListener(new AddOnClick());
        layout_caozuo.setVisibility(View.GONE);

        // adpater对象
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrhangye);
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrfenlei);
        sp_hangye.setAdapter(arrayAdapter);
        sp_fenlei.setAdapter(arrayAdapter1);
        sp_hangye.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                // String content = arr[position];

                Spinner spinner = (Spinner) parent;

                Toast.makeText(getApplicationContext(),
                         spinner.getItemAtPosition(position)+"",
                        Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "没有改变的处理",
                        Toast.LENGTH_LONG).show();

            }
        });

        sp_fenlei.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                // String content = arr[position];

                Spinner spinner = (Spinner) parent;

                Toast.makeText(getApplicationContext(),
                        "" + spinner.getItemAtPosition(position),
                        Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "没有改变的处理",
                        Toast.LENGTH_LONG).show();

            }
        });

    }

    private class LocationOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intentlocation=new Intent();
            intentlocation.setClass(Acquistion.this,BaiduMapLocation.class);
            startActivity(intentlocation);
        }
    }

    private class AddOnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(addclickflag==false){
                layout_caozuo.setVisibility(View.VISIBLE);
                addclickflag=true;
            }
          else  if(addclickflag==true){
                layout_caozuo.setVisibility(View.GONE);
                addclickflag=false;
            }

        }
    }
}

