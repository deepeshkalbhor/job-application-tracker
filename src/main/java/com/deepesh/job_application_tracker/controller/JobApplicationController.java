package com.deepesh.job_application_tracker.controller;

import com.deepesh.job_application_tracker.model.JobApplication;
import com.deepesh.job_application_tracker.service.JobApplicationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import jakarta.validation.Valid;
 

@RestController
@RequestMapping("/api/jobs")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    public JobApplicationController(JobApplicationService jobApplicationService) {
        this.jobApplicationService = jobApplicationService;
    }
    
    @PostMapping
    public JobApplication createJobApplication(
    		@Valid @RequestBody JobApplication jobApplication) {
    	return jobApplicationService.createJobApplication(jobApplication);
    }
    
    @GetMapping
    public List<JobApplication> getAllJobs() {
        return jobApplicationService.getAllJobApplications();
    }

    @GetMapping("/{id}")
    public JobApplication getJobById(@PathVariable Long id) {
        return jobApplicationService.getJobApplicationById(id);
    }
    
    @PutMapping("/{id}")
    public JobApplication updateJob(
            @PathVariable Long id,
            @Valid @RequestBody JobApplication jobApplication) {

        return jobApplicationService.updateJobApplication(id, jobApplication);
    }
    
    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
    	
    	jobApplicationService.deleteJobApplication(id);
    	return "Job deleted successfully";
    }

    		
}
