package com.training.demo.hr.service.department;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.demo.hr.bean.Department;
import com.training.demo.hr.bean.Employee;
import com.training.demo.hr.bean.SalaryDescComparator;
import com.training.demo.hr.db.DepartmentRepositoy;
import com.training.demo.hr.exception.department.DepartmentAddFailureException;
import com.training.demo.hr.exception.department.DepartmentDeleteFailureException;
import com.training.demo.hr.exception.department.DepartmentGetAllFailureException;
import com.training.demo.hr.exception.department.DepartmentGetFailureException;
import com.training.demo.hr.exception.department.DepartmentUpdateFailureException;
import com.training.demo.hr.util.ConsoleUtil;



@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepositoy departmentRepository;

	@Override
	public Department addDepartment(Department department) throws Exception {
		ConsoleUtil.printCaption("Department Service Add Department");
		ConsoleUtil.printData(department);

		Department insertedDepartment = null;
		try {
			insertedDepartment = this.departmentRepository.save(department);
			ConsoleUtil.printCaption("Department Service Add Completed");
		} catch (Exception e) {
			ConsoleUtil.printCaption("Department Service Add Failed");
			throw new DepartmentAddFailureException(e.getMessage());
		}

		ConsoleUtil.printData(insertedDepartment);

		return insertedDepartment;
	}

	@Override
	public Department updateDepartment(Department department) throws Exception {
		ConsoleUtil.printCaption("Department Service Update Department");
		ConsoleUtil.printData(department);
		
		Department updatedDepartment=null;
		try {
	    Optional<Department> optionalfindDepartment=this.departmentRepository.findById(department.getId());
	    if(optionalfindDepartment.isPresent()) {
	    	Department findDepartment=optionalfindDepartment.get();
	    	findDepartment.setDepartmentName(department.getDepartmentName());
	    	findDepartment.getEmployees().clear();
	    	//findDepartment.setEmployees(department.getEmployees());
	    	
			updatedDepartment=this.departmentRepository.save(findDepartment);
			findDepartment.setEmployees(department.getEmployees());
			updatedDepartment=this.departmentRepository.save(findDepartment);
			ConsoleUtil.printCaption("Department Service update Completed");
	    }else {
	    	ConsoleUtil.printCaption("Department Service Could not find Department for update");
	    }
	    
		}catch(Exception e) {
			ConsoleUtil.printCaption("Department Service Update Failed");
			throw new DepartmentUpdateFailureException(e.getMessage());
		}
		ConsoleUtil.printData(updatedDepartment);
		return updatedDepartment;
	}

	@Override
	public boolean deleteDepartment(Department department) throws Exception {
		ConsoleUtil.printCaption("Department Service Delete Department");
		ConsoleUtil.printData(department);
		boolean deleteStatus=false;
		try {
			this.departmentRepository.delete(department);
			deleteStatus=true;
			ConsoleUtil.printCaption("Department Service Delete Completed");

		}catch (Exception e) {
			ConsoleUtil.printCaption("Department Service Delete Failed");
			throw new DepartmentDeleteFailureException(e.getMessage());
		}
		
		return deleteStatus;
	}

	@Override
	public Department getDepartment(int id) throws Exception {
		ConsoleUtil.printCaption("Department Service Get Department");
		ConsoleUtil.printData(id);
		Optional<Department> foundDepartmentOptional = null;
		try {
			foundDepartmentOptional = this.departmentRepository.findById(id);
			
			
			if (foundDepartmentOptional.isPresent()) {
				ConsoleUtil.printCaption("Department Service Get Completed");
				List<Employee> deptEmployees=foundDepartmentOptional.get().getEmployees();
				Collections.sort(deptEmployees, new SalaryDescComparator());
				return foundDepartmentOptional.get();

			} else {
				ConsoleUtil.printCaption("Department Service Get Completed Not Found Department");
				return foundDepartmentOptional.get();
			}

		} catch (Exception e) {
			ConsoleUtil.printCaption("Department Service Get Failed");
			throw new DepartmentGetFailureException(e.getMessage());
		}

	}

	@Override
	public List<Department> getAllDepartments() throws Exception {
		ConsoleUtil.printCaption("Department Service Get All Departments");
		List<Department> allDepartments =null;
		try {
			allDepartments= this.departmentRepository.findAll();
			System.out.println(allDepartments);
			ConsoleUtil.printCaption("Department Service Get All Completed");
		} catch (Exception e) {
			ConsoleUtil.printCaption("Department Service Get All Failed");
			throw new DepartmentGetAllFailureException(e.getMessage());
		}
		return allDepartments;
	}

}
