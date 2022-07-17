package com.example.advertisementservice.repository;


import com.example.advertisementservice.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}
