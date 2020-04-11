/**
 * Gagandeep
 * 10:34:47 pm
 * 11-Apr-2020
 */
package com.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * These methods are executed adfter an exception is thrown
 * Using within(*) to enable it everywhere
 *
 */
@Aspect
@Component
public class AfterThrowingAspect {
	
	@AfterThrowing("within(*)")
	public void afterhrowing() {
		System.out.println("-------@AfterThrowing advice-------");
	}
	
	/**
	 * Here we will fetch the method name and error message of the throwable
	 * @return void
	 */
	@AfterThrowing(pointcut = "within(*)", throwing = "message")
	public void interceptingException(JoinPoint point, Throwable message) {
		System.out.println("Method throwing excetion: " + point.getSignature().toShortString());
		System.out.println("Exception message: " + message);
	}

}
