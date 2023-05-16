
package com.aspect;

import java.util.Scanner;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeAspect {
//	@Before(value = "execution(* com.service.EmployeeService.*(..))")
//	public void beforeAdvice(JoinPoint joinPoint)
//	{
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter Passcode:");
//		String pwd = input.nextLine();
//		System.out.println("Before method:" + joinPoint.getSignature().getName());  
//	}
	
	@After(value = "execution(* com.service.EmployeeService.*(..))")
	public void afterAdvice(JoinPoint joinPoint)
	{
		System.out.println("After method:" + joinPoint.getSignature().getName());  
	}


}

