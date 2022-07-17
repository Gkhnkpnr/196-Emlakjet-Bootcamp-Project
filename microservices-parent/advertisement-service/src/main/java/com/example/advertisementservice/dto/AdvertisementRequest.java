package com.example.advertisementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementRequest {
    private String title;
    private String description;
    private Integer viewCount;
    private Boolean isActive;
    private LocalDateTime createdAt;
}
