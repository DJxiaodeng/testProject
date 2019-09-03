package org.wsc.session1.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.wsc.session1.entity.Office;
import org.wsc.session1.utils.DBUtils;

public class OfficeDAO {

	/**
	 * 查询所有的办公室
	 * @return
	 */
	public ArrayList<Office> findAll(){
		String sql = "select * from office";
		ResultSet rs = DBUtils.query(sql);
		ArrayList<Office> list = new ArrayList<>();
		try {
			Office office = null;
			while(rs.next()){
				office = new Office(rs.getString("officeID"),rs.getString("officeName"));
				list.add(office);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 根据OfficeID查询办公室
	 * @param officeID
	 * @return
	 */
	public Office findByOfficeId(String officeID){
		Office office = null;
		String sql = "select * from office where officeID=?";
		ResultSet rs = DBUtils.query(sql, officeID);
		try {
			if(rs.next()){
				office = new Office(rs.getString("officeID"),rs.getString("officeName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs != null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return office;
	}
}
