package mycity.com.citymanage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Window;

import mycity.com.citymanage.R;

/**
 * @Title: BaseFragmentActivity.java
 *
 * @author :GZS
 * @date 2016-05-23 下午5:14:40
 * @version : V1.0
 * @Description:
 */
public class BaseFragmentActivity extends FragmentActivity {
	protected BaseApplication mApplication;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		mApplication=(BaseApplication) getApplication();
		AppManager.getAppManager().addActivity(this);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
	}

	/** 含有Bundle通过Class跳转界面
	 * NO finish();
	 * **/
	public void dropToNextActivity(Class<?> cls) {
		startActivity(new Intent(this, cls));
		// 使用动画可以避免在vivo手机上出现的地图bug
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}

	/** 含有Bundle通过Class跳转界面
	 * NO finish();
	 * **/
	public void dropToNextActivity(Intent intent) {
		startActivity(intent);
		// 使用动画可以避免在vivo手机上出现的地图bug
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}


	/** 含有Bundle通过Class跳转界面 
	 * NO finish();
	 * **/
	public void dropToNextActivity(Class<?> cls, Bundle bundle) {
		Intent intent = new Intent();
		intent.setClass(this, cls);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivity(intent);
		//overridePendingTransition(R.anim.zoom_out_enter, R.anim.zoom_out_exit);
		overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
	}
	
	/** 含有Bundle通过Action跳转界面 **/
	protected void startActivityForRet(Class<?> cls, Bundle bundle, int requestCode) {
		Intent intent = new Intent();
		intent.setClass(this, cls);
		if (bundle != null) {
			intent.putExtras(bundle);
		}
		startActivityForResult(intent, requestCode);
		overridePendingTransition(R.anim.push_left_in,
				R.anim.push_left_out);
	}
	
	
	/** 通过Action跳转界面 **/
	protected void startActivityForRet(Intent intent, int requestCode) {
		startActivityForResult(intent, requestCode);
		overridePendingTransition(R.anim.push_left_in,
				R.anim.push_left_out);
	}
	
	public void finish()
	{
		super.finish();
		overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
	}
	
	public void defaultFinish()
	{
		super.finish();
	}


}
