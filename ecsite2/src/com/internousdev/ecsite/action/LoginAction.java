package com.internousdev.ecsite.action;


import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemSelectDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.ItemSelectDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;

	public Map<String, Object> session;

	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();


	ArrayList<ItemSelectDTO> itemNameList = new ArrayList<ItemSelectDTO>();

	private ItemSelectDAO itemSelectDAO = new ItemSelectDAO();



	public String execute()   {

		String result = ERROR;

		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword); // DBからのデータとFlgにtrueを入れたDTO
		session.put("loginUser", loginDTO);



//		              思い出させる
//                       →
//            (   ( 型 )     型を忘れたloginDTO     )

		if(   ( (LoginDTO) session.get("loginUser") ) .getLoginFlg()     ) {


			if(((LoginDTO)session.get("loginUser")).getAdmin_flg() != null  //  admin_flgがNULLでないことも明示する
				&& ((LoginDTO)session.get("loginUser")).getAdmin_flg().equals("1")){


				result = "admin";
			}

			else{

//         loginFlg が true →  つまり、ユーザーIDがしっかりと存在しているので  success を

			result = SUCCESS;
			      //   商品選択ページ に飛ぶので、商品の名前のリストを作成する必要がある



			itemNameList = itemSelectDAO.getItemSelectInfo();


			session.put("login_user_id", loginDTO.getLoginId());  // ログインに成功したら、これがputされる




			return result;
			}

		}



		return result;
	}




	public String getLoginUserId() {
		return loginUserId;
	}


	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}


	public String getLoginPassword() {
		return loginPassword;
	}


	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public ArrayList<ItemSelectDTO> getItemNameList () {
		return itemNameList;
	}



}
















