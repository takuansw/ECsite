package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.opensymphony.xwork2.ActionSupport;




public class ItemListDeleteCompleteAction extends ActionSupport{



	public String execute() throws SQLException{

		ItemListDAO dao = new ItemListDAO();



		 dao.AllItemDelete();





		return SUCCESS;
	}

}
