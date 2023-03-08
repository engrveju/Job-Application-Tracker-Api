package com.jobs.app.pojos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDto {
    private int pageNumber;
    private int pageSize;
    private String filter;
    private String sortBy;
}
