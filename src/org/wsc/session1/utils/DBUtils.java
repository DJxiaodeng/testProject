package org.wsc.session1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.wsc.session1.entity.User;

public class DBUtils {

	/** ������·�� **/
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	/** URL **/
	private static final  String URL ="jdbc:mysql://127.0.0.1:3306/session1";
	/** �˺� **/
	private static final  String USER = "root";
	/** ����**/
	private static final  String PASSWORD = "root";
	
	static{
		try {			
			//��������
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ���ݿ�����
	 * @return
	 */
	public static Connection getConn(){
		try {
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * ��װͨ�õ��� ɾ ��
	 * @param sql
	 * @param param
	 * @return
	 */
	public static boolean exeUpdate(String sql,Object ...param){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i + 1, param[i]);
			}
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				if(ps != null){
					ps.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * ��װͨ�ò�ѯ����
	 * @param sql
	 * @param call
	 * @param param
	 * @return
	 */
	public static ResultSet query(String sql,Object... param){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < param.length; i++) {
				ps.setObject(i + 1, param[i]);
			}
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
		}
		return null;
	}
}
