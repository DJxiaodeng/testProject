package org.wsc.session1.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.wsc.session1.entity.User;
import org.wsc.session1.utils.DBUtils;

public class UserDAO {


	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean insert(User user){
		String sql = "insert into user(email,firstName,lastName,password,birthdate,officeID,role) values(?,?,?,?,?,?,?)";
		return DBUtils.exeUpdate(sql, 
				user.getEmail(),
				user.getFirstName(),
				user.getLastName(),
				user.getPassword(),
				user.getBirthdate(),
				user.getOfficeID(),
				user.getRole());
	}
	
	/**
	 * 根据邮箱查询用户（登录）
	 * @param email
	 * @return
	 */
	public User findByEmail(String email){
		String sql = "select * from user where email=?";
		ResultSet rs = DBUtils.query(sql,email);
		User user = null;
		try {
			if(rs.next()){
				user = new User();
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getInt("active"));
				user.setBirthdate(rs.getDate("birthdate"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setOfficeID(rs.getString("officeID"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 根据officeID查询用户列表
	 * @param officeID
	 * @return
	 */
	public ArrayList<User> findByOfficeID(String officeID){
		String sql = "select * from user where officeID=?";
		ResultSet rs = DBUtils.query(sql,officeID);
		ArrayList<User> users = new ArrayList<>();
		User user = null;
		try {
			while(rs.next()){
				user = new User();
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getInt("active"));
				user.setBirthdate(rs.getDate("birthdate"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setOfficeID(rs.getString("officeID"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				//将查询到的用户对象加入集合
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	/**
	 * 查询所有用户
	 * @return
	 */
	public ArrayList<User> findAll(){
		String sql = "select * from user";
		ResultSet rs = DBUtils.query(sql);
		ArrayList<User> users = new ArrayList<>();
		User user = null;
		try {
			while(rs.next()){
				user = new User();
				user.setEmail(rs.getString("email"));
				user.setActive(rs.getInt("active"));
				user.setBirthdate(rs.getDate("birthdate"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setOfficeID(rs.getString("officeID"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
				//将查询到的用户对象加入集合
				users.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	/**
	 * 修改用户角色
	 * @param user
	 * @return
	 */
	public boolean modifyRole(User user){
		String sql = "update user set role=? where email=?";
		return DBUtils.exeUpdate(sql, user.getRole(),user.getEmail()); 
	}
	
	/**
	 * 修改用户状态
	 * @param user
	 * @return
	 */
	public boolean modifyActive(User user){
		String sql = "update user set active=? where email=?";
		return DBUtils.exeUpdate(sql, user.getActive(),user.getEmail()); 
	}
}
