package com.jobs.app.pojos;

import com.jobs.app.enums.ApplicationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class JobAppDto {
    private String name;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus applicationStatus;
    private String companywebsite;
    private String websiteofapplication;
    private String websiteOfAdvert;
    @CreationTimestamp
    private LocalDateTime appliedOn;
    @UpdateTimestamp
    private LocalDateTime updated;

}
