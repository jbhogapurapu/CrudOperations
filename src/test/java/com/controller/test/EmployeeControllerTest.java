package com.controller.test;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.controller.EmployeeController;
import com.model.EmployeeModel;
import com.service.EmployeeService;

@SpringBootTest
public class EmployeeControllerTest {

	@InjectMocks
	EmployeeController employeeController;
	
	@Mock
	EmployeeService employeeService;
	
	@Test
	public void insertData()
	{
//		Mockito.when(employeeService.insertData(Mockito.any(EmployeeModel.class))).thenReturn(insertData());
//		return null;
	}
	 @Test
	 public void fetch()
	 {
		 
	 }
	 
	 @Test
	 public void fetchId()
	 {
		 
	 }
	 
	 @Test
	 public void fetchName()
	 {
		 
	 }
	 
	 @Test
	 public void updateData()
	 {
		 
	 }
	 
	 @Test
	 public void deleteId()
	 {
		 
	 }
	 @Test
	 public void deleteName()
	 {
		 
	 }
	 @Test
	 public void delete()
	 {
		 
	 }
}
