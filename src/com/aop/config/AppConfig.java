/**
 * Gagandeep
 * 1:05:14 pm
 * 11-Apr-2020
 */
package com.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 
 * @Configuration Indicates the class consits of @Beans 
 * @EnableAspectJAutoProxy Enables use of AspectJ
 * @ComponentScan("com.packake.name") look for components in specified package and subpackage
 *
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.aop")
public class AppConfig {

}
