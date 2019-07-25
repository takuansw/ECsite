package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;



public class ItemDeleteCompleteDAO {


	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();




	public void itemDelete(String id) throws SQLException{


		String sql = "delete from item_info_transaction where id = ?";


		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, id);

			ps.execute();

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
	}
}
