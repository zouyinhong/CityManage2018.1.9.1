package mycity.com.citymanage.activity;

import android.annotation.SuppressLint;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TextView;
import mycity.com.citymanage.R;
import mycity.com.citymanage.fragment.ContactFragment;
import mycity.com.citymanage.fragment.FirstFragment;
import mycity.com.citymanage.fragment.InforFragment;
import mycity.com.citymanage.fragment.WorkFragment;

@SuppressWarnings("deprecation")
public class MainActivityfirst extends TabActivity {
	private TabHost tabHost;


	private RelativeLayout layout1;
	private RelativeLayout layout2;
	private RelativeLayout layout3;
	private RelativeLayout layout4;
	private RelativeLayout layout5;

	private ImageView image1;
	private ImageView image2;
	private ImageView image3;
	private ImageView image4;
	private ImageView image5;

	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private TextView tv4;
	private TextView tv5;

	@SuppressWarnings("deprecation")
	@SuppressLint("ResourceAsColor")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.newactivityfirst);
		

		layout1 = (RelativeLayout) findViewById(R.id.layout1);
		layout2 = (RelativeLayout) findViewById(R.id.layout2);
		layout3 = (RelativeLayout) findViewById(R.id.layout3);
		layout4 = (RelativeLayout) findViewById(R.id.layout4);
		//layout5 = (RelativeLayout) findViewById(R.id.layout5);

		image1 = (ImageView) findViewById(R.id.image1);
		image2 = (ImageView) findViewById(R.id.image2);
		image3 = (ImageView) findViewById(R.id.image3);
		image4 = (ImageView) findViewById(R.id.image4);
		//image5 = (ImageView) findViewById(R.id.image5);

		tv1 = (TextView) findViewById(R.id.tv1);
		tv2 = (TextView) findViewById(R.id.tv2);
		tv3 = (TextView) findViewById(R.id.tv3);
		tv4 = (TextView) findViewById(R.id.tv4);
		//tv5 = (TextView) findViewById(R.id.tv5);

		tv1.setTextColor(this.getResources().getColor(R.color.colorPrimaryDark));
		tv2.setTextColor(this.getResources().getColor(R.color.greynew));
		tv3.setTextColor(this.getResources().getColor(R.color.greynew));
		tv4.setTextColor(this.getResources().getColor(R.color.greynew));
		//tv5.setTextColor(this.getResources().getColor(R.color.greynew));

		tabHost = this.getTabHost();
		TabHost.TabSpec spec;
		Intent intent;

		intent = new Intent().setClass(this, FirstFragment.class);
		spec = tabHost.newTabSpec("首页").setIndicator("首页").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, InforFragment.class);
		spec = tabHost.newTabSpec("消息").setIndicator("消息").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, WorkFragment.class);
		spec = tabHost.newTabSpec("工作").setIndicator("工作").setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, ContactFragment.class);
		spec = tabHost.newTabSpec("通讯录").setIndicator("通讯录").setContent(intent);
		tabHost.addTab(spec);

		/*intent = new Intent().setClass(this, MineActivity.class);
		spec = tabHost.newTabSpec("我的").setIndicator("我的").setContent(intent);
		tabHost.addTab(spec);*/

		tabHost.setCurrentTab(0); // TabHost最初加载的Activity的索引，0代表第一个

		/*
		 * RadioGroup radioGroup=(RadioGroup)
		 * this.findViewById(R.id.main_tab_group);
		 * radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		 * 
		 * @Override public void onCheckedChanged(RadioGroup group, int
		 * checkedId) { // TODO Auto-generated method stub
		 * 
		 * if(checkedId==R.id.main0) { //tabHost.setCurrentTabByTag("基础展示");
		 * tabHost.setCurrentTabByTag("首页"); } if(checkedId==R.id.main1) {
		 * //tabHost.setCurrentTabByTag("信息管理");
		 * tabHost.setCurrentTabByTag("信息采集"); } if(checkedId==R.id.main2) {
		 * tabHost.setCurrentTabByTag("社区论坛"); } if(checkedId==R.id.main3) {
		 * //tabHost.setCurrentTabByTag("任务上报");
		 * tabHost.setCurrentTabByTag("巡检"); }
		 * 
		 * if(checkedId==R.id.main4){ //tabHost.setCurrentTabByTag("任务列表");
		 * tabHost.setCurrentTabByTag("任务列表");
		 * 
		 * }
		 * 
		 * 
		 * } });
		 */

		layout1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tabHost.setCurrentTabByTag("首页");
				image1.setBackgroundResource(R.mipmap.u3200_selected);

				image2.setBackgroundResource(R.mipmap.u318);

				image3.setBackgroundResource(R.mipmap.u320);

				image4.setBackgroundResource(R.mipmap.u3180);
			//	image5.setBackgroundResource(R.drawable.xh6);

				tv1.setTextColor(v.getResources().getColor(R.color.colorPrimaryDark));
				tv2.setTextColor(v.getResources().getColor(R.color.greynew));
				tv3.setTextColor(v.getResources().getColor(R.color.greynew));
				tv4.setTextColor(v.getResources().getColor(R.color.greynew));
			//	tv5.setTextColor(v.getResources().getColor(R.color.greynew));

			}
		});

		layout2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tabHost.setCurrentTabByTag("消息");
				image1.setBackgroundResource(R.mipmap.u3160);

				image2.setBackgroundResource(R.mipmap.u322_selected);

				image3.setBackgroundResource(R.mipmap.u320);

				image4.setBackgroundResource(R.mipmap.u3180);

				tv1.setTextColor(v.getResources().getColor(R.color.greynew));
				tv2.setTextColor(v.getResources().getColor(R.color.colorPrimaryDark));
				tv3.setTextColor(v.getResources().getColor(R.color.greynew));
				tv4.setTextColor(v.getResources().getColor(R.color.greynew));
			//	tv5.setTextColor(v.getResources().getColor(R.color.greynew));
			}
		});
		layout3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tabHost.setCurrentTabByTag("工作");
				image1.setBackgroundResource(R.mipmap.u3160);

				image2.setBackgroundResource(R.mipmap.u318);

				image3.setBackgroundResource(R.mipmap.u324_selected);

				image4.setBackgroundResource(R.mipmap.u3180);

				tv1.setTextColor(v.getResources().getColor(R.color.greynew));
				tv2.setTextColor(v.getResources().getColor(R.color.greynew));
				tv3.setTextColor(v.getResources().getColor(R.color.colorPrimaryDark));
				tv4.setTextColor(v.getResources().getColor(R.color.greynew));
			//	tv5.setTextColor(v.getResources().getColor(R.color.greynew));

			}
		});
		layout4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tabHost.setCurrentTabByTag("通讯录");
				image1.setBackgroundResource(R.mipmap.u3160);

				image2.setBackgroundResource(R.mipmap.u318);

				image3.setBackgroundResource(R.mipmap.u320);

				image4.setBackgroundResource(R.mipmap.u3180_selected);

				tv1.setTextColor(v.getResources().getColor(R.color.greynew));
				tv2.setTextColor(v.getResources().getColor(R.color.greynew));
				tv3.setTextColor(v.getResources().getColor(R.color.greynew));
				tv4.setTextColor(v.getResources().getColor(R.color.colorPrimaryDark));
				//tv5.setTextColor(v.getResources().getColor(R.color.greynew));

			}
		});

		/*layout5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				tabHost.setCurrentTabByTag("我的");
				image1.setBackgroundResource(R.drawable.wuyegrey);

				image2.setBackgroundResource(R.drawable.sheshigrey);

				image3.setBackgroundResource(R.drawable.xinxigrey);

				image4.setBackgroundResource(R.drawable.xh5);
				image5.setBackgroundResource(R.drawable.xl6);

				tv1.setTextColor(v.getResources().getColor(R.color.greynew));
				tv2.setTextColor(v.getResources().getColor(R.color.greynew));
				tv3.setTextColor(v.getResources().getColor(R.color.greynew));
				tv4.setTextColor(v.getResources().getColor(R.color.greynew));
				tv5.setTextColor(v.getResources().getColor(R.color.blue));

			}
		});
*/
	}

	/*
	 * @Override public void onBackPressed(){ super.onBackPressed(); Intent
	 * intent= new Intent(Intent.ACTION_MAIN);
	 * intent.addCategory(Intent.CATEGORY_HOME); startActivity(intent);
	 * 
	 * }
	 */
}
