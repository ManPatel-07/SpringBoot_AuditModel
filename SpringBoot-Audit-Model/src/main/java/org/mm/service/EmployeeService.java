package org.mm.service;

import java.util.List;

import org.mm.dao.EmployeeRepository;
import org.mm.dto.EmployeeDto;
import org.mm.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EmployeeDto save(@RequestBody EmployeeDto dto)
	{
		Employee employee = employeeRepository.save(toEmployeeEntity(dto));
		return toEmployeeDto(employee);
	}
	
//	public List<EmployeeDto> findAll()
//	{
//		List<Employee> all = employeeRepository.findAll();
//	}
//	
	public Employee toEmployeeEntity(EmployeeDto dto)
	{
		return modelMapper.map(dto, Employee.class);
	}
	
	public EmployeeDto toEmployeeDto(Employee employee)
	{
		return modelMapper.map(employee, EmployeeDto.class);
	}
}
