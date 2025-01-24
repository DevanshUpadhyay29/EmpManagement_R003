package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.exceptions.EmployeeNotFound;
import com.example.demo.service.EmployeeService;

@RestController     //@Controller + @ResponseBody
@RequestMapping("/employees") //http://localhost:8080/employees
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("/save")   //http://localhost:8080/employees/save
	public String saveEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deleteEmployee(@PathVariable("id") int employeeId) {
		return service.deleteEmployee(employeeId);
	}
	@GetMapping("/getById/{id}")
	public Employee getEmployee(@PathVariable("id") int employeeId) throws EmployeeNotFound{
		return service.getEmployee(employeeId);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAllEmployee(){
		return service.getAllEmployee();
	}
	
	@GetMapping("/getAllBetween/{sal1}/{sal2}")
	public List<Employee> getAllEmployeesBetween(@PathVariable("sal1") int initialSal, @PathVariable("sal2") int finalSal){
		return service.getAllBetweenSalaries(initialSal, finalSal);
	}
	
	@GetMapping("/getAllByDesg/{desg}")
	public List<Employee> getAllByDesg(@PathVariable("desg") String empDesg){
		return service.getAllByDesg(empDesg);
	}
}
