package com.aksh.firstJobApp.job.impl.controllers;

import com.aksh.firstJobApp.job.impl.entities.Job;
import com.aksh.firstJobApp.job.impl.services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class JobController {

    private JobService jobService;

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll()
    {
       return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping("/jobs")
    public ResponseEntity<Job> createJob(@RequestBody Job job)
    {
        jobService.createJob(job);
        return new ResponseEntity<>(job, HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id)
    {

        Job  job = jobService.getJobById(id);
        if(job!=null)
        {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(job, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id)
    {
        boolean deleted = jobService.deleteById(id);
        if(deleted)
        {
            return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id,
                                                @RequestBody Job updatedJob)
    {
        boolean updated = jobService.updateJob(id, updatedJob);

        if(updated)
        {
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
