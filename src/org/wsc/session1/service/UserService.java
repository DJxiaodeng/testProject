package org.wsc.session1.service;

import org.wsc.session1.dao.UserDAO;
import org.wsc.session1.dto.Model;
import org.wsc.session1.entity.User;
import org.wsc.session1.utils.MD5Utils;

public class UserService {

	private UserDAO userDAO;
	
	/**
	 * 登录的业务逻辑
	 * @param user
	 * @return
	 */
	public Model login(User user){
		Model model = new Model();
		userDAO = new UserDAO();
		User u = userDAO.findByEmail(user.getEmail());
		if(u != null){
			//判断密码是否正确(用户输入的密码需加密后再对比)
			if(u.getPassword().equals(MD5Utils.encoder(user.getPassword()))){
				if(u.getActive() == 1){					
					//成功
					model.setSuccess(true);
					model.setData(u);
				}else{
					//账号禁用
					model.setMsg("该账号已被禁用");
				}
			}else{
				//密码错误
				model.setMsg("密码不正确");
			}
		}else{
			//账号不存在
			model.setMsg("账号不存在");
		}
		return model;
	}
	
	
	
}
