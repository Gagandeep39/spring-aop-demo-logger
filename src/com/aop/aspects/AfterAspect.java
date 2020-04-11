/**
 * Gagandeep
 * 10:51:56 pm
 * 11-Apr-2020
 */
package com.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Below methods will run on successful completion or Exception
 * It is executed after @AfterRFeturning or @afterThrowing
 * 
 *
 */
@Component
@Aspect
public class AfterAspect {
	
	@After("within(*)")
	public void afterMethod(JoinPoint point) {
		System.out.println("----------@After Advice (finally)-----------");
		System.out.println("Executing method: " + point.getSignature().toShortString());
	}

}
