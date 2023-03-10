package com.jobs.app.service;

import com.jobs.app.pojos.ApiResponse;
import com.jobs.app.pojos.JobAppDto;
import com.jobs.app.pojos.RequestDto;
import org.springframework.http.ResponseEntity;

public interface JobService {
    ResponseEntity<ApiResponse> saveJobApplication(JobAppDto jobAppDto);
    ResponseEntity<ApiResponse> findAllByApplicationStatus(RequestDto request);

    ResponseEntity<String> UpdateApplicationStatus(String jobName,String setCurrentStatus);

}
