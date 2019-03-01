package com.hzit.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hzit.bean.Dept;

@RestController
@RequestMapping("/consumer/dept")
public class DeptConsumerController {
	private static final String PREFIX_URL = "http://SPRINGCLOUD-DEPT/";
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/list")
	public List<Dept> list() {
		List list = restTemplate.getForObject(PREFIX_URL + "/dept/list", List.class);
		return list;
	}

	@RequestMapping("/get/{deptno}")
	public Dept get(@PathVariable("deptno") Long deptno) {
		Dept dept = restTemplate.getForObject(PREFIX_URL + "/dept/get/" + deptno, Dept.class);
		return dept;
	}

	@RequestMapping("/add")
	public boolean add(Dept dept) {
		Boolean boolean1 = restTemplate.postForObject(PREFIX_URL + "/dept/add", dept, Boolean.class);
		return boolean1;

	}
}
