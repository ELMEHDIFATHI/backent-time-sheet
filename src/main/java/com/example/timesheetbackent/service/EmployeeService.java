package com.example.timesheetbackent.service;


import com.example.timesheetbackent.model.Employee;
import com.example.timesheetbackent.model.EmployeeDev;
import com.example.timesheetbackent.model.EmployeeManager;
import com.example.timesheetbackent.repository.EmployeeRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepositorie employeeRepositorie;

    public Employee finEmployeeMangerById(Long id){
        Employee employee = employeeRepositorie.findById(id).orElse(null);
        if(!(employee instanceof  EmployeeManager) || (employee == null)){
            return null;
        }
        return employee;
    }

    public EmployeeDev findEmployeeDevById(Long id){
        Employee employee = employeeRepositorie.findById(id).orElse(null);
        if(!(employee instanceof EmployeeDev) || (employee == null)){
            return null;
        }
        return (EmployeeDev) employee;
    }
}
