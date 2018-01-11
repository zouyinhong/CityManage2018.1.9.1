package mycity.com.citymanage.fragment;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;


import mycity.com.citymanage.R;
import mycity.com.citymanage.activity.ContactHangye;
import mycity.com.citymanage.activity.ContactXingzheng;



public class ContactFragment extends TabActivity {

    private TabHost tabHost;
    private RelativeLayout layout1;
    private RelativeLayout layout2;
    private ImageView image1;
    private ImageView image2;
    private TextView tv1;
    private TextView tv2;



        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_contactmain);
            layout1 = (RelativeLayout)findViewById(R.id.layout1);
            layout2 = (RelativeLayout) findViewById(R.id.layout2);
            image1 = (ImageView)findViewById(R.id.image1);
            image2 = (ImageView) findViewById(R.id.image2);
            tv1 = (TextView) findViewById(R.id.tv1);
            tv2 = (TextView) findViewById(R.id.tv2);

            tv1.setTextColor(this.getResources().getColor(R.color.black));
            tv2.setTextColor(this.getResources().getColor(R.color.black));



            tabHost = this.getTabHost();
            TabHost.TabSpec spec;
            Intent intent;

            intent = new Intent().setClass(ContactFragment.this, ContactXingzheng.class);
            spec = tabHost.newTabSpec("行政层级").setIndicator("行政层级").setContent(intent);
            tabHost.addTab(spec);

            intent = new Intent().setClass(ContactFragment.this, ContactHangye.class);
            spec = tabHost.newTabSpec("行业分类").setIndicator("行业分类").setContent(intent);
            tabHost.addTab(spec);

            tabHost.setCurrentTab(0); // TabHost最初加载的Activity的索引，0代表第一个

            layout1.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    tabHost.setCurrentTabByTag("行政层级");


                }
            });

            layout2.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    tabHost.setCurrentTabByTag("行业分类");

                }
            });

        }









    }
