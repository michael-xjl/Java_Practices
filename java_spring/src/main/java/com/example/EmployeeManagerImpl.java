package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xjliu on 2016-05-22.
 */
@Service
public class EmployeeManagerImpl implements EmployeeManager
{
    @Autowired
    EmployeeDAO dao;

    public EmployeeDTO createNewEmployee()
    {
        return dao.createNewEmployee();
    }
}
