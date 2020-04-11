/**
 * Gagandeep
 * 8:16:45 pm
 * 11-Apr-2020
 */
package com.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aop.entity.Account;

@Aspect
@Component
@Order(4)
public class MethodLogsAspect {
	
	/**
	 * Logs for method signature 
	 * @return void
	 */
	@Before("within(*)")
	public void displayMethodSignature(JoinPoint point) {
		Signature signature = point.getSignature();
		System.out.println("Method Signature: " + signature);
	}
	
	/**
	 * Logs for method Parameters
	 * @return void
	 */
	@Before("within(*)")
	public void displayMethodArguments(JoinPoint point) {
		 Object args[] = point.getArgs();
		 for (Object object : args) {
			System.out.println("Argument: " + object);
			
			// Can fetch values also 
//			if(object instanceof Account) {
//				Account account = (Account)object;
//				System.out.println(account.getLevel());
//			}
		}
		
	}
}
