package com.training.demo.hr.rs.department;

import org.springframework.http.ResponseEntity;

import com.training.demo.hr.rs.request.department.DepartmentAddRequest;
import com.training.demo.hr.rs.request.department.DepartmentDeleteRequest;
import com.training.demo.hr.rs.request.department.DepartmentUpdateRequest;
import com.training.demo.hr.rs.response.department.DepartmentAddResponse;
import com.training.demo.hr.rs.response.department.DepartmentDeleteResponse;
import com.training.demo.hr.rs.response.department.DepartmentRetrieveAllResponse;
import com.training.demo.hr.rs.response.department.DepartmentRetrieveResponse;
import com.training.demo.hr.rs.response.department.DepartmentUpdateResponse;

public interface DepartmentRESTService {
	ResponseEntity<DepartmentAddResponse> addDepartment(DepartmentAddRequest departmentAddRequest) throws Exception;
	ResponseEntity<DepartmentRetrieveResponse> getDepartmentById(int id) throws Exception;
	ResponseEntity<DepartmentRetrieveAllResponse> getAllDepartments() throws Exception;
	ResponseEntity<DepartmentUpdateResponse> updateDepartment(DepartmentUpdateRequest departmentUpdateRequest) throws Exception;
	ResponseEntity<DepartmentDeleteResponse> deleteDepartment(DepartmentDeleteRequest departmentDeleteRequest) throws Exception;
	ResponseEntity<DepartmentDeleteResponse> deleteDepartmentById(DepartmentDeleteRequest departmentDeleteRequest) throws Exception;
}
