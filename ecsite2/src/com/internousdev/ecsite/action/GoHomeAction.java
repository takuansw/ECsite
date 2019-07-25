package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoHomeAction extends ActionSupport implements SessionAware {



	public Map<String, Object> session;  //  これいる？




	public String execute()  {

		return SUCCESS;

	}



	public Map<String, Object> getSession() {   // これも
		return this.session;
	}


	public void setSession(Map<String, Object> session) {  // これも
		this.session = session;
	}

}
