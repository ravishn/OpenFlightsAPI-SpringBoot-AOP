package com.foxtel.spring.demo.aspects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.foxtel.spring.demo.controller.interfaces.EnableAccessControl;

@Aspect
@Component
@Configuration
public class FlightControllerAspect {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());
	
	@Before("execution(@com.foxtel.spring.demo.controller.interfaces.EnableAccessControl * *(..)) &&"
			+ " @annotation(accessControlAnnotation)")
	public void beforeAPICall(JoinPoint joinPoint, EnableAccessControl accessControlAnnotation) throws Exception {

		if (accessControlAnnotation.value().equals("dwarf") 
				|| accessControlAnnotation.value().equals("hobbit") 
				|| accessControlAnnotation.value().equals("wizard")) {
			
			logger.info("<<<<<<<<<<<<<<<<<<<<<< BEFORE API call {} " + joinPoint);
		} else {
			
			logger.error(" !!!!!!!! <<YOU SHALL NOT PASS>> !!!!!!!! ");
			throw new Exception();
		}
	}

	@AfterReturning("execution(* com.foxtel.spring.demo.controller.FlightController.*(..))")
	public void afterAPICall(JoinPoint joinPoint) {

		logger.info("AFTER API call {} >>>>>>>>>>>>>>>>>>>>>> " + joinPoint);
	}

}
