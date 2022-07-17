package com.example.advertisementservice.service;

import com.example.advertisementservice.dto.AdvertisementRequest;
import com.example.advertisementservice.dto.AdvertisementUpdateRequest;
import com.example.advertisementservice.entity.Advertisement;
import com.example.advertisementservice.repository.AdvertisementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdvertisementServiceImpl implements AdvertisementService{

    private final AdvertisementRepository advertisementRepository;


    @Override
    public Optional<Advertisement> findById(Long advertisementId) {
        return advertisementRepository.findById(advertisementId);
    }

    @Override
    public void createAdvertisement(AdvertisementRequest advertisementRequest) {

    }

    @Override
    public void updateAdvertisement(AdvertisementUpdateRequest advertisementUpdateRequest) {

    }

    @Override
    public void approveAdvertisement(Long advertisementId) {

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
