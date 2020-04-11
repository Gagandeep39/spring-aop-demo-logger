/**
 * Gagandeep
 * 9:51:33 pm
 * 11-Apr-2020
 */
package com.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.aop.entity.Account;

/*
 * Methods are executed after target method returns a value
 * NOTE: We can simply use within(*) instead of multiple patterns if we want to execute something for all
 */
@Aspect
@Component
public class AfterReturningAspect {
	
	/**
	 * Executing a method after a target method has returned some result
	 * @return void
	 */
	@AfterReturning("execution(* com.aop.*.*.add*())")
	public void afterReturn() {
		System.out.println("---------@AfterReturning advice---------");
	}
	
	/**
	 * Inteercepting the return value 
	 * Here the parameter name 'returning' and argument name must be same
	 * @return void
	 */
	@AfterReturning(pointcut = "execution(* com.aop.*.*.add*())", returning = "result")
		public void fetchReturnValue(JoinPoint point, String result) {
			System.out.println("Returning from method: " + point.getSignature().toShortString());
			System.out.println("Returned Value: " + result);
			
			// Modifying(Postprocesing data and changing return value)
		}
	
	
	/**
	 * Postprocessing and modifyiing the values
	 * 
	 */
	@AfterReturning(pointcut = "execution(* com.aop.*.*.return*())", returning = "result")
	public void fetchReturnValue(JoinPoint point, Account result) {
		System.out.println("Returning from method: " + point.getSignature().toShortString());
		System.out.println("Returned Value: " + result);
		
		// Modifying(Postprocesing data and changing return value)
		result.setLevel("MOdified value");;
		result.setName("MOdified 2");;
	}

}
