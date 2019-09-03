package org.wsc.session1.service;

import org.wsc.session1.dao.UserDAO;
import org.wsc.session1.dto.Model;
import org.wsc.session1.entity.User;
import org.wsc.session1.utils.MD5Utils;

public class UserService {

	private UserDAO userDAO;
	
	/**
	 * ��¼��ҵ���߼�
	 * @param user
	 * @return
	 */
	public Model login(User user){
		Model model = new Model();
		userDAO = new UserDAO();
		User u = userDAO.findByEmail(user.getEmail());
		if(u != null){
			//�ж������Ƿ���ȷ(�û��������������ܺ��ٶԱ�)
			if(u.getPassword().equals(MD5Utils.encoder(user.getPassword()))){
				if(u.getActive() == 1){					
					//�ɹ�
					model.setSuccess(true);
					model.setData(u);
				}else{
					//�˺Ž���
					model.setMsg("���˺��ѱ�����");
				}
			}else{
				//�������
				model.setMsg("���벻��ȷ");
			}
		}else{
			//�˺Ų�����
			model.setMsg("�˺Ų�����");
		}
		return model;
	}
	
	
	
}
