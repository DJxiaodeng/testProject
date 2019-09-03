package org.wsc.session1.utils;

import java.security.MessageDigest;

/**
 * MD5���ܲ��
 * @author mrchai
 *
 */
public class MD5Utils {

	public static String encoder(String source){
		String des = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] result = md.digest(source.getBytes());
			StringBuilder buf = new StringBuilder();
			for (int i=0;i<result.length;i++) {
				byte b = result[i];
				buf.append(String.format("%02X", b));
			}
			des = buf.toString().toLowerCase();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("����ʧ��");
		}
		return des;
	}

	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(MD5Utils.encoder("2222"));
	}
}
