package org.wsc.session1.utils;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class Tools {

	/**
	 * ��ȡ����ķ���
	 * @param date
	 * @return
	 */
	public static int getAge(Date date){
		return new Date(System.currentTimeMillis()).getYear() - date.getYear();
	} 
	
	/**
	 * �����ṩ��ʱ�����ȡ��Ӧ������
	 * @param t
	 * @return
	 */
	public static String getDate(Timestamp t){
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		return sdf.format(new java.util.Date(t.getTime()));
	}
	
	/**
	 * �����ṩ��ʱ�����ȡ��Ӧ��ʱ��
	 * @param t
	 * @return
	 */
	public static String getTime(Timestamp t){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		return sdf.format(new java.util.Date(t.getTime()));
	}
	
	/**
	 * ���ڸ�ʽ���ܵ�¼ʱ���ķ���
	 * @param total
	 * @return
	 */
	public static String getTotalSpent(long total){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(new java.util.Date(total));
	}
}
