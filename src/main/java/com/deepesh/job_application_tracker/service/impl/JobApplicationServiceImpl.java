package com.deepesh.job_application_tracker.service.impl;

import com.deepesh.job_application_tracker.model.JobApplication;
import com.deepesh.job_application_tracker.repository.JobApplicationRepository;
import com.deepesh.job_application_tracker.service.JobApplicationService;
import org.springframework.stereotype.Service;
import com.deepesh.job_application_tracker.exception.ResourceNotFoundException;


import java.util.List;

@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationServiceImpl(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    public JobApplication createJobApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    @Override
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    @Override
    public JobApplication getJobApplicationById(Long id) {
        return jobApplicationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Job not found with id: " + id));
    }
    
    @Override
    public JobApplication updateJobApplication(Long id, JobApplication updatedJob) {

        JobApplication existingJob = jobApplicationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Job not found with id: " + id));

        existingJob.setCompanyName(updatedJob.getCompanyName());
        existingJob.setJobRole(updatedJob.getJobRole());
        existingJob.setStatus(updatedJob.getStatus());
        existingJob.setAppliedDate(updatedJob.getAppliedDate());

        return jobApplicationRepository.save(existingJob);
    }
    
    @Override
    public void deleteJobApplication(Long id) {

        JobApplication job = jobApplicationRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Job not found with id: " + id));

        jobApplicationRepository.delete(job);
    }
    
    


}
