package org.wsc.session1.dto;

/**
 * ҵ���߼�ģ��
 * @author mrchai
 */
public class Model {
	
	/**״̬�룺�Զ���**/
	private int code;
	/**��Ϣ**/
	private String msg;
	/**���ݵ�����**/
	private Object data;
	/**�Ƿ�ɹ�**/
	private boolean success; //false
	
	public Model() {
		// TODO Auto-generated constructor stub
	}


	public Model(int code, String msg, Object data, boolean success) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.success = success;
	}



	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	
}
