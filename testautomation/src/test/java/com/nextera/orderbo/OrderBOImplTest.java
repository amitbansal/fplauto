package com.nextera.orderbo;

import org.junit.Before;
import org.junit.Test;
//import org.mockito.MockitoAnnotations.Mock;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nextera.orderbo.exception.BOException;
import com.nextera.orderdao.OrderDAO;
import com.nextera.orderdto.Order;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;


public class OrderBOImplTest {
	@Mock
	OrderDAO dao;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
	}
	
	@Test
	public void placeOrder_Should_Create_An_Order() throws SQLException, BOException{
		OrderBOImpl bo = new OrderBOImpl();
		bo.setDao(dao);
		Order order =new Order();
		when(dao.create(order)).thenReturn(new Integer(1));
		boolean result = bo.placeOrder(order);
		assertTrue(result);
		verify(dao).create(order);
	}
	
}
