package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.UserDetailsDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailsAction extends ActionSupport {

	private String loginId;

	UserDetailsDAO dao = new UserDetailsDAO();
	UserInfoDTO dto = new UserInfoDTO();


	public String execute() throws SQLException{

		dto = dao.getUserInfo(loginId);

		return SUCCESS;
	}




	public String getLoginId(){
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}




	public UserInfoDTO getDto(){
		return dto;
	}


}
