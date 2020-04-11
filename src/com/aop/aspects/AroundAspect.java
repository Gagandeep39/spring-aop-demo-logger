/**
 * Gagandeep
 * 11:04:30 pm
 * 11-Apr-2020
 */
package com.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Methods here will be executed before and after target method edxecution
 * 
 * Order of Execiton
 * 
 * @Before
 * @Around (start) targetmethod
 * @Around (end)
 * @AfterReturning/ @AfterThrowing
 * @After
 *
 */
@Aspect
@Component
public class AroundAspect {

	/**
	 * This method must return the value else it will lead to an exception (NulPointer)
	 * Because we are making a method handle and controlling the method
	 * @return Object
	 */
	@Around("within(*)")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		long begin = System.currentTimeMillis();
		System.out.println("--------@Around advice----------");
		Object result = null;
		try {
			result = joinPoint.proceed();
		} catch (Exception e) {
			System.out.println("-------@Around Advice handed error: " + e);
			// retrwoing execption after logging
			throw e;
		}
		long end = System.currentTimeMillis();
		System.out.println("--------@Around advice----------Duration: " + (end - begin));
		
		return result;
	}
	
	/**
	 * Second Around method created to see error ahdnling
	 * @return Object
	 */
//	@Around("within(*)")
//	public Object aroundMethod2(ProceedingJoinPoint joinPoint) throws Throwable {
//		long begin = System.currentTimeMillis();
//		System.out.println("--------@Around advice2----------");
//		Object result = null;
//		try {
//			result = joinPoint.proceed();
//		} catch (Exception e) {
//			System.out.println("-------@Around Advice handed error: " + e);
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("--------@Around advice2----------Duration: " + (end - begin));
//		
//		return result;
//	}
}
