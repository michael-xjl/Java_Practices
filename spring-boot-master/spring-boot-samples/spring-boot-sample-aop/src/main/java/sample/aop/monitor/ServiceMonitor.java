/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.aop.monitor;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceMonitor {

	//Way1
	   /** Following is the definition for a pointcut to select
	    *  all the methods available. So advice will be called
	    *  for all the methods.
	    */
	@Pointcut("execution(* sample.aop.service.*.*(..))")
	 private void selectAll(){}
	
	  /** 
	    * This is the method which I would like to execute
	    * before a selected method execution.
	    */
	   @Before("selectAll()")
	   public void beforeAdvice(){
	      System.out.println("Going to setup student profile.");
	   }
	   

	   
	   /** 
	    * This is the method which I would like to execute
	    * when any method returns.
	    */
	   @AfterReturning(pointcut = "selectAll()", returning="retVal")
	   public void afterReturningAdvice(Object retVal){
	      System.out.println("Returning:" + retVal.toString() );
	   }
	   
	   
	   /** 
	    * This is the method which I would like to execute
	    * after a selected method execution.
	    */
	   @After("selectAll()")
	   public void afterAdvice(){
	      System.out.println("Student profile has been setup.");
	   }
	   
	
	   @Around("selectAll()")
	   public String beforeAdvice(ProceedingJoinPoint jp) throws Throwable{
		   System.out.println("Annotation driven:Around advice");
		   Object[] args=jp.getArgs();
		   if(args.length>0){
		   System.out.print("Arguments passed:");
		    for (int i = 0; i < args.length; i++) {
		     System.out.print("Arg"+(i+1)+":"+args[i]);
		     args[i]=":Annotation driven argument";
		    }
		   }
		   Object result=jp.proceed(args);
		   return result.toString()+" :Result is also modified";
		  }
	
	//Way2
	@AfterReturning("execution(* sample..*Service.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		System.out.println("Completed: " + joinPoint);
	}

}
