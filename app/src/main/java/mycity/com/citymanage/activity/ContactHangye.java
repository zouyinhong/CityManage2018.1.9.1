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

public class ContactHangye extends Activity {
    private ListView lv_view;
    private QuickView quick_bar;
    private TextView tv_show;
    private Handler handler=new Handler();
    private ArrayList<Friend> friends=new ArrayList<Friend>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_hangye);
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
        friends.add(new Friend("李伟"));
        friends.add(new Friend("张三"));
        friends.add(new Friend("阿三"));
        friends.add(new Friend("阿四"));
        friends.add(new Friend("段誉"));
        friends.add(new Friend("段正淳"));
        friends.add(new Friend("张三丰"));
        friends.add(new Friend("陈坤"));
        friends.add(new Friend("林俊杰1"));
        friends.add(new Friend("陈坤2"));
        friends.add(new Friend("王二a"));
        friends.add(new Friend("林俊杰a"));
        friends.add(new Friend("张四"));
        friends.add(new Friend("林俊杰"));
        friends.add(new Friend("王二"));
        friends.add(new Friend("王二b"));
        friends.add(new Friend("赵四"));
        friends.add(new Friend("杨坤"));
        friends.add(new Friend("赵子龙"));
        friends.add(new Friend("杨坤1"));
        friends.add(new Friend("李伟1"));
        friends.add(new Friend("宋江"));
        friends.add(new Friend("宋江1"));
        friends.add(new Friend("李伟3"));
    }
}
