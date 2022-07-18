package com.example.reportservice.controller;

import com.example.reportservice.entity.Report;
import com.example.reportservice.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping
    public Optional<Report> findByAdvertisementId(Long advertisementId){
        return reportService.findByAdvertisementId(advertisementId);
    }
}
