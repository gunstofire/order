package com.kj.order.entiry;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
	
	private Integer id;
	private String orderNumber;
	private String orderDescription;
	private Date createTime;
}
