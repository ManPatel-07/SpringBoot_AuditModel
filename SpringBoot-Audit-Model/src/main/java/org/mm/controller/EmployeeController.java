package org.mm.controller;

import org.mm.dto.EmployeeDto;
import org.mm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "")
	public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employeeDto)
	{
		EmployeeDto DtoSave = employeeService.save(employeeDto);
		return new ResponseEntity<EmployeeDto>(DtoSave,HttpStatus.OK);
	}
}
