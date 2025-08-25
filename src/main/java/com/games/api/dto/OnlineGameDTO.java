package com.games.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OnlineGameDTO {
    private Long id;
    private String title;
    private String description;
    private String genre;
    private Integer releaseYear;
    private String platform;
    private String productionStudio;
    private BigDecimal price;
    private Boolean active;
    private String server;
    private Boolean multiplayer;
    private String subscriptionPeriod;
    private Integer maxPlayers;
    private Long consoleId;
    private LocalDateTime createdAt;
}
