package com.example.advertisementservice.service;

import com.example.advertisementservice.dto.AdvertisementQueueDto;
import com.example.advertisementservice.dto.AdvertisementRequest;
import com.example.advertisementservice.dto.AdvertisementUpdateRequest;
import com.example.advertisementservice.entity.Advertisement;
import com.example.advertisementservice.repository.AdvertisementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdvertisementServiceImpl implements AdvertisementService{

    private final AdvertisementRepository advertisementRepository;
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;


    @Override
    public Optional<Advertisement> findById(Long advertisementId) {
        return advertisementRepository.findById(advertisementId);
    }

    @Override
    public void createAdvertisement(AdvertisementRequest advertisementRequest) {
        Advertisement advertisement = Advertisement.builder()
                .title(advertisementRequest.getTitle())
                .description(advertisementRequest.getDescription())
                .createdAt(Instant.now())
                .isActive(false)
                .build();
        advertisementRepository.save(advertisement);
    }

    @Override
    public void updateAdvertisement(AdvertisementUpdateRequest advertisementUpdateRequest,Long id) {
        Advertisement advertisement = advertisementRepository.findById(id).get();
        advertisement.setUpdatedAt(Instant.now());
        advertisement.setTitle(advertisementUpdateRequest.getTitle());
        advertisement.setDescription(advertisementUpdateRequest.getDescription());
        advertisement.setViewCount(advertisement.getViewCount()+1);
        advertisement.setIsActive(advertisementUpdateRequest.getIsActive());
        advertisementRepository.save(advertisement);
    }

    @Override
    public void approveAdvertisement(Long advertisementId) {
        Advertisement advertisement = advertisementRepository.findById(advertisementId).get();
        advertisement.setIsActive(true);
        advertisementRepository.save(advertisement);
        AdvertisementQueueDto message = AdvertisementQueueDto.builder()
                .id(advertisement.getId())
                .description(advertisement.getDescription())
                .isActive(advertisement.getIsActive())
                .viewCount(advertisement.getViewCount())
                .title(advertisement.getTitle())
                .build();
        rabbitTemplate.convertAndSend(queue.getName(),message);
    }

    @Override
    public void rejectAdvertisement(Long advertisementId) {
        Advertisement advertisement = advertisementRepository.findById(advertisementId).get();
        advertisement.setIsActive(false);
        advertisementRepository.save(advertisement);
    }

    @Override
    public List<Advertisement> findLast10ByIsActiveIsTrue() {
        return advertisementRepository.findLast10ByIsActiveIsTrue();
    }

    @Override
    public List<Advertisement> findAllByIsActiveIsFalse() {
        return advertisementRepository.findAllByIsActiveIsFalse();
    }
}
