package mycity.com.citymanage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

import mycity.com.citymanage.R;

/**
 * Created by Administrator on 2017/12/27.
 */

public class LeftQianDao extends Activity{
    private TabHost tabhost;
    private ImageView btn_return;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.left_tabhost);

        btn_return=(ImageView) findViewById(R.id.img_return);
        btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //得到TabHost对象实例
        tabhost =(TabHost) findViewById(R.id.mytab);
        //调用 TabHost.setup()
        tabhost.setup();
        //创建Tab标签
        tabhost.addTab(tabhost.newTabSpec("one").setIndicator("实时签到").setContent(R.id.widget_layout1));
        tabhost.addTab(tabhost.newTabSpec("two").setIndicator("签到查看").setContent(R.id.widget_layout2));
        for(int i=0;i<tabhost.getTabWidget().getChildCount();i++){
            View view = tabhost.getTabWidget().getChildAt(i);

            if (tabhost.getCurrentTab() == 0) {//选中
                view.setBackgroundDrawable(getResources().getDrawable(R.mipmap.title_bg));//选中后的背景

            } else {//不选中
                view.setBackgroundDrawable(getResources().getDrawable(R.mipmap.title_back));//非选择的背景

            }
        }


    }
}
