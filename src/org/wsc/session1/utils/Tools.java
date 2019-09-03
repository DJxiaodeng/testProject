package org.wsc.session1.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class Tools {

	/**
	 * 获取年龄的方法
	 * @param date
	 * @return
	 */
	public static int getAge(Date date){
		return new Date(System.currentTimeMillis()).getYear() - date.getYear();
	} 
	
	/**
	 * 根据提供的时间戳获取对应的日期
	 * @param t
	 * @return
	 */
	public static String getDate(Timestamp t){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(new java.util.Date(t.getTime()));
	}
	
	/**
	 * 根据提供的时间戳获取对应的时间
	 * @param t
	 * @return
	 */
	public static String getTime(Timestamp t){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(new java.util.Date(t.getTime()));
	}
	
	/**
	 * 用于格式化总登录时长的方法
	 * @param total
	 * @return
	 */
	public static String getTotalSpent(long total){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(new java.util.Date(total));
	}
}
