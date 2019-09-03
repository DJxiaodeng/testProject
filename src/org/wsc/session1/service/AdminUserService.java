package org.wsc.session1.service;

import java.util.ArrayList;

import org.wsc.session1.dao.OfficeDAO;
import org.wsc.session1.dao.UserDAO;
import org.wsc.session1.dto.Model;
import org.wsc.session1.dto.UserInfo;
import org.wsc.session1.entity.Office;
import org.wsc.session1.entity.User;
import org.wsc.session1.utils.Tools;

/**
 * 管理员业务逻辑
 * @author mrchai
 *
 */
public class AdminUserService {

	private UserDAO userDAO;
	
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean addUser(User user){
		userDAO = new UserDAO();
		return userDAO.insert(user);
	}
	
	/**
	 * 查询所有的用户
	 * @return
	 */
	public ArrayList<UserInfo> findAllUsers(){
		ArrayList<UserInfo> users = new ArrayList<>();

		userDAO = new UserDAO();
		OfficeDAO officeDAO = new OfficeDAO();
		ArrayList<User> list = userDAO.findAll();
		for (User u : list) {
			
			//根据用户所属的officeID查询office对象
			Office office = officeDAO.findByOfficeId(u.getOfficeID());
			//根据用户的生日获取年龄
			int age = Tools.getAge(u.getBirthdate());

			UserInfo ui = new UserInfo();
			ui.setOffice(office);
			ui.setUser(u);
			ui.setAge(age);
			
			users.add(ui); 
		}
		
		return users;
	}
	
	/**
	 * 根据officeID查询所有员工
	 * @param officeId
	 * @return
	 */
	public ArrayList<UserInfo> findByOffice(String officeID){
		ArrayList<UserInfo> users = new ArrayList<>();

		userDAO = new UserDAO();
		OfficeDAO officeDAO = new OfficeDAO();
		ArrayList<User> list = userDAO.findByOfficeID(officeID);
		for (User u : list) {
			
			//根据用户所属的officeID查询office对象
			Office office = officeDAO.findByOfficeId(u.getOfficeID());
			//根据用户的生日获取年龄
			int age = Tools.getAge(u.getBirthdate());

			UserInfo ui = new UserInfo();
			ui.setOffice(office);
			ui.setUser(u);
			ui.setAge(age);
			
			users.add(ui); 
		}
		
		return users;
	}
	
	/**
	 * 启用用户登录
	 * @return
	 */
	public boolean enableUser(String email){
		User user = new User();
		user.setEmail(email);
		user.setActive(1);
		userDAO = new UserDAO();
		return userDAO.modifyActive(user);
	}
	
	/**
	 * 禁用用户登录
	 * @return
	 */
	public boolean disableUser(String email){
		User user = new User();
		user.setEmail(email);
		user.setActive(0);
		userDAO = new UserDAO();
		return userDAO.modifyActive(user);
	}
	
	/**
	 * 修改角色
	 * @return
	 */
	public boolean modifyRole(User user){
		user.setEmail(user.getEmail());
		user.setRole(user.getRole());
		userDAO = new UserDAO();
		return userDAO.modifyRole(user);
	}
	
	/**
	 * 查询所有的office
	 * @return
	 */
	public ArrayList<Office> queryAllOffice(){
		OfficeDAO officeDAO =  new OfficeDAO();
		return officeDAO.findAll();
	}
}
