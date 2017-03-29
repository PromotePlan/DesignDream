package com.designdream.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间类
 * @author leianjun
 * @time 2017/3/17
 * @version 1.0
 */
public class TimeUtil {

	public static String getCurrentDate() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(new Date());
		
		return date;
	}
	
	public static String getCurrentTime() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String currentTime = sdf.format(new Date());
		
		return currentTime;
	}
	
	public static  String getCurrentDateAndTime() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(new Date());
		
		return currentTime;
	}
	
	public static  String getCurrentDteAndTme() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String currentTimeStr = sdf.format(new Date());
		
		return currentTimeStr;
	}
}
