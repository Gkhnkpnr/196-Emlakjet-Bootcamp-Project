package com.example.advertisementservice.service;

import com.example.advertisementservice.dto.AdvertisementRequest;
import com.example.advertisementservice.dto.AdvertisementUpdateRequest;
import com.example.advertisementservice.entity.Advertisement;

import java.util.List;
import java.util.Optional;

public interface AdvertisementService {
    Optional<Advertisement> findById(Long advertisementId);
    void createAdvertisement(AdvertisementRequest advertisementRequest);
    void updateAdvertisement(AdvertisementUpdateRequest advertisementUpdateRequest, Long id);
    void approveAdvertisement(Long advertisementId);
    void rejectAdvertisement(Long advertisementId);
    List<Advertisement> findLast10ByIsActiveIsTrue();
    List<Advertisement> findAllByIsActiveIsFalse();
}
