package com.aksh.firstJobApp.job.impl.services;

import com.aksh.firstJobApp.job.impl.entities.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();

    void createJob(Job job);

    Job getJobById(Long id);

    boolean deleteById(Long id);

    boolean updateJob(Long id, Job updatedJob);
}
