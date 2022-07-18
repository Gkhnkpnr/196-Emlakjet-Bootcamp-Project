package com.example.reportservice.repository;

import com.example.reportservice.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReportRepository extends JpaRepository<Report,Long> {
    Optional<Report> findByAdvertisementId(Long advertisementId);
}
