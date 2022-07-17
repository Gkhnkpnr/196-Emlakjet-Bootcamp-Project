package com.example.advertisementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Builder.Default
    private Integer viewCount=0;
    @Builder.Default
    private Boolean isActive=false;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
