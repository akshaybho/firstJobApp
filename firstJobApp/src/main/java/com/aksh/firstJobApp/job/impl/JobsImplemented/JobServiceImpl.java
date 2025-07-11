package com.aksh.firstJobApp.job.impl.JobsImplemented;

import com.aksh.firstJobApp.job.impl.entities.Job;
import com.aksh.firstJobApp.job.impl.repositories.JobRepository;
import com.aksh.firstJobApp.job.impl.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    //private List<Job> jobs = new ArrayList<>();
    @Autowired
    private JobRepository jobRepo;
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobRepo.findAll();
    }


    @Override
    public void createJob(Job job) {

        jobRepo.save(job);
    }

    @Override
    public Job getJobById(Long id) {

        return jobRepo.findById(id)
                .orElse(null);
    }

    @Override
    public boolean deleteById(Long id) {

        try {
            jobRepo.deleteById(id);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {

        Optional<Job> jobOptional = jobRepo.findById(id);

            if(jobOptional.isPresent())
            {
                Job job = jobOptional.get();
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setLocation(updatedJob.getLocation());
                jobRepo.save(job);
                return true;
            }

        return false;
    }


}
