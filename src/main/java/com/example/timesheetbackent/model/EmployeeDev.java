package com.example.timesheetbackent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "Developer")
public class EmployeeDev extends Employee implements Serializable {


    @JsonIgnore
    @OneToMany(mappedBy = "employeeTask")
    private List<Task> taskList;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable( name = "Employee_Event",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_Event")
    )
    private List<Event> eventList;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private Collection<Time> timeList = new ArrayList<>();

}
