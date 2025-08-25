package com.games.api.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "physical_games")
public class PhysicalGame extends GameBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_physical_game")
    private Long id;

    @Column(name = "media_type", length = 50)
    private String mediaType;

    @Column(name = "condition_status", length = 50)
    private String conditionStatus;

    @Column(name = "manual_language", length = 50)
    private String manualLanguage;

    @Column(name = "has_box")
    private Boolean hasBox;
}
