package com.example.timesheetbackent.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Project;
    private String name;

    @Column(length = 5000000,columnDefinition = "LONGTEXT")
    private String description;
    private int duration;
    private String status;
    private String client;

    @JsonIgnore
    @ManyToOne
    @ToString.Exclude
    private EmployeeManager managerProject;






    @ToString.Exclude
    @OneToMany(mappedBy = "projectTask",cascade = CascadeType.ALL)
    private List<Task> taskList;



    /*
    @OneToMany(mappedBy = "projectEvent")
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonBackReference
    private List<Event> eventList;

     */




}
