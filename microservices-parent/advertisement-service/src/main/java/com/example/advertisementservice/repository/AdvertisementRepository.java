package com.example.advertisementservice.repository;


import com.example.advertisementservice.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
    List<Advertisement> findLast10ByIsActiveIsTrue();
    List<Advertisement> findAllByIsActiveIsFalse();
}
