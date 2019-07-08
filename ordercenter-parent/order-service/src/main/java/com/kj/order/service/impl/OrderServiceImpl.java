package com.kj.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kj.order.entiry.Order;
import com.kj.order.mapper.OrderMapper;
import com.kj.order.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderMapper orderMapper;
	
	@Override
	public List<Order> list() {
		List<Order> list = orderMapper.list();
		for(int i=0;i<list.size();i++) {
			System.err.println(list.get(i).getOrderNumber());
		}
		return list;
	}

}
