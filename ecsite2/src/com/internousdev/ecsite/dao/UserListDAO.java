/*DBのlogin_user_transactionのカラム４つをDBからとってきてｒｓにいれる
rsから1件ずつ、dtoのフィールドに入れていく
List.addで随時追加
selectメソッドの返り血はDTOのList
*/


package com.internousdev.ecsite.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;



public class UserListDAO {


	public List<UserInfoDTO> getAllUser() throws SQLException{


		List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from login_user_transaction order by insert_date desc";


		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();


			while (rs.next()){

				UserInfoDTO dto = new UserInfoDTO();

				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsertDate(rs.getString("insert_date"));

				userInfoDTOList.add(dto);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			con.close();
		}

		return userInfoDTOList;



	}



}











