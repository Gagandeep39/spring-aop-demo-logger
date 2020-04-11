/**
 * Gagandeep
 * 11:29:36 pm
 * 11-Apr-2020
 */
package com.aop.demo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.config.AppConfig;
import com.aop.dao.AccountDao;
import com.aop.entity.Account;
/**
 * 
 * Spring application to demonstrate AOP conceepts such as Afvice, Pointcit etc
 * Uses Jars
 * Spring 5.0.7
 * AspectJweaver
 *
 */
public class MainLogger {
	
	/**
	 * Used to sync the output with springs logger stream
	 * Using logger instead os system.out
	 */
	static Logger logger = Logger.getLogger(MainClass.class.getName());
	
	public static void main(String[] args) {
		/**
		 * Initializing Annoation based ncfiguration
		 */
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		

		
		/*
		 * DEMO 1
		 * Using PointCut exression
		 */
		AccountDao dao = context.getBean("accountDao", AccountDao.class);
		logger.info("\n\n***********DEMO 1***********");
		dao.addAccount();
		dao.addAccount(new Account());
		
		/**
		 * Method with this expression WOnt be executed for getter and settot methods 
		 * Below line won be printed for set ID
		 * ----------Method with no getter/sette and all other method----------
		 * @Before("pointCutMethodExceptGetterAndSetter()")
		 */
		logger.info("\n\n************DEMO 2***********");
		dao.setId(12);
		
		dao.addAccount();
		
		/**
		 * DEMO 3
		 * Below method returns a string, we will be intercepting the data using @AfterReturning
		 */
		logger.info("\n\n************DEMO 3***********");
		String output = dao.addDebit();
		
		
		/**
		 * DEMO 4
		 * Interceotion an post processing a maethodnamed returnAcount()
		 * ONly below aspect will be executed for the method
		 * @AfterReturning(pointcut = "execution(* com.aop.*.*.return*())", returning = "result")
		 */
		logger.info("\n\n************DEMO 4***********");
		
		Account account = dao.returnAccount();
		logger.info(account.toString());
		
		
		/**
		 * DEMO 5
		 * Executed after an exception is thrown
		 * NOTE: WONT show desired output if thown exception is hanled by @Around before it even reaches @AdterThrowing
		 * Comment try/catch in @Around for this to work
		 */
		logger.info("\n\n************DEMO 5***********");
		try {
			dao.throwsException();
		} catch (Exception e) {
		}
		
		context.close();
	}

}
