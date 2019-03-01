package com.hzit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzit.bean.Dept;
import com.hzit.service.impl.DeptServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	private DeptServiceImpl deptService;

	@RequestMapping("/list")
	public List<Dept> list() {
		List<Dept> list = deptService.list();
		return list;
	}

	@RequestMapping("/get/{deptno}")
	@HystrixCommand(fallbackMethod = "nullDeptFallBack")
	public Dept get(@PathVariable(value = "deptno") Long deptno) {
		Dept dept = deptService.get(deptno);
		if (dept == null) {
			throw new RuntimeException();
		}
		return dept;
	}

	public Dept nullDeptFallBack(@PathVariable(value = "deptno") Long deptno) {
		System.out.println("--------------->" + deptno + ":没有找到数据");
		Dept dept = new Dept().setDeptno(500l).setPname("没有找到改部门编号对应的值").setLoc("no data ..... hystris");
		return dept;
	}

	@RequestMapping("/add")
	public boolean add(@RequestBody Dept dept) {
		boolean bool = deptService.add(dept);
		return bool;
	}
}
