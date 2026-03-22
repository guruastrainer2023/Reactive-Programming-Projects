package com.training.demo.hr.bean;

import java.util.Comparator;

public class SalaryDescComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getBasicSalary()>o2.getBasicSalary())
			return -1;
		
		if(o1.getBasicSalary()<o2.getBasicSalary())
			return 1;
		
		return 0;
	}

}
