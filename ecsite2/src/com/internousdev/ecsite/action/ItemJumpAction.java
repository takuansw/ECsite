package com.internousdev.ecsite.action;




import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemJumpDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemJumpAction extends ActionSupport implements SessionAware{



	private String itemName;

	private BuyItemDTO buyItemDTO = new BuyItemDTO();
	private ItemJumpDAO itemJumpDAO = new ItemJumpDAO();


	public Map<String,Object> session;


	public String execute(){


		buyItemDTO = itemJumpDAO.getBuyItemInfo(itemName);





		session.put("id", buyItemDTO.getId());
		session.put("buyItem_name", buyItemDTO.getItemName());
		session.put("buyItem_price", buyItemDTO.getItemPrice());   //  session に put (次のページに表示する為）
		session.put("item_stock", buyItemDTO.getItemStock());




		return "success";
	}





	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
