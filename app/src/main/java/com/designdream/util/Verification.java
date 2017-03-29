package com.designdream.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证类
 * @author leianjun
 * @time 2017/3/17
 * @version 1.0
 */
public class Verification {
	
	/* 手机号验证
	* 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
	* 联通：130、131、132、152、155、156、185、186
	* 电信：133、153、180、189
	* 第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
	*/
	public static boolean isPhoneNumberValid(String phoneNumber) {

	   boolean isValid = false;
	   String expression = "((^(13|15|18)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";

	   CharSequence inputStr = phoneNumber;
	   Pattern pattern = Pattern.compile(expression);
	   Matcher matcher = pattern.matcher(inputStr);
	   // 如果输入的手机号格式正确，返回true
	   if (matcher.matches() ) {
		   isValid = true;
	   }
	   return isValid;
	}
	/**
	 * 判断网路是否可以用
	 * @return
	 */
	public static boolean checkNetwork(Context context) {

		if(isNetworkConnected(context)==true){
			if(isWifiConnected(context)==true || isMobileConnected(context)==true){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	/**
	 * 判断是否有网络连接
	 *
	 * @param context
	 * @return
	 */
	public static boolean isNetworkConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager
					.getActiveNetworkInfo();
			if (mNetworkInfo != null) {
				return mNetworkInfo.isAvailable();
			}
		}
		return false;
	}

	/**
	 * 判断wifi 是否可用
	 *
	 * @param context
	 * @return
	 */
	public static boolean isWifiConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mWiFiNetworkInfo = mConnectivityManager
					.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
			if (mWiFiNetworkInfo != null) {
				return mWiFiNetworkInfo.isAvailable();
			}
		}
		return false;
	}

	/**
	 * 判断手机网络是否可用
	 *
	 * @param context
	 * @return
	 */
	public static boolean isMobileConnected(Context context) {
		if (context != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mMobileNetworkInfo = mConnectivityManager
					.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
			if (mMobileNetworkInfo != null) {
				return mMobileNetworkInfo.isAvailable();
			}
		}
		return false;
	}
}
