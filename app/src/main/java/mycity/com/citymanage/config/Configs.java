package mycity.com.citymanage.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import mycity.com.citymanage.log.DebugLog;

/**
 * @Title: Configs.java
 *
 * @author
 * @date 2016-02-23 下午7:14:40
 * @version : V1.0
 * @Description: 放置配置相关的常量
 */
public class Configs {
	// 秒 为单位
	public static int Content_ListCacheTime = 5 * 60; // 5分钟
	public static int Content_ContentCacheTime = 60 * 24 * 3 * 60; // 3天
	public static int Content_InitDataCacheTime = 60 * 24 * 15 * 60; // 15天
	public static int Content_DefaultCacheTime = 60 * 24 * 1 * 60; // 1天

	// 银联支付环境配置：// 生产 传'0'，测试传1
	public static String umspaycfg = "0";

	public static String appSignKey = "request_system_tag";
	public static String appSignValue = "2";
	
	//验证码时间 单位秒
	public static final int CODE_TIME = 60 * 1000;
	
	//计时器名字
	public static String RegTime = "regtime";
	public static String RestPwdTime = "restpwdtime";
	
	// 配置文件key
	public static String UID = "uid";// 用户名
	
	private final static String APP_CONFIG = "config";
	public final static String CONF_COOKIE = "cookie";
	public final static String LOGIN_INFO = "loginInfo";
	public final static String UMENG_SHARE = "com.umeng.share";
	
	private Context mContext;
	
	private static Configs appConfig;
	
	private Configs(){
		
	}
	
	public static Configs getAppConfig(Context context)
	{
		if(appConfig == null){
			appConfig = new Configs();
			appConfig.mContext = context;
		}
		return appConfig;
	}
	
	/**
	 * 获取Preference设置
	 */
	public static SharedPreferences getSharedPreferences(Context context)
	{
		return PreferenceManager.getDefaultSharedPreferences(context);
	}
	
	public String getCookie(){
		return get(CONF_COOKIE);
	}
	
	public void setCookie(String value){
		set(CONF_COOKIE, value);
	}
	
	/**
	 * 清除保存的缓存
	 */
	public void cleanCookie()
	{
		remove(CONF_COOKIE);
	}
	
	public String get(String key)
	{
		Properties props = get();
		return (props!=null)?props.getProperty(key):null;
	}
	
	public Properties get() {
		FileInputStream fis = null;
		Properties props = new Properties();
		try{
			//读取files目录下的config
			//fis = activity.openFileInput(APP_CONFIG);
			
			//读取app_config目录下的config
			File dirConf = mContext.getDir(APP_CONFIG, Context.MODE_PRIVATE);
			fis = new FileInputStream(dirConf.getPath() + File.separator + APP_CONFIG);
			
			props.load(fis);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				fis.close();
			} catch (Exception e) {}
		}
		return props;
	}
	
	private void setProps(Properties p) {
		FileOutputStream fos = null;
		try{
			//把config建在files目录下
			//fos = activity.openFileOutput(APP_CONFIG, Context.MODE_PRIVATE);
			
			//把config建在(自定义)app_config的目录下
			File dirConf = mContext.getDir(APP_CONFIG, Context.MODE_PRIVATE);
			File conf = new File(dirConf, APP_CONFIG);
			
			//test
			DebugLog.d("Propetry路径：" + conf.getAbsolutePath());
			fos = new FileOutputStream(conf);
			
			p.store(fos, null);
			fos.flush();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				fos.close();
			} catch (Exception e) {}
		}
	}

	public void set(Properties ps)
	{
		Properties props = get();
		props.putAll(ps);
		setProps(props);
	}
	
	public void set(String key, String value)
	{
		Properties props = get();
		props.setProperty(key, value);
		setProps(props);
	}
	
	public void remove(String...key)
	{
		Properties props = get();
		for(String k : key)
			props.remove(k);
		setProps(props);
	}
}
