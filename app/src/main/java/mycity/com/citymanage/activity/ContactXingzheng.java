package mycity.com.citymanage.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import mycity.com.citymanage.R;
import mycity.com.citymanage.adapter.MyAdapter;
import mycity.com.citymanage.bean.Friend;

/**
 * Created by Administrator on 2017/12/29.
 */

public class ContactXingzheng extends Activity {
    private ListView lv_view;
    private QuickView quick_bar;
    private TextView tv_show;
    private Handler handler=new Handler();
    private ArrayList<Friend> friends=new ArrayList<Friend>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_xingzheng);
        lv_view = (ListView) findViewById(R.id.lv_view);

        quick_bar = (QuickView)findViewById(R.id.quick_bar);
        tv_show = (TextView) findViewById(R.id.tv_show);
        /**初始化控件*/

        /**初始化数据*/

        prepareData();
        Collections.sort(friends);
        lv_view.setAdapter(new MyAdapter(friends));
        /**数据监听事件*/
        quick_bar.setOnTextChangeListener(new QuickView.OnTextChangeListener() {
            @Override
            public void textChange(String text) {
                for (int i = 0; i < friends.size(); ++i) {
                    String firstChar= friends.get(i).pinyin.charAt(0)+"";
                    if(firstChar.equalsIgnoreCase(text)){
                        lv_view.setSelection(i);
                        break;
                    }

                }
                showText(text);
            }
        });
    }

    private void showText(String text) {
        handler.removeCallbacksAndMessages(null);
        tv_show.setText(text);
        tv_show.setVisibility(View.VISIBLE);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv_show.setVisibility(View.GONE);
            }
        },2000);
    }



    /**
     * 准备数据
     */
    private void prepareData() {
        // 虚拟数据
        friends.add(new Friend("局领导"));
        friends.add(new Friend("市局机关"));
        friends.add(new Friend("局属单位"));
        friends.add(new Friend("南岗区"));
        friends.add(new Friend("道外区"));
        friends.add(new Friend("道里区"));
        friends.add(new Friend("香坊区"));
        friends.add(new Friend("平房区"));
        friends.add(new Friend("松北区"));

    }
}
