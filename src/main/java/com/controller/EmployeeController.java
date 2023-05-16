package com.controller;

import java.util.List;
import javax.servlet.http.HttpServlet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.EmployeeModel;
import com.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService empService;
	
	@CrossOrigin()
	@PostMapping("/insertData")
	public EmployeeModel insertData(@RequestBody EmployeeModel employeeModel) {
		return empService.insertData(employeeModel);
	}
	
	@CrossOrigin()
	 @GetMapping("/fetch")
	 public List<Map<String, Object>> fetch()
	 {
		 return empService.fetch();
	 }
	
	@CrossOrigin()
	@GetMapping("/fetchId/{id}")
	public List<Map<String, Object>> fetchId(@PathVariable int id)
	{
		return empService.fetchId(id);
	}
	
	@CrossOrigin()
	@GetMapping("/fetchName/")
	public List<Map<String,Object>> fetchName(@RequestParam String name)
	{
		return empService.fetchName(name);
	}
	
	@CrossOrigin()
	@PutMapping("/update")
	public EmployeeModel updateData(@RequestBody EmployeeModel employeeModel)
	{
		return empService.update(employeeModel);
	}
	@CrossOrigin()
	@DeleteMapping("/deleteId/{id}")
	public EmployeeModel deleteId(@PathVariable int id)
	{
		return empService.deleteId(null, id);
	}
	@CrossOrigin()
	@DeleteMapping("/deleteName/{name}")
	public String deleteName(@PathVariable String name)
	{
		return empService.deleteName(name);
	}
	@CrossOrigin()
	@DeleteMapping("/delete")
	public String delete()
	{
		return empService.delete();
	}
	
	@CrossOrigin()
	@GetMapping("/filter")
	public List filter(@RequestBody EmployeeModel employeeModel)
	{
		return empService.filter(employeeModel);
		
	}

}
