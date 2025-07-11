package com.aksh.firstJobApp.job.impl.entities;

import com.aksh.firstJobApp.company.entities.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="job_table")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String minSalary;
    @Column
    private String maxSalary;
    @Column
    private String location;

    @ManyToOne
    private Company company;

}
