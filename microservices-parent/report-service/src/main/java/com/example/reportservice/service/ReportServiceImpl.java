package com.example.reportservice.service;

import com.example.reportservice.dto.AdvertisementQueueDto;
import com.example.reportservice.entity.Advertisement;
import com.example.reportservice.entity.Report;
import com.example.reportservice.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService{

    private final ReportRepository reportRepository;

    @Override
    public Optional<Report> findByAdvertisementId(Long advertisementId) {
        return reportRepository.findByAdvertisementId(advertisementId);
    }

    @Override
    @RabbitListener(queues = "${queue.name}")
    public void createReport(@Payload AdvertisementQueueDto advertisementQueueDto) {
        Report report = Report.builder()
                .advertisementId(advertisementQueueDto.getId())
                .message(advertisementQueueDto.getId() + " id numarali ilan " + advertisementQueueDto.getViewCount() + " kere goruntulendi.")
                .build();
        reportRepository.save(report);
    }
}
