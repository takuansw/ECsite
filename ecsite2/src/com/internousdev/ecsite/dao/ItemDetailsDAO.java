package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;


public class ItemDetailsDAO {

	ItemInfoDTO dto = new ItemInfoDTO();

	public ItemInfoDTO getItemInfo(String id) throws SQLException {

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select * from item_info_transaction where id = ?";


		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();


			if (rs.next()) {

				dto.setId(rs.getString("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
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
