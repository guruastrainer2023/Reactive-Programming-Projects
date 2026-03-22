package com.training.demo.hr.service.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.demo.hr.bean.Department;
import com.training.demo.hr.bean.Employee;
import com.training.demo.hr.db.EmployeeRepository;
import com.training.demo.hr.bean.Employee;
import com.training.demo.hr.exception.department.DepartmentDeleteFailureException;
import com.training.demo.hr.exception.department.DepartmentGetAllFailureException;
import com.training.demo.hr.exception.department.DepartmentGetFailureException;
import com.training.demo.hr.exception.department.DepartmentUpdateFailureException;
import com.training.demo.hr.exception.employee.EmployeeAddFailureException;
import com.training.demo.hr.exception.employee.EmployeeDeleteFailureException;
import com.training.demo.hr.exception.employee.EmployeeGetAllFailureException;
import com.training.demo.hr.exception.employee.EmployeeGetFailureException;
import com.training.demo.hr.exception.employee.EmployeeUpdateFailureException;
import com.training.demo.hr.util.ConsoleUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee addEmployee(Employee employee) throws Exception {
		ConsoleUtil.printCaption("Employee Service Add Employee");
		ConsoleUtil.printData(employee);

		Employee insertedEmployee = null;
		try {
			insertedEmployee = this.employeeRepository.save(employee);
			ConsoleUtil.printCaption("Employee Service Add Completed");
		} catch (Exception e) {
			ConsoleUtil.printCaption("Employee Service Add Failed");
			throw new EmployeeAddFailureException(e.getMessage());
		}

		ConsoleUtil.printData(insertedEmployee);

		return insertedEmployee;
	}

	@Override
	public Employee updateEmployee(Employee employee) throws Exception {
		ConsoleUtil.printCaption("Employee Service Update Employee");
		ConsoleUtil.printData(employee);
		
		Employee updatedEmployee=null;
		try {
		this.employeeRepository.save(employee);
		ConsoleUtil.printCaption("Employee Service update Completed");
		}catch(Exception e) {
			ConsoleUtil.printCaption("Employee Service Update Failed");
			throw new EmployeeUpdateFailureException(e.getMessage());
		}
		ConsoleUtil.printData(updatedEmployee);
		return updatedEmployee;
	}

	@Override
	public boolean deleteEmployee(Employee employee) throws Exception {
		ConsoleUtil.printCaption("Employee Service Delete Employee");
		ConsoleUtil.printData(employee);
		boolean deleteStatus=false;
		try {
			this.employeeRepository.delete(employee);
			deleteStatus=true;
			ConsoleUtil.printCaption("Employee Service Delete Completed");

		}catch (Exception e) {
			ConsoleUtil.printCaption("Employee Service Delete Failed");
			throw new EmployeeDeleteFailureException(e.getMessage());
		}
		
		return deleteStatus;
	}

	@Override
	public Employee getEmployeeById(int id) throws Exception {
		ConsoleUtil.printCaption("Employee Service Get Employee");
		ConsoleUtil.printData(id);
		Optional<Employee> foundEmployeeOptional = null;
		try {
			foundEmployeeOptional = this.employeeRepository.findById(id);
			if (foundEmployeeOptional.isPresent()) {
				ConsoleUtil.printCaption("Employee Service Get Completed");
				return foundEmployeeOptional.get();

			} else {
				ConsoleUtil.printCaption("Employee Service Get Completed Not Found Employee");
				return foundEmployeeOptional.get();
			}

		} catch (Exception e) {
			ConsoleUtil.printCaption("Employee Service Get Failed");
			throw new EmployeeGetFailureException(e.getMessage());
		}
	}

	@Override
	public List<Employee> getAllEmployees() throws Exception {
		ConsoleUtil.printCaption("Employee Service Get All Employees");
		List<Employee> allEmployees =null;
		try {
			allEmployees= this.employeeRepository.findAll();
			System.out.println(allEmployees);
			ConsoleUtil.printCaption("Employee Service Get All Completed");
		} catch (Exception e) {
			ConsoleUtil.printCaption("Employee Service Get All Failed");
			throw new EmployeeGetAllFailureException(e.getMessage());
		}
		return allEmployees;
	}

}
