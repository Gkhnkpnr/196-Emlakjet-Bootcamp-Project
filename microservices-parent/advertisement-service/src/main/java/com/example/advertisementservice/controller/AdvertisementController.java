package com.example.advertisementservice.controller;

import com.example.advertisementservice.dto.AdvertisementRequest;
import com.example.advertisementservice.dto.AdvertisementUpdateRequest;
import com.example.advertisementservice.entity.Advertisement;
import com.example.advertisementservice.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisement")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    @GetMapping("/{id}")
    public Advertisement getById(@PathVariable("id") Long id){
        return advertisementService.findById(id).get();
    }

    @PostMapping
    public void createAdvertisement(@RequestBody AdvertisementRequest advertisementRequest){
        advertisementService.createAdvertisement(advertisementRequest);
    }

    @PutMapping("/{id}")
    public void updateAdvertisement(@PathVariable("id") Long id, @RequestBody AdvertisementUpdateRequest advertisementUpdateRequest){
        advertisementService.updateAdvertisement(advertisementUpdateRequest,id);
    }

    @PatchMapping("/approve/{id}")
    public void approveAdvertisement(@PathVariable("id") Long id){
        advertisementService.approveAdvertisement(id);
    }

    @PatchMapping("/reject/{id}")
    public void rejectAdvertisement(@PathVariable("id") Long id){
        advertisementService.rejectAdvertisement(id);
    }

    @GetMapping("/actives")
    public List<Advertisement> findLast10ByIsActiveIsTrue(){
        return advertisementService.findLast10ByIsActiveIsTrue();
    }

    @GetMapping("/rejects")
    public List<Advertisement> findAllByIsActiveIsFalse(){
        return advertisementService.findAllByIsActiveIsFalse();
    }
}
