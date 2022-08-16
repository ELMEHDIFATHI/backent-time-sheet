package com.example.timesheetbackent.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Long id_Event;
    @JsonProperty("Subject")
    private String subject;
    @DateTimeFormat(fallbackPatterns = "dd/MM/yyyy HH:mm")
    @JsonFormat(pattern="yyyy,MM,dd,HH,mm")
    @JsonProperty("StartTime")
    private Date startDate;
    @DateTimeFormat(fallbackPatterns = "dd/MM/yyyy HH:mm")
    @JsonFormat(pattern="yyyy,MM,dd,HH,mm")
    @JsonProperty("EndTime")
    private Date endDate;


    @JsonIgnore
    @ManyToOne
    private EmployeeManager employeeManagerEvent;



    @JsonIgnore
    @ManyToMany(mappedBy = "eventList")
    private List<EmployeeDev> employeeDevList;
}
