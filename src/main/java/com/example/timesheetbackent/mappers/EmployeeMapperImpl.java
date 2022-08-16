package com.example.timesheetbackent.mappers;


import com.example.timesheetbackent.dtos.User;
import com.example.timesheetbackent.model.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapperImpl {

    public User fromUser(Employee employee) {
        User user = new User();
        BeanUtils.copyProperties(employee,user);
        return user;
    }
}
