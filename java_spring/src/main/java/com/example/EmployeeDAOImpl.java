package com.example;

import org.springframework.stereotype.Repository;

/**
 * Created by xjliu on 2016-05-22.
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO
{
    public EmployeeDTO createNewEmployee()
    {
        EmployeeDTO e = new EmployeeDTO();
        e.setId(1);
        e.setFirstName("Lokesh");
        e.setLastName("Gupta");
        return e;
    }
}