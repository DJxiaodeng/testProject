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
	 * 查询指定用户的所有登录记录
	 * @param email
	 * @return
	 */
	public Map<String,Object> queryLoginInfo(String email){
		LoginrecordDAO recordDAO =  new LoginrecordDAO();
		//1.查询出当前登录用户的所有登录记录
		ArrayList<Loginrecord> list = recordDAO.findAllByEmail(email);
		ArrayList<LoginInfo> records = new ArrayList<>();
		long total = 0;
		for (Loginrecord lr : list) {
			
			//获取登录时间
			Timestamp in = lr.getLoginTime();
			//获取登出时间
			Timestamp out = lr.getLogoutTime();
			
			LoginInfo info = new LoginInfo();
			info.setEmail(email);
			info.setDate(Tools.getDate(in));
			info.setLoginTime(Tools.getTime(in));
			info.setLogoutTime(Tools.getTime(out));
			//计算本次登录和登出时间差(本次登录耗时：ms)
			long spent = out.getTime()-in.getTime();
			System.out.println(spent+"------------");
			//设置耗时（HH:mm）
			info.setSpent(Tools.getTime(new Timestamp(spent)));
			
			records.add(info);
			//统计每一次登录的耗时
			total += spent;
		}

		
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("record", records);
		//2.将统计的总登录时长格式化后存储到map中
		data.put("total", Tools.getTotalSpent(total));	
		return data;
	}
}	
