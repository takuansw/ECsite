package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserDeleteCompleteDAO {



	public void deleteUserInfo(String loginId) throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "delete from login_user_transaction where login_id = ? ";

		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1,loginId);

			ps.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			con.close();
		}






	}






}
