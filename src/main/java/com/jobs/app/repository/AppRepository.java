package com.jobs.app.repository;

import com.jobs.app.enums.ApplicationStatus;
import com.jobs.app.model.Applications;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AppRepository extends JpaRepository<Applications,Long> {
    Page<Applications> findAllByApplicationStatusEquals(ApplicationStatus applicationStatus, Pageable pageRequest);
    List<Applications> findAll();
    Applications findByName(String jobName);

}
