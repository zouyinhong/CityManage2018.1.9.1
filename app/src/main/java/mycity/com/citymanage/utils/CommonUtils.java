package mycity.com.citymanage.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;

import java.io.File;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *class CommonUtils
 *@author GuoZhuShu
 * create at 2016/5/24 15:36
 **/
public class CommonUtils {

	/**
	 * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
	 *
	 * @param input
	 * @return boolean
	 */
	public static boolean isNullOrEmpty(String input) {
		if (input == null || "".equals(input))
			return true;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
				return false;
			}
		}
		return true;
	}

	// 获取系统时间
	public static String getSystime() {
		String systime;
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		//SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); // 签名是用到的时间戳时间只能纯数字
		Date date = c.getTime();
		systime = df.format(date);
		return systime;
	}

	// 获取时间戳
	public static String getTimestamp() {
		String systime;
		Calendar c = Calendar.getInstance();
		//SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); // 签名是用到的时间戳时间只能纯数字
		Date date = c.getTime();
		systime = df.format(date);
		return systime;
	}

	private static char sHexDigits[] = { '0', '1', '2', '3', '4', '5', '6',
			'7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static String hexString(byte[] source) {
		if (source == null || source.length <= 0) {
			return "";
		}

		final int size = source.length;
		final char str[] = new char[size * 2];
		int index = 0;
		byte b;
		for (int i = 0; i < size; i++) {
			b = source[i];
			str[index++] = sHexDigits[b >>> 4 & 0xf];
			str[index++] = sHexDigits[b & 0xf];
		}
		return new String(str);
	}

	/**
	 * 获取货币类型格式
	 *
	 * @return
	 */
	public static NumberFormat getMoneyFormt() {
		NumberFormat currency = NumberFormat.getNumberInstance();
		// currency.setMaximumIntegerDigits(6); // 设置数的整数部分所允许的最大位数 显示返回的数据上限不设置
		currency.setMinimumFractionDigits(2); // 设置数的小数部分所允许的最小位数(如果不足后面补0)
		currency.setMaximumFractionDigits(2); // 设置数的小数部分所允许的最大位数(如果超过会四舍五入)
		return currency;
	}


	/**
	 * 检测sdcard是否可用
	 * 
	 * @return true为可用，否则为不可用
	 */
	public static boolean sdCardIsAvailable() {
		String status = Environment.getExternalStorageState();
		if (!status.equals(Environment.MEDIA_MOUNTED))
			return false;
		return true;
	}

	/**
	 * Checks if there is enough Space on SDCard
	 * 
	 * @param updateSize
	 *            Size to Check
	 * @return True if the Update will fit on SDCard, false if not enough space on SDCard Will also return false, if the SDCard is
	 *         not mounted as read/write
	 */
	public static boolean enoughSpaceOnSdCard(long updateSize) {
		String status = Environment.getExternalStorageState();
		if (!status.equals(Environment.MEDIA_MOUNTED))
			return false;
		return (updateSize < getRealSizeOnSdcard());
	}

	/**
	 * get the space is left over on sdcard
	 */
	public static long getRealSizeOnSdcard() {
		File path = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long availableBlocks = stat.getAvailableBlocks();
		return availableBlocks * blockSize;
	}

	/**
	 * Checks if there is enough Space on phone self
	 * 
	 */
	public static boolean enoughSpaceOnPhone(long updateSize) {
		return getRealSizeOnPhone() > updateSize;
	}

	/**
	 * get the space is left over on phone self
	 */
	public static long getRealSizeOnPhone() {
		File path = Environment.getDataDirectory();
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long availableBlocks = stat.getAvailableBlocks();
		long realSize = blockSize * availableBlocks;
		return realSize;
	}

	/**
	 * 判断sim是否存在
	 * @return true 存在 flase 不存在
	 */
	public static boolean isSimExist(Context context){
		TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		return manager.getSimState() == TelephonyManager.SIM_STATE_ABSENT ? false : true;
	}

	/**
	 * 获取手机唯一标识 imei码 需要权限 <uses-permission
	 * android:name="android.permission.READ_PHONE_STATE"/>
	 *
	 * @return
	 */
	public static String getDeviceId(Context context) {
		TelephonyManager telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		return telephonyManager.getDeviceId();
	}


}
