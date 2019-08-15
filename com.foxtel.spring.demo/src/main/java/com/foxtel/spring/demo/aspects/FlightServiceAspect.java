package com.foxtel.spring.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Configuration
@Component
public class FlightServiceAspect {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	/**
	 * JoinPoint example with @Before
	 * 
	 * @param joinPoint
	 */
	@Before("execution(* com.foxtel.spring.demo.service.FlightService.*(..))")
	public void beforeRequest(JoinPoint joinPoint) {

		logger.info("<<<<<<<<<<<<<<<<<<<<<< Before Service method {} ", joinPoint);
	}

	/**
	 * JoinPoint example with @After
	 * 
	 * @param joinPoint
	 */
	@AfterReturning(value = "execution(* com.foxtel.spring.demo.service.FlightService.*(..))")
	public void afterResponse(JoinPoint joinPoint) {

		logger.info("After Service method >>>>>>>>>>>>>>>>>>>>>> {} ", joinPoint);
	}


//------------------------------------------------------------------------------------------//

	
	/**
	 * Pointcut example
	 */
	@Pointcut("execution(* com.foxtel.spring.demo.service.FlightService.*(..))")
	private void selectAll() {
		
	}
	
	@Before("selectAll()")
	public void beforeAdviceMethod(JoinPoint joinPoint) {
		
		logger.info("<<<<<<<<<<<<<<<<<<<<<< POINTCUT Before Service method {} " +joinPoint);
	}
	
	@After("selectAll()")
	public void afterAdviceMethod(JoinPoint joinPoint) {
		
		logger.info("POINTCUT After Service method >>>>>>>>>>>>>>>>>>>>>> {} ", joinPoint);
	}

}
