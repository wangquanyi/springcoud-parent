package com.hzit.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hzit.bean.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactoy implements FallbackFactory<DeptClientService> {

	@Override
	public DeptClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new DeptClientService() {
			@Override
			public List<Dept> list() {
				return null;
			}

			@Override
			public Dept get(Long deptno) {
				return new Dept().setDeptno(500L).setPname(deptno + "没有找到对应数据").setLoc("通过fegin");
			}

			@Override
			public boolean add(Dept dept) {
				return false;
			}
		};
	}

}