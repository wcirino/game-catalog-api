package com.games.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhysicalGameDTO {
    private Long id;
    private String title;
    private String description;
    private String genre;
    private Integer releaseYear;
    private String platform;
    private String productionStudio;
    private BigDecimal price;
    private Boolean active;
    private String mediaType;
    private String conditionStatus;
    private String manualLanguage;
    private Boolean hasBox;
    private Long consoleId;
    private LocalDateTime createdAt;
}
