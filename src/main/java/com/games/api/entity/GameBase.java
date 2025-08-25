package com.games.api.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class GameBase {

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "genre", nullable = false, length = 100)
    private String genre;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "platform", length = 100)
    private String platform;

    @Column(name = "production_studio", length = 150)
    private String productionStudio;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "active", nullable = false)
    private Boolean active = true;

    @Column(name = "id_console", nullable = false)
    private Long consoleId;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
}

