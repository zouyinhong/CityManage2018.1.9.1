package mycity.com.citymanage.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.sax.StartElementListener;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import mycity.com.citymanage.R;

/**
 * @description：
 * @author：shilin
 * @date:2017-8-10下午4:31:16
 */
public class LeftPopupWindow extends PopupWindow{
	private View popupWindowView;
	private PopupWindow popupWindow;
	private Context mContext;
	private int from;
	
	public LeftPopupWindow(Context context , int from) {
		super();
		this.from = from;
		this.mContext = context;
		this.popupWindowView = ((Activity) context).getLayoutInflater().inflate(R.layout.leftslidebar, null);
	
	}
	
	public void initPopupWindow(int from){
		View popupWindowView = ((Activity) mContext).getLayoutInflater().inflate(R.layout.leftslidebar, null);


		if(SlideLocation.BOTTOM.ordinal() == from){
			popupWindow = new PopupWindow(popupWindowView, LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, true);
		}else{
			popupWindow = new PopupWindow(popupWindowView, LayoutParams.WRAP_CONTENT, LayoutParams.FILL_PARENT, true);
		}

		if(SlideLocation.LEFT.ordinal() == from){
			popupWindow.setAnimationStyle(R.style.AnimationLeftFade);
		}

		ColorDrawable dw = new ColorDrawable(0xffffffff);
		popupWindow.setBackgroundDrawable(dw);
		
		WindowManager wm = ((Activity) mContext).getWindowManager();
		int height = wm.getDefaultDisplay().getHeight();
		int width = wm.getDefaultDisplay().getWidth();

		popupWindow.setWidth(width/2); 


		popupWindow.setHeight(height);
		if(SlideLocation.LEFT.ordinal() == from){
			popupWindow.showAtLocation(((Activity) mContext).getLayoutInflater().inflate(R.layout.activity_main, null), Gravity.LEFT, 0, 500);
		}

		backgroundAlpha(0.5f);

		popupWindow.setOnDismissListener(new popupDismissListener());
		
		popupWindowView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				/*if( popupWindow!=null && popupWindow.isShowing()){
					popupWindow.dismiss();
					popupWindow=null;
				}*/
				return false;
			}
		});
		

		/**
		 * 登陆角色
		 */
	/*	TextView role = (TextView) popupWindowView.findViewById(R.id.role);
		role.setText(MyZZApplication.USERINFO.getName());*/
		/**
		 * 退出登陆
		 */
	/*	ImageButton loginout = (ImageButton) popupWindowView.findViewById(R.id.loginout);
		loginout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext, LoginActivity.class);
				intent.setFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
				mContext.startActivity(intent);
				popupWindow.dismiss();
				MyZZApplication.logout();
			}
		});*/
		/**
		 * 导航栏-网格签到
		 */
		LinearLayout qiandao = (LinearLayout) popupWindowView.findViewById(R.id.layout_qiandao);
		qiandao.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext, LeftQianDao.class);
				mContext.startActivity(intent);
				popupWindow.dismiss();
			}
		});
		/**
		 * 导航栏-个人日志
		 */
        LinearLayout rizhi = (LinearLayout) popupWindowView.findViewById(R.id.layout_rizhi);

		rizhi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext, LeftRiZhi.class);
				intent.putExtra("mainalarm", "");
				mContext.startActivity(intent);
				popupWindow.dismiss();
			}
		});
		
		
		/**
		 * 导航栏-个人信息
		 */
        LinearLayout xinxi = (LinearLayout) popupWindowView.findViewById(R.id.layout_xinxi);
		xinxi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext, LeftInfor.class);
	
				mContext.startActivity(intent);
				popupWindow.dismiss();
			}
		});
		/**
		 * 导航栏-个人信誉
		 */
        LinearLayout xinyu = (LinearLayout) popupWindowView.findViewById(R.id.layout_xinyu);
		xinyu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext, LeftXinyu.class);
				mContext.startActivity(intent);
				popupWindow.dismiss();
			}
		});
		/**
		 * 导航栏-设置
		 */
        LinearLayout shezhi = (LinearLayout) popupWindowView.findViewById(R.id.layout_shezhi);
		shezhi.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext, LeftSheZhi.class);
				mContext.startActivity(intent);
				popupWindow.dismiss();
			}
		});
		


	} 


class popupDismissListener implements OnDismissListener{

	@Override
	public void onDismiss() {
		backgroundAlpha(1f);
	}
	
} 
/**
 * 设置透明度
 * @param bgAlpha
 */
public void backgroundAlpha(float bgAlpha)
{
	WindowManager.LayoutParams lp = ((Activity) mContext).getWindow().getAttributes();
	lp.alpha = bgAlpha; //0.0-1.0
    ((Activity) mContext).getWindow().setAttributes(lp);
}   	

/**
 * 打开方向
 *
 */   
public enum SlideLocation {

	LEFT,
	RIGHT,
	TOP,
	BOTTOM;
	
}		
	
}
