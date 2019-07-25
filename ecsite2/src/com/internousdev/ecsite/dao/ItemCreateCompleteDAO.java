package com.internousdev.ecsite.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {



	public void   itemInsert(String item_name, int item_price, int item_stock) throws SQLException{

		DateUtil dateUtil = new DateUtil();



		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "insert into item_info_transaction (item_name, item_price, item_stock, insert_date) values (?,?,?,?)";


		try {

			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, item_name);
			ps.setInt(2, item_price);
			ps.setInt(3, item_stock);
			ps.setString(4, dateUtil.getDate());


			ps.execute();



		}

		catch(SQLException e) {
			e.printStackTrace();
		}

		finally {
			con.close();
		}


	}

}
