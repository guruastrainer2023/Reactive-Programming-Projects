package com.training.demo.hr.rs.department;

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

import com.training.demo.hr.bean.Department;
import com.training.demo.hr.rs.request.department.DepartmentAddRequest;
import com.training.demo.hr.rs.request.department.DepartmentDeleteRequest;
import com.training.demo.hr.rs.request.department.DepartmentUpdateRequest;
import com.training.demo.hr.rs.response.department.DepartmentAddResponse;
import com.training.demo.hr.rs.response.department.DepartmentDeleteResponse;
import com.training.demo.hr.rs.response.department.DepartmentRetrieveAllResponse;
import com.training.demo.hr.rs.response.department.DepartmentRetrieveResponse;
import com.training.demo.hr.rs.response.department.DepartmentUpdateResponse;
import com.training.demo.hr.service.department.DepartmentService;


@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class DepartmentRESTServiceImpl implements DepartmentRESTService {

	@Autowired
	private DepartmentService departmentService;

	@Override
	@PostMapping("/add")
	public ResponseEntity<DepartmentAddResponse> addDepartment(@RequestBody DepartmentAddRequest departmentAddRequest)
			throws Exception {
		DepartmentAddResponse departmentAddResponse = new DepartmentAddResponse();

		Department department1 = departmentAddRequest.getDepartment();
		Department department2 = this.departmentService.addDepartment(department1);

		departmentAddResponse.setStatusCode(200);
		departmentAddResponse.setMessage("Department Added Successfully");
		departmentAddResponse.setDepartment(department2);

		return ResponseEntity.ok(departmentAddResponse);
	}

	@Override
	@GetMapping("/find/{did}")
	public ResponseEntity<DepartmentRetrieveResponse> getDepartmentById(@PathVariable(name="did") int id) throws Exception {
		DepartmentRetrieveResponse departmentRetrieveResponse = new DepartmentRetrieveResponse();

		Department department = this.departmentService.getDepartment(id);

		if (department != null) {
			departmentRetrieveResponse.setStatusCode(200);
			departmentRetrieveResponse.setMessage("Department Retrieved Successfully");
			departmentRetrieveResponse.setDepartment(department);
		} else {
			departmentRetrieveResponse.setStatusCode(404);
			departmentRetrieveResponse.setMessage("Department Not Found");
			departmentRetrieveResponse.setDepartment(null);
		}

		return ResponseEntity.ok(departmentRetrieveResponse);
	}

	@Override
	@GetMapping("/all")
	public ResponseEntity<DepartmentRetrieveAllResponse> getAllDepartments() throws Exception {
		DepartmentRetrieveAllResponse departmentRetrieveAllResponse=new DepartmentRetrieveAllResponse();
		
		List<Department> allDepartments=this.departmentService.getAllDepartments();
		
		departmentRetrieveAllResponse.setStatusCode(200);
		departmentRetrieveAllResponse.setMessage(allDepartments.size()+ "department Retrieved ");
		departmentRetrieveAllResponse.setAllDepartments(allDepartments);
		return ResponseEntity.ok(departmentRetrieveAllResponse);
	}

	@Override
	@PutMapping("/update")
	public ResponseEntity<DepartmentUpdateResponse> updateDepartment(@RequestBody DepartmentUpdateRequest departmentUpdateRequest)
			throws Exception {
	    DepartmentUpdateResponse departmentUpdateResponse=new DepartmentUpdateResponse();
	    
	    Department department1=departmentUpdateRequest.getDepartment();
	    Department department2=this.departmentService.updateDepartment(department1);
	    
	    departmentUpdateResponse.setStatusCode(200);
	    departmentUpdateResponse.setMessage("Department Updated Successfully");
	    departmentUpdateResponse.setDepartment(department2);
	    
		return ResponseEntity.ok(departmentUpdateResponse);
	}

	@Override
	@DeleteMapping("/delete")
	public ResponseEntity<DepartmentDeleteResponse> deleteDepartment(@RequestBody DepartmentDeleteRequest departmentDeleteRequest)
			throws Exception {
		DepartmentDeleteResponse departmentDeleteResponse=new DepartmentDeleteResponse();
		
		Department department=departmentDeleteRequest.getDepartment();
		
		boolean result=this.departmentService.deleteDepartment(department);
		if(result==true) {
			departmentDeleteResponse.setStatusCode(200);
			departmentDeleteResponse.setMessage("Department Deleted Successfully");
			departmentDeleteResponse.setDepartment(department);
			return new ResponseEntity<>(departmentDeleteResponse,HttpStatus.OK);
		}else {
			departmentDeleteResponse.setStatusCode(500);
			departmentDeleteResponse.setMessage("Employee Not Deleted");
			departmentDeleteResponse.setDepartment(department);
			return new ResponseEntity<>(departmentDeleteResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}

	@Override
	@DeleteMapping("/deleteById")
	public ResponseEntity<DepartmentDeleteResponse> deleteDepartmentById(@RequestBody DepartmentDeleteRequest departmentDeleteRequest) throws Exception {
		DepartmentDeleteResponse departmentDeleteResponse=new DepartmentDeleteResponse();
		
		Department department=departmentDeleteRequest.getDepartment();
		
		
		boolean result=this.departmentService.deleteDepartment(department);
		if(result==true) {
			departmentDeleteResponse.setStatusCode(200);
			departmentDeleteResponse.setMessage("Department Deleted Successfully");
			departmentDeleteResponse.setDepartment(department);
			return new ResponseEntity<>(departmentDeleteResponse,HttpStatus.OK);
		}else {
			departmentDeleteResponse.setStatusCode(500);
			departmentDeleteResponse.setMessage("Employee Not Deleted");
			departmentDeleteResponse.setDepartment(department);
			return new ResponseEntity<>(departmentDeleteResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
