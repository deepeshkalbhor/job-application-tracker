package com.deepesh.job_application_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.deepesh.job_application_tracker.model")
@EnableJpaRepositories("com.deepesh.job_application_tracker.repository")
public class JobApplicationTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobApplicationTrackerApplication.class, args);
    }
}
