/**
 * Gagandeep
 * 1:14:53 pm
 * 11-Apr-2020
 */
package com.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * |
 * Exwecuted before executing the target method
 * @Order() -> The order in which the Aspect is to be executed (lwer value higher priority)
 * @Aspect -> Specifies that it has AOP related code
 * @Before -> Execution before the targe method
 *
 */
@Order(1)	// Will be executed first
@Aspect
@Component
public class DemoLoggingAspect {
	
	/**
	 * Creating a pontcut epression for reusability
	 * We will create a method with this expression 
	 * We ill specity this metod in @Before 
	 */
	@Pointcut("execution(* com.aop.dao.*.*(..))")
	public void anyMethodExpression() {}
	

	@Before("anyMethodExpression()")
	public void beforeMehotd() {
		System.out.println("----------@Before advice----------");
	}
	
	
	
	
	
	
}

