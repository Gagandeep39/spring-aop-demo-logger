/**
 * Gagandeep
 * 7:29:30 pm
 * 11-Apr-2020
 */
package com.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)	// Will be executed second 
@Aspect
@Component
public class GetterSetterLoggingAspect {
	
	@Pointcut("execution(* com.aop.dao.*.*(..))")
	public void anyMethodExpression() {}
	
	/****
	 * TO Execute only on non getter and setter methods o any class inside dao package
	 * 1. Create getter and setter Expression
	 * 2. Add them in not section in join expression
	 */
	
	/**
	 * Getter
	 * @return void
	 */
	@Pointcut("execution(* com.aop.dao.*.get*(..))")
	public void getterExpression() {}
	
	/**
	 * Setter
	 * @return void
	 */
	@Pointcut("execution(* com.aop.dao.*.set*(..))")
	public void setterExpression() {}
	
	/**
	 * Below ex[ression ensure advice is executed i all method except getter and setter
	 */
	@Pointcut("anyMethodExpression() && !(setterExpression() || getterExpression())")
	public void pointCutMethodExceptGetterAndSetter() {}
	
	
	/**
	 * Using the point cut expression that will be executed for all except getter and setter 
	 * @return void
	 */
	@Before("pointCutMethodExceptGetterAndSetter()")
	public void methodForNoGetterSetter() {
		System.out.println("----------Advice that run for everthing except getter/setting----------");
	}

}
