package com.example.timesheetbackent.repository;

import com.example.timesheetbackent.model.Employee;
import com.example.timesheetbackent.model.EmployeeManager;
import com.example.timesheetbackent.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

    List<Project> findByManagerProject(Employee manager);
}
