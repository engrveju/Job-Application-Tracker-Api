package com.jobs.app.controller;

import com.jobs.app.model.Applications;
import com.jobs.app.pojos.ApiResponse;
import com.jobs.app.pojos.JobAppDto;
import com.jobs.app.pojos.RequestDto;
import com.jobs.app.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @PostMapping("/saveApplication")
    public ResponseEntity<ApiResponse> aveApplications(@RequestBody JobAppDto jobAppDto){
        return jobService.saveJobApplication(jobAppDto);
    }
    @GetMapping("/checkApplication")
    public ResponseEntity<ApiResponse> checkApplications(
            @RequestParam(defaultValue = "appliedOn") String sortBy,
            @RequestParam(defaultValue = "active") String filter,
            @RequestParam(defaultValue = "0") int pageNumber){
        RequestDto requestDto = RequestDto.builder()
                .filter(filter)
                .pageNumber(pageNumber)
                .pageSize(10)
                .sortBy(sortBy)
                .build();
        return jobService.findAllByApplicationStatus(requestDto);
    }





    @PutMapping("/updateApplication")
    public ResponseEntity<String> updateApplications(@RequestParam String jobName,@RequestParam String setCurrentStatus){
        return jobService.UpdateApplicationStatus(jobName,setCurrentStatus);
    }
}
