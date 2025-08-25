package com.games.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DigitalGameDTO {
    private Long id;
    private String title;
    private String description;
    private String genre;
    private Integer releaseYear;
    private String platform;
    private String productionStudio;
    private BigDecimal price;
    private Boolean active;
    private String activationKey;
    private String digitalStore;
    private BigDecimal downloadSize;
    private LocalDate licenseExpiration;
    private Long consoleId;
    private LocalDateTime createdAt;
}

