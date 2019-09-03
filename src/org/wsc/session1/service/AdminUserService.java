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
 * ����Աҵ���߼�
 * @author mrchai
 *
 */
public class AdminUserService {

	private UserDAO userDAO;
	
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	public boolean addUser(User user){
		userDAO = new UserDAO();
		return userDAO.insert(user);
	}
	
	/**
	 * ��ѯ���е��û�
	 * @return
	 */
	public ArrayList<UserInfo> findAllUsers(){
		ArrayList<UserInfo> users = new ArrayList<>();

		userDAO = new UserDAO();
		OfficeDAO officeDAO = new OfficeDAO();
		ArrayList<User> list = userDAO.findAll();
		for (User u : list) {
			
			//�����û�������officeID��ѯoffice����
			Office office = officeDAO.findByOfficeId(u.getOfficeID());
			//�����û������ջ�ȡ����
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
	 * ����officeID��ѯ����Ա��
	 * @param officeId
	 * @return
	 */
	public ArrayList<UserInfo> findByOffice(String officeID){
		ArrayList<UserInfo> users = new ArrayList<>();

		userDAO = new UserDAO();
		OfficeDAO officeDAO = new OfficeDAO();
		ArrayList<User> list = userDAO.findByOfficeID(officeID);
		for (User u : list) {
			
			//�����û�������officeID��ѯoffice����
			Office office = officeDAO.findByOfficeId(u.getOfficeID());
			//�����û������ջ�ȡ����
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
	 * �����û���¼
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
	 * �����û���¼
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
	 * �޸Ľ�ɫ
	 * @return
	 */
	public boolean modifyRole(User user){
		user.setEmail(user.getEmail());
		user.setRole(user.getRole());
		userDAO = new UserDAO();
		return userDAO.modifyRole(user);
	}
	
	/**
	 * ��ѯ���е�office
	 * @return
	 */
	public ArrayList<Office> queryAllOffice(){
		OfficeDAO officeDAO =  new OfficeDAO();
		return officeDAO.findAll();
	}
}
