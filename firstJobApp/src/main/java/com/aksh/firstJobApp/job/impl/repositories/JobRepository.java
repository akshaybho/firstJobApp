package com.aksh.firstJobApp.job.impl.repositories;

import com.aksh.firstJobApp.job.impl.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}
