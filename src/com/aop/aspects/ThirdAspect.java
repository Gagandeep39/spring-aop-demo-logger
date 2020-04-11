/**
 * Gagandeep
 * 7:30:32 pm
 * 11-Apr-2020
 */
package com.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(3)	//will be exwcuted third
@Aspect
@Component
public class ThirdAspect {
	/**
	 * Creating multiple @Before
	 */
	@Before("execution(* com.aop.dao.*.get*(..))")
	public void performAnalytics() {
		System.out.println("----------Executing second @Before method----------");
	}
}
