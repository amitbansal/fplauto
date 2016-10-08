package com.nextera.orderbo;

import java.sql.SQLException;

import com.nextera.orderbo.exception.BOException;
import com.nextera.orderdao.OrderDAO;
import com.nextera.orderdto.Order;

public class OrderBOImpl implements OrderBO {
	private OrderDAO dao;
	
	@Override
	public boolean placeOrder(Order order) throws BOException {
		try{
			int result= dao.create(order);
			if(result==0){
				return false;
				}
			}
			catch(SQLException e){
			throw new BOException(e);
		}
		return true;
	}

	@Override
	public boolean cancelOrder(int id) throws BOException {
		try{
			
			Order order = dao.read(id);	
			order.setStatus("Cancelled");
			int result =dao.update(order);
			if(result==0){
				return false;
			}
		}
		catch(SQLException e){
			throw new BOException(e);
		}
		
		return true;
	}

	@Override
	public boolean deleteOrder(int id) throws BOException {
		try{
			int result=dao.delete(id);
			if(result==0){
				return false;
			}
		}
		catch(SQLException e){
			throw new BOException(e);
		}
		return true;
	}

	/**
	 * @return the dao
	 */
	public OrderDAO getDao() {
		return dao;
	}

	/**
	 * @param dao the dao to set
	 */
	public void setDao(OrderDAO dao) {
		this.dao = dao;
	}

}
