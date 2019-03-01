package com.hzit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hzit.bean.Dept;
import com.hzit.service.impl.DeptServiceImpl;

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
	public Dept get(@PathVariable(value = "deptno") Long deptno) {
		Dept dept = deptService.get(deptno);
		if (dept == null) {
			throw new RuntimeException();
		}
		return dept;
	}

	@RequestMapping("/add")
	public boolean add(@RequestBody Dept dept) {
		boolean bool = deptService.add(dept);
		return bool;
	}
}
