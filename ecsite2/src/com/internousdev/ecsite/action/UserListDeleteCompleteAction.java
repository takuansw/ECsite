package com.internousdev.ecsite.action;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{
	
	
	
	public String execute(){
		
		UserListDeleteCompleteDAO dao = new UserListDeleteCompleteDAO();
		
		
		dao.AllUserDelete();
		
		
		return SUCCESS;
	}
	
	
	
	

}
