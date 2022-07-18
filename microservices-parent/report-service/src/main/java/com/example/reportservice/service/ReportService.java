package com.example.reportservice.service;

import com.example.reportservice.dto.AdvertisementQueueDto;
import com.example.reportservice.entity.Report;

import java.util.Optional;

public interface ReportService {
    Optional<Report> findByAdvertisementId(Long advertisementId);
    void createReport(AdvertisementQueueDto advertisementQueueDto);
}
