package com.jobs.app.model;

import com.jobs.app.enums.ApplicationStatus;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@NoArgsConstructor
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Applications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;
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
