package com.faunjoe.impl;


import com.faunjoe.annotation.ExtService;
import com.faunjoe.service.OrderService;

@ExtService
public class OrderServiceImpl implements OrderService {

	public void addOrder() {
		System.out.println("addOrder");
	}
}
