package com.internousdev.ecsite.action;


import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDetailsDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ItemDetailsAction extends ActionSupport implements SessionAware{


	private String id; //  ← 前画面のJSPからparamタグによって引き継がれた 変数 id  中身は 1つずつのidがそれぞれiteratorの回転毎に入る


	public Map<String, Object> session;
	private ItemDetailsDAO dao = new ItemDetailsDAO();
	private ItemInfoDTO dto = new ItemInfoDTO();

	public String execute() throws SQLException{




		dto = dao.getItemInfo(id);




		return SUCCESS;

	}


	public String getId() {
		return id;
	}

	public void setId (String id) {
		this.id = id;
	}



	public ItemInfoDTO getDto(){
		return dto;
	}

	public void setDto(ItemInfoDTO dto) {
		this.dto = dto;
	}




	public void setSession(Map<String, Object> session) {

		this.session = session;
	}


	public Map<String, Object> getSession(){
		return session;
	}


}
