package com.example;

/**
 * Created by xjliu on 2016-05-22.
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpringContext
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //EmployeeManager manager = (EmployeeManager) context.getBean(EmployeeManager.class);

        //OR this will also work

        EmployeeController controller = (EmployeeController) context.getBean("employeeController");

        System.out.println(controller.createNewEmployee());
    }
}