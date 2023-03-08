package com.jobs.app.service.serviceImpl;

import com.jobs.app.enums.ApplicationStatus;
import com.jobs.app.model.Applications;
import com.jobs.app.pojos.ApiResponse;
import com.jobs.app.pojos.JobAppDto;
import com.jobs.app.pojos.RequestDto;
import com.jobs.app.repository.AppRepository;
import com.jobs.app.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final AppRepository appRepository;

    @Override
    public ResponseEntity<ApiResponse> saveJobApplication(JobAppDto jobAppDto) {
        Applications jobApp = new Applications();
        BeanUtils.copyProperties(jobAppDto,jobApp);

        Applications savedApp = appRepository.save(jobApp);
         return new ResponseEntity<>(new ApiResponse<>(savedApp),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> findAllByApplicationStatus(RequestDto request) {
        Sort sort = Sort.by(request.getSortBy()).ascending();
        Pageable pageRequest = PageRequest.of(request.getPageNumber(), request.getPageSize(), sort);
        Page<Applications> jobApplications;

        if(request.getFilter().equalsIgnoreCase("completed")){
             jobApplications = appRepository.findAllByApplicationStatusEquals(ApplicationStatus.COMPLETED,pageRequest);
            return ResponseEntity.ok(new ApiResponse<>(jobApplications.getContent()));
        }

        if(request.getFilter().equalsIgnoreCase("pending")){
              jobApplications = appRepository.findAllByApplicationStatusEquals(ApplicationStatus.PENDING, pageRequest);
            return ResponseEntity.ok(new ApiResponse<>(jobApplications.getContent()));
        }

        if(request.getFilter().equalsIgnoreCase("active")){
              jobApplications = appRepository.findAllByApplicationStatusEquals(ApplicationStatus.ACTIVE, pageRequest);
            return ResponseEntity.ok(new ApiResponse<>(jobApplications.getContent()));
        }else{

            return ResponseEntity.ok(new ApiResponse<>(appRepository.findAll()));
        }
    }

    @Override
    public ResponseEntity<String> UpdateApplicationStatus(String jobName, String currentStatus) {
        Applications applications = appRepository.findByName(jobName);
        applications.setApplicationStatus(ApplicationStatus.COMPLETED);
        appRepository.save(applications);
        return new ResponseEntity<>("Job Status Updated to "+ ApplicationStatus.COMPLETED.toString(), HttpStatus.OK);
    }


}
