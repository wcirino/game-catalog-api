package com.games.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsoleDTO {
    private Long id;
    private String name;
    private String manufacturer;
    private Integer releaseYear;
    private LocalDateTime createdAt;
    private Boolean active;
}
