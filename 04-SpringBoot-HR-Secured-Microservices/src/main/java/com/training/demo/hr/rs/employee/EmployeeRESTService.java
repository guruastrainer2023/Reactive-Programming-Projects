package com.training.demo.hr.rs.employee;

import org.springframework.http.ResponseEntity;

import com.training.demo.hr.rs.request.employee.EmployeeAddRequest;
import com.training.demo.hr.rs.request.employee.EmployeeDeleteRequest;
import com.training.demo.hr.rs.request.employee.EmployeeUpdateRequest;
import com.training.demo.hr.rs.response.employee.EmployeeAddResponse;
import com.training.demo.hr.rs.response.employee.EmployeeDeleteResponse;
import com.training.demo.hr.rs.response.employee.EmployeeRetrieveAllResponse;
import com.training.demo.hr.rs.response.employee.EmployeeRetrieveResponse;
import com.training.demo.hr.rs.response.employee.EmployeeUpdateResponse;

public interface EmployeeRESTService {
	ResponseEntity<EmployeeAddResponse> addEmployee(EmployeeAddRequest employee) throws Exception;
	ResponseEntity<EmployeeRetrieveResponse> getEmployeeById(int id) throws Exception;
	ResponseEntity<EmployeeRetrieveAllResponse> getAllEmployees() throws Exception;
	ResponseEntity<EmployeeUpdateResponse> updateEmployee(EmployeeUpdateRequest employee) throws Exception;
	ResponseEntity<EmployeeDeleteResponse> deleteEmployee(EmployeeDeleteRequest employee) throws Exception;
	ResponseEntity<EmployeeDeleteResponse> deleteEmployeeById(int id) throws Exception;
}
