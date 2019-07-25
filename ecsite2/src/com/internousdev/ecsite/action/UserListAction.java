/*このボタンをポチっとすると、次のページに、ユーザーのリストが表示される*/


/*
空のdtoListを作成
フィールドに、id,pass,username,insertdateが入ったDTOをListにしたものを作成する

daoのselectメソッドの返り血がListになっている

リスト作成に成功したら、success

次のjspがgetするために、リストのgetterを書く*/



package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UserListAction extends ActionSupport{


	private List<UserInfoDTO> userList = new ArrayList<UserInfoDTO>();


	public String execute() throws SQLException{

		UserListDAO dao = new UserListDAO();

		userList = dao.getAllUser();



		return SUCCESS;
	}



	public List<UserInfoDTO> getUserList(){
		return this.userList;
	}

}











