package com.faunjoe.mvc.demo.service.impl;


import com.faunjoe.mvc.demo.service.INamedService;
import com.faunjoe.mvc.demo.service.IService;
import com.faunjoe.mvc.framework.annotation.*;

@FService("myName")
public class NamedServiceImpl implements INamedService {

	@FAutowired
	private IService service;
}
