package org.wsc.session1.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.wsc.session1.dao.LoginrecordDAO;
import org.wsc.session1.dto.LoginInfo;
import org.wsc.session1.entity.Loginrecord;
import org.wsc.session1.utils.Tools;

public class OfficeUserService {

	/**
	 * ��ѯָ���û������е�¼��¼
	 * @param email
	 * @return
	 */
	public Map<String,Object> queryLoginInfo(String email){
		LoginrecordDAO recordDAO =  new LoginrecordDAO();
		//1.��ѯ����ǰ��¼�û������е�¼��¼
		ArrayList<Loginrecord> list = recordDAO.findAllByEmail(email);
		ArrayList<LoginInfo> records = new ArrayList<>();
		long total = 0;
		for (Loginrecord lr : list) {
			
			//��ȡ��¼ʱ��
			Timestamp in = lr.getLoginTime();
			//��ȡ�ǳ�ʱ��
			Timestamp out = lr.getLogoutTime();
			
			LoginInfo info = new LoginInfo();
			info.setEmail(email);
			info.setDate(Tools.getDate(in));
			info.setLoginTime(Tools.getTime(in));
			info.setLogoutTime(Tools.getTime(out));
			//���㱾�ε�¼�͵ǳ�ʱ���(���ε�¼��ʱ��ms)
			long spent = out.getTime()-in.getTime();
			System.out.println(spent+"------------");
			//���ú�ʱ��HH:mm��
			info.setSpent(Tools.getTime(new Timestamp(spent)));
			
			records.add(info);
			//ͳ��ÿһ�ε�¼�ĺ�ʱ
			total += spent;
		}

		
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("record", records);
		//2.��ͳ�Ƶ��ܵ�¼ʱ����ʽ����洢��map��
		data.put("total", Tools.getTotalSpent(total));	
		return data;
	}
}	
