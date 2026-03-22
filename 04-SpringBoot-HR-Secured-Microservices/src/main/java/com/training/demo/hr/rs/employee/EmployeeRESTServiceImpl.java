package com.training.demo.hr.rs.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.demo.hr.bean.Employee;
import com.training.demo.hr.rs.request.employee.EmployeeAddRequest;
import com.training.demo.hr.rs.request.employee.EmployeeDeleteRequest;
import com.training.demo.hr.rs.request.employee.EmployeeUpdateRequest;
import com.training.demo.hr.rs.response.employee.EmployeeAddResponse;
import com.training.demo.hr.rs.response.employee.EmployeeDeleteResponse;
import com.training.demo.hr.rs.response.employee.EmployeeRetrieveAllResponse;
import com.training.demo.hr.rs.response.employee.EmployeeRetrieveResponse;
import com.training.demo.hr.rs.response.employee.EmployeeUpdateResponse;
import com.training.demo.hr.service.employee.EmployeeService;


@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class EmployeeRESTServiceImpl implements EmployeeRESTService {

	@Autowired
	private EmployeeService employeeService;

	@Override
	@PostMapping("/add")
	public ResponseEntity<EmployeeAddResponse> addEmployee(@RequestBody EmployeeAddRequest employeeAddRequest)
			throws Exception {
		EmployeeAddResponse employeeAddResponse = new EmployeeAddResponse();

		Employee employee1 = employeeAddRequest.getEmployee();
		Employee employee2 = this.employeeService.addEmployee(employee1);

		employeeAddResponse.setStatusCode(200);
		employeeAddResponse.setMessage("Employee Added Successfully");
		employeeAddResponse.setEmployee(employee2);

		return ResponseEntity.ok(employeeAddResponse);
	}

	@Override
	@GetMapping("/find/{eid}")
	public ResponseEntity<EmployeeRetrieveResponse> getEmployeeById(@PathVariable(name = "eid") int id)
			throws Exception {
		EmployeeRetrieveResponse employeeRetrieveResponse = new EmployeeRetrieveResponse();

		Employee employee = this.employeeService.getEmployeeById(id);

		if (employee != null) {
			employeeRetrieveResponse.setStatusCode(200);
			employeeRetrieveResponse.setMessage("Employee Retrieved Successfully");
			employeeRetrieveResponse.setEmployee(employee);
		} else {
			employeeRetrieveResponse.setStatusCode(404);
			employeeRetrieveResponse.setMessage("Employee Not Retrieved");
			employeeRetrieveResponse.setEmployee(null);
		}
		return ResponseEntity.ok(employeeRetrieveResponse);
	}

	@Override
	@GetMapping("/all")

	public ResponseEntity<EmployeeRetrieveAllResponse> getAllEmployees() throws Exception {
		EmployeeRetrieveAllResponse employeeRetrieveAllResponse = new EmployeeRetrieveAllResponse();

		List<Employee> employees = this.employeeService.getAllEmployees();

		employeeRetrieveAllResponse.setStatusCode(200);
		employeeRetrieveAllResponse.setMessage("All Employees Retrieved Successfully");
		employeeRetrieveAllResponse.setAllEmployees(employees);
		return ResponseEntity.ok(employeeRetrieveAllResponse);
	}

	@Override
	@PutMapping("/update")
	public ResponseEntity<EmployeeUpdateResponse> updateEmployee(
			@RequestBody EmployeeUpdateRequest employeeUpdateRequest) throws Exception {
		EmployeeUpdateResponse employeeUpdateResponse = new EmployeeUpdateResponse();

		Employee employee = employeeUpdateRequest.getEmployee();

		Employee resultEmployee = this.employeeService.updateEmployee(employee);

		employeeUpdateResponse.setStatusCode(200);
		employeeUpdateResponse.setMessage("Employee updated Successfully");
		employeeUpdateResponse.setEmployee(resultEmployee);

		return ResponseEntity.ok(employeeUpdateResponse);
	}

	@Override
	@DeleteMapping("/delete")
	public ResponseEntity<EmployeeDeleteResponse> deleteEmployee(
			@RequestBody EmployeeDeleteRequest employeeDeleteRequest) throws Exception {
		EmployeeDeleteResponse  employeeDeleteResponse = new EmployeeDeleteResponse();

		boolean result = this.employeeService.deleteEmployee(employeeDeleteRequest.getEmployee());
		if (result == true) {
			employeeDeleteResponse.setStatusCode(200);
			employeeDeleteResponse.setMessage("Employee Deleted Successfully");
			employeeDeleteResponse.setEmployee(employeeDeleteRequest.getEmployee());
			return new ResponseEntity<>(employeeDeleteResponse, HttpStatus.OK);
		} else {
			employeeDeleteResponse.setStatusCode(500);
			employeeDeleteResponse.setMessage("Employee Not Deleted");
			employeeDeleteResponse.setEmployee(employeeDeleteRequest.getEmployee());
			return new ResponseEntity<>(employeeDeleteResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Override

	@DeleteMapping("/deleteById/{eid}")
	public ResponseEntity<EmployeeDeleteResponse> deleteEmployeeById(@PathVariable(name = "eid") int id)
			throws Exception {
		EmployeeDeleteResponse employeeDeleteResponse = new EmployeeDeleteResponse();

		Employee employee = new Employee(id);
		boolean result = this.employeeService.deleteEmployee(employee);

		if (result) {
			employeeDeleteResponse.setStatusCode(200);
			employeeDeleteResponse.setMessage("Employee Deleted Successfully");
			employeeDeleteResponse.setEmployee(this.employeeService.getEmployeeById(id));
			return new ResponseEntity<>(employeeDeleteResponse, HttpStatus.OK);
		} else {
			employeeDeleteResponse.setStatusCode(500);
			employeeDeleteResponse.setMessage("Employee Not Deleted");
			employeeDeleteResponse.setEmployee(null);
			return new ResponseEntity<>(employeeDeleteResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}