package com.example.timesheetbackent.service;


import com.example.timesheetbackent.model.Employee;
import com.example.timesheetbackent.model.EmployeeManager;
import com.example.timesheetbackent.model.Event;
import com.example.timesheetbackent.repository.EmployeeRepositorie;
import com.example.timesheetbackent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EventService {


    @Autowired
    EventRepository eventRepository;
    @Autowired
    EmployeeRepositorie  employeeRepositorie;

    public Event addEvent(Long id,Event event){

        Employee employee = employeeRepositorie.findById(id).orElse(null);
        if(!(employee instanceof EmployeeManager) || (employee == null)){
            return null;
        }
        event.setEmployeeManagerEvent((EmployeeManager) employee);
        return eventRepository.save(event);
    }


}
