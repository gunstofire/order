package com.kj.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kj.order.entiry.Order;

@Mapper
public interface OrderMapper {
	
	List<Order> list();
}
