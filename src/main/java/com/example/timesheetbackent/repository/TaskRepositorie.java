package com.example.timesheetbackent.repository;

import com.example.timesheetbackent.model.EmployeeDev;
import com.example.timesheetbackent.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepositorie extends JpaRepository<Task,Long> {

    List<Task> findByEmployeeTask(EmployeeDev employeeTask);
}
