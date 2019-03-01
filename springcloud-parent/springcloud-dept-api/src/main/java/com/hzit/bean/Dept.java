package com.hzit.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {
	public Long deptno;
	public String pname;
	public String loc;

	public Dept aout(String name) {
		Dept dept = new Dept().setDeptno(1111L).setPname(name).setLoc("深圳市华美居");
		return dept;

	}

}
