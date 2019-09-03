package org.wsc.session1.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.wsc.session1.entity.Loginrecord;
import org.wsc.session1.utils.DBUtils;

public class LoginrecordDAO {

	/**
	 * 登录记录添加
	 * @param record
	 * @return
	 */
	public boolean insert(Loginrecord record){
		String sql = "insert into loginrecord value(?,?,?,?)";
		return DBUtils.exeUpdate(sql, 
				record.getEmail(),
				record.getLoginTime(),
				record.getLogoutTime(),
				record.getUnsuccessfulLoginReason());
	}
	
	/**
	 * 查询指定邮箱的登录记录
	 * @param email
	 * @return
	 */
	public ArrayList<Loginrecord> findAllByEmail(String email){
		String sql = "select * from loginrecord where email=?";
		ResultSet rs = DBUtils.query(sql,email);
		ArrayList<Loginrecord> list = new ArrayList<>();
		Loginrecord record = null;
		try {
			while(rs.next()){
				record = new Loginrecord();
				record.setEmail(rs.getString("email"));
				record.setLoginTime(rs.getTimestamp("logintime"));
				record.setLogoutTime(rs.getTimestamp("logouttime"));
				record.setUnsuccessfulLoginReason(rs.getString("unsuccessfulLogoutReason"));
				list.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
