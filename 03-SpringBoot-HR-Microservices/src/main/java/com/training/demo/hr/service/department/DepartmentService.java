package com.training.demo.hr.service.department;

import java.util.List;

import com.training.demo.hr.bean.Department;

public interface DepartmentService {
	Department addDepartment(Department department) throws Exception;
	Department updateDepartment(Department department) throws Exception;
	boolean deleteDepartment(Department department) throws Exception;
	Department getDepartment(int id) throws Exception;
	List<Department> getAllDepartments() throws Exception;
}
