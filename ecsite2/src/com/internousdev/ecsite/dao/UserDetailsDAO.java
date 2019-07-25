package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;


public class UserDetailsDAO {

	UserInfoDTO dto = new UserInfoDTO();

	public UserInfoDTO getUserInfo(String loginId) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from login_user_transaction where login_id = ?";


		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, loginId);

			ResultSet rs = ps.executeQuery();


			if (rs.next()) {

				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsertDate(rs.getString("insert_date"));


			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			con.close();
		}

		return dto;
	}

}
