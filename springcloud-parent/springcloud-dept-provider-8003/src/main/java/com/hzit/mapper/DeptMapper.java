package com.hzit.mapper;

import java.util.List;

import com.hzit.bean.Dept;

public interface DeptMapper {
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
