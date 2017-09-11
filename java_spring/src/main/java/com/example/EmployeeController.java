package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by xjliu on 2016-05-22.
 */
@Controller
public class EmployeeController
{
    @Autowired
    EmployeeManager manager;

    public EmployeeDTO createNewEmployee()
    {
        return manager.createNewEmployee();
    }
}