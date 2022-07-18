package com.example.reportservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AdvertisementQueueDto implements Serializable {
    private Long id;
    private String title;
    private String description;
    private Integer viewCount;
    private Boolean isActive;
}
