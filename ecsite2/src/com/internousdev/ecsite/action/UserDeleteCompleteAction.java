package com.internousdev.ecsite.action;


import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDeleteCompleteAction extends ActionSupport{


	 private String loginId;

	UserDeleteCompleteDAO dao = new UserDeleteCompleteDAO();



	public String execute() throws SQLException {





		dao.deleteUserInfo(loginId);



		return SUCCESS;
	}







	public String getLoginId(){
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

}
