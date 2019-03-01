package com.hzit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hzit.bean.Dept;
import com.hzit.mapper.DeptMapper;
import com.hzit.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{
	@Autowired
	private DeptMapper deptmapper;
	
	@Override
	public boolean add(Dept dept) {
		
		return deptmapper.add(dept);
	}

	@Override
	public Dept get(Long id) {
		
		return deptmapper.get(id);
		
	}

	@Override
	public List<Dept> list() {
		List<Dept> list = deptmapper.list();
		return list;
	}

}
