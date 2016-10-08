package com.nextera.orderbo;

import com.nextera.orderbo.exception.BOException;
import com.nextera.orderdto.Order;

public interface OrderBO {
	boolean placeOrder(Order order) throws BOException;
	boolean cancelOrder(int id) throws BOException;
	boolean deleteOrder(int id) throws BOException;
	
}
