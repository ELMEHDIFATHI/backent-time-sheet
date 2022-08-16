package com.example.timesheetbackent.controller;


import com.example.timesheetbackent.model.Employee;
import com.example.timesheetbackent.model.EmployeeDev;
import com.example.timesheetbackent.model.EmployeeManager;
import com.example.timesheetbackent.model.Event;
import com.example.timesheetbackent.repository.EmployeeRepositorie;
import com.example.timesheetbackent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    EmployeeRepositorie employeeRepositorie;

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/findAll")
    public List<Employee> findAll() {
        return employeeRepositorie.findAll();
    }

    @GetMapping("/findAll/Dev")
    public List<Employee> findAllDev() {
        return employeeRepositorie.findAll().stream().filter(t -> t instanceof EmployeeDev).collect(Collectors.toList());
    }


    @GetMapping("/findAll/Manager")
    public List<Employee> findAllManager() {
        return employeeRepositorie.findAll().stream().filter(t -> t instanceof EmployeeManager).collect(Collectors.toList());
    }

    @GetMapping("/findById/Manager/{id}")
    public Employee findManagerById(@PathVariable("id") Long id) {
        Employee employee =employeeRepositorie.findById(id).orElse(null);
        if (!(employee instanceof EmployeeManager) || employee == null){
            return null;
        }
        return employee;
    }

    @GetMapping("/findById/Dev/{id}")
    public Employee findDevById(@PathVariable("id") Long id) {
        Employee employee =employeeRepositorie.findById(id).orElse(null);
        if (!(employee instanceof EmployeeDev) || employee == null){
            return null;
        }
        return employee;
    }



    @GetMapping("/findAllEvent/{id}")
    public List<Event> findAllEventByDev(@PathVariable("id") Long id){
        Employee  employee = employeeRepositorie.findById(id).orElse(null);
        if (employee instanceof EmployeeDev){
            return ((EmployeeDev) employee).getEventList();
        }
        if (employee instanceof EmployeeManager){

            return eventRepository.findAllByEmployeeManagerEvent((EmployeeManager) employee);
        }
        return null;

    }


}
