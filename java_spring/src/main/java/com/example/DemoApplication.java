package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@ComponentScan(basePackages = "com.example")
//@Configuration
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		HelloWord hw = ctx.getBean(HelloWord.class);
		System.out.println(hw.sayHello())
				;

		EmployeeController ec = (EmployeeController) ctx.getBean("employeeController");
		System.out.println(ec.createNewEmployee());
	}
}
